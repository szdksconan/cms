<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../inc.jsp"></jsp:include>
<meta http-equiv="X-UA-Compatible" content="edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户中心</title>
<script type="text/javascript">
$(function() {
	var id=1;
	
	$('#btn1').click(function(){
		$.post('${ctx}/loginUser/update', {
			id : $('#id').val(),name:$('#name').val(),sex:$('#sex').val(),type:1
		}, function(result) {
			parent.$.messager.alert('提示', result.msg, 'info');
			progressClose();
		}, 'JSON');
	});
	$('#btn2').click(function(){
		$.post('${ctx}/loginUser/update', {
			id : $('#id').val(),tel1:$('#tel1').val(),tel2:$('#tel2').val(),type:2
		}, function(result) {
			parent.$.messager.alert('提示', result.msg, 'info');
			progressClose();
		}, 'JSON');
	});
	$('#btn3').click(function(){
		if ($('#newloginPwd').val()!=$('#confirmloginPwd').val()){
			parent.$.messager.alert('提示', '确认密码不正确！', 'info');
			return ;
		}
		$.post('${ctx}/loginUser/update', {
			id : $('#id').val(),oldloginPwd:$('#oldloginPwd').val(),newloginPwd:$('#newloginPwd').val(),type:3,loginPwd:$('#loginPwd').val()
		}, function(result) {
			parent.$.messager.alert('提示', result.msg, 'info');
			progressClose();
		}, 'JSON');
	});
	$('#btn4').click(function(){
		if ($('#newpayPwd').val()!=$('#comfirmpayPwd').val()){
			parent.$.messager.alert('提示', '确认密码不正确！', 'info');
			return ;
		}
		$.post('${ctx}/loginUser/update', {
			id : $('#id').val(),newpayPwd:$('#newpayPwd').val(),oldpayPwd:$('#oldpayPwd').val(),type:4,payPwd:$('#payPwd').val()
		}, function(result) {
			parent.$.messager.alert('提示', result.msg, 'info');
			progressClose();
		}, 'JSON');
	});
	
	$('.info_1').show();
	$('.info_2').hide();
	$('.info_3').hide();
	$('.info_4').hide();
	$('#tt1').tabs({
	 	border:false,
	    onSelect:function(title){
	    	id = getTabId(title);
	    	if (id==1){
	    		$('.info_1').show();
	    		$('.info_2').hide();
	    		$('.info_3').hide();
	    		$('.info_4').hide();
	    	}else if (id==2){
	    		$('.info_1').hide();
	    		$('.info_2').show();
	    		$('.info_3').hide();
	    		$('.info_4').hide();
	    	}else if (id==3){
	    		$('.info_1').hide();
	    		$('.info_2').hide();
	    		$('.info_3').show();
	    		$('.info_4').hide();
	    	}else if (id==4){
	    		$('.info_1').hide();
	    		$('.info_2').hide();
	    		$('.info_3').hide();
	    		$('.info_4').show();
	    	}
	    }
	});
});

function getTabId(title){
	var id;
	$("#queryType option").each(function(){
		if($(this).text() == title){
			id = $(this).val();
		}
	});
	return id;
}

</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<select id="queryType" name="queryType" style="display: none;">
			<option value="1">修改个人资料</option>
			<option value="2">修改联系方式</option>
			<option value="3">修改登录密码</option>
			<option value="4">修改支付密码</option>
	</select>
	
	<div style="height: 64px; overflow: hidden;background-color: #f4f4f4">
		<div id="tt1" class="easyui-tabs task-header-one" >
	    	<div title="修改个人资料" style="overflow:auto;display:none;">
      		 </div>
      		 <div title="修改联系方式" style="overflow:auto;display:none;">
      		 </div>
      		 <div title="修改登录密码" style="overflow:auto;display:none;">
      		 </div>
      		 <div title="修改支付密码" style="overflow:auto;display:none;">
      		 </div>
		</div>
	</div>
	
	<div>
		<input type="hidden" id="loginPwd" name="loginPwd" value="${info.loginPwd}"/>
		<input type="hidden" id="payPwd" name="payPwd" value="${info.payPwd}"/>
		<input type="hidden" name="id" id="id" value="${info.id}"/>
		<div class="info_1">
			<table>
				<tr>
					<td>姓名</td>
					<td><input id="name" name="name" type="text"  class="easyui-validatebox" style="background:transparent;" value="${info.name}"></td>
				</tr>
				<tr class="info_1">
					<td>性别</td>
					<td>
						<select name="sex" id="sex" class="easyui-validatebox" data-options="panelHeight:true,editable:false">
							<option value="0" <c:if test="${info.sex==0}">selected="selected"</c:if>>男</option>
							<option value="1" <c:if test="${info.sex==1}">selected="selected"</c:if>>女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input id="btn1" type="button" value="保存" onclick="updateInfo()"/>
					</td>
				</tr>
			</table>
		</div>
		<div class="info_2">
			<table>
				<tr>
					<td>手机1</td>
					<td><input id="tel1" name="tel1" type="text"  class="easyui-validatebox" style="background:transparent;" value="${info.tel1}"></td>
				</tr>
				<tr class="info_2">
					<td>手机2</td>
					<td><input id="tel2" name="tel2" type="text"  class="easyui-validatebox" style="background:transparent;" value="${info.tel2}"></td>
				</tr>
				<tr>
					<td>
						<input id="btn2" type="button" value="保存" onclick="updateTel()"/>
					</td>
				</tr>
			</table>
		</div>
		<div class="info_3">
			<table>
				<tr>
					<td>原始密码</td>
					<td colspan="3"><input id="oldloginPwd" name="oldloginPwd" type="password" placeholder="请输入密码" class="easyui-validatebox" style="background:transparent;" data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
					<td>新密码</td>
					<td colspan="3"><input id="newloginPwd" name="newloginPwd" type="password" placeholder="请输入密码" class="easyui-validatebox" style="background:transparent;" data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
					<td>确认密码</td>
					<td colspan="3"><input id="confirmloginPwd" name="confirmloginPwd" type="password" placeholder="请输入密码" class="easyui-validatebox" style="background:transparent;" data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
				</tr>
				<tr>
					<td>
						<input id="btn3" type="button" value="保存" onclick="updateLoginPwd()"/>
					</td>
				</tr>
			</table>
		</div>
		<div class="info_4">
			<table>
				<tr>
					<td>原始密码</td>
					<td colspan="3"><input id="oldpayPwd" name="oldpayPwd" type="password" placeholder="请输入密码" class="easyui-validatebox" style="background:transparent;" data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
					<td>新密码</td>
					<td colspan="3"><input id="newpayPwd" name="newpayPwd" type="password" placeholder="请输入密码" class="easyui-validatebox" style="background:transparent;" data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
					<td>确认密码</td>
					<td colspan="3"><input id="comfirmpayPwd" name="comfirmpayPwd" type="password" placeholder="请输入密码" class="easyui-validatebox" style="background:transparent;" data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
				</tr>
				<tr>
					<td>
						<input id="btn4" type="button" value="保存" onclick="updatePayPwd()"/>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>