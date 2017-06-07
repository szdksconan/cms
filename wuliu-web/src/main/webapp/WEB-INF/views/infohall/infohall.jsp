<%@ page import="com.cms.model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ctx}/js/infohall.js"></script>
<script>
    <%
User loginUser = (User)request.getSession().getAttribute("sso:loginUser");
    %>
    userId='<%=loginUser.getId()%>';
  
    provinceAreaId='<%=loginUser.getBelongAreaId()%>';
    $("#more_query").toggle(function(){
        more_huoyuan_query=true;
        $(".text").animate({height: 'toggle', opacity: 'toggle'}, "1000");
    },function(){
        more_huoyuan_query=false;
        $(".text").animate({height: 'toggle', opacity: 'toggle'}, "1000");
    });
    $("#more_cheyuan_query").toggle(function(){
        more_cheyuan_query=true;
        $(".text2").animate({height: 'toggle', opacity: 'toggle'}, "1000");
    },function(){
        more_cheyuan_query=false;
        $(".text2").animate({height: 'toggle', opacity: 'toggle'}, "1000");
    });
</script>
<title>资源管理</title>
<style>
    .area_ul li{
        float: left;
    }
    .text{line-height:22px;padding:0 6px;color:#666;display: none;}
    .text2{line-height:22px;padding:0 6px;color:#666;display: none;}
    .box{position:relative;border:1px solid #e7e7e7;}
</style>
</head>
<body>
	<input id="different" hidden="true" value=" ${different}"/>
	<input id="anyList" hidden="true" />
	<button id="dbutton1" hidden="true"    data-toggle="modal" data-target="#myModal"  ></button>
	<button id="dbutton2" hidden="true"    data-toggle="modal" data-target="#myModal2" onclick="openmsg('anyList')" ></button>
	<div class="tab-pane fade in active" id="daiqueren" style="height: 91%;">
            <section class="radiotabs" style="height: 100%;width: 100%;">
                <input type="radio" name="tab" id="tab11" class="tabs" checked="checked" onclick="query(this)">
                <label for="tab11">
                    货源信息
                </label>
                <input type="radio" name="tab" id="tab12" class="tabs" onclick="query(this)">
                <label for="tab12">
                    车源信息
                </label>
                
                <section id="view11" class="tabcontent" style="width: 100%;">
                	<fieldset>
                		<legend></legend>
                        <ul class="area_ul">
                            <c:forEach items="${list}" var="map">
                                <li>
                                    <input class="to-labelauty synch-icon" type="radio" name="rd1" id="h_a_${map.id}" value="${map.id}" data-labelauty="${map.name}"/>
                                </li>
                            </c:forEach>
                        </ul>
                	</fieldset>
					<fieldset>
					 	<legend></legend>
					 	<div style="height:86%;margin-top: 8px;border-radius:4px;border: 1px solid #d4d4d4;">
							<table id="huoyuanList" data-options="border:false">
							</table>
						</div>
						<div id="huoyuantoolbar" style="display: none;">
							<table>
								<tr>
									<td>
										始发地
<!-- 										<input  id="Area_cityName_1"  class="input6" -->
<!-- 												onclick="showProvince(this, 'Area_cityName_1','huobeginAdd_query',1, true, event);" onchange="checkValue(this)" type="text"> -->
<!-- 										<input  id="huobeginAdd_query" type="hidden"> -->
										<select id="provinceListstart" onchange="searchAreaStart('provinceListstart','areaListstart');" style="width: 135px;">
                                        </select>
                                        <select id="areaListstart"  style="width: 135px;">
                                        </select>
									</td>
									<td>
										目的地
<!-- 										<input  id="Area_cityName_0"  class="input6" -->
<!-- 												onclick="showProvince(this, 'Area_cityName_0','huoendAdd_query',1, true, event);" onchange="checkValue(this)" type="text"> -->
<!-- 										<input  id="huoendAdd_query" type="hidden"> -->
												<select id="provinceListend" onchange="searchAreaStart('provinceListend','areaListend');" style="width: 135px;">
                                                </select>
                                                <select id="areaListend" style="width: 135px;">
                                                </select>
									</td>
									<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
									<td>
										<button class="btn btn-success" type="button" onclick="huosearchFun()">查询</button>
									</td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </td>
                                    <td>
                                        <input type="button" value="更多条件" id="more_query"/>
                                    </td>
								</tr>
							</table>
                            <div class="box">
                                <div class="text">
                                    <table>
                                        <tr>
                                            <td>包装类型</td>
                                            <td>
                                                <select id="packageType" name="packageType">
                                                </select>
                                            </td>
                                            <td>报价</td>
                                            <td>
                                                <select class="easyui-combobox" id="quoteRegion" name="quoteRegion">
                                                </select>
                                            </td>
                                            <td>吨位</td>
                                            <td>
                                                <select class="easyui-combobox" id="weight" name="weight">
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
						</div>
					 </fieldset>
		        </section>
		        
                <section id="view12" class="tabcontent" style="width: 100%;">
					<fieldset>
                		<legend></legend>
						<%--<table id="cheyuanrecommend" data-options="border:false">--%>
						<%--</table>--%>
                        <ul class="area_ul">
                            <c:forEach items="${list}" var="map">
                                <li>
                                    <input class="to-labelauty synch-icon" type="radio" name="rd2" id="c_a_${map.id}" value="${map.id}" data-labelauty="${map.name}"/>
                                </li>
                            </c:forEach>
                        </ul>
                	</fieldset>
                	<fieldset>
                		<legend></legend>
                        <div style="height:86%;margin-top: 8px;border-radius:4px;border: 1px solid #d4d4d4;">
                            <table id="cheyuanList" data-options="border:false">
                            </table>
                        </div>
                        <div id="cheyuantoolbar" style="display: none;">
                            <table>
                                <tr>
                                    <td>
                                        始发地
                                        <!-- 									<input  id="chebeginAdd"  class="input6" -->
                                        <!-- 											onclick="showProvince(this, 'chebeginAdd','chebeginAdd_query',1, true, event);" onchange="checkValue(this)" type="text"> -->
                                        <!-- 									<input  id="chebeginAdd_query" type="hidden"> -->
                                        <select id="provinceListstart2" onchange="searchAreaStart('provinceListstart2','areaListstart2');" style="width: 135px;">
                                        </select>
                                        <select id="areaListstart2"  style="width: 135px;">
                                        </select>
                                    </td>
                                    <td>
                                        目的地
                                        <!-- 									<input  id="cheendAdd"  class="input6" -->
                                        <!-- 											onclick="showProvince(this, 'cheendAdd','cheendAdd_query',1, true, event);" onchange="checkValue(this)" type="text"> -->
                                        <!-- 									<input  id="cheendAdd_query" type="hidden"> -->
                                        <select id="provinceListend2" onchange="searchAreaStart('provinceListend2','areaListend2');" style="width: 135px;">
                                        </select>
                                        <select id="areaListend2" style="width: 135px;">
                                        </select>
                                    </td>
                                    <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td>
                                        <button class="btn btn-success" type="button" onclick="chesearchFun()">查询</button>
                                    </td>
                                    <td>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </td>
                                    <td>
                                        <input type="button" value="更多条件" id="more_cheyuan_query"/>
                                    </td>
                                </tr>
                            </table>
                            <div class="box">
                                <div class="text2">
                                    <table>
                                        <tr>
                                            <td>运输类型</td>
                                            <td>
                                                <select class="easyui-combobox" id="carTrafficType">
                                                </select>
                                            </td>
                                            <td>可承载重量</td>
                                            <td>
                                                <select class="easyui-combobox" id="weight2">
                                                </select>
                                            </td>
                                            <td>报价</td>
                                            <td>
                                                <select class="easyui-combobox" id="quoteRegion2">
                                                </select>
                                            </td>
                                            <td>货运类型</td>
                                            <td>
                                                <select id="trafficType">
                                                    <option value="0" selected></option>
                                                    <option value="1">零担</option>
                                                    <option value="2">整车</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>车型</td>
                                            <td>
                                                <select class="easyui-combobox" id="carTypeId">
                                                </select>
                                            </td>
                                            <td>车轴</td>
                                            <td>
                                                <select class="easyui-combobox" id="carAxleId">
                                                </select>
                                            </td>
                                            <td>车厢结构</td>
                                            <td>
                                                <select class="easyui-combobox" id="carContainerId">
                                                </select>
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                	</fieldset>
		        </section>
            </section>
    </div>
    <div  id="infoPublish" class="tan_chuang" style="border-radius: 4px;width: 60%;height: 35%;right: 30%;">
        <div onclick="closeInfo('infoPublish');"    style="width: 24px;height:24px; margin-bottom: 3px;background-image: url('images/k-2.jpg');">

        </div>
        <label id="lab_1"></label>
        <div data-options="region:'center',border:false" >
            <table id="gridTable" data-options="border:false">
            </table>
        </div>
    </div>
    <div  id="infoHall2" class="tan_chuang" style="border-radius: 4px;width: 60%;height: 70%;right: 30%;">
	   	<div onclick="closeInfo('infoHall2');"    style="width: 24px;height:24px; margin-bottom: 3px;background-image: url('images/k-2.jpg');">
	   		
	   	</div>
        <label id="lab_2"></label>
		<div id="divInfo"  style="height: 400px; ">
		
		</div>
	</div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"  style="border-radius:5px;width:540px;"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="height: 250px;width: 100%">
			<div class="modal-header">
					<h4 class="modal-title" id="myModalLabel">距离信息开放时间</h4>
				</div>
			<div class="modal-content">
				<div class="modal-body" style="height: 141px;">
					<div class="time ">
				<ul>
		<li class="num"><span class="static old">0</span></li>
		<li class="num"><span class="static old">0</span></li>
		<li><span>:</span></li>
		<li class="num"><span class="static old">0</span></li>
		<li class="num"><span class="static old">0</span></li>
		<li><span>:</span></li>
		<li class="num"><span class="static old">0</span></li>
		<li class="num"><span class="static old">0</span></li>
				</ul>
		
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
		<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeTime();">关闭
					</button>
					

				</div>
	</div>
	</div>
	<!-- /.modal -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"  style=" border-radius:5px;width:540px;"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="height: 125px;width: 100%">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel2"></h4>
				</div>
			<div class="modal-content">
			<div class="modal-body">
				<input id="totalCount" hidden="true"/>
					<table class="table2">
					<tbody>
						<tr>
							<td>发送至:</td>
							<td><input id="sendOwner"  />
								<button type="button" id="sendbutton2" class="btn btn-primary" data-dismiss="modal" onclick="sendmsg('anyList')" >发送</button>
							<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="changeDiv('vaservice/vaserviceList')">购买套餐</button>
							</td>
							
						</tr>
					</tbody>	
					</table>
				
				</div>
		<!-- /.modal-dialog -->
	</div>
	
	</div>
	</div>
	<!-- /.modal -->

    <script type="text/javascript" src="${ctx}/js/jquery-labelauty.js"></script>
    <script>
        $(document).ready(function(){
            $(".to-labelauty").labelauty({minimum_width: "155px",margin_left:"30px"});
            $(".to-labelauty-icon").labelauty({ label: false });
            $('#h_a_<%=loginUser.getBelongAreaId()%>').attr("checked",true);
        });
    </script>
</body>
</html>