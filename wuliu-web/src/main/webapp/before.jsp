<%@page import="com.cms.model.util.GlobalConstant"%>
<%@ page import="com.cms.model.util.SessionInfo" %>
<%@ page import="java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>简洁大气快速登录注册模板</title> 

<!-- <script type="text/javascript" src="js/jquery-1.9.0.min.js"></script> -->
<!-- <script type="text/javascript" src="images/login.js"></script> -->
<link href="css/login2.css" rel="stylesheet" type="text/css" />
  <script src="js/jquery.js"></script>
</head>
<body>
<h1>角色登录页面<sup>@</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    
            <!--登录-->
            <div class="web_login" id="web_login">
               <div class="login-box">
			<div class="login_form">
                <div class="uinArea" id="uinArea">
          			<label><input id="Role" name="Role" type="radio" value="1" checked/>生产者 </label>
          			<label><input id="Role" name="Role" type="radio" value="2" />贸易商 </label>
          			<label><input id="Role" name="Role" type="radio" value="3" />物流商 </label>
          			<label><input id="Role" name="Role" type="radio" value="4" />司机 </label>
                </div>
                <div style="padding-left:50px;margin-top:20px;">
                	<button  style="width:150px;" class="button_blue" onclick="openIndex();">登录</button>
                </div>
           </div>
            	</div>
            </div>
            <!--登录按角色end-->
  </div>


    <!--注册end-->
</div>
<div class="jianyi">*推荐使用Chrome内核浏览器访问本站</div>
</body>
</html>
<script>
	function openIndex(){
	//	var role = $('#Role').val();
		var role = $('#uinArea input[id="Role"]:checked ').val();
	//	alert(role);
		if(role != undefined)
		window.location ="index.jsp";
	}
</script>