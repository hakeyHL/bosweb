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
    <form class="form-horizontal" action="<%=contextPath%>/car/update" id="form_edit"
          method="post" onsubmit="return dosubmit()">

        <input type="hidden" name="id" value="${car.id}">
        <div class="form-group">
            <label class="col-sm-3 control-label">Brand：</label>

            <div class="col-sm-7">
                <input type="text" name="brand" class="form-control" value="${car.brand}" placeholder="车辆品牌">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Model：</label>

            <div class="col-sm-7">
                <input type="text" name="model" class="form-control" value="${car.model}" placeholder="车辆型号">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-3 control-label">Number：</label>

            <div class="col-sm-7">
                <input type="text" name="number" class="form-control" value="${car.number}" placeholder="车辆牌号">
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
