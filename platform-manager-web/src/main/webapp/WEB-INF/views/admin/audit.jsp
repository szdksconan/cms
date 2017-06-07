<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
$(function() {
	$('#auditForm').form({
		url : '${ctx}/loginUser/audit',
		onSubmit : function() {
			return true;
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
<div>
	<form id="auditForm" method="post">
		<input type="hidden" name="id" value="${id}"/>
		<input type="hidden" name="status" id="status" value=""/>
		<table>
			<tr>
				<td>
					<textarea rows="4" cols="50" placeholder="备注" name="remark" class="textarea easyui-validatebox" style="background:transparent;border:0" data-options="validType:'length[1,255]'"></textarea>
				</td>
			</tr>
		</table>
	</form>
</div>
