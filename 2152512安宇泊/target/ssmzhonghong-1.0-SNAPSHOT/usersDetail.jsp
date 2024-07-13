<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台用户详情</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
    <script language="javascript">
        //附件下载
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //跳转到子表baoming添加页面
        function usersbaomingAdd(id) {
            var url="${contextPath}/usersbaomingAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表baoming查看页面
        function usersbaomingGetByusersid(id) {
            var url="${contextPath}/usersbaomingGetByusersid/"+id;
            window.location.href=url;
        }
        //跳转到子表huodong添加页面
        function usershuodongAdd(id) {
            var url="${contextPath}/usershuodongAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表huodong查看页面
        function usershuodongGetByusersid(id) {
            var url="${contextPath}/usershuodongGetByusersid/"+id;
            window.location.href=url;
        }
        //跳转到子表liuyan添加页面
        function usersliuyanAdd(id) {
            var url="${contextPath}/usersliuyanAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表liuyan查看页面
        function usersliuyanGetByusersid(id) {
            var url="${contextPath}/usersliuyanGetByusersid/"+id;
            window.location.href=url;
        }
        //跳转到子表shenqing添加页面
        function usersshenqingAdd(id) {
            var url="${contextPath}/usersshenqingAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表shenqing查看页面
        function usersshenqingGetByusersid(id) {
            var url="${contextPath}/usersshenqingGetByusersid/"+id;
            window.location.href=url;
        }
        //跳转到子表xiaozu添加页面
        function usersxiaozuAdd(id) {
            var url="${contextPath}/usersxiaozuAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表xiaozu查看页面
        function usersxiaozuGetByusersid(id) {
            var url="${contextPath}/usersxiaozuGetByusersid/"+id;
            window.location.href=url;
        }

    </script>
</head>
<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;用户详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            用户名称:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.loginname }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            密码:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.loginpw }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            类型:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.type}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            类型名称:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.typename }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            姓名:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.xingming }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            性别:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.xingbie}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            年龄:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.nianling }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            地址:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.address }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            电话:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.dianhua }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            班级:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.banji.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            审核:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.shenhe}
        </td>

    </tr>

    <tr>
        <td width="10" bgcolor="#FFFFFF" align="right">
            &nbsp;
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
                <%--<input type="button" value="报名添加" onclick="usersbaomingAdd(${users.id})"/>--%>
                <%--<input type="button" value="报名查看" onclick="usersbaomingGetByusersid(${users.id})"/>--%>
                <%--<input type="button" value="活动添加" onclick="usershuodongAdd(${users.id})"/>--%>
                <%--<input type="button" value="活动查看" onclick="usershuodongGetByusersid(${users.id})"/>--%>
                <%--<input type="button" value="留言咨询添加" onclick="usersliuyanAdd(${users.id})"/>--%>
                <%--<input type="button" value="留言咨询查看" onclick="usersliuyanGetByusersid(${users.id})"/>--%>
                <%--<input type="button" value="申请添加" onclick="usersshenqingAdd(${users.id})"/>--%>
                <%--<input type="button" value="申请查看" onclick="usersshenqingGetByusersid(${users.id})"/>--%>
                <%--<input type="button" value="小组添加" onclick="usersxiaozuAdd(${users.id})"/>--%>
                <%--<input type="button" value="小组查看" onclick="usersxiaozuGetByusersid(${users.id})"/>--%>

            <input type="button" value="打印" onClick="javascript:window.print()"/>
            <input type="button" value="返回" onClick="javascript:history.back()"/>
        </td>
    </tr>
</table>
</body>
</html>


