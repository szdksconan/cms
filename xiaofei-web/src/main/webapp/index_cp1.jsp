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
    <link rel="stylesheet" type="text/css" href="css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="css/xiaofei.css">
    <link href="css/base.css" rel="stylesheet" type="text/css" />
    <script src="js/control.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery.jqzoom.js"></script>
    <script type="text/javascript" src="js/base.js"></script>
	<script type="text/javascript" src="js/xiaofei_ajax/index_cp1.js"></script>
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
                    <span class="btn_left"><img src="images/btn1.png"></span>
                    <span class="btn_right"><img src="images/btn2.png"></span>
                    <div class="wapper">
                        <div class="wscroll" id="wscroll">

                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="images/ttt1.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="images/ttt2.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="images/ttt1.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);">
                                <img width="130" height="130" src="images/ttt2.jpg">
                                <p><span class="red">￥399.00</span><br/>春装一套搭配</p>
                            </a>
                            <a href="javascript:void(0);" style="margin-left: 0px;">
                                <img width="130" height="130" src="images/ttt1.jpg">
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
            <img src="images/fentu1.jpg">
            </span>
                <span class="xf_ms3">
                    <p class="xf_ms5"> 坚果（JmGO）G1-CS 冰箱 国外技术 4D智能&nbsp;1365.00元</p>
                    <div contenteditable="true" class="xf_ms4"> 坚果（JmGO）G1-CS 冰箱 国外技术 4D智能&nbsp;1365.00元</div>

                   <div class="xf_ms6"> <a   class="btn btn-he btn-w100" type="button" >发布</a></div>
                    <div class="share">

                        <div class="bdsharebuttonbox">
                            <span class="xf_ms7">分享到</span>
                            <a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_linkedin" data-cmd="linkedin" title="分享到linkedin"></a><a href="#" class="bds_baidu" data-cmd="baidu" title="分享到百度搜藏"></a><a href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="erwei.jsp" target="_blank" class="bds_weixin" title="分享到微信"></a></div>
                        <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"坚果（JmGO）G1-CS 冰箱 国外技术 4D智能,1365.00元","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
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
<div align="center" >
    <script src="index_head.js">

    </script>
</div>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="index.jsp" target="_self"><img src="images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要找的商品"  />
            <img class="xf_cl" src="images/close.jpg">
        </div>
        <img src="images/xf_sou1.jpg">

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
<div class="xf_cxd" style="height: 170px">
<p>
<img src="images/cx_1.jpg">
</p>
</div>
<!--  zhuyao主要-->
<div class="xf_thd">
<div style="font-size: 15px;margin-top:20px">
    全部 > 包袋 > 单肩包 > GUCCI/古驰 > GUCCI/古驰 黑色男士帆布单肩包 337074 KWT5N 1060
    </div>

</div>
<!-- 放大镜商品-->
<div class="xf_thd" style="margin-top: 20px">


    <div style="width:500px;height:650px;background-color: #ffffff;float:left;display: inline-block; ">
        <div id="preview" class="spec-preview" style="float: right;margin-top: 30px;">
            <!-- <span class="jqzoom" style="margin-bottom: 20px">
            <img width="380" height="530" jqimg="images/01.jpg" src="images/01_mid.jpg" /></span> -->
<span class="jqzoom"><img width="380" id="img" height="530" jqimg="" src="" /></span>
            <p style="padding: 20px  0 0 0;font-size: 14px;">
                商品编码：<span class="productCode"></span> <span><span style="margin-left: 15px;cursor: pointer;"> <i class="fa fa-search"></i> 权威认证</span>&nbsp;
                <a data-toggle="modal" data-target="#myModal" style="cursor: pointer;margin-left: 5px;" ><i class="fa fa-cubes" aria-hidden="true"></i> 分享</a>&nbsp;
                <a data-toggle="modal" data-target="#myModal1" style="cursor: pointer;margin-left: 5px;" > <i class="fa fa-shopping-cart" aria-hidden="true"></i>&nbsp;收藏 </a></span>
            </p>
        </div>
        <!--缩图开始-->
        <div class="spec-scroll" style="margin-left:10px;float: left;">

            <div class="items"  style="position:absolute;top:490px;height: 290px;float: none;overflow: hidden;">
                <ul class="img_tb_thumb">
                     <!-- <li><img  bimg="images/01.jpg" src="images/01_mid.jpg" onmousemove="preview(this);"></li><br/>
                    <li style="margin-top: 0;"><img  bimg="images/02.jpg" src="images/02_mid.jpg" onmousemove="preview(this);"></li>
                    <li ><img  bimg="images/03.jpg" src="images/03_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/04.jpg" src="images/04_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/05.jpg" src="images/05_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/01.jpg" src="images/01_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/02.jpg" src="images/02_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/03.jpg" src="images/03_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/04.jpg" src="images/04_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/05.jpg" src="images/05_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/01.jpg" src="images/01_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/02.jpg" src="images/02_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/03.jpg" src="images/03_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/04.jpg" src="images/04_mid.jpg" onmousemove="preview(this);"></li>
                    <li><img  bimg="images/05.jpg" src="images/05_mid.jpg" onmousemove="preview(this);"></li> --> 

                </ul>
            </div>
        </div>
    </div>
    <div style="width:700px;height: 650px;background-color: #ffffff;float:left;display: inline-block;font-size: 15px;padding: 20px  0 0 30px;">
    <P class="xf_shou"> GUCCI/古驰 黑色男士帆布单肩包 337074 KWT5N 1060&nbsp;
      <a href="f_w/ditu.jsp"  target="_self" ><span style="font-size: 15px;margin-left: 30px"><img style="margin-top: -3px" src="images/b.png" >所在地</span></a>
    </P>
       <p class="h_xuline" style="width: 670px"></p>
        <P style="margin: 20px 0 20px 0;font-size: 22px;font-weight: bold;" id="priceone">¥  5，242.00</P>
       <div class="xf_peiz_color" style="display: inline-block;margin: 20px 0 20px 0;">
        <!--  <span style="float: left;margin-left:0;">颜色：</span>
           
        <div class="xf_gouy3" >
            <p>红色</p>
        </div>
        <div class="xf_gouy3">
            <p>黑色</p>
        </div>  -->

       </div>
        <p  align="left">
           <span style="margin: 20px 20px 0 0;">数量 : </span>
            <img onclick="kc_jian();" src="${pageContext.request.contextPath}/images/jian.jpg"><input type="text " class="cmao_inpsm" value="1"  id="i1"/><img style="margin-right:30px;" onclick="ku_jia();" src="${pageContext.request.contextPath}/images/jia.jpg">


        </p>
        <p   align="left" style="margin: 20px  0 0 0;">
            <a href="gouc_y.jsp" target="_self"> <img  onmousemove="this.src='images/gouwu1.jpg'" onmouseout="this.src='images/gouwu.jpg'"src="images/gouwu.jpg"></a>&nbsp;<a href="gouc_main.jsp" target="_self"><img   onmousemove="this.src='images/liji1.jpg'" onmouseout="this.src='images/liji.jpg'"src="images/liji.jpg"></a>
        </p>
         <p style="margin: 20px 0 0 0 ;">
             消费提示：  购买此物您需要支付￥<span id="pricesum"></span>
        <p class="h_xuline" style="width: 670px">
           <div style="width: 350px;float: left;padding-top: 20px;">
            <p  class="my_name" ></p>
        <p align="left" style="margin: 20px 0 0 0 ;" ><span id="my_shangjia"></span>&nbsp;<a data-toggle="modal" data-target="#myModal1" onclick="cp_dp();"><img src="${pageContext.request.contextPath}/images/jianguo2.jpg" ></a>
        <!-- <p align="left" style="margin: 20px 0 0 0 ;"><a href="dianx.jsp" target="_self"> <img src="images/jianguo1.jpg"></a>&nbsp;<a data-toggle="modal" data-target="#myModal1"><img src="images/jianguo2.jpg" ></a></p> -->
       <!--  <P style="margin: 20px 0 0 0 ;" >联系方式：028-56566565</P>
        <p style="margin: 20px 0 0 0 ;">所  在  地：四川成都高新区-城市里路-135号</p> -->
        
        <p  class="my_lxfs" style="margin: 20px 0 0 0 ;"></p>
      <p class="my_szd" style="margin: 20px 0 0 0 ;"></p>
        
          </div>
             <div style="width: 300px ;height: auto;display: inline-block;float: left;padding-top: 20px;">
                 <img src="images/jianguo.jpg" width="246" height="123">
             </div>

        </p>


    </div>

</div>
<!--   chanpin展现-->
<div class="xf_thd">
<div class="xf_cplab">
   <span>店铺同类型推荐</span>
</div>
</div>


<!-- 图片一列-->
<div class="xf_thd">
     <span>
        <p><img src="images/li_01.jpg"> </p>
         <p>2016款时尚春季节冰箱</p>
        <p><a class="red" >￥399</a></p>
    </span>
     <span>
        <p><img src="images/li02.jpg"> </p>
         <p>2016款时尚春季节冰箱</p>
        <p><a class="red" >￥399</a></p>
    </span>
     <span>
        <p><img src="images/li03.jpg"> </p>
         <p>2016款时尚春季节冰箱</p>
        <p><a class="red" >￥399</a></p>
    </span>
     <span>
        <p><img src="images/li04.jpg"> </p>
         <p>2016款时尚春季节冰箱</p>
        <p><a class="red" >￥399</a></p>
    </span>
     <span>
        <p><img src="images/li05.jpg"> </p>
         <p>2016款时尚春季节冰箱</p>
        <p><a class="red" >￥399</a></p>
    </span>
     <span>
        <p><img src="images/li06.jpg"> </p>
         <p>2016款时尚春季节冰箱</p>
        <p><a class="red" >￥399</a></p>
    </span>
 </div>


<!--   展示大图-->
<div class="xf_thd">
    <div class="xf_czd"><img src="images/li_33.jpg" ></div>
    <!--供应商物资-->
    <div class="cfw_c">
        <div class="xf_li1">

            <ul class="nav nav-tabs" role="tablist" id="tab-list" >
                <li class="active"><a href="#tab-basicinfo" role="tab" data-toggle="tab">商品详情</a></li>
                <li id="wd"><a href="#tab-cominfo" role="tab" data-toggle="tab">规格参数</a></li>
                <li><a href="#tab-intelinfo" role="tab" data-toggle="tab">包装清单</a></li>
                <li><a href="#tab-comi" role="tab" data-toggle="tab">累计评价（235）</a></li>
                <li><a href="#tab-comin" role="tab" data-toggle="tab">售后服务</a></li>

            </ul>
        </div>
        <div class="tab-content">
            <!--基本信息-->
            <div class="tab-pane active" id="tab-basicinfo" align="center">
               <p >

                <table class="table1 mt10" style="font-size: 15px;" id="tablight" onclick="setColor();">

                    <tbody>
                    <tr style="background-color: #ffffff;">
                        <td align="left" >商品名称：<span class="xf_shou"></span></td>
                        <td align="left">
                            商品编码：<span class="productCode">
                        </td>
                        <td align="left" >
                            品牌：<span class="brandName">
                        </td>
                        <td align="left">
                            商品毛重：<span class="gproductGW">
                        </td>
                    </tr>
                    </tbody>
                <tbody>
                <tr style="background-color: #ffffff;">
                    <td align="left" >商品产地：<span class="productPlace"></span></td>
                    <!-- <td align="left">
                        产品特性：智能系统，HDMI...
                    </td>
                    <td align="left" >
                        分辨率：宽屏（1280*800）
                    </td>
                    <td align="left">
                        光源：LED
                    </td> -->
                </tr>
                </tbody>
                <tbody>
                <tr style="background-color: #ffffff;">
                    <td align="left" >商务场景应用：6人以下，6-20人...</td>
                    <td align="left">
                        亮度：1000-1999流明
                    </td>
                    <td align="left" >
                        产品类别：家用型，商住两用
                    </td>
                    <td align="left">&nbsp;
                        
                    </td>
                </tr>
                <tr style="background-color: #ffffff;">
                    <td >&nbsp;</td>
                    <td>&nbsp;
                        
                    </td>
                    <td >&nbsp;
                        
                    </td>
                    <td>
                        <a class="lian" href="#tab-cominfo" role="tab" data-toggle="tab">更多参数>></a>
                    </td>
                </tr>
                </tbody>
                </table>
               </p>


              <p><span id="pro_sale"></span><!-- <img width="837"  src="images/p_2.jpg" > --></p>

            </div>


            <!--企业信息-->
            <div class="tab-pane" id="tab-cominfo">
                <table  class="xfb_1">
                    <!-- -->
                    <tbody class="xfb_1">
                    <tr class="xfb_2">
                        <td colspan="2" align="center"  class="xfb_3">主体</td>

                    </tr>
                    </tbody>

                    <!-- <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">品牌</td>
                        <td align="left" class="xfb_6">
                            坚果
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">型号</td>
                        <td align="left" class="xfb_6">
                            G1-CS
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">颜色</td>
                        <td align="left" class="xfb_6">
                            银色
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">类型</td>
                        <td align="left" class="xfb_6">
                            家用投影机
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">功能</td>
                        <td align="left" class="xfb_6">
                            家庭娱乐
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">发光原理</td>
                        <td align="left" class="xfb_6">
                           DLP
                        </td>

                    </tr>
                    </tbody>

                    <tbody>
                    <tr class="xfb_2">
                        <td colspan="2" align="center"  class="xfb_3">光学规格</td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">标准亮度（ISO流明）</td>
                        <td align="left" class="xfb_6">
                            1500流明（国际标准450 ANSI Iumens）
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">标准分辨率</td>
                        <td align="left" class="xfb_6">
                           WXGA（1280*800）
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">兼容分辨率</td>
                        <td align="left" class="xfb_6">
                           支持1080p.2k.4k
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">兼容分辨率</td>
                        <td align="left" class="xfb_6">
                            支持1080p.2k.4k
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">兼容分辨率</td>
                        <td align="left" class="xfb_6">
                            支持1080p.2k.4k
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_2">
                        <td colspan="2" align="center"  class="xfb_3">主体</td>

                    </tr>
                    </tbody>

                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">品牌</td>
                        <td align="left" class="xfb_6">
                            坚果
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">型号</td>
                        <td align="left" class="xfb_6">
                            G1-CS
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">颜色</td>
                        <td align="left" class="xfb_6">
                            银色
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">类型</td>
                        <td align="left" class="xfb_6">
                            家用投影机
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">功能</td>
                        <td align="left" class="xfb_6">
                            家庭娱乐
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">发光原理</td>
                        <td align="left" class="xfb_6">
                            DLP
                        </td>

                    </tr>
                    </tbody>

                    <tbody>
                    <tr class="xfb_2">
                        <td colspan="2" align="center"  class="xfb_3">光学规格</td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">标准亮度（ISO流明）</td>
                        <td align="left" class="xfb_6">
                            1500流明（国际标准450 ANSI Iumens）
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">标准分辨率</td>
                        <td align="left" class="xfb_6">
                            WXGA（1280*800）
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">兼容分辨率</td>
                        <td align="left" class="xfb_6">
                            支持1080p.2k.4k
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">兼容分辨率</td>
                        <td align="left" class="xfb_6">
                            支持1080p.2k.4k
                        </td>

                    </tr>
                    </tbody>
                    <tbody>
                    <tr class="xfb_4">
                        <td align="right"  class="xfb_5">兼容分辨率</td>
                        <td align="left" class="xfb_6">
                            支持1080p.2k.4k
                        </td>

                    </tr>
                    </tbody> -->
                </table>
            </div>
            <!--资质信息-->
            <div class="tab-pane" id="tab-intelinfo">2
            </div>
            <!--企业介绍-->
            <div class="tab-pane" id="tab-comintro">3
            </div>
            <div class="tab-pane" id="tab-com">
                dsfg
            </div>
            <div class="tab-pane" id="tab-comin">
                fggyjgh
            </div>
        </div>
    </div>
</div>
<!---->
<div class="xf_thd">
    <div class="xf_cplab">
        <span>累计评价</span>
    </div>
</div>
<div class="xf_thd">
    <img src="images/jindu.jpg" >
</div>

<!--评论-->
<div class="xf_thd">
<div class="cfw_x">
    <ul class="nav nav-tabs" role="tablist" id="tab-list">
        <li class="active"><a href="#cfw_c1" role="tab" data-toggle="tab">全部评价（124）</a></li>
        <li><a href="#cfw_can1" role="tab" data-toggle="tab">好评（122）</a></li>
        <li><a href="#cfw_xi1" role="tab" data-toggle="tab">中评（2）</a></li>
        <li><a href="#cfw_se1" role="tab" data-toggle="tab">差评（0）</a></li>

    </ul>

    <div class="tab-content">
        <!--基本信息-->
        <div class="tab-pane active" id="cfw_c1">
            <div class="xf_zhanshi">
                <div>
                <img src="images/da1.jpg">
                    <p> 帮****黑</p>
                </div>
                <div>
                    <p><img src="images/da3.jpg" ><a class="orange" >中评</a></p>
                    <p class="d_w">我公司长期希望和用户给合作,东西看了很多，还不知道怎么收，另外十大消费过对方感受到第三方士大夫vds的防晒霜的写成V型才分GV不穿校服啥都说地方的说法是大幅度的法国队和东方闪电 多个的</p>
                    <p>颜色：图片色 .尺码：均码&nbsp;昨天11:11</p>
                </div>
            </div>

            <!-- 2-->
            <div class="xf_zhanshi">
                <div>
                    <img src="images/da2.jpg">
                    <p> 帮****黑</p>
                </div>
                <div>
                    <p><img src="images/da4.jpg" ><a class="red" >好评</a></p>
                    <p class="d_w">我公司长期希望和用户给合作,东西看了很多，还不知道怎么收，另外十大消费过对方感受到第三方士大夫vds的防晒霜的写成V型才分GV不穿校服啥都说地方的说法是大幅度的法国队和东方闪电 多个的</p>
                    <p>颜色：图片色 .尺码：均码&nbsp;昨天11:11</p>
                </div>
            </div>
            <!--3-->
            <div class="xf_zhanshi">
                <div>
                    <img src="images/da1.jpg">
                    <p> 帮****黑</p>
                </div>
                <div>
                    <p><img src="images/da3.jpg" ><a class="orange" >中评</a></p>
                    <p class="d_w">我公司长期希望和用户给合作,东西看了很多，还不知道怎么收，另外十大消费过对方感受到第三方士大夫vds的防晒霜的写成V型才分GV不穿校服啥都说地方的说法是大幅度的法国队和东方闪电 多个的</p>
                    <p>颜色：图片色 .尺码：均码&nbsp;昨天11:11</p>
                </div>
            </div>
            <!--4-->
            <div class="xf_zhanshi">
                <div>
                    <img src="images/da2.jpg">
                    <p> 帮****黑</p>
                </div>
                <div>
                    <p><img src="images/da4.jpg" ><a class="red" >好评</a></p>
                    <p class="d_w">我公司长期希望和用户给合作,东西看了很多，还不知道怎么收，另外十大消费过对方感受到第三方士大夫vds的防晒霜的写成V型才分GV不穿校服啥都说地方的说法是大幅度的法国队和东方闪电 多个的我公司长期希望和用户给合作,东西看了很多，还不知道怎么收，另外十大消费过对方感受到第三方士大夫vds的防晒霜的写成V型才分GV不穿校服啥都说地方的说法是大幅度的法国队和东方闪电 多个的</p>
                    <p>颜色：图片色 .尺码：均码&nbsp;昨天11:11</p>
                </div>
            </div>


        </div>
        <!--企业信息-->
        <div class="tab-pane" id="cfw_can1">
            1
        </div>
        <!--资质信息-->
        <div class="tab-pane" id="cfw_xi1">2
        </div>
        <!--企业介绍-->
        <div class="tab-pane" id="cfw_se1">3
        </div>
        <div class="tab-pane" id="cfw_we1">4
        </div>


    </div>
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
<!---->
<div class="xf_thd">
    <div class="xf_cplab">
        <span>附近同类产品</span>
    </div>
</div>
<!--图片-->
<div class="xf_tu" style="padding-top: 20px;">
    <span>
        <p><img src="images/b001.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;2016春季大冰箱</p>
        <p>世纪爱美有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>
    <span>
        <p><img src="images/b002.jpg"> </p>  <p><a class="red" >￥399</a>&nbsp;2016春季大冰箱</p>
        <p>世纪爱美有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>
    <span>
        <p><img src="images/b003.jpg"> </p>  <p><a class="red" >￥399</a>&nbsp;2016春季大冰箱</p>
        <p>世纪爱美有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>
    <span>
        <p><img src="images/b004.jpg"> </p>  <p><a class="red" >￥399</a>&nbsp;2016春季大冰箱</p>
        <p>世纪爱美有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>
    <span>
        <p><img src="images/b005.jpg"> </p>  <p><a class="red" >￥399</a>&nbsp;2016春季大冰箱</p>
        <p>世纪爱美有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>

</div>
<div class="xf_chatu"><img src="images/t3.jpg" ></div>
<!-- 底部-->
<div align="center" >
    <script src="index_foot.js">

    </script>
</div>
<form action="ShoppingData/Shopping"  method="post" enctype="multipart/form-data"  id="ShopcheckForm" name="ShopcheckForm" >
	<input name="pid" id="shoppingpid" style="display:none;" ></input>
	<input name="num" id="shoppingnum" style="display:none;" ></input>
	<input name="shopId" id="shoppingshopId" style="display:none;" ></input>
</form>
<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
</script>
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
    /*编辑事件*/
    $(".lian").click(function(){
        $(".cfw_c li").removeClass("active");
        $("#wd").addClass("active");
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


    $('.btn_left').click(function(){
        $('#wscroll').children().first().animate({marginLeft:'-=216px'},'slow',function(){
            $(this).appendTo($('#wscroll')).css('marginLeft','0px');

        });

    });
    $('.btn_right').click(function(){
        $('#wscroll').children().last().prependTo($('#wscroll')).css('marginLeft','-216px');
        $('#wscroll').children().first().animate({marginLeft:'+=216px'},'slow');
    });

</script>

<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script>
$(".xf_gouy3").click(function(){
$(".xf_gouy3").removeClass("active");
$(this).addClass("active");
});
</script>
<style>
    .xf_gouy3{width: 120px;height: 50px;border: 1px solid #dddddd;padding: 13px 0 0 30px;cursor: pointer;float: left;margin: 0 0 0 20px;}
    .xf_gouy3.active{width: 120px;height: 50px;border: 1px solid #dddddd;padding: 13px 0 0 30px;background:url(images/gouwu/vb_1.jpg)  no-repeat;cursor: pointer;float: left;margin: 0 0 0 20px;}
    .spec-scroll .items ul li {
        /* float: left; */
        float: none;
        width: 64px;
        text-align: center;
        margin-top: 20px;
    }
    a:hover{text-decoration: none}
</style>
</body>
</html>