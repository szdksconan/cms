$(document).ready(function() {
	//alert(1);
	//refresh();
	$("#PriceNum").html(PriceNum);
	$("#shoppingPriceNum").html(PriceNum);
	sele();
});
var addressId="";
function sele(){
	if(userid!=""){
		$.ajax({
			url:context+"/addr/select_user_address?uId="+userid,
			type:"get",
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				$.each(data.listData,function(i,n){
					if(n.aStates==1){
						addressId=n.addrId;
						html+="<div value='"+n.addrId+"' class=\"xf_gouy1f\">";
					}
					else
						html+="<div value='"+n.addrId+"' class=\"xf_gouy1\">";
					html+=" <p>姓名:<span class=\"contactName\">"+n.contactName+"</span></p>";
					html+=" <p>联系方式:<sapn class=\"aPhone\">"+n.aPhone+"</span></p>";
					html+="<p>";
					html+="<p>地址:<span class=\"address\">"+n.addressProvince+"-"+n.addressCity+"-"+n.addressCounty+"</span></p>";
					html+="<p class=\"addressDetail\">"+n.addressDetail+"</p>";
					html+="</p>"
					html+= "<p>邮编:<span class=\"postCode\">"+n.postCode+"</span></p>";
					html+="<p align=\"right\"><a class=\"orange uptc_btn\" data-toggle=\"modal\" data-target=\"#myModal\"> 修改</a></p>";
					html+="</div>";//).appendTo(".cout_by");
				})
				$(".cout_by").append(html);
				 /*点击修改地址*/		
				$(".uptc_btn").click(function(){
					//alert($(this).parents("[class^='xf_gouy1'] ").find(".address").html());
					$(".xf_ms").html("修改地址");[abc$="def"] 
					$("#myModal [class$='lable']").addClass("hide");
					$(".xf_ms1 #sh_name").val($(this).parents("[class^='xf_gouy1'] ").find(".contactName").html());//姓名
					$(".xf_ms1 #sh_tel").val($(this).parents("[class^='xf_gouy1'] ").find(".aPhone").html());//联系方式
					$(".xf_ms1 .citys").val($(this).parents("[class^='xf_gouy1'] ").find(".address").html());//所在地区
					$(".xf_ms1 #sh_address").val($(this).parents("[class^='xf_gouy1'] ").find(".addressDetail").html());//详细地址
					$(".xf_ms1 #sh_code").val($(this).parents("[class^='xf_gouy1'] ").find(".postCode").html());//邮编
				 });
				 $(".xf_gouy1,.xf_gouy1f").click(function(){
			            $(".xf_gouy1,.xf_gouy1f").removeClass("xf_gouy1f").addClass("xf_gouy1");
			            $(this).removeClass("xf_gouy1").addClass("xf_gouy1f");
			            addressId=$(this).attr("value");
			            
			    });
				 
				
			}
		})
	}
}

function address_add(){
	var name = $("#sh_name").val();
	var tel = $("#sh_tel").val();
	var xx = $("#sh_address").val();
	var code = $("#sh_code").val();
	//alert("姓名："+name+"-联系方式："+tel+"-详细地址："+xx+"-邮编："+code);
		$.ajax({
			url:context+"/addr/addUserAddress",
			type:"post",
			async : false,
			data:{contactName:name,aPhone:tel,addressDetail:xx,postCode:code},
			dataType:"json",
			success:function(json){
				window.location.reload();
				
			}
		});
}

function refresh(){
	window.location.reload();//刷新当前页面.
}
window.getshoppingdata=function(){
	if(addressId==""){
		alert("请选择收货信息！！");
	}
	else{
		$.ajax({
			url:context+"/ShoppingData/insertOrderOne",
			type:"post",
			async : false,
			data:{"productId":shopId,
				"addressId":addressId,
				"num":shopNum},
			dataType:"json",
			success:function(json){
				window.location.href=context+"/g_w/gouc_z.jsp";
			}
		});
		
		
		}
	
	
}

