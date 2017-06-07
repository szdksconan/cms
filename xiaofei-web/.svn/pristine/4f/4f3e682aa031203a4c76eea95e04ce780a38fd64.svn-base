$(document).ready(function() {
	ding_zhi_OK(1,2);
});

function ding_zhi_OK(page,pageSize){
	var key=$(".xf_input").val();
	if(userid!=""){
		$.ajax({
			url:context+"/innovation/selectUserByIdAndReqRecGetInfo",
			type:"get",
			data:{uId:userid,key:encodeURIComponent(key),page:page,pageSize:pageSize},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				var size_count =data.size;
				var size = 0;
				if(size_count%pageSize==0){
					size = parseInt(size_count/pageSize);
				}else{
					size = parseInt(size_count/pageSize)+1;
				}
				$(".xf_zx_user").html("");
				$.each(data.listData,function(i,n){
					html+="<span class=\"xf_gekaid\">";
					html+="<P>需求标题："+n.reqTitle+"</P>";
					html+="<p>发布时间："+n.opTime+" </p>";
					html+="<p>联 系  人："+n.realName+"</p>";
					html+="<p>需求数量："+n.reqNumber+"</p>";
					html+="<p>预算价格：￥"+n.cash+"</p>";
					html+="<P>浏  览  量："+n.viewNum+"</P>";
					html+="<P align=\"right\"><a class=\"orange\" href="+context+"/cx_xq.jsp?Id="+n.customId+" target=\"_self\">详情...</a></P>";
					html+="</span>";
				});
				$(".xf_zx_user").append(html);
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 2,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							ding_zhi_OK(num,pageSize);
						}
					}
				});
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}