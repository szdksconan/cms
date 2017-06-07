<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>货源信息</title>
</head>
<body style="width: 100%;height: 100%">
<script type="text/javascript" src="${ctx}/js/infopublish.js"></script>
  		<form method="post" id="cheyuanform" enctype="multipart/form-data">
  						<input type="hidden" id="carId2" value="${carId}"/>
	               		<input type="hidden" name="beginProvinceName" id="cheyuanbeginProvinceName"/>
	               		<input type="hidden" name="beginCityName" id="cheyuanbeginCityName"/>
	               		<input type="hidden" name="beginAreaName" id="cheyuanbeginAreaName"/>
	               		<input type="hidden" name="endProvinceName" id="cheyuanendProvinceName"/>
	               		<input type="hidden" name="endCityName" id="cheyuanendCityName"/>
	               		<input type="hidden" name="endAreaName" id="cheyuanendAreaName"/>
		        		<input type="hidden" id="carImgInp" name="carImg"/>
		        		<input type="hidden" id="carNo" name="carNo"/>
		        		<input type="hidden" id="carOwner" name="carOwner"/>
		        		<input type="hidden" id="car_axle_id" name="car_axle_id"/>
		        		<input type="hidden" id="car_container_id" name="car_container_id"/>
		        		<input type="hidden" id="carTrafficTypeId" name="carTrafficTypeId"/>
		        		<input type="hidden" id="carTrafficTypeName" name="carTrafficTypeName"/>
		        		<input type="hidden" id="carTypeId" name="carTypeId"/>
		        		<input type="hidden" id="carTypeName" name="carTypeName"/>
		        		<input type="hidden" id="companyName" name="companyName"/>
                        <div style="height: 510px;width:100%;overflow-y: auto;overflow-x: auto;">
                            <table class="table table-bordered ">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label" style="display: none;">有效期</label>
                                            <div class="col-sm-2" style="display: none;">
                                                <input class="form-control" id="cheyuaninvalidNum" name="invalidNum" type="text" placeholder="1" value="1"/><label>天</label>
                                            </div>
                                            <label class="col-sm-1 control-label" >车牌号码</label>
                                            <div class="col-sm-2">
                                                <c:if test="${ carId != ''}">
                                                    <input class="easyui-combobox" id="carId" name="carId"  readonly="readonly">
                                                </c:if>
                                                <c:if test="${ carId == ''}">
                                                    <input class="easyui-combobox" id="carId" name="carId"  >
                                                </c:if>
                                                </input>
                                            </div>
                                        </div>
                                    </td>
                                    <td rowspan="6">
                                        <div class="form-group">
                                            <img id="carImg" width="200" height="200" alt="车辆图片"/>
                                            <input class="input-file" id="cheyuanfileInput" name="cheyuan" type="file">
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label" >可装载重量</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="zaizong" name="weight" type="text" placeholder="" />
                                            </div>
                                            <label class="col-sm-1 control-label" >货运类型</label>
                                            <div class="col-sm-2">
                                                <input name="trafficType" type="radio" value="1" checked />零担
                                                <input name="trafficType" type="radio" value="2"/>整车
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">车厢结构</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="car_container_name" name="car_container_name" type="text" readonly/>
                                            </div>
                                            <label class="col-sm-1 control-label">报价</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="offer" name="offer" type="text" value=""/><label>元/吨</label>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">联系人</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="chelinkMan" name="linkMan" type="text" />
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">联系电话</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="cheyuantel" name="tel" type="text" placeholder="${session.tel}" value="${session.tel}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备用电话1</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="cheyuantel1" name="tel1" type="text" placeholder="${session.tel1}" value="${session.tel1}"/>
                                            </div>
                                            <label class="col-sm-1 control-label">备用电话2</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="cheyuantel2" name="tel2" type="text" placeholder="${session.tel2}" value="${session.tel2}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">线路</label>
                                            <div class="col-sm-10">
                                                <%--<input id="cheyuanbeginAddName" name="startName" class="input6"--%>
                                                <%--onclick="showProvince(this, 'cheyuanbeginAddName','cheyuanbeginAddId',1, true, event,null,null,'cheyuanProvinceAreaId');"  type="text">--%>
                                                <%--<input id="cheyuanbeginAddId" name="startId" type="hidden">--%>

                                                <%--<input id="cheyuanendAddName" name="endName" class="input6"--%>
                                                <%--onclick="showProvince(this, 'cheyuanendAddName','cheyuanendAddId',1, true, event);" type="text">--%>
                                                <%--<input id="cheyuanendAddId" name="endId" type="hidden">--%>
                                                <select id="begin_cheyuan_province" name="beginProvinceId" onchange="searchAreaStart('begin_cheyuan_province','begin_cheyuan_area','cheyuanProvinceAreaId');" style="width: 135px;">
                                                </select>
                                                <select id="begin_cheyuan_area" name="beginAreaId" onchange="searchCityStart('begin_cheyuan_area','begin_cheyuan_city');" style="width: 135px;">
                                                </select>
                                                <select id="begin_cheyuan_city" name="beginCityId" style="width: 135px;">
                                                </select>
                                                至
                                                <select id="end_cheyuan_province" name="endProvinceId" onchange="searchAreaStart('end_cheyuan_province','end_cheyuan_area');" style="width: 135px;">
                                                </select>
                                                <select id="end_cheyuan_area" name="endAreaId" onchange="searchCityStart('end_cheyuan_area','end_cheyuan_city');" style="width: 135px;">
                                                </select>
                                                <select id="end_cheyuan_city" name="endCityId" style="width: 135px;">
                                                </select>
                                                <input value="保存常用地址" type="button" onclick="saveAddress('cheyuan','begin_cheyuan_province','begin_cheyuan_area','begin_cheyuan_city','end_cheyuan_province','end_cheyuan_area','end_cheyuan_city','cheyuanProvinceAreaId','carId')"/>
                                                <a href="#" onclick="getAdd('cheyuan','begin_cheyuan_province','begin_cheyuan_area','begin_cheyuan_city','end_cheyuan_province','end_cheyuan_area','end_cheyuan_city','carId')">常用地址选择</a>
                                                <input type="hidden" id="cheyuanProvinceAreaId" name="provinceAreaId"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <div class="form-group">
                                            <textarea class="" id="cheyuaninfo" name="info" style="margin: 0px;" cols="180" rows="10"> </textarea>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2">
                                        <button class="btn btn-success">发布</button>
                                    </td>
                                </tr>
                            </table>
                        </div>
		            </form>
</body>
</html>