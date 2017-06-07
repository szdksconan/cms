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
    <!-- 放大镜-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.imagezoom.min.js"></script>
</head>
<body>

<!--消费顶部-->
<!-- <div class="xf_top">
    <div class="xf_head">
        <ul>
            <li><a href="index.jsp" target="_self" class="active">成都</a></li>
            <li><a href="wuliou.jsp" target="_self">消息</a></li>
            <li><a href="wuliou.jsp" target="_self">购物车</a></li>
            <li><a href="wuliou.jsp" target="_self">收藏夹</a></li>
            <li><a href="wuliou.jsp" target="_self">客服中心</a></li>
        </ul>

        <div class="xf_dz">
            <a href="regist/register.jsp" target="_self">登录</a><a>&nbsp;/&nbsp;</a> <a href="regist/login.jsp"
                                                                                        target="_self">注册</a>
        </div>
    </div>

</div> -->
<%@ include file="comm/cms_head.jsp" %>
<!--消费顶部搜索-->
<div class="xf_tsou">
    <a href="index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
       
        <span style="font-size: 28px;margin-top:10px;float: left;">创业申请</span>
    </div>

</div>
<!--  信息验证-->
<form method="post" id="shop_info">
<div class="xf_thd">
    <div class="xf_cxlabel">
        基本信息（此项 皆为 * 必填信息）
    </div>
</div>
<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
        <div id="formbox">
            <div class="form">
                <div class="item">
                    <span class="label"><span class="red">*</span>真实姓名：</span>
                    <div class="fl">
                        <input type="text" id="username" class="text name" tabindex="1" />
                        <label id="username_succeed" class="blank"></label>
                        <span class="clear"></span>
                        <div id="username_error" style="font-size: 14px"></div>
                    </div>
                </div><!--item end-->

                <div class="item">
                    <span class="label"><span class="red">*</span>手机号码：</span>
                    <div class="fl">
                        <input type="text" id="mobile" class="text tel" tabindex="10" />
                        <label id="mobile_succeed" class="blank"></label>
                        <span class="clear"></span>
                        <label id="mobile_error"></label>
                    </div>
                </div><!--item end-->
                <div class="item">
                    <span class="label"><span class="red">*</span>手机验证：</span>
                    <div class="fl">
                        <input type="text" id="authcode" name="authcode" class="text text-1" autocomplete="off" MaxLength="6" tabindex="6" />
                        <!-- <label class="img"><img id="JD_Verification1" Ver_ColorOfNoisePoint="#888888" src="http://www.mailuke.com/Inc/Code/adminCode.php?sesstr=regCode" onClick="chanageCode('regCode')" alt="" style="cursor:pointer;width:100px;height:26px;"/>
                        </label>
                        <label>&nbsp;看不清？点击验证码图片更换</label>
                        <label id="authcode_succeed" class="blank invisible"></label>
                        <span class="clear"></span>
                        <label id="authcode_error"></label> -->
                    </div>
                </div><!--item end-->

            </div>
    </div>
</div>

<!--2-->
<div class="xf_thd">
    <p class="h_xuline">
    </p>
</div>
<!--2-->
<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
        <table >
            <tr>
                <td ><span class="red">*</span>有店铺：</td>
                <td class="yn_shop">
                    <input type="radio" name="sellYn" value="是" checked="checked"/>是

                    &nbsp;
                    <input type="radio" name="sellYn" value="否"/>否

                </td>
            </tr>
            </table>
           <table style="margin-top: -60px;">
            <tr>
                <td>店铺位置：</td>
                <td style="padding-top:40px"> <!-- 兼容浏览器的下拉选框-->
                    <div class="sjld" style="width:auto;margin:30px auto;position:relative;float: left;height: 50px;">
                        <div class="m_zlxg" id="shenfen" >
                            <p title="" >选择省份</p>
                            <div class="m_zlxg2" >
                                <ul style="height:250px; overflow-y:auto; "></ul>
                            </div>
                        </div>
                        <div class="m_zlxg" id="chengshi" >
                            <p title="">选择城市</p>
                            <div class="m_zlxg2" >
                                <ul  style="height:250px; overflow-y:auto; "></ul>
                            </div>
                        </div>
                        <div class="m_zlxg" id="quyu">
                            <p title="">选择区域</p>
                            <div class="m_zlxg2">
                                <ul  style="height:250px; overflow-y:auto; "></ul>
                            </div>
                        </div>
                    </div>

                </td>
            </tr>
           </table>
        <table style="margin-top: -60px;">
            <tr>
                <td>街道地址：</td>
                <td>
                    <input type="text" class="cmao_inplg userDetAdr"/>

                </td>
            </tr>
            <tr>
                <td colspan="2">附加信息（此项为选填信息，您的填写有助提高合作申请的成功率 ） </td>
            </tr>
        </table>
    </div>
    <!-- 出现内容-->
    <div class="xf_thd shop_info" id="chu">
    <div class="xf_cxyanz"  style="margin-top: -20px;">
        <table >
            <tr>
                <td>店铺面积：</td>
                <td>
                    <input type="text" class="cmao_inplg sellArea" value="100"/>&nbsp;平方米

                </td>
            </tr>
            <tr>
                <td>企业名称：</td>
                <td>
                    <input type="text" class="cmao_inplg enterpriseName"/>

                </td>
            </tr>
            <tr>
                <td>企业性质：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="enterpriseType"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">国营</a></li>
                            <li><a href="javascript:void(0);">私有</a></li>
                            <li><a href="javascript:void(0);">合资</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
            <tr>
                <td>所属行业：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="belongsIndustry"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">铁路</a></li>
                            <li><a href="javascript:void(0);">石化</a></li>
                            <li><a href="javascript:void(0);">钢铁</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
            <tr>
                <td>企业官网：</td>
                <td>
                    <input type="text" class="cmao_inplg enterpriseWebsite"/>

                </td>
            </tr>
            <tr>
                <td>传真：</td>
                <td>
                    <input type="text" class="cmao_inplg mail_z"/>

                </td>
            </tr>

        </table>
        <div id="formbox" style="height: 50px;">
        <div class="form">
            <div class="item">
                <span class="label" style="margin-left: -10px;margin-left: -20px\9;"><span class="red"></span>企业邮箱：</span>
                <div class="fl">
                    <input type="text" id="mail" class="text enterpriseEmail" tabindex="4"/>
                    <label id="mail_succeed" class="blank"></label>
                    <span class="clear"></span>
                    <div id="mail_error" style="font-size: 14px;"></div>
                </div>
            </div><!--item end-->

        </div>
</div>
        <table >
            <tr>
                <td valign="top">企业介绍：</td>
                <td><textarea class="enterpriseInfo" placeholder="请输入" cols="5"></textarea> </td>
            </tr>

            <tr>
                <td valign="top">资质证书：</td>
                <td>
                    <!-- <div class=" xf_fangdaz1 " style="width: 115px;height: 145px;float: left;">
                        <i onclick="clo()"  class="xf_reclo fa fa-times"></i>

                        <div class="box f_refada" >

                            <div class=" tb-pic xf_refada0" style="margin-top:-18px;">
                                <a href="${pageContext.request.contextPath}/images/01.jpg"><img src="${pageContext.request.contextPath}/images/01_mid.jpg" alt="产品" rel="${pageContext.request.contextPath}/images/01.jpg" class="jqzoom xf_refada0"  /></a>
                            </div>
                        </div>
                    </div> -->
                    <div  style="float: left;margin:-5px 0 0 20px;">
                        <div id="fileList" class="xf_repicleft">
                        </div>
                        <input id="Button1" type="button" value="" class="xf_repicture"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="top">&nbsp;</td>
                <td>

                    <p> 说明：此处的文件最好是清晰地扫描文件或照片文件，格式为JPG、PNG，大小不超过3M，

                        数量不超过4张
                    </p>
                </td>
            </tr>

        </table>

    </div>
</div>
 </div>
<!-- 消失内容-->
<div class="xf_thd pre_desc" id="chu_2" style="display: none">
<div class="xf_cxyanz"  style="margin-top: -20px;">

    <table >
        <tr>
            <td valign="top">个人描述：</td>
            <td><textarea class="brief" placeholder="请输入" cols="5"></textarea> </td>
        </tr>

    </table>

</div>
</div>
<!-- -->
<!--虚线-->
<div class="xf_thd">
    <p class="h_xuline">
    </p>
</div>
<div class="xf_thd">
    <div class="xf_cxlabel">
        条件意向填写（此项 皆为 * 必填信息）
    </div>
</div>
<!-- 意向-->
<div class="xf_thd" >
    <div class="xf_cxyanz"  style="margin-top: -20px;">
        <table >
            <tr>
                <td>申请区域：</td>
                <td style="padding-top:40px"> 兼容浏览器的下拉选框
                    <!-- <div class="sjld" style="width:auto;margin:30px auto;position:relative;float: left;height: 50px;">
                        <div class="m_zlxg" id="shenfen" >
                            <p title="" >选择省份</p>
                            <div class="m_zlxg2" >
                                <ul style="height:250px; overflow-y:auto; "></ul>
                            </div>
                        </div>
                        <div class="m_zlxg" id="chengshi" >
                            <p title="">选择城市</p>
                            <div class="m_zlxg2" >
                                <ul  style="height:250px; overflow-y:auto; "></ul>
                            </div>
                        </div>
                        <div class="m_zlxg" id="quyu">
                            <p title="">选择区域</p>
                            <div class="m_zlxg2">
                                <ul  style="height:250px; overflow-y:auto; "></ul>
                            </div>
                        </div>
                    </div> -->
					<input type="text" class="applicationArea" />
                </td>
            </tr>
            <tr>
                <td>流动资金：</td>
                <td>
                    <input type="text" class="cmao_inplg cash"/>&nbsp;万

                </td>
            </tr>
            <tr>
                <td>意向行业：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none h_one">
                            <!-- <li><a href="javascript:void(0);">行业1</a></li>
                            <li><a href="javascript:void(0);">行业2</a></li>
                            <li><a href="javascript:void(0);">行业3</a></li> -->
                        </ul>
                    </div>
                    <!-- 2 -->
                    <div class="dropdown-list hang1" style="display: none;margin-left: 50px;">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="h_checked"></a><span></span></div>
                        </div>
                        <ul class="select select-min none h_two">
                            <!-- <li><a href="javascript:void(0);">行业1</a></li>
                            <li><a href="javascript:void(0);">行业2</a></li>
                            <li><a href="javascript:void(0);">行业3</a></li> -->
                        </ul>
                    </div>
                   <!-- 3 -->
                    <div class="dropdown-list hang2" style="display: none;margin-left: 50px;">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="h_checked1"></a><span></span></div>
                        </div>
                        <ul class="select select-min none h_three">
                            <!-- <li><a href="javascript:void(0);">行业1</a></li>
                            <li><a href="javascript:void(0);">行业2</a></li>
                            <li><a href="javascript:void(0);">行业3</a></li> -->
                        </ul>
                    </div>
                </td>
            </tr>
            <tr>
                <td>合作方式：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="metCoop"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">经销</a></li>
                            <li><a href="javascript:void(0);">代理</a></li>
                            <li><a href="javascript:void(0);">经销/代理</a></li>
                        </ul>
                    </div>
                </td>
            </tr>
            <tr>
                <td>从业年限：</td>
                <td>
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="employedYear"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">无年限</a></li>
                            <li><a href="javascript:void(0);">1年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                        </ul>
                    </div>

                </td>
            </tr>
            <tr>
                <td>货款支付：</td>
                <td>
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="payWay"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">现货现款</a></li>
                            <li><a href="javascript:void(0);">先货后款</a></li>
                            <li><a href="javascript:void(0);">分期付款</a></li>
                        </ul>
                    </div>

                </td>
            </tr>
            <tr>
                <td colspan="2" >

                      是否申请区域独家经营：
                    <input  type="radio" name="areaExclBusiness" id="radio" value="是" />是

                    &nbsp;
                    <input   type="radio" name="areaExclBusiness"  id="radio2" value="否" />否


                </td>
            </tr>
            <tr>
                <td colspan="2" >

                        具备服务能力：
                         <input name="serviceCapability" type="checkbox" value="送货上门" />送货上门

                        &nbsp;
                        <input name="serviceCapability" type="checkbox" value="商品维修" />商品维修

                        &nbsp;
                        <input name="serviceCapability" type="checkbox" value="暂无相关能力" />暂无相关能力

                        &nbsp;

                </td>
            </tr>
        </table>
    </div>
</div>
<!--虚线 -->
<div class="xf_thd">
    <p class="h_line">
    </p>
</div>

<div class="xf_thd">
<a   class="btn btn-he btn-w100" type="button"  onclick="shopInfo()">提交</a>
</div>
</div>
</form>
<p>&nbsp;</p>


<!-- 底部-->
<div align="center">
    <script src="index_foot.js">

    </script>
</div>

    <script src="${pageContext.request.contextPath}/js/uplo.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/address.js"></script>
    <script type="text/javascript">
        $(function(){

            $("#sjld").sjld("#shenfen","#chengshi","#quyu");

        });
        
        function shopInfo(){
        	alert($("#shop_info").serialize());
        }
    </script>


<script type="text/javascript">

   /*  function clo() {
        $(".xf_fangdaz1,.fa ").hide();
    }

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
    }); */
    
    $(document).ready(function() {
    	$(".yn_shop").click(function(){
    		var sellYn=$('input:radio[name="sellYn"]:checked').val();
    		if(sellYn=="否"){
    			$(".shop_info").hide();
    			$(".pre_desc").show();
    		}else{
    			$(".shop_info").show();
    			$(".pre_desc").hide();
    		}
    	})
    });

    $(".xf_tsouy div img").click(function(){
        $(this).hide();
        $(".xf_input").val( $(this).get(0).defaultValue );
    });

</script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xiaofei_ajax/regist.js"></script>

</body>
</html>