<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>密码重置</title>
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
		function resetPw() {
			var loginname = $('#loginname').val().trim();;
			var xingming = $('#xingming').val().trim();
			var dianhua = $('#dianhua').val().trim();
			if (loginname == "") {
				alert("用户名称不能空");
				return;
			}
			if (xingming == "") {
				alert("姓名不能空");
				return;
			}
			if (dianhua == "") {
				alert("电话不能空");
				return;
			}
			var param = {
				'loginname':loginname,
				'xingming':xingming,
				'dianhua':dianhua,
			};
			$.post(basePath + '/usersResetPw', param, function(resp) {
				if (resp.success) {
					alert("您的密码已被重置为'000000'如需修改，请登录个人中心操作!");

				}else {
					alert(resp.message);
				}
			})
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
			重置密码<span><i></i>
				</span>
		</p>
	</div>
</div>
<div class="container">
	<ul class="g-firstsec2-list">
		<div class="content-form">
			<link rel="stylesheet" href="${staticPath}/images/hsgcommon/divqt.css" type="text/css">
			<form>
				用户名称:<input type="text" style='border:solid 1px #000000; color:#666666' name="loginname" id="loginname" size="12px" />&nbsp;&nbsp;
				姓名:<input type="text" style='border:solid 1px #000000; color:#666666' name="xingming" id="xingming" size="12px" />&nbsp;&nbsp;
				电话:<input type="text" style='border:solid 1px #000000; color:#666666' name="dianhua" id="dianhua" size="12px" />&nbsp;&nbsp;
				<input type="button" onclick="resetPw();" style='border:solid 1px #000000; color:#666666' value="重置密码"/>
			</form>
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
