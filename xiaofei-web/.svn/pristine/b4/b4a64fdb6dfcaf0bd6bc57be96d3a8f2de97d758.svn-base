<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<script >
	    var context = "${pageContext.request.contextPath}";
	    var shopId="";
	    var PriceNum=0;
	    var shopNum="";
    </script>
<body>
<!-- 新增模态化窗口-->
<div class="motaisc1 modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span class="xf_ms">新增收货地址</span>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div class="xf_ms1">
                    <table >
                        <tr>
                            <td ><a class="red" >*</a>收货人姓名：</td>
                            <td ><input type="text" class="cmao_input" value=""/> </td>
                        </tr>
                        <tr>
                            <td><a class="red" >*</a>联系电话：</td>
                            <td>
                                <input type="text" class="cmao_input" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top"><a class="red" >*</a>所在地区：</td>
                            <td>
                                <input type="text" id="city" value="请选择地区" class="areainput" />
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">详细地址：</td>
                            <td><textarea placeholder="" cols="5"></textarea> </td>
                        </tr>
                        <tr>
                            <td >邮政编码：</td>
                            <td>
                                <input type="text" class="cmao_input" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td> <input type="checkbox" name="checkbox"  />&nbsp;设为默认</td>
                        </tr>

                    </table>
                    <P class="h_line"></P>
                    <p align="center"><a onclick="kong()"  class="btn btn-he btn-w100" type="button"  >保存</a>&nbsp;<a   class="btn btn-hu btn-w100" type="button" >取消</a></p>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>


<!--  2第二模态框修改-->
<!-- 新增模态化窗口-->
<div class="motaisc1 modal fade" id="myModal1" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span class="xf_ms">更新配送地址</span>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div class="xf_ms1">
                    <table >
                        <tr>
                            <td colspan="2">完成后，点击“保存此地址”按钮处理订单，或者返回您的地址薄。  </td>
                        </tr>
                        <tr>
                            <td ><a class="red" >*</a>姓名：</td>
                            <td ><input type="text" class="cmao_input" value=""/> </td>
                        </tr>

                        <tr>
                            <td valign="top"><a class="red" >*</a>所在地区：</td>
                            <td>
                                <input type="text" id="city" value="请选择地区" class="areainput" />
                            </td>
                        </tr>
                        <tr>
                            <td><a class="red" >*</a>街道地址：</td>
                            <td>
                                <input type="text" class="cmao_input" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td >邮政编码：</td>
                            <td>
                                <input type="text" class="cmao_input" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td >联系电话：</td>
                            <td>
                                ( 可能会印于标签上，便于交货   )<br/>
                                <input type="text" class="cmao_input" value=""/>
                            </td>
                        </tr>


                    </table>
                    <P class="h_line" style="margin-top: 40px"></P>
                    <p align="center"><a onclick="kong()"  class="btn btn-he btn-w100" type="button"  >保存此地址</a>&nbsp;<a   class="btn btn-hu btn-w100" type="button" >返回地址薄</a></p>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<!--消费顶部-->
<!-- <div align="center" >
    <script src="index_head.js">

    </script>
</div> -->
<%@ include file="comm/cms_head.jsp" %>
<div class="xf_thd">
    <img src="${pageContext.request.contextPath}/images/gouc_3.jpg" usemap="#Map">
    <map name="Map">
        <area shape="rect" coords="42,44,224,87" href="index.jsp" target="_self">
    </map>

</div>
<!-- 创新标题-->

<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
        <table >

            <tr>
                <td valign="top" style="font-size: 22px"><i class="fa fa-caret-right"></i>&nbsp;请选择支付方式 </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="xf_gwzi">&nbsp;<input type="radio" name="radio" id="radio" value="radio" />&nbsp;产贸送余额   产贸送自己的支付平台</div>
                </td>
            </tr>
            <tr>
                <td valign="middle">
                    <span class="xf_gouy3"><input type="radio" name="radio" id="radio" value="radio" />&nbsp;平台支付</span>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche1.jpg"></a>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche2.jpg"></a>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche3.jpg"></a>
                    <a href="javascript::" ><img src="${pageContext.request.contextPath}/images/gouwu/gouche4.jpg"></a>
                </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="xf_gwzi">&nbsp; <input type="radio" name="radio" id="radio" value="radio" />&nbsp;银行卡支付 <span>
                        <a  class="btn btn-he btn-w100" type="button" >快捷</a></span>无需跳转网银，银行预留手机短信验证进行支付</div>
                </td>
            </tr>


        </table>
    </div>
</div>

<!-- 结算-->
<c:forEach items="${lista}" var="list">

<div class="xf_thd">
    <div class="xf_cxlabel">
        <span>商品：<a class=" red" >¥${list.totalPrice}</a></span>
        <span>配送和服务：<a class=" red" >¥0</a></span>
        <span style="text-align: right">总计：<a class=" red" >¥${list.totalPrice}</a></span>
        <span><a href="javascript::" onclick="getShoppingpay('${list.orderId}')" target="_self" class="btn btn-he btn-w100" type="button" >提交订单</a></span><!-- ${pageContext.request.contextPath}/g_w/gouc_zf.jsp -->
    </div>
</div>
</c:forEach>

<p>&nbsp;</p>
<!-- 底部-->
<div align="center" style="position: fixed;bottom: 0;left: 0;right: 0;">
    <script src="${pageContext.request.contextPath}/index_foot.js">

    </script>
</div>
<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<style>
    .table1{border: 0}
    .table1 tbody tr td{border-bottom: 1px dashed #dddddd}
</style>
</body>

<script>
	window.getShoppingpay=function(){
		$.ajax({
			url:context+"/ShoppingData/getOrderInfoList",
			data:{"param":12,
				},
			dataType:"json",
			type:"post",
			success:function(data){
				
			}
		});
	}


    function kong() {
        $(".xf_ms1 input").val("");
    }

    $(".xf_gouy1,.xf_gouy1f").click(function(){
        $(".xf_gouy1,.xf_gouy1f").removeClass("xf_gouy1f").addClass("xf_gouy1");
        $(this).removeClass("xf_gouy1").addClass("xf_gouy1f");
    });

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