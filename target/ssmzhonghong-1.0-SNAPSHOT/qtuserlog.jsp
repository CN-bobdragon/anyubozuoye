<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.user==null}">
<form action="" method="post" name="formlogin" id="formlogin">
    <table width='100%' height='302' border='0' cellpadding='0' cellspacing='0' bgcolor='#FFFFFF' class='newsline'>
        <%--<tr>
            <td height='48' colspan='4' style='padding-left:30px; font-size:20px;'><strong>用户登录</strong></td>
        </tr>--%>
        <tr>
            <td width='40' height='28'>&nbsp;</td>
            <td width='240' height='28'>用户名:</td>
            <td height='28' colspan='2'><input name='loginname' type='text' id='loginname' placeholder='请输入用户名'
                                               class="user"/></td>
        </tr>
        <tr>
            <td height='28'>&nbsp;</td>
            <td height='28'>密码:</td>
            <td height='28' colspan='2'><input name='loginpw' type='password' id='loginpw' placeholder='请输入密码' class="user"/>
            </td>
        </tr>
        <tr>
            <td height='28'>&nbsp;</td>
            <td height='28'>权限:</td>
            <td height='28' colspan='2'><select name='type' id='type' class="user">
                <option value="2">用户</option>

                <option value="0">管理员</option>

            </select></td>
        </tr>
        <tr>
            <td height='28'>&nbsp;</td>
            <td height='28'>验证码:</td>
            <td width='67' height='28'><input name="captcha" type="text" id="captcha" class="password"/></td>
            <td width='653'>
                <a href="javascript:loadimage();">
                    <img alt="看不清请点我！" name="randImage" id="randImage"
                         src="${contextPath}/captcha" width="60" height="20" border="1"
                         align="absmiddle"/></a>
            </td>
        </tr>
        <tr>
            <td height='38' align='center'>&nbsp;</td>
            <td height='38' align='center'>&nbsp;</td>
            <td height='38' colspan='2'>
                <input type='button' name='Submit' value='登录' onclick='login();'
                                               class="content-form-signup"/>
                <input type='reset' name='Submit2' value='重置' class="content-form-signup"/></td>
        </tr>
    </table>
</form>

<script type="text/javascript">
        function login() {
            var fromurl = document.referrer;
            var loginname = $("#loginname").length > 0 ? $('#loginname').val().trim() : null;
            var loginpw = $('#loginpw').length > 0 ? $('#loginpw').val().trim() : null;
            var captcha = $('#captcha').length > 0 ? $('#captcha').val().trim() : null;
            var type = $('#type').length > 0 ? $('#type').val().trim() : null;
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
                        alert("登录成功");
                        window.location.href = "${contextPath}/default.jsp";
                    } else {
                        alert(resp.message);
                        return;
                    }
                }
            });
        }

        function loadimage() {
            document.getElementById("randImage").src = "${contextPath}/captcha?" + Math.random();
        }
    </script>

</c:if>
<c:if test="${sessionScope.user!=null}">

<table width='100%' height='300' border='0' align='center' cellpadding='0' cellspacing='0' bgcolor='#FFFFFF'>
    <tr>
        <td height='28' align='left' style='padding-left:20px; font-size:20px;'>
            当前用户：${sessionScope.user.loginname}
        </td>
    </tr>
    <tr>
        <td height='28' align='left' style='padding-left:20px; font-size:20px;'>
            您的权限：${sessionScope.user.typename}
        </td>
    </tr>
    <tr>
        <td height='28' align='left' style='padding-left:20px; font-size:20px;'>欢迎您的到来!!!</td>
    </tr>
    <tr>
        <td height='28' align='center'><input type='button' name='Submit3' value='退出'
                                              onclick="javascript:location.href='${contextPath}/userlogout.jsp';"
                                              class="content-form-signup"/>
            <input type='button' name='Submit22' value='个人中心' onclick="javascript:location.href='${contextPath}/main.jsp';"
                   class="content-form-signup"/></td>
    </tr>
</table>
</c:if>