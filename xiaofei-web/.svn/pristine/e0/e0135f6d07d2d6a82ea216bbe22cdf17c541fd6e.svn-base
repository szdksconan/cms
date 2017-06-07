$(document).ready(function() {
	/**
	 * 导航搜索
	 */
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var key=decodeURI(GetQueryString("key"));
	var industry=GetQueryString("industryId");
	
	
	var goodshtml="";
	
	window.seek=function (key){
		goodshtml="";
		$.ajax({
			url:context+"/tcbpc/supc",
			data:{"param":key,
				"industryId":industry
				},
			dataType:"json",
			type:"post",
			success:function(data){
				
				if(((key==null||key=="")&&(industry==null||industry==""))||data.PageProduce==null){
					goodshtml+="<div class=\"xf_thd\" align=\"center\" >";
					goodshtml+="<div id=\"goodsData\">";
					goodshtml+="<P style=\"margin-top: 200px\">&nbsp;</P>";
					goodshtml+=" <img src=\""+context+"/images/zifenye/s_w1.jpg\">";
					goodshtml+="<P>&nbsp;</P>";
					goodshtml+="<p>抱歉哦！没有找到“sjkajkdjkasj...”相关商品";
					
					goodshtml+="试试其它关键词</p>";
					goodshtml+="</div>";
				}else{
					goodshtml+="<div class=\"xf_tu\">";
					$.each(data.PageProduce.records,function(i,n){
						goodshtml+="<span>";
						goodshtml+="<a href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"\" target=\"_self\">";
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
		seek(key);
	window.get=function (){
		if($("#seekKey").val()!=""){
			 key=$("#seekKey").val();
			 seek(key);
			window.location.href="index_fen2.jsp?key="+key+"&industryId="+industry+"";
		}
		else
			alert("请输入关键字");
	}
	window.getUrl=function (id){
		if(id!=""||id!=null){
			window.location.href=context+"/index_fen2.jsp?industryId="+id+""; 
		}
	}
	$.ajax({
		url:context+"/tcbpc/industry",
		type:"post",
		dataType:"json",
		data:{industryId:industry},
		success:function(data){
			var m=0;Object.keys(data).length;
			var jiegouhtml="";
			var shoptrdatahtml="";
				$.each(data,function(i,n){
					m++;
					shoptrdatahtml="<td align=\"left\" width=\"150\">类似用品</td>";
						$.each(n,function(i,k){
							//alert(Object.keys(data).length);
							if(m!=Object.keys(data).length){
								jiegouhtml+=">><a href=\"javascript:;\" onclick=getUrl("+k.code+")>"+k.name+"</a>";
							}else{
								shoptrdatahtml+="<td align=\"left\"  width=\"150\" onclick=getUrl("+k.code+")>"+k.name+"</td>";
							}
								
						})	
						
				})
				$(".sou_jiegou").html(jiegouhtml);
				$("#shoptrdata").html(shoptrdatahtml);
			//alert(data.a0.name);
		}
	})
	
})