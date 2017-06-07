<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
<h2>产贸送公共平台登陆</h2>
<form:form action="loginAuth" method="post" target="_parent" modelAttribute="loginForm">
	用户名：<form:input path="loginName"/><br>
	密      码：<input type="password" name="password"/><br>
	是否自动登陆<input type="checkbox" name="autoLogin"/><br>
	<form:hidden path="systemId" value="1" />
	<form:hidden path="redirect" />
	<font color="red"><%=(String)request.getAttribute("message") %></font><br><br>
	<input type="submit" value="登  陆">
</form:form>
</body>
</html>
