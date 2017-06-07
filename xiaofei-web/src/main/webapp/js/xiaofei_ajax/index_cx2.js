$(document).ready(function() {
	var op="";
	loading_OK(op);
});

function loading_OK(op){
	$.ajax({
		url:context+"/innovation/selectGetListContInfo",
		type:"get",
		data:{opTime:op,page:0,pageSize:0},
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_cms1",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			var html="";
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
			if(op!=""){
				$(".cx_basic_info_bise").append(html);
				$("div.holder").jPages({
					containerID: "tab-cominfo",
					perPage: 10
				});
			}else{
				$(".cx_basic_info").append(html);
				$("div.holder").jPages({
					containerID: "tab-basicinfo",
					perPage: 1
				});
			}
			//$(".cx_basic_info").append(html);
			
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