<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>后台用户申请添加</title>
	<%@include file="common/head.jsp" %>
	<%@include file="common/loginstate.jsp" %>
	<link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="${staticPath}/js/popup.js"></script>
	<script type="text/javascript">
		//文件上传
		function upx(id) {
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
			pop.setContent("contentUrl","${contextPath}/common/upload/?id="+id);
			pop.setContent("title","文件上传");
			pop.build();
			pop.show();
		}
		// 添加申请
		function shenqingAdd() {
			var xiaozuid = $('#xiaozuid').val().trim();
			var neirong = $('#neirong').val().trim();
			var usersid = $('#usersid').val().trim();
			var shenhe = $('#shenhe').val().trim();

			var param = {
				'xiaozuid':xiaozuid,
				'neirong':neirong,
				'usersid':usersid,
				'shenhe':shenhe,

			};
			$.ajax({
				type: 'post',
				url: '${basePath}/shenqingAdd',
				dataType: "json",
				contentType:"application/json",
				data : JSON.stringify(param),
				success: function (resp) {
					if (resp.success) {
						alert("添加成功！");
						//window.location.href = "${contextPath}/shenqingMana";
					} else {
						alert(resp.message);
					}
				}
			});
		}
	</script>
</head>

<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<form id="formAdd" name="formAdd" >
	<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
		<tr bgcolor="#EEF4EA">
			<td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;用户申请添加</span></td>
		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				申请用户
			</td>
			<td width="90%" bgcolor="#FFFFFF" align="left">
				<select name="usersid" id="usersid" style="width: 280px;">
					<option value="${users.id}">${users.loginname}</option>
				</select>
			</td>
		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				小组:
			</td>
            <td>
                <select name="xiaozuid" id="xiaozuid" style="border:solid 1px #000000; color:#666666"></select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/xiaozuAll/', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#xiaozuid").append("<option value='"+info.id+"' >" + info.mingcheng + "</option>");
                            }
                        }
                    }else {
                        alert(resp.message);
                    }
                });
            </script>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="neirong" id="neirong" style="width:670px;height:200px;" size="70px"></textarea>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				申请:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="shenhe" id="shenhe" style="border:solid 1px #000000; color:#666666">
                    <option value="no">no</option>
                    <%--<option value="yes">yes</option>--%>
                </select>
            </td>

		</tr>

		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10" bgcolor="#FFFFFF" align="right">&nbsp;</td>
			<td width="90%" bgcolor="#FFFFFF" align="left">
				<input type="button" name="Submit" value="提交" style='border:solid 1px #000000; color:#666666' onclick="shenqingAdd();"/>
				<input type="button" value="返回" style='border:solid 1px #000000; color:#666666' onClick="javascript:history.back()" />
				<input type="reset" name="Submit2" value="重置" style='border:solid 1px #000000; color:#666666'/></td>
		</tr>
	</table>
</form>
</body>
</html>
