   
$(document).ready(function() {
	/**
	 * 生成订单号
	 */
	$.ajax({
		url:context+"/logistical/getId",
		type:"get",
		async:false,
		success:function(data){
			$("#wid").val(data);
			$("#wuliuid").val(data);
		}
	})
})

/**
 * 发布物流需求
 */
function wl_save(){
	var id=$("#wid").val();
	$("#sdln").val($("#city").val());
	$("#dcln").val($("#city2").val());
	$("#sdate").val($("#sendtime").val());
	$("input[name=radio1]").each(function(){  
        if ($(this).attr("checked")) { 
        	var sfjh=$(this).attr("value1");	
        	 if(sfjh=="是"){
             	$("#sfjh").val(1);
             	$("#jhd").val($("#jddz").val());
             }else{
             	$("#sfjh").val(0);
             } 
        }
       
	});
	$("input[name=radio2]").each(function(){  
        if ($(this).attr("checked")) { 
        	var sfsh=$(this).attr("value1");
        	if(sfsh=="是"){
            	$("#sfsh").val(1);
            	$("#shd").val($("#shdz").val());
            }else{
            	$("#sfsh").val(0);
            } 
        }
        
	});
	$("input[name=radio3]").each(function(){  
        if ($(this).attr("checked")) { 
        	var sfds=$(this).attr("value1");
        	if(sfds=="是"){
            	$("#sfds").val(1);
            	$("#ckr2").val($("#ckr").val());
            	$("#kh2").val($("#kh").val());
            	$("#yh2").val($("#yh").val());
            }else{
            	$("#sfds").val(0);
            }
        }
        
	});
	if($("#checkbox1").attr("checked")){
		$("#hd").val(1);
	}else{
		$("#hd").val(0);
	}if($("#checkbox2").attr("checked")){
		$("#js").val(1);
	}else{
		$("#js").val(0);
	}if($("#checkbox3").attr("checked")){
		$("#bj").val(1);
	}else{
		$("#bj").val(0);
	}if($("#checkbox4").attr("checked")){
		$("#kjfp").val(1);
	}else{
		$("#kjfp").val(0);
	}if($("#checkbox5").attr("checked")){
		$("#yqkh").val(1);
	}else{
		$("#yqkh").val(0);
	}
	$("#qita2").val($("#qita").val());
    $("#shr2").val($("#shr").val());
    $("#shrphone2").val($("#shrphone").val());
    $("#suname").val($("#fhr").val());
    $("#sutel").val($("#shrsjhm").val());
	var goodsName ="";var goodsNum=""; var weight=""; var volume=""; var price="";
	$("input[name=goodsName1]").each(function(){  
        gname=$(this).attr("value");	
        goodsName+=gname+",";
	});
	$("#gname").val(goodsName);
	$("input[name=num]").each(function(){  
		num=$(this).attr("value");	
		goodsNum+=num+",";
	});
	$("#gnum").val(goodsNum);
	$("input[name=wegith]").each(function(){  
		wegith=$(this).attr("value");	
    	weight+=wegith+",";
	});
	$("#gwith").val(weight);
	$("input[name=volem]").each(function(){  
		volem=$(this).attr("value");	
    	volume+=volem+",";
	});
	$("#gvlo").val(volume);
	$("input[name=price1]").each(function(){  
		prices=$(this).attr("value");	
    	price+=prices+",";
	});
	$("#gpric").val(price);
	$("#uid").val(userid);
	if(userid!=""&&id!=""){
		$("#wuliuForm").submit();
			/*$.ajax({
				url:context+"/logistical/insertorUpdateLogistical",
				data:{"id":id,"userId":userid,"sendLocalName":city,"descLocalName":city2,"sendDate":sendtime,"sendUserName":fhr,
					"sendUserTel":shrsjhm,"descUserName":shr,"descUserTel":shrphone,"needReceipt":sfjh,"placeReceipt":jhd,"needDelivery":sfsh,
					"placeDelivery":shd,"needCashDelivery":sfds,"cardHolder":ckr,"bankName":yh,"cardId":kh,"otherInfo":qita,"goodsName":goodsName,
					"goodsNum":goodsNum,"weight":weight,"volume":volume,"price":price
					},
				dataType:"json",
				type:"post",
				success:function(data){
					alert("发布成功！");
					window.location.href=context+"/f_w/wuliu_3.jsp?id="+id;
				}
			});*/
	}else{
		window.location.href=context+"/g_w/gouc_login.jsp?url="+window.location.href;
		}
}
function GetQueryString(name)
{
     var reg = new RegExp("(^|$)"+ name +"=([^$]*)(^|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}
var id=GetQueryString("id");

function jsbj(obj){
	var state = obj;
	var reqid = $("#reqid").text();
	//alert(state+"--"+reqid);
	var DistanceFee = $("#DistanceFee").text();
	var ReceiptGoodsFee = $("#ReceiptGoodsFee").text();
	var DeliveryGoodsFee = $("#DeliveryGoodsFee").text();
	var InsuredFee = $("#InsuredFee").text();
	var TaxFee = $("#TaxFee").text();
	var AmountFee = $("#AmountFee").text();
	$.ajax({
		url:context+"/logistical/updatePrice",
		data:{"DistanceFee":DistanceFee,"ReceiptGoodsFee":ReceiptGoodsFee,"DeliveryGoodsFee":DeliveryGoodsFee,"InsuredFee":InsuredFee,
				"TaxFee":TaxFee,"AmountFee":AmountFee,"state":state,"id":reqid
			},
		dataType:"json",
		type:"post",
		success:function(data){
			window.location.href=context+"/f_w/wuliu_4.jsp";
		}
	});
}


