<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>后台登录</title>
    <%@include file="common/head.jsp" %>
    <link href="${staticPath}/images/src/bootstrap.min.css" rel="stylesheet">
    <link href="${staticPath}/images/src/materialdesignicons.min.css" rel="stylesheet">
    <link href="${staticPath}/images/src/style.min.css" rel="stylesheet">
    <style>
        .lyear-wrapper {
            position: relative;
        }

        .lyear-login {
            display: flex !important;
            min-height: 100vh;
            align-items: center !important;
            justify-content: center !important;
        }

        .login-center {
            background: #666;
            min-width: 38.25rem;
            padding: 2.14286em 3.57143em;
            border-radius: 5px;
            margin: 2.85714em 0;
        }

        .login-header {
            margin-bottom: 1.5rem !important;
        }

        .login-center .has-feedback.feedback-left .form-control {
            padding-left: 38px;
            padding-right: 12px;
        }

        .login-center .has-feedback.feedback-left .form-control-feedback {
            left: 0;
            right: auto;
            width: 38px;
            height: 38px;
            line-height: 38px;
            z-index: 4;
            color: #dcdcdc;
        }

        .login-center .has-feedback.feedback-left.row .form-control-feedback {
            left: 15px;
        }
    </style>

</head>
<script type="text/javascript">

    <c:if test="${sessionScope.user!=null}">
    window.location.href = "${contextPath}/main.jsp";
    </c:if>

    function login() {
        var loginname = $("#loginname").length > 0 ? $('#loginname').val().trim():null;
        var loginpw = $('#loginpw').length > 0 ? $('#loginpw').val().trim():null;
        var captcha = $('#captcha').length > 0 ? $('#captcha').val().trim():null;
        var type = $('#type').length > 0 ? $('#type').val().trim():null;
        if ($("#loginname").length > 0 && loginname == "") {
            alert("请输入用户名");
            $('#loginname').focus();
            return false;
        }
        if ($("#loginpw").length > 0 && loginpw == "") {
            alert("请输入密码");
            $('#loginpw').focus();
            return false;
        }
        if ($("#captcha").length > 0 && captcha == "") {
            alert("请输入验证码");
            $('#captcha').focus();
            return false;
        }

        var param = {
            loginname: loginname,
            loginpw: loginpw,
            type: type,
            captcha: captcha
        };
        $.ajax({
            type: 'post',
            url: '${basePath}/login',
            data: param,
            dataType: "json",
            success: function (resp) {
                if (resp.success) {
                    alert("登录成功！");
                    window.location.href = "${contextPath}/main.jsp";
                } else {
                    alert(resp.message);
                }
            }
        });
    }

    function loadimage() {
        document.getElementById("randImage").src = "${contextPath}/captcha?" + Math.random();
    }

</script>
<body>
<div class="row lyear-wrapper">
    <div class="lyear-login">
        <div class="login-center">
            <div class="login-header text-center">
                <a href=""> <%--<img alt="light year admin" src="images/src/logo-sidebar.png">--%> 后台登录 </a>
            </div>
            <form name="form1" method="post" action="">
                <div class="form-group has-feedback feedback-left">
                    <input type="text" placeholder="请输入您的用户名" class="form-control" name="loginname" id="loginname"/>
                    <span class="mdi mdi-account form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left">
                    <input type="password" placeholder="请输入密码" class="form-control" id="loginpw" name="loginpw"/>
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left">
                    <select name="type" id="type" class="form-control">
                        <option value="0">管理员</option>
                        <option value="1">老师</option>

                        <option value="2">用户</option>

                    </select>
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left row">
                    <div class="col-xs-7">
                        <input type="text" name="captcha" class="form-control" placeholder="验证码" id="captcha">
                        <span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>
                    </div>
                    <div class="col-xs-5" style="height:38px;">

                        <a href="javascript:loadimage();"><img alt="看不清请点我！" name="randImage" id="randImage"
                                                               src="${contextPath}/captcha" class="code"
                                                               style="width:100%;height:100%; color:#00F; font-size:24px; background-color:#FC6; cursor:pointer"
                                                               align="center"> </a>
                    </div>
                </div>
                <div class="form-group">
                    <input type="button" class="btn btn-block btn-primary" name="Submit" value="登录"
                           onClick="login();">

                </div>
            </form>


            <hr>
            <footer class="col-sm-12 text-center">
                <p class="m-b-0">Copyright @ <a>xxxxxx</a>. All right reserved</p>
            </footer>
        </div>
    </div>
</div>


</body>
</html>
