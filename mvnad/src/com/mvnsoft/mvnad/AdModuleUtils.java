/*
 * $Header: /cvsroot/mvnforum/mvnad/src/com/mvnsoft/mvnad/AdModuleUtils.java,v 1.6 2008/06/17 04:51:36 lexuanttkhtn Exp $
 * $Author: lexuanttkhtn $
 * $Revision: 1.6 $
 * $Date: 2008/06/17 04:51:36 $
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
package com.mvnsoft.mvnad;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import net.myvietnam.mvncore.util.ParamUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mvnsoft.mvnad.db.BannerBean;
import com.mvnsoft.mvnad.db.ZoneBean;
import com.mvnsoft.mvnad.service.MvnAdServiceFactory;

public final class AdModuleUtils {
    
    private static final Log log = LogFactory.getLog(AdModuleUtils.class);
    
    private AdModuleUtils() {
    }
    
    public static String getWebFolderOfMember(String memberName) {
        String lowerMemberName = memberName.toLowerCase();
        return MVNAdConfig.getWebUploadFolder() + "/" + lowerMemberName;
    }
    
    public static String getBannerWebPath(BannerBean bannerBean) {
      
        // if banner type is HTML, just return its HTML code
        if (bannerBean.getBannerType() == BannerBean.BANNER_TYPE_HTML) {
            return bannerBean.getBannerHtmlCode();
        }
        
        String bannerImageURL = bannerBean.getBannerImageURL();

        // check if banner is an internal media, we must add web path to display
        if ((bannerImageURL.startsWith("http://") || bannerImageURL.startsWith("https://") || bannerImageURL.startsWith("ftp://")) == false) {
            bannerImageURL = ParamUtil.getServerPath() + ParamUtil.getContextPath() + MVNAdConfig.getWebUploadFolder() + "/" + bannerImageURL;
        }
        
        return bannerImageURL;
    }

    public static String getZoneDirectionName(int zoneDirection, Locale locale) {
        switch (zoneDirection) {
        case ZoneBean.ZONE_DIRECTION_HORIZONTAL:
            return MVNAdResourceBundle.getString(locale, "mvnad.common.zone.direction.horizontal");

        case ZoneBean.ZONE_DIRECTION_VERTICAL:
            return MVNAdResourceBundle.getString(locale, "mvnad.common.zone.direction.vertical");
            
        default:
            log.error("Assertion: currently does not support zoneDirection = " + zoneDirection);
            return "";
        }
    }

    public static String getZoneTypeName(int zoneType, Locale locale) {
        switch (zoneType) {
        case ZoneBean.ZONE_TYPE_NORMAL:
            return MVNAdResourceBundle.getString(locale, "mvnad.common.zone.type.normal");

        case ZoneBean.ZONE_TYPE_DIRECT_CODE:
            return MVNAdResourceBundle.getString(locale, "mvnad.common.zone.type.direct_code");
            
        default:
            log.error("Assertion: currently does not support zoneType = " + zoneType);
            return "";
        }
    }

    public static void writeMvnAdImage(HttpServletResponse response) throws IOException {

        BufferedImage image = MvnAdServiceFactory.getMvnAdService().getMvnAdInfoService().getImage();
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            response.setContentType("image/jpeg");

            //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(outputStream);
            //encoder.encode(image);
            ImageIO.write(image, "jpeg", outputStream);
            outputStream.flush();
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) { }
            }
        }
    }
    
    public static String getDocumentID(int zoneID, Timestamp timestamp) {
        return "z" + zoneID + "_" + timestamp.getTime();
    }
}