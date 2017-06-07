
var namehtml="";
var classlayerhtml="";
var goodshtml="";
/*document.write(" <script language=\"javascript\" src=\"js/2016caidan.js\" > <\/script>");*/ 
$(document).ready(function() {
	$.ajax({
		url:"/xiaofei-web/tcbpc/test",
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
			var str = ["fa fa-cubes","fa fa-fax","fa fa-desktop","fa fa-building-o","fa fa-gift",
			           "fa fa-shopping-cart","fa fa-calendar-o","fa fa-tree","fa fa-car",
			           "fa fa-reddit-square","fa fa-coffee","fa fa-cutlery","fa fa-file-text"];
			$.each(data,function(i,n){
				
				
				html+="                <li >";//onmouseenter=\"getTwo('"+n.code+"','"+n.id+"')\"
				html+="                    <i class=\""+str[i]+"\" aria-hidden=\"true\"></i>";
				html+="                    <a href=\"javascript:;\" onclick=\"getUrl('"+n.code+"')\" target=\"_self\">"+n.name+"</a>";
				html+="";
				html+="                </li>";
			});
		
			html+="";
			html+="            </ul>";
			html+="            <!-- 下拉详细列表具体分类 -->";
			html+="<div class=\"menuDiv\">"
			$.each(data,function(i,n){
				html+="<div class=\"yMenuListCon \" id=\""+n.id+"\">";
				html+="        </div>";
			})
			html+="  </div>";
			html+="        </div>";
			html+="";
			html+="";
			html+="    </div>";
			html+="    <!-- 导航   end  -->";
			html+="</div>";
			$(".xf_fucaidan").append(html);
			$.each(data,function(i,n){
				
				getTwo(n.code,n.id,i);	
			})
			
		$(".pullDownList li").hover(function(){
			var index=$(this).index();
			$(this).addClass("menulihover menuliselected").siblings().removeClass("menulihover menuliselected");
			$(".menuDiv .yMenuListCon").eq(index).css("display","block").siblings().css("display","none");
		},function(){
		});	
			$(".pullDown").mouseleave(function(){
				$(".yMenuListCon").css("display","none");
				$(".pullDownList li").removeClass("menulihover");

			})
	
		}
	});
});

function getTwo(code,id,layer){
	if(layer<=1){
		getgoods(code,layer);
	}
	$.ajax({
		url:"/xiaofei-web/tcbpc/test2?cms="+code+"&cmscodes="+code,
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".xia_la_codeInfo").html("");
			var html="";
			html+="<div class=\"yMenuListConin \">";
			var  typesum=0;
			if(layer==1) {
				classlayerhtml="";
				goodshtml="";
				typesum=0
			}
			$.each(data,function(i,n){
				
				getname(data,data[i].id);
				
				if(id==n.superid){
					html+="<div class=\"yMenuLCinList codeInfo\">";
					html+="<p>";
					html+="<a href=\"javascript:void(0);\" onclick=\"getUrl('"+n.code+"')\" class=\"ecolor610\">"+n.name+"</a>";
					html+=namehtml;
					html+="</p>";
					html+="</div>";
				}
				var classlayer="<li  class=\"active\"><a href=\"javascript:void(0);\" >全部</a></li>"
				if(typesum<4&&layer<2&&id==n.superid){
					typesum++;
					classlayerhtml+="<li  ><a   href=\"javascript:void(0);\" onclick=\"getgoods('"+n.code+"','"+layer+"')\">"+n.name+"</a></li>";/**/
					}
				
				
				
				if(classlayerhtml!=""){
					$(".classlayer"+layer).html(classlayer+classlayerhtml);
					}
			});
			
			$(".xf_sbanner ul li ").click(function(){
			    $(".xf_sbanner ul  li ").removeClass("active");
			    $(this).addClass("active");
			});

			$(".xf_sbanner1 ul  li ").click(function(){
			    $(".xf_sbanner1 ul  li ").removeClass("active");
			    $(this).addClass("active");
			});
			
			html+="</div>";
			
			$("#"+id).append(html);
		}
	})
}

function getgoods(id,layer){
	//alert("layer="+layer);
	$("#goodsList"+layer).html("");
	$.ajax({
		url:context+"/tcbpc/supc",
		data:{"industryId":id,
			"isFamousBrand":0,
			"start":1,
			"pageSize":4},
		dataType:"json",
		type:"post",
		success:function(data){
			//alert("00"+data.productMainImg);
			
			//goodshtml+="<div class=\"xf_tu\">";
			if(data.PageProduce!=null){
				$.each(data.PageProduce.records,function(i,n){
					goodshtml+="<span>";
					goodshtml+="<a href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"&shopId="+n.enterpriceId+"\" target=\"_self\">";
					goodshtml+="<p><img src=\""+n.productMainImg+"\"> </p>";
					goodshtml+="<p><a class=\"red\" >￥"+n.productPrice+"</a>&nbsp;"+n.productNameCn+"</p>";
					goodshtml+="<p>"+n.enterpriceName+"</p>";
					goodshtml+="<p><img src=\""+context+"/images/b.png\">"+n.enterpriseinfo.manaAddAn+n.enterpriseinfo.manageDetail+"</p>";
					goodshtml+="</a>";
					goodshtml+="</span>";
				});
				$("#goodsList"+layer).html(goodshtml);
				goodshtml="";
			}
			//goodshtml+="</div>";
			
			
			
	        
	        
		}
		
	});
	
   // alert(goodshtml);
}

window.getUrl=function (id){
	if(id!=""||id!=null){
		window.location.href=context+"/index_fen2.jsp?industryId="+id+""; 
	}
}
function getname(datas,pid){
	namehtml="";
	for (var i = 0; i < datas.length; i++) {
        if (datas[i].superid ==pid) {
        	namehtml+="<a href=\"javascript:void(0);\" onclick=\"getUrl('"+datas[i].code+"')\" >"+datas[i].name+"</a>";
        }
      }
	
}
