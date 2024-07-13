<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台活动详情</title>
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
        function huodongbaomingAdd(id) {
            var url="${contextPath}/huodongbaomingAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表baoming查看页面
        function huodongbaomingGetByhuodongid(id) {
            var url="${contextPath}/huodongbaomingGetByhuodongid/"+id;
            window.location.href=url;
        }
        //跳转到子表xiaozu添加页面
        function huodongxiaozuAdd(id) {
            var url="${contextPath}/huodongxiaozuAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表xiaozu查看页面
        function huodongxiaozuGetByhuodongid(id) {
            var url="${contextPath}/huodongxiaozuGetByhuodongid/"+id;
            window.location.href=url;
        }

    </script>
</head>
<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;活动详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            名称:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${huodong.mingcheng }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            图片:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            <img src="${contextPath}/${huodong.tupian}" alt="" width="550" height="350" onerror="this.src='${staticPath}/images/zanwu.jpg'" />
            <br />
        <c:choose>
            <c:when test='${ null != huodong.tupian && !huodong.tupian.equals("")}'>
                <a href="#" onclick="down('${huodong.tupian}')" style="font-size: 11px;color: red">下载</a>
            </c:when>
            <c:otherwise>
                暂无
            </c:otherwise>
        </c:choose>
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            日常内容:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${huodong.neirong }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            用户:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${huodong.users.loginname}
        </td>

    </tr>

    <tr>
        <td width="10" bgcolor="#FFFFFF" align="right">
            &nbsp;
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
                <%--<input type="button" value="报名添加" onclick="huodongbaomingAdd(${huodong.id})"/>--%>
                <%--<input type="button" value="报名查看" onclick="huodongbaomingGetByhuodongid(${huodong.id})"/>--%>
                <%--<input type="button" value="小组添加" onclick="huodongxiaozuAdd(${huodong.id})"/>--%>
                <%--<input type="button" value="小组查看" onclick="huodongxiaozuGetByhuodongid(${huodong.id})"/>--%>

            <input type="button" value="打印" onClick="javascript:window.print()"/>
            <input type="button" value="返回" onClick="javascript:history.back()"/>
        </td>
    </tr>
</table>
</body>
</html>


