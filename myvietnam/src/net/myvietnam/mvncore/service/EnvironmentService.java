/*
 * $Header: /cvsroot/mvnforum/myvietnam/src/net/myvietnam/mvncore/service/EnvironmentService.java,v 1.9 2008/06/06 10:18:12 lexuanttkhtn Exp $
 * $Author: lexuanttkhtn $
 * $Revision: 1.9 $
 * $Date: 2008/06/06 10:18:12 $
 *
 * ====================================================================
 *
 * Copyright (C) 2002-2007 by MyVietnam.net
 *
 * All copyright notices regarding MyVietnam and MyVietnam CoreLib
 * MUST remain intact in the scripts and source code.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * Correspondence and Marketing Questions can be sent to:
 * info at MyVietnam net
 *
 * @author: Dung Bui
 */
package net.myvietnam.mvncore.service;

public interface EnvironmentService {
    
    public final static int PRODUCT_DISABLED    = 0;
    public final static int PRODUCT_OPENSOURCE  = 1;
    public final static int PRODUCT_ENTERPRISE  = 2;
    
    public int getForumRunMode();
    
    public int getCmsRunMode();
    
    public int getAdRunMode();
    
    public boolean isPortlet();
    
    public String customizeFor();
    
    public void setShouldRun(boolean shouldRun, String reason);
    
    public boolean isShouldRun();
    
    public String getReason();
    
    public void overloadEnvironment();

}
