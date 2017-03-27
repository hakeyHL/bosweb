<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    String contextPath = request.getContextPath();
%>

<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../../include/left.jsp"/>


<div id="page-wrapper">

    <div class="col-lg-12" style="margin: 20px"></div>
    <form class="form-horizontal" action="<%=contextPath%>/courier/update" id="form_edit"
          method="post">

        <input type="hidden" name="id" value="${courier.id}">
        <div class="form-group">
            <label class="col-sm-3 control-label">姓名：</label>

            <div class="col-sm-7">
                <input type="text" name="name" class="form-control" value="${courier.name}" placeholder="快递员姓名">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">负责的区域：</label>

            <div class="col-sm-7">
                <input type="text" name="region" class="form-control" value="${courier.region}" placeholder="负责的区域">
            </div>
        </div>

        <label class="col-sm-3 control-label">所有订单：</label>

        <div class="form-group">
            <div class="row">
                <div class="col-lg-12">
                    <table class="table table-bordered table-hover table-condensed" style="font-size:12px;">
                        <thead>
                        <tr>
                            <td>创建时间</td>
                            <td>发件人</td>
                            <td>收件人</td>
                            <td>收件地址</td>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orders}" var="data">
                            <tr>
                                <td><fmt:formatDate value="${data.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td>${data.sender}</td>
                                <td>${data.receiver}</td>
                                <td>${data.receiveraddress}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-default" id="button_submit">确定</button>
            </div>
        </div>

    </form>


</div>
