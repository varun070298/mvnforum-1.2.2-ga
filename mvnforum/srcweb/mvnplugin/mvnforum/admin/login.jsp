<%--
 - $Header: /cvsroot/mvnforum/mvnforum/srcweb/mvnplugin/mvnforum/admin/login.jsp,v 1.82 2008/06/26 10:32:43 minhnn Exp $
 - $Author: minhnn $
 - $Revision: 1.82 $
 - $Date: 2008/06/26 10:32:43 $
 -
 - ====================================================================
 -
 - Copyright (C) 2002-2007 by MyVietnam.net
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
 - @author: Minh Nguyen  
 - @author: Mai  Nguyen  
 --%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page errorPage="fatalerror.jsp"%>

<%@ page import="net.myvietnam.mvncore.util.ParamUtil" %>

<%@ include file="inc_common.jsp"%>
<%@ include file="inc_doctype.jsp"%>
<fmt:bundle basename="mvnForum_i18n">
<mvn:html locale="${currentLocale}">
<mvn:head>
  <mvn:title><fmt:message key="mvnforum.common.forum.title_name"/> - <fmt:message key="mvnforum.user.login.title"/></mvn:title>
<%@ include file="/mvnplugin/mvnforum/meta.jsp"%>
<link href="<%=onlineUser.getCssPath()%>" rel="stylesheet" type="text/css" />
</mvn:head>
<mvn:body onunload="document.submitform.submitbutton.disabled=false;">
<script type="text/javascript" language="JavaScript" src="<%=contextPath%>/mvnplugin/mvnforum/js/md5.js"></script>
<%@ include file="header.jsp"%>

<script type="text/javascript">
//<![CDATA[
function checkEnter(event) {
  var agt=navigator.userAgent.toLowerCase();
  
  // Maybe, Opera make an onClick event when user press enter key 
  // on the text field of the form
  if (agt.indexOf('opera') >= 0) return;

  // enter key is pressed
  if (getKeyCode(event) == 13)
    SubmitForm();
}

function SubmitForm() {
  if (ValidateForm()) {
    var enableEncrypted = <%=MVNForumConfig.getEnableEncryptPasswordOnBrowser()%>;
    if (enableEncrypted) {
      pw2md5(document.submitform.MemberMatkhau, document.submitform.md5pw);
    }
    <mvn:servlet>
    document.submitform.submitbutton.disabled=true;
    </mvn:servlet>
    return document.submitform.submit();
  }
  return false;
}

function ValidateForm() {
  if (isBlank(document.submitform.MemberName, "<fmt:message key="mvnforum.common.member.login_name"/>")) return false;
  if (isBlank(document.submitform.MemberMatkhau, "<fmt:message key="mvnforum.common.member.password"/>")) return false;
  //Check Password's length
  if (document.submitform.MemberMatkhau.value.length < 3) {
    alert("<fmt:message key="mvnforum.common.js.prompt.invalidlongpassword"/>");
    document.submitform.MemberMatkhau.focus();
    return false;
  }
  return true;
}
//]]>
</script>
<br />

<table width="95%" align="center">
  <tr class="nav">
    <td><img src="<%=contextPath%>/mvnplugin/mvnforum/images/nav.gif" alt="" /></td>
    <td width="100%" nowrap="nowrap">
    <%if (isServlet) {%>
    <a class="nav" href="<%=urlResolver.encodeURL(request, response, "index", URLResolverService.RENDER_URL, "view")%>"><fmt:message key="mvnforum.common.nav.index"/></a>&nbsp;&raquo;&nbsp;
    <%}%>
    <a class="nav" href="<%=urlResolver.encodeURL(request, response, "index")%>"><fmt:message key="mvnforum.admin.index.title"/></a>&nbsp;&raquo;&nbsp;
    <fmt:message key="mvnforum.user.login.title"/>
    </td>
  </tr>
</table>
<br />

<%
String errorMessage = ParamUtil.getAttribute(request, "Reason");
%>
<% if (errorMessage.length() > 0) { %>
<table class="tborder" width="95%" cellspacing="0" cellpadding="3" align="center">
<tr class="pagedesc">
  <td>
    <fmt:message key="mvnforum.user.login.message"/>: <span class="warning"><%=errorMessage%></span><br/>
  </td>
</tr>
</table>
<br />
<% } %>
<table class="tborder" width="95%" cellspacing="0" cellpadding="3" align="center">
  <tr class="pagedesc">
    <td>
    <fmt:message key="mvnforum.user.login.guide"/><br/>
    </td>
  </tr>
</table>

<%if (MVNForumConfig.getEnableLogin()) {%>
<br/>
<form action="<%=urlResolver.encodeURL(request, response, "loginprocess", URLResolverService.ACTION_URL)%>" method="post" name="submitform" onsubmit="return false;">
<%=urlResolver.generateFormAction(request, response, "loginprocess")%>
<input type="hidden" name="FromLoginPage" value="true" />
<input type="hidden" name="md5pw" value="" />
<table class="tborder" width="95%" cellspacing="0" cellpadding="3" align="center">
<mvn:cssrows>
  <tr class="portlet-section-header">
    <td colspan="2"><fmt:message key="mvnforum.user.login.prompt"/></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td width="40%"><fmt:message key="mvnforum.common.member.login_name"/></td>
    <td><input type="text" name="MemberName" value="<%=ParamUtil.getAttribute(request, "MemberName")%>" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.password"/></td>
    <td><input type="password" name="MemberMatkhau" onkeypress="checkEnter(event);" /></td>
  </tr>
  <tr class="portlet-section-footer">
    <td colspan="2" align="center">
      <input type="button" name="submitbutton" value="<fmt:message key="mvnforum.common.action.login"/>" onclick="javascript:SubmitForm();" class="portlet-form-button" />
    </td>
  </tr>
</mvn:cssrows>
</table>
</form>

<script language="JavaScript" type="text/javascript">
//<![CDATA[
    document.submitform.MemberName.focus();
//]]>
</script>
<%}%>
<br/>

<%@ include file="footer.jsp"%>
</mvn:body>
</mvn:html>
</fmt:bundle>