<%@ page language="java" pageEncoding="UTF-8" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>网站后台</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <style>
        body {
            scrollbar-base-color: #C0D586;
            scrollbar-arrow-color: #FFFFFF;
            scrollbar-shadow-color: #DEEFC6;
        }
    </style>
</head>
<frameset rows="50,*" cols="*" frameborder="no" border="0" framespacing="0">
    <frame src="top.jsp" name="topFrame" scrolling="no">
    <frameset cols="225,*" name="btFrame" frameborder="NO" border="0" framespacing="0">
        <frame src="mygo.jsp" noresize name="menu" scrolling="yes">
        <frame src="sy.jsp" class="frame_r" noresize name="hsgmain" scrolling="yes">
    </frameset>
</frameset>
<noframes>
    <body>您的浏览器不支持框架！</body>
</noframes>
</html>

