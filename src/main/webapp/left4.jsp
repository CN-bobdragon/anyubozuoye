<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%request.setCharacterEncoding("utf-8");%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8">
    <title>左边导航</title>
    <link rel="stylesheet" type="text/css" href="images/reset.css"/>
    <link rel="stylesheet" type="text/css" href="images/common.css"/>
    <script type="text/javascript" src="images/jquery-1.8.3.min.js"></script>
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
                    <span><a href="usersAdd.jsp" target="hsgmain">用户添加</a></span>
                </li>
                <li>
                    <span><a href="usersMana.action" target="hsgmain">用户查询</a></span>
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
                    <span><a href="lunboMana.action" target="hsgmain">轮播查询</a></span>
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
                    <span><a href="gonggaoMana.action" target="hsgmain">公告查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>政策管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="zhengceAdd.jsp" target="hsgmain">政策添加</a></span>
                </li>
                <li>
                    <span><a href="zhengceMana.action" target="hsgmain">政策查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>农产品管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="leibieAdd.jsp" target="hsgmain">类别添加</a></span>
                </li>
                <li>
                    <span><a href="leibieMana.action" target="hsgmain">类别查询</a></span>
                </li>

                <li>
                    <span><a href="shangpinAdd.jsp" target="hsgmain">农产品添加</a></span>
                </li>
                <li>
                    <span><a href="shangpinMana.action" target="hsgmain">农产品查询</a></span>
                </li>

                <li>
                    <span><a href="shoucangMana.action" target="hsgmain">收藏查询</a></span>
                </li>
                <li>
                    <span><a href="chanpinpingjiaMana.action" target="hsgmain">评论查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>订单管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <%--<li>
                    <span><a href="dingdanAdd.jsp" target="hsgmain">订单添加</a></span>
                </li>--%>
                <li>
                    <span><a href="dingdanMana.action" target="hsgmain">订单查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>支付方式管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="zhifufangshiAdd.jsp" target="hsgmain">支付方式添加</a></span>
                </li>
                <li>
                    <span><a href="zhifufangshiMana.action" target="hsgmain">支付方式查询</a></span>
                </li>

            </ul>
        </li>
        <li>
            <div class="nav_m">
                <span><a>售后管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="shouhouAdd.jsp" target="hsgmain">售后添加</a></span>
                </li>
                <li>
                    <span><a href="shouhouMana.action" target="hsgmain">售后查询</a></span>
                </li>

            </ul>
        </li>
        <%--<li>
            <div class="nav_m">
                <span><a>系统管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="usersAdd.jsp" target="hsgmain">友情连接添加</a></span>
                </li>
                <li>
                    <span><a href="usersMana.action" target="hsgmain">友情连接查询</a></span>
                </li>

            </ul>
        </li>--%>
        <li>
            <div class="nav_m">
                <span><a>系统管理</a></span>
                <i>&nbsp;</i>
            </div>
            <ul class="erji">
                <li>
                    <span><a href="lianjieAdd.jsp" target="hsgmain">友情连接添加</a></span>
                </li>
                <li>
                    <span><a href="lianjieMana.action" target="hsgmain">友情连接查询</a></span>
                </li>

                <li>
                    <span><a href="dxAdd.jsp" target="hsgmain">介绍添加</a></span>
                </li>
                <li>
                    <span><a href="dxMana.action" target="hsgmain">介绍查询</a></span>
                </li>

                <li>
                    <span><a href="liuyanMana.action" target="hsgmain">留言查询</a></span>
                </li>

            </ul>
        </li>


    </ul>
</div>
</body>
</html>





