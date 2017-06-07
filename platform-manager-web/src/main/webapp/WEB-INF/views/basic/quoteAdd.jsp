<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	
	$(function() {
		
		$('#quoteAddForm').form({
			url : '${ctx}/quote/add',
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
		
		    	
		    	$('#bname').combobox({ 
				    url: '${ctx}/city/selectCityJson',
					mode: 'remote',
					valueField:'name', 
					textField:'name',
					panelHeight:true,
					editable:false,
					onHidePanel:function(){
						
					},
				    onSelect:function(rowData){
					    	$('#bid').val(rowData.id);
				    	}
				}); 
		    	$('#ename').combobox({ 
				    url: '${ctx}/city/selectCityJson',
					mode: 'remote',
					valueField:'name', 
					textField:'name',
					panelHeight:true,
					editable:false,
					onHidePanel:function(){
						
					},
				    onSelect:function(rowData){
				    		$('#eid').val(rowData.id);
				    	}
				});
		    	
	
	
	
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="quoteAddForm" method="post">
			<input type="hidden" id="bid" name="bid" />
			<input type="hidden" id="eid" name="eid" />
			<table class="grid">
					<tr>
					<td>起始市县</td>
					<td><input id="bname"    name="bname" type="text"   style="background:transparent;border:0"></td>
					<td>到达市县</td>
					<td><input id="ename"    name="ename" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>里程</td>
					<td><input id="mileage"    name="mileage" type="text"   data-options="required:true,validType:'number'"  class="easyui-validatebox"   style="background:transparent;border:0"></td>
					<td>单价</td>
					<td><input id="price"    name="price" type="text"   data-options="required:true,validType:'number'"  class="easyui-validatebox"   style="background:transparent;border:0"></td>
					</tr>
			</table>
		</form>
	</div>
</div>