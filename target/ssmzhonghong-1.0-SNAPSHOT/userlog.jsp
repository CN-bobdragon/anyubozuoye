<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class=" portrait">
<head>
    <title>用户登录</title>
    <%@include file="common/head.jsp" %>
    <meta name="apple-touch-fullscreen" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta http-equiv="pragma" content="no-cache">
    <meta name="renderer" content="webkit">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/bootstrap-theme.css">
    <link href="http://www.chinagrandinc.com/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link type="text/css" href="${staticPath}/qtimages/pack.built.2045013b.cache.css" rel="stylesheet" media="all">

    <link type="text/css" href="${staticPath}/qtimages/nav.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/public.css">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/styles.css">
    <!--nav css end-->
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/g_sy_first.css">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/home.css">
    <link rel="stylesheet" href="${staticPath}/qtimages/sl_common_form.css">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body ontouchstart="">
<%@ include file="qttop.jsp" %>


<div class="container">
    <div class="g-firstsection-title_sy">
        <p class="g-firstsection-title_sy_p">用户登录<span><i><%--UserLog--%></i></span></p>
    </div>
</div>
<div class="container">
    <ul class="g-firstsec2-list">
        <div class="content-form">
            <%@ include file="qtuserlog.jsp" %>
        </div>
        <ul>
        </ul>
    </ul>
</div>
<br>
<br>
<%@ include file="qtdown.jsp" %>
</body>
</html>