/*
 * $Header: /cvsroot/mvnforum/mvnad/src/com/mvnsoft/mvnad/user/AdUserWebHandler.java,v 1.3 2008/06/03 08:20:54 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.3 $
 * $Date: 2008/06/03 08:20:54 $
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

import java.util.Collection;

import net.myvietnam.mvncore.exception.BadInputException;
import net.myvietnam.mvncore.exception.DatabaseException;
import net.myvietnam.mvncore.web.GenericRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mvnforum.auth.*;
import com.mvnsoft.mvnad.db.DAOFactoryAd;

public class AdUserWebHandler {

    private static final Log    log               = LogFactory.getLog(AdUserWebHandler.class);
    private OnlineUserManager   onlineUserManager = OnlineUserManager.getInstance();

    public void listBanners(GenericRequest request)
        throws DatabaseException, AssertionError, AuthenticationException, BadInputException {
        
        OnlineUser onlineUser = onlineUserManager.getOnlineUser(request);
        MVNForumPermission permission = onlineUser.getPermission();
        permission.ensureCanViewBanner();
        
        Collection bannerBeans = DAOFactoryAd.getBannerDAO().getBannersOfUser(onlineUser.getMemberName());

        request.setAttribute("BannerBeans", bannerBeans);
    }

}
