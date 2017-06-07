var upload;
function shopInfo() {
	$.ajax({
		url : "open/addCmsXShopApply",
		data : $("#shop_info").serialize(),
		dataType : "json",
		type : "post",
		success : function(data) {
			upload.submitUpload();
		}
	});
}
$(function() {
	var btn = $("#Button1").uploadFile({
		url : "open/upload",
		fileSuffixs : [ "jpg", "png", "gif" ],
		maximumFilesUpload : 4,// 最大文件上传数
		onComplete : function(msg) {
			$("#testdiv").append(msg + "<br/>");
		},
		onAllComplete : function() {
			alert("全部上传完成");
		},
		isGetFileSize : true,// 是否获取上传文件大小，设置此项为true时，将在onChosen回调中返回文件fileSize和获取大小时的错误提示文本errorText
		onChosen : function(file, obj, fileSize, errorText) {
			if (!errorText) {
				$("#file_size").text(file + "文件大小为：" + fileSize + "KB");
			} else {
				alert(errorText);
				return false;
			}
			return true;// 返回false将取消当前选择的文件
		},
		perviewElementId : "fileList", // 设置预览图片的元素id
		perviewImgStyle : {
			width : '110px',
			height : '145px',
			border : '1px solid #ebebeb'
		}
	// 设置预览图片的样式
	});

	upload = btn.data("uploadFileData");

	/*
	 * $("#files").click(function () { upload.submitUpload(); });
	 */
});