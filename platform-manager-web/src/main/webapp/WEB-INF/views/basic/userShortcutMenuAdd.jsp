<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#menuId').combotree({
			url : '${ctx}/shortcutmenu/userMenuTree',
			lines : true,
		    panelHeight : 'auto',
		    onSelect:function(node){
		    	$('#accessMenuName').val(node.text);
		    	$('#accessMenuUrl').val(node.attributes.url);
		    }
		});
		
		$('#userShortcutMenuAddForm').form({
			url : '${ctx}/shortcutmenu/add',
			onSubmit : function() {
				progressLoad();
				var isValid = $(this).form('validate');
				if (!isValid) {
					progressClose();
				}
				var id = $("#menuId").combotree("getValue");
				if(id == null || id== ""){
					parent.$.messager.alert('提示','请先选择快捷菜单！','info');
					return false;
				}
				return isValid;
			},
			success : function(result) {
				progressClose();
				result = $.parseJSON(result);
				if (result.success) {
					parent.$.modalDialog.handler.dialog('close');
					window.parent.getShortcutList();
				}else{
					$.messager.confirm('提示',result.msg,'info');
				}
			}
		});
		
	});
</script>
<div style="padding: 3px;">
	<form id="userShortcutMenuAddForm" method="post">
		<table class="grid">
			<tr>
				<td>快捷菜单</td>
				<td>
					<input type="hidden" name="accessMenuName" id="accessMenuName"/>
					<input type="hidden" name="accessMenuUrl" id="accessMenuUrl"/>
					<select id="menuId" name="accessMenuId" class="easyui-validatebox" data-options="required:true" style="width:200px;height: 29px;"></select>
				</td>
			</tr>
		</table>
	</form>
</div>