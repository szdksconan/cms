var upload;
$(function () {
            var btn = $("#Button1").uploadFile({
                url: context+"/file/fileAPreview?type=01&vive=1",
                fileSuffixs: ["jpg", "png", "gif", "txt"],
                maximumFilesUpload: 4,//最大文件上传数
                onComplete: function (msg) {
                    $("#testdiv").append(msg + "<br/>");
                },
                onAllComplete: function () {
                	//post('file/success_redirect',"");
                	window.location.href=context+"/index.jsp";
                },
                isGetFileSize: true,//是否获取上传文件大小，设置此项为true时，将在onChosen回调中返回文件fileSize和获取大小时的错误提示文本errorText
                onChosen: function (file, obj, fileSize, errorText) {
                    if (!errorText) {
                        $("#file_size").text(file + "文件大小为：" + fileSize + "KB");
                    } else {
                        alert(errorText);
                        return false;
                    }
                    return true;//返回false将取消当前选择的文件
                },
                perviewElementId: "fileList", //设置预览图片的元素id
                perviewImgStyle: { width: '110px', height: '145px', border: '1px solid #ebebeb' }//设置预览图片的样式
            });

            upload = btn.data("uploadFileData");

           /* $("#files").click(function () {
                upload.submitUpload();
            });*/
        });

function shopInfo(){
	var name=$(".name").val();
	var tel=$(".tel").val();
	var sellYn=$('input:radio[name="sellYn"]:checked').val();
	var userDetAdr=$(".userDetAdr").val();
	var sellArea=$(".sellArea").val();
	var enterpriseName=$(".enterpriseName").val();
	var enterpriseType=$(".enterpriseType").text();
	var belongsIndustry=$(".belongsIndustry").text();
	var enterpriseWebsite=$(".enterpriseWebsite").val();
	var enterpriseEmail=$(".enterpriseEmail").val();
	var mail=$(".mail_z").val();
	var enterpriseInfo=$(".enterpriseInfo").val();
	var brief=$(".brief").val();
	var cash=$(".cash").val();
	var metCoop=$(".metCoop").text();
	var employedYear=$(".employedYear").text();
	var payWay=$(".payWay").text();
	var applicationArea=$(".applicationArea").val();
	var areaExclBusiness=$('input:radio[name="areaExclBusiness"]:checked').val();
	//var serviceCapability=document.getElementsByTagName("serviceCapability");
	var serviceCapability="";
	var obj = document.getElementsByName("serviceCapability");
	for(var i=0;i<obj.length;i++){
		if(obj[i].checked){
			serviceCapability+=obj[i].value+',';
		}
	}
	/*alert("真实姓名："+name+"手机号码："+tel+"是否有店铺："+sellYn+"街道地址："+userDetAdr+
			"店铺面积："+sellArea+"企业名称："+enterpriseName+"企业性质："+enterpriseType+"所属行业："+belongsIndustry+"企业官网："+enterpriseWebsite+
			"企业邮箱："+enterpriseEmail+"传真："+mail+"企业介绍："+enterpriseInfo+"流动资金："+cash+"个人描述："+brief+"合作方式："+brand+
			"从业年限："+employedYear+"贷款支付："+payWay+"独家经营："+areaExclBusiness);*/
	if(userid!=""){
		$.ajax({
			url:context+"/open/addCmsXShopApply",
			data:{name:name,tel:tel,sellYn:sellYn,userDetAdr:userDetAdr,sellArea:sellArea,enterpriseName:enterpriseName,enterpriseType:enterpriseType,
				belongsIndustry:belongsIndustry,enterpriseWebsite:enterpriseWebsite,enterpriseEmail:enterpriseEmail,mail:mail,enterpriseInfo:enterpriseInfo,
				brief:brief,cash:cash,metCoop:metCoop,employedYear:employedYear,payWay:payWay,areaExclBusiness:areaExclBusiness,userId:userid,
				serviceCapability:serviceCapability,applicationArea:applicationArea},
			dataType:"json",
			type:"post",
			success:function(data){
				if(brief!=null&&brief!=""){
					window.location.href=context+"/index.jsp";
				}
				upload.submitUpload();
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

$(document).ready(function() {
	var sellYn=$('input:radio[name="sellYn"]:checked').val();
	if(sellYn=="否"){
		$(".shop_info").hide();
		$(".pre_desc").show();
	}else{
		$(".shop_info").show();
		$(".pre_desc").hide();
	}
	$.ajax({
		url:context+"/tcbpc/test",
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_success3",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$.each(data,function(i,n){
				$("<li><a href=\"javascript:void(0);\" onclick=\"hy_two('"+n.id+"');\">"+n.name+"</a></li>").appendTo(".h_one");
			})
		}
	})
})

function hy_two(id){
	$.ajax({
		url:context+"/tcbpc/test3?cms="+id,
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_success1",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".h_two").html("");
			$(".h_checked").text("");
			$(".hang2").hide();
			$.each(data,function(i,n){
				$("<li><a href=\"javascript:void(0);\" onclick=\"hy_three('"+n.id+"');\">"+n.name+"</a></li>").appendTo(".h_two");
				$(".hang1").show();
			})
		}
	})
}

function post(URL, PARAMS) {      
    var temp = document.createElement("form");      
    temp.action = URL;      
    temp.method = "post";      
    temp.style.display = "none";      
    for (var x in PARAMS) {      
        var opt = document.createElement("textarea");      
        opt.name = x;      
        opt.value = PARAMS[x];      
        // alert(opt.name)      
        temp.appendChild(opt);      
    }      
    document.body.appendChild(temp);      
    temp.submit();      
    return temp;      
}

function hy_three(id){
	$.ajax({
		url:context+"/tcbpc/test4?cms="+id,
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_success2",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".h_three").html("");
			$(".h_checked1").html("");
			$.each(data,function(i,n){
				$("<li><a href=\"javascript:void(0);\">"+n.name+"</a></li>").appendTo(".h_three");
				$(".hang2").show();
			})
		}
	})
}