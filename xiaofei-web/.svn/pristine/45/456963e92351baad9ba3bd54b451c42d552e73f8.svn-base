<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<script >
	    var context = "${pageContext.request.contextPath}";
    </script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/list.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/index_fen2.js"></script>
    <%-- <script src="${pageContext.request.contextPath}/js/shaixuan.js"></script> --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ui.tab.js"></script>
    


</head>
<body>

<!--消费顶部-->
<%@ include file="comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" id="seekKey" class="xf_input" placeholder="请输入您要找的商品"  />
            <img class="xf_cl" src="images/close.jpg">
        </div>
        <a onclick="get()"><img src="images/xf_sou1.jpg"></a>

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
<!--  zhong见未定内容-->
<div class="xf_thd">
    <p class="sou_jiegou"></p><!-- 全部结果 “办公” -->
    <p class="h_line"></p>
    <div class="shou">
    <table class="table1 mt10" style="font-size: 14px;border: 0" >

        <tbody>
        <tr id="shoptrdata" style="background-color: #ffffff;">
           <!--  <td align="left" width="150">文具及类似用品</td>
            <td align="left">

                文具盒（铅笔盒）
            </td>
            <td align="left" >
                装订文件用钉、针
            </td>
            <td align="left">
                固体胶
            </td>
            <td align="left">
                纸制文件袋（夹）
            </td>
            <td align="left">
                日记簿
            </td>
            <td align="left">

                儿童智益册
            </td>
            <td align="right">
                <a href="javascript:;" class="hn_1">
                    <img src="images/zan.jpg">
                </a>
            </td> -->
        </tr>
        </tbody>
        <!-- <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" width="150" >&nbsp;</td>
            <td align="left">
                文具袋（笔袋）
            </td>
            <td align="left" >
                塑料票夹
            </td>
            <td align="left">
                印泥
            </td>
            <td align="left">
                信封
            </td>
            <td align="left">
                效率手册
            </td>
            <td align="left">
                图书
            </td>
            <td align="right">
                <a href="javascript:;" >
                    <img onclick="shou()" src="images/duo.jpg">
                </a>
            </td>
        </tr>
        </tbody> -->

    </table>
    </div> 
<!--    隐藏复选框-->
    <!-- <div class="w1200" style="display:none">
        <div class="list-screen">


            <div class="screen-term">
                <div class="selectNumberScreen">
                    <div id="selectList" class="screenBox screenBackground">

                        <dl class="listIndex" attr="terminal_brand_s">
                            <span style="display: inline-block;width:140x;height: 36px;float: left;font-size: 15px;margin-right: 20px;">文具及类似用品</span>
                            <dt></dt>
                            <dd data-more=true>

                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">装订文件用钉、针</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">固体胶</a> </label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="lenovo">固体胶</a> </label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">装订文件用钉、针</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">固体胶</a> </label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="lenovo">固体胶</a> </label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">装订文件用钉、针</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">固体胶</a> </label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="lenovo">固体胶</a> </label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <label>
                                    <input name="checkbox2" type="checkbox" value="" autocomplete="off"/>
                                    <a href="javascript:;" values2="" values1="" attrval="">塑料票夹</a></label>
                                <span class="more"><em class="open"></em>更多...</span>
                            </dd>
                            <P>
                            <a href="javascript:;" >
                                <img onclick="shou1()" src="images/souqi.jpg">
                            </a>
                            </P>
                            <p style="margin-top: 30px;">
                            <a href="javascript:;">
                                <img src="images/duo.jpg">
                            </a>
                            </p>
                        </dl>
                        <dl class="listIndex more-none" attr="terminal_brand_s" style="display:none;border:none;margin-left: -5px;padding:10px 0; ">
                            <dt style='visibility:hidden'></dt>
                            <dd>
                                <form action="" method="get">
                                    <label><input name="checkbox2" type="checkbox" value=""/><a href="javascript:;"
                                                                                                values2="" values1=""
                                                                                                attrval="">螺旋本</a></label>
                                    <label><input name="checkbox2" type="checkbox" value=""/><a href="javascript:;"
                                                                                                values2="" values1=""
                                                                                                attrval="">图书、期刊架</a>
                                    </label>
                                    <label><input name="checkbox2" type="checkbox" value=""/><a href="javascript:;"
                                                                                                values2="" values1=""
                                                                                                attrval="">复写纸</a>
                                    </label>
                                </form>

                        </dl>
                    </div>
                </div>
            </div>

        </div>

        <div class="hasBeenSelected clearfix">

            <div style="float:right;" class="eliminateCriteria">【清空全部】</div>
            <dl style="margin-top: 15px;margin-left: -90px\9;">
                <dt >已选择：</dt>
                <dd style="DISPLAY: none;margin-left: -55px;padding-left: 15px;" class=clearDd >
                    <div class=clearList></div>
            </dl>
            <p align="center">
                <span> <a  class="btn btn-he btn-w60" type="button" style="height: 32px;padding-top: 5px;" >确认</a></span>&nbsp;
                <span> <a   class="btn btn-hu btn-w60" type="button" style="height: 32px;padding-top: 5px;" >取消</a></span>
            </p>
        </div>
        <script type="text/javascript" src="js/shaixuan.js"></script>
    </div>
        隐藏的展开部分
    <div class="cmao_daoleft" style="display:none">
    <table class="table1 mt10 " style="font-size: 14px;border: 0;" >

        <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" style="color: #ffffff;" width="150">文具及类似用品</td>
            <td align="left">

                文具盒（铅笔盒）
            </td>
            <td align="left" >
                装订文件用钉、针
            </td>
            <td align="left">
                固体胶
            </td>
            <td align="left">
                纸制文件袋（夹）
            </td>
            <td align="left">
                日记簿
            </td>
            <td align="left">

                儿童智益册
            </td>
            <td align="left" width="120">
               &nbsp;
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" width="150">&nbsp;</td>
            <td align="left">
                文具袋（笔袋）
            </td>
            <td align="left" >
                塑料票夹
            </td>
            <td align="left">
                印泥
            </td>
            <td align="left">
                信封
            </td>
            <td align="left">
                效率手册
            </td>
            <td align="left">
                图书
            </td>
            <td align="left">
                书包
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" width="150">&nbsp;</td>
            <td align="left">
                文具袋（笔袋）
            </td>
            <td align="left" >
                塑料票夹
            </td>
            <td align="left">
                印泥
            </td>
            <td align="left">
                信封
            </td>
            <td align="left">
                效率手册
            </td>
            <td align="left">
                图书
            </td>
            <td align="left">
                书包
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" >&nbsp;</td>
            <td align="left">
                文具袋（笔袋）
            </td>
            <td align="left" >
                塑料票夹
            </td>
            <td align="left">
                印泥
            </td>
            <td align="left">
                信封
            </td>
            <td align="left">
                效率手册
            </td>
            <td align="left">
                图书
            </td>
            <td align="left">
                书包
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" >&nbsp;</td>
            <td align="left">
                文具袋（笔袋）
            </td>
            <td align="left" >
                塑料票夹
            </td>
            <td align="left">
                印泥
            </td>
            <td align="left">
                信封
            </td>
            <td align="left">
                效率手册
            </td>
            <td align="left">
                图书
            </td>
            <td align="left">
                书包
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr style="background-color: #ffffff;">
            <td align="left" >&nbsp;</td>
            <td align="left">
                文具袋（笔袋）
            </td>
            <td align="left" >
                塑料票夹
            </td>
            <td align="left">
                印泥
            </td>
            <td align="left">
                信封
            </td>
            <td align="left">
                效率手册
            </td>
            <td align="left">
                图书
            </td>
            <td align="left">
                书包
            </td>
        </tr>
        </tbody>

    </table>
        </div> -->
</div>
<!-- <div class="xf_thd" style="height: 60px;padding: 10px 0 0 20px;">
   综合排序:<input type="text" id="city" value="请选择省市" class="areainput">
    &nbsp;
    兼容浏览器的下拉选框
    <div class="dropdown-list">
        <div class="drop-list drop-list-min" >
            <div class="checked" ><a href="javascript:void(0);">全部</a><span></span></div>
        </div>
        <ul class="select select-min none" >
            <li><a href="javascript:void(0);">货运</a></li>
            <li><a href="javascript:void(0);">储运</a></li>
            <li><a href="javascript:void(0);">订单</a></li>
        </ul>
    </div>
    &nbsp;
    <input type="text" class="cmao_input" value="在结果中搜索" style="margin-left:50px "/>
     <a   class="btn btn-hui btn-w80" type="button" >确定</a>

</div> -->

<!--图片-->
<div id="goodsData" class="xf_tu"><!-- 
    <span>
        <a href="index_cp.jsp" target="_self">
            <p><img src="images/t01.jpg"> </p>
            <p><a class="red" >￥399</a>&nbsp;格力全自动洗衣机</p>
            <p>格力电器有限公司</p>
            <p><img src="images/b.png">高新区-都会路-1008号</p>
        </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t02.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;格力空气清新器</p>
              <p>格力电器有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t03.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;海尔刮胡刀</p>
              <p>海尔集团有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
        <p><img src="images/t04.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;国美小空调</p>
        <p>国美电器有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t05.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;夏美的饮水机</p>
              <p>美的股分有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
 -->
</div>
<!--图片-->
<div class="xf_tu">
 <!--    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t06.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;纯金属汽车轮毂</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t07.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;高档汽车润滑油</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t08.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;后备箱必备工具箱</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t09.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;驾驶台必备手机架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t010.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;座椅后面的杯架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
 -->
</div>
<!--图片-->
<div class="xf_tu">
  <!--   <span>
        <a href="index_cp.jsp" target="_self">
            <p><img src="images/t01.jpg"> </p>
            <p><a class="red" >￥399</a>&nbsp;格力全自动洗衣机</p>
            <p>格力电器有限公司</p>
            <p><img src="images/b.png">高新区-都会路-1008号</p>
        </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t02.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;格力空气清新器</p>
              <p>格力电器有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t03.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;海尔刮胡刀</p>
              <p>海尔集团有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
        <p><img src="images/t04.jpg"> </p>
        <p><a class="red" >￥399</a>&nbsp;国美小空调</p>
        <p>国美电器有限公司</p>
        <p><img src="images/b.png">高新区-都会路-1008号</p>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t05.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;夏美的饮水机</p>
              <p>美的股分有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
 -->
</div>
<!--图片-->
<div class="xf_tu">
   <!--  <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t06.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;纯金属汽车轮毂</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t07.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;高档汽车润滑油</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t08.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;后备箱必备工具箱</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t09.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;驾驶台必备手机架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
    <span>
          <a href="index_cp.jsp" target="_self">
              <p><img src="images/t010.jpg"> </p>
              <p><a class="red" >￥399</a>&nbsp;座椅后面的杯架</p>
              <p>丰田汽车有限公司</p>
              <p><img src="images/b.png">高新区-都会路-1008号</p>
          </a>
    </span>
 -->
</div>

<!-- fenye分页-->
<!-- <div class="xf_chatu" align="center">
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
</div> -->
<!---->



<!-- 底部-->
<div align="center" >
    <script src="index_foot.js">

    </script>
</div>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
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

<script>
    $(function () {

        var flag = true;
        $(".hn_1").click(function () {
            if (!flag) {
                flag = true;
                $(this).children("img").attr('src', 'images/zan.jpg');

                $(".cmao_daoleft").hide();

                $(".w1200").hide();


            } else {
                flag = false;
                $(this).children("img").attr('src', 'images/souqi.jpg');

                $(".cmao_daoleft").show();

                $(".w1200").hide();

            }

        });

    });

    $(function () {

        var flag = true;
        $(".hn_2").click(function () {
            if (!flag) {
                flag = true;
                $(this).children("img").attr('src', 'images/zan.jpg');

                $(".cmao_daol").hide();
                $(".shou").show();

                $(".w1200").hide();


            } else {
                flag = false;
                $(this).children("img").attr('src', 'images/souqi.jpg');

                $(".cmao_daol").show();
                $(".shou").show();
                $(".w1200").hide();

            }

        });

    });



    function shou() {
        $(".shou").hide();
        $(".w1200").show();
        $(".cmao_daoleft").hide();
        $(".hn_1").children("img").attr('src', 'images/zan.jpg');
    }


    function shou1() {
        $(".shou").show();
        $(".w1200").hide();


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
<script type="text/javascript">
    $(document).ready(function (e) {
        $("#selectList").find(".more").toggle(function () {
            $(this).addClass("more_bg");
            $(".more-none").show()
        }, function () {
            $(this).removeClass("more_bg");
            $(".more-none").hide()
        });
    });
</script>

<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
</body>
</html>