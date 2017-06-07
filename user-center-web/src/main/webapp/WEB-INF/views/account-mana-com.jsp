<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>企业账户管理</title>
<link href="${path}/css/account-mana.css" rel="stylesheet"/>
<link href="${path}/css/account-mana2.css" rel="stylesheet"/>
<script src="${path}/js/jquery.1.11.3.min.js"></script>
<script src="${path}/js/bootstrap.min.js"></script>
<script src="${path}/js/account-mana.js"></script>
<script src="${path}/js/dropdown.js"></script>
<script type="text/javascript">
//判断当前页面对象是不是顶级对象
	if(window!=window.top){
	     top.location.href=window.location.href;
	}
</script>
<!--[if lt IE 9]>
<script src="js/html5shiv.js"></script>
<script src="js/respond.min.js"></script>
<![endif]-->
</head>
<body>
	<div class="acc-main">
		<!--左侧导航栏-->
		<div class="acc-menu">
			<div class="acc-logo" align="center">
				<a href="../index.html" target="_self"><img src="${path}/image/accmana_logo.png"/></a>
				<span>账户管理</span>
			</div>
			<div class="acc-per-info" align="center">
				<div class="acc-photo">标志</div>
				<span>成都NIK股份有限公司</span>
				<div class="acc-icon">
					<img src="${path}/image/member.png" class="acc_imgmember"/>
					<img src="${path}/image/approve.png" class="acc_imgapprove"/>
					<img src="${path}/image/qul_ass.png" class="acc_imgqulass"/>
					<img src="${path}/image/credit.png" class="acc_imgcredit" />
				</div>
				<div class="acc-member-level" align="center">
				    <div>信用等级:</div>
				    <img src="${path}/image/member-level-icon.png" />
				    <img src="${path}/image/member-level-icon.png" />
				    <img src="${path}/image/member-level-icon.png" />
				</div>			
			</div>
			<div class="sidebar-menu">
			    <a href="#accinfoMeun" class="nav-header menu-first collapsed" data-toggle="collapse"><i class="icon-user"></i><span>账号信息</span><i class="arrow-r"></i></a>
				    <ul id="accinfoMeun" class="nav nav-list collapse menu-second">
				        <li><a href="${path}/accountCom/basicInfo" target="accframe"><i class="icon-basinfo"></i><span>基本信息</span></a></li>
				        <li><a href="${path}/accountCom/companyInfo" target="accframe"><i class="icon-cominfo"></i><span>企业信息</span></a></li>
				        <li><a href="javascript:;" target="accframe"><i class="icon-materinfo"></i><span>物质信息</span></a></li>
				        <li><a href="javascript:;" target="accframe"><i class="icon-comintro"></i><span>企业介绍</span></a></li>		 
				    </ul>
                   <!-- 				    data-toggle="collapse" -->
			    <a href="${path}/accountCom/accountSafety" target="accframe" class="nav-header menu-first collapsed" ><i class="icon-safe"></i><span>账户安全</span><i class="arrow-r"></i></a>
                <!-- 			    data-toggle="collapse" -->
			    <a href="${path}/accountCom/accountManage" target="accframe" class="nav-header menu-first collapsed" ><i class="icon-mana"></i><span>账户管理</span><i class="arrow-r"></i></a>
			    <a href="#accadsMenu" target="accframe" class="nav-header menu-first collapsed" data-toggle="collapse"><i class="icon-ads"></i><span>地址管理</span><i class="arrow-r"></i></a>
				    <ul id="accadsMenu" class="nav nav-list collapse menu-second">
				        <li><a href="${path}/accountCom/comeAds" target="accframe"><i class="icon-basinfo"></i><span>收货地址</span></a></li>
				        <li><a href="javascript:;" target="accframe"><i class="icon-cominfo"></i><span>发货地址</span></a></li>		 
				    </ul>
			</div>
		</div>
		
		<!--右侧主要内容-->
		<div class="acc-content">
			<div class="acc-top">
				<div class="acc-top-con">
					<ul class="acc-top-left">
						<li>
							<img src="${path}/image/adsmana_icon2.png" class="acc-dingwei"/>
							<span class="fn-left">成都</span>
							<i class="icon-select"></i>
						</li>
						<li class="acc-userli">你好,尊贵的<span class="acc-level">金牌会员</span>丁山石</li>
						<li><a href="javascript:;" target="_blank" class="acc-exit">[退出]</a></li>
						<li><a href="javascript:;" target="_blank" class="acc-msg">消息</a><img src="${path}/image/msg_icon.png" class="acc-msgicon"/></li>
					</ul>
					<ul class="acc-top-right">
						<li><a href="javascript:;" target="_blank">产贸送首页</a></li>
						<li>
							<span><a href="javascript:;" target="_blank">收藏夹</a></span>
						</li>
						<li>
							<span><a href="javascript:;" target="_blank">客服中心</a></span>
						</li>
						<li>
							<span><a href="javascript:;" target="_blank">网站导航</a></span>
						</li>
						<li>
							<img src="${path}/image/iphone_icon.png"/>
							<a href="javascript:;" target="_blank">手机产贸送</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="acc-con-mid">		
	            <iframe src="${path}/accountCom/basicInfo" frameborder="0" id="accframe" name="accframe" width="100%" height="300" onload="setIframeHeight(this)"></iframe>
			</div>
		</div>
	</div>
	<!--底部版权-->
	<div class="acc-footer" align="center"><h1>版权</h1></div>
</body>
</html>



