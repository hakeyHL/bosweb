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
        <input type="hidden" name="updatetime" value="${order.show}">
        <input type="hidden" name="userid" value="${order.userid}">
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
            <label class="col-sm-3 control-label">快递员：</label>

            <div class="col-sm-7">
                <select id="typeSelect" class="form-control" name="courierid">
                    <option
                            selected value="${order.courierid}">${order.courierName}
                    </option>
                    <%--循环展示--%>
                    <c:forEach items="${allCouriers}" var="item">
                        <option
                                value="${item.id}">${item.name}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label">运输车辆：</label>

            <div class="col-sm-7">
                <select id="carSelected" class="form-control" name="carnumber">
                    <option
                            selected value="${order.carnumber}">${order.vehicleNumber}
                    </option>
                    <%--循环展示--%>
                    <c:forEach items="${allCars}" var="item">
                        <option
                                value="${item.id}">${item.number}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">是否取消：</label>

            <div class="col-sm-7">
                <select id="showSelected" class="form-control" name="show">
                    <option
                            value="0" <c:if test="${order.show==0}">selected</c:if>>已取消
                    </option>
                    <option
                            value="1" <c:if test="${order.show==1}">selected</c:if>>未取消
                    </option>

                </select>
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
