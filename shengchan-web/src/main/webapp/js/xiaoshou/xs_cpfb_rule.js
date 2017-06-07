//加载销售规则

$('#'+ruleDivId+' #ruleId').multiselect({
    nonSelectedText:'请选择',
    onChange : function(option, checked) {
    	var id = option[0].value;
    	loadDeatail(id);
    },
	onLoadSuccess:function(option, checked){
		var selectContet = $('#'+ruleDivId+' #ruleId').multiselect('getSelected')
		var selectOption = selectContet[0];
		var labelOption = selectOption[0];
		loadDeatail(labelOption.value);
	}
});
$('#'+ruleDivId+' .sellType').change(function(){
    var _select = $('#'+ruleDivId+' .sellType:checked').val();
    if (_select==8){
        console.log($('#'+ruleDivId+' .bzj'));
        $('#'+ruleDivId+' .bzj').show();
    }else {
        $('#'+ruleDivId+' .bzj').hide();
    }
});
$('#'+ruleDivId+' #ruleId').multiselect('url','../product/getAllSaleRule');
$('#ruleArea').attr('id','ruleArea_'+ruleDivId);//修改ruleArea id
//根据销售规则ID 加载其余信息
function loadDeatail(id){
	  $.ajax({
	      url: "../product/getSaleRuleById",
	      datatype: 'json',
	      type: "Post",
	      data: {id:id},
	      async: true,//使用同步的方式,true为异步方式
	      success: function (data) {
	        if (data != null) {
	            $('#'+ruleDivId+' #ruleName').val(data.compSaleRuleBean.rule.ruleName);
	            $('#'+ruleDivId+' #ruleDate').val(data.compSaleRuleBean.rule.ruleTime);
	            $('#'+ruleDivId+' #ruleUser').val(data.compSaleRuleBean.rule.creator);
	            $('#'+ruleDivId+' #applyProductType').val(data.compSaleRuleBean.rule.applyType);
                $('#'+ruleDivId+" input[name$='sellType']").each(function(i){
           		    var value = $(this).val(); 
           		    if(value == data.compSaleRuleBean.rule.saleType)
           			 $(this).attr("checked","checked");
           		    else
           		     $(this).attr("checked",false);
               	});
                if (data.compSaleRuleBean.rule.saleType==8){
                    $('#'+ruleDivId+' .bzj').show();
                }else {
                    $('#'+ruleDivId+' .bzj').hide();
                }
	          	$('#'+ruleDivId+" input[name$='payType']").each(function(i){
           		    var value = $(this).val(); 
           		    if(value == data.compSaleRuleBean.rule.payWay)
           			$(this).attr("checked","checked");
           		 	else
           		     $(this).attr("checked",false);
           		});
	            $('#'+ruleDivId+' #deposit').val(data.compSaleRuleBean.rule.bail);
	            $('#'+ruleDivId+' #produceDutyExplain').val(data.compSaleRuleBean.rule.proRight);
	            $('#'+ruleDivId+' #traderDutyExplain').val(data.compSaleRuleBean.rule.busiRight);
	            $('#'+ruleDivId+' #aftermarketExplain').val(data.compSaleRuleBean.rule.customerService);
			}
	      }
	    });
}
//选择区县

$('#'+ruleDivId+" input[city=true]").click(function (e) {
    var tipcon = '<div class="area-tip-input city-fb">' +
            '<span class="rule-tip" value="{0}" data-id="{1}">{2}</span>' +
            '<span class="del"></span>' +
            '</div>';
    SelCity(this,e,{
        'divId':'ruleArea_'+ruleDivId,
        'appendHtml':tipcon,
        'positions':'fixed'
    });
});
//规格型号列表
$('#'+ruleDivId+' #table_3').bootstrapTable({
	data:data,
	editable:true,//开启编辑模式
	pagination : true,//是否显示分页
	queryParamsType : '',//传递参数
	sidePagination : "client",//分页方式：client客户端分页，server服务端分页
	uniqueId: "productCode",//每一行的唯一标识，一般为主键列
	columns : [{
        field: 'number',
        title: '序号',
        formatter: function (value, row, index) {
            return index+1;
        }
    }, {
		title : '产品编码',
		field : 'productCode'
	}, {
		title : '规格型号',
		field : 'productModelSize'
	}, {
		title : '参数配置',
		field : 'productConfig'
	}, {
		title : '销售价格',
		editable:true,
		field : 'rulePrice'
	},{
		title : '操作',
		field : 'action',
		formatter : function(value, row, index) {
			return '<a href="javascript:void(0);" onclick="delProductPrice(\''+row.productCode+'\')">删除</a>';
		}
	}]
});


//删除规格型号
function delProductPrice(id){
	$('#'+ruleDivId+' #table_3').bootstrapTable('removeByUniqueId', id);
}