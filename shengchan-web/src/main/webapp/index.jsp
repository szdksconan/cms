<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
	<link rel="stylesheet" type="text/css" href="css/common/bootstrap-multiselect.css">
	<link rel="stylesheet" type="text/css" href="css/canmaosongptai.css">
    <link rel="stylesheet" type="text/css" href="css/common/bootstrap-table.css">
    <link rel="stylesheet" type="text/css" href="css/common/bootstrap-dialog.css">
    <link rel="stylesheet" type="text/css" href="css/shenchan.css">
    <script src="js/common/common.js"></script>
    <script src="js/common/jquery.js"></script>
    <script src="js/common/control.js"></script>
    <script src="js/common/headsc.js">   </script>
	<script src="js/common/bootstrap.min.js"></script>
	<script src="js/common/bootstrap-multiselect.js"></script>
    <script src="js/common/bootstrap-table.js"></script>
    <script src="js/common/bootstrap-table-zh-CN.js"></script>
    <script src="js/common/bootstrap-dialog.js"></script>
    <script src="js/common/jquery.validate.js"></script>
<!--      <script src="js/common/jquery.metadata.js"></script> -->
<head>
    <title>生产应用平台</title>
</head>
<body >
<div class="cmaosc_caidan" id="header">
</div>
<div class="cmao_cont" >
    <div class="cmao_daohang">
        <div class="cmao_daoleft">
            <!-- 左侧菜单-->
            <div class="cmao_menu" id="left">

            </div>
        </div>
        <div class="cmao_daoright">
            <div class="camo_rightbar" id="center" >
            </div>
        </div>
    </div>
</div>
<!--左侧推拉图标-->
<a href="javascript:;" class="hn_1">
    <img src="images/you_1.jpg">
</a>

</body>
</html>

	<script type="text/javascript">
		$(function(){
			$('#header').load('index/header');
			$('#left').load('index/left?menuId=1');
			$('#center').load('index/center');
			
		});


</script>

