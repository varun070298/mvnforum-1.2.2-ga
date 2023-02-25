<%--
 - $Header: /cvsroot/mvnforum/mvnad/srcweb/mvnplugin/mvnad/user/error.jsp,v 1.4 2008/06/03 17:21:51 minhnn Exp $
 - $Author: minhnn $
 - $Revision: 1.4 $
 - $Date: 2008/06/03 17:21:51 $
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
<%@ page errorPage="fatalerror.jsp"%>

<%@ page import="net.myvietnam.mvncore.util.MailUtil" %>
<%@ page import="com.mvnforum.MVNForumConfig" %>

<%@ include file="inc_common.jsp"%>
<%@ include file="inc_doctype.jsp"%>
<fmt:bundle basename="mvnad_i18n">
<mvn:html>
<mvn:head>
  <mvn:title><fmt:message key="mvnad.common.ad.title_name"/> - <fmt:message key="mvnad.admin.error.title"/></mvn:title>
<%@ include file="/mvnplugin/mvnad/meta.jsp"%>
<link href="<%=contextPath%>/mvnplugin/mvnad/css/style.css" rel="stylesheet" type="text/css" />
</mvn:head>
<mvn:body>

<%@ include file="header.jsp"%>
<br />

<table width="95%" align="center">
  <tr class="nav">
    <td><img src="<%=contextPath%>/mvnplugin/mvnad/images/nav.gif" alt="" /></td>
    <td width="100%" nowrap="nowrap">
      <a class="nav" href="index"><fmt:message key="mvnad.user.index.title"/></a>&nbsp;&raquo;&nbsp;
      <fmt:message key="mvnad.admin.error.title"/>
    </td>
  </tr>
</table>
<br />

<table class="tborder" align="center" cellpadding="3" cellspacing="1" width="95%">
  <tr class="pagedesc">
    <td>
      <fmt:message key="mvnad.admin.error.error_message"/><br />
      <b><i><span class="warning"><%=session.getAttribute("ErrorMessage")%></span></i></b>
      <br />
      <fmt:message key="mvnad.admin.error.you_may"/> <a class="command" href="javascript:history.back(1)"><fmt:message key="mvnad.admin.error.go_back"/></a> <fmt:message key="mvnad.admin.error.now_and_try_again"/><br />
      <fmt:message key="mvnad.common.ad.or"/>
      <script language="JavaScript" type="text/javascript">
      //<![CDATA[
        var emailtitle = "<%=MailUtil.getEmailUsername(MVNForumConfig.getWebMasterEmail())%>";
        var emaildomain= "<%=MailUtil.getEmailDomain(MVNForumConfig.getWebMasterEmail())%>";
        writeEmail(emailtitle, emaildomain, "<fmt:message key="mvnad.admin.error.report_bug"/>", "", "<fmt:message key="mvnad.admin.error.report_to_admin"/>", "command");
      //]]>
      </script>
    </td>
  </tr>
</table>

<br />
<%@ include file="footer.jsp"%>
</mvn:body>
</mvn:html>
</fmt:bundle>