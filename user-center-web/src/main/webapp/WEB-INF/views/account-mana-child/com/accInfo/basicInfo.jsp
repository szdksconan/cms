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
<script src="${path}/js/accountCom/jquery.validate.js"></script>
<script src="${path}/js/accountCom/messages_zh.min.js"></script>
<script src="${path}/js/dropdown.js"></script>
<script src="${path}/js/accountCom/basicInfo.js"></script>
<script type="text/javascript">
$(function(){
	//下拉框值回显
    var certType="${sysUser.certType}";
    var contactPersonPosition="${sysUser.contactPersonPosition}";
    var contactPersonDepart="${sysUser.contactPersonDepart}";
    var contactPersonCertType="${sysUser.contactPersonCertType}";
    $("#certType").html(certType);
    $("#contactPersonPosition").html(contactPersonPosition);
    $("#contactPersonDepart").html(contactPersonDepart);
    $("#contactPersonCertType").html(contactPersonCertType);
    var phone="${sysUser.contactPersonPhone}"
    var contactPersonPhone = phone.substr(-11,11);
    $("input[name='contactPersonPhone']").val(contactPersonPhone);
    var contactPersonTel="${sysUser.contactPersonTel}";
    var contactTel=contactPersonTel.split("-")[0];
    $("input[name='contactTel']").val("+"+contactTel);
    var contactTelArea=contactPersonTel.split("-")[1];
    $("input[name='contactTelArea']").val(contactTelArea);
    var contactTelNumber=contactPersonTel.split("-")[2];
    $("input[name='contactTelNumber']").val(contactTelNumber);
});
</script>
</head>
<body>
  <form id="basicInfoForm" >
	<input type="hidden" name="uid" value="${sysUser.uid}" />
	<div  class="acc-info"> 
		<!--基本信息-->
		<div class="acc-basinfodiv">
			<div class="acc-ads-title">
		  	 	<span class="acc-adst-icon"></span>
		  	 	<span class="acc-adst-word" >基本信息</span>
		  	</div>
		  	<table class="acc-basinfotb">
		  		<tr>
		  			<td width="10%" align="right"><span class="must">*</span>用户名：</td>
		  			<td width="40%"><input type="text" name="uname" disabled="disabled"  value="${sysUser.uname}"/></td>
		  			<td width="10%" align="right"><span class="must">*</span>真实姓名：</td>
		  			<td width="40%"><input type="text" name="realname" disabled="disabled" value="${sysUser.realname}" /></td>
		  		</tr>
		  		<tr>
		  			<td align="right"><span class="must">*</span>证件类型：</td>
		  			<td>
		  			    <div class="dropdown drop" >
					      	<p id="certType"></p>
					     	<ul class="dropul" >
					         	<li><a href="javascript:void(0)" rel="1" >身份证</a></li>
					         	<li><a href="javascript:void(0)" rel="2" >军人证</a></li>
					      	</ul>
					    </div>
		  			</td>
		  			<td align="right"><span class="must">*</span>证件号：</td>
		  			<td><input type="text" name="certNum" disabled="disabled" value="${sysUser.certNum}"/></td>
		  		</tr>
		  		<tr>
		  			<td align="right"><span class="must">*</span>手机号：</td>
		  			<td><input type="text" name="phone" value="${sysUser.phone}"/></td>
		  			<td align="right">固定电话：</td>
		  			<td><input type="text" name="tel" value="${sysUser.tel}" /></td>
		  		</tr>
		  		<tr>
		  			<td align="right">邮箱：</td>
		  			<td><input type="text" name="email" value="${sysUser.email}"/></td>
		  			<td></td>
		  			<td></td>
		  		</tr>
		  	</table>
		</div>
		<!--企业联系人-->
		<div class="acc-comuserdiv">
			<div class="acc-ads-title">
		  	 	<span class="acc-adst-icon"></span>
		  	 	<span class="acc-adst-word">企业联系人</span>
		  	</div>
		  	<table class="acc-comusertb">
		  		<tr>
		  			<td width="10%" align="right">姓名：</td>
		  			<td width="40%">
		  				<input type="text" class="acccom-name" name="contactPersonName" value="${sysUser.contactPersonName}" />
		  				<input type="radio" name="contactPersonSex" checked="checked"  value="1" />先生
		  				<input type="radio" name="contactPersonSex" <c:if test="${sysUser.contactPersonSex==2}">checked="checked"</c:if> value="2" />女士
		  			</td>
		  			<td width="10%" align="right">所属部门：</td>
		  			<td width="40%">
		  			<div class="dropdown acccom-bumen">
					      	<p id="contactPersonDepart"></p>
					     	<ul class="dropul_bumen">
					         	<li><a href="javascript:void(0)" rel="1">人事部</a></li>
					         	<li><a href="javascript:void(0)" rel="2">技术部</a></li>
					      	</ul>
					    </div>
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="right">职位：</td>
		  			<td>
		  			<div class="dropdown acc-zhiwei">
					      	<p id="contactPersonPosition"></p>
					     	<ul class="dropul_zhiwei">
					         	<li><a href="javascript:void(0)" rel="1">经理</a></li>
					         	<li><a href="javascript:void(0)" rel="2">总监</a></li>
					      	</ul>
					    </div>
		  			</td>
		  			<td align="right">手机号：</td>
		  			<td>
		  				<!--<select class="acc-numselect"><option>中国大陆 +86</option></select>-->
		  				<div class="dropdown acc-numselect">
					      	<p id="contactPersonPhoneArea">中国大陆 +86</p>
					     	<ul class="dropul_numselect">
					         	<li><a href="javascript:void(0)" rel="1">中国大陆 +86</a></li>
					         	<li><a href="javascript:void(0)" rel="2">中国台湾  +886</a></li>
					      	</ul>
					    </div>
		  				<input type="text" class="acc-numinput" name="contactPersonPhone" value=""/>
		  			</td>
		  		</tr>
		  		<tr>		  			
		  			<td align="right">固定电话：</td>
		  			<td>
		  				<input type="text" name="contactTel" placeholder="+86" value="+86" class="acc-gdtel1"/>
		  				<input type="text" name="contactTelArea" placeholder="区号" class="acc-gdtel2"/>
		  				<input type="text" name="contactTelNumber" placeholder="电话号码" class="acc-gdtel3"/>
		  			</td>
		  			<td align="right">证件类型：</td>
		  			<td>
		  				<div class="dropdown drop">
					      	<p id="contactPersonCertType"></p>
					     	<ul class="dropul">
					         	<li><a href="javascript:void(0)" rel="1">身份证</a></li>
					      	</ul>
					    </div>		  				
		  			</td>
		  		</tr>
		  		<tr>
		  			<td align="right">证件号码：</td>
		  			<td><input type="text" class="acc-zjnum" name="contactPersonCertNum" value="${sysUser.contactPersonCertNum}"/></td>
		  			<td></td>
		  			<td></td>
		  		</tr>
		  	</table>
		</div>
		<input type="submit" id="basicInfoSub" value="保存" class="accinfo-savebtn"/>
	</div>
  </form>	
</body>
</html>
