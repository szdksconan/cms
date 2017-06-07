$(document).ready(function() {
	if(userid!=null&&userid!=""){
		$.ajax({
			url:context+"/logon/selectlogin?uid="+userid,
			type:"get",
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"cms_2_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				
			}
		})
	}
});