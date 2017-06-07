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
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/cx_xq.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.imagezoom.min.js"></script>
</head>
<body>

<!--消费顶部-->
<!-- <div align="center" >
    <script src="index_head.js">

    </script>
</div> -->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div class="xf_tsou">
    <a href="index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
       
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">信息详情</span>
    </div>

</div>

<!-- 创新标题-->
<div class="xf_thd">
    <div class="xf_cxlabel" style="height: 80px;">
        <p class="xq_cx_title"></p>
        <p style="margin:10px"><img src="${pageContext.request.contextPath}/images/chuangxin/cx_d4.jpg" >发布时间：<a class="xq_cx_time"></a>&nbsp;<img src="${pageContext.request.contextPath}/images/chuangxin/cx_d5.jpg" >浏览次数：<a class="xq_cx_num"></a></p>
    </div>
</div>
<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
      <table >
        <tr>
          <td >所属分类：</td>
          <td >男装、女装、内衣、珠宝 >  女装  > <a class="orange" >短袖</a> </td>
        </tr>

        <tr>
          <td valign="top">图片说明：</td>
          <td class="xq_cx_img">
             <%--  <div class=" xf_fangdaz1 " style="width: 115px;height: 145px;">

                  <div class="box f_refada" >

                      <div class=" tb-pic xf_refada0" >
                          <a href="${pageContext.request.contextPath}/images/01.jpg"><img src="${pageContext.request.contextPath}/images/01_mid.jpg" alt="产品" rel="${pageContext.request.contextPath}/images/01.jpg" class="jqzoom xf_refada0"  /></a>
                      </div>
                  </div>
              </div> --%>
          </td>
        </tr>
        <tr>
          <td valign="top">文字描述：</td>
          <td><p style="width:800px" class="xq_cx_des"></p> </td>
        </tr>
        <tr>
          <td valign="top">其他附件：</td>
          <td class="xq_cx_dload">
              <%-- <p><span> 服装图纸1.jpg</span> &nbsp;<span> 152KB</span>&nbsp;<span><a href="javascript:if(confirm('${pageContext.request.contextPath}/images/01.jpg '))window.location='${pageContext.request.contextPath}/images/01.jpg '" tppabs="${pageContext.request.contextPath}/images/01.jpg " class="orange" >下载</a></span></p>
              <p>&nbsp;</p>
              <p>
                  <span> 服装图纸1.jpg</span> &nbsp;<span> 152KB</span>&nbsp;<span><a href="javascript:if(confirm('${pageContext.request.contextPath}/images/01.jpg '))window.location='${pageContext.request.contextPath}/images/01.jpg '" class="orange" >下载</a></span>
              </p> --%>
          </td>
        </tr>
          <tr>
              <td valign="top">你的价格：</td>
              <td>
                 <p class="red xq_cx_prict"></p>
              </td>
          </tr>
          <tr>
              <td valign="top">需求数量：</td>
              <td>
                  <p class="xq_cx_number"> </p>
              </td>
          </tr>
        <tr>
            <td colspan="2"><img style="float: left;margin-top: -8px;" src="${pageContext.request.contextPath}/images/chuangxin/cx_d7.jpg">联系人：<a class="xq_cx_rname"></a>&nbsp;&nbsp;&nbsp;&nbsp;联系方式：<span class="tel_phone"></span><br><br><br>
            <img style="margin-top: -8px;" src="${pageContext.request.contextPath}/images/chuangxin/cx_d8.jpg">联系地址：<span class="dq_address"></span></td>
        </tr>
     <tr>
      <td>&nbsp;</td>
     </tr>
          <tr>
              <td>&nbsp;</td>
          </tr>
      </table>
    </div>

</div>




<!-- 底部-->
<div align="center">
    <script src="index_foot.js">

    </script>
</div>

</body>
<script type="text/javascript">
    $(document).ready(function(){

        $(".jqzoom").imagezoom();

        $("#thumblist li a").click(function(){
            $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
            $(".jqzoom").attr('src',$(this).find("img").attr("mid"));
            $(".jqzoom").attr('rel',$(this).find("img").attr("big"));
        });

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