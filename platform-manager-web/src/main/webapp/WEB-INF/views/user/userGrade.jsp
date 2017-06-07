<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<jsp:include page="../inc.jsp"></jsp:include>
<head>
<c:if test="${fn:contains(sessionInfo.accessList, '/userGrade/delete')}">
	<script type="text/javascript">
		$.canDel = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/userGrade/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>公告管理</title>
	<script type="text/javascript">
	var dataGrid;
	$(function() {
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}' + '/userGrade/dataGrid',
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
				title : '名称',
				field : 'name'
			},{
				width : '100',
				title : '延迟时间',
				field : 'delayTime'
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
					
					if ($.canDel) {
						str += $.formatString('<a href="javascript:void(0)" onclick="delFun(\'{0}\')" ><span style="color:red">删除</span></a>', row.id);
						str += '&nbsp;';
					} 
					return str;
				}
			} ] ],
			toolbar : '#toolbar'
		});
	});

	//新增
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 600,
			height : 300,
			href : '${ctx}/userGrade/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#userGradeAddForm');
					f.submit();
				}
			},{
				text : '关闭',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			} ]
		});
		
	
	}
	
	function delFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('提示', '您是否要删除当前信息？', function(b) {
			if (b) {
					progressLoad();
					$.post('${ctx}/userGrade/delete', {
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
	
	function editFun(id) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
		title : '修改',
		width : 600,
		height : 300,
		href : '${ctx}/userGrade/editPage?id='+id,
		buttons : [ {
			text : '保存',
			handler : function() {
				parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
				var f = parent.$.modalDialog.handler.find('#userGradeEditForm');
				f.submit();
			}
		},{
			text : '关闭',
			handler : function() {
				parent.$.modalDialog.handler.dialog('close');
			}
		} ]
	});
	}
	
	</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" >
		<table id="dataGrid" data-options="fit:true,border:false"></table>
	</div>
   	<div id="toolbar" style="display: none;">
			<c:if test="${fn:contains(sessionInfo.accessList, '/userGrade/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
	</div>
</body>
</html>