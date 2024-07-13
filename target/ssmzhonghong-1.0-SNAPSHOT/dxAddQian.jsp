<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>介绍添加</title>
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
        // 添加介绍
        function dxAdd() {
			var leibie = $("#leibie").length > 0 ? $('#leibie').val().trim():null;
			if(("#leibie").length > 0 && leibie == "")
			{
				alert("please input:类别");
			    $('#leibie').focus();
				return false;
			}
			var content=$('#content').val().trim();
			var addtime = $("#addtime").length > 0 ? $('#addtime').val().trim():null;
			if(("#addtime").length > 0 && addtime == "")
			{
				alert("please input:时间");
			    $('#addtime').focus();
				return false;
			}

            var param = {
				'leibie':leibie,
				'content':content,
				'addtime':addtime,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/dxAddQian',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("添加成功！");
                        //window.location.href = "${contextPath}/dxManaMyQian";
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
            介绍添加<span><i></i> </span>
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
				类别:
			</td>
            <td>
                <input type="text" name="leibie" id="leibie" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="content" id="content" style="width:670px;height:200px;"></textarea>
            </td>

		</tr>
		<tr>
			<td>
				时间:
			</td>
            <td>
                <input type="text" name="addtime" id="addtime" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>

                    <tr align='center'   height="22">
                        <td width="25%"  align="right">&nbsp;
                        </td>
                        <td width="75%"  align="left">
                            <input type="button" name="querenzhuce" id="querenzhuce" value="提交" onClick="dxAdd();"/>
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
