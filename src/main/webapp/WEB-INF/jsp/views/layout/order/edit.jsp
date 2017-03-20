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
    <form class="form-horizontal" action="<%=contextPath%>/order/update" id="form_edit"
          method="post" onsubmit="return dosubmit()">

        <input type="hidden" name="id" value="${order.id}">
        <input type="hidden" name="createtime" value="${order.createtime}">
        <input type="hidden" name="updatetime" value="${order.updatetime}">
        <div class="form-group">
            <label class="col-sm-3 control-label">发件人：</label>

            <div class="col-sm-7">
                <input type="text" name="sender" class="form-control" value="${order.sender}" placeholder="发件人姓名">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">发件人号码：</label>

            <div class="col-sm-7">
                <input type="text" name="senderphone" class="form-control" value="${order.senderphone}"
                       placeholder="发件人号码">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">发件人地址：</label>

            <div class="col-sm-7">
                <input type="text" name="senderaddress" class="form-control" value="${order.senderaddress}"
                       placeholder="发件人地址">
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">收件人：</label>

            <div class="col-sm-7">
                <input type="text" name="receiver" class="form-control" value="${order.receiver}" placeholder="收件人姓名">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">收件人号码：</label>

            <div class="col-sm-7">
                <input type="text" name="receiverphone" class="form-control" value="${order.receiverphone}"
                       placeholder="收件人号码">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">收件人地址：</label>

            <div class="col-sm-7">
                <input type="text" name="receiveraddress" class="form-control" value="${order.receiveraddress}"
                       placeholder="收件人地址">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-9">
                <button type="submit" class="btn btn-default" id="button_submit">确定</button>
            </div>
        </div>

    </form>


</div>
<script>
    function dosubmit() {
        return true;
    }

</script>
