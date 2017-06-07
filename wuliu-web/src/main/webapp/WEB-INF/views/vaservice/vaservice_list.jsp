<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线车辆</title>
</head>
<body>
	<div class="tab-pane fade in active" id="daiqueren" style="height: 87%;">
		<section class="radiotabs" style="width: 100%; height: 100%;">
			<input type="radio" name="tab" id="tab11" class="tabs"
				checked="checked"> <label for="tab11">订购套餐</label> <input
				type="radio" name="tab" id="tab12" class="tabs"> <label
				for="tab12" onclick="query3();">订购记录 </label>
				<input
				type="radio" name="tab" id="tab13" class="tabs"> <label
				for="tab13"   onclick="query2();">使用记录 </label>
			<section id="view11" class="tabcontent" 	style="width: 100%; height: 100%;">
					<div class="panel panel-default" id="mycar" style="width: 100%;height: 646px;margin-top: 5px;overflow:auto; ">
				<div style="float: left; width: 100%; height: 168px;">
						<table  class="table2" style="text-align: center;">
							<thead>
								<tr style="height: 44px;">
								<th>已购服务 
<!-- 								 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<!--      							 <a href="javascript:void(0);" onclick="openHis();">历史订购记录</a> -->
								</tr>
							</thead>
							
							<tbody>
								<tr>
									<td>
											<div id="ztbox">
					  <div id="left"></div>
					  <div id="conter">
					   <ul>
					<c:forEach items="${userVaServiceList}" var="userva">
                     <li>
                       	<div style="width:165px; height: 100px;background-image: url('images/bg.png');" class="img-thumbnail">
                       		 	<div style="width:164px;height: 30px;margin-top:4px;text-align: center; ">
                       		 		<span>${userva.vaServiceName }</span>
                       		 	</div>
                       		 		<div style="width:164px;height: 30px;margin-top:3px;text-align: center;">
                       		 		<span>有效期至:${userva.effectDate }</span>
                       		 	</div>
                       		 		<div style="width:164px;height: 30px;margin-top:3px;text-align: center;">
                       		 		<span>剩余次数:${userva.remainAmount }${userva.count }</span>
                       		 	</div>
                       	</div>
                     </li>
                      </c:forEach>
                    	</ul>
						 <div id="scroll" style="visibility: hidden;"> <span></span> </div>
					  </div>
					  <div id="right"></div>
					</div>
									</td>
								</tr>
							</tbody>
						</table>	
						
					</div>
					<div style="float: left; width: 100%; height: 450px;margin-top: 5px;position: relative;">
							<table  class="table2" style="text-align: center;">
							<thead>
								<tr style="height: 44px;">
								<th>更多增值服务包  </th>
								</tr>
								<tr>
								<th>会员服务</th>
								</tr>
							</thead>
							<tbody>
							<tr>
								<td>
						
										<div id="ztbox">
					
					  <div id="conter">
							       <ul>
			                   <c:forEach items="${vaServiceList}" var="va">
			                    <c:if test="${ va.vaServiceType == 8001}">
			                     <li>
			                       	<div style="width:165px;height: 100px;background-image: url('images/bg.png');"  class="img-thumbnail">
			                       		 	<div style="width:164px;height: 22px;margin-top:3px;text-align: center; ">
			                       		 		<span>${va.servicepackagename}</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center; ">
			                       		 		<span>价格：${va.price}元</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center; ">
			                       		 		<span>有效期：${va.measurePeriod}月</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center;">
			                       		 		<a href="javascript:void(0);" onclick="openInfo('${va.measurePeriod}','${va.id}','${va.servicepackagename}','${va.price}','${va.salestag}');" style="cursor: pointer;"><span>查看详情</span></a>
			                       		 	</div>
			                       	</div>
			                       	
			                     </li>
			                        </c:if>
								 </c:forEach>
			                    </ul>
						 <div id="scroll" style="visibility: hidden;"> <span></span> </div>
					  </div>
				
					  </div>
									</td>
									
								</tr>
							</tbody>
							<thead>
								<tr>
									<th>短信服务</th>
								</tr>
							</thead>
							<tbody>
							
								<tr>
									<td>
										<div id="ztbox">
	
					  <div id="conter">
							 <ul>
			                   <c:forEach items="${vaServiceList}" var="va2">
			                   <c:if test="${ va2.vaServiceType == 8003}">
			                     <li>
			                       	<div style="width:165px;height: 100px;background-image: url('images/bg.png');"  class="img-thumbnail">
			                       		 	<div style="width:164px;height: 22px;margin-top:3px;text-align: center; ">
			                       		 		<span>${va2.servicepackagename}</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center; ">
			                       		 		<span>价格：${va2.price}元</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center; ">
			                       		 		<span>有效期：${va2.measurePeriod}月</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center;">
			                       		 		<a href="javascript:void(0);" onclick="openInfo('${va2.measurePeriod}','${va2.id}','${va2.servicepackagename}','${va2.price}','${va2.salestag}');" style="cursor: pointer;"><span>查看详情</span></a>
			                       		 	</div>
			                       	</div>
			                     </li>
			                       </c:if> 
								 </c:forEach>
			                    </ul>
						 <div id="scroll" style="visibility: hidden;"> <span></span> </div>
					  </div>
					
					  </div>
									</td>
								</tr>
							</tbody>
							<thead>
								<tr>
									<th>手机定位服务</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>
											<div id="ztbox">

					  <div id="conter">
							<ul>
			                   <c:forEach items="${vaServiceList}" var="va3">
			                    <c:if test="${va3.vaServiceType == 8002}">
			                     <li>
			                       	<div style="width:165px;height: 100px;background-image: url('images/bg.png');"  class="img-thumbnail">
			                       		 	<div style="width:164px;height: 22px;margin-top:3px;text-align: center; ">
			                       		 		<span>${va3.servicepackagename}</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center; ">
			                       		 		<span>价格：${va3.price}元</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center; ">
			                       		 		<span>有效期：${va3.measurePeriod}月</span>
			                       		 	</div>
			                       		 	<div style="width:164px;height: 22px;margin-top:2px;text-align: center;">
			                       		 		<a href="javascript:void(0);" onclick="openInfo('${va3.measurePeriod}','${va3.id}','${va3.servicepackagename}','${va3.price}','${va3.salestag}');" style="cursor: pointer;"><span>查看详情</span></a>
			                       		 	</div>
			                       	</div>
			                     </li>
			                        </c:if>
								 </c:forEach>
			                    </ul>
						 <div id="scroll" style="visibility: hidden;"> <span></span> </div>
					  </div>
					
					  </div>
									</td>
								</tr>
							</tbody>
						</table>
							
				
					</div>
					
	</div>
								<div  id="VAService" class="tan_chuang" style="border-radius: 4px;width: 521px;height: 341px;">
   
    	<div     style="width: 100%;height:24px;">
    		<a href="javascript:void(0);" onclick="closeInfo();">关闭</a>
    	</div>
		<div id="VAServiceInfo"  style="height: 400px; ">
		
		</div>
	</div>
			</section>
			<section id="view12" class="tabcontent" 	style="width: 100%; height: 100%;">
						<div style="float: left; width: 100%; height: 8%;">
					<table class="table1" style="text-align: center;">
					<thead>
						<tr style="height: 44px;">
							<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;购买时间至&nbsp;&nbsp;&nbsp;
								<div class="controls input-append date form_date"
									data-date-format="yyyy-MM-dd" data-link-field="">
									<input id="createDate3" size="16" type="text" value="" readonly>
									<span class="add-on"><i class="icon-remove"></i></span> <span
										class="add-on"><i class="icon-th"></i></span>
								</div> &nbsp;&nbsp;&nbsp;套餐名称&nbsp;&nbsp;&nbsp;<input id="comboName3"
								type="text"></input>&nbsp;&nbsp;&nbsp;<a
								href="javascript:void(0);" onclick="query3();">查询</a>
							</th>
						</tr>
					</thead>	
					</table>
				</div>
				<div
					style="float: left; width: 100%; height: 81%; margin-top: 5px;">
					<table id="data_table3" class="table1">
						<thead>
							<tr>
								<th width="15%">名称</th>
								<th width="15%">购买时间</th>
								<th width="15%">购买价格</th>
								<th width="25%">有效期</th>
								<th width="30%">操作</th>
							</tr>
						</thead>
						<tbody id="msgtable3">

						</tbody>
					</table>
				</div>
				<div id="example3" style="cursor: pointer;height: 10%;"></div>
																<div  id="VAService2" class="tan_chuang" style="border-radius: 4px;width: 521px;height: 341px;">
   
    	<div     style="width: 100%;height:24px;">
    		<a href="javascript:void(0);" onclick="closeInfo();">关闭</a>
    	</div>
		<div id="VAServiceInfo2"  style="height: 400px; ">
		
		</div>
	</div>
			</section>
			<section id="view13" class="tabcontent" 	style="width: 100%; height: 100%;">
						<div style="float: left; width: 100%; height: 8%;">
					<table class="table1" style="text-align: center;">
					<thead>
						<tr style="height: 44px;">
							<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发生时间至&nbsp;&nbsp;&nbsp;
								<div class="controls input-append date form_date"
									data-date-format="yyyy-MM-dd" data-link-field="">
									<input id="createDate" size="16" type="text" value="" readonly>
									<span class="add-on"><i class="icon-remove"></i></span> <span
										class="add-on"><i class="icon-th"></i></span>
								</div> &nbsp;&nbsp;&nbsp;车牌号&nbsp;&nbsp;&nbsp;<input id="carNo2"
								type="text"></input>&nbsp;&nbsp;&nbsp;<a
								href="javascript:void(0);" onclick="query2();">查询</a>
							</th>
						</tr>
					</thead>	
					</table>
				</div>
				<div
					style="float: left; width: 100%; height: 81%; margin-top: 5px;">
					<table id="data_table2" class="table1">
						<thead>
							<tr>
								<th width="15%">车牌号</th>
								<th width="15%">发送时间</th>
								<th width="40%">短信内容</th>
							</tr>
						</thead>
						<tbody id="msgtable">

						</tbody>
					</table>
				</div>
				<div id="example2" style="cursor: pointer;height: 10%;"></div>

			</section>
		</section>
	</div>

</body>
<script src="js/hellojs.js"></script>
<script src="js/vaservice_list.js"></script>
</html>