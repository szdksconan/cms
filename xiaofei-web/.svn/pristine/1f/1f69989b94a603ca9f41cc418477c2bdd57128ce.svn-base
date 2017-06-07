
var productCode;
var goodsId;
var productName;
var productImgUrl;
var productPrice;
var productAttribute;
var storeId;
var storeName;
var storeLogoUrl;
var sId="";
var pId="";
var shopId="";		//商家id
var shopproductPrice=0; 		//商品价格



$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	sId=GetQueryString("sId");
	pId=GetQueryString("pId");
	shopId=GetQueryString("shopId");
	
	$.ajax({
		url:context+"/tcbpc/test1",
		type:"get",
		data:{id:pId,shopId:shopId},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$.each(data,function(i,n){
				productImgUrl=n.productMainImg;
				goodsId=n.goodsId;
				productCode=pId;
				productName=n.productNameCn;
				productPrice=n.productPrice;
				storeId=n.enterpriceId;
				$(".xf_shou").text(n.productNameCn);
				$(".fx_name_priec").html(n.productNameCn);
				$(".xf_ms4").html(n.productNameCn);
				if(n.unit!=null){
					$(".productTotalStock").text(n.productTotalStock+n.unit);
				}else{
					$(".productTotalStock").text(+n.productTotalStock+"件");
				}
				$(".productSales").text(n.productSales);
				$(".productCode").text(n.productCode);
				$(".brandName").text(n.brandName);
				$(".gproductGW").text(n.productGW);
				$(".productPlace").text(n.productPlace);
				$(".productDetail").text(n.productDetail);
				$("#pro_sale").html(n.productIntroduction);
				$(".service").text(n.service);
				$(".men").text(n.men);
				$(".weis").text(n.wei);
				$(".xf_xuse").text(n.color);
				$(".sc_name").append("<a target=\"_blank\" href=\"http://192.168.2.224:8080/shengchan-web/qiyezhongxin/qiyeguanOut.html?compid="+n.oemId+"\">"+n.oemName+"</a>");
				var html="";
				$.each(n.cmsAttrVal,function(j,m){
					html+="<tr class=\"xfb_4\">";
					html+="<td align=\"right\"  class=\"xfb_5\">"+m.attr.attrNameCn+"</td>";
					html+="<td align=\"left\" class=\"xfb_6\">"+m.attrValueCn+"</td>";
					html+="</tr>";
				});
				$(".cms_guige").append(html);
			})
		}
	});
	
	goods();
	show_service();
	connenl_num();
	
	var ku_num=$("#i1").val();
	$("#shoppingnum").val(ku_num);
    window.kc_jian=function (){
    	ku_num= $("#i1").val();
    	if(ku_num>1){
    		ku_num--;
    	}else{
    		return;
    	}
    	$("#i1").val(ku_num);
    	$("#pricesum").html(shopproductPrice*ku_num);
    	$("#shoppingnum").val(ku_num);
    }
    
    window.ku_jia=function (){
    	ku_num= $("#i1").val()
    	if(ku_num<999){
    		ku_num++;
    	}else{
    		return;
    	}
    	$("#i1").val(ku_num);
    	$("#pricesum").html(shopproductPrice*ku_num);
    	$("#shoppingnum").val(ku_num);
    }
	
	
	
	
	
	
});

function goods() {
	$.ajax({
		url:context+"/tcbpc/selectGoodsInfoById?id="+sId,
		type:"get",
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_2_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			/*if($("#my_shangjia").text()==""){
				mId=data.companyId;
				if(mId!=null){
					show_service(mId);
				}
				storeId=data.companyId;
				$("#my_shangjia").append("<a href=\"f_w/dianx.jsp?shopId="+data.companyId+"\" target=\"_self\"> <img src=\"images/jianguo1.jpg\"></a>");
			}*/
			if($(".sc_name").text()==""){
				$(".sc_name").append("<a target=\"_blank\" href=\"http://192.168.2.224:8080/shengchan-web/qiyezhongxin/qiyeguanOut.html?compid="+data.oemId+"\">"+data.oemName+"</a>");
			}
			if($(".my_name").text()==""){
				$(".my_name").text(data.companyName);
				storeName=data.companyName;
			}
			if(data!=null){
				var numbers=0;
				$.each(data.cmsImages,function(i,n){
					numbers=i;
					if(i==0){
						$("#img").attr({"src":n.imgUrl,"jqimg":n.imgUrl});
					}
					$("<li><img  bimg="+n.imgUrl+" src="+n.imgUrl+" onmousemove=\"preview(this);\"></li>").appendTo(".img_tb_thumb");
				});
				if(numbers>=5){
					$(".prev").show();
					$(".next").show();
				}else{
					$(".prev").hide();
					$(".next").hide();
				}
				$.each(data.cmsSellRule,function(i,n){
					$.each(n.productPrice,function(j,k){
						shopproductPrice=k.price;
						$("#priceone").html("￥"+k.price);
					});
				})
			}
			//图片预览小图移动效果,页面加载时触发
			$(function(){
				var tempLength = 0; //临时变量,当前移动的长度
				var viewNum = 5; //设置每次显示图片的个数量
				var moveNum = 2; //每次移动的数量
				var moveTime = 300; //移动速度,毫秒
				var scrollDiv = $(".spec-scroll .items ul"); //进行移动动画的容器
				var scrollItems = $(".spec-scroll .items ul li"); //移动容器里的集合
				var moveLength = scrollItems.eq(0).width() * moveNum; //计算每次移动的长度
				var countLength = (scrollItems.length - viewNum) * scrollItems.eq(0).width(); //计算总长度,总个数*单个长度
				  
				//下一张
				$(".spec-scroll .next").bind("click",function(){
					if(tempLength < countLength){
						if((countLength - tempLength) > moveLength){
							scrollDiv.animate({left:"-=" + moveLength + "px"}, moveTime);
							tempLength += moveLength;
						}else{
							scrollDiv.animate({left:"-=" + (countLength - tempLength) + "px"}, moveTime);
							tempLength += (countLength - tempLength);
						}
					}
				});
				//上一张
				$(".spec-scroll .prev").bind("click",function(){
					if(tempLength > 0){
						if(tempLength > moveLength){
							scrollDiv.animate({left: "+=" + moveLength + "px"}, moveTime);
							tempLength -= moveLength;
						}else{
							scrollDiv.animate({left: "+=" + tempLength + "px"}, moveTime);
							tempLength = 0;
						}
					}
				});
			});
		}
	});
	
	$.ajax({
		url:context+"/tcbpc/testw?id="+sId,
		type:"get",
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_3_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			if(data!=null&&data!=""){
				var html="";
				/*html+="<span>颜色 ：</span>";
				$.each(data,function(i,n){
					if(n.id==pId){
						productAttribute=n.name;
						
						<div class="xf_gouy3" ><p>红色</p></div>
						html+="<div class=\"xf_gouy3\" ><span  title="+n.name+" onclick=\"p_choose('"+n.id+"');\">"+n.name+"</span></div>";
					}else{
						html+="<div class=\"xf_gouy3\" ><span  title="+n.name+" onclick=\"p_choose('"+n.id+"');\">"+n.name+"</span></div>";
					}
				});*/
				html+="<span>配置 ：</span>";
				$.each(data,function(i,n){
					if(n.id==pId){
						productAttribute=n.name;
						html+="<span class=\"xf_xuse active\" title="+n.name+" onclick=\"p_choose('"+n.id+"');\">"+n.name+"</span>";
					}else{
						html+="<span class=\"xf_xuse\" title="+n.name+" onclick=\"p_choose('"+n.id+"');\">"+n.name+"</span>";
					}
				});
			}
			$(".xf_peiz_color").append(html);
			$(".xf_peiz_color").click(function(){
				$(".xf_peiz_color span").removeClass("active");
			})
			$(function() { 
				$('.xf_xuse').tipsy({gravity: 's'});
			});
		}
		
	});
}

function p_choose(id){
	window.location.href="index_cp.jsp?pId="+id+"&sId="+sId+"&shopId="+shopId; 
}

function show_service(){
	$.ajax({
		url:context+"/shopData/getServInfo?id="+shopId,
		type:"post",
		dataType:"json",
		success:function(data){
			var html="";
			$.each(data.EnterpriseToOutBean.goodsServices,function(i,n){
				//alert(n.description);
				if(n.type==1&&n.description!=null&&n.description!=""){
		        	html+=" 商品配送<a class=\"xf_ly service\">";
		        	html+=" <br/>";
		        	html+=n.description+"<br/>";
					html+="  </a><br/>";
		        }else if(n.type==2&&n.description!=null&&n.description!=""){
		        	html+="商品安装 <a class=\"xf_ly men\">";
		        	html+=" <br/>";
		        	html+=n.description+"<br/>";
					html+="  </a><br/>";
		        }else if(n.type==3&&n.description!=null&&n.description!=""){
		        	html+="商品维修 <a class=\"xf_ly weis\">";
		        	html+=" <br/>";
		        	html+=n.description+"<br/>";
					html+="  </a><br/>";
		        }
				//alert(n.description);

			});
			$(".xf_service_ps").append(html);
			$("#my_shangjia").append("<a href=\"f_w/dianx.jsp?shopId="+shopId+"\" target=\"_self\"> <img src=\"images/jianguo1.jpg\"></a>");
			storeName=data.EnterpriseToOutBean.enterpriseInfo.name;
			storeLogoUrl=data.EnterpriseToOutBean.enterpriseInfo.logoPath;
			$("#my_logo").attr("src",data.EnterpriseToOutBean.enterpriseInfo.logoPath);
			$(".my_name").text(data.EnterpriseToOutBean.enterpriseInfo.name);
			$(".my_lxfs").text("联系方式："+data.EnterpriseToOutBean.enterpriseInfo.contactTel);
			$(".my_szd").text("所在地："+data.EnterpriseToOutBean.enterpriseInfo.regAddAn+data.EnterpriseToOutBean.enterpriseInfo.registerDetail);
		}
	});
}

function add_cart(){
	if(userid!=""){
		var productNumber=$(".cmao_inpsm").val();
		$.ajax({
			url:context+"/cart/addGoodsToShoppinctart",
			type:"post",
			data:{productCode:productCode,productName:productName,productImgUrl:productImgUrl,productPrice:productPrice,productNumber:productNumber,
				productAttribute:productAttribute,storeId:storeId,storeName:storeName,storeLogoUrl:storeLogoUrl,goodsId:goodsId,userId:userid},
			dataType:"json",
			success:function(data){
				window.location.href=context+"/gouc_y.jsp";
			}
		});
	}else{//http://192.168.2.223:8080"+context+"/index_cp.jsp?sId="+sId+"&pId="+pId
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
		
	}
}

function connenl_num(){
	$.ajax({
		url:context+"/cpcc/selectAllCollectionNumber?pId="+pId,
		type:"get",
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_num_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".cp_xq_number").text(data);
		}
	})
}

/**
收藏商品
 */
function p_sc(){
	//alert("产品Id:"+pId+"-产品名称:"+productName+"-产品主图:"+productImgUrl+"-贸易商ID:"+storeId+"-贸易商名称:"+storeName+"-贸易商logn:"+storeLogoUrl);
	if(userid!=""){
		$.ajax({
			url:context+"/cpcc/addGoodsToCollect",
			type:"post",
			data:{userId:userid,productId:pId,productName:productName,productImgUrl:productImgUrl,
				storeId:storeId,storeName:storeName,storeLogoUrl:storeLogoUrl},
			dataType:"json",
			success:function(data){
				$("#myModal1").modal();
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}
/**
 * 收藏店铺
 */
function cp_dp(){
	if(userid!=""){
		$.ajax({
			url:context+"/cpcc/addCmsXStoreCollection",
			type:"post",
			data:{userId:userid,storeId:shopId,storeName:storeName,storeImageUrl:storeLogoUrl},
			dataType:"json",
			success:function(data){
				$("#myModal1").modal();
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}


/*立即购买 访问后台*/


var CODE={
	    //初始化化验证码
	    initCode:function(){
	     context+"/ShoppingData/Shopping?pid=322156156";//如果需要点击图片改变图片的内容，则必须添加时间搓
	    }
};

window.post=function (URL, PARAMS) {      
          
}

post('file/success_redirect',"");



window.goumai=function(){
	
	$("#shoppingpid").val(pId);
	$("#shoppingshopId").val(shopId);
	$("#ShopcheckForm").submit();
		/*$.ajax({
			url:context+"/ShoppingData/Shopping",
			type:"post",
			data:{
				"sid":sId,
				"pid":pId
			},
			dataType:"json",
			success:function(data){
				
			}
		});*/
}

		
		
		
