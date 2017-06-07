<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%-- <%=String path=request.getContextPath() %>  --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>产贸送消费应用平台</title>
	<script >
	     var context = "${pageContext.request.contextPath}";
    </script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <!-- <script type="text/javascript" src="js/2016caidan.js"></script> -->
    <link href="${pageContext.request.contextPath}/css/2016caidan.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/css/fand.css" rel="stylesheet" type="text/css">
    
    
    <script src="${pageContext.request.contextPath}/js/seek.js"></script>
       <%-- <script src="${pageContext.request.contextPath}/js/logionComm.js"></script> --%>  
    
    
</head>
<body >
<!--消费顶部-->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" id="seekKey" class="xf_input" placeholder="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="images/close.jpg">
        </div>
        <a onclick="get()" target="_self"><img src="images/xf_sou.jpg"></a><!-- href="f_w/s_no.jsp" -->
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

<!--   主要浮动菜单广告图-->
<div class="xf_contain">
    <div class="xf_fucaidan" align="left">
		<!-- <div class="yHeader">
			<div class="yNavIndex">
				<div class="pullDown">
					<ul class="pullDownList" id="hang_ye">
						
					</ul>
				</div>
			</div>
		</dir> -->
				         <script src="feicaidan1.js">
				        </script> 

    </div>
    <div class="xf_guanggao">
        <div id="demo01" class="flexslider">
            <ul class="slides">
                <li><div ><img src="${pageContext.request.contextPath}/images/ad_home.jpg"  /></div></li>
                <li><div ><img src="${pageContext.request.contextPath}/images/ad_yuetu.jpg"  /></div></li>
                <li><div><img src="${pageContext.request.contextPath}/images/ad_nba.jpg" /></div></li>
                <li><div ><img src="${pageContext.request.contextPath}/images/ad_stock.jpg"  /></div></li>
                <li><div><img src="${pageContext.request.contextPath}/images/ad_auto.jpg"  /></div></li>
            </ul>
        </div>
        <div><img src="${pageContext.request.contextPath}/images/guanggaof1.jpg"> </div>
    </div>

</div>

<!--   下面浮动-->

<div class="xf_ban">
   <img src="images/tu2.jpg">
</div>

<!--  商品展示-->
<div class="xf_shang">
    <span class="xf_shang1">家电.电器</span>
    <span class="xf_shang2">尖货来袭，要你好看</span>
    <span class="xf_shang3">查看更多<img src="images/yj.jpg" ></span>
 </div>
<div class="xf_sbanner">
    <ul class="classlayer0"> 
        <li class="active" >
         <a  href="javascript:void(0);">全部</a>
     </li>
        <li>
            <a href="javascript:void(0);"> 电视</a>
        </Li>
        <li>
            <a href="javascript:void(0);">空调</a>
        </Li>
        <li>
            <a href="javascript:void(0);">地暖</a>
        </Li>
        <li>
            <a href="javascript:void(0);">电脑</a>
        </Li>   
    </ul>
</div>
<!--图片-->
<div id="goodsList0" class="xf_tu">
     <!-- <span>
        <a href="index_cp.jsp?pId=731034401760215041&sId=731034350342242301" target="_self">
        <p><img src="http://s3.cn-north-1.amazonaws.com.cn/consumer-store/uploads/images/QQ图片20160322163147.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;格力全自动洗衣机</p>
        <p>格力电器有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
        </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t02.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;格力空气清新器</p>
        <p>格力电器有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t03.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;海尔刮胡刀</p>
        <p>海尔集团有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>
    <span>
        <p><img src="images/t04.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;国美小空调</p>
        <p>国美电器有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t05.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;夏美的饮水机</p>
        <p>美的股分有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>  -->

</div>
<div class="xf_chatu"><img src="images/t3.jpg" ></div>
<!--  商品展示-->
<div class="xf_shang">
    <span class="xf_shang1">手机.数码</span>
    <span class="xf_shang2">叱咤公路，明智选择</span>
    <span class="xf_shang3">查看更多<img src="images/yj.jpg" ></span>
</div>
<div class="xf_sbanner1">
    <ul class="classlayer1">
       <!--  <li  class="active">
            <a href="javascript:void(0);">全部</a>
        </Li>
        <li>
            <a href="javascript:void(0);"> 轮毂</a>
        </Li>
        <li>
            <a href="javascript:void(0);">机油</a>
        </Li>
        <li>
            <a href="javascript:void(0);">配件</a>
        </Li>
        <li>
            <a href="javascript:void(0);">机具</a>
        </Li> -->
    </ul>
</div>

<!--图片-->
<div id="goodsList1" class="xf_tu">
 <!--    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t06.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;纯金属汽车轮毂</p>
        <p>丰田汽车有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t07.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;高档汽车润滑油</p>
        <p>丰田汽车有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t08.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;后备箱必备工具箱</p>
        <p>丰田汽车有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t09.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;驾驶台必备手机架</p>
        <p>丰田汽车有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
        <p><img src="images/t010.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;座椅后面的杯架</p>
        <p>丰田汽车有限公司</p>
        <p><img src="images/b.jpg">高新区-都会路-1008号</p>
              </a>
    </span> -->

</div>
<div align="center" >
    <script src="index_foot.js">

    </script>
</div>

<div class="el_2" style="position: fixed;right:100px;bottom:150px;">

    <img src="${pageContext.request.contextPath}/App/appcode.png"><br/>
   扫描下载消费者App
</div>
<div class="el_1" style="position: fixed;right:20px;bottom:150px;">

    <img src="images/el_1.png">
</div>
<div class="fixed-bar">
    <div class="wide-bar">
        <a href="javascript:scrollTo(0,0)" class="gotop" title="回到顶部" style="display:none;"><img src="images/fand.png" ></a>
    </div>
</div>
<script type="text/javascript">
    $(document).scroll(function(){
        var  scrollTop =  $(document).scrollTop(),bodyHeight = $(window).height();
        if(scrollTop > bodyHeight){
            $('.fixed-bar .gotop').css('display','block');
        }else{
            $('.fixed-bar .gotop').css('display','none');
        }
    })
</script>

</body>
<script type="text/javascript" src="js/slider.js"></script>
<script type="text/javascript">

    $(function(){

        $('#demo01').flexslider({
            animation: "slide",
            direction:"horizontal",
            easing:"swing"
        });

        $('#demo02').flexslider({
            animation: "slide",
            direction:"vertical",
            easing:"swing"
        });

    });
</script>

<script>



$(".el_2").hide();
$(".el_1").hover(function(){
    $(".el_2").show();
},function(){
    $(".el_2").hide();
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