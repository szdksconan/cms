$(document).ready(function(){
	//切换登录选中样式
	$(".login-top div").click(function(){
		var index=$(this).index();
		$(this).addClass("login-current").siblings("div").removeClass("login-current");
	});
	
	//切换内容
	$(".login-left").click(function(){
		$(".login-con-l").addClass("show").removeClass("hide");
		$(".login-con-r").addClass("hide").removeClass("show");
	});
	$(".login-right").click(function(){
		$(".login-con-r").addClass("show").removeClass("hide");
		$(".login-con-l").addClass("hide").removeClass("show");
	});
	//点击切换checkbox状态
	$(".login-link span").click(function(){
		if($(this).attr("class")=="no-ckbox"){
			$(this).attr("class","ok-ckbox");
		}else{
			$(this).attr("class","no-ckbox");
		}
	});
	//聚焦input样式
	$(".login-username-input").focus(function(){
		$(".loign-username").css("border","1px solid #7FAED3");
		$(".login-usericon").addClass("login-uiconjj").removeClass("login-uiconnor login-uiconerror");
	});	
	$(".login-password-input").focus(function(){
		$(".loign-password").css("border","1px solid #7FAED3");
		$(".login-pwdicon").addClass("login-piconjj").removeClass("login-piconnor login-piconerror");
	});
	//账户名验证为空
	$(".login-username-input").blur(function() {        
        var username = $(".login-username-input").val();  
        if(username.length<=0){
        	$(".login-valmsg").css("visibility","visible");
        	$(".login-msg").text("请输入账户名");
        	$(".loign-username").css("border","1px solid #E4393C");
	        $(".login-usericon").addClass("login-uiconerror").removeClass("login-uiconjj");		        
        }else{
        	$(".login-valmsg").css("visibility","hidden");
        	$(".loign-username").css("border","1px solid #CFCFCF");
	        $(".login-usericon").addClass("login-uiconnor").removeClass("login-uiconjj");		       
        }
     });
    //密码验证为空
    $(".login-password-input").blur(function() {
        var userpwd = $(".login-password-input").val();  
        if(userpwd.length<=0){
        	$(".login-valmsg").css("visibility","visible");
        	$(".login-msg").text("请输入密码");
        	$(".loign-password").css("border","1px solid #E4393C");
	        $(".login-pwdicon").addClass("login-piconerror").removeClass("login-piconjj");
        }else{
            $(".login-valmsg").css("visibility","hidden");
            $(".loign-password").css("border","1px solid #CFCFCF");
	        $(".login-pwdicon").addClass("login-piconnor").removeClass("login-piconjj");
        }
     });
    //点击登录验证为空
    $(".login-btn").click(function(){
    	$(".login-btn span").css("margin-top","1px");
    	var username = $(".login-username-input").val(); 
    	var userpwd = $(".login-password-input").val();
    	if(username.length<=0&&userpwd.length<=0){
    		$(".login-valmsg").css("visibility","visible");
    	 	$(".login-msg").text("请输入账户名/密码");
    	 	$(".login-msg-icon").addClass("show").removeClass("hide");
    	 	$(".loign-username").css("border","1px solid #E4393C");
		    $(".login-usericon").addClass("login-uiconerror").removeClass("login-uiconjj");
		    $(".loign-password").css("border","1px solid #E4393C");
		    $(".login-pwdicon").addClass("login-piconerror").removeClass("login-piconjj");
    	 }
    	else if(username.length<=0){
    		$(".login-valmsg").css("visibility","visible");
        	$(".login-msg").text("请输入账户名");
        	$(".login-msg-icon").addClass("show").removeClass("hide");
        	$(".loign-username").css("border","1px solid #E4393C");
		    $(".login-usericon").addClass("login-uiconerror").removeClass("login-uiconjj");
        }
        else if(userpwd.length<=0){
        	$(".login-valmsg").css("visibility","visible");
        	$(".login-msg").text("请输入密码");
        	$(".login-msg-icon").addClass("show").removeClass("hide");
        	$(".loign-password").css("border","1px solid #E4393C");
		    $(".login-pwdicon").addClass("login-piconerror").removeClass("login-piconjj");
        }else{
        	$(".login-valmsg").css("visibility","hidden");
        	$.ajax({
          	  type: 'POST',
          	  url:path+'/login/checklogin',
          	  data: {uname:username,password:userpwd},
          	  dataType: "json",
          	  success:function(data, textStatus){
          		  if (data.success) {
          			  if(data.type == "1"){
          				$(".login-valmsg").css("visibility","visible");
          	        	$(".login-msg").text(data.msg);
          	        	$(".login-msg-icon").addClass("show").removeClass("hide");
          	        	$(".loign-username").css("border","1px solid #E4393C");
          			    $(".login-usericon").addClass("login-uiconerror").removeClass("login-uiconjj");
          				
          			  }else if(data.type == "2"){
          				$(".login-valmsg").css("visibility","visible");
          	        	$(".login-msg").text(data.msg);
          	        	$(".login-msg-icon").addClass("show").removeClass("hide");
          	        	$(".loign-password").css("border","1px solid #E4393C");
          			    $(".login-pwdicon").addClass("login-piconerror").removeClass("login-piconjj");
          			  }else{
          				window.location.href=path+"/register/newbieRoad";
          			  }
      			    }else{
  			    		$(".login-valmsg").css("visibility","visible");
  			    	 	$(".login-msg").text(data.msg);
      			    }
                }
          	  
          });
        	
        }
    });
    //账户名框删除功能
    $(".login-userdel").click(function(){
    	$(".login-username-input").val("");
    	$(".login-userdel").addClass("hide").removeClass("show");
    	$(".login-valmsg").css("visibility","hidden");
    });
    //密码框删除功能
    $(".login-pwddel").click(function(){
    	$(".login-password-input").val("");
    	$(".login-pwddel").addClass("hide").removeClass("show");
    	$(".login-valmsg").css("visibility","hidden");
    });
    
    
    
});

 //账户名框聚焦时显示删除小图标
function CheckNumber(){
	    var num = document.getElementById("login-username-input").value;
	    if(num.length <= 0){
	       $(".login-userdel").addClass("show").removeClass("hide");
	    }
	}
 //密码框聚焦时显示删除小图标
function CheckNumber2(){
	    var num = document.getElementById("login-password-input").value;
	    if(num.length <= 0){
	       $(".login-pwddel").addClass("show").removeClass("hide");
	    }
	}