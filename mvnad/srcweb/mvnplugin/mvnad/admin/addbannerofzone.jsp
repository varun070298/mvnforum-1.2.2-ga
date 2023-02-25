<%--
 - $Header: /cvsroot/mvnforum/mvnad/srcweb/mvnplugin/mvnad/admin/addbannerofzone.jsp,v 1.4 2008/06/13 07:54:47 lexuanttkhtn Exp $
 - $Author: lexuanttkhtn $
 - $Revision: 1.4 $
 - $Date: 2008/06/13 07:54:47 $
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

<%@ page import="java.util.*" %>
<%@ page import="com.mvnsoft.mvnad.db.*"%>

<%@ include file="inc_common.jsp"%>
<%@ include file="inc_doctype.jsp"%>
<%
Collection adBannerBeans = (Collection) request.getAttribute("BannerBeans");
Collection adZoneBeans = (Collection) request.getAttribute("ZoneBeans");
int zoneID = ((Integer) request.getAttribute("ZoneID")).intValue();
%>
<fmt:bundle basename="mvnad_i18n">
<mvn:html>
<mvn:head>
  <mvn:title><fmt:message key="mvnad.common.ad.title_name"/> - <fmt:message key="mvnad.admin.addbannerofzone.title"/></mvn:title>
<%@ include file="/mvnplugin/mvnad/meta.jsp"%>
<link href="<%=contextPath%>/mvnplugin/mvnad/css/style.css" rel="stylesheet" type="text/css" />
</mvn:head>
<mvn:body onunload="document.submitForm.submitbutton.disabled=false;">
<script type="text/javascript" language="JavaScript">
//<![CDATA[
function changeImage(s) {
    document.submitForm.imgChange.src = s;
}
function ValidateForm() {
  if (isBlank(document.submitForm.ZoneID, "<fmt:message key="mvnad.common.zone.name"/>")) return false;
  if (isBlank(document.submitForm.BannerID, "<fmt:message key="mvnad.common.banner.name"/>")) return false;
  return true;
 }
function SubmitFormAddBannerofZone() {
  if (ValidateForm()) {
  <mvn:servlet>
    document.submitForm.submitbutton.disabled=true;
  </mvn:servlet>
    document.submitForm.submit();
  }
}
//]]>
</script>

<%@ include file="header.jsp"%>
<br />

<table width="95%" align="center">
  <tr class="nav">
    <td><img src="<%=contextPath%>/mvnplugin/mvnad/images/nav.gif" alt="" /></td>
    <td width="100%" nowrap="nowrap">
    <a class="nav" href="<%=urlResolver.encodeURL(request, response, "index")%>"><fmt:message key="mvnad.admin.index.title"/></a>&nbsp;&raquo;&nbsp;
    <a class="nav" href="<%=urlResolver.encodeURL(request, response, "listzones")%>"><fmt:message key="mvnad.common.ad.zone_management"/></a>&nbsp;&raquo;&nbsp;
    <fmt:message key="mvnad.admin.addbannerofzone.link_banner_with_zone"/>
    </td>
  </tr>
</table>
<br />

<form action="<%=urlResolver.encodeURL(request, response, "addbannerofzoneprocess", URLResolverService.ACTION_URL)%>" name="submitForm" method="post">
<mvn:cssrows>
<table class="tborder" align="center" cellpadding="3" cellspacing="0" width="95%">
    <tr class="portlet-section-header">
      <td colspan="2">
        <fmt:message key="mvnad.admin.addbannerofzone.link_banner_with_zone"/>
      </td>
    </tr>
    <tr class="<mvn:cssrow/>">
      <td width="15%"><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.name"/></td>
      <td>
        <select name="ZoneID">
          <option value=""></option>
      <%for (Iterator iterator = adZoneBeans.iterator(); iterator.hasNext(); ) {
          ZoneBean adZoneBean = (ZoneBean) iterator.next();%>
          <option value="<%=adZoneBean.getZoneID()%>"<%if (adZoneBean.getZoneID() == zoneID) {%> selected="selected"<%}%>><%=adZoneBean.getZoneName()%></option>
      <%}%>
        </select>
      </td>
    </tr>
    <tr class="<mvn:cssrow/>">
      <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.banner.name"/></td>
      <td>
        <select name="BannerID">
          <option value=""></option>
      <%for (Iterator iterator = adBannerBeans.iterator(); iterator.hasNext(); ) {
          BannerBean adBannerBean = (BannerBean) iterator.next();%>
          <option value="<%=adBannerBean.getBannerID()%>"><%=adBannerBean.getBannerName()%></option>
      <%}%>
      </select>
      </td>
    </tr>
    <tr class="<mvn:cssrow/>">
      <td nowrap="nowrap"><span class="requiredfield">*</span> <fmt:message key="mvnad.common.bannerofzone.zone_publish_start_date"/></td>
      <td>
        <%prefixName = "RelationPublishStartDate";
          Timestamp currentTimestamp = null;
          float startYear = 0;%>
        <%@ include file="inc_date_option.jsp"%>
      </td>
    </tr>
    <tr class="<mvn:cssrow/>">
      <td nowrap="nowrap"><span class="requiredfield">*</span> <fmt:message key="mvnad.common.bannerofzone.zone_publish_end_date"/></td>
      <td>
        <%prefixName = "RelationPublishEndDate";%>
        <%@ include file="inc_date_option.jsp"%>
      </td>
    </tr>
    <tr class="portlet-section-footer" align="center">
      <td colspan="2">
        <input type="button" name="submitbutton" value="<fmt:message key="mvnad.common.action.ok"/>" onclick="javascript:SubmitFormAddBannerofZone()" class="portlet-form-button" />
        <input type="reset" value="<fmt:message key="mvnad.common.action.reset"/>" class="liteoption" />
      </td>
    </tr>
</table>
</mvn:cssrows>
</form>

<br />
<%@ include file="footer.jsp"%>

</mvn:body>
</mvn:html>
</fmt:bundle>