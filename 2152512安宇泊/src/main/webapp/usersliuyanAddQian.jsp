<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户留言咨询添加</title>
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
        // 添加留言咨询
        function liuyanAdd() {
			var biaoti = $("#biaoti").length > 0 ? $('#biaoti').val().trim():null;
			if($("#biaoti").length > 0 && biaoti == "")
			{
				alert("please input:标题");
			    $('#biaoti').focus();
				return false;
			}
			var neirong=$('#neirong').val().trim();
			var tianjiashijian = $("#tianjiashijian").length > 0 ? $('#tianjiashijian').val().trim():null;
			if($("#tianjiashijian").length > 0 && tianjiashijian == "")
			{
				alert("please input:时间");
			    $('#tianjiashijian').focus();
				return false;
			}
			var usersid=$('#usersid').val().trim();

            var param = {
				'biaoti':biaoti,
				'neirong':neirong,
				'tianjiashijian':tianjiashijian,
				'usersid':usersid,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/liuyanAddQian',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("添加成功！");
                        //window.location.href = "${contextPath}/liuyanManaMyQian";
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
            用户留言咨询添加<span><i></i> </span>
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

            <table width="100%" border="1" align="center" cellpadding="3"
                   cellspacing="1" bordercolor="#CCCCCC"
                   style="border-collapse:collapse" class="newsline">
                <form name="formAdd" id="formAdd">
                    <tr>
                        <td width="10%" bgcolor="">
                            用户:
                        </td>
                        <td width="90%" bgcolor="" align="left">
                            <select name="usersid"
                                    id="usersid" style="width: 280px;">
                                <option value="${users.id }">${users.loginname}</option>
                            </select>
                        </td>
                    </tr>
		<tr>
			<td>
				标题:
			</td>
            <td>
                <input type="text" name="biaoti" id="biaoti" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				内容:
			</td>
            <td>
                <textarea name="neirong" id="neirong" style="width:670px;height:200px;" size="70px"></textarea>
            </td>

		</tr>
		<tr>
			<td>
				时间:
			</td>
            <td>
                <input type="text" name="tianjiashijian" id="tianjiashijian" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>

                    <tr align='center'   height="22">
                        <td width="25%"  align="right">&nbsp;

                        </td>
                        <td width="75%"  align="left">
                            <input type="button" name="querenzhuce" id="querenzhuce" value="提交" onClick="liuyanAdd();"/>
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

