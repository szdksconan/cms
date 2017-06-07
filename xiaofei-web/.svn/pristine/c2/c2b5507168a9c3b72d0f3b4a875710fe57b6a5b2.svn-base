$(document).ready(function() {
	sc_my_zs();wl_lx_zs(1,20);
});

function sc_my_zs(){
	$.ajax({
		url:context+"/open/selectGetRecommendedAndBusinessInfo",
		type:"get",
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_2_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var tables="";
			$(".zs_list_push").html("");
			$.each(data,function(i,n){
				tables+="<li>";
				tables+="<div class=\"x_P\">";
				tables+="<a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+"><img src="+n.img_url+" style=\"float: left;margin:0 20px 0 0; \" width=\"90\"height=\"90\"></a>";
				tables+="<span style=\"display: inline-block;font-size: 15px;margin-top:15px;\">";
				tables+="<a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+" >"+n.name+"</a>";
				tables+="<P><img src="+context+"/images/b.png>"+n.pr_name+n.re_name+n.ci_name+" </P>";
				tables+="</span>";
				tables+="</div>";
				tables+="</li>";
			})
			$(".zs_list_push").append(tables);
		}
	});
}

function wl_lx_zs(page,pageSize){
	$.ajax({
		url:context+"/open/chinaMerchantsLogistics",
		type:"get",
		data:{page:page,pageSize:pageSize},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var html="";
			$(".wycy_info_body").html("");
			$.each(data.data.items,function(i,n){
				/*html+="<li>";*/
				html+="<div class=\"x_P\" style=\"font-size: 15px\">";
				html+="<p>始发地："+n.FromCity+" <span style=\"float: right\">¥/年</span></p>";
				html+="<P> 到达地地："+n.ToCity+" <span style=\"float: right\">"+n.Price+"</span></P>";
				html+="</span>";
				html+="</div>";
				/*html+="</li>";*/
			})
			$(".wycy_info_body").append(html);
		}
	});
}