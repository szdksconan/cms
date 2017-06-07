<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>企业管理</title>
<script type="text/javascript">
$(function() {
	
	$('#companyAddForm').form({
		url : '${ctx}/company/register',
		onSubmit : function() {
			var endAdd = '';
			$("input[name='endAdd1']").each(function(){
				if ($(this).val()!=''){
					endAdd +=$(this).val()+",";
				}
			});
			if (endAdd!=''){
				endAdd = endAdd.substr(0,endAdd.length-1);
			}
			$('#endAdd').val(endAdd);
			$('#json').val(JSON.stringify($.serializeObject($('#companyAddForm'))));
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
				$('#companyAddForm')[0].reset();
			} else {
				parent.$.messager.alert('提示', result.msg, 'info');
			}
		}
	});
	
	$('#paperType').combobox({ 
	    url: '${ctx}/premium/selectTypeJson?pid=4',
		mode: 'remote',
		valueField:'id', 
		textField:'name',
		panelHeight:true,
		editable:false,
		onHidePanel:function(){
			
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
});
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit:true,border:false" >
		<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
			<form id="companyAddForm" method="post" enctype="multipart/form-data">
				<input type="hidden" name="json" id="json"/>
				<input type="hidden" name="accountType" value="17"/>
				<input type="hidden" name="accountGrade" value="36"/>
				<input type="hidden" name="addType" value="32"/>
				<input type="hidden" name="identifyType" value="3"/>
				<input type="hidden" name="endAdd" id="endAdd"/>
				<table class="grid">
					<tr>
						<td>企业名称</td>
						<td><input name="companyName" id="companyName" type="text" placeholder="请输入企业名称"  class="easyui-validatebox span2" data-options="required:true,validType:['length[1,100]','enterName']"></td>
						<td>工商执照编号</td>
						<td><input name="companyNo" id="companyNo" type="text" placeholder="请输入工商执照编号"  class="easyui-validatebox span2" data-options="required:true,validType:['length[1,100]','enterName']"></td>
					</tr>
					<tr>
						<td>联系人</td>
						<td><input name="companyLinkman" id="companyLinkman" type="text" placeholder="请输入企业联系人"  class="easyui-validatebox span2" data-options="required:true,validType:['length[1,100]','enterName']"></td>
						<td>联系电话</td>
						<td><input name="companyId" id="companyId" type="text" placeholder="请输入联系电话"  class="easyui-validatebox span2" data-options="required:true,validType:['length[1,20]','number']"></td>
					</tr>
					<tr>
						<td>证件类型</td>
						<td>
							<select name="paperType" id="paperType" class="easyui-combobox" style="width:100px">
							</select>
						</td>
						<td>证件编号</td>
						<td>
							<input name="paperNo" id="paperNo" type="text" class="easyui-validatebox span2" data-options="required:true,validType:['length[1,50]','enterName']"/>
						</td>
					</tr>
					<tr>
						<td>证件照</td>
						<td colspan="3">
							<input type="file" name="paperPic" accept="image/gif,image/jpeg,image/png">
						</td>
					</tr>
					<tr>
						<td>企业地址</td>
						<td><input name="companyAdd" id="companyAdd" type="text" placeholder="请输入企业地址"  class="easyui-validatebox span2"></td>
						<td>物流园</td>
						<td><input name="companyGarden" id="companyGarden" type="text" class="easyui-validatebox span2"></td>
					</tr>
					<tr>
						<td>营业执照</td>
						<td colspan="3">
							<input type="file" name="industryPic" accept="image/gif,image/jpeg,image/png">
						</td>
					</tr>
					<tr>
						<td>门头照</td>
						<td colspan="3">
							<input type="file" name="companyPic" accept="image/gif,image/jpeg,image/png">
						</td>
					</tr>
					<tr>
						<td>出发地</td>
						<td colspan="3">
							<input name="beginAdd" id="3Area_cityName"  class="input6"
                                   onclick="showProvince(this, '3Area_cityName','3Area_cityId',1, true, event);" type="text">
                            <input id="3Area_cityId" type="hidden">
						</td>
					</tr>
					<tr>
						<td>到达地</td>
						<td colspan="3">
							<table style="width: 100%;border: 0px;">
								<tr><td>
									<input name="endAdd1" id="4Area_cityName"  class="input6"
                                           onclick="showProvince(this, '4Area_cityName','4Area_cityId',1, true, event);" type="text">
                                    <input id="4Area_cityId" type="hidden">
								</td></tr>
								<tr><td>
									<input name="endAdd1" id="5Area_cityName"  class="input6"
                                           onclick="showProvince(this, '5Area_cityName','5Area_cityId',1, true, event);" type="text">
                                    <input id="5Area_cityId" type="hidden">
								</td></tr>
								<tr><td>
									<input name="endAdd1" id="6Area_cityName"  class="input6"
                                           onclick="showProvince(this, '6Area_cityName','6Area_cityId',1, true, event);" type="text">
                                    <input id="6Area_cityId" type="hidden">
								</td></tr>
								<tr><td>
									<input name="endAdd1" id="Area_cityName_5"  class="input6"
                                           onclick="showProvince(this, 'Area_cityName_5','Area_cityId_5',1, true, event);" type="text">
                                    <input id="Area_cityId_5" type="hidden">
								</td></tr>
								<tr><td>
									<input name="endAdd1" id="Area_cityName_0"  class="input6"
                                           onclick="showProvince(this, 'Area_cityName_0','Area_cityId_0',1, true, event);" type="text">
                                    <input id="Area_cityId_0" type="hidden">
								</td></tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="submit" value="提交" style="width: 5%"/></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>