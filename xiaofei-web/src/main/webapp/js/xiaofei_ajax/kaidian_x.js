$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var Id=GetQueryString("Id");
	if(userid!=""){
		$.ajax({
			url:context+"/open/selectGetCmsXShopApplyByIdAndInfo",
			type:"get",
			data:{Id:Id},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				recuit_OK(data.productRecruitId);
				var html="";
				html+="<tbody>";
				html+="<tr>";
				html+="<td colspan=\"2\">基本信息</td>";
				html+="</tr>";
				html+="<tr>";
				html+="<td width=\"150\">真实姓名：</td>";
				html+="<td>"+data.name+"</td>";
				html+="</tr>";
				html+="<tr>";
				html+="<td >手机号码：</td>";
				html+="<td>"+data.tel+"</td>";
				html+="</tr>";
				html+="</tbody>";

				html+="<tr>";
				html+="<td colspan=\"2\"><P class=\"h_xuline\"></P></td>";
				html+="</tr>";
				html+="<tbody>";
				html+="<tr>";
				html+="<td >申请区域：</td>";
				html+="<td>"+data.provinceName+data.regionName+data.cityName+"</td>";
				html+="</tr>";
				html+="</tbody>";
				html+="<tbody>";
				html+="<tr>";
				html+="<td >具备服务能力：</td>";
				html+="<td>"+data.brief+"</td>";
				html+="</tr>";
				html+="</tbody>";
				$(".kd_info_user").append(html);
			}
		})
	}
});

function recuit_OK(id){
	$.ajax({
		url:context+"/open/selectCmsXRecruitByIdAndInfo",
		type:"get",
		data:{id:id},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$("#sj_logo_img").attr("src",data.productLogoUrl);
			var str=data.recruitRule;//比如str是你那个字符串
			eval("var p="+str+";");//将json格式字符串转换为json对象
			$(".sj_disc_name").text(data.productName);
			$(".sj_recruitRule_info").append(p.ruleBusiRight+"<br/>"+p.ruleCustomerService+"<br/>"+p.ruleProRight);
			$(".sj_addr_crity").append(data.provinceName+"-"+data.regionName+"-"+data.cityName);
			$(".sj_name_and_tel").append(data.contactsName+"&nbsp;&nbsp;"+data.contactsTel);
			$(".sj_apply_mony").text(p.rulePayWayName);
			$(".sj_hz_fs").text(p.ruleSaleTypeName);
			$(".sj_user_cs").text(data.visitTime);
			var tble="";
			$.each(data.cmsXRecruitProducts,function(i,n){
				tble+="<tr>";
				tble+="<td></td>";
				tble+="<td><input class=\"spnum zs"+n.productId+"\" style=\"display:none\" value="+n.productId+" />"+n.productId+"</td>";
				tble+="<td>"+n.productName+"</td>";
				tble+="<td>"+n.brandName+"</td>";
				tble+="<td>"+n.productTypeFullName+"</td>";
				tble+="</tr>";
			});
			$(".sp_info_body").append(tble);
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
		}
	});
}