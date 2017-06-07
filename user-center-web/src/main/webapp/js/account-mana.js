$(document).ready(function(){
	//切换左侧菜单样式和内容
	$(".acc-menu-ul li").click(function(){
		$(this).addClass("acc-select").siblings().removeClass();
	});
	//账户管理菜单特效	
	$(".sidebar-menu>a").click(function(){
		$(this).addClass("menu-active").siblings().removeClass("menu-active");
		//获取当前元素下一个标签名
		var tagname=$(this).next().get(0).tagName;
		//判断是否有下拉框
		if(tagname=="UL"){
			$(this).find(".arrow-r").removeClass("arrow-r").addClass("arrow-down");
		}else{
			$(this).find(".arrow-r").removeClass("arrow-r").addClass("arrow-downleft");
		}
		$(this).siblings().find(".arrow-down").removeClass("arrow-down").addClass("arrow-r");
		$(this).siblings().find(".arrow-downleft").removeClass("arrow-downleft").addClass("arrow-r");
		//账号信息
		if($(this).find("i").hasClass("icon-user")){
			$(this).find(".icon-user").removeClass("icon-user").addClass("icon-user-select");
			$(this).siblings().find(".icon-safe-select").removeClass("icon-safe-select").addClass("icon-safe");
			$(this).siblings().find(".icon-mana-select").removeClass("icon-mana-select").addClass("icon-mana");
			$(this).siblings().find(".icon-ads-select").removeClass("icon-ads-select").addClass("icon-ads");
		}
		//账户安全
		if($(this).find("i").hasClass("icon-safe")){
			$(this).find(".icon-safe").removeClass("icon-safe").addClass("icon-safe-select");
			$(this).siblings().find(".icon-user-select").removeClass("icon-user-select").addClass("icon-user");
			$(this).siblings().find(".icon-mana-select").removeClass("icon-mana-select").addClass("icon-mana");
			$(this).siblings().find(".icon-ads-select").removeClass("icon-ads-select").addClass("icon-ads");
		}
		//账户管理
		if($(this).find("i").hasClass("icon-mana")){
			$(this).find(".icon-mana").removeClass("icon-mana").addClass("icon-mana-select");
			$(this).siblings().find(".icon-user-select").removeClass("icon-user-select").addClass("icon-user");
			$(this).siblings().find(".icon-safe-select").removeClass("icon-safe-select").addClass("icon-safe");
			$(this).siblings().find(".icon-ads-select").removeClass("icon-ads-select").addClass("icon-ads");
		}
		//地址管理
		if($(this).find("i").hasClass("icon-ads")){
			$(this).find(".icon-ads").removeClass("icon-ads").addClass("icon-ads-select");
			$(this).siblings().find(".icon-user-select").removeClass("icon-user-select").addClass("icon-user");
			$(this).siblings().find(".icon-safe-select").removeClass("icon-safe-select").addClass("icon-safe");
			$(this).siblings().find(".icon-mana-select").removeClass("icon-mana-select").addClass("icon-mana");
		}
	});
	//二级元素
	$(".menu-second li").click(function(){
		//二级菜单下同辈元素之间改变
		$(this).find("span").addClass("menu-second-selected").parents("li").siblings().find("span").removeClass("menu-second-selected");
		//基本信息
		if($(this).find("i").hasClass("icon-basinfo")){
			$(this).find(".icon-basinfo").removeClass("icon-basinfo").addClass("icon-basinfoed");
			$(this).parent().find(".icon-cominfoed").removeClass("icon-cominfoed").addClass("icon-cominfo");
			$(this).parent().find(".icon-cominfoed").removeClass("icon-materinfoed").addClass("icon-materinfo");
			$(this).parent().find(".icon-comintroed").removeClass("icon-comintroed").addClass("icon-comintro");
		}
		//企业信息
		if($(this).find("i").hasClass("icon-cominfo")){
			$(this).find("i").removeClass("icon-cominfo").addClass("icon-cominfoed");
			$(this).parent().find(".icon-basinfoed").removeClass("icon-basinfoed").addClass("icon-basinfo");
			$(this).parent().find(".icon-materinfoed").removeClass("icon-materinfoed").addClass("icon-materinfo");
			$(this).parent().find(".icon-comintroed").removeClass("icon-comintroed").addClass("icon-comintro");
		}
		//物质信息
		 if($(this).find("i").hasClass("icon-materinfo")){
			$(this).find("i").removeClass("icon-materinfo").addClass("icon-materinfoed");
			$(this).parent().find(".icon-basinfoed").removeClass("icon-basinfoed").addClass("icon-basinfo");
			$(this).parent().find(".icon-cominfoed").removeClass("icon-cominfoed").addClass("icon-cominfo");
			$(this).parent().find(".icon-comintroed").removeClass("icon-comintroed").addClass("icon-comintro");
		}
		//企业介绍
		if($(this).find("i").hasClass("icon-comintro")){
			$(this).find("i").removeClass("icon-comintro").addClass("icon-comintroed");
			$(this).parent().find(".icon-basinfoed").removeClass("icon-basinfoed").addClass("icon-basinfo");
			$(this).parent().find(".icon-cominfoed").removeClass("icon-cominfoed").addClass("icon-cominfo");
			$(this).parent().find(".icon-materinfoed").removeClass("icon-materinfoed").addClass("icon-materinfo");
		}
	})
	
	//点击点此添加到个人信息添加
	$(".acc-perinfolink").click(function(){
		$(".acc-perinfoshow").addClass("hide").removeClass("show");
		$(".acc-perinfoadd").addClass("show").removeClass("hide");
	});
	//点击点此添加到教育经历添加
	$(".acc-peredulink").click(function(){
		$(".acc-eduxpshow").addClass("hide").removeClass("show");
		$(".acc-eduxpadd").addClass("show").removeClass("hide");
	});
	//交易账户管理-跳转到交易详情页
	$(".acc-moneydetail").click(function(){
		$("#acc-indexdiv").addClass("hide").removeClass("show");
		$("#acc-moneydiv").addClass("show").removeClass("hide");
		$("#acc-addcarddiv").addClass("hide").removeClass("show");
	});
	//交易账户管理-跳转到添加银联账户
	$(".acc-tra-addicon").click(function(){
		$("#acc-moneydiv").addClass("hide").removeClass("show");
		$("#acc-indexdiv").addClass("hide").removeClass("show");
		$("#acc-addcarddiv").addClass("show").removeClass("hide");
	});
	
	window.onload = function () {
	//地址管理-表格样式
	 $(".acc-ads-tbody>tr:odd").addClass("acc-ads-ou");   //为偶数行设置样式(添加样式类)
     $(".acc-ads-tbody>tr:even").addClass("acc-ads-ji");  // 为奇数行设置样式类
}

});

//iframe高度自适应子页面高度
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
            if (iframeWin.document.body) {
                iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
            }
        }
   }
	window.onload = function () {
	setIframeHeight(document.getElementById('accframe'));
	};
	