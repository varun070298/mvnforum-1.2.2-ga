/*
 * $Header: /cvsroot/mvnforum/mvnad/src/com/mvnsoft/mvnad/user/AdUserServlet.java,v 1.4 2008/06/27 04:24:33 lexuanttkhtn Exp $
 * $Author: lexuanttkhtn $
 * $Revision: 1.4 $
 * $Date: 2008/06/27 04:24:33 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2008 by MyVietnam.net
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
 * @author: MyVietnam.net developers
 */
package com.mvnsoft.mvnad.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import net.myvietnam.mvncore.db.DBUtils;
import net.myvietnam.mvncore.exception.BadInputException;
import net.myvietnam.mvncore.filter.UserAgentFilter;
import net.myvietnam.mvncore.service.IPFilterService;
import net.myvietnam.mvncore.service.MvnCoreServiceFactory;
import net.myvietnam.mvncore.util.I18nUtil;
import net.myvietnam.mvncore.util.ParamUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mvnforum.MVNForumConfig;
import com.mvnforum.auth.OnlineUser;
import com.mvnforum.auth.OnlineUserManager;
import com.mvnsoft.mvnad.service.*;

public class AdUserServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(AdUserServlet.class);
    
    private static int count = 0;

    private MvnAdInfoService    mvnAdInfo           = MvnAdServiceFactory.getMvnAdService().getMvnAdInfoService();
    private IPFilterService     ipFilterService     = MvnCoreServiceFactory.getMvnCoreService().getIPFilterService();

    private MvnAdModuleProcessor userModuleProcessor = null;

    /** Initialize global variables */
    public void init() throws ServletException {
        
        userModuleProcessor = MvnAdServiceFactory.getMvnAdService().getMvnAdModuleProcessorService().getUserModuleProcessor();
        userModuleProcessor.setServlet(this);

        log.info("<<---- AdUserServlet has been inited.  Detailed info: "
                        + mvnAdInfo.getProductVersion() + " (Build: " + mvnAdInfo.getProductReleaseDate() + ") ---->>");
    }

    /** Process the HTTP Get request */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        process(request, response);
    }

    /** Process the HTTP Post request */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        process(request, response);
    }

    public void process(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

        long startTime = 0;
        if (log.isDebugEnabled()) {
            startTime = System.currentTimeMillis();
        }
        
        count++;
        
        try {
            request.setCharacterEncoding("utf-8");
            String responseURI = null;
            
            if (ipFilterService.filter(request) == false) {
                getServletContext().getRequestDispatcher("/mvnplugin/mvnad/404.jsp").forward(request, response);
                return;
            }

            if (UserAgentFilter.filter(request) == false) {
                getServletContext().getRequestDispatcher("/mvnplugin/mvnad/404.jsp").forward(request, response);
                return;
            }
            
            OnlineUserManager onlineUserManager = OnlineUserManager.getInstance();
            OnlineUser onlineUser = onlineUserManager.getOnlineUser(request);
            
            String localeName = ParamUtil.getParameter(request, MVNForumConfig.getLocaleParameterName());
            if (MVNForumConfig.supportLocale(localeName)) {
                onlineUser.setLocaleName(localeName);
            }
            I18nUtil.setLocaleInRequest(request, onlineUser.getLocale());
            
            // this method should not throw Exception (it must catch all Exceptions)
            responseURI = userModuleProcessor.process(request, response);
            
            if ((null != responseURI) && (response.isCommitted() == false)) {
                if (responseURI.endsWith(".jsp")) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher(responseURI);
                    if (dispatcher != null) {
                        dispatcher.forward(request, response);
                    } else {
                        log.warn("Cannot get RequestDispatcher for responseURI = " + responseURI);
                    }
                } else {
                    response.sendRedirect(request.getContextPath() + responseURI);
                }
            }
        } catch (Throwable e) {
            if (e instanceof BadInputException) {
                //We log in WARN level if this is the exception from user input
                log.warn("Exception in AdUserServlet e = " + e.getMessage(), e);
            } else if (e instanceof AssertionError) {
                //We log in FATAL level if this is the exception from user input
                log.fatal("Exception in AdUserServlet e = " + e.getMessage(), e);
            } else {
                log.error("Exception in AdUserServlet [" + e.getClass().getName() + "] : " + e.getMessage(), e);
            }
        } finally {
            if (log.isDebugEnabled()) {
                long processTime = System.currentTimeMillis() - startTime;
                log.debug("AdUserServlet processed " + count + " times. Took " + processTime + " milliseconds.\n");
            }
        }
    }// process

    /**
     * Clean up resources
     */
    public void destroy() {
        // This code will release all connections currently pooled.
        // The next call to #getConnection will recreate the pool.
        DBUtils.closeAllConnections();

        log.info("<<---- AdUserServlet has been destroyed. ---->>");
    }
}