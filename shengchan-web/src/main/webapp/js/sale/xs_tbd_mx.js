laydate({
    elem: '#priceExpiryTime',
    format: 'YYYY-MM-DD',
    min: laydate.now()
});
$('#priceExpiryTime').val(laydate.now());

$('#table_1').bootstrapTable({
    sidePagination: "client",//分页方式：client客户端分页，server服务端分页
    uniqueId: "id",//每一行的唯一标识，一般为主键列
    editable:true,
    columns : [ {
        field : 'Number',
        title : '序号',
        formatter : function(value, row, index) {
            return index + 1;
        }
    }, {
        title : '产品名称',
        field : 'productName'
    }, {
        title : '物资类别',
        field : 'productTypeName'
    }, {
        title : '规格型号',
        field : 'productModelSize'
    }, {
        title : '数量',
        field : 'count'
    }, {
        title : '单位',
        field : 'unitName'
    }, {
        title : '产品描述',
        field : 'description'
    },{
        title : '文档附件',
        field : 'docCot',
        formatter:function(value, row, index){
            var cot='';
            try{
                cot = row.purchaseTenderDetailDocList.length==0?'-':row.purchaseTenderDetailDocList.length;
            }catch (e){
                try{
                    if (row.docs!=''){
                        cot = row.docs.split(',').length;
                    }
                }catch (e){
                    cot=''
                }
            }
            if (cot==''||cot=='-'){
                return '-';
            }else {
                return $.formatString('<a class="a_css" href="javascript:void(0)" onclick="viewImg(\'{0}\')">'+cot+'</a>',row.id);
            }
        }
    }, {
        title : '报价单价',
        editable:true,
        field : 'offerPrice',
        otherFormatter:function(value,row){
            try{
                return value*row.count;
            }catch (e){
                return '';
            }
        }
    }, {
        title : '报价小计',
        total:true,
        field : 'offerSubtotal',
        formatter:function(value,rows,index){
            try{
                if (rows.count!=null&&rows.offerPrice!=null){
                    return parseInt(rows.count)*parseInt(rows.offerPrice);
                }else {
                    return '-';
                }
            }catch (e){
                return '-';
            }
        }
    }, {
        title : '交货日期',
        editable:true,
        width:'150px',
        edit:{
            type:'date',//日期
            layObj:{
                event: 'click', //触发事件
                format: 'YYYY-MM-DD',
                min: laydate.now() //-1代表昨天，-2代表前天，以此类推
            },
            required:false,
            click:function(){

            }
        },
        field : 'deliveryTime'
    },{
        title : '操作',
        field : 'action',
        formatter : function(value, row, index) {
            return $.formatString('<a class="a_css" href="javascript:void(0)" onclick="removeRow(\'{0}\')">删除</a>',row.id);
        }
    } ]
});

function removeRow(id){
    $('#delDetailIds').val($('#delDetailIds').val()+id+',');
    $('#table_1').bootstrapTable('removeByUniqueId',id);
}

$('#btn_submit').click(function(){
    var details = JSON.stringify($('#table_1').bootstrapTable('getData'));
    $('#details').val(details);
    form_post('saveSaleBidOrderFB');
});

$('#btn_zc').click(function(){
    var details = JSON.stringify($('#table_1').bootstrapTable('getData'));
    $('#details').val(details);
    form_post('saveSaleBidOrderZC');
});

function form_post(url){
    var options={
        url:"../saleBid/"+url,
        type:'post',
        dataType:'json',
        success:function(data){
            closeLoading();
            if (data.success){
                layer.msg(data.msg, {icon: 1});
                changeContent('../xiaoshou/xs_tbd.html','right');
            }else {
                layer.msg(data.msg, {icon: 2});
            }
        }
    };
    loading();
    $('#BidForm').ajaxSubmit(options);
}

function viewImg(id){
    var row=$('#table_1').bootstrapTable('getRowByUniqueId',id);
    var _docArray = row.docs.split(',');
    layer.open({
        type : 1,
        title : false,
        closeBtn : 0,
        shadeClose : true,
        area : [ '300px', '150px' ],
        skin : 'yourclass',
        content : '<div class="swiper-container" id="contentImg">' +
        '<div class="swiper-wrapper" id="detailDoc">' +
        '</div>' +
        '<div class="swiper-button-prev sides-btn"></div>' +
        '<div class="swiper-button-next sides-btn"></div>' +
        '</div>'
    });
    var imgSwiper = new Swiper('#contentImg', {
        observer : true,
        observeParents : true,
        spaceBetween : 10,
        slidesPerView : 3,
        onlyExternal : true,
        nextButton : '.swiper-button-next',
        prevButton : '.swiper-button-prev'
    });
    for (var i=0;i<_docArray.length;i++){
        var _div = '<div class="swiper-slide"><img src="'+_docArray[i]+'"> </div>';
        $('#detailDoc').append(_div);
    }
}
