<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	
	$(function() {
		
		$('#carAddForm').form({
			url : '${ctx}/city/add',
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
		
		$('#pid').combobox({ 
		    url: '${ctx}/province/selectProvinceJson2',
			mode: 'remote',
			valueField:'id', 
			textField:'name',
			panelHeight:true,
			editable:false,
			onHidePanel:function(){
				
			},
		    onSelect:function(rowData){
		    	$('#lid').combobox({ 
				    url: '${ctx}/line/selectLineJson?pid='+rowData.id,
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
		    	$('#aid').combobox({ 
				    url: '${ctx}/area/selectAreaJson?pid='+rowData.id,
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
	
		$('#type').combobox({ 
		    url: '${ctx}/premium/selectTypeJson?pid=9',
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
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="carAddForm" method="post">
			<table class="grid">
					<tr>
					<td>车牌号</td>
					<td><input id="carNo"    name="carNo" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>车主姓名</td>
					<td><input id="carOwner"    name="carOwner" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>随车电话</td>
					<td><input id="carTel"    name="carTel" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>车型</td>
					<td><input id="carType"    name="carType" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>车长</td>
					<td><input id="carLength"    name="carLength" type="text"   style="background:transparent;border:0"></td>
					<td>载重</td>
					<td><input id="carWeigth"    name="carWeigth" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>体积</td>
					<td><input id="carVolume"    name="carVolume" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>身份证号</td>
					<td><input id="carCard"    name="carCard" type="text"   style="background:transparent;border:0"></td>
					<td>身份证照片上传</td>
					<td><input id="carCardUrl"    name="carCardUrl" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>驾驶证号</td>
					<td><input id="carCard2"    name="carCard2" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>驾驶证图片上传</td>
					<td><input id="carCard2Url"    name="carCard2Url" type="text"   style="background:transparent;border:0"></td>
					<td>行驶证号</td>
					<td><input id="carCard3"    name="carCard3" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>行驶证图片上传</td>
					<td><input id="carCard3Url"    name="carCard3Url" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>运输许可证号</td>
					<td><input id="carCard4"    name="carCard4" type="text"   style="background:transparent;border:0"></td>
					<td>运输许可证图片上传</td>
					<td><input id="carCard4Url"    name="carCard4Url" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>车辆图片上传</td>
					<td><input id="carPicUrl"    name="carPicUrl" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>车辆所在地</td>
					<td><input id="carAddress"    name="carAddress" type="text"   style="background:transparent;border:0"></td>
					<td>轮轴ID</td>
					<td><input id="carAxle"    name="carAxle" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>货箱结构ID</td>
					<td><input id="carContainer"    name="carContainer" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>线路文字描述</td>
					<td><input id="carLineDesc"    name="carLineDesc" type="text"   style="background:transparent;border:0"></td>
					<td>是否开通定位</td>
					<td><input id="carLocationTag"    name="carLocationTag" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>家庭地址</td>
					<td><input id="carAddress2"    name="carAddress2" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>固定电话</td>
					<td><input id="carTel2"    name="carTel2" type="text"   style="background:transparent;border:0"></td>
					<td>运输类型</td>
					<td><input id="carTrafficType"    name="carTrafficType" type="text"   style="background:transparent;border:0"></td>
					</tr>
					<tr>
					<td>经度</td>
					<td><input id="carLongitude"    name="carLongitude" type="text"   data-options="required:true,validType:['length[1,20]','enterName']"  class="easyui-validatebox" style="background:transparent;border:0"></td>
					<td>纬度</td>
					<td><input id="carLatitude"    name="carLatitude" type="text"   style="background:transparent;border:0"></td>
					</tr>
			</table>
		</form>
	</div>
</div>