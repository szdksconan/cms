<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	

	$(function() {
		
		$('#pid').combotree({
			url : '${ctx}/baseDic/allTree?flag=true',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto'
		});
		
		$('#orderDicAddForm').form({
			url : '${ctx}/baseDic/add',
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
					parent.$.modalDialog.openner_treeGrid.treegrid('reload');//之所以能在这里调用到parent.$.modalDialog.openner_treeGrid这个对象，是因为access.jsp页面预定义好了
					//parent.layout_west_tree.tree('reload');
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
		
	});
	
	function setxzzs(data,x){
		var reg1 = /^[A-Za-z0-9\u4e00-\u9fa5]+$/;
		if(!reg1.test(data.value)){
			parent.$.messager.alert('提示','请重新输入1到'+x+'位数字、汉字、字母','warning');
		}
	}
	
	function seturl(data,x){
		var reg = /^\/([0-9a-zA-Z]+)+$/;
		if(!reg.test(data.value)){
			parent.$.messager.alert('提示','请输入正确的连接地址','warning');
		}
	}
</script>
<div style="padding: 3px;">
	<form id="orderDicAddForm" method="post">
		<table class="grid">
			<tr>
				<td>编号</td>
				<td><input name="dicno" class="easyui-validatebox" data-options="required:true,validType:['length[1,32]','nonChinese']" style="background:transparent;border:0" ></td>
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