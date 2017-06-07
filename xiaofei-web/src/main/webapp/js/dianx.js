$(document).ready(function() {
	
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var shopId=GetQueryString("shopId");
	//var shopId=23;
	var goodshtml="";
	
	var barhtml="";
	barhtml+="<ul>";
	barhtml+=" <li >";
	barhtml+="<a href=\"dianx.jsp?shopId="+shopId+"\" target=\"_self\" class=\"active\">店铺首页</a>";
	barhtml+=" </li>";
	barhtml+="<li>";
	barhtml+=" <a href=\"zmu.jsp?shopId="+shopId+"\" target=\"_self\" >商品</a>";
	barhtml+="</li>";
	barhtml+="<li>";
	barhtml+=" <a href=\"javascript:void(0);\" target=\"_self\" >招募信息</a>";
	barhtml+="</li>";
	barhtml+="<li >";
	barhtml+="<a href=\"dian_xinxi.jsp?shopId="+shopId+"\" target=\"_self\" > 店铺信息</a>";
	barhtml+="</li>";
	barhtml+=" </ul>";
	$("#bar").html(barhtml);
	
	
	$.ajax({
		url:context+"/shopData/ProductList",
		data:{"id":shopId},
		dataType:"json",
		type:"post",
		success:function(data){
			
			$.each(data,function(i,n){
				goodshtml+="<span>";
				goodshtml+="<a href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"&shopId="+shopId+"\" target=\"_self\">";
				goodshtml+="<p><img src=\""+n.productMainImg+"\"> </p>";
				goodshtml+="<p><a class=\"red\" >￥"+n.productPrice+"</a>&nbsp;"+n.productNameCn+"</p>";
				goodshtml+="<p>"+n.enterpriceName+"</p>";
				goodshtml+="<p><img src=\""+context+"/images/b.png\">"+n.productPlace+"</p>";
				goodshtml+="</a>";
				goodshtml+="</span>";
			});
			$("#goodsList").html(goodshtml);
	        
	        
	        
		}
	});
	
})