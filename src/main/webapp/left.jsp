<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <title>左边导航</title>
    <link rel="stylesheet" type="text/css" href="${staticPath}/images/reset.css"/>
    <link rel="stylesheet" type="text/css" href="${staticPath}/images/common.css"/>
    <script type="text/javascript" src="${staticPath}/images/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        var temp_click = true;
        $(function () {
            $('.erji li').click(function () {
                $(this).siblings('li').removeClass('now_li');
                $(this).addClass('now_li');
            });
            $('.sidenav li').click(function () {
                if (temp_click) {
                    $(this).addClass('now');
                    $(this).siblings('li').removeClass('now');
                    temp_click = false;
                } else {
                    $(this).removeClass('now');
                    temp_click = true;
                }
            });
            var main_h = $(window).height();
            $('.sidenav').css('height', main_h + 'px');
        })
    </script>
</head>
<body>
<div id="left_ctn">
    <ul class="sidenav">

        <li>
            <div class="nav_m">
                <span><a>用户管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">


                <li>
                    <span><a href="usersMana?type=1" target="hsgmain">老师查询</a></span>
                </li>

                <li>
                    <span><a href="usersMana?type=2" target="hsgmain">学生查询</a></span>
                </li>

                <li>
                    <span><a href="usersAdd.jsp" target="hsgmain">学生添加</a></span>
                </li>
                <li>
                    <span><a href="userPw.jsp" target="hsgmain">修改密码</a></span>
                </li>
                <li>
                    <span><a href="usersSet2.jsp" target="hsgmain">修改资料</a></span>
                </li>
            </ul>
        </li>

        <li>
            <div class="nav_m">
                <span><a>轮播管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="lunboAdd.jsp" target="hsgmain">轮播添加</a></span>
                </li>
                <li>
                    <span><a href="lunboMana" target="hsgmain">轮播查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>公告管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="gonggaoAdd.jsp" target="hsgmain">公告添加</a></span>
                </li>
                <li>
                    <span><a href="gonggaoMana" target="hsgmain">公告查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>社会实践管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="huodongAdd.jsp" target="hsgmain">社会实践添加</a></span>
                </li>
                <li>
                    <span><a href="huodongMana" target="hsgmain">社会实践查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>报名管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="baomingMana" target="hsgmain">个人报名管理</a></span>
                </li>

                <li>
                    <span><a href="baomingAdd.jsp" target="hsgmain">个人报名添加</a></span>
                </li>


                <li>
                    <span><a href="shenqingAdd.jsp" target="hsgmain">小组申请添加</a></span>
                </li>

                <li>
                    <span><a href="shenqingMana" target="hsgmain">小组申请查询</a></span>
                </li>
            </ul>
        </li>

        <li>
            <div class="nav_m">
                <span><a>小组管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">

                <li>
                    <span><a href="xiaozuAdd.jsp" target="hsgmain">小组添加</a></span>
                </li>

                <li>
                    <span><a href="xiaozuMana" target="hsgmain">小组查询</a></span>
                </li>
            </ul>
        </li>





        <li>
            <div class="nav_m">
                <span><a>系统管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">


                <li>
                    <span><a href="dxAdd.jsp" target="hsgmain">介绍添加</a></span>
                </li>
                <li>
                    <span><a href="dxMana" target="hsgmain">介绍查询</a></span>
                </li>

                <li>
                    <span><a href="liuyanMana" target="hsgmain">留言查询</a></span>
                </li>

            </ul>
        </li>


    </ul>
</div>
</body>
</html>





