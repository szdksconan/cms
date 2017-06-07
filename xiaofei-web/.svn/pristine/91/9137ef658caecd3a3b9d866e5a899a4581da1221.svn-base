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
            <Li class="active">
                <a href="${pageContext.request.contextPath}/f_w/index_qtj2.jsp" target="_self"> <i class="fa fa-desktop" aria-hidden="true"></i>&nbsp; 生产平台统计</a>

            </Li>
            <Li>
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
            <img src="${pageContext.request.contextPath}/images/gang.jpg">&nbsp;商品种类
        </p>

        <p class="xf_hp">
            <span class="xf_tq">
            &nbsp;
           </span>
        </p>

        <div class="xf_tjy1" id="t3">

        </div>
        <div class="xf_tjy1">
            <table width="578" border="0" style="font-size: 15px">
                <tr>
                    <td height="46">&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td width="20" height="46"></td>
                    <td width="89">&nbsp;</td>
                    <td width="150">累计</td>
                    <td width="135">当月</td>
                    <td width="162"><strong>周</strong></td>
                </tr>
                <tr>
                    <td height="45"><img src="${pageContext.request.contextPath}/images/tongji/y1.png" width="15" height="15"></td>
                    <td>普通商品</td>
                    <td>170，456</td>
                    <td>390</td>
                    <td><strong>2,730</strong></td>
                </tr>
                <tr>
                    <td height="44"><img src="${pageContext.request.contextPath}/images/tongji/y2.png" width="15" height="15"></td>
                    <td>世界名品</td>
                    <td>40,321</td>
                    <td>78</td>
                    <td><strong>546</strong></td>
                </tr>
                <tr>
                    <td height="45">&nbsp;</td>
                    <td>和值</td>
                    <td>330,879</td>
                    <td>780</td>
                    <td><p>5,460</p></td>
                </tr>
            </table>
        </div>
        <p class="xf_hp">
            <span class="xf_tq">
           &nbsp;
           </span>
        </p>

        <div class="xf_tjy1">
            <div id="sjld" style="width:1200px;position:relative;float: left;display:inline-block;height:700px; ">
                <div class="m_zlxg" id="shenfen"
                     style="display: block;width:300px;background: url(${pageContext.request.contextPath}/images/sanjiao11.png)75px 13px no-repeat;">
                    <p title="">选择省份</p>

                    <div class="m_zlxg2" style="width:300px;">
                        <ul style="height:250px; overflow-y:auto;width:300px; "></ul>
                    </div>
                </div>
                <div class="m_zlxg" id="chengshi"
                     style="display: block;width:300px;background: url(${pageContext.request.contextPath}/images/sanjiao11.png)75px 13px no-repeat;">
                    <p title="">选择城市</p>

                    <div class="m_zlxg2" style="min-width:300px;">
                        <ul style="height:250px; overflow-y:auto;width:300px; "></ul>
                    </div>
                </div>
                <div class="m_zlxg" id="quyu"
                     style="display: block;width:300px;background: url(${pageContext.request.contextPath}/images/sanjiao11.png)75px 13px no-repeat;">
                    <p title="">选择区域</p>

                    <div class="m_zlxg2" style="width:300px;">
                        <ul style="height:250px; overflow-y:auto;width:300px; "></ul>
                    </div>
                </div>
            </div>

        </div>

        <p class="xf_hp">&nbsp;</p>


        <div class="cfw_x" style="margin-top: 30px;">
            <ul class="nav nav-tabs" role="tablist" id="tab-list">
                <li class="active"><a href="#cfw_c1" role="tab" data-toggle="tab">本周热门top10</a></li>
                <li class=""><a href="#cfw_can1" role="tab" data-toggle="tab">本周热销top10</a></li>


            </ul>

            <div class="tab-content">
                <!--基本信息-->
                <div class="tab-pane active" id="cfw_c1">

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

        require(["echarts", "echarts/chart/bar", // 使用柱状图就加载bar模块，按需加载
                    "echarts/chart/line" //加载折线图
                ], function (ec) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById("t6"));

                    option = {
                        title: {
                            subtext: ''
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        legend: {
                            data: ['浏览量（pv）', '访客量（uv）']
                        },
                        toolbox: {
                            show: false,
                            feature: {
                                mark: {show: true},
                                dataView: {show: true, readOnly: false},
                                magicType: {show: true, type: ['line', 'bar']},
                                restore: {show: true},
                                saveAsImage: {show: true}
                            }
                        },
                        calculable: true,
                        xAxis: [
                            {
                                type: 'category',
                                boundaryGap: false,
                                data: ['0时', '1时', '2时', '3时', '4时', '5时', '6时', '7时', '8时', '9时', '10时', '11时', '12时', '13时', '14时', '15时', '16时', '17时', '18时', '19时', '20时', '21时', '22时', '23时']
                            }
                        ],
                        yAxis: [
                            {
                                type: 'value',
                                axisLabel: {
                                    formatter: '{value} '
                                }
                            }
                        ],
                        series: [
                            {
                                name: '浏览量（pv）',
                                type: 'line',
                                data: [63, 55, 100, 45, 40, 42, 200, 63, 63, 55, 300, 45, 40, 400, 67, 63, 63, 500, 50, 45, 600, 42, 67],
                                markLine: {
                                    data: [
                                        {type: 'average', name: '平均值'}
                                    ]
                                }
                            },
                            {
                                name: '访客量（uv）',
                                type: 'line',
                                data: [64, 150, 50, 48, 250, 66, 68, 310, 64, 62, 50, 420, 60, 66, 560, 64, 64, 62, 320, 48, 60, 100, 68],
                                markLine: {
                                    data: [
                                        {type: 'average', name: '平均值'}
                                    ]
                                }
                            }
                        ]
                    };
                    // 为echarts对象加载数据
                    myChart.setOption(option);

                }
        );

    }


    $("#t6").each(function () {
        kpipic();
    });
</script>
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
                    var myChart = ec.init(document.getElementById("t5"), theme);

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
                                        name: '创业申请',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    }


                                ]
                            }
                        ]
                    };
                    // 为echarts对象加载数据
                    myChart.setOption(option);

                }
        );

    }


    $("#t5").each(function () {
        kpipic();
    });
</script>
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
                    var myChart = ec.init(document.getElementById("t4"), theme);

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
                                        name: '创新定制',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    }


                                ]
                            }
                        ]
                    };
                    // 为echarts对象加载数据
                    myChart.setOption(option);

                }
        );

    }


    $("#t4").each(function () {
        kpipic();
    });
</script>
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
                                        name: '普通商品',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 310,
                                        name: '世界名品',
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
<script type="text/javascript">

    function kpi() {

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
                    var myChart = ec.init(document.getElementById("t2"), theme);

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
                                        value: 500,
                                        name: '消费者',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 210,
                                        name: '生产商',
                                        itemStyle: {normal: {label: {textStyle: {color: 'blank'}}}}
                                    },
                                    {
                                        value: 334,
                                        name: '贸易商',
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


    $("#t2").each(function () {
        kpi();
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