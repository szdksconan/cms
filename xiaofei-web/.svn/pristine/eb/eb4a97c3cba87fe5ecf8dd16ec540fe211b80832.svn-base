$(document).ready(function() {
	loading_OK(1,4);
})

function loading_OK(page,pageSize){
	if(userid!=""){
		$.ajax({
			url:context+"/cpcc/selectAllCollectionUserGetById",
			type:"get",
			data:{uId:userid,page:page,pageSize:pageSize},
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
				$(".sc_user_all_info").html("");
				$.each(data.listData,function(i,n){
					html+="<tr>";
					html+="<td><a target=\"_blank\" href="+context+"/index_cp.jsp?pId="+n.productId+"&sId="+n.goodsId+"&shopId="+n.storeId+"><img width=\"106\" height=\"106\" src="+n.productImgUrl+"></a></td>";
					html+="<td><div>";
					html+="<p> </p><p><a class=\"red\" target=\"_blank\" href="+context+"/index_cp.jsp?pId="+n.productId+"&sId="+n.goodsId+"&shopId="+n.storeId+">"+n.productName+"</a>&nbsp;</p><p>"+n.storeName+"</p>";
					html+="</div></td>";
					html+="<td></td>";
					html+="<td></td>";
					html+="<td>"+n.collectDate+"</td>";
					html+="<td></td>";
					html+="<td >";
					html+="<a href=\"javascript:;\" onclick=\"del_OK('"+n.proCollectId+"');\" class=\"red\">删除</a><br/><br/><a href=\"javascript:;\" onclick=\"cancel_OK('"+n.proCollectId+"');\" class=\"red\">取消收藏</a><br/>";
                    html+="</td>";
					html+="</tr>";
				})
				$(".sc_user_all_info").append(html);
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 4,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							loading_OK(num,pageSize);
						}
					}
				});
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

function store_OK(page,pageSize){
	if(userid!=""){
		$.ajax({
			url:context+"/cpcc/selectUserAndGetByIdStoreCollection",
			type:"get",
			data:{uId:userid,page:page,pageSize:pageSize},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_store_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				var html="";
				$(".sc_user_all_store_info").html("");
				var size_count =data.size;
				var size = 0;
				if(size_count%pageSize==0){
					size = parseInt(size_count/pageSize);
				}else{
					size = parseInt(size_count/pageSize)+1;
				}
				$.each(data.listData,function(i,n){
					html+="<tr>";
					html+="<td><a target=\"_blank\" href="+context+"/f_w/dianx.jsp?shopId="+n.storeId+"><img width=\"106\" height=\"106\" src="+n.storeImageUrl+"></a></td>";
					html+="<td><div>";
					html+="<p> </p><p><a class=\"red\" target=\"_blank\" href="+context+"/f_w/dianx.jsp?shopId="+n.storeId+">"+n.storeName+"</a>&nbsp;</p><p></p>";
					html+="</div></td>";
					html+="<td></td>";
					html+="<td></td>";
					html+="<td>"+n.collectionDate+"</td>";
					html+="<td></td>";
					html+="<td >";
					html+="<a href=\"javascript:;\" onclick=\"del_store_OK('"+n.storeCollectionCode+"');\" class=\"red\">删除</a><br/><br/><a href=\"javascript:;\" onclick=\"cancel_store_OK('"+n.storeCollectionCode+"');\" class=\"red\">取消收藏</a><br/>";
                    html+="</td>";
					html+="</tr>";
				});
				$(".sc_user_all_store_info").append(html);
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 2,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							store_OK(num,pageSize);
						}
					}
				});
			}
		});
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

function del_OK(id){
	if(confirm("确认删除吗")){
		$.ajax({
			url:context+"/cpcc/deleteUserAndCollectionAProduce",
			type:"get",
			data:{id:id},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_del_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				alert("删除成功!");
				loading_OK(1,4);
			}
		})
	}else{
		alert("已取消删除!");
	}
}

function cancel_OK(id){
	if(confirm("确认取消收藏吗")){
		$.ajax({
			url:context+"/cpcc/updateUserAndCollectionAProduce",
			type:"get",
			data:{id:id},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_cancel_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				alert("取消收藏成功!");
				loading_OK(1,4);
			}
		})
	}else{
		alert("已取消收藏!");
	}
}

function del_store_OK(id){
	if(confirm("确认删除吗")){
		$.ajax({
			url:context+"/cpcc/deleteUserStoreAndCollectionAProduce",
			type:"get",
			data:{id:id},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_del_store_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				alert("删除成功!");
				store_OK(1,2);
			}
		})
	}else{
		alert("已取消删除!");
	}
}

function cancel_store_OK(id){
	if(confirm("确认取消收藏吗")){
		$.ajax({
			url:context+"/cpcc/updateUserStoreAndCollectionAProduce",
			type:"get",
			data:{id:id},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"success_cancel_store_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				alert("取消收藏成功!");
				store_OK(1,2);
			}
		})
	}else{
		alert("已取消收藏!");
	}
}