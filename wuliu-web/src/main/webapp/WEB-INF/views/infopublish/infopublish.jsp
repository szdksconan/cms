<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="edge" />
<title>发布信息</title>
<script type="text/javascript" src="${ctx}/js/infopublish.js"></script>
</head>
<body>
	<input id="different" hidden="true" value=" ${different}"/>
	<input id="anyList" hidden="true" />
	<button id="dbutton1" hidden="true"    data-toggle="modal" data-target="#myModal"  ></button>
	<button id="dbutton2" hidden="true"    data-toggle="modal" data-target="#myModal2" onclick="openmsg('anyList')" ></button>
		<div class="tab-pane fade in active" id="daiqueren" style="height: 91%;">
         <section class="radiotabs">
                <input type="radio" name="tab" id="tab11" class="tabs" checked="checked">
                <label for="tab11">
                    货源信息
                </label>
                <input type="radio" name="tab" id="tab12" class="tabs">
                <label for="tab12">
                   车源信息
                </label>
                <input type="radio" name="tab" id="tab13" class="tabs">
                <label for="tab13">
                   历史信息
                </label>
                
                <section id="view11" class="tabcontent" style="width: 100%;">
                	<div id="loadHuoyuan"></div>
       			</section>
		        <section id="view12" class="tabcontent" style="width: 100%;height: 90%">
	        		<div id="loadCheyuan"></div>
		        </section>
		        <section id="view13" class="tabcontent" style="width: 100%;">
		  
                    <div class="navbar">
                        <div class="navbar-inner">
                            <ul class="nav">
                                <li class="active">
                                    <a href="#" onclick="changeTable('huoyuan');" data-toggle="tab">历史货源</a>
                                </li>
                                <li>
                                    <a href="#" onclick="changeTable('cheyuan');" data-toggle="tab">历史车源</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <table id="historyHuoyuanList" data-options="border:false" class="table">
                    </table>
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
</html>