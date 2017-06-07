//下拉菜单js
jQuery(document).ready(function(){
	$(".dropdown p").click(function(){
		var ul=$(this).next("ul");
		if(ul.css("display")=="none"){
			ul.slideDown("fast");
		}else{
			ul.slideUp("fast");
		}
	});	
	$(".dropdown ul li").click(function(){
		var txt = $(this).find("a").text();
		$(this).parents("ul").prev("p").html(txt);
		var value = $(this).attr("rel");
		$(this).parents("ul").hide();	
	});
	$(".dropdown ul li").hover(function(){
		$(this).find("a").css("color","#FFFFFF");
	},function(){
		$(this).find("a").css("color","#807a62");
	});
});