<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户详情</title>
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

        //跳转到子表baoming添加页面
        function usersbaomingAddQian(id) {
            var url="${contextPath}/usersbaomingAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表baoming查看页面
        function usersbaomingGetByusersidQian(id) {
            var url="${contextPath}/usersbaomingGetByusersidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表huodong添加页面
        function usershuodongAddQian(id) {
            var url="${contextPath}/usershuodongAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表huodong查看页面
        function usershuodongGetByusersidQian(id) {
            var url="${contextPath}/usershuodongGetByusersidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表liuyan添加页面
        function usersliuyanAddQian(id) {
            var url="${contextPath}/usersliuyanAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表liuyan查看页面
        function usersliuyanGetByusersidQian(id) {
            var url="${contextPath}/usersliuyanGetByusersidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表shenqing添加页面
        function usersshenqingAddQian(id) {
            var url="${contextPath}/usersshenqingAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表shenqing查看页面
        function usersshenqingGetByusersidQian(id) {
            var url="${contextPath}/usersshenqingGetByusersidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表xiaozu添加页面
        function usersxiaozuAddQian(id) {
            var url="${contextPath}/usersxiaozuAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表xiaozu查看页面
        function usersxiaozuGetByusersidQian(id) {
            var url="${contextPath}/usersxiaozuGetByusersidQian/"+id;
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
            用户信息<span><i></i> </span>
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
            用户名称:
        </td>
        <td width="39%">
            ${users.loginname }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            密码:
        </td>
        <td width="39%">
            ${users.loginpw }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            类型:
        </td>
        <td width="39%">
            ${users.type}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            类型名称:
        </td>
        <td width="39%">
            ${users.typename }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            姓名:
        </td>
        <td width="39%">
            ${users.xingming }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            性别:
        </td>
        <td width="39%">
            ${users.xingbie}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            年龄:
        </td>
        <td width="39%">
            ${users.nianling }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            地址:
        </td>
        <td width="39%">
            ${users.address }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            电话:
        </td>
        <td width="39%">
            ${users.dianhua }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            班级:
        </td>
        <td width="39%">
            ${users.banji.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            审核:
        </td>
        <td width="39%">
            ${users.shenhe}
        </td>

    </tr>

                <tr>
                    <td colspan=4 align=center>
                <input type="button" value="报名添加" onclick="usersbaomingAddQian(${users.id})"/>
                <%--<input type="button" value="报名查看" onclick="usersbaomingGetByusersidQian(${users.id})"/>--%>
                <input type="button" value="活动添加" onclick="usershuodongAddQian(${users.id})"/>
                <input type="button" value="活动查看" onclick="usershuodongGetByusersidQian(${users.id})"/>
                <input type="button" value="留言咨询添加" onclick="usersliuyanAddQian(${users.id})"/>
                <input type="button" value="留言咨询查看" onclick="usersliuyanGetByusersidQian(${users.id})"/>
                <input type="button" value="申请添加" onclick="usersshenqingAddQian(${users.id})"/>
                <input type="button" value="申请查看" onclick="usersshenqingGetByusersidQian(${users.id})"/>
                <input type="button" value="小组添加" onclick="usersxiaozuAddQian(${users.id})"/>
                <input type="button" value="小组查看" onclick="usersxiaozuGetByusersidQian(${users.id})"/>

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



