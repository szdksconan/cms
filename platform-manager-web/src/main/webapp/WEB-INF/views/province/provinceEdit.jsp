<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	
	$(function() {
		
		$('#provinceEditForm').form({
			url : '${ctx}/province/edit',
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
		
// 			$('#type').combobox({ 
// 			    url: '${ctx}/province/selectProvinceJson',
// 				mode: 'remote',
// 				valueField:'id', 
// 				textField:'text',
// 				panelHeight:true,
// 				editable:false,
// 				onHidePanel:function(){
					
// 				},
// 			    onSelect:function(rowData){
// 				    	if(rowData.id != '1'){
// 				    		$('#pidname1').combobox("reload",'${ctx}/province/selectProvinceJson2?pid1='+rowData.id); 
// 				    	}
// 			    	}
// 			}); 
// 			$('#pidname1').combobox({ 
// 			    url: '',
// 				mode: 'remote',
// 				valueField:'name', 
// 				textField:'name',
// 				panelHeight:true,
// 				editable:false,
// 				onHidePanel:function(){
					
// 				},
// 			    onSelect:function(rowData){
// 			    	$('#pid1').val(rowData.id);
// 			    	var tag = $('#type').combobox('getValue');
// 			    	if(tag == '3'){
// 			    	$('#pidname2').combobox("reload",'${ctx}/province/selectProvinceJson3?pid1='+rowData.id); 
// 				}}
// 			}); 
// 			$('#pidname2').combobox({ 
// 			    url: '',
// 				mode: 'remote',
// 				valueField:'name', 
// 				textField:'name',
// 				panelHeight:true,
// 				editable:false,
// 				onHidePanel:function(){
					
// 				},
// 			    onSelect:function(rowData){
// 			    	$('#pid2').val(rowData.id);
// 				}
// 			}); 
	
	
	});
	
</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="provinceEditForm" method="post" >
			<input type="hidden" name="id" value="${provinceBean.id}"/>
			<table class="grid">
				<tr>
					<td>编码</td>
					<td ><input id="code" value="${provinceBean.code}" name="code" type="text" data-options="required:true,validType:['length[1,50]','enterName']" class="easyui-validatebox" style="background:transparent;border:0" />
					</td>
				</tr>
				<tr>
					<td>名称</td>
					<td ><input id="name" value="${provinceBean.name}" name="name" type="text" data-options="required:true,validType:['length[1,32]','enterName']" class="easyui-validatebox" style="background:transparent;border:0" />
					</td>
				</tr>
			
			</table>
		</form>
	</div>
</div>