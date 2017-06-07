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
<title>司机注册</title>
<script type="text/javascript">
$(function() {
	$('#driverAddForm').form({
		url : '${ctx}/driver/register',
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
				$('#driverAddForm')[0].reset();
			} else {
				parent.$.messager.alert('提示', result.msg, 'info');
			}
		}
	});

});
</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div class="easyui-layout" data-options="fit:true,border:false">
		<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
			<form id="driverAddForm" method="post">
				<table class="grid">
					<tr>
						<td>登录名</td>
						<td><input id="login" name="login" type="text" placeholder="请输入手机号" class="easyui-validatebox" data-options="required:true" style="background:transparent;border:0;width: 100%;" ></td>
						<td>姓名</td>
						<td><input id="name" name="name" type="text"  class="easyui-validatebox" data-options="required:true" style="background:transparent;border:0;width: 100%;" ></td>
						
					</tr>
					<tr>
						<td>移动电话</td>
						<td><input id="tel1" name="tel1" type="text"  class="easyui-validatebox" data-options="required:true"  style="background:transparent;border:0;width: 100%;" ></td>
						<td>固定电话</td>
						<td><input id="tel2" name="tel2" type="text"  class="easyui-validatebox" style="background:transparent;border:0;width: 100%;" ></td>
					</tr>
					<tr>
						<td>身份证号</td>
						<td><input id="cardNo1" name="cardNo1"   class="easyui-validatebox" data-options="required:true" style="background:transparent;border:0;width: 100%;"></input></td>
						<td>驾驶证号</td>
						<td><input id="cardNo2"  name="cardNo2"   class="easyui-validatebox" data-options="required:true" style="background:transparent;border:0;width: 100%;" ></input></td>
					</tr>
					<tr>
						<td>联系地址</td>
						<td><input id="address" name="address"   class="easyui-validatebox"  style="background:transparent;border:0;width: 100%;"></input></td>
						<td>邮箱</td>
						<td><input id="email"  name="email"   class="easyui-validatebox" style="background:transparent;border:0;width: 100%;" ></input></td>
					</tr>
					<tr>
						<td>QQ</td>
						<td colspan="3"><input id="qq" name="qq"   class="easyui-validatebox"  style="background:transparent;border:0;width: 100%;"></input></td>
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