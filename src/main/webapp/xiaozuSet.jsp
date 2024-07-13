<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台小组修改</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${staticPath}/js/popup.js"></script>
    <script type="text/javascript">
        //文件上传
        function upx(id) {
            var pop = new Popup({contentType: 1, isReloadOnClose: false, width: 400, height: 200});
            pop.setContent("contentUrl", "${contextPath}/common/upload/?id=" + id);
            pop.setContent("title", "文件上传");
            pop.build();
            pop.show();
        }

        // 修改小组
        function xiaozuSet() {
            var id = $('#id').val();
			var mingcheng  = $("#mingcheng").length > 0 ? $('#mingcheng').val().trim():null;
			if($("#mingcheng").length > 0 && mingcheng == "")
			{
				alert("please input:名称");
			    $('#mingcheng').focus();
				return false;
			}
			var tupian  = $("#tupian").length > 0 ? $('#tupian').val().trim():null;
			if($("#tupian").length > 0 && tupian == "")
			{
				alert("please input:图片");
			    $('#tupian').focus();
				return false;
			}
			var huodongid=$('#huodongid').val().trim();
			var chengji  = $("#chengji").length > 0 ? $('#chengji').val().trim():null;
			if($("#chengji").length > 0 && chengji == "")
			{
				alert("please input:小组成绩");
			    $('#chengji').focus();
				return false;
			}
			var usersid=$('#usersid').val().trim();

            var param = {
                'id': id,
				'mingcheng':mingcheng,
				'tupian':tupian,
				'huodongid':huodongid,
				'chengji':chengji,
				'usersid':usersid,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/xiaozuAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/xiaozuMana";
                    } else {
                        alert(resp.message);
                    }
                }
            });
        }
    </script>
</head>


<body>

<form name="formAdd" id="formAdd">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
           style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;小组修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				名称:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="mingcheng" id="mingcheng" value="${xiaozu.mingcheng }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				图片:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="tupian" id="tupian" value="${xiaozu.tupian}" size="50px" readonly="readonly" />
                <input type="button" value="上传" onclick="upx('tupian')" />
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				活动:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="huodongid" id="huodongid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${xiaozu.huodong.id }">${xiaozu.huodong.mingcheng }</option>
                </select>
            </td>
            <script type="text/javascript">
                // 如果要获取所有数据请替换一下
                //$.get(basePath + '/huodongAll/', function(resp) {
                $.get(basePath + '/huodongSearch/?usersid=${sessionScope.user.id}', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#huodongid").append("<option value='"+info.id+"' >" + info.mingcheng + "</option>");
                            }
                        }
                    }else {
                        alert(resp.message);
                    }
                });
            </script>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				小组成绩:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="chengji" id="chengji" value="${xiaozu.chengji }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				用户:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="usersid" id="usersid" style="width: 280px;">
                    <option value="${xiaozu.users.id }">${xiaozu.users.loginname}</option>
                </select>
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${xiaozu.id}"/>
                <input type="button" value="提交" onclick="xiaozuSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


