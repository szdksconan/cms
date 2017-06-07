<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#userGradeAddForm').form({
			url : '${ctx}/userGrade/add',
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
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="userGradeAddForm" method="post">
			<table class="grid">
				<tr>
					<td>名称</td>
					<td><input id="name" name="name" type="text"   data-options="required:true,validType:['length[1,32]','enterName']"  class="easyui-validatebox"></td>
				</tr>
				<tr>
					<td>延迟时间</td>
					<td><input id="delayTime" name="delayTime" type="text"   data-options="validType:['length[1,3]','number']"  class="easyui-validatebox" value="0">分钟</td>
				</tr>
			</table>
		</form>
	</div>
</div>