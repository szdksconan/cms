<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/kaidian.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
</head>
<body style="z-index: 0">
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">个人中心</span>
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
            <Li ><a href="${pageContext.request.contextPath}/f_w/note.jsp" target="_self">订单管理></a>
            </Li>
            <Li  >
                <a href="${pageContext.request.contextPath}/gouc.jsp" target="_self"> 我的购物车></a>
            </Li>
            <Li  class="active">
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
            <Li ><%-- <a href="${pageContext.request.contextPath}/f_w/money.jsp" target="_self">资金管理></a> --%>
            </Li>
            <Li >
                <%-- <a href="${pageContext.request.contextPath}/f_w/zhanghu.jsp" target="_self">账户信息></a> --%>
            </Li>
            <Li > <%-- <a href="${pageContext.request.contextPath}/f_w/tui.jsp" target="_self">退换货管理></a> --%>
            </Li>

        </ul>


    </div>
    <div class="xf_tongjiy ge_ren"  >
        <div class="xf_getou" >
            <img src="${pageContext.request.contextPath}/images/gang.jpg">&nbsp;所有申请记录
            <span> <a   class="btn btn-hu btn-w80" onclick="kd_I_OK(1,2);" type="button" style="width: 55px;height: 32px;padding-top: 4px;margin: 0 0 20px 5px ;float: right;" >搜索</a></span>
        	<div class="xf_sou1 fl" style="border: 1px solid #dddddd;width: 150px;margin:0 0 0 0;height: 32px;padding-top: 4px;float: right;">

                <input type="text" class="xf_input" placeholder="省/市/县/区"  style="width: 120px;border: 0;" />
                <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
            </div>
        </div>
        <!--  2排序 style="display:none"-->
        <div class="xf_getou" >
            <span class="k_d_info" id="k_d_info"></span>

    </div>
    </div>

<!-- fenye分页-->
<div class="xf_chatu" align="center">
   <div class="pagination" id="page_home"></div>
</div>
<!---->
<div class="xf_chatu">
   &nbsp;
</div>
    </div>
<!-- 底部-->
<div align="center" >
    <script src="../index_foot.js">

    </script>
</div>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    function Goto(){}
    function deleteCurrentRow(obj){
        var tr=obj.parentNode.parentNode;
        var tbody=tr.parentNode;
        tbody.removeChild(tr);
    }
</script>
<script>

    function deltr() {
        $(this).hide();
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