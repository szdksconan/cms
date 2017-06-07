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
<script type="text/javascript" src="${ctx}/js/infopublish_huoyuan.js"></script>
  		<form method="post" id="huoyuanform" enctype="multipart/form-data">
   		<input type="hidden" name="beginProvinceName" id="beginProvinceName"/>
   		<input type="hidden" name="beginCityName" id="beginCityName"/>
   		<input type="hidden" name="beginAreaName" id="beginAreaName"/>
   		<input type="hidden" name="endProvinceName" id="endProvinceName"/>
   		<input type="hidden" name="endCityName" id="endCityName"/>
   		<input type="hidden" name="endAreaName" id="endAreaName"/>
   		<input type="hidden" name="userId" id="userId" value="${bean.userId}"/>
   		<input type="hidden" name="companyName" id="companyName" value="${bean.companyName}"/>
        <input type="hidden" id="packageType2" value="${bean.packageType}">
   		<input type="hidden" name="goodsImg" id="goodsImg" value=""/>
        <div style="height: 510px;width:100%;overflow-y: auto;overflow-x:auto;">
            <table class="table table-bordered" >
                <tr align="center">
                    <td width="100%" height="100%">
                        <fieldset>
                            <legend>货源信息</legend>
                            <table width="100%" height="100%">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 form-label" style="display: none;">有效期</label>
                                            <div class="col-sm-2" style="display: none;">
                                                <input class="form-control" id="huoyuaninvalidNum" name="invalidNum" type="text" value="1"/><label>天</label>
                                            </div>
                                            <label class="col-sm-1 form-label" >货物名称</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="goodsName" name="goodsName" type="text" placeholder="" value="${bean.goodsName}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">包装类型</label>
                                            <div class="col-sm-2">
                                                <select class="easyui-combobox" id="packageType" name="packageType">
                                                </select>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">吨位</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="weight" name="weight" type="text" value="${bean.weight}"/>
                                            </div>
                                            <label class="col-sm-1 control-label">体积</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="volume" name="volume" type="text" value="${bean.volume}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">件数</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="numbers" name="numbers" type="text" value=""/>
                                            </div>
                                            <label class="col-sm-1 control-label">报价</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="offer" name="offer" type="text" value=""/><label>元/吨</label>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                    <td rowspan="5">
                        <div class="form-group">
                            <img id="ImgPr" width="200" height="200" alt="货物图片"/>
                            <input class="input-file" id="huoyuanfileInput" name="huoyuan" type="file">
                        </div>
                    </td>

                </tr>
                <tr>

                </tr>
                <tr>
                    <td>
                        <div class="form-group">
                            <label class="col-sm-1 control-label">线路</label>
                            <div class="col-sm-10">
                                <%--<input id="huoyuanbeginAddName"  class="input6" name="huoyuanbeginAddName"--%>
                                <%--onclick="showProvince(this, 'huoyuanbeginAddName','huoyuanbeginAddId',1, true, event,null,null,'huoyuanProvinceAreaId');" type="text">--%>
                                <%--<input id="huoyuanbeginAddId" type="hidden">--%>
                                <%--<input id="huoyuanendAddName"  class="input6" name="huoyuanendAddName"--%>
                                <%--onclick="showProvince(this, 'huoyuanendAddName','huoyuanendAddId',1, true, event,null,null,'cheyuanProvinceAreaId');" type="text">--%>
                                <%--<input id="huoyuanendAddId" type="hidden">--%>
                                <select id="begin_huoyuan_province" name="beginProvinceId" onchange="searchAreaStart('begin_huoyuan_province','begin_huoyuan_area','huoyuanProvinceAreaId');" style="width: 135px;">
                                </select>
                                <select id="begin_huoyuan_area" name="beginAreaId" onchange="searchCityStart('begin_huoyuan_area','begin_huoyuan_city');" style="width: 135px;">
                                </select>
                                <select id="begin_huoyuan_city" name="beginCityId" style="width: 135px;">
                                </select>
                                至
                                <select id="end_huoyuan_province" name="endProvinceId" onchange="searchAreaStart('end_huoyuan_province','end_huoyuan_area');" style="width: 135px;">
                                </select>
                                <select id="end_huoyuan_area" name="endAreaId" onchange="searchCityStart('end_huoyuan_area','end_huoyuan_city');" style="width: 135px;">
                                </select>
                                <select id="end_huoyuan_city" name="endCityId" style="width: 135px;">
                                </select>
                                <input value="保存常用地址" type="button" onclick="saveAddress('huoyuan','begin_huoyuan_province','begin_huoyuan_area','begin_huoyuan_city','end_huoyuan_province','end_huoyuan_area','end_huoyuan_city','huoyuanProvinceAreaId')"/>
                                <a href="#" onclick="getAdd('huoyuan','begin_huoyuan_province','begin_huoyuan_area','begin_huoyuan_city','end_huoyuan_province','end_huoyuan_area','end_huoyuan_city')">常用地址选择</a>
                                <input type="hidden" id="huoyuanProvinceAreaId" name="provinceAreaId"/>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td width="100%" height="100%">
                        <fieldset>
                            <legend>发货人信息</legend>
                            <table width="100%" height="100%">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">发货人姓名</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="linkMan" type="text" name="linkMan" placeholder="${bean.linkMan}" value="${bean.linkMan}"/>
                                            </div>
                                            <label class="col-sm-1 control-label">联系电话</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="huoyuantel" type="text" name="tel" placeholder="${bean.tel}" value="${bean.tel}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备用电话1</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="huoyuantel1" type="text" name="tel1" placeholder="${bean.tel1}" value="${bean.tel1}"/>
                                            </div>
                                            <label class="col-sm-1 control-label">备用电话2</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="huoyuantel2" type="text" name="tel2" placeholder="${bean.tel2}" value="${bean.tel2}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>

                <tr>
                    <td width="100%" height="100%">
                        <fieldset>
                            <legend>收货人信息</legend>
                            <table width="100%" height="100%">
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">收货人姓名</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="consigneeMan" type="text" name="consigneeMan" placeholder="${bean.consigneeMan}" value="${bean.consigneeMan}"/>
                                            </div>
                                            <label class="col-sm-1 control-label">收货地址</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="consigneeAdd" type="text" name="consigneeAdd" placeholder="${bean.consigneeAdd}" value="${bean.consigneeAdd}"/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">联系电话</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="consigneeTel" type="text" name="consigneeTel" placeholder="" value=""/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="form-group">
                                            <label class="col-sm-1 control-label">备用电话1</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="consigneeTel1" type="text" name="consigneeTel1" placeholder="" value=""/>
                                            </div>
                                            <label class="col-sm-1 control-label">备用电话2</label>
                                            <div class="col-sm-2">
                                                <input class="form-control" id="consigneeTel2" type="text" name="consigneeTel2" placeholder="" value=""/>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </fieldset>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="form-group">
                            <textarea class="" id="huoyuaninfo" name="info" style="margin: 0px;" cols="200" rows="10"> </textarea>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button class="btn btn-success" type="submit" >发布</button>
                    </td>
                </tr>
            </table>
        </div>
	</form>
    <div title="" id="infoPublish_huoyuan" class="tan_chuang" style="border-radius: 4px;width: 60%;height: 35%;right: 30%;">
        <div onclick="closeInfo_huoyuan('infoPublish_huoyuan');"    style="width: 24px;height:24px; margin-bottom: 3px;background-image: url('images/k-2.jpg');">

        </div>
        <label id="lab_huoyuan1" ></label>
        <div data-options="region:'center',border:false" >
            <table id="gridTable_huoyuan" data-options="border:false">
            </table>
        </div>
    </div>
    <div  id="viewInfo_huoyuan" class="tan_chuang" style="border-radius: 4px;width: 60%;height: 70%;right: 30%;top: 10%;">
        <div onclick="closeInfo_huoyuan('viewInfo_huoyuan');"    style="width: 24px;height:24px; margin-bottom: 3px;background-image: url('images/k-2.jpg');">

        </div>
        <label id="lab_huoyuan2"></label>
        <div id="divInfo_huoyuan"  style="height: 400px; ">

        </div>
    </div>
</body>
</html>