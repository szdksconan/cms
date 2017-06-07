<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册页面</title>
    <link href="${ctx}/css/register.css" rel="stylesheet" />
    <style type="text/css">
    	.error{
    		color:blue;
    	}
    
    </style>
    
    <script type="text/javascript">
	  	var path = "${ctx}";
    	
	
    
    </script>
  </head>
  
  <body>
        <!--顶部logo-->
    	<div class="re-container">
    		<!--logo 图标-->
    		<a href="${ctx}/index" target="_self"><img src="${ctx}/image/logo.png" alt="logo" class="login-logo"/></a>
    		<div class="login-title">欢迎注册</div>
    	</div>
    	<!--主体模块--> 
      <div class="re-container">
      		<div class="re-going-login">
						 	我已经注册，现在就
						  <a href="${ctx}/login/login">登录</a>
						  <a href="javascript:;" class="register-lang">English</a>
					</div>
	        <ul class="nav nav-tabs" role="tablist" id="tab-list">
				    <li class="active" id="li-com">
				   	    <a href="#tab-company" role="tab" data-toggle="tab">企业用户</a>
				    </li>
				    <li id="li-per">
				   	    <a href="#tab-personal" role="tab" data-toggle="tab" class="register-nocurrent">个人用户</a>
				   	</li>			   	
				  </ul>
					<div class="tab-content">						
						 <!--开始 企业用户 -->
						<div class="tab-pane active" id="tab-company">
							<!-- 第一步 -->
							<div class="re-com-step1 show">
								    <!--顶部步骤-->
								    <div class="register-step">
								    	<img src="${ctx}/image/img_flow_one.png" />
								    	<span class="register-flow1 color-B70707">设置账号</span>
								    	<span class="register-flow2 color-A3A3A3">填写账号信息</span>
								    	<span class="register-flow3 color-A3A3A3">注册成功</span>
						  	    </div>
						  	    <!--开始主体内容-->
						  	    <div class="register-mid" align="center">
						  	    	<form method='post' action='#' id="register-comstep1">
									  	<table class="register-comstep1-table">
									  		<tr>
									  			<td width="20%" class="text-right">会员名</td>
									  			<td width="45%" class="text-left">
									  				<input type="text" id ="comusername" name="comusername" class="register-username">
									  			<!--	<span class='info comusername_put'>请输入您的会员名。</span>
													  <span class='info_error comusername_error' >请输入正确会员名！</span>
													  <span class='ok comusername_ok'></span>		-->																			
									  			</td>
									  		</tr>
									  		<tr>
									  			<td class="text-right">密码</td>
									  			<td class="text-left">
									  				<input type="password" id="comuserpwd" name="comuserpwd" class="register-username">
									  				<!--<span class='info comuserpwd_put'>请输入您的密码。</span>
													  <span class='info_error comuserp_error'>请输入正确密码！</span>
													  <span class='ok comuserpwd_ok'></span>		-->
									  			</td>
									  		</tr>
									  		<tr>
									  			<td class="text-right">确认密码</td>
									  			<td class="text-left">
									  				<input type="password" name="comuserpwd1" class="register-username">
									  				<!--<span class='info comuserpwd_put'>请再次输入您的密码。</span>
													  <span class='info_error comuserp_error'>两次密码不一致！</span>
													  <span class='ok comuserpwd_ok'></span>		-->
									  			</td>
									  		</tr>
									  		<tr>
									  			<td class="text-right">验证码</td>
									  			<td class="text-left">
									  				<input type="text" name="validateCode" class="register-validate">
									  				
													<img src="${ctx}/captcha/getKaptchaImage" id="kaptchaImage"  style="margin-bottom: 4px;margin-left: 5px"/>  
      												<a href="javascript:void(0);" onclick="changeCode()">看不清?换一张</a>  
										  	  					
									  			</td>
									  		</tr>
									  		<tr>
									  			<td></td>
									  			<td>
									  				<div class="register-allowfile">
											  	  	  	<input type="checkbox" onchange="ss();" name="checkboxallowfile"><span>我已阅读并同意</span>
											  	  	  	<a href="#" target="_blank">《产贸送用户注册协议》</a>
									  	  	  </div>
									  			</td>							  			
									  		</tr>
									  		<tr>
									  			<td></td>
									  			<td>
									  				 <div class="register-btndiv">
									  				 	<input class="register-step-nextbtn"  id="register-com-nextbtn1" type="submit" value="下一步"/>
									  				 		<!-- <span class="register-step-nextbtn" onclick="tostep2();" id="register-com-nextbtn1">下一步</span> -->
									  				 </div>		
									  			</td>
									  		</tr>
									  	</table>
								    </form>
						  	    </div>
						  	    <!--结束内容-->
							</div>
							<!--第二步-->
							<div class="re-com-step2 hide">
								    <!--顶部步骤-->
								    <div class="register-step">
						  	  	  <img src="${ctx}/image/img_flow_two.png" />
								    	<span class="register-flow1 color-B70707">设置账号</span>
								    	<span class="register-flow2 color-B70707">填写账号信息</span>
								    	<span class="register-flow3 color-A3A3A3">注册成功</span>
						  	    </div>
						  	    <!--开始主体内容-->
						  	    <div class="register-comstep2-mid" align="center">
						  	    	<form method='post' action='#' id="register-comstep2">
										  	<table class="register-step2-table">							  		
										  		<tr>
										  			<td width="20%" class="register-tb-title">设置登录密码</td>
										  			<td width="45%" class="text-left"></td>
										  			<td width="35%"></td>
										  		</tr>
										  		<tr>
										  			<td class="text-right"><span class="re-huiyaunspan">会员身份</span></td>
										  			<td class="text-left">
										  				<div class="re-huiyuandiv">
										  					<input type="hidden" name="uid">
										  					<input type="hidden" name="uname">
											  				<span class="fn-left"><input name="c-way" type="radio" checked="checked" value="1" />生产厂家</span>
											  				<span class="margin-l-20"><input name="c-way" type="radio" value="2" />经销商 </span>
											  				<span class="margin-l-20"><input name="c-way" type="radio" value="3" />物流商	</span>	
											  				<span class="margin-l-20"><input name="c-way" type="radio" value="4" />个人经营</span>
											  				<span><input name="c-way" type="radio" value="5" />其他</span>											  				
										  				</div>
										  			</td>
										  			<td></td>
										  		</tr>
										  		<tr>
										  			<td class="text-right">企业名称</td>
										  			<td class="text-left"><input type="text" name="companyname" class="register-input" ></td>
										  			<td class="text-left">
										  				<!--<span class='info companyname_put'>请输入企业名称</span>
														  <span class='info_error companyname_error'>企业名称不符合要求</span>
														  <span class='ok companyname_ok'></span>-->
										  			</td>
										  		</tr>
										  		<tr>
										  			<td class="text-right">企业所在地</td>
										  			<td class="text-left">
										  				<select class="register-adspro">
										  					<option value="">请选择省</option>
										  					<option value="四川省">四川省</option>
										  				</select>
										  				<span class="padding-l-3">-</span>
										  				<select class="register-adscity">
										  					<option value="">请选择城市</option>
										  					<option value="成都市">成都市</option>
										  				</select>
										  				<span>-</span>
										  				<select class="register-adsarea">
										  					<option value="">请选择区县</option>
										  					<option value="双流县">双流县</option>
										  				</select>								  	
										  			</td>
										  			<td></td>
										  		</tr>
										  		<tr>
										  			<td class="text-right"><span>*</span>详细地址</td>
										  			<td class="text-left"><input type="text" name="address" class="register-input" ></td>
										  			<td class="text-left">
										  				<!--<span class='info address_put'>请输入地址</span>
														  <span class='info_error address_error'>地址不符合要求</span>
														  <span class='ok address_ok'></span>-->
										  			</td>
										  		</tr>								  										  		
										  		<tr>
										  			<td class="text-right"><span>*</span>企业邮箱</td>
										  			<td class="text-left"><input type="text" name="email" class="register-input" ></td>
										  			<td class="text-left">
										  				<!--<span class='info address_put'>请输入邮箱地址</span>
														  <span class='info_error address_error'>地址不符合要求</span>
														  <span class='ok address_ok'></span>-->
										  			</td>
										  		</tr>
										  		<tr>
										  			<td class="register-tb-title">企业联系人</td>
										  			<td class="text-left"></td>
										  			<td></td>
										  		</tr>
										  		<tr>
										  			<td class="text-right">联系人姓名</td>
										  			<td class="text-left">
										  				<input type="text" name="realuser" class="register-contactname">
										  				<input type="radio" value="1" checked="checked" name="com-sex"/>先生
										  				<input type="radio" value="2" name="com-sex"/>女士
										  			</td>
										  			<td class="text-left">
										  				<!--<span class='info realuser_put'>请输入姓名</span>
														  <span class='info_error realuser_error'>姓名不符合要求</span>
														  <span class='ok realuser_ok'></span>-->
										  			</td>
										  		</tr>			
										  		<tr>
										  			<td class="text-right">手机号码</td>
										  			<td class="text-left">
										  				<!--<select class="register-num-select"><option>中国大陆  +86</option></select>-->
										  				<div class="dropdown drop margin-l-20">
													      <p>中国大陆   +86</p>
													     	<ul class="dropul">
													         	<li><a href="javascript:void(0)" rel="1">中国大陆   +86</a></li>
													      	</ul>
													    </div>&nbsp;-
										  				<input type="text" name="phone2" class="register-phone"  id="register-com-num">								  				
										  			</td>
										  			<td class="text-left">
										  				<!--<span class='info phone_put2'>请输入手机号码</span>
															<span class='info_error phone_error2'>手机号码格式不正确</span>
															<span class='ok phone_ok2'></span>-->
										  			</td>
										  		</tr>								  										  							  										  		
										  		<tr>
										  			<td></td>
										  			<td>
										  				<input class="register-step-nextbtn margin-t-45"  id="register-com-nextbtn2" type="submit" value="下一步"/>
										  			</td>
										  			<td></td>
										  		</tr>
										  	</table>
									    </form>
						  	    </div>	
						  	    <!--结束主体内容-->
						  	</div>
						  	<!--第三步-->
						  	<div class="re-com-step3 hide">
						  		  <!--顶部步骤--> 
								    <div class="register-step">
						  	  	  <img src="${ctx}/image/img_flow_three.png" />
								    	<span class="register-flow1 color-B70707">设置账号</span>
								    	<span class="register-flow2 color-B70707">填写账号信息</span>
								    	<span class="register-flow3 color-B70707">注册成功</span>
						  	    </div>
						  	    <!--开始主体内容-->
						  	    <div class="register-step3-showmes" align="center">
						  	    	<div class="register-imgsucceed">
									  	 	<p class="register-successinfo">
									  	 	  <span class="register-user" id="comp-register-user"></span><span class="register-sucinfo">恭喜你已经成功开通产贸送服务！</span>
									  	 	</p>
									  	 	<div class="register-step3-msg">
									  	 		<span>此企业账号可同时登录产贸送物流平台、产贸送公共应用平台</span>
									  	 	</div>
									  	</div> 	
								  	 	<div class="register-newbiebtn"><a href="${ctx}/register/newbieRoad" class="register-step-nextbtn">开始使用</a></div>
								    </div>
						  	    <!--结束主体内容-->
						  	</div>
						</div>
						<!--结束 企业用户 -->
						
						
						<!--开始 个人用户 -->
						<div class="tab-pane" id="tab-personal">
						    <!-- 第一步 -->
						    <div class="re-per-step1 show">
						    	  <!--顶部步骤-->
						    	  <div class="register-step">
								    	<img src="${ctx}/image/img_flow_one.png" />
								    	<span class="register-flow1 color-B70707">设置账号</span>
								    	<span class="register-flow2 color-A3A3A3">填写账号信息</span>
								    	<span class="register-flow3 color-A3A3A3">注册成功</span>
						  	    </div>
						  	    <!--开始主体内容-->
						  	    <div class="register-mid" align="center">				  	    	
						  	    	<form  id="checkphone" method='post' action='#'>
										  	<table class="register-step1-nextbtn-table">
										  		<tr>
										  			<td width="20%" class="text-right">手机号</td>
										  			<td width="47%" class="text-left">
										  				<!--<select class="register-areanum"><option>中国大陆   +86</option></select>-->
										  				<div class="dropdown drop margin-l-20">
													      <p>中国大陆   +86</p>
													     	<ul class="dropul">
													         	<li><a href="javascript:void(0)" rel="1">中国大陆   +86</a></li>
													      	</ul>
													    </div>
													    <span class="fn-left">&nbsp;-</span>
										  				<input type="text" name="phone" id="phone" placeholder="请输入手机号" class="register-num">								  																						
										  			</td>
										  			<td width="33%" class="text-left">
										  				<!--<span class='info phone_put'>请输入您的手机号。</span>
															<span class='info_error phone_error'>手机号码格式不正确！</span>
															<span class='ok phone_ok'></span>			-->
										  			</td>
										  		</tr>
										  		<tr>
										  			<td class="text-right">验证码</td>
										  			<td class="text-left">
										  				<input type="text" class="register-validate">
										  				<input type="button" id="register-send-btn" class="register-valdate-box" value="获取短信验证码" />					  	  	  			
										  			</td>
										  			<td></td>
										  		</tr>
										  		<tr>
										  			<td></td>
										  			<td>
										  				 <input class="register-step-nextbtn margin-t-56" id="register-per-nextbtn1" type="submit" value="下一步"/>
										  			</td>
										  			<td></td>
										  		</tr>
										  	</table>
									    </form>
									    <p class="register-prompt " align="center">温馨提示：若你拥有营业执照，为方便你发布信息以及未来升级，强烈建议你注册企业账户，<a href="${ctx}/register" class="text-underline">点此注册</a></p>
						  	    </div>						  	    
						  	    <!--结束主体内容-->
						    </div>	
						    <!-- 第二步 -->
						   <form action=""  id="checkpw" name="checkRegister" method="post"> 
						    <div class="re-per-step2 hide">
						    	<!--顶部步骤-->
						    	<div class="register-step">
								  	  <img src="${ctx}/image/img_flow_two.png" />
								    	<span class="register-flow1 color-B70707">设置账号</span>
								    	<span class="register-flow2 color-B70707">填写账号信息</span>
								    	<span class="register-flow3 color-A3A3A3">注册成功</span>
								</div>
								<!--开始主体内容-->
								<div class="register-step2-mid" align="center">
									<table class="register-perstep2-table">
								  		<tr>
								  			<td width="20%" class="text-right">会员名</td>
								  			<td width="47%" class="text-left"><input type="text" name="user" id="user" class="register-input" placeholder="设置会员名"></td>
								  			<td width="33%" class="text-left">
								  				<!--<span class='info user_put'>请输入1个字符以上的会员名</span>
													<span class='info_error user_error'></span>
													<span class='ok user_ok'></span>-->
												<span class="user_error"></span>	
								  			</td>
								  		</tr>
								  		<tr>
								  			<td class="text-right">密码</td>
								  			<td class="text-left"><input type="password" name="pass" id="password" class="register-input" placeholder="请设置你的登录密码"   id="register-per-pwd"></td>
								  			<td class="text-left">
									  		<!--	<span class ='info pass_put'>请输入密码</span>
												  <span class='safe'>安全等级：<strong class='s s1'></strong> <strong class='s s2'></strong>
													  <strong class='s s3'></strong> <strong class='word'></strong>
													</span>
													<span class='info_error pass_error'>请输入正确密码</span>
													<span class='ok pass_ok'></span>				-->
								  			</td>
								  		</tr>
								  		<tr>
								  			<td class="text-right">确认密码</td>
								  			<td class="text-left"><input type="password" name='confirm_pass' id="confirm_password" class="register-input" placeholder="请再次输入你的登录密码" id="register-per-pwd2"></td>
								  			<td class="text-left">
								  				<!--<span class='info confirm_put'>请再次输入密码</span>
													<span class='info_error confirm_error'>两次密码不一致</span>
													<span class='ok confirm_ok'></span>-->
								  			</td>
								  		</tr>						  									  										  		
								  		<tr>
								  			<td></td>
								  			<td>
								  			<!-- 	<span class="register-step-nextbtn margin-t-45" id="register-per-nextbtn2" onclick="submit()">下一步</span> -->
								  					<input  class="register-step-nextbtn margin-t-45" id="register-per-nextbtn2"  type="submit" value="下一步"/>
								  				
								  			</td>
								  			<td></td>
								  		</tr>
								  	</table>
								</div>	
								<!--结束主体内容-->
						    </div>
						  </form><!--第二步结束标签  --> 
						    <!-- 第三步 -->
						    <form action="" id="checkInfo"  method="post">
						    <div class="re-per-step3 hide">
						    	<!--顶部步骤-->
						  		<div class="register-step">
								  	  <img src="${ctx}/image/img_flow_three.png" />
								    	<span class="register-flow1 color-B70707">设置账号</span>
								    	<span class="register-flow2 color-B70707">填写账号信息</span>
								    	<span class="register-flow3 color-B70707">注册成功</span>
								</div>
								<!--开始主体内容-->
								  <div class="register-per-step3mid" align="center">
							  	 	<p class="register-successinfo">
									  	 	  <span class="register-user"></span><span class="register-sucinfo">恭喜你已经成功开通产贸送服务！</span>
									  	 	</p>
									  	 	<div class="register-step3-msg">
									  	 		<span>此企业账号可同时登录产贸送物流平台、产贸送公共应用平台</span>
									  	 	</div>
							    </div>
							    <p class="register-step3-p">
							  	  为了让你获得更精确的服务和商业机会，我们建议你立即完善一下信息
							    </p>
							    <div class="register-per-step3-mid" align="center">
								  	<table class="register-step3-table">
								  		<tr>
								  			<td width="20%" class="register-tb-title">基本信息</td>
								  			<td width="47%" class="text-left"></td>
								  			<td width="33%"></td>
								  		</tr>		
								  		<tr>
								  			<td class="text-right">你的姓名</td>
								  			<td class="text-left">
								  				<input type="text" class="register-realname" id="personName" name="personName">
								  				<div class="margin-l-10 fn-left">
									  				<input name="sex" type="radio"  value="男" />先生
									  				<input name="sex" type="radio"  value="女" />女士
								  				</div>
								  			</td>
								  			<td></td>
								  		</tr>
								  		<tr>
								  			<td class="text-right">手机号码</td>
								  			<td class="text-left">
								  				<span class="register-label" id="personphone"></span>
								  			</td>
								  			<td></td>
								  		</tr>
								  		<tr>
								  			<td class="text-right">固定电话</td>
								  			<td class="text-left">
								  				<input type="text" id="tel1" class="register-tell1" value="+86"/>&nbsp;-
								  				<input type="text" id="tel2" class="register-tell2" placeholder="区号">&nbsp;-
								  				<input type="text" id="tel3" class="register-tell3" placeholder="电话号码">			
								  			</td>
								  			<td></td>
								  		</tr>
								  		<tr>
								  			<td class="text-right">证件类型</td>
								  			<td class="text-left">
								  				<div class="dropdown drop margin-l-20" id="cert_type" >
											      	<p id="per_card">身份证</p>
											     	  <ul class="dropul">
											         	<li><a href="javascript:void(0)" rel="1">身份证</a></li>
											         	<li><a href="javascript:void(0)" rel="2">护照</a></li>
											         	
											      	  </ul>
											    </div>											    
								  			</td>
								  			<td></td>
								  		</tr>
								  		<tr>
								  			<td class="text-right">证件号码</td>
								  			<td class="text-left">
								  				<input type="text" name="idCard" id="idCard" class="register-input" placeholder="请输入你的证件号码"> 				
								  			</td>
								  			<td></td>
								  		</tr>	
								  		<tr>
								  			<td class="text-right">邮箱地址</td>
								  			<td class="text-left">
								  				<input type="text" name="email" id="email" class="register-input" placeholder="请输入邮箱地址"> 				
								  			</td>
								  			<td></td>
								  		</tr>						  		
								  		<tr>
								  			<td></td>
								  			<td>
								  				<input class="register-step-nextbtn margin-t-45" type="submit" value="保存"/>
								  				<div class="register-step3-link-div">
											  		<a href="#" target="_blank">跳过</a>
											  	</div>	
								  			</td>
								  			<td>							  				
								  			</td>
								  		</tr>
								  	</table>
								</div>
								<!--结束主体内容-->
							</div>	
							</form>	<!-- 第三步结束form标签 -->						  
						</div>
						<!--结束 个人用户 -->
					</div>	 
        </div>
        <!--底部-->
        <div class="login-footer">          	
        	<div class="row">
        		<div class="col-lg-12">
		        	<ul class="register-footer-ul">
		        		<li class="login-right-line"><a href="javascript:;">关于产贸送</a></li>
		        		<li class="login-right-line"><a href="javascript:;">法律声明</a></li>
		        		<li class="login-right-line"><a href="javascript:;">加盟入驻</a></li>
		        		<li class="padding-l-10"><a href="javascript:;">帮助中心</a></li>
		        	</ul>
	        	</div>
        	</div>
        	<div class="row">
        		<div class="col-lg-12">
        	       <p>如有任何问题请拨打热线电话<span class="margin-l-30">24小时热线电话:400-800-2015-0586</span></p>
        	    </div>
        	</div>
        	<div class="row">
        		<div class="col-lg-12">
        	    <p>Copyright &copy; 2015 cmswl Inc.保留所有权。<span class="margin-l-30">新公安网备10000000586新ICP备</span></p>
        	  </div>
        	</div>       	
    	</div>	      	    
  
	    <script src="${ctx}/js/jquery.1.11.3.min.js"></script>
	    <script src="${ctx}/js/dropdown.js" type="text/javascript"></script>
	    <script src="${ctx}/js/bootstrap.min.js"></script>

	    <script type="text/javascript" src="${ctx}/js/register.js"></script>
	    <script src="${ctx}/js/validate/jquery.validate.js"></script>
	    <script src="${ctx}/js/validate/messages_cn.js"></script>
	    <script src="${ctx}/js/IdCard.js"></script>
	    <script src="${ctx}/js/sysUserTradeAccount.js"></script>
	    
	    
	    <!--<script type="text/javascript" src="js/Myjs.js"></script>-->

	    <script src="${ctx}/js/validate/jquery.validate.js"></script>
	    <script src="${ctx}/js/validate/messages_cn.js"></script>
	    <script type="text/javascript" src="${ctx}/js/com-register.js"></script>

  </body>
</html>