$(document).ready(function() {
	wuliu_OK(1,2);
})

function wuliu_OK(page,pageSize){
	$.ajax({
		url:context+"/logistical/getLogisticalist",
		type:"get",
		data:{"page":page,"pageSize":pageSize},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var size_count =data.size;
			var size = 0;
			if(size_count%pageSize==0){
				size = parseInt(size_count/pageSize);
			}else{
				size = parseInt(size_count/pageSize)+1;
			}
			//获取当前时间
			var nowDate = new Date();
			var html="";
			$.each(data.listData,function(i,n){
				//需求发布时间
				var date = n.sendDate;
				//计算时间差 
				var date2=nowDate.getTime()-(new Date(n.reqDate)).getTime(); //时间差的毫秒数
				var date3=Math.floor(date2/(24*3600*1000)); //计算相差天数
				var leave1=date2%(24*3600*1000); //计算天数后剩余的毫秒数
				var hours;
				var showDay;
				//相差小于一天时计算小时数
				if(date3==0){
					hours=Math.floor(leave1/(3600*1000)) //计算小时数
					showDay = hours+"小时前";
				}else{
					showDay = date3+"天前";
				}
				//相差小于一小时计算分钟 
				if(hours==0){
					var leave2=leave1%(3600*1000)        //计算小时数后剩余的毫秒数
					var minutes=Math.floor(leave2/(60*1000))
					showDay = minutes+"分钟前";
				}
				if(date=="undefined" || date==null || date==""){
					date="----";
				}if(n.needReceipt==1){
					n.needReceipt="是";
				}else{
					n.needReceipt="否";
				}if(n.needDelivery==1){
					n.needDelivery="是";
				}else{
					n.needDelivery="否";
				}if(n.quoteAcceptState==1){
					n.quoteAcceptState="是";
				}else{
					n.quoteAcceptState="否";
				}
			       html+="<tr>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+n.sendLocalName+"</a></td>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+n.descLocalName+"</a></td>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+date+"</a></td>";//n.sendDate
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+n.quoteSum+"</a></td>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+n.quoteAcceptState+"</a></td>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+n.needReceipt+"</a></td>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+n.needDelivery+"</a></td>";
		    	   html+="<td><a style=\"font-size:14px\" href=\""+context+"/logistical/getReqlInfo?id="+n.id+"\">"+showDay+"</a></td>";
		    	   html+="</tr>";
			});
			$("#show").html(html);
			$.jqPaginator('#page_home', {
				totalPages: size,
				pageSize : 2,
				visiblePages: 5,
				currentPage: page,
				onPageChange: function (num, type) {
					if (type == 'change') {
						wuliu_OK(num,pageSize);
					}
				}
			});
		}
	});
}

