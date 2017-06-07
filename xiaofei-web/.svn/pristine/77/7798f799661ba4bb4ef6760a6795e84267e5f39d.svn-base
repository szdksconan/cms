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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
     <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/addwuliu.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
     <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
</head>
<body>
<!--消费顶部-->
<!-- <div align="center">
    <script src="../g_w/index_head.js"></script>
</div> -->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div class="xf_tsou"><a href="../index.html" target="_self"><img src="../images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">物流需求发布</span>
        <!--<div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="../images/close.jpg">
        </div>
        <img src="../images/xf_sou1.jpg">
        <span> <a   class="btn btn-he btn-w100" type="button" >免费发布</a></span>-->
    </div>
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

     </div>-->

</div>

<!-- 消费顶部菜单
<div class="xf_menu">
    <ul>
     <li><img src="../images/han_f.png" style="margin-top: -1px"> 行业分类</li>
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

</div>-->

<!-- -->
<div class="xf_thd">
    <p style="font-size: 18px;margin: 20px  0 0 20px;">产贸送平台运输报价</p>
    <table  class="table1 mv" style="font-size: 14px;width: 80%;margin: 20px 0 0 20px;border: 0;">
        <tbody>
        <tr>
            <td >长途运费</td>
            <td>接货费</td>
            <td>运货费</td>
            <td>保险费</td>
            <td>税费</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
       <%--  <c:forEach items="${priceList}" var="list"> </c:forEach> --%>
          <td id="reqid" style="display:none">${cmsXLogisticsReq.id}</td>
	      <td id="DistanceFee">50.00</td>  <!-- ${list.DistanceFee} -->
	      <td id="ReceiptGoodsFee">50.00</td>  <!-- ${list.ReceiptGoodsFee} -->
	      <td id="DeliveryGoodsFee"> 50.00</td>  <!-- ${list.DeliveryGoodsFee} -->
	      <td id="InsuredFee">50.00</td>  <!-- ${list.InsuredFee} -->
	      <td id="TaxFee">5.00</td>  <!-- ${list.TaxFee} -->
        </tr>
        </tbody>
    </table>
    <table  class="table1 mv" style="font-size: 14px;width: 80%;margin: 20px 0 0 20px;border: 0;">
        <tbody>
        <tr>
            <td style="font-size: 22px;font-weight: bold;">运费合计：<span id="AmountFee">205.00</span></td><!-- ${list.AmountFee} -->
        </tr>
        </tbody>
    </table>
    </div>
<div class="xf_thd">
       <table style="margin: 30px 0 0 20px;">
           <tbody>
        <tr>
            <td>
               <span style="font-size: 22px;"> 是否接受平台报价标准</span>
                <a style="margin-left: 30px"  class="btn btn-he btn-w100" type="button" onclick="jsbj(1)">接受</a><!-- href="wuliu_4.jsp" target="_self" -->
                &nbsp;<a style="margin-left: 30px"  class="btn btn-he btn-w100" type="button" onclick="jsbj(0)">不接受</a></td><!-- href="wuliu_4.jsp" target="_self" -->
        </tr>
        </tbody>
    </table>
</div>

<div style="position: fixed;left: 0;right: 0;bottom: 0;" align="center">
    <script src="../index_foot.js">

    </script>
</div>

<style>
    .mv tbody tr td{border: 1px solid #dddddd;}
    .onError{font-size: 15px;color: #f10202;margin:3px 0 0 15px;float: left;}
</style>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        /*添加行数据*/
        $(".J_add").click(function(){
            var this_html=$(this).parent().parent().prev().html();//当前新增所在行的html
            var after_tr=$(this).parent().parent().prev().after("<tr class='after_tr'></tr>");//向当前行插入一行tr
            var after_tr=$(".after_tr");//选择插入行的类名
            after_tr.html(this_html);//把变量this_html内容插入到创建后的空tr中
            after_tr.find(".J_add").addClass("J_del").removeClass("J_add").text("删除");

            $(".J_del").live("click",function(){
                $(this).parents("tr").remove();
            });//把原来新增操作改成删除操作，并且把它的类名改成J_del
        });
        //移除方法
        $(".J_del").live("click",function(){
            $(this).parents("tr").remove();
        });
    })
</script>

<script src="${pageContext.request.contextPath}/js/formValidator-4.1.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/DateTimeMask.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/function.js" type="text/javascript"></script>
<script>


    var onShowHtml = "<div class='$class$'>$data$</div>";
    var onFocusHtml = "<div class='$class$'>$data$</div>";
    var onErrorHtml = "<div class='$class$'>$data$</div>";
    var onCorrectHtml = "<div class='$class$'>$data$</div>";
    var onShowClass = "";
    var onFocusClass = "";
    var onErrorClass = "";
    var onCorrectClass = "";



</script>
<script>
    $(".jiehuo1").hide();
    $(".jiehuo2").hide();
    $(".jiehuo3").hide();

    $(".v1").click(function () {
        $(".jiehuo1").hide();

    });

    $(".v2").click(function () {
        $(".jiehuo1").show();

    });

    $(".v4").click(function () {
        $(".jiehuo2").hide();

    });

    $(".v3").click(function () {
        $(".jiehuo2").show();

    });

    $(".v6").click(function () {
        $(".jiehuo3").hide();

    });

    $(".v5").click(function () {
        $(".jiehuo3").show();

    });

    $(".mv").click(function () {
        $(".onError").hide();
    });

    $(".w12").hide();


    $("#yinhang").click(function () {
        $(".jiehuo1").hide();
        $(".jiehuo2").hide();
        $(".jiehuo3").hide();
    });

    $(function () {

        var flag = true;
        $(".hn_1").click(function () {
            if (!flag) {
                flag = true;
                $(this).children("img").attr('src', '../images/geren/gengduo.jpg');

                $(".w12").hide();


            } else {
                flag = false;
                $(this).children("img").attr('src', '../images/geren/gengduo1.jpg');

                $(".w12").show();


            }

        });

    });

    $('.xf_cl').hide();
    $("input").each(function () {
        $(this).focus(function () {
            if ($(this).val() == $(this).get(0).defaultValue) {
                $(this).val("");
                $('.xf_cl').show();
            }
        });
        $(this).blur(function () {
            if ($(this).val() == "") {
                $(this).val($(this).get(0).defaultValue);
                $('.xf_cl').hide();
            }
        })
    });

    $(".xf_tsouy div img").click(function () {
        $(this).hide();
        $(".xf_input").val($(this).get(0).defaultValue);
    });


</script>
</html>