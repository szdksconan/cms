<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#pid').combotree({
			url : '${ctx}/subCompany/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto'
		});
		$('#pid').combotree('setValue', '${pid}');
		
		$('#subCompanyAddForm').form({
			url : '${ctx}/subCompany/add',
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
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');//因为添加成功之后，需要刷新这个treeGrid，所以先预定义好
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
	<form id="subCompanyAddForm" method="post">
		<table class="grid">
			<tr>
				<td>网点名称</td>
				<td colspan="3"><input name="name" type="text" placeholder="请输入部门名称" maxlength="65" class="easyui-validatebox" data-options="required:true,validType:['notSpace','length[1,64]']" ></td>
			</tr>
			<tr>
				<td>上级网点</td>
				<td><select id="pid" name="pid" style="width:200px;height: 29px;"></select></td>
				<td>排序</td>
				<td>
					<input name="seq"  class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false" value="0">
					<input type="hidden" name="showAddressbook" value="0">
				</td>
			</tr>
		</table>
	</form>
</div>