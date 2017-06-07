<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge" />

<link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/base_v3.0.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/city.css">
<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
<link href="${ctx}/css/hellocss.css" rel="stylesheet">
<link href="${ctx}/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link href="${ctx}/css/jquery-labelauty.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${ctx}/css/jquery.countdown.css">
<!--  -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/css/themes/<c:out value="${cookie.easyuiThemeName.value}" default="metro-gray"/>/easyui.css" type="text/css"></link>
<script src="${ctx}/js/jquery.js"></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/build.js"></script>
<script src="${ctx}/js/base_v3.0.js"></script>
<script src="${ctx}/js/control.js"></script>
<script src="${ctx}/js/AreaManager.js"></script>
<script src="${ctx}/js/Init.js"></script>
<script src="${ctx}/js/common.js"></script>
<script src="${ctx}/js/extJquery.js"></script>
<script src="${ctx}/js/bootstrap-paginator.js"></script>
<script src="${ctx}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<!-- 加载百度地图 -->
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N5eGdOHnO80ZMcthzYXtRWEc"></script>
<script type="text/javascript"  src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css"/>

<style type="text/css">
    body{overflow-y: hidden;}
</style>
<link href="${ctx}/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css">