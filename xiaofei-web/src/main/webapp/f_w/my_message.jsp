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
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/my_message.js"></script>
</head>
<body style="z-index: 0">
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div class="xf_tsou"><a href="${pageContext.request.contextPath}/index.html" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">个人中心</span>
        
    </div>
    
</div>
<!--   主要浮动菜单广告图-->
<div class="xf_cxd" style="height: 146px;border: 0;padding-top: 6px;z-index: 2;">
    <p>
        <img src="${pageContext.request.contextPath}/images/geren/ge_1.jpg">
    </p>
</div>

<!--  zhuyao主要-->
<div class="xf_thd">
    <div class="xf_tongjiz">
        <p class="ge_rentou"><img src="${pageContext.request.contextPath}/images/geren/ge_2.png"><br/>
            天涯客户111
        </p>
        <ul style="margin-top: 80px;">
            <Li ><a href="${pageContext.request.contextPath}/f_w/note.jsp" target="_self">订单管理></a>
            </Li>
            <Li  >
                <a href="${pageContext.request.contextPath}/gouc.jsp" target="_self"> 我的购物车></a>
            </Li>
            <Li>
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
            <Li class="active">
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
    <div class="xf_tongjiy ge_ren">
        <!--  2排序-->
        <div class="cfw_x" style="padding: 20px  0  20px  20px">
            <!--  右边搜索框-->
           
            <!-- 左边切换-->
            <ul class="nav nav-tabs" role="tablist" id="tab-list">
                <li class="active"><a href="#cfw_c1" onclick="new_Msg_OK(1,5);" role="tab" data-toggle="tab">新消息</a></li>
                <li><a href="#cfw_can1" role="tab" onclick="have_read_msg_OK(1,5);" data-toggle="tab">已读消息</a></li>
            </ul>

            <div class="tab-content" style="border: 0">
                <!--基本信息-->
                <div class="tab-pane active" id="cfw_c1">
                    <div class="xin_1">
                        <table class="table1 mt10" style="font-size: 15px;cursor: pointer;">
                            <tbody class="new_msg_wdq">
                            
                            </tbody>

                        </table>
                    </div>
                    <div class="xin_2">
 <pre style="background-color:#ffffff;border: 0;color: #333333;font-size: 15px;">
<a class="xin_2_2" style="cursor: pointer"> <i class="fa fa-caret-left"></i>&nbsp;返回</a>
服务消息                                                                                                               <span
         style="float: right"> 2016-04-15  15:15:15</span>
<P>
据官方信息，明确提出商家要在三个方面做好服务工作：

第一，针对客服，建议卖家要从售前到售后统一进行宣导，加强315期间与消费者沟通的敏感度，并注意服务态度；

第二，针对店铺维权纠纷，卖家需要及时关注，在面对消费者有升级投诉意向或涉及敏感词汇的问题时，建议应安排专人优先跟进，做好安抚工作；

第三，卖家要谨慎使用店铺个性化活动，如果有商家已经使用应及时做好后续工作。

众所周知，每年的3月15日是“国际消费者权益日”，在该日中央电视台都会特别开设3·15晚会对存在侵犯消费者权益的商家进行曝光。

此前，工商局就曾公开披露2014年双十一期间出现的售假问题，致股票下跌。此番，为了维护自身形象，在2015年度315消费者权益日来临前就提醒卖家在服务层面防控各种风险。
</P>

 </pre>

                    </div>
                </div>
                <!--企业信息-->
                <div class="tab-pane" id="cfw_can1">
                    <div class="xin_3">
                        <table class="table1 mt10" style="font-size: 15px;cursor: pointer;">
                            <tbody class="yd_have_msg_cont">
                            
                            </tbody>

                        </table>
                    </div>
                    <div class="xin_4">
 <pre style="background-color:#ffffff;border: 0;color: #333333;font-size: 15px;">
<a class="xin_4_4" style="cursor: pointer"> <i class="fa fa-caret-left"></i>&nbsp;返回</a>
服务消息                                                                                                               <span
         style="float: right"> 2016-04-15  15:15:15</span>

     <p>
据官方信息，明确提出商家要在三个方面做好服务工作：

第一，针对客服，建议卖家要从售前到售后统一进行宣导，加强315期间与消费者沟通的敏感度，并注意服务态度；

第二，针对店铺维权纠纷，卖家需要及时关注，在面对消费者有升级投诉意向或涉及敏感词汇的问题时，建议应安排专人优先跟进，做好安抚工作；

第三，卖家要谨慎使用店铺个性化活动，如果有商家已经使用应及时做好后续工作。

众所周知，每年的3月15日是“国际消费者权益日”，在该日中央电视台都会特别开设3·15晚会对存在侵犯消费者权益的商家进行曝光。

此前，工商局就曾公开披露2014年双十一期间出现的售假问题，致股票下跌。此番，为了维护自身形象，在2015年度315消费者权益日来临前就提醒卖家在服务层面防控各种风险。
     </p>

 </pre>

                    </div>
                </div>

            </div>
        </div>

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
<div align="center">
    <script src="../index_foot.js">

    </script>
</div>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this, e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    function Goto() {
    }
    function deleteCurrentRow(obj) {
        var tr = obj.parentNode.parentNode;
        var tbody = tr.parentNode;
        tbody.removeChild(tr);
    }
</script>
<script>
    $(".xin_2").hide();
    $(".xin_1_1").click(function () {
        $(".xin_1").hide();
        $(".xin_2").show();
    });
    $(".xin_2_2").click(function () {
        $(".xin_2").hide();
        $(".xin_1").show();
    });

    $(".xin_4").hide();
    $(".xin_3_3").click(function () {
        $(".xin_3").hide();
        $(".xin_4").show();
    });
    $(".xin_4_4").click(function () {
        $(".xin_4").hide();
        $(".xin_3").show();
    });
    function deltr() {
        $(this).hide();
    }


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
<style>
    .table1 {
        border: 0
    }

    .table1 tbody tr td {
        border-bottom: 1px dashed #dddddd
    }
</style>
</body>
</html>