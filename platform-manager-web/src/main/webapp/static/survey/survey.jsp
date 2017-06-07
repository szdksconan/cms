<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no,traget-densitydpi=medium-dpi">
<title>问卷调查</title>
<link href="css/common.css" rel="stylesheet" type="text/css">
<script src="javascript/jquery-1.8.3.js"></script>

</head>

<body>
	<header>
		<!-- <h3>问卷调查</h3> -->
		<!-- <p></p> -->
		<h3></h3>
		<p id="p1" align="right"></p>
		<p id="p2"></p>
	</header>
	<section id="surveList">
	</section>
	<input type="button" class="surveBtn" value="提交"/>
	
</body>
<script src="javascript/common.js"></script>

<script>
var oJson=getArgs();
var researchId = oJson.researchId;	//问卷ID
var communityId = oJson.communityId;	//社区ID
var userId = oJson.userId;  //用户ID
var roomId = oJson.roomId;  //用户ID
var answer = [];   //存 答案集合
//researchId = '1';
//communityId = '1';	//社区ID
//userId = 'd000fbac-df73-4453-8c3e-7729cc8fdbb3';  //用户ID
//roomId = 'EASJHLuSbAD4STmnL1csRmW1ZJAEASJHAjYEASDH';  //用户ID

researchExam(researchId);

</script>
</html>
