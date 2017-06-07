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
			onLoadSuccess: function () { //加载完成后,设置选中第一项
	            var val = $(this).combobox("getData");
	            for (var item in val[0]) {
	                if (item == "id") {
	                    $(this).combobox("select", val[0][item]);
	                }
	            }
	        }
		});
		
		$('#dataRoleId').combobox({
		    url: '${pageContext.request.contextPath}/dataRole/getDataRoleList',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onLoadSuccess: function () { //加载完成后,设置选中第一项
	            var val = $(this).combobox("getData");
	            for (var item in val[0]) {
	                if (item == "id") {
	                    $(this).combobox("select", val[0][item]);
	                }
	            }
	        }
		});
		
		$('#stationAddForm').form({
			url : '${ctx}/station/add',
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
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
					parent.$.modalDialog.handler.dialog('close');
					parent.$.messager.alert('提示', result.msg, 'info');
				}
				else{
					parent.$.messager.alert('提示', result.msg, 'info');
				}
			}
		});
		
	});
	
</script>
<div style="padding: 3px;">
	<form id="stationAddForm" method="post">
		<table class="grid">
			<tr>
				<td>岗位名称</td>
				<td colspan="3"><input name="name" type="text" placeholder="请输入岗位名称" maxlength="65" class="easyui-validatebox" data-options="required:true,validType:['notSpace','length[1,25]']" ></td>
			</tr>
			<tr>
				<td>资源角色</td>
				<td><select id="roleId" name="roleId" style="width:180px;height: 29px;"></select></td>
				<td>数据角色</td>
				<td><select id="dataRoleId" name="dataRoleId" style="width:180px;height: 29px;"></select></td>
			</tr>
		</table>
	</form>
</div>