<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../include/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">欢迎注册!</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="${pageContext.request.contextPath }/user/register" method="post"
                          onsubmit="onsubmitFn()" id="defaultForm">
                        <fieldset>

                            <div class="form-group">
                                <input class="form-control" value="${data.userName}" placeholder="昵称/登录名"
                                       name="userName" type="text" autofocus>
                            </div>


                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="密码" name="password" value=""/>
                            </div>
                            <div class="form-group">
                                <input type="password" name="repeatPassword" class="form-control" placeholder="确认密码"
                                       id="repeatPassword"
                                       value=""/>
                            </div>

                            <div class="form-group">
                                <button type="submit" id="validateBtn" class="btn btn-lg btn-success btn-block">注册
                                </button>
                            </div>
                        </fieldset>
                    </form>
                    <div style="color: red">
                        ${msg}
                    </div>
                </div>
            </div>
        </div>
    </div>
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
                userName: {
                    validators: {
                        notEmpty: {
                            message: '请填写用户名'
                        },
                        remote: {
                            type: 'GET',
                            url: '${pageContext.request.contextPath }/user/validate',
                            message: '用户名已存在',
                            delay: 500
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: '请填写密码'
                        },
                        stringLength: {
                            min: 6,
                            message: '密码不少于6位'
                        }
                    }
                },
                repeatPassword: {
                    validators: {
                        notEmpty: {
                            message: '请填写确认密码'
                        },
                        identical: {
                            field: 'password',
                            message: '确认密码与密码不一致'
                        },
                    }
                }
            }
        })
        ;
    });

    /*
     * 当点击了确定下单的按钮后调用此方法
     * 然后执行表单校验
     * */

    function onsubmitFn() {
        var bootstrapValidator = $("#defaultForm").data('bootstrapValidator');
        bootstrapValidator.validate();
        return bootstrapValidator.validate();
    }
</script>