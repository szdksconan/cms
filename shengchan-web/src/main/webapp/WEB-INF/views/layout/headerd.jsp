<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
    function changeHeaderDiv(url,_this){
        $('#left').load(url);
        $('#ul_header li.active').removeClass('active');
        $(_this).children('li').addClass('active');
    }
</script>
	<div>
        新疆产贸送网络有限公司
    </div>
    <div>
      <ul id="ul_header">
          <c:forEach items="${menuList}" var="list">
              <a href="#" onclick="changeHeaderDiv('${ctx}/index/left?menuId=${list.menuId}',this)" target="_self"> <li <c:if test="${list.menuId==1}">class="active"</c:if>>${list.name}</li></a>
          </c:forEach>
          <a href="#" target="_self" > <li >财务管理</li></a>
      </ul>
    </div>