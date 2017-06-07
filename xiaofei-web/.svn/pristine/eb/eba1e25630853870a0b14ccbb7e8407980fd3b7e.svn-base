<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
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
   <!--  <div class="xf_smenu">
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
            <a href="../index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="../index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li>
            <a href="../index_kd.jsp" target="_self">我要开店</a>
        </li>
        <li>
            <a href="../index_tj.jsp" target="_self">消费统计</a>
        </li>
        <li>
            <a href="../index_cx.jsp" target="_self">创新定制</a>
        </li>
    </ul>

</div>
<div class="xf_thd">
<table class="table1" style="border:0">

            <tr>
                <td valign="top" style="font-size: 22px"><i class="fa fa-caret-right"></i>&nbsp;请选择支付方式 </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="xf_gwzi">&nbsp;<input type="radio" name="radio" id="radio" value="radio" />&nbsp;产贸送余额   产贸送自己的支付平台</div>
                </td>
            </tr>
            <tr>
                <td valign="middle">
                    <span class="xf_gouy3"><input type="radio" name="radio" id="radio" value="radio" />&nbsp;平台支付</span>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche1.jpg"></a>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche2.jpg"></a>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche3.jpg"></a>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche4.jpg"></a>
                </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="xf_gwzi">&nbsp; <input type="radio" name="radio" id="radio" value="radio" />&nbsp;银行卡支付 <span>
                        <a  class="btn btn-he btn-w100" type="button" >快捷</a></span>无需跳转网银，银行预留手机短信验证进行支付</div>
                </td>
            </tr>


        </table>
</div>
<div class="xf_thd">

    <p style="padding: 50px 30px 30px 30px;">
        <span style="font-size:18px">账户名称：18782250255</span>
    </p>
    <p style="padding: 10px 30px 30px 30px;font-size:18px;">您的账户余额：￥15208.00</p>

</div>
<!--虚线-->
<div class="xf_thd">
    <p class="h_line">
    </p>
</div>
<div class="xf_thd">

    <p style="padding: 30px 30px 30px 30px;">
        <span style="font-size:18px">现将从您的账户消费￥5208.00</span>
    </p>
    <p style="padding: 10px 30px 10px 30px;font-size:18px;">支付密码：<input type="text" class="cmao_inplg" value="请输入支付密码"/></p>
    <p style="padding: 10px 30px 10px 30px;font-size:18px;">动态验证：<input type="text" class="cmao_inplg" value=""/> <a   href="javascript:void(0);"  class="btn btn-he btn-w150" type="button" >发送动态验证码</a></p>
</div>
<!--虚线-->
<div class="xf_thd">
    <p class="h_line">
    </p>
</div>
<div class="xf_thd">

        <p style="padding: 50px 30px 30px 30px">&nbsp;

            <button   class="btn btn-he btn-w150" type="button" >确认支付</button>&nbsp;
            <a  href="gouc_z.jsp" target="_self" class="btn btn-hu btn-w150" type="button" >稍后支付</a>

        </p>

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