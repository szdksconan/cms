<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#pid').combotree({
			url : '${ctx}/subCompany/tree?flag=false',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto',
			value :'${subCompany.pid}'
		});
		
		if ($(':input[name="id"]').val().length > 0) {
			$.post( '${ctx}/subCompany/get', {
				id : $(':input[name="id"]').val(),
			}, function(result) {
				if (result.id != undefined) {
					$('#subCompanyEditForm').form('load', {
						'id' : result.id,
						'name' : result.name,
						'seq' : result.seq
					});
					$('#pid').combotree('setValue',result.pid);
				}
			}, 'json');
		}
		
		$('#subCompanyEditForm').form({
			url : '${ctx}/subCompany/edit',
			onSubmit : function() {
				if ($('#subCompanyId').val()=='1'&&$('#pid').combotree("getValue")!=''){
					$("#pid").combotree("clear"); 
					parent.$.messager.alert('提示', '最高级部门不能选择上级部门！', 'info');
					return false;
				}
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
	<form id="subCompanyEditForm" method="post">
		<table class="grid">
			<tr>
				<td>网点名称</td>
				<td><input name="id" id="subCompanyId" type="hidden"  value="${subCompany.id}"><input name="name" type="text" value="${subCompany.name}" placeholder="请输入部门名称"  class="easyui-validatebox" data-options="required:true,validType:['notSpace','length[1,64]']" ></td>
			</tr>
			<tr>
				<td>上级网点</td>
				<td><select id="pid" name="pid" style="width: 200px; height: 29px;"></select></td>
				<td>排序</td>
				<td>
					<input name="seq"  class="easyui-numberspinner" value="${subCompany.seq}" style="widtd: 140px; height: 29px;" required="required" data-options="editable:false">
				</td>
			</tr>
		</table>
	</form>
</div>
