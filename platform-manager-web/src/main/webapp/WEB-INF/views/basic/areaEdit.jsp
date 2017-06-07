<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	
	$(function() {
		
		$('#areaEditForm').form({
			url : '${ctx}/area/edit',
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
		
			$('#pid').combobox({ 
			    url: '${ctx}/province/selectProvinceJson2',
				mode: 'remote',
				valueField:'id', 
				textField:'name',
				panelHeight:true,
				editable:false,
				onHidePanel:function(){
					
				},
			    onSelect:function(rowData){
				    	
			    	}
			}); 

	
	
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="areaEditForm" method="post" >
			<input type="hidden" name="id" value="${areaBean.id}"/>
			<table class="grid">
						<tr>
					<td>编码</td>
					<td><input id="code"    name="id" type="text" value="${areaBean.code}" readonly="readonly"  data-options="required:true"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					</tr>
				<tr>	
					<td>名称</td>
					<td ><input id="name" value="${areaBean.name}" name="name" type="text" data-options="required:true,validType:['length[1,32]','enterName']" class="easyui-validatebox" style="background:transparent;border:0" />
					</td>
				</tr>
					<tr>	
					<td>省份</td>
					<td ><input id="pid" value="${areaBean.pid}" name="pid" type="text"   style="background:transparent;border:0" />
					</td>
				</tr>
			
			</table>
		</form>
	</div>
</div>