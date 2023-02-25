/*
 * $Header: /cvsroot/mvnforum/mvnforum/src/com/mvnforum/service/MvnForumLifeCycleService.java,v 1.5 2008/02/28 11:29:07 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.5 $
 * $Date: 2008/02/28 11:29:07 $
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
 * @author: Phong Ta Quoc
 */
package com.mvnforum.service;

import javax.servlet.ServletContextEvent;

public interface MvnForumLifeCycleService {

    /**
     * Notification that the web application initialization process is starting. All
     * ServletContextListeners are notified of context initialization before any filter
     * or servlet in the web application is initialized.
     * 
     * @param event
     */
    public void contextInitialized(ServletContextEvent event);

    /**
     * Notification that the servlet context is about to be shut down. All servlets and
     * filters have been destroy()ed before any ServletContextListeners are notified
     * of context destruction.
     * 
     * @param event
     */
    public void contextDestroyed(ServletContextEvent event);
}
