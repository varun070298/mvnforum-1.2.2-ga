<%--
 - $Header: /cvsroot/mvnforum/mvnad/srcweb/mvnplugin/mvnad/delivery/getad.jsp,v 1.3 2008/06/03 16:58:17 minhnn Exp $
 - $Author: minhnn $
 - $Revision: 1.3 $
 - $Date: 2008/06/03 16:58:17 $
 -
 - ====================================================================
 -
 - Copyright (C) 2002-2008 by MyVietnam.net
 -
 - All copyright notices regarding mvnForum MUST remain 
 - intact in the scripts and in the outputted HTML.
 - The "powered by" text/logo with a link back to
 - http://www.mvnForum.com and http://www.MyVietnam.net in 
 - the footer of the pages MUST remain visible when the pages
 - are viewed on the internet or intranet.
 -
 - This program is free software; you can redistribute it and/or modify
 - it under the terms of the GNU General Public License as published by
 - the Free Software Foundation; either version 2 of the License, or
 - any later version.
 -
 - This program is distributed in the hope that it will be useful,
 - but WITHOUT ANY WARRANTY; without even the implied warranty of
 - MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 - GNU General Public License for more details.
 -
 - You should have received a copy of the GNU General Public License
 - along with this program; if not, write to the Free Software
 - Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 -
 - Support can be obtained from support forums at:
 - http://www.mvnForum.com/mvnforum/index
 -
 - Correspondence and Marketing Questions can be sent to:
 - info at MyVietnam net
 -
 - @author: MyVietnam.net developers
 -
 --%>
<%@ page contentType="application/x-javascript;charset=utf-8" %>
<%@ page import="com.mvnsoft.mvnad.AdModuleUtils"%>
<%@ page import="java.sql.Timestamp"%>
<%
int zoneID = ((Integer) request.getAttribute("ZoneID")).intValue();
Timestamp now = (Timestamp) request.getAttribute("Now");
%>
document.write("<%=request.getAttribute("ad_table")%>");
<%if (now != null) {%>
document.getElementById('<%=AdModuleUtils.getDocumentID(zoneID, now)%>').href += '&screen='+window.screen.width+'x'+window.screen.height;
<%}%>