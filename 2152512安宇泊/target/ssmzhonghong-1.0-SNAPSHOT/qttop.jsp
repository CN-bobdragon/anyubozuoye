<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid cst_navcontainer cst_navfixed cst_Headroom c-section cbsect_65b0cdbf navChange headroom headroom--not-top headroom--unpinned headroom--bottom"
     data-c_spy="scroll" data-c_tl_id="tl_0fd52c25" data-offset="0" data-tolerance="0" id="section262cf66c"
     style="background-color: transparent; ">
    <div class="c-div div_cQh2kT">
        <div style="margin-bottom:-60px; height:30px; width:860px; margin-top:30px;z-index:999; position:relative;color:#999900; font-size:28px; font-weight:700;"
             align="center">
            学生社会实践管理网站
        </div>
        <div style="float:right; margin-top:0px; ">
            <c:if test="${sessionScope.user==null}">
                <a href="${contextPath}/userlog.jsp">登录</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${contextPath}/usersAddQian.jsp" >注册</a>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                ${sessionScope.user.loginname},[${sessionScope.user.typename}]&nbsp; <a href="${contextPath}/userlogout.jsp"
                                                                                        onclick="return confirm('确定要退出？')">退出</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${contextPath}/main.jsp" >个人中心</a>
            </c:if>
        </div>
        <div class="navbar-header">
            <a class="navbar-brand g-navbar-brand" href="${contextPath}/default.jsp">
               <%-- <img src="./qtimages/logo.png" style=" height: 80px; margin-top: -10px; margin-left:100px;"
                     alt="">--%>
            </a>
        </div>
        <%--<div class="g-navbar-collapse-search">
            <form class="navbar-form navbar-right g-form-search" method="get" action="">
                <div class="form-group new_navsearchInput_wrap">
                    <input type="text" name="keyword" class="form-control new_navsearchInput" placeholder="请输入关键词">
                    <i class="glyphicon glyphicon-search"></i>
                </div>
                <button type="submit" class="btn btn-default new_navsearchButton">搜索</button>
            </form>
            <a href="#" class="navbar-right g-navbar-english">English</a>
        </div>--%>
    </div>
    <nav class=" nav_style_01 c-navbar cbnavb_85edbd95 box-shadow-2">
        <div class="container cst_navcontainer cbnavc_c5076ba3" style="background-color: transparent; ">
            <div class="collapse navbar-collapse c-navcollapse nav_padding" data-c_e_id="navcollapsea6e6120e"
                 id="navmenu_a2997e40a12eddca">
                <ul class="nav navbar-nav c-navlist cbnavl_194a2a7a">


                    <li id="li-1" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec currentPage_on" data-c_spy="scroll" href="${contextPath}/default.jsp">
                            首页
                        </a>
                    </li>
                    <li id="li-4" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec" data-c_spy="scroll" href="${contextPath}/dxManaQian">
                            介绍
                        </a>
                    </li>
                    <li id="li-5" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec" data-c_spy="scroll" href="${contextPath}/gonggaoManaQiantp">
                            公告
                        </a>
                    </li>
                    <li id="li-8" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec" data-c_spy="scroll" href="${contextPath}/huodongManaQiantp">
                            社会实践
                        </a>
                    </li>
                    <li id="li-11" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec" data-c_spy="scroll" href="${contextPath}/xiaozuManaQiantp">
                            加入小组
                        </a>
                    </li>
                    <li id="li-3" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec" data-c_spy="scroll">
                            在线留言
                        </a>
                        <div id="box-3" class="hidden-box hidden-loc-index pc_nav_drop" style="display: none;">
                            <ul>

                                <li><a href='${contextPath}/liuyanAddQian.jsp'>在线留言</a></li>
                                <li><a href='${contextPath}/liuyanManaQian'>查看留言</a></li>
                            </ul>
                        </div>
                    </li>


                    <li id="li-100" class="c-navlistitem">
                        <a class="c-navlink  cbnavl_pcnavsec" data-c_spy="scroll" href="${contextPath}/login.jsp">
                            后台管理
                        </a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="navChange" style="height: 150px;"></div>