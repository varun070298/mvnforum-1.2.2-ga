/*
 * $Header: /cvsroot/mvnforum/mvnforum/src/com/mvnforum/admin/importexport/jive/JiveThreadXML.java,v 1.9 2007/01/15 10:27:36 dungbtm Exp $
 * $Author: dungbtm $
 * $Revision: 1.9 $
 * $Date: 2007/01/15 10:27:36 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2007 by MyVietnam.net
 *
 * All copyright notices regarding mvnForum MUST remain 
 * intact in the scripts and in the outputted HTML.
 * The "powered by" text/logo with a link back to
 * http://www.mvnForum.com and http://www.MyVietnam.net in 
 * the footer of the pages MUST remain visible when the pages
 * are viewed on the internet or intranet.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * Support can be obtained from support forums at:
 * http://www.mvnForum.com/mvnforum/index
 *
 * Correspondence and Marketing Questions can be sent to:
 * info at MyVietnam net
 *
 * @author: Igor Manic   
 */
package com.mvnforum.admin.importexport.jive;

import java.sql.Timestamp;
import java.util.Vector;

import com.mvnforum.admin.PostXML;
import com.mvnforum.admin.ThreadXML;
import net.myvietnam.mvncore.exception.*;

/**
 * @author Igor Manic
 * @version $Revision: 1.9 $, $Date: 2007/01/15 10:27:36 $
 * <br/>
 * <code>JiveThreadXML</code> class encapsulates processing of
 * threads' definitions found in the Jive XML file. It implements
 * methods to be called from XML parsing routine, adds some additional
 * processing and checking, and calls corresponding methods of
 * <code>ThreadXML</code> and other neccessary classes in order to perform
 * the actual creation of a thread, as well as thread watches.
 */
public class JiveThreadXML {

    private ThreadXML threadXML=null;
    private boolean threadCreated=false;
    private Vector threadWatchesToAddLater=new Vector();
    private JiveForumXML parentForum =null;

    public JiveThreadXML() {
        super();
        threadXML=new ThreadXML();
        threadCreated=false;
        parentForum=null;
    }

    public void setThreadID(String id) {
        threadXML.setThreadID(id);
    }

    /**
     * This method simply calls <code>setThreadID()</code>.
     * It's defined only to avoid property-setter problems with digester
     * (since it doesn't seem to recognize <code>setThreadID()</code> as a setter
     * method for <code>threadID</code> property).
     */
    public void setThreadId(String id) {
        setThreadID(id);
    }

    public int getThreadID() { return threadXML.getThreadID(); }

    public int getParentCategoryID() {
        return threadXML.getParentCategoryID();
    }

    public int getParentForumID() {
        return threadXML.getParentForumID();
    }

    public void setParentForum(Object o)
    throws ForeignKeyNotFoundException {
        if (o instanceof JiveForumXML) {
            parentForum=(JiveForumXML)o;
            //warning: parent forum might not be added to database yet
        } else {
            throw new ForeignKeyNotFoundException("Can't find parent forum.");
        }
    }

    private String threadTopic=null;
    public void setTopic(String value) throws CreateException {
        if ( (value==null) || (value.equals("")) ) {
            throw new CreateException("Cannot create a thread with an empty ThreadTopic.");
        } else this.threadTopic=value;
    }

    private String threadBody=null;
    public void setBody(String value) throws CreateException {
        if ( (value==null) || (value.equals("")) ) {
            throw new CreateException("Cannot create a thread with an empty ThreadBody.");
        } else this.threadBody=value;
    }

    private String threadUsername=null;
    public void setUsername(String value) throws CreateException {
        this.threadUsername=value;
    }

    private String threadCreationDate=null;
    public void setCreationDate(String value) throws CreateException {
        this.threadCreationDate=value;
    }

    private String threadModifiedDate=null;
    public void setModifiedDate(String value) throws CreateException {
        this.threadModifiedDate=value;
    }

    public void addJiveThread() throws BadInputException, CreateException,
    DatabaseException, ObjectNotFoundException, DuplicateKeyException, ForeignKeyNotFoundException {
        /* This method is here because of the digester rule it could fire it, but
         * actually, this shouldn't happen, because the first <Message> of the thread
         * will call addJiveThread(firstMessageUsername, firstMessageSubject, firstMessageBody)
         * so this method will be called only after threadCreated is already
         * set to true (because of that previous executions of the other addJiveThread method).
         */
        if (!threadCreated) addJiveThread(threadUsername, threadTopic, threadBody);
    }

    public void addJiveThread(String firstMessageUsername, String firstMessageSubject, String firstMessageBody)
    throws BadInputException, CreateException,
    DatabaseException, ObjectNotFoundException, DuplicateKeyException, ForeignKeyNotFoundException {
        /* First check if the digester already called this method.
         * It will happen even under normal circumstances, if this thread has
         * subelements that need it already be defined, so they first call
         * this method to create thread before creating data that refer him.
         */
        if (threadCreated) return;
        setUsername(firstMessageUsername);
        setTopic(firstMessageSubject);
        setBody(firstMessageBody);
        /* Second, create parent forum if it's not yet created. */
        if (parentForum!=null) {
            parentForum.addJiveForum();
            threadXML.setParentForumID(parentForum.getForumID());
            threadXML.setParentCategoryID(parentForum.getParentCategoryID());
        }

        ImportJive.addMessage("Adding Jive thread \""+threadTopic+"\".");
        threadXML.addThread(threadUsername, threadUsername/*lastPostMemberName*/,
                            threadTopic, threadBody,
                            null/*threadVoteCount*/, null/*threadVoteTotalStars*/,
                            threadCreationDate, threadModifiedDate/*threadLastPostDate*/,
                            null/*threadType*/, null/*threadPriority*/, null/*threadOption*/,
                            null/*threadStatus*/, null/*threadHasPoll*/,
                            null/*threadViewCount*/, null/*threadReplyCount*/,
                            null/*threadIcon*/, null/*threadDuration*/, null/*threadAttachCount*/ );
        threadCreated=true;

        for (int i=0; i<threadWatchesToAddLater.size(); i++) {
            String memberName= (String)threadWatchesToAddLater.elementAt(i);
            ImportJive.addMessage("Adding thread watch for member \""+memberName+"\".");
            threadXML.addThreadWatch(memberName,
                      null/*watchType*/, null/*watchOption*/,
                      null/*watchStatus*/, null/*watchCreationDate*/,
                      null/*watchLastSentDate*/, null/*watchEndDate*/);
        }
        threadWatchesToAddLater.clear();

        if (parentForum!=null) {
            parentForum.updateAddedThread(threadXML); //update parents
        }
    }

    public void addJiveThreadWatch(String type, String expirable, String username)
    throws CreateException {
        /* expirable and type are ignored
         * expirable is "true" or "false", default is "true"
         * type is "NORMAL_WATCH" or "EMAIL_NOTIFY_WATCH"
         * MVN Forum supports only email notify watches
         */
        threadWatchesToAddLater.add(username);
    }

    public void updateAddedPost(PostXML postXML, String postUsername, Timestamp postCreationDate)
    throws ObjectNotFoundException, DatabaseException, ForeignKeyNotFoundException {
        if (postXML.getParentPostID()!=0) {//reply to a post in thread, so we increase the ThreadReplyCount
            threadXML.increaseReplyCount();
        }
        threadXML.updateLastPostMemberName(postUsername);
        threadXML.updateLastPostDate(postCreationDate);
        if (parentForum!=null) {
            //update parents
            parentForum.updateAddedPost(postXML, postUsername, postCreationDate);
        }
    }


}


