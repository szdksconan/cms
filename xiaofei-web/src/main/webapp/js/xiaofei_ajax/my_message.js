$(document).ready(function() {
	new_Msg_OK(1,5);
});

function new_Msg_OK(page,pageSize){
	if(userid!=""){
		$.ajax({
			url:context+"/msg/selectUserByIdGetUserMsgAllInfo",
			type:"get",
			data:{uId:userid,page:page,pageSize:pageSize},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_1_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				$(".new_msg_wdq").html("");
				var size_count =data.size;
				var size = 0;
				if(size_count%pageSize==0){
					size = parseInt(size_count/pageSize);
				}else{
					size = parseInt(size_count/pageSize)+1;
				}
				$.each(data.listData,function(i,n){
					html+="<tr>";
					html+=" <td width=\"80%\">";
					html+="<p style=\"color:#FF3300\"> 系统消息</p><br/>";
					html+="<p class=\"xin_1_1\"> "+n.msgInfo.slice(0,20)+"..."+"</p>";
					html+="</td>";
					html+="<td width=\"20%\">"+n.writeTime+"</td>";
					html+="<tr>";
				})
				$(".new_msg_wdq").append(html);
				$(".xin_1_1").click(function () {
					$(".xin_1").hide();
					$(".xin_2").show();
				});
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 5,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							new_Msg_OK(num,pageSize);
						}
					}
				});
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

function have_read_msg_OK(page,pageSize){
	if(userid!=""){
		$.ajax({
			url:context+"/msg/selectGetUserByIdGetUserMsgAllInfo",
			type:"get",
			data:{uId:userid,page:page,pageSize:pageSize},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_2_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				$(".yd_have_msg_cont").html("");
				var size_count =data.size;
				var size = 0;
				if(size_count%pageSize==0){
					size = parseInt(size_count/pageSize);
				}else{
					size = parseInt(size_count/pageSize)+1;
				}
				$.each(data.listData,function(i,n){
					html+="<tr>";
					html+="<td width=\"80%\">";
					html+="<p>系统消息</p><br/>";
					html+="<p class=\"xin_1_1\"> "+n.msgInfo.slice(0,20)+"..."+"</p>";
					html+="</td>";
					html+="<td width=\"20%\">"+n.readTime+"</td>";
					html+="</tr>";
				})
				$(".yd_have_msg_cont").append(html);
				$(".xin_1_1").click(function () {
					$(".xin_1").hide();
					$(".xin_2").show();
				});
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 5,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							have_read_msg_OK(num,pageSize);
						}
					}
				});
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}
