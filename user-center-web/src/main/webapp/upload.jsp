<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- production -->
<script type="text/javascript" src="${ctx}/js/jquery.1.11.3.min.js"></script>
<script type="text/javascript" src="${ctx}/js/plupload.full.min.js"></script>

<script type="text/javascript">
 	var path = "${ctx}";
 	$(document).ready(function(){
 		
 		var uploader = new plupload.Uploader({
 			runtimes : 'html5,flash,silverlight,html4',
 			browse_button : 'pickfiles', // you can pass an id...
 			container: document.getElementById('container'), // ... or DOM Element itself
 			url : path+'/login/upload',
 			flash_swf_url : path+'/js/Moxie.swf',
 			silverlight_xap_url : path+'/js/Moxie.xap',
 			
 			filters : {
 				max_file_size : '10mb',
 				mime_types: [
 					{title : "Image files", extensions : "jpg,gif,png"},
 					{title : "Zip files", extensions : "zip"}
 				]
 			},

 			init: {
 				PostInit: function() {
 					document.getElementById('filelist').innerHTML = '';

 					document.getElementById('uploadfiles').onclick = function() {
 						uploader.start();
 						return false;
 					};
 				},

 				FilesAdded: function(up, files) {
 					plupload.each(files, function(file) {
 						document.getElementById('filelist').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ') <b></b></div>';
 					});
 				},
 				FileUploaded:function(up, file, info){//上传完成后预览
 					
 			        var url = info.response;
 			        var str = '<img src="'+url+'" style="width:80px;height:80px;border:1px solid #666;margin:2px;"/><b></b>';
 			        $("#pre").append(str);
 			        
 			    },
 				UploadProgress: function(up, file) {
 					document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
 				},

 				Error: function(up, err) {
 					document.getElementById('console').appendChild(document.createTextNode("\nError #" + err.code + ": " + err.message));
 				}
 			}
 		});

 		uploader.init();
 		
 	});
 	
	
	
</script>

</head>
<body style="font: 13px Verdana; background: #eee; color: #333">

<h1>Custom example</h1>

<p>Shows you how to use the core plupload API.</p>

<div id="filelist">Your browser doesn't have Flash, Silverlight or HTML5 support.</div>
<br />
<div id="pre"></div>
<div id="container">
    <a id="pickfiles" href="javascript:;">[Select files]</a> 
    <a id="uploadfiles" href="javascript:;">[Upload files]</a>
</div>

<br />
<pre id="console"></pre>


</body>
</html>
