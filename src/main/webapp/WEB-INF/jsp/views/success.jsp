<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + contextPath + "/";
%>
<jsp:include page="include/header.jsp"/>
<body>
<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">下单成功</h4>
            </div>
            <div class="modal-body">
                <p>感谢您的光临,祝您生活愉快!</p>
            </div>
            <div class="modal-footer">
                <button type="button" id="ensure" class="btn btn-default" data-dismiss="modal">确定</button>
            </div>
        </div>
    </div>
</div>
</body>

<script type="text/javascript" language="JavaScript">
    $(function () {
        $('#myModal').modal('show');

        $('#ensure').click(function () {
            $(window).attr('location', '<%=basePath%>');
        });
    });
</script>
