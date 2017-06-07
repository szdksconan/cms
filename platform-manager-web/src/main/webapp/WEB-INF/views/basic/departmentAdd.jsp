<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#subcompanyId').combotree({
			url : '${ctx}/subCompany/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			onLoadSuccess : function(){
 			}
		});
		
		$('#departmentAddForm').form({
			url : '${ctx}/department/add',
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
	<form id="departmentAddForm" method="post">
		<table class="grid">
			<tr>
				<td>部门名称</td>
				<td><input name="name" type="text" placeholder="请输入部门名称" maxlength="65" class="easyui-validatebox" data-options="required:true,validType:['notSpace','length[1,40]']" ></td>
			</tr>
			<tr>
				<td>所属网点</td>
				<td><select id="subcompanyId" name="subcompanyId" style="width:200px;height: 29px;"></select></td>
			</tr>
		</table>
	</form>
</div>