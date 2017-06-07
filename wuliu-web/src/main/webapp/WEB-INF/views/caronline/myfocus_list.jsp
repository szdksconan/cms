<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<div class="panle-title" style="height: 45px; margin-top: 5px;">
					<table class="table1" style="text-align: center;">
						<thead>
						<tr style="height: 44px;">
						
								<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;车牌号&nbsp;&nbsp;&nbsp;<input
									id="carNo"></input>&nbsp;&nbsp;&nbsp;<a
									href="javascript:void(0);" onclick="query_mycar();">查询</a>
								</th>
							</tr>
							</thead>
						</table>
		<table  class="table1" style="text-align: center;margin-top: 5px;">
							<thead>
								<tr>
								<th style="width:18%;text-align:center;">车牌号</th>
								<th style="width:15%;text-align:center;">车主</th>
								<th style="width:15%;text-align:center;">状态</th>
								<th style="width:17%;text-align:center;">流向</th>
								<th style="width:35%;text-align:center;">操作</th>
								</tr>
							</thead>
							<tbody id="data_table_mycar">
							
							</tbody>
						</table>
							<div id="example_mycar" style="cursor: pointer;margin-top: 10px;"></div>
	</div>
	<script src="js/myfocus_list.js"></script>