<%--
 - This file could be used to add advertisement to mvnForum
 --%>
<% if ((mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_1) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_2) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_3) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_4) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_5) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_6) > 0) ) {%>
<br />
<mvn:cssrows>  
<table class="tborder-no_need" align="center" cellpadding="3" cellspacing="0" width="95%">
   <tr class="<mvn:cssrow/>">
   <%if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_1) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_1))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_2) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_2))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_3) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_3))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_4) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_4))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_5) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_5))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_6) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_6))%></td>
   <%}%>
   </tr>
</table>
</mvn:cssrows>
<% } %>

<% if ((mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_1) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_2) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_3) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_4) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_5) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_6) > 0) ) {%>
<br />
<mvn:cssrows>   
<table class="tborder-no_need" align="center" cellpadding="3" cellspacing="0" width="95%">
   <tr class="<mvn:cssrow/>">
   <%if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_1) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_1))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_2) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_2))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_3) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_3))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_4) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_4))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_5) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_5))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_6) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_2_POSITION_6))%></td>
   <%}%>
   </tr>
</table>
</mvn:cssrows>
<% } %>

<% if ((mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_1) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_2) > 0) ||
       (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_3) > 0) ) {%>
<br />       
<mvn:cssrows>
<table class="tborder-no_need" align="center" cellpadding="3" cellspacing="0" width="95%">
   <tr class="<mvn:cssrow/>">
   <%if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_1_POSITION_1) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_1))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_2) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_2))%></td>
   <%}
     if (mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_3) > 0) {%>
     <td align="center"><%=mvnForumAdService.getZone(mvnForumAdService.getAdZone(MvnForumAdService.ZONE_NAME_FORUM_HEADER_3_POSITION_3))%></td>
   <%}%>
   </tr>
</table>
</mvn:cssrows>
<br />
<% } %>
