<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="common/head.jsp" %>
    <title>首页</title>
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
    <script type="text/javascript" src="${staticPath}/index/js/swiper.min.js"></script>
    <link href="${staticPath}/index/css/swiper.min.css" rel="stylesheet">
</head>
<body>

<!--新头部的开始-->
<%@ include file="qttop.jsp" %>
<!--新头部的结束-->
<!--ban图片切换开始-->
<%@ include file="bht.jsp"%>
<!--ban图片切换结束-->
<!--主体内容的开始-->
<div class="dy-index-home-div" style="padding: 10px 0">
    <!--图片列表 样式1 -->
    <div class="dy-index-home-tp-list-div">
        <div class="dy-index-home-tp-list-title-div">
            <span class="dy-index-home-tp-list-title-span">公告信息</span>
        </div>
        <!-- 图片数据列表 -->
        <div class="dy-index-home-tp-list-item-div">
            <c:forEach items="${gonggaoList}" var="info" varStatus="s" begin="0" end="3">
                <div class="dy-index-home-tp-list-div-box" onclick="toDetail('gonggao',${info.id})">
                    <img class="dy-index-home-tp-list-div-box-item-img"
                         src="${contextPath}/${info.tupian}"/>
                    <div class="dy-index-home-tp-list-div-box-item-info">
                        <div class="dy-index-home-tp-list-div-box-item-mingcheng">
                                ${info.biaoti}
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="dy-index-home-more-div" onclick="moreBtn('gonggaoManaQiantp')">
            <span>查看更多</span>
            <i class="el-icon-d-arrow-right"></i>
        </div>
    </div>

    <!--图片列表 样式2 -->
    <div class="dy-index-home-tp-list2-div">
        <div class="dy-index-home-tp-list2-title-div">
            <span class="dy-index-home-tp-list2-title-span">推荐商品</span>
        </div>
        <div class="dy-index-home-tp-list2-info-div">
            <c:forEach items="${gonggaoList}" var="info" varStatus="s" begin="0" end="0">
                <div class="dy-index-home-tp-list2-info-first-div" onclick="toDetail('gonggao',${info.id})">
                    <img src="${contextPath}/${info.tupian}"/>
                    <div class="dy-index-home-tp-list2-info-title-div">
                        <div>
                                ${info.biaoti}
                        </div>
                    </div>
                </div>
            </c:forEach>
            <div class="dy-index-home-tp-list2-info-div-2">
                <c:forEach items="${gonggaoList}" var="info" varStatus="s" begin="1" end="1">
                    <div class="dy-index-home-tp-list2-info-item-div-2"
                         onclick="toDetail('gonggao',${info.id})">
                        <img src="${contextPath}/${info.tupian}"/>
                        <div class="dy-index-home-tp-list2-info-title-div">
                            <div>
                                    ${info.biaoti}
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <c:forEach items="${gonggaoList}" var="info" varStatus="s" begin="2" end="2">
                    <div class="dy-index-home-tp-list2-info-item-div-2" style="float: right;"
                         onclick="toDetail('gonggao',${info.id})">
                        <img src="${contextPath}/${info.tupian}"/>
                        <div class="dy-index-home-tp-list2-info-title-div">
                            <div>
                                    ${info.biaoti}
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="dy-index-home-tp-list2-info-div-2">
                <c:forEach items="${gonggaoList}" var="info" varStatus="s" begin="3" end="3">
                    <div class="dy-index-home-tp-list2-info-item-div-2"
                         onclick="toDetail('gonggao',${info.id})">
                        <img src="${contextPath}/${info.tupian}"/>
                        <div class="dy-index-home-tp-list2-info-title-div">
                            <div>
                                    ${info.biaoti}
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <c:forEach items="${gonggaoList}" var="info" varStatus="s" begin="4" end="4">
                    <div class="dy-index-home-tp-list2-info-item-div-2" style="float: right;"
                         onclick="toDetail('gonggao',${info.id})">
                        <img src="${contextPath}/${info.tupian}"/>
                        <div class="dy-index-home-tp-list2-info-title-div">
                            <div>
                                    ${info.biaoti}
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div onclick="moreBtn('gonggaoManaQiantp')" class="dy-index-home-more-div-2">
            <span>查看更多>></span>
        </div>
    </div>

    <!-- 图片列表 样式3 -->
    <div class="dy-index-home-tp-list3-div" style="display: block;">
        <div class="dy-index-home-tp-list3-title-div">
            <span class="dy-index-home-tp-list3-title-span">商品展示</span>
        </div>
        <div>
            <div id="dySwiper" class="swiper-container dy-index-home-tp-list3-swiper">
                <div class="swiper-wrapper">
                    <c:forEach items="${gonggaoList}" var="info" varStatus="s">
                        <div class="swiper-slide" onclick="toDetail('gonggao',${info.id})">
                            <img src="${contextPath}/${info.tupian}"/>
                            <p>${info.biaoti}</p>
                        </div>
                    </c:forEach>
                </div>
                <div class="swiper-button-next"></div>
                <div class="swiper-button-prev"></div>
            </div>
            <script type="text/javascript">
                setTimeout(function () {
                        new Swiper('#dySwiper', {
                            loop: true,
                            speed: 500,
                            slidesPerView: Number(3),
                            spaceBetween: Number(10),
                            autoplay: {"delay": 3000, "disableOnInteraction": false},
                            centeredSlides: true,
                            watchSlidesProgress: true,
                            on: {
                                setTranslate: function () {
                                    var slides = this.slides
                                    for (var i = 0; i < slides.length; i++) {
                                        var slide = slides.eq(i)
                                        var progress = slides[i].progress
                                        slide.css({
                                            'opacity': '',
                                            'background': ''
                                        });
                                        slide.transform(''); //清除样式
                                        slide.transform('scale(' + (1.5 - Math.abs(progress) / 4) + ')');
                                    }
                                },
                                setTransition: function (transition) {
                                    for (var i = 0; i < this.slides.length; i++) {
                                        var slide = this.slides.eq(i)
                                        slide.transition(transition);
                                    }
                                },
                            },
                            navigation: {"nextEl": ".swiper-button-next", "prevEl": ".swiper-button-prev"},
                        });
                    }
                    , 100);
            </script>
        </div>
        <div class="dy-index-home-more-div-3" onclick="moreBtn('gonggaoManaQiantp')">
            <span>查看更多>></span>
        </div>
    </div>

    <!--文字列表 样式1 -->
    <div class="dy-index-home-wz-list-div">
        <div class="dy-index-home-wz-list-title-div">
            <span class="dy-index-home-wz-list-title-span">介绍</span>
        </div>
        <div class="dy-index-home-wz-list-item-info-div">
            <c:forEach items="${dxList}" var="info" varStatus="s" begin="0" end="0">
                <div class="dy-index-home-wz-list-item-first-info-div" onclick="toDetail('dx',${info.id})">
                    <img id="img1" src="${staticPath}/index/images/index-home-list-1.jpg"/>
                    <div class="dy-index-home-wz-list-item-first-info-title-div">${info.leibie}</div>
                    <div class="dy-index-home-wz-list-item-first-info-time-div">${info.addtime}</div>
                    <div style="display: -webkit-box;margin-bottom: 6px;overflow: hidden; white-space: normal; text-overflow: ellipsis;-webkit-box-orient: vertical;-webkit-line-clamp: 3;"
                         class="dy-index-home-wz-list-item-first-info-content-div">
                            ${info.content}
                    </div>
                </div>
                <script type="text/javascript" defer>
                    function initImg() {
                        var images = ['index-home-list-1.jpg', 'index-home-list-2.jpg', 'index-home-list-3.jpg', 'index-home-list-4.jpg', 'index-home-list-5.jpg'];
                        var randomIndex = Math.floor(Math.random() * images.length);
                        document.getElementById("img1").src = staticPath + "/index/images/" + images[randomIndex];
                        ;
                    }

                    initImg();
                </script>
            </c:forEach>

            <div class="dy-index-home-wz-list-item-other-info-div">
                <c:forEach items="${dxList}" var="info" varStatus="s" begin="1" end="3">
                    <div class="dy-index-home-wz-list-item-other-info-detail-div"
                         onclick="toDetail('dx',${info.id})">
                        <div class="dy-index-home-wz-list-item-other-info-title-div">
                                ${info.leibie}
                        </div>
                        <div class="dy-index-home-wz-list-item-other-info-time-div">
                                ${info.addtime}
                        </div>
                        <div style="display: -webkit-box;margin-bottom: 6px;overflow: hidden; white-space: normal; text-overflow: ellipsis;-webkit-box-orient: vertical;-webkit-line-clamp: 3;"
                             class="dy-index-home-wz-list-item-other-info-content-div">
                                ${info.content}
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <div class="dy-index-home-more-div" onclick="moreBtn('dxManaQian')">
            <span>查看更多>></span>
        </div>
    </div>

    <!--文字列表 样式2 -->
    <div class="dy-index-home-wz-list2-div">
        <div class="dy-index-home-wz-list2-title-div">
            <span class="dy-index-home-wz-list2-title-span">介绍</span>
        </div>
        <div class="dy-index-home-wz-list2-info-div">
            <c:forEach items="${dxList}" var="info" varStatus="s" begin="0" end="3">
                <div class="dy-index-home-wz-list2-item-div" onclick="toDetail('dx',${info.id})">
                    <div class="dy-index-home-wz-list2-item-title-div">${info.leibie}</div>
                    <div class="dy-index-home-wz-list2-item-title2-div">${info.addtime}</div>
                    <div style="display: -webkit-box;margin-bottom: 6px;overflow: hidden; white-space: normal; text-overflow: ellipsis;-webkit-box-orient: vertical;-webkit-line-clamp: 2;"
                         class="dy-index-home-wz-list2-item-content-div">
                            ${info.content}
                    </div>
                    <div class="dy-index-home-wz-list2-item-title3-div">0${s.index +1 }</div>
                </div>
            </c:forEach>
        </div>
        <div class="dy-index-home-wz-list2-more-div" onclick="moreBtn('dxManaQian')">
            <span>查看更多</span>
        </div>
    </div>
</div>
<!--主体内容的结束-->
<!--底部的开始-->
<%@ include file="qtdown.jsp" %>
<!--底部的结束-->
</body>
<style type="text/css">
    /*首页*/
    .dy-index-home-div {
        width: 1250px;
        margin: 10px auto;
        justify-content: space-between;
        flex-wrap: wrap;
        background: none;
        display: flex;
    }

    /*首页 图片列表 样式1*/
    .dy-index-home-tp-list-div {
        width: 100%;
        margin: 10px auto;
        position: relative;
        background: #faf0e6;
    }

    .dy-index-home-tp-list-title-span {
        text-shadow: 0px 0px 0px #eee;
        color: #333333;
        font-size: 26px;
        font-weight: bold;
    }

    /* 首页 图片列表 样式1 box */
    .dy-index-home-tp-list-div-box {
        border: 1px solid #33553f;
        border-radius: 16px;
        padding: 8px;
        margin: 10px 3px 10px 9px;
        flex-wrap: wrap;
        background: #fff;
        display: flex;
        font-size: 14px;
        position: relative;
        justify-content: center;
        width: 23.9%;
        height: auto;
        float: left;
    }

    /* 首页 图片列表 样式1 box 图片 */
    .dy-index-home-tp-list-div-box-item-img {
        cursor: pointer;
        object-fit: cover;
        display: inline-block;
        width: 100%;
        height: 240px;
    }

    /* 首页 图片列表 样式1 box info */
    .dy-index-home-tp-list-div-box-item-info {
        cursor: pointer;
        padding: 20px 20px 0;
        overflow: hidden;
        background: #fff;
        text-align: center;
        display: inline-block;
        width: 80%;
        height: 60px;
    }

    /* 首页 图片列表 样式1 box 名称 */
    .dy-index-home-tp-list-div-box-item-mingcheng {
        border: 1px solid #eee;
        border-radius: 10px;
        padding: 4px 10px;
        margin: 0 0 10px;
        white-space: nowrap;
        overflow: hidden;
        font-weight: bold;
        font-size: 14px;
        text-overflow: ellipsis;
        color: #333;
        text-align: center;
        display: inline-block;
        width: 100%;
        line-height: 28px;
    }

    /* 首页 图片列表 样式1 box 价格 */
    .dy-index-home-tp-list-div-box-item-price {
        color: #f00;
        font-size: 12px;
    }

    /* 列表页 图片列表 box 图片 鼠标悬浮 */
    .dy-index-home-tp-list-div img:hover {
        -webkit-perspective: 1000px;
        perspective: 1000px;
        opacity: 0.75;
        transition: all 0.3s ease-in-out 0s;
    }

    /*首页 图片列表 样式1 标题*/
    .dy-index-home-tp-list-title-div {
        width: 100%;
        padding: 0px 7%;
        margin: 10px auto 0px;
        line-height: 54px;
        background: none;
        text-align: left;
        color: #202020;
        font-size: 20px;
        font-weight: bold;
    }

    /*首页 图片列表 样式1 内容*/
    .dy-index-home-tp-list-info-div {
        width: 100%;
        padding: 20px 7% 40px;
        flex-wrap: wrap;
        display: flex;
        background: none;
        /*justify-content: pace-between;*/
        height: auto;
    }

    /*首页 图片列表 样式1 列表项*/
    .dy-index-home-tp-list-item-div {
        padding: 20px 10px 40px;
        width: 100%;
        height: 380px;
    }


    /*首页 图片列表 样式2*/
    .dy-index-home-tp-list2-div {
        border: 0px solid #dfdfdf;
        box-shadow: 0px 0px 0px #eee;
        padding: 0;
        margin: 10px auto;
        overflow: hidden;
        border-radius: 10px;
        background: #faf0e6;
        width: 100%;
        position: relative;
        height: auto;
    }

    /*首页 图片列表 样式2 标题 div */
    /*首页 图片列表 样式2 标题 span*/
    .dy-index-home-tp-list2-title-span {
        padding: 8px 50px 8px 20px;
        background: linear-gradient(135deg, rgba(17, 112, 210, 1) 0%, rgba(8, 179, 68, 1) 100%);
        text-shadow: 0px 0px 0px #eee;
        color: #fff;
        font-size: 30px;
        font-weight: bold;
    }

    /*首页 图片列表 样式2 列表*/
    .dy-index-home-tp-list2-info-div {
        width: 98%;
        padding: 0px;
        margin: 40px auto;
        overflow: hidden;
        background: none;
        height: auto;
    }

    .dy-index-home-tp-list2-title-div {
        padding: 0;
        margin: 50px auto 20px 10px;
        background: none;
        text-align: left;
        line-height: 1;
        position: relative;
    }


    /*首页 图片列表 样式2 列表 首条信息*/
    .dy-index-home-tp-list2-info-first-div {
        cursor: pointer;
        border-radius: 4px;
        width: 48%;
        margin: 0 0px;
        float: left;
        position: relative;
        background: #fff;
        height: 560px;
    }

    /*首页 图片列表 样式2 列表 首条信息 图片*/
    .dy-index-home-tp-list2-info-first-div img {
        width: 100%;
        object-fit: cover;
        float: left;
        border-radius: 8px 8px 0 0;
        height: 92%;
    }

    /*首页 图片列表 样式2 列表 首条信息 图片 鼠标悬浮*/
    .dy-index-home-tp-list2-info-first-div img:hover {
        filter: brightness(1.1);
        -webkit-perspective: 1000px;
        perspective: 1000px;
        transition: all 0.3s ease-in-out 0s;
    }

    /*首页 图片列表 样式2 列表 标题*/
    .dy-index-home-tp-list2-info-title-div {
        white-space: nowrap;
        color: #fff;
        text-align: center;
        bottom: 0;
        overflow: hidden;
        border-radius: 0 0 8px 8px;
        left: 0;
        background: rgba(0, 0, 0, .3);
        width: 100%;
        line-height: 44px;
        font-size: 16px;
        position: absolute;
        text-overflow: ellipsis;
    }


    /*首页 图片列表 样式2 列表2*/
    .dy-index-home-tp-list2-info-div-2 {
        width: 51%;
        margin: 0 0 10px;
        float: right;
        background: none;
        height: 275px;
    }

    /*首页 图片列表 样式2 列表2 信息*/
    .dy-index-home-tp-list2-info-item-div-2 {
        cursor: pointer;
        margin: 0;
        border-radius: 4px;
        background: #fff;
        width: 49%;
        position: relative;
        float: left;
        height: 275px;
    }

    /*首页 图片列表 样式2 列表2 信息 图片*/
    .dy-index-home-tp-list2-info-div-2 img {
        width: 100%;
        object-fit: cover;
        border-radius: 8px 8px 0 0;
        float: left;
        height: 83%;
    }

    /*首页 图片列表 样式2 列表2 信息 图片 鼠标悬浮*/
    .dy-index-home-tp-list2-info-div-2 img:hover {
        filter: brightness(1.1);
        transform: rotate(0deg);
        -webkit-perspective: 1000px;
        perspective: 1000px;
        opacity: 0.75;
        transition: all 0.3s ease-in-out 0s;
    }


    /*首页 列表 样式1 查看更多*/
    .dy-index-home-more-div {
        cursor: pointer;
        border: 1px solid #999;
        padding: 0 16px;
        margin: 20px auto 0px;
        top: 0px;
        text-align: center;
        color: #333;
        font-size: 14px;
        background: none;
        display: inline-block;
        width: auto;
        line-height: 30px;
        position: absolute;
        right: 7%;
    }


    /*首页 列表 样式2 查看更多*/
    .dy-index-home-more-div-2 {
        border: 0px solid #ffa100;
        cursor: pointer;
        box-shadow: 0px 0px 0px #ddd5c6, inset 0px 0px 0px 0px #ffa100;
        margin: 40px auto 40px;
        border-radius: 0px;
        text-align: center;
        background: url(${staticPath}/index/images/index-home-list2-more-bg.png) repeat-x;
        display: block;
        width: 88%;
        line-height: 44px;
    }

    /*首页 列表 样式2 查看更多 span*/
    .dy-index-home-more-div-2 span {
        padding: 0 0 0 10px;
        border-color: #ccc;
        margin: 0;
        color: #333;
        background: #eee;
        border-width: 1px 0 1px 1px;
        display: inline-block;
        width: 100px;
        font-size: 16px;
        line-height: 44px;
        border-style: solid;
        height: 44px;
    }

    /*首页 列表 样式2 查看更多 i */
    .dy-index-home-more-div-2 i {
        padding: 0 20px 0 0;
        border-color: #ccc;
        margin: 0 0 0 -10px;
        color: #333;
        border-width: 1px 1px 1px 0px;
        background: #eee;
        display: inline-block;
        width: 40px;
        font-size: 16px;
        line-height: 44px;
        border-style: solid;
        height: 44px;
    }

    /*首页 图片列表 样式3*/
    .dy-index-home-tp-list3-div {
        border: 0px solid #dfdfdf;
        border-radius: 10px;
        box-shadow: 0px 0px 0px #eee;
        height: auto;
        padding: 30px 7%;
        margin: 10px auto;
        overflow: hidden;
        background: linear-gradient(180deg, rgba(209, 238, 254, 1) 0%, rgba(252, 253, 254, 1) 40%, rgba(252, 253, 254, 1) 100%);
        width: 100%;
        position: relative;

    }

    /*首页 图片列表 样式3 标题 div  */
    .dy-index-home-tp-list3-title-div {
        margin: 0 auto 20px;
        align-items: center;
        background: url(${staticPath}/index/images/index-home-list3-title-bg.png) no-repeat center bottom;
        display: flex;
        width: 100%;
        line-height: 50px;
        justify-content: center;
    }

    /*首页 图片列表 样式3 标题 span  */
    .dy-index-home-tp-list3-title-span {
        padding: 0 0 30px;
        font-size: 32px;
        line-height: 50px;
        color: #111;
    }

    /*首页 图片列表 样式3 swiper组件  */
    .dy-index-home-tp-list3-swiper {
        width: 100%;
        padding: 50px 10px;
        margin: 40px 0 0;
        background: none;
        text-align: center;
    }

    /*首页 图片列表 样式3 swiper组件 图片 */
    .dy-index-home-tp-list3-swiper img {
        cursor: pointer;
        border: 0;
        width: 200px;
        padding: 20px 10px;
        background: url(${staticPath}/index/images/index-home-list3-img-bg.png) no-repeat center top / 100% 100%;
        height:200px;
    }

    /*首页 图片列表 样式3 swiper组件 p */
    .dy-index-home-tp-list3-swiper p {
        cursor: pointer;
        line-height: 24px;
        margin: 0;
        padding: 0;
        text-align: center;
        color: #636363;
        font-size: 16px;
    }

    /*首页 图片列表 样式3 swiper组件 span */
    .dy-index-home-tp-list3-swiper span {
        cursor: pointer;
        font-size: 12px;
        color: #f00;
    }

    /*首页 图片列表 样式3 swiper组件 向左箭头按钮 */
    .swiper-button-prev {
        left: 10px;
        right: auto;
        color: #55b44b;
    }

    /*首页 图片列表 样式3 swiper组件 向右箭头按钮 */
    .swiper-button-next {
        left: auto;
        right: 10px;
        color: #55b44b;
    }

    /*首页 列表 样式3 查看更多*/
    .dy-index-home-more-div-3 {
        border: 0;
        padding: 0 20px;
        margin: 40px auto 50px;
        text-align: center;
        background: none;
        display: inline-block;
        width: 100%;
        line-height: 40px;
    }

    /*首页 列表 样式3 查看更多 span*/
    .dy-index-home-more-div-3 span {
        cursor: pointer;
        color: #3e97c6;
        font-size: 18px;
    }

    /*首页 列表 样式3 查看更多 i */
    .dy-index-home-more-div-3 i {
        cursor: pointer;
        color: #3e97c6;
        font-size: 18px;
    }


    /*首页 文字列表 样式1 列表*/
    .dy-index-home-wz-list-div {
        padding: 2px 1px 40px;
        margin: 10px auto;
        flex-wrap: wrap;
        display: flex;
        position: relative;
        background: url(${staticPath}/index/images/index-home-list-bg.png) no-repeat center top, #fff;
        width: 100%;
        min-height: 520px;
        cursor: pointer;
    }

    /*首页 图片列表 样式1 标题*/
    .dy-index-home-wz-list-title-div {
        width: 100%;
        padding: 0px 1%;
        margin: 1px auto 0px;
        line-height: 54px;
        background: none;
        text-align: left;
        color: #202020;
        font-size: 20px;
        font-weight: bold;
    }

    /*首页 文字列表 样式1 标题 span */
    .dy-index-home-wz-list-title-span {
        margin: 0 0 0 2px;
        padding: 0 1px;
        text-shadow: 0px 0px 0px #eee;
        color: #333333;
        font-size: 26px;
        font-weight: bold;
    }

    /*首页 文字列表 样式1 列表 信息*/
    .dy-index-home-wz-list-item-info-div {
        padding: 10px 1% 40px;
        justify-content: space-between;
        flex-wrap: wrap;
        display: flex;
        background: none;
        width: 100%;
        min-height: auto;
    }

    /*首页 文字列表 样式1 列表 首条信息*/
    .dy-index-home-wz-list-item-first-info-div {
        margin: 0 0px;
        position: relative;
        background: none;
        width: 48%;
        height: auto;
    }

    /*首页 文字列表 样式1 列表 首条信息 图片*/
    .dy-index-home-wz-list-item-first-info-div img {
        border: 6px solid #cca162;
        width: 100%;
        object-fit: cover;
        display: block;
        height: 220px;
    }

    /*首页 文字列表 样式1 列表 首条信息 标题*/
    .dy-index-home-wz-list-item-first-info-title-div {
        padding: 16px 0px 8px;
        width: calc(100% - 80px);
        font-size: 20px;
        line-height: 28px;
        color: #b58339;
    }

    /*首页 文字列表 样式1 列表 首条信息 时间*/
    .dy-index-home-wz-list-item-first-info-time-div {
        padding: 4px 8px;
        width: 140px;
        font-size: 12px;
        line-height: 24px;
        color: #fff;
        background: #cca162;
    }

    /*首页 文字列表 样式1 列表 首条信息 内容*/
    .dy-index-home-wz-list-item-first-info-content-div {
        padding: 0 10px;
        overflow: hidden;
        font-size: 14px;
        text-indent: 2em;
        line-height: 24px;
        color: #555;
        height: 72px;
    }

    /*首页 文字列表 样式1 列表 非首条信息*/
    .dy-index-home-wz-list-item-other-info-div {
        padding: 0 0 0 120px;
        margin: 0 0px;
        background: url(${staticPath}/index/images/index-home-wz-list-bg.png) no-repeat left top;
        flex-direction: column;
        display: block;
        width: 48%;
        position: relative;
        justify-content: space-between;
        height: 400px;
    }

    /*首页 文字列表 样式1 列表 非首条信息项*/
    .dy-index-home-wz-list-item-other-info-detail-div {
        width: 100%;
        margin: 0 0 55px;
        position: relative;
        background: none;
        height: 100px;
    }

    /*首页 文字列表 样式1 列表 非首条信息 标题*/
    .dy-index-home-wz-list-item-other-info-title-div {
        padding: 0;
        white-space: nowrap;
        overflow: hidden;
        width: calc(100% - 80px);
        font-size: 20px;
        line-height: 1;
        text-overflow: ellipsis;
        color: #b58339;
    }

    /*首页 文字列表 样式1 列表 非首条信息 时间*/
    .dy-index-home-wz-list-item-other-info-time-div {
        font-size: 12px;
        line-height: 1;
        color: #b89e66;
        top: 2px;
        position: absolute;
        right: 20px;
    }

    /*首页 文字列表 样式1 列表 非首条信息 内容*/
    .dy-index-home-wz-list-item-other-info-content-div {
        padding: 0 0px;
        margin: 5px auto 0;
        overflow: hidden;
        font-size: 14px;
        text-indent: 2em;
        line-height: 24px;
        color: #555;
        width: calc(100% - 0px);
        height: 72px;
    }

    /*首页 文字列表 样式2 列表*/
    .dy-index-home-wz-list2-div {
        padding: 20px 10px 40px;
        margin: 10px auto;
        flex-wrap: wrap;
        display: flex;
        position: relative;
        background: #fff;
        width: 100%;
        /*align-items:space-between;*/
        flex: 1;
        height: auto;
    }

    /*首页 文字列表 样式2 标题 div */
    .dy-index-home-wz-list2-title-div {
        margin: 0 auto 20px;
        top: 0;
        background: url(${staticPath}/index/images/index-home-wz-list2-title-bg.png) repeat-x center bottom, linear-gradient(0deg, rgba(182, 215, 222, 1) 0%, rgba(233, 248, 251, 1) 80%, rgba(207, 237, 244, 1) 100%), #b6d7de;
        display: flex;
        width: 100%;
        position: relative;
        height: 56px;
    }

    /*首页 文字列表 样式2 标题 span */
    .dy-index-home-wz-list2-title-span {
        margin: 0 0 0 20px;
        padding: 0 20px;
        background: url(${staticPath}/index/images/index-home-wz-list2-title-bg.png) center bottom repeat-x, linear-gradient(0deg, rgb(182, 215, 222) 0%, rgb(233, 248, 251) 80%, rgb(207, 237, 244) 100%), rgb(182, 215, 222);
        color: #202020;
        text-align: center;
        font-size: 18px;
        font-weight: 500;
        width: auto;
        line-height: 44px;
    }

    /*首页 列表 文字列表 样式2 查看更多*/
    .dy-index-home-wz-list2-more-div {
        cursor: pointer;
        border: 0;
        padding: 0 12px 0 20px;
        margin: 0 auto;
        bottom: 40px;
        left: 46%;
        text-align: center;
        background: none;
        display: inline-block;
        position: absolute;
        width: 44px;
        min-width: 120px;
        line-height: 40px;
    }

    /*首页 文字列表 样式2 列表 信息*/
    .dy-index-home-wz-list2-info-div {
        width: 100%;
        padding: 10px 20px 20px;
        flex-wrap: wrap;
        background: url(${staticPath}/index/images/index-home-wz-list2-info-bg.png) repeat-x center bottom / 50% auto;
        display: flex;
        height: auto;
    }

    /*首页 文字列表 样式2 列表项*/
    .dy-index-home-wz-list2-item-div {
        cursor: pointer;
        padding: 0 20px 0 60px;
        margin: 0 10px 20px 0;
        flex-wrap: wrap;
        background: none;
        display: flex;
        width: 100%;
        position: relative;
        height: 88px;
    }

    /*首页 文字列表 样式2 列表项 标题*/
    .dy-index-home-wz-list2-item-title-div {
        padding: 2px 10px;
        white-space: nowrap;
        overflow: hidden;
        color: #333;
        width: calc(100% - 140px);
        font-size: 14px;
        line-height: 24px;
        text-overflow: ellipsis;
        font-weight: 600;
        height: 24px;
    }

    /*首页 文字列表 样式2 列表项 副标题*/
    .dy-index-home-wz-list2-item-title2-div {
        color: #333;
        top: 0px;
        border-radius: 4px;
        text-align: center;
        background: linear-gradient(150deg, rgba(215, 238, 242, .3) 0%, rgba(255, 255, 255, .3) 50%, rgba(215, 238, 242, .3) 100%), #d7eef2;
        width: 150px;
        font-size: 12px;
        line-height: 24px;
        position: absolute;
        right: 0;
    }

    /*首页 文字列表 样式2 列表项 副标题3*/
    .dy-index-home-wz-list2-item-title3-div {
        padding: 4px 10px;
        color: #333;
        text-align: center;
        display: flex;
        justify-content: center;
        align-items: center;
        top: 0;
        left: 0;
        background: #d7eef2;
        width: 40px;
        font-size: 14px;
        line-height: 1.2;
        position: absolute;
        height: 100%;
    }

    /*首页 文字列表 样式2 列表项 内容*/
    .dy-index-home-wz-list2-item-content-div {
        padding: 4px 0;
        overflow: hidden;
        color: #666;
        width: 100%;
        font-size: 14px;
        line-height: 24px;
        text-indent: 2em;
        height: 48px;
    }
</style>
<script type="text/javascript">
    function toDetail(path, id) {
        window.location.href = "${contextPath}/" + path + "DetailQian/" + id;
    }

    function moreBtn(path) {
        window.location.href = "${contextPath}/" + path;
    }
</script>
</html>
