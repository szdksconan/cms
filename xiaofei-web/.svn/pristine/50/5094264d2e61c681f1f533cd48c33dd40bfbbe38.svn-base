<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 	<title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
   <link href="${pageContext.request.contextPath}/css/caidan.css" rel="stylesheet" type="text/css">

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.SuperSlide.2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
</head>
<body>
<!--消费顶部-->
<div align="center">
    <script src="index_head.js">

    </script>
</div>

<!--消费顶部搜索-->
<div class="xf_tsou"><a href="../index.jsp" target="_self"><img src="../images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">投资申请</span>

    </div>


</div>


<!-- 创新标题-->
<div class="xf_thd">
    <div class="xf_cxlabel" style="height: 80px;padding: 20px 0 0 20px;">
        <div style="font-size:22px;width: 100px;float: left;">申请信息</div>
        <div style="font-size: 14px;width:800px;float: left;padding: 5px 0 0 0;">（此项 皆为 * 必填信息）</div>
    </div>
    <table class="table1 mf" style="border: 0;font-size: 14px;margin: 20px  0 0 0;">
        <tbody>
        <tr>
            <td width="155"  align="right">*意向产品：</td>
            <td> <!-- 兼容浏览器的下拉选框-->
                <div class="dropdown-list" id="hang0" ><!-- onblur="hang0()" -->
                    <div class="drop-list drop-list-min">
                        <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                    </div>
                    <ul class="select select-min none">
                        <li onclick="hang1()"><a href="javascript:void(0);">行业1</a></li>
                        <li onclick="hang2()"><a href="javascript:void(0);">行业2</a></li>
                        <li><a href="javascript:void(0);">行业3</a></li>
                    </ul>
                </div>
                <!--2-->
                <div class="dropdown-list" id="hang1" style="display: none;margin-left: 50px;">
                    <div class="drop-list drop-list-min">
                        <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                    </div>
                    <ul class="select select-min none">
                        <li><a href="javascript:void(0);">行业1</a></li>
                        <li><a href="javascript:void(0);">行业2</a></li>
                        <li><a href="javascript:void(0);">行业3</a></li>
                    </ul>
                </div>
                <!--3-->
                <div class="dropdown-list" id="hang2" style="display: none;margin-left: 50px;">
                    <div class="drop-list drop-list-min">
                        <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                    </div>
                    <ul class="select select-min none">
                        <li><a href="javascript:void(0);">行业1</a></li>
                        <li><a href="javascript:void(0);">行业2</a></li>
                        <li><a href="javascript:void(0);">行业3</a></li>
                    </ul>
                </div>
                <span class="red hide hang_lable" style="margin-left:50px;">请选择行业</span>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td width="155"  align="right" valign="top">*申请区域：</td>
            <td><input type="text" id="city" value="请选择地区" class="areainput citys" onblur="citys()"/>
            <span class="red hide citys_lable">请选择地址</span>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td valign="top"width="155"  align="right">*能力描述：</td>
            <td>
                <div contenteditable="true" class="nengli_ms" style="width: 600px;height: 150px;border: 1px solid #dddddd;" onblur="nengli_ms()"></div>
              
            </td>
            <td valign="top">
                提示： 尊敬的用户您好！为了增加您的合作成功率； 您可以输入自己是否有店铺，店铺面积为多大…… 您的活动资金有多少……您的服务能力……从业经验等
                  <span  class="red hide nengli_ms_lable">请完善您的能力描述</span>
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
    <table class="table1" style="border: 0;font-size: 15px;margin: 20px  0 0 0;">

        <tbody>
        <tr>
            <td width="155" align="right">*真实姓名：</td>
            <td><input type="text" value="请输入您的真实姓名" class="cmao_inplg names" onblur="names()"/>
            <span class="hide red names_lable">请输入您的姓名</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">* 手机号码：</td>
            <td><input type="text" class="cmao_inplg tels" value="有效号码 用于业务沟通" onblur="tels()"/>
            <span class="red hide tels_lable">请输入您的手机号码</span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">&nbsp;</td>
            <td><a class="btn btn-he btn-w150" type="button">发送验证码</a></td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">手机验证：</td>
            <td><input type="text" value="请输入手机收到的验证码" class="cmao_inplg tels_code" onblur="tels_code()"/>
            <span class="red hide tels_code_lable"></span>
            </td>
        </tr>
        </tbody>
        <tbody>
        <tr>
            <td width="155" align="right">&nbsp;</td>
            <td><a href="javascript:;"  target=" _self" onclick="cy_tj_btn()" class="btn btn-he btn-w100 cy_tj_btn"
                   type="button">提交</a></td>
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
        border: 0;
    }

    .mv tbody tr td {
        background-color: #ffffff;
        border: 1px solid #dddddd;
    }

    .onError {
        font-size: 15px;
        color: #f10202;
        margin: 3px 0 0 15px;
        float: left;
    }
</style>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this, e);
    });
</script>
<script src="../js/Popt.js"></script>
<script src="../js/cityJson.js"></script>
<script src="../js/citySet.js"></script>


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

    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    var ok6=false;
    //行业分类
     function hang0(){
    	if($("#hang0 .checked a").html()==null||$("#hang0 .checked a").html()==""){
  			$(".hang_lable").removeClass("hide");
		 	ok1=false;
		}else{
			$(".hang_lable").addClass("hide");
			ok1=true;
		}
    } 
    //申请区域
    function citys(){
    	 if($(".citys").val()==null||$(".citys").val()==""||$(".citys").val()=="请选择地区"){
  			$(".citys_lable").removeClass("hide");
		   ok2=false;
		}else{
			$(".citys_lable").addClass("hide");
		   ok2=true;
		}
    }
    //能力描述
    function nengli_ms(){
     if($(".nengli_ms").text()==null||$(".nengli_ms").text()==""){
		$(".nengli_ms_lable").removeClass("hide");
		$(".nengli_ms_lable").html("请完善您的能力描述");
		 ok3=false;
		}else{
			if($(".nengli_ms").text().length>200||$(".nengli_ms").text().length<50){
				$(".nengli_ms_lable").removeClass("hide");
	 			$(".nengli_ms_lable").html("能力描述限制50-200字数！");
	 			 ok3=false;
			}else{
				$(".nengli_ms_lable").addClass("hide");
 				ok3=true;
			}
		}
    }
	//姓名
	 function names(){
    	if($(".names").val()==null||$(".names").val()==""||$(".names").val()=="请输入您的真实姓名"){
			$(".names_lable").removeClass("hide");
		    $(".names_lable").html("请输入姓名");
		    ok4=false;
		}else{
			var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
			 if(names.test(($(".names").val()))){
                 $(".names_lable").addClass("hide");
               ok4=true;
             }else{
                $(".names_lable").removeClass("hide");
                $(".names_lable").html("姓名输入有误");
                ok4=false;
              }
		}
    }
	//手机号码
    function  tels(){
		  if($(".tels").val()==null||$(".tels").val()==""||$(".tels").val()=="有效号码 用于业务沟通"){
				$(".tels_lable").removeClass("hide");
				$(".tels_lable").html("请输入手机号");
				 ok5=false;
			}else{
				var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
				 if(tel_zz.test(($(".tels").val()))){
	                $(".tels_lable").addClass("hide");
	               ok5=true;
	            }else{
	               $(".tels_lable").removeClass("hide");
	               $(".tels_lable").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
	               ok5=false;
	           }
			}
	  }
	//手机验证
	function tels_code(){
		  if($(".tels_code").val()==null||$(".tels_code").val()==""||$(".tels_code").val()=="请输入手机收到的验证码"){
				$(".tels_code_lable").removeClass("hide");
				$(".tels_code_lable").html("请输入验证码!");
				ok6=false;
			}else{
				if($(".tels_code").val()=="123456"){
					$(".tels_code_lable").addClass("hide");
					ok6=true;
				}else{
					$(".tels_code_lable").removeClass("hide"); 
					$(".tels_code_lable").html("验证码错误!");
					ok6=false;
				}
			}
	  }
	//提交
	function cy_tj_btn(){
		 //hang0();
		 citys();
		 nengli_ms();
		 names();
		 tels();
		 tels_code();
		 if(ok2&&ok3&&ok4&&ok5&&ok6){/* ok1 */
			alert("通过"); 
			$(".cy_tj_btn").attr("href","kaidian_x3_3.jsp");
			//=""
		 }else{
			 alert("不通过"); 
			 $(".cy_tj_btn").attr("href","javascript:;");
		 }
	}
</script>

</body>
</html>