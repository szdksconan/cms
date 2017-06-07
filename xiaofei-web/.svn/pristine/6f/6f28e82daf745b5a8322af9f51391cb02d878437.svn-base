/**
 * 其他附件
 */
var upload;
var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
    function fileChange(target,id) {
        var fileSize = 0;
        var filetypes =[".jpg",".png",".rar",".txt",".zip",".doc",".ppt",".xls",".pdf",".docx",".xlsx"];
        var filepath = target.value;
        var filemaxsize = 1024*10;//10M/*   1024*2 为2MB    1024*10 为10MB* 下面自动限制/
        if(filepath){
            var isnext = false;
            var fileend = filepath.substring(filepath.indexOf("."));
            if(filetypes && filetypes.length>0){
                for(var i =0; i<filetypes.length;i++){
                    if(filetypes[i]==fileend){
                        isnext = true;
                        break;
                    }
                }
            }
            if(!isnext){
                alert("不接受此文件类型！");
                target.value ="";
                return false;
            }
        }else{
            return false;
        }
        if (isIE && !target.files) {
            var filePath = target.value;
            var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
            if(!fileSystem.FileExists(filePath)){
                alert("附件不存在，请重新输入！");
                return false;
            }
            var file = fileSystem.GetFile (filePath);
            fileSize = file.Size;
        } else {
            fileSize = target.files[0].size;
        }

        var size = fileSize / 1024;
        if(size>filemaxsize){
            alert("附件大小不能大于"+filemaxsize/1024+"M！");
            target.value ="";
            return false;
        }
        if(size<=0){
            alert("附件大小不能为0M！");
            target.value ="";
            return false;
        }
    }
    /**
     * 浏览图片
     */
    $(function () {
        //var btn = $("#Button1");

        var btn = $("#Button1").uploadFile({
            url: context+"/file/fileAPreview?type=02&vive=1",
            fileSuffixs: ["jpg", "png", "gif"],
            maximumFilesUpload: 4,//最大文件上传数
            onComplete: function (msg) {
                $("#testdiv").append(msg + "<br/>");
            },
            onAllComplete: function () {
                //alert("全部上传完成");
            	//post('file/success_redirect',"");
            	window.location.href=context+"/index.jsp";
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

        upload = btn.data("uploadFileData");

        /*$("#files").click(function () {
            upload.submitUpload();
        });*/
    });
    /**
     * 添加选项上传文件
     */
  //全局变量，代表文件域的个数，并用该变量区分文件域的name属性
	  var file_count = 0;
	  //增加文件 域   
	  function additem(id) {
	  //定义行变量row；单元格变量cell；单元格内容变量str。
	  var row,cell,str;
	  //在指定id的table中插入一行
	  if(file_count<4){
		  row = eval("document.all["+'"'+id+'"'+"]").insertRow();
		  if(row != null ) {
		    //设置行的背景颜色
		    row.bgColor="white";
		    //在行中插入单元格
		    cell = row.insertCell();
		    //设置str的值，包括一个文件域和一个删除按钮
		    str='<input style="font-size:12px;margin-left:-20px;" onselectstart="return false" class="romtf" onpaste="return false" type="file"  name="uploadFile" onkeydown="return false;" />';
		    str += " <a style='float:right;margin-top:-15px;margin-top:10px\9;font-size:12px;margin-left:-80px;' href='javascript:void(0)'><i style='font-size:14px' class='fa fa-minus fa-lg rom'  onclick='deleteitem(this,"+'"'+"tb"+'"'+");'>删除</i></a>";
		    //文件域个数增加
		    file_count++;
		    
		    //设置单元格的innerHTML为str的内容
		    cell.innerHTML=str;
		  }
	  }else{
	    	return;
	}
	}
	   //删除文件域 
	   function deleteitem(obj,id) {
	     var rowNum,curRow;
	     curRow = obj.parentNode.parentNode;
	     rowNum = eval("document.all."+id).rows.length - 1;
	     if(file_count>0){
		     eval("document.all["+'"'+id+'"'+"]").deleteRow(curRow.rowIndex);
		     file_count--;
	     }else{
	    	 return;
	     }
	   }

    
    
$(document).ready(function() {
	$.ajax({
		url:context+"/tcbpc/test",
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_cms1_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$.each(data,function(i,n){
				$("<li><a href=\"javascript:void(0);\" onclick=\"hy_two('"+n.id+"');\">"+n.name+"</a></li>").appendTo(".h_one");
				$(".cx_addr_code").val(n.code);
			})
		}
	})
	unitsby();
})

function hy_two(id){
	$.ajax({
		url:context+"/tcbpc/test3?cms="+id,
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_cms2_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".h_two").html("");
			$(".h_checked").text("");
			$(".hang2").hide();
			$.each(data,function(i,n){
				$("<li><a href=\"javascript:void(0);\" onclick=\"hy_three('"+n.id+"');\">"+n.name+"</a></li>").appendTo(".h_two");
				$(".cx_addr_code").val(n.code);
				$(".hang1").show();
			})
		}
	})
}

function hy_three(id){
	$.ajax({
		url:context+"/tcbpc/test4?cms="+id,
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_cms3_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$(".h_three").html("");
			$(".h_checked1").html("");
			$.each(data,function(i,n){
				$("<li><a href=\"javascript:void(0);\">"+n.name+"</a></li>").appendTo(".h_three");
				$(".cx_addr_code").val(n.code);
				$(".hang2").show();
			})
		}
	})
}


function cx_save(){
	var reqTitle=$(".reqTitle").val();
	var reqBrief=$(".reqBrief").val();
	var realName=$(".realName").val();
	var reqNumber=$(".xq_number").val()+$('#testSelect option:selected') .val();
	var tel=$(".tel").val();
	var cash=$(".cash").val();
	var hcity = document.getElementById("hcity").getAttribute("data-id");//省代码
	var hproper = document.getElementById("hproper").getAttribute("data-id");//市代码
	var harea = document.getElementById("harea").getAttribute("data-id");//区县代码
	var provinceName = $("#hcity").val();
	var regionName = $("#hproper").val();
	var cityName = $("#harea").val();
	var loclName=provinceName+"-"+regionName+"-"+cityName;
	var attYn;
	var els=document.getElementsByName("uploadFile");
	for (var i = 0, j = els.length; i < j; i++){
		//alert(els[i].value);
		if(els[i].value!=""&&els[i].value!=null){
			//attYn=els[i].value;
			attYn="0";
		}else{
			attYn="1";
		}
	}
	var busiCode =$(".cx_addr_code").val();
	if(userid!=""){
		if(reqTitle!=""&&reqTitle!=null&&reqBrief!=""&&reqBrief!=null&&
		realName!=""&&realName!=null&&tel!=""&&tel!=null&&
		reqNumber!=""&&reqNumber!=null&&cash!=""&&cash!=null){
		//data-toggle="modal" data-target="#myModal"
			$.ajax({
				url:context+"/innovation/addCmsXReqRec",
				data:{reqTitle:reqTitle,reqBrief:reqBrief,realName:realName,
					tel:tel,attYn:attYn,userId:userid,reqNumber:reqNumber,cash:cash,loclName:loclName,
					loclCode:harea,busiCode:busiCode},
				dataType:"json",
				type:"post",
				success:function(data){
					upload.submitUpload();
					if(attYn=="0"){
						$("#myModal").modal();
						$("#file_cont").submit();
					}else{
						window.location.href=context+"/index.jsp";
					}
				}
			});
		}else{
			alert("完善信息");
		}
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

function unitsby(){
	$.ajax({
		url:context+"/tcbpc/unit",
		type:"get",
		async:false,
		contentType : "application/jsonp",
		dataType:"jsonp",
		jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
		jsonpCallback:"success_cms8_jsonpCallback",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
		success:function(data){
			$.each(data,function(i,n){
				$("<option value="+n.name+">"+n.name+"</option>").appendTo("#testSelect");
			})
		}
	})
}


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