

$(document).ready(function() {
	var phone="";
	var code="";
	var uname="";
	var pwd="";
	var	pwd2="";
	var succeed="blank succeed"
	var CODE={
		    //初始化化验证码
		    initCode:function(){
		     $("#check_img").attr("src",context+"/logon/randomImage?rmd="+new Date().getTime())//如果需要点击图片改变图片的内容，则必须添加时间搓
		     .click(function(){
		      $(this).attr("src",context+"/logon/randomImage?rmd="+new Date().getTime());
		     }); 
		    }
	};
	window.upcode=function (){
		 CODE.initCode();
	}
	$(function(){
		 CODE.initCode();
	});
	
	/*调用登录的页面使用    URL为登录后返回的页面*/
	/*function openNewHtml(){
		if(self!=top){
			var url = "";
			try {
			url = parent.location.href; 
			} 
			catch (e) { 
				url = document.referrer; 
			}
			if(url=="undefined" ||url==undefined){
				url = document.referrer;
			}
			parent.location.href = context+"/g_w/gouc_login.jsp?url="+url;
		}else{
			window.location.href = "http://www.baidu.com";
		}
	}*/
	
	
	
	//var Url = splitUrl(location.href,"url");
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|$)"+ name +"=([^$]*)(^|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var url=GetQueryString("url");
	
	/*注册后登录*/
	//var Url = "http://www.baidu.com";
	/*window.logoninfo=function(){
		alert("00");
		phone=$("#mobile").val();
		uname=$("#username").val();
		pwd=$("#pwd").val();
		
		
	}*/
	/*登陆*/
	window.logon=function(name,pass){
		pwd = hex_md5(pwd);
		$.ajax({
			url:context+"/logon/logoninfo",
			data:{"uname":name,
				"password":pass},
			dataType:"json",
			type:"post",
			success:function(data){
				if(data!=null&&data.uid!=null)
					window.location.href=url+"";
					//;
				else
					alert("登录失败!!");
		        
		        
		        
			}
		});
	}
	
	window.logoninfo=function(){
		uname=$("#user").val();
		pwd=$("#pass").val();
		if(uname.length<4||uname.length>18)
			alert("请输入正确的用户名！");
		else if(pwd.length<6||pwd.length>18)
			alert("请输入正确的密码！");
		else{
			pwd = hex_md5(pwd);
			logon(uname,pwd);
		}
		
	}
	
	
	/*注册*/
	window.login=function(){
		phone=$("#mobile").val();
		uname=$("#username").val();
			if($("#mobile_succeed").attr("class")==succeed&&$("#mobile_succeed").attr("class")==succeed&&$("#pwd_succeed").attr("class")==succeed&&$("#pwd2_succeed").attr("class")==succeed)
				{
				pwd=$("#pwd").val();
				pwd2=$("#pwd2").val();
				if(pwd.length>2&&pwd==pwd2){
					
					pwd = hex_md5(pwd);
					
				}
				$.ajax({
					url:context+"/logon/login",
					data:{"phone":phone,
						"uname":uname,
						"password":pwd},
					dataType:"json",
					type:"post",
					success:function(data){
						if(data==1)
							//logon(phone,pwd);
							window.location.href=context+"/g_w/gouc_login.jsp?url="+url;
						else
							alert("注册失败!!");
				        
				        
				        
					}
				});
				
				}
	}
	
	/*$("#mobile_succeed").attr("class");
	$("#username_succeed").attr("class");
	$("#pwd_succeed").attr("class");
	$("#pwd2_succeed").attr("class");
	
	pwd=$("#pwd").val();
	pwd2=$("#pwd2").val();
	if(pwd==pwd2)
		pwd = hex_md5(pwd);*/
	
	
	
	/*验证手机号、用户名是否注册*/
	window.ifinfo=function (type){
		if(type==1){
			phone=$("#mobile").val();
			uname="";
		}
		else if(type=2){
			phone="";
			uname=$("#username").val();
		}
		if(phone.length==11||uname.length>=4){
			$.ajax({
				url:context+"/logon/ifinfo",
				data:{"phone":phone,
					"uname":uname},
				dataType:"json",
				type:"post",
				success:function(data){
					if(data[0]!=null){
						if(data[0].uid!=null&&type==1){
							//手机号已注册
							$("#mobile_succeed").attr("class","blank");
							$("#mobile_error").attr("class","error");
							$("#mobile_error").text("该手机号码已被使用!!");
						}
						//mobile_error
						else
							//号码正确
							$("#mobile_succeed").attr("class","blank succeed");
						if(data[0].uid!=null&&type==2){
							//用户名已注册
							$("#username_succeed").attr("class","blank");
							$("#username_error").attr("class","error");
							$("#username_error").text("该用户名已被使用!!");
							//alert("该用户名已被使用，请使用其它用户名注册！！");
							}
						else
							//用户正确
							$("#username_succeed").attr("class","blank succeed");
					}else{ 
						if(type==1)
							//号码正确
							$("#mobile_succeed").attr("class","blank succeed");
						else if(type==2)
							//用户正确
							$("#username_succeed").attr("class","blank succeed");
						//注册方法 
						;}
				}
			});
		}
	}
	/*验证码是否正确*/
	window.CkCode=function(){
		code=$("#authcode").val();
		if(code.length==4){
			$.ajax({
				url:context+"/logon/CkrandomImage",
				data:{"randomStr":code},
				dataType:"json",
				type:"post",
				success:function(data){
					//alert(data.Qualif.imageType);
						if(data==true)
							$("#authcode_succeed").attr("class","blank succeed");
						else{
							$("#authcode_error").attr("class","error");
							$("#authcode_error").text("验证码错误!!");
						}
			        
			        
				}
			});
		}else{
			$("#authcode_error").attr("class","error");
			$("#authcode_error").text("验证码错误!!");
		}
	}
})