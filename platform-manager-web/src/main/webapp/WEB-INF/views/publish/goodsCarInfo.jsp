<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>发布车源</title>
<script type="text/javascript">
$(function() {
  	$('#start').combobox({ 
	    url: '${ctx}/city/selectCityJson',
		mode: 'remote',
		valueField:'name', 
		textField:'name',
		panelHeight:true,
		editable:false,
		onHidePanel:function(){
			
		},
	    onSelect:function(rowData){
		    	$('#startId').val(rowData.id);
	    	}
	}); 
	$('#end').combobox({ 
	    url: '${ctx}/city/selectCityJson',
		mode: 'remote',
		valueField:'name', 
		textField:'name',
		panelHeight:true,
		editable:false,
		onHidePanel:function(){
			
		},
	    onSelect:function(rowData){
	    		$('#endId').val(rowData.id);
	    	}
	});
	$('#carInfoAddForm').form({
		url : '${ctx}/goodsCarInfo/add',
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
				parent.$.messager.alert('提示', result.msg, 'info');
				$('#carInfoAddForm')[0].reset();
			} else {
				parent.$.messager.alert('提示', result.msg, 'info');
			}
		}
	});
	
});
	function writeInfo(){
	
		var info=''
		var carLength = $('#carLength').val();
		var carWeight = $('#carWeight').val();
		var carAxles = $('#carAxles').val();
		var carDesc = $('#carDesc').val();
		if(carLength != ''){
			info += '长：'+carLength+'米；';
		}
		if(carWeight != ''){
			info += '载重：'+carWeight+'吨；';
		}
		if(carAxles != ''){
			info += '轴数：'+carAxles+'轴；';
		}
		if(carDesc != ''){
			info += '其他描述：'+carDesc+'；';
		}
		$('#carMainInfo').val(info);
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false" >
		<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
			<form id="carInfoAddForm" method="post" >
				<table class="grid">
					<tr>
						<td>出发地</td>
						<td>
							<input id="start" name="start"  type="text"
                                  />
                            <input id="startId"  name="startId" type="hidden"/>
						</td>
						<td>到达地</td>
						<td>
							<input name="end" id="end"  type="text"
                                  />
                            <input id="endId" name="endId" type="hidden"/>
						</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>车牌号</td>
						<td>
							<input name="carNo" id="carNo" type="text" />
						</td>
						<td>车厢长度</td>
						<td>
							<input name="carLength" id="carLength" type="text" onkeyup="writeInfo();" />
                         
						</td>
						<td colspan="2"></td>
					</tr>
					<tr>
						<td>载重</td>
						<td>
							<input name="carWeight" id="carWeight" type="text" onkeyup="writeInfo();" />
						</td>
						<td>轴数</td>
						<td>
							<input name="carAxles" id="carAxles" type="text" onkeyup="writeInfo();" />
						</td>
						<td>其他描述</td>
						<td>
							<input name="carDesc" id="carDesc" type="text"  onkeyup="writeInfo();"/>
						</td>
						
					</tr>
					<tr>
						<td>主要信息</td>
						<td colspan="6">
							<textarea name="carMainInfo" id="carMainInfo" rows="6" cols="150"></textarea>
						</td>
					</tr>
					<tr>
						<td>联系人姓名</td>
						<td>
							<input name="carLinkman" id="carLinkman" type="text"  class="easyui-validatebox " >
						</td>
						<td>联系电话1</td>
						<td>
							<input name="tel1" id="tel1" type="text"  class="easyui-validatebox " data-options="validType:'mobile'">
						</td>
						<td>联系电话2</td>
						<td>
							<input name="tel2" id="tel2" type="text"  class="easyui-validatebox " data-options="validType:'mobile'">
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