<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>账号信息-基本信息</title>
<link href="${ctx}/css/account-mana.css" rel="stylesheet"/>
<link href="${ctx}/css/account-mana2.css" rel="stylesheet"/>
<script src="${ctx}/js/jquery.1.11.3.min.js"></script>
<script src="${ctx}/js/accountCom/jquery.validate.js"></script>
<script src="${ctx}/js/accountCom/messages_zh.min.js"></script>
<script src="${ctx}/js/account-mana.js" ></script>
<script src="${ctx}/js/dropdown.js"></script>
<script src="${ctx}/js/sysUserSingelInfo/perAddress.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<form id="comAddForm">
	<div class="acc-info"> 
		<!--已保存的地址-->
		<div class="acc-saveadsdiv">
			<div class="acc-ads-title">
		  	 	<span class="acc-adst-icon"></span>
		  	 	<span class="acc-adst-word">已保存的地址</span>
		  	</div>
		  	<table class="acc-saveadstb">
		  		<thead>
		  			<tr>
		  				<td>收货人</td>
		  				<td>所在地区</td>
		  				<td>街道地址</td>
		  				<td>邮编</td>
		  				<td>电话/手机</td>
		  				<td>操作 </td>
		  			</tr>
		  		</thead>
		  		<tbody class="acc-ads-tbody">
		  		<c:forEach items="${adsLists}" var="ads">
		  			<tr>
		  				<td>${ads.username}</td>
		  				<td>${ads.addressProvince}-${ads.addressCity}-${ads.addressCounty}</td>
		  				<td>${ads.addressDetail}</td>
		  				<td>${ads.postCode}</td>
		  				<td>${ads.tel}||${ads.phone}</td>
		  				<td><input type="button" id="delBtn" onclick="deleteAds('/user-center-web/sysUserAddressPer/deleteAds?id=${ads.id}')" value="删除" class="acc-adsdel"></td>
		  			</tr>
		  		</c:forEach>
		  		</tbody>
		  	</table>
		</div>
		<!--添加收货人地址-->
		<div class="acc-addadsdiv">
			<div class="acc-ads-title">
		  	 	<span class="acc-adst-icon"></span>
		  	 	<span class="acc-adst-word">添加收货地址</span>
		  	</div>
		  	<form action="" id="comeAdsForm" method="post">
			  	<table class="acc-comusertb">
			  		<tr>
			  			<td width="12%" align="right">收货人姓名：</td>
			  			<td width="25%">
			  				<input type="text" name="username" class="acc-adsinput user_name"/>		  				
			  			</td>
			  			<td width="12%"></td>
			  			<td width="51%"></td>
			  		</tr>
			  		<tr>
			  			<td align="right">所在地区：</td>
			  			<td><!--<select class="acc-adsinput"><option></option></select>-->
			  				<div class="dropdown acccom-bumen">
						      	<p class="address" ></p>
						     	<ul class="dropul_bumen">
						         	<li><a href="javascript:void(0)" rel="1">北京</a></li>
						         	<li><a href="javascript:void(0)" rel="2">成都</a></li>
						      	</ul>
						    </div>
			  			</td>
			  			<td></td>
			  			<td></td>
			  		</tr>
			  		<tr>
			  			<td align="right">邮编：</td>
			  			<td>
			  				<input type="text"  name="postCode" class="acc-adsinput post_code"/>		  				
			  			</td>
			  			<td align="right">街道地址：</td>
			  			<td>
			  				<textarea class="accom-jyfw address_detail" name="addressDetail" ></textarea>
			  			</td>
			  		</tr>
			  		<tr>		  			
			  			<td align="right">固定电话：</td>
			  			<td>
			  				<input type="text" placeholder="+86" value="+86" name="tel1" class="acc-gdtel1"/>
			  				<input type="text" placeholder="区号" name="telArea" class="acc-gdtel2"/>
			  				<input type="text" placeholder="电话号码" name="telNumber" class="acc-gdtel3"/>
			  			</td>
			  			<td align="right">手机号码：</td>
			  			<td><input type="text" class="acc-adsinput phone" name="phone" onkeyup="value=value.replace(/^1([38]\d|4[57]|5[0-35-9]|7[06-8])(\-\d{4}){2}$/,'')"/>
			  			</td>
			  		</tr>
			  		<tr>
			  			<td align="right">设为默认地址：</td>
			  			<td><input type="radio" name="isDefault" value="1" />设为默认地址</td>
			  			<td></td>
			  			<td></td>
			  		</tr>
			  	</table>
		  	</form>
		</div>
		<input type="submit" id="addSbt" value="保存" class="accinfo-savebtn"/>
	</div>
 </form>	
</body>
</html>