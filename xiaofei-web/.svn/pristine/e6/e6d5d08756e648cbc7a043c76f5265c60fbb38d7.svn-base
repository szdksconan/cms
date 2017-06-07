$(document).ready(function() {
	/**
	 * 导航搜索
	 */
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  decodeURI(r[2]); return null;
	}
	var key=decodeURI(GetQueryString("key"));
	var Famous=decodeURI(GetQueryString("Famous"));
	var goodshtml="";
	window.seek=function (param){
		goodshtml="";
		$.ajax({
			url:context+"/tcbpc/supc",
			data:{"param":param,
				"isFamousBrand":Famous
				},
			dataType:"json",
			type:"post",
			success:function(data){
				
				if(key==null||key==""||data.PageProduce==null){
					goodshtml+="<div class=\"xf_thd\" align=\"center\" >";
					goodshtml+="<div id=\"goodsData\">";
					goodshtml+="<P style=\"margin-top: 200px\">&nbsp;</P>";
					goodshtml+=" <img src=\""+context+"/images/zifenye/s_w1.jpg\">";
					goodshtml+="<P>&nbsp;</P>";
					goodshtml+="<p>抱歉哦！没有找到“"+key+"”相关商品";
					
					goodshtml+="试试其它关键词</p>";
					goodshtml+="</div>";
				}else{
					goodshtml+="<div class=\"xf_tu\">";
					$.each(data.PageProduce.records,function(i,n){
						goodshtml+="<span>";
						if(Famous==0)
							goodshtml+="<a href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"\" target=\"_self\">";
						else if(Famous==1)
							goodshtml+="<a href=\""+context+"/index_cp.jsp1?sId="+n.goodsId+"&pId="+n.productId+"\" target=\"_self\">";
						goodshtml+="<p><img src=\""+n.productMainImg+"\"> </p>";
						goodshtml+="<p><a class=\"red\" >￥"+n.productPrice+"</a>&nbsp;"+n.productNameCn+"</p>";
						goodshtml+="<p>"+n.enterpriceName+"</p>";
						goodshtml+="<p><img src=\""+context+"/images/b.png\">"+n.productPlace+"</p>";
						goodshtml+="</a>";
						goodshtml+="</span>";
					});
					goodshtml+="</div>";
				}
				
				$("#goodsData").html(goodshtml);
		        
		        
		        
			}
		});
	}
	
	window.getClass=function(){
		var html="";
		$.ajax({
			url:context+"/tcbpc/supc",
			data:{"param":12,
				},
			dataType:"json",
			type:"post",
			success:function(data){
				$.each(data.PageProduce.records,function(i,n){
					html+="<span>";
					html+="<a href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"\" target=\"_self\">";
					html+="<p><img src=\""+n.productMainImg+"\"> </p>";
					html+="<p><a class=\"red\" >￥"+n.productPrice+"</a>&nbsp;"+n.productNameCn+"</p>";
					html+="<p>"+n.enterpriceName+"</p>";
					html+="<p><img src=\""+context+"/images/b.png\">"+n.productPlace+"</p>";
					html+="</a>";
					html+="</span>";
				});
				$("#goodsData").html(html);
		        
		        
		        
			}
		});
	}
	
	
	window.get=function (){
		if($("#seekKey").val()!=""){
			 key=$("#seekKey").val();
			window.location.href="s_no.jsp?key="+key+""; 
		}
		else
			alert("请输入关键字");
	}
	/*window.getTwo=function (){
		if($("#seekKey").val()!=""){
			alert("00");
			key=$("#seekKey").val();
			seek(key);
		}
		else
			alert("请输入关键字");
	}*/
	
	
	if(key==null||key==""){
		goodshtml+="<div class=\"xf_thd\" align=\"center\" >";
		goodshtml+="<div id=\"goodsData\">";
		goodshtml+="<P style=\"margin-top: 200px\">&nbsp;</P>";
		goodshtml+=" <img src=\""+context+"/images/zifenye/s_w1.jpg\">";
		goodshtml+="<P>&nbsp;</P>";
		goodshtml+="<p>抱歉哦！没有找到“"+key+"...”相关商品";
		
		goodshtml+="试试其它关键词</p>";
		goodshtml+="</div>";
		$("#goodsData").html(goodshtml);
	}else
		seek(key);
})
