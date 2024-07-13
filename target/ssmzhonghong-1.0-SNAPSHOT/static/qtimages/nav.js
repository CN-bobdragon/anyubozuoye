$(document).ready(function(){
//	var currentPage = 1;
	$('#li-'+currentPage).children(".cbnavl_pcnavsec").addClass('currentPage_on');
//	$("#box-"+currentPage).remove();
//  $(".ph_bb").eq(currentPage-1).addClass("ph_cur").siblings().removeClass("ph_cur");
    var num;
    $('.c-navlist>li[id]').hover(function(){
       /*一级导航*/
        $(this).children(".cbnavl_pcnavsec").addClass('pcnav_on');
        $(this).addClass('pcnav_lion');
        /*下拉框出现*/
        var Obj = $(this).attr('id');
        num = Obj.substring(3, Obj.length);
        $('#box-'+num).slideDown(300);
    },function(){
        /*一级导航*/
        $(this).children(".cbnavl_pcnavsec").removeClass('pcnav_on');
        $(this).removeClass('pcnav_lion');
        /*下拉框消失*/
        $('#box-'+num).hide();
    });
//    hidden-box hover e
    $('.hidden-box').hover(function(){
        $('#li-'+num).children(".cbnavl_pcnavsec").addClass('pcnav_on');
        $('#li-'+num).addClass('pcnav_lion');
        $(this).show();
    },function(){
        $(this).slideUp(200);
        $('#li-'+num).children(".cbnavl_pcnavsec").removeClass(".pcnav_on");
        $('#li-'+num).removeClass("pcnav_lion");
    });
    $(".g-navbar-toggle").click(function() {
    		$(".ph_navdrop1").slideToggle();
    })
    $(".ph_navdrop1>li>p").click(function() {
    		$(this).children("img").toggleClass("hover-up");
    		$(this).next().slideToggle();
    });
 
});
$(".g-btn-search").click(function() {
	$(".g-form-search .g-form-search-input").css("display","inline-block").focus();
	$(this).css("display","none");
});
$(".g-form-search .g-form-search-input").blur(function() {
	
	$(".g-btn-search").css("display","inline-block");
	$(this).fadeOut(500);
});

