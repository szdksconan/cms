<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>账户管理-账户安全</title>
<link href="${path}/css/account-mana.css" rel="stylesheet"/>	
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
</head>
<div class="acc-safety">
	<div class="acc-safety-title">基础信息</div>
	<div class="acc-safety-msg">
		<table>
			<tr>
				<td class="color-999999">
					<p class="margin-t-5 margin-l-10">
						<img src="${path}/image/acc-msg-icon.png" class="fn-left"/><span class="font-bold margin-l-5">温馨提示：</span>
					</p>
					<p class="acc-null"></p>
					<p class="acc-null"></p>
				</td>
				<td class="color-999999">
					<p class="margin-t-10 margin-l-5">1.手机号码用于账户安全验证，不展示在您的联系方式中;</p>
					<p class="margin-l-5">2.1个手机号码只能在1个账户下开启登录功能用于登录，无法在多个账户下同时开启登录;</p>
					<p class="margin-l-5">3.绑定手机、邮箱，可享受通过绑定手机或邮箱找回密码等服务。</p>
				</td>
			</tr>
		</table>		
	</div>
	<div class="acc-safety-basicinfo">
		<dl>
			<dd>会员名：<span>安玲安玲83978939</span></dd>
			<dd>
				手机号码：
				<span>185****0129</span>
				<a href="javascript:;">修改</a>
				<a href="javascript:;">开启手机登录</a>
				<a href="javascript:;">取消手机绑定</a>
			</dd>
			<dd>
				登录邮箱：
				<span>592***@qq.com</span>
				<a href="javascript:;">修改邮箱</a>
			</dd>
		</dl>
	</div>
    <div class="acc-safety-title">安全产品</div>
    <table class="acc-safety-info">
    	<tr>
    		<td width="15%">
    			<p class="padding-l-10 font-bold">身份认证</p>
    			<p class="acc-null-p"></p>
    		</td>
    		<td width="60%"><p>身份认证是指通过工商信息，或银行卡信息和身份证信息的核实，来证明会员身份的真实性和类型。包含企业认证和个人实名认证。</p></td>
    		<td width="25%">
    			<p>
	    			<span class="color-999999">未进行任何认证</span>
	    			<a href="javascript:;" class="margin-l-20 color-999999">查看详情</a>
    			</p>
    			<p class="acc-null-p"></p>
    		</td>
    	</tr>
    	<tr>
    		<td><p class="padding-l-10 font-bold">登录密码</p></td>
    		<td><p>修改更高级别的密码能提高账号的安全性</p></td>
    		<td><p><a href="javascript:;" class="margin-l-125 color-999999">修改</a></p></td>
    	</tr>
    	<tr>
    		<td>
    			<p class="padding-l-10 font-bold">密保问题管理</p>
    			<p class="acc-null-p"></p>
    		</td>
    		<td>
    			<p>新一代密码保护问题由3个问题以及对应的答案组成，专门用于您忘记密码时取回密码。与之前的密码保护问题相比，采用最新的问题验证，更加安全。</p>
    		</td>
    		<td>
    			<p><a href="javascript:;" class="margin-l-125 color-999999">管理</a></p>
    			<p class="acc-null-p"></p>
    		</td>
    	</tr>
    </table>
 
</div>
<script src="${path}/js/jquery.1.11.3.min.js"></script>
<script src="${path}/js/bootstrap.min.js"></script>
<script src="${path}/js/account-mana.js"></script>
</html>