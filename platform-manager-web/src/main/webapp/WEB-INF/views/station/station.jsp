<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.accessList, '/station/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/station/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<title>岗位管理</title>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#datagrid').datagrid({
			url : '${ctx}/station/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			singSelect : true,
			idField : 'id',
			sortName : 'id',
			sortOrder : 'asc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ {
				field : 'id',
				title : '编号',
				hidden : true
			},{
				field : 'name',
				title : '岗位名称',
				width : 200
			},{
				field : 'roleName',
				title : '资源角色',
				width : 200
			},{
				field : 'dataRoleName',
				title : '数据角色',
				width : 200
			}, {
				field : 'seq',
				title : '排序',
				hidden : true,
				width : 40
			},{
				field : 'action',
				title : '操作',
				width : 220,
				align : 'center',
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit) {
						str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" ><span style="color:red">编辑</span></a>', row.id);
						str += '&nbsp;|&nbsp;';
					}
					if ($.canDelete) {
						str += $.formatString('<a href="javascript:void(0)" onclick="deleteFun(\'{0}\');" ><span style="color:red">删除</span></a>', row.id);
						str += '&nbsp;';
					}
					return str;
				}
			} ] ],
			toolbar : '#toolbar'
		});
	});
	
	function editFun(id) {
		parent.$.modalDialog({
			title : '编辑',
			width : 550,
			height : 200,
			href : '${ctx}/station/editPage?id=' + id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#stationEditForm');
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
	
	function deleteFun(id) {
		parent.$.messager.confirm('提示', '您是否要删除当前岗位？', function(b) {
			if (b) {
				progressLoad();
				$.post('${ctx}/station/delete', {
					id : id
				}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						dataGrid.datagrid('reload');
					}else{
						parent.$.messager.alert('提示', result.msg, 'info');
					}
					progressClose();
				}, 'JSON');
			}
		});
	}
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 550,
			height : 200,
			href : '${ctx}/station/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#stationAddForm');
					f.submit();
				}
			},{
				text : '关闭',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			}  ]
		});
	}
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center',border:false" >
		<table id="datagrid" data-options="fit:true,border:false">
		</table>
	</div>
		
		<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.accessList, '/station/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
	</div>
	</div>
</body>
</html>