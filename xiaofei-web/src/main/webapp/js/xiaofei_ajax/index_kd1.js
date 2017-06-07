$(document).ready(function() {
	kd_OK(1,2);
});

function kd_OK(page,pageSize){
	$.ajax({
		url:context+"/open/selectAllCmsXRecruitGetInfo",
		type:"get",
		data:{type:"0",typeId:"",title:"",code:"",page:page,pageSize:pageSize},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var html="";
			var tables="";
			$(".wycy_info_body").html("");
			var size_count =data.size;
			var size = 0;
			if(size_count%pageSize==0){
				size = parseInt(size_count/pageSize);
			}else{
				size = parseInt(size_count/pageSize)+1;
			}
			$.each(data.listData,function(i,n){
				html+="<tr>";
				html+="<td><a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+" target=\"_self\">";
				html+="<img src="+n.img_url+" width=\"106\"height=\"106\"></a></td>";
				html+="<td>";
				html+="<div>";
				html+="<p><a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+">"+n.name+"</a></p>";
				html+="<p> &nbsp;</p>";
				html+="<p><a href="+context+"/f_w/ditu.jsp target=\"_self\">";
				html+="<img src="+context+"/images/b.png></a>"+n.pr_name+n.re_name+n.ci_name+"</p>";
				html+="</div>";
				html+="</td>";
				html+="<td>";
				html+="<div>";
				html+="<a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+" target=\"_self\">";
				var str=n.re_rule;//比如str是你那个字符串
				eval("var p="+str+";");//将json格式字符串转换为json对象
				html+="<p style=\"color: #999999;font-size: 13px;\">"+p.ruleApplyTypeName+"</p>";
				html+="</a>";
				html+="</div>";
				html+="</td>";
				html+="<td><a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+">"+n.visit+"</a></td>";
				html+="<td><a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+" target=\"_self\">"+n.req+"</a></td>";
				html+="<td><a href="+context+"/f_w/kaidian_x2.jsp?id="+n.id+" target=\"_self\">"+n.p_time+"</a></td>";
				html+="</tr>";
			})
			$(".cj_zs").html("贸易商机("+data.size+")")
			$(".wycy_info_body").append(html);
			$.jqPaginator('#page_home', {
				totalPages: size,
				pageSize : 2,
				visiblePages: 5,
				currentPage: page,
				onPageChange: function (num, type) {
					if (type == 'change') {
						kd_OK(num,pageSize);
					}
				}
			});
		}
	});
}

function wu_z_OK(page,pageSize){
	$.ajax({
		url:context+"/open/chinaMerchantsLogistics",
		type:"get",
		data:{page:page,pageSize:pageSize},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"cms_2_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var html="";
			$(".wl_zs_info_bs").html("");
			/*var size_count =data.size;
			var size = 0;
			if(size_count%pageSize==0){
				size = parseInt(size_count/pageSize);
			}else{
				size = parseInt(size_count/pageSize)+1;
			}*/
			$.each(data.data.items,function(i,n){
				html+="<tr>";
				html+="<td>"+parseInt(i+1)+"</td>";
				html+="<td>"+n.FromCity+"</td>";
				html+="<td>"+n.ToCity+"</td>";
				html+="<td>"+n.Price+"</td>";
				html+="<td><a href=\"javascript:;\">申请</a></td>";
				html+="</tr>";
			});
			$(".wl_zs_info_bs").append(html);
			$.jqPaginator('#page_home', {
				totalPages: data.data.paged.pageCount,
				pageSize : 20,
				visiblePages: 5,
				currentPage: page,
				onPageChange: function (num, type) {
					if (type == 'change') {
						wu_z_OK(num,pageSize);
					}
				}
			});
		}
	});
}