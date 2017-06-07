<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/cmaoxiaofei.css">
    <script src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="../css/caidan.css" rel="stylesheet" type="text/css">

</head>
<body >
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!-- <div align="center" >
    <script src="index_head.js">

    </script>
</div> -->

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="../index.jsp" target="_self"><img src="../images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="../images/close.jpg">
        </div>
        <a href="../f_w/s_no.jsp" target="_self"><img src="../images/xf_sou.jpg"></a>
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
            <a href="../index.html" target="_self">产品购买</a>
        </li>
        <li>
            <a href="../index_sj.html" target="_self">世界名品</a>
        </li>
        <li>
            <a href="../index_kd.html" target="_self">我要创业</a>
        </li>
        <li>
            <a href="../index_tj.html" target="_self">消费统计</a>
        </li>
        <li>
            <a href="../index_cx.html" target="_self">创新定制</a>
        </li>
    </ul>

</div>

<div class="xf_thd">

    <p style="padding: 50px 30px 30px 30px;">
        <span style="font-size:18px">&nbsp;感谢您提交订单，请于1小时内进行支付，我们会在之后尽快处理您的订单。</span>
        <a  style="margin-left: 20px;" href="gouc_zf.jsp"  target="_self" class="btn btn-he btn-w150" type="button" >立即支付</a>

    </p>

</div>
<!--虚线-->
<div class="xf_thd">
    <p class="h_line">
    </p>
</div>
<div class="xf_thd">

        <p style="padding: 50px 30px 30px 30px;text-align: center;">&nbsp;

            <a   href="../index_cp.jsp"  target="_self" class="btn btn-he btn-w150" type="button" >继续选购商品</a>

        </p>

</div>

<!--虚线-->
<div class="xf_thd" style="height:40px;">
    <p style="font-size: 16px;">
        <img style="float: left" src="../images/gang.jpg">&nbsp;你可能感兴趣产品
    </p>
</div>

<div class="xf_tu">
    <span>
          <a href="../index_cp.html" target="_self">
              <p><img src="../images/t06.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;纯金属汽车轮毂</p>
              <p>丰田汽车有限公司</p>
              <p><img src="../images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="../index_cp.html" target="_self">
              <p><img src="../images/t07.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;高档汽车润滑油</p>
              <p>丰田汽车有限公司</p>
              <p><img src="../images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="../index_cp.html" target="_self">
              <p><img src="../images/t08.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;后备箱必备工具箱</p>
              <p>丰田汽车有限公司</p>
              <p><img src="../images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="../index_cp.html" target="_self">
              <p><img src="../images/t09.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;驾驶台必备手机架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="../images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="../index_cp.html" target="_self">
              <p><img src="../images/t010.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;座椅后面的杯架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="../images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>

</div>
<div align="center" >
    <script src="../index_foot.js">

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
</body>
</html>