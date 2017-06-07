<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
	  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/index_cx.js"></script>
</head>
<body >
<!--消费顶部-->
<%@ include   file="comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" placeholder="标题"  />
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <img src="${pageContext.request.contextPath}/images/xf_sou1.jpg" onclick="loading_OK(1,2);">
       <!--  <span> <a   class="btn btn-he btn-w100" type="button" >免费发布</a></span> -->
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
        <li class="active">
            <a href="index_cx.jsp" target="_self">创新定制</a>
        </li>
        <li> <a href="index_wli.jsp" target="_self">我要发货</a>
        </li>
        <li>
            <a href="index_tj.jsp" target="_self">消费统计</a>
        </li>
    </ul>

</div>

<!--   主要浮动菜单广告图-->
<div class="xf_cxd">
<p>
<img src="${pageContext.request.contextPath}/images/cx_1.jpg">
</p>
 <div class="xf_cxfabu">
     <span style="margin-left:300px;"><a href="javascript:void(0);" style="color: #0044cc;font-size: 16px;">什么是创新定制？</a></span>
      <a  style="margin-left: 60px;" onclick="fu_cx_show();" href="javascript:;" target="_self" class="btn btn-blue btn-w120 " type="button" >发布创新定制</a>
 </div>
 <div>
<span style="width:790px;height: auto;font-size: 15px;">
    <img src="${pageContext.request.contextPath}/images/cx_2.jpg">
    <div>
      <P >
          <a  href="javascript:void(0);">男装.女装.内衣.珠宝</a>
          <a style="padding-left: 30px;" href="javascript:void(0);">手机.数码.通信</a>
          <a style="padding-left: 30px;" href="javascript:void(0);">个护化妆.清洁用品</a>
          <a style="padding-left: 30px;" href="javascript:void(0);">电脑.办公</a>
          <a style="padding-left: 30px;" href="javascript:void(0);">家用电器</a>


      </P>
        <P>
            <a  href="javascript:void(0);">家居.家具.家装.厨具</a>
            <a style="padding-left: 30px;" href="javascript:void(0);">汽车.汽车用品</a>
            <a style="padding-left: 35px;" href="javascript:void(0);">母婴.玩具乐器</a>
            <a style="padding-left: 60px;" href="javascript:void(0);">图书.音像</a>
            <a style="padding-left: 30px;" href="javascript:void(0);">运动.户外</a>
        </P>
        <P>
            <a  href="javascript:void(0);">鞋靴.箱包.钟表.奢侈品</a>
            <a style="padding-left:13px;" href="javascript:void(0);">食品.酒类.生鲜.特产</a>
            <a style="padding-left: 30px;" href="javascript:void(0);">营养保健</a>
        </P>
    </div>
</span>

     <span>
    <img src="${pageContext.request.contextPath}/images/cx_4.jpg">
    <div>
        <P>
            <a href="javascript:void(0);"></a>

        </P>
        <P>
            <a href="javascript:void(0);" style="font-size: 15px;">共<span style="font-size: 16px;font-weight: bold;"><span class="c_x_total">0</span>条</span> </a>

        </P>
        <P>

        </P>
    </div>
</span>
 </div>
</div>

<!--   liebia列表-->
<!--供应商物资-->
<div class="cfw_l">
    <div class="xf_li">

    <ul class="nav nav-tabs" role="tablist" id="tab-list" >
        <li class="active"><a href="#tab-basicinfo" onclick="loading_OK(1,2);" role="tab" data-toggle="tab">默认排序</a></li>
        <li><a href="#tab-cominfo" role="tab" onclick="loading_OK(1,2);" data-toggle="tab">按时间</a></li>
        <li><a href="#tab-intelinfo" role="tab" data-toggle="tab">按距离</a></li>

    </ul>
    </div>
    <div class="tab-content">
        <!--基本信息-->
        <div class="tab-pane active cx_basic_info" id="tab-basicinfo" >
        </div>
        <!--企业信息-->
        <div class="tab-pane cx_basic_info_bise" id="tab-cominfo">
            <!-- 物资内容 -->
        </div>
        
        <!--资质信息-->
        <div class="tab-pane" id="tab-intelinfo">2
        </div>
        <!--企业介绍-->
        <div class="tab-pane" id="tab-comintro">3
        </div>
    </div>
</div>
<!-- fenye分页-->
<div class="xf_chatu" align="center" id="pagecontSize">
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