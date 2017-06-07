<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#roleId').combobox({
		    url: '${pageContext.request.contextPath}/user/getRoleList',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			value:'${station.roleId}',
			onLoadSuccess: function () { //加载完成后,设置选中第一项
	        }
		});
		
		$('#dataRoleId').combobox({
		    url: '${pageContext.request.contextPath}/dataRole/getDataRoleList',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			value:'${station.dataRoleId}',
			onLoadSuccess: function () { //加载完成后,设置选中第一项
	        }
		});
		
		$('#stationEditForm').form({
			url : '${ctx}/station/edit',
			onSubmit : function() {
				progressLoad();
				var isValid = $(this).form('validate');
				if (!isValid) {
					progressClose();
				}
				return isValid;
			},
			success : function(result) {
				progressClose();
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.messager.alert('提示', result.msg, 'info');
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					parent.$.modalDialog.handler.dialog('close');
				}
				else{
					parent.$.messager.alert('提示', result.msg, 'info');
				}
			}
		});
		
	});
	
	
</script>
<div style="padding: 3px;">
	<form id="stationEditForm" method="post">
		<table class="grid">
			<tr>
				<td>岗位名称</td>
				<td colspan="3"><input type="hidden" name="id" value="${station.id}"/><input name="name" type="text" value="${station.name}" placeholder="请输入岗位名称"  class="easyui-validatebox" data-options="required:true,validType:['notSpace','length[1,25]']" ></td>
			</tr>
			<tr>
				<td>资源角色</td>
				<td><input id="roleId" name="roleId" class="easyui-validatebox" style="width:180px;height: 29px;"/></td>
				<td>数据角色</td>
				<td><input id="dataRoleId" name="dataRoleId" class="easyui-validatebox" style="width:180px;height: 29px;"/></td>
			</tr>
		</table>
	</form>
</div>
