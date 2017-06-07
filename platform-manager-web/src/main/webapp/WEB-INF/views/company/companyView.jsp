<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" href="${ctx}/style/css/imagezoom.css" type="text/css">
<style type="text/css">
.box{width:30%;}
</style>
<script type="text/javascript">
$(function() {
	$(".jqzoom").imagezoom();
});
</script>
<div data-options="fit:true,border:false" style="height: 100%;overflow: auto;">
	<div data-options="region:'center',border:false" title="" style="overflow: hidden;padding: 3px;" >
		<table class="grid">
			<tr>
				<td>企业名称</td>
				<td><input disabled="disabled" name="companyName" id="companyName" type="text" placeholder="请输入企业名称"  class="easyui-validatebox span2" value="${company.companyName}"></td>
				<td>工商执照编号</td>
				<td><input disabled="disabled" name="companyNo" id="companyNo" type="text" placeholder="请输入工商执照编号"  class="easyui-validatebox span2" value="${company.companyNo}"></td>
			</tr>
			<tr>
				<td>联系人</td>
				<td><input disabled="disabled" name="companyLinkman" id="companyLinkman" type="text" placeholder="请输入企业联系人"  class="easyui-validatebox span2" value="${company.companyLinkman}"></td>
				<td>联系电话</td>
				<td><input disabled="disabled" type="text" placeholder="请输入联系电话"  class="easyui-validatebox span2" value="${company.companyId}"></td>
			</tr>
			<tr>
				<td>证件类型</td>
				<td>
				<select disabled="disabled" name="paperType" id="paperType" class="easyui-combobox" data-options="panelHeight:true,editable:false">
					<c:forEach items="${list}" var="dic">
						<option value="${dic.id}" <c:if test="${dic.id == company.paperType}">selected="selected"</c:if>>${dic.name}</option>
					</c:forEach>
				</select>
				</td>
				<td>证件编号</td>
				<td>
					<input name="paperNo" disabled="disabled" id="paperNo" type="text" value="${company.paperNo}" class="easyui-validatebox span2" data-options="required:true,validType:['length[1,50]','enterName']"/>
				</td>
			</tr>
			<tr>
				<td>证件照</td>
				<td colspan="3">
					<div class="box">
						<div class="tb-pic tb-s310">
							<img id="paperPic" src="${ctx}/login/showImg?url=${company.paperPicMin}&date="+new Date() rel="${ctx}/login/showImg?url=${company.paperPic}&date="+new Date() class="jqzoom"/>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>企业地址</td>
				<td><input disabled="disabled" name="companyAdd" id="companyAdd" type="text" placeholder="请输入企业地址"  class="easyui-validatebox span2"  value="${company.companyAdd}"></td>
				<td>物流园</td>
				<td><input disabled="disabled" name="companyGarden" id="companyGarden" type="text" class="easyui-validatebox span2" value="${company.companyGarden}"></td>
			</tr>
			<tr>
				<td>营业执照</td>
				<td colspan="3">
					<div class="box">
						<div class="tb-pic tb-s310">
							<img id="industryPic" src="${ctx}/login/showImg?url=${company.industryPicMin}&date="+new Date() rel="${ctx}/login/showImg?url=${company.industryPic}&date="+new Date() class="jqzoom"/>
						</div>
					</div>
				</td>
			</tr>
			<tr>
				<td>门头照</td>
				<td colspan="3">
					<div class="box">
						<div class="tb-pic tb-s310">
							<img id="companyPic" src="${ctx}/login/showImg?url=${company.companyPicMin}&date="+new Date() rel="${ctx}/login/showImg?url=${company.companyPic}&date="+new Date() class="jqzoom"/>
						</div>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>