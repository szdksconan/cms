<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/xiaofei_ajax/jPages.css">
    <script >
	    var context = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/echarts.js"></script>
    <script src="${pageContext.request.contextPath}/css/laydate/laydate.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/jPages.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/dizi.js"></script>
</head>
<body style="z-index: 0">
<!-- 新增地址弹出通用模态化窗口-->
<div class="motaisc modal fade" id="myModal1" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <p style="margin:-23px 0  0 20px;font-size: 14px;"><span style="font-size: 22px">新增配送地址</span><br/>

                    完成后，点击“新增此地址”按钮,以便新增新地址</p>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div  class="xf_tongjiy" style="padding: 20px 0 0 20px;min-height:300px;">
                    <table class=" fl" style="border: 0;background: transparent;font-size: 15px;">
                        <tbody>
                        <tr>
                            <td width="80" height="30">姓名：</td>
                            <td><input type="text" class="cmao_inplg user_input" value="" onblur="user_input()"/>
                            <span class="hide red user_input_lable">请输入姓名</span>
                            </td>
                        </tr>
                        <tr>
                            <td height="50">地区：</td>
                            <td><input type="text" id="city" value="请选择地区" class="areainput city_input" onblur="city_input()"/>
                            <span class="hide red city_input_lable">请选择地区</span>
                            </td>
                        </tr>

                        <tr>
                            <td height="50">街道地址：</td>
                            <td><input type="text" class="cmao_inplg jd_input" value="" onblur="jd_input()"/>
                            <span class="hide red jd_input_lable">街道地址不能为空</span>
                            </td>
                        </tr>

                        <tr>
                            <td height="40">邮政编码：</td>
                            <td><input type="text" class="cmao_inplg yznum" value="" onblur="yznum()"/>
                             <span class="hide red yznum_lable">请输入邮政编码</span>
                            </td>
                        </tr>
                        <tr>
                            <td height="20">&nbsp;</td>
                            <td>( 可能会印于标签上，便于交货 )</td>
                        </tr>
                        <tr>
                            <td height="40">联系电话：</td>
                            <td><input type="text" class="cmao_inplg tel_input" value="" onblur="tel_input()"/>
                            <span class="hide red tel_input_lable"></span>
                            </td>
                        </tr>
                        <tr >
                            <td height="30">&nbsp;</td>
                            <td><a  class="btn btn-he btn-w150 add_dz_btn" type="button" onclick="add_dz_btn()">新增此地址</a></td>
                        </tr>
                        </tbody>
                    </table>


                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

<!-- 修改地址弹出通用模态化窗口-->
<div class="motaisc modal fade update_model" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <p style="margin:-23px 0  0 20px;font-size: 14px;"><span style="font-size: 22px">修改配送地址</span><br/>

                    完成后，点击“修改此地址”按钮,以便修改新地址</p>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div  class="xf_tongjiy" style="padding: 20px 0 0 20px;min-height:300px;">
                    <table class=" fl" style="border: 0;background: transparent;font-size: 15px;">
                        <tbody>
                        <tr>
                            <td width="80" height="30">姓名：</td>
                            <td><input type="text" class="cmao_inplg user_input2" value="" onblur="user_input2()"/>
                            <span class="hide red user_input_lable2">请输入姓名</span>
                            </td>
                        </tr>
                        <tr>
                            <td height="50">地区：</td>
                            <td><input type="text" id="city" value="请选择地区" class="areainput city_input2" onblur="city_input2()"/>
                             <span class="hide red city_input_lable2">请选择地区</span>
                             </td>
                        </tr>

                        <tr>
                            <td height="50">街道地址：</td> 
                            <td><input type="text" class="cmao_inplg jd_input2" value=""  onblur="jd_input2()"/>
                            <span class="hide red jd_input_lable2">街道地址不能为空</span>
                            </td>
                        </tr>

                        <tr>
                            <td height="40">邮政编码：</td>
                            <td><input type="text" class="cmao_inplg yznum2" value="" onblur="yznum2()"/>
                             <span class="hide red yznum_lable2">请输入邮政编码</span>
                            </td>
                        </tr>

                        <tr>
                            <td height="20">&nbsp;</td>
                            <td>( 可能会印于标签上，便于交货 )</td>
                        </tr>
                        <tr>
                            <td height="40">联系电话：</td>
                            <td><input type="text" class="cmao_inplg tel_input2" value="" onblur="tel_input2()"/>
                            <span class="hide red tel_input_lable2"></span><input type="text" style="display: none;" class="id_input2">
                            </td>
                        </tr>
                        <tr >
                            <td height="30">&nbsp;</td>
                            <td><a  class="btn btn-he btn-w150 update_dz_btn" type="button" onclick="update_dz_btn();">修改此地址</a></td>
                        </tr>
                        </tbody>
                    </table>


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
<div class="xf_tsou"><a href="${pageContext.request.contextPath}/index.jsp" target="_self"><img src="${pageContext.request.contextPath}/images/logoin.jpg"></a>

    <div class="xf_tsouy">
        <span style="font-size: 22px;margin: 13px 0 0 -100px;display: inline-block;float: left;">地址管理</span>

    </div>

</div>
<!--   主要浮动菜单广告图-->
<div class="xf_cxd" style="height: 146px;border: 0;padding-top: 6px;z-index: 2;">
    <p  >
        <img src="${pageContext.request.contextPath}/images/geren/ge_1.jpg">
    </p>
</div>
<!-- 头像-->
<!--<div style="position: absolute;top:260px;left:20%; ">
    <img src="${pageContext.request.contextPath}/images/geren/ge_2.png"><br/> raoo
</div>-->
<!--  zhuyao主要-->
<div class="xf_thd">

    <div class="xf_tongjiz">
        <p class="ge_rentou"><img src="${pageContext.request.contextPath}/images/geren/ge_2.png"><br/>
            天涯客户111
        </p>
        <ul style="margin-top: 80px;">
            <Li><a href="${pageContext.request.contextPath}/f_w/note.jsp" target="_self">订单管理></a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/gouc.jsp" target="_self"> 我的购物车></a>
            </Li>
            <Li> <a href="${pageContext.request.contextPath}/f_w/kaidian.jsp" target="_self">创业申请></a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/dingzhi.jsp" target="_self">我的定制></a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/my_sou.jsp" target="_self">我的收藏></a>
            </Li>
            <Li class="active"><a href="${pageContext.request.contextPath}/f_w/dizi.jsp" target="_self">地址管理></a>
            </Li>
            <Li>
                <a href="${pageContext.request.contextPath}/f_w/my_message.jsp" target="_self">我的消息></a>
            </Li>
            <Li><%-- <a href="${pageContext.request.contextPath}/f_w/money.jsp" target="_self">资金管理></a> --%>
            </Li>
            <Li>
                <%-- <a href="${pageContext.request.contextPath}/f_w/zhanghu.jsp" target="_self">账户信息></a> --%>
            </Li>
            <Li><%-- <a href="${pageContext.request.contextPath}/f_w/tui.jsp" target="_self">退换货管理></a> --%>
            </Li>

        </ul>


    </div>
    <div class="xf_tongjiy ge_ren">
        <!--  2排序-->
        <div class="xf_getou">
            您录入的地址<br/>

            您想使用的是下方显示的地址吗？如果是，选择相应的地址。 或者您可以

            <a data-toggle="modal" data-target="#myModal1" style="font-weight: bold;cursor: pointer;">添加新地址</a>
        </div>

        <!-- 中间信息现况-->
        <div style="width: 100%;height: auto;display: inline-block;" class="addr_info_user" id="addr_info_user">
            <!-- 信息结尾-->
        </div>
        <!--  3-->
            <!-- <span class="xf_gerendi1" style="float: right">
                1/5&nbsp;
                <a class="btn btn-hu btn-w50" type="button"
                   style="width: 32px;height: 32px;padding: 4px 0 2px 0;background-color: #ffffff;border: 1px solid #dddddd;"><</a>
                <a class="btn btn-hu btn-w50" type="button" style="width: 32px;height: 32px;padding:4px 0 0 2px;"> ></a>
            </span> -->

    </div>
</div>


<div class="xf_thd">

    <!-- fenye分页-->
    <div class="xf_chatu" align="center">
        <div class="holder"></div>
    </div>
    <!---->
    <div class="xf_chatu">
        &nbsp;
    </div>
</div>
<!-- 底部-->
<div align="center">
    <script src="../index_foot.js">

    </script>
</div>

<script type="text/javascript">
    $(".areainput").click(function (e) {
        SelCity(this, e);
    });
</script>
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
<script type="text/javascript">
    function Goto() {
    }
    function deleteCurrentRow(obj) {
        var tr = obj.parentNode.parentNode;
        var tbody = tr.parentNode;
        tbody.removeChild(tr);
    }
</script>
<script>
    function delInput(that) {
        $(that).parent().parent().parent().remove();
    }


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
    
    /* var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    var ok5=false;
    //姓名
    function user_input(){
    	if($(".user_input").val()==null||$(".user_input").val()==""){
			$(".user_input_lable").removeClass("hide");
		    $(".user_input_lable").html("请输入姓名");
		    ok1=false;
		}else{
			var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
			 if(names.test(($(".user_input").val()))){
                 $(".user_input_lable").addClass("hide");
               ok1=true;
             }else{
                $(".user_input_lable").removeClass("hide");
                $(".user_input_lable").html("姓名输入有误");
                ok1=false;
              }
		}
    }
    //地区
    function city_input(){
    	 if($(".city_input").val()==null||$(".city_input").val()==""||$(".city_input").val()=="请选择地区"){
 			$(".city_input_lable").removeClass("hide");
 			 ok2=false;
 			}else{
 				$(".city_input_lable").addClass("hide");
 				ok2=true;
 			}
    }
    //街道地址
	function jd_input(){
		 if($(".jd_input").val()==null||$(".jd_input").val()==""){
			$(".jd_input_lable").removeClass("hide");
			 ok3=false;
			}else{
				$(".jd_input_lable").addClass("hide");
				ok3=true;
			}
	}
    //邮政编码
    function yznum(){
    	  if($(".yznum").val()==null||$(".yznum").val()==""){
				$(".yznum_lable").removeClass("hide");
			    $(".yznum_lable").html("请输入邮编");
			    ok4=false;
			}else{
				var yznums=  /^[1-9][0-9]{5}$/;
				 if(yznums.test(($(".yznum").val()))){
	                 $(".yznum_lable").addClass("hide");
	              ok4=true;
	             }else{
	                $(".yznum_lable").removeClass("hide");
	                $(".yznum_lable").html("邮编开头不能为0，共6位");
	                ok4=false;
	              }
			}
    }
    //电话号码
    function  tel_input(){
		  if($(".tel_input").val()==null||$(".tel_input").val()==""){
				$(".tel_input_lable").removeClass("hide");
				$(".tel_input_lable").html("请输入手机号");
				 ok5=false;
			}else{
				var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
				 if(tel_zz.test(($(".tel_input").val()))){
	                $(".tel_input_lable").addClass("hide");
	               ok5=true;
	            }else{
	               $(".tel_input_lable").removeClass("hide");
	               $(".tel_input_lable").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
	               ok5=false;
	           }
			}
	  }
    
    //新增地址
    function add_dz_btn(){
    	user_input();
    	city_input();
    	jd_input();
    	yznum();
    	tel_input();
    	if(ok1&&ok2&&ok3&&ok4&&ok5){
    		alert("通过");
    		//添加属性  data-dismiss="modal"  关闭弹窗 
    	  $(".add_dz_btn").attr("data-dismiss","modal"); 
    	}else{
    		//取消关闭弹窗
    		 $(".add_dz_btn").attr("data-dismiss","");    
    		alert("未通过");
    	}
    } */
    
   /*  var ok11=false;
    var ok12=false;
    var ok13=false;
    var ok14=false;
    var ok15=false;
  //姓名
    function user_input2(){
    	if($(".user_input2").val()==null||$(".user_input2").val()==""){
			$(".user_input_lable2").removeClass("hide");
		    $(".user_input_lable2").html("请输入姓名");
		    ok11=false;
		}else{
			var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
			 if(names.test(($(".user_input2").val()))){
                 $(".user_input_lable2").addClass("hide");
               ok11=true;
             }else{
                $(".user_input_lable2").removeClass("hide");
                $(".user_input_lable2").html("姓名输入有误");
                ok11=false;
              }
		}
    }
    //地区
    function city_input2(){
    	 if($(".city_input2").val()==null||$(".city_input2").val()==""||$(".city_input2").val()=="请选择地区"){
 			$(".city_input_lable2").removeClass("hide");
 			 ok12=false;
 			}else{
 				$(".city_input_lable2").addClass("hide");
 			ok12=true;
 			}
    }
    //街道地址
	function jd_input2(){
		 if($(".jd_input2").val()==null||$(".jd_input2").val()==""){
			$(".jd_input_lable2").removeClass("hide");
			 ok13=false;
			}else{
				$(".jd_input_lable2").addClass("hide");
				ok13=true;
			}
	}
    //邮政编码
    function yznum2(){
    	  if($(".yznum2").val()==null||$(".yznum2").val()==""){
				$(".yznum_lable2").removeClass("hide");
			    $(".yznum_lable2").html("请输入邮编");
			    ok14=false;
			}else{
				var yznums=  /^[1-9][0-9]{5}$/;
				 if(yznums.test(($(".yznum2").val()))){
	                 $(".yznum_lable2").addClass("hide");
	              ok14=true;
	             }else{
	                $(".yznum_lable2").removeClass("hide");
	                $(".yznum_lable2").html("邮编开头不能为0，共6位");
	                ok14=false;
	              }
			}
    }
    //电话号码
    function  tel_input2(){
		  if($(".tel_input2").val()==null||$(".tel_input2").val()==""){
				$(".tel_input_lable2").removeClass("hide");
				$(".tel_input_lable2").html("请输入手机号");
				 ok15=false;
			}else{
				var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
				 if(tel_zz.test(($(".tel_input2").val()))){
	                $(".tel_input_lable2").addClass("hide");
	               ok15=true;
	            }else{
	               $(".tel_input_lable2").removeClass("hide");
	               $(".tel_input_lable2").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
	               ok15=false;
	           }
			}
	  }
    //修改地址
    function update_dz_btn(){
    	user_input2();
    	city_input2();
    	jd_input2();
    	yznum2();
    	tel_input2();
      	if(ok11&&ok12&&ok13&&ok14&&ok15){
    		//添加属性  data-dismiss="modal"  关闭弹窗 
    	  //$(".update_dz_btn").attr("data-dismiss","modal"); 
    	}else{
    		//取消关闭弹窗
    		 $(".update_dz_btn").attr("data-dismiss","");    
    		alert("未通过");
    	}
    } */
    
</script>
<style>
    .xf_thd .xf_tongjiy .xf_gekaid p {
        line-height: 26px;
    }
    .xf_thd .xf_tongjiy .xf_gekaid {
        width: 310px;
        height: 190px;
        border: 1px solid #dddddd;
        display: inline-block;
        float: left;
        padding: 20px 10px 0 20px;
        font-size: 15px;
        margin: 20px 0 0 20px;
    }

    .table1 thead tr th {
        font-size: 12px;
        background-color: #f5f5f5;
        border: 0;
    }
</style>
</body>
</html>