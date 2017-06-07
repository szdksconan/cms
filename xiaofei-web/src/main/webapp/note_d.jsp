<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/cmaoxiaofei.css">
    <script src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="../css/caidan.css" rel="stylesheet" type="text/css">
<script >
    </script>
</head>
<body >
<!--消费顶部-->
<%@ include file="comm/cms_head.jsp" %>
<!-- <div align="center" >
    <script src="../g_w/index_head.js">

    </script>
    
    
</div> -->

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="../index.jsp" target="_self"><img src="../images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">订单详情</span>
        <!--<div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="../images/close.jpg">
        </div>
        <img src="../images/xf_sou1.jpg">
        <span> <a   class="btn btn-he btn-w100" type="button" >免费发布</a></span>-->
    </div>
   <!-- <div class="xf_smenu">
        <ul>
          <li>
              <a href="javascript:void(0);">服装</a>
          </li>
            <li>
                <a href="javascript:void(0);"> 照明</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="active">办公</a>
            </li>
            <li>
                <a href="javascript:void(0);">化妆品</a>
            </li>
            <li>
                <a href="javascript:void(0);" class="active">机械</a>
            </li>
            <li>
                <a href="javascript:void(0);">皮革</a>
            </li>
        </ul>

    </div>-->

</div>

<!-- 消费顶部菜单
<div class="xf_menu">
    <ul>
     <li><img src="../images/han_f.png" style="margin-top: -1px"> 行业分类</li>
      <li  class="active">
            <a href="../index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="../index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li>
            <a href="../index_kd.jsp" target="_self">我要创业</a>
        </li>
        <li>
            <a href="../index_tj.jsp" target="_self">消费统计</a>
        </li>
        <li>
            <a href="../index_cx.jsp" target="_self">创新定制</a>
        </li>
    </ul>

</div>-->
<c:forEach items="${lista}" var="list">
<div class="xf_thd">
    <div class="xf_cxlabel">
        订单状态：
    </div>
</div>
<div class="xf_thd">
    <p class="h_xuline">
    </p>
</div>
<div class="xf_thd">
    <div class="xf_cxlabel">
       您可以进行的操作  <a class="ml26" href="javascript:;" >立即支付</a>   <a  class="ml26" href="javascript:;" > 取消订单</a>
    </div>
</div>
<div class="xf_thd">
    <div style="width: 100%;border: 1px solid #dddddd;padding: 20px 0 0 60px;display: inline-block;min-height: 480px;height: auto;">
        <p style="font-size: 16px;margin-left: -50px;">
            <img style="float: left;" src="../images/gang.jpg">&nbsp;订单详情
        </p>
         <div style="float: left;display: inline-block;width: 700px;min-height: 300px;line-height: 28px;">
             <P style="font-weight: bold">买家信息</P>
             <P >订单号：${list.orderId}</P>
             <P style="font-weight: bold;margin-top: 20px;">配送地址：</P>
             <P style="font-weight: bold;font-size: 22px;">${list.customerPerson}</P>
             <P >${list.customerArea}</P>
             <P >${list.customerAdress}</P>
             <p>&nbsp;</p>
             <P >邮编：610000</P>
             <P >电话: ${list.customerTel}</P>
         </div>

        <div style="float: left;display: inline-block;width: 400px;line-height: 28px;">
            <P style="font-weight: bold">下单时间：${list.orderTime}</P>
            <P style="font-weight: bold">支付方式：${list.payType}</P>
            <P style="font-weight: bold"><img src="../images/geren/yinh1.png"></P>
        </div>
        <p class="h_xuline" style="display: inline-block;width: 95%; "></p>
        <div style="float: left;display: inline-block;width: 700px;min-height: 150px;line-height: 28px;">
            <P style="font-weight: bold">卖家信息</P>
            <P >贸易商：${list.entName}</P>

            <P >卖家电话 ：${list.entTel}</P>

            <p>卖家地址 ：${list.entArea}${list.entAdress}</p>
        </div>

        <div style="float: left;display: inline-block;width: 400px;line-height: 28px;">
            <!-- <P style="font-weight: bold">卖家姓名 ：吴冬冬</P>
            <P style="font-weight: bold">卖家邮箱 ：15456552232@163.com</P> -->

        </div>
    </div>

</div>
<!--虚线-->

<div class="xf_thd">
    <div style="width: 100%;border: 1px solid #dddddd;padding: 20px 0 0 0;display: inline-block;min-height: 280px;height: auto;margin-top: 20px;">
        <p style="font-size: 16px;margin:0 0 20px 10px;">
            <img style="float: left;" src="../images/gang.jpg">&nbsp;商品列表
        </p>
        <table class="table1 mt10" style="font-size: 15px;border: 0;" >
            <thead>
            <tr>


                <th >商品名称</th>
                <th >&nbsp;</th>
                <th >&nbsp;</th>
                <th >商品单价（元）</th>
                <th >数量</th>
                <th >运费（元）</th>
                <th >合计（元）</th>

            </tr>
            </thead>
             <c:forEach items="${list.cmsOrderItem}" var="lists">
            <tbody>
            <tr>
                <td >  <img width="106" height="106" src="../images/w1.jpg"></td>
                <td>
                    <div>
                        <p> ${lists.productTitle}</p>

                    </div>
                </td>
                <td >
                    <div>
                        <p>${lists.productTitle}</p>
                        <p>尺码：1.75</p>

                    </div>
                </td>
                <td>${lists.unitPrice}</td>

                <td > ${lists.realQuantity}</td>
                <td >￥0</td>
                <td >
                    ${lists.realTotal}
                </td>

            </tr>
            </tbody>
            </c:forEach> 
            <!-- <tbody>
            <tr>
                <td >  <img width="106" height="106" src="../images/w1.jpg"></td>
                <td>
                    <div>
                        <p> 坚果（JmGO）G1-CS 投影仪 微型
                            投影机 3D智能</p>

                    </div>
                </td>
                <td >
                    <div>
                        <p>颜色：玫瑰红</p>
                        <p>尺码：1.75</p>

                    </div>
                </td>
                <td>￥187.00</td>

                <td > 1</td>
                <td >￥187.00</td>
                <td >
                    ￥5222.00
                </td>

            </tr>
            </tbody> -->

        </table>

     </div>
</div>
</c:forEach> 
<p>&nbsp;</p>

<div align="center" >
    <script src="../index_foot.js">

    </script>
</div>
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