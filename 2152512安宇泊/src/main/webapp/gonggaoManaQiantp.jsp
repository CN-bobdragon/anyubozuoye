<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>公告图片列表</title>
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
			公告<span><i></i>
				</span>
		</p>
	</div>
</div>
<div class="container">
	<ul class="g-firstsec2-list">
		<div class="content-form">
			<link rel="stylesheet" href="${staticPath}/images/hsgcommon/divqt.css" type="text/css">
			<form name="formSearch" id="formSearch" method="post" action="${contextPath}/gonggaoManaQiantp" >
        标题:<input type="text" name="biaoti" id="biaoti" size="15px" value="${req.biaoti}"/>&nbsp;&nbsp;

				<input type="submit" value="查询" class='hsgqiehuanshitu'/>
			</form>
			<br/>
			<table width="100%" border="0" align="center" cellpadding="4"
				   cellspacing="1" bgcolor="#ebf0f7">
				<tr>
					<c:forEach items="${pageInfo.records}" var="info" varStatus="s">
					<td align="center">
						<table width="160" height="160" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td align="center">
									<a href="${contextPath}/gonggaoDetailQian/${info.id}">
										<img src="${contextPath}/${info.image}" width="240px" height="240px" border="0" onerror="this.src='${staticPath}/images/zanwu.jpg'"/>
									</a>
								</td>
							</tr>
							<tr>
								<td height="26" align="center">

									<a href="${contextPath}/gonggaoDetailQian/${info.id}">
										<c:if test="${fn:length(info.biaoti)>'16'}">
											${fn:substring(info.biaoti,0,16)}...
										</c:if>
										<c:if test="${fn:length(info.biaoti)<='16'}">
											${info.biaoti}
										</c:if>
									</a>

								</td>
							</tr>
						</table>
					</td>
					<c:if test="${(s.index+1)%4==0}">
				</tr><tr>
				</c:if>
				</c:forEach>
			</tr>
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
