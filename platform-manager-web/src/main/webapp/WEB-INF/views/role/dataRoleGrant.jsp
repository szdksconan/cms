<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	var subTree;
	$(function() {
		subTree = $('#subTree').tree({
			url : '${ctx}/subCompany/tree',
			parentField : 'pid',
			lines : true,
			checkbox : true,
			onLoadSuccess : function(node, data) {
				progressLoad();
				var ids = $.stringToList("${dataRole.subIds}");
				if (ids.length > 0) {
					for ( var i = 0; i < ids.length; i++) {
						var child = subTree.tree('find', ids[i]);
						if (child){
							var children = child.children;
							if(children == null || children == undefined){//当该节点没有子节点时设置选择状态
								subTree.tree('check', subTree.tree('find', ids[i]).target);
							}
						}
					}
				}
				progressClose();
			},
			cascadeCheck : true
		});

		$('#dataRoleGrantForm').form({
			url : '${ctx}/dataRole/grant',
			onSubmit : function() {
				var dataType = $('input:radio[name="dataType"]:checked').val();
				$('#dataRightsType').val(dataType);
				progressLoad();
				var isValid = $(this).form('validate');
				if (!isValid) {
					progressClose();
				}
				//var checknodes = subTree.tree('getChecked');
				//获取被选中的节点 包括模糊不清楚的，及父节点的子节点未被选中时 也要包含父节点
				var checknodes = subTree.tree('getChecked',['checked','indeterminate']);
				//alert(checknodes1)
				var ids = [];
				if (checknodes && checknodes.length > 0) {
					for ( var i = 0; i < checknodes.length; i++) {
						ids.push(checknodes[i].id);
					}
				}
				$('#subIds').val(ids);
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

	function checkAll() {
		var nodes = subTree.tree('getChecked', 'unchecked');
		if (nodes && nodes.length > 0) {
			for ( var i = 0; i < nodes.length; i++) {
				subTree.tree('check', nodes[i].target);
			}
		}
	}
	function uncheckAll() {
		var nodes = subTree.tree('getChecked');
		if (nodes && nodes.length > 0) {
			for ( var i = 0; i < nodes.length; i++) {
				subTree.tree('uncheck', nodes[i].target);
			}
		}
	}
	function checkInverse() {
		var unchecknodes = subTree.tree('getChecked', 'unchecked');
		var checknodes = subTree.tree('getChecked');
		if (unchecknodes && unchecknodes.length > 0) {
			for ( var i = 0; i < unchecknodes.length; i++) {
				subTree.tree('check', unchecknodes[i].target);
			}
		}
		if (checknodes && checknodes.length > 0) {
			for ( var i = 0; i < checknodes.length; i++) {
				subTree.tree('uncheck', checknodes[i].target);
			}
		}
	}
</script>
<div id="roleGrantLayout" class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'west'" title="系统资源" style="width: 300px; padding: 1px;">
		<div class="well well-small">
			<form id="dataRoleGrantForm" method="post">
				<input name="id" type="hidden"  value="${dataRole.id}" readonly="readonly"/>
				<input id="dataRightsType" name="dataRightsType" type="hidden" />
				<ul id="subTree"></ul>
				<input id="subIds" name="subIds" type="hidden" />
			</form>
		</div>
	</div>
	<div data-options="region:'center'" title="" style="overflow: hidden; padding: 10px;">
		<div>
			<button class="btn btn-success" onclick="checkAll();">全选</button>
			<br /> <br />
			<button class="btn btn-warning" onclick="checkInverse();">反选</button>
			<br /> <br />
			<button class="btn btn-inverse" onclick="uncheckAll();">取消</button>
		</div>
	</div>
</div>