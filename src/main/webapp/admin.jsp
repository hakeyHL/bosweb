<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<%
    /*
    *请求layout/showIndex
    * 跳转到后台管理首页
    * */
    final String url = request.getContextPath() + "/layout/showIndex";
    /*执行重定向操作*/
    response.sendRedirect(response.encodeURL(url));
%>