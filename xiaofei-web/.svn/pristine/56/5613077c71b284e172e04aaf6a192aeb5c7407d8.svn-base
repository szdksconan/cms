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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <link href="${pageContext.request.contextPath}/css/genre.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/dian_xinxi.js"></script>
    <!-- ditu地图-->

    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=N5eGdOHnO80ZMcthzYXtRWEc"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css"/>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>
<body>
<!-- 收藏弹出通用模态化窗口-->
<div class="motaisc modal fade" id="myModal1" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span class="xf_ms">成功加入收藏夹</span>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div class="courselist8">
                    <br /><br /><br /><br />
                    <span class="btn_left"><img src="${pageContext.request.contextPath}/images/btn1.png"></span>
                    <span class="btn_right"><img src="${pageContext.request.contextPath}/images/btn2.png"></span>
                    <div class="wapper">
                        <div class="wscroll" id="wscroll">

                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="${pageContext.request.contextPath}/images/ttt1.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="${pageContext.request.contextPath}/images/ttt2.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="${pageContext.request.contextPath}/images/ttt1.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="${pageContext.request.contextPath}/images/ttt2.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);" style="margin-left: 0px;">
                                <img width="130" height="130" src="${pageContext.request.contextPath}/images/ttt1.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 分享弹出通用模态化窗口-->
<div class="motaisc modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span class="xf_ms">分享宝贝</span>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div class="xf_ms1">
            <span class="xf_ms2">
            <img src="${pageContext.request.contextPath}/images/fentu1.jpg">
            </span>
                <span class="xf_ms3">
                    <p class="xf_ms5"> 韩版针织汗衫+初秋套装&nbsp;365.00元</p>
                    <div contenteditable="true" class="xf_ms4"> 韩版针织汗衫+初秋套装&nbsp;365.00元</div>

                   <div class="xf_ms6"> <a   class="btn btn-he btn-w100" type="button" >发布</a></div>
                    <div class="share">

                        <div class="bdsharebuttonbox">
                            <span class="xf_ms7">分享到</span>
                            <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_linkedin" data-cmd="linkedin" title="分享到linkedin"></a><a href="#" class="bds_baidu" data-cmd="baidu" title="分享到百度搜藏"></a><a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="${pageContext.request.contextPath}/erwei.jsp" target="_blank" class="bds_weixin" title="分享到微信"></a></div>
                        <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"韩版针织汗衫+初秋套装 365.00元","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
                        </script>
                    </div>
                </span>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div  class="xf_tsou" >
    <a href="${pageContext.request.contextPath}/index.jsp" target="_self" ><img  style="margin-left:10px;" src="${pageContext.request.contextPath}/images/dianxilog.jpg" /></a>
    <div class="xf_tsouy" style="margin-left:0px;width:auto">
        <a data-toggle="modal" data-target="#myModal1" class="xf_soc3" > 收藏</a>
        <a data-toggle="modal" data-target="#myModal" class="xf_soc4" > 分享</a>
        <div class="xf_sou1">

            <input type="text" class="xf_input" value="请输入您要的商品"  />
            <img class="xf_cl" src="${pageContext.request.contextPath}/images/close.jpg">
        </div>
        <img src="${pageContext.request.contextPath}/images/xf_sou1.jpg">
        <span> <a   class="btn btn-he btn-w100" type="button" >搜全站</a></span>
    </div>
    <!-- 下面菜单-->

</div>

<!-- 商铺名称-->
<div class="xf_thd"><img src="${pageContext.request.contextPath}/images/dianxi.jpg"> </div>
<!--  zhuyao主要-->
<div class="xf_thd">
    <div id="bar" class="xf_cpmenu">
        <!-- <ul>
            <li >
                <a href="dianx.jsp" target="_self">店铺首页</a>
            </li>
            <li>
                <a href="zmu.jsp" target="_self" >商品</a>
            </li>
            <li>
                <a href="javascript:void(0);" target="_self" >招募信息</a>
            </li>
            <li >
                <a href="dian_xinxi.jsp" target="_self" class="active"> 店铺信息</a>
            </li>
        </ul> -->
    </div>

</div>
<!-- 展示图-->
<div class="xf_thd"><img src="${pageContext.request.contextPath}/images/shangpin/shang_1.jpg"> </div>
<!--   主要浮动菜单广告图-->

<div class="xf_thd" >
    <P  class="xf_dianj">服务能力</P>
    <P id="servNL" style="display: inline-block">
   <!--    <span class="xf_dianv">
         商品配送<br/>
提供商品送货上门服务 覆盖范围成都市主城区及
龙泉、双流<br/>
说明：距离店铺2公里范围内，配送时间 09：00
-21：00。
      </span>
        <span class=" xf_dianv ">
         上门安装 <br/>
提供商品上门安装服务  覆盖范围成都市主城区<br/>
说明：有专业安装人员。
      </span>
        <span class=" xf_dianv ">
         商品维修 <br/>
承接商品维修服务  覆盖范围成都市主城区<br/>
说明：有专业家电维修，可上门维修服务。
      </span> -->

    </P>
</div>

<!---->

<div id="shopJJ" class="xf_thd" style="background:url(${pageContext.request.contextPath}/images/shangpin/shang_2.jpg)  no-repeat;height: 300px;margin-top: 20px;">

    <!-- <div class="xf_cplab">
        <span>店铺简介</span>
    </div>
    <div  class="xf_diann">
        浙江银座箱包有限公司是长三角最大的拉杆箱生产厂家，公司占地80000多平方米，员工1400多名 ，拥有国际最先进的的多条硬箱专业生产流水线公司拥有2
        0000平方米仓库，2013年销售额4.8亿元。20年来，我们长期专注于硬箱的生产与研发，每年向全世界160多个国家，出口260万只高品质旅行箱。每年为几十
        个国际知名品牌，代加工高品质商旅旅行箱、限量版旅行箱。“新秀丽、RICARDO、ACE、MyTrvel、瑞士军刀、皇冠、CK、CHANEL、TOYOTA”等众多品
        牌，都是银座的长期合作伙伴。 对如今，银座旅行箱已来到你身边，无论你是时尚潮人、励志学生、商务精英都会在银座找到适合您的高品质旅行箱。 银座
        专注硬箱20年。 <br/>  银座全国服务专线：400-189-919
    </div> -->
</div>
<!--图片-->
<div class="xf_thd" >
    <div  class="xf_cplab">
        <span>资质信息</span>
        <span style="margin-left:495px;">经营场址</span>
    </div>
</div>
<div class="xf_thd" >
    <div id="zizhixinxi" class="xf_diandiv">
        <!-- <div id="demo01" class="flexslider" style="width: 199px;height:300px;">
            <ul class="slides">
                <li><div ><img width="199"  height="241" src="${pageContext.request.contextPath}/shangpin/shang_3.jpg"  /></div></li>
                <li><div ><img width="199"  height="241" src="${pageContext.request.contextPath}/shangpin/shang_3.jpg"  /></div></li>
                <li><div><img width="199"  height="241" src="${pageContext.request.contextPath}/shangpin/shang_3.jpg" /></div></li>
                <li><div ><img width="199"  height="241" src="${pageContext.request.contextPath}/ad_stock.jpg"  /></div></li>
                <li><div><img width="199"  height="241" src="${pageContext.request.contextPath}/ad_auto.jpg"  /></div></li>
            </ul>
        </div>
      <table width="350" border="0">
        <tr>
          <td width="85" align="right">证书名称:</td>
          <td width="255">营业执照</td>
        </tr>
        <tr>
          <td align="right"> 有效期 : </td>
          <td> 2017.3.6</td>
        </tr>
        <tr>
          <td align="right" valign="top">经营范围 :</td>
          <td>行李箱;旅行包;纺织、皮革制品代理加<br>
          盟;皮革加工</td>
        </tr>
        <tr>
          <td align="right" valign="top">主营商品 :</td>
          <td>拉杆箱;箱包;旅行箱;行李箱;硬箱;ABS+<br>
            PC;ABS;PC;登机箱;万向轮;旅行箱包;功<br>
          能箱包;行李包;箱子;铝框箱</td>
        </tr>
      </table> -->
    </div>
    <div class="xf_diandiv">
        <div id="allmap" style="float: left">
        </div>
        <span id="address" ><!-- 经营场址：<br/>成都市高新区高新国际广场B座708号 -->
     </span>
    </div>
</div>






<!-- 分隔站位保留-->
<div class="xf_thd" >
    <div class="xf_cplab" style="border: 0">

    </div>
</div>
<!---->
<!-- 底部-->
<div align="center" >
    <script src="${pageContext.request.contextPath}/index_foot.js">

    </script>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/slider.js"></script>
<!-- <script type="text/javascript">
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
</script> -->
<style type="text/css">
    #allmap {height:315px;width:350px;overflow: hidden;}

</style>
<style>

    .flex-control-nav {
        width:200px;
        position: absolute;
        top: 1200px;
        text-align: center;
    }


</style>
<script src="${pageContext.request.contextPath}/js/ditu.js"></script>
</body>

<!-- <script>
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

</script> -->
</html>