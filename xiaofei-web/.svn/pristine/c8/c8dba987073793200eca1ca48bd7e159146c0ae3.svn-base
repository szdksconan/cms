<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>

</head>
<body>
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!-- <div align="center">
    <script src="index_head.js">

    </script>
</div> -->

<!--消费顶部搜索-->
<div class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"/>
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <img src="${pageContext.request.contextPath}/images/xf_sou1.jpg">
       <!--  <span> <a class="btn btn-he btn-w100" type="button">免费发布</a></span> -->
    </div>
    <!-- 下面菜单-->

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
      <li >
            <a href="${pageContext.request.contextPath}/index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/index_kd.jsp" target="_self">我要创业</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/index_cx.jsp" target="_self">创新定制</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/index_wli.jsp" target="_self">我要发货</a>
        </li>
        <li class="active">
            <a href="${pageContext.request.contextPath}/index_tj.jsp" target="_self">消费统计</a>
        </li>
    </ul>

</div>

<!--   主要浮动菜单广告图-->
<div class="xf_cxd" style="height: 170px">
    <p>
        <img src="${pageContext.request.contextPath}/images/cx_1.jpg">
    </p>
</div>
<!--  zhuyao主要-->
<div class="xf_thd">
    <div class="xf_tongjiz">
        <p><img src="${pageContext.request.contextPath}/images/tj_3.jpg"></p>
        <ul>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/index_qtj1.jsp" target="_self"> <i class="fa fa-clipboard"></i> &nbsp;&nbsp;基本情况统计</a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/index_qtj2.jsp" target="_self"> <i class="fa fa-desktop" aria-hidden="true"></i>&nbsp; 生产平台统计</a>

            </Li>
            <Li class="active">
                <a href="${pageContext.request.contextPath}/f_w/index_qtj3.jsp" target="_self"> <i class="fa fa-cubes" aria-hidden="true"></i>贸易平台统计</a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/index_qtj4.jsp" target="_self"> <i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;
                    消费平台统计</a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/index_qtj4.jsp" target="_self"> <i class="fa fa-car" aria-hidden="true"></i>&nbsp; 物流平台统计</a>
            </Li>
        </ul>


    </div>
    <div class="xf_tongjiy">
        <div class="xf_tjy"></div>

        <p class="xf_hp">
            <span >
  暂时不考虑以下内容<br/>

截止统计时间区间，平台销售额，各个行业的销售额

<br/><span style="font-size: 28px">消费额：

123，345.00

万</span>
           </span>
        </p>

        <div class="xf_tjy1" id="t3" style="width: 520px;height: 450px;">

        </div>
        <div style="margin-left: 20px;">
            <table width="350" border="0" style="font-size: 13px;float: right;">
                <tr>
                    <td height="46">&nbsp;</td>
                    <td width="20"></td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td width="20" height="46"></td>
                    <td width="20">&nbsp;</td>
                    <td width="120">百分比</td>
                    <td width="135">行业</td>
                    <td width="162"><strong>销售额/万</strong></td>
                </tr>
                <tr>
                    <td height="45"><img src="${pageContext.request.contextPath}/images/tongji/y1.png" width="15" height="15"></td>
                    <td></td>
                    <td>70%</td>
                    <td>家用电器</td>
                    <td><strong>2,730</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td></td>
                    <td>20%</td>
                    <td>手机数码</td>
                    <td><strong>546</strong></td>
                </tr>


            </table>
        </div>
        <p class="xf_hp">
            <span class="xf_tq">
           &nbsp;
           </span>
        </p>
        <div style="width: 100%;padding-left: 30px;display: inline-block;margin-top: 20px;">

            <table class="table1 mt10" style="font-size: 14px">
                <thead>
                <tr>
                    <th  style="font-size: 25px"><i class="fa fa-building-o" aria-hidden="true" ></i> 招商数量</th>
                    <th  style="font-size: 25px"><i class="fa fa-credit-card"></i>创业申请</th>
                    <th  style="font-size: 25px"><i class="fa fa-car" aria-hidden="true"></i> 个性定制</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td  style="font-size: 28px">200，456</td>
                    <td  style="font-size: 28px">
                        356，200
                    </td>
                    <td  style="font-size: 28px">
                        789，200
                    </td>

                </tr>
                </tbody>
            </table>

        </div>


        <p class="xf_hp">&nbsp;</p>


        <div class="cfw_x" style="margin-top: -30px;padding-left: 30px;">
            <ul class="nav nav-tabs" role="tablist" id="tab-list">
                <li class="active"><a href="#cfw_c1" role="tab" data-toggle="tab">本周热门top10</a></li>
                <li class=""><a href="#cfw_can1" role="tab" data-toggle="tab">本周热销top10</a></li>


            </ul>

            <div class="tab-content">
                <!--基本信息-->
                <div class="tab-pane active" id="cfw_c1" >

                    <table class="table1 mt10" style="font-size: 14px">
                        <thead>
                        <tr>
                            <th>商品名称</th>
                            <th>访问量</th>
                            <th>名次</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                        <tbody>
                        <tr>
                            <td>Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机</td>
                            <td>
                                2，730
                            </td>
                            <td>
                                1
                            </td>
                        </tr>
                        </tbody>
                    </table>

                </div>
                <!--企业信息-->
                <div class="tab-pane" id="cfw_can1">
                    <div style="width: 100%;height: 450px;" id="t5">

                    </div>
                </div>
                <!--资质信息-->
                <div class="tab-pane" id="cfw_xi1">
                    <div style="width: 100%;height: 450px;" id="t4">

                    </div>
                </div>


            </div>
        </div>


    </div>

    <div class="xf_chatu">
        <img src="${pageContext.request.contextPath}/images/t3.jpg">
    </div>
</div>
<!-- 底部-->
<div align="center">
    <script src="../index_foot.js">

    </script>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/address.js"></script>
<script type="text/javascript">
    $(function () {

        $("#sjld").sjld("#shenfen", "#chengshi", "#quyu");

    });
</script>
</body>



<script type="text/javascript">

    function kpipic() {

        // 路径配置

        require.config({
            paths: {
                echarts: "http://echarts.baidu.com/build/dist"
            }
        });

        // 使用
        require(["echarts", 'echarts/theme/macarons', "echarts/chart/bar", "echarts/chart/pie", // 使用柱状图就加载bar模块，按需加载
                    "echarts/chart/line" //加载折线图
                ], function (ec, theme) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById("t3"), theme);

                    option = {
                        tooltip: {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        toolbox: {
                            show: false,
                            feature: {
                                mark: {show: true},
                                dataView: {show: true, readOnly: false},
                                magicType: {
                                    show: true,
                                    type: ['pie', 'funnel'],
                                    option: {
                                        funnel: {
                                            x: '25%',
                                            width: '50%',
                                            funnelAlign: 'left',
                                            max: 310
                                        }
                                    }
                                },
                                restore: {show: true},
                                saveAsImage: {show: true}
                            }
                        },
                        calculable: true,
                        series: [
                            {
                                name: '支出指标',
                                type: 'pie',
                                radius: '60%',
                                center: ['50%', '60%'],
                                data: [
                                    {
                                        value: 100,
                                        name: '家用电器',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 310,
                                        name: '劳保防护/用品',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 100,
                                        name: '汽车用品/配件',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 310,
                                        name: '电工电气安防品',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 100,
                                        name: '食品/源生鲜',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 310,
                                        name: '鞋包/箱包/配饰',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 100,
                                        name: '男装/女装',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 310,
                                        name: ' 美妆日化',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 100,
                                        name: '母婴用品',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 310,
                                        name: '纺织/皮革',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },


                                ]
                            }
                        ]
                    };
                    // 为echarts对象加载数据
                    myChart.setOption(option);

                }
        );

    }


    $("#t3").each(function () {
        kpipic();
    });
</script>
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