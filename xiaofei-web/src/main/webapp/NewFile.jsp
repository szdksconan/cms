<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="js/jquery-1.7.2.min.js"></script>  
    <script src="js/uplo.js"></script>  
    <script>  
        $(function () {  
            //var btn = $("#Button1");  
  
            var btn = $("#Button1").uploadFile({  
                url: "file/fileAPreview?type=01&vive=1",  
                fileSuffixs: ["jpg", "png", "gif", "txt"],  
                maximumFilesUpload: 4,//最大文件上传数  
                onComplete: function (msg) {  
                    $("#testdiv").append(msg + "<br/>");  
                },  
                onAllComplete: function () {  
                    //alert("全部上传完成");  
                	//调用方法 如      
                    post('file/success_redirect',"");
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
  
            var upload = btn.data("uploadFileData");  
  
            $("#files").click(function () {  
                upload.submitUpload();  
            });  
        });
        
        
        function post(URL, PARAMS) {      
            var temp = document.createElement("form");      
            temp.action = URL;      
            temp.method = "post";      
            temp.style.display = "none";      
            for (var x in PARAMS) {      
                var opt = document.createElement("textarea");      
                opt.name = x;      
                opt.value = PARAMS[x];      
                // alert(opt.name)      
                temp.appendChild(opt);      
            }      
            document.body.appendChild(temp);      
            temp.submit();      
            return temp;      
        }      
             
        
    </script>  
  
</head>  
    <body>  
        <div >
            <div id="fileList" style=" width:auto;overflow: hidden;float: left;max-width:500px;">
            </div>
            <input id="Button1" type="button" value="选择文件" style="width: 110px;height: 145px;background-color: #dddddd;"/>
        </div>  <br><br><br>

		<a   class="btn btn-he btn-w100" type="button"  id="files">提交</a>
    </body>
    <script type="text/javascript"></script>  
</html>  