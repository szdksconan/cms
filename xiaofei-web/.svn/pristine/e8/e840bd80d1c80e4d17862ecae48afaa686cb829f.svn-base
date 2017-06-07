<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
</head>
<body>
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!-- <div align="center" >
    <script src="index_head1.js">

    </script>
</div> -->

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <img src="${pageContext.request.contextPath}/images/xf_sou1.jpg">
       <!--  <span> <a   class="btn btn-he btn-w100" type="button" >免费发布</a></span> -->
    </div>
    <!-- 下面菜单-->

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
        <li>
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
<div class="xf_thd" >
    <div class="xf_tongjiz">
      <p><img src="${pageContext.request.contextPath}/images/tj_3.jpg"> </p>
        <ul>
            <Li >
                <a href="${pageContext.request.contextPath}/index_tj1.jsp" target="_self"> <i class="fa fa-picture-o" aria-hidden="true"></i>&nbsp;&nbsp;我的消费</a>
            </Li>
            <Li class="active">
                <a href="${pageContext.request.contextPath}/f_w/index_tj2.jsp" target="_self"> <i class="fa fa-pencil-square-o" aria-hidden="true"></i>&nbsp; 消费明细</a>
            </Li>
        </ul>


    </div>
    <div class="xf_tongjiy" >
        <div class="xf_tjy"></div>
        <div class="xf_tjy" style="background-color: #ffffff;padding: 20px  0  0 20px;width: 950px;">
            <span style="display: inline-block;*zomm:1;*display: inline; width:280px;">按时间：默认<br/><input placeholder="请输入日期" class="laydate-icon" onclick="laydate()">&nbsp;至&nbsp;<input placeholder="请输入日期" class="laydate-icon" onclick="laydate()"></span>
            <span style="margin-left: 30px;width:200px;display: inline-block;*zomm:1;*display: inline;">
                按价格：默认&nbsp;从高到低&nbsp;从低到高<br/>
                  <input type="text" class="cmao_inpsm " value=" "  />&nbsp;-&nbsp;<input type="text" class="cmao_inpsm " value=""  />&nbsp;<a   class="btn btn-hu btn-w60" style="height: 32px;padding-top: 5px;" type="button" >确定</a>
            </span>
            <span style="display: inline-block;width: 150px;">
                <div class="xf_sou1 " style="border: 1px solid #dddddd;width: 150px;margin:20px 0 0 0;height: 32px;padding-top:4px;">
                    <input type="text" class="xf_input" value="在结果中搜索" style="width: 120px;">
                    <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg" style="display: none;">

                </div>
            </span>
            <span> <a class="btn btn-hu btn-w80" type="button" style="width: 55px;height: 32px;padding-top: 4px;margin: 0 0 0 5px ;">搜索</a></span>
            <span style="display: inline-block;width: 150px;font-size: 15px;margin-left: 20px;">
                1/5&nbsp;
                <a class="btn btn-hu btn-w50" type="button" style="width: 32px;height: 32px;padding: 4px 0 2px 0;background-color: #ffffff;border: 1px solid #dddddd;"><</a>
                <a class="btn btn-hu btn-w50" type="button" style="width: 32px;height: 32px;padding:4px 0 0 2px;"> ></a>
            </span>
        </div>

        <p  class="xf_hp">
            <img  src="${pageContext.request.contextPath}/images/gang.jpg">&nbsp;近期消费
        </p>
        <div class="xf_zhanshi">
            <table class="table1 mt10" style="font-size: 16px">
                <thead>
                <tr>

                    <th >商品名称</th>
                    <th >&nbsp;</th>
                    <th >&nbsp;</th>
                    <th >数量</th>
                    <th >支出/日期</th>


                </tr>
                </thead>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                       <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
                <tbody>
                <tr>
                    <td > <img src="${pageContext.request.contextPath}/images/w1.jpg" width="106" height="106"></td>
                    <td>
                        <div>
                            <p>
                                Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>
                            <p><a class="red" >￥2370.00</a>&nbsp;</p>
                            <p>Apple专卖店</p>
                            <p>地址：广东省广南市凡苏区东宫街23</p>
                        </div>
                    </td>
                    <td>
                        <P> 颜色：玫瑰金</P><br/>

                        <P>尺码：全球通  4G  32G</P>
                    </td>
                    <td >
                        <div>
                            1
                        </div>
                    </td>
                    <td>
                        <span class="red">¥</span>187.00<br/><br/>
                        2016/04/05
                    </td>
                </tr>
                </tbody>
            </table>


    </div>


</div>
    <!-- fenye分页-->
    <div class="xf_chatu" align="center">
        <div class="page-bar" >
            <a href="javascript:void(0);">首页</a>
            <a href="javascript:void(0);">上页</a>
            <a href="javascript:void(0);">1</a>
            <b>…</b>
            <a href="javascript:void(0);">3</a>
            <a href="javascript:void(0);" class="active">4</a>

            <b>…</b>
            <a href="javascript:void(0);">12</a>
            <a href="javascript:void(0);">下页</a>
            <a href="javascript:void(0);">尾页</a>
                <span>共12页
                到第<input type="text" value="4" class="input-text box-shadow">页
                <a href="javascript:void(0);">确定</a></span>
        </div>
    </div>
<div class="xf_chatu">
    <img src="${pageContext.request.contextPath}/images/t3.jpg" >
</div>
    </div>
<!-- 底部-->
<div align="center" >
    <script src="../index_foot.js">

    </script>
</div>

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
        require(["echarts", // 使用柱状图就加载bar模块，按需加载
                    "echarts/chart/line" //加载折线图
                ], function (ec) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById("t3"));

                    option = {
                        title : {
                            subtext: ''
                        },
                        tooltip : {
                            trigger: 'axis'
                        },
                        toolbox: {
                            show : false,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {show: true, type: ['line', 'bar']},
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        xAxis : [
                            {
                                type : 'category',
                                boundaryGap : false,
                                data : ['11月','12月','1月','2月','3月','4月','5月','6月','7月','8月','9月','10月']
                            }
                        ],
                        yAxis : [
                            {
                                type : 'value',
                                axisLabel : {
                                    formatter: '{value} '
                                }
                            }
                        ],
                        series : [
                            {
                                name:'指标KPI值',
                                type:'line',
                                data:[70, 60, 80, 70, 55, 85, 72, 95,78,75,50,90],
                                itemStyle:{
                                    normal:{
                                        color:'#3092DA',
                                    }
                                },
                                markLine : {
                                    itemStyle:{
                                        normal:{
                                            color:'#74EA91',
                                        }
                                    },
                                    data : [
                                        {type : 'average', name: '平均值'}
                                    ]
                                }
                            },
                        ]
                    };
                    // 为echarts对象加载数据
                    myChart.setOption(option);

                }
        );

    }


    $("#t3").each(function(){
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
        require(["echarts",'echarts/theme/macarons', "echarts/chart/bar", "echarts/chart/pie", // 使用柱状图就加载bar模块，按需加载
                    "echarts/chart/line" //加载折线图
                ], function (ec,theme) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById("t2"),theme);

                    option = {
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        toolbox: {
                            show :false,
                            feature : {
                                mark : {show: true},
                                dataView : {show: true, readOnly: false},
                                magicType : {
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
                                restore : {show: true},
                                saveAsImage : {show: true}
                            }
                        },
                        calculable : true,
                        series : [
                            {
                                name:'支出指标',
                                type:'pie',
                                radius : '60%',
                                center: ['50%', '60%'],
                                data:[
                                    {value:100, name:'运动∣户外',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:310, name:'图书∣音像',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:234, name:'男装∣女装',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:100, name:'电脑∣办公',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:310, name:'手机∣数码',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:234, name:'生产∣制造',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:135, name:'金融',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:125, name:'传媒∣印刷∣艺术∣设计',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}},
                                    {value:100, name:'其他',itemStyle:{normal:{label:{textStyle:{color:'blank'}}}}}
                                ]
                            }
                        ]
                    };
                    // 为echarts对象加载数据
                    myChart.setOption(option);

                }
        );

    }


    $("#t2").each(function(){
        kpi();
    });
</script>
<script>
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
</html>