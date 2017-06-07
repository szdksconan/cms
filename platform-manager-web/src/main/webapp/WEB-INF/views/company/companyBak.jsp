<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<c:if test="${fn:contains(sessionInfo.accessList, '/company/edit')}">
	<script type="text/javascript">
		$.canEdit = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/company/update')}">
	<script type="text/javascript">
		$.update = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/company/view')}">
	<script type="text/javascript">
		//$.view = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/company/rePwd')}">
	<script type="text/javascript">
		$.rePwd = true;
	</script>
</c:if>
<c:if test="${fn:contains(sessionInfo.accessList, '/company/audit')}">
	<script type="text/javascript">
		$.audit = true;
	</script>
</c:if>
<title>企业管理</title>
<script type="text/javascript">
var dataGrid;
$(function() {
	dataGrid = $('#dataGrid').datagrid({
		url : '${ctx}' + '/company/dataGrid',
		striped : true,
		rownumbers : true,
		pagination : true,
		singleSelect : true,
		idField : 'id',
		sortName : 'id',
		sortOrder : 'asc',
		pageSize : 50,
		pageList : [ 10, 20, 30, 40, 50, 100, 200, 300, 400, 500 ],
		frozenColumns : [ [ {
			width : '100',
			title : '账户ID',
			field : 'companyId'
		}, {
			width : '140',
			title : '企业名称',
			field : 'companyName',
			sortable : true
		}, {
			title : '企业地址',
			width : '250',
			field : 'companyAdd'
		}, {
			title : '状态',
			width : '80',
			field : 'status',
			formatter:function(value, row, index){
				if (value==2){
					return '<span style="color:blue">停用</span>';
				}else if(value==3){
					return '<span style="color:blue">正常</span>';
				}else if(value==0){
					return '<span style="color:red">停用</span>';
				}else if (value==1){
					return '<span style="color:blue">正常</span>';
				}
			}
		},{
			width : '150',
			field : 'action',
			title : '操作',
			align : 'center',
			formatter : function(value, row, index) {
				var str = '';
				if ($.canEdit && row.status!=1) {
					str += $.formatString('<a href="javascript:void(0)" onclick="editFun(\'{0}\');" ><span style="color:red">编辑</span></a>', row.companyId);
				}
				if ($.update) {
					if (row.status==2){
						str += '&nbsp;|&nbsp;';
						str += $.formatString('<a href="javascript:void(0)" onclick="updateFlag(\'{0}\',3);" ><span style="color:red">启用</span></a>', row.companyId);
					}else if(row.status==3){
						str += '&nbsp;|&nbsp;';
						str += $.formatString('<a href="javascript:void(0)" onclick="updateFlag(\'{0}\',2);" ><span style="color:red">停用</span></a>', row.companyId);
					}
				}
		
				return str;
			}
		} ] ],
		toolbar : '#toolbar',
		onDblClickRow:function(rowIndex, rowData){
			/*if ($.view) {
				viewFun(rowData.companyId);
			}*/
		}
	});
	
	$('#keyword').keydown(function(e){
		if (e.keyCode==13){
			searchFun();
		}
	});
	
	var statusArray = [{id:"-1",value:"全部"},{id:"0",value:"启用"},{id:"1",value:"停用"}];
	
	$('#status').combobox({
		valueField: 'id',
        textField: 'value',                                  
        data : statusArray,
        editable:false,
        panelHeight:true,
        onSelect:function(){
        	searchFun();
        },
        onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            for (var item in val[0]) {
                if (item == "id") {
                    $(this).combobox("select", val[0][item]);
                }
            }
        }
	});
});

function rePwd(id){
	parent.$.messager.confirm('提示', '您是否要这样做？', function(b) {
		if (b) {
			$.post('${ctx}/company/rePwd', {id:id}, function(result) {
				if (result.success) {
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
		width : 1000,
		height : 600,
		href : '${ctx}/company/addPage',
		buttons : [ {
			text : '保存',
			handler : function() {
				parent.$.modalDialog.openner_dataGrid = dataGrid;
				var f = parent.$.modalDialog.handler.find('#companyAddForm');
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
	parent.$.modalDialog({
		title : '编辑',
		width : 1000,
		height : 600,
		href : '${ctx}/company/editPage?companyId='+id,
		buttons : [ {
			text : '保存',
			handler : function() {
				parent.$.modalDialog.openner_dataGrid = dataGrid;
				var f = parent.$.modalDialog.handler.find('#companyEditForm');
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

function viewFun(id) {
	parent.$.modalDialog({
		title : '查看',
		width : 800,
		height : 800,
		href : '${ctx}/company/viewPage?companyId='+id,
		buttons : [{
			text : '关闭',
			handler : function() {
				parent.$.modalDialog.handler.dialog('close');
			}
		} ]
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
				parent.$.modalDialog.openner_dataGrid = dataGrid;
				$(parent.$.modalDialog.handler.find('#status')[0]).val(3);
				var f = parent.$.modalDialog.handler.find('#auditForm');
				f.submit();
			}
		} ,{
			text : '审核不通过',
			handler : function() {
				parent.$.modalDialog.openner_dataGrid = dataGrid;
				$(parent.$.modalDialog.handler.find('#status')[0]).val(1);
				var f = parent.$.modalDialog.handler.find('#auditForm');
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

function updateFlag(id,status){
	var json='{"id":"'+id+'","status":'+status+'}';
	parent.$.messager.confirm('提示', '您是否要这样做？', function(b) {
		if (b) {
			$.post('${ctx}/company/updateFlag', {json:json}, function(result) {
				if (result.success) {
					parent.$.messager.alert('提示', result.msg, 'info');
					dataGrid.datagrid('reload');
				}
				progressClose();
			}, 'JSON');
		}
	});
}

function searchFun(){
	var fromObj =  $.serializeObject($('#searchForm'));
	dataGrid.datagrid('load',fromObj);
}

function cleanFun(){
	$('#keyword').val("");
	searchFun()
}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'north',border:false" style="height: 34px; overflow: hidden;background-color: #f4f4f4">
		<form id="searchForm">
			<table>
				<tr>
					<td>关键词：</td>
					<td>
					<input type="text" id="keyword" name="keyword" style="height:20px;" >
					</td>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon_search',plain:true" onclick="searchFun();">查询</a>
						<!-- <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon_refresh',plain:true" onclick="cleanFun();">清空</a> -->
						<select name="status" id="status" class="easyui-combobox" style="width: 60px;">
							<!-- <option value="-1" selected="selected">全部</option>
							<option value="0">启用</option>
							<option value="1">停用</option> -->
						</select>
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
		<c:if test="${fn:contains(sessionInfo.accessList, '/company/add')}">
			<a onclick="addFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_add'">添加</a>
		</c:if>
	</div>
</div>
</body>
</html>