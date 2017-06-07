<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$(function() {
		<%--$('#stationId').combobox({--%>
		    <%--url: '${ctx}/station/getStationList',--%>
			<%--mode: 'remote',--%>
			<%--valueField:'id', --%>
			<%--textField:'name',--%>
			<%--panelHeight:true,--%>
			<%--editable:false,--%>
			<%--onLoadSuccess: function () { //加载完成后,设置选中第一项--%>
				<%--var val = $(this).combobox("getData");--%>
	            <%--for (var item in val[0]) {--%>
	                <%--if (item == "id") {--%>
	                    <%--$(this).combobox("select", val[0][item]);--%>
	                <%--}--%>
	            <%--}--%>
	        <%--}--%>
		<%--});--%>
		
		<%--$('#subcompanyId').combotree({--%>
 			<%--url : '${ctx}/subCompany/tree',--%>
 			<%--parentField : 'pid',--%>
 			<%--valueField:'id',--%>
			<%--lines : true,--%>
 			<%--panelHeight:true,--%>
			<%--editable:false,--%>
			<%--value : '${userBean.subcompanyId}',--%>
			<%--onSelect : function(node){--%>
				<%--$.ajax({--%>
			        <%--type: "POST",--%>
			        <%--url : '${ctx}/department/getDepartmentList?json={"subcompanyId":"'+node.id+'"}',--%>
			        <%--cache: true,--%>
			        <%--dataType : "json",--%>
			        <%--success: function(data){--%>
			        	<%--$("#departmentId").combobox("clear");--%>
			        	<%--$("#departmentId").combobox("loadData",data);--%>
			        <%--}--%>
			   <%--}); 	--%>
			<%--},--%>
 			<%--onLoadSuccess : function(){--%>
 				<%----%>
 			<%--}--%>
 		<%--});--%>
		
 		<%--$('#departmentId').combobox({--%>
 			<%--url : '${ctx}/department/getDepartmentList?json={"subcompanyId":"${userBean.subcompanyId}"}',--%>
 			<%--mode: 'remote',--%>
			<%--valueField:'id', --%>
			<%--textField:'name',--%>
			<%--panelHeight:true,--%>
			<%--editable:false,--%>
 			<%--onLoadSuccess : function(){--%>
 			<%--}--%>
 		<%--});--%>
 		
		$('#userAddForm').form({
			url : '${ctx}/user/add',
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

        $('#roleId').combobox({
        url: '${ctx}/user/getRoleList',
        mode: 'remote',
        valueField:'id',
        textField:'name',
        panelHeight:true,
        editable:false,
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
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="overflow:scroll;padding: 3px;">
		<form id="userAddForm" method="post">
			<table class="grid">
				
				<tr>
					<td>登录名</td>
					<td><input value="" id="lname" name="loginName" type="text" placeholder="请输入登录名" class="easyui-validatebox"  data-options="required:true,validType:['length[5,14]','nonChinese']"></td>
					<td>密码</td>
					<td colspan="3"><input value="" id="pwd" name="loginPwd" type="password" placeholder="请输入密码" class="easyui-validatebox"  data-options="required:true,validType:['length[1,32]','nonChinese']" />
					</td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input id="name" name="name" type="text"  class="easyui-validatebox"    data-options="validType:'length[1,10]'"></td>
					<td>性别</td>
					<td>
						<select name="sex" id="sex" class="easyui-validatebox" data-options="panelHeight:true,editable:false">
							<option value="0" selected="selected">男</option>
							<option value="1">女</option>
						</select>
					</td>
					
				</tr>
                <tr>
                    <td>角色分配</td>
                    <td>
                        <select id="roleId"  name="roleId" style="width: 140px; height: 29px;" class="easyui-combobox"></select>
                    </td>
                </tr>
				<%--<tr>--%>
					<%--<td>网点</td>--%>
					<%--<td><select id="subcompanyId" name="subcompanyId" style="width:200px;height: 29px;"></select></td>--%>
					<%--<td>部门</td>--%>
					<%--<td><input id="departmentId" name="departmentId"  class="easyui-validatebox" /></td>--%>
				<%--</tr>--%>
				<%--<tr>--%>
					<%--<td>岗位</td>--%>
					<%--<td colspan="3"><input id="stationId" name="stationId" class="easyui-validatebox" /></td>--%>
				<%--</tr>--%>
				<tr>
					<td>描述</td>
					<td colspan="3"><textarea rows="4" cols="50" placeholder="请输入描述" name="description" class="textarea easyui-validatebox"  data-options="validType:'length[1,255]'"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
</div>