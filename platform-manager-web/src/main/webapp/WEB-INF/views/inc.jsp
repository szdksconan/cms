<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="edge" />
<link rel="shortcut icon" href="${ctx}/static/style/images/index/favicon.png" />
<!-- 引入my97日期时间控件 -->
<script type="text/javascript" src="${ctx}/static/My97DatePicker/WdatePicker.js" charset="utf-8"></script>

<!-- 引入jQuery -->
<script src="${ctx}/static/jquery-1.8.3.js" type="text/javascript" charset="utf-8"></script>

<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${ctx}/static/easyui1.4/themes/<c:out value="${cookie.easyuiThemeName.value}" default="MetroBlue"/>/easyui.css" type="text/css">
<script type="text/javascript" src="${ctx}/static/easyui1.4/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/static/easyui1.4/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>

<!-- 扩展EasyUI -->
<script type="text/javascript" src="${ctx}/static/extEasyUI.js" charset="utf-8"></script>
<!-- 扩展Jquery -->
<script type="text/javascript" src="${ctx}/static/extJquery.js" charset="utf-8"></script>

<!-- 自定义工具类 -->
<script type="text/javascript" src="${ctx}/static/estatemvc.js" charset="utf-8"></script>

<!-- 扩展EasyUI图标 -->
<link rel="stylesheet" href="${ctx}/static/style/estatemvc.css" type="text/css">
<script type="text/javascript" src="${ctx}/static/uploadPreview.min.js" charset="utf-8"></script>
<!-- 扩展点击图片放大 -->
<link rel="stylesheet" href="${ctx}/static/style/imgView.css" type="text/css">
<link rel="stylesheet" href="${ctx}/style/css/reset.css" type="text/css">
<script type="text/javascript" src="${ctx}/static/imgView.js" charset="utf-8"></script>
<!-- 登录页面样式 -->
<link rel="stylesheet" href="${ctx}/style/css/login.css" type="text/css">
<link rel="stylesheet" href="${ctx}/style/css/amend.css" type="text/css">
<link rel="stylesheet" href="${ctx}/style/css/city.css" type="text/css">
<script type="text/javascript" src="${ctx}/style/js/jquery.imagezoom.min.js"></script>
<script type="text/javascript" src="${ctx}/style/js/AreaManager.js"></script>
<!-- 
<script type="text/javascript" src="${ctx}/style/js/cnkjAreaList.js"></script>
 -->
<script type="text/javascript">
$(window).load(function(){
	$("#loading").fadeOut();
});
var _ROOT_PATH = "${pageContext.request.contextPath}";
$.post('${ctx}/province/selectProvinceJson2', function(result) {
	result.forEach(function(obj){
		province.push(obj.name);
		province.push(obj.id);
		province.push('0');
	});
}, 'JSON');

$.post('${ctx}/area/getAll', function(result) {
	var i=0;
	result.forEach(function(obj){
		var array = new Array();
		array.push(i);
		array.push(obj.name);
		array.push(obj.id);
		array.push(obj.pid);
		city.push(array);
		i++;
	});
}, 'JSON');

$.post('${ctx}/city/selectCityJson', function(result) {
	result.forEach(function(obj){
		var array = new Array();
		array.push(obj.name);
		array.push(obj.id);
		array.push(obj.pid);
		area.push(array);
	});
}, 'JSON');
</script>
<style type="text/css">
div.zoomMask{position:absolute;background:url("${ctx}/style/img/mask.png") repeat scroll 0 0 transparent;cursor:move;z-index:10001;}
</style>
