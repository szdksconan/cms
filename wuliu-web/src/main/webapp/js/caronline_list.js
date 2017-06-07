// 百度地图API功能
//初始化地图参数方法
var map = new BMap.Map('allmap');
// var poi = new BMap.Point(104.0944580000,30.6677660000);

var premarker = 0;
var area = 1;
var areaname = '成都';
var markers = new Array();
var sendcarno;
var sendtel;
var areacity;

// 初始化下拉框等
$(function() {
	searchProvince();
	changeTable('caronline/allcarList');
})
// 点击导航该店左侧链表
function changeTable(url) {
	$('#list').load(url);
	map.clearOverlays();
	markers = new Array();
	premarker = 0;
}
// 下拉框
function searchProvince() {
	$.ajax({
		url : "common/getAreaInfo",
		dataType : 'json',
		type : "Post",
		data : {},
		success : function(data) {
			if (data != null) {
				
				
				var province = data.province;
				areacity = data.area;
				var html = '<option value=\'0\' ></option>';
				for (var i = 0; i < province.length; i++) {
					html += '	<option value="' + province[i].id + '">'
							+ province[i].name + '</option>';
				}
				$('#provinceList').html(html);
			}

		}
	});
}
function searchArea() {
	// 1:拿到select对象：
	var myselect = document.getElementById("provinceList");
	// 2：拿到选中项的索引：
	var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index

	// 3:拿到选中项options的value：
	var html = '<option value=\'0\' ></option>';
	for (var i = 0; i < areacity.length; i++) {
		if (areacity[i].pid == myselect.options[index].value) {
			var names = areacity[i].names.split(",");
			var ids = areacity[i].ids.split(",");
			for (var j = 0; j < names.length; j++)

				html += '<option value="' + ids[j] + '">' + names[j]
						+ '</option>';
		}

	}
	$('#areaList').html(html);
};
// 根据city重新锚点
function searchCity(tag) {
	var carNo = $('#carNo').val();
	// 1:拿到select对象：
	var myselect = document.getElementById("areaList");
	// 2：拿到选中项的索引：
	var index = myselect.selectedIndex;
	var myGeo = new BMap.Geocoder();
	area = myselect.options[index].value;
	// 将地址解析结果显示在地图上，并调整地图视野
	if(tag == 2){
	myGeo.getPoint(myselect.options[index].text, function(point) {
		if (point) {
			map.centerAndZoom(point, 13);
			map.enableScrollWheelZoom();
			// markers = new Array();
		}
	}, myselect.options[index].value);
	}
	// query();
	// searchLeft(myselect.options[index].value,carNo);
	query_mycar();

}
// 右侧地图锚点并加载marker
function searchMap(data, type) {

	if (data != null) {
		$
				.each(
						data,
						function(index, item) {

							var poi = new BMap.Point(item.carLongitude,
									item.carLatitude);
							var myIcon = new BMap.Icon("images/w.gif",
									new BMap.Size(50, 50));
							var marker = new BMap.Marker(poi, {
								icon : myIcon
							}); // 创建标注
							var content = "";
							if (type == 1) {
								content += '<div style="margin:0;line-height:20px;padding:2px;">'
										+ '<img src="" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>车牌号:'
										+ item.carNo
										+ '<br/>车长:'
										+ item.carLength
										+ '载重:'
										+ item.carWeigth
										+ '体积:'
										+ item.carVolume
										+ '<br/>电话:'
										+ item.carTel;
										+ '<br/>';
							}
							else{
								content += '<div style="margin:0;line-height:20px;padding:2px;">'
									+ '<img src="" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>车牌号:'
									+ item.carNo
									+ '<br/>车长:'
									+ item.carLength
									+ '载重:'
									+ item.carWeigth
									+ '体积:'
									+ item.carVolume
									+ '<br/>流向: <br/>'
									+ '<button  onclick=\"openmsgWindow(\''+item.carNo+'\','+item.carTel+',\''+item.carOwner+'\')\"> 发送短信</button>';
					
							}
							var opts = {
								title : "信息栏展示",
								width : 350, // 宽度
								height : 200,
								border : 0, // 高度
								panel : "panel", // 检索结果面板
								enableAutoPan : true, // 自动平移
								searchTypes : []
							};
							var html = content;// html设置
							var infoWindow = new BMap.InfoWindow(html, opts);// 创建窗口信息
							marker.infoWindow = infoWindow;
							var carLongitude = item.carLongitude;
							var carLatitude = item.carLatitude;

							marker.addEventListener("click", function(e) {
								var changeIcon = new BMap.Icon("images/w2.gif",
										new BMap.Size(50, 50));
								var preIcon = new BMap.Icon("images/w.gif",
										new BMap.Size(50, 50));
								if (premarker != 0) {
									premarker.setIcon(preIcon);
								}

								this.setIcon(changeIcon);
								this.openInfoWindow(e.target.infoWindow);
								premarker = this;

							});
							// 判断marker是否已存在队列中中
							var count = 0;
							for (var i = 0; i < markers.length; i++) {
								if (marker.point.lng == markers[i].point.lng
										&& marker.point.lat == markers[i].point.lat)
									count++;
							}
							if (count == 0) {
								markers.push(marker);

							}
							map.addOverlay(marker);

						});
	}

}

// 左侧列表控制marker
function openmarker(lng, lat) {
	var markerAmazing;
	// alert(markers.length);
	for (var i = 0; i < markers.length; i++) {
		var marker = markers[i];
		var point = marker.point;
		if (point.lng == lng && point.lat == lat) {
			markerAmazing = marker;
			break;
		}

	}
	map.centerAndZoom(point, 15);
	changeicon(markerAmazing);

}
// 改变marker并展开
function changeicon(marker) {
	var changeIcon = new BMap.Icon("images/w2.gif", new BMap.Size(50, 50));
	var preIcon = new BMap.Icon("images/w.gif", new BMap.Size(50, 50));
	if (premarker != 0) {
		premarker.setIcon(preIcon);
	}

	marker.setIcon(changeIcon);
	marker.openInfoWindow(marker.infoWindow);
	premarker = marker;
}

// 后台添加删除关注记录
function changeFocus(id, state) {
	$.ajax({
		url : "caronline/changeFocus",
		datatype : 'json',
		type : "Post",
		data : {
			id : id,
			state : state
		},
		async : false,// 使用同步的方式,true为异步方式
		success : function(data) {
			if (data != null) {
				$.bootstrapGrowl("操作成功!", {
					type : 'success', // (null, 'info', 'danger', 'success')
					align : 'center', // ('left', 'right', or 'center')
					offset : {
						from : 'top',
						amount : 288
					}, // 'top', or 'bottom'
					width : 140, // (integer, or 'auto')
					delay : 300,
					allow_dismiss : false, // If true then will display a cross
											// to close the popup.
				});
			}

		}
	});
}
function refocus(obj, id, state) {
	// $(obj).parent().parent().remove();
	changeFocus(id, state);
	query_mycar();
}
// 查询短信记录
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

											html += '<td>';
											html += '<a id=\"fa'
													+ item.id
													+ '\"  href=\"javascript:void(0);\" onclick=\"delMsg(\''
													+ item.id
													+ '\')\" style=\"cursor: pointer;\"><span>删除</span></a>';
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
																		html += '<td>';
																		html += '<a id=\"fa'
																				+ item.id
																				+ '\"  href=\"javascript:void(0);\" onclick=\"delMsg(\''
																				+ item.id
																				+ '\')\" style=\"cursor: pointer;\"><span>删除</span></a>';
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
// 删除短信记录
function delMsg(id) {
	$.ajax({
		url : "caronline/delMsg",
		datatype : 'json',
		type : "Post",
		data : {
			id : id
		},
		async : false,// 使用同步的方式,true为异步方式
		success : function(data) {
			if (data != null) {
				$.bootstrapGrowl("删除成功!", {
					type : 'success', // (null, 'info', 'danger', 'success')
					align : 'center', // ('left', 'right', or 'center')
					offset : {
						from : 'top',
						amount : 288
					}, // 'top', or 'bottom'
					width : 140, // (integer, or 'auto')
					delay : 300,
					allow_dismiss : false, // If true then will display a cross
											// to close the popup.
				});
			}
		}
	});
	query2();
}
// 将要接收短信商家赋值给sendcarno
function openmsg(carNo, tel, carOwner) {
	sendcarno = carNo;
	sendtel = tel;
	$('#sendOwner').val(carOwner);
	$.ajax({
		url : "caronline/getMsgSum",
		datatype : 'json',
		type : "Post",
		data : {
			vaServiceType : '8003'
		},
		async : false,// 使用同步的方式,true为异步方式
		success : function(data) {
			if (data != null) {
				$('#totalCount').val(data.msgSum);
				if (data.msgSum <= 0)
					// 按钮显示灰色
					$('#sendbutton').attr("disabled", true);
			}
		}
	});
}
//将要接收短信商家赋值给sendcarno
function openmsgWindow(carNo, tel, carOwner) {
	$('#msgwindow').click();
	openmsg(carNo, tel, carOwner);
}
// 发送短信
function sendmsg() {
	var msginfo = $('#msginfo').val();
	$.ajax({
		url : "caronline/sendMsg",
		datatype : 'json',
		type : "Post",
		data : {
			sendcarno : sendcarno,
			sendtel : sendtel,
			msginfo : msginfo,
			type : '8003'
		},
		async : false,// 使用同步的方式,true为异步方式
		success : function(data) {
			if (data != null) {
				$.bootstrapGrowl("发送成功!", {
					type : 'success', // (null, 'info', 'danger', 'success')
					align : 'center', // ('left', 'right', or 'center')
					offset : {
						from : 'top',
						amount : 288
					}, // 'top', or 'bottom'
					width : 140, // (integer, or 'auto')
					delay : 300,
					allow_dismiss : false, // If true then will display a cross
											// to close the popup.
				});
			}
		}
	});
}
function dragend(){
	//拖拽得到当前所属省市

	var center = map.getCenter();
	var lng = center.lng;
	var lat = center.lat;
	//	 alert(lng+','+lat);
	var myGeo = new BMap.Geocoder();
	myGeo
			.getLocation(
					new BMap.Point(lng, lat),
					function(result) {
						if (result) {
							// 	 			          		 $.ajax({
							// 	 			      		      url: "caronline/getCodeByName",
							// 	 			      		      datatype: 'json',
							// 	 			      		      type: "Post",
							// 	 			      		      data: {province:result.addressComponents.province,page:1,city:result.addressComponents.city},
							// 	 			      		      success: function (data) {

							// 	 			      		      }
							// 	 			          		 });	
							// 1:拿到select对象：
							var myselect = document
									.getElementById("provinceList");

							for (var i = 0; i < myselect.options.length; i++) {
								if (myselect.options[i].text == result.addressComponents.province) {
									myselect.options[i].selected = true;
									break;
								}
							}
							searchArea();
							var myselect2 = document
									.getElementById("areaList");

							for (var i = 0; i < myselect2.options.length; i++) {
								if (myselect2.options[i].text == result.addressComponents.city) {
									myselect2.options[i].selected = true;
									break;
								}
							}
							searchCity(1);
						}
					});
}
