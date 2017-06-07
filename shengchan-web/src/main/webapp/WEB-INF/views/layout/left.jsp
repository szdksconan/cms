<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
    function changeCenterDiv(url,_this){
        $('#center').load(url);
    }
</script>
<div class="cmaoleftBar">
  <div class="cmaoleftBar">
      <c:forEach items="${menuList}" var="list">
          <div class="cmaoleft-menu ">
              <a class="parent-menu no-child-menu" href="javascript:void(0);" target="house-frame">${list.name}</a>
              <ul class="submenu">
                  <c:forEach items="${list.list}" var="menu">
                      <c:if test="${menu.name!=null && menu.name!=''}">
                          <li><a href="javascript:void(0)" onclick="changeCenterDiv('${menu.url}')" target="house-frame">${menu.name}</a></li>
                      </c:if>
                  </c:forEach>
              </ul>
          </div>
      </c:forEach>


      <%--<div class="cmaoleft-menu active">--%>
          <%--<a class="parent-menu no-child-menu" href="javascript:void(0);" target="house-frame">企业信息大厅</a>--%>
          <%--<ul class="submenu">--%>
              <%--<li><a href="javascript:void(0);" target="house-frame" >企业基本信息</a></li>--%>
              <%--<li><a href="javascript:void(0);" target="house-frame"  >生产加工能力信息</a></li>--%>
              <%--<li><a href="javascript:void(0);" target="house-frame"  >品牌及明星产品</a></li>--%>
              <%--<li class="active"><a href="javascript:void(0);" target="house-frame"  >企业联系信息</a></li>--%>
          <%--</ul>--%>
      <%--</div>--%>
      <%--<div class="cmaoleft-menu active">--%>
          <%--<a class="parent-menu no-child-menu" href="javascript:void(0);" target="house-frame">交易规则</a>--%>
          <%--<ul class="submenu">--%>
              <%--<li><a href="javascript:void(0);" target="house-frame" >采购交易规则</a></li>--%>
              <%--<li><a href="javascript:void(0);" target="house-frame"  >期望销售规则</a></li>--%>
              <%--<li><a href="javascript:void(0);" target="house-frame"  >产贸合作规则</a></li>--%>

          <%--</ul>--%>
      <%--</div>--%>
  </div>
</div>