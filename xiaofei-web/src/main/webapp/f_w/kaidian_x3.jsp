<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
     <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/kaidian_x3.js"></script>

</head>
<body>
<!--消费顶部-->
<%@ include file="../comm/cms_head.jsp" %>

<!--消费顶部搜索-->
<div class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">创业申请</span>
    </div>

</div>



<!-- 创新标题-->
<div class="xf_thd">
    <div class="xf_cxlabel" style="height: 80px;padding: 20px 0 0 20px;f">
        <div style="font-size:22px;width: 100px;float: left;">申请信息</div>
        <div style="font-size: 14px;width:800px;float: left;padding: 5px 0 0 0;">（此项 皆为 * 必填信息）</div>
    </div>
    <table class="table1 mv" style="font-size: 14px;width: 80%;margin: 20px 0 0 45px;border: 0;">
	        <tbody>
	        <tr>
	            <td>商品编号</td>
	            <td>商品名称</td>
	            <td>品牌</td>
	            <td>商品类型</td>
	        </tr>
	        </tbody>
	        <tbody class="sp_info_body">
	        
	        </tbody>
	
	    </table>
    <table class="table1 mf" style="border: 0;font-size: 14px;margin: 20px  0 0 0;">
        <tr>
            <td valign="top" width="100">*申请区域：</td>
            <td> <input type="text" id="city" value="请选择地区" class="areainput" onblur="city()" />
            <span class="hide red city_lable">请选择地区</span>
            </td>
        </tr>
        <tr>
            <td valign="top" width="100">*能力描述：</td>
            <td><div contenteditable="true" style="width: 600px;height: 150px;border: 1px solid #dddddd;float:left;" class="desict"  onblur="desict()"></div>
            <span class="hide red desict_lable">请输入能力描述</span>
            </td>
        </tr>
        </tbody>

    </table>
</div>
<!-- xuxian-->

<div class="xf_thd" style="margin-top: 20px">
    <p class="h_xuline"></p>
</div>
<div class="xf_thd" id="yinhang">
    <table class="table1" style="border: 0;font-size: 15px;margin-left: -20px;">

        <tbody>
        <tr>
            <td width="155" align="right">*真实姓名：</td>
            <td><input type="text" id="us" name="us"  value="" class="cmao_inplg xf_name" onblur="names()"/>
            <span class="hide red xf_name_lable"></span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right" >* 手机号码：</td>
            <td><input type="text" id="shouji" name="shouji" class="cmao_inplg xf_tel"  value="" onblur="xf_tel()" />
            <span class="hide red xf_tel_lable"></span>
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
            <td><input type="text" id="us" name="us"  value="" class="cmao_inplg code" onblur="code()"/>
            <span class="hide red code_lable"></span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">&nbsp;</td>
            <td><a style="margin-left: -10px" onclick="save_i_ok();" class="btn btn-he btn-w100" type="button">提交</a></td>
        </tr>
        </tbody>
    </table>
</div>

<div align="center">
    <script src="../index_foot.js">

    </script>
</div>

<style>
    .mf tbody tr td {
        background-color: #ffffff;
        border:0;
    }
    .mv tbody tr td {
        background-color: #ffffff;
        border: 1px solid #dddddd;
    }
    .onError{font-size: 15px;color: #f10202;margin:3px 0 0 15px;float: left;}
</style>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
    
    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    //地址
    function city(){
    	 if($("#city").val()==null||$("#city").val()==""||$("#city").val()=="请选择地区"){
			$(".city_lable").removeClass("hide");
			}else{
				$(".city_lable").addClass("hide");
				ok1=true;
			}
    }
    //能力描述
     function desict(){
    	 if($(".desict").text()==null||$(".desict").text()==""){
			$(".desict_lable").removeClass("hide");
			}else{
				$(".desict_lable").addClass("hide");
				ok2=true;
			}
    }
    //真实姓名
     function names(){
		  if($(".xf_name").val()==null||$(".xf_name").val()==""){
				$(".xf_name_lable").removeClass("hide");
			    $(".xf_name_lable").html("请输入姓名");
			}else{
				var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
				 if(names.test(($(".xf_name").val()))){
	                 $(".xf_name_lable").addClass("hide");
	              ok3=true;
	             }else{
	                $(".xf_name_lable").removeClass("hide");
	              }
			}
	  }
	  //手机号
	  function xf_tel(){
		  if($(".xf_tel").val()==null||$(".xf_tel").val()==""){
				$(".xf_tel_lable").removeClass("hide");
				$(".xf_tel_lable").html("请输入手机号");
			}else{
				var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
				 if(tel_zz.test(($(".xf_tel").val()))){
	                $(".xf_tel_lable").addClass("hide");
	               ok4=true;
	            }else{
	               $(".xf_tel_lable").removeClass("hide");
	               $(".xf_tel_lable").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
	           }
			}
	  }
	  //验证码
	  function code(){
		  if($(".code").val()==null||$(".code").val()==""){
				$(".code_lable").removeClass("hide");
				$(".code_lable").html("请输入验证码!");
			}else{
				if($(".code").val()=="123456"){
					$(".code_lable").addClass("hide");
					ok5=true;
				}else{
					$(".code_lable").removeClass("hide"); 
					$(".code_lable").html("验证码错误!");
				}
			}
	  }
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>


<script src="${pageContext.request.contextPath}/js/formValidator-4.1.1.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/formValidatorRegex.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/DateTimeMask.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/function.js" type="text/javascript"></script>
<script>