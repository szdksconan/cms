
var namehtml="";
/*document.write(" <script language=\"javascript\" src=\"js/2016caidan.js\" > <\/script>");*/ 
$(document).ready(function() {
	$.ajax({
		url:"tcbpc/test",
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var html="";
			html+="<div class=\"yHeader\">";
			html+="    <!-- 导航   start  -->";
			html+="    <div class=\"yNavIndex\">";
			html+="        <div class=\"pullDown\">";
			html+="";
			html+=" <ul class=\"pullDownList\">";
			var str = ["fa fa-cutlery","fa fa-fax","fa fa-building-o","fa fa-reddit-square",
			           "fa fa-desktop","fa fa-coffee","fa fa-gift","fa fa-car","fa fa-file-text",
			           "fa fa-calendar-o","fa fa-cubes","fa fa-shopping-cart","fa fa-tree"];
			$.each(data,function(i,n){
				html+="                <li onmouseenter=\"getTwo('"+n.code+"','"+n.id+"')\">";//onmouseenter=\"getTwo('"+n.code+"','"+n.id+"')\"
				html+="                    <i class=\""+str[i]+"\" aria-hidden=\"true\"></i>";
				html+="                    <a href=\"javascript:;\" target=\"_self\">"+n.name+"</a>";
				html+="";
				html+="                </li>";
			});
		
			html+="";
			html+="            </ul>";
			html+="            <!-- 下拉详细列表具体分类 -->";
			html+="<div class=\"yMenuListCon\" id=\"xia_la_codeInfo\">";
			html+="        </div>";
			html+="        </div>";
			html+="";
			html+="";
			html+="    </div>";
			html+="    <!-- 导航   end  -->";
			html+="</div>";
			$(".xf_fucaidan").append(html);
			// 导航左侧栏js效果 start
			$(".pullDownList li").hover(function(){
				$(".yMenuListCon").fadeIn();
				var index=$(this).index(".pullDownList li");
				if (!($(this).hasClass("menulihover")||$(this).hasClass("menuliselected"))) {
					$($(".yBannerList")[index]).css("display","block").siblings().css("display","none");
					$($(".yBannerList")[index]).removeClass("ybannerExposure");
					setTimeout(function(){
					$($(".yBannerList")[index]).addClass("ybannerExposure");
					},60)
				}else{	
				}
				$(this).addClass("menulihover").siblings().removeClass("menulihover");
					$(this).addClass("menuliselected").siblings().removeClass("menuliselected");
				$($(".yMenuListConin")[index]).fadeIn().siblings().fadeOut();
			},function(){
				
			})
			$(".pullDown").mouseleave(function(){
				$(".yMenuListCon").fadeOut();
				$(".yMenuListConin").fadeOut();
				$(".pullDownList li").removeClass("menulihover");

			})
		}
	});
});

function getTwo(code,id){
	$.ajax({
		url:"tcbpc/test2?cms="+code+"__&cmscodes="+code+"____",
		type:"get",
		//async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var sup = new Array();
			$("#codeInfo").html("");
			var html="";
			html+="<div class=\"yMenuListConin\">";
			$.each(data,function(i,n){
				
				getname(data,data[i].id);
				
				if(id==n.superid){
					html+="<div class=\"yMenuLCinList\" id=\"codeInfo\">";
					html+="<p>";
					html+="<a href=\"\" class=\"ecolor610\">"+n.name+"</a>";
					html+=namehtml;
					html+="</p>";
					html+="</div>";
				}
				
				
			});
			
			html+="</div>";
			
			$("#xia_la_codeInfo").append(html);
		}
	})
}

function getname(datas,pid){
	namehtml="";
	for (var i = 0; i < datas.length; i++) {
        if (datas[i].superid ==pid) {
        	namehtml+="<a href=\"\" >"+datas[i].name+"</a>";
        }
      }
	
}
