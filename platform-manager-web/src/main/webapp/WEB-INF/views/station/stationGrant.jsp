<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#stationId').combobox({
		    url: '${ctx}/station/getStationList',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			value:'${map.stationId}',
			onLoadSuccess: function () { //加载完成后,设置选中第一项
	        }
		});

		$('#stationGrantForm').form({
			url : '${ctx}/station/grant',
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
<div id="roleGrantLayout" class="easyui-layout" data-options="fit:true,border:false">
	<div style="width: 100%; padding: 1px;height: 100%">
		<form id="stationGrantForm" method="post">
			<input name="userId" type="hidden" value="${map.id}"/>
			<input id="stationId" name="stationId" class="easyui-validatebox" style="background:transparent;border:0"/>
		</form>
	</div>
</div>