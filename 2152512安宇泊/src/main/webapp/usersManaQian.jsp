<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户列表</title>
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
            用户<span><i></i>
				</span>
        </p>
    </div>
</div>
<div class="container">
    <ul class="g-firstsec2-list">
        <div class="content-form">
            <link rel="stylesheet" href="${staticPath}/images/hsgcommon/divqt.css" type="text/css">
            <form name="formSearch" id="formSearch" method="post" action="${contextPath}/${actionName}">
        用户名称:<input type="text" style='border:solid 1px #000000; color:#666666' name="loginname" id="loginname" size="12px" value="${req.loginname}"/>&nbsp;&nbsp;
        类型:<input type="text" style='border:solid 1px #000000; color:#666666' name="type" id="type" size="12px" value="${req.type}"/>&nbsp;&nbsp;
        类型名称:<input type="text" style='border:solid 1px #000000; color:#666666' name="typename" id="typename" size="12px" value="${req.typename}"/>&nbsp;&nbsp;
        姓名:<input type="text" style='border:solid 1px #000000; color:#666666' name="xingming" id="xingming" size="12px" value="${req.xingming}"/>&nbsp;&nbsp;
        性别:
        <select size="1px"  name="xingbie" id="xingbie">
            <option value="">全部</option>
            <option value="男" <c:if test="${req.xingbie == '男'}">selected</c:if>>男</option>
            <option value="女" <c:if test="${req.xingbie == '女'}">selected</c:if>>女</option>
        </select>&nbsp;&nbsp;
        年龄:<input type="text" style='border:solid 1px #000000; color:#666666' name="nianling" id="nianling" size="12px" value="${req.nianling}"/>&nbsp;&nbsp;
        地址:<input type="text" style='border:solid 1px #000000; color:#666666' name="address" id="address" size="12px" value="${req.address}"/>&nbsp;&nbsp;
        电话:<input type="text" style='border:solid 1px #000000; color:#666666' name="dianhua" id="dianhua" size="12px" value="${req.dianhua}"/>&nbsp;&nbsp;
        班级:
        <select style="border:solid 1px #000000; color:#666666;" name="banjiid" id="banjiid">
            <option value="">全部</option>
            <c:forEach items="${banjiList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.banjiid}">
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
        审核:
        <select name="shenhe" id="shenhe" size="1px" >
            <option value="">全部</option>
            <option value="yes" <c:if test="${req.shenhe == 'yes'}">selected</c:if>>yes</option>
            <option value="no" <c:if test="${req.shenhe == 'no'}">selected</c:if>>no</option>
        </select>&nbsp;&nbsp;

                <input type="submit" value="查询" class='hsgqiehuanshitu'/>
            </form>
            <br/>
            <table width="100%" border="0" align="center" cellpadding="4"
                   cellspacing="1" bgcolor="#ebf0f7">
                <tr style="height: 32px;font-size: 16px">
<%--                    <td width="40" align="center" bgcolor="">序号</td>--%>
        <td bgcolor='' align="center">用户名称</td>
        <td bgcolor='' align="center">密码</td>
        <td bgcolor='' align="center">类型</td>
        <td bgcolor='' align="center">类型名称</td>
        <td bgcolor='' align="center">姓名</td>
        <td bgcolor='' align="center">性别</td>
        <td bgcolor='' align="center">年龄</td>
        <td bgcolor='' align="center">地址</td>
        <td bgcolor='' align="center">电话</td>
        <td bgcolor='' align="center">班级</td>
        <td bgcolor='' align="center">审核</td>

                    <td width="40" align="center" bgcolor="">详细</td>
                </tr>
                <c:forEach items="${pageInfo.records}" var="info" varStatus="s">
                    <tr style="height: 32px;font-size: 16px">
                            <%--                            <td width="40px" align="center">--%>
                            <%--                                    ${s.index+1}--%>
                            <%--                            </td>--%>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.loginname)>'16'}">
                        ${fn:substring(info.loginname,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.loginname}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.loginpw)>'16'}">
                        ${fn:substring(info.loginpw,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.loginpw}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.type)>'16'}">
                        ${fn:substring(info.type,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.type}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.typename)>'16'}">
                        ${fn:substring(info.typename,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.typename}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.xingming)>'16'}">
                        ${fn:substring(info.xingming,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.xingming}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.xingbie)>'16'}">
                        ${fn:substring(info.xingbie,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.xingbie}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.nianling)>'16'}">
                        ${fn:substring(info.nianling,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.nianling}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.address)>'16'}">
                        ${fn:substring(info.address,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.address}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.dianhua)>'16'}">
                        ${fn:substring(info.dianhua,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.dianhua}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.banji.mingcheng)>'16'}">
                        ${fn:substring(info.banji.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.banji.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.shenhe)>'16'}">
                        ${fn:substring(info.shenhe,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.shenhe}
                    </c:otherwise>
                </c:choose>
            </td>

                        <td width="50px" align="center">
                            <a href="${contextPath}/usersDetailQian/${info.id}">
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
