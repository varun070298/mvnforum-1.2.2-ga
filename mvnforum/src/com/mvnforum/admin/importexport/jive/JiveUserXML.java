/*
 * $Header: /cvsroot/mvnforum/mvnforum/src/com/mvnforum/admin/importexport/jive/JiveUserXML.java,v 1.11 2007/06/22 18:37:16 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.11 $
 * $Date: 2007/06/22 18:37:16 $
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

import com.mvnforum.MVNForumConstant;
import com.mvnforum.admin.MemberXML;
import com.mvnforum.admin.importexport.XMLUtil;
import com.mvnforum.db.DAOFactory;
import net.myvietnam.mvncore.exception.*;
import net.myvietnam.mvncore.util.DateUtil;

/**
 * @author Igor Manic
 * @version $Revision: 1.11 $, $Date: 2007/06/22 18:37:16 $
 * <br/>
 * <code>JiveUserXML</code> class encapsulates processing of
 * users' definitions found in the Jive XML file. It implements
 * methods to be called from XML parsing routine, adds some additional
 * processing and checking, and calls corresponding methods of
 * <code>MemberXML</code> and other neccessary classes in order to perform
 * the actual creation of a member.
 */
public class JiveUserXML {

    private MemberXML memberXML = null;
    private boolean memberCreated = false;

    public JiveUserXML() {
        super();
        memberXML = new MemberXML();
        memberCreated = false;
    }

    public void setUserID(String id) {
        memberXML.setMemberID(id);
    }

    /**
     * This method simply calls <code>setUserID()</code>.
     * It's defined only to avoid property-setter problems with digester
     * (since it doesn't seem to recognize <code>setUserID()</code> as a setter
     * method for <code>userID</code> property).
     */
    public void setUserId(String id) {
        setUserID(id);
    }

    public void addJiveUser(String username, String password, String email,
                            String emailVisible, String name, String nameVisible,
                            String creationDate, String modifiedDate, String expireDate, String passwordExpireDate,
                            String rewardPoints)
        throws CreateException, DuplicateKeyException, ObjectNotFoundException,
        DatabaseException, ForeignKeyNotFoundException {
        
        /* First check if the digester already called this method.
         * It will happen even under normal circumstances, if this user has
         * subelements that need it already be defined, so they first call
         * this method to create user before creating data that refer him.
         */
        if (memberCreated) return;
        if ((username==null) || (username.equals("")) ||
            (password==null) || (password.equals("")) ||
            (email==null) || (email.equals("")) ) {
            throw new CreateException("Not enough data to create a member.");
        } else {
            String mvnPassword = JiveXML.convertPassword(password);

            String memberFirstName="";
            String memberLastName="";
            int i=name.indexOf(' ');
            if (i<0) {
                memberFirstName=name;
                memberLastName="";
            } else {
                memberFirstName=name.substring(0, i);
                memberLastName=name.substring(i+1, name.length());
            }

            if (emailVisible==null) emailVisible="true";
            if (nameVisible==null) nameVisible="true";

            if (username.equalsIgnoreCase(JiveXML.adminName)) {
                /* This user will become an admin.
                 * NO MATTER WHETHER HE HAD SYSTEM_ADMIN PERMISSIONS IN JIVE OR NOT,
                 * AFTER IMPORT HE WILL HAVE SYSTEM_ADMIN PERMISSION IN MVN FORUM.
                 */
                updateAdmin(username, mvnPassword, email, emailVisible, name, nameVisible,
                            creationDate, modifiedDate, rewardPoints,
                            memberFirstName, memberLastName);
            } else {
                ImportJive.addMessage("Adding Jive user \""+username+"\".");
                memberXML.addMember(username/*memberName*/, mvnPassword/*memberPassword*/,
                      email/*memberFirstEmail*/, email/*memberEmail*/,
                      emailVisible/*memberEmailVisible*/, nameVisible/*memberNameVisible*/,
                      null/*memberFirstIP*/, null/*memberLastIP*/,
                      null/*memberViewCount*/, null/*memberPostCount*/,
                      creationDate/*memberCreationDate*/, modifiedDate/*memberModifiedDate*/,
                      expireDate/*memberExpireDate*/, passwordExpireDate/*memberPasswordExpireDate*/, null/*memberLastLogon*/,
                      null/*memberOption*/, null/*memberStatus*/,
                      null/*memberActivateCode*/, null/*memberTempPassword*/,
                      null/*memberMessageCount*/, null/*memberMessageOption*/,
                      null/*memberPostsPerPage*/, null/*memberWarnCount*/,
                      null/*memberVoteCount*/, null/*memberVoteTotalStars*/,
                      rewardPoints/*memberRewardPoints*/, null/*memberTitle*/,
                      null/*memberTimeZone*/, null/*memberSignature*/,
                      null/*memberAvatar*/, null/*memberSkin*/,
                      null/*memberLanguage*/,
                      memberFirstName/*memberFirstname*/, memberLastName/*memberLastname*/,
                      null/*memberGender*/, null/*memberBirthday*/, null/*memberAddress*/,
                      null/*memberCity*/, null/*memberState*/, null/*memberCountry*/,
                      null/*memberPhone*/, null/*memberMobile*/, null/*memberFax*/,
                      null/*memberCareer*/, null/*memberHomepage*/, null/*memberYahoo*/,
                      null/*memberAol*/, null/*memberIcq*/, null/*memberMsn*/,
                      null/*memberCoolLink1*/, null/*memberCoolLink2*/);
                //ImportWebHelper.addMessage("Adding message folders \""+...+"\".");
                memberXML.addMessageFolder(MVNForumConstant.MESSAGE_FOLDER_INBOX,
                          null/*folderOrder*/,
                          null/*folderCreationDate*/, null/*folderModifiedDate*/);
                memberXML.addMessageFolder(MVNForumConstant.MESSAGE_FOLDER_SENT,
                          null/*folderOrder*/,
                          null/*folderCreationDate*/, null/*folderModifiedDate*/);
                memberXML.addMessageFolder(MVNForumConstant.MESSAGE_FOLDER_DRAFT,
                          null/*folderOrder*/,
                          null/*folderCreationDate*/, null/*folderModifiedDate*/);
                memberXML.addMessageFolder(MVNForumConstant.MESSAGE_FOLDER_TRASH,
                          null/*folderOrder*/,
                          null/*folderCreationDate*/, null/*folderModifiedDate*/);
            }

            memberCreated=true;
        }
    }

    private void updateAdmin(String username, String mvnPassword, String email,
                             String emailVisible, String name, String nameVisible,
                             String creationDate, String modifiedDate,
                             String rewardPoints,
                             String memberFirstName, String memberLastName)
        throws CreateException, DuplicateKeyException, ObjectNotFoundException,
        DatabaseException, ForeignKeyNotFoundException {
        
        int memberID = MVNForumConstant.MEMBER_ID_OF_ADMIN;
        memberXML.setMemberID(Integer.toString(memberID));
        //for later use (to call memberXML.addMessageFolder)

        int emailVisible1;
        int nameVisible1;
        java.sql.Timestamp modifiedDate1;
        java.sql.Date memberBirthday1;
        try {
            emailVisible1 = (XMLUtil.stringToBooleanDef(emailVisible, false)?1:0);
            nameVisible1 = (XMLUtil.stringToBooleanDef(nameVisible, false)?1:0);
            modifiedDate1= XMLUtil.stringToSqlTimestampDefNull(modifiedDate);
            memberBirthday1= new java.sql.Date(DateUtil.getCurrentGMTTimestamp().getTime());
        } catch (NumberFormatException e) {
            throw new CreateException("Invalid data for a member. Expected a number.");
        }
        ImportJive.addImportantMessage("Replacing default admin data with Jive admin user \""+username+"\".");
        JiveXML.foundAdminUser = true;
        DAOFactory.getMemberDAO().update(memberID,
                     emailVisible1/*memberEmailVisible*/, nameVisible1/*memberNameVisible*/,
                     modifiedDate1/*memberModifiedDate*/,
                     0/*memberOption*/, 0/*memberStatus*/,
                     0/*memberMessageOption*/, 0/*memberPostsPerPage*/,
                     0/*memberTimeZone*/, ""/*memberSkin*/,
                     ""/*memberLanguage*/,
                     memberFirstName/*memberFirstname*/, memberLastName/*memberLastname*/,
                     1/*memberGender,1=male*/, memberBirthday1/*memberBirthday*/,
                     ""/*memberAddress*/, ""/*memberCity*/, ""/*memberState*/,
                     ""/*memberCountry*/, ""/*memberPhone*/,
                     ""/*memberMobile*/, ""/*memberFax*/,
                     ""/*memberCareer*/, ""/*memberHomepage*/, ""/*memberYahoo*/,
                     ""/*memberAol*/, ""/*memberIcq*/, ""/*memberMsn*/,
                     ""/*memberCoolLink1*/, ""/*memberCoolLink2*/);
        //todo Igor: not available: DAOFactory.getMemberDAO().updateMemberName(memberID, username);
        DAOFactory.getMemberDAO().updatePassword(memberID, mvnPassword, null);
        DAOFactory.getMemberDAO().updateEmail(memberID, email);
        //todo Igor: not available: DAOFactory.getMemberDAO().updateCreationDate(memberID, creationDate);
        //todo Igor: not available: DAOFactory.getMemberDAO().updateRewardPoints(memberID, rewardPoints);
    }


}


