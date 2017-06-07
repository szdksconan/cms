<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#carStyleAddForm').form({
			url : '${ctx}/carStyle/add',
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
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false" >
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
		<form id="carStyleAddForm" method="post">
			<table class="grid">
				<tr>
				<td>编号</td>
				<td><input name="code" class="easyui-validatebox" data-options="required:true,validType:['length[1,50]','nonChinese']" style="background:transparent;border:0" ></td>
				</tr>
				<tr>
				<td>名称</td>
				<td><input name="name" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','enterName']" style="background:transparent;border:0">
						</td>
			</tr>
			<tr>
				<td>上级字典</td>
				<td colspan="3"><select id="pid" name="pid" style="width: 200px; height: 29px;"></select>
				<a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#pid').combotree('clear');" >清空</a></td>
			</tr>
			<tr>
				<td>状态</td>
				<td ><select name="tag"  class="easyui-combobox"  style="width: 200px; height: 29px;" >
					<option value="1" selected="selected">启用</option>
					<option value="0" >禁用</option>
				</select></td>
			</tr>
			</table>
		</form>
	</div>
</div>