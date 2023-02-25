<%--
 - $Header: /cvsroot/mvnforum/mvnad/srcweb/mvnplugin/mvnad/admin/addzone.jsp,v 1.7 2008/06/27 17:39:34 minhnn Exp $
 - $Author: minhnn $
 - $Revision: 1.7 $
 - $Date: 2008/06/27 17:39:34 $
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
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page errorPage="fatalerror.jsp"%>

<%@ page import="com.mvnsoft.mvnad.db.ZoneBean"%>

<%@ include file="inc_common.jsp"%>
<%@ include file="inc_doctype.jsp"%>
<fmt:bundle basename="mvnad_i18n">
<mvn:html>
<mvn:head>
  <mvn:title><fmt:message key="mvnad.common.ad.title_name"/> - <fmt:message key="mvnad.admin.addzone.title"/></mvn:title>
<%@ include file="/mvnplugin/mvnad/meta.jsp"%>
<link href="<%=contextPath%>/mvnplugin/mvnad/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="JavaScript">
//<![CDATA[
function ValidateForm() {
  if (isBlank(document.adzoneform.ZoneName, "<fmt:message key="mvnad.common.zone.name"/>")) return false;
  if (!isUnsignedInteger(document.adzoneform.ZoneCellWidth, "<fmt:message key="mvnad.common.zone.cell_width"/>")) return false;
  if (!isUnsignedInteger(document.adzoneform.ZoneCellHeight, "<fmt:message key="mvnad.common.zone.cell_height"/>")) return false;
  if (!isUnsignedInteger(document.adzoneform.ZoneCellHorizontalCount, "<fmt:message key="mvnad.common.zone.cell_horizontal_count"/>")) return false;
  if (!isUnsignedInteger(document.adzoneform.ZoneCellVerticalCount, "<fmt:message key="mvnad.common.zone.cell_vertical_count"/>")) return false;
  if (!isUnsignedInteger(document.adzoneform.ZoneMaxBanners, "<fmt:message key="mvnad.common.zone.max_banners"/>")) return false;
  if (document.adzoneform.ZoneMaxBanners.value < 1) {
    alert("<fmt:message key="mvnad.common.zone.max_banners"/> <fmt:message key="mvnad.common.js.prompt.mustbe_greater_or_equal_to"/> 1");
    return false;
  }
  if (!isUnsignedInteger(document.adzoneform.ZoneAutoReloadTime, "<fmt:message key="mvnad.common.zone.auto_reload_time"/>")) return false;
  return true;
}
function SubmitFormAddZone() {
  if (ValidateForm()) {
  <mvn:servlet>
    document.adzoneform.submitbutton.disabled=true;
  </mvn:servlet>
    document.adzoneform.submit();
  }
}
//]]>
</script>
</mvn:head>
<mvn:body onunload="document.adzoneform.submitbutton.disabled=false;">

<%@ include file="header.jsp"%>
<br />

<table width="95%" align="center">
  <tr class="nav">
    <td><img src="<%=contextPath%>/mvnplugin/mvnad/images/nav.gif" alt="" /></td>
    <td width="100%" nowrap="nowrap">
      <a class="nav" href="<%=urlResolver.encodeURL(request, response, "index")%>"><fmt:message key="mvnad.admin.index.title"/></a>&nbsp;&raquo;&nbsp;
      <a class="nav" href="<%=urlResolver.encodeURL(request, response, "listzones")%>"><fmt:message key="mvnad.common.ad.zone_management"/></a>&nbsp;&raquo;&nbsp;
      <fmt:message key="mvnad.admin.addzone.title"/>
    </td>
  </tr>
</table>
<br />

<table class="tborder" align="center" cellpadding="3" cellspacing="0" width="95%">
  <tr class="pagedesc">
    <td>
      <fmt:message key="mvnad.admin.addzone.guide"/><br /><br />
      <fmt:message key="mvnad.admin.addzone.some_sample_size"/><br />
      <fmt:message key="mvnad.admin.addzone.left_zone"/><br />
      <fmt:message key="mvnad.admin.addzone.right_video_zone"/><br /> 
      <fmt:message key="mvnad.admin.addzone.right_zone_small"/><br /> 
      <fmt:message key="mvnad.admin.addzone.right_zone_big"/><br />
      <fmt:message key="mvnad.admin.addzone.center_zone"/><br />
      <fmt:message key="mvnad.admin.addzone.header_zone"/><br />
      <fmt:message key="mvnad.admin.addzone.bottom_zone"/><br />
      <fmt:message key="mvnad.admin.addzone.right_vertical_zone"/>
    </td>
  </tr>
</table>
<br />

<form action="<%=urlResolver.encodeURL(request, response, "addzoneprocess", URLResolverService.ACTION_URL)%>" method="post" name="adzoneform">
<mvn:cssrows>
<table class="tborder" align="center" cellpadding="3" cellspacing="0" width="95%">
  <tr class="portlet-section-header">
    <td colspan="2"><fmt:message key="mvnad.admin.addzone.title"/></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.name"/></td>
    <td><input type="text" name="ZoneName" size="70" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnad.common.zone.description"/></td>
    <td><input type="text" name="ZoneDesc" size="70" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.target_window"/></td>
    <td>
      <select name="ZoneTargetWindow">
        <option value="_blank"><fmt:message key="mvnad.common.target_link._blank"/></option>
        <option value="_parent"><fmt:message key="mvnad.common.target_link._parent"/></option>
        <option value="_self"><fmt:message key="mvnad.common.target_link._self"/></option>
        <option value="_top"><fmt:message key="mvnad.common.target_link._top"/></option>
      </select>
    </td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.cell_width"/></td>
    <td><input type="text" name="ZoneCellWidth" size="13" value="100" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.cell_height"/></td>
    <td><input type="text" name="ZoneCellHeight" size="13" value="50" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.cell_horizontal_count"/></td>
    <td><input type="text" name="ZoneCellHorizontalCount" size="13" value="1" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.cell_vertical_count"/></td>
    <td><input type="text" name="ZoneCellVerticalCount" size="13" value="1" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.max_banners"/></td>
    <td><input type="text" name="ZoneMaxBanners" size="13" value="10" /></td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.direction"/></td>
    <td>
      <select name="ZoneDirection">
        <option value="<%=ZoneBean.ZONE_DIRECTION_HORIZONTAL%>"><fmt:message key="mvnad.common.zone.direction.horizontal"/></option>
        <option value="<%=ZoneBean.ZONE_DIRECTION_VERTICAL%>"><fmt:message key="mvnad.common.zone.direction.vertical"/></option>
      </select>
    </td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.type"/></td>
    <td>
      <select name="ZoneType">
        <option value="<%=ZoneBean.ZONE_TYPE_NORMAL%>"><fmt:message key="mvnad.common.zone.type.normal"/></option>
        <option value="<%=ZoneBean.ZONE_TYPE_DIRECT_CODE%>"><fmt:message key="mvnad.common.zone.type.direct_code"/></option>
      </select>
    </td>
  </tr>
  <tr class="<mvn:cssrow/>">
    <td><span class="requiredfield">*</span> <fmt:message key="mvnad.common.zone.auto_reload_time"/></td>
    <td><input type="text" name="ZoneAutoReloadTime" size="13" value="0" />&nbsp;<fmt:message key="mvnad.common.zone.auto_reload_time_info"/></td>
  </tr>
  <tr class="portlet-section-footer" align="center">
    <td colspan="2">
      <input type="button" name="submitbutton" value="<fmt:message key="mvnad.common.action.add"/>" onclick="javascipt:SubmitFormAddZone()" class="portlet-form-button" />
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