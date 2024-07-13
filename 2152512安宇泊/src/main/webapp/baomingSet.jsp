<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台报名修改</title>
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

        // 修改报名
        function baomingSet() {
            var id = $('#id').val();
			var huodongid=$('#huodongid').val().trim();
			var nerong  = $("#nerong").length > 0 ? $('#nerong').val().trim():null;
			if($("#nerong").length > 0 && nerong == "")
			{
				alert("please input:申请原因");
			    $('#nerong').focus();
				return false;
			}
			var shijian  = $("#shijian").length > 0 ? $('#shijian').val().trim():null;
			if($("#shijian").length > 0 && shijian == "")
			{
				alert("please input:时间");
			    $('#shijian').focus();
				return false;
			}
			var usersid=$('#usersid').val().trim();

            var param = {
                'id': id,
				'huodongid':huodongid,
				'nerong':nerong,
				'shijian':shijian,
				'usersid':usersid,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/baomingAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/baomingMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;报名修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				活动:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="huodongid" id="huodongid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${baoming.huodong.id }">${baoming.huodong.mingcheng }</option>
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
				申请原因:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="nerong" id="nerong" value="${baoming.nerong }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				时间:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="shijian" id="shijian" style="border:1px solid #cccccc;" readonly="readonly" size="20px" value="${baoming.shijian}" />
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				用户:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="usersid" id="usersid" style="width: 280px;">
                    <option value="${baoming.users.id }">${baoming.users.loginname}</option>
                </select>
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${baoming.id}"/>
                <input type="button" value="提交" onclick="baomingSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


