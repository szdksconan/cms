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
<c:if test="${fn:contains(sessionInfo.accessList, '/combo/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/combo/state')}">
	<script type="text/javascript">
		$.canDelete = true;
	</script>
</c:if>
<title>用户管理</title>
	<script type="text/javascript">
	var dataGrid;
	$(function() {
		//加載下拉框
		$('#vaservicetype').combobox({ 
		    url: '${ctx}/premium/selectTypeJson?pid=8',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	
		    	}
		}); 
		
		dataGrid = $('#dataGrid').datagrid({
			url : '${ctx}/combo/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			idField : 'id',
			sortName : 'vaservicetypename',
			sortOrder : 'asc',
			pageSize : 50,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [ 
				{
					width : '120',
					title : '套餐类型',
					field : 'vaservicetypename',
					sortable : true
				},
			             {
				width : '120',
				title : '套餐名称',
				field : 'vaservicename',
				sortable : true
			},
			
			{
				width : '120',
				title : '价格',
				field : 'price',
				sortable : true
			},
			{
				width : '120',
				title : '计量次数',
				field : 'measureamount',
				sortable : true
			},
			{
				width : '120',
				title : '计量单位',
				field : 'measurementunit',
				sortable : true
			},
			{
				width : '120',
				title : '状态',
				field : 'stauts',
				sortable : true,
				formatter : function(value, row, index) {
					if(row.stauts == '1')
						return '有效';
					if(row.stauts == '0')
						return '失效';
				}
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
						if (row.state=='1'){
							str += $.formatString('<a href="javascript:void(0)" onclick="updateFun(\'{0}\',0)" ><span style="color:red">禁用</span></a>', row.id);
							str += '&nbsp;';
						}else {
							str += $.formatString('<a href="javascript:void(0)" onclick="updateFun(\'{0}\',1)" ><span style="color:red">启用</span></a>', row.id);
							str += '&nbsp;';
						}
					}
			
						
					return str;
				}
			}] ],
			toolbar : '#toolbar'
		});
	});
	
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 600,
			height : 300,
			href : '${ctx}/combo/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#comboAddForm');
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
			title : '编辑',
			width : 500,
			height : 300,
			href : '${ctx}/combo/editPage?id='+id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#comboEditForm');
					f.submit();
				}
			},{
				text : '关闭',
				handler : function() {
					parent.$.modalDialog.handler.dialog('close');
				}
			}]
		});
	}
	
	function updateFun(id,status) {
		if (id == undefined) {//点击右键菜单才会触发这个
			var rows = dataGrid.datagrid('getSelections');
			id = rows[0].id;
		} else {//点击操作里面的删除图标会触发这个
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		var json = '{"id":"'+id+'","state":"'+status+'"}';
		parent.$.messager.confirm('提示', '您是否要这样做？', function(b) {
			if (b) {
				$.post('${ctx}/combo/state', {json:json}, function(result) {
					if (result.success) {
						parent.$.messager.alert('提示', result.msg, 'info');
						dataGrid.datagrid('reload');
					}
					progressClose();
				}, 'JSON');
			}
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
		<form id="searchForm" method="post" action="${ctx}/combo/userDown">
			<table>
			
				<tr>
					<th>套餐类型:</th>
					<td><input id="vaservicetype" name="vaservicetype"></td>
					<th>套餐名称:</th>
					<td>
					<input name="vaservicename" placeholder="请输入套餐名称"/>
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
		<c:if test="${fn:contains(sessionInfo.accessList, '/combo/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
</div>
</body>
</html>