var tableObj = {
    editable:true,//开启编辑模式
    clickToSelect: true,
    toolbar:'',
    pagination: true,//是否显示分页
    sidePagination: "client",//分页方式：client客户端分页，server服务端分页
    uniqueId: "id",//每一行的唯一标识，一般为主键列
    showFooter:true,
    onCheckAll:function(rows){
        try{
            var total=0;
            for (var i=0;i<rows.length;i++){
                total+=parseInt(rows[i].actuallyCount)*parseInt(rows[i].offerPrice);
            }
            $('#'+rows[0].randSpanId).text(total);
        }catch (e){}
    },
    onUncheckAll:function(rows){
        try{
            $('#'+rows[0].randSpanId).text(0);
        }catch (e){}
    },
    columns: [{
        checkbox: true,
        checkFormatter:function(row){
            $('#'+row.randSpanId).text(parseInt($('#'+row.randSpanId).text())+parseInt(row.actuallyCount)*parseInt(row.offerPrice));
        },
        cancelFormatter:function(row){
            $('#'+row.randSpanId).text(parseInt($('#'+row.randSpanId).text())-parseInt(row.actuallyCount)*parseInt(row.offerPrice));
        }
    },{
        title : '物资名称',
        clickToSelect:true,
        field : 'productName'
    },{
        title : '规格型号',
        field : 'productModelSize'
    },{
        title : '数量',
        editable:true,
        field : 'actuallyCount',
        otherFormatter:function(value,row){
            try{
                return value*row.offerPrice;
            }catch (e){
                return '';
            }
        }
    },{
        title : '交货日期',
        field : 'deliveryTime'
    },{
        title : '单价',
        field : 'offerPrice'
    },{
        title : '合计',
        field : 'offerSubtotal',
        total:true,
        formatter:function(value,rows,index){
            try{
                return parseInt(rows.actuallyCount)*parseInt(rows.offerPrice);
            }catch (e){
                return '-';
            }
        },
        footerFormatter:function(rows){
            var _randSpanId='span_Total_'+Math.round(Math.random()*10000);
            var total=0;
            for (var i=0;i<rows.length;i++){
                rows[i].randSpanId=_randSpanId;
                if (rows[i].saved){
                    total+=parseInt(rows[i].actuallyCount)*parseInt(rows[i].offerPrice);
                }
            }
            return '<span>合计：</span><span id="'+_randSpanId+'">'+total+'</span>';
        }
    }]
};

function getSaleBidOrderDetail(_divData,_divObj){
    $.ajaxLoad({
        url:'../purchaseTender/getSaleBidOrderDetail',
        data:{
            id:_divData.id
        },
        success:function(data){
            try{
                var _radDivId='Div_'+Math.round(Math.random()*10000);
                _divObj.data('_radDivId',_radDivId);
                _divObj.data('id',_divData.id);
                var _radTableId='table_'+Math.round(Math.random()*10000);
                var _radToolBarId='toolbar_'+Math.round(Math.random()*10000);
                var tableDiv='<div id="'+_radDivId+'"><div id="'+_radToolBarId+'" style="width: 100%">'+_divData.companyName+'</div><table id="'+_radTableId+'" ></table></div>';
                var new_tableObj = $.extend({
                    toolbar:_radToolBarId,
                    data:data
                },tableObj);
                $('#_tables').append(tableDiv);
                $('#'+_radTableId).bootstrapTable(new_tableObj);
                for (var i=0;i<data.length;i++){
                    var _obj=data[i];
                    if (_obj.saved){
                        $('#'+_radTableId).bootstrapTable('check',i);
                    }
                }
            }catch(e){}
        }
    });
}

$('#btn_zc,#btn_confirm').click(function(){
    var orderIds=[];
    var delOrderIds=[];
    $('.company-warp').each(function(){
        if ($(this).attr('check')){
            orderIds.push($(this).data('id'));
        }else {
            delOrderIds.push($(this).data('id'));
        }
    });
    var detailArray=[];
    var delDetail=[];
    $('table[id^="table_"]').each(function(){
        var _rows = $(this).bootstrapTable('getSelections');
        var _rows2 = $(this).bootstrapTable('getUnSelections');
        for (var i=0;i<_rows.length;i++){
            var _obj={
                id:_rows[i].id,
                actuallyCount:_rows[i].actuallyCount,
                saved:true
            };
            detailArray.push(_obj);
        }
        for (var i=0;i<_rows2.length;i++){
            var _obj={
                id:_rows2[i].id,
                saved:false
            };
            delDetail.push(_obj);
        }
    });
    var reviewFlag=false;
    if ($(this).attr('id')=='btn_confirm'){
        reviewFlag=true;
    }
    $.ajaxLoad({
        url:'../purchaseTender/saveReview',
        data:{
            delOrderIds:JSON.stringify(delOrderIds),
            orderIds:JSON.stringify(orderIds),
            delDetail:JSON.stringify(delDetail),
            detailArray:JSON.stringify(detailArray),
            reviewFlag:reviewFlag,
            purchaseTenderId:$('#purchaseTenderId').val()
        },
        success:function(data){
            if (data.success){
                layer.msg(data.msg, {icon: 1});
                changeContent('../caigou/c_zhaobiao.html','right');
            }else {
                layer.msg(data.msg, {icon: 2});
            }
        }
    });
});