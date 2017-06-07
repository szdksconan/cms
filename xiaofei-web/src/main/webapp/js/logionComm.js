$(document).ready(function() {
	function GetQueryString(name)
	{
	     var reg = new RegExp("(^|$)"+ name +"=([^$]*)(^|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
	var url=GetQueryString("url");
	var urlOl1="";
	var urlOl2="";
	if(url==""||url==null){
		url=window.location;
	}
	if(userid==""||userid==null){
		urlOl1=$("#login_1").attr("href");
		$("#login_1").attr("href",urlOl1+"?url="+url);
		
		urlOl2=$("#login_2").attr("href");
		$("#login_2").attr("href",urlOl2+"?url="+url);
	}
	
})