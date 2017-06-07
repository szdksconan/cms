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

</head>
<body>
<!-- 模态化窗口进度表示-->
<div class="motaisc modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body" >
                <div class="xf_ms1">
                    <p style="padding: 60px 0 0 100px;"><img  style=" float: left" src="${pageContext.request.contextPath}/images/chuangxin/2011613102338724.gif">
                    <span style="margin: 80px 0  0 80px;font-size: 18px;display: inline-block;"> 正在提交中...... </span></p>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
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

        <span style="font-size: 16px;">发布创新定制</span>
    </div>

</div>

<!-- 创新标题-->
<div class="xf_thd">
    <div class="xf_cxlabel">
        发布您的创新定制（以下皆为必填信息）
    </div>
</div>
<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
        <table>
            <tr >
                <td>输入标题：</td>
                <td><input type="text" class="cmao_input reqTitle" onblur="biaoti()" /> 
                <span class="hide  red reqTitle_lable">请输入标题</span>
                </td>
            </tr>
            <tr>
                <td>所属分类：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <div class="dropdown-list hang0">
                        <div class="drop-list drop-list-min"  onblur="fenlei()"> 
                            <div class="checked"><a href="javascript:void(0);" ></a><span></span></div>
                        </div>
                        <input style="display:none" class="cx_addr_code">
                        <ul class="select select-min none h_one">
                        </ul>
                    </div>
                    <!-- 2 -->
                    <div class="dropdown-list hang1" style="display: none;margin-left: 50px;">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="h_checked"></a><span></span></div>
                        </div>
                        <ul class="select select-min none h_two">
                        </ul>
                    </div>
                   <!-- 3 -->
                    <div class="dropdown-list hang2" style="display: none;margin-left: 50px;">
                        <div class="drop-list drop-list-min">
                            <div class="checked"><a href="javascript:void(0);" class="h_checked1"></a><span></span></div>
                        </div>
                        <ul class="select select-min none h_three">
                        </ul>
                    </div>
                    <span class="hide red checked_a_lable" style="margin-left:80px">请选择分类</span>
                </td>
            </tr>
            <tr>
                <td valign="top">图片说明：</td>
                <td>

                    <div >
                        <div id="fileList" class="xf_repicleft">
                        </div>
                        <input id="Button1" type="button" value="" class="xf_repicture"/>
                    </div>

                </td>
            </tr>
            <tr>
                <td valign="top">&nbsp;</td>
                <td> 说明：此处的文件最好是清晰地扫描文件或照片文件，格式为JPG、PNG，大小不超过3M， 数量不超过4张
                </td>
            </tr>
            <tr>
                <td valign="top">文字描述：</td>
                <td><textarea placeholder="" cols="5" class="reqBrief" onblur="wenzimaishu()"></textarea>
                <span class="hide red reqBrief_lable">请输入文字描述</span> 
                </td>
            </tr>
            <tr>
                <td valign="top">其他附件：</td>
                <td id="enclosure" >
                           <form id="file_cont" action="file/publishNews" method="post" enctype="multipart/form-data"><div id=filespan noWrap style="height：20px;" >
                               <input onselectstart="return false" id="tf" onpaste="return false" class="input" size=30 type="file"  name="uploadFile" onkeydown="return false;"/>
                               <input style="margin-left:60px;margin-left:150px\9;" id=btnAdd onclick='additem("tb")' type=button value=添加上传项>
                               <p><table cellspacing="0" id="tb" style="width:400px"></table></p>
								<div class="clear"></div>
                           </div>
                           </form>
                </td>
                
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td> 您可以上传对您的创新定制有说明作用的文件，如图片，文本，压缩文件等；文件数量5个内，
                    单个文件大小不要超过10M.</td>
            </tr>
            <tr>
                <td>你的价格：</td>
                <td><input type="text" class="cmao_inplg cash" value=""  onblur="price()"/>&nbsp;请输入您愿意支付的费用，也可选择和服务单位商议
                <span class="hide red cash_lable">请输入价格</span>
                </td>
            </tr>
            <tr>
                <td>需求数量：</td>
                <td><input type="text" class="cmao_inplg xq_number" onkeyup="value=value.replace(/[^\d]/g,'') "onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onblur="nums()"/>&nbsp;&nbsp;
                	<select id="testSelect">
                		
                	</select>
                	<span class="hide red xq_number_lable">请输入数量</span>
                </td>
            </tr>
            <tr>
                <td>我的位置：</td>
                <td> <!-- 兼容浏览器的下拉选框-->
                    <input type="text" id="city" value="请选择地区" class="areainput" ReadOnly="true" onblur="address()" /><!--  -->
					<span class="hide red city_lable">请选择地址</span>
                </td>
            </tr>
            <tr>
                <td>真实姓名：</td>
                <td><input type="text" class="cmao_inplg realName" onblur="names()" />
                <span class="hide red realName_lable">请输入您的姓名</span>
                </td>
            </tr>
            <tr>
                <td>手机号码：</td>
                <td><input type="text" class="cmao_inplg tel" onblur="tel()"/>&nbsp;<a   class="btn btn-he btn-w120" type="button" onblur="tel()">获取验证码</a>
                <span class="hide red tel_lable">请输入手机号码</span>
                </td>
            </tr>
            <tr>
                <td>手机验证：</td>
                <td><input type="text" class="cmao_inplg tel_code" onblur="code()"/>
                <span class="hide red tel_code_lable">请输入验证码</span>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td align="left"><a  class="btn btn-he btn-w100" type="button" onclick="cx_save();">提交信息</a></td>
            </tr>
        </table>
    </div>


</div>




<!-- 底部-->
<div align="center">
    <script src="index_foot.js">

    </script>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/xiaofei_ajax/cx_fabu.js"></script>
<script src="${pageContext.request.contextPath}/js/uplo.js"></script>


<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    function hang1() {
        $("#hang1").show();
    }

    function hang2() {
        $("#hang2").show();
    }


    $(".areainput").click(function (e) {
        SelCity(this,e);
    });
	    var ok1=false;
	    var ok2=false;
	    var ok3=false;
	    var ok4=false;
	    var ok5=false;
	    var ok6=false;
	    var ok7=false;
	    var ok8=false;
	    var ok9=false;
   	//标题
    function biaoti(){
		 if($(".reqTitle").val()==null||$(".reqTitle").val()==""){
			 $(".reqTitle_lable").removeClass("hide");
		}else{
			 $(".reqTitle_lable").addClass("hide");
			ok1=true;
		}
    }
  	//所属分类
  	function fenlei(){
		if($(".hang0 .checked a").text()==null||$(".hang0 .checked a").text()==""){
			$(".checked_a_lable").removeClass("hide");
		}else{
			 $(".checked_a_lable").addClass("hide");
			ok2=true;
		}
	} 
	  //文字描述
	  function wenzimaishu(){
		  if($(".reqBrief").val()==null||$(".reqBrief").val()==""){
				$(".reqBrief_lable").removeClass("hide");
			}else{
				 $(".reqBrief_lable").addClass("hide");
				 ok3=true;
			}
	  }
	  //价格
	  function price(){
		  if($(".cash").val()==null||$(".cash").val()==""){
				$(".cash_lable").removeClass("hide");
			    $(".cash_lable").html("请输入价格");
			}else{
				 var decimalReg=/^\d{0,8}\.{0,1}(\d{1,2})?$/;//价格的正则表达式
	             if(decimalReg.test(($(".cash").val()))){
	                 $(".cash_lable").addClass("hide");
	               ok4=true;
	             }else{
	                $(".cash_lable").removeClass("hide");
	                $(".cash_lable").html("价格输入有误");
	             }
			}
	  }
	  //数量
	  function nums(){
		  if($(".xq_number").val()==null||$(".xq_number").val()==""){
				$(".xq_number_lable").removeClass("hide");
			}else{
				$(".xq_number_lable").addClass("hide");
				 ok5=true;
			}
	  }
	  //地址
	  function address(){
		  if($("#city").val()==null||$("#city").val()==""||$("#city").val()=="请选择地区"){
				$(".city_lable").removeClass("hide");
			}else{
				$(".city_lable").addClass("hide");
				ok6=true;
			}
	  }
	  //真实姓名
	  function names(){
		  if($(".realName").val()==null||$(".realName").val()==""){
				$(".realName_lable").removeClass("hide");
			    $(".realName_lable").html("请输入姓名");
			}else{
				var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
				 if(names.test(($(".realName").val()))){
	                 $(".realName_lable").addClass("hide");
	              ok7=true;
	             }else{
	                $(".realName_lable").removeClass("hide");
	              }
			}
	  }
	  //手机号
	  function tel(){
		  if($(".tel").val()==null||$(".tel").val()==""){
				$(".tel_lable").removeClass("hide");
				$(".tel_lable").html("请输入手机号");
			}else{
				var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
				 if(tel_zz.test(($(".tel").val()))){
	                $(".tel_lable").addClass("hide");
	               ok8=true;
	            }else{
	               $(".tel_lable").removeClass("hide");
	               $(".tel_lable").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
	           }
			}
	  }
	  //验证码
	  function code(){
		  if($(".tel_code").val()==null||$(".tel_code").val()==""){
				$(".tel_code_lable").removeClass("hide");
				$(".tel_code_lable").html("请输入验证码!");
			}else{
				if($(".tel_code").val()=="123456"){
					$(".tel_code_lable").addClass("hide");
					ok9=true;
				}else{
					$(".tel_code_lable").removeClass("hide"); 
					$(".tel_code_lable").html("验证码错误!");
				}
			}
	  }
	  
	  //提交按钮
	function cx_save(){
		
		 biaoti();
		fenlei();
		wenzimaishu();
		price();
		nums();
		address();
		names();
		tel();
		code();
		if(ok1&&ok2&&ok3&&ok4&&ok5&&ok6&&ok7&&ok8&&ok9){
			alert("验证通过！");
		}else{
			alert("验证失败");
		}
		
	}
	
</script>
<style>
</style>
</body>

</html>