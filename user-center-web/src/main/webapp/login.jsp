<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登录页面</title>
    <link href="${ctx}/css/login.css" rel="stylesheet"/>
    <script type="text/javascript">
 		var path = "${ctx}";
    </script>
  </head>
  <body>
    <!--
    	顶部logo
    -->
    	<div class="login-main">
    		<!--logo 图标-->
    		<a href="${ctx}/register/newbieRoad" target="_self"><img src="${ctx}/image/logo.png" alt="logo" class="login-logo"/></a>
    		<div class="login-title">欢迎登录</div>
    	</div>
    	<!--
        	主体模块
        -->
        <div class="login-container">
        	<div class="login-main">
        		<div class="row">
        			<div class="col-md-6"></div>                                           
        			<div class="col-md-6">
        				<div class="login-box">
        					<div class="login-top">
        							<div class="login-left">
        								快速登录
        							</div>
        							<div class="login-right login-current">
        								账户登录
        							</div>
        					</div>
        					<!--
                            	快速登录
                            -->
                  <div class="login-content">
	        					<div class= "login-con-l hide ">
	        						<div class="login-twocode">
	        							<img src="${ctx}/image/login-twocode.png" />
	        							<div>
	        								<p>手机扫码 安全登录</p>
	        								<span>使用手机产贸送二维码</span>
	        							</div>
	        						</div>
	        					</div>
	        					<!--
	                            	账户密码登录内容
	                            -->
	        					<div class="login-con-r show">
	        						<!-- 验证提示信息 -->
	        					  <div class="login-valmsg">
	        					  	<img src="${ctx}/image/icon_error.png"/>
	        					  	<label class="login-msg"></label>
	        					  </div>	
	        						<div class="loign-username">
	        							<div class="login-usericon login-uiconnor"></div>
	        							<input type="text" name="login-name" placeholder="手机号/会员名/邮箱" id="login-username-input" class="login-username-input" onkeydown="CheckNumber()"/>
	        							<span class="login-userdel hide"></span>
	        						</div>
	        						<div class="loign-password">
	        							<div class="login-pwdicon login-piconnor"></div>
	        							<input type="password" name="login-password" placeholder="密码" id="login-password-input" class="login-password-input" onkeydown="CheckNumber2()"/>
	        							<span class="login-pwddel hide"></span>
	        						</div>
	        						<div class="login-link">
	        								<ul>
	        									<li><div><span class="no-ckbox"></span>下次自动登录</div></li>
	        									<li><div><span class="no-ckbox"></span>安全登录控件</div></li>
	        									<li class="login-forget"><a href="JavaScript:;" target="_blank" >忘记密码?</a></li>
	        								</ul>  
	        						</div>
	        						<!--密码五次错误出现验证码-->
	        					  <div class="login-valdiv hide">
	        					  	<input type="text" class="login-valinput" />
	        					  	<span class="login-valspan">ABCD</span>
	        					  	<a href="javascript:;" class="login-vallink">看不清楚，刷新一张</a>
	        					  </div>
	        						<div class="login-btn">
	        							<span>登 录</span>
	        						</div>		        						
		        						<img src="${ctx}/image/icon_enter.png" class="login-entericon"/>
		        						<a href="${ctx}/login/register" target="_blank" class="login-register">免费注册</a>
	        					</div>
        				  </div>  	
        				</div>
        			</div>
        		</div>
        	</div>
        </div>
        <!--
        	底部
        -->
        <div class="login-main">
        	<div class="row">
	        		<div class="col-lg-12">
	        			<div class="login-feedback">
	        				<img src="${ctx}/image/qustion-icon.png" alt="qustion-icon" />
	        				<a href="javascript:;">登录页反馈,调查问卷</a>
	        			</div>
	        		</div>
	        </div>
          <div class="login-footer">          	
	        	<div class="row">
	        		<div class="col-lg-12">
			        	<ul class="login-footer-ul">
			        		<li class="login-right-line"><a href="javascript:;">关于产贸送</a></li>
			        		<li class="login-right-line"><a href="javascript:;">法律声明</a></li>
			        		<li class="login-right-line"><a href="javascript:;">加盟入驻</a></li>
			        		<li class="login-right-line"><a href="javascript:;">帮助中心</a></li>
			        		<li class="login-right-line"><a href="javascript:;">友情链接</a></li>
			        		<li class="padding-l-20"><a href="javascript:;">English</a></li>
			        	</ul>
		        	</div>
	        	</div>
	        	<div class="row">
	        		<div class="col-lg-12">
	        	       <p>Copyright &copy; 2015 cmswl Inc. 保留所有权利</p>
	        	  </div>
	        	</div>        	
        	</div>	       	    
        </div>  
    <script src="${ctx}/js/jquery.1.11.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <script src="${ctx}/js/login.js"></script>
  </body>
</html>