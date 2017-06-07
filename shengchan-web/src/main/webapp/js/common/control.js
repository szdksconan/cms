/*  */
/*  产贸已登录页面通用js2016-1-16*/


/*左侧菜单js*//*
$(".subNav").live("click",function(){
	if($(this).hasClass("currentDd")){
		$(this).removeClass("currentDd");
		$(this).addClass("currentDt");
		$(this).next(".navContent").slideDown(500);
		return;
	}
	if($(this).hasClass("currentDt")){
		$(this).removeClass("currentDt");
		$(this).addClass("currentDd");
		$(this).next(".navContent").slideUp(500);
		return;
	}
	if($(this).parent().find(".navContent li").hasClass("active")){
		$(this).parent().find(".navContent li").removeClass("active");
		return;
	}
});	*/
$(".subNavBox .navContent li").live("click",function(){
	$(this).addClass("active").siblings().removeClass("active");
	if($(this).parent().siblings(".navContent").find("li").hasClass("active")){
		$(this).parent().siblings(".navContent").find("li").removeClass("active");
	}
	if($(this).parent().siblings(".subNav").hasClass('a_css')){
		$(this).parent().siblings(".subNav").removeClass('a_css');
	}
});
$('.subNav').live('click',function(){
	$(this).addClass("a_css").siblings().removeClass("a_css");
	if($(this).siblings(".navContent").find("li").hasClass("active")){
		$(this).siblings(".navContent").find("li").removeClass("active");
	}
})

/* */
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        var userAgent = navigator.userAgent;
        var _doc;
        if (userAgent.indexOf("Chrome") > -1){
            _doc=iframe.ownerDocument;
        }else {
            _doc=iframeWin.document;
        }
        if (_doc.body) {
            iframe.height = _doc.documentElement.scrollHeight || _doc.body.scrollHeight;
        }
        //if (iframeWin.document.body) {
        //    iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        //}
    }
}
window.onload = function () {
    setIframeHeight(document.getElementById('house-frame'));
};

/*左右侧拉*/
$(function () {

    var flag = true;
    $(".hn_1").click(function () {
        if (!flag) {
            flag = true;
            $(this).children("img").attr('src', '../images/you_1.jpg');

            $(".cmao_daoleft").hide();
            $(".cmao_daohang").css({"background":"#f6f6f6","color":"#333333"});
        } else {
            flag = false;
            $(this).children("img").attr('src', '../images/zuo_1.jpg');

            $(".cmao_daoleft").show();
            $(".cmao_daohang").css({"background":"#ffffff","color":"#333333"});

        }

    });

});

/*第三级页面框架顶部搜索*/
$(function(){
	
    $(".cmao_b p").click(function(){
        var ul=$(".camo_bs");
        if(ul.css("display")=="none"){
            ul.slideDown();
        }else{
            ul.slideUp();
        }
    });

    $(".cmao_set").click(function(){
        var _name = $(this).attr("name");
        if( $("[name="+_name+"]").length > 1 ){
            $("[name="+_name+"]").removeClass("cmao_sel");
            $(this).addClass("cmao_sel");
        } else {
            if( $(this).hasClass("cmao_sel") ){
                $(this).removeClass("cmao_sel");
            } else {
                $(this).addClass("cmao_sel");
            }
        }
    });

    $(".cmao_b li").click(function(){
        var li=$(this).text();
        $(".cmao_b p").html(li);
        $(".camo_bs").hide();
        /*$(".cmao_set").css({background:'none'});*/
        $("p").removeClass("cmao_sel") ;
    });
});

/* 所有输入得失焦点*/
$("input").each(function(){
    $(this).focus(function(){
        if( $(this).val() == $(this).get(0).defaultValue ){
            $(this).val("");
        }
    });
    $(this).blur(function(){
        if( $(this).val() == "" ){
            $(this).val( $(this).get(0).defaultValue);
        }
    })
});

/* xialakuang*/
$(function(){
    $(".max-select .checked").click(function(){
        if($(this).next(".select").hasClass('none')){
            $(this).next(".select").addClass("none").removeClass('none');
            $(".drop-list .checked").removeClass('current');
            $(this).addClass('current');
        }else{
            $(this).next(".select").addClass('none');
            $(this).removeClass('current');
        }
        $(this).parents(".tab-content").scrollLeft(1000);
    })
    $(".drop-list").each(function(i){

        var $select = $(this).parent().find(".select");
        var $checked = $(this).find(".checked");
        $checked.on('click',function(){
            if($select.hasClass('none')){
                $(".dropdown-list .select").addClass("none").eq(i).removeClass('none');
                $(".drop-list .checked").removeClass('current').eq(i).addClass('current');
            }else{
                $select.addClass('none');
                $(this).removeClass('current');
            }
            return false;
        });
        $(document).on('click', function(e){
            $select.addClass('none');
            $checked.removeClass('current');
            e.stopPropagation();
        });
    });
    $(".dropdown-list .select li").live('click',function(){
        var txt = $(this).find('a').text();
        var $checkedBox = $(this).parents('.dropdown-list').find('.checked').find('a');
        var specialData = $(this).find('a').attr("specialData");
        $checkedBox.text(txt);
        $(this).parent().addClass('none');
        $(this).parents('.dropdown-list').find('.checked').removeClass('current');
        if(specialData != "undefined"){
            $checkedBox.html(specialData);
        }
        return false;
    });
});
