<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="com.cms.model.xiaofei.logon.CmsXSysUser" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产贸送消费应用平台</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script >
	    var context = "${pageContext.request.contextPath}";
	    var shopId="";
	    var PriceNum=0;
	    var shopNum="";
    </script>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/control.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/xiaofei_ajax/gouc_main.js"></script>
</head>
<body>





<!-- 新增模态化窗口-->
<div class="motaisc1 modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabe" aria-hidden="true">
    <div  class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <span class="xf_ms">新增收货地址</span>
                <button  type="button" class="close"
                         data-dismiss="modal" aria-hidden="true" >
                    &times;
                </button>
            </div>
            <div class="modal-body" >
                <div class="xf_ms1">
                    <table >
                        <tr>
                            <td ><a class="red" >*</a>收货人姓名：</td>
                            <td ><input type="text" id="sh_name" class="cmao_input" value="" onblur="sh_name()"/> 
                            <span class="red hide sh_name_lable">请输入姓名</span>
                            </td>
                        </tr>
                        <tr>
                            <td><a class="red" >*</a>联系电话：</td>
                            <td>
                                <input type="text" id="sh_tel" class="cmao_input" value="" onblur="sh_tel()"/>
                                <span class="red hide sh_tel_lable">请输入顶手机号码</span>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top"><a class="red" >*</a>所在地区：</td>
                            <td>
                                <input type="text" id="city" value="请选择地区" class="areainput citys" onblur="citys()" />
                                <span class="red hide citys_lable">请选择地区</span>
                            </td>
                        </tr>
                        <tr>
                            <td valign="top">详细地址：</td>
                            <td><textarea placeholder="" id="sh_address" cols="5" onblur="sh_address()"></textarea>
                            <span class="red hide sh_address_lable">请输入详细地址</span>
                             </td>
                        </tr>
                        <tr>
                            <td >邮政编码：</td>
                            <td>
                                <input type="text" id="sh_code" class="cmao_input" value="" onblur="sh_code()"/>
                                <span class="red hide sh_code_lable">请输入邮编</span>
                            </td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td> <input type="checkbox" name="checkbox"  />&nbsp;设为默认</td>
                        </tr>

                    </table>
                      <P class="h_line"></P>
                    <p align="center"><a onclick="address_bc()"  class="btn btn-he btn-w100 address_bc_btn" type="button"  >保存</a>&nbsp;<a   class="btn btn-hu btn-w100" type="button" >取消</a></p>
                </div>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<!--消费顶部-->
<!-- <div align="center" >
    <script src="index_head.js">

    </script>
</div> -->
<%@ include file="comm/cms_head.jsp" %>

<div class="xf_thd">
    <img src="${pageContext.request.contextPath}/images/gouc_3.jpg" usemap="#Map">
    <map name="Map">
      <area shape="rect" coords="42,44,224,87" href="${pageContext.request.contextPath}/index.jsp" target="_self">
    </map>

</div>
<div class="xf_thd">
    <div class="xf_cxlabel1" >
        <i class="fa fa-caret-right"></i>&nbsp;检查核对您选购的商品
    </div>
    <table class="table1 mt10" style="font-size: 15px">
        
         <c:forEach items="${list}" var="list">
         <script >
         shopId+="${list.productId}"+",";
         PriceNum+=parseInt("${list.productPrice}")*parseInt("${list.unit}");
         shopNum+=parseInt("${list.unit}")+",";
         
         </script>
          <tbody>
        
           <tr>
            <td width="12%" > <img src="${list.productMainImg}" width="106" height="106"></td>
             <td width="37%"> 
                 <div> 
                     <p><a class="red" >${list.productNameCn}</a>&nbsp;</p>
                    <p>${list.enterpriceName}</p>
                     <p><img src="../images/b.png"> 高新区-都会路-1008号 &nbsp;<img src="../images/b1.png">1小时前</p> 
                 </div> 
             </td> 
             <td width="24%" > 
                 <div> 
                     <p>颜色：玫瑰红</p> 
                     <p>尺码：1.75</p> 

                 </div> 
            </td> 
            <td width="14%"><span class="red">¥</span>${list.productPrice}</td>

             <td width="13%" >数量：${list.unit}<br/> <a href="javascript:void(0);"><!-- 修改 --><br/> 
             </a></td> 
         </tr> 
        </tbody>
           </c:forEach> 
           
           
        <%-- <tbody>
           <tr>
            <td width="12%" > <img src="${product.productMainImg}" width="106" height="106"></td>
             <td width="37%"> 
                 <div> 
                     <p><a class="red" >${product.productNameCn}</a>&nbsp;</p>
                    <p>${product.enterpriceName}</p>
                     <p><img src="../images/b.png"> 高新区-都会路-1008号 &nbsp;<img src="../images/b1.png">1小时前</p> 
                 </div> 
             </td> 
             <td width="24%" > 
                 <div> 
                     <p>颜色：玫瑰红</p> 
                     <p>尺码：1.75</p> 
                 </div> 
            </td> 
            <td width="14%"><span class="red">¥</span>${product.productPrice}</td>
            <td width="13%" >数量：1<br/> <a href="javascript:void(0);"><!-- 修改 --><br/> 
            </a></td> 
         </tr> 
        </tbody> --%>
        
        
        
        
        
    </table>
</div>

<!--  信息验证-->
<div class="xf_thd">
    <div class="xf_cxyanz">
        <table >
            <tr>
                <td >请选择配送地址 <a data-toggle="modal" data-target="#myModal" class="btn btn-he btn-w100 dztc_btn" type="button" >添加新地址</a></td>
            </tr>

            <tr>
                <td valign="top" class="cout_by">
                    <!-- <div class="xf_gouy1f">
                      <p>xuyue</p>
                        <p>四川 成都市  青羊区<br/>新学年桥南街6号潮阳花园</p>
                        <p>邮编：610000</p>
                        <p align="right"><a class="orange"> 修改</a></p>
                    </div>
                    <div class="xf_gouy1">
                        <p>xuyue</p>
                        <p>四川 成都市  青羊区<br/>新学年桥南街6号潮阳花园</p>
                        <p>邮编：610000</p>
                        <p align="right"><a class="orange"> 修改</a></p>
                    </div>
                    <div class="xf_gouy1">
                        <p>联系人：xuyue</p>
                        <p>联系方式：028-963582</p>
                        <p>
                        <P>地址：四川 成都市  青羊区</P>
                            <p>新学年桥南街6号潮阳花园</p>
                        </p>
                        <p>邮编：610000</p>
                        <p align="right"><a class="orange"> 修改</a></p>
                    </div>
                    <div class="xf_gouy1">
                        <p>xuyue</p>
                        <p>四川 成都市  青羊区<br/>新学年桥南街6号潮阳花园</p>
                        <p>邮编：610000</p>
                        <p align="right"><a class="orange"> 修改</a></p>
                    </div> -->

                </td>
            </tr>
            <tr>
                <td valign="top" style="font-size: 22px"><i class="fa fa-caret-right"></i>&nbsp;请选择支付方式 </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="xf_gouy3" >
                        <p>货到付款</p>
                    </div>
                    <div class="xf_gouy3">
                        <p>在线支付</p>
                    </div>

                </td>
            </tr>
            <%-- <tr>
                <td valign="top">请选择支付方式 </td>
            </tr>
            <tr>
            <td valign="top">
                <div class="xf_gwzi">&nbsp;<input type="radio" name="radio" id="radio" value="radio" />产贸送余额   产贸送自己的支付平台</div>
            </td>
           </tr>
            <tr>
                <td valign="middle">
                   <span class="xf_gouy3"><input type="radio" name="radio" id="radio" value="radio" />平台支付</span> <img src="${pageContext.request.contextPath}/images/gouwu/gouc_3.jpg">
                </td>
            </tr>
            <tr>
                <td valign="top">
                    <div class="xf_gwzi">&nbsp; <input type="radio" name="radio" id="radio" value="radio" />银行卡支付 <span><a  class="btn btn-he btn-w100" type="button" >快捷</a></span>无需跳转网银，银行预留手机短信验证进行支付</div>
                </td>
            </tr> --%>


        </table>
    </div>
</div>

<!-- 结算-->
<div class="xf_thd">
    <div class="xf_cxlabel">
        <span>商品：<a id="PriceNum" class=" red" ></a></span>
        <span>配送和服务：<a class=" red" >¥0</a></span>
        <span style="text-align: right">总计：<a id="shoppingPriceNum" class=" red" >${product.productPrice}</a></span>
        <span><a  onclick="getshoppingdata()" target="_self" class="btn btn-he btn-w100" type="button" >提交订单</a></span><!-- href="gouc_z.jsp" -->
    </div>
</div>

<p>&nbsp;</p>
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
<script src="${pageContext.request.contextPath}/js/Popt.js"></script>
<script src="${pageContext.request.contextPath}/js/cityJson.js"></script>
<script src="${pageContext.request.contextPath}/js/citySet.js"></script>
</body>
<style>
    .xf_gouy3{width: 120px;height: 50px;border: 1px solid #dddddd;padding: 13px 0 0 30px;cursor: pointer;}
    .xf_gouy3.active{width: 120px;height: 50px;border: 1px solid #dddddd;padding: 13px 0 0 30px;background:url(images/gouwu/vb_1.jpg)  no-repeat;cursor: pointer;}
    .table1{border: 0}
    .table1 tbody tr td{border-bottom: 1px dashed #dddddd}
</style>
<script>
	


    function kong() {
        $(".xf_ms1 input").val("");
    }


    $(".xf_gouy3").click(function(){
        $(".xf_gouy3").removeClass("active");
        $(this).addClass("active");
    });
   /*  $(".xf_gouy1,.xf_gouy1f").click(function(){
            $(".xf_gouy1,.xf_gouy1f").removeClass("xf_gouy1f").addClass("xf_gouy1");
            $(this).removeClass("xf_gouy1").addClass("xf_gouy1f");
    }); */

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
    
  
    //点击新增收货地址
   	 $(".dztc_btn").click(function(){
   		 $(".xf_ms").html("添加新地址");
   		 //清空输入框
   		 $(".xf_ms1 input,.xf_ms1 textarea").val("");
   	 });
   	 var ok1=false;
     var ok2=false;
     var ok3=false;
     var ok4=false;
     var ok5=false;
    //姓名
 	function sh_name(){
 		if($("#sh_name").val()==null||$("#sh_name").val()==""){
			$(".sh_name_lable").removeClass("hide");
		    $(".sh_name_lable").html("请输入姓名");
		    ok1=false;
		}else{
			var names=/^[\u4e00-\u9fa5]{2,4}$|^[a-zA-Z]{1,30}$/gi;
			 if(names.test(($("#sh_name").val()))){
                 $(".sh_name_lable").addClass("hide");
               ok1=true;
             }else{
                $(".sh_name_lable").removeClass("hide");
                $(".sh_name_lable").html("姓名输入有误");
                ok1=false;
              }
		}
 	}
    //联系电话
    function sh_tel(){
    	if($("#sh_tel").val()==null||$("#sh_tel").val()==""){
			$(".sh_tel_lable").removeClass("hide");
			$(".sh_tel_lable").html("请输入手机号");
			 ok2=false;
		}else{
			var tel_zz=/^1[3|4|5|7|8]\d{9}$/;
			 if(tel_zz.test(($("#sh_tel").val()))){
                $(".sh_tel_lable").addClass("hide");
               ok2=true;
            }else{
               $(".sh_tel_lable").removeClass("hide");
               $(".sh_tel_lable").html("手机号只能以13/14/15/17/18开头的11位数字组成!");
               ok2=false;
           }
		}
    }
    //地址
     function citys(){
    	 if($(".citys").val()==null||$(".citys").val()==""||$(".citys").val()=="请选择地区"){
 			$(".citys_lable").removeClass("hide");
 			 ok3=false;
 			}else{
 				$(".citys_lable").addClass("hide");
 			ok3=true;
 			}
    }
     //详细地址
 	function sh_address(){
 		 if($("#sh_address").val()==null||$("#sh_address").val()==""){
 			$(".sh_address_lable").removeClass("hide");
 			 ok4=false;
 			}else{
 				$(".sh_address_lable").addClass("hide");
 			ok4=true;
 			}
 	}
     //邮政编码
     function sh_code(){
     	  if($("#sh_code").val()==null||$("#sh_code").val()==""){
 				$(".sh_code_lable").removeClass("hide");
 			    $(".sh_code_lable").html("请输入邮编");
 			    ok5=false;
 			}else{
 				var yznums=  /^[1-9][0-9]{5}$/;
 				 if(yznums.test(($("#sh_code").val()))){
 	                 $(".sh_code_lable").addClass("hide");
 	              ok5=true;
 	             }else{
 	                $(".sh_code_lable").removeClass("hide");
 	                $(".sh_code_lable").html("邮编开头不能为0，共6位");
 	                ok5=false;
 	              }
 			}
     }
    //点击保存
    function address_bc(){
    	//清空提示
    	$("#myModal [class$='lable']").addClass("hide");
    	sh_name();
    	sh_tel();
    	citys();
    	sh_address();
    	sh_code();
    	if(ok1&&ok2&&ok3&&ok4&&ok5){//通过验证
    	    if($("#myModal .xf_ms").html()=="添加新地址"){
    	    	address_add();
    	  	}else{//修改
    		 //后台操作待续
    	  }
    		//添加弹窗关闭属性
    	    $(".address_bc_btn").attr("data-dismiss","modal");
    	}else{
    		alert("未通过");
    		//取消弹窗关闭属性
    		$(".address_bc_btn").attr("data-dismiss",""); 
    	}
    	
   }

</script>

</html>