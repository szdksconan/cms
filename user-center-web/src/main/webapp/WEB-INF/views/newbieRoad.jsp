<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>新手上路</title>
    <link href="${ctx}/css/NewbieRoad.css" rel="stylesheet"/>
    <!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
  <style>
  	body{background-color: #F6F6F6;}
  </style>  
  </head>
  <body>
    <!--
    	顶部logo
    -->
    	<div class="re-container">
    		<!--logo 图标-->
    	  <a href="${ctx}/index.html" target="_self"><img src="${ctx}/image/logo.png" alt="logo" class="login-logo"/></a>
    		<div class="login-title">新手上路</div>
    	</div>
    	<!--
        	主体模块
        -->
       <div class="re-container padding-b-20">
       	  <div class="newbiew-road">新手上路</div>
       	  <div class="new-msg">更多热门推荐，就在&nbsp;<a href="#" target="_blank">产贸送产贸平台</a></div>
       	  <div class="new-content">
	       	  <table class="new-table">
	       	  	<!--第一行tr -->
	       	  	<tr>
	       	  		<td>
	       	  			<div class="new-table-divone">
	       	  				<p class="margin-t-40">
	       	  					<img src="${ctx}/image/icon_zgys.png" />
	       	  					<span>找供应商</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-rline"></span>
	       	  			<span class="new-bline"></span>
	       	  		</td>
	       	  		<td>
	       	  			<div class="new-table-divone">
	       	  				<p class="margin-t-40">
	       	  					<img src="${ctx}/image/icon_qdjm.png" />
	       	  					<span>找渠道加盟</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-rline"></span>
	       	  			<span class="new-bline"></span>
	       	  		</td>
	       	  		<td>
	       	  			<div class="new-table-divone">
	       	  				<p class="margin-t-40">
	       	  					<img src="${ctx}/image/icon_wytb.png" />
	       	  					<span>我要投标</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-bline"></span>
	       	  		</td>
	       	  	</tr>
	       	  	<!--第二行tr -->
	       	  	<tr>
	       	  		<td>
	       	  			<div class="new-table-div">
	       	  				<p>
	       	  					<img src="${ctx}/image/icon_nyqy.png" />
	       	  					<span>拿样体验</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-rline"></span>
	       	  			<span class="new-bline"></span>
	       	  		</td>
	       	  		<td>
	       	  			<div class="new-table-div">
	       	  				<p>
	       	  					<img src="${ctx}/image/icon_zdg.png" />
	       	  					<span>找代工</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-rline"></span>
	       	  			<span class="new-bline"></span>
	       	  		</td>
	       	  		<td>
	       	  			<div class="new-table-div">
	       	  				<p>
	       	  					<img src="${ctx}/image/icon_zb.png" />
	       	  					<span>发招标</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-bline"></span>
	       	  		</td>
	       	  	</tr>
	       	  	<!--第三行tr -->
	       	  	<tr>
	       	  		<td>
	       	  			<div class="new-table-div">
	       	  				<p>
	       	  					<img src="${ctx}/image/icon_release_channel.png" />
	       	  					<span>发布渠道</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-rline"></span>
	       	  		</td>
	       	  		<td>
	       	  			<div class="new-table-div">
	       	  				<p>
	       	  					<img src="${ctx}/image/icon_ycl.png" />
	       	  					<span>找原料</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  			<span class="new-rline"></span>
	       	  		</td>
	       	  		<td>
	       	  			<div class="new-table-div">
	       	  				<p>
	       	  					<img src="${ctx}/image/icon_please_shop.png" />
	       	  					<span>发求购信息</span>
	       	  				</p>
	       	  				<p class="new_detail">使用强大的搜索功能，轻松从海量的供求信息中寻找优质的供应商</p>
	       	  				<p style="margin-bottom: 20px;"><input type="button" value="立即查找" class="new-btn"></p>
	       	  			</div>
	       	  		</td>
	       	  	</tr>
	       	  </table>
	       	</div>        	  
       </div>
        <!--
        	底部
        -->
        <div class="login-footer">          	
        	<div class="row">
        		<div class="col-lg-12">
		        	<ul class="register-footer-ul">
		        		<li class="login-right-line"><a href="javascript:;">关于产贸送</a></li>
		        		<li class="login-right-line"><a href="javascript:;">法律声明</a></li>
		        		<li class="login-right-line"><a href="javascript:;">加盟入驻</a></li>
		        		<li class="padding-l-10"><a href="javascript:;">帮助中心</a></li>
		        	</ul>
	        	</div>
        	</div>
        	<div class="row">
        		<div class="col-lg-12">
        	       <p>如有任何问题请拨打热线电话<span class="margin-l-30">24小时热线电话:400-800-2015-0586</span></p>
        	    </div>
        	</div>
        	<div class="row">
        		<div class="col-lg-12">
        	    <p>Copyright &copy; 2015 cmswl Inc.保留所有权。<span class="margin-l-30">新公安网备10000000586新ICP备</span></p>
        	  </div>
        	</div>       	
    	</div>	      	       
    <script src="${ctx}/js/jquery.1.11.3.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
  </body>
</html>
