Array.prototype.remove=function(dx) 
{ 
    if(isNaN(dx)||dx>this.length){return false;} 
    for(var i=0,n=0;i<this.length;i++) 
    { 
        if(this[i]!=this[dx]) 
        { 
            this[n++]=this[i] 
        } 
    } 
    this.length-=1 
}; 

//初始化图片编辑器
$('#uploadID').uploadPreview({
			ListId:'#List',
			fileName:'fileupload'
		})
//初始化物资编辑index
var updateNeedDetailIndex;

//初始化上传数组
var needDetailDocBefore = new Array();

//计量单位加载
//$('#needDetailUnit').multiselect({
//    onChange : function(option, checked) {
//       var labelOption = option[0];
//       $('#needDetailUnitName').val(labelOption.label);
//    },
//    onLoadSuccess:function(option, checked){
//    	var selectContet = $('#needDetailUnit').multiselect('getSelected')
//    	var selectOption = selectContet[0];
//    	var labelOption = selectOption[0]
//    	$('#needDetailUnitName').val(labelOption.label);
//    }
//});
//                
//$('#needDetailUnit').multiselect('dataprovider', _zNodes);
//选择区县

$("#sellCity").click(function (e) {
    var tipcon = '<div class="area-tip-input city-fb">' +
            '<span class="rule-tip" value="{0}" data-id="{1}">{2}</span>' +
            '<span class="del"></span>' +
            '</div>';
    SelCity(this,e,{
        'divId':'_areas',
        'appendHtml':tipcon
    });
});

$('#unitDiv2').cxSelect({
    data:_zNodes,
    selects:['unitSelect']
});

function changeUnit(){
	//$('#needDetailUnit option:selected').text();
	$('#needDetailUnitName').val($('#needDetailUnit option:selected').text());
}

//所属行业加载

$('#needDetailIndustry').multiselect({
	maxHeight:'300',
    onChange : function(option, checked) {
       var labelOption = option[0];
       $('#needDetailIndustryName').val(labelOption.label);
    },
    onLoadSuccess:function(option, checked){
    	var selectContet = $('#needDetailIndustry').multiselect('getSelected')
    	var selectOption = selectContet[0];
    	var labelOption = selectOption[0]
    	$('#needDetailIndustryName').val(labelOption.label);
    }
});
                
$('#needDetailIndustry').multiselect('url', '../purchase/getIndustryList');

//物资类型加载                
$('#needDetailNo').multiselect('url', '../purchase/getNeedDetailNoList?tag=2');

//物资类别加载
$("#apply_goods").cxSelect({
	url:'../js/common/productJson.json',
	selects : ['materials1','materials2','materials3','materials4'],
	nodata: 'none'
});

//规则类型加载

$('#ruleIdCombo').multiselect({
    onChange : function(option, checked) {
       var labelOption = option[0];
      //表现值
    $('#ruleIdCombo').val(labelOption.value);
    //隐藏值
	$('#ruleId').val(labelOption.value);
    $('#needRuleName').val(labelOption.label);
       changeRule(labelOption.value);
    },
    onLoadSuccess:function(option, checked){
    	//后台获取的ID
    	var ruleId = $('#ruleId').val();
//    	console.info(ruleId);
	    if(ruleId == ''){
	    	//为空默认加载
	    	var selectContet = $('#ruleIdCombo').multiselect('getSelected');
	    	var selectOption = selectContet[0];
	    	var labelOption = selectOption[0]
	    	//虚拟ID
	    	$('#ruleIdCombo').multiselect('select', labelOption.value);
	    	$('#ruleId').val(labelOption.value);
	    	$('#needRuleName').val(labelOption.label);
	    	changeRule(labelOption.value);
    	}
	    else{
	    	//不为空 只加载ruleId
	    	$('#ruleIdCombo').multiselect('select', ruleId);
	    	changeTypeArray($('#needRuleApply').val());
	     	
	    }
    	
    }
});
             
$("#ruleIdCombo").multiselect('url', '../purchase/getAllBuyRule');

//主要联系人加载


$('#needLinkmanPidCombo').multiselect({
    onChange : function(option, checked) {
       var labelOption = option[0];
       
       //真实值
       $('#needLinkmanName').val(labelOption.label);
       $('#needLinkmanPid').val(labelOption.value);
    },
    onLoadSuccess:function(option, checked){
        setTimeout(function(){
        		var  needLinkmanPid =  $('#needLinkmanPid').val();
        	        if(needLinkmanPid == ''){
        		    	//为空默认加载
        		    	var selectContet = $('#needLinkmanPidCombo').multiselect('getSelected');
        		    	var selectOption = selectContet[0];
        		    	var labelOption = selectOption[0]
        		    	//虚拟ID
        		    	$('#needLinkmanPidCombo').multiselect('select', labelOption.value);
        		    	$('#needLinkmanPid').val(labelOption.value);
        		    	$('#needLinkmanName').val(labelOption.label);
        	    	}
        		    else{
        		    	
        		     	$('#needLinkmanPidCombo').multiselect('select', needLinkmanPid);
        		    }
    	}, 1000);

    }
});

                
$('#needLinkmanPidCombo').multiselect('url', '../purchase/getPurchaseLinkmanList');


//需求类型加载
$('#purchaseNeedTypeCombo').multiselect({
    onChange : function(option, checked) {
       var labelOption = option[0];
       $('#purchaseNeedType').val(labelOption.value);
    },
    onLoadSuccess:function(option, checked){
        setTimeout(function(){
    		var  purchaseNeedType =  $('#purchaseNeedType').val();
    	        if(needLinkmanPid == ''){
    		    	//为空默认加载
    		    	var selectContet = $('#purchaseNeedTypeCombo').multiselect('getSelected');
    		    	var selectOption = selectContet[0];
    		    	var labelOption = selectOption[0];
    		    	console.info(labelOption.value);
    		    	//虚拟ID
    		    	$('#purchaseNeedType').val(labelOption.value);
    	    	}
    		    else{
    		    	
    		     	$('#purchaseNeedTypeCombo').multiselect('select', purchaseNeedType);
    		    }
	}, 2000);
    }
});


$("#purchaseNeedTypeCombo").multiselect('url', '../purchase/getPurchaseNeedTypeList?tag=2');

//记载物资明细列表
	$('#table').bootstrapTable({
	//  url:'purchase/test',//请求后台的URL（*）
	clickToSelect: true,
	method: 'post',//请求方式（*）
	//toolbar: '#toolbar',//工具栏所在div id
	striped: true, //是否显示行间隔色
	cache:false, //是否使用缓存
	pagination: true,//是否显示分页
	queryParamsType:'',//传递参数
	sortable: false,//是否启用排序
	sortOrder: "asc",//排序方式
	sidePagination: "client",//分页方式：client客户端分页，server服务端分页
	pageNumber:1,//初始化加载第一页，默认第一页
	pageSize: 10, //每页的记录行数
	pageList: [10, 20, 40, 100],//可供选择的每页的行数
	search: false,//是否显示表格搜索，此搜索是客户端搜索，不会进服务端
	showColumns: false,//是否显示所有的列
	showRefresh: false,//是否显示刷新按钮
	//minimumCountColumns: 2,//最少允许的列数
	clickToSelect: true,//是否启用点击选中行
	//height: 500,//行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	uniqueId: "id",//每一行的唯一标识，一般为主键列
	showToggle:false,//是否显示详细视图和列表视图的切换按钮
	cardView: false,//是否显示详细视图
	detailView: false,//是否显示父子表
	paginationHAlign:'right',//分页组件显示位置
	paginationVAlign:'bottom',//分页信息显示位置
	paginationDetailHAlign: 'left', //right, left
	height:'350',
	//showFooter:false,//是否显示合计
	columns: [{
	    field: 'Number',
	    title: '序号',
	    formatter: function (value, row, index) {
	        return index+1;
	    }
	},{
	    title : '物资名称',
	    field : 'needDetailName'
	},{
	    title : '物资编号',
	    field : 'needDetailNo'
	},{
	    title : '规格型号',
	    field : 'needDetailType'
	},{
	    title : '所属行业',
	    field : 'needDetailIndustryName'
	},{
	    title : '物资类型',
	    field : 'needDetailMantrName'
	},{
	    title : '采购数量',
	    field : 'needDetailNum',
	    formatter: function (value, row, index){
	    	return row.needDetailNum+row.needDetailUnitName;
	    }
	}
//	,{
//	    title : '文档附件',
//	    field : 'doc',
//	    formatter: function (value, row, index){
//	    	console.info(row.needDetailDoc.length);
//	    	if(row.needDetailDoc.length > 0)
//	    		return '已上传';
//	    	else
//	    		return '未上传';
//	    }
//	}
	,{
	    title : '交货日期',
	    field : 'needDetailDeliveryTime'
	},{
	    title: '操作',
	    field : 'action',
	    formatter: function (value, row, index) {
	        return '<a class="a_css" href="javascript:void(0);" onclick="editNeedDetail(\''+row.id+'\',\''+index+'\')">编辑</a> | <a class="a_css" href="javascript:void(0);" onclick="delNeedDetail(\''+row.id+'\')">删除</a>';
	    }
	}]
	});

//添加或更新数据

function addOrUpdateNeedDetail(){
	
	var needDetailName = $('#needDetailName').val();
	//初始化为更新数据
	var tag = false;
	
	if(needDetailName == ''){
		msg({texts:'物资名称不能为空！'});
		return false;
	}
	
	var needDetailNo = $('#needDetailNo').val();
	
	if(needDetailNo == ''){
		msg({texts:'物资编号不能为空！'});
		return false;
	}
	
	var needDetailNum = $('#needDetailNum').val();
	
	if(needDetailNum == ''){
		msg({texts:'数量不能为空！'});
		return false;
	}
	
	
	var needDetailDeliveryTime = $('#needDetailDeliveryTime').val();
	
	if(needDetailDeliveryTime == ''){
		msg({texts:'交货日期不能为空！'});
		return false;
	}
	
	var needDetailUnit = $('#needDetailUnit').val();
	
	if(needDetailUnit == ''){
		
		msg({texts:'单位不能为空！'});
		return false;
	}
	
	var needDetailUnit = $('#needDetailUnit').val();
	
	var needDetailType = $('#needDetailType').val();
	
	var needDetailIndustry = $('#needDetailIndustry').val();

	
	//封装物资类别数据
	var needDetailMantr = '';
	
	var needDetailMantrName = '';
	

	
	var materials1 = $(".materials1").val();
	
	var materials2 = $(".materials2").val();
	
	var materials3 = $(".materials3").val();
	
	var materials4 = $(".materials4").val();
	
	if(materials1 != ''){
		
		needDetailMantr += materials1+',';
		
		needDetailMantrName += 	$('.materials1 option:selected').text()+',';
		
	}
	else{
		
		msg({texts:'物资类别不能为空！'});
		
		return false;
	
	}
	
	if(materials2 != null && materials2 != ''){
		
		needDetailMantr += materials2+',';
	
		needDetailMantrName += 	$('.materials2 option:selected').text()+',';
	
	}
	
	if(materials3 != null && materials3 != ''){
		
		needDetailMantr += materials3+',';
	
		needDetailMantrName += 	$('.materials3 option:selected').text()+',';
	
	}
	
	if(materials4 != null && materials4 != ''){
		
		needDetailMantr += materials4+',';
	
		needDetailMantrName += 	$('.materials4 option:selected').text()+',';
	
	}
	
	var needDetailUnitName = $('#needDetailUnitName').val();
	
	var needDetailIndustryName = $('#needDetailIndustryName').val();
	
	var needDetailId = $('#needDetailId').val();
	
	if(needDetailId == ''){
		
		//模拟一个ID
		needDetailId = 'needDtail'+parseInt(100 * Math.random());
		tag = true;
	}
	
	//检查是否有附件需要上传
	
	var needDetailDoc = needDetailDocBefore;
	
	
	//有增加图片时
	
	var len = $("#List  input[name$='fileupload']");

	if(len.length > 0){
		
		loading();
		
	       $("#uploadForm").ajaxSubmit({
	            type: 'post', // 提交方式 get/post
	            url: _commonUrl+'/purchase/uploadNeedDetailDoc',  // 需要提交的 url
	            success: function(data) {
	            	// data 保存提交后返回的数据，一般为 json 数据
	            	//console.info(data.list);
	            	closeLoading();
	            	var fileObj = data.list;
	            	for(var i=0;i<fileObj.length;i++){
	            		needDetailDoc.push(fileObj[i]);
	            	}
	            		            	
	            }
	           
	        });
	       
	   
	}
	
	//有删除图片时
	var delKeys = $('#delFileKeys').val();
	if(delKeys.length > 0){
		
		loading();
		
		$.ajax({
             type: "POST",     //提交方式
             dataType: "json",     //类型
             async:false, 
             url: _commonUrl+'/purchase/delNeedDetailDoc',    //提交的页面，方法名
             data:{delKeys:delKeys},    //参数，如果没有，可以为null
             success: function (data) { 
            	 closeLoading();
            	 //如果执行成功，那么执行此方法
            	 for(var i=0;i<data.keys.length;i++){
            		 var delkey = data.keys[i];
            		 var delindex = 0;
            		 for (var j = 0; j < needDetailDoc.length; j++) {
            			 if (delkey == needDetailDoc[j].fileKey) {
            				 delindex = j;
            			
            			 	}
            			 }
            		 needDetailDoc.remove(delindex);
            	 }
            	
             },
             error: function (err) { //如果执行不成功，那么执行此方法
                // alert("err:" + err);
             }
         });
	}
	
	if(tag){
	 	$('#table').bootstrapTable('insertRow',	{index :0 ,
			row : {id:needDetailId,needDetailName:needDetailName,needDetailNo:needDetailNo,needDetailNum:needDetailNum,
				needDetailDeliveryTime:needDetailDeliveryTime,needDetailUnit:needDetailUnit,needDetailType:needDetailType,
				needDetailIndustry:needDetailIndustry,needDetailMantr:needDetailMantr,needDetailMantrName:needDetailMantrName,
				needDetailUnitName:needDetailUnitName,needDetailIndustryName:needDetailIndustryName,needDetailDoc:needDetailDoc
			}});
	 	cleanNeedDetail();
	}
	else{
		$('#table').bootstrapTable('updateRow',	{index :updateNeedDetailIndex ,
			row : {id:needDetailId,needDetailName:needDetailName,needDetailNo:needDetailNo,needDetailNum:needDetailNum,
				needDetailDeliveryTime:needDetailDeliveryTime,needDetailUnit:needDetailUnit,needDetailType:needDetailType,
				needDetailIndustry:needDetailIndustry,needDetailMantr:needDetailMantr,needDetailMantrName:needDetailMantrName,
				needDetailUnitName:needDetailUnitName,needDetailIndustryName:needDetailIndustryName,needDetailDoc:needDetailDoc
			}});
		cleanNeedDetail();
		
	}
	
	
	
}

//编辑物资

function editNeedDetail(id,index){
	


	
	var needDetailRow = $("#table").bootstrapTable('getRowByUniqueId',id);
	
	updateNeedDetailIndex = index;
	
	 $('#needDetailName').val(needDetailRow.needDetailName);
	
	 //$('#needDetailNo').val(needDetailRow.needDetailNo);
	 
	 $('#needDetailNo').multiselect('select',needDetailRow.needDetailNo);
		
	 $('#needDetailNum').val(needDetailRow.needDetailNum);
	
	 $('#needDetailDeliveryTime').val(needDetailRow.needDetailDeliveryTime);
	

	 $('.unitSelect').attr('data-value',needDetailRow.needDetailUnit);
	 
	 $('#unitDiv2').cxSelect({
		    data:_zNodes,
		    selects:['unitSelect']
		});
	 
	 $('#needDetailType').val(needDetailRow.needDetailType);
	 
	 $('#needDetailIndustry').multiselect('select',needDetailRow.needDetailIndustry);
	 

	
	 //解析物资类别
	 
	 var needDetailMantr = needDetailRow.needDetailMantr.split(",");
	 
	
	 
	 for(var i=0;i<needDetailMantr.length-1;i++){

		 $('.materials'+(i+1)).attr('data-value',needDetailMantr[i]);
		 
	
	 }
	 
	
	 
	 $('#needDetailUnitName').val(needDetailRow.needDetailUnitName);
	
	 $('#needDetailIndustryName').val(needDetailRow.needDetailIndustryName);
	
	 $('#needDetailId').val(needDetailRow.id);
	
     $('#needDetailDoc').val(needDetailRow.needDetailDoc);	
	 
     needDetailDocBefore = needDetailRow.needDetailDoc;
     
	 $('#List').empty();
	 
	// console.info(needDetailRow.needDetailDoc.length);
	 $('#delFileKeys').val('');
	 if (needDetailRow.needDetailDoc.length!=0){
//    	console.info(needDetailRow.needDetailDoc);
    	_imgArray = new Array();
    	_keyArray = new Array();
    	for(var i=0;i<needDetailRow.needDetailDoc.length;i++){
    		var obj = needDetailRow.needDetailDoc[i];
    		_imgArray.push(obj.filePath);
    		_keyArray.push(obj.fileKey);
    	}
         $('#List').loadPreview({
             imgArray:_imgArray,
             keyArray:_keyArray,
             update:true,
             delObject:$('#delFileKeys')
         });
     }
	 
	 $("#apply_goods").cxSelect({
			url:'../js/common/productJson.json',
			selects : ['materials1','materials2','materials3','materials4'],
			nodata: 'none'
		});
	 
		var state = $('#tab1').css('display');
		
		if(state == 'none'){
			
			 $('#tab1').show();
			 $('#expend').empty();
			 $('#expend').append('∧收起');
		}

}
//删除物资
function delNeedDetail(id){
	
	 $("#table").bootstrapTable('removeByUniqueId',id);
	 
}

//清空物资编辑框
function  cleanNeedDetail(){
	
	 $('#needDetailName').val('');
		
	 $('#needDetailNo').val('');
		
	 $('#needDetailNum').val('');
	
	 $('#needDetailDeliveryTime').val('');
	
	 $('#needDetailUnit').val('');
	
	 $('#needDetailType').val('');
	
	 $('#needDetailIndustry').val('');
	
	 $('#needDetailMantr').val('');

	 $('#needDetailId').val('');
	 
	 $('#List').empty();
	 
	 needDetailDocBefore = new Array();
	 
	

}

//根据规则类型加载不同的规则信息
function changeRule(ruleId){
	  $.ajax({
	      url: "../purchase/getBuyRuleById",
	      datatype: 'json',
	      type: "Post",
	      data: {ruleId:ruleId},
	      async: false,//使用同步的方式,true为异步方式
	      success: function (data) {
	    		
	    	  ruleBean = data.ruleBean;
	    
	    	  
	    	  $("#createUser").val(ruleBean.rule.creator);
	    	  
	    	  $("#createTime").val(ruleBean.rule.ruleTime);
	    	  
	    	  $("#needRuleApply").val(ruleBean.rule.applyType);
	    	  
	    	  $("#needRulePaytype").val(ruleBean.rule.payWay);
	    	  
	       	  $("#needRuleDesc").val(ruleBean.rule.ruleDesc);
	       	  
	       	  getBuyArea(ruleId);
	       	  
	       	  changeTypeArray(ruleBean.rule.applyType);

	      }
	    });
}

//加载次要联系人
function  addLinkMan(){
	
	var display2 = $('#linkManDetail2').css('display');
	if(display2 == 'none'){
		$('#linkManDetail2').css('display','block');
		return false;
	}
	
	var display3 = $('#linkManDetail3').css('display');
	if(display3 == 'none'){
		$('#linkManDetail3').css('display','block');
		return false;
	}
	
}
//删除次要联系人
function delLinkMan(id){
	$('#'+id).css('display','none');
	$('#' + id + " input[type$='text']").each(function(i) {
		$(this).val('');
	});
}

//封装规则json
function getneedRuleJson(){
	
	var ruleData = {};
	
	ruleData.id = $("#needRuleId").val();
	
	ruleData.ruleId = $('#ruleId').val();
	
	ruleData.needRuleName = $('#needRuleName').val();
	
	ruleData.createUser = $('#createUser').val();
	
	ruleData.needRuleApply = $('#needRuleApply').val();
	
	ruleData.createTime = $('#createTime').val();
	
	ruleData.needRulePaytype = $('#needRulePaytype').val();
	
	ruleData.needRuleDesc = $('#needRuleDesc').val();
	
	ruleData.areaList = getBuyAreaValue();
	
	$('#needRuleJson').val(JSON.stringify(ruleData));
}

//封装物资明细json
function getneedDetailJson(detailData){
	
	$('#needDetailJson').val(JSON.stringify(detailData));

}

//封装联系人json
function getneedLinkJson(){
	
	var dataArray = new Array();
	
	var linkData = {};
	
	linkData.id = $("#needLinkmanId").val();
	
	linkData.pid = $("#needLinkmanPid").val();
	
	linkData.needLinkmanName = $("#needLinkmanName").val();
	 
	linkData.needLinkmanPhone = $("#needLinkmanPhone").val();
	
	linkData.needLinkmanFax = $("#needLinkmanFax").val();

	linkData.needLinkmanEmail = $("#needLinkmanEmail").val();
	
	
	dataArray.push(linkData);
	
	var display2 = $('#linkManDetail2').css('display');
	if(display2 == 'block'){
		
		var linkData2 = {};
		
		linkData2.id = $("#needLinkmanId2").val();
		
		
		linkData2.needLinkmanName = $("#needLinkmanName2").val();
		 
		linkData2.needLinkmanPhone = $("#needLinkmanPhone2").val();
		
		linkData2.needLinkmanFax = $("#needLinkmanFax2").val();

		linkData2.needLinkmanEmail = $("#needLinkmanEmail2").val();
		
		dataArray.push(linkData2);
	}
	
	var display3 = $('#linkManDetail3').css('display');
	if(display3 == 'block'){
		
		var linkData3 = {};
		
		linkData3.id = $("#needLinkmanId3").val();
		
		linkData3.needLinkmanName = $("#needLinkmanName3").val();
		 
		linkData3.needLinkmanPhone = $("#needLinkmanPhone3").val();
		
		linkData3.needLinkmanFax = $("#needLinkmanFax3").val();

		linkData3.needLinkmanEmail = $("#needLinkmanEmail3").val();
		
		dataArray.push(linkData3);
	}
	
	$('#needLinkJson').val(JSON.stringify(dataArray));


}

//发布或暂存产品
function purchaseNeedFb(type){
	
	var purchaseNeedName =  $('#purchaseNeedName').val();
	
	var purchaseNeedNo= $('#purchaseNeedNo').val();
	
	
	if(purchaseNeedName == ''){
		
		msg({texts:'需求名称不能为空！'});
		
		return false;
	}
	
	if(purchaseNeedNo == ''){
		
		msg({texts:'物资需求单号不能为空！'});
		
		return false;
	}
	
	$('#purchaseNeedState').val(type);
	
	var purchaseNeedLinkstate = $('[name="radio3"]:checked').val();
	
	$('#purchaseNeedLinkstate').val(purchaseNeedLinkstate);
	
	if(purchaseNeedLinkstate == undefined){
		
		msg({texts:'请选择联系信息是否公开！'});
		
		return false;
	}
	
	var detailData = $('#table').bootstrapTable('getData');

	if(detailData.length == 0){
		
			msg({texts:'请填写物资需求明细！'});
			
			return false;

	}
	
	var needLinkmanPhone = $("#needLinkmanPhone").val();
	
	if(needLinkmanPhone == ''){
		
		msg({texts:'联系电话不能为空！'});
		
		return false;
	}
	var needRuleApply = $("#needRuleApply").val();
	if(needRuleApply == ''){
		
		msg({texts:'适用物资不能为空！'});
		
		return false;
	}
	
	
	getneedRuleJson();
	
	getneedDetailJson(detailData);
	
	getneedLinkJson();
	
    loading();
    //return;

    $.kyPost('purchaseNeedForm',_commonUrl+'/purchase/addOrUpdatePurchaseNeed',
        function(data) {
            closeLoading();
            // 显示提示信息
            msg({
                texts:$.parseJSON(data).msg,
                fn:function(){
                	changeContent('../caigou/c_wuzixuqiu.html','right');
                }
            });
        });
}
//生成标签
function changeTypeArray(TypeArray){
	 $('#ruleApply').empty();
	var TypeArray = TypeArray.split(",");
	for(var i=0;i<TypeArray.length;i++){
		  var tipcon = '<div class="area-tip-input city-fb">' +
	      '<span class="rule-tiptype" value="'+TypeArray[i]+'" data-id="'+TypeArray[i]+'">'+TypeArray[i]+'</span>' +
	      '<span class="del" title="'+TypeArray[i]+'" ></span>' +
	      '</div>';
	      $('#ruleApply').append(tipcon);
	}
   if ($('.del').length>0){
       $('.del').click(function () {
       
       	 deltipcon($(this).attr("title"));
           $(this).parent().remove();
       });
	}
	
}
//删除标签
function deltipcon(tipcon){

	var productTypeBefore = $('#needRuleApply').val();
	var index = productTypeBefore.indexOf(','+tipcon);
	var productTypeAfter = '';
	if(index > -1){
		productTypeAfter = productTypeBefore.replace(','+tipcon,'');
	}
	else{
		productTypeAfter = productTypeBefore.replace(tipcon,'');
	}

	$('#needRuleApply').val(productTypeAfter);
}

function getBuyArea(value){
	$('#_areas').empty();
	$.post('../compRule/getBuyArea',{"buyId":value},function(data){
		$.each(data,function(i,v){
			$.each(v,function(i1,v1){
				var lyd = '<div class="area-tip-input"><span class="rule-tip" data-id="'+v1['shengId']+'-'+v1['cityId']+'-'+v1['xianId']+'">'+v1['sheng']+'-'+v1['city']+'-'+v1['xian']+'</span><span class="del" onclick="delobj(this)"></span></div>'
				$('#_areas').append(lyd);
			})
		})
	},"json");
}

function delobj(obj){
		$(obj).parent().remove();
}
function getBuyAreaValue(){
	var areaList = new Array();
	var area ={};
	$('#_areas .rule-tip').each(function(){
		var dataid = $(this).attr('data-id');
		var name = $(this).text();
		var dataidArray = dataid.split('-');
		var nameArray = name.split('-');
		if(dataidArray.length == 1){
			area.provinceId = dataidArray[0];
			area.province = nameArray[0];
		}
		else if(dataidArray.length == 2){
			
			area.provinceId = dataidArray[0];
			area.cityId = dataidArray[1];
			area.province = nameArray[0];
			area.city = nameArray[1];
		}
		else{
			area.provinceId = dataidArray[0];
			area.cityId = dataidArray[1];
			area.areaId =dataidArray[2];
			area.province = nameArray[0];
			area.city = nameArray[1];
			area.area = nameArray[2];
		}
	
		areaList.push(area);
	});
	
	return  areaList;
}
function showDetaiAdd(){
	
	var state = $('#tab1').css('display');
	
	if(state == 'none'){
		
		 $('#tab1').show();
		 $('#expend').empty();
		 $('#expend').append('∧收起');
	}
	else{
		
		$('#tab1').hide();
	 $('#expend').empty();
	 $('#expend').append('∨展开');
	}
}
