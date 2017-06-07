/**
 * 上传图片本地预览
 */
jQuery.fn.extend({
    uploadPreview: function (opts) {
        var _self = this,
            _this = $(this);
        opts = jQuery.extend({
            Img: "ImgPr",
            Width: 200,
            Height: 200,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
            Callback: function () {}
        }, opts || {});
        _self.getObjectURL = function (file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file)
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file)
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file)
            }
            return url
        };
        _this.change(function () {
            if (this.value) {
                if (!RegExp("\.(" + opts.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert("选择文件错误,图片类型必须是" + opts.ImgType.join("，") + "中的一种");
                    this.value = "";
                    return false
                }
                if ($.browser.msie) {
                    try {
                        $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                    } catch (e) {
                        var src = "";
                        var obj = $("#" + opts.Img);
                        var div = obj.parent("div")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus()
                        } else {
                            _self.blur()
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("div").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': opts.Width + 'px',
                            'height': opts.Height + 'px'
                        });
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src
                    }
                } else {
                    $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                }
                opts.Callback()
            }
        })
    }
});

/**
 * 根据比例计宽度
 * @param percent
 * @returns {Number}
 */
function fixWidth(percent)
{  
    return document.body.clientWidth * percent ; //这里你可以自己做调整  
}


/**
 * 对Date的扩展，将 Date 转化为指定格式的String
	月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
	年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
	例子： 
	(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
	(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
 * @param fmt
 * @returns
 */
Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

/**
 * o:参数格式为2015-01-01[ 01:01[:01]].\r其中[]内的内容可省略
 * 倒计时
 */
var cdst;//定时执行对象，不用的时候需要clear
function count_down(o){
    var www_qsyz_net=/^[\d]{4}-[\d]{1,2}-[\d]{1,2}( [\d]{1,2}:[\d]{1,2}(:[\d]{1,2})?)?$/ig,str='',conn,s;
    if(!o.match(www_qsyz_net)){
            alert('参数格式为2015-01-01[ 01:01[:01]].\r其中[]内的内容可省略');
            return false;
    }
    var sec=(new Date(o.replace(/-/ig,'/')).getTime() - new Date().getTime())/1000;
    if(sec > 0){
        conn='还有';
    }else{
    	document.getElementById('countdown').innerHTML = '';
		return;//时间已过去就不用显示
        conn='已过去';
        sec*=-1;
    }
    s={'天':sec/24/3600,'小时':sec/3600%24,'分':sec/60%60,'秒':sec%60};
    for(i in s){
            if(Math.floor(s[i])>0 ) str += Math.floor(s[i]) + i;
    }
    if(Math.floor(sec)==0){ str='0秒'; }
    document.getElementById('countdown').innerHTML = '<h1>'+str+'</h1>';
    cdst = setTimeout(function(){count_down(o)},1000);
}

$.modalDialog = function(options) {
    if ($.modalDialog.handler == undefined) {// 避免重复弹出
        var opts = $.extend({
            title : '',
            width : 840,
            height : 680,
            modal : true,
            onClose : function() {
                $.modalDialog.handler = undefined;
                $(this).dialog('destroy');
            },
            onOpen : function() {
            }
        }, options);
        opts.modal = true;// 强制此dialog为模式化，无视传递过来的modal参数
        return $.modalDialog.handler = $('<div/>').dialog(opts);
    }
};
function timeDifferent(time1,time2){
	//判断开始时间是否大于结束日期
	if(time1>time2)
	{
	   alert("开始时间不能大于结束时间！");
	   return false;
	}

	//截取字符串，得到日期部分"2009-12-02",用split把字符串分隔成数组
	var begin1=time1.substr(0,10).split("-");
	var end1=time2.substr(0,10).split("-");

	//将拆分的数组重新组合，并实例成化新的日期对象
	var date1=new Date(begin1[1] + - + begin1[2] + - + begin1[0]);
	var date2=new Date(end1[1] + - + end1[2] + - + end1[0]);

	//得到两个日期之间的差值m，以分钟为单位
	//Math.abs(date2-date1)计算出以毫秒为单位的差值
	//Math.abs(date2-date1)/1000得到以秒为单位的差值
	//Math.abs(date2-date1)/1000/60得到以分钟为单位的差值
	var m=parseInt(Math.abs(date2-date1)/1000/60);

	//小时数和分钟数相加得到总的分钟数
	//time1.substr(11,2)截取字符串得到时间的小时数
	//parseInt(time1.substr(11,2))*60把小时数转化成为分钟
	var min1=parseInt(time1.substr(11,2))*60+parseInt(time1.substr(14,2));
	var min2=parseInt(time2.substr(11,2))*60+parseInt(time2.substr(14,2));

	//两个分钟数相减得到时间部分的差值，以分钟为单位
	var n=min2-min1;

	//将日期和时间两个部分计算出来的差值相加，即得到两个时间相减后的分钟数
	var minutes=m+n;
	
	return minutes;
}
function openmsg(anyList) {
	//取出隐藏域的值
	var anyList =  $('#'+anyList).val();
	var row = $('#'+anyList).datagrid('getSelected');
	
	$.ajax({
		url : "caronline/getMsgSum",
		datatype : 'json',
		type : "Post",
		data : {
			vaServiceType : '8003'
		},
		async : false,// 使用同步的方式,true为异步方式
		success : function(data) {
			if (data != null) {
				$('#totalCount').val(data.msgSum);
				if (data.msgSum <= 0)
					// 按钮显示灰色
					$('#sendbutton2').attr("disabled", true);
			}
		}
	});

}
// 发送短信
function sendmsg(anyList) {
	//取出隐藏域的值
	var anyList =  $('#'+anyList).val();
	var row = $('#'+anyList).datagrid('getSelected');
	var sendtel = $('#sendOwner').val();
	$.ajax({
		url : "caronline/sendMsg",
		datatype : 'json',
		type : "Post",
		data : {
			sendcarno : '',
			sendtel : sendtel,
			msginfo : '信息内容:'+row.info+'联系电话:'+row.tel+','+row.tel1+','+row.tel2,
			type : '8003'
		},
		async : false,// 使用同步的方式,true为异步方式
		success : function(data) {
			if (data != null) {
				$.bootstrapGrowl("发送成功!", {
					type : 'success', // (null, 'info', 'danger', 'success')
					align : 'center', // ('left', 'right', or 'center')
					offset : {
						from : 'top',
						amount : 288
					}, // 'top', or 'bottom'
					width : 140, // (integer, or 'auto')
					delay : 300,
					allow_dismiss : false // If true then will display a cross
											// to close the popup.
				});
			}
		}
	});
}
function openTime(list,index,anyList,title){
	//定义两个变量time1,time2分别保存开始和结束时间
	//var time1="2009-12-02 12:25";
	//将值赋给隐藏域
//	alert(title);

	$('#'+anyList).val(list);
	$('#'+list).datagrid('selectRow',index)
	var different =  $('#different').val();
	var row = $('#'+list).datagrid('getSelected');
	if(row != null){
	var time1 = row.createTime;
	var time2 = new Date().Format("yyyy-MM-dd hh:mm:ss");  
	var min = timeDifferent(time1,time2);
	console.info(min);

	if(min >= different){
		$('#myModalLabel2').html(title);
		$('#dbutton2').click();
	}
	else{
		min = different - min;
		$('#dbutton1').click();
		$('#sendbutton').attr("disabled", true);
		Countdown.init(Math.floor(min/60),(min%60),1);
		
	}
	//$("#myModal").modal('show');
}

}
function closeTime(){
	Countdown.reset();
}
function reTime(){
	$('#sendbutton').attr("disabled", false);
}