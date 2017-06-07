<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cms_x" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${cms_x }/css/cmaoxiaofei.css">
    <script src="${cms_x }/js/jquery.js"></script>
    <script type="text/javascript" src="${cms_x }/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${cms_x }/css/caidan.css" rel="stylesheet" type="text/css">
    <link href="${cms_x }/css/2016caidan.css" rel="stylesheet" type="text/css">
</head>
<body>
<!--消费顶部-->
<div class="xf_top">
    <div class="xf_head">
    <ul>
    <li ><a href="index.jsp" target="_self" class="active">成都</a></li>
    <li ><a href="wuliou.jsp" target="_self">消息</a></li>
    <li><a href="wuliou.jsp" target="_self">购物车</a></li>
    <li><a href="wuliou.jsp" target="_self">收藏夹</a></li>
    <li><a href="wuliou.jsp" target="_self">客服中心</a></li>
    </ul>

        <div class="xf_dz">
            <a  href="regist/register.jsp" target="_self">登录</a><a>&nbsp;/&nbsp;</a> <a  href="regist/login.jsp" target="_self">注册</a>
        </div>
    </div>

</div>

<!--消费顶部搜索-->
<div  class="xf_tsou"><a href="index.jsp" target="_self"><img src="${cms_x }/images/logoin.jpg"></a>
    <div class="xf_tsouy">
        <div class="xf_sou">
            <input type="text" class="xf_input" value="请输入您要代理的商品或行业"  />
            <img class="xf_cl" src="${cms_x }/images/close.jpg">
        </div>
        <img src="${cms_x }/images/xf_sou1.jpg">
        <span> <a  href="regist.jsp" target="_self" class="btn btn-he btn-w100" type="button" >我要开店</a></span>
    </div>
    <!-- 下面菜单-->
    <div class="xf_smenu">
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

    </div>

</div>

<!-- 消费顶部菜单-->
<div class="xf_menu">
    <ul>
     <li>行业分类</li> <li >
            <a href="index.jsp" target="_self">产品购买</a>
        </li>
        <li>
            <a href="index_sj.jsp" target="_self">世界名品</a>
        </li>
        <li class="active">
            <a href="index_kd.jsp" target="_self">我要开店</a>
        </li>
        <li>
            <a href="index_tj.jsp" target="_self">消费统计</a>
        </li>
        <li>
            <a href="index_cx.jsp" target="_self">创新定制</a>
        </li>
    </ul>

</div>

<!--   主要浮动菜单广告图-->
<div class="xf_contain">
    <div class="xf_fucaidan" align="left">
        <script src="${cms_x }/feicaidan1.js">

        </script>
    </div>
    <div class="xf_guanggao">
    <img src="${cms_x }/images/guanggao2.jpg">
    </div>
</div>

<!--   下面浮动-->

<div class="xf_ban">
   <img src="${cms_x }/images/tu2.jpg">
</div>

<!--  商品展示-->
<div class="xf_shang">
    <span class="xf_shang1">最新.代理</span>
    <span class="xf_shang2">本月排行，最新更新</span>
    <span class="xf_shang3">查看更多<img src="${cms_x }/images/yj.jpg" ></span>
 </div>
<div class="xf_sbanner">
    <ul>
      <li  class="active">
         <a href="javascript:void(0);">全部</a>
     </Li>
        <li>
            <a href="javascript:void(0);"> 服装</a>
        </Li>
        <li>
            <a href="javascript:void(0);">服饰</a>
        </Li>
        <li>
            <a href="javascript:void(0);">箱包</a>
        </Li>
        <li>
            <a href="javascript:void(0);">皮鞋</a>
        </Li>
    </ul>
</div>
<!--图片-->
<div class="xf_tu">
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t001.jpg"> </p>
        <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
        </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t002.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t003.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t004.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t005.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>

</div>
<div class="xf_chatu"><img src="${cms_x }/images/t3.jpg" ></div>
<!--  商品展示-->
<div class="xf_shang">
    <span class="xf_shang1">汽车.配件</span>
    <span class="xf_shang2">叱咤公路，明智选择</span>
    <span class="xf_shang3">查看更多<img src="${cms_x }/images/yj.jpg" ></span>
</div>
<div class="xf_sbanner">
    <ul>
        <li  class="active">
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
        </Li>
    </ul>
</div>

<!--图片-->
<div class="xf_tu">
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t006.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t007.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t008.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t009.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>
    <span>
        <a href="regist.jsp" target="_self">
        <p><img src="${cms_x }/images/t0010.jpg"> </p> <p>累积代理数：&nbsp;<a class="red" >1811</a></p>
        <p>推荐指数：<img src="${cms_x }/images/xinxin.jpg" ></p>
        <p><img src="${cms_x }/images/b.jpg">高新区-都会路-1008号</p>
            </a>
    </span>

</div>
<div align="center" >
    <script src="${cms_x }/index_foot.js">

    </script>
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