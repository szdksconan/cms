
var namebox="";//定义选取的boxname
var totalprice=0;
var shopnum="";
var shopId="";
$(document).ready(function() {
	gouc_OK(1,2);
})

function gouc_OK(page,pageSize){
	totalprice();
	if(userid!=""){
		$.ajax({
			url:context+"/cart/userCart",
			type:"get",
			data:{userId:userid,page:page,pageSize:pageSize},
			contentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				$(".shopping_cart").html("");
				var s_id =[];
				var s_name=[]
				var html="";
				var q_all_num=[];
				var size_count =data.size;
				var size = 0;
				if(size_count%pageSize==0){
					size = parseInt(size_count/pageSize);
				}else{
					size = parseInt(size_count/pageSize)+1;
				}
				$.each(data.listData,function(i,n){
					s_id.push(n.STORE_ID);
					s_name.push(n.STORE_NAME);
				});//
				var jia = s_id.delRepeat();
				var shang = s_name.delRepeat();
				for (var k = 0,i=0; k < jia.length,i<shang.length; k++,i++) {
						html+="<tr><td colspan=\"7\" > " ;
						html+="<input id=\"chkAll_q\" type=\"checkbox\" value=\"no\" onClick=\"x_z('a"+jia[k]+"');\" class=\"fl cv\" />";
						html+="&nbsp;商家： "+shang[i]+"</td>";
						html+="</tr>";
						$.each(data.listData,function(i,n){
							if(n.STORE_ID==jia[k]){
								q_all_num.push(n.PRODUCT_CODE);
								html+="<tr>";
								html+=" <td ><input class=\"q_xza"+jia[k]+"\"  name=nm_xza"+jia[k]+"  style=\"display:none\" value="+n.ID+" /><INPUT id="+n.ID+" num="+n.PRODUCT_NUMBER+" totalprice="+n.PRODUCT_PRICE*n.PRODUCT_NUMBER+" name=\"a"+jia[k]+"\" value='"+n.PRODUCT_CODE+"' value2='"+n.GOODS_ID+"' onClick=\"s_p('a"+jia[k]+"');\" class=\"boxck g_inp cv a"+n.ID+"\"  type=\"checkbox\" />&nbsp;&nbsp;<img width=\"106\" height=\"106\" src="+n.PRODUCT_IMG_URL+"></td>" ;//images/w1.jpg
								html+=" <td>" ;
								html+=" <div>" ;
								html+=" <p> </p>";
								html+="<p><a class=\"red\" >"+n.PRODUCT_NAME+"</a>&nbsp;</p>" ;
								html+= "<p>"+n.STORE_NAME+"</p>" ;
								html+= " <p><img src="+context+"/images/b.png>高新区-都会路-1008号&nbsp;<img src="+context+"/images/b1.png>1小时前</p>" ;
								html+=" </div>" ;
								html+="</td>" ;
							//	html+=" <td >" ;
								//html+= " <div>" ;
								//html+= "<p style=\"width:200px;height:auto;\">"+n.PRODUCT_ATTRIBUTE+"</p>" ;
								//html+=  "<p>尺码：1.75</p>" ;
								//html+="</div>" ;
							//	html+="</td>" ;
								html+="<td>￥"+n.PRODUCT_PRICE+"</td>" ;
								//var j_g = ku_num*n.PRODUCT_PRICE;
								html+= " <td > <img style=\"float: left\" onclick=\"kc_jian('"+n.PRODUCT_PRICE+"','"+n.ID+"');\" src="+context+"/images/jian.jpg>" ;
								html+="<input  style=\"float: left\"  type=\"text \" class=\"cmao_inpsm i0 \" value="+n.PRODUCT_NUMBER+" id=a"+n.ID+" />" ;
								html+=	"<img  onclick=\"ku_jia('"+n.PRODUCT_PRICE+"','"+n.ID+"');\" src="+context+"/images/jia.jpg></td>" ;
								html+="<td id=p_q_pric"+n.ID+" >￥"+n.PRODUCT_PRICE*n.PRODUCT_NUMBER+"<input class=b_s"+n.ID+" style=\"display:none\" value="+n.PRODUCT_PRICE*n.PRODUCT_NUMBER+"></td>" ;//￥"+j_g+"
								html+="<td >" ;
								html+="<div>" ;
								html+= "<p> </p>" ;
								html+= "<p><a class=\"red\" onclick=\"del('"+n.ID+"');\">删除</a></p>" ;
								html+=  "<p><a class=\"red\" >移至收藏</a>&nbsp;</p>" ;
								html+=  "</div>" ;
								html+="</td>" ;
	
								html+="</tr>";
							}
						});
				}
				$(".shopping_cart").append(html);
				$.jqPaginator('#page_home', {
					totalPages: size,
					pageSize : 2,
					visiblePages: 5,
					currentPage: page,
					onPageChange: function (num, type) {
						if (type == 'change') {
							gouc_OK(num,pageSize);
						}
					}
				});
				$(".q_all_num").text("全部商品("+q_all_num.length+")");	
				//不同商家之间只能选择一家商品
				$(".boxck").click(function(){
					 namebox=$(this).attr("name");
					$("input:checkbox:not([name='"+namebox+"'])").removeAttr("checked");
				})
			}
		})
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
	}
}

var j_scart="";
var g_cart="";
function x_z(x){
	j_scart=[];
	g_cart=[];
	var arrSon = document.getElementsByName(x);
    for(i=0;i<arrSon.length;i++) {
        arrSon[i].click();
    }
    if($("#chkAll_q").val()=="no"){
    	$("#chkAll_q").val("yes");
    }else{
    	$("#chkAll_q").val("no");
    }
    if($("#chkAll_q").val()=="yes"){
    	$(".q_xz"+x).each(function(){
    		j_scart.push($(this).val());
		 });
    }
    for (var j = 0; j < j_scart.length; j++) {
    	$("#a"+j_scart[j]).each(function(){
    		g_cart.push($(this).val());
		 });
	}
    lj_jscart();
}

function s_p(s){
	namebox=s;
	totalprice();
	/*j_scart=[];
	g_cart=[];
	$(".b_s"+s).each(function(){
		j_scart.push($(this).val());
		if($(this).checked==false)
			alert(j_scart);
			
	 });*/
    
}

function lj_jscart(){
	if(g_cart!=""){
    	$.ajax({
			url:context+"/cart/selectUserShopping",
			type:"get",
			data:{lj_jscart:j_scart,g_cart:g_cart},
			ontentType : "application/jsonp",
			dataType:"jsonp",
			jsonp: "callbackparam",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)
			jsonpCallback:"cms_1_success",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
			success:function(data){
				$(".xz_num").text(data.sp_num);
				$(".xz_jg_cont").text("￥"+data.sp_pricet);
			}
		});
    }else{
    	$(".xz_num").text("0");
		$(".xz_jg_cont").text("￥0.0");
    }
}

var ku_num;
 
function kc_jian(p,i){
	g_cart=[];
    ku_num= $("#a"+i).val();
	if(ku_num>1){
		ku_num--;
	}else{
		return;
	}
	$("#a"+i).val(ku_num);
	$("#p_q_pric"+i).text("￥"+ku_num*p);
	$("#"+i).attr("totalprice",ku_num*p);
	$("#"+i).attr("num",ku_num);
	for (var j = 0; j < j_scart.length; j++) {
    	$("#a"+j_scart[j]).each(function(){
    		g_cart.push($(this).val());
		 });
	}
	if(g_cart!=""){
		lj_jscart();
	}
	
	totalprice();
}

function ku_jia(p,i){
	g_cart=[];
	ku_num= $("#a"+i).val()
	if(ku_num<999){
		ku_num++;
	}else{
		return;
	}
	$("#a"+i).val(ku_num);
	$("#p_q_pric"+i).text("￥"+ku_num*p);
	$("#"+i).attr("totalprice",ku_num*p);
	$("#"+i).attr("num",ku_num);
	for (var j = 0; j < j_scart.length; j++) {
    	$("#a"+j_scart[j]).each(function(){
    		g_cart.push($(this).val());
		 });
	}
	if(g_cart!=""){
		lj_jscart();
	}
	
	totalprice();
}

function del(id){
	if(confirm("确认删除吗")){
		if(id!=null&&id!=""){
			$.ajax({
				url:context+"/cart/del_cart",
				data:{Id:id},
				type:"post",
				dataType:"json",
				success:function(data){
					alert("删除成功!");
					refresh();
				}
			});
		}else{
			alert("取消删除!");
		}
	}else{
		return;
	}
}

function refresh(){
	window.location.reload();//刷新当前页面.
}

//function
// 判断重复
Array.prototype.delRepeat = function() {
	var newArray = [];
	var provisionalTable = {};
	for (var i = 0, item; (item = this[i]) != null; i++) {
		if (!provisionalTable[item]) {
			newArray.push(item);
			provisionalTable[item] = true;
		}

	}
	return newArray;
}

window.getinputKey=function(){
//	var str=document.getElementsByName(namebox);
//	var objarray=str.length;
	var chestr="";
	var goodsId="";
	
	$("input[name="+namebox+"]").each(function() {  
        if ($(this).attr("checked")) { 
        	
        	chestr+=$(this).val+",";
        	goodsId+=$(this).attr("value2")+",";
        } 
		});
	
	if(chestr == "")
	{
	  alert("请先选择一个～！");
	}
	else
	{
		$("#shoppingpid").val(chestr);
		$("#shoppingnum").val(shopnum);
		$("shoppingshopId").val(goodsId);
		
		$("#ShopcheckForm").submit();
	}
}
/*统计价格和数量*/
window.totalprice=function(){
	var price=0;
	var i=0;
	shopnum="";
	$("input[name="+namebox+"]").each(function() {  
        if ($(this).attr("checked")) { 
        	i++;
        	price+=parseInt($(this).attr("totalprice"));	//记录选着需求id
        	shopnum+=$(this).attr("num")+",";                       	//记录商品个数
        } 
		});
	$("#totalprice").html(price);
	$("#totalnum").html(i);
}
