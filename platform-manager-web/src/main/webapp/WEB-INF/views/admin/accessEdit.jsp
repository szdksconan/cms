<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	

	$(function() {
		
		$('#pid').combotree({
			url : '${ctx}/access/tree',
			parentField : 'pid',
			lines : true,
			panelHeight : 'auto'
		});
		
		$('#systemId').combobox({
			url: '${ctx}/premium/selectTypeJson?pid=10',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			value:'${access.systemId}',
			onLoadSuccess: function () { //加载完成后,设置选中第一项
	        }
		});
		
		if ($(':input[name="id"]').val().length > 0) {
			$.post( '${ctx}/access/get', {
				id : $(':input[name="id"]').val(),
			}, function(result) {
				if (result.id != undefined) {
					$('form').form('load', {
						'id' : result.id,
						'name' : result.name,
						'url' : result.url,
						'accessType' : result.accessType,
						'description' : result.description,
						'icon' : result.icon,
						'seq' : result.seq,
						'status':result.cstate
					});
					$('#pid').combotree('setValue',result.pid);
				}
			}, 'json');
		}
		
		$('#accessEditForm').form({
			url : '${pageContext.request.contextPath}/access/edit',
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
					parent.layout_west_tree.tree('reload');
					parent.$.modalDialog.handler.dialog('close');
				}
			}
		});
		
	});
	
	
</script>
<div style="padding: 3px;">
	<form id="accessEditForm" method="post">
		<table  class="grid">
			<tr>
				<td>资源名称</td>
				<td><input name="id" type="hidden"  value="${access.id}" >
				<input name="name" type="text" placeholder="请输入资源名称" class="easyui-validatebox span2" data-options="required:true,validType:'length[1,16]'" ></td>
				<td>资源类型</td>
				<td><select name="accessType" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
					<option value="0">菜单</option>
					<option value="1">按钮</option>
				</select></td>
			</tr>
			<tr>
				<td>资源路径</td>
				<td><input name="url" type="text" placeholder="请输入资源路径" onchange="seturl()" class="easyui-validatebox span2" data-options="validType:'route'"></td>
				<td>排序</td>
				<td><input name="seq"  class="easyui-numberspinner" style="width: 140px; height: 29px;" required="required" data-options="editable:false"></td>
			</tr>
			<tr>
				<td>菜单图标</td>
				<td ><input  name="icon" class="easyui-validatebox" data-options="validType:'length[1,20]'" /></td>
				<td>所属系统</td>
				<td >
					<select id="systemId" name="systemId" style="width: 200px; height: 29px;"></select>
				</td>
			</tr>
			<tr>
				<td>上级资源</td>
				<td colspan="3"><select id="pid" name="pid" style="width: 200px; height: 29px;"></select>
				<a class="easyui-linkbutton" href="javascript:void(0)" onclick="$('#pid').combotree('clear');" >清空</a></td>
			</tr>
			<tr>
				<td>备注</td>
				<td colspan="3"><textarea name="description" maxlength="255" rows="5" cols="50" class="easyui-validatebox" data-options="validType:'length[1,255]'" ></textarea></td>
			</tr>
		</table>
	</form>
</div>
