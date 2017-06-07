(function($) {
    $.fn.tipsy = function(options) {

        options = $.extend({}, $.fn.tipsy.defaults, options);
        
        return this.each(function() {
            
            var opts = $.fn.tipsy.elementOptions(this, options);
            
            $(this).hover(function() {

                $.data(this, 'cancel.tipsy', true);

                var tip = $.data(this, 'active.tipsy');
                if (!tip) {
                    tip = $('<div class="tipsy"><div class="tipsy-inner"/></div>');
                    tip.css({position: 'absolute', zIndex: 100000});
                    $.data(this, 'active.tipsy', tip);
                }

                if ($(this).attr('title') || typeof($(this).attr('original-title')) != 'string') {
                    $(this).attr('original-title', $(this).attr('title') || '').removeAttr('title');
                }

                var title;
                if (typeof opts.title == 'string') {
                    title = $(this).attr(opts.title == 'title' ? 'original-title' : opts.title);
                } else if (typeof opts.title == 'function') {
                    title = opts.title.call(this);
                }

                tip.find('.tipsy-inner')[opts.html ? 'html' : 'text'](title || opts.fallback);

                var pos = $.extend({}, $(this).offset(), {width: this.offsetWidth, height: this.offsetHeight});
                tip.get(0).className = 'tipsy'; // reset classname in case of dynamic gravity
                tip.remove().css({top: 0, left: 0, visibility: 'hidden', display: 'block'}).appendTo(document.body);
                var actualWidth = tip[0].offsetWidth, actualHeight = tip[0].offsetHeight;
                var gravity = (typeof opts.gravity == 'function') ? opts.gravity.call(this) : opts.gravity;

                switch (gravity.charAt(0)) {
                    case 'n':
                        tip.css({top: pos.top + pos.height, left: pos.left + pos.width / 2 - actualWidth / 2}).addClass('tipsy-north');
                        break;
                    case 's':
                        tip.css({top: pos.top - actualHeight, left: pos.left + pos.width / 2 - actualWidth / 2}).addClass('tipsy-south');
                        break;
                    case 'e':
                        tip.css({top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left - actualWidth}).addClass('tipsy-east');
                        break;
                    case 'w':
                        tip.css({top: pos.top + pos.height / 2 - actualHeight / 2, left: pos.left + pos.width}).addClass('tipsy-west');
                        break;
                }

                if (opts.fade) {
                    tip.css({opacity: 0, display: 'block', visibility: 'visible'}).animate({opacity: 0.8});
                } else {
                    tip.css({visibility: 'visible'});
                }

            }, function() {
                $.data(this, 'cancel.tipsy', false);
                var self = this;
                setTimeout(function() {
                    if ($.data(this, 'cancel.tipsy')) return;
                    var tip = $.data(self, 'active.tipsy');
                    if (opts.fade) {
                        tip.stop().fadeOut(function() { $(this).remove(); });
                    } else {
                        tip.remove();
                    }
                }, 100);

            });
            
        });
        
    };
    
    // Overwrite this method to provide options on a per-element basis.
    // For example, you could store the gravity in a 'tipsy-gravity' attribute:
    // return $.extend({}, options, {gravity: $(ele).attr('tipsy-gravity') || 'n' });
    // (remember - do not modify 'options' in place!)
    $.fn.tipsy.elementOptions = function(ele, options) {
        return $.metadata ? $.extend({}, options, $(ele).metadata()) : options;
    };
    
    $.fn.tipsy.defaults = {
        fade: false,
        fallback: '',
        gravity: 'n',
        html: false,
        title: 'title'
    };
    
    $.fn.tipsy.autoNS = function() {
        return $(this).offset().top > ($(document).scrollTop() + $(window).height() / 2) ? 's' : 'n';
    };
    
    $.fn.tipsy.autoWE = function() {
        return $(this).offset().left > ($(document).scrollLeft() + $(window).width() / 2) ? 'e' : 'w';
    };
    
})(jQuery);
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
var kindId="";		//产品行业id



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
				kindId=n.kindId;
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
	
	var likeHtml="";
	
	/**
	 * 本店同类产品
	 */
	$.ajax({
		url:context+"/shopData/OtherProducesInEnterprise",
		type:"post",
		data:{
			"entpriseId":shopId,
			"industryId":kindId,
			"produceId":pId,
			"isFamousBrand":-1,
			"start":1,
			"pageSize":6
		},
		dataType:"json",
		success:function(data){
			
			$.each(data.records,function(i,n){
				likeHtml+="<span>";
				likeHtml+="<a  href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"&shopId="+n.enterpriceId+"\"><p ><img src=\""+n.productMainImg+"\"> </p></a>";
				likeHtml+="<p>"+n.productNameCn+"</p>";
				likeHtml+="<p><a class=\"red\" >￥"+n.productPrice+"</a></p>";
				likeHtml+="</span>";
			});
			$("#likeHtml").html();
			$("#likeHtml").html(likeHtml);
			
			
		}
	});
	
	/**
	 * 附近产品
	 */
	var nearbyHtml="";
	$.ajax({
		url:context+"/shopData/queryProducesInOtherEnterprise",
		type:"post",
		data:{
			"entpriseId":shopId,
			"industryId":kindId,
			"isFamousBrand":-1,
			"start":1,
			"pageSize":6
		},
		dataType:"json",
		success:function(data){
			
			$.each(data.records,function(i,n){
				nearbyHtml+="<span>";
				nearbyHtml+="<a  href=\""+context+"/index_cp.jsp?sId="+n.goodsId+"&pId="+n.productId+"&shopId="+n.enterpriceId+"\"><p><img src=\""+n.productMainImg+"\"> </p> </a> <p><a class=\"red\" >￥"+n.productPrice+"</a>&nbsp;"+n.productNameCn+"</p>";
				nearbyHtml+="<p>"+n.enterpriceName+"</p>";
				nearbyHtml+="<p><img src=\""+context+"/images/b.jpg\">"+n.enterpriseinfo.manaAddAn+n.enterpriseinfo.manageDetail+"</p>";
				nearbyHtml+="</span>";
			});
			$("#nearbyHtml").html();
			$("#nearbyHtml").html(nearbyHtml);
			
			
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
    	$("#shoppingnum").val(ku_num);
    }
	
	
    /**
     * 查询评论
     */
    window.pinglun=function(level){
    	 //alert(level);
    	
    	var pinHtml="";
    	var pinDataHtml="";
    	var haoHtml="";
    	var zhongHtml="";
    	var chaHtml="";
    	var hao=0;		//好评数
    	var	zhong=0;	//中评数
    	var cha=0;		//差评数
    	var pinlunSum=0;	//总评数
    		$.ajax({
    			url:context+"/shopData/selectAllCmsXProductEvaluation",
    			type:"post",
    			data:{
    				"page":1,
    				"pagesize":10,
    				"productId":pId,
    				"storeId":shopId,
    				"level":level
    			},
    			dataType:"json",
    			success:function(data){
    				
    				$.each(data.listData,function(i,n){
    					if(n.productName==null)
    						n.productName="";
    					if(n.evaluationLevel==5){
    						hao++;
    						haoHtml+="<div class=\"xf_zhanshi\">";
    						haoHtml+="<div>";
    						haoHtml+="<img src=\""+context+"/images/da2.jpg\">";
    						haoHtml+="<p> 帮****黑</p>";
    						haoHtml+="</div>";
    						haoHtml+="<div>";
    						haoHtml+="<p><img src=\""+context+"/images/da4.jpg\" ><a class=\"red\" >好评</a></p>";
    						haoHtml+="<p class=\"d_w\">"+n.evaluationContent+"</p>";
    						haoHtml+="<p>"+n.productName+"&nbsp;"+n.evaluationTime+"</p>";
    						haoHtml+="</div>";
    						haoHtml+="</div>";
    					}else if(n.evaluationLevel==3||n.evaluationLevel==4){
    						zhong++;
    						zhongHtml+="<div class=\"xf_zhanshi\">";
    						zhongHtml+="<div>";
    						zhongHtml+="<img src=\""+context+"/images/da2.jpg\">";
    						zhongHtml+="<p> 帮****黑</p>";
    						zhongHtml+="</div>";
    						zhongHtml+="<div>";
    						zhongHtml+="<p><img src=\""+context+"/images/da3.jpg\" ><a class=\"red\" >中评</a></p>";
    						zhongHtml+="<p class=\"d_w\">"+n.evaluationContent+"</p>";
    						zhongHtml+="<p>"+n.productName+"&nbsp;"+n.evaluationTime+"</p>";
    						zhongHtml+="</div>";
    						zhongHtml+="</div>";
    					}else{
    						cha++;
    						chaHtml+="<div class=\"xf_zhanshi\">";
    						chaHtml+="<div>";
    						chaHtml+="<img src=\""+context+"/images/da2.jpg\">";
    						chaHtml+="<p> 帮****黑</p>";
    						chaHtml+="</div>";
    						chaHtml+="<div>";
    						chaHtml+="<p><img src=\""+context+"/images/da4.jpg\" ><a class=\"red\" >差评</a></p>";
    						chaHtml+="<p class=\"d_w\">"+n.evaluationContent+"</p>";
    						chaHtml+="<p>"+n.productName+"&nbsp;"+n.evaluationTime+"</p>";
    						chaHtml+="</div>";
    						chaHtml+="</div>";
    					}
    					
    					
    				});
    				pinlunSum=parseInt(data.size);
    				pinHtml+="<li class=\"active\"><a href=\"#cfw_c1\" role=\"tab\" data-toggle=\"tab\">全部评价（"+data.size+"）</a></li>";
    				pinHtml+="<li><a href=\"#cfw_c1\" onclick='pinglun(5)' role=\"tab\" data-toggle=\"tab\">好评（"+hao+"）</a></li>";
    				pinHtml+="<li><a href=\"#cfw_c1\" onclick='pinglun(3)' role=\"tab\" data-toggle=\"tab\">中评（"+zhong+"）</a></li>";
    				pinHtml+="<li><a href=\"#cfw_c1\" onclick='pinglun(1)' role=\"tab\" data-toggle=\"tab\">差评（"+cha+"）</a></li>";
    				
    				$("#pinHtml").html();
    				$("#pinHtml").html(pinHtml);
    				
    				pinDataHtml=haoHtml+zhongHtml+chaHtml;
    				$("#pinDataHtml").html();
    				$("#pinDataHtml").html(pinDataHtml);
    				
    				
    				
    				$('#bar-1').jqbar({ label: '好评（'+hao+'）', value: (parseInt(hao)/pinlunSum)*100,span: '%', barColor: '#fbc63a' });

    	            $('#bar-2').jqbar({ label: '中评（'+zhong+'）', value:(parseInt(zhong)/pinlunSum)*100, barColor: '#fbc63a' });

    	            $('#bar-3').jqbar({ label: '差评（'+cha+'）', value: (parseInt(cha)/pinlunSum)*100, barColor: '#fbc63a' });
    				
    	            $("#hapingspan").html();
    	            $("#hapingspan").html((parseInt(hao)/pinlunSum)*100+"%");
    			}
    			
    		});
    		
    		
    		
    		
    }
    pinglun(null);
   

	
	
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
						$(".xf_sho2").text("￥"+k.price);
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
	window.location.href=context+"/index_cp.jsp?pId="+id+"&sId="+sId+"&shopId="+shopId; 
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
			$("#my_shangjia").append("<a href="+context+"/f_w/dianx.jsp?shopId="+shopId+" target=\"_self\"> <img src=\"images/jianguo1.jpg\"></a>");
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
				storeId:shopId,storeName:storeName,storeLogoUrl:storeLogoUrl,goodsId:sId},
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
	//$("#shoppinggoodsId").val(sId);
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

		
		
		
