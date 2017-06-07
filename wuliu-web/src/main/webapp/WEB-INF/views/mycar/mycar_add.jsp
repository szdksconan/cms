<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="post" id="carfrom" enctype="multipart/form-data">
		<input type="hidden" name="beginProvinceName2" id="cheyuanbeginProvinceName2" />
		<input type="hidden" name="beginCityName2" id="cheyuanbeginCityName2" />
		<input type="hidden" name="beginAreaName2" id="cheyuanbeginAreaName2" /> 
		<input type="hidden" name="endProvinceName2" id="cheyuanendProvinceName2" /> 
		<input type="hidden" name="endCityName2" id="cheyuanendCityName2" /> 
		<input type="hidden" name="endAreaName2" id="cheyuanendAreaName2" />
			<table class="table2">
				<tr>
					<td style="text-align: center;">车牌号</td>
					<td ><input  id="carNo"    name="carNo" type="text"     >
					<button type="button" class="btn btn-primary" onclick="carNoUrl.click()">上传</button>
						<input id="carNoUrl" name="carNoUrld"  type="file" style="position:absolute; filter:alpha(opacity=0); opacity:0; width:30px; " size="1"></input>
					</td>
					<td style="text-align: center;">运输类型</td>
					<td>
						<select id="carTrafficType"    name="carTrafficType" class="combobox" >
					    <c:forEach items="${dicList3}" var="type" >
					    	<option value="${type.id}">${type.name}</option>
					    </c:forEach>

						</select>
					</td>
					</tr>
					<tr>
					<td style="text-align: center;">车型</td>
					<td>
						<select id="carType"    name="carType" class="combobox" >
					    <c:forEach items="${dicList}" var="type" >
					    	<option value="${type.id}">${type.name}</option>
					    </c:forEach>

						</select>
					</td>
					<td style="text-align: center;">轴数</td>
					<td>
						<select id="carAxle"    name="carAxle" class="combobox" >
					    <c:forEach items="${dicList2}" var="type" >
					    	<option value="${type.id}">${type.name}</option>
					    </c:forEach>

						</select>
					</td>
				
					
					</tr>
					<tr>
					<td style="text-align: center;">车长</td>
					<td><input  id="carLength"    name="carLength" type="text"    ></td>
					<td style="text-align: center;">车厢结构</td>
					<td>
						<select id="carContainer"    name=carContainer class="combobox" >
					    <c:forEach items="${dicList4}" var="type" >
					    	<option value="${type.id}">${type.name}</option>
					    </c:forEach>

						</select>
					</td>
				
			
					</tr>
						<tr>
					<td style="text-align: center;">车主姓名</td>
					<td><input  id="carOwner"    name="carOwner" type="text"    ></td>
						<td style="text-align: center;">载重</td>
					<td><input  id="carWeigth"    name="carWeigth" type="text"    ></td>
				
			
					
					</tr>
					<tr>
					<td style="text-align: center;">身份证号</td>
					<td ><input  id="carCard"    name="carCard" type="text"    >
						<button type="button" class="btn btn-primary" onclick="carCardUrl.click()">上传</button>
						<input id="carCardUrl" name="carCardUrld"  type="file" style="position:absolute; filter:alpha(opacity=0); opacity:0; width:30px; " size="1"></input>
					</td>
						<td style="text-align: center;">车厢体积</td>
					<td><input  id="carVolume"    name="carVolume" type="text"    ></td>
					
					</tr>
						<tr>
					<td style="text-align: center;">驾驶证号</td>
					<td ><input  id="carCard2"    name="carCard2" type="text"    >
						<button type="button" class="btn btn-primary" onclick="carCar24Url.click()">上传</button>
						<input id="carCard2Url" name="carCard2Urld"  type="file" style="position:absolute; filter:alpha(opacity=0); opacity:0; width:30px; " size="1"></input>
					</td>
							<td style="text-align: center;">随车电话</td>
					<td><input  id="carTel"    name="carTel" type="text"    ></td>
				
					</tr>
					<tr>
					<td style="text-align: center;">行驶证号</td>
					<td ><input  id="carCard3"    name="carCard3" type="text"    >
						<button type="button" class="btn btn-primary" onclick="carCard3Url.click()">上传</button>
						<input id="carCard3Url" name="carCard3Urld"  type="file" style="position:absolute; filter:alpha(opacity=0); opacity:0; width:30px; " size="1"></input>
					</td>
							<td style="text-align: center;">固定电话</td>
					<td><input  id="carTel2"    name="carTel2" type="text"    ></td>
					</tr>
					<tr>
					<td style="text-align: center;">运输许可证号</td>
					<td ><input  id="carCard4"    name="carCard4" type="text"    >
						<button type="button" class="btn btn-primary" onclick="carCard4Url.click()">上传</button>
						<input id="carCard4Url" name="carCard4Urld"  type="file" style="position:absolute; filter:alpha(opacity=0); opacity:0; width:30px; " size="1"></input>
					</td>
					</tr>
					<tr>
					<td style="text-align: center;">线路描述</td>
					<td><input  id="carLineDesc"    name="carLineDesc" type="text"    ></td>
				</tr>
				<tr>
				  <td style="text-align: center;">主营线路起始地</td>
				  	<td colspan="3">
				  		<select id="begin_cheyuan_province2" name="beginProvinceId2"
							onchange="searchAreaStart2('begin_cheyuan_province2','begin_cheyuan_area2','cheyuanbeginProvinceName2','cheyuanProvinceAreaId2');"
							style="width: 135px;">
						</select> <select id="begin_cheyuan_area2" name="beginAreaId2"
							onchange="searchCityStart2('begin_cheyuan_area2','begin_cheyuan_city2','cheyuanbeginAreaName2');"
							style="width: 135px;">
						</select> <select id="begin_cheyuan_city2" name="beginCityId2" onchange="searchAreaStart3('begin_cheyuan_city2','cheyuanbeginCityName2');"
							style="width: 135px;">
						</select>	
				  	</td>
				</tr>
				<tr>
					 <td style="text-align: center;">主营线路终止地</td>
					 <td colspan="3">
					 	<select id="end_cheyuan_province2" name="endProvinceId2"
							onchange="searchAreaStart2('end_cheyuan_province2','end_cheyuan_area2','cheyuanendProvinceName2');"
							style="width: 135px;">
						</select> <select id="end_cheyuan_area2" name="endAreaId2"
							onchange="searchCityStart2('end_cheyuan_area2','end_cheyuan_city2','cheyuanendAreaName2');"
							style="width: 135px;">
						</select> <select id="end_cheyuan_city2" name="endCityId2" onchange="searchAreaStart3('end_cheyuan_city2','cheyuanendCityName2');"
							style="width: 135px;">
						</select> 
						<input type="hidden" id="cheyuanProvinceAreaId2"
							name="provinceAreaId2" />
					 </td>
				</tr>
						<tr>
                				<td colspan="4" style="text-align: center;">
                				
                						<button class="btn btn-primary" type="submit" >添加</button>
                				</td>
                			</tr>
			</table>
</form>
<script src="js/mycar_add.js"/>
<style>
	.combobox{
			width:165px;
			height: 25px;
	}
</style>

