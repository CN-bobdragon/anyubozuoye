<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>头部</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <link rel="stylesheet" type="text/css" href="${staticPath}/images/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${staticPath}/images/common.css"/>
</head>


<body>
<div class="head clearfix">
    <div class="logo">
        <table border="0">
            <tr>
                <td><a href=""><%--<img src="images/logo1.png" alt="logo图片" width="87"/>--%></a></td>
                <td><font color=white style="font-size:22px; ">${sessionScope.user.typename}中心</font></td>
            </tr>
        </table>
    </div>
    <div style="font-size:16px;float:right;margin-right:30px; color:#FFFFFF">
        当前用户：${sessionScope.user.loginname} 权限：${sessionScope.user.typename}&nbsp;|
        <a href="logout.jsp" target="_parent" style="color:#FFF">退出</a>&nbsp;|
        <a href="default.jsp" target="_parent" style="color:#FFF">首页</a>
    </div>
</div>
</body>

</html>

