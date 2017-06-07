<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page language="java" import="com.cms.util.CmsUtil" %> 
    <%
  String name="";
     name=CmsUtil.CheckLogin(request);
  %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>产贸送消费应用平台</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cmaoxiaofei.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/xiaofei.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script >
	    var context = "${pageContext.request.contextPath}";
	    var userid="<%=name%>";
    </script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/md5.js"></script>
    <script src="${pageContext.request.contextPath}/js/login.js"></script>
    <script src="${pageContext.request.contextPath}/js/logionComm.js"></script>
    <style>
    .xf_goudengs{width: 100%;min-height: 550px;background: url('../images/login_bg.png') no-repeat top center;border:1px solid #febf00;background-color: #febf00;}
    .regist_table{width:600px;height:auto;float:left;}
    .regist_table tr td{height:60px;}
    .regist_table tr td input{float:left;height: 35px;border-radius: 0;margin-top:12px;border:none;border:1px solid #ddd;}
    .regist_table tr td label{float:left;}
    .regist_table_td1{width:90px;text-align:right;font-size:1.2em;font-weight:600; padding-right:10px;padding-top:10px;}
    .regist_table_td2{width:310px;}
    .regist_table_td3{text-align:left;width:190px;color:orange;padding-right:5px;}  
    
    </style>
</head>
<body style="overflow-x:hidden; ">
<!--消费顶部-->
<div class="xf_thd">
    <p style="height:100px; ">
        <a href="${pageContext.request.contextPath}/index.jsp"  target="_self"> <img src="${pageContext.request.contextPath}/images/gouwu/deng_logo.jpg"   ></a>
    </p>
</div>
<!-- 消费顶部菜单-->
    <div  class="xf_goudengs">
    	<div style="width:600px;height:auto;flaot:left;margin:20px 5% 0px auto;background-color:#fff;border:1px solid #ddd;overflow: hidden;">
    		<div style="height:50px;float:left;width:100%;line-height:60px;">
                <h2 style="font-size:2em;float:left;margin-left:30px;line-height:50px;">注册</h2>
               	<a  id="login_1" href="gouc_login.jsp" target="_self" style="float:right; margin-right:50px;font-size:1em;color:rgb(251,135,60);">立即登录<span>-&gt;</span></a>
               		
               		<%--  <span>
               	 		<img style=" margin-top: 2.4px;" src="${pageContext.request.contextPath}/images/gouwu/deng_l3.jpg"> 
                	</span> --%>
               
            </div>
           <hr style="width:100%;color:#333;"/>
    		<table class="regist_table" >
    		<!-- <tr>
    			<td colspan="3"> </td>
    		</tr> -->
    			<tr>
    				<td class="regist_table_td1">手机号码</td>
    				<td class="regist_table_td2">
    					
    					<input type="text" id="mobile" name="mobile" class="text " value="请输入手机号码" tabindex="10"  style="width: 308px;"/>
	                
	                </td>
	                <td class="regist_table_td3">
	                  <span id="mobile_succeed" class="blank"></span>
	                  <span class="clear"></span>
	                  <span id="mobile_error"></span>
	                </td>
    			</tr>
    			<tr>
    				<td class="regist_table_td1">动态验证</td>
    				<td class="regist_table_td2"> 
    					<input type="text" id="authcode" name="authcode" class="text" autocomplete="off" MaxLength="6" tabindex="6" value="请输入验证码"  style="width:130px;"/>
    					<label class="img" style="margin-top:16px;margin-left:10px;"><img id="check_img" Ver_ColorOfNoisePoint="#888888"  onClick="upcode()" alt="" style="cursor:pointer;width:100px;height:26px;"/></label>
                        <label onClick="upcode()" style="margin-top:20px;">&nbsp;点击更换</label>
                    </td>
    				<td class="regist_table_td3">
                        <span id="authcode_succeed" class="blank invisible"></span>
                        <span class="clear"></span>
                        <span id="authcode_error"></span>
                     </td>
    			</tr>
    			<tr>
    			</tr>
    				<td class="regist_table_td1">设登录名</td>
    				<td class="regist_table_td2"><input type="text" id="username" name="username" class="text" tabindex="1" value="请输入4-20位字母和数字组合的用户名"  style="width: 308px;"/></td>
    				<td class="regist_table_td3">
    					<span id="username_succeed" class="blank "></span>
                        <span class="clear"></span>
                        <span id="username_error"></span>
                    </td>
    			</tr>
    			</tr>
    				<td class="regist_table_td1">设置密码</td>
    				<td class="regist_table_td2"><input type="password" id="pwd" name="pwd" class="text" tabindex="2" value="请输入密码23"  style="width: 308px;height: 35px;border-radius: 0;"/></td>
    				<td class="regist_table_td3">
    					 <span id="pwd_succeed" class="blank"></span>
                         <span class="clear"></span>
                         <span class="hide" id="pwdstrength"><span class="fl">安全程度：</span></span>
                         <span id="pwd_error"></span>
                    </td>
    			</tr>
    			</tr>
    				<td class="regist_table_td1">确认密码</td>
    				<td class="regist_table_td2"> <input type="password" id="pwd2" name="pwd2" class="text" tabindex="3" value="请再次输入密码"  style="width: 308px;"/></td>
    				<td class="regist_table_td3">
    					<span id="pwd2_succeed" class="blank"></span>
                        <span class="clear"></span>
                        <span id="pwd2_error"></span>
                    </td>
    			</tr>
    			<tr>
    				<td></td>
    				<td>
    				    <a href="javascript:void(0);" onClick="login()" target="_self" > 
		                    <img  onmousemove="this.src='${pageContext.request.contextPath}/images/gouwu/zce1.jpg'" onmouseout="this.src='${pageContext.request.contextPath}/images/gouwu/zce.jpg'"src="${pageContext.request.contextPath}/images/gouwu/zce.jpg">
		                 </a>
    				</td>
    			</tr>
    			<tr>
    				<td></td>
    				<td>
    				 	<P style="width: 300px;margin-top: -15px;margin-top: -13px\9;font-size: 13px;">注册本网站即表明您同意我们的使用和销售条款条件及 隐私声明</P>
    				</td>
    			</tr>
    		</table>
    	</div>




       <%--  <div class="xf_goud1">
            <div class="xf_login">
                                            注册
                <span style="margin-left:218px;font-size: 14px;"><a  id="login_1" href="gouc_login.jsp" target="_self" style="color:#fa873b;">立即登录</a><span><img style=" margin-top: 2.4px;" src="${pageContext.request.contextPath}/images/gouwu/deng_l3.jpg"> </span></span>
            </div>
        <div id="formbox" style="position:relative;top:35px;left:752px;margin-left: -7px;">
            <div class="form">

                <div class="item">
                    <div class="fl">
                        <input type="text" id="mobile" name="mobile" class="text " value="请输入手机号码" tabindex="10"  style="width: 308px;height: 35px;border-radius: 0;"/>
                        <label id="mobile_succeed" class="blank"></label>
                        <span class="clear"></span>
                        <label id="mobile_error"></label>
                    </div>
                </div><!--item end-->
                <div class="item">

                    <div class="fl">
                        <input type="text" id="authcode" name="authcode" class="text text-1" autocomplete="off" MaxLength="6" tabindex="6" value="请输入验证码"  style="width:120px;height: 35px;border-radius: 0;"/><!--  text-1 -->
                        <label class="img"><img id="check_img" Ver_ColorOfNoisePoint="#888888"  onClick="upcode()" alt="" style="cursor:pointer;width:100px;height:26px;"/>
                        </label>
                        <label onClick="upcode()">&nbsp;点击更换</label>
                        <label id="authcode_succeed" class="blank invisible"></label>
                        <span class="clear"></span>
                        <label id="authcode_error"></label>
                    </div>
                </div><!--item end-->
                <div class="item">

                    <div class="fl" style="font-size: 14px">
                        <input type="text" id="username" name="username" class="text" tabindex="1" value="请输入4-20位字母和数字组合的用户名"  style="width: 308px;height: 35px;border-radius: 0;"/>
                        <label id="username_succeed" class="blank "></label>
                        <span class="clear"></span>
                        <div id="username_error"></div>
                    </div>
                </div><!--item end-->
                <div id="o-password">
                    <div class="item">

                        <div class="fl">
                            <input type="password" id="pwd" name="pwd" class="text" tabindex="2" value="请输入密码23"  style="width: 308px;height: 35px;border-radius: 0;"/>
                            <label id="pwd_succeed" class="blank"></label>

                            <span class="clear"></span>
                            <label class="hide" id="pwdstrength"><span class="fl">安全程度：</span><b></b></label>
                            <label id="pwd_error"></label>
                        </div>
                    </div><!--item end-->

                    <div class="item">

                        <div class="fl">
                            <input type="password" id="pwd2" name="pwd2" class="text" tabindex="3" value="请再次输入密码"  style="width: 308px;height: 35px;border-radius: 0;"/>
                            <label id="pwd2_succeed" class="blank"></label>
                            <span class="clear"></span>
                            <label id="pwd2_error"></label>
                        </div>
                    </div><!--item end-->

                </div><!--o-password end-->

                <div class="item">
                    <!-- href="gouc_loginsc.jsp" --><a href="javascript:void(0);" onClick="login()" target="_self"> <img  onmousemove="this.src='${pageContext.request.contextPath}/images/gouwu/zce1.jpg'" onmouseout="this.src='${pageContext.request.contextPath}/images/gouwu/zce.jpg'"src="${pageContext.request.contextPath}/images/gouwu/zce.jpg"></a>
                </div>
                 <P style="width: 300px;margin-top: -15px;margin-top: -13px\9;font-size: 13px;">注册本网站即表明您同意我们的使用和销售条款

                     条件及 隐私声明</P>

            </div>
        </div>
    </div> --%>


</div>


<div align="center" >
    <script src="${pageContext.request.contextPath}/js/index_foot.js"></script>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Validate.form.js"></script>
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
</body>
</html>