<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" session="false" %>
<jsp:include page="include/header.jsp"/>
<%--首页--%>

<div id="page-wrapper">
    <div class="row" style="margin: 5px; font-size: 18px">
        <span>首页下单</span>
    </div>

    <form id="defaultForm" class="form-horizontal" action="${pageContext.request.contextPath }/order/add" method="post">
        <div class="form-group">
            <label for="sender" class="col-sm-2 control-label">发件人</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="sender" id="sender" placeholder="发件人">
            </div>
        </div>
        <div class="form-group">
            <label for="senderphone" class="col-sm-2 control-label">发件人号码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="senderphone" id="senderphone" placeholder="发件人号码">
            </div>
        </div>
        <div class="form-group">
            <label for="senderaddress" class="col-sm-2 control-label">发件人地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="senderaddress" id="senderaddress" placeholder="发件人地址">
            </div>
        </div>

        <div class="form-group">
            <label for="receiver" class="col-sm-2 control-label">收件人</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="receiver" id="receiver" placeholder="收件人地址">
            </div>
        </div>
        <div class="form-group">
            <label for="receiverphone" class="col-sm-2 control-label">收件人号码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="receiverphone" id="receiverphone" placeholder="收件人号码">
            </div>
        </div>
        <div class="form-group">
            <label for="receiveraddress" class="col-sm-2 control-label">收件人地址</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="receiveraddress" id="receiveraddress" placeholder="收件人地址">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary btn-block btn-sm active">下单</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" language="JavaScript">
    /*
     *表单校验
     */
    $(function () {
        $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                sender: {
                    validators: {
                        notEmpty: {
                            message: '请填写您的姓名'
                        }
                    }
                },
                senderphone: {
                    validators: {
                        notEmpty: {
                            message: '您应该填写手机'
                        },
                        stringLength: {
                            min: 11,
                            message: '联系方式应该不少于11位'
                        }
                    }
                },
                senderaddress: {
                    validators: {
                        notEmpty: {
                            message: '请填写您当前的地址'
                        }
                    }
                },
                receiver: {
                    validators: {
                        notEmpty: {
                            message: '请填写收件人姓名'
                        }
                    }
                },
                receiverphone: {
                    validators: {
                        notEmpty: {
                            message: '请填写收件人手机号'
                        },
                        stringLength: {
                            min: 11,
                            message: '联系方式应该不少于11位'
                        }
                    }
                },
                receiveraddress: {
                    validators: {
                        notEmpty: {
                            message: '您要邮寄到哪里?'
                        }
                    }
                }
            }
        });
    });

    /*
     * 当点击了确定下单的按钮后调用此方法
     * 然后执行表单校验
     * */
    $('#validateBtn').click(function () {
        $('#defaultForm').bootstrapValidator('validate');
    });
</script>