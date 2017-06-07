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
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">

</head>
<body>
<!--消费顶部-->
<!-- <div align="center">
    <script src="../g_w/index_head.js">

    </script>
</div>  -->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div class="xf_tsou"><a href="../index.html" target="_self"><img src="../images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">物流需求详情</span>
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



<!-- 创新标题-->
<c:forEach items="${reqList}" var="list">
<div class="xf_thd">
    <div class="xf_cxlabel" style="height: 80px;">
        <span class="orange" style="float: right;margin-right:600px ">已接受报价</span>
        <p>&nbsp;平台报价：${list.quoteSum} 元</p>
        <p style="margin:10px 0 0 -10px;"><img src="../images/chuangxin/cx_d4.jpg" >发布时间：${list.reqDate}&nbsp;<img src="../images/chuangxin/cx_d5.jpg" >浏览次数：${list.seeCount}</p>
    </div>
</div>
<!-- xuxian-->
<div class="xf_thd">
<p class="h_xuline"></p>
    </div>

<!-- -->
<div class="xf_thd">
    <table class="table1" style="border: 0;font-size: 15px;">
        <tbody>
        <tr>
            <td width="130" align="right">货/订单号：</td>
            <td>${list.id}</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="130" align="right">*始发地：</td>
            <td>${list.descLocalName}</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="130" align="right">*到达地：</td>
            <td>${list.sendLocalName}</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="130" align="right">*运输时间：</td>
            <td>${list.sendDate}</td>
        </tr>
        </tbody>
    </table>
    </div>

<div class="xf_thd">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd">
    <p align="right" style="float: left;font-size: 15px;margin-top: 20px;width: 120px;">*货物信息：</p>
    <table class="table1 mv" style="font-size: 14px;width: 80%;margin-top: 20px;border: 0;">

        <tbody>
        <tr>
            <td >货物名称</td>
            <td>件数</td>
            <td>重量（kg）</td>
            <td>体积（m³）</td>
            <td>货物价值（元）</td>
        </tr>
        </tbody>
        <tbody>
        <c:forEach items="${detailList}" var="list2">
        <tr>
        	<td >${list2.goodsName}</td>
            <td>${list2.goodsNum}</td>
            <td>${list2.goodsWeight}</td>
            <td>${list2.goodsVolume}</td>
            <td>${list2.goodsValues}</td>
         </tr>
         </c:forEach>
        </tbody>

    </table>
</div>
<div class="xf_thd">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" style="padding-left: 30px">
    <div style="font-size: 15px;margin-top: 20px;">是否需接货：<c:if test="${list.needReceipt=='1'}">是
        <div style="margin-top: 10px;">
	    <table class="table1 " style="font-size: 14px;width: 80%;">
	        <tbody>
	        <tr>
	            <td width="60" >接货地：&nbsp;街道地址&nbsp;${list.placeReceipt}</td>
	        </tr>
	        </tbody>
	    </table>
    </div>
    </c:if>
    <c:if test="${list.needReceipt=='0'}">否</c:if></div><br/>
    <div style="font-size: 15px;margin-top: 20px;">是否需接货： <c:if test="${list.needDelivery=='1'}">是</c:if><c:if test="${list.needDelivery=='0'}">否</c:if></div>
    <div style="font-size: 15px;margin-top: 20px;">是否需代收货款： <c:if test="${list.needCashDelivery=='1'}">是</c:if><c:if test="${list.needCashDelivery=='0'}">否</c:if></div>
</div>
<div class="xf_thd"  style="margin-top: 20px">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" style="padding-left: 45px;font-size: 15px;">
    <div style="margin-top: 20px;">附加要求：
   		<c:if test="${list.needAcknowledgement=='1'}"> <input type="checkbox" name="checkbox" checked="checked"/> 回单</c:if>
   		<c:if test="${list.needAcknowledgement=='0'}"> <input type="checkbox" name="checkbox" /> 回单</c:if></div>
    <div style="margin:20px 0 0 75px">
        <c:if test="${list.needUrgent=='1'}"> <input type="checkbox" name="checkbox" checked="checked"/> 加急</c:if>
    	<c:if test="${list.needUrgent=='0'}"> <input type="checkbox" name="checkbox" /> 加急</c:if></div>
    <div style="margin:20px 0 0 75px">
    	<c:if test="${list.needInsured=='1'}"> <input type="checkbox" name="checkbox" checked="checked"/> 保价</c:if>
    	<c:if test="${list.needInsured=='0'}"> <input type="checkbox" name="checkbox" /> 保价</c:if></div>
    <div style="margin:20px 0 0 75px">
    	<c:if test="${list.needPlusDuty=='1'}"> <input type="checkbox" name="checkbox" checked="checked"/> 开具发票</c:if>
    	<c:if test="${list.needPlusDuty=='0'}"> <input type="checkbox" name="checkbox" /> 开具发票</c:if></div>
    <div style="margin:20px 0 0 75px">
    	<c:if test="${list.needControlCargo=='1'}"> <input type="checkbox" name="checkbox" checked="checked"/> 要求控货</c:if>
    	<c:if test="${list.needControlCargo=='0'}"> <input type="checkbox" name="checkbox" /> 要求控货</c:if></div>
    </div>
    <div style="margin:20px 0 0 75px;">
      	  其他要求 ${list.otherInfo}
    </div>

</div>
<div class="xf_thd" style="margin-top: 20px">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" >
    <table class="table1" style="border: 0;font-size: 15px;margin-left: -20px;">
        <tbody>
        <tr>
            <td width="155" align="right">*收货人：</td>
            <td> ${list.descUserName}</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="left" >* 收货人联系方式：</td>
            <td>${list.descUserTel}</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">*发货人：</td>
            <td>${list.sendUserName}</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">手机号码：</td>
            <td>${list.sendUserTel}</td>
        </tr>
        </tbody>
    </table>
</div>
 	<p>${list.userName}</a>&nbsp;</p>
</c:forEach>
<div align="center">
    <script src="../index_foot.js">

    </script>
</div>
<style>
    .mv tbody tr td{border: 1px solid #dddddd;}
    .onError{font-size: 15px;color: #f10202;margin:3px 0 0 15px;}
</style>
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
    $(".w12").hide();

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