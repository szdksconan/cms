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

//弹出框
function openInfo(measurePeriod,id,name,price,salestag) {

			document.getElementById("VAService").style.display = "block";
			$('#VAServiceInfo').load('vaservice/vaserviceAddPage?id='+id+'&name='+name+'&price='+price+'&salestag='+salestag+'&measurePeriod='+measurePeriod);

	}
//隐藏弹出框
function closeInfo() {
		document.getElementById("VAService").style.display = "none";
		document.getElementById("VAService2").style.display = "none";
	}
	
function openHis(){
	document.getElementById("VAService").style.display = "block";
	$('#VAServiceInfo').load('vaservice/vaserviceHisPage');
}	
function openHisMsg(){
	document.getElementById("VAService").style.display = "block";
	$('#VAServiceInfo').load('vaservice/vaserviceHisMsgPage');
}	
	
//查询短信记录
function query2() {
	var createDate = $('#createDate').val();
	var carNo = $('#carNo2').val();
	// 首先置空分页标签
	$('#example2').html('');
	$
			.ajax({
				url : "caronline/getMsgData",
				datatype : 'json',
				type : "Post",
				data : {
					createDate : createDate,
					carNo : carNo,
					page : 1
				},
				success : function(data) {
					if (data != null) {
						var html = '';
						$
								.each(
										data.list,
										function(index, item) { // 遍历返回的json
											html += '<tr>';
											html += '<td>' + item.carNo;
											html += '</td>';
											html += '<td>' + item.createDate;
											html += '</td>';
											html += '<td>' + item.msgDesc;
											html += '</td>';
											html += '</tr>';

										});
						$("#msgtable").html(html);
						//searchMap(data,type);
						var pageCount = data.pageCount; // 取到pageCount的值(把返回数据转成object类型)
						var currentPage = data.CurrentPage; // 得到urrentPage
						var options = {
							size : 'normal',
							bootstrapMajorVersion : 2, // 版本
							currentPage : currentPage, // 当前页数
							totalPages : pageCount, // 总页数
							itemTexts : function(type, page, current) {
								switch (type) {
								case "first":
									return "<<";
								case "prev":
									return "<";
								case "next":
									return ">";
								case "last":
									return ">>";
								case "page":
									return page;
								}
							},// 点击事件，用于通过Ajax来刷新整个list列表
							onPageClicked : function(event, originalEvent,
									type, page) {
								$
										.ajax({
											url : "caronline/getMsgData",
											datatype : 'json',
											type : "Post",
											data : {
												createDate : createDate,
												carNo : carNo,
												page : page
											},
											success : function(data) {
												if (data != null) {
													var html = '';
													$
															.each(
																	data.list,
																	function(
																			index,
																			item) { // 遍历返回的json
																		html += '<tr>';
																		html += '<td>'
																				+ item.carNo;
																		html += '</td>';
																		html += '<td>'
																				+ item.createDate;
																		html += '</td>';
																		html += '<td>'
																				+ item.msgDesc;
																		html += '</td>';
																		html += '</tr>';

																	});
													$("#msgtable").html(html);
												}
											}
										});
							}
						};
						if (data.pageCount > 0) {
							$('#example2').bootstrapPaginator(options);
						}
					}

				}
			});
}
//查询订购记录
function query3() {
	var createDate = $('#createDate3').val();
	var comboName = $('#comboName3').val();
	// 首先置空分页标签
	$('#example3').html('');
	$
			.ajax({
				url : "vaservice/getHisData",
				datatype : 'json',
				type : "Post",
				data : {
					createDate : createDate,
					comboName : comboName,
					page : 1
				},
				success : function(data) {
					if (data != null) {
						var html = '';
						$
								.each(
										data.list,
										function(index, item) { // 遍历返回的json
											html += '<tr>';
											html += '<td>' + item.vaServiceName;
											html += '</td>';
											html += '<td>' + item.purchaseDate;
											html += '</td>';
											html += '<td>' + item.price;
											html += '</td>';
											html += '<td>'+item.effectDate;
											html +='</td>'
											html += '<td>';
										    html += '<a '
												 + '  href=\"javascript:void(0);\" onclick=\"openBuyFun(\''
												 + item.vaServiceID
												 + '\')\" style=\"cursor: pointer;\"><span>再次购买</span></a>';
												 	 
											html += '</td>';
											html += '</tr>';

										});
						$("#msgtable3").html(html);
						//searchMap(data,type);
						var pageCount = data.pageCount; // 取到pageCount的值(把返回数据转成object类型)
						var currentPage = data.CurrentPage; // 得到urrentPage
						var options = {
							size : 'normal',
							bootstrapMajorVersion : 2, // 版本
							currentPage : currentPage, // 当前页数
							totalPages : pageCount, // 总页数
							itemTexts : function(type, page, current) {
								switch (type) {
								case "first":
									return "<<";
								case "prev":
									return "<";
								case "next":
									return ">";
								case "last":
									return ">>";
								case "page":
									return page;
								}
							},// 点击事件，用于通过Ajax来刷新整个list列表
							onPageClicked : function(event, originalEvent,
									type, page) {
								$
										.ajax({
											url : "vaservice/getHisData",
											datatype : 'json',
											type : "Post",
											data : {
												createDate : createDate,
												carNo : carNo,
												page : page
											},
											success : function(data) {
												if (data != null) {
													var html = '';
													$
															.each(
																	data.list,
																	function(
																			index,
																			item) { // 遍历返回的json
																		html += '<tr>';
																		html += '<td>' + item.vaServiceName;
																		html += '</td>';
																		html += '<td>' + item.purchaseDate;
																		html += '</td>';
																		html += '<td>' + item.price;
																		html += '</td>';
																		html += '<td>'+item.effectDate;
																		html +='</td>'
																		html += '<td>';
																	    html += '<a '
																			 + '  href=\"javascript:void(0);\" onclick=\"openBuyFun(\''
																			 + item.vaServiceID
																			 + '\')\" style=\"cursor: pointer;\"><span>再次购买</span></a>';
																			 	 
																		html += '</td>';
																		html += '</tr>';

																	});
													$("#msgtable3").html(html);
												}
											}
										});
							}
						};
						if (data.pageCount > 0) {
							$('#example3').bootstrapPaginator(options);
						}
					}

				}
			});
}
//再次購買
function openBuyFun(id){

	document.getElementById("VAService2").style.display = "block";
	$('#VAServiceInfo2').load('vaservice/vaserviceAddPage2?id='+id);
}