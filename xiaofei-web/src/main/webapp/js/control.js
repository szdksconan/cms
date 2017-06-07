/*  */
/*  产贸已登录页面通用js2016-1-16*/

$(".cmaoleft-menu .parent-menu").live('click', function() {
    var $cmaoleftMenu = $(this).parent();
    if ($cmaoleftMenu.hasClass("active")) {
        $cmaoleftMenu.removeClass("active").find('ul').slideUp('500');
    } else {
        $(".parent-menu").each(function() {
            if (!$(this).hasClass('no-child-menu')) {
                $(this).parent().removeClass('active');
            }
        });
        $(".cmaoleft-menu ul").slideUp('500');
        $cmaoleftMenu.addClass("active").find('ul').slideDown('500');
    }
    if ($(this).hasClass('no-child-menu')) {
        $(".cmaoleft-menu").removeClass('active');
        $(".cmaoleft-menu .submenu li").removeClass("active");
        $cmaoleftMenu.addClass('active');
    }
});

$(".cmaoleft-menu .submenu li").live('click', function() {
    var clickElement = $(this).is("li") ? $(this) : $(this).parent();
    $(".cmaoleft-menu").removeClass('active');
    $(this).parents('.cmaoleft-menu').addClass('active');
    $(".cmaoleft-menu .submenu li").removeClass("active");
    clickElement.addClass("active");
    $(".camo_rightbar").find("iframe").attr("src", clickElement.find("a").attr("href"));
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
            $(this).val( $(this).get(0).defaultValue );
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
    });
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

/*的是焦点*/
$('.xf_cl').hide();

$("input").each(function () {
    $(this).focus(function () {
        if ($(this).val() == $(this).get(0).defaultValue) {
            $(this).val("");
            $('.xf_cl').show();
        }
    });
    $(this).blur(function () {
        if ($(this).val() == "") {
            $(this).val($(this).get(0).defaultValue);
            $('.xf_cl').hide();
        }
    })
});

$(".xf_tsouy div img").click(function () {
    $(this).hide();
    $(".xf_input").val($(this).get(0).defaultValue);
});



//IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("localImag");




/*   regist*/
function hang1() {
    $("#hang1").show();
}

function hang2() {
    $("#hang2").show();
}


function chu() {
    $("#chu").show();
    $("#chu_2").hide();
}

function chu_2() {
    $("#chu").hide();
    $("#chu_2").show();
}

$('.xf_cl').hide();
$("input").each(function () {
    $(this).focus(function () {
        if ($(this).val() == $(this).get(0).defaultValue) {
            $(this).val("");
            $('.xf_cl').show();
        }
    });
    $(this).blur(function () {
        if ($(this).val() == "") {
            $(this).val($(this).get(0).defaultValue);
            $('.xf_cl').hide();
        }
    })
});

$(".xf_tsouy div img").click(function () {
    $(this).hide();
    $(".xf_input").val($(this).get(0).defaultValue);
});


/*  放大镜*/
$(document).ready(function(){

    $(".jqzoom").imagezoom();

    $("#thumblist li a").click(function(){
        $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
        $(".jqzoom").attr('src',$(this).find("img").attr("mid"));
        $(".jqzoom").attr('rel',$(this).find("img").attr("big"));
    });

});

