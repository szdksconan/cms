<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>账号信息-基本信息</title>
<link href="${path}/css/account-mana.css" rel="stylesheet"/>
<link href="${path}/css/account-mana2.css" rel="stylesheet"/>
<script src="${path}/js/jquery.1.11.3.min.js"></script>
<script src="${path}/js/accountCom/ajaxfileupload.js"></script>
<script src="${path}/js/accountCom/jquery.validate.js"></script>
<script src="${path}/js/accountCom/messages_zh.min.js"></script>
<script src="${path}/js/accountCom/companyInfo.js"></script>
<script src="${path}/js/dropdown.js"></script>
<script type="text/javascript">
$(function(){
	var industryType = "${enterpriseInfo.industryType}";
	$("#industryType").html(industryType);
	var companyLogo="${enterpriseInfo.companyLogo}";
	if(companyLogo!=null&&companyLogo!=""){
	 $("#headPortrait").attr("src",companyLogo);
	}
});

</script>
</head>
<body>
	<form id="companyInfoForm">
   <input type="hidden" name="eid" value="${enterpriseInfo.eid}" />
    <input type="hidden" name="uid" value="${enterpriseInfo.uid}" />
	<div class="acc-info"> 
		<!--企业信息-->
		<div class="acc-cominfodiv">
			<div class="acc-ads-title">
		  	 	<span class="acc-adst-icon"></span>
		  	 	<span class="acc-adst-word">企业信息</span>
		  	</div>
		  	<table class="acc-basinfotb">
		  		<tr>
		  			<td width="12%" align="right"><span class="must">*</span>企业名称：</td>
		  			<td width="40%"><input type="text" name="companyName" value="${enterpriseInfo.companyName}"/></td>
		  			<td width="10%"></td>
		  			<td width="38%"></td>
		  		</tr>
		  		<tr>
		  			<td align="right"><div class="acccomlogo"><span class="must">*</span>企业标志：</div></td>
		  			<td>
		  			  <div class="acc-uplogo">
		  				<img id="headPortrait" src="${path}/image/normal_img.png" width="68px" height="69px" class="fn-left">
		  				<span class="acccom-upbtn">上传</span>
		  				<input type="file"  id="companyLogo" class="acccom-upbtninput" onchange="return checkData()" name="uploadImage"/>
		  			  </div>
		  				<div class="acc-uplogomsg">
		  					<span class="accom-des">请使用真实标志，展示风格JPG,JPEG,GIF,PNG风格,支持2M以内的图片</span>
		  				</div>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="right">行业分类：</td>
		  			<td>
		  				<div class="dropdown acccom-bumen">
					      	<p id="industryType"></p>
					     	<ul class="dropul_bumen">
					         	<li><a href="javascript:void(0)" rel="1">电器</a></li>
					         	<li><a href="javascript:void(0)" rel="2">服装</a></li>
					      	</ul>
					    </div>
		  			</td>
		  			<td align="right">我的产品：</td>
		  			<td><input type="text" name="product" value="${enterpriseInfo.product}"/></td>
		  		</tr>
		  		<tr>
		  			<td align="right">经营范围：</td>
		  			<td><textarea class="accom-jyfw" name="businessScope">${enterpriseInfo.businessScope}</textarea></td>
		  			<td></td>
		  			<td></td>
		  		</tr>
		  		<tr>
		  			<td align="right">注册资金：</td>
		  			<td><input type="text" name="registerCapital" value="${enterpriseInfo.registerCapital}" /></td>
		  			<td align="right">注册日期：</td>
		  			<td>
		  				<div class="dropdown acccom-bumen">
					      	<p name="registerDate" value="${enterpriseInfo.registerDate}"></p>
					     	<ul class="dropul_bumen">
					         	<li><a href="javascript:void(0)" rel="1">2015-01-01</a></li>
					         	<li><a href="javascript:void(0)" rel="2">2015-02-27</a></li>
					      	</ul>
					    </div>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="right">会员身份：</td>
		  			<td>
		  				<span><input type="radio" name="memberType"   checked="checked" value="1"/>生产厂家</span>
		  				<span class="margin-l-5"><input type="radio" name="memberType" <c:if test="${enterpriseInfo.memberType==2}">checked="checked"</c:if>  value="2"/>经销商</span>
		  				<span class="margin-l-5"><input type="radio" name="memberType" <c:if test="${enterpriseInfo.memberType==3}">checked="checked"</c:if> value="3"/>物流商</span>
		  				<span class="margin-l-5"><input type="radio" name="memberType" <c:if test="${enterpriseInfo.memberType==4}">checked="checked"</c:if> value="4"/>个人经营</span>
		  				<span class="margin-l-5"><input type="radio" name="memberType" <c:if test="${enterpriseInfo.memberType==5}">checked="checked"</c:if> value="5"/>其他</span>
		  			</td>
		  			<td></td>
		  			<td></td>
		  		</tr>
		  	</table>
		  	<p class="acccom-dgfw">
		  		<span>是否提供代加工定制服务：</span>
		  		<span><input type="radio" name="isOem" value="1" <c:if test="${enterpriseInfo.isOem==1}">checked="checked"</c:if>/>是，提供</span>
		  	    <span class="margin-l-10"><input type="radio" name="isOem" value="2" checked="checked" >不提供</span>
		  	</p>
		</div>
		<input type="submit" id="comInfoSbt" value="保存" class="accinfo-savebtn"/>
	</div>
  </form>
</body>
</html>
