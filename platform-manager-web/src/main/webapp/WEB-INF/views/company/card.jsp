<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />

<title>企业管理</title>
<script type="text/javascript">
var dataGrid;
$(function() {
	dataGrid = $('#dataGrid').datagrid({
		url : '${ctx}' + '/company/dataGrid2',
		striped : true,
		rownumbers : true,
		pagination : true,
		singleSelect : true,
		idField : 'id',
		sortName : 'id',
		sortOrder : 'asc',
		pageSize : 50,
		pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
		frozenColumns : [ [   {
			width : '100',
			title : '联系人',
			field : 'companyLinkman',
			sortable : true
		},  {
			width : '100',
			title : '电话',
			field : 'companyId',
			sortable : true
		}, {
			width : '100',
			title : '起始地',
			field : 'beginAdd',
			sortable : true
		}, {
			width : '100',
			title : '终止地',
			field : 'endAdd',
			sortable : true
		}, {
			width : '100',
			title : '企业名称',
			field : 'companyName',
			sortable : true
		},{
			title : '企业地址',
			width : '250',
			field : 'companyAdd'
		},{
			width : '100',
			title : '附件',
			field : 'companyPic',
			sortable : true
		}, ] ],
		toolbar : '#toolbar'
	});
});
	




</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'center',border:false" >
		<table id="dataGrid" data-options="fit:true,border:false">
		</table>
	</div>
	</div>
</body>
</html>