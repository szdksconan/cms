var _randomId;// 产品DIV自定义ID
var ruleDivId;// 规则DIV自定义ID
var data;// table_1中自定义产品数量
var _updateFlag=false;
var ruleIdBefore;
// 图片预览

$("#upload2").singleUploadPreview({
	ListId : "#uploadList2",
    fileName:'mainProductPicTrue',
    isNoGetFileKey:true,
    updateKeyObjId:'delMainFileKeys'
});

$("button[name=upload]").uploadPreview({
	ListId : "#uploadList",
	fileName : 'mainProductPic'
});

$("#brandId").multiselect({
    onLoadSuccess:function(){
        try{
            $('#brandId').multiselect('select',obj.brandId);
        }catch (e){}
    }
});
$("#brandId").multiselect('url', '../product/getBrandSelectList?companyId=1312312313');
// 规格型号列表
$('#table_1').bootstrapTable({
					pagination : true,// 是否显示分页
					queryParamsType : '',// 传递参数
					sidePagination : "client",// 分页方式：client客户端分页，server服务端分页
					uniqueId : "productCode",// 每一行的唯一标识，一般为主键列
					columns : [
							{
								field : 'number',
								title : '序号',
								formatter : function(value, row, index) {
									return index + 1;
								}
							},{
								title : '产品编码',
								field : 'productCode'
							},{
								title : '规格型号',
								field : 'productModelSize'
							},{
								title : '参数配置',
								field : 'productConfig'
							},{
								title : '库存量',
								field : 'warehouseBalance'
							},{
								title : '单位',
								field : 'unitName'
							},{
								title : '产品附件',
                                visible:false,
								field : 'productPic'
							},{
								title : '操作',
								field : 'action',
								formatter : function(value, row, index) {
									return '<a class="a_css" href="javascript:void(0);" onclick="show(\''
											+ row.productDivId
											+ '\',\''
											+ row.productCode
											+ '\',\''
											+ row.id
											+ '\') " >编辑</a> | <a class="a_css" href="javascript:void(0);" onclick="delProduct(\''
											+ row.productCode + '\')">删除</a>';
								}
							} ]
				});

// 添加规格型号
$('#btn_addproduct').click(function() {
					_randomId = 'layerDiv' + parseInt(100 * Math.random());
					$('#cpxsform').append('<div id="' + _randomId + '" style="display:none" >');
					$('#cpxsform').append('</div>');
					layer.open({
								title : [ ' 新增产品','font-size:18pt;text-align:center' ],
								skin : 'layui-layer-cms',
								closeBtn : 2,
								offset : 'center', // 右下角弹出
								type : 1,
								area : [ '865px', '500px' ],// [width,height]
								content : $('#' + _randomId).load('../xiaoshou/xs_cpfb_mx.html'),
								btn : [ '保存', '取消' ],
								yes : function(index, layero) {
									// table_1添加row
                                    var delProductFileKeys = $('#' + _randomId+" #delProductFileKeys").val();
									var productCode = $('#' + _randomId + ' #productCode').val();
									var productModelSize = $('#' + _randomId + ' #productModelSize').val();
									var warehouseBalance = $('#' + _randomId + ' #warehouseBalance').val();
									var unitId = $('#' + _randomId + ' #unitId').val();
									var unitName = $('#' + _randomId + ' #unitId option:selected').text();
									var industryId = $('#' + _randomId + ' #industryId').attr('data-id');
									var industryName = $('#' + _randomId + ' #industryId').val();
									var ipoTime = $('#' + _randomId + ' #ipoTime').val();
									var len = $('#table_1').bootstrapTable('getData').length;
									var productConfig = "";
									// 校验是否为空
									if (productCode == '') {
										msg({texts:'产品编码不能为空！'});
										return false;
									}
									// 校验是否重复
									var realrow = $('#table_1').bootstrapTable('getRowByUniqueId', productCode);
									if (realrow != undefined) {
										msg({texts:'产品编码重复！'});
										return false;
									}
									// 组装属性参数
									var productConfigObj = {};
									var productConfigName = [];
									var productConfigValue = [];
									var productConfigKey = '';
									// 组装参数名称
									$('#' + _randomId + " #configArea #configName2").each(function(i) {
										var value = $(this).val(); // 这里的value就是每一个input的value值~
										productConfigName.push(value);
									});
									// 组装参数值
									$('#' + _randomId + " #configArea #configValue2").each(function(i) {
										var value = $(this).val(); // 这里的value就是每一个input的value值~
										productConfigValue.push(value);
									});
									for (var i = 0; i < productConfigName.length; i++) {
										if (i != productConfigName.length - 1) {
											productConfig += productConfigName[i]
													+ ":"
													+ productConfigValue[i]
													+ ",";
											productConfigKey += productConfigName[i]
													+ ",";
										} else {
											productConfig += productConfigName[i]
													+ ":"
													+ productConfigValue[i];

											productConfigKey += productConfigName[i];
										}
										productConfigObj[productConfigName[i]] = productConfigValue[i];
									}
									// 组装参数名称
									productConfigObj['key'] = productConfigKey;
									var productPicName = 'productPic'
											+ parseInt(100 * Math.random());
									$('#' + _randomId + " input[type$='file']").each(function(i) {
										$(this).attr('name',productPicName);
									});
									var row = {
										id : len + 1,
										productCode : productCode,
										productModelSize : productModelSize,
                                        warehouseBalance : warehouseBalance,
                                        unitId : unitId,
                                        unitName:unitName,
                                        industryId : industryId,
                                        industryName:industryName,
                                        ipoTime : ipoTime,
										productConfig : productConfig,
										productPicName : productPicName,
										productConfigObj : productConfigObj,
										productDivId : _randomId,
                                        delProductFileKeys:delProductFileKeys
									};
									$('#table_1').bootstrapTable('insertRow', {
										index : len + 1,
										row : row
									});
									layer.close(index);
								},
								no : function(index, layero) {
									layer.close(index);
								},
								cancel : function(index) {
									$('#' + _randomId).parents("#layui-layer" + index).remove();
									$('#layui-layer-shade' + index).remove();
									$('#' + _randomId).remove();
									layer.close(index);
								}
							});
				});
// 删除规格型号
function delProduct(id) {
    var _id=$('#table_1').bootstrapTable('getRowByUniqueId', id).id;
	$('#table_1').bootstrapTable('removeByUniqueId', id);
    $('#delProductIds').val(_id+','+$('#delProductIds').val());
}
// 规则列表
$('#table_2').bootstrapTable({
					pagination : true,// 是否显示分页
					queryParamsType : '',// 传递参数
					sidePagination : "client",// 分页方式：client客户端分页，server服务端分页
					uniqueId : "id",// 每一行的唯一标识，一般为主键列
					columns : [
							{
								field : 'number',
								title : '序号',
								formatter : function(value, row, index) {
									return index + 1;
								}
							},{
								title : '销售类型',
								field : 'sellType',
								formatter : function(value, row, index) {
									if (value == '7')
										return '经销';
									else
										return '代销';
								}
							},{
								title : '销售区域',
								field : 'ruleArea'
							},{
								title : '付款方式',
								field : 'payType',
								formatter : function(value, row, index) {
									if (value == '9')
										return '先款后货';
									else
										return '货到付款';
								}
							},{
								title : '销售价格明细',
								field : 'rulePrice',
								formatter : function(value, row, index) {
									return ' <a href="javascript:void(0);">查看价格</a>';
								}
							},{
								title : '操作',
								field : 'action',
								formatter : function(value, row, index) {
									return '<a class="a_css" href="javascript:void(0);" onclick="showRuleDiv(\''
											+ row.ruleDivId
											+ '\',\''
											+ row.id
											+ '\') " >编辑</a> | <a class="a_css" href="javascript:void(0);" onclick="delRule(\''
											+ row.id + '\')">删除</a>';
								}
							}]
				});
// 新增销售规则
$('#btn_addrule').click(function() {
	data = $('#table_1').bootstrapTable('getData');
	var _newdata = new Array();
	ruleIdBefore = '';
	for(var i= 0;i<data.length;i++){
		var b=new Object();
		b.productCode = data[i].productCode;
		b.productModelSize = data[i].productModelSize;
		b.productConfig = data[i].productConfig;
		_newdata.push(b);
	}
	data = _newdata;
    if (data.length <= 0) {
        msg({texts:'请先添加规格型号！'});
        return false;
    }
    ruleDivId = 'layerDivRule' + parseInt(100 * Math.random());
    $('#ruleform').append('<div id="' + ruleDivId+ '" style="display:none" >');
    $('#ruleform').append('</div>');
    layer.open({
                title : [ '新增规则','font-size:18pt;text-align:center' ],
                skin : 'layui-layer-cms',
                closeBtn : 2,
                offset : 'center', // 右下角弹出
                type : 1,
                area : [ '865px', '500px' ],// [width,height]
                content : $('#'+ruleDivId).load('../xiaoshou/xs_cpfb_rule.html',function(){
//                        var new_element=document.createElement("script");
//                        new_element.setAttribute("type","text/javascript");
//                        new_element.setAttribute("src","../js/xiaoshou/xs_cpfb_rule.js");
//                        document.body.appendChild(new_element);
                        $("table.-querytable").find("tr").height("auto");
                        $("table.-querytable").find("tr td").height("auto");
                    }),
                btn : [ '保存', '取消' ],
                yes : function(index, layero) {
                    var ruleId = $('#' + ruleDivId + ' #ruleId').val();
                    var ruleName = $('#' + ruleDivId + ' #ruleName').val();
                    var updateTime = $('#' + ruleDivId + ' #updateTime').val();
                    var updator = $('#' + ruleDivId + ' #updator').val();
                    var applyProductType = $('#' + ruleDivId + ' #applyProductType').val();
                    var sellType = $('#'+ ruleDivId+ ' #sellType input[name="sellType"]:checked').val();
                    var deposit = $('#' + ruleDivId + ' #deposit').val();
                    var payType = $('#'+ ruleDivId+ ' #payType input[name="payType"]:checked').val();
                    var produceDutyExplain = $('#' + ruleDivId + ' #produceDutyExplain').val();
                    var traderDutyExplain = $('#' + ruleDivId + ' #traderDutyExplain').val();
                    var aftermarketExplain = $('#' + ruleDivId + ' #aftermarketExplain').val();
                    var len = $('#table_2').bootstrapTable('getData').length;
                    var arealen = $('#' + ruleDivId+ " span[class$='rule-tip']").length;
                    var ruleArea = "";
                    var ruleAreaCode = "";
                    $('#' + ruleDivId + " span[class$='rule-tip']").each(
                        function(i) {
                            var value = $(this).attr('value'); // 这里的value就是每一个input的value值~
                            var code = $(this).attr('data-id');
                            if (i != arealen - 1) {
                                ruleArea += value+ ",";
                                ruleAreaCode += code+ ",";
                            } else {
                                ruleArea += value;
                                ruleAreaCode += code;
                            }
                    });
                    if (ruleArea == '') {
                        msg({texts:'销售区域不能为空！'});
                        return false;
                    }

                    var priceData = $('#' + ruleDivId + ' #table_3').bootstrapTable('getData');
                    var rulePrice = {};
                    for (var j = 0; j < priceData.length; j++) {
                        var priceRow = priceData[j];
                        rulePrice[priceRow.productCode] = priceRow.rulePrice;
                        if (priceRow.rulePrice == undefined) {
                            msg({texts:'价格不能为空！'});
                            return false;
                        }
                    }
                    var row = {
                        id : len + 1,
                        ruleId:ruleId,
                        ruleName : ruleName,
                        updateTime : updateTime,
                        updator : updator,
                        applyProductType : applyProductType,
                        sellType : sellType,
                        rulePrice : rulePrice,
                        payType : payType,
                        deposit : deposit,
                        produceDutyExplain : produceDutyExplain,
                        traderDutyExplain : traderDutyExplain,
                        aftermarketExplain : aftermarketExplain,
                        ruleArea : ruleArea,
                        rulePrice : rulePrice,
                        ruleAreaCode : ruleAreaCode,
                        ruleDivId : ruleDivId
                    };

                    // 向table_2添加数据
                    $('#table_2').bootstrapTable('insertRow', {
                        index : len + 1,
                        row : row
                    });
                    layer.close(index);
                },
                no : function(index, layero) {
                    layer.close(index);
                }
            });
});
/**
 * 产品发布
 */
$('#cpfb').click(function() {
    $('#state').val(202);
    cp_post();
});

/**
 * 产品暂存
 */
$('#cpzc').click(function(){
    $('#state').val(201);
    cp_post();
});

/**
 * 产品保存
 * @returns {boolean}
 */
function cp_post(){
    var productName = $('#productName').val();
    $('#setIntroduce2').val(TransferString($('#setIntroduce').val()));
    var productData = $('#table_1').bootstrapTable('getData');
    var ruleData = $('#table_2').bootstrapTable('getData');
    $('#productStyleName').val($('#productStyleId option:checked').text());
    if (productName == '') {
        msg({texts:'产品名称不能为空!'});
        return false;
    }
    if (productData.length <= 0) {
        msg({texts:'规格型号列表不能为空!'});
        return false;
    }
    if (ruleData.length <= 0) {
        msg({texts:'销售规则列表不能为空!'});
        return false;
    }
    $('#productBeanStr').val(JSON.stringify(productData));
    $('#productSellRuleStr').val(JSON.stringify(ruleData));

    $("#main input[type$='file']").each(function(i) {
        $(this).attr('name', 'mainProductPic');
    });
    $('#brandName').val($('#brandId option:selected').text());
    $('#productSetName').val($('#productSetId option:selected').text());
    var productTypeName='';
    $('#element_id select[name=productTypeId]').each(function(e){
        if ($('#'+$(this).attr('id')+' option:selected').val()!=null&&$('#'+$(this).attr('id')+' option:selected').val()!=''){
            productTypeName+=$('#'+$(this).attr('id')+' option:selected').text()+',';
        }
    });
    productTypeName=productTypeName.length>0?productTypeName.substr(0,productTypeName.length-1):productTypeName;
    $('#productTypeName').val(productTypeName);
    loading();
    //return;
    var options={
        url:'../product/addMainProduct',
        type:'post',
        dataType:'json',
        success:function(data){
            closeLoading();
            if (data.success){
                msg({
                    texts:data.msg,
                    fn:function(){
                        changeContent('../xiaoshou/xs_cpxxgl.html','right');
                    }
                });
            }else {
                layer.msg(data.msg, {icon: 2});
            }
        }
    };
    loading();
    $('#cpxsform').ajaxSubmit(options);
    //$.kyPost('cpxsform',_commonUrl+'/product/addMainProduct',
    //    function(data) {
    //        closeLoading();
    //    });
}

// 编辑产品
function show(id, productCodeBefore, indexBefore) {
	var tag = true;
	var content;
	if (id == 'undefined') {
        _randomId = 'layerDiv' + parseInt(100 * Math.random());
		$('#cpxsform').append('<div id="' + _randomId + '" style="display:none" >');
		$('#cpxsform').append('</div>');
		tag = false;
	}
	if (tag) {
        _randomId=id;
		content = $('#' + _randomId).css('display', 'block');
	} else {
		var row = $('#table_1').bootstrapTable('getRowByUniqueId',productCodeBefore);
		content = $('#' + _randomId).load('../xiaoshou/xs_cpfb_mx.html',
            function() {
                $('#' + _randomId + ' #productCode').val(row.productCode);
                $('#' + _randomId + ' #oldProductCode').val(row.productCode);
                $('#' + _randomId + ' #productId').val(row.id);
                $('#' + _randomId + ' #productModelSize').val(row.productModelSize);
                $('#' + _randomId + ' #warehouseBalance').val(row.warehouseBalance);
                $('#'+_randomId+' #unitId').val(row.unitId);
                $('#' +_randomId+ ' #industryId').val(row.industryName);
                $('#' +_randomId+ ' #industryId').attr('data-id',row.industryId);
                $('#' +_randomId+ ' #ipoTime').val(row.ipoTime);
                var _docArray = new Array();
                var _keyArray = new Array();
                for (var i=0;i<row.productDocBeanList.length;i++){
                    var productDoc = row.productDocBeanList[i];
                    _docArray.push(productDoc.fileUrl);
                    _keyArray.push(productDoc.id);
                }
                if (_docArray.length!=0){
                    $('#'+_randomId+' #uploadList').loadPreview({
                        imgArray:_docArray,
                        keyArray:_keyArray,
                        update:true,
                        delObject:$('#'+_randomId+" #delProductFileKeys")
                    });
                }

                // 参数配置.....
                var config = row.productConfig.split(',');
                for (var i = 0; i < config.length; i++) {
                    if (config[i]!=''){
                        var tip = config[i].split(':');
                        var number = parseInt(100 * Math.random());
                        var tipcon = '<div class="collocate" id="'+number+ '">'
                            + '<span>参数名称：<input type="text" id="configName2"  class="cmao_inplg" value="'
                            + tip[0]
                            + '"/></span>'
                            + '<span class="collocate-tow">参数值： <input type="text" id="configValue2" class="cmao_inplg" value="'
                            + tip[1] + '"/></span>'
                            + '<a href="javascript:void(0)" onclick="delConfig(this)">删除</a>' + '</div>';
                        $('#' + _randomId + ' #configArea').append(tipcon);
                    }
                }
            });
	}
	 layer.open({
         title : [ ' 编辑产品', 'font-size:18pt;text-align:center' ],
         skin : 'layui-layer-cms',
         closeBtn : 2,
         offset : 'center', //右下角弹出
         type : 1,
         area : [ '865px', '500px' ],//[width,height]
         content : content,
         btn : [ '保存', '取消' ],
         yes : function(index, layero) {
             //table_1添加row
             var delProductFileKeys = $('#' + _randomId+" #delProductFileKeys").val();
             var productCode = $('#'+_randomId+' #productCode').val();
             var oldProductCode = $('#'+_randomId+' #oldProductCode').val();
             var productId = $('#'+_randomId+' #productId').val();
             var productModelSize = $('#'+_randomId+' #productModelSize').val();
             var warehouseBalance = $('#'+_randomId+' #warehouseBalance').val();
             var unitId = $('#'+_randomId+' #unitId').val();
             var unitName = $('#'+_randomId+' #unitId option:selected').text();
             var industryName = $('#'+_randomId+' #industryId').val();
             var industryId = $('#'+_randomId+' #industryId').attr('data-id');
             var ipoTime = $('#'+_randomId+' #ipoTime').val();
             var productConfig = "";
             //校验是否为空
             if(productCode == ''){
                 msg({texts:'产品编码不能为空！'});
                 return false;
             }
             if (productCode!=oldProductCode){
                 var realrow = $('#table_1').bootstrapTable('getRowByUniqueId', productCode);
                 if (realrow != undefined) {
                     msg({texts:'产品编码重复！'});
                     return false;
                 }
             }
             var len = $('#table_1').bootstrapTable('getData').length;
             //组装属性参数
             var productConfigObj = {};
             var productConfigName = [];
             var productConfigValue = [];
             var productConfigKey = '';
             //组装参数名称
             $('#'+_randomId+" #configArea #configName2").each(function(i){
                 var value = $(this).val(); //这里的value就是每一个input的value值~
                 productConfigName.push(value);
             });
             //组装参数值
             $('#'+_randomId+" #configArea #configValue2").each(function(i){
                 var value = $(this).val(); //这里的value就是每一个input的value值~
                 productConfigValue.push(value);
             });
             for(var i=0;i<productConfigName.length;i++){
                 if(i != productConfigName.length-1){
                     productConfig += productConfigName[i]+":"+productConfigValue[i]+",";
                     productConfigKey += productConfigName[i]+",";
                 }else{
                     productConfig += productConfigName[i] + ":"+productConfigValue[i];
                     productConfigKey += productConfigName[i];
                 }
                 productConfigObj[productConfigName[i]]=productConfigValue[i];
             }
             //组装参数名称
             productConfigObj['key']= productConfigKey;
             var productPicName = 'productPic'+ parseInt(100*Math.random());
             $('#'+_randomId+" input[type$='file']").each(function(i){
                $(this).attr('name',productPicName);
             });
             var row = {
                 id : productId,
                 productCode : productCode,
                 productModelSize : productModelSize,
                 warehouseBalance : warehouseBalance,
                 unitId : unitId,
                 unitName:unitName,
                 industryId : industryId,
                 industryName:industryName,
                 ipoTime : ipoTime,
                 productConfig : productConfig,
                 productPicName : productPicName,
                 productConfigObj : productConfigObj,
                 productDivId : _randomId,
                 delProductFileKeys:delProductFileKeys
             };
             $('#table_1').bootstrapTable('updateByUniqueId',{id:oldProductCode,row:row});
             layer.close(index);
             //$('#'+id).css('display','none');
         },
         no : function(index, layero) {
             $('#' + _randomId+" #delProductFileKeys").val('');
             layer.close(index);
         }
	 });
}
// 编辑规则
function showRuleDiv(id, indexBefore) {
	var tag = true;
	var content;
	ruleDivId = id;
	var row = $('#table_2').bootstrapTable('getRowByUniqueId', indexBefore);
	if (ruleDivId == 'undefined') {
		ruleDivId = 'layerDivRule' + parseInt(100 * Math.random());
		$('#ruleform').append('<div id="' + ruleDivId+ '" style="display:none" >');
		$('#ruleform').append('</div>');
		tag = false;
	}
	if (tag) {
		content = $('#' + ruleDivId).css('display', 'block');
	} else {
        _updateFlag=true;
		content = $('#' + ruleDivId).load('../xiaoshou/xs_cpfb_rule.html?update=true',
                function() {
                    var new_element=document.createElement("script");
                    new_element.setAttribute("type","text/javascript");
                    var _data = $('#table_1').bootstrapTable('getData').concat();
                    var rulePriceList = row.rulePrice;
                    ruleIdBefore = row.ruleId;
                    for (var i=0;i<_data.length;i++){
                        _data[i].rulePrice=rulePriceList[_data[i].productCode];
                    }
                    data=_data;
//                    new_element.setAttribute("src","../js/xiaoshou/xs_cpfb_rule.js");
//                    document.body.appendChild(new_element);
                    $('#ruleArea').attr('id','ruleArea_'+ruleDivId);//修改ruleArea id
                    $('#'+ruleDivId+' #ruleId').multiselect({
                        onLoadSuccess:function(option, checked){
                            $('#'+ruleDivId+' #ruleId').multiselect('select',row.ruleId);
                        }
                    });
                    //初始化参数
                    $('#'+ruleDivId+' #deposit').val(row.deposit);
                    $('#'+ruleDivId+' #updateTime').val(row.updateTime);
                    $('#'+ruleDivId+' #updator').val(row.updator);
                    $('#'+ruleDivId+' #applyProductType').val(row.applyProductType);
                    $('#'+ruleDivId+' #produceDutyExplain').val(row.produceDutyExplain);
                    $('#'+ruleDivId+' #traderDutyExplain').val(row.traderDutyExplain);
                    $('#'+ruleDivId+' #aftermarketExplain').val(row.aftermarketExplain);

                    // 重置radio框值
                    $('#' + ruleDivId + " input[name$='sellType']").each(function(i) {
                        var value = $(this).val();
                        if (value == row.sellType)
                            $(this).attr("checked", "checked");
                        else
                            $(this).attr("checked", false);
                    });
                    if (row.sellType==8){
                        $('#'+ruleDivId+' #deposit').css('display',true);
                    }
                    $('#' + ruleDivId + " input[name$='payType']").each(function(i) {
                        var value = $(this).val();
                        if (value == row.payType)
                            $(this).attr("checked", "checked");
                        else
                            $(this).attr("checked", false);
                    });

                    var tipcon = '<div class="area-tip-input">' +
                        '<span class="rule-tip" value="{0}" data-id="{1}">{2}</span>' +
                        '<span class="del"></span>' +
                        '</div>';
                    var ruleAreaCodeArray = row.ruleAreaCode.split(',');
                    var ruleAreaNameArray = row.ruleArea.split(',');
                    for (var j=0;j<ruleAreaCodeArray.length;j++){
                        $('#ruleArea_'+ruleDivId).append($.formatString(tipcon,ruleAreaNameArray[j],ruleAreaCodeArray[j],ruleAreaNameArray[j]));
                    }
                    if ($('.del').length>0){
                        $('.del').click(function () {
                            $(this).parent().remove();
                        });
                    }
                });
	}

	// 重置radio框值
	$('#' + ruleDivId + " input[name$='sellType']").each(function(i) {
		var value = $(this).val();
		if (value == row.sellType)
			$(this).attr("checked", "checked");
		else
			$(this).attr("checked", false);
	});
	$('#' + ruleDivId + " input[name$='payType']").each(function(i) {
		var value = $(this).val();
		if (value == row.payType)
			$(this).attr("checked", "checked");
		else
			$(this).attr("checked", false);
	});
	layer.open({
				title : [ '编辑规则', 'font-size:18pt;text-align:center' ],
				skin : 'layui-layer-cms',
				closeBtn : 2,
				offset : 'center', // 右下角弹出
				type : 1,
				area : [ '865px', '500px' ],// [width,height]
				content : content,
				btn : [ '保存', '取消' ],
				yes : function(index, layero) {
					var ruleId = $('#' + ruleDivId + ' #ruleId').val();
					var ruleName = $('#' + ruleDivId + ' #ruleName').val();
					var updateTime = $('#' + ruleDivId + ' #updateTime').val();
					var updator = $('#' + ruleDivId + ' #updator').val();
					var applyProductType = $('#' + ruleDivId + ' #applyProductType').val();
					var sellType = $('#'+ ruleDivId+ ' #sellType input[name="sellType"]:checked').val();
					var deposit = $('#' + ruleDivId + ' #deposit').val();
					var payType = $('#' + ruleDivId+ ' #payType input[name="payType"]:checked').val();
					var produceDutyExplain = $('#' + ruleDivId + ' #produceDutyExplain').val();
					var traderDutyExplain = $('#' + ruleDivId + ' #traderDutyExplain').val();
					var aftermarketExplain = $('#' + ruleDivId + ' #aftermarketExplain').val();
					var len = $('#table_2').bootstrapTable('getData').length;
					var arealen = $('#' + ruleDivId + " .rule-tip").length;
					var ruleArea = "";
					var ruleAreaCode = "";
					$('#' + ruleDivId + " .rule-tip").each(function(i) {
						var value = $(this).attr("value"); // 这里的value就是每一个input的value值~
						var code = $(this).attr('data-id');
						if (i != arealen - 1) {
							ruleArea += value + ",";
							ruleAreaCode += code + ",";
						} else {
							ruleArea += value;
							ruleAreaCode += code;
						}
					});
                    if (ruleArea == '') {
                        msg({texts:'销售区域不能为空！'});
                        return false;
                    }
					var priceData = $('#' + ruleDivId + ' #table_3').bootstrapTable('getData');
					var rulePrice = {};
					for (var j = 0; j < priceData.length; j++) {
						var priceRow = priceData[j];
						rulePrice[priceRow.productCode] = priceRow.rulePrice;
                        if (priceRow.rulePrice==undefined||priceRow.rulePrice=='') {
                            msg({texts:'价格不能为空！'});
                            return false;
                        }
					}
					var row = {
						id : indexBefore,
						ruleId:ruleId,
						ruleName : ruleName,
						updateTime : updateTime,
						updator : updator,
                        applyProductType : applyProductType,
						sellType : sellType,
						rulePrice : rulePrice,
						payType : payType,
						deposit : deposit,
						produceDutyExplain : produceDutyExplain,
						traderDutyExplain : traderDutyExplain,
						aftermarketExplain : aftermarketExplain,
						ruleArea : ruleArea,
						ruleAreaCode : ruleAreaCode,
						productDivId : ruleDivId
					}
					// 向table_2添加数据
					$('#table_2').bootstrapTable('updateByUniqueId', {
						id : indexBefore,
						row : row
					});
					layer.close(index);
				},
				no : function(index, layero) {
					layer.close(index);
				}
			});

}
// 删除规则
function delRule(id) {
	$('#table_2').bootstrapTable('removeByUniqueId', id);
    $('#delProductRuleIds').val(id+','+$('#delProductRuleIds').val());
}
//编辑品牌
$("#brandEdit").click(function(){
	layer.open({
		title : [ '编辑品牌', 'text-align:center'],
		skin : 'layui-layer-cms',
		closeBtn : 2,
		offset : 'center', // 右下角弹出
		type : 1,
		area : [ '500px', '400px' ],
		content : $("#brandBox").load('../xiaoshou/xs_compBrand.html')
	
	});
});

//$("#productEdit").click(function(){
//	layer.open({
//		title : [ '编辑品牌', 'text-align:center'],
//		skin : 'layui-layer-cms',
//		closeBtn : 2,
//		offset : 'center', // 右下角弹出
//		type : 1,
//		area : [ '500px', '400px' ],
//		content : $("#productBox").load('../xiaoshou/xs_compBrand.html'),
//		btn : [ '保存', '取消' ],
//		yes : function(index,layero){
//			layer.close(index);
//		},
//		no : function(index,layero){
//			layer.close(index);
//		}
//	});
//});
$('#tabProduct').bootstrapTable({
	pagination : true,// 是否显示分页
	queryParamsType : '',// 传递参数
	sidePagination : "client",// 分页方式：client客户端分页，server服务端分页
	uniqueId : "productCode",// 每一行的唯一标识，一般为主键列
	columns : [
			{
				title : '名称'
			},
			{
				title : '操作',
				field : 'action',
				formatter : function(value, row, index) {
					return '<a href="javascript:void(0);">编辑</a> | <a href="javascript:void(0);">删除</a>';
				}
			} ]
});