<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台小组详情</title>
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

        //跳转到子表shenqing添加页面
        function xiaozushenqingAdd(id) {
            var url="${contextPath}/xiaozushenqingAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表shenqing查看页面
        function xiaozushenqingGetByxiaozuid(id) {
            var url="${contextPath}/xiaozushenqingGetByxiaozuid/"+id;
            window.location.href=url;
        }

    </script>
</head>
<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;小组详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            名称:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${xiaozu.mingcheng }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            图片:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            <img src="${contextPath}/${xiaozu.tupian}" alt="" width="550" height="350" onerror="this.src='${staticPath}/images/zanwu.jpg'" />
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
        <td width="10%" bgcolor="#FFFFFF" align="right">
            活动:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${xiaozu.huodong.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            小组成绩:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${xiaozu.chengji }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            用户:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${xiaozu.users.loginname}
        </td>

    </tr>

    <tr>
        <td width="10" bgcolor="#FFFFFF" align="right">
            &nbsp;
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
                <%--<input type="button" value="申请添加" onclick="xiaozushenqingAdd(${xiaozu.id})"/>--%>
                <%--<input type="button" value="申请查看" onclick="xiaozushenqingGetByxiaozuid(${xiaozu.id})"/>--%>

            <input type="button" value="打印" onClick="javascript:window.print()"/>
            <input type="button" value="返回" onClick="javascript:history.back()"/>
        </td>
    </tr>
</table>
</body>
</html>


