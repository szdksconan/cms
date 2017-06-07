<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="comm/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
</head>
<body>
<%-- <%@ include file="comm/cms_head.jsp" %> --%>
	<script type="text/javascript">
		$(document).ready(function() {
			$.ajax({
				//url:"innovation/selectAllCmsXReqRecGetInfo",
				url:"open/selectAllUserAndShopAndAttachmentGetInfo",
				//url:"cart/addGoodsToShoppinctart",
				//url:"open/selectAllUserAndShopAndAttachmentGetInfo",
				data:{loclCode:"0010",typeCode:"",page:"1",pageSize:"5"},
				//data:{loclCode:"001001",typeCode:"1001",page:"1",pageSize:"5"},
				//data:{type:"0",typeId:"10010101",title:"",code:"",page:"1",pageSize:"5"},
				type:"get",
				contentType : "application/jsonp",
				dataType:"jsonp",
				jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
				jsonpCallback:"success_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
				success:function(data){
					/* $.each(data,function(i,n){
						var str=n.RECRUIT_RULE;//比如str是你那个字符串
						 eval("var p="+str+";");//将json格式字符串转换为json对象
						 //下面直接解析p这个json对象就OK了.如
						alert(p.ruleBusiRight);
					}); */
				}
			});
			/* $.ajax({
				url:"open/application",
				type:"post",
				data:{compId:"123456789",companyName:"张三",merchantInfoId:"1234567654321",merchantName:"李四",
					investmentOrderId:"1000000001",investmentOrderCode:"EXK00000002",investmentOrderName:"cms",
					productIds:"1001,1002,1003",productNames:"电脑,电视,影像",merchantLocationName:"四川省-成都市-高新区",
					merchantContactPerson:"13302131234"},
				dataType:"json",
				success:function(data){
					
				}
			}) */
		});
	</script>
	<div class="can_index">
		<!-- <img id="img" src="images/we.jpg"> -->
	</div>
</body>
</html>