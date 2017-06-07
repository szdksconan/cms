//企业信息javaScript
$(function(){
	//验证图片格式
	
	//基本信息提交表单验证
	$("#companyInfoForm").validate({
		errorElement: "em",
        success: function(em) {
//            em.text("ok").addClass("success");//验证通过的动态CSS
        },
        submitHandler:function() {
        	ajaxSbuForm();
        },
		rules:{
			companyName:"required",
			companyLogo:{
//				required:true
			}
		},
		messages:{
			companyName:"请填写您的企业名称",
			companyLogo:{
//				required:"请上传你的企业Logo"
//			    ,checkPic:"请上传正确的图片类型"
			},
			certType:"请选择你的身份类型"
		}
	});
	
	
});
function ajaxSbuForm(){
	//ajax提交保存表单
//	$("#comInfoSbt").click(function(){
		var eid=$("input[name='eid']").val();
		var uid=$("input[name='uid']").val();
		var companyName=$("input[name='companyName']").val();
		//企业标志
		var companyLogo=$("#headPortrait").attr("src");
		alert(companyLogo);
		var industryType=$("#industryType").html();
		var product=$("input[name='product']").val();
		var businessScope=$("textarea[name='businessScope']").val();
		var registerCapital=$("input[name='registerCapital']").val();
		//注册日期
		
		var memberType=$("input[name='memberType']:checked").val();
		var isOem=$("input[name='isOem']:checked").val();
		var param="eid="+eid+"&uid="+uid+"&companyName="+companyName+"&companyLogo="+companyLogo+"&industryType="+industryType+
		"&product="+product+"&businessScope="+businessScope+"&registerCapital="+registerCapital+
		"&memberType="+memberType+"&isOem="+isOem
		$.ajax({
	       cache: true,
	       type: "POST",
	       url:"/user-center-web/accountCom/saveCompanyInfo",
	       data:param,
	       async: false,
	       error: function(request) {
	           alert("出问题啦，产贸送员工正在紧张地抢修！！！");
	       },
	       success: function(data) {
					alert(data.success);
				//刷新地址列表
				window.location.reload();						
	       }
//	   });
	});
}
//验证上传图片格式
function checkData(){
        var fileDir = $( "#companyLogo").val();
        var suffix = fileDir.substr(fileDir.lastIndexOf("." ));
        // && ".png" != suffix
        if( ".jpg" != suffix && ".jpeg" != suffix && ".gif" != suffix){
              alert( "请选择jpg、jpeg/gif图片格式上传！" );
               return false;
        }
        ajaxFileUpload();
        return true;
}


function ajaxFileUpload(){
//		    loading();//动态加载小图标
		    $.ajaxFileUpload ({
			    url :'/user-center-web/accountCom/saveImage',
			    secureuri :false,
			    fileElementId :'companyLogo',
			    dataType :'json',
			    success : function (data, status){
			    	if(data.uri!=null){
			    		alert(data.success);
			    		$("#headPortrait").attr("src","http://192.168.2.213/"+data.uri);
			    	}
			    },
			    error: function (data, status, e){
			    alert("图片未正确上传！！");
			    }
		    });
		    return false;
}

function loading (){
	    $("#loading ").ajaxStart(function(){
	    	$(this).show();
	    }).ajaxComplete(function(){
	    	$(this).hide();
	    });
}



