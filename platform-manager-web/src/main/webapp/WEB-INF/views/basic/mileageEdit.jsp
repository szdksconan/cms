<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	
	$(function() {
		
		$('#mileageEditForm').form({
			url : '${ctx}/mileage/edit',
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
		
		    	$('#startcid').combobox({ 
				    url: '${ctx}/line/selectLineJson',
					mode: 'remote',
					valueField:'id', 
					textField:'id',
					panelHeight:true,
					editable:false,
					onHidePanel:function(){
						
					},
				    onSelect:function(rowData){
					    	
				    	}
				}); 
		    	$('#endcid').combobox({ 
				    url: '${ctx}/line/selectLineJson',
					mode: 'remote',
					valueField:'id', 
					textField:'id',
					panelHeight:true,
					editable:false,
					onHidePanel:function(){
						
					},
				    onSelect:function(rowData){
					    	
				    	}
				}); 
		    	$('#endid').combobox({ 
				    url: '${ctx}/area/selectAreaJson',
					mode: 'remote',
					valueField:'id', 
					textField:'id',
					panelHeight:true,
					editable:false,
					onHidePanel:function(){
						
					},
				    onSelect:function(rowData){
					    	
				    	}
				}); 
		    	$('#startid').combobox({ 
				    url: '${ctx}/area/selectAreaJson',
					mode: 'remote',
					valueField:'id', 
					textField:'id',
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
		<form id="mileageEditForm" method="post">
			<table class="grid">
					<tr>
					<td>出发线路县市ID</td>
					<td><input id="startid"  readonly="readonly" value="${mileageBean.startid }"   name="startid" type="text"   style="background:transparent;border:0"></td>
					<td>出发行政县市ID</td>
					<td><input id="startcid" value="${mileageBean.startcid }"   name="startcid" type="text"    style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>到达线路县市ID</td>
					<td><input id="endid"  readonly="readonly" value="${mileageBean.endid }"   name="endid" type="text"   style="background:transparent;border:0"></td>
					<td>到达行政县市ID</td>
					<td><input id="endcid"  value="${mileageBean.endcid }"   name="endcid" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>里程</td>
					<td><input id="mileage"  value="${mileageBean.mileage }"   name="mileage" type="text"   data-options="required:true,validType:'number'"  class="easyui-validatebox"   style="background:transparent;border:0"></td>
					</tr>
			</table>
		</form>
	</div>
</div>