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
		
		$('#pname').combobox({ 
		    url: '${pageContext.request.contextPath}/province/selectProvinceJson2',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
		    	$('#aname').combobox({ 
				    url: '${pageContext.request.contextPath}/area/selectAreaJson?pid='+rowData.id,
					mode: 'remote',
					valueField:'id', 
					textField:'name',
					panelHeight:true,
					editable:false,
					onHidePanel:function(){
						
					},
				    onSelect:function(rowData){
				    	$('#cname').combobox({ 
						    url: '${pageContext.request.contextPath}/city/selectCityJson2?pid='+$('#pname').combobox('getValue')+'&pid2='+rowData.id,
							mode: 'remote',
							valueField:'id', 
							textField:'name',
							panelHeight:true,
							editable:false,
							onHidePanel:function(){
								
							},
						    onSelect:function(rowData){
							    	
						    	}
						}); 
				    	}
				}); 
		    	
		    	}
		}); 
		
		$('#companyType').combobox({ 
		    url: '${pageContext.request.contextPath}/premium/selectTypeJson?pid=3',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	
		    	}
		}); 
		
		$('#checkType').combobox({ 
		    url: '${pageContext.request.contextPath}/premium/selectTypeJson?pid=1',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	
		    	}
		}); 
		$('#joinType').combobox({ 
		    url: '${pageContext.request.contextPath}/premium/selectTypeJson?pid=5',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	
		    	}
		}); 

		$('#paperType').combobox({ 
		    url: '${pageContext.request.contextPath}/premium/selectTypeJson?pid=4',
			mode: 'remote',
			valueField:'dicno', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
			    	
		    	}
		}); 
		
	});
</script>
<div class="easyui-layout" data-options="fit:true,border:false" >
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
		<form id="companyAddForm" method="post" enctype="multipart/form-data">
			<input type="hidden" name="json" id="json"/>
			<input type="hidden" name="accountType" value="17"/>
			<input type="hidden" name="accountGrade" value="36"/>
			<input type="hidden" name="addType" value="32"/>
			<input type="hidden" name="identifyType" value="3"/>
			<table class="grid">
				<tr>
					<td>账户ID</td>
					<td><input name="id" id="id" type="text" placeholder="请输入手机号"  class="easyui-validatebox span2" data-options="required:true,validType:['length[1,100]','enterName']"></td>
					<td>账号类型</td>
					<td><input name="companyType" id="companyType" type="text" ></td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>企业注册地</td>
					<td>
						<input id='pname' name='pname' style="width: 60px;"/>
						<input id='aname' name='aname'  class="easyui-combobox" style="width: 60px;" />
						<input id='cname' name='cname' class="easyui-combobox" style="width: 60px;" />
					</td>
					<td>注册日期</td>
					<td><input name="companyCreateDate" id="companyCreateDate" type="text"   class="easyui-datebox" ></td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>认证类型</td>
					<td><input name="checkType" id="checkType" /></td>
					<td>加入平台方式</td>
					<td><input name="joinType" id="joinType" /></td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>账号资金</td>
					<td><input name="companyMoney" id="companyMoney" type="text"   class="easyui-validatebox span2" data-options="validType:'money'"></td>
					<td>账号状态</td>
					<td><input name="status" id="status" type="text"  ></td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>物流园</td>
					<td colspan="5"><input name="companyGarden" id="companyGarden" type="text"   class="easyui-validatebox span2" style="width: 425px;" data-options="validType:['length[1,100]','enterName']"></td>
				</tr>
				<tr>
					<td>公司名称</td>
					<td colspan="5"><input name="companyName" id="companyName" type="text"   class="easyui-validatebox span2" style="width: 425px;" data-options="validType:['length[1,100]','enterName']"></td>
				</tr>
				<tr>
					<td>公司地址全称</td>
					<td colspan="5"><input name="companyAdd" id="companyAdd" type="text"   class="easyui-validatebox span2" style="width: 425px;" data-options="validType:['length[1,100]','enterName']"></td>
				</tr>
				<tr>
					<td>地址经度</td>
					<td><input name="longitude" id="longitude" type="text"   class="easyui-validatebox span2" data-options="validType:['length[1,100]','enterName']"></td>
					<td>地址纬度</td>
					<td><input name="latitude" id="latitude" type="text"  class="easyui-validatebox span2" data-options="validType:['length[1,100]','enterName']"></td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<td>联系人</td>
					<td><input name="companyLinkman" id="companyLinkman" type="text"   class="easyui-validatebox span2" data-options="required:true,validType:['length[1,100]','enterName']"></td>
					<td>固定电话</td>
					<td><input name="companyContactnum" id="companyContactnum" type="text"  class="easyui-validatebox span2" data-options="required:true,validType:['length[1,100]','enterName']"></td>
					<td>紧急电话</td>
					<td><input name="companyTel1" id="companyTel1" type="text"  class="easyui-validatebox span2" data-options="validType:['length[1,100]','enterName']"></td>
				</tr>
					<tr>
					<td>证件类型</td>
					<td>
						<select name="paperType" id="paperType" class="easyui-combobox" style="width:100px">
						</select>
					</td>
					<td>证件编号</td>
					<td colspan="3">
						<input name="paperNo" id="paperNo" type="text" class="easyui-validatebox span2" data-options="required:true,validType:['length[1,50]','enterName']"/>
						<input type="file" name="paperPic" accept="image/gif,image/jpeg,image/png">
					</td>
				
				</tr>
				<tr>
					<td>营业执照</td>
					<td colspan="5">
						<input name="companyNo" id="companyNo" type="text" class="easyui-validatebox span2" data-options="required:true,validType:['length[1,50]','enterName']"/>
						<input type="file" name="industryPic" accept="image/gif,image/jpeg,image/png">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>