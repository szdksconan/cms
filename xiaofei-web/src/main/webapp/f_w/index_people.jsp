<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
</head>
<body style="z-index: 0">
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>
    <div class="xf_tsouy">
    </div>
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
            <Li >
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
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/dizi.jsp" target="_self">地址管理></a>
            </Li>
            <Li >
                <a href="${pageContext.request.contextPath}/f_w/my_message.jsp" target="_self">我的消息></a>
            </Li>
            <Li >
                <!-- <a href="javascript:void(0);" target="_self">资金管理></a> -->
            </Li>
            <Li >
                <%-- <a href="${pageContext.request.contextPath}/f_w/zhanghu.jsp" target="_self">账户信息></a> --%>
            </Li>
            <Li > <%-- <a href="${pageContext.request.contextPath}/f_w/tui.jsp" target="_self">退换货管理></a> --%>
            </Li>

        </ul>


    </div>
    <div class="xf_tongjiy ge_ren"  >
        <!--  地信息-->
        <div class="ge_ren1">
            <P class="ge_ren3"> 登录名 <span class="red">  Rango77</span></P>

            <P class="ge_ren5"> 安全系数<img src="${pageContext.request.contextPath}/images/xinxin.jpg">中级 </P>

            <P class="ge_ren5"> 登陆密码&nbsp;:&nbsp;修改更高强度的密码能提高账号的安全性</P>

            <P class="ge_ren5"> 支付密码&nbsp;:&nbsp;启用支付密码后，在使用账户资产时，需通过支付密码进行身份验证</P>

            <P class="ge_ren5"> 手机验证&nbsp;:&nbsp;<i style="font-size:15px;color: #16ab4f" class="fa fa-check"
                                                    aria-hidden="true"></i>验证的手机： 187*****257 若已丢失或停用，请立即更换，避免账户被盗</P>

            <P class="ge_ren5"> 邮箱验证&nbsp;:&nbsp;验证后，可用于快速找回登录密码，接收账户余额变动提醒</P>
        </div>
        <!-- 单信息-->
        <div class="ge_ren2">
            <P class="ge_ren6"> 待收款&nbsp;:&nbsp;<span class="red"> 10</span><span class="ge_ren8">待发货&nbsp;:&nbsp;<span class="red"> 10</span></P>
            <P class="ge_ren7"> 待收货&nbsp;:&nbsp;<span class="red"> 10</span><span class="ge_ren9">待评价&nbsp;:&nbsp;<span class="red"> 10</span></P>

            <P class="ge_ren10"> 账户余额&nbsp;:&nbsp;<span class="red"> ￥1,565.00</P>
            <P class="ge_ren11">消费总额&nbsp;:&nbsp;<span class="red"> ￥1,565.00</P>
        </div>


        <p  class="xf_hp" style="margin-top: 10px;display: inline-block;">
            <img  src="${pageContext.request.contextPath}/images/gang.jpg">&nbsp;我的 订单
        </p>
        <div class="xf_zhanshi" style="border: 0">
            <table  class="table1 mt10" style="font-size: 16px">
                <thead>
                <tr>

                    <th width="150" >下单时间：2016-03-05</th>
                    <th >收货人：RANGO7</th>
                    <th> 贸易商：OPPOP服装</th>
                    <th width="150" style="float: right;padding-left: 35px;">订单号：</th>
                    <th width="200">C02-x x x x x 99-2984011</th>


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
                       <P> 数量：5</P><br/>

                        <P class="red">退货/换货</P>
                    </td>
                    <td width="150" align="center">
                        <div style="font-size: 13px;">
                            待收货<br/>￥1,565.00<br/>（含运费20元）
                        </div>
                    </td>
                    <td  align="center" style="line-height: 36px;">
                       <p> <a href="javascript:;" class="red">立即支付</a></p>
                        <p><a href="javascript:;" class="red"> 取消订单</a></p>
                        <p> <a href="javascript:;" class="red">订单详情</a></p>
                    </td>
                </tr>
                </tbody>
                <thead>
                <tr>

                    <th width="150" >下单时间：2016-03-05</th>
                    <th >收货人：RANGO7</th>
                    <th> 贸易商：OPPOP服装</th>
                    <th width="150" style="float: right;padding-left: 35px;">订单号：</th>
                    <th width="200">C02-x x x x x 99-2984011</th>


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
                        <P> 数量：5</P><br/>

                        <P class="red">退货/换货</P>
                    </td>
                    <td width="150" align="center">
                        <div style="font-size: 13px;">
                            待收货<br/>￥1,565.00<br/>（含运费20元）
                        </div>
                    </td>
                    <td  align="center" style="line-height: 36px;">
                        <p> <a href="javascript:;" class="red">立即支付</a></p>
                        <p><a href="javascript:;" class="red"> 取消订单</a></p>
                        <p> <a href="javascript:;" class="red">订单详情</a></p>
                    </td>
                </tr>
                </tbody>

                <tbody>
                <tr>
                  <td colspan="5" >
                      <p  class="xf_hp" style="margin-left: 20px;display: inline-block;">
                 <img  src="${pageContext.request.contextPath}/images/gang.jpg">&nbsp;我收藏的商品
               </p>
                  </td>
                  </tr>
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
                            187.00
                        </div>
                    </td>
                    <td  align="center" style="line-height: 36px;">
                         <a href="javascript:;" class="red" onclick='{if(confirm("确定要删除?")) {deleteCurrentRow(this); }else {}}'>删除</a><br/>
                        <a href="javascript:;" class="red"  onclick='{if(confirm("确定要移至购物车?")) {deleteCurrentRow(this); }else {}}'> 移至购物车</a><br/>
                        <a href="javascript:;" class="red"  onclick='{if(confirm("确定要移至购物车?")) {deleteCurrentRow(this); }else {}}'> 移至购物车</a>
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
                            186.00
                        </div>
                    </td>
                    <td  align="center" style="line-height: 36px;">
                        <a href="javascript:;" class="red" onclick='{if(confirm("确定要删除?")) {deleteCurrentRow(this); }else {}}'>删除</a><br/>
                        <a href="javascript:;" class="red"  onclick='{if(confirm("确定要移至购物车?")) {deleteCurrentRow(this); }else {}}'> 移至购物车</a><br/>
                        <a href="javascript:;" class="red"  onclick='{if(confirm("确定要移至购物车?")) {deleteCurrentRow(this); }else {}}'> 移至购物车</a>
                    </td>
                </tr>
                </tbody>

            </table>


    </div>


</div>

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