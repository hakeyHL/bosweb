<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="WEB-INF/jsp/views/include/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">请登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="${pageContext.request.contextPath }/user/login" method="post">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" value="${data.userName}" placeholder="用户名"
                                       name="userName" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="密码" name="password" value=""/>
                            </div>
                            <button type="submit" class="btn btn-lg btn-success btn-block">登录</button>
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