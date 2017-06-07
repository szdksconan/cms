<%@ page import="com.cms.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

　<meta http-equiv="X-UA-Compatible" content="IE=edge" /> 
<%-- <jsp:include page="/WEB-INF/views/inc.jsp"/> --%>
<%
    User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
%>
<html>
<head>
    <title>产贸运网络科技平台</title>
    <meta charset="utf-8">

    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/base_v3.0.css">
     <link rel="stylesheet" type="text/css" href="css/jquery-labelauty.css">
<!--     <link rel="stylesheet" type="text/css" href="css/city.css">

 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/hellocss.css" rel="stylesheet">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <!--  -->
    <link id="easyuiTheme" rel="stylesheet" href="${ctx}/css/themes/<c:out value="${cookie.easyuiThemeName.value}" default="metro-gray"/>/easyui.css" type="text/css"/>
    
	<script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%--<script src="js/jquery.js"></script>--%>
<!-- 	<script src="js/build.js"></script> -->
	<script src="js/base_v3.0.js"></script>
<!-- 	<script src="js/control.js"></script> -->
	<script src="js/AreaManager.js"></script>
    <script src="js/Init.js"></script>
	<script src="js/common.js"></script>
    <script src="js/extJquery.js"></script>
	<script src="js/bootstrap-paginator.js"></script>
	<script src="js/jquery.easyui.min.js"></script>
	<script src="js/bootstrap-growl.js"></script>
	<script type="text/javascript" src="js/easyui-lang-zh_CN.js" charset="utf-8"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/jquery.countdown.js" charset="utf-8"></script>
	<!-- 加载百度地图 -->
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N5eGdOHnO80ZMcthzYXtRWEc"></script>
    <script type="text/javascript"  src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css"/>

	<style type="text/css">
	    body{overflow-y: hidden;}
	</style>
<!--     <link href="css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"> -->
	<script type="text/javascript">
		$(function(){
			$('#center').load('infohall/infohall');
		});
		function changeDiv(url){
			$('#center').load(url);
		}
	</script>

</head>
<body style="background: #fff url(images/1.jpg) 50% 0 no-repeat;background-size: 114%" >
<div>

    <div class="navbar" style="width: 98.4%;margin: 0 auto;">
        <div class="navbar-inner" >
            <ul class="nav">
                <li class="active"><a href="#" onclick="changeDiv('${ctx}/infohall/infohall')" data-toggle="tab">信息中心</a></li>
                <li><a href="#" onclick="changeDiv('${ctx}/infopublish/infopublish')" data-toggle="tab">发布信息</a></li>
                <li><a href="#" onclick="changeDiv('${ctx}/caronline/caronlineList')" data-toggle="tab">在线车辆</a></li>
                <li><a href="#" onclick="changeDiv('${ctx}/mycar/mycarList')" data-toggle="tab">我的车库</a></li>
                <!--
                <li><a href="#" onclick="changeDiv()" data-toggle="tab">我要投保</a></li>
                <li><a href="#" onclick="changeDiv()" data-toggle="tab">物流名片</a></li>
                <li><a href="#" onclick="changeDiv()" data-toggle="tab">身份验证</a></li>
                 -->
                <li><a href="#"  data-toggle="tab" onclick="changeDiv('${ctx}/vaservice/vaserviceList')">套餐服务</a></li>
                <li><a href="#"  data-toggle="tab" onclick="changeDiv('${ctx}/infopublish/canmao')">产贸平台</a></li>
                <li>
                    <a data-toggle="tab" style="color: red;">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        用户id:<%=loginUser.getId()%>
                    </a>
                </li>
            </ul>

        </div>
    </div>
    <div  id="center"    style="height: 99%;width: 98.4%;margin: 0 auto;"  >

    </div>
</div>

</body>

</html>