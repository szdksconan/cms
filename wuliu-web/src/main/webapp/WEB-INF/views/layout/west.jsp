<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
	$(function() {
		$('#layout_west_tree').tree({
			url : 'menu.do?f=menuAllJson',
			parentField : 'pid',
			lines : true,
			onClick : function(node) {
				var  rootT=$('#layout_west_tree').tree('getRoot');
				var  subT =$('#layout_west_tree').tree('getParent',node.target);
				//先移除
				$("#breadcrumb ul li").remove();
				$("#breadcrumb ul span").remove();
				//再追加
				$("#breadcrumb ul").append("<li><a style=\"url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/nav.png) no-repeat right bottom\"><img alt=\"首页\" src=\"${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/icon/iconHome.png\" style=\"margin-top:5px;margin-right:10px;\"></a>"+
						"<img src=\"${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/nav.png\" style=\"no-repeat right bottom; height:25px;\"/></li>");
				$("#breadcrumb ul").append("<li>"+subT.text+"</li>");
				$("#breadcrumb ul").append("<span style=\"background:url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/navigatorActiveLeft.png) no-repeat left top; display:inline-block; padding-left:15px;\">"+
						"<li style=\"background:url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/navigatorActiveRight.png) no-repeat right top; display:inline-block; color:#fff; padding:0 20px 0 10px;\">"+node.text+"</li></span>");
				var url;
				//menuUrl
				if (node.attributes) {
					url = node.attributes;
				} else {
					url ='${pageContext.request.contextPath}/error.jsp';
				}
				if (url.indexOf('druidController') > -1) {/*要查看连接池监控页面*/
					layout_center_addTabFun({
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
					});
				} else {
					layout_center_addTabFun({
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						href : url
					});
				}
			}
		});

	});
</script>
<div class="easyui-accordion" data-options="fit:true,border:false">
	<ul id="layout_west_tree"></ul>
<%--	${menuForm.menuStr}--%>
</div>
