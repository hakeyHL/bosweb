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
    <!-- 删除结果提示 -->
    <div class="alert alert-success" id="delete_success" role="alert" style="display: none">删除成功</div>
    <div class="alert alert-warning" id="delete_fail" role="alert" style="display: none">删除失败</div>

    <div class="col-lg-12" style="margin: 10px"></div>
    <div class="row" style="margin: 5px; font-size: 12px">
        <span>添加快递员: <a href="<%=contextPath%>/courier/info/-1">手动添加快递员(create Courier)</a></span>
    </div>
    <div class="col-lg-8">
        <div name="appType" class="input-group">
            <span class="input-group-addon">快递员查询</span>

            <form id="reListDealByType" action="/courier/list" method="get">
                <div class="col-lg-4">
                    <span class="input-group-addon">快递员姓名</span>
                    <input type="text" name="name" class="form-control" placeholder="Search"
                           value="${courier.name}">
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
            <button type="button" class="btn btn-primary" onclick="batchDelete('<%=contextPath%>/courier/batchDelete')"
                    data-toggle="modal" data-target="#confirm-delete">批量删除
            </button>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <table class="table table-bordered table-hover table-condensed" style="font-size:12px;">
                <thead>
                <tr>
                    <td><input type="checkbox" id="checkAll"/>全选</td>
                    <td>ID</td>
                    <td>姓名</td>
                    <td>region区域</td>
                    <td colspan="3">操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${couriers}" var="data">
                    <tr>
                        <td><input type="checkbox" name="subBox" value="${data.id}"/></td>
                        <td>${data.id}</td>
                        <td>${data.name}</td>
                        <td>${data.region}</td>
                        <td><a href="info/${data.id}">编辑</a></td>
                        <td><a href="javascript:void(0)"
                               onclick="deleteById('<%=contextPath%>/courier/del/${data.id}')"
                               data-toggle="modal" data-target="#confirm-delete">删除</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--page--%>
    </div>

    <script>
        function deleteById(url) {
            $('#url').val(url);//给会话中的隐藏属性URL赋值
            $('#deleteModel').modal();
        }

        function urlSubmit() {
            var url = $.trim($("#url").val());//获取会话中的隐藏属性URL
            $.ajax({
                url: url,
                type: 'GET',
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

        function batchDelete(batchUrl) {

            var arr = new Array();
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