$(document).ready(function() {
	kd_I_OK(1,2);
});

function kd_I_OK(page,pageSize){
	var key=$(".xf_input").val();
	if(userid!=""){
		$.ajax({
			url:context+"/open/selectUserByIdAndShopApplyGetInfo",
			type:"get",
			data:{uId:userid,key:encodeURIComponent(key),page:page,pageSize:pageSize},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				$(".k_d_info").html("");
				var size_count =data.size;
				var size = 0;
				if(size_count%pageSize==0){
					size = parseInt(size_count/pageSize);
				}else{
					size = parseInt(size_count/pageSize)+1;
				}
				$.each(data.listData,function(i,n){
					html+="<span class=\"xf_gekaid\">";
					html+="<P>申请编号："+n.id+"</P>";
					html+="<p>申请人姓名："+n.name+"</p>";
					html+="<P>联系电话："+n.tel+"</P>";
					html+="<p>申请区域： "+n.provinceName+n.regionName+n.cityName+"</p>";
					html+="<p>能力描述："+n.brief.substring(0,10)+"..."+" </p>";
					html+="<p>申请时间："+n.aplTime+"</p>";
					html+="<P align=\"right\"><a class=\"orange\" href="+context+"/f_w/kaidian_x.jsp?Id="+n.id+" target=\"_self\">详情...</a></P>";
					html+="</span>";
				});
				$(".k_d_info").append(html);
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 2,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							kd_I_OK(num,pageSize);
						}
					}
				});
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}