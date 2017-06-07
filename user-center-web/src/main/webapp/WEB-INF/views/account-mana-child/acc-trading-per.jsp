<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>账户管理-交易账户管理</title>
<link href="${ctx}/css/account-mana.css" rel="stylesheet"/>	
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>
<!--交易账户管理首页-->
<div class="acc-trading show" id="acc-indexdiv">
	<div class="acc-tradtitle">资金账户</div>
	<div class="acc-trad-con1">
		<div class="acc-tra-money">
			<p class="acc-tram-title"><img src="${ctx}/image/acc-trad-money-icon.png" />平台账户余额</p>
			<div align="center" class="acc-tram-money"><span>0.00</span>&yen;</div>
			<ul class="acc-tram-ul">
				<li><a href="#">充值</a></li>
				<li><a href="#">提现</a></li>
				<li><a href="${ctx}/sysUserTradeAccount/trade_query" class="acc-moneydetail">详情</a></li>
			</ul>
		</div>
		<div class="acc-tra-addBankcard">
			<span class="glyphicon glyphicon-plus acc-tra-addicon"></span>
			<p align="center">添加银行卡/支付宝</p>
		</div>
	</div>
	<div class="acc-tradtitle">我的保证金</div>
	<div class="acc-trad-con2">
		<div class="acc-tradc-div">保证金：<span>2630.00</span>&yen;<a href="javascript:;" class="acc-trad-chongzhi">充值</a></div>
		<table class="acc-tradc-table">
			<thead class="acc-tradct-thead">
				<tr>
					<td width="25%" class="padding-l-40">时间</td>
					<td width="30%">保证金交易记录</td>
					<td width="35%">金额</td>
					<td width="10%">操作</td>
				</tr>
			</thead>
			<tbody  class="acc-tradct-tbody">
				<tr>
					<td class="padding-l-40">2016/01/05</td>
					<td>产品违规</td>
					<td>-562.30</td>
					<td><a href="javascript:;">详情</a></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!--交易账户管理--余额详情-->

<!--交易账户管理--添加银联账户-->
<div class="acc-trading hide" id="acc-addcarddiv">
	<form action ="${ctx}/sysUserTradeAccount/trade_save" id="sysUserTradeAccountForm" method="post">
	<div class="acc-trad-carddiv">
		<span class="acc-trad-msg">请绑定持卡人本人的银行卡</span>
		<table class="acc-trad-cardtable">
			<tr>
				<td width="30%" align="right"><span class="must">*</span>持卡人</td>
				<td width="36%"><span class="margin-l-20">${loginUser.realname}</span></td>
				<td width="34%"></td>
			</tr>
			<tr>
				<td align="right"><span>*</span>身份证号</td>
				<td><input type="text" value="" name="idCard" class="acc-trad-input"/></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><span>*</span>银行卡卡号</td>
				<td><input type="text" value="" id="bankCard" name="bankCard" class="acc-trad-input"/></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><span>*</span>卡类型</td>
				<td><select class="acc-trad-input" name="bankCardType">
					<option id="bank" value="">请选择</option>
				</select></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><span>*</span>手机号</td>
				<td><input type="text" value="" class="acc-trad-input" name="phone" placeholder="请输入银行预留手机号"/></td>
				<td></td>
			</tr>
			<tr>
				<td align="right"><span>*</span>验证码</td>
				<td>
					<input type="text" value="" name="safeCode" class="acc-trad-validateinput" placeholder="请输入验证码">
				    <input type="button" class="acc-validate" value="获取短信验证码" />	
				</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" class="acc-trad-okbtn" value="同意并确定"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:;" class="acc-trad-link">《平台快捷支付协议》</a></td>
				<td></td>
			</tr>
		</table>
	</div>
	</form>
</div>
<script src="${ctx}/js/jquery.1.11.3.min.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/account-mana.js"></script>
<script type="text/javascript" src="${ctx}/js/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${ctx}/js/validate/messages_cn.js"></script>
<script type="text/javascript" src="${ctx}/js/sysUserSingelInfo/IdCard.js"></script>
<!-- 使用日历控件 -->
<script type="text/javascript" src="${ctx}/js/lhgcalender/lhgcore.min.js"></script>
<script type="text/javascript" src="${ctx}/js/lhgcalender/lhgcalendar.min.js"></script>

<script type="text/javascript" src="${ctx}/js/sysUserSingelInfo/sysUserTradeAccount.js"></script>


</html>



