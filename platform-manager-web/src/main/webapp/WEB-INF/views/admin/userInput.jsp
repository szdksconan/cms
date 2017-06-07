<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script language="javascript" type="text/javascript">
$(function() {
	$('#userInputForm').form({
		url : '${ctx}/user/userInput',
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

	
	function setxzzs(data,x){
		var reg1 = /^[A-Za-z0-9\u4e00-\u9fa5]+$/;
		if(!reg1.test(data.value)){
			parent.$.messager.alert('提示','请重新输入1到'+x+'位数字、汉字、字母','warning');
		}
	}
	
	function setphone(data){
		var reg = /0?(13|14|15|18)[0-9]{9}/;
		if(!reg.test(data.value)){
			parent.$.messager.alert('提示','请输入正确的手机号码','warning');
		}
	}


	function uploadFile() {
		var fd = new FormData();
		fd.append("fileToUpload",
				document.getElementById('fileToUpload').files[0]);
		var xhr = new XMLHttpRequest();
		xhr.upload.addEventListener("progress", uploadProgress, false);
		xhr.addEventListener("load", uploadComplete, false);
		xhr.addEventListener("error", uploadFailed, false);
		xhr.addEventListener("abort", uploadCanceled, false);
		xhr.open("POST", "/Goods/ToLead");
		xhr.send(fd);
	}

	function uploadProgress(evt) {
		if (evt.lengthComputable) {
			var percentComplete = Math.round(evt.loaded * 100 / evt.total);
			$('#progressNumber').progressbar('setValue', percentComplete);
		} else {
			document.getElementById('progressNumber').innerHTML = '无法计算';
		}
	}

	function uploadComplete(evt) {
		/* 服务器返回数据*/
		var message = evt.target.responseText;

	}

	function uploadFailed(evt) {
		alert("上传出错.");
	}

	function uploadCanceled(evt) {
		alert("上传已由用户或浏览器取消删除连接.");
	}
	
	function inputFun(){
		var upfile = $("#upExcel").val();
		if(null == upfile || "" == upfile){
			parent.$.messager.alert('提示', "请选择上传文件！", 'warning');
			return;
		}
		$('#userInputForm').submit();
	}

</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">

			<div class="row" style="display: none;">
				<input type="file" name="fileToUpload" id="fileToUpload" multiple="multiple" onchange="fileSelected();" />
				<a id="uploadFile" style="display: none" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="uploadFile()"> 上传并导入</a>
			</div>

			<table class="grid" style="display: none;">
				<tr>
					<td>登录名</td>
					<td><input name="id" type="hidden"  value="${user.id}"/>
					<input id="lname" name="loginName" type="text" placeholder="默认为邮箱前缀" readonly="readonly" class="easyui-validatebox" style="background:transparent;border:0" data-options="required:true" value="${user.loginName}" /></td>
					<td>邮箱</td>
					<td><input name="email" type="text" placeholder="请输入邮箱" class="easyui-validatebox" data-options="required:true,validType:'email'" onchange="setlname(this);" value="${user.email}" /></td>
					
				</tr>
				<tr>
					<td>密码</td>
					<td colspan="3"><input type="text" name="loginPwd" class="easyui-validatebox" data-options="required:true,validType:'length[1,32]'"/></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input name="name" type="text" placeholder="请输入姓名" class="easyui-validatebox" onchange="setxzzs(this,32)" data-options="required:true,validType:'length[1,32]'" value="${user.name}"></td>
					<td>员工号</td>
					<td><input name="userNumber" type="text" placeholder="请输入登录名称" class="easyui-validatebox" onchange="setxzzs(this,30)" data-options="required:true,validType:'length[1,30]'" readonly="readonly" value="${user.userNumber}"></td>
				</tr>
				<tr>
					<td>手机号</td>
					<td><input name="phoneNumber" type="text" placeholder="请输入手机号" class="easyui-validatebox" onchange="setphone(this)" data-options="required:true,validType:'length[1,30]'" readonly="readonly" value="${user.phoneNumber }"></td>
					<td>性别</td>
					<td><select name="sex" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<c:forEach items="${sexList}" var="sexList">
							<option value="${sexList.key}" <c:if test="${sexList.key == user.sex}">selected="selected"</c:if>>${sexList.value}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>职位</td>
					<td><input name="position" type="text" placeholder="请输入职位" class="easyui-validatebox" onchange="setxzzs(this,30)" data-options="required:true,validType:'length[1,30]'" value="${user.position}"></td>
					<td>是否启用</td>
					<td><select name="isEnabled" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<c:forEach items="${enabledlist}" var="enabledlist">
							<option value="${enabledlist.key}" <c:if test="${enabledlist.key == user.isCheckWork}">selected="selected"</c:if>>${isCheckWorkList.value}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>部门</td>
					<td><select id="departmentId" name="departmentId" style="width: 140px; height: 29px;" class="easyui-validatebox" data-options="required:true"></select></td>
					<td>角色</td>
					<td><input  id="roleIds" name="roleIds" style="width: 140px; height: 29px;"/></td>
				</tr>
				<tr>
					<td>入职日期</td>
					<td><input name="entryDate" placeholder="点击选择入职时间" onclick="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" readonly="readonly" value="${user.entryDate}" /></td>
					<td>是否考勤</td>
					<td><select name="isCheckWork" class="easyui-combobox" data-options="width:140,height:29,editable:false,panelHeight:'auto'">
						<c:forEach items="${isCheckWorkList}" var="isCheckWorkList">
							<option value="${isCheckWorkList.key}" <c:if test="${isCheckWorkList.key == user.isCheckWork}">selected="selected"</c:if>>${isCheckWorkList.value}</option>
						</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>描述</td>
					<td colspan="3"><textarea rows="4" cols="40" name="description" class="textarea easyui-validatebox" data-options="required:true,validType:'length[1,255]'">${user.description }</textarea></td>
				</tr>
			</table>

			<div id="fileName" style="padding: 10px;display: none;"></div>
			<div id="fileSize" style="padding: 10px;display: none;"></div>
			<div id="fileType" style="padding: 10px;display: none;"></div>
			<div id="progressNumber" class="easyui-progressbar" style="width: 400px;display: none;"></div>

		<form id="userInputForm" method="post" enctype="multipart/form-data">
			<table data-options="fit:true,border:false" style="width: 100%">
				<tr>
					<td style="text-align: left;width: 70%">
						<input type="file" name="upExcel" id="upExcel" multiple="multiple" />
					</td>
					<td style="text-align: right;width: 30%">
						<a onclick="inputFun();" href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon_input'">导入</a>
					</td>
				</tr>
			</table>


		</form>
	</div>
</div>