<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>小组详情</title>
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
    <script language="javascript">
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //跳转到子表shenqing添加页面
        function xiaozushenqingAddQian(id) {
            var url="${contextPath}/xiaozushenqingAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表shenqing查看页面
        function xiaozushenqingGetByxiaozuidQian(id) {
            var url="${contextPath}/xiaozushenqingGetByxiaozuidQian/"+id;
            window.location.href=url;
        }

    </script>
</head>
<body>
<!--新头部的开始-->
<%@ include file="qttop.jsp" %>
<!--新头部的结束-->
<!--主体内容的开始-->
<div class="container">
    <div class="g-firstsection-title_sy">
        <p class="g-firstsection-title_sy_p">
            小组信息<span><i></i> </span>
        </p>
    </div>
</div>
<div class="container">
    <ul class="g-firstsec2-list">
        <div class="content-form">

            <table width="100%" border="0" align="center" cellpadding="3"
                   cellspacing="1" bordercolor="#00FFFF"
                   style="border-collapse:collapse" class="newsline">
    <tr>
        <td width="39%" height="44px">
            名称:
        </td>
        <td width="39%">
            ${xiaozu.mingcheng }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            图片:
        </td>
        <td idth="39%" height="240px">
            <img src="${contextPath}/${xiaozu.tupian}" alt="" width="228px" height="215px" border="0" onerror="this.src='${staticPath}/images/zanwu.jpg'" />
            <br />
        <c:choose>
            <c:when test='${ null != xiaozu.tupian && !xiaozu.tupian.equals("")}'>
                <a href="#" onclick="down('${xiaozu.tupian}')" style="font-size: 11px;color: red">下载</a>
            </c:when>
            <c:otherwise>
                暂无
            </c:otherwise>
        </c:choose>
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            活动:
        </td>
        <td width="39%">
            ${xiaozu.huodong.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            小组成绩:
        </td>
        <td width="39%">
            ${xiaozu.chengji }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            用户:
        </td>
        <td width="39%">
            ${xiaozu.users.loginname}
        </td>

    </tr>

                <tr>
                    <td colspan=4 align=center>
                <input type="button" value="申请加入" onclick="xiaozushenqingAddQian(${xiaozu.id})"/>
                <input type="button" value="我的申请" onclick="xiaozushenqingGetByxiaozuidQian(${xiaozu.id})"/>

                        <input type=button name=Submit5 value=返回 class='hsgqiehuanshitu' onClick="javascript:history.back()" />
                        <%--<input type=button name=Submit52 value=打印 class='hsgqiehuanshitu' onClick="javascript:window.print()" /> --%>
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



