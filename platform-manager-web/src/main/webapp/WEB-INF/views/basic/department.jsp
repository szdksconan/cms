<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.accessList, '/department/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/department/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/department/addChild')}">
	<script type="text/javascript">
		$.canAddChild = true;
	</script>
</c:if>
<title>部门管理</title>
<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}/department/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			idField : 'id',
			sortName : 'id',
			sortOrder : 'asc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			frozenColumns : [ [ {
				title : 'id',
				field : 'id',
				width : 150,
				hidden : true
			} ] ],
			columns : [ [{
				field : 'name',
				title : '部门名称',
				sortable : true,
				width : 200
			}, {
				field : 'subcompanyName',
				title : '所属网点',
				sortable : true,
				width : 200
			},{
				width : '150',
				title : '创建时间',
				field : 'createTime'
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
					
					/*if ($.canAddChild) {
						str += $.formatString('<a href="javascript:void(0)" onclick="addChildFun(\'{0}\');" ><span style="color:red">添加下级部门</span></a>', row.id);
					}*/
						
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
			href : '${ctx}/department/editPage?id=' + id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#departmentEditForm');
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
		if (id != undefined) {
			dataGrid.dataGrid('select', id);
		}
		var node = dataGrid.dataGrid('getSelected');
		if (node) {
			parent.$.messager.confirm('提示', '您是否要删除当前部门？删除当前部门会连同子部门一起删除!', function(b) {
				if (b) {
					progressLoad();
					$.post('${ctx}/department/delete', {
						id : node.id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.dataGrid('reload');
						}else{
							parent.$.messager.alert('提示', result.msg, 'info');
						}
						progressClose();
					}, 'JSON');
				}
			});
		}
	}
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 550,
			height : 200,
			href : '${ctx}/department/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#departmentAddForm');
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
	
	/*function addChildFun(id) {
		parent.$.modalDialog({
			title : '添加下级部门',
			width : 550,
			height : 350,
			href : '${ctx}/department/addPage?pid=' + id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#departmentAddForm');
					f.submit();
				}
			},{
				text : '关闭',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			}  ]
		});
	}*/
	</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
			<div data-options="region:'center',border:false" >
		<table id="dataGrid" data-options="fit:true,border:false">
		</table>
	</div>
		
		<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.accessList, '/department/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
	</div>
	</div>
</body>
</html>