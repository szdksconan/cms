<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/note.js"></script>
    
</head>
<body style="z-index: 0">
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="../index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
    </div>
    <!-- 下面菜单-->
</div>
<!--   主要浮动菜单广告图-->
<div class="xf_cxd" style="height: 146px;border: 0;padding-top: 6px;z-index: 2;">
<p>
<img src="${pageContext.request.contextPath}/images/geren/ge_1.jpg">
</p>
</div>
<!-- 头像-->
<!--<div style="position: absolute;top:260px;left:20%; ">
    <img src="${pageContext.request.contextPath}/images/geren/ge_2.png"><br/> raoo
</div>-->
<!--  zhuyao主要-->
<div class="xf_thd" >
    <div class="xf_tongjiz">
      <p  class="ge_rentou"><img src="${pageContext.request.contextPath}/images/geren/ge_2.png"><br/>
      天涯客户111
      </p>
        <ul style="margin-top: 80px;">
            <Li class="active">
                <a href="${pageContext.request.contextPath}/f_w/note.jsp" target="_self">订单管理></a>
            </Li>
            <Li  >
                <a href="${pageContext.request.contextPath}/gouc.jsp" target="_self"> 我的购物车></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/kaidian.jsp" target="_self">创业申请></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/dingzhi.jsp" target="_self">我的定制></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/my_sou.jsp" target="_self">我的收藏></a>
            </Li>
            <Li > <a href="${pageContext.request.contextPath}/f_w/dizi.jsp" target="_self">地址管理></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/my_message.jsp" target="_self">我的消息></a>
            </Li>
            <Li ><!-- <a href="${pageContext.request.contextPath}/f_w/money.jsp" target="_self">资金管理></a> -->
            </Li>
            <Li >
                <!-- <a href="${pageContext.request.contextPath}/f_w/zhanghu.jsp" target="_self">账户信息></a> -->
            </Li>
            <Li > <!-- <a href="${pageContext.request.contextPath}/f_w/tui.jsp" target="_self">退换货管理></a> -->
            </Li>

        </ul>


    </div>




    <div class="xf_tongjiy ge_ren"  >
        <div class="cfw_x" style="padding: 20px  0  20px  20px;">
            <!--  右边搜索框-->
            <span> <a   class="btn btn-hu btn-w80" type="button" style="width: 55px;height: 32px;padding-top: 4px;margin: 0 0 20px 5px ;float: right;" >搜索</a></span>
            <div class="xf_sou1 fl" style="border: 1px solid #dddddd;width: 150px;margin:0 0 0 0;height: 32px;padding-top: 4px;float: right;">
                <input type="text" class="xf_input" value="本店搜索"  style="width: 120px;border: 0;" />
                <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
            </div>
            <!-- 左边切换-->
            <ul class="nav nav-tabs" role="tablist" id="tab-list">
                <li class="active"><a onclick="getOrderInfoList('div1')"  href="#cfw_c1" role="tab" data-toggle="tab">所有订单</a></li>
                <li><a onclick="getOrderInfoList('div2')" href="#cfw_can1" role="tab" data-toggle="tab">待付款</a></li>
                <li><a onclick="getOrderInfoList('div3')" href="#cfw_can2" role="tab" data-toggle="tab">待发货</a></li>
                <li><a onclick="getOrderInfoList('div4')" href="#cfw_can3" role="tab" data-toggle="tab">待收货</a></li>
                <li><a onclick="getOrderInfoList('div5')" href="#cfw_can4" role="tab" data-toggle="tab">待评价</a></li>
            </ul>

            <div class="tab-content" style="border: 0">
                <!--基本信息-->
                <div class="tab-pane active" id="cfw_c1">

                    <table  id="ordersData0" class="table1 mt10" style="font-size: 16px">

                     
                        
                       
<!-- 

                    </table>

                </div>
                <!--企业信息-->
                <div class="tab-pane" id="cfw_can1">
                	<table  id="ordersDatadiv2" class="table1 mt10" style="font-size: 16px">
					</table>
                </div>
                <div class="tab-pane" id="cfw_can2">
					<table  id="ordersDatadiv3" class="table1 mt10" style="font-size: 16px">
					</table>
                </div>
                <div class="tab-pane" id="cfw_can3">
					<table  id="ordersDatadiv4" class="table1 mt10" style="font-size: 16px">
					</table>
                </div>
                <div class="tab-pane" id="cfw_can4">
					<table  id="ordersDatadiv5" class="table1 mt10" style="font-size: 16px">
					</table>
                </div>

            </div>
        </div>

    </div>
</div>



<div class="xf_chatu" align="center">
    <div class="pagination" id="page_home"></div>
</div>



<div class="xf_chatu">
   &nbsp;
</div>
    </div>
<!-- 底部-->
<div align="center" >
    <script src="${pageContext.request.contextPath}/index_foot.js">

    </script>
</div>
<form action="${pageContext.request.contextPath}/ShoppingData/ordersIdData"  method="post" enctype="multipart/form-data"  id="ShopcheckForm" name="ShopcheckForm" >
	<input name="orderId" id="ordersId" style="display:none;" ></input>
</form>

<form action="${pageContext.request.contextPath}/ShoppingData/getordersIdData"  method="post" enctype="multipart/form-data"  id="getorderShopcheckForm" name="getorderShopcheckForm" >
	<input name="orderId" id="getordersId" style="display:none;" ></input>
</form>
<form action="${pageContext.request.contextPath}/ShoppingData/skipNotePin"  method="post" enctype="multipart/form-data"  id="skipNotePincheckForm" name="skipNotePincheckForm" >
	<input name="orderId" id="getPinordersId" style="display:none;" ></input>
</form>

<script type="text/javascript">
    function Goto(){}
    function deleteCurrentRow(obj){
        var tr=obj.parentNode.parentNode;
        var tbody=tr.parentNode;
        tbody.removeChild(tr);
    }

</script>
<script>
    function delInput(that){
        $(that).parent().parent().parent().prev().remove();
        $(that).parent().parent().parent().remove();

    }
    function deltr(that) {
        $(that).parent().parent().prev().remove();
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
    .table1 thead tr th {font-size: 12px;background-color: #f5f5f5;border: 0;}
</style>
</body>
</html>