<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<%
    final String queryString = request.getQueryString();
    final String url = request.getContextPath() + "/layout/showIndex";
    response.sendRedirect(response.encodeURL(url));
    String contextPath = request.getContextPath();
%>

<jsp:include page="include/header.jsp"/>
<div id="page-wrapper">
    <div class="row" style="margin: 5px; font-size: 12px">
        <span>首页下单</span>
    </div>
</div>