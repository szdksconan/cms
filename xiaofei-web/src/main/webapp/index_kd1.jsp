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
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/index_kd1.js"></script>
</head>
<body>
<!--消费顶部-->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div class="xf_tsou"><a href="index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"/>
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <img src="${pageContext.request.contextPath}/images/xf_sou1.jpg">
        <!-- <span> <a href="regist.jsp" target="_self" class="btn btn-he btn-w100" type="button">我要创业</a></span> -->
    </div>
    <!-- 下面菜单-->
    <div class="xf_smenu">
    </div>

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
        <li>
            <a href="index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li class="active">
            <a href="index_kd.jsp" target="_self">我要创业</a>
        </li>
        <li>
            <a href="index_cx.jsp" target="_self">创新定制</a>
        </li>
        <li><a href="index_wli.jsp" target="_self">我要发货</a>
        </li>
        <li>
            <a href="index_tj.jsp" target="_self">消费统计</a>
        </li>
    </ul>

</div>


<div class="xf_thd">
    <div class="cfw_x" style="padding: 20px  0  20px  20px">

        <ul class="nav nav-tabs" role="tablist" id="tab-list">
            <li class="active"><a href="#cfw_c1" onclick="kd_OK(1,2);" role="tab" data-toggle="tab" class="cj_zs">贸易商机（0）</a></li>
            <li><a href="#cfw_can1" role="tab" onclick="wu_z_OK(1,20);" data-toggle="tab" class="my_zs">物流商机（0）</a></li>
        </ul>
        <%-- <P style="width: 100%;height: 40px;padding: 20px  0 0 20px;font-size: 14px;">
            <a href="f_w/ditu.jsp" target="_self"> <img src="${pageContext.request.contextPath}/images/b.png"> </a>
            <input type="text" style="margin-left: 20px;" id="city" value="请选择地区" class="areainput"/>
            <i style="margin-left: 20px;" class="fa fa-desktop" aria-hidden="true"></i>&nbsp;意向产品&nbsp;<input
                type="text" value="+" class="cmao_inplg"/>
            <i style="margin-left: 20px;" class="fa fa-picture-o" aria-hidden="true"></i>&nbsp;关键词&nbsp;
          <span style="border: 1px solid #dddddd;width: 150px;margin:-5px 0 0 0;height: 32px;padding-top: 4px;display: inline-block;">
          <input type="text" value="" style="width: 120px;border: 0;">
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg" style="display: none;">
         </span>
            <span>
                <a class="btn btn-hu btn-w80" type="button"
                   style="width: 55px;height: 32px;margin: 0 0 0 5px;font-size: 13px;padding-top: 6px;">搜索</a>
            </span>
        </P> --%>

        <div class="tab-content" style="border: 0">
            <!--基本信息-->
            <div class="tab-pane active" id="cfw_c1">
            	<P style="width: 100%;height: 40px;padding: 20px  0 0 20px;font-size: 14px;">
            <a href="f_w/ditu.jsp" target="_self"> <img src="${pageContext.request.contextPath}/images/b.png"> </a>
            <input type="text" style="margin-left: 20px;" id="city" value="请选择地区" class="areainput"/>
            <i style="margin-left: 20px;" class="fa fa-desktop" aria-hidden="true"></i>&nbsp;意向产品&nbsp;<input
                type="text" value="+" class="cmao_inplg"/>
            <i style="margin-left: 20px;" class="fa fa-picture-o" aria-hidden="true"></i>&nbsp;关键词&nbsp;
          <span style="border: 1px solid #dddddd;width: 150px;margin:-5px 0 0 0;height: 32px;padding-top: 4px;display: inline-block;">
          <input type="text" value="" style="width: 120px;border: 0;">
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg" style="display: none;">
         </span>
            <span>
                <a class="btn btn-hu btn-w80" type="button"
                   style="width: 55px;height: 32px;margin: 0 0 0 5px;font-size: 13px;padding-top: 6px;">搜索</a>
            </span>
        </P>
                <table class="table1 mt10" style="font-size: 15px;margin-top: 20px;">
                    <thead>
                    <tr>
                        <th width="120">招商单位</th>
                        <th width="220">&nbsp;</th>
                        <th width="120">招募信息</th>
                        <th width="120">浏览次数</th>
                        <th width="120">申请次数</th>
                        <th width="180">发布时间</th>

                    </tr>

                    </thead>
                    <tbody class="wycy_info_body" id="wycy_info_body">
                    </tbody>

                </table>

            </div>
            <!--企业信息-->
            <div class="tab-pane" id="cfw_can1">
            <P style="width: 100%;height: 40px;padding: 20px  0 0 20px;font-size: 14px;">
            <i style="margin-left: 20px;" class="fa fa-picture-o" aria-hidden="true"></i>&nbsp;关键词&nbsp;
            <span style="border: 1px solid #dddddd;width: 150px;margin:-5px 0 0 0;height: 32px;padding-top: 4px;display: inline-block;">
          <input type="text" value="" style="width: 120px;border: 0;">
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg" style="display: none;">
         </span>
            <span>
                <a class="btn btn-hu btn-w80" type="button"
                   style="width: 55px;height: 32px;margin: 0 0 0 5px;font-size: 13px;padding-top: 6px;">搜索</a>
            </span>
        </P>
				<table class="table1 mt10" style="font-size: 15px;margin-top: 20px;">
                    <thead>
                    <tr>
                        <th width="15%">序号</th>
                        <th width="20%">起始地</th>
                        <th width="20%">到达地</th>
                        <th width="28%">价格/元¥/年</th>
                        <th width="17%">操作</th>
                    </tr>

                    </thead>
                    <tbody class="wl_zs_info_bs">
                    <!-- <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr>
                    </tbody>
                    <tbody>
                    <tr>
                        <td>
                            1
                        </td>
                        <td>
                            成都
                        </td>
                        <td>
                            乌鲁木齐
                        </td>
                        <td>
                            2,500，000
                        </td>

                        <td><a href="f_w/kaidian_x2.html" target="_self">2016-6-25 &nbsp;15:25:12</a></td>
                    </tr> -->
                    </tbody>
                </table>

            </div>

        </div>
    </div>

</div>

<!--分页-->
<div class="xf_chatu" align="center">
    <div class="pagination" id="page_home"></div>
</div>

<div class="xf_chatu"><img src="${pageContext.request.contextPath}/images/t3.jpg"></div>
<div align="center">
    <script src="index_foot.js">

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

<script type="text/javascript" src="${pageContext.request.contextPath}/js/scroll.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('.list_lh li:even').addClass('lieven');
    })
    $(function () {
        $("div.list_lh").myScroll({
            speed: 40, //数值越大，速度越慢
            rowHeight: 44 //li的高度
        });
    });
</script>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    body {
        background: none;
    }

    input, button, select, textarea {
        outline: none;
    }

    ul, li, dl, ol {
        list-style: none;
    }

    a {
        color: #666;
        text-decoration: none;
    }

    .box {
        width: 1200px;
        margin: 0 auto;
    }

    .bcon {
        width: 1200px;
        border: 1px solid #eee;
        margin: 30px auto;
    }

    .bcon h1 {
        border-bottom: 1px solid #eee;
        padding: 0 10px;
    }

    .bcon h1 b {
        border-top: 2px solid #3492D1;
        padding: 0 8px;
        margin-top: -1px;
        display: inline-block;
    }

    .list_lh {
        height: 400px;
        overflow: hidden;
    }

    .list_lh li {
        padding: 10px;
    }

    .list_lh li.lieven {
        background: #ffffff;
    }

    .list_lh li p {
        height: 24px;
        line-height: 24px;
    }

    .list_lh li p a {
        float: left;
    }

    .list_lh li p em {
        width: 80px;
        font: normal 12px/24px Arial;
        color: #FF3300;
        float: right;
        display: inline-block;
    }

    .list_lh li p span {
        color: #999;
        float: right;
    }

    .list_lh li p a.btn_lh {
        background: #28BD19;
        height: 17px;
        line-height: 17px;
        color: #fff;
        padding: 0 5px;
        margin-top: 4px;
        display: inline-block;
        float: right;
    }

    .btn_lh:hover {
        color: #fff;
        text-decoration: none;
    }

    .btm p {
        font: normal 12px/24px 'Microsoft YaHei';
        text-align: center;
    }

</style>
</body>

<script>
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