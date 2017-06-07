$(document).ready(function() {
	$.jqPaginator('#page_home', {
        totalPages: 100,
        visiblePages: 10,
        currentPage: 3,
        onPageChange: function (num, type) {
            //$('#p1').text(type + '：' + num);
        }
    });
	var ordershtml="";
	window.getOrderInfoList=function(div){
		$.ajax({
			url:context+"/ShoppingData/getOrderInfoList",
			data:{"param":12,
				},
			dataType:"json",
			type:"post",
			success:function(data){
				$.each(data,function(i,n){
					var zhifuhtml="";
					if(n.status=10){
						zhifuhtml="<p> <a href=\"javascript:;\" onclick='getshopping(\""+n.orderId+"\")'class=\"red\">立即支付</a></p><a href=\"javascript:;\" class=\"red\" onclick='delshopping(\""+n.orderId+"\")'> 取消订单</a>";
						n.status="待付款";}
					else{
						zhifuhtml="<p> <a href=\"javascript:;\" class=\"red\" onclick='{if(confirm(\"您的提醒已经递交给了贸易商请耐心等待！\")) {del(this); }else {}}'>提醒发货</a></p>";
					}
					ordershtml+="<thead>";
					ordershtml+="<tr>";
					ordershtml+="<th width=\"150\" >下单时间：<br/>"+n.orderTime+"</th>";
					ordershtml+="<th width=\"400\">收货人：<br/>"+n.customerPerson+"</th>";
					ordershtml+="<th width=\"200\"> 贸易商：<br/>"+n.entName+"</th>";
					ordershtml+="<th width=\"120\" >&nbsp;</th>";
					ordershtml+="<th width=\"300\">订单号："+n.orderId+"<br/><span style=\"float: right\">"+n.status+"</span></th>";
					ordershtml+="</tr>";
					ordershtml+="</thead>";
					ordershtml+="<tbody>";
					ordershtml+="<tr>";
					ordershtml+="<td >";
					$.each(n.cmsOrderItem,function(i,m){
						ordershtml+="<div style=\"height: 130px\">";
						ordershtml+="<img src=\""+m.productImage+"\" width=\"106\" height=\"106\">";
						ordershtml+="</div>";
					});
					ordershtml+="</td>";
					
					ordershtml+="<td>";
					$.each(n.cmsOrderItem,function(i,m){
						ordershtml+="<div style=\"height: 130px\">";
						ordershtml+="<p>";
						ordershtml+=""+m.productTitle+" </p>";
						ordershtml+="<p><a class=\"red\" >￥"+m.unitPrice+"</a>&nbsp;</p>";
						ordershtml+="<p>"+m.productAttrVal+"</p>";
						ordershtml+="</div>";
					});
						/*ordershtml+="<div style=\"height: 130px\">";
						ordershtml+="<p>";
						ordershtml+="Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机 </p>";
						ordershtml+="<p><a class=\"red\" >￥2370.00</a>&nbsp;</p>";
						ordershtml+="<p>Apple专卖店</p>";
						ordershtml+="<p>地址：广东省广南市凡苏区东宫街23</p>";
						ordershtml+="</div>";*/
					ordershtml+="</td>";
					ordershtml+="<td>";
					$.each(n.cmsOrderItem,function(i,k){
						ordershtml+="<div style=\"height: 130px\">";
						ordershtml+="数量:"+k.realQuantity+"";
						ordershtml+="</div>";
					});
						/*ordershtml+="<div style=\"height: 130px\">";
						ordershtml+="数量：5";
						ordershtml+="</div>";*/
					ordershtml+="</td>";
					ordershtml+="<td width=\"150\" align=\"center\">";
					ordershtml+="</td>";
					ordershtml+="<td width=\"100\" align=\"center\" style=\"line-height: 36px;\" valign=\"top\">";
					ordershtml+="<div style=\"font-size: 13px;float: left;\">";
					ordershtml+="￥"+n.totalPrice+"<br/>（含运费）<br/><img width=\"30\" height=\"30\" src=\"../images/geren/ge_3.png\">";
					ordershtml+="</div>";
					ordershtml+=zhifuhtml;
					//ordershtml+="<p> <a href=\"javascript:;\" class=\"red\" onclick='{if(confirm(\"您的提醒已经递交给了贸易商请耐心等待！\")) {del(this); }else {}}'>提醒发货</a></p>";
					ordershtml+="<p><a onclick=getordersData('"+n.orderId+"')  target=\"_self\" class=\"red\">订单详情</a></p>";
					ordershtml+="<p> <a onclick=skipNotePin('"+n.orderId+"') href=\"javascript:;\" target=\"_self\"class=\"red\">商品评价</a></p>";/*\"note_pin.jsp?"+n.orderId+"\"
*/					ordershtml+="</td>";
					ordershtml+="</tr>";
					ordershtml+="</tbody>";
				});		
			//	alert(ordershtml);
				$("#ordersData0").html(ordershtml);
		        
				
			}
		});
	}
	
	getOrderInfoList("0");
	
	

	window.getordersData=function(id){
		
		if(id!=null){
				$("#ordersId").val(id);
				$("#ShopcheckForm").submit();
			}
		
	}
	window.getshopping=function(orderids){
		$("#getordersId").val(orderids);
		$("#getorderShopcheckForm").submit();
		
	}
	window.skipNotePin=function(orderids){
		$("#getPinordersId").val(orderids);
		$("#skipNotePincheckForm").submit();
		
	}
	
	
	
window.delshopping=function(orderids){
	$.ajax({
		url:context+"/ShoppingData/updateshoppingstate",
		data:{"ordersId":orderids,
			},
		dataType:"json",
		type:"post",
		success:function(data){
			
			alert("00");
			
		}
	});
		
	}
	
    
})