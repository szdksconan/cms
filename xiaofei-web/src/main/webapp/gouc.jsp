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
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/gouc.js"></script>
</head>
<body  style="outline:none;">
<!--消费顶部-->
<!-- <div align="center" >
    <script src="index_head.js">

    </script>
</div> -->
<%@ include file="comm/cms_head.jsp" %>

<div class="xf_thd">
    <img src="${pageContext.request.contextPath}/images/gouc_2.jpg" usemap="#Map" style="outline:none;">
    <map name="Map">
        <area shape="rect" coords="49,40,228,88" href="index.jsp" target="_self">
    </map>

</div>


<!-- 创新标题-->
<div class="xf_thd">
    <!-- <div class="xf_cxlabel">
        您还没有登录！登录后购物车的商品将保存到您账号中<a style="margin-top: -8px;" href="g_w/gouc_regist.jsp"  target="_self" class="btn btn-he btn-w100" type="button" >立即登录</a>
    </div> -->
</div>
<div class="xf_chatu">
    <span class="orange q_all_num">全部商品（0）</span>
</div>
<div class="xf_thd">
    <table class="table1 mt10" style="font-size: 15px;border: 0;" id="tablight" >
        <thead>
        <tr><!-- onClick="ChkAllClick('chkSon','chkAll')" -->

            <!-- <th >&nbsp;全部</th> -->
            <th >商品</th>
            <th >&nbsp;</th>
            <th >单价（元）</th>
            <th >数量</th>
            <th >小计</th>
            <th >操作</th>

        </tr>
        </thead>
        <tbody class="shopping_cart" id="shopping_cart">
        </tbody> 
    </table>
</div>
<!-- fenye分页-->
<div class="xf_chatu" align="center">
    <div class="pagination" id="page_home"></div>
</div>
<!-- 结算-->
<div class="xf_thd">
    <div class="xf_cxlabel">
        <span style="width:420px;"><a class="orange" ></a></span>

        <span style="width:500px;">已选 <a id="totalnum" class="orange xz_num" > 0</a> 件商品，合计（不含运费和优惠扣减）：<a id="totalprice" class=" red xz_jg_cont" style="font-size: 16px;" >¥ 0.0</a></span>
        <span style="width: 30%"><a  href="javascript:;" onclick="getinputKey()" target="_self" class="btn btn-he btn-w100" type="button" >立即结算</a></span>
    </div>
</div>
<br>
<!-- 底部-->
<div align="center" >
    <script src="index_foot.js">

    </script>
</div>
<form action="ShoppingData/Shoppinglist"  method="post" enctype="multipart/form-data"  id="ShopcheckForm" name="ShopcheckForm" >
	<input name="pid" id="shoppingpid" style="display:none;" ></input>
	<input name="num" id="shoppingnum" style="display:none;" ></input>
	<input name="shopId" id="shoppingshopId" style="display:none;" ></input>
</form>
</body>

<script>

    // --列头全选框被单击---
    function ChkAllClick(sonName, cbAllId){
        var arrSon = document.getElementsByName(sonName);
        var cbAll = document.getElementById(cbAllId);
        var tempState=cbAll.checked;
        for(i=0;i<arrSon.length;i++) {
            if(arrSon[i].checked!=tempState)
                arrSon[i].click();
        }
    }

    // --子项复选框被单击---
    function ChkSonClick(sonName, cbAllId) {
        var arrSon = document.getElementsByName(sonName);
        var cbAll = document.getElementById(cbAllId);
        for(var i=0; i<arrSon.length; i++) {
            if(!arrSon[i].checked) {
                cbAll.checked = false;
                return;
            }
        }
        cbAll.checked = true;
    }

    // --反选被单击---
    function ChkOppClick(sonName){
        var arrSon = document.getElementsByName(sonName);
        for(i=0;i<arrSon.length;i++) {
            arrSon[i].click();
        }
    }



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
<style>
    .selected{
        background-color:#dddddd;
        color:#c0a808;
    }
</style>
</html>