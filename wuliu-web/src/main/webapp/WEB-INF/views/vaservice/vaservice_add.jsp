<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/vaservice_add.js"></script>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false" title="" style="padding: 3px;">
			<table class="table2">
				<input id="servicePackageid" name="servicePackageid" type="hidden" value="${servicePackage.id }" />
				<input id="salestag" name="salestag" type="hidden" value="${servicePackage.salestag }" />
			
				<tr>
					<td style="width: 128px;">套餐名</td>
					<td><input  id="servicepackagename"    name="servicepackagename" value="${servicePackage.servicepackagename }" type="text"  readonly="readonly"  class="easyui-validatebox" ></td>
					</tr>
				<tr>
				<td >价格</td>
					<td><input id="price"    name="price" value="${servicePackage.price }"  type="text"   readonly="readonly"  class="easyui-validatebox" ></td>
					</tr>
				<tr>
					<td >有效期</td>
					<td><input id="measurePeriod"    name="measurePeriod" value="${servicePackage.measurePeriod }"  type="text"   readonly="readonly"  class="easyui-validatebox" ></td>
					</tr>
				<tr>
				<td >套餐包含说明</th>
					<td>
					<textarea rows="5" cols="25">${servicePackage.note }</textarea>
					</td>
					</tr>
					
				<tr>
					<td colspan="2" style="text-align: center;">
					
							<button type="button" class="btn btn-primary" onclick="addServicePackage('${servicePackage.id }');" style="width: 100px;" type="submit" >购买</button>
					</td>
				</tr>
			</table>
	</div>
</div>