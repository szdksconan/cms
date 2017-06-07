<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/showwuliu.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
<!--消费顶部-->
<!-- <div align="center" >
    <script src="index_head.js">
    </script>
</div> -->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="index.jsp" target="_self"><img src="images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="images/close.jpg">
        </div>
        <img src="images/xf_sou1.jpg">
        <!-- <span> <a   class="btn btn-he btn-w100" type="button" >免费发布</a></span> -->
    </div>
    <!-- 下面菜单-->
    <div class="xf_smenu">

    </div>

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
      <li >
            <a href="index.jsp" target="_self">产品购买</a>
        </li>
        <li >
            <a  href="index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li >
            <a href="index_kd.jsp" target="_self">我要创业</a>
        </li>
        <li >
            <a href="index_cx.jsp" target="_self">创新定制</a>
        </li >
        <li class="active"> <a href="index_wli.jsp" target="_self">我要发货</a>
        </li>
        <li>
            <a href="index_tj.jsp" target="_self">消费统计</a>
        </li>
    </ul>

</div>

<!--   主要浮动菜单广告图-->
<div class="xf_cxd" style="border: 0">
<p>
<img src="images/geren/ge_1.jpg">
</p>
 <div class="xf_cxfabu" >
     <span style="margin:10px 0 0 250px;">
     <a href="javascript:void(0);" style="color: #0044cc;font-size: 16px;">物流运输什么是？</a></span>
      <a  style="margin-left: 60px;" href="f_w/wuliu_2.jsp" target="_self" class="btn btn-blue btn-w120 " type="button" >发布物流需求</a>
 </div>

</div>
<div class="xf_thd">
   <table  class="table1" style="border: 0">
  
    <thead>
    <tr>
        <th style="font-size:15px">始发地</th>
        <th style="font-size:15px">到达地</th>
        <th style="font-size:15px">运输时间</th>
        <th style="font-size:15px">报价（元）</th>
        <th style="font-size:15px">接受报价</th>
        <th style="font-size:15px">需接货</th>
        <th style="font-size:15px">需送货</th>
        <th style="font-size:15px">&nbsp;</th>
    </tr>
    </thead>
      <tbody id="show">
       </tbody>
   </table>
</div>
<!--   liebia列表-->

<!-- fenye分页-->
<div class="xf_chatu" align="center">
    <div class="pagination" id="page_home"></div>
</div>
<!---->
<!-- 底部-->
<div align="center" >
    <script src="index_foot.js">

    </script>
</div>

</body>

<script>
    $('.xf_cl').hide();
    $("input").each(function(){
        $(this).focus(function(){
            if( $(this).val() == $(this).get(0).defaultValue ){
                $(this).val("");
                $('.xf_cl').show();
            }
        });
        $(this).blur(function(){
            if( $(this).val() == "" ){
                $(this).val( $(this).get(0).defaultValue );
                $('.xf_cl').hide();
            }
        })
    });

    $(".xf_tsouy div img").click(function(){
        $(this).hide();
        $(".xf_input").val( $(this).get(0).defaultValue );
    });

</script>
</html>