$(function() {
		map.setMaxZoom(16);
		map.setMinZoom(13);
		//map.addEventListener("moveend",function(e){
		//	

		//})
		//为地图添加推拽事件
		map.addEventListener(
						"dragend",dragend
						);
		$('#provinceList').attr("disabled", false);
		$('#areaList').attr("disabled", false);
		var myGeo = new BMap.Geocoder();
		map.addControl(new BMap.NavigationControl());
		// 将地址解析结果显示在地图上，并调整地图视野    
		myGeo.getPoint(areaname, function(point) {
			if (point) {
				map.centerAndZoom(point, 13);
				map.enableScrollWheelZoom();
				//	 markers = new Array(); 
			}
		}, area);
		query_mycar();

	});
	//加载我的车库列表
	function query_mycar() {
		var carNo = $('#carNo').val();
		//  1:拿到select对象： 
		var myselect = document.getElementById("areaList");
		//  2：拿到选中项的索引：
		var index = myselect.selectedIndex;
		var city = area;
		if (index > 0) {
			area = myselect.options[index].value;
			areaname = myselect.options[index].text;
		}

		$('#example_mycar').html('');
		$
				.ajax({
					url : "caronline/getPageDataAllcar",
					datatype : 'json',
					type : "Post",
					data : {
						carNo : carNo,
						page : 1,
						city : city
					},
					success : function(data) {
						if (data != null) {
							
							data = $.parseJSON(data);  
				
							var html = '';
							$
									.each(
											data.list,
											function(index, item) { //遍历返回的json
												html += '<tr>';
												html += '<td>' + item.carNo;
												html += '</td>';
												html += '<td>' + item.carOwner;
												html += '</td>';
												html += '<td>'
														+ item.carCondition;
												html += '</td>';
												html += '<td>'
														+ item.carLineDesc;
												html += '</td>';
												html += '<td>';
												html += '<a href=\"javascript:void(0);\" onclick=\"openmarker('
														+ item.carLongitude
														+ ','
														+ item.carLatitude
														+ ')\" style=\"cursor: pointer;\"><span>定位</span></a>';
												html += '&nbsp;|&nbsp;';
												html += '<a href=\"javascript:void(0);\"  onclick=\"refocus(this,\''
														+ item.id
														+ '\',1)\" style=\"cursor: pointer;\"><span>关注</span></a>';
												html += '&nbsp;|&nbsp;';
												html += '<a href=\"javascript:void(0);\" onclick=\"openmsg(\''
														+ item.carNo
														+ '\','
														+ item.carTel
														+ ',\''
														+ item.carOwner
														+ '\')\"   data-toggle=\"modal\" data-target=\"#myModal\" style=\"cursor: pointer;\"><span>发送短信</span></a>';
												html += '</td>';
												html += '</tr>';

											});
							$("#data_table_mycar").html(html);
							searchMap(data.maplist, 2);
							var pageCount = data.pageCount; //取到pageCount的值(把返回数据转成object类型)
							var currentPage = data.CurrentPage; //得到urrentPage
							var options = {
								size : 'mini',
								bootstrapMajorVersion : 2, //版本
								currentPage : currentPage, //当前页数
								totalPages : pageCount, //总页数
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
								},//点击事件，用于通过Ajax来刷新整个list列表
								onPageClicked : function(event, originalEvent,
										type, page) {
									$
											.ajax({
												url : "caronline/getPageDataAllcar",
												datatype : 'json',
												type : "Post",
												data : {
													carNo : carNo,
													page : page,
													city : city
												},
												success : function(data) {
													if (data != null) {
														data = $.parseJSON(data);  
														var html = '';
														$
																.each(
																		data.list,
																		function(
																				index,
																				item) {
																			html += '<tr >';
																			html += '<td>'
																					+ item.carNo;
																			html += '</td>';
																			html += '<td>'
																					+ item.carOwner;
																			html += '</td>';
																			html += '<td>'
																					+ item.carCondition;
																			html += '</td>';
																			html += '<td>'
																					+ item.carLineDesc;
																			html += '</td>';
																			html += '<td>';
																			html += '<a href=\"javascript:void(0);\" onclick=\"openmarker('
																					+ item.carLongitude
																					+ ','
																					+ item.carLatitude
																					+ ')\" style=\"cursor: pointer;\"><span>定位</span></a>';
																			html += '&nbsp;|&nbsp;';
																			html += '<a href=\"javascript:void(0);\"  onclick=\"refocus(this,\''
																					+ item.id
																					+ '\',1)\" style=\"cursor: pointer;\"><span>关注</span></a>';
																			html += '&nbsp;|&nbsp;';
																			html += '<a href=\"javascript:void(0);\" onclick=\"openmsg(\''
																					+ item.carNo
																					+ '\','
																					+ item.carTel
																					+ ',\''
																					+ item.carOwner
																					+ '\')\"  data-toggle=\"modal\" data-target=\"#myModal\" style=\"cursor: pointer;\"><span>发送短信</span></a>';
																			html += '</td>';
																			html += '</tr>';
																		});
														$("#data_table_mycar")
																.html(html);
														//Map添加marker
														searchMap(data.maplist, 2);
													}
												}
											});
								}
							};

							if (data.pageCount > 0) {
								$('#example_mycar').bootstrapPaginator(options);
							}
						}
					}
				});
	}