<%--
 - $Header: /cvsroot/mvnforum/mvnforum/srcweb/mvnplugin/mvnforum/user/header.jsp,v 1.185 2008/06/13 09:23:22 phuongpdd Exp $
 - $Author: phuongpdd $
 - $Revision: 1.185 $
 - $Date: 2008/06/13 09:23:22 $
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
<%@ include file="inc_js_checkvalid_myvietnamlib.jsp"%>

<fmt:bundle basename="mvnForum_i18n">
<script type="text/javascript">
//<![CDATA[
function SubmitFormSearch() {
  if (ValidateFormSearch()) {
    // uncomment when we find a way to enable the button
    //document.submitformsearch.submitbutton.disabled = true;
    document.submitformsearch.submit();
  }
}

function ValidateFormSearch() {
  if (isBlank(document.submitformsearch.key, "<fmt:message key="mvnforum.common.action.search"/>")) return false;
  return true;
}
//]]>
</script>
<table width="95%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td height="60">
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td rowspan="2">
            <a href="<%=MVNForumConfig.getLogoUrl()%>"><img src="<%=onlineUser.getLogoPath()%>" height="50" border="0" alt="<fmt:message key="mvnforum.common.forum.homepage"/>" title="<fmt:message key="mvnforum.common.forum.homepage"/>"/></a>
          </td>
          <td rowspan="2" align="center" valign="top">
            <%@ include file="adheart.jsp"%>
          </td>
          <td width="100%" height="25" align="right" valign="top" nowrap="nowrap" class="portlet-font">
            <span class="welcomeHeader"><fmt:message key="mvnforum.user.header.welcome"/></span>
            <%if (onlineUser.isMember()) {%>
              <font color="#FF0000"><%=memberName%></font>
              <%int newMessageCount = onlineUser.getNewMessageCount();
                if (newMessageCount > 0) { %>
                (<a href="<%=urlResolver.encodeURL(request, response, "mymessage")%>"><%=onlineUser.getNewMessageCount()%> <fmt:message key="mvnforum.common.message.header.new_private_message"/></a>)
              <%}%>
              <% if (onlineUser.getAuthenticationType() == OnlineUser.AUTHENTICATION_TYPE_COOKIE) { %>(<fmt:message key="mvnforum.user.header.we_remember_you"/>)<% } %>
              <%if (MVNForumConfig.getEnableLogin()) {%>
              &nbsp;|&nbsp;<a class="command" href="<%=urlResolver.encodeURL(request, response, "logout")%>"> <fmt:message key="mvnforum.common.action.logout"/></a>
              <%}%>
              <br/>
              <% if (MVNForumConfig.getEnableShowLastLoginOfCurrentMember()) {%>
                <fmt:message key="mvnforum.common.member.last_login"/>:&nbsp;<%=onlineUser.getGMTTimestampFormat(onlineUser.getLastLogonTimestamp())%>
                <fmt:message key="mvnforum.common.from_ip"/>&nbsp;<%=onlineUser.getLastLogonIP()%>
              <%}%>
            <%} else { 
                if ((memberName!=null) && (memberName.length()>0)) {%>
                  <%=memberName%>
               <%} else {%>
                  <%=MVNForumConfig.getDefaultGuestName()%>
               <%}%>
               <%if (MVNForumConfig.getEnableNewMember() && onlineUser.isGuest()) {%>
               &nbsp;|&nbsp;&nbsp;<a class="command" href="<%=urlResolver.encodeURL(request, response, "registermember")%>"><fmt:message key="mvnforum.user.header.new_user"/></a>
               <%}%>
               <%if (MVNForumConfig.getEnableLogin()) {%>
               &nbsp;|&nbsp;&nbsp;<a class="command" href="<%=urlResolver.encodeURL(request, response, "login")%>"><fmt:message key="mvnforum.common.action.login"/></a>
               <%@ include file="login_meta.jsp"%>
               <%}%>
            <%}%>
          </td>
        </tr>
        <tr>
          <td height="35" valign="top">
          <%if (MVNForumConfig.getEnableSearch()) {%>
            <form action="<%=urlResolver.encodeURL(request, response, "search", URLResolverService.ACTION_URL)%>" id="submitformsearch" name="submitformsearch" <mvn:method/>>
            <%=urlResolver.generateFormAction(request, response, "search")%>
            <table class="tborder" cellspacing="0" cellpadding="2" align="right" style="width: 0%">
              <tr class="topmenu">
                <td align="left" valign="top" nowrap="nowrap">&nbsp;
                <%if (onlineUser.isMember()) {%>
                  <a href="<%=urlResolver.encodeURL(request, response, "myprofile")%>" class="topmenu"><fmt:message key="mvnforum.user.header.my_profile"/></a>
                <%}%>
                <%if (onlineUser.isMember() && MVNForumConfig.getEnablePrivateAlbum() && permission.canUseAlbum()) {%>
                  &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "myalbums")%>" class="topmenu"><fmt:message key="mvnforum.user.listalbumsx.my_albums"/></a>
                <%}%>
                <%if (onlineUser.isMember() && MVNForumConfig.getEnableRequestPrivateForum()) { %>
                  &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "myprivateforums")%>" class="topmenu"><fmt:message key="mvnforum.user.myprivateforumsx.title"/></a>
                <%}%>
                <%if (permission.canModerateThreadInAnyForum()) {%>
                  &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "modcp")%>" class="topmenu"><fmt:message key="mvnforum.user.header.moderation"/></a>
                  &nbsp;|&nbsp;
                <%}%>
                  <a href="<%=urlResolver.encodeURL(request, response, "search")%>" class="topmenu"><img src="<%=contextPath%>/mvnplugin/mvnforum/images/icon/search.gif" alt="<fmt:message key="mvnforum.common.action.search"/>" title="<fmt:message key="mvnforum.common.action.search"/>" hspace="0" vspace="0" border="0" align="bottom"/></a>
                  <input type="text" size="10" name="key"/>
                  <input type="button" name="submitbutton" value="<fmt:message key="mvnforum.common.action.search"/>" onclick="javascript:SubmitFormSearch();" class="portlet-form-button"/>&nbsp;
                </td>
              </tr>
            </table>
            </form>
          <%} else {%>
            <%if (onlineUser.isMember()) {%>
            <table class="tborder" cellspacing="0" cellpadding="2" align="right" style="width: 0%">
              <tr class="topmenu">
                <td align="left" valign="top" nowrap="nowrap">&nbsp;
                  <a href="<%=urlResolver.encodeURL(request, response, "myprofile")%>" class="topmenu"><fmt:message key="mvnforum.user.header.my_profile"/></a>
                <%if (MVNForumConfig.getEnablePrivateAlbum() && permission.canUseAlbum()) {%>
                  &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "myalbums")%>" class="topmenu"><fmt:message key="mvnforum.user.listalbumsx.my_albums"/></a>
                <%}%>
                <%if (MVNForumConfig.getEnableRequestPrivateForum()) { %>
                  &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "myprivateforums")%>" class="topmenu"><fmt:message key="mvnforum.user.myprivateforumsx.title"/></a>
                <%}%>
                <%if (permission.canModerateThreadInAnyForum()) {%>
                  &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "modcp")%>" class="topmenu"><fmt:message key="mvnforum.user.header.moderation"/></a>
                  &nbsp;
                <%}%>
                </td>
              </tr>
            </table>
            <%}%>
          <%}%>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<table class="tborder" width="95%" cellspacing="0" cellpadding="2" align="center">
  <tr class="topmenu">
    <td nowrap="nowrap">&nbsp;
      <a href="<%=urlResolver.encodeURL(request, response, "index")%>" class="topmenu"><fmt:message key="mvnforum.user.header.index"/></a>
      <%--
      <a href="<%=urlResolver.encodeURL(request, response, "listforums")%>" class="topmenu"><fmt:message key="mvnforum.user.header.all_forums"/></a>&nbsp;|&nbsp;
      --%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listrecentthreads")%>" class="topmenu"><fmt:message key="mvnforum.user.header.recent_threads"/></a>
      <%if (MVNForumConfig.getEnableListUnansweredThreads()) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listunansweredthreads")%>" class="topmenu"><fmt:message key="mvnforum.user.header.listunansweredthreads"/></a>
      <% } %>
      <%if (permission.canGetAttachmentInAnyForum()) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listattachments")%>" class="topmenu"><fmt:message key="mvnforum.user.listattachments.title"/></a>
      <% } %>
      <%if (MVNForumConfig.getEnablePoll()) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listpolls")%>" class="topmenu"><fmt:message key="mvnforum.user.listpollsx.title"/></a>
      <% } %>
      <%if (MVNForumConfig.getEnablePublicAlbum()) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listpublicalbums")%>" class="topmenu"><fmt:message key="mvnforum.user.listalbumsx.public_albums"/></a>
      <% } %>
      <%if (MVNForumConfig.getEnableOnlineUsers()) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listonlineusers")%>" class="topmenu"><fmt:message key="mvnforum.user.header.who_online"/></a>
      <% } // if enable online users%>
      <%if (MVNForumConfig.getEnableListMembers()) {
          if (onlineUser.isMember() || (onlineUser.isGuest() && MVNForumConfig.getEnableGuestViewListUsers())) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "listmembers")%>" class="topmenu"><fmt:message key="mvnforum.user.header.user_list"/></a>
      <%  }
        } %>
      <%if (permission.canGetAttachmentInAnyForum() && false) {%>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "searchattachments")%>" class="topmenu"><fmt:message key="mvnforum.user.searchattachments.header"/></a>
      <% } %>
      &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "help")%>" class="topmenu"><fmt:message key="mvnforum.user.header.help"/></a>
      
      <% if (MVNForumConfig.getEnableChat()) {%>
        &nbsp;|&nbsp;<a class="topmenu" href="#" onclick="window.open ('<%=urlResolver.encodeURL(request, response, "pre_lobbymessages")%>', 'alllobbychat','location=1,status=1,scrollbars=1, width=400,height=400 resizable=yes');"> Lobby Messages</a>
        <% if (onlineUser.isMember()) { %>
          &nbsp;|&nbsp;<a href="<%=urlResolver.encodeURL(request, response, "messenger")%>" class="topmenu">Messenger</a>
        <% } %>
      <% } %>
    </td>
  </tr>
</table>
<%if (MVNForumConfig.getShouldShowUserArea() == false) {%>
<br/>
<table class="tborder" width="95%" cellspacing="0" cellpadding="3" align="center">
  <tr class="pagedesc">
    <td align="center" class="warning"><fmt:message key="mvnforum.user.header.turn_off"/></td>
  </tr>
</table>
<%}%>
</fmt:bundle>
<%@ include file="ad.jsp"%>
<%@ include file="news.jsp"%>
