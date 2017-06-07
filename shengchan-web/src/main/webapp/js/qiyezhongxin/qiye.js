	var galleryThumbs1 = new Swiper('#conten3', {
		observer:true,
		observeParents:true,
		spaceBetween : 10,
		slidesPerView : 3,
		onlyExternal : true,
		loop : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev'
	});
	var galleryThumbs2 = new Swiper('#conten4', {
		observer:true,
		observeParents:true,
		spaceBetween: 10,
        slidesPerView: 3,
        onlyExternal : true,
        loop:true,
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',
	});
	 
	var galleryThumbs3 = new Swiper('#conten5', {
		observer:true,
		spaceBetween : 10,
		slidesPerView : 4,
		onlyExternal : true,
		loop : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev'
	});
	var galleryThumbs5 = new Swiper('#conten6', {
		observer:true,
		spaceBetween : 10,
		slidesPerView : 1,
		effect : 'fade',
		autoplay : 3000,
		pagination: '.swiper-pagination',
		  paginationClickable: true,
		  paginationBulletRender: function (index, className) {
		      return '<span class="' + className + '">' + (index + 1) + '</span>';
		  },
		  autoplayDisableOnInteraction:false,  
		width:'1135',
		height:'515',
		onlyExternal : true,
		loop : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
		
	});

	$(document).ready(function(){
		// 地图放大
		$(".magnify").click(function(){
			layer.open({
			  type: 1,
			  title: false,
			  closeBtn: 0,
			  shadeClose: true,
			  area: ['800px', '600px'],
			  skin: 'yourclass',
			  content: '<div id="magnifyMap"></div>'
			});
			$.get("/shengchan-web/comp/initCompById",{"compId" : "1312312313"},function(data){
				if(data.success){
					var zuobiao = data.list.base.compZuobiao;
					var company = data.list.base.companyName;
					var addess = data.list.base.address;
					var tel = data.list.base.tel;
					var fax = data.list.base.fax;
					showMagnifyMap(zuobiao, company, addess,tel, fax, '15');
				}else{
					alert('百度地图加载失败');	
				}
			},"json")
		});
		// 图片放大
		$(".swiper-slide img").each(function(){
			$(this).live("click",function(){
				var img = $(this).attr("src");
				layer.open({
				  type: 1,
				  title :false,
				  area: ['800px', '600px'],
				  skin: 'yourclass',
				  content: '<img src="'+img+'" class="layer-alert-img"/>'
				});
			})
		});
		// 超出部分显示...
		/*
		 * $(".jieshao-text").each(function(){ var _this = $(this); var length =
		 * _this.html().length; var text1 = _this.html(); var texts =
		 * _this.text().substring(0,74); var html = '<span
		 * class="jieshao-beyond">...<span>'; if(length>=75){ _this.attr({
		 * "title":text1, "data-toggle":"tooltip" }); _this.text(texts);
		 * _this.append(html); _this.addClass("jieshao-box"); }else{
		 * _this.removeClass("jieshao-box"); } });
		 * $("[data-toggle='tooltip']").tooltip();
		 */
		// 百度地图
		
		$.get("/shengchan-web/comp/initCompById",{"compId" : "1312312313"},function(data){
			if(data.success){
				var zuobiao = data.list.base.compZuobiao;
				var company = data.list.base.companyName;
				var addess = data.list.base.address;
				var tel = data.list.base.tel;
				var fax = data.list.base.fax;
				ShowMap(zuobiao, company, addess,tel, fax, '15');
			}else{
				alert('百度地图加载失败');
			}
		},"json")
// ShowMap('104.072673,30.596522', '成都鑫信达股份有限公司', '茂业中心A座1503','021-888888888',
// '021-888888888', '20');
		
		$(".swiper-container").mousemove(function() {
			$(this).find(".sides-btn").show();
		});
		$(".swiper-container").mouseout(function() {
			$(this).find(".sides-btn").hide();
		});

		$("input").addClass('test')
		$('textarea').addClass('test');
		$("select").addClass('test')
		var qy_edit = $('.qy_edit');
// qy_edit.on('click', function() {
// alert('正在实现编辑');
// });

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
			value : '0'
		}, {
			label : '物质采购',
			value : '2'
		}, {
			label : '物质销售',
			value : '1'
		}, {
			label : '类型1',
			value : '3'
		} ];
		$('#address_province').multiselect('dataprovider', address_province);
		$('#address_city').multiselect('dataprovider', address_city);
		$('#address_region').multiselect('dataprovider', address_region);
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
	});
	function addproduct(obj) {
		var val1 = $("#product1").val();
		var val2 = $("#product2").val();
		var val3 = $("#product3").val();
		var content = "<div class='crumb-select-item'><span>" + val1 + ">"
				+ val2 + ">" + val3
				+ "</span><i onclick='del(this);'></i></div>";
		$(obj).parent().parent().next().append(content);
	}
	function del(obj) {
		$(obj).parent("div").remove();

	}
	function addlianxi(obj) {
		$(obj).closest('.ywlianxi').find('.lianxi-l1').first().clone(true)
				.insertBefore('.lianxi_add');
	}
	function ShowMap(zuobiao, name, addrsee, phone, chuanzhen, zoom) {
		var arrzuobiao = zuobiao.split(',');
		var map = new BMap.Map('allmap');
		map.centerAndZoom(new BMap.Point(arrzuobiao[0], arrzuobiao[1]), zoom);
		map.addControl(new BMap.NavigationControl());
		var marker = new BMap.Marker(new BMap.Point(arrzuobiao[0],arrzuobiao[1]));
		map.addOverlay(marker);
		var infoWindow = new BMap.InfoWindow(
				'<p style="color: #bf0008;font-size:12px;">' + name
						+ '</p><p>地址：' + addrsee + '</p>');
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
				'<p style="color: #bf0008;font-size:12px;">' + name
						+ '</p><p>地址：' + addrsee + '</p><p>电话：' + phone
						+ '</p><p>传真：' + chuanzhen + '</p>');
		marker.addEventListener("click", function() {
			this.openInfoWindow(infoWindow);
		});
		marker.openInfoWindow(infoWindow);
	}
