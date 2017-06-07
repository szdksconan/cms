/**
 * 拆分URL,并将当前参数值进行拆分组装
 * @param url 可使用location.href获取当前页面的url地址
 * @param name 指定从url中获取值的key值
 */
function splitUrl(url,name){
	//判断当前url是否包含参数
	if(url.indexOf("?") == -1
			|| url.indexOf(name + "=") == -1)
		return "";
	//获取url参数部分
	var paramStr = url.substring(url.indexOf("?") + 1);
	//将url参数部分进行键值对拆分
	var values = paramStr.split("&");
	//循环处理
	for ( var i = 0; i < values.length; i++) {
		//获取当前‘=’位置
		var postion = values[i].indexOf("=");
		//判断
		if(postion == -1)
			continue;
		//获取键=值
		var key = values[i].substring(0, postion);
		var value = values[i].substring(postion + 1);
		//判断键是否相同
		if(key == name)
			return unescape(value);
	}
	return "";
}