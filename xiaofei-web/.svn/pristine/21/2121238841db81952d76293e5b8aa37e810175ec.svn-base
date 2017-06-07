// JavaScript Document
var sContent = "<h4 style='margin:0 0 5px 0;padding:0.2em 0'>浙江银座箱包有限公司</h4>" +
    "<div style='margin:140;float:right;'><p style='margin:0;line-height:1.5;font-size:13px'>地址:成都市高新区高新国际广场B座708号</br>邮编:610041<br />电话:028-8225075<br />公交:111;109;86;90;176;246等</p></div>" +
    "</div>";
var map = new BMap.Map("allmap");
var point = new BMap.Point(104.0727350000, 30.5981890000);
var marker = new BMap.Marker(point);
var infoWindow = new BMap.InfoWindow(sContent);  // 创建信息窗口对象
map.centerAndZoom(point, 15);
map.addControl(new BMap.NavigationControl());  //添加默认缩放平移控件
map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_TOP_RIGHT, type: BMAP_NAVIGATION_CONTROL_SMALL}));  //右上角，仅包含平移和缩放按钮
map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_BOTTOM_LEFT, type: BMAP_NAVIGATION_CONTROL_PAN}));  //左下角，仅包含平移按钮
map.addControl(new BMap.NavigationControl({anchor: BMAP_ANCHOR_BOTTOM_RIGHT, type: BMAP_NAVIGATION_CONTROL_ZOOM}));  //右下角，仅包含缩放按钮
map.addOverlay(marker);
/*marker.addEventListener("click", function () {
    this.openInfoWindow(infoWindow);
    alert("000");
    //图片加载完毕重绘infowindow
    //document.getElementById('imgDemo').onload = function () {
    //    infoWindow.redraw();
    //}
});*/
marker.openInfoWindow(infoWindow);


window.map = map;
map.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
map.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
map.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
map.enableScrollWheelZoom();                            //启用滚轮放大缩小
map.addControl(new BMap.MapTypeControl());          //添加地图类型控件
map.disable3DBuilding();
marker.enableDragging();


var gc = new BMap.Geocoder();//地址解析类
//单击获取点击的经纬度
map.addEventListener("click",function(e){
	map.clearOverlays();	
	
	var point=new BMap.Point(e.point.lng,e.point.lat);
   	var marker = new BMap.Marker(point); //地图标记
   
	map.addOverlay(marker);
//    window.parent.transParam(lng,lat);
      gc.getLocation(e.point,function(rs){
	    var opts = {
	      width : 250,     //信息窗口宽度
	      height: 100,     //信息窗口高度
	      title : ""  //信息窗口标题
	    }
	    var addComp = rs.addressComponents;
	    var addr = "当前位置：" + addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber + "<br/>";
	    addr += "纬度: " + e.point.lat + ", " + "经度：" + e.point.lng;
	    var infoWindow = new BMap.InfoWindow(addr, opts);  //创建信息窗口对象
	    marker.openInfoWindow(infoWindow);
	    var jwd=e.point.lng+ "," + e.point.lat;
	    
      }); 
});
