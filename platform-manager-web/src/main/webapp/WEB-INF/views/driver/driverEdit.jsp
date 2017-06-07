<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		$('#driverEditForm').form({
			url : '${ctx}/driver/edit',
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

</script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="driverEditForm" method="post">
			<input type="hidden" id="id" name="id" value="${driverBean.id }"/>
			<input type="hidden" id="state" name="state" value="${driverBean.state }"/>
			<table class="grid">
				
				<tr>
					<td>登录名</td>
					<td><input id="login"  name="login" readonly="readonly" value="${driverBean.login }" type="text"  class="easyui-validatebox" data-options="required:true" style="background:transparent;border:0" ></td>
					<td>姓名</td>
					<td><input id="name" name="name" value="${driverBean.name }" type="text"  class="easyui-validatebox" data-options="required:true" style="background:transparent;border:0" ></td>
					
				</tr>
				<tr>
					<td>移动电话</td>
					<td><input id="tel1" name="tel1" value="${driverBean.tel1 }" type="text"  class="easyui-validatebox" data-options="required:true,validType:'mobile'"  style="background:transparent;border:0" ></td>
					<td>固定电话</td>
					<td><input id="tel2" name="tel2" value="${driverBean.tel2 }" type="text"  class="easyui-validatebox" style="background:transparent;border:0" ></td>
				</tr>
				<tr>
					<td>身份证号</td>
					<td><input id="cardNo1" name="cardNo1" value="${driverBean.cardNo1 }"   class="easyui-validatebox" data-options="required:true,validType:['length[1,30]','nonChinese']" style="background:transparent;border:0"></input></td>
					<td>驾驶证号</td>
					<td><input id="cardNo2"  name="cardNo2" value="${driverBean.cardNo2 }"  class="easyui-validatebox" data-options="required:true,validType:['length[1,30]','nonChinese']" style="background:transparent;border:0" ></input></td>
				</tr>
				<tr>
					<td>联系地址</td>
					<td><input id="address" name="address" value="${driverBean.address }"   class="easyui-validatebox"  style="background:transparent;border:0"></input></td>
					<td>邮箱</td>
					<td><input id="email"  name="email" value="${driverBean.email }"   class="easyui-validatebox" data-options="validType:'emailx'" style="background:transparent;border:0" ></input></td>
				</tr>
					<tr>
					<td>QQ</td>
					<td colspan="3"><input id="qq" name="qq" value="${driverBean.qq }"   class="easyui-validatebox" data-options="validType:'QQ'"  style="background:transparent;border:0"></input></td>
				</tr>
			</table>
		</form>
	</div>
</div>