function saveRule(){
	
	var ruleid=$("#ruleid").val();
	var ruleName = $('#rulename').val();
	var ruleTime = "2016-05-19";
	var creator = "张三";
	
	
	var applyType=$(".crumb-select-item span");
	var temp = '';
	$.each(applyType,function(i,v){
		if(i<applyType.length-1){
			temp+=$(v).html()+","
		}else{
			temp+=$(v).html();
		}
	})
	var saleType=$('input:radio[name="sellType"]:checked').val();
	var bail = $('#deposit').val();
	var saleArea=$(".area-tip-input>.rule-tip");
	var temp1 = "";
	var temp2 = "";
	$.each(saleArea,function(i,v){
		if(i<saleArea.length-1){
			temp1+=$(v).html()+","
			temp2+=$(v).attr("data-id")+","
		}else{
			temp1+=$(v).html();
			temp2+=$(v).attr("data-id");
		}
	})
	var payWay=$('input:radio[name="payway"]:checked').val();
	var proRight =$("#produceDutyExplain").val();
	var busiRight = $("#traderDutyExplain").val();
	var customerService = $("#aftermarketExplain").val();
	if(ruleName==null||ruleName==undefined||ruleName==""){
		msg({texts:'规则名不能为空！'});
		return false;
	}
	if(temp==null||temp==undefined||temp==""){
		msg({texts:'适用物资不能为空！'});
		return false;
	}
	if(!($("#redeposit").attr("style") === "display: none")){
		if(bail==null||bail==undefined||bail==""){
			msg({texts:'保证金不能为空！'});
			return false;
		}
	}
	
	if(temp1==null||temp1==undefined||temp1==""){
		msg({texts:'销售区域不能为空！'});
		return false;
	}
	if(proRight==null||proRight==undefined||proRight==""){
		msg({texts:'生产企业权利义务说明不能为空！'});
		return false;
	}
	if(busiRight==null||busiRight==undefined||busiRight==""){
		msg({texts:'貿易商权利义务说明不能为空！'});
		return false;
	}
	if(customerService==null||customerService==undefined||customerService==""){
		msg({texts:'售后服务说明不能为空！'});
		return false;
	}
	$.ajax({
		url : "/shengchan-web/comp/saveSaleRule",
		type : "POST",
		dataType : "json",
		data : {
			"id":ruleid,
			"compid" : "1312312313",
			"ruleName" : ruleName,
			"ruleTime" : ruleTime,
			"creator" : creator,
			"applyType" : temp,
			"saleType" : saleType,
			"bail" : bail,
			"saleArea":temp1,
			"saleAreaCode":temp2,
			"payWay" : payWay,
			"proRight" : proRight,
			"busiRight" : busiRight,
			"customerService" : customerService
		},
		success : function(data) {
			if(data.success){
				$('#caigoujiaoyi').bootstrapTable('refresh');
				msg({texts:'保存成功！'});
			}else{
				msg({texts:'保存失败！'});
			}
		}
	})
	return "1";
}
