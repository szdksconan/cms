<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<jsp:include page="../inc.jsp"></jsp:include>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>短信业务管理</title>
	<script type="text/javascript">

	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}' + '/messageLog/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			idField : 'id',
			sortName : 'id',
			sortOrder : 'desc',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [{
				width : '100',
				title : '产生时间',
				field : 'createDate'
			},{
				width : '100',
				title : '用户',
				field : 'login'
			}
			,{
				width : '100',
				title : '对方电话',
				field : 'tel'
			},{
				width:'100',
				title:'车源车牌号',
				field:'carNo'
			}
			,{
				width:'100',
				title:'货源信息',
				field:'orderDesc'
			}
			 ] ],
			toolbar : '#toolbar'
		});

		$('#searchForm input').val('');
	});


	

	
	
	
	
	
	//查询方法
	function searchFun() {
		var fromObj =  $.serializeObject($('#searchForm'));
		dataGrid.datagrid('load',fromObj);
	}



	
	function cleanFun() {



		$('#searchForm input').val('');

		dataGrid.datagrid('load', {});
	}
	
	
	

	</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" style="height: 35px; overflow: hidden;background-color: #f4f4f4">
		<form id="searchForm">
			<table>
				<tr>
					<td>用户名：</td>
					<td>
						<input type="text" name="login" style="height:20px;">
						</td>
					<td>对方电话：</td>
					<td>
					<input type="text" name="tel" style="height:20px;">
					
						
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon_search',plain:true" onclick="searchFun();">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon_refresh',plain:true" onclick="cleanFun();">清空</a>
					</td>
				</tr>
			</table>
		</form>

	</div>
	<div data-options="region:'center',border:false" >
		<table id="dataGrid" data-options="fit:true,border:false"></table>
	</div>
	<div id="toolbar" style="display: none;">
	</div>
</body>
</html>