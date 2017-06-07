<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#dataRoleEditForm').form({
			url : '${ctx}/dataRole/edit',
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
					parent.$.modalDialog.openner_dataGrid.datagrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_dataGrid这个对象，是因为user.jsp页面预定义好了
					parent.$.modalDialog.handler.dialog('close');
					parent.$.messager.alert('提示', result.msg, 'info');
				} else {
					parent.$.messager.alert('提示', result.msg, 'info');
				}
			}
		});
		$("#description").val('${dataRole.description}');
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;">
		<form id="dataRoleEditForm" method="post">
			<table class="grid">
				<tr>
					<td>角色名称</td>
					<td><input name="id" type="hidden"  value="${dataRole.id}">
					<input name="name" type="text" placeholder="请输入角色名称" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'" value="${dataRole.name}"></td>
				</tr>
				<tr>
					<td>描述</td>
					<td colspan="3"><textarea id="description" name="description" rows="5" cols="45" class="easyui-validatebox" data-options="validType:'length[1,255]'" ></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>