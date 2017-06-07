<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>

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


<div class="xf_thd">
       <table style="margin: 30px 0 0 20px;">
           <tbody>
        <tr>
            <td>
               <span style="font-size: 22px;"> 您的创业需求，已经通过平台发出，<br/>您可以在个人中心查看您的创业需求详情</span>
                <a style="margin-left: 30px" href="kaidian.jsp" target="_self" class="btn btn-he btn-w150" type="button">去查看记录</a>
                <a style="margin-left: 30px" href="${pageContext.request.contextPath}/index_kd.jsp" target="_self" class="btn btn-he btn-w150" type="button">去看其它的需求</a>
        </tr>
        </tbody>
    </table>
</div>

<div style="position: fixed;left: 0;right: 0;bottom: 0;" align="center">
    <script src="${pageContext.request.contextPath}/index_foot.js">

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