$(document).ready(function() {
		// 对日期控件进行初始化
	laydate({
		elem : '#createTime',
		event : 'focus'
	});
	
	//物质类别
	 $.cxSelect.defaults.emptyStyle = 'none';
	    $("#element_id").cxSelect({
			url:'../js/common/productJson.json',
			selects : ['materials1','materials2','materials3','materials4'],
			nodata: 'none'
		});
	// 对地址信息进行初始化
	    $('#jingyingdizhi').click(function(e){
	    	SelCity(this,e);
	    });
	// 地图放大
	//对下拉框进行初始化
		$(".magnify").click(function() {
		layer.open({
			type : 1,
			title : false,
			closeBtn : 0,
			shadeClose : true,
			area : [ '800px', '600px' ],
			skin : 'yourclass',
			content : '<div id="magnifyMap"></div>'
		});
		// 百度地图
		initComp6("1312312313");
		$(".swiper-container").mousemove(function() {
			$(this).find(".sides-btn").show();
		});
		$(".swiper-container").mouseout(function() {
			$(this).find(".sides-btn").hide();
		});
		// 修改位置
		var qy_edit = $('.edit_btn');
		layer.config({
			extend : [ 'skin/myskin.css' ]
		// 加载新皮肤
		});
		initComp7("1312312313");
	});
	
	$(".swiper-container").mousemove(function() {
		$(this).find(".sides-btn").show();
	});
	$(".swiper-container").mouseout(function() {
		$(this).find(".sides-btn").hide();
	});

	// 修改位置
	var qy_edit = $('.edit_btn');
	layer.config({
		extend : [ 'skin/myskin.css' ]
	// 加载新皮肤
	});
	// 修改基本信息
	qy_edit.on('click', function() {
		// 对于基本信息进行回显
		initbaseInfo();
//		$('#logoList').empty();
//		 loadPic('logoList','6','deletelogo');
		layer.open({
			title : [ '修改基本信息',
					'font-size:18pt;text-align:center' ],
			skin : 'layui-layer-cms',
			closeBtn : 2,
			offset : 'center', // 右下角弹出
			type : 1,
			area : [ '800px', '600px' ],// [width,height]
			content : $('#changBaseInfo'),
			btn : [ '提交', '取消' ],
			yes : function(index, layero) {
				editBaseInfo();
				layer.close(index);
			}
		});
	});
	// 对加工能力实现编辑
	$('#ablilty').on('click',function() {
		$('#jiagognlist').empty();
		initJiagongInfo();
		loadPic('jiagognlist','2','deletejiagong');
		/*loadUploadList('#jiagognlist');*/
		layer.open({
			title : [ '修改加工能力信息',
					'font-size:18pt;text-align:center' ],
			skin : 'layui-layer-cms',
			closeBtn : 2,
			offset : 'center', // 右下角弹出
			type : 1,
			area : [ '800px', '697px' ],// [width,height]
			content : $('#changAbility'),
			btn : [ '提交', '取消' ],
			yes : function(index,layero) {
				editJiagong();
				layer.close(index);
			}
		});
	});
	// 对上传的图片进行配置
	$("#uplodjiagong").uploadPreview({
		fileName : 'jiagong',
		fileId : 'test',
		ListId : '#jiagognlist'
	});
	// 对继续添加进行配置
	$("#reuploadjiagong").uploadPreview({
		fileName : 'jiagong',
		fileId : 'test',
		ListId : '#jiagognlist'
	});

					$('#zizhi-btn').on('click',function() {
						$('#zizhilist').empty();
						
						loadPicInput('zizhilist','4','zizhiFileKeys');
						
						//loadUploadList('#zizhilist');
						layer.open({
									title : [ '修改资质信息',
											'font-size:18pt;text-align:center' ],
									skin : 'layui-layer-cms',
									closeBtn : 2,
									offset : 'center', // 右下角弹出
									type : 1,
									area : [ '800px', '600px' ],// [width,height]
									content : $('#changeZizhi'),
									btn : [ '提交', '取消' ],
									yes : function(index,
											layero) {
										var msg= updatezizhi();
										if(msg =="1"){
											layer.close(index);
										}
										
									}
								});
					});
					// 对资质图片继续上传进行配置
					$("#reuploadzizhi").uploadPreview({
						fileName :'zizhi',
						fileId : 'test2',
						ListId : '#zizhilist',
						isInput : true,
						inputName : 'zizhiname'
					});
					$('#qy-contact').on('click',function() {
						$('#contactList').empty();
						$("#addr").click(function(e) {
							SelCity(this, e);
						});
						// 对企业联系信息进行初始化
						initcontact();
						loadPic('contactList','3','delContactFileKeys');
						layer.open({
									title : [ '修改联系信息','font-size:18pt;text-align:center' ],
									skin : 'layui-layer-cms',
									closeBtn : 2,
									offset : 'center', // 右下角弹出
									type : 1,
									area : [ '800px', '600px' ],// [width,height]
									content : $('#changeContact'),
									btn : [ '提交', '取消' ],
									yes : function(index,layero) {
										updateCompBase();
										layer.close(index);
									}
								});
					});
					
					// 对联系人在次上传图片进行配置
					$("#recontactUpload").uploadPreview({
						fileName : 'upload',
						fileId : 'test3',
						ListId : '#contactList'
					});
					// 修改业务联系人
	
	
	 $("#logoBtn").singleUploadPreview({
	 	ListId : "#logoList",
	 	fileId : "logofile",
	 	fileName : "logoname"
	 });
	 loadPic('logoList','6','deletelogo');
	
	
	
	
	// 修改业务联系人

	$('#ywcontact').on('click',function() {
		layer.open({
			title : [ '修改业务联系人','font-size:18pt;text-align:center' ],
			skin : 'layui-layer-cms',
			closeBtn : 2,
			offset : 'center', // 右下角弹出
			type : 1,
			area : [ '800px', '600px' ],// [width,height]
			content : $('#changywlianxi'),
			yes : function(index,layero) {
				/*
				 * addContact();
				 * layer.close(index);
				 */
			}
		});

		addTable();

		$('#ywtable').bootstrapTable({
			url : '../comp/getContact?compId=1312312313',
			dataType : 'json',
			method : 'post', // 请求方式（*）
			editable : true, // 开启编辑模式
			clickToSelect : true,
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存
			pagination : true, // 是否显示分页
			// queryParamsType :
			// '', //传递参数
			sortable : false, // 是否启用排序
			// sortOrder :
			// "asc", //排序方式
			sidePagination : "client", // 分页方式：client客户端分页，server服务端分页
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 7, // 每页的记录行数
			pageList : [ 7, 10 ], // 可供选择的每页的行数
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端
			showColumns : false, // 是否显示所有的列
			showRefresh : false, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			width : 'auto',
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			paginationHAlign : 'right', // 分页组件显示位置
			paginationVAlign : 'bottom', // 分页信息显示位置
			paginationDetailHAlign : 'left', // right,
			// left
			columns : [
					{
						title : '序号',
						field : 'id',
						sortable : true
					},
					{
						title : '联系人',
						field : 'contactPerson',
						sortable : true
					},
					{
						title : '业务类型',
						field : 'businessType',
						sortable : true
					},
					{
						title : '手机',
						field : 'phone',
						sortable : true
					},
					{
						title : '固定电话',
						field : 'tel',
						sortable : true
					},
					{
						title : '电子邮箱',
						field : 'email',
						sortable : true
					},
					{
						title : '操作',
						edit : false,
						field : 'action',
						formatter : function(value,row,index) {
							return '<a href="javascript:void(0)" onclick="updateContact(\''
									+ row.id
									+ '\',\''+compidval+'\')">修改</a>|<a href="javascript:void(0)" onclick="delContact(\''+ row.id+ '\',\''+compidval+'\')">删除</a>';
						}
					}]
		});


	});									
	$('.position').on('click',function() {
		var jingyingdizhi = $('#jingyingdizhi').val();
		var zuobiao = $('#zuobiao').val();
		var qyname = $('#qyname').val();
		if (jingyingdizhi && qyname) {
			// 对百度地图进行初始化
			layer.open({
						title : [ '百度地图定位功能','font-size:18pt;text-align:center' ],
						skin : 'layui-layer-cms',
						closeBtn : 2,
						offset : 'center', // 右下角弹出
						type : 1,
						area : [ '800px','600px' ],// [width,height]
						content : $('#ditu'),
						btn : [ '提交', '取消' ],
						yes : function(index,layero) {
							$('#zuobiao').val($('#jingweidu').val());
							layer.close(index);
						}
					});
			initMap(qyname,zuobiao);
//			searchByStationName(jingyingdizhi);
		} else {
//			alert('请填写经营地址或者公司名称');
		}
	});
	// 修改企业门户图片
	$('.edit_img1').on('click',function() {
		/*$('#menhulist').empty();*/
		$('#reattachId').val($('#qiattachId').val())
		$('#reqyname').val($(".qy_name").html());
		layer.open({
			title : [ '修改企业门户图片',
					'font-size:18pt;text-align:center' ],
			skin : 'layui-layer-cms',
			closeBtn : 2,
			offset : 'center', // 右下角弹出
			type : 1,
			area : [ '600px', '500px' ],// [width,height]
			content : $('#qymenhu'),
			btn : [ '提交', '取消' ],
			yes : function(index,layero) {
				if(!$("#statuss").val()){
					ajaxFileUpload();
				}
				layer.close(index);
			}
		});
//						slingleUploadListLength('#menhulist');
	});
	console.log(123)
	
	// 对企业门户信息修改图片进行配置
	$("#menhu").singleUploadPreview({
		ListId : '#menhulist',
		fileId : 'filemenhuId',
		fileName : 'menhu'
	});
	loadPic('menhulist','5','deletelogPic');
	var address_province = [ {
		label : '请选择',
		title : '请选择',
		value : '0'
	}, {
		label : '四川',
		value : '2'
	}, {
		label : '山东',
		value : '1'
	}, {
		label : '湖北',
		value : '3'
	} ];
	// 配置城市
	var address_city = [ {
		label : '请选择',
		title : '请选择',
		value : '0'
	}, {
		label : '成都',
		value : '2'
	}, {
		label : '北京',
		value : '1'
	}, {
		label : '上海',
		value : '3'
	} ];
	// 配置区域
	var address_region = [ {
		label : '请选择',
		title : '请选择',
		value : '0'
	}, {
		label : '高新区',
		value : '2'
	}, {
		label : '成华区',
		value : '1'
	}, {
		label : '金牛区',
		value : '3'
	} ];
	var yewu_type = [ {
		label : '请选择',
		title : '请选择',
		value : '请选择'
	}, {
		label : '总经理',
		value : '总经理'
	}, {
		label : '产品销售',
		value : '产品销售'
	}, {
		label : '物资采购',
		value : '物资采购'
	} , {
		label : '仓储物流',
		value : '仓储物流'
	} ];
	$('#address_province').multiselect('dataprovider',
			address_province);
	$('#address_city')
			.multiselect('dataprovider', address_city);
	$('#address_region').multiselect('dataprovider',
			address_region);
	$('#yewu_type').multiselect('dataprovider', yewu_type);

	var product1 = [ {
		label : '请选择',
		title : '请选择',
		value : '请选择'
	}, {
		label : '服装',
		value : '服装'
	} ];
	var product2 = [ {
		label : '请选择',
		title : '请选择',
		value : '请选择'
	}, {
		label : '男装',
		value : '男装'
	} ];
	var product3 = [ {
		label : '请选择',
		title : '请选择',
		value : '请选择'
	}, {
		label : '衬衫',
		value : '衬衫'
	}, {
		label : 'T恤',
		value : 'T恤'
	} ];
	var datetype = [ {
		label : '天',
		title : '天',
		value : '0'
	}, {
		label : '小时',
		value : '1'
	} ];
	$('#product1').multiselect('dataprovider', product1);
	$('#product2').multiselect('dataprovider', product2);
	$('#product3').multiselect('dataprovider', product3);
	$('#datetype').multiselect('dataprovider', datetype);
	
	var galleryThumbs1 = new Swiper('#conten3', {
		observer : true,
		observeParents : true,
		spaceBetween : 10,
		slidesPerView : 3,
		onlyExternal : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev'
	});
	var galleryThumbs2 = new Swiper('#conten4', {
		observer : true,
		observeParents : true,
		spaceBetween : 10,
		slidesPerView : 3,
		onlyExternal : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev'
	});
	
	var galleryThumbs3 = new Swiper('#conten5', {
		observer : true,
		spaceBetween : 10,
		slidesPerView : 4,
		onlyExternal : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev'
	});
	
	var galleryThumbs5 = new Swiper('#conten6', {
		observer : true,
		effect : 'fade',
		autoplay : 3000,
		pagination : '.swiper-pagination',
		paginationClickable : true,
		paginationBulletRender : function(index, className) {
			return '<span class="' + className + '">'
					+ (index + 1) + '</span>';
		},
		autoplayDisableOnInteraction : false,
		width : '1138',
		height : '515',
		onlyExternal : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev'

	});
	// 对业务联系人实现动态添加效果
});
function addproduct(obj) {
	var test = applyGoods("type1","type2","type3","type4");
	if(!test){
		return;
	}
	var content = "<div class='crumb-select-item'><span>"+test+"</span><i onclick='del(this);'></i></div>";
	$(obj).parent().next().append(content);
}
function del(obj) {
	$(obj).parent("div").remove();

}
function addlianxi(obj) {
	$(obj).closest('.ywlianxi').find('.lianxi-l1').first().clone(true).insertBefore('.lianxi_add');
}
function ShowMap(zuobiao, name, addrsee, phone, chuanzhen, zoom) {
	var arrzuobiao = zuobiao.split(',');
	var map = new BMap.Map('allmap');
	map.centerAndZoom(new BMap.Point(arrzuobiao[0], arrzuobiao[1]), zoom);
	map.addControl(new BMap.NavigationControl());
	var marker = new BMap.Marker(new BMap.Point(arrzuobiao[0], arrzuobiao[1]));
	map.addOverlay(marker);
	var infoWindow = new BMap.InfoWindow(
			'<p style="color: #bf0008;font-size:12px;">' + name + '</p><p>地址：'
					+ addrsee + '</p>');
	marker.addEventListener("click", function() {
		this.openInfoWindow(infoWindow);
	});
	marker.openInfoWindow(infoWindow);
}

function showMagnifyMap(zuobiao, name, addrsee, phone, chuanzhen, zoom) {
	var arrzuobiao = zuobiao.split(',');
	var map = new BMap.Map('magnifyMap');
	map.enableScrollWheelZoom();
	var point = new BMap.Point(arrzuobiao[0], arrzuobiao[1]);
	map.centerAndZoom(point, zoom);
	map.addControl(new BMap.NavigationControl());
	var marker = new BMap.Marker(point);
	map.addOverlay(marker);
	var infoWindow = new BMap.InfoWindow(
			'<p style="color: #bf0008;font-size:12px;">' + name + '</p><p>地址：'
					+ addrsee + '</p><p>电话：' + phone + '</p><p>传真：' + chuanzhen
					+ '</p>');
	marker.addEventListener("click", function() {
		this.openInfoWindow(infoWindow);
	});
	marker.openInfoWindow(infoWindow);
}
function initMap(qyname,zuobiao) {
	var map = new BMap.Map("qy-position");
	map.centerAndZoom("成都", 12);
	map.enableScrollWheelZoom(); // 启用滚轮放大缩小，默认禁用
	map.enableContinuousZoom(); // 启用地图惯性拖拽，默认禁用

	map.addControl(new BMap.NavigationControl()); // 添加默认缩放平移控件
	map.addControl(new BMap.OverviewMapControl()); // 添加默认缩略地图控件
	map.addControl(new BMap.OverviewMapControl({
		isOpen : true,
		anchor : BMAP_ANCHOR_BOTTOM_RIGHT
	})); // 右下角，打开
	var rezuobiao = zuobiao.split(',')
	var marker1 = new BMap.Marker(new BMap.Point(rezuobiao[0],rezuobiao[1]));
	map.addOverlay(marker1);
	var gc = new BMap.Geocoder();
	map.addEventListener("click", function(e) {
		var marker = new BMap.Marker(new BMap.Point(e.point.lng, e.point.lat)); // 创建标注，为要查询的地方对应的经纬度
			map.clearOverlays();
			map.addOverlay(marker);
		$("#jingweidu").val(e.point.lng+","+e.point.lat);
		 gc.getLocation(e.point, function(rs){
		        showLocationInfo(e.point, rs,marker);
		   });
//		var infoWindow = new BMap.InfoWindow("<p style='font-size:14px;'>"
//				+ content + "</p>");
//
//		marker.addeventlistener("mouseover", function() {
//			this.openinfowindow(infowindow);
//		});
	});
	var localSearch = new BMap.LocalSearch(map);
	localSearch.enableAutoViewport(); // 允许自动调节窗体大小
	searchByStationName(map, localSearch)
}
function showLocationInfo(pt, rs,marker){
    var opts = {
      width : 250,     //信息窗口宽度
      height: 100,     //信息窗口高度
      title : ""  //信息窗口标题
    }
    var addComp = rs.addressComponents;
    var addr = "当前位置：" + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber + "<br/>";
    addr += "纬度: " + pt.lat + ", " + "经度：" + pt.lng;
    //alert(addr);
    var infowindow = new BMap.InfoWindow("<p style='font-size:14px;'>"
    		+ addr + "</p>");
    marker.addEventListener("mouseover", function(e){
		this.openInfoWindow(infowindow);
	});
}
function searchByStationName(map, localSearch) {
	// map.clearOverlays();//清空原来的标注
	var keyword = $('#jingyingdizhi').val();
	localSearch.setSearchCompleteCallback(function(searchResult) {
		var poi = searchResult.getPoi(0);
		document.getElementById("jingweidu").value = poi.point.lng + ","
				+ poi.point.lat;
		map.centerAndZoom(poi.point, 13);
	});
	localSearch.search(keyword);
}

function initbaseInfo() {
	$('#qyname').val($("#companyName").html());
	$('#jingyingdizhi').val($("#address").html());
	//回显的时候需要使用value进行回显
	$('#type').attr('data-value','602');
	$("#select-qylx").cxSelect({
		data:_companyProperty,
		selects : ['materials1']
	});
	$("#select-jyms").cxSelect({
		data:_operationModel,
		selects : ['materials2']
	});
	
	$('#createTime').val($("#setupTime").html());
	$('#remoney').val($("#registMoney").html());
	$('#qyowner').val($("#owners").html());
	$('#reHomePage').val($("#homePage").html());
	
	$('#gongshang').val($("#registNo").html());
	$('#RetaxNO').val($('#taxNo').html());
	$('#orgNO').val($("#organization").html());
	$('#recridet').val($("#credit").html());
	$('#zuobiao').val($('#rezuobiao').val())
	$('#re_shengId').val($('#sheng_id').val());
	$('#re_cityId').val($('#city_id').val());
	$('#re_xianId').val($('#xian_id').val());
	
	if ($("#customMade").html() == '是') {
		$("input[value='是']").attr('checked', true);
	}
	if ($("#customMade").html() == '否') {
		$("input[value='否']").attr('checked', true);
	}
	$('#zhuying').val($('#mainIndustry').html());
	
	var  test = del_html_tags($('#comp_intro').html(),'<br>','\n');
	$('#qy_intr').html(test);
	$('#brand_in').html(del_html_tags($('#pinpai_intro').html(),'<br>','\n'));
}
function del_html_tags(str,reallyDo,replaceWith) { 
	var e=new RegExp(reallyDo,"g"); 
	words = str.replace(e, replaceWith); 
	return words; 
	} 
function initJiagongInfo() {
	// 修改加工信息
	$('#reserviceYear').val($('#serviceYear').html());
	$('#refactoryArea').val($('#factoryArea').html());
	$('#renumber').val($('#number').html());
	$('#reability').html($('#ability').html());
	$('#reshebei_intro').html($('#shebei_intro').html());
	// 对主加工产品进行特殊处理
	var product = $('#mainProduct').html().split('，');
	$('#blank_theme').empty();
	if(product[0]!=''){
		$.each(product, function(index, value) {
			var content = "<div class='crumb-select-item'><span>" + value
					+ "</span><i onclick='del(this);'></i></div>";
			$('#blank_theme').append(content);
		});
	}
}
function initcontact() {
	$('#addr').val($('#mainAddress').html());
	$('#weixin').val($('#qyweixin').html());
	$('#retel').val($('#tel').html());
	$('#refax').val($('#fax').html());
	$('#repost').val($('#post').html());
	$('#reemail').val($('#email').html());
}
function loadUploadList(uploadList) {
	if ($(uploadList).children("li").length > 0) {
		$(uploadList).next().addClass("element-invisible");
	} else {
		$(uploadList).next().removeClass("element-invisible");
	}
}
function delDom(obj) {
	var listId = $(obj).parent().parent().parent().parent().attr("id");
	$(obj).parent().parent().parent().remove();
	loadUploadList('#'+listId);
}

function ajaxFileUpload() {
	var compid = "1312312313";
	var deletelogPic = $('#deletelogPic').val();
	if(deletelogPic){
		deletelogPic = deletelogPic.substring(0,deletelogPic.length-1);
	}else{
		deletelogPic=1;
	}
	var options = {
			url:"/shengchan-web/qiye/uploadmenhu?compid="+compid,
			dataType:"json",
			data:{
				"deletelogPic":deletelogPic
			}
	}
	$('#menhuForm').ajaxSubmit(options)
	
	initComp(compid);
}
function editJiagong() {
	var serviceYear = $('#reserviceYear').val();
	var factoryArea = $('#refactoryArea').val();
	var number = $('#renumber').val();
	var reability = $('#reability').html();
	var shebei = $('#reshebei_intro').html();
	var deleteJiagong = $('#deletejiagong').val();
	if(deleteJiagong){
		deleteJiagong =  deleteJiagong.substring(0,deleteJiagong.length-1)
	}else{
		deleteJiagong =1;
	}
	
	var applyType=$("#blank_theme span");
	var temp = '';
	$.each(applyType,function(i,v){
		if(i<applyType.length-1){
			temp+=$(v).html()+"，"
		}else{
			temp+=$(v).html();
		}
	})
	var data = {
		"compid":1312312313,
		"mainProductDesc":temp,
		"serviceYear" : parseInt(serviceYear),
		"factoryArea" : parseFloat(factoryArea),
		"employeeNum" : parseInt(number),
		"equipmentInfo" : shebei,
		"outputAbilityInfo" : reability,
		"deletejiagong":deleteJiagong
//		"mainIndustry":temp
	}
	$.ajax({
		url : "/shengchan-web/qiye/changeJiagong",
		type : "POST",
		dataType : "json",
		data : data,
		success : function(data) {
			if(data.success){
				msg({texts:'保存成功！'});
				initComp3("1312312313");
			}
			
		}
	});
	// 处理多图片的上传问题
	
	var temp = $('#jiagognlist').find("input[name='jiagong']");
	
	var compid = "1312312313";
	var options = {
			url:"/shengchan-web/qiye/uploadJiagongImg?compid="+compid,
			dataType:"json"
	}
	if(temp){
		$('#uploadjiagong').ajaxSubmit(options);
	}
}

function uploadJiagong(){
	var temp = $("input[type='file']").attr('id');
	$.ajaxFileUpload({
		url : '/shengchan-web/qiye/uploadJiagongImg?id='+$('#reattachId').val(),
		secureuri : false,
		fileElementId :   temp,
		dataType : 'json',
		success : function(data, status) {
			window.location.reload();
		},
		error : function(data, status, e) {
			msg({texts:"图片上传失败，请从新上传，或刷新网络"});
		}
	});
}

function loadPic(uploadList,picType,deletestand,isInput){
	var compId = 1312312313;
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				var _docArray = new Array();
			    var _keyArray = new Array();
				$.each(data.list.attach,function(i, att){
					if (att.relType == picType) {
						 _docArray.push(att.attaUrl);
					     _keyArray.push(att.id);
					}
				});
				$("#"+uploadList).loadPreview({
			        imgArray:_docArray,
			        keyArray:_keyArray,
			        update:true,
			        isInput:isInput,
			        delObject:$('#'+deletestand+'')
			    });
			} else {
				// alert('初始化失败!');
			}
		}

	});
}
function loadPicInput(uploadList,picType,deletestand){
	var compId = 1312312313;
	$.ajax({
		url : "/shengchan-web/comp/initCompById",
		data : {
			"compId" : compId
		},
		type : "POST",
		dataType : "json",
		success : function(data, textStatus) {
			if (data.success) {
				var _docArray = new Array();
			    var _keyArray = new Array();
			    var _nameArray = new Array();
				$.each(data.list.attach,function(i, att){
					if (att.relType == picType) {
						 _docArray.push(att.attaUrl);
					     _keyArray.push(att.id);
					     _nameArray.push(att.typeName);
					}
				});
				$("#"+uploadList).loadPreview({
			        imgArray:_docArray,
			        keyArray:_keyArray,
			        nameArray:_nameArray,
			        update:true,
			        isInput:true,
			        delObject:$('#'+deletestand+'')
			    });
			} else {
				// alert('初始化失败!');
			}
		}

	});
}

function refreshTab(){
	$('#ywtable').bootstrapTable('refresh',{url:'../comp/getContact?compId=1312312313'});
	
}

function addTable(){
	$('#ywtable').bootstrapTable({
		url : '../comp/getContact?compId=1312312313',
		dataType : 'json',
		method : 'post', // 请求方式（*）
		editable : true, // 开启编辑模式
		clickToSelect : true,
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存
		pagination : true, // 是否显示分页
		// queryParamsType :
		// '', //传递参数
		sortable : false, // 是否启用排序
		// sortOrder :
		// "asc", //排序方式
		sidePagination : "client", // 分页方式：client客户端分页，server服务端分页
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 7, // 每页的记录行数
		pageList : [ 7, 10 ], // 可供选择的每页的行数
		search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端
		showColumns : false, // 是否显示所有的列
		showRefresh : false, // 是否显示刷新按钮
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		width : 'auto',
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : false, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		paginationHAlign : 'right', // 分页组件显示位置
		paginationVAlign : 'bottom', // 分页信息显示位置
		paginationDetailHAlign : 'left', // right,
		// left
		columns : [
				{
					title : '序号',
					field : 'id',
					sortable : true
				},
				{
					title : '联系人',
					field : 'contactPerson',
					sortable : true
				},
				{
					title : '业务类型',
					field : 'businessType',
					sortable : true
				},
				{
					title : '手机',
					field : 'phone',
					sortable : true
				},
				{
					title : '固定电话',
					field : 'tel',
					sortable : true
				},
				{
					title : '电子邮箱',
					field : 'email',
					sortable : true
				},
				{
					title : '操作',
					edit : false,
					field : 'action',
					formatter : function(
							value,
							row,
							index) {
						return '<a href="javascript:void(0)" onclick="updateContact(\''
								+ row.id
								+ '\',\''+compidval+'\')">修改</a>|<a href="javascript:void(0)" onclick="delContact(\''+ row.id+ '\',\''+compidval+'\')">删除</a>';
					}
				} ]
	});
}
function applyGoods(id1,id2,id3,id4){
	var val1 = $("#"+id1+" option:selected").text()=='请选择' ? '':$("#"+id1+" option:selected").text()+">";
	var val2 = $("#"+id2+"  option:selected" ).text()=='请选择'|| !$("#"+id2+"  option:selected" ).text() ? '':$("#"+id2+" option:selected" ).text()+">";
	var val3 = $("#"+id3+"  option:selected").text()=='请选择' || !$("#"+id3+"  option:selected" ).text() ? '':$("#"+id3+" option:selected" ).text()+">";
	var val4 = $("#"+id4+"  option:selected").text()=='请选择' || !$("#"+id4+"  option:selected" ).text() ?  '':$("#"+id4+" option:selected" ).text()+">";
	var temp = val1.trim()+val2.trim()+val3.trim()+val4.trim();
	     var test = temp.substring(0,temp.length-1);
	if(temp.length==1 || temp.length==2){
		test='';
	}
	return test;
}
