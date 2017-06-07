$(function() {
	$('.zoom-list dt').live('click', function() {
		if ($(this).children().children().hasClass('zoom-in')) {
			$(this).children().children().removeClass('zoom-in');
			$(this).children().children().addClass('zoom-out');
			$(this).siblings('dd').show();
		} else {
			$(this).children().children().removeClass('zoom-out');
			$(this).children().children().addClass('zoom-in');
			$(this).siblings('dd').hide();
		}
	});
	$('.zoom-list dd').live('click',function(){
		$(this).addClass('active').siblings().removeClass('active');
		if($(this).parent().siblings().find('dd').hasClass('active')){
			$(this).parent().siblings().find('dd').removeClass('active');
		}
	});
	$('#shrink').toggle(
		function(){
			$(this).parent().parent().width('20px');
			$(this).addClass('gy-shrink-left');
		},function(){
			$(this).parent().parent().width('216px');
			$(this).removeClass('gy-shrink-left');
	})
	// 对地理位置进行初始化
	// $("#address").click(function(e){
	// SelCity(this,e);
	// });
	
	$.cxSelect.defaults.emptyStyle = 'none';
	$("#apply_goods").cxSelect({
		url : '../js/common/productJson.json',
		selects : [ 'materials1', 'materials2', 'materials3', 'materials4' ],
		nodata : 'none'
	});
	
	
	$('#dt').click(function(){
		$.post('../supplier/list', function(data) {
			if (data) {
				initMap(data);
			} else {
				msg({
					texts : '地图初始化异常！'
				});
			}
		}, "json")
	})
	// 对全选进行操作
	$('#choice').click(function() {
		if ($(this).attr('checked') == 'checked') {
			$.each($("input[type='checkbox']"), function(i, v) {
				$(v).attr('checked', 'checked');
			})
		} else {
			$.each($("input[type='checkbox']"), function(i1, v1) {
				$(v1).attr('checked', false);
			});
		}
	});
	// 执行备选页面初始化工作
	$('#beixuan').click(function(){
		var queryParams = {};
		queryParams.address = $('#address').val();
		queryParams.mainIndustry = applyGoods('type5', 'type6', 'type7', 'type8');
		$.ajax({
			url:'../supplier/getBeixuan',
			type:'POST',
			dataType:'json',
			data:queryParams,
			success:function(data){
				if(data.total>0){
					initBeixuan(data.rows);
				}else{
					$('#bei_con').empty();
				}
			}
		});	
	});
	$('#clear').click(function(){
		$('#address').val('');
		$('.materials1').attr('data-value','请选择');
		$.cxSelect.defaults.emptyStyle = 'none';
		$("#apply_goods").cxSelect({
			url : '../js/common/productJson.json',
			selects : [ 'materials1', 'materials2', 'materials3', 'materials4' ],
			nodata : 'none'
		});
	});
});
// 发布类型加载
var optionssshy = [ {
	label : '装备制造业',
	value : '1'
}, {
	label : '金属挖掘业',
	value : '2'
}, {
	label : '挖掘机系',
	value : '2'
} ];

$('#sshy').multiselect('dataprovider', optionssshy);
// 发布类型加载
var optionskhpj = [ {
	label : '优',
	value : '1'
}, {
	label : '中',
	value : '2'
}, {
	label : '差',
	value : '2'
} ];

$('#khpj').multiselect('dataprovider', optionskhpj);
function changeUrl(url, id) {
	$('#house-frame').attr('src', url);

	// alert(obj.type);
	// alert($(obj).type);
}


var tableoption = {
	// toolbar: '#toolbar',
	url : '../supplier/list',
	dataType : 'json',
	method : 'post', // 请求方式（*）
	pagination : true, // 是否显示分页
	editable : true, // 开启编辑模式
	clickToSelect : true,
	locale : "zh-US",// 表格汉化
	striped : true, // 是否显示行间隔色
	cache : false, // 是否使用缓存
	height : '500',
	contentType : 'application/x-www-form-urlencoded; charset=UTF-8',
	queryParams : function(params) {
		return {
			pageSize : params.limit,
			sort : 'id',
			order : params.order,
			pageNumber : params.pageNumber,
		};
	},
	queryParamsType : 'limit',
	// '', //传递参数
	sortable : false, // 是否启用排序
	sortOrder : 'desc',
	// "asc", //排序方式
	sidePagination : "server", // 分页方式：client客户端分页，server服务端分页
	pageNumber : 1, // 初始化加载第一页，默认第一页
	pageSize : 10, // 每页的记录行数
	pageList : [ 10, 20 ], // 可供选择的每页的行数
	width : 'auto',
	uniqueId : "id",// 每一行的唯一标识，一般为主键列
	columns : [ {
		field : 'Number',
		title : '序号',
		formatter : function(value, row, index) {
			return index + 1;
		}
	}, {
		title : '企业名称',
		field : 'companyName'
	}, {
		title : '企业性质',
		field : 'compType'
	}, {
		title : '经营模式',
		field : 'businessModel'
	}, {
		title : '主营物资类别',
		field : 'mainIndustry'
	}, {
		title : '所在地区',
		field : 'address'
	}, {
		title : '联系人',
		field : 'owners'
	}, {
		title : '联系电话',
		field : 'tel'
	}, {
		title : '交易次数',
		field : 'tradeNum',
		formatter : function(value, row, index) {
			return row['compSuppliers'].tradeNum;
		}
	}, {
		title : '交易总金额',
		field : 'categoryAmount',
		formatter : function(value, row, index) {
			return row['compSuppliers'].totalMoney;
		}

	}, {
		title : '操作',
		field : 'action',
		formatter : function(value, row, index) {
			return '<a class="a_css" href="#">删除</a>';
		}
	} ]
};

obj = new Array();
content = new Array();
$('#table_1').bootstrapTable(tableoption);
function initMap(data) {
		var rows = data.rows;
		var address = data.address;
		var map = new BMap.Map("tubiaomoshi");
		content[1]=map;
		map.enableScrollWheelZoom(); // 启用滚轮放大缩小，默认禁用
		map.enableContinuousZoom(); // 启用地图惯性拖拽，默认禁用
		var opts = {
			anchor : BMAP_ANCHOR_BOTTOM_LEFT
		};
		map.addControl(new BMap.NavigationControl(opts)); // 添加默认缩放平移控件
		map.addControl(new BMap.OverviewMapControl()); // 添加默认缩略地图控件
		map.addControl(new BMap.OverviewMapControl({
			isOpen : true,
			anchor : BMAP_ANCHOR_BOTTOM_RIGHT
		})); // 右下角，打开
		var point = new BMap.Point(104.072828, 30.64832)
		map.centerAndZoom(point, 10);
		if(rows[0]){
			showInfoFirst(rows[0]);
		}
		
		$.each(rows,function(i, v) {
			var companyName = v['companyName'];
			var compid = v['compid']
			var compZuobiao = v['compZuobiao'].split(',');
			var myIcon = new BMap.Icon("../images/mark.png", new BMap.Size(30, 30), {
				offset: new BMap.Size(10, 25), // 指定定位位置
				imageOffset: new BMap.Size(0, 0* 25) // 设置图片偏移
			});
			var marker = new BMap.Marker(new BMap.Point(compZuobiao[0],
					compZuobiao[1]), {
					icon: myIcon
				});
			marker.compid=compid;
			
			obj[i]=marker;
			
			map.addOverlay(marker);
			// 根据坐标获得公司的省市位置
		});
		$("#gyml").empty();
		showCompany(address)
}
function showInfoFirst(obj){
	var mainProduct = obj['mainProductDesc'];
	var address = obj['address'];
	var compType = obj['compType'];
	var jingyingmoshi = obj['businessModel'];
	var mainIndustry = obj['mainIndustry'];
	var tradeNum = obj['compSuppliers'].tradeNum;
	var money = obj['compSuppliers'].totalMoney;
	var linkman = obj['owners'];
	var tel = obj['tel'];
	var email = obj['email'];
	$('#mainProduct').html(mainProduct);
	$('#readress').html(address);
	$('#compType').html(compType);
	$('#bussiness').html(jingyingmoshi);
	$('#hangye').html(mainIndustry);
	$('#tradeNum').html(tradeNum);
	$('#tradeMoney').html(money);
	$('#owner').html(linkman);
	$('#num').html(tel);
	$('#email').html(email);
}
function querySupplier() {
	var beixuan = $('#beixuan').attr('class');
	var queryParams = {};
	queryParams.address = $('#address').val();
	queryParams.mainIndustry = applyGoods('type5', 'type6', 'type7', 'type8');
	alert();
	if (beixuan) {
		queryParams.beixuan = true;
		// 这儿在发一个请求进行备选供应商信息的获取
		$.ajax({
			url:'../supplier/getBeixuan',
			type:'POST',
			dataType:'json',
			data:queryParams,
			success:function(data){
				if(data.total>0){
					initBeixuan(data.rows);
				}else{
					$('#bei_con').empty();
				}
			}
		});
		
	} else {
		$.ajaxLoad({
			url : '../supplier/list',
			type : 'POST',
			dataType : 'json',
			data : queryParams,
			success : function(data) {
				$('#table_1').bootstrapTable('load', data);
				// 对地图列表模式进行控制
				if(data.total>0){
					initMap(data);
				}else{
					msg({texts:'没有查询到数据'});
					$('#gyml').empty();
				}
			}
		});
	}
}
function applyGoods(id1, id2, id3, id4) {
	var val1 = $("#" + id1 + " option:selected").text() == '请选择' ? '' : $(
			"#" + id1 + " option:selected").text()
			+ "-";
	var val2 = $("#" + id2 + "  option:selected").text() == '请选择'
			|| !$("#" + id2 + "  option:selected").text() ? '' : $(
			"#" + id2 + " option:selected").text()
			+ "-";
	var val3 = $("#" + id3 + "  option:selected").text() == '请选择'
			|| !$("#" + id3 + "  option:selected").text() ? '' : $(
			"#" + id3 + " option:selected").text()
			+ "-";
	var val4 = $("#" + id4 + "  option:selected").text() == '请选择'
			|| !$("#" + id4 + "  option:selected").text() ? '' : $(
			"#" + id4 + " option:selected").text()
			+ "-";
	var temp = val1.trim() + val2.trim() + val3.trim() + val4.trim();
	var test = temp.substring(0, temp.length - 1);
	if (temp.length == 1 || temp.length == 2) {
		test = '';
	}
	return test;
}


function showCompany(obj) {
	$.each(obj,function(i,v){
		var pdom = '<dl class="zoom-list" data="'+i+'"><dt><a href="javascript:;"><i class="zoom-btn zoom-out"></i>'+v['province']+'</a></dt></dl>';
		flag = true;
		$('#gyml').append(pdom);
		var companys = v['addr'];
		$.each(companys,function(i1,v1){
			console.debug(v1);
			var dom = '<dd><a href="#" onclick="showInfo('+v1['compId']+','+v1['supplierType']+')">' +v1['companyName'] + '</a></dd>'
			$('dl[data="'+i+'"]').append(dom);
		})
	})
}
function showInfo(compid,supplierType) {
	var marker = '';
	$.each(obj,function(i1,v1){
		if(v1['compid']==compid){
			marker=v1;
		}
	});
	var map = content[1];
	var html='<div class="gy-pfl"><div class="pfl-u clearfix"><div class="plf-l"><div class="gy-logo-l"><img id="logo"></div></div><div class="plf-r"><div class="gy-hang pd32">主营产品：<span id="mainProduct">电脑</span></div><div class="gy-hang pd32">所在地区：<span id="readress">成都市高新区茂业中心</span></div><div class="gy-hang pd32">企业性质：<span id="compType">国有企业</span></div><div class="gy-hang pd32">经营模式：<span id="bussiness">生产销售型</span></div></div></div><div class="gy-hang pd20">交易次数：<span id="tradeNum">500</span></div><div class="gy-hang pd20">	交易总金额：<span id="tradeMoney">10000</span></div><div class="gy-hang pd20">联系人：<span id="owner">罗毅刚</span></div><div class="gy-hang pd20">联系电话：<span id="tel"></span></div><div class="gy-hang pd20">邮箱：<span id="email">fangbo@163.com1999</span></div></div>'
	var opts = {
			width:300,
			height:247,
			title : "<b>公司详情</b>" 
	}
	console.debug(marker.point)
	var infowindow = new BMap.InfoWindow(html,opts);
	$(marker).bind('click',function(){
		map.setCenter(marker.point) 
		this.openInfoWindow(infowindow);
	});
	$(marker).trigger('click');
	var compids = compid+'';
	// 可以根据id 去获得所有的附件信息
	$.post('../supplier/getCompbaseInfo',{"compids":compids,"supplierType":supplierType},function(data){
		if(data.rows){
			var obj = data.rows;
			$('#mainProduct').html(obj['mainProductDesc']);
			$('#readress').html(obj['address']);
			$('#compType').html(obj['compType']);
			$('#bussiness').html(obj['businessModel']);
			$('#hangye').html(obj['mainIndustry']);
			$('#tradeNum').html(obj['compSuppliers'].tradeNum);
			$('#tradeMoney').html(obj['compSuppliers'].totalMoney);
			$('#owner').html(obj['owners']);
			$('#num').html(obj['tel']);
			$('#email').html(obj['email']);
			$('#logo').attr('src',obj['logoPath']);
		}
		
	})
	
	
}
function initBeixuan(rows){
	console.debug(rows);
	
	$('#bei_con').empty();
	$.each(rows,function(i,v){
		var businessModel=v['businessModel'];
		var employeeNum=v['employeeNum'];
		var factoryArea=v['factoryArea'];
		var serviceYear=v['serviceYear'];
		if(!v['businessModel']){
			businessModel='--';
		}
		if(employeeNum==0){
			employeeNum="--";
		}
		if(!factoryArea){
			factoryArea="--";
		}
		if(!serviceYear){
			serviceYear = "--";
		}
		var supplierType = v['compSuppliers'].supplierType;
		var https = '';
		if(supplierType=='0'){
			https = 'http://192.168.2.224:8080/shengchan-web/qiyezhongxin/qiyeguanOut.html?compid='
		}
		if(supplierType=='1'){
			https = "http://192.168.2.227:8080/maoyi-web/UserEnterprise/user?enterpriseId=";
		}
		
		var dom = '<ul class="gy-list clearfix"><li class="gy-title"><a href="'+https+''+v['compid']+'" class="a_css"  target="_blank">'+v['companyName']+'</a> </li><li class="gy-intro">'+
					'<div class="gy-intro-l"><div class="gy-logo"><a href="'+https+''+v['compid']+'" class="a_css"  target="_blank"><img src="'+v['logoPath']+'" ></a></div></div><div class="gy-intro-r"><div class="gy-hang">主营产品：<span>'+v['mainProductDesc']+'</span>'+
					'</div><div class="gy-hang">所在地区：<span>'+v['address']+'</span></div><div class="gy-hang">企业性质：<span>'+v['compType']+'</span></div><div class="gy-hang">经营模式：<span>'+businessModel+'</span>'+
					'</div><div class="gy-hang">所属行业：<span>'+v['mainIndustry']+'</span>	</div></div></li><li class="gy-daigong"><div class="gy-hang">主营加工产品：<span>'+v['mainProductDesc']+'</span>'+
					'</div><div class="gy-hang">员工人数：<span>'+employeeNum+'人</span></div><div class="gy-hang">厂房面积：<span>'+factoryArea+'平方</span></div><div class="gy-hang">从业年限：<span>'+serviceYear+'年</span></div>'+
					'<div class="gy-hang">企业能力：<span>研发、按图加工</span></div></li><li class="gy-product">'+
					'<div class="swiper-container conten4" id="conten'+i+'"><div class="swiper-wrapper" id="mainProd'+i+'">'+
					'<div class="swiper-slide"><img src="../images/qiyezhongxin/shebei/jiagong1.png"></div><div class="swiper-slide"><img src="../images/qiyezhongxin/shebei/jiagong2.png"></div>'+
					'<div class="swiper-slide"><img src="../images/qiyezhongxin/shebei/jiagong3.png"></div>'+
					
					'</div>'+
					
					'<div class="swiper-button-prev sides-btn"></div><div class="swiper-button-next sides-btn"></div></div></li>'+
					'<li class="gy-caozuo"><img src="../images/chuyun/delete.png" title="删除" onclick="delDom(this,'+v['compSuppliers'].id+')" class="gy-delete"> </li></ul>';
		$('#bei_con').append(dom);
		var galleryThumbs = new Swiper('#conten'+i+'', {
			observer : true,
			observeParents : true,
			spaceBetween : 10,
			slidesPerView : 3,
			height : '200px',
			loop : true,
			onlyExternal : true,
			nextButton : '.swiper-button-next',
			prevButton : '.swiper-button-prev'
		});
		console.debug(v['mainDocList']);
		$.each(v['mainDocList'],function(i2,v2){
			
			var mainProduct = '<div class="swiper-slide">'
				+ '<img src='
				+ v2['fileUrl']
				+ ' onclick="gyImgOpen(this)">'
				+'</div>';
			$('#mainProd'+i+'').append(mainProduct);
		});
	})
}

//图片放大
function gyImgOpen(obj) {
	var img = $(obj).attr("src");
	var heght = $(obj).height();
	var width = $(obj).width();
	layer.open({
		type : 1,
		title : false,
		area : [ width, heght ],
		skin : 'yourclass',
		content : '<img src="' + img + '"/>'
	});
}

function delDom(obj,id){
	$(obj).closest('ul').remove();
	$.post('../supplier/deleteSupplier',{"id":id},function(data){
		if(data.success){
			msg({texts:'操作成功'})
		}else{
			msg({texts:'操作异常'})
		}
	},"json")
	
}