<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/addwuliu.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
</head>

<body>

<!--消费顶部-->
<!-- <div align="center">
    <script src="../g_w/index_head.js"></script>
</div> -->
<%@ include file="../comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">物流需求发布</span>
    </div>

</div>


<form action="${pageContext.request.contextPath}/logistical/insertorUpdateLogistical" method="post" id="wuliuForm">
	<input name="id" id="wuliuid" style="display:none;" ></input>
	<input name="userId" id="uid" style="display:none;" ></input>
	<input name="sendLocalName" id="sdln" style="display:none;" ></input>
	<input name="descLocalName" id="dcln" style="display:none;" ></input>
	<input name="sendDate" id="sdate" style="display:none;" ></input>
	<input name="sendUserName" id="suname" style="display:none;" ></input>
	<input name="sendUserTel" id="sutel" style="display:none;" ></input>
	<input name="descUserName" id="shr2" style="display:none;" ></input>
	<input name="descUserTel" id="shrphone2" style="display:none;" ></input>
	<input name="needReceipt" id="sfjh" style="display:none;" ></input>
	<input name="placeReceipt" id="jhd" style="display:none;" ></input>
	<input name="needDelivery" id="sfsh" style="display:none;" ></input>
	<input name="placeDelivery" id="shd" style="display:none;" ></input>
	<input name="needCashDelivery" id="sfds" style="display:none;" ></input>
	<input name="cardHolder" id="ckr2" style="display:none;" ></input>
	<input name="bankName" id="yh2" style="display:none;" ></input>
	<input name="cardId" id="kh2" style="display:none;" ></input>
	<input name="otherInfo" id="qita2" style="display:none;" ></input>
	<input name="goodsName" id="gname" style="display:none;"></input>
	<input name="goodsNum" id="gnum" style="display:none;" ></input>
	<input name="weight" id="gwith" style="display:none;"></input>
	<input name="volume" id="gvlo" style="display:none;"></input>
	<input name="price" id="gpric" style="display:none;"></input>
	<input name="needAcknowledgement" id="hd" style="display:none;"></input>
	<input name="needUrgent" id="js" style="display:none;"></input>
	<input name="needInsured" id="bj" style="display:none;"></input>
	<input name="needPlusDuty" id="kjfp" style="display:none;"></input>
	<input name="needControlCargo" id="yqkh" style="display:none;"></input>
</form>

<!-- 创新标题-->
<div class="xf_thd">
    <div class="xf_cxlabel" style="height: 80px;padding: 20px 0 0 20px;f">
        <div style="18px;width: 100px;float: left;">货物运输订单</div><div style="font-size: 14px;width:800px;float: left;">（ 注意，此单用于和物流商单位的初步报价沟通，不一定为最后收费标准）</div>
    </div>
</div>
<!-- xuxian-->
<div class="xf_thd">
<p class="h_xuline"></p>
    </div>

<!-- -->
<div class="xf_thd">
    <table class="table1" style="border: 0;font-size: 15px;">
        <tbody>
        <tr>
            <td width="130" align="right">货/订单号：</td>
            <td><input type="text" class="cmao_inplg" id="wid" readonly="readonly" value="XFWL20160520116"/></td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="130" align="right">*始发地：</td>
            <td> <input type="text" id="city" value="请选择地区" class="areainput"  onblur="address()"/>
            <span class="hide red city_lable">请选择始发地</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="130" align="right">*到达地：</td>
            <td><input type="text" id="city2" value="请选择地区" class="areainput"  onblur="address2()"/>
            <span class="hide red city2_lable">请选择到达地</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="130" align="right">*运输时间：</td>
            <td><input placeholder="请输入日期" class="laydate-icon" id="sendtime" onclick="laydate()" onblur="fhtime()">
            <span class="hide red sendtime_lable">请选择运输时间</span>
            </td>
        </tr>
        </tbody>
    </table>
    </div>

<div class="xf_thd">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd">
    <p align="right" style="float: left;font-size: 15px;margin-top: 20px;width: 120px;">*货物信息：</p>
    <table  class="table1 mv" style="font-size: 14px;width: 80%;margin: 20px 0 0 45px;border: 0;">
        <tbody>
        <tr>
            <td >货物名称</td>
            <td>件数</td>
            <td>重量（kg）</td>
            <td>体积（m³）</td>
            <td>货物价值（元）</td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td ><input style="border: 0" type="text" id="us" name="goodsName1"  value="" class="cmao_inplg"/></td>
            <td><input style="border: 0" type="text" id="us" name="num"  value="" class="cmao_inplg"/></td>
            <td><input style="border: 0" type="text" id="us" name="wegith"  value="" class="cmao_inplg"/></td>
            <td><input style="border: 0" type="text" id="us" name="volem"  value="" class="cmao_inplg"/></td>
            <td><input style="border: 0" type="text" id="us" name="price1"  value="" class="cmao_inplg"/></td>
        </tr>
        <tr>
            <td align="center" colspan="5"> <div class="J_add" style="background: url('../images/geren/xinzen.jpg')no-repeat  center  top;width: 120px;height: 28px;"></div></td>
        </tr>
        </tbody>
    </table>
</div>
<div class="xf_thd">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" style="padding-left: 30px">
    <div style="font-size: 15px;margin-top: 20px;">是否需接货：<input class="v2" type="radio" name="radio1"  value1="是" /> 是&nbsp;
    <input class="v1" type="radio" name="radio1"  value1="否" /> 否&nbsp;(若需要接货，即需要物流运输单位到指定位置接取货物。)</div>
    <div class="jiehuo1" style="padding:10px  0 0 90px;">
        <table class="table1 " style="font-size: 14px;width: 80%;">
            <tbody>
            <tr>
                <td width="60" >接货地：&nbsp;
                <span class="dizhi_xq"></span>
      			<a data-toggle="modal" data-target="#myModaldz" style="margin-left:10px;" class="btn btn-he btn-w150 dizhi_btn" type="button">设置接货详细地址</a>   
                	<!-- 街道地址&nbsp;<input type="text" id="jddz" name="us"  value="" class="cmao_inplg"/></td> -->
            </tr>
            </tbody>
        </table>
    </div>

    <div style="font-size: 15px;margin-top: 20px;">是否需送货：<input  class=" v3" type="radio" name="radio2"  value1="是" /> 是&nbsp;
    <input class=" v4" type="radio" name="radio2"  value1="否" /> 否&nbsp;(若需要送货，即需要物流运输单位要将货物送达指定的位置。)</div>
    <div class="jiehuo2" style="padding:10px  0 0 90px;">
        <table class="table1 " style="font-size: 14px;width: 80%;">

            <tbody>
            <tr>
                <td width="60" >送货地：&nbsp;
                <span class="dizhi_xq">四川省成都市高新区邻里街23号</span>
      			<a data-toggle="modal" data-target="#myModaldz"  style="margin-left:10px;" class="btn btn-he btn-w150 dizhi_btn" type="button">设置送货详细地址</a>          
              <!--   街道地址&nbsp;<input type="text" id="shdz" name="us"  value="" class="cmao_inplg"/> --></td>
            </tr>
            </tbody>

        </table>
    </div>
    <!-- <div style="font-size: 15px;margin: 20px 0 0 -30px;">是否需代收货款：<input  class="v5" type="radio" name="radio3"  value1="是" /> 是&nbsp;
    <input  class="v6" type="radio" name="radio3"  value1="否" /> 否&nbsp;(若需代收货款，即您需要录入你的银行账号信息，方便汇款。)</div> -->
    <!-- <div class="jiehuo3" style="padding:10px  0 0 90px;">
        <table class="table1 " style="font-size: 14px;width: 80%;">

            <tbody>
            <tr>
                <td width="60" >持卡人：<input type="text" id="ckr" name="us"  value="请输入真实姓名" class="cmao_inplg"/></td>
            </tr>
            <tr>
                <td width="60" >持卡人：<div class="dropdown-list">
                    <div class="drop-list drop-list-min">
                        <div class="checked" ><a href="javascript:void(0);" id="yh">中国银行</a><span></span></div>
                    </div>
                    <ul class="select select-min none">
                        <li><a href="javascript:void(0);">农业银行</a></li>
                        <li><a href="javascript:void(0);">工商银行</a></li>
                        <li><a href="javascript:void(0);">建设银行</a></li>
                    </ul>
                </div></td>
            </tr>
            <tr>
                <td width="60">&nbsp;&nbsp;卡号：&nbsp;<input type="text" id="kh" name="us"  value="请输入有效卡号" class="cmao_inplg"/></td>
            </tr>
            </tbody>

        </table>
    </div> -->
</div>
<div class="xf_thd"  style="margin-top: 20px">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" style="padding-left: 45px;font-size: 15px;">

    <div style="margin-top: 20px;">附加要求：<input type="checkbox" name="checkbox1" id="checkbox1" value="0" /> 回单</div>
    <div style="margin:20px 0 0 75px">
        <input type="checkbox" name="checkbox2"  id="checkbox2" value="1"/> 加急
    </div>
    <div style="margin:20px 0 0 75px">
        <input type="checkbox" name="checkbox3" id="checkbox3" value="2"/> 保价
    </div>
    <div style="margin:20px 0 0 75px">
        <input type="checkbox" name="checkbox4" id="checkbox4" value="3"/> 开具发票
    </div>
    <div style="margin:20px 0 0 75px">
        <input type="checkbox" name="checkbox5" id="checkbox5" value="4"/> 要求控货
    </div>
    <div style="margin:20px 0 0 75px;">
        其他要求 <input type="text" class="cmao_inplg" id="qita" value=""/>
    </div>

</div>
<div class="xf_thd" style="margin-top: 20px">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" >
    <table class="table1" style="border: 0;font-size: 15px;margin-left: -20px;">

        <tbody>
        <tr>
            <td width="155" align="right">*收货人：</td>
            <td><input type="text" id="shr" name="us"  value="请输入您的真实姓名" class="cmao_inplg" onblur="shr()"/>
            <span class="hide red shr_lable">请输入姓名</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="left" >* 收货人联系方式：</td>
            <td><input type="text" id="shrphone" name="shouji" class="cmao_inplg"   value="请输入有效手机号码"  onblur="shrphone()"/>
            <span class="hide red shrphone_lable">请输入有效的手机号码</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">*发货人：</td>
            <td><input type="text" id="fhr" name="us"  value="请输入您的真实姓名" class="cmao_inplg" onblur="fhr()"/>
            <span class="hide red fhr_lable">请输入您的姓名</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right" >*手机号码：</td>
            <td><input type="text" id="shrsjhm" name="shouji" class="cmao_inplg" value="请输入有效手机号码" onblur="shrsjhm()"/>
            <span class="hide red shrsjhm_lable">请输入您的手机号码</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">&nbsp;</td>
            <td> <a style="margin-left: -10px" class="btn btn-he btn-w150" type="button">发送验证码</a></td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">手机验证：</td> 
            <td><input type="text" id="us" name="us"  value="请输入手机收到的验证码" class="cmao_inplg us_code" onblur="us()"/>
            <span class="hide red us_lable">请输入手机验证码</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">&nbsp;</td>
            <td><a style="margin-left: -10px" class="btn btn-he btn-w100" type="button" onclick="wl_save()">提交</a></td>
        </tr>
        </tbody>
    </table>
</div>

<div align="center">
    <script src="${pageContext.request.contextPath}/index_foot.js">

    </script>
</div>
<!-- 设置接货地址与收货地址 -->
<div class="motaisc modal fade" id="myModaldz" tabindex="-1" role="dialog"  aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <p class="mymodal_title" style="margin:-23px 0  0 20px;font-size: 14px;font-size: 22px;">设置接货详细地址</p>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" style="padding:0px;" >
                <div class="xf_tongjiy" style="min-height:300px;margin:10px;">
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<style>
    .mv tbody tr td{border: 1px solid #dddddd;}
    .onError{font-size: 15px;color: #f10202;margin:3px 0 0 15px;float: left;}
</style>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        /*添加行数据*/
        $(".J_add").click(function(){
            var this_html=$(this).parent().parent().prev().html();//当前新增所在行的html
            var after_tr=$(this).parent().parent().prev().after("<tr class='after_tr'></tr>");//向当前行插入一行tr
            var after_tr=$(".after_tr");//选择插入行的类名
            after_tr.html(this_html);//把变量this_html内容插入到创建后的空tr中
            after_tr.find(".J_add").addClass("J_del").removeClass("J_add").text("删除");

            $(".J_del").live("click",function(){
                $(this).parents("tr").remove();
            });//把原来新增操作改成删除操作，并且把它的类名改成J_del
        });
        //移除方法
        $(".J_del").live("click",function(){
            $(this).parents("tr").remove();
        });
    })
</script>

<script src="${pageContext.request.contextPath}/js/formValidator-4.1.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/DateTimeMask.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/function.js" type="text/javascript"></script>
<script>
    var onShowHtml = "<div class='$class$'>$data$</div>";
    var onFocusHtml = "<div class='$class$'>$data$</div>";
    var onErrorHtml = "<div class='$class$'>$data$</div>";
    var onCorrectHtml = "<div class='$class$'>$data$</div>";
    var onShowClass = "";
    var onFocusClass = "";
    var onErrorClass = "";
    var onCorrectClass = "";



</script>
<script>
    $(".jiehuo1").hide();
    $(".jiehuo2").hide();
    $(".jiehuo3").hide();

    $(".v1").click(function () {
        $(".jiehuo1").hide();

    });

    $(".v2").click(function () {
        $(".jiehuo1").show();

    });

    $(".v4").click(function () {
        $(".jiehuo2").hide();

    });

    $(".v3").click(function () {
        $(".jiehuo2").show();

    });

    $(".v6").click(function () {
        $(".jiehuo3").hide();

    });

    $(".v5").click(function () {
        $(".jiehuo3").show();

    });

    $(".table1").click(function () {
        $(".onError").hide();
    });

    $(".w12").hide();

    $(function () {

        var flag = true;
        $(".hn_1").click(function () {
            if (!flag) {
                flag = true;
                $(this).children("img").attr('src', '../images/geren/gengduo.jpg');

                $(".w12").hide();


            } else {
                flag = false;
                $(this).children("img").attr('src', '../images/geren/gengduo1.jpg');

                $(".w12").show();


            }

        });

    });

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

    //表单验证
    ok1=false;
    ok2=false;
    ok3=false;
    ok4=false;
    ok5=false;
    ok6=false;
    ok7=false;
    ok8=false;
    //始发地
     function address(){
	  if($("#city").val()==null||$("#city").val()==""||$("#city").val()=="请选择地区"){
			$(".city_lable").removeClass("hide");
		}else{
			$(".city_lable").addClass("hide");
			ok1=true;
		}
    }
   //到达地
   function address2(){
	  if($("#city2").val()==null||$("#city").val()==""||$("#city").val()=="请选择地区"){
			$(".city2_lable").removeClass("hide");
		}else{
			$(".city2_lable").addClass("hide");
			ok2=true;
		}
  	}
   //运输时间
    function fhtime(){
	  if($("#sendtime").val()==null||$("#sendtime").val()==""||$("#sendtime").val()=="请输入日期"){
			$(".sendtime_lable").removeClass("hide");
		}else{
			$(".sendtime_lable").addClass("hide");
			ok3=true;
		}
  	}
   
   //收货人
   function shr(){
	   if($("#shr").val()==null||$("#shr").val()==""){
			$(".shr_lable").removeClass("hide");
			$(".shr_lable").html("请输入姓名!");
		}else{
			names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
			 if(names.test(($("#shr").val()))){
				$(".shr_lable").addClass("hide");
				ok4=true;
			}else{
				$(".shr_lable").removeClass("hide"); 
				$(".shr_lable").html("姓名输入错误!");
			}
		}
   	}
   //收货人联系方式
   function shrphone(){
	   if($("#shrphone").val()==null||$("#shrphone").val()==""){
			$(".shrphone_lable").removeClass("hide");
			$(".shrphone_lable").html("请输入有效的联系方式!");
		}else{
			var tel_zz=/^1[3|4|5|7|8]\d{9}$/;//手机号码
			 if(tel_zz.test(($("#shrphone").val()))){
				$(".shrphone_lable").addClass("hide");
				ok5=true;
			}else{
				$(".shrphone_lable").removeClass("hide"); 
				$(".shrphone_lable").html("手机号码错误!");
			}
		}
   	}
   //发货人姓名
   function fhr(){
	   if($("#fhr").val()==null||$("#fhr").val()==""){
			$(".fhr_lable").removeClass("hide");
			$(".fhr_lable").html("请输入姓名!");
		}else{
			names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
			 if(names.test(($("#fhr").val()))){
				$(".fhr_lable").addClass("hide");
				ok6=true;
			}else{
				$(".fhr_lable").removeClass("hide"); 
				$(".fhr_lable").html("姓名输入错误!");
			}
		}
   }
   //发货人联系方式
   function shrsjhm(){
	   if($("#shrsjhm").val()==null||$("#shrsjhm").val()==""){
			$(".shrsjhm_lable").removeClass("hide");
			$(".shrsjhm_lable").html("请输入有效的联系方式!");
		}else{
			var tel_zz=/^1[3|4|5|7|8]\d{9}$/;//手机号码
			 if(tel_zz.test(($("#shrsjhm").val()))){
				$(".shrsjhm_lable").addClass("hide");
				ok7=true;
			}else{
				$(".shrsjhm_lable").removeClass("hide"); 
				$(".shrsjhm_lable").html("手机号码错误!");
			}
		}
   }
   //手机验证码
   function  us(){
	   if($(".us_code").val()==null||$(".us_code").val()==""){
			$(".us_lable").removeClass("hide");
			$(".us_lable").html("请输入验证码!");
		}else{
			if($(".us_code").val()=="123456"){
				$(".us_lable").addClass("hide");
				ok8=true;
			}else{
				$(".us_lable").removeClass("hide"); 
				$(".us_lable").html("验证码错误!");
			}
		}
   }
   
   //提交
   function wl_save(){
	   address();
	   address2();
	   fhtime();
	   shr();
	   shrphone();
	   fhr();
	   shrsjhm();
	   us();
	   if(ok1&&ok2&&ok3&&ok4&&ok5&&ok6&&ok7&&ok8){
			alert("验证通过！");
		}else{
			alert("验证失败");
		}
   }
 /* 判断点击的是送货地址还是收获地址并赋值给弹窗标题 */
 $(".dizhi_btn").click(function(){
	var xxdi=$(this).prev(".dizhi_xq").html();//详细地址
	var cc_btn=$(this).text();
	 if(xxdi==""||xxdi==null){//为空
		 $(".mymodal_title").text(cc_btn);
	 }else{
		 if(cc_btn=="设置接货详细地址"){//接货
			 $(".mymodal_title").text("重置接货地址"); 
		 }else{
			 $(".mymodal_title").text("重置送货地址"); 
		 } 
	 }
 })
</script>
</body>
</html>