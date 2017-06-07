/*
 * author:



$(".left-menu .parent-menu").live('click', function () {
    var $leftMenu = $(this).parent();
    if ($leftMenu.hasClass("active")) {
        $leftMenu.removeClass("active").find('ul').slideUp('500');
    } else {
        $(".parent-menu").each(function () {
            if (!$(this).hasClass('no-child-menu')) {
                $(this).parent().removeClass('active');
            }
        });
        $(".left-menu ul").slideUp('500');
        $leftMenu.addClass("active").find('ul').slideDown('500');
    }
    if ($(this).hasClass('no-child-menu')) {
        $(".left-menu").removeClass('active');
        $(".left-menu .submenu li").removeClass("active");
        $leftMenu.addClass('active');
    }
});
$(".top-nav ul li a").live('click', function () {
    $(".top-nav ul li").removeClass("active");
    $(this).parent().addClass("active");
});

$(".left-menu .submenu li").live('click', function () {
    var clickElement = $(this).is("li") ? $(this) : $(this).parent();
    $(".left-menu").removeClass('active');
    $(this).parents('.left-menu').addClass('active');
    $(".left-menu .submenu li").removeClass("active");
    clickElement.addClass("active");
    $("#rightBar").find("iframe").attr("src", clickElement.find("a").attr("href"));
});

$(".left-menu1 .parent-menu1").live('click', function () {
    var $leftMenu1 = $(this).parent();
    if ($leftMenu1.hasClass("active")) {
        $leftMenu1.removeClass("active").find('ul').slideUp('500');
    } else {
        $(".parent-menu1").each(function () {
            if (!$(this).hasClass('no-child-menu1')) {
                $(this).parent().removeClass('active');
            }
        });
        $(".left-menu1 ul").slideUp('500');
        $leftMenu1.addClass("active").find('ul').slideDown('500');
    }
    if ($(this).hasClass('no-child-menu1')) {
        $(".left-menu1").removeClass('active');
        $(".left-menu1 .submenu li").removeClass("active");
        $leftMenu1.addClass('active');
    }
});
$(".top-nav ul li a").live('click', function () {
    $(".top-nav ul li").removeClass("active");
    $(this).parent().addClass("active");
});

$(".left-menu .submenu li").live('click', function () {
    var clickElement = $(this).is("li") ? $(this) : $(this).parent();
    $(".left-menu").removeClass('active');
    $(this).parents('.left-menu').addClass('active');
    $(".left-menu .submenu li").removeClass("active");
    clickElement.addClass("active");
    $("#rightBar").find("iframe").attr("src", clickElement.find("a").attr("href"));
});
 */
/* 自适应内容高度 */
$("#rightBar").css({
    marginLeft:115

});

$("#rightBar").find("iframe").attr({
    height: $(".leftBar").height() +100
});
$(window).resize(function () {
    $("#rightBar").find("iframe").attr({
        height: $(".leftBar").height() +100
    })
});
/* 自适应内容高度 */
$("#rightBar1").css({
    marginLeft: 140
});
$("#rightBar1").find("iframe").attr({
    height: $(".leftBar1").height() -20
});
$(window).resize(function () {
    $("#rightBar1").find("iframe").attr({
        height: $(".leftBar1").height() -20
    })
});
$("#switchs").click(function () {
    $(this).hasClass("pull") ? $(this).removeClass("pull").addClass("push") : $(this).removeClass("push").addClass("pull");
    $("#rightBar").css("-webkit-transition", "margin-left .3s linear").css("-moz-transition", "margin-left .3s linear").css("transition", "margin-left .3s linear");
    if (parseInt($(".leftBar").css("left")) < 0) {
        $(".leftBar").animate({
            left: 0
        }, 10);
        $("#rightBar").animate({
            marginLeft: 200
        }, 10);
    } else {
        $(".leftBar").animate({
            left: -$(".leftBar").width()
        }, 10);
        $("#rightBar").animate({
            marginLeft: 0
        }, 10)
    }
});

/* 点击myTab导航替换说明 */
$(function () {
    //$(".page-headers>span").first().addClass('current');
});

/* 复选框点击
$(".check-box,.check-box + span").live('click', function () {
    var _this = $(this).hasClass("check-box") ? $(this) : $(this).prev(".check-box");
    if (!_this.hasClass("disabled")) {
        _this.hasClass('selected') ? _this.removeClass('selected') : _this.addClass('selected');
    }
});

// 点击输入框，输入框边框改变颜色
$(function () {
    $("input[type='text']").live('focus', function () {
        $(this).hasClass("input-wrong") ? "" : $(this).addClass('color-15a');
        $(this).next("em").removeClass('Icon1').addClass('Icon11');
        $(this).next("em").removeClass('Icon2').addClass('Icon22');
    });
    $("input[type='text']").live('blur', function () {
        $(this).hasClass("input-wrong") ? "" : $(this).removeClass('color-15a');
        $(this).next("em").removeClass('Icon11').addClass('Icon1');
        $(this).next("em").removeClass('Icon22').addClass('Icon2');
    })
});*/
// 搜索框
$(function () {
    $(".search-content input").focus(function () {
        $(this).css("borderColor", "#16ab4f");
        $(this).next().children().removeClass("search-em").addClass("search-em1")
    });
    $(".search-content input").blur(function () {
        $(this).css("borderColor", "#cbcfd2");
        $(this).next().children().removeClass("search-em1").addClass("search-em")
    })
});
/* 提交状态
$(function () {
    $(".modal-backdrop").live('click', function () {
        var $subStatus = $("#subStatus");
        $subStatus.fadeOut(800, function () {
            $(this).remove();
        });
    });
});*/
function statusInfo($that, imgNum, bigTxt, callback) {
    var html = $('<div id="subStatus" style="width:500px;height:400px;z-index:10000;padding:50px 10px;background-color: rgba(0,0,0,0);position:absolute;left: 50%;top: 20%;margin-left:-250px;z-index: 2222;display: none;">'
    + '<img src="/static/new_ui/images/sub-status-'
    + imgNum
    + '.png" alt="" style="display: block;margin: 0 auto;"/>'
    + '<p style="margin-top:55px;text-align: center;font-size:30px;color:#fff;">' + bigTxt + '</p>' + '</div>');
    //html.find("img").parent().html(state1);
    $("body").append(html);
    var $modal = $that.parent().parent();
    $modal.removeClass("in").css("display", "none");
    html.fadeIn(800);
    setTimeout(function () {
        html.fadeOut(800, function () {
            $(this).remove();
            if (callback) {
                callback();
            }
        });
        $(".modal-backdrop").click();
    }, 1500);
}
/* 保存状态 */
function saveResult(saveState, desc, callback) {
    var descTxt = saveState ? "保存成功" : "保存失败";
    descTxt = desc ? desc : descTxt;
    var html1 = $('<div class="hint-popup" style="height: 82px;padding:0 20px;z-index:10003;border-radius:2px;text-align: center;line-height: 82px;background-color: #fff;border:1px solid #16AB4F;box-shadow: 0 4px 8px rgba(0,0,0,.2);position: fixed;top:30%;">'
    + '<span style="display: inline-block;width: 16px;height: 16px;margin-right:5px;background: url(/static/new_ui/images/succeed-ico.png) 0 0 no-repeat;vertical-align: middle;"></span>'
    + '<span style="display:inline-block;min-width:160px;margin-top:-1px;font-size: 14px;color:#16AB4F;vertical-align: middle;">' + descTxt + '</span>' + '</div>');
    var html2 = $('<div class="hint-popup" style="height: 82px;padding:0 20px;z-index:10003;border-radius:2px;text-align: center;line-height: 82px;background-color: #fff;border:1px solid #ea3b3b;box-shadow: 0 4px 8px rgba(0,0,0,.2);position: fixed;top:30%;">'
    + '<span style="display: inline-block;width: 16px;height: 16px;margin-right:5px;background: url(/static/new_ui/images/error-ico.png) 0 0 no-repeat;vertical-align: middle;"></span>'
    + '<span style="display:inline-block;min-width:160px;margin-top:-1px;font-size: 14px;color:#ea3b3b;vertical-align: middle;">' + descTxt + '</span>' + '</div>');
    if (saveState) {
        $('body').append(html1);
        var width = $(html1).outerWidth();
        $(html1).css("left", ($(window).innerWidth() - width) / 2);
        setTimeout(function () {
            html1.fadeOut(800, function () {
                $(this).remove();
                if (callback) {
                    callback();
                }
            });
        }, 1000);
    } else {
        $('body').append(html2);
        var width = $(html2).outerWidth();
        $(html2).css("left", ($(window).innerWidth() - width) / 2);
        setTimeout(function () {
            html2.fadeOut(800, function () {
                $(this).remove();
                if (callback) {
                    callback();
                }
            });
        }, 1000);
    }
}

/* 加载状态 */
var loadHtml;
function loadResult(loadTxt) {
    loadHtml = $('<div class="load-popup" style="width:100%;height: 82px;text-align:center;z-index:10003;border-radius:2px;text-align: center;line-height: 82px;position: fixed;top:30%;">' +
    '<span style="display:inline-block;margin-top:-1px;font-size: 14px;color:#fff;vertical-align: middle;">' + loadTxt + '</span></div>' +
    '<div style="position:fixed;width:100%;height:100%;z-index: 10002;top:0;left:0;background-color:rgba(0,0,0,.8);"></div>');
    $('body').append(loadHtml);
    var width = $(loadHtml).eq(0).outerWidth();
    $(loadHtml).eq(0).css("left", ($(window).innerWidth() - width) / 2);
}
/* 关闭加载弹出层 */
function closeLoad(callback) {
    setTimeout(function () {
        loadHtml.fadeOut(800, function () {
            $(this).remove();
            if (callback) {
                callback();
            }
        });
    }, 1000);
}
if (window.frames.length == 0) {
    $("html,body").css({overflow: ""});
} else if (window.parent && window.frames.length > 0) {
    $(window.parent.document).find("html,body").css({
        overflow: "hidden"
    });
} else if (window.parent && window.parent.parent) {
    $(window.parent.parent.document).find("html,body").css({
        overflow: "hidden"
    });
}
$(function () {
    var bodyHeight = $(".white-bg").outerHeight();
    var warpHeight = $(".white-bg").find(".warp").outerHeight();
    if (bodyHeight < warpHeight) {
        $(".white-bg").css({height: "auto"});
    } else {
        $(".white-bg").css({height: "100%"});
    }
});


/* 二维码浮窗 */
$(function () {
    $(".footer").hover(function () {
        slidediv(this, $(this).css("right"));
    }, function () {
        slidediv(this, $(this).css("right"));
    });
    function slidediv(obj, offsetNum) {
        var interValId;
        offsetNum = parseInt(offsetNum);
        if (offsetNum < 0) { // 收
            interValId = setInterval(function () {
                offsetNum += 4;
                $(obj).css({
                    right: offsetNum
                });
                if (offsetNum >= 0) {
                    clearInterval(interValId)
                }
            }, 1);
        } else {// 出
            interValId = setInterval(function () {
                offsetNum -= 4;
                $(obj).css({
                    right: offsetNum});
                if (offsetNum <= -208) {
                    clearInterval(interValId)
                }
            }, 1);
        }
    }
});
$("a[data-toggle=modal]").on("click", function () {
    $(".modal>.modal-body").animate({
        scrollTop: 0
    });
});
