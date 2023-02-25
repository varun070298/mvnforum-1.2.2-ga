<%--
 - $Header: /cvsroot/mvnforum/mvnad/srcweb/mvnplugin/mvnad/delivery/fatalerror.jsp,v 1.3 2008/06/03 16:58:16 minhnn Exp $
 - $Author: minhnn $
 - $Revision: 1.3 $
 - $Date: 2008/06/03 16:58:16 $
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
<%-- not localized yet --%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false" isErrorPage="true"%>

<%@ page import="net.myvietnam.mvncore.util.MailUtil" %>
<%@ page import="org.apache.commons.logging.Log" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="com.mvnforum.MVNForumConfig" %>

<%@ taglib uri="mvntaglib" prefix="mvn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%
log.fatal("Assertion in admin.fatalerror.jsp", exception);
%>

<fmt:bundle basename="mvnad_i18n">
<mvn:html locale="${currentLocale}">
<mvn:head>
  <mvn:title><fmt:message key="mvnad.common.ad.title_name"/> - <fmt:message key="mvnad.admin.fatalerror.title"/></mvn:title>
<link href="<%=request.getContextPath()%>/mvnplugin/mvnad/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="JavaScript" src="<%=request.getContextPath()%>/mvnplugin/mvnad/js/myvietnam.js"></script>
</mvn:head>
<mvn:body>

<table class="tborder" width="95%" cellspacing="1" cellpadding="3" align="center">
  <tr class="pagedesc">
    <td>
    <span class="warning"><fmt:message key="mvnad.admin.fatalerror.error_info"/></span>
    <br/><br/>
    <b>&raquo;&nbsp;</b>
    <script language="JavaScript" type="text/javascript">
      var emailtitle = "<%=MailUtil.getEmailUsername(MVNForumConfig.getWebMasterEmail())%>";
      var emaildomain= "<%=MailUtil.getEmailDomain(MVNForumConfig.getWebMasterEmail())%>";
      writeEmail(emailtitle, emaildomain, "Report serious bug in mvnAd", "", "<fmt:message key="mvnad.admin.fatalerror.report_bug"/>", "command");
    </script>
    </td>
  </tr>
</table>

<br/>
<%@ include file="footer.jsp"%>

</mvn:body>
</mvn:html>
</fmt:bundle>
<%!
    private static final Log log = LogFactory.getLog("com.mvnsoft.mvnad.admin.fatalerror.jsp");
%>