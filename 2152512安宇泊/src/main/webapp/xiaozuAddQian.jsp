<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>小组添加</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
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

    <script type="text/javascript">
        //文件上传
        function upx(id) {
            var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
            pop.setContent("contentUrl","${contextPath}/common/upload/?id="+id);
            pop.setContent("title","文件上传");
            pop.build();
            pop.show();
        }
        // 添加小组
        function xiaozuAdd() {
			var mingcheng = $("#mingcheng").length > 0 ? $('#mingcheng').val().trim():null;
			if(("#mingcheng").length > 0 && mingcheng == "")
			{
				alert("please input:名称");
			    $('#mingcheng').focus();
				return false;
			}
			var tupian = $("#tupian").length > 0 ? $('#tupian').val().trim():null;
			if(("#tupian").length > 0 && tupian == "")
			{
				alert("please input:图片");
			    $('#tupian').focus();
				return false;
			}
			var huodongid=$('#huodongid').val().trim();
			var chengji = $("#chengji").length > 0 ? $('#chengji').val().trim():null;
			if(("#chengji").length > 0 && chengji == "")
			{
				alert("please input:小组成绩");
			    $('#chengji').focus();
				return false;
			}
			var usersid=$('#usersid').val().trim();

            var param = {
				'mingcheng':mingcheng,
				'tupian':tupian,
				'huodongid':huodongid,
				'chengji':chengji,
				'usersid':usersid,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/xiaozuAddQian',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("添加成功！");
                        //window.location.href = "${contextPath}/xiaozuManaMyQian";
                    } else {
                        alert(resp.message);
                    }
                }
            });
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
            小组添加<span><i></i> </span>
        </p>
    </div>
</div>
<div class="container">
    <ul class="g-firstsec2-list">
        <div class="content-form">
            <link rel="stylesheet" href="${staticPath}/images/hsgcommon/divqt.css" type="text/css">
            <link rel="stylesheet" href="${staticPath}/images/hsgcommon/commonqt.css" type="text/css">
            <script src="${staticPath}/images/hsgcommon/common.js"></script>
            <script src="${staticPath}/images/hsgcommon/bootbox.js"></script>
            <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CCCCCC" style="border-collapse:collapse" class="newsline">
                <form name="formAdd" id="formAdd">
		<tr>
			<td>
				名称:
			</td>
            <td>
                <input type="text" name="mingcheng" id="mingcheng" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				图片:
			</td>
            <td>
                <input type="text" name="tupian" id="tupian" size="50px" readonly="readonly" />
                <input type="button" value="上传" onclick="upx('tupian')" />
            </td>

		</tr>
		<tr>
			<td>
				活动:
			</td>
            <td>
                <select name="huodongid" id="huodongid" style="border:solid 1px #000000; color:#666666"></select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/huodongAll/', function(resp) {
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
		<tr>
			<td>
				小组成绩:
			</td>
            <td>
                <input type="number" name="chengji" id="chengji" value="0" size="70px"/>
            </td>

		</tr>
		<tr style="display: none;">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				用户:
			</td>
            <td style="display: none">
                <select name="usersid" id="usersid" style="border:solid 1px #000000; color:#666666">
                    <option value="${sessionScope.user.id }">${sessionScope.user.loginname }</option>
                </select>
            </td>

		</tr>

                    <tr align='center'   height="22">
                        <td width="25%"  align="right">&nbsp;
                        </td>
                        <td width="75%"  align="left">
                            <input type="button" name="querenzhuce" id="querenzhuce" value="提交" onClick="xiaozuAdd();"/>
                            <input type="button" value="返回" onClick="javascript:history.back()"/>
                            <%--<input type="reset" value="重置"/>&nbsp;--%>
                        </td>
                    </tr>

                </form>
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

