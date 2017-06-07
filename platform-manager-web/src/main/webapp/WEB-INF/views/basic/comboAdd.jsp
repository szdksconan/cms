<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#vaservicetype').combobox({ 
		    url: '${ctx}/premium/selectTypeJson?pid=8',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	$('#vaservicetypename').val(rowData.name);
		    	}
		}); 
		
	
		$('#comboAddForm').form({
			url : '${ctx}/combo/add',
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
	<form id="comboAddForm" method="post">
		<input id="vaservicetypename" name="vaservicetypename" type="hidden"/>
		<table class="grid">
			<tr>
				<td>套餐名称</td>
				<td><input name="vaservicename" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','enterName']"  ></td>
				</tr>
				<tr>
				<td>套餐类型</td>
				<td><input id="vaservicetype" name="vaservicetype">
						</td>
			</tr>
			<tr>
				<td>价格</td>
				<td ><input id="price" name="price"  class="easyui-validatebox" data-options="required:true,validType:'money'"  ></input>
			</td>
			</tr>
			<tr>
				<td>计量次数</td>
				<td ><input name="measureamount" class="easyui-validatebox" data-options="required:true,validType:'number'" ></td>
				
			</tr>
			<tr>
				<td>计量单位</td>
				<td >
					<select id="measurementunit" name="measurementunit" class="easyui-combobox" data-options="panelHeight:true,
						editable:false">
						<option value="月" selected="selected">月</option>
						<option value="次" >次</option>
						<option value="分钟" >分钟</option>
					</select>
				</td>
				
			</tr>
			<tr>
				<td>状态</td>
				<td >
					<select id="stauts" name="stauts" class="easyui-combobox" data-options="panelHeight:true,
			editable:false">
						<option value="1" selected="selected">有效</option>
						<option value="0" >失效</option>
					</select>
				</td>
				
			</tr>
		</table>
	</form>
</div>