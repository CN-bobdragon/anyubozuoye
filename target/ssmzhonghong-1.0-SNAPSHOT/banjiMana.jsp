<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>班级管理列表</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <script type="text/javascript">
        //导出信息
        function daochu() {
            var url = "${contextPath}/banjiExportExcel";
            window.location.href=url;
        }
        //删除信息
        function banjiDel(id) {
            if (confirm('您确定删除吗?')) {
                $.get(basePath + '/banjiDel/' + id, function (resp) {
                    if (resp.success) {
                        alert("删除成功！");
                        //window.location.href = "${contextPath}/banjiMana";
                        document.formSearch.submit();
                        return;
                    } else {
                        alert(resp.message);
                    }
                })
            }
        }

        //跳转到信息修改页
        function banjiGet(id) {
            window.location.href = "${contextPath}/banjiGet/" + id;
        }

        //跳转到信息详细页
        function banjiDetail(id) {
            window.location.href = "${contextPath}/banjiDetail/" + id;
        }

        //附件下载
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //更新信息
        function banjiSet(id,property,value) {
            if (confirm('您确定操作吗?')) {
                var param = {};
                param["id"]=id;
                param[property]=value;
                $.post(basePath + '/banjiSet', param, function(resp) {
                    if (resp.success) {
                        alert("操作成功！");
                        //window.location.href = "${contextPath}/banjiMana";
                        document.formSearch.submit();
                        return;
                    }else {
                        alert(resp.message);
                    }
                })
            }
        }

        //跳转到子表users添加页面
        function banjiusersAdd(id) {
            var url="${contextPath}/banjiusersAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表users查看页面
        function banjiusersGetBybanjiid(id) {
            var url="${contextPath}/banjiusersGetBybanjiid/"+id;
            window.location.href=url;
        }


    </script>
</head>
<body leftmargin="2" topmargin="2">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px"
       bordercolor="#008080">
    <form action="${contextPath}/banjiMana" name="formSearch" id="formSearch" method="post">
        名称:<input type="text" name="mingcheng" id="mingcheng" size="15px" value="${req.mingcheng}"/>&nbsp;&nbsp;

        <input type="submit" value="搜索"/>
    </form>
    <tr bgcolor="#E7E7E7">
        <td height="14" colspan="100" background="${staticPath}/images/tbg.gif">班级管理</td>
    </tr>
    <tr align="center" bgcolor="#C0C0C0" height="22">
        <td width="2%">序号</td>
        <td width="5%">名称</td>

        <td width="10%">操作</td>
    </tr>
    <c:forEach items="${pageInfo.records}" var="info" varStatus="s">
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td bgcolor="#FFFFFF" align="center">
                    ${s.index +1 }
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.mingcheng)>'16'}">
                        ${fn:substring(info.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>

            <td bgcolor="#FFFFFF" align="center">

                <input type="button" value="修改" onclick="banjiGet(${info.id})"/>
                <input type="button" value="详情" onclick="banjiDetail(${info.id})"/>
                <input type="button" value="删除" onclick="banjiDel(${info.id})"/>
                    <%--sonTable本表子表管理--%>
                <%--<input type="button" value="班级用户查看" onclick="banjiusersGetBybanjiid(${info.id})"/>--%>
                <%--<input type="button" value="班级用户添加" onclick="banjiusersAdd(${info.id})"/>--%>

            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="common/fenye.jsp" %>
<table width='98%' border='0' style="margin-top:8px;margin-left: 8px;">
    <tr>
        <td>
            <input type="button" value="导出"  onclick="daochu();" />
            <%--<input type="button" value="打印"  onClick="javascript:window.print()" />--%>
            <input type="button" value="返回" style="width: 120px;" onClick="javascript:history.back()"/>
        </td>

    </tr>
</table>

<div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
    <TABLE id="tipTable" border="0" bgcolor="#ffffee">
        <TR align="center">
            <TD><img id="photo" src="" height="160" width="200"></TD>
        </TR>
    </TABLE>
</div>
</body>
</html>
