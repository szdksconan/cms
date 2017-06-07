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
	
	<div class="tab-pane fade in active" id="daiqueren" style="height: 91.6%;">
<!-- 		<div class="panel panel-default" style="width: 100%;height: 100%;margin-top: 5px;"> -->
		<section class="radiotabs" style="width: 100%; height: 100%;">
			<input type="radio" name="tab" id="tab11" class="tabs"
				checked="checked">
<!-- 				 <label for="tab11"> 在线车辆 </label>  -->
<!-- 				<input -->
<!-- 				type="radio" name="tab" id="tab12" class="tabs"> <label -->
<!-- 				for="tab12" onclick="query2();"> 短信记录 </label> -->
			<section id="view11" class="tabcontent"
				style="width: 100%; height: 100%;">

				<div style="float: left; width: 40%; height: 85%;">

					<div class="navbar">
						<div class="navbar-inner">
							<ul class="nav">
								<li class="active"><a href="#"
									onclick="changeTable('caronline/allcarList');"
									data-toggle="tab">在线车库</a></li>
								<li ><a href="#"
									onclick="changeTable('caronline/mycarList');" data-toggle="tab">我的车库</a></li>
								<li><a href="#"
									onclick="changeTable('caronline/myfocusList');"
									data-toggle="tab">我的关注</a></li>
								
							</ul>
						</div>
					</div>

					<div id="list" class="panle-body"
						style="height: 460px; margin: 10px auto;"></div>

				
				</div>
				<div class="panel panel-default"
					style="float: left; width: 59%; height: 96%; margin-left: 10px;">
					<div style="height: 42px; ">
						<table class="table2">
							<thead>
								<th><select id="provinceList" onchange="searchArea();" style="width: 135px;"
							disabled="disabled">
						</select> <select id="areaList" onchange="searchCity(2);" style="width: 135px;"
							disabled="disabled">
						</select></th>
							</thead>
						</table>
					</div>
					<div id="allmap" style="height: 90%; margin-top: 5px;"></div>
				</div>
			</section>
			<section id="view12" class="tabcontent"
				style="width: 100%; height: 100%;">
				<div style="float: left; width: 100%; height: 50px;">
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
					style="float: left; width: 100%; height: 450px; margin-top: 5px;">
					<table id="data_table2" class="table1">
						<thead>
							<tr>
								<th width="15%">车牌号</th>
								<th width="15%">发送时间</th>
								<th width="37%">短信内容</th>
								<th width="30%">操作</th>
							</tr>
						</thead>
						<tbody id="msgtable">

						</tbody>
					</table>
				</div>
				<div id="example2" style="cursor: pointer;margin-top: 66px;"></div>

			</section>
		</section>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"  style="border-radius:5px;width: 408px;"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" >
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">发送短信</h4>
				</div>
				<div class="modal-body">
					<table class="table2">
					<tbody>
						<tr>
							<td>发送至:</td>
							<td><input id="sendOwner"  readonly="readonly"></input></td>
						</tr>
						<tr>
							<td>剩余条数:</td>
							<td><input id="totalCount" readonly="readonly"></input></td>
						</tr>
						<tr>
							<td colspan="2">内容:(60字左右):</td>
						</tr>
						<tr>
							<td colspan="2">
								<textarea id="msginfo" rows="4" cols="35"></textarea>
							</td>
						</tr>
					</tbody>	
					</table>
				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭
					</button>
					<button type="button" id="sendbutton" class="btn btn-primary" data-dismiss="modal" onclick="sendmsg()" >发送</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="changeDiv('vaservice/vaserviceList')">购买套餐</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
		<button id="msgwindow" data-toggle="modal" data-target="#myModal" style="display: none;" ></button>
	<!-- /.modal -->
</body>
<script src="js/caronline_list.js"></script>
<script type="text/javascript">
//datetimepick插件加载
$('.form_date').datetimepicker({
    language:  'zh-CN',
    weekStart: 1,
    todayBtn:  1,
	autoclose: 1,
	todayHighlight: 1,
	startView: 2,
	minView: 2,
	forceParse: 0
});

</script>
</html>