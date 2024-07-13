<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>报名列表</title>
    <%@include file="common/head.jsp" %>
    <script type="text/javascript" src="${staticPath}/js/popup.js"></script>
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/bootstrap-theme.css">
    <link type="text/css" href="${staticPath}/qtimages/pack.built.2045013b.cache.css" rel="stylesheet" media="all">
    <link type="text/css" href="${staticPath}/qtimages/nav.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/public.css">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/styles.css">
    <!--nav css end-->
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/g_sy_first.css">
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/home.css">
    <link rel="stylesheet" href="${staticPath}/qtimages/sl_common_form.css">
</head>
<script type="text/javascript">
    //附件下载
    function down(fujianPath) {
        var url = "${contextPath}/common/download?filename=" + fujianPath;
        url = encodeURI(url);
        window.open(url, "_self");
    }
</script>
<body>

<!--新头部的开始-->
<%@ include file="qttop.jsp" %>
<!--新头部的结束-->
<!--ban图片切换开始-->
<%@ include file="bht.jsp"%>
<!--ban图片切换结束-->
<!--主体内容的开始-->
<div class="container">
    <div class="g-firstsection-title_sy">
        <p class="g-firstsection-title_sy_p">
            报名<span><i></i>
				</span>
        </p>
    </div>
</div>
<div class="container">
    <ul class="g-firstsec2-list">
        <div class="content-form">
            <link rel="stylesheet" href="${staticPath}/images/hsgcommon/divqt.css" type="text/css">
            <form name="formSearch" id="formSearch" method="post" action="${contextPath}/${actionName}">
        活动:
        <select style="border:solid 1px #000000; color:#666666;" name="huodongid" id="huodongid">
            <option value="">全部</option>
            <c:forEach items="${huodongList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.huodongid}">
                        <option value="${s.id}" selected>
                                ${s.mingcheng }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.mingcheng}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;
        申请原因:<input type="text" style='border:solid 1px #000000; color:#666666' name="nerong" id="nerong" size="12px" value="${req.nerong}"/>&nbsp;&nbsp;
<%--        用户:
        <select name="usersid" id="usersid">
            <option value="">全部</option>
            <c:forEach items="${usersList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.usersid}">
                        <option value="${s.id}" selected>
                                ${s.loginname }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.loginname}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;--%>

                <input type="submit" value="查询" class='hsgqiehuanshitu'/>
            </form>
            <br/>
            <table width="100%" border="0" align="center" cellpadding="4"
                   cellspacing="1" bgcolor="#ebf0f7">
                <tr style="height: 32px;font-size: 16px">
<%--                    <td width="40" align="center" bgcolor="">序号</td>--%>
        <td bgcolor='' align="center">活动</td>
        <td bgcolor='' align="center">申请原因</td>
        <td bgcolor='' align="center">时间</td>
        <td bgcolor='' align="center">用户</td>

                    <td width="40" align="center" bgcolor="">详细</td>
                </tr>
                <c:forEach items="${pageInfo.records}" var="info" varStatus="s">
                    <tr style="height: 32px;font-size: 16px">
                            <%--                            <td width="40px" align="center">--%>
                            <%--                                    ${s.index+1}--%>
                            <%--                            </td>--%>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.huodong.mingcheng)>'16'}">
                        ${fn:substring(info.huodong.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.huodong.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.nerong)>'16'}">
                        ${fn:substring(info.nerong,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.nerong}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.shijian)>'16'}">
                        ${fn:substring(info.shijian,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.shijian}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.users.loginname)>'16'}">
                        ${fn:substring(info.users.loginname,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.users.loginname}
                    </c:otherwise>
                </c:choose>
            </td>

                        <td width="50px" align="center">
                            <a href="${contextPath}/baomingDetailQian/${info.id}">
                                详细
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>

            <%@ include file="common/fenye.jsp"%>
            <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
                   style="border-collapse:collapse" class="newsline">
                <tr>
                    <td align="center" bgcolor="">
                        <%--<input type="button" value="打印" style="width: 60px;" onClick="javascript:window.print()" />--%>
                        <input type="button" value="返回" style="width: 60px;" onClick="javascript:history.back()" />
                    </td>
                </tr>
            </table>
        </div>
        <ul>
        </ul>
    </ul>
</div>
<br>
<br>
<!--主体内容的结束-->
<!--底部的开始-->
<%@ include file="qtdown.jsp" %>
<!--底部的结束-->
</body>
</html>
