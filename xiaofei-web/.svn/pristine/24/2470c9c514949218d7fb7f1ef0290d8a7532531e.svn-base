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
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/kaidian_x.js"></script>
    <!-- 放大镜-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.imagezoom.min.js"></script>
</head>
<body>


<!--消费顶部-->
<!-- <div align="center">
    <script src="index_head.js">

    </script>
</div> -->
<%@ include file="../comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div class="xf_tsou">
    <a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">

        <span style="font-size: 22px;margin: 13px 0 0 -100px;float: left;">创业申请详情</span>
    </div>

</div>
<!--  信息验证-->


<!--2-->
<div class="xf_thd">
    <div class="xf_gezan">
        展开招商详情
    </div>
    <div class="xf_gezan0">
        <div class="xf_gezuo">
            <p><img width="224" height="310" id="sj_logo_img" src=""></p>

            <P class="xf_gepai1"><span class="xf_gepai"></span> <br/>
			<p class="sj_js_info"></p>
            </P>
        </div>
        <div class="xf_gezuoy">
            <div class="xf_cxlabel1">
                <i class="fa fa-caret-right"></i>&nbsp;招商单位
            </div>
   <pre style="background-color: #ffffff;border: 0;">
        <span style="font-size:20px; " class="sj_disc_name"></span>

        <p class="sj_recruitRule_info"></p>
   </pre>
            <table class="table1" style="border: 0">
                <tbody>
                <tr>
                    <td><img src="${pageContext.request.contextPath}/images/b.png">地址</td>
                    <td><i class="fa fa-user" aria-hidden="true"></i>联系人</td>
                </tr>
                <tr>
                    <td class="sj_addr_crity"></td>
                    <td class="sj_name_and_tel"></td>
                </tr>
                </tbody>
            </table>
            <div class="xf_cxlabel1">
                <i class="fa fa-caret-right"></i>&nbsp;招商商品
            </div>
            <table class="table1">
                <thead>
                <tr>
                    <td></td>
		            <td>商品编号</td>
		            <td>商品名称</td>
		            <td>品牌</td>
		            <td>商品类型</td>
                </tr>
                </thead>
                <tbody class="sp_info_body">
                </tbody>
            </table>
            <div class="xf_cxlabel1">
                <i class="fa fa-caret-right"></i>&nbsp;招商条件
            </div>
            <table class="table1" style="border: 0">
                <tbody>
                <tr>
                    <td>支付方式：</td>
                    <td class="sj_apply_mony"></td>
                </tr>
                <tr>
                    <td>合作方式：</td>
                    <td class="sj_hz_fs"></td>
                </tr>

                <tr>
                    <td>浏览次数：</td>
                    <td class="sj_user_cs"></td>
                </tr>
                </tbody>
            </table>
            <div class="xf_cxlabel1">
                <i class="fa fa-caret-right"></i>&nbsp;招商区域
            </div>
            <table class="table1 fl" style="border: 0">
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

        </div>
    </div>
    <div class="xf_gezan1">
        收起招商详情
    </div>
</div>
<!--2-->
<!-- 出现的信息-->
<div class="xf_thd">
    <div class="xf_cxlabel1">
        <i class="fa fa-caret-right"></i>&nbsp;我的提交信息
    </div>
    <table class="table1 ll kd_info_user" style="border: 0">
    </table>


   </div>


<!-- 底部-->
<div style="position: fixed;left: 0;right: 0;bottom: 0;" align="center">
    <script src="../index_foot.js">
    </script>
</div>


<script type="text/javascript">
    $(".xf_gezan0").hide();
    $(".xf_gezan1").hide();

    $(".xf_gezan").click(function(){
        $(".xf_gezan0").show();
        $(".xf_gezan").hide();
        $(".xf_gezan1").show();
    });

    $(".xf_gezan1").click(function(){
        $(".xf_gezan0").hide();
        $(".xf_gezan").show();
        $(".xf_gezan1").hide();
    });

    function clo() {
        $(".xf_fangdaz1,.fa ").hide();
    }

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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validate.form.js"></script>


<style>
    .fl tbody tr td {
        border-bottom: 1px dashed #dddddd;
    }
    .ll tbody  {
        border-bottom: 1px dashed #dddddd;
    }
 .table1 tbody tr td{font-size: 15px}
</style>


</body>
</html>