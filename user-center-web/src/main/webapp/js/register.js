
var user_type;//用户类型

$(document).ready(function(){
	
	//第一步电话号码验证
	$("#checkphone").validate({  
		submitHandler: function(form) {
			
			 //tostepthree();
		 },
		rules:{
			phone:{
				required:true,
				isMobile:true
			}
		},
		
		messages:{
			phone:{
				required:"请输入电话号码",
		        isMobile:"请输入正确的电话号码格式"	
			}
			
		},
		
		errorPlacement : function(error, element) {
			error.appendTo(element.parent().next());
			phone.onfocus;
		}
		
	});
	
	//第二步验证密码和确认密码
	$("#checkpw").validate({ 
		submitHandler: function(form) {
		
			 tostepthree();
		 },
		rules:{
			  user: {
				    required: true,
				    minlength: 5,
				    remote:{
						type:"POST",
			            url:path+"/personRegister/checkRegister",
			            data:{
			            	uname:function(){
			         		  return $("input[name='user']").val();
			         	  }
			            } 
					  }
				    
				   },
			pass:{
				required:true,
				minlength:6
				
			},
		
			confirm_pass:{
				required:true,
				minlength:6,
				equalTo: "#password"
			}
		},
		 messages: {
			 user: {
			    required: "请输入会员名",
			    minlength: jQuery.format("会员名不能小于{0}个字 符"),
			    remote:jQuery.format("该用户名已被使用")
			   },
			   pass: {
			    required: "请输入密码",
			    minlength: jQuery.format("密码不能小于{0}个字 符")
			   },
			   confirm_pass: {
			    required: "请输入确认密码",
			    minlength: jQuery.format("确认密码不能小于{0}个字 符"),
			    equalTo: "两次输入密码不一致"
			   }
		 },
		 

		errorPlacement : function(error, element) {
			error.appendTo(element.parent().next());
			
		}
		 
	});
	
	
	

	//获取下拉列表的值触发验证规则
	$("#cert_type").on("click",function(){	
		var temp = $(this).find("p").html();
		if("身份证"==temp){
			$("#idCard").attr("name","idCard");//修改name的属性,对应下面的属性
		}else if("护照"==temp){
			$("#idCard").attr("name","passport");//修改name的属性,对应下面的属性
			
		}
	});
	
	//第三步验证件号码和邮箱
	
	$("#checkInfo").validate({ 
		submitHandler: function(form) {
			 save();
		 },
		rules:{
			email: {
			    required: true,
			    email: true
			   },
			idCard :
				{
				required : true,
				isIdCardNo : true

			},
			personName:{
				   required: true,
				   rangelength:[1,50]
			   },
			passport:{
				required:true,
				passport:true
			}
		},
		messages:{
			email:{
				   required: "请输入邮箱",
				   email: "请输入正确格式的电子邮件"
			      },
		    idCard :
		          {
		           required : "请输入证件号码",
		           isIdCardNo : "请输入正确的证件号码"

                   },
                   personName:{
            		   required: "请输入联系人姓名",
               		   rangelength: jQuery.validator.format("请输入 一个长度介于 {0} 和 {1} 之间的字符串")
            	   }
		},
		errorPlacement : function(error, element) {
			error.appendTo(element.parent().next());
		}
	});
	
	
	
	
	
	//切换注册角色样式
	$("#li-com a").click(function(){
		$(this).removeClass("register-nocurrent");
		$("#li-per a").addClass("register-nocurrent");
	});
	$("#li-per a").click(function(){
		$(this).removeClass("register-nocurrent");
		$("#li-com a").addClass("register-nocurrent");
	});
		

	//个人--点击下一步跳到step2
	$("#register-per-nextbtn1").click(function(){
		
		if(phone.value.length==0){			
			phone.focus();//把光标移到输入电话号码框里
			$(".register-num").text("请输入电话号码");
			return;
		}else{
			$(".register-num").text("");
		}
		
		if(verification_code.value.length==0){			
			verification_code.focus();//把光标移到输入电话号码框里
			$(".register-num").text("请输入验证码");
			return;
		}else{
			$(".register-num").text("");
		}
		
		$(".re-per-step1").addClass("hide").removeClass("show");
		$(".re-per-step2").addClass("show").removeClass("hide");
	});
	
  
});


//点击发送按钮切换成倒计时60秒
var wait=60;
function time(o){
	if(wait==0){
		o.removeAttribute("disabled");
		o.value="获取验证码";
		wait=60;
	}else{
		o.setAttribute("disabled",true);
		o.value="重新发送("+wait+")";
		wait--;
		setTimeout(function(){
			time(o)
		},1000)
	}
}
document.getElementById("register-send-btn").onclick=function(){time(this);}


function safeTest(str){
	var strlen = str.length;
	var codeCont = 0;
	if( /\d/.test(str) ) codeCont++;
	if( /[a-zA-Z]/g.test(str) ) codeCont++;
	if( /_/g.test(str) ) codeCont++;
	if( strlen < 10 && codeCont == 1) return 1;
	else if( strlen < 10 && codeCont == 2 ) return 2;
	else return 3;

}


//个人注册第二步提交
function tostepthree(){
	var uname=document.getElementById("user").value; 
	$(".register-user").text(uname);
	var password=document.getElementById("password").value; 
	var phone=document.getElementById("phone").value; 
	$("#personphone").text(phone);
	$.ajax({
		url:"/user-center-web/personRegister/insertRegister",
		data:{
			"uname":uname,
			"password":password,
			"phone":phone,
			"userType":user_type
		},
		type:"POST",
		dataType:"json",
		success:function(data,textStatus){
			if (data.success) {
				$(".re-per-step2").addClass("hide").removeClass("show");
				$(".re-per-step3").addClass("show").removeClass("hide");
    			
	    	}else{
	    		alert('注册失败!');
	    	}
       }
			
	});
	
}
//获取用户类型(个人用户)
$(function(){
	$(".nav li").click(function(){
		 user_type=$(this).index();
	
	});
});


//保存信息;
function save(){

	var uname=document.getElementById("user").value; 
	var realname=document.getElementById("personName").value; 
	var sex = $('input[name="sex"]:checked').val();
	var tel1=document.getElementById("tel1").value; 
	var tel2=document.getElementById("tel2").value; 
	var tel3=document.getElementById("tel3").value; 
	var tel=tel1+"-"+tel2+"-"+tel3;
	var phone=document.getElementById("phone").value; 
	var cert_num=document.getElementById("idCard").value; 
	var email=document.getElementById("email").value; 
    var cert_type=document.getElementById("per_card").innerHTML; 
	$.ajax({
		url:"/user-center-web/personRegister/addSysUser",
		data:{
			"realname":realname,
			"sex":sex,
			"tel":tel,
			"certNum":cert_num,
			"email":email,
			"certType":cert_type,
			"uname":uname
		},
		type:"POST",
		dataType:"text",
		success:function(data){
			alert("信息已保存成功");
			/*location.href="/user-center-web/login.jsp";*/
			
		}
	});
	
}




