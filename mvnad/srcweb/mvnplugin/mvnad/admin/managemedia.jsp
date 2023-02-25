<%--
 - $Header: /cvsroot/mvnforum/mvnad/srcweb/mvnplugin/mvnad/admin/managemedia.jsp,v 1.10 2008/06/17 09:44:05 lexuanttkhtn Exp $
 - $Author: lexuanttkhtn $
 - $Revision: 1.10 $
 - $Date: 2008/06/17 09:44:05 $
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

<%@ page import="java.io.File"%>
<%@ page import="com.mvnsoft.mvnad.MVNAdConfig"%>

<%@ include file="inc_common.jsp"%>
<%@ include file="inc_doctype.jsp"%>
<%
File[] mediaFiles = (File[]) request.getAttribute("MediaFiles");
%>
<fmt:bundle basename="mvnad_i18n">
<mvn:html>
<mvn:head>
  <mvn:title><fmt:message key="mvnad.common.ad.title_name"/> - <fmt:message key="mvnad.admin.managemedia.title"/></mvn:title>
<%@ include file="/mvnplugin/mvnad/meta.jsp"%>
<link href="<%=contextPath%>/mvnplugin/mvnad/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript">
//<![CDATA[
  function confirmDelete(fileName) {
    if (confirm("<fmt:message key="mvnad.admin.managemedia.confirm_delete"/>") == true) {
      document.deleteform.filename.value = fileName;
      document.deleteform.submit();
    }
  }
  function endsWith(imageURL, extension) {
    if (imageURL.lastIndexOf(extension) == -1) return false;
    if ((imageURL.lastIndexOf(extension) + extension.length) != imageURL.length) return false;
    return true; 
  }
  function getViewCode(newBannerImageURL) {
    newBannerImageURL='<%=ParamUtil.getServerPath() + ParamUtil.getContextPath() + MVNAdConfig.getWebUploadFolder() + "/" + onlineUser.getMemberName().toLowerCase() + "/"%>' + newBannerImageURL;
    if (endsWith(newBannerImageURL,".jpg") || endsWith(newBannerImageURL,".jpeg") || endsWith(newBannerImageURL,".gif") || endsWith(newBannerImageURL,".png")) {
      document.write("<img src='" + newBannerImageURL + "' alt='Preview Image'/>");
    } else if (endsWith(newBannerImageURL,".swf")) {
      document.write("<embed src='" + newBannerImageURL + "' id='previewFlash' quality='high' scale='noborder' wmode='transparent' bgcolor='#000000' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/shockwave/download/index.cgi?P1_Prod_Version=ShockwaveFlash'>");
    } else if (endsWith(newBannerImageURL,".avi") || endsWith(newBannerImageURL,".wmv") || endsWith(newBannerImageURL,".mpg")) {
      document.write("<embed src='" + newBannerImageURL + "' height='200' type='application/x-mplayer2' EnableContextMenu='0' AutoStart='1' loop='1' ShowStatusBar='0' ShowControls='0'></embed>");
    } else if (endsWith(newBannerImageURL,".mov")) {
      document.write("<OBJECT classid='clsid:02BF25D5-8C17-4B23-BC80-D3488ABDDC6B' height='200' codebase='http://www.apple.com/qtactivex/qtplugin.cab'><param name='src' value='" + newBannerImageURL + "'><param name='autoplay' value='true'><param name='controller' value='false'><param name='loop' value='true'><EMBED src='" + newBannerImageURL + "' height='200' autoplay='true' controller='false' loop='true' pluginspage='http://www.apple.com/quicktime/download/'></EMBED></OBJECT>");
    }
  }
//]]>
</script>
</mvn:head>
<mvn:body>
<%@ include file="header.jsp"%>
<br />

<table width="95%" align="center">
  <tr class="nav">
    <td><img src="<%=contextPath%>/mvnplugin/mvnad/images/nav.gif" alt="" /></td>
    <td width="100%" nowrap="nowrap">
      <a class="nav" href="<%=urlResolver.encodeURL(request, response, "index")%>"><fmt:message key="mvnad.admin.index.title"/></a>&nbsp;&raquo;&nbsp;
      <fmt:message key="mvnad.admin.managemedia.title"/>
    </td>
  </tr>
</table>
<br />

<table class="tborder" align="center" cellpadding="3" cellspacing="0" width="95%">
  <tr class="pagedesc">
    <td><fmt:message key="mvnad.admin.managemedia.manage_local_media"/></td>
  </tr>
</table>
<br />

<%if (permission.canUploadMedia()) {%>
<%String frompage = "managemedia"; %>
<%@ include file="uploadmedia.jsp"%>
<%}%>

<form name="deleteform" action="<%=urlResolver.encodeURL(request, response, "deletemedia", URLResolverService.ACTION_URL)%>" method="post">
  <input type="hidden" name="filename" value="" />
</form>

<mvn:cssrows>
<table class="tborder" align="center" width="95%" cellpadding="3" cellspacing="0">
  <tr class="portlet-section-header">
    <td align="center"><fmt:message key="mvnad.admin.managemedia.file_name"/></td>
    <td align="center"><fmt:message key="mvnad.common.action.preview"/></td>
    <td align="center">
    <%if (permission.canUploadMedia()) {%>
      <fmt:message key="mvnad.common.action.delete"/>
    <%}%>
    </td>
  </tr>
<%
  for (int i = 0; i < mediaFiles.length; i++) {
    File mediaFile = mediaFiles[i];
%>
  <tr class="<mvn:cssrow/>" align="center">
    <td><%=mediaFile.getName()%></td>
    <td>
      <script type="text/javascript" language="javascript">
      //<![CDATA[
        getViewCode("<%=mediaFile.getName()%>");
      //]]>
      </script>
    </td>
    <td>
      <input type="button" value="<fmt:message key="mvnad.common.action.delete"/>" class="command" onclick="confirmDelete('<%=mediaFile.getName()%>')" />
    </td>
  </tr>
<%}
  if (mediaFiles.length == 0) {%>
  <tr class="<mvn:cssrow/>">
    <td colspan="3" align="center"><fmt:message key="mvnad.admin.managemedia.no_media_here"/></td>
  </tr>
<%}%>
</table>
</mvn:cssrows>

<br />
<%@ include file="footer.jsp"%>

</mvn:body>
</mvn:html>
</fmt:bundle>