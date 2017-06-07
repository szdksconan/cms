<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/js/seek.js"></script>

</head>
<body >
<!--消费顶部-->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}//images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" id="seekKey" class="xf_input" placeholder="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <a onclick="get()"><img src="${pageContext.request.contextPath}/images/xf_sou.jpg"></a>
    </div>
    <!-- 下面菜单-->
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

    </div> -->

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
      <li  class="active">
            <a href="index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li>
            <a href="index_kd.jsp" target="_self">我要创业</a>
        </li>
        <li>
            <a href="index_cx.jsp" target="_self">创新定制</a>
        </li>
        <li>
            <a href="index_wli.jsp" target="_self">我要发货</a>
        </li>
        <li>
            <a href="index_tj.jsp" target="_self">消费统计</a>
        </li>
    </ul>

</div>

<!-- 提示-->
<div id="goodsData">
	<!-- <div class="xf_tu">
	</div>
	
	
	<div class="xf_thd" align="center" >
	    <div id="goodsData">
	     <P style="margin-top: 200px">&nbsp;</P>
	        <img src="../images/zifenye/s_w1.jpg">
	        <P>&nbsp;</P>
	        <p>抱歉哦！没有找到“sjkajkdjkasj...”相关商品
	
	            试试其它关键词</p>
	    </div>
	</div> -->
</div>


</body>
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