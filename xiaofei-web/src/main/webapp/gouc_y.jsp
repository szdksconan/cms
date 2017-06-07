<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
<script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">

</head>
<body >
<!--消费顶部-->
<!-- <div align="center" >
    <script src="index_head.js">

    </script>
</div> -->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <a href="f_w/s_no.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/xf_sou.jpg"></a>
    </div>
    <!-- 下面菜单-->
    <!-- <div class="xf_smenu">
        <ul>
          <li>
              <a href="javascript:void(0);">服装</a>
          </li>
            <li>
                <a href="javascript:void(0);"> 照明</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="active">办公</a>
            </li>
            <li>
                <a href="javascript:void(0);">化妆品</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="active">机械</a>
            </li>
            <li>
                <a href="javascript:void(0);">皮革</a>
            </li>
        </ul>

    </div> -->

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
      <li  class="active">
            <a href="index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li>
            <a href="index_kd.jsp" target="_self">我要创业</a>
        </li>
        <li>
            <a href="index_tj.jsp" target="_self">消费统计</a>
        </li>
        <li>
            <a href="index_cx.jsp" target="_self">创新定制</a>
        </li>
    </ul>

</div>


<div class="xf_thd">

        <p style="padding: 50px 30px 30px 30px;">&nbsp;<i style="font-size: 48px;color: #16ab4f" class="fa fa-check" aria-hidden="true"></i>
            <span style="font-size: 28px;margin-left: 200px;">商品已加入购物车</span>
            <a  style="margin-left: 100px;" href="gouc.jsp"  target="_self" class="btn btn-he btn-w150" type="button" >去购物车结算</a>
            <a style="margin-left: 100px;font-size: 16px;" href="index.jsp" target="_self" >继续购物</a>
        </p>

</div>
<!--虚线-->
<div class="xf_thd">
    <p class="h_line">
    </p>
</div>
<!--虚线-->
<div class="xf_thd" style="height:40px;">
    <p style="font-size: 16px;">
        <img style="float: left" src="${pageContext.request.contextPath}/images/gang.jpg">&nbsp;附近同类产品
    </p>
</div>

<div class="xf_tu">
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="${pageContext.request.contextPath}/images/t06.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;纯金属汽车轮毂</p>
              <p>丰田汽车有限公司</p>
              <p><img src="${pageContext.request.contextPath}/images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="${pageContext.request.contextPath}/images/t07.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;高档汽车润滑油</p>
              <p>丰田汽车有限公司</p>
              <p><img src="${pageContext.request.contextPath}/images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="${pageContext.request.contextPath}/images/t08.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;后备箱必备工具箱</p>
              <p>丰田汽车有限公司</p>
              <p><img src="${pageContext.request.contextPath}/images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="${pageContext.request.contextPath}/images/t09.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;驾驶台必备手机架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="${pageContext.request.contextPath}/images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="${pageContext.request.contextPath}/images/t010.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;座椅后面的杯架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="${pageContext.request.contextPath}/images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>

</div>
<div align="center" >
    <script src="index_foot.js">

    </script>
</div>
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