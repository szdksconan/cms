<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>资源管理</title>
<script type="text/javascript">
	var treeGrid;
	$(function() {
		
		treeGrid = $('#treeGrid').treegrid({
			url : '${ctx}/baseDic/treeGrid',
			idField : 'dicno',
			treeField : 'dicno',
			parentField : 'pid',
			fit : true,
			fitColumns : false,
			border : false,
			frozenColumns : [ [ {
				title : '编号',
				field : 'dicno',
				width : 120
			} ] ],
			columns : [ [ {
				field : 'name',
				title : '名称',
				width : 120
			}, {
				field : 'accessType',
				title : '状态',
				width : 120,
				formatter : function(value, row, index) {
					if(row.tag == '1')
						return '启用';
					if(row.tag == '0')
						return '禁用';
				}
			}
			] ],
			toolbar : '#toolbar',
			onLoadSuccess:function(){
				$('#treeGrid').treegrid('collapseAll');
			}
		});
	});
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 500,
			height : 350,
			href : '${ctx}/baseDic/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_treeGrid = treeGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#orderDicAddForm');
					f.submit();
				}
			} ,{
				text : '关闭',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			} ]
		});
	}
	function editFun() {

			var rows = treeGrid.treegrid('getSelections');
			if(rows.length > 0){
			id = rows[0].id;
			parent.$.messager.confirm('提示', '您是否要更改当前信息？', function(b) {
			if (b) {
					progressLoad();
					$.post('${ctx}/baseDic/edit', {
						id : id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							treeGrid.treegrid('reload');
						}else{
							parent.$.messager.alert('提示', result.msg, 'info');
						}
						progressClose();
					}, 'JSON');}
			});
			
		
			
			}
	}
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center',border:false"  style="overflow: hidden;">
			<table id="treeGrid"></table>
		</div>
	</div>
	
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.accessList, '/baseDic/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
		<c:if test="${fn:contains(sessionInfo.accessList, '/baseDic/edit')}">
			<a onclick="editFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_sys'">更改状态</a>
		</c:if>
	</div>
</body>
</html>