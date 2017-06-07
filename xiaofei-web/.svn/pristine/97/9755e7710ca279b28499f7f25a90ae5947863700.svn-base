$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var Id=GetQueryString("Id");
	$.ajax({
		url:context+"/innovation/selectGetCmsXReqRecByDetails?Id="+Id,
		type:"get",
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$.each(data,function(i,n){
				$(".xq_cx_title").text(n.reqTitle);
				$(".xq_cx_time").text(n.opTime);
				$(".xq_cx_num").text(n.viewNum);
				$(".xq_cx_des").text(n.reqBrief);
				$(".xq_cx_prict").append("￥"+n.cash);
				$(".xq_cx_rname").text(n.realName);
				$(".xq_cx_number").text(n.reqNumber);
				$(".tel_phone").text(n.tel);
				$(".dq_address").text(n.loclName);
				var html="";
				$.each(n.attachments,function(j,m){
					if(m.attImgCode!="101"){
						$(" <div class=\" xf_fangdaz1 \" style=\"width: 115px;height: 145px;\">"
							+	"<div class=\"box f_refada\" >"
							+"<div class=\" tb-pic xf_refada0\" >"
							+"<img src="+m.attLoc+" alt=\"产品\"  class=\"jqzoom xf_refada0\" style=\"margin-left:20px;\" />"
							+ "</div>"
							+ "</div>"
							+ "</div>").appendTo(".xq_cx_img");
					}else{
						html+="<p>";
						html+="<span>"+m.attName+"</span> &nbsp;" ;
						html+="<span>"+m.attSize+"</span>&nbsp;" ;
                   		//"<a href=\"javascript:;\" onclick=\"cx_download('"+m.attKey+"','"+m.attLoc+"')\"; class=\"orange\" >下载</a></span>"
						if(m.attType=="image/jpeg"||m.attType=="text/plain"){
							html+="<span><a target=\"_blank\" href='"+m.attLoc+"' class=\"orange\" >查看</a></span>";
						}else{
							html+="<span><a href='"+m.attLoc+"' class=\"orange\" >下载</a></span>";
						}
						html+="</p>";
					}
				});
				$(".xq_cx_dload").append(html);
			});
		}
	});
});
