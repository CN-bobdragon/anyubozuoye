<%@ page language="java" pageEncoding="UTF-8" %>
<div id="myCarousel" class="carousel slide carousel-add">
    <ol class="carousel-indicators" id="olIndex">
    </ol>
    <div class="carousel-inner" id="divLunbo">
    </div>
</div>
<script type="text/javascript">
    $.get(basePath + '/lunboAll/', function (resp) {
        if (resp.success) {
            if (resp.data != null) {
                var list = resp.data;
                var olHtml = [];
                var divHtml = [];
                for (var i = 0; i < list.length; i++) {
                    var info = list[i];
                    olHtml.push('<li data-target="#myCarousel" data-slide-to="'+i+'" class="');
                    divHtml.push('<div class="item');
                    if (i == 0) {
                        olHtml.push('active"></li>');
                        divHtml.push(' active">');
                    }else {
                        olHtml.push('"></li>');
                        divHtml.push('">');
                    }
                    divHtml.push('<img src="${contextPath}/' + info.image + '" class="hidden-xs" style="height: 400px" /></div>');
                }
                $("#olIndex").empty().html(olHtml.join(''));
                $("#divLunbo").empty().html(divHtml.join(''));
            }
        } else {
            alert(resp.message);
        }
    });
</script>