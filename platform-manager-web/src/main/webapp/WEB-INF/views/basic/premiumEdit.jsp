<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#type').combobox({ 
		    url: '${ctx}/premium/selectTypeJson?pid=7',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	$('#typename').val(rowData.name);
		    	}
		}); 
		
	
		$('#premiumEditForm').form({
			url : '${ctx}/premium/edit',
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
<div style="padding: 3px;">
	<form id="premiumEditForm" method="post">
			<input name="id" type="hidden" value="${premiumBean.id }"/>
		<input id="typename" name="typename" type="hidden" value="${premiumBean.typename }"/>
		<table class="grid">
			<tr>
				<td>编号</td>
				<td><input name="no"  value="${premiumBean.no }" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','nonChinese']" style="background:transparent;border:0" ></td>
				</tr>
				<tr>
				<td>名称</td>
				<td><input name="name"  value="${premiumBean.name }" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','enterName']" style="background:transparent;border:0">
						</td>
			</tr>
			<tr>
				<td>类型</td>
				<td ><input id="type"  value="${premiumBean.type }" name="type" ></input>
			</td>
			</tr>
			<tr>
				<td>免赔说明</td>
				<td ><input name="note"  value="${premiumBean.note }" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','enterName']" style="background:transparent;border:0"></td>
				
			</tr>
			<tr>
				<td>费率</td>
				<td ><input name="rate"  value="${premiumBean.rate }" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','enterName']" style="background:transparent;border:0"></td>
				
			</tr>
		</table>
	</form>
</div>