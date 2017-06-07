// JavaScript Document
	// 百度地图API功能

    var map = new BMap.Map('allmap');
	var poi = new BMap.Point(103.9196840000, 36.0644050000);
    map.centerAndZoom(poi, 5);   // 这个数字控制浏览地图微缩大小，增加地图细节越显
    map.enableScrollWheelZoom();
	
	
//样式0乌鲁木齐
	var poi = new BMap.Point(87.6449760000,43.8744000000);
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker(poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker); 
    map.enableScrollWheelZoom();
	    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 新HA7015<br/>车辆信息: 半挂二拖三、 高栏、 37.0吨、13.0米<br/>流向: 全国。<br/>最后定位时间:11-10 13:10。<br/>最后定位地址: 新疆省城东区XXX大道。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';
	var searchInfoWindow0 = new BMapLib.SearchInfoWindow(map, content, {
		title  : "司机姓名:  刘新疆", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindow0() {
		searchInfoWindow0.open(new BMap.Point(87.6449760000,43.8744000000));
	};	
   marker.addEventListener("mouseover",function(e){ 
   searchInfoWindow0.open(new BMap.Point(87.6449760000,43.8744000000));
   })

    marker.addEventListener("click", function(e){  
    map.centerAndZoom(e.point,12);   // 这个数字控制浏览地图微缩大小，增加地图细节越显
	searchInfoWindow0.open(new BMap.Point(87.6449760000,43.8744000000));
    })

		//样式a乌西宁
	var poi = new BMap.Point(101.7855980000,36.6151400000);
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker(poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker); 
    map.enableScrollWheelZoom();
	    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 西HA7015<br/>车辆信息: 半挂二拖三、 高栏、 37.0吨、13.0米<br/>流向: 全国。<br/>最后定位时间:11-10 13:10。<br/>最后定位地址: 青海省西宁市XXX区。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';
	var searchInfoWindowa = new BMapLib.SearchInfoWindow(map, content, {
		title  : "司机姓名: 延西宁", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindowa() {
		searchInfoWindowa.open(new BMap.Point(101.7855980000,36.6151400000));
	};	
   marker.addEventListener("mouseover",function(e){ 
   searchInfoWindowa.open(new BMap.Point(101.7855980000,36.6151400000));
   })

    marker.addEventListener("click", function(e){  
    map.centerAndZoom(e.point,12);   // 这个数字控制浏览地图微缩大小，增加地图细节越显
	searchInfoWindowa.open(new BMap.Point(101.7855980000,36.6151400000));
    })
	
	
	//样式b凯拉萨
	var poi = new BMap.Point(91.0990680000,29.6575860000);
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker(poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker); 
    map.enableScrollWheelZoom();
	    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 藏HA7015<br/>车辆信息: 半挂二拖三、 高栏、 37.0吨、13.0米<br/>流向: 全国。<br/>最后定位时间:11-10 13:10。<br/>最后定位地址: 西藏省拉萨市XXX区。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';
	var searchInfoWindowb = new BMapLib.SearchInfoWindow(map, content, {
		title  : "司机姓名: 凯拉萨", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindowb() {
		searchInfoWindowa.open(new BMap.Point(91.0990680000,29.6575860000));
	};	
    marker.addEventListener("click", function(e){  
	searchInfoWindowb.open(new BMap.Point(91.0990680000,29.6575860000));
    })
	
	
	
	
		//样式c凯拉萨
	var poi = new BMap.Point(91.0956180000,29.6344840000);
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker(poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker); 
    map.enableScrollWheelZoom();
	    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 藏HA7015<br/>车辆信息: 半挂二拖三、 高栏、 37.0吨、13.0米<br/>流向: 全国。<br/>最后定位时间:11-10 13:10。<br/>最后定位地址: 西藏省拉萨市XXX区。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';
	var searchInfoWindowc = new BMapLib.SearchInfoWindow(map, content, {
		title  : "司机姓名: 拉萨仓", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindowc() {
		searchInfoWindowc.open(new BMap.Point(91.0956180000,29.6344840000));
	};	
   marker.addEventListener("mouseover",function(e){ 
   searchInfoWindowc.open(new BMap.Point(91.0956180000,29.6344840000));
   })

    marker.addEventListener("click", function(e){  
    map.centerAndZoom(e.point,12);   // 这个数字控制浏览地图微缩大小，增加地图细节越显
	searchInfoWindowc.open(new BMap.Point(91.0956180000,29.6344840000));
    })

	//样式1成都: 田延青
	var poi = new BMap.Point(104.0861220000,30.6706240000);
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker(poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker); 
    map.enableScrollWheelZoom();
	    var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 鲁HA7015<br/>车辆信息: 半挂二拖三、 高栏、 37.0吨、13.0米<br/>流向: 全国。<br/>最后定位时间:11-10 13:10。<br/>最后定位地址: 四川省成都市双流县双楠大道四段。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';
	var searchInfoWindow1 = new BMapLib.SearchInfoWindow(map, content, {
		title  : "司机姓名: 田延青", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindow1() {
		searchInfoWindow1.open(new BMap.Point(104.0861220000,30.6706240000));
	};	
    marker.addEventListener("click", function(e){		  
	    searchInfoWindow1.open(new BMap.Point(104.0861220000,30.6706240000));
    })
	


	
	//样式2成都: 张一涵
	 var poi = new BMap.Point(104.0816660000,30.6657780000);
	
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker( poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中

    map.enableScrollWheelZoom();
	 var content =  '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q2.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 川A45623<br/>车辆信息: 一挂二拖一、 低栏、 23.0吨、10.0米<br/>流向: 全国。<br/>最后定位时间:08-09 10:05。<br/>最后定位地址: 四川省成都市武侯小区。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';
	var searchInfoWindow2 = new BMapLib.SearchInfoWindow(map,  content, {
		title  : "司机姓名: 张一涵", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindow2() {
		searchInfoWindow2.open(new BMap.Point(104.0816660000,30.6657780000));
	};


    marker.addEventListener("click", function(e){
	    searchInfoWindow2.open(new BMap.Point(104.0816660000,30.6657780000));
    })

 
	//样式3成都: 吴侃
    var poi = new BMap.Point(104.0974770000,30.6650330000);
	var myIcon = new BMap.Icon("images/shengchan/w.gif", new BMap.Size(50,50));
	var marker = new BMap.Marker( poi,{icon:myIcon});  // 创建标注
	map.addOverlay(marker);              // 将标注添加到地图中
  
    map.enableScrollWheelZoom();
	 var content =  '<div style="margin:0;line-height:20px;padding:2px;">' +
                    '<img src="images/shengchan/q3.gif" alt="" style="float:right;zoom:1;width:150px;height:150px;margin-left:3px;"/>' +
                    '验：诚信认证 云A45623<br/>车辆信息: 半挂二拖二、 中栏、 28.0吨、22.0米<br/>流向: 全国。<br/>最后定位时间:02-10 15:25。<br/>最后定位地址: 四川省成都市苏坡立交。<br/>' +
					'<button   > 发送短信</button>'+' <button   > 拨打电话</button>'
                  '</div>';

	var searchInfoWindow3 = new BMapLib.SearchInfoWindow(map,  content, {
	title  : "司机姓名: 吴侃", 
			width  : 350,             //宽度
			height : 200, 
			border:0,             //高度
			panel  : "panel",         //检索结果面板
			enableAutoPan : true,     //自动平移
			searchTypes   :[				
			]
	});
	function openInfoWindow3() {
		searchInfoWindow3.open(new BMap.Point(104.0974770000,30.6650330000)); 
	};
    marker.addEventListener("mouseover",function(e){ 
       searchInfoWindow3.open(new BMap.Point(104.0974770000,30.6650330000));
   })
    marker.addEventListener("click", function(e){	   
		 map.centerAndZoom(e.point, 12);   // 这个数字控制浏览地图微缩大小，增加地图细节越显
		  searchInfoWindow3.open(new BMap.Point(104.0974770000,30.6650330000));
    })
	
	
	
	
	
     window.map = map;
        map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
        map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
        map.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
        map.enableScrollWheelZoom();                            //启用滚轮放大缩小
        map.addControl(new BMap.MapTypeControl());          //添加地图类型控件
        map.disable3DBuilding();