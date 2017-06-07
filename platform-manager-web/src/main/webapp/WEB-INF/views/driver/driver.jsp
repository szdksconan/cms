<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:if test="${fn:contains(sessionInfo.accessList, '/driver/state')}">
	<script type="text/javascript">
		$.canState = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/driver/reset')}">
	<script type="text/javascript">
		$.canReset = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/driver/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/driver/audit')}">
	<script type="text/javascript">
		$.audit = true;
	</script>
</c:if>
<title>用户管理</title>
	<script type="text/javascript">
	var dataGrid;
	$(function() {
		
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}/driver/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			idField : 'id',
			sortName : 'name',
			sortOrder : 'asc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ 
				
			             {
				width : '80',
				title : '登录名',
				field : 'login',
				sortable : true
			},{
				width : '80',
				title : '姓名',
				field : 'name',
				sortable : true
			},
			{
				width : '80',
				title : '身份证号',
				field : 'cardNo1',
				sortable : true
			},
			{
				width : '80',
				title : '驾驶证号',
				field : 'cardNo2',
				sortable : true
			},
			{
				width : '80',
				title : 'QQ',
				field : 'qq',
				sortable : true
			},
			{
				width : '80',
				title : '邮箱',
				field : 'email',
				sortable : true
			},
			{
				width : '80',
				title : '移动电话',
				field : 'tel1',
				sortable : true
			},
			{
				width : '80',
				title : '固定电话',
				field : 'tel2',
				sortable : true
			},
			{
				width : '90',
				title : '联系地址',
				field : 'address',
				sortable : true
			},
			{
				width : '80',
				title : '状态',
				field : 'state',
				sortable : true,
				formatter : function(value, row, index) {
					if (value==2){
						return '<span style="color:blue">禁用</span>';
					}else if(value==3){
						return '<span style="color:blue">启用</span>';
					}else if(value==0){
						return '<span style="color:blue">待审核</span>';
					}else if (value==1){
						return '<span style="color:blue">审核未通过</span>';
					}
				}
			}, {
				field : 'action',
				title : '操作',
				width : 220,
				align : 'center',
				formatter : function(value, row, index) {
					var str = '';
					if ($.canEdit ) {
						str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" ><span style="color:red">编辑</span></a>', row.id);
					}
					if ($.canState) {
						str += '&nbsp;|&nbsp;';
						if (row.state=='0' || row.state=='1'){
							str += $.formatString('<a href="javascript:void(0)" onclick="auditFun(\'{0}\')" ><span style="color:red">审核</span></a>', row.id);
						
						}else if(row.state=='2')
						{
							str += $.formatString('<a href="javascript:void(0)" onclick="stateFun(\'{0}\',3)" ><span style="color:red">启用</span></a>', row.id);
					
						}
						else{
							str += $.formatString('<a href="javascript:void(0)" onclick="stateFun(\'{0}\',2)" ><span style="color:red">禁用</span></a>', row.id);
						
						}
					}
					if ($.canReset ) {
						str += '&nbsp;|&nbsp;';
						str += $.formatString('<a href="javascript:void(0)" onclick="resetFun(\'{0}\')" ><span style="color:red">重置密码</span></a>', row.id);
					} 
					return str;
				}
			}
			] ],
			toolbar : '#toolbar'
		});
	});
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 600,
			height : 300,
			href : '${ctx}/driver/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#driverAddForm');
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
				href : '${ctx}/driver/editPage?id='+id,
				buttons : [ {
					text : '保存',
					handler : function() {
						parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
						var f = parent.$.modalDialog.handler.find('#driverEditForm');
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
	
	function stateFun(id,status) {
			if (id == undefined) {//点击右键菜单才会触发这个
				var rows = dataGrid.datagrid('getSelections');
				id = rows[0].id;
			} else {//点击操作里面的删除图标会触发这个
				dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
			}
		//	var json = '{"id":"'+id+'","state":"'+status+'"}';
			parent.$.messager.confirm('提示', '您是否要这样做？', function(b) {
				if (b) {
					$.post('${ctx}/driver/state', {id:id,state:status}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.datagrid('reload');
						}
						progressClose();
					}, 'JSON');
				}
			});

	}
	
	function resetFun(id) {
			if (id == undefined) {
				var rows = dataGrid.datagrid('getSelections');
				id = rows[0].id;
			} else {
				dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
			}
			parent.$.messager.confirm('提示', '您是否要重置该司机账号密码!', function(b) {
				if (b) {
					progressLoad();
					$.post('${pageContext.request.contextPath}/driver/reset', {
						id : id
					}, function(result) {
						if (result.success) {
							parent.$.messager.alert('提示', result.msg, 'info');
							dataGrid.datagrid('reload');
						}
						progressClose();
					}, 'JSON');
				}
			});
			

	
	}

	function auditFun(id) {
		parent.$.modalDialog({
			title : '审核',
			width : 400,
			height : 200,
			href : '${ctx}/loginUser/auditPage?id='+id,
			buttons:[ {
				text : '审核通过',
				handler : function() {
					stateFun(id,3);
				}
			} ,{
				text : '审核不通过',
				handler : function() {
					stateFun(id,1);
				}
			},{
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
					<th>登录名:</th>
					<td>
					<input name="login" placeholder="请输入登录名"/></td>
				
					<th>姓名:</th>
					<td>
						<input name="name" placeholder="请输入姓名"/>
					</td>
					<th>移动电话:</th>
					<td>
						<input name="tel1" placeholder="请输入移动电话"/>
					</td>
						<th>QQ:</th>
					<td>
						<input name="qq" placeholder="请输入QQ"/>
					</td>
					<th>状态:</th>
					<td>
						<select  id="state" name="state" style="width: 140px; height: 18px;" class="easyui-combobox" >
							<option value="2" selected="selected">全部</option>
							<option value="1" >启用</option>
							<option value="0" >禁用</option>
						</select>
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
		<c:if test="${fn:contains(sessionInfo.accessList, '/driver/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
</div>
</body>
</html>