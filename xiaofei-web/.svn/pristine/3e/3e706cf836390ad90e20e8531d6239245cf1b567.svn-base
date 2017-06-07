<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
     <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/kaidian_x2.js"></script>

</head>
<body>
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">创业申请</span>
    </div>

</div>

<!-- 创新标题-->
<div class="xf_thd">
    <div class="xf_cxlabel1">
        <i class="fa fa-caret-right"></i>&nbsp;招商单位
    </div>
    <P style="font-size: 22px" class="zs_gs_name"></P>
    <span style="font-size: 14px;width: 390px;text-align: left;height: 50px;">
        <img style="margin-top: -3px" src="${pageContext.request.contextPath}/images/b.png">地址
        <p class="zs_gs_address"></p>
    </span>
     <span style="font-size: 14px;width: 390px;text-align: left;height: 50px;">
        <i style="font-size: 20px;color: #ffc100;" class="fa fa-user" aria-hidden="true"></i>&nbsp;联系人
        <p class="zs_gs_lxr"></p>
    </span>
     <!-- <span style="font-size: 14px;width: 390px;text-align: left;display: inline-block;height: 50px;">
       <i style="font-size: 20px;color: #ffc100;" class="fa fa-envelope"></i>&nbsp;邮箱
        <p>18782250255@163.com</p>
    </span> -->

    <p style="display: inline-block;" class="h_xuline"></p>
    <p style="margin-top:10px;font-size: 14px;">
        <span style="margin: 10px 0 20px 0;width: 380px;display: inline-block;height: 28px;">
        <img style="margin: -3px 0 0 -5px;" src="${pageContext.request.contextPath}/images/b1.png">发布时间 :<a class="zs_gs_time"></a>
          </span>
        <span style="margin: 10px 0 20px 0;width: 390px;display: inline-block;height: 28px;">
        <i style="font-size: 20px;color: #ffc100;" class="fa fa-search "></i>&nbsp;浏览次数:<a class="zs_gs_vs"></a>
        </span>
        <span style="margin: 10px 0 20px 0;width: 390px;display: inline-block;height:28px;">
         <i style="font-size: 20px;color: #ffc100;" class="fa fa-picture-o" aria-hidden="true"></i>&nbsp;申请次数:<a class="zs_gs_sq"></a>
        </span>
    </p>
</div>


<!-- 招募信息-->
<div class="xf_thd" style="font-size: 14px">
    <div class="xf_cxlabel1">
        <i class="fa fa-caret-right"></i>&nbsp;招募信息
    </div>
    <P >招商条件&nbsp;Investment condition</P>
    <P class="h_xuline"></P>
    <p style="width: 1130px;margin:20px 0 0 60px;" class="zs_gs_dise">
        
    </p>

    <P style="margin:50px 0 0 0;">招商区域&nbsp;Investment condition</P>
    <P class="h_xuline"></P>
    <table class="table1 mv" style="font-size: 14px;width: 80%;margin: 20px 0 0 45px;border: 0;">

        <tbody>
        <tr>
            <td>省</td>
            <td>市</td>
            <td>区</td>
        </tr>
        </tbody>
        <tbody class="zs_gs_adre">
        </tbody>

    </table>
    <P style="margin:50px 0 0 0;">招商商品&nbsp;Merchants commodities</P>
    <P class="h_xuline"></P>
    <table class="table1 mv" style="font-size: 14px;width: 80%;margin: 20px 0 0 45px;border: 0;">

        <tbody>
        <tr>
            <td></td>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>品牌</td>
            <td>商品类型</td>
        </tr>
        </tbody>
        <tbody class="sp_info_body">
        
        </tbody>

    </table>
   </div>
<div class="xf_thd">
   <p class="h_line"></p>
    </div>
<div class="xf_thd">
<a style="margin:20px 60px 20px 10px" href="javascript:void(0);" onclick="apply_button();"  class="btn btn-he btn-w100"
                   type="button">我要申请</a>*注意：此处要对招商商品进行了勾选，才能够进行下一步，点击我要申请时要进行判断
</div>


<div align="center">
    <script src="${pageContext.request.contextPath}/index_foot.js">

    </script>
</div>

<style>
    .mv tbody tr td {
        background-color: #ffffff;
        border: 1px solid #dddddd;
    }

    .onError {
        font-size: 15px;
        color: #f10202;
        margin: 3px 0 0 15px;
        float: left;
    }
</style>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this, e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        /*添加行数据*/
        $(".J_add").click(function () {
            var this_html = $(this).parent().parent().prev().html();//当前新增所在行的html
            var after_tr = $(this).parent().parent().prev().after("<tr class='after_tr'></tr>");//向当前行插入一行tr
            var after_tr = $(".after_tr");//选择插入行的类名
            after_tr.html(this_html);//把变量this_html内容插入到创建后的空tr中
            after_tr.find(".J_add").addClass("J_del").removeClass("J_add").text("删除");

            $(".J_del").live("click", function () {
                $(this).parents("tr").remove();
            });//把原来新增操作改成删除操作，并且把它的类名改成J_del
        });
        //移除方法
        $(".J_del").live("click", function () {
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