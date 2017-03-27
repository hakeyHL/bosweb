<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    String contextPath = request.getContextPath();
%>

<jsp:include page="../../include/header.jsp"/>
<jsp:include page="../../include/left.jsp"/>
<%--车辆列表页面--%>
<div id="page-wrapper">
    <!-- 删除结果提示 -->
    <div class="alert alert-success" id="delete_success" role="alert" style="display: none">删除成功</div>
    <div class="alert alert-warning" id="delete_fail" role="alert" style="display: none">删除失败</div>

    <div class="col-lg-12" style="margin: 10px"></div>
    <div class="row" style="margin: 5px; font-size: 12px">
        <%--手动添加车辆事件,此时传的id是-1,是复用了车辆详情接口--%>
        <span>添加车辆: <a href="<%=contextPath%>/car/info/-1">手动添加车辆(create car)</a></span>
    </div>
    <div class="col-lg-8">
        <div name="appType" class="input-group">
            <span class="input-group-addon">车辆查询</span>

            <form id="reListDealByType" action="/car/list" method="get">
                <div class="col-lg-4">
                    <span class="input-group-addon">brand(品牌)</span>
                    <input type="text" name="brand" class="form-control" placeholder="Brand"
                           value="${car.brand}">
                </div>

                <div class="col-lg-4">
                    <span class="input-group-addon">model(型号)</span>
                    <input type="text" name="model" class="form-control" placeholder="Model"
                           value="${car.model}">
                </div>

                <div class="col-lg-4">
                    <span class="input-group-addon">carNumber(车牌号)</span>
                    <input type="text" name="number" class="form-control" placeholder="Number"
                           value="${car.number}">
                </div>


                <div class="col-lg-2">
                    <button type="submit" class="btn btn-primary">查询</button>
                </div>
            </form>
        </div>
    </div>

    <!-- 信息删除确认 -->
    <div class="modal fade" id="deleteModel">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title">提示信息</h4>
                </div>
                <div class="modal-body">
                    <p>您确认要删除吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="url"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a onclick="urlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
                </div>
            </div>
        </div>
    </div>

    <!-- 批量删除确认 -->
    <div class="modal fade" id="batchDeleteModel">
        <div class="modal-dialog">
            <div class="modal-content message_align">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">×</span></button>
                    <h4 class="modal-title">提示信息</h4>
                </div>
                <div class="modal-body">
                    <p>您确认要删除选中记录吗？</p>
                </div>
                <div class="modal-footer">
                    <input type="hidden" id="batchUrl"/>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <a onclick="batchUrlSubmit()" class="btn btn-success" data-dismiss="modal">确定</a>
                </div>
            </div>
        </div>
    </div>


    <div class="col-lg-12" style="margin: 5px"></div>


    <div class="col-lg-12" style="margin: 10px"></div>

    <div class="row">
        <div class="col-lg-12">
            <%--批量删除车辆--%>
            <button type="button" class="btn btn-primary" onclick="batchDelete('<%=contextPath%>/car/batchDelete')"
                    data-toggle="modal" data-target="#confirm-delete">批量删除
            </button>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <table class="table table-bordered table-hover table-condensed" style="font-size:12px;">
                <thead>
                <tr>
                    <td><input type="checkbox" id="checkAll"/>选择</td>
                    <td>ID</td>
                    <td>Brand</td>
                    <td>Model</td>
                    <td>Number</td>
                    <td colspan="3">操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="data">
                    <tr>
                        <td><input type="checkbox" name="subBox" value="${data.id}"/></td>
                        <td>${data.id}</td>
                        <td>${data.brand}</td>
                        <td>${data.model}</td>
                        <td>${data.number}</td>
                            <%--调用车辆详情接口跳转到车辆编辑页面--%>
                        <td><a href="info/${data.id}">编辑</a></td>
                        <td><a href="javascript:void(0)"
                            <%--删除车辆--%>
                               onclick="deleteById('<%=contextPath%>/car/del/${data.id}')"
                               data-toggle="modal" data-target="#confirm-delete">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <script>
        function deleteById(url) {
            $('#url').val(url);//给会话中的隐藏属性URL赋值

            //显示删除确认窗口
            $('#deleteModel').modal();
        }

        function urlSubmit() {
            /*删除车辆*/
            var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
            $.ajax({
                url: url,
                type: 'GET',
                /*删除成功*/
                success: function (result) {
                    if (result) {
                        $("#delete_success").css("display", "block").hide(3000);
                        window.location.reload();
                    }
                },
                //删除失败
                error: function (xhr, textStatus, errorThrown) {
                    $("#delete_fail").css("display", "block").hide(3000);
                }
            });
        }

        /*批量删除js*/
        function batchDelete(batchUrl) {

            var arr = new Array();
            /*获取已选择的车辆的id列表放入集合中*/
            $("input[name='subBox']:checked").each(function () {
                arr.push($(this).val());
            });

            if (arr.length == 0) {
                BootstrapDialog.show({
                    title: '提示',
                    message: '请选择要删除的记录!'
                });

                return false;
            }

            $('#batchUrl').val(batchUrl);//给会话中的隐藏属性URL赋值
            $('#batchDeleteModel').modal();
        }

        /*执行批量删除操作*/
        function batchUrlSubmit() {
            var url = $.trim($("#batchUrl").val());//获取会话中的隐藏属性URL

            var arr = new Array();
            $("input[name='subBox']:checked").each(function () {
                arr.push($(this).val());
            });

            $.ajax({
                url: url,
                type: 'GET',
                data: {"ids": arr},
                dataType: "json",
                contentType: 'application/json;charset=utf-8', //设置请求头信息
                success: function (result) {
                    if (result) {
                        $("#delete_success").css("display", "block").hide(3000);
                        window.location.reload();
                    }
                },
                error: function (xhr, textStatus, errorThrown) {
                    $("#delete_fail").css("display", "block").hide(3000);
                }
            });
        }
    </script>
</div>