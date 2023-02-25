<%--
 - $Header: /cvsroot/mvnforum/mvnforum/srcweb/mvnplugin/mvnforum/user/editmember.jsp,v 1.105 2008/06/25 09:23:45 phuongpdd Exp $
 - $Author: phuongpdd $
 - $Revision: 1.105 $
 - $Date: 2008/06/25 09:23:45 $
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

<%@ page import="java.util.Date"%>
<%@ page import="java.util.Locale" %>
<%@ page import="net.myvietnam.mvncore.util.DateUtil" %>
<%@ page import="com.mvnforum.db.*" %>
<%@ page import="com.mvnforum.common.MemberMapping" %>

<%@ include file="inc_common.jsp"%>
<%@ include file="inc_doctype.jsp"%>
<fmt:bundle basename="mvnForum_i18n">
<mvn:html locale="${currentLocale}">
<mvn:head>
  <mvn:title><fmt:message key="mvnforum.common.forum.title_name"/> - <fmt:message key="mvnforum.user.editmember.title"/></mvn:title>
<%@ include file="/mvnplugin/mvnforum/meta.jsp"%>
<link href="<%=onlineUser.getCssPath()%>" rel="stylesheet" type="text/css"/>
</mvn:head>
<mvn:body onunload="document.submitform.submitbutton.disabled=false;">
<script language="JavaScript1.2" src="<%=contextPath%>/mvnplugin/mvnforum/js/vietuni.js" type="text/javascript"></script>

<%
MemberBean memberBean = (MemberBean)request.getAttribute("MemberBean");
MemberMapping mapping = MemberMapping.getInstance();
%>

<script type="text/javascript">
//<![CDATA[
function SubmitForm() {
  if (ValidateForm()) {
  <mvn:servlet>
    document.submitform.submitbutton.disabled=true;
  </mvn:servlet>  
    document.submitform.submit();
  }
}

function ValidateForm() {
<% if ( MVNForumConfig.getEnableShowFirstName() && MVNForumConfig.isRequireRegisterFirstname() &&
        (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberFirstname())) ) { %>
  if (isBlank(document.submitform.MemberFirstname, "<fmt:message key="mvnforum.common.member.first_name"/>")) return false;
<%}%>

<% if ( MVNForumConfig.getEnableShowLastName() && MVNForumConfig.isRequireRegisterLastname() &&
        (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberLastname())) ) { %>
  if (isBlank(document.submitform.MemberLastname, "<fmt:message key="mvnforum.common.member.last_name"/>")) return false;
<%}%>

<% if ( MVNForumConfig.getEnableShowBirthday() && MVNForumConfig.isRequireRegisterBirthday() &&
        (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberBirthday())) ) { %>
  if (isBlank(document.submitform.MemberBirthday, "<fmt:message key="mvnforum.common.member.birthday"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowGender() && MVNForumConfig.isRequireRegisterGender() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberGender())) ) {%>
  if (document.submitform.MemberGender.value == -1) {
    alert("<fmt:message key="mvnforum.common.member.gender"/> <fmt:message key="mvnforum.common.js.prompt.fieldrequired"/>"); 
    return false;
  }
<%}%>
  
<%if ( MVNForumConfig.getEnableShowAddress() && MVNForumConfig.isRequireRegisterAddress() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberAddress())) ) {%>
    if (isBlank(document.submitform.MemberAddress, "<fmt:message key="mvnforum.common.member.address"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowCity() && MVNForumConfig.isRequireRegisterCity() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCity())) ) {%>
    if (isBlank(document.submitform.MemberCity, "<fmt:message key="mvnforum.common.member.city"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowState() && MVNForumConfig.isRequireRegisterState() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberState())) ) {%>
    if (isBlank(document.submitform.MemberState, "<fmt:message key="mvnforum.common.member.state"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowCountry() && MVNForumConfig.isRequireRegisterCountry() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCountry())) ) {%>
    if (isBlank(document.submitform.MemberCountry, "<fmt:message key="mvnforum.common.member.country"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowPhone() && MVNForumConfig.isRequireRegisterPhone() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberPhone())) ) {%>
    if (isBlank(document.submitform.MemberPhone, "<fmt:message key="mvnforum.common.member.phone"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowMobile() && MVNForumConfig.isRequireRegisterMobile() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberMobile())) ) {%>
    if (isBlank(document.submitform.MemberMobile, "<fmt:message key="mvnforum.common.member.mobile"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowFax() && MVNForumConfig.isRequireRegisterFax() &&
        (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberFax())) ) {%>
    if (isBlank(document.submitform.MemberFax, "<fmt:message key="mvnforum.common.member.fax"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowCareer() && MVNForumConfig.isRequireRegisterCareer() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCareer())) ) {%>
    if (isBlank(document.submitform.MemberCareer, "<fmt:message key="mvnforum.common.member.career"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowHomepage() && MVNForumConfig.isRequireRegisterHomepage() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberHomepage())) ) {%>
    if (isBlank(document.submitform.MemberHomepage, "<fmt:message key="mvnforum.common.member.homepage"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowYahoo() && MVNForumConfig.isRequireRegisterYahoo() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberYahoo())) ) {%>
    if (isBlank(document.submitform.MemberYahoo, "<fmt:message key="mvnforum.common.member.yahoo"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowAOL() && MVNForumConfig.isRequireRegisterAol() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberAol())) ) {%>
    if (isBlank(document.submitform.MemberAol, "<fmt:message key="mvnforum.common.member.aol"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowICQ() && MVNForumConfig.isRequireRegisterIcq() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberIcq())) ) {%>
    if (isBlank(document.submitform.MemberIcq, "<fmt:message key="mvnforum.common.member.icq"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowMSN() && MVNForumConfig.isRequireRegisterMsn() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberMsn())) ) {%>
    if (isBlank(document.submitform.MemberMsn, "<fmt:message key="mvnforum.common.member.msn"/>")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowCoolLink1() && MVNForumConfig.isRequireRegisterLink1() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCoolLink1())) ) {%>
    if (isBlank(document.submitform.MemberCoolLink1, "<fmt:message key="mvnforum.common.member.cool_link"/> 1")) return false;
<%}%>

<%if ( MVNForumConfig.getEnableShowCoolLink2() && MVNForumConfig.isRequireRegisterLink2() &&
       (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCoolLink2())) ) {%>
    if (isBlank(document.submitform.MemberCoolLink2, "<fmt:message key="mvnforum.common.member.cool_link"/> 2")) return false;
<%}%>
  
  return true;
}
//]]>
</script>
<%@ include file="header.jsp"%>
<br/>

<table width="95%" align="center">
  <tr class="nav">
    <td><img src="<%=contextPath%>/mvnplugin/mvnforum/images/nav.gif" alt=""/></td>
    <td width="100%" nowrap="nowrap">
    <a class="nav" href="<%=urlResolver.encodeURL(request, response, "index")%>"><fmt:message key="mvnforum.common.nav.index"/></a>&nbsp;&raquo;&nbsp;
    <a class="nav" href="<%=urlResolver.encodeURL(request, response, "myprofile")%>"><fmt:message key="mvnforum.user.header.my_profile"/></a>&nbsp;&raquo;&nbsp;
    <fmt:message key="mvnforum.user.editmember.title"/>
    </td>
  </tr>
</table>
<br/>

<div align="center" class="portlet-font">
<fmt:message key="mvnforum.user.editmember.login_as"/> <span class="messageTextBoldRed"><%=memberName%></span>.
<% if ((isServlet) || (MVNForumConfig.getRedirectLogoutURL().equals(MVNForumConfig.DEFAULT) == false)) {%>
  <fmt:message key="mvnforum.user.editmember.if_not"/> <span class="messageTextBoldRed"><%=memberName%></span>, <fmt:message key="mvnforum.user.editmember.click_here"/> <a href="<%=urlResolver.encodeURL(request, response, "logout", URLResolverService.ACTION_URL)%>" class="command"><fmt:message key="mvnforum.common.action.logout"/></a>
<%}%>
</div>

<form action="<%=urlResolver.encodeURL(request, response, "updatemember", URLResolverService.ACTION_URL)%>" method="post" name="submitform">
<%=urlResolver.generateFormAction(request, response, "updatemember")%>
<table class="tborder" width="95%" cellspacing="0" cellpadding="3" align="center">
<mvn:cssrows>
  <tr class="portlet-section-header">
    <td colspan="2"><fmt:message key="mvnforum.user.editmember.prompt"/></td>
  </tr>
<% if (MVNForumConfig.getEnableShowFirstName()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberFirstname())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterFirstname()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.first_name"/></td>
    <td><input type="text" size="60" name="MemberFirstname" value="<%=memberBean.getMemberFirstname()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowLastName()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberLastname())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterLastname()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.last_name"/></td>
    <td><input type="text" size="60" name="MemberLastname" value="<%=memberBean.getMemberLastname()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowBirthday()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberBirthday())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterBirthday()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.birthday"/> (dd/mm/yyyy)</td>
    <td><input type="text" size="60" name="MemberBirthday" value="<%=DateUtil.getDateDDMMYYYY(memberBean.getMemberBirthday())%>"/>
    <%--
    minhnn: if use this, need a way to set the correct current value
    <select name="MemberBirthdayDate" size="1">
      <%for (int i=1;i<32;i++) {%>
       <option><%=i%></option>
       <%}%>
    </select>
    <select name="MemberBirthdayMonth" size="1">
      <%for (int i=1;i<13;i++) {%>
       <option><%=i%></option>
       <%}%>
    </select>
    <input type="text" name = "MemberBirthdayYear" size=4/>
    --%>
    </td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowGender()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberGender())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterGender()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.gender"/></td>
    <td>
      <select name="MemberGender" size="1">
        <option value="-1"></option>
        <option value="1"<%if (memberBean.getMemberGender() == 1) {%> selected="selected"<%}%>><fmt:message key="mvnforum.common.member.male"/></option>
        <option value="0"<%if (memberBean.getMemberGender() == 0) {%> selected="selected"<%}%>><fmt:message key="mvnforum.common.member.female"/></option>
      </select>
    </td>
  </tr>
  <%} %>  
<% } %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberEmailVisible())) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.show_email"/></td>
    <td>
      <input type="checkbox" name="MemberEmailVisible" value="yes" class="noborder"
      <%if (memberBean.getMemberEmailVisible() == MemberBean.MEMBER_EMAIL_VISIBLE) {%> checked="checked"<%}%>
      />
    </td>
  </tr>
  <%} %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberNameVisible())) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.name_visible"/></td>
    <td>
      <input type="checkbox" name="MemberNameVisible" value="yes" class="noborder"
      <%if (MVNForumConfig.getEnableInvisibleUsers()==false) {%> checked="checked" disabled="disabled"
      <%} else if (memberBean.getMemberNameVisible() == MemberBean.MEMBER_NAME_VISIBLE) {%> checked="checked"
      <%}%>
      />
    </td>
  </tr>
  <%} %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberPostsPerPage())) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.posts_per_page"/></td>
    <td>
      <select name="MemberPostsPerPage">
      <%
      int postPageArray[] = {5, 10, 15, 20, 30, 50};
      for (int i=0; i<postPageArray.length; i++) { %>
        <option value="<%=postPageArray[i]%>"<%if (postPageArray[i]==memberBean.getMemberPostsPerPage()) {%> selected="selected"<%}%>>
          <%=postPageArray[i]%>
        </option>
      <% }//for %>
      </select>
    </td>
  </tr>
  <%} %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberLanguage())) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.language"/></td>
    <td>
      <select name="MemberLanguage" size="1">
        <option value=""><fmt:message key="mvnforum.common.member.default_language"/></option>
        <%
        Locale[] locales = MVNForumConfig.getSupportedLocales();
        for (int i = 0; i < locales.length; i++) {
          Locale locale = locales[i]; 
        %>
          <option value="<%=locale.toString()%>"<%if (memberBean.getMemberLanguage().equals(locale.toString())) {%> selected="selected"<%}%>>
            <%=locale.getDisplayName(locale)%>
          </option>
        <%}%>
      </select>
    </td>
  </tr>
  <%} %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberTimeZone())) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.time_zone"/></td>
    <td>
<%
double selectedTimeZone = memberBean.getMemberTimeZone();
String timeZoneSelectName = "MemberTimeZone";
%>
<%@ include file="inc_timezone_option.jsp"%>
    </td>
  </tr>
  <%} %>
  <%-- 
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.skin"/></td>
    <td><input type="text" size="60" name="MemberSkin" readonly value="<%=memberBean.getMemberSkin()%>"/></td>
  </tr>
  --%>
  <%--
  <%if (externalUserDatabase && MemberMapping.isExternalField("MemberOption") == false) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.member_option"/></td>
    <td><input type="text" size="60" name="MemberOption" readonly value="<%=memberBean.getMemberOption()%>"/></td>
  </tr>
  <%} %>
  <%if (externalUserDatabase && MemberMapping.isExternalField("MemberMessageOption") == false) {%>
  <tr class="<mvn:cssrow/>">
    <td><fmt:message key="mvnforum.common.member.private_option"/></td>
    <td><input type="text" size="60" name="MemberMessageOption" readonly value="<%=memberBean.getMemberMessageOption()%>"/></td>
  </tr>
  <%} %>
  --%>
<% if (MVNForumConfig.getEnableShowAddress()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberAddress())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterAddress()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.address"/></td>
    <td><input type="text" size="60" name="MemberAddress" value="<%=memberBean.getMemberAddress()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowCity()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCity())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterCity()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.city"/></td>
    <td><input type="text" size="60" name="MemberCity" value="<%=memberBean.getMemberCity()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowState()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberState())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterState()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.state"/></td>
    <td><input type="text" size="60" name="MemberState" value="<%=memberBean.getMemberState()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowCountry()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCountry())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterCountry()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.country"/></td>
    <td><input type="text" size="60" name="MemberCountry" value="<%=memberBean.getMemberCountry()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowPhone()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberPhone())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterPhone()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.phone"/></td>
    <td><input type="text" size="60" name="MemberPhone" value="<%=memberBean.getMemberPhone()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowMobile()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberMobile())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterMobile()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.mobile"/></td>
    <td><input type="text" size="60" name="MemberMobile" value="<%=memberBean.getMemberMobile()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowFax()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberFax())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterFax()) { %><span class="requiredfield">*</span><% } %><fmt:message key="mvnforum.common.member.fax"/></td>
    <td><input type="text" size="60" name="MemberFax" value="<%=memberBean.getMemberFax()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowCareer()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCareer())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterCareer()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.career"/></td>
    <td><input type="text" size="60" name="MemberCareer" value="<%=memberBean.getMemberCareer()%>" onkeyup="initTyper(this);"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowHomepage()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberHomepage())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterHomepage()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.homepage"/></td>
    <td><input type="text" size="60" name="MemberHomepage" value="<%=memberBean.getMemberHomepage()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowCoolLink1()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCoolLink1())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterLink1()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.cool_link"/> 1</td>
    <td><input type="text" size="60" name="MemberCoolLink1" value="<%=memberBean.getMemberCoolLink1()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowCoolLink2()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberCoolLink2())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterLink2()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.cool_link"/> 2</td>
    <td><input type="text" size="60" name="MemberCoolLink2" value="<%=memberBean.getMemberCoolLink2()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowYahoo()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberYahoo())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterYahoo()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.yahoo"/></td>
    <td><input type="text" size="60" name="MemberYahoo" value="<%=memberBean.getMemberYahoo()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowAOL()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberAol())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterAol()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.aol"/></td>
    <td><input type="text" size="60" name="MemberAol" value="<%=memberBean.getMemberAol()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowICQ()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberIcq())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterIcq()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.icq"/></td>
    <td><input type="text" size="60" name="MemberIcq" value="<%=memberBean.getMemberIcq()%>"/></td>
  </tr>
  <%} %>
<% } %>
<% if (MVNForumConfig.getEnableShowMSN()) { %>
  <%if (internalUserDatabase || MemberMapping.isLocalField(mapping.getMemberMsn())) {%>
  <tr class="<mvn:cssrow/>">
    <td><% if (MVNForumConfig.isRequireRegisterMsn()) { %><span class="requiredfield">*</span><% } %> <fmt:message key="mvnforum.common.member.msn"/></td>
    <td><input type="text" size="60" name="MemberMsn" value="<%=memberBean.getMemberMsn()%>"/></td>
  </tr>
  <%} %>
<% } %>
<%if (currentLocale.equals("vi")) {/*vietnamese here*/%>
  <tr class="<mvn:cssrow/>">
    <td valign="top" nowrap="nowrap"><fmt:message key="mvnforum.common.vietnamese_type"/>:</td>
    <td>
      <input type="radio" name="vnselector" id="TELEX" value="TELEX" onclick="setTypingMode(1);" class="noborder"/> <fmt:message key="mvnforum.common.vietnamese_type.telex"/>&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="radio" name="vnselector" id="VNI" value="VNI" onclick="setTypingMode(2);" class="noborder"/> <fmt:message key="mvnforum.common.vietnamese_type.vni"/>&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="radio" name="vnselector" id="VIQR" value="VIQR" onclick="setTypingMode(3);" class="noborder"/> <fmt:message key="mvnforum.common.vietnamese_type.VIQR"/><br/>
      <input type="radio" name="vnselector" id="NOVN" value="NOVN" onclick="setTypingMode(0);" class="noborder"/> <fmt:message key="mvnforum.common.vietnamese_type.not_use"/>
      <script type="text/javascript" language="JavaScript">
      //<![CDATA[
      initVNTyperMode();
      //]]>
      </script>
    </td>
  </tr>
<%}// end if vietnamese%>
  <tr class="portlet-section-footer">
    <td colspan="2" align="center">
      <input type="button" name="submitbutton" value="<fmt:message key="mvnforum.common.action.save"/>" onclick="javascript:SubmitForm();" class="portlet-form-button"/>
      <input type="reset" value="<fmt:message key="mvnforum.common.action.reset"/>" class="liteoption"/>
    </td>
  </tr>
</mvn:cssrows>
</table>
</form>

<br/>
<%@ include file="footer.jsp"%>
</mvn:body>
</mvn:html>
</fmt:bundle>

