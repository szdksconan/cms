//多张图片上传预览
jQuery.fn.extend({
    uploadPreview: function (opts) {
        opts = jQuery.extend({
        	fileName : 'inputfilename', //file的name
            fileId : 'fileId',			//file的id
            ListId: "#List",		//包含图片li的容器ul的id
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"], //限制上传图片的格式
            isInput : false,			//是否需要input
            inputName : "inputname",	//input的name
            Callback: function () {}
        }, opts || {});
        var i = 0,_this = $(this),inputhtml="";
        _this.on('click',function(){
        	inputhtml = '<input type="file" style="display: none;" onchange="filechange(this)" id="'+opts.fileId+i+'" name="'+opts.fileName+'"/>';
			$(opts.ListId).append(inputhtml);
			$('#'+opts.fileId+i).data("opts",opts);
			$('#'+opts.fileId+i).trigger("click");
			i++;
        });
        var _self = $('#'+opts.fileId+i);
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file);
//                console.info(url);
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        };
        filechange = function(e){
        	var html = "";
			var _this = $(e);
			var _opts=_this.data('opts');
			var fileid = $(e).attr("id");
			var uploadList = $(_opts.ListId);
            if (_this.val()!=null) {
                if (!RegExp("\.(" + _opts.ImgType.join("|") + ")$", "i").test(e.value.toLowerCase())) {
                    msg({texts:"选择文件错误,图片类型必须是" + _opts.ImgType.join("，") + "中的一种"});
                    e.value = "";
                    return false;
                }
                if ($.browser.msie) {
                    try {
                    	html += '<li onmouseleave="moveOut(this)">';
                    	html += '	<div class="upload-content">';
						html += '		<div class="file-panel"><span class="cancel" onclick="delImg('+fileid+',this)"></span></div>';
						html += '		<img src='+_self.getObjectURL(e.files[0])+' onmouseover="moveUp(this)" class="list-img">';
						html +='	</div>';
						if(_opts.isInput){
							var inpu = '<input type="text" class="file-input" name="'+_opts.inputName+'" placeholder="请输入名称"/>';
							html += inpu;
						}
						html +='</li>';
                    } catch (e) {
                        var src = "";
                        var obj = $(".list-img");
                        var li = obj.parent("li")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus();
                        } else {
                            _self.blur();
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("li").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': _opts.Width + 'px',
                            'height': _opts.Height + 'px'
                        });
                        li.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                    }
                } else {
					html += '<li onmouseleave="moveOut(this)">';
                	html += '	<div class="upload-content">';
					html += '		<div class="file-panel"><span class="cancel" onclick="delImg('+fileid+',this)"></span></div>';
					html += '		<img src='+_self.getObjectURL(e.files[0])+' onmouseover="moveUp(this)" class="list-img">';
					html +='	</div>';
					if(_opts.isInput){
						var inpu = '<input type="text" class="file-input" name="'+_opts.inputName+'" placeholder="请输入名称"/>';
						html += inpu;
					}
					html +='</li>';
                }
                uploadList.append(html);
                uploadListLength(uploadList);
                _opts.Callback();
            }else{
            	$(fileid).remove();
            	return false;
            }
        }
        delImg = function(fileId,e){
        	$(fileId).remove();
        	var uploadList = $(e).parent().parent().parent().parent().attr("id");
        	$(e).parent().parent().parent().remove();
			uploadListLength('#'+uploadList);
        }
        uploadListLength = function(uploadList){
        	if($(uploadList).children("li").length>0){
				$(uploadList).next().addClass("element-invisible");
			}else{
				$(uploadList).next().removeClass("element-invisible");
			}
        }
        moveUp = function(e){
        	$(e).siblings(".file-panel").height("30px");
        }
        moveOut = function(e){
        	$(e).find(".file-panel").height("0");
        }
    }
});

jQuery.fn.extend({
	loadPreview : function(opts){
    	opts = jQuery.extend({
        	imgArray : new Array(),		//图片地址（数组形式）
            keyArray : new Array(),		//图片key（数组形式）
            nameArray : new Array(),	//图片对应名称的name(数组形式)
            delObject:'',//存储需要删除的filekey
            delInput :'',//存储需要删除的图片名称		
        	isInput : false,		//是否需要input
            update:false,//是否是更新
        	inputName : 'inputname'	//input的name
      	}, opts || {});
    	var array = opts.imgArray, html = '', _this = this,keyArray=opts.keyArray,nameArray=opts.nameArray;
        var _rnd = [];
    	$.each(array, function(index) {
            var rnd = Math.floor(Math.random()*1000)+''+new Date().getTime();
            _rnd.push(rnd);
	  		html += '<li onmouseleave="moveOut(this)">';
	  		html += '	<div class="upload-content">';
			html += '		<div class="file-panel"><span class="cancel" id="'+rnd+'" onclick="delList(this)"></span></div>';
			html += '		<img src='+array[index]+' key="{0}" onmouseover="moveUp(this)" class="list-img">';
			html += '	</div>';
			if(opts.isInput){
				var inpu = '<input type="text" class="file-input" value="{1}" name="'+opts.inputName+'" placeholder="请输入名称"/>';
				html += inpu;
			}
            if (keyArray[index]){
                html=$.formatString(html,keyArray[index],nameArray[index]);
            }else {
                html=$.formatString(html,'','');
            }
			html += '</li>';
    	});
    	$(_this).append(html);
        for (var i=0;i<_rnd.length;i++){
            $('#'+_rnd[i]).data('opts',opts);
        }
    	delList = function(obj){
            var opts = $(obj).data('opts');
            try{
                if (opts.update){
                    $(opts.delObject).val($(opts.delObject).val()+$(obj).parent().next().attr('key')+',');
                    $(opts.delInput).val($(opts.delInput).val()+$(obj).parent().siblings('input[type=text]').val()+',')
                }
            }catch (e){}
    		$(obj).parent().parent().parent().remove();
    		loadListLength(_this);
    	};
    	loadListLength = function(list){
    		if($(list).children("li").length>0){
    			if($(list).parent().hasClass("singleUpload"))
    				$(list).prev().addClass("element-invisible");
    			else
					$(list).next().addClass("element-invisible");
			}else{
				if($(list).parent().hasClass("singleUpload"))
					$(list).prev().removeClass("element-invisible");
				else
					$(list).next().removeClass("element-invisible");
			}
    	};
    	loadListLength(_this);
    }
});
//单张图片上传预览
jQuery.fn.extend({
    singleUploadPreview: function (opts) {
        var _self = this,_this = $(this);
        opts = jQuery.extend({
            fileName : 'inputfilename', //file的name
            fileId : 'fileId',			//file的id
            ListId: "#List",			//包含图片li的容器ul的id
            isNoGetFileKey:false,		//是否记录替换的filekey
            updateKeyObjId:'',			//记录原来的filekey
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"], //限制上传图片的格式
            isInput : false,			//是否需要input
            inputName : "inputname"	//input的name
        }, opts || {});
        var _this = $(this);
    	var inputhtml = '<input type="file" style="display: none;" onchange="singleFilechange(this)" id="'+opts.fileId+'" name="'+opts.fileName+'"/>';
		$(opts.ListId).append(inputhtml);
        _this.on('click',function(){
			$('#'+opts.fileId).data("opts",opts);
			$('#'+opts.fileId).trigger("click");
        });
        var _self = $('#'+opts.fileId);
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file);
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file);
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file);
            }
            return url;
        };
        singleFilechange = function(e){
        	var html = "";
			var _this = $(e);
			var _opts=_this.data('opts');
			var fileid = $(e).attr("id");
			var uploadList = $(_opts.ListId);
            if (_this.val()!=null) {
                if (!RegExp("\.(" + _opts.ImgType.join("|") + ")$", "i").test(e.value.toLowerCase())) {
                    msg({texts:"选择文件错误,图片类型必须是" + _opts.ImgType.join("，") + "中的一种"});
                    e.value = "";
                    return false;
                }
                if ($.browser.msie) {
                    try {
						html += '<li onmouseleave="moveOut(this)">';
	                    html += '	<div class="upload-content">';
						html += '		<div class="file-panel"><span class="cancel" onclick="slingleDelImg(this)"></span></div>';
						html += '		<img src='+_self.getObjectURL(e.files[0])+' onmouseover="moveUp(this)" class="list-img">';
						html += '	</div>'
						if(_opts.isInput){
							var inpu = '<input type="text" class="file-input" name="'+_opts.inputName+'" placeholder="请输入名称"/>';
							html += inpu;
						}
						html += '</li>';
                    } catch (e) {
                        var src = "";
                        var obj = $(".list-img");
                        var li = obj.parent("li")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus();
                        } else {
                            _self.blur();
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("li").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': _opts.Width + 'px',
                            'height': _opts.Height + 'px'
                        });
                        li.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src;
                    }
                } else {
                    html += '<li onmouseleave="moveOut(this)">';
                    html += '	<div class="upload-content">';
					html += '		<div class="file-panel"><span class="cancel" onclick="slingleDelImg(this)"></span></div>';
					html += '		<img src='+_self.getObjectURL(e.files[0])+' onmouseover="moveUp(this)" class="list-img">';
					if(_opts.isInput){
						var inpu = '<input type="text" class="file-input" name="'+_opts.inputName+'" placeholder="请输入名称"/>';
						html += inpu;
					}
					html += '	</div>'
					html += '</li>';
                }
                if (opts.isNoGetFileKey){
                    uploadList.find("li").each(function(){
                        var key = $($(this).find('img')[0]).attr('key');
                        if (opts.updateKeyObjId!=''&&typeof key != 'undefined'){
                            $('#'+opts.updateKeyObjId).val($('#'+opts.updateKeyObjId).val()+key+',');
                        }
                    });
                }
                uploadList.find("li").remove();
                uploadList.append(html);
                slingleUploadListLength(uploadList);
            }
        }
        slingleDelImg = function(e){
        	var uploadList = $(e).parent().parent().parent().parent().attr("id");
        	$(e).parent().parent().parent().remove();
			slingleUploadListLength('#'+uploadList);
        }
        slingleUploadListLength = function(uploadList){
        	if($(uploadList).children("li").length>0){
				$(uploadList).prev().addClass("element-invisible");
			}else{
				$(uploadList).prev().removeClass("element-invisible");
			}
        }
        moveUp = function(e){
        	$(e).siblings(".file-panel").height("30px");
        }
        moveOut = function(e){
        	$(e).find(".file-panel").height("0");
        }
    }
});