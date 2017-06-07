<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.accessList, '/user/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/user/delete')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/user/stationGrant')}">
	<script type="text/javascript">
		$.canGrant = true;
	</script>
</c:if>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
	<script type="text/javascript">
	var dataGrid;
	$(function() {
		
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}/user/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			idField : 'userId',
			sortName : 'userId',
			sortOrder : 'asc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [  {
				width : '120',
				title : '登录名',
				field : 'loginName',
				sortable : true
			},
			{
				width : '120',
				title : '姓名',
				field : 'name',
				sortable : true
			},
//			{
//				width : '120',
//				title : '岗位',
//				field : 'stationName',
//				sortable : true
//			},{
//				width : '120',
//				title : '所属网点',
//				field : 'subcompanyName',
//				sortable : true
//			},{
//				width : '120',
//				title : '所属部门',
//				field : 'departmentName',
//				sortable : true
//			},
            {
				field:'stationId',
				hidden:true
			},{
				field : 'action',
				title : '操作',
				width : 220,
				align : 'center',
				formatter : function(value, row, index) {
					var str = '';
					if (row.userId!=1){
						if ($.canEdit) {
							str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" ><span style="color:red">编辑</span></a>', row.userId);
							str += '&nbsp;|&nbsp;';
						}
						if ($.canDelete) {
							str += $.formatString('<a href="javascript:void(0)" onclick="delFun(\'{0}\');" ><span style="color:red">删除</span></a>', row.userId);
//							str += '&nbsp;|&nbsp;';
						}
//						if ($.canGrant){
//							str += $.formatString('<a href="javascript:void(0)" onclick="grantFun(\'{0}\',\'{1}\');" ><span style="color:red">角色分配</span></a>', row.userId,row.roleId);
//							str += '&nbsp;';
//						}
					}
					return str;
				}
			},] ],
			toolbar : '#toolbar'
		});
	});
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 600,
			height : 350,
			href : '${ctx}/user/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#userAddForm');
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
	
	function editFun(id) {
		parent.$.modalDialog({
			title : '修改',
			width : 600,
			height : 350,
			href : '${ctx}/user/updatePage?id='+id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#userEditForm');
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
		if (id == '0') {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].userId;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		if (id==1){
			parent.$.messager.alert('提示', "不能删除超级管理员！", 'info');
			return;
		}
		parent.$.messager.confirm('提示', '您是否要删除当前角色？', function(b) {
			if (b) {
				var currentUserId = '${sessionInfo.userId}';/*当前登录用户的ID*/
				if (currentUserId != id) {
					progressLoad();
					$.post('${ctx}/user/delete', {
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
				} else {
					parent.$.messager.show({
						title : '提示',
						msg : '不可以删除自己！'
					});
				}
			}
		});
	}

	
	function grantFun(id,roleId) {
		if (id == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
			//title : '授权',
			title : '角色分配',
			width : 200,
			height : 100,
			href : '${ctx}/station/grantPage?id=' + id+"&roleId="+roleId,
			buttons : [ {
				text : '确定',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#stationGrantForm');
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
	
	
	
	function searchFun() {
		dataGrid.datagrid('load', $.serializeObject($('#searchForm')));
	}
	function cleanFun() {
		$('#searchForm input').val('');
		dataGrid.datagrid('load', {});
	}


	
	</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" style="height: 35px; overflow: hidden;background-color: #f4f4f4">
		<form id="searchForm" method="post" action="${ctx}/user/userDown">
			<table>
				<tr>
					<th>姓名:</th>
					<td><input id="temp" name="template" type="hidden"/>
					<input id="dId" name="departmentId" type="hidden"/>
					<input name="name" placeholder="请输入用户姓名"/></td>
					<!--  <th>创建时间:</th>
					<td>
					<input id="timeStart" name="createTimeStart" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />至<input id="timeEnd" name="createTimeEnd" placeholder="点击选择时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" />
					</td>
					-->
					<th>登录名:</th>
					<td>
						<input name="loginName" placeholder="请输入登录名"/>
					</td>
					<th>角色:</th>
					<td>
						<input  id="roleId" name="roleId" style="width: 140px; height: 18px;" class="easyui-combobox" />
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon_search',plain:true" onclick="searchFun();">查询</a><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon_cancel',plain:true" onclick="cleanFun();">清空</a>
					</td>
				
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',border:false" >
		<table id="dataGrid" data-options="fit:true,border:false">
		</table>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.accessList, '/user/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
</div>
</body>
</html>