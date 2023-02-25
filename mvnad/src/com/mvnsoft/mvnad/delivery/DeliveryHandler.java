/*
 * $Header: /cvsroot/mvnforum/mvnad/src/com/mvnsoft/mvnad/delivery/DeliveryHandler.java,v 1.6 2008/06/03 10:55:05 minhnn Exp $
 * $Author: minhnn $
 * $Revision: 1.6 $
 * $Date: 2008/06/03 10:55:05 $
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
package com.mvnsoft.mvnad.delivery;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.myvietnam.mvncore.exception.*;
import net.myvietnam.mvncore.util.*;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mvnsoft.mvnad.db.BannerBean;
import com.mvnsoft.mvnad.db.DAOFactoryAd;

public class DeliveryHandler {
    
    private static final Log log = LogFactory.getLog(DeliveryHandler.class);
    
    public void processClickAd(HttpServletRequest request, HttpServletResponse response) 
        throws BadInputException, ObjectNotFoundException, DatabaseException, CreateException, ForeignKeyNotFoundException {
        
        int bannerID = ParamUtil.getParameterInt(request, "bannerID");
        int zoneID   = ParamUtil.getParameterInt(request, "zoneID");

        // increase ReceivedClick
        DAOFactoryAd.getBannerDAO().increaseReceivedClick(bannerID, 1);
        DAOFactoryAd.getZoneDAO().increaseReceivedClick(zoneID, 1);
        
        BannerBean bannerBean = DAOFactoryAd.getBannerDAO().getBean(bannerID);//TODO cache this call for improve performance
        request.setAttribute("TargetURL", bannerBean.getBannerTargetURL());
    }
    
    public void getZoneAd(HttpServletRequest request) { 
        
        try {
            int zoneID   = ParamUtil.getParameterInt(request, "zoneID");
            
            Timestamp now = DateUtil.getCurrentGMTTimestamp();
            
            String objectType = ParamUtil.getParameter(request, "objectType");
            int objectID = ParamUtil.getParameterInt(request, objectType + "ID", 0);
            
            if ((objectType.length() > 0) && (objectID != 0)) {
                request.setAttribute("ad_table", StringEscapeUtils.escapeJavaScript(AdGenerator.getTableAd(now, zoneID, objectType, objectID)));
            } else {
                request.setAttribute("ad_table", StringEscapeUtils.escapeJavaScript(AdGenerator.getTableAd(now, zoneID, "", 0)));
            }
            request.setAttribute("Now", now);
            request.setAttribute("ZoneID", new Integer(zoneID));
        } catch (Exception exception) {
            request.setAttribute("ad_table", "");
            log.error("Error", exception);
        }
    }
    
    public void getAdFrame(HttpServletRequest request) { 
        
        try {
            int zoneID   = ParamUtil.getParameterInt(request, "zoneID");
            
            Timestamp now = DateUtil.getCurrentGMTTimestamp();
            request.setAttribute("ad_frame", AdGenerator.getAutoReloadFrame(now, zoneID));
        } catch (Exception exception) {
            request.setAttribute("ad_frame", "");
            log.error("Error", exception);
        }
    }
}