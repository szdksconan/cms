<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>申请开店</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="css/xiaofei.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/control.js"></script>
    <script src="js/uplo.js"></script>
</head>
<body>

<!--消费顶部-->
<div class="xf_top">
    <div class="xf_head">
        <ul>
            <li><a href="index.html" target="_self" class="active">成都</a></li>
            <li><a href="wuliou.html" target="_self">消息</a></li>
            <li><a href="wuliou.html" target="_self">购物车</a></li>
            <li><a href="wuliou.html" target="_self">收藏夹</a></li>
            <li><a href="wuliou.html" target="_self">客服中心</a></li>
        </ul>

        <div class="xf_dz">
            <a href="regist/register.html" target="_self">登录</a><a>&nbsp;/&nbsp;</a> <a href="regist/login.html"
                                                                                        target="_self">注册</a>
        </div>
    </div>

</div>

<!--消费顶部搜索-->
<div class="xf_tsou">
    <a href="index.html" target="_self"><img src="images/logoin.jpg"></a>

    <div class="xf_tsouy">
       
        <span style="font-size: 28px;margin-top:10px;float: left;">开店申请</span>
    </div>

</div>
<!--  信息验证-->

<div class="xf_thd">
    <div class="xf_cxlabel">
        基本信息（此项 皆为 * 必填信息）
    </div>
</div>
<form action="javacsript(0);" method="post" id="shop_info">
<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
        <div id="formbox">
            <div class="form">
                <div class="item">
                    <span class="label"><span class="red">*</span>真实姓名：</span>
                    <div class="fl">
                        <input type="text" id="username" name="name" class="text" tabindex="1" />
                        <label id="username_succeed" class="blank"></label>
                        <span class="clear"></span>
                        <div id="username_error" style="font-size: 14px"></div>
                    </div>
                </div><!--item end-->

                <div class="item">
                    <span class="label"><span class="red">*</span>手机号码：</span>
                    <div class="fl">
                        <input type="text" id="mobile" name="tel" class="text" value="" tabindex="10" />
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
                <td >*有店铺：</td>
                <td class="yn_shop">
                    <input type="radio" name="sellYn" value="是" />是

                    &nbsp;
                    <input type="radio" name="sellYn" value="否" />否

                </td>
            </tr>
            <tr>
                <td>店铺位置：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <input type="text" id="city" name="addressProvince" class="areainput" />

                </td>
            </tr>
            <tr>
                <td>街道地址：</td>
                <td>
                    <input type="text" name="userDetAdr" class="cmao_inplg" value=""/>

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
                    <input type="text" name="sellArea" class="cmao_inplg" value="100"/>&nbsp;平方米

                </td>
            </tr>
            <tr>
                <td>企业名称：</td>
                <td>
                    <input type="text" name="enterpriseName" class="cmao_inplg" value=""/>

                </td>
            </tr>
            <tr>
                <td>企业性质：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <!-- <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">国营</a></li>
                            <li><a href="javascript:void(0);">私有</a></li>
                            <li><a href="javascript:void(0);">合资</a></li>
                        </ul> -->
                        <select name="enterpriseType">
						<option selected="selected">---请选择---</option>
						<option value="个体经营">个体经营</option>
						<option value="合伙经营">合伙经营</option>
					</select>
                    </div>
                </td>
            </tr>
            <tr>
                <td>所属行业：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                       <!--  <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">铁路</a></li>
                            <li><a href="javascript:void(0);">石化</a></li>
                            <li><a href="javascript:void(0);">钢铁</a></li>
                        </ul> -->
                        <select name="belongsIndustry">
						<option selected="selected">---请选择---</option>
						<option value="电器">电器</option>
						<option value="食品">食品</option>
					</select>
                    </div>
                </td>
            </tr>
            <tr>
                <td>企业官网：</td>
                <td>
                    <input type="text" class="cmao_inplg" value="" name="enterpriseWebsite"/>

                </td>
            </tr>
            <tr>
                <td>传真：</td>
                <td>
                    <input type="text" class="cmao_inplg" value="" name="enterpriseEmail"/>

                </td>
            </tr>

        </table>
        <div id="formbox" style="height: 50px;">
        <div class="form">
            <div class="item">
                <span class="label" style="margin-left: -10px;margin-left: -20px\9;"><span class="red"></span>企业邮箱：</span>
                <div class="fl">
                    <input type="text" id="mail" name="mail" class="text" tabindex="4"/>
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
                <td><textarea placeholder="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus accumsan et viverra justo commodo. Proin sodales pulvinar tempor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam fermentum, nulla luctus pharetra vulputate, felis tellus mollis orci, sed rhoncus sapien nunc eget odio." cols="5"></textarea> </td>
            </tr>
            <tr>
                <td valign="top">资质证书：</td>
                <td>
					<div id="fileList" style=" width:auto;overflow: hidden;float: left">
                  </div>
                  <input id="Button1" type="button" value="" style="width: 110px;height: 145px;background: url('images/chuangxin/cx_d3.jpg')no-repeat  center  top;border: 0;margin-top:5px;"/>
                    <p>&nbsp;</p>
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
            <td><textarea placeholder="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean euismod bibendum laoreet. Proin gravida dolor sit amet lacus accumsan et viverra justo commodo. Proin sodales pulvinar tempor. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nam fermentum, nulla luctus pharetra vulputate, felis tellus mollis orci, sed rhoncus sapien nunc eget odio." cols="5"></textarea> </td>
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
                <td>
                    <input type="text" id="city" class="areainput" />

                </td>
            </tr>
            <tr>
                <td>流动资金：</td>
                <td>
                    <input type="text" class="cmao_inplg" name="cash"/>&nbsp;万

                </td>
            </tr>
            <tr>
                <td>意向行业：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">行业1</a></li>
                            <li><a href="javascript:void(0);">行业2</a></li>
                            <li><a href="javascript:void(0);">行业3</a></li>
                        </ul>
                    </div>
                    <!--2-->
                    <!-- <div class="dropdown-list" id="hang1" style="display: none;margin-left: 50px;">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">行业1</a></li>
                            <li><a href="javascript:void(0);">行业2</a></li>
                            <li><a href="javascript:void(0);">行业3</a></li>
                        </ul>
                    </div>
                    3
                    <div class="dropdown-list" id="hang2" style="display: none;margin-left: 50px;">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">行业1</a></li>
                            <li><a href="javascript:void(0);">行业2</a></li>
                            <li><a href="javascript:void(0);">行业3</a></li>
                        </ul>
                    </div> -->
                </td>
            </tr>
            <tr>
                <td>合作方式：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list">
                        <!-- <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">经销</a></li>
                            <li><a href="javascript:void(0);">代理</a></li>
                            <li><a href="javascript:void(0);">经销/代理</a></li>
                        </ul> -->
                        <select name="brand">
					<option selected="selected">---请选择---</option>
					<option value="经销">经销</option>
					<option value="代理">代理</option>
					<option value="经销/代理">经销/代理</option>
				</select>
                    </div>
                </td>
            </tr>
            <tr>
                <td>从业年限：</td>
                <td>
                    <div class="dropdown-list">
                        <!-- <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">无年限</a></li>
                            <li><a href="javascript:void(0);">1年以上</a></li>
                            <li><a href="javascript:void(0);">3年以上</a></li>
                        </ul> -->
                        <select name="employedYear">
					<option selected="selected">---请选择---</option>
					<option value="无年限">无年限</option>
					<option value="1年以上">1年以上</option>
					<option value="3年以上">3年以上</option>
				</select>
                    </div>

                </td>
            </tr>
            <tr>
                <td>货款支付：</td>
                <td>
                    <div class="dropdown-list">
                        <!-- <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);"></a><span></span></div>
                        </div>
                        <ul class="select select-min none">
                            <li><a href="javascript:void(0);">现货现款</a></li>
                            <li><a href="javascript:void(0);">先货后款</a></li>
                            <li><a href="javascript:void(0);">分期付款</a></li>
                        </ul> -->
                        <select name="payWay">
					<option selected="selected">---请选择---</option>
					<option value="现货现款">现货现款</option>
					<option value="先货后款">先或后款</option>
					<option value="分期付款">分期付款</option>
				</select>
                    </div>

                </td>
            </tr>
            <tr>
                <td colspan="2" >

                      是否申请区域独家经营：
                    <input  type="radio" name="areaExclBusiness" value="是" />是

                    &nbsp;
                    <input   type="radio" name="areaExclBusiness" value="否" />否


                </td>
            </tr>
            <tr>
                <td colspan="2" >

                        具备服务能力：
                        <input name="servAbt" type="checkbox" value="送货上门" />送货上门

                        &nbsp;
                        <input name="servAbt" type="checkbox" value="商品维修" />商品维修

                        &nbsp;
                        <input name="servAbt" type="checkbox" value="暂无相关能力" />暂无相关能力

                        &nbsp;

                </td>
            </tr>
        </table>
    </div>
</div>
<!--虚线-->
<div class="xf_thd">
    <p class="h_line">
    </p>
</div>

<div class="xf_thd">
<a   class="btn btn-he btn-w100" type="button" onclick="shopInfo()">提交</a>
<!-- <input class="btn btn-he btn-w100" type="submit" value="提交" id="files"> -->
</div>
</div>
</form>
<p>&nbsp;</p>
</body>

<!-- 底部-->
<div align="center">
    <script src="js/index_foot.js">

    </script>
</div>
<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
</script>
<script src="js/Popt.js"></script>
<script src="js/cityJson.js"></script>
<script src="js/citySet.js"></script>
<script type="text/javascript" src="js/Validate.js"></script>
<!-- <script type="text/javascript" src="js/Validate.form.js"></script> -->
<script type="text/javascript" src="js/wykd.js"></script>
</body>

<script>
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

    $(".xf_tsouy div img").click(function () {
        $(this).hide();
        $(".xf_input").val($(this).get(0).defaultValue);
    });

</script>
<!-- <script>
var upload;
function shopInfo(){
	$.ajax({
		url:"open/addCmsXShopApply",
		data:$("#shop_info").serialize(),
		dataType:"json",
		type:"post",
		success:function(data){
			upload.submitUpload();
		}
	});
}
    $(function () {
        //var btn = $("#Button1");

        var btn = $("#Button1").uploadFile({
            url: "open/upload",
            fileSuffixs: ["jpg", "png", "gif"],
            maximumFilesUpload: 4,//最大文件上传数
            onComplete: function (msg) {
                $("#testdiv").append(msg + "<br/>");
            },
            onAllComplete: function () {
                alert("全部上传完成");
            },
            isGetFileSize: true,//是否获取上传文件大小，设置此项为true时，将在onChosen回调中返回文件fileSize和获取大小时的错误提示文本errorText
            onChosen: function (file, obj, fileSize, errorText) {
                if (!errorText) {
                    $("#file_size").text(file + "文件大小为：" + fileSize + "KB");
                } else {
                    alert(errorText);
                    return false;
                }
                return true;//返回false将取消当前选择的文件
            },
            perviewElementId: "fileList", //设置预览图片的元素id
            perviewImgStyle: { width: '110px', height: '145px', border: '1px solid #ebebeb' }//设置预览图片的样式
        });

        upload = btn.data("uploadFileData");

        /* $("#files").click(function () {
            upload.submitUpload();
        }); */
    });
</script> -->
</html>