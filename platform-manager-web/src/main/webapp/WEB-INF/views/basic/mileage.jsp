<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<jsp:include page="../inc.jsp"></jsp:include>
<head>
<c:if test="${fn:contains(sessionInfo.accessList, '/mileage/delete')}">
	<script type="text/javascript">
		$.canDel = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/mileage/edit')}">
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
			url : '${ctx}' + '/mileage/dataGrid',
			striped : true,
			rownumbers : true,
			pagination : true,
			singleSelect : true,
			idField : 'startid',
			sortName : 'startid',
			sortOrder : 'desc',
			pageSize : 20,
			pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
			columns : [ [{
				width : '100',
				title : '出发线路县市ID',
				field : 'startid'
			},
			{
				width : '100',
				title : '出发行政县市ID',
				field : 'startcid'
			},
			{
				width : '100',
				title : '到达线路县市ID',
				field : 'endid'
			}
			,{
				width : '100',
				title : '到达行政县市ID',
				field : 'endcid'
			},
			{
				width : '100',
				title : '里程',
				field : 'mileage'
			}
			,{
				field : 'action',
				title : '操作',
				width : 220,
				align : 'center',
				formatter : function(value, row, index) {
					var str = '';
						if ($.canEdit) {
							str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\',\'{1}\');" ><span style="color:red">编辑</span></a>', row.startid,row.endid);
							str += '&nbsp;|&nbsp;';
						}
					
					if ($.canDel) {
						str += $.formatString('<a href="javascript:void(0)" onclick="delFun(\'{0}\',\'{1}\');" ><span style="color:red">删除</span></a>', row.startid,row.endid);
						str += '&nbsp;';
					} 
					return str;
				}
			} ] ],
			toolbar : '#toolbar'
		});

		$('#searchForm input').val('');
	});

	//新增
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 600,
			height : 300,
			href : '${ctx}/mileage/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#mileageAddForm')
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
	
	function delFun(startid,endid) {
		if (startid == undefined && endid == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			startid = rows[0].startid;
			endid = rows[0].endid;
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.messager.confirm('提示', '您是否要删除当前信息？', function(b) {
			if (b) {
					progressLoad();
					$.post('${ctx}/mileage/delete', {
						startid : startid, endid : endid
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
	
	function editFun(startid,endid) {
		if (startid == undefined && endid == undefined) {
			var rows = dataGrid.datagrid('getSelections');
			startid = rows[0].startid;
			endid = rows[0].endid
		} else {
			dataGrid.datagrid('unselectAll').datagrid('uncheckAll');
		}
		parent.$.modalDialog({
		title : '修改',
		width : 600,
		height : 300,
		href : '${ctx}/mileage/editPage?startid='+startid+'&endid='+endid,
		buttons : [ {
			text : '保存',
			handler : function() {
				parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
				var f = parent.$.modalDialog.handler.find('#mileageEditForm');
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
					<td>名称：</td>
					<td>
						<input type="text" name="name" style="height:20px;">
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
			<c:if test="${fn:contains(sessionInfo.accessList, '/mileage/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
	</div>
</body>
</html>