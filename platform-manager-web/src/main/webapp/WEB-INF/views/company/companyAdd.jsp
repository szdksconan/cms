<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(function() {
		$('#companyAddForm').form({
			url : '${pageContext.request.contextPath}/company/add',
			onSubmit : function() {
				$('#json').val(JSON.stringify($.serializeObject($('#companyAddForm'))));
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
		
		$('#paperType').combobox({ 
		    url: '${pageContext.request.contextPath}/premium/selectTypeJson?pid=4',
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
<div class="easyui-layout" data-options="fit:true,border:false" >
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
		<form id="companyAddForm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="json" id="json"/>
			<input type="hidden" name="status" value="1"/>
			<input type="hidden" name="accountType" value="17"/>
			<input type="hidden" name="accountGrade" value="36"/>
			<input type="hidden" name="addType" value="32"/>
			<input type="hidden" name="identifyType" value="3"/>
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
			</table>
		</form>
	</div>
</div>