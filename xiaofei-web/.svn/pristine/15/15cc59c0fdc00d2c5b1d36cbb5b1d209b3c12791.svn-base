<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="com.cms.util.CmsUtil" %>
	
     <%
  String name="";
     name=CmsUtil.CheckLogin(request);
  %> 
  <script src="${pageContext.request.contextPath}/js/logionComm.js"></script>
    
    <%-- <script src="${pageContext.request.contextPath}/js/loginsucceed.js"></script> --%>
<div class="xf_top">
	<div class="xf_head">
	
	<ul>
            <li><a href="${pageContext.request.contextPath}/f_w/ditu.jsp" target="_self" class="active"><img src="${pageContext.request.contextPath}/images/di_1.png"> &nbsp;成都</a></li>
            <%-- <li><a href="${pageContext.request.contextPath}/wuliou.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/di_2.png">&nbsp;消息</a></li> --%>
            <li><a href="${pageContext.request.contextPath}/App/app.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/di_4.png">&nbsp;手机APP</a></li>
            <li><a href="${pageContext.request.contextPath}/gouc.jsp" target="_self">购物车&nbsp;<img src="${pageContext.request.contextPath}/images/di_3.png"></a></li>
            <li><a href="${pageContext.request.contextPath}/f_w/my_sou.jsp" target="_self">收藏夹&nbsp;<img src="${pageContext.request.contextPath}/images/di_3.png"></a></li>
            <%-- <li><a href="${pageContext.request.contextPath}/wuliou.jsp" target="_self">客服中心&nbsp;<img src="${pageContext.request.contextPath}/images/di_3.png"></a></li> --%>
        </ul>
	
	
		<%-- <ul>
			<li><a class="active" target="_self" href="index.jsp">成都</a></li>
			<li><a target="_self" href="wuliou.jsp">消息</a></li>
			<li><a target="_self" href="gouc.jsp">购物车</a></li>
			<li><a target="_self" href="wuliou.jsp">收藏夹</a></li>
			<li><a target="_self" href="wuliou.jsp">客服中心</a></li>
			<li><a target="_self" href="${pageContext.request.contextPath}/f_w/index_people.jsp">个人中心</a></li>
		</ul> --%>
		<div id="logindiv" class="xf_dz">
			<a target="_self" id="login_1" href="${pageContext.request.contextPath}/g_w/gouc_login.jsp" >登录</a> <a>
				/ </a> <a id="login_2" target="_self" href="${pageContext.request.contextPath}/g_w/gouc_regist.jsp">注册</a>
		</div>
	</div>
</div>
  <script >
  //$(document).ready(function() {
	    var context = "${pageContext.request.contextPath}";
	    var userid="<%=name%>";
	    
	    if(userid!=""){
	    	//alert(userid);
	    	var logindivhtml="<a href='${pageContext.request.contextPath}/f_w/index_people.jsp' target='_self' >"+userid+"已登录!!!</a>";
	    	$("#logindiv").html(logindivhtml);
	    	/* $("#login_1").text(userid+"已登录!!");
	    	$("#login_1").attr("href","javascript:void(0);");
	    	$("#login_2").jsp("");
	    	$("#login_2").attr("href","javascript:void(0);");  */
	    }
  //})
    </script>