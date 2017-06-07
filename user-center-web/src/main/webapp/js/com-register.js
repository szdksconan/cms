$(document).ready(function() {
	
 $("#register-comstep1").validate({
	 submitHandler: function(form) {
		 tostep2();
	 },
     rules: {
	   comusername: {
	    required: true,
	    minlength: 5,
	    remote:{
			type:"POST",
            url:path+"/register/nameRegist",
            data:{
            	uname:function(){
         		  return $("input[name='comusername']").val();
         	  }
            } 
		  }
	    
	   },
	   comuserpwd:{
		   required: true,
		   minlength: 5
	   },
	   comuserpwd1: {
	    required: true,
	    minlength: 5,
	    equalTo: "#comuserpwd"
	   },
	   validateCode:{
		   required: true,
		   remote:{
			   type:"POST",
               url:path+"/register/validate",
               data:{
            	  validateCode:function(){
            		  return $("input[name='validateCode']").val();
            	  }
               } 
		   }
	   },
	   checkboxallowfile:{
		   required: true
	   }
    },
    messages: {
	   comusername: {
	    required: "请输入会员名",
	    minlength: jQuery.format("会员名不能小于{0}个字 符"),
	    remote:jQuery.format("该用户名已被使用")
	   },
	   comuserpwd: {
	    required: "请输入密码",
	    minlength: jQuery.format("密码不能小于{0}个字 符")
	   },
	   comuserpwd1: {
	    required: "请输入确认密码",
	    minlength: jQuery.format("确认密码不能小于{0}个字 符"),
	    equalTo: "两次输入密码不一致"
	   },
	   validateCode:{
		   required:"请输入验证码",
		   remote:jQuery.format("验证码错误")
	   },
	   checkboxallowfile:{
		   required: "请阅读注册协议"
	   }
	   
	   
	},
	errorPlacement: function(error, element) { //错误信息位置设置方法
		error.appendTo( element.parent() ); 
	}

 });
 $("#register-comstep2").validate({
	 submitHandler: function(form) {
		 tostep3();
	 },
     rules: {
    	companyname: {
    		required: true,
    		rangelength:[2,50]
	   },
	   compsheng:{
		   required: true
	   },
	   compcity:{
		   required: true
	   },
	   compcountry:{
		   required: true
	   },
	   address:{
		   required: true
	   },
	   email: {
	    required: true,
	    email: true
	   },
	   realuser:{
		   required: true,
		   rangelength:[1,50]
	   },
	   phone2:{
		   required: true,
		   mobile:true
	   }
    },
    messages: {
    	companyname: {
    		required: "请输入企业名",
    		rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串")
	   },
	   compsheng: {
		   required: "请选择省份"
	   },
	   compcity: {
		   required: "请选择城市"
	   },
	   compcountry: {
		   required: "请选择区县"
	   },
	   address:{
		   required: "请输入详细地址"
	   },
	   email:{
		   required: "请输入邮箱",
		   email: "请输入正确格式的电子邮件"
	   },
	   realuser:{
		   required: "请输入联系人姓名",
   		   rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串")
	   },
	   phone2:{
		   required: "请输入手机号码"
	   }
	   
	},
	errorPlacement: function(error, element) { //错误信息位置设置方法
		error.appendTo( element.parent().next() ); 
	}

 });
 jQuery.validator.addMethod("mobile", function(value, element) {  
	 var length = value.length;  
	 return this.optional(element) || (length == 11 && /^1[34578]\d{9}$/.test(value));  
  }, "手机号码格式错误");

 

});


function changeCode(){
  	$('#kaptchaImage').hide().attr('src', path+'/captcha/getKaptchaImage?' + Math.floor(Math.random()*100) ).fadeIn();
}  
$('#kaptchaImage').click(function () {//生成验证码  
   $(this).hide().attr('src', path+'/captcha/getKaptchaImage?' + Math.floor(Math.random()*100) ).fadeIn();  
   event.cancelBubble=true;  
});


function tostep2(){
	var password = $("#comuserpwd").val();
	var uname = $("#comusername").val();
	var param = "password="+password+"&uname="+uname+"&userType=2";
	$.ajax({
    	  type: 'POST',
    	  url:path+'/register/step1',
    	  data: param,
    	  dataType: "json",
    	  async:false,
    	  error : function(e, text){
    		  alert('注册失败!');
    	  },
    	  success:function(data, textStatus){
    		  if (data.success) {
		    			$(".re-com-step1").addClass("hide").removeClass("show");
		    			$(".re-com-step2").addClass("show").removeClass("hide");
		    			$("#register-comstep2 input[name='uid']").val(data.uid);
		    			$("#register-comstep2 input[name='uname']").val(uname);
			    	}else{
			    		alert('注册失败!');
			    	}
          }
    	  
    });
}
function tostep3(){
	
	var uid = $("#register-comstep2 input[name='uid']").val();
	var memberType=$('#register-comstep2 input:radio[name="c-way"]:checked').val();
	var companyName = $("#register-comstep2 input[name='companyname']").val();
	var companyAddressProvince = $("#comp-sheng").find("option:selected").val();
	var companyAddressCity = $("#comp-city").find("option:selected").val();
	var companyAddressCounty = $("#comp-country").find("option:selected").val();
	var companyAddressDetail = $("#register-comstep2 input[name='address']").val();
	var email = $("#register-comstep2 input[name='email']").val();
	var contactPersonName = $("#register-comstep2 input[name='realuser']").val();
	var contactPersonPhone = $("#register-comstep2 input[name='phone2']").val();
	var contactPersonSex=$('#register-comstep2 input:radio[name="com-sex"]:checked').val();
	
	var param = "uid="+uid+"&memberType="+memberType+"&companyName="+companyName+"&companyAddressProvince="+companyAddressProvince
	+"&companyAddressCity="+companyAddressCity+"&companyAddressCounty="+companyAddressCounty+"&companyAddressDetail="+companyAddressDetail
	+"&email="+email+"&contactPersonName="+contactPersonName+"&contactPersonPhone="+contactPersonPhone+"&contactPersonSex="+contactPersonSex;
	$.ajax({
    	  type: 'POST',
    	  url:path+'/register/step2',
    	  data: param,
    	  dataType: "json",
    	  async:false,
    	  error : function(e, text){
    		  alert('注册失败!');
    	  },
    	  success:function(data, textStatus){
    		  if (data.success) {
    			  $(".re-com-step2").addClass("hide").removeClass("show");
    			  $(".re-com-step3").addClass("show").removeClass("hide");
    			  $("#comp-register-user").text($("#register-comstep2 input[name='uname']").val());
			    	}else{
			    		alert('注册失败!');
			    	}
          }
    	  
    });
}
	