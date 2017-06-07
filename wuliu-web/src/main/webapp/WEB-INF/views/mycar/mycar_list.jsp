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
	<input id="different" hidden="true" value="${different}"/>
	<input id="anyList" hidden="true" />
	<button id="dbutton1" hidden="true"    data-toggle="modal" data-target="#myModal"  ></button>
	<button id="dbutton2" hidden="true"    data-toggle="modal" data-target="#myModal2" onclick="openmsg('anyList')" ></button>
		<div class="tab-pane fade in active" id="daiqueren" style="height: 91.6%;">
		<section class="radiotabs" style="width: 100%; height: 100%;">
			<input type="radio" name="tab" id="tab11" class="tabs"
				checked="checked">
<!-- 				 <label for="tab11"> 我的车库 </label>  -->
			<section id="view11" class="tabcontent"
				style="width: 100%; height: 100%;">
				<div style="float: left; width: 100%; height: 6%;">
						<table  class="table1" style="text-align: center;">
							<thead>
								<tr style="height: 44px;">
									<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车牌号&nbsp;&nbsp;&nbsp;
								<input id="carNo2" type="text"></input>	   
								&nbsp;&nbsp;&nbsp;最后定位城市&nbsp;&nbsp;&nbsp;<input  id="city" type="text"></input>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="query();" >查询</a> 
								&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" onclick="add();" >添加车辆</a>
								</th>
								</tr>
							</thead>	
						</table>
					</div>
					<div style="float: left; width: 100%; height: 82%;margin-top: 10px;">
						<table id="data_table2" class="table1" >
							<thead >
							<tr>
								<th width="10%">车牌号</th>
								<th width="10%">司机姓名</th>
								<th width="15%">线路描述</th>
								<th width="10%">车型</th>
								<th width="15%">最后位置</th>
								<th width="15%">定位时间</th>
								<th width="15%">操作</th>
							</tr>	
							</thead>
							<tbody id="msgtable">
							
							</tbody>
						</table>
					</div>
						<div id="example" style="cursor: pointer;height: 10%"></div>
							<div  id="mycaradd" class="tan_chuang" style="width:57%; border-radius: 4px;height: 60%;right: 25%;" >
    	<div     style="width: 100%;height:24px;">
    		<a href="javascript:void(0);" onclick="closeInfo();">关闭</a>
    	</div>
		<div id="mycaradd2"  style="height: 90%;overflow: auto;"   >
		
		</div>
	</div>
	
	</div>

		</section>
		</section>
		    <div  id="infoPublish" class="tan_chuang" style="border-radius: 4px;width: 60%;height: 35%;right: 30%;">
	   	<div onclick="closeInfo('infoPublish');"    style="width: 24px;height:24px; margin-bottom: 3px;background-image: url('images/k-2.jpg');">
	   		
	   	</div>
        <label id="lab_1"></label>
		<div data-options="region:'center',border:false" >
			<table id="gridTable" data-options="border:false">
			</table>
		</div>
	</div>
	<div  id="viewInfo" class="tan_chuang" style="border-radius: 4px;width: 60%;height: 70%;right: 30%;top: 10%;">
	   	<div onclick="closeInfo('viewInfo');"    style="width: 24px;height:24px; margin-bottom: 3px;background-image: url('images/k-2.jpg');">
	   		
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
				<input id="totalCount" hidden="true"></input>
					<table class="table2">
					<tbody>
						<tr>
							<td>发送至:</td>
							<td><input id="sendOwner"  ></input>
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
</body>
<script src="js/mycar_list.js" />
</html>
