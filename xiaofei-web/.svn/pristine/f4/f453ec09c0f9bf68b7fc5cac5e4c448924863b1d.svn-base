var compId="";//生产商Id
var companyName="";//生产商名称
var investmentOrderId="";//招商单Id
var investmentOrderCode="";//招商单号
var investmentOrderName="";//招商单名称
var name = "";
var productRecruitId="";
var productNames=[];//产品名称
var id="";
var pId="";
$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	id=GetQueryString("id");
	pId=GetQueryString("pId");
	var result=pId.split(",");
	$.ajax({
		url:context+"/open/selectCmsXRecruitByIdAndInfo",
		type:"get",
		data:{id:id},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			compId=data.productId;
			companyName=data.productName;
			investmentOrderId=data.id;
			investmentOrderName=data.productLogoUrl;
			productRecruitId = data.productRecruitId;
			name = data.name;
			var tble="";
			$.each(data.cmsXRecruitProducts,function(i,n){
				for(var i=0;i<result.length;i++){
					if(n.productId==result[i]){
						productNames+=n.productName+",";
						tble+="<tr>";
						tble+="<td>"+n.productId+"</td>";
						tble+="<td>"+n.productName+"</td>";
						tble+="<td>"+n.brandName+"</td>";
						tble+="<td>"+n.productTypeFullName+"</td>";
						tble+="</tr>";
					}
				}
			});
			$(".sp_info_body").append(tble);
		}
	})
})

function save_i_ok(){
	/*后一次改的验证*/
	city();
	desict();
	names();
	xf_tel();
	code();
	if(ok1&&ok2&&ok3&&ok4&&ok5){
		var brief=$(".desict").text();
		var merchantName=$(".xf_name").val();
		var tel = $(".xf_tel").val();
		var hcity = document.getElementById("hcity").getAttribute("data-id");//省代码
		var hproper = document.getElementById("hproper").getAttribute("data-id");//市代码
		var harea = document.getElementById("harea").getAttribute("data-id");//区县代码
		var provinceName = $("#hcity").val();
		var regionName = $("#hproper").val();
		var cityName = $("#harea").val();
		var merchantLocationName = provinceName+regionName+cityName;
		$.ajax({
			url:context+"/open/application",
			type:"post",
			data:{compId:compId,companyName:companyName,merchantInfoId:userid,merchantName:merchantName,
				investmentOrderId:investmentOrderId,investmentOrderCode:productRecruitId,investmentOrderName:name,brief:brief,
				productIds:pId,productNames:productNames,merchantLocationName:merchantLocationName,merchantContactPerson:tel,
				provinceId:hcity,provinceName:provinceName,regionId:hproper,regionName:regionName,cityId:harea,cityName:cityName},
			dataType:"json",
			success:function(data){
				if(data.xf==1){
					//window.location.href=context+"/f_w/kaidian_x3_3.jsp";
				}
			}
		})
	}
	else{
		alert("验证失败！")
	}
	
	/*之前的验证*/
	/*var brief=$(".desict").text();
	var merchantName=$(".xf_name").val();
	var tel = $(".xf_tel").val();
	var hcity = document.getElementById("hcity").getAttribute("data-id");//省代码
	var hproper = document.getElementById("hproper").getAttribute("data-id");//市代码
	var harea = document.getElementById("harea").getAttribute("data-id");//区县代码
	var provinceName = $("#hcity").val();
	var regionName = $("#hproper").val();
	var cityName = $("#harea").val();*/
	//alert("省代码："+hcity+"/"+provinceName+"--市代码："+hproper+"/"+regionName+"--区县代码："+harea+"/"+cityName);
	/*var merchantLocationName = provinceName+regionName+cityName;*/
	/*if(userid!=""){
		if(merchantName!=""&&merchantName!=null){
			if(tel!=""&&tel!=null){
				$.ajax({
					url:context+"/open/application",
					type:"post",
					data:{compId:compId,companyName:companyName,merchantInfoId:userid,merchantName:merchantName,
						investmentOrderId:investmentOrderId,investmentOrderCode:investmentOrderId,investmentOrderName:investmentOrderName,brief:brief,
						productIds:pId,productNames:productNames,merchantLocationName:merchantLocationName,merchantContactPerson:tel,
						provinceId:hcity,provinceName:provinceName,regionId:hproper,regionName:regionName,cityId:harea,cityName:cityName},
					dataType:"json",
					success:function(data){
						if(data.xf==1){
							window.location.href=context+"/f_w/kaidian_x3_3.jsp";
						}
					}
				})
			}else{
				alert("电话不能为空！");
			}
		}else{
			alert("姓名不能为空！")
		}
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}*/
}