<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<jsp:include page="../inc.jsp"></jsp:include>
<head>

<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.accessList, '/carStyle/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/carStyle/update')}">
	<script type="text/javascript">
		$.canUpdate = true;
	</script>
</c:if>
<title>车辆属性管理</title>
	<script type="text/javascript">
	var treeGrid;
	$(function() {
		treeGrid = $('#treeGrid').treegrid({
			url : '${ctx}/carStyle/treeGrid',
			idField : 'id',
			treeField : 'code',
			parentField : 'pid',
			fit : true,
			fitColumns : false,
			border : false,
			frozenColumns : [ [ {
				title : '编号',
				field : 'code',
				width : 120
			} ] ],
			columns : [ [ {
				field : 'id',
				hidden:true,
				width : 120
			},{
				field : 'name',
				title : '名称',
				width : 120
			}, {
				field : 'status',
				title : '状态',
				width : 120,
				formatter : function(value, row, index) {
					if(row.status == '1')
						return '启用';
					if(row.status == '0')
						return '禁用';
				}
			}
			] ],
			toolbar : '#toolbar',
			onLoadSuccess:function(){
				$('#treeGrid').treegrid('collapseAll');
			}
		});
		
		$('#creatorId').combotree({
			url : '${ctx}/remind/userTree',
			parentField : 'pid',
			lines : true,
			panelHeight : '200'
			

		});
		$('#searchForm input').val('');
		$('#tt1').tabs({
		 	border:false,
		    onSelect:function(title){
		    	var id = getTabId(title);
		    	tabTitle = id;
		    	tableindex = id;
		    	swicthTab(id);
		    }
		});
		
		$('#keyword').keydown(function(e){
			if (e.keyCode==13){
				searchFun();
			}
		});
	});
	
	function getTabId(title){
		var id;
		$("#queryType option").each(function(){
    		if($(this).text() == title){
    			id = $(this).val();
    		   }
    	});
		return id;
	}
	
	//新增
	function addFun() {
		parent.$.modalDialog({
			title : '添加',
			width : 500,
			height : 300,
			href : '${ctx}/carStyle/addPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#carStyleAddForm');
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
			href : '${ctx}/carStyle/editPage?tableindex='+tableindex+'&id='+id,
			buttons : [ {
				text : '保存',
				handler : function() {
					parent.$.modalDialog.openner_dataGrid = dataGrid;//因为添加成功之后，需要刷新这个dataGrid，所以先预定义好
					var f = parent.$.modalDialog.handler.find('#carStyleEditForm');
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
	
	</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center',border:false"  style="overflow: hidden;">
			<table id="treeGrid"></table>
		</div>
	</div>
	<div id="toolbar" style="display: none;">
		<c:if test="${fn:contains(sessionInfo.accessList, '/baseDic/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
	</div>
</body>
</html>