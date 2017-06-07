var compId;//生产商Id
var companyName;//生产商名称
var investmentOrderId;//招商单Id
var investmentOrderCode;//招商单号
var investmentOrderName;//招商单名称
var productIds="";//产品id
var productNames;//产品名称
var id="";
$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	id=GetQueryString("id");
	$.ajax({
		url:context+"/open/selectCmsXRecruitByIdAndInfo",
		type:"get",
		data:{id:id},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".zs_gs_name").text(data.productName);
			$(".zs_gs_address").text(data.provinceName+data.regionName+data.cityName);
			$(".zs_gs_lxr").append(data.contactsName+"&nbsp;&nbsp;"+data.contactsTel);
			$(".zs_gs_time").append(data.publishTime);
			$(".zs_gs_vs").append(data.visitTime);
			$(".zs_gs_sq").append(data.reqTime);
			var str=data.recruitRule;//比如str是你那个字符串
			eval("var p="+str+";");//将json格式字符串转换为json对象
			$(".zs_gs_dise").append(p.ruleBusiRight+"<br>"+p.rulePayWayName+"<br>"+p.ruleCustomerService+"<br>"+
					p.ruleApplyTypeName+"<br>"+p.ruleSaleTypeName+"<br>"+p.ruleProRight);
			var html="";
			$.each(data.cmsXRecruitAreas,function(i,n){
				html+="<tr>";
				if(n.provinceName!=null){
					html+="<td>"+n.provinceName+"</td>";
				}else{
					html+="<td></td>";
				}
				if(n.regionName!=null){
					html+="<td>"+n.regionName+"</td>";
				}else{
					html+="<td></td>";
				}
				if(n.cityName!=null){
					html+="<td>"+n.cityName+"</td>";
				}else{
					html+="<td></td>";
				}
				html+="</tr>";
			});
			$(".zs_gs_adre").append(html);
			var tble="";
			$.each(data.cmsXRecruitProducts,function(i,n){
				tble+="<tr>";
				tble+="<td><input type=\"checkbox\" name=\"checkbox_item'"+n.productId+"'\" class=\"fl f_but\" /></td>";
				tble+="<td><input class=\"spnum zs"+n.productId+"\" style=\"display:none\" value="+n.productId+" />"+n.productId+"</td>";
				tble+="<td>"+n.productName+"</td>";
				tble+="<td>"+n.brandName+"</td>";
				tble+="<td>"+n.productTypeFullName+"</td>";
				tble+="</tr>";
			});
			$(".sp_info_body").append(tble);
			
		}
	})
});

function apply_button(){
	productIds=[];
	if($(".f_but").each(function(){
		if ($(this).attr("checked")) { 
			productIds.push($(this).parent().next().text());
		}
	}));
	if(userid!=""){
		if(productIds!=""){
			window.location.href=context+"/f_w/kaidian_x3.jsp?pId="+productIds+"&id="+id;
		}else{
			alert("请选择商品");
		}
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}