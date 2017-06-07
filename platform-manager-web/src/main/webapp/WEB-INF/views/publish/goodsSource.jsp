<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>发布货源</title>
<script type="text/javascript">
$(function() {
	$('#goodsSourceAddForm').form({
		url : '${ctx}/goodsSource/add',
		onSubmit : function() {
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
				parent.$.messager.alert('提示', result.msg, 'info');
				$('#goodsSourceAddForm')[0].reset();
			} else {
				parent.$.messager.alert('提示', result.msg, 'info');
			}
		}
	});
	
	$('#orderDicId').combobox({
	    url: '${ctx}/orderDic/selectTypeJson?pid=5',
		mode: 'remote',
		valueField:'id', 
		textField:'name',
		panelHeight:true,
		editable:false,
		onSelect:function(){
			updateInfo();
		},
		onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            for (var item in val[0]) {
                if (item == "id") {
                    $(this).combobox("select", val[0][item]);
                }
            }
        }
	});
	
	$('#unit').combobox({
	    url: '${ctx}/orderDic/selectTypeJson?pid=1',
		mode: 'remote',
		valueField:'id', 
		textField:'name',
		panelHeight:true,
		editable:false,
		onSelect:function(){
			updateInfo();
		},
		onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            for (var item in val[0]) {
                if (item == "id") {
                    $(this).combobox("select", val[0][item]);
                }
            }
        }
	});
	
	$('#validTime').combobox({
	    url: '${ctx}/baseDic/selectTypeJson?pid=11',
		mode: 'remote',
		valueField:'name', 
		textField:'name',
		panelHeight:true,
		editable:false,
		onSelect:function(){
			updateInfo();
		},
		onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            for (var item in val[0]) {
                if (item == "id") {
                    $(this).combobox("select", val[0].name);
                }
            }
        }
	});
	
	$('#weight').bind('input propertychange', function() {
		updateInfo();
	}); 
	$('#startAddName').bind('input propertychange', function() {
		updateInfo();
	}); 
	$('#endAddName').bind('input propertychange', function() {
		updateInfo();
	}); 
});

function updateInfo(){
	$('#info').val($('#orderDicId').combobox('getText')+";"+$('#weight').val()+$('#unit').combobox('getText')+";"+$('#startAddName').val()+";"+$('#endAddName').val()+";");
}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false" >
		<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
			<form id="goodsSourceAddForm" method="post" enctype="multipart/form-data">
				<table class="grid">
					<tr>
						<td>货物名称</td>
						<td><input name="orderDicId" id="orderDicId" type="text"  class="easyui-combobox"></td>
						<td>单位</td>
						<td><input name="unit" id="unit" type="text" class="easyui-combobox"></td>
						<td>重量</td>
						<td><input name="weight" id="weight" type="text" placeholder="请输入重量"  class="easyui-validatebox span2" data-options="required:true,validType:'number'"></td>
					</tr>
					<tr>
						<td>出发地</td>
						<td>
							<input name="startAdd" id="startAddName" class="input6"
                                   onclick="showProvince(this, 'startAddName','startAdd',1, true, event,null,'updateInfo()');" type="text">
                            <input id="startAdd" type="hidden">
						</td>
						<td>到达地</td>
						<td>
							<input name="endAdd" id="endAddName" class="input6"
                                   onclick="showProvince(this, 'endAddName','endAdd',1, true, event,null,'updateInfo()');" type="text">
                            <input id="endAdd" type="hidden">
						</td>
						<td>有效时间</td>
						<td>
							<select name="validTime" id="validTime" class="easyui-combobox" style="width:100px">
							</select>小时
						</td>
					</tr>
					<tr>
						<td>主要信息</td>
						<td colspan="6">
							<textarea name="info" id="info" rows="6" cols="150"></textarea>
						</td>
					</tr>
					<tr>
						<td>联系电话1</td>
						<td>
							<input name="tel1" id="tel1" type="text"  class="easyui-validatebox span2" data-options="validType:'mobile'">
						</td>
						<td>联系电话2</td>
						<td>
							<input name="tel2" id="tel2" type="text"  class="easyui-validatebox span2" data-options="validType:'mobile'">
						</td>
					</tr>
					<tr>
						<td colspan="6" align="center"><input type="submit" value="提交" style="width: 5%"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>