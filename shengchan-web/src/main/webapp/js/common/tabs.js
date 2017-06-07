$(document).ready(function(){
	//tab切换效果
	$(".qy_conul li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".qy_tab>div").eq(index).show().siblings().hide();
		$(".qy_tabbar>div").eq(index).show().siblings().hide();
	});
	
	$(".qy_conul2 li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
		$(".qy_tab2>div").eq(index).show().siblings().hide();
		$(".qy_tabbar2>div").eq(index).show().siblings().hide();
	});

	$(".qy_conul3 li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
        $(this).parent('.qy_conul3').siblings('.qy_tab3').children('div').eq(index).show().siblings().hide();
        //$(this).sibling(".qy_tab3>div").eq(index).show().siblings().hide();
		//$(".qy_tabbar3>div").eq(index).show().siblings().hide();
	});

	$(".qy_conul4 li").click(function(){
		var index=$(this).index();
		$(this).addClass("active").siblings().removeClass("active");
        $(this).parent('.qy_conul4').siblings('.qy_tab4').children('div').eq(index).show().siblings().hide();
        //$(this).sibling(".qy_tab3>div").eq(index).show().siblings().hide();
		//$(".qy_tabbar3>div").eq(index).show().siblings().hide();
	});
});
