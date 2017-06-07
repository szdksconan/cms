<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page language="java" import="com.cms.util.CmsUtil" %> 
 <%
  String name="";
     name=CmsUtil.CheckLogin(request);
  %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Cookie cookies[]=request.getCookies();
  	
  	 if(cookies != null){
  		
         for(int i=0;i<cookies.length;i++){
        	 if("dl_cms_user".equals(cookies[i].getName()))
        	 out.println(cookies[i].getValue()+"已登录");
          
        } --> 
<head>
    <title>产贸送消费应用平台</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script >
	    var context = "${pageContext.request.contextPath}";
	    var userid="<%=name%>";
    </script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>   
    <script src="${pageContext.request.contextPath}/js/md5.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>   
    <script src="${pageContext.request.contextPath}/js/logionComm.js"></script> 
   <!--  <script src="${pageContext.request.contextPath}/js/urlSplit.js"></script>  -->
    <style>
    .xf_goudengs{width: 100%;min-height: 500px;background: url('../images/login_bg.png') no-repeat top center;border:1px solid #febf00;background-color: #febf00;}
    .login_div{width:308px;height:auto;float:left;margin:10px 20px;}
    .login_div div{floar:left;width:100%;} 
    .login_div input[type='password'],.login_div input[type='text']{float:left;height: 40px;border-radius: 0;border:none;border:1px solid #ddd;width:100%;}
    .login_lable{width:100%;float:left;font-size:1.3em;font-weight:600;height:30px;line-height:30px;}
    .w100left{width:100%;float:left;text-align:left;}
    </style>

</head>

<body  style="overflow-x:hidden ">

	<!--消费顶部-->
	<div class="xf_thd">
	    <p style="height:100px; ">
	        <a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/gouwu/deng_logo.jpg"   ></a>
	    </p>
	</div>

	<!-- 消费顶部菜单-->
	<div  class="xf_goudengs">
    	<div style="width:350px;height:auto;flaot:left;margin:20px 15% 0px auto;background-color:#fff;border:1px solid #ddd;overflow: hidden;">
    		<div style="height:50px;float:left;width:100%;line-height:60px;">
                <h2 style="font-size:2em;float:left;margin-left:20px;line-height:50px;">登录</h2>
               	<a  id="login_1" href="gouc_regist.jsp" target="_self" style="float:right; margin-right:20px;font-size:1em;color:rgb(251,135,60);"><span>&lt;-</span>立即注册</a>
            </div>
           <hr style="width:100%;color:#333;"/>
    		<div class="login_div" >
    			
	    			<div class="login_lable" >登录名、手机号码或邮箱地址</div>
	    			<input type='text' id="user" name='user' value='手机号/会员名/邮箱' onblur="user()" /><!-- onfocus="if(this.value == '手机号/会员名/邮箱') this.value = ''" onblur="if(this.value =='') this.value = '手机号/会员名/邮箱'"  -->
	    			<div class="w100left" style="height:20px;">
	    				<!--  <span class='info user_put'></span> -->
	                     <span class='user_error'></span><!--info_error  -->
	                     <!-- <span class='ok user_ok'></span> -->
	                </div>
	    			<div class="login_lable" >密码
	    			 	<a style="float:right; font-size:0.1em;font-weight:100; color:#999;">忘记密码</a>
	    			</div>
	    			<input type='password' id="pass" name='pass' vlaue='密码'  onblur="pwds()"/>
	    			<div class="w100left" style="height:20px;">
	    				<!--  <span class ='info pass_put' style="margin-top:35px;"></span> -->
					     <span class='safe' style="margin-top:38px;">安全等级：<strong class='s s1'></strong> <strong class='s s2'></strong>
						        <strong class='s s3'></strong> <strong class='word'></strong>
					     </span>
	                     <span class=' pass_error'></span><!-- info_error -->
	                    <!--  <span class='ok pass_ok'></span> -->
	                </div>
	            	<!-- onclick="logoninfo()" --><a onclick="loginsub()" href="javascript:void(0);" target="_self" class="w100left"> <img   onmousemove="this.src='${pageContext.request.contextPath}/images/gouwu/delu1.jpg'" onmouseout="this.src='${pageContext.request.contextPath}/images/gouwu/delu.jpg'"src="${pageContext.request.contextPath}/images/gouwu/delu.jpg"></a>
	            	<p  style="margin:30px 0px 30px 35%;float:left;" >
		                   <input type="checkbox" name="checkbox" id="checkbox" style="float:left"/>下次自动登录
		            </p>
		            <P class="w100left">登录本网站即表明您同意我们的使用和销售条款条件及 隐私声明</P>
    		</div>
    	</div>
    </div>
    	
     <%-- <div  class="xf_goudeng">
        <div class="xf_goud1">       
            <div class="xf_login">
                          登录
                <span style="margin-left:218px;font-size: 14px;"><a id="login_2" href="gouc_regist.jsp" target="_self" style="color:#fa873b;">立即注册</a><span><img style=" margin-top: 2.5px;" src="${pageContext.request.contextPath}/images/gouwu/deng_l3.jpg"> </span></span>
            </div>
	        <div id="formbox" style="position:relative;top:80px;left:702px;left:692px\9;">
	            <div class="form">
	                <div class="item">
	                    <span class="label"><span class="red"></span><img src="${pageContext.request.contextPath}/images/gouwu/deng_l1.jpg"> </span>
	                    <div class="fl">
	                        <dd class='user_dd'>
	                            <input type='text' id="user" name='user' value='手机号/会员名/邮箱' onfocus="if(this.value == '手机号/会员名/邮箱') this.value = ''" onblur="if(this.value =='') this.value = '手机号/会员名/邮箱'" style="width: 268px;float:left;margin-left:-50px;height:35px;border-radius:0;margin-top:-37px;border: 1px solid #dddddd; "/>
	                            <span class='info user_put'></span>
	                            <span class='info_error user_error'>请输入正确用户名!</span>
	                            <span class='ok user_ok' style="margin:-20px 0 0 -20px;"></span>
	                        </dd>
	                    </div>
	                </div><!--item end-->
	                <div class="item">
	                    <span class="label"><span class="red"></span><img src="${pageContext.request.contextPath}/images/gouwu/deng_l2.jpg"> </span>
	                    <div class="fl">
	                        <dd>
	                            <input type='password' id="pass" name='pass' vlaue='密码'  style="width: 268px;float:left;margin-left:-50px;height:35px;border-radius:0;margin-top:-17px;border: 1px solid #dddddd; "/>
	                            <span class ='info pass_put' style="margin-top:35px;"></span>
					            <span class='safe' style="margin-top:38px;">安全等级：<strong class='s s1'></strong> <strong class='s s2'></strong>
						         <strong class='s s3'></strong> <strong class='word'></strong>
					          </span>
	                            <span class='info_error pass_error' style="margin-top:38px;">请输入正确密码!</span>
	                            <span class='ok pass_ok' style="margin:2px 0 0 -20px"></span>
	                        </dd>
	                    </div>
	                    
	                </div><!--item end-->
	                <p align="left" style="margin-top:10px;margin-left: 45px;margin-left: 55px\9;font-size: 13px;">
	                    <span ><input type="checkbox" name="checkbox" id="checkbox" style="float: left;margin-top: 3px\9;margin:3px 2px 0 0;" />下次自动登录<span style="margin-left:150px">忘记密码？</span> </span>
	                </p>
	
	                <div class="item" style="margin:20px 0 0 45px;margin-left:52px\9;">
	                    <a onclick="logoninfo()" href="javascript:void(0);" target="_self"> <img   onmousemove="this.src='${pageContext.request.contextPath}/images/gouwu/delu1.jpg'" onmouseout="this.src='${pageContext.request.contextPath}/images/gouwu/delu.jpg'"src="${pageContext.request.contextPath}/images/gouwu/delu.jpg"></a>
	                </div>
	                <P style="width: 300px;margin:30px 0 0 45px;font-size: 13px;margin-left: 52px\9;">登录本网站即表明您同意我们的使用和销售条款条件
	                    及 隐私声明</P>
	            </div>
	        </div>

         </div>
    </div>  --%>
	<div align="center" >
	    <script src="${pageContext.request.contextPath}/js/index_foot.js">
	
	    </script>
	</div>	

<script>
    
    $('.xf_cl').hide();
    $("input").each(function(){
        $(this).focus(function(){
            if( $(this).val() == $(this).get(0).defaultValue ){
                $(this).val("");
                $('.xf_cl').show();
            }
        });
        $(this).blur(function(){
            if( $(this).val() == "" ){
                $(this).val( $(this).get(0).defaultValue );
                $('.xf_cl').hide();
            }
        })
    });

    $(".xf_tsouy div img").click(function(){
        $(this).hide();
        $(".xf_input").val( $(this).get(0).defaultValue );
    }); 

</script>

<!-- <script>
$.ajax({
	url:context+"/logon/CheckLogin",
	data:{
		},
	dataType:"json",
	type:"post",
	success:function(data){
		        //alert(data);
	}
});

</script> -->
        <!--   验证表单js css-->
      <%-- <script type="text/javascript" src='${pageContext.request.contextPath}/js/Myjs.js'></script> 
      <script type="text/javascript" src='${pageContext.request.contextPath}/js/myemail.js' >  --%>
    <script>
    var ok1=false;
    var ok2=false;
    //登录名
    function user(){
    	if($("#user").val()==null||$("#user").val()==""||$("#user").val()=="手机号/会员名/邮箱"){
		    $(".user_error").html("请输入用户名、手机号码或邮箱地址!");
		    ok1=false;
		}else{
			/*  if($("#user").val()=="15882179420"){*/
                 $(".user_error").html(""); 
               ok1=true;
             /* }else{
            	 $(".user_error").html("请输入正确登录名!");
                ok1=false;
              } */
		}
    }
    //密码
    function pwds(){
    	if($("#pass").val()==null||$("#pass").val()==""){
		    $(".pass_error").html("请输入密码!");
		    ok2=false;
		}else{
			/*  if($("#pass").val()=="123456"){ */
                 $(".pass_error").html("");
               ok2=true;
           /*   }else{
            	 $(".pass_error").html("请输入正确密码!");
                ok2=false;
              } */
		}
    }
    
    function loginsub(){
    	user();
    	pwds();
    	if(ok1&&ok2){
    		logoninfo();
    	}
    }
    </script>    
        
</body>

</html>