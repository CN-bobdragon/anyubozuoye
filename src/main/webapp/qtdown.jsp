<%@ page language="java" pageEncoding="UTF-8" %>
<div class="footer">
    <div class="container">
        <p class="footer_add">友情链接:</p>
        <p class="footer_cell" id="yqlj">
        </p>
    </div>
</div>

<script type="text/javascript">
    $.get(basePath + '/lianjieAll/', function(resp) {
        if (resp.success) {
            if(resp.data!=null){
                var list = resp.data;
                var yqljHtml = [];
                for(var i=0; i<list.length; i++){
                    var info = list[i];
                    yqljHtml.push('<span><a style="color:white" target="_blank" href="'+info.url+'">'+info.name+'</a></span>');
                }
                $("#yqlj").empty().html(yqljHtml.join(''));
            }
        }else {
            alert(resp.message);
        }
    });
    coolsite360 = {
        PlayerPlugins: []
    };
</script>
<script src="${staticPath}/qtimages/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="${staticPath}/qtimages/jarallax.min.js"></script>
<script src="${staticPath}/qtimages/headroom.min.js"></script>
<script src="${staticPath}/qtimages/jQuery.headroom.min.js"></script>
<script src="${staticPath}/qtimages/jquery.fancybox.min.js"></script>
<script type="text/javascript" src="${staticPath}/qtimages/vendor_c.bundle.built.e43e22b1.cache.js"></script>
<script type="text/javascript" src="${staticPath}/qtimages/pack.built.76b478c1.cache.js"></script>
<script type="text/javascript" src="${staticPath}/qtimages/cst.built.438db8a8.cache.js"></script>
<script src="${staticPath}/qtimages/fakeLoader.min.js"></script>
<script src="${staticPath}/qtimages/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="${staticPath}/qtimages/scrrol.js" type="text/javascript" charset="utf-8"></script>
<script src="${staticPath}/qtimages/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="${staticPath}/qtimages/jquery.touchSwipe.min.js"></script>
<script>
    var currentPage = 1;
    document.body.addEventListener('touchstart', function () {
    });
    $('#myCarousel').carousel({
        interval: 4000
    });
    $("#myCarousel").swipe({
        swipeLeft: function () {
            $(this).carousel('next');
        },
        swipeRight: function () {
            $(this).carousel('prev');
        },
    });
</script>