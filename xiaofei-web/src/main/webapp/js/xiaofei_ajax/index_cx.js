$(document).ready(function() {
	loading_OK(1,2);
});

function loading_OK(page,pageSize){
	var op="a";
	var key =$(".xf_input").val();
	$.ajax({
		url:context+"/innovation/selectGetListContInfo",
		type:"get",
		data:{opTime:op,key:encodeURIComponent(key),page:page,pageSize:pageSize},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_cms1",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var html="";
			var size_count =data.size;
			var size = 0;
			if(size_count%pageSize==0){
				size = parseInt(size_count/pageSize);
			}else{
				size = parseInt(size_count/pageSize)+1;
			}
			$(".cx_basic_info_bise").html("");
			$(".cx_basic_info").html("");
			$(".c_x_total").text(data.size);
			$.each(data.listData,function(i,n){
				html+="<div class=\"xf_zhanshi result\" >";
				if(n.attachments!=""){
					$.each(n.attachments,function(j,m){
						html+="<img src="+m.attLoc+" width=\"118\" height=\"88\">";
					});
				}else{
					html+="<img src="+context+"/images/f1.jpg width=\"118\" height=\"88\">";
				}
				html+="<div>";
				html+="<p> </p>";
				html+="<p><a class=\"red\" href="+context+"/cx_xq.jsp?Id="+n.customId+" target=\"_self\">"+n.reqTitle+"</a>&nbsp;</p>";
				html+="<p><a  href="+context+"/cx_xq.jsp?Id="+n.customId+" target=\"_self\">"+n.realName+"</a></p>";
				html+="<p><a  href="+context+"/cx_xq.jsp?Id="+n.customId+" target=\"_self\">" ;
				if(n.loclName!=null&&n.loclName!=""){
					html+="<img src="+context+"/images/b.jpg>"+n.loclName+"&nbsp;";
				}else{
					html+="<img src="+context+"/images/b.jpg>未知&nbsp;";
				}
				html+="<img src="+context+"/images/b1.jpg>"+n.opTime+"</a></p>";
				html+="</div>";
				html+="<div class=\"xf_you\">"; 
				html+="<p><img src="+context+"/images/tou.jpg ></p>";
				html+="<p><a class=\"red\" >￥"+n.cash+"</a>&nbsp;</p>";
				html+="</div>";
				html+="</div>";
			});
			//if(op!=""){
				$(".cx_basic_info_bise").append(html);
				$(".cx_basic_info").append(html);
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 2,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							loading_OK(num,pageSize);
						}
					}
				});
			//}
				/*else{
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 2,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							loading_OK("",num,pageSize);
						}
					}
				});
			}*/
		}
	});
	
}

function fu_cx_show(){
	if(userid!=""){
		window.location.href=context+"/cx_fabu.jsp";
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

/*function conditions(){
	alert(1);
}*/