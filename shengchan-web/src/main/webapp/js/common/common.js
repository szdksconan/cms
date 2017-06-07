var _commonUrl='http://localhost:8080/shengchan-web';//url

var _zNodes =[{"value":"10df55d1eb2941ce82c172bfbc595ad2","n":"米","isParent":"true"},{"value":"2a16f03274e647878825c20779600215","n":"件","isParent":"true"},
    {"value":"3dff885a492748af88a9e0128c3aa845","n":"平米","isParent":"true"},{"value":"3e9267d5c4984c1e9a3979a8bfc9ef7d","n":"吨","isParent":"true"},
    {"value":"4561fc80121c4ee0bca4c3fb1e16487e","n":"台","isParent":"true"},{"value":"9793a8446dab47fb8888ef9b8a733b47","n":"千克","isParent":"true"},
    {"value":"c61b28f91b6547ea9bb83b10c8d4dec4","n":"立方","isParent":"true"}];//计量单位

function fixWidth(percent){
    return document.body.clientWidth * percent ; //这里你可以自己做调整
}

/**
 * 获取url后面的参数
 * @param LocString window.location.search
 * @param str 参数名称
 * @returns {*}
 */
function getQueryStr(LocString,str) {
    var rs = new RegExp("(^|)" + str + "=([^&]*)(&|$)", "gi").exec(LocString), tmp;
    if (tmp = rs) {
        return tmp[2];
    }
}
/* loading方法 */
function loading(){
	//loading层
	var index = layer.load(1, {
	  shade: [0.3,'#000'] //0.3透明度的白色背景
	});
	return index;
}
/* 关闭loading */
function closeLoading(){
	layer.close(loading());
}

/**
 *
 * @requires jQuery
 *
 * 将form表单元素的值序列化成对象 不包括file
 *
 * @returns object
 */
$.serializeObject = function(form) {
    var o = {};
    $.each(form.serializeArray(), function(index) {
        if (o[this['name']]) {
            o[this['name']] = o[this['name']] + "," + this['value'];
        } else {
            o[this['name']] = this['value']; 
            
        }
    });
    return o;
};

/**
 *
 * 跨域form post提交
 * @param url form url地址
 * @param formId formId
 * @param data form data数据
 * @param fn 回调函数
 */
$.kyPost = function(formId,url,fn) {
    var form=$('#'+formId);
    //try&catch是为了解决IE67创建iframe新开窗问题
    var iframe;
    try {
        iframe = document.createElement('<iframe name="postIframe">');
    } catch (ex) {
        iframe = document.createElement('iframe');
    }
    $(iframe).attr("id","0_postIframe");
    $(iframe).attr("name","0_postIframe");
    $(iframe).hide();
    form[0].appendChild(iframe);

    //表单提交
    form.attr('action',url);
    form.attr('target',iframe.name);
    form.attr('method',"post");
    form.submit();

    //事件处理
    if(iframe.attachEvent){
        iframe.attachEvent("onload", _loadFn);
    }else{
        iframe.onload = _loadFn;
    }

    //记录iframe的加载状态
    iframe.state = 0;
    function _loadFn() {
        if (iframe.state === 1) {
            var data = '';
            //获取window.name保存的数据
            try{
                data = iframe.contentWindow.name;
            }catch(e){
            }
            //执行回调方法
            _callback(data);
            //iframe清除
            iframe.onload = null;
            iframe.contentWindow.document.write('');
            iframe.contentWindow.close();
            form[0].removeChild($(iframe));
        } else if (iframe.state === 0) {
            //form提交完成之后，将location置为同域
            iframe.state = 1;
            iframe.removeAttribute('name');//解决IE10+获取不到window.name的问题
            iframe.contentWindow.location = "../blank.html";
        }
    }
    function _callback(json) {
        //默认执行传入的回调方法
        if (fn && typeof fn === "function") {
            fn(json);
        } else {
            //没有回调方法则解析postcallback
            var svalue = url.match(new RegExp("[\?\&]postcallback=([^\&]*)(\&?)"));
            fn = window[svalue ? svalue[1] : svalue];
            if (fn && typeof fn === "function") {
                fn(json);
            }
        }
    }
};

/**
 * 提示框弹出
 */
function msg(opts){
	opts = $.extend({
        title: '信息提示',		//提示的title
        texts: '',			//提示的内容
        time: 1000,			//几秒后消失
        fn:undefined        //关闭后执行方法
    }, opts);
    var msg = $('<div class="msg"></div>');
	var msgTitle = $('<div class="msg-title">'+opts.title+'</div>');
	var msgContent = $('<div class="msg-content">'+opts.texts+'</div>');
	$('body').append(msg);
	msg.append(msgTitle);
	msg.append(msgContent);
	setTimeout(function(){
		msg.remove();
        if (typeof opts.fn=='function'){
            opts.fn();
        }
	},opts.time);
}

/**
 * 字符替换
 * @param str
 * @returns {*}
 */
$.formatString = function(str) {
    for ( var i = 0; i < arguments.length - 1; i++) {
        str = str.replace("{" + i + "}", arguments[i + 1]);
    }
    return str;
};

/**
 * 封装ajax请求，加入加载组件
 * @param obj
 */
$.ajaxLoad = function(obj){
    if (typeof(obj)=='object'){
        var async = (obj.async==null || obj.async=="" || typeof(obj.async)=="undefined")? "true" : obj.async;
        var type = (obj.type==null || obj.type=="" || typeof(obj.type)=="undefined")? "post" : obj.type;
        var dataType = (obj.dataType==null || obj.dataType=="" || typeof(obj.dataType)=="undefined")? "json" : obj.dataType;
        var data = (obj.data==null || obj.data=="" || typeof(obj.data)=="undefined")? {"date": new Date().getTime()} : obj.data;
        var options={
            type: type,
            async: async,
            data: data,
            url: obj.url,
            dataType: dataType,
            success: function(d){
                closeLoading();
                if ($.isFunction(obj.success)){
                    obj.success(d);
                }
            },
            error: function(e){
                closeLoading();
                if ($.isFunction(obj.error)){
                    obj.error(e);
                }
            }
        };
        if (dataType=='jsonp'){
            options.jsonp='jsonpCallback';
        }
        loading();
        $.ajax(options);
    }
};

/**
 * 替换所有的回车换行
 * @param content
 * @returns {*}
 * @constructor
 */
function TransferString(content) {
    var string = content;
    try{
        string=string.replace(/\r\n/g,"\\n")
        string=string.replace(/\n/g,"\\n");
    }catch(e) {}
    return string;
}
/**
 * 通过提供id 对数据进行空格 换行的监听
 * @param id dom元素id
 * @returns 返回实现了空格 和 换行的字符串
 */
function checkTextArea(id){
	var newString = document.getElementById(id).value.replace(/\n/g, '_@').replace(/\r/g, '_#');
	newString = newString.replace(/_#_@/g, '<br/>'); //IE7-8
	newString = newString.replace(/_@/g, '<br/>'); //IE9、FF、chrome
	newString = newString.replace(/\s/g, '&nbsp;'); //空格处理
	return newString;
};
