<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送生产平台</title>
    <meta charset="utf-8">
<script >
	    var context = "${pageContext.request.contextPath}";
    </script>

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N5eGdOHnO80ZMcthzYXtRWEc"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css"/>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>

<body>
    <!--主要菜单及对应选项-->
    <div class="xf_thd">
      <div id="allmap">
       </div>
    </div>
<!-- 地图的js和特定样式-->


<style type="text/css">
    #allmap {height:1000px;width:1200px;overflow: hidden;margin: 0 auto;}
    }
</style>
<script src="${pageContext.request.contextPath}/js/ditu.js"></script>
</body>
</html>