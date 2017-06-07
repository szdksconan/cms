$(document).ready(function() {
	window.fabuev=function(){
		
		var shopPin=new Array();
		var orderPin1="";
		var orderPin2="";
		var Content = new Array();
		var val="";
		
		orderId=$("#orderId").val();
		//for(var i=0;i<=parseInt(shopNum);i++){
			$("textarea[name=Evaluatio]").each(function() {  
				Content.push($(this).val())
	        	
			});
		//}
		
		for(var i=0;i<=parseInt(shopNum);i++){
			$("i[name=levelSolid"+i+"]").each(function() { 
				val=$(this).attr("txt");
				if(val.length>0){
					shopPin.push($(this).attr("txt"));   
				}
			});
			//alert("shopPin1="+shopPin);
		}
			$("i[name=orderPin1]").each(function() {  
				val=$(this).attr("txt");
				if(val.length>0){
					orderPin1=$(this).attr("txt");   
				}
			});
			//alert("orderPin1="+orderPin1);
			$("i[name=orderPin2]").each(function() {  
				val=$(this).attr("txt");
				if(val.length>0){
					orderPin2=$(this).attr("txt");   
				}
			});
			//alert("orderPin2="+orderPin2);
		
		$.ajax({
			url:context+"/ShoppingData/setPin",
			data:{"orderId":orderId,
				"Content":Content,
				"shopPin":shopPin,
				"orderPin1":orderPin1,
				"orderPin2":orderPin2},
			dataType:"json",
			type:"post",
			success:function(data){
				alert(" 成功!! ");
			}
		});
		alert("ajax2222222222222222-------------");
	}
	
	
	
	
	
})