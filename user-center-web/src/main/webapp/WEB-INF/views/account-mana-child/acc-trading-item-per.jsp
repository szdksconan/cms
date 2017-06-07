<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>交易账户管理--余额详情</title>
<link href="${ctx}/css/account-mana.css" rel="stylesheet"/>	
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->

</head>
<!--交易账户管理--余额详情-->
<div class="acc-trading " id="acc-moneydiv">
	<div class="acc-tradtitle">资产明细
	  <ul class="acc-trat-ul">
	  	<li><a href="#">收支明细证明</a></li>
	  	<li><a href="#">下查询结果</a></li>
	  </ul>
	</div>
	<div class="acc-tram-detail">
		<form action="${ctx}/sysUserTradeAccount/trade_query" id="searchForm" method="post">
			<div class="acc-tratime-div">
				<span>时间：</span>
				<span><input type="text" name="beginTime" value="${query.beginTime}" id="inp1" class="acc-tradtime-input"></span>
				<span>-</span>
				<span><input type="text" name="endTime" value="${query.endTime}" id="inp12"  class="acc-tradtime-input"></span>
			</div>
		<ul class="acc-tratime-ul">
			<li id="queryId">查询</li>
			<li id="lately">最近</li>
			<li id="week">1周</li>
			<li id="latelymonth">1个月</li>
		</form>
			<li id="year">1年&nbsp;|&nbsp;<select class="acc-trad-select" value="${query.month}">
				<option value="-1">按月份选择</option>
				<option value="1">1月</option>
				<option value="2">2月</option>
				<option value="3">3月</option>
				<option value="4">4月</option>
				<option value="5">5月</option>
				<option value="6">6月</option>
				<option value="7">7月</option>
				<option value="8">8月</option>
				<option value="9">9月</option>
				<option value="10">10月</option>
				<option value="11">11月</option>
				<option value="12">12月</option>
			</select></li>
		</ul>
		<select>
			<option>高级筛选</option>
		</select>
		<div class="acc-trad-income" align="center">收入：${income}</div>
		<div class="acc-trad-goout" align="center">支出：${expend}</div>		
	</div>
	<table class="acc-trad-table">
		<thead class="acc-trad-thead">
			<tr>
				<td class="padding-l-10">流水号</td>
				<td>日期</td>
				<td>名称|备注</td>
				<td>收入(元)</td>
				<td>支出(元)</td>
				<td>余额</td>
				<td>支付方式</td>
			</tr>
		</thead>
		
		<tbody class="acc-trad-tbody">
			<c:forEach items="${tradeinfos}" var ="info">
			<tr class="acc-tradborder-b">
				<td class="padding-l-10">${info.trade_id}</td>
				<td>${info.create_time}</td>
				<td>${info.type}</td>
				<td>${info.income}</td>
				<td>${info.expenditure}</td>
				<td>${info.count}</td>
				<td>${info.pay_way}</td>
			</tr>
			</c:forEach>
		</tbody>
		
		
	</table>
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
<script type="text/javascript">
	$(function(){
		var lately = ${query.lately}
		console.debug(lately);
		if(!lately){
			return;
		}
		if(lately=="1"){
			//表示选择了最近
			$("#lately").addClass("acc-trad-current").siblings().removeClass(
			"acc-trad-current");
		}
		else if(lately=="2"){
			//表示选择了最近
			$("#week").addClass("acc-trad-current").siblings().removeClass(
			"acc-trad-current");
		}
		else if(lately=="3"){
			//表示选择了最近
			$("#latelymonth").addClass("acc-trad-current").siblings().removeClass(
			"acc-trad-current");
		}
		else{
			var temp = parseInt(lately)-3;
			$("option[value="+temp+"]").attr("selected",true);
			$("#year").addClass("acc-trad-current").siblings().removeClass(
			"acc-trad-current");
		}
	});
</script>
</html>