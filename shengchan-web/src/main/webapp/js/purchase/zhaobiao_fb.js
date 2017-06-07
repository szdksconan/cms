var _cggzCompId='1313131313';//采购规则企业id

laydate({
    elem: '#endTime',
    event: 'click', //触发事件
    format: 'YYYY-MM-DD',
    min:laydate.now(),
    festival: true
});
$('#endTime').val(laydate.now());

laydate({
    elem: '#resultReleaseTime',
    event: 'click', //触发事件
    format: 'YYYY-MM-DD',
    min:laydate.now(),
    festival: true
});
$('#resultReleaseTime').val(laydate.now());

$("#deliverAddress").click(function (e) {
    SelCity(this,e);
});

$("input[city=true]").click(function (e) {
    var tipcon = '<div class="area-tip-input">' +
        '<span class="rule-tip" value="{0}" data-id="{1}">{2}</span>' +
        '<span class="del"></span>' +
        '</div>';
    SelCity(this,e,{
        'divId':'_areas',
        'appendHtml':tipcon
    });
});

_DetailInit();

/**
 * 初始化下拉框
 * @private
 */
function _DetailInit(){
    //$.cxSelect.defaults.emptyStyle = 'none';
    $('#'+_purchaseTenderDetailDivId+' #unitId').attr('data-value','10df55d1eb2941ce82c172bfbc595ad2');
    $('#'+_purchaseTenderDetailDivId+' #unitDiv').cxSelect({
        data:_zNodes,
        selects:['unitSelect']
    });

    $("#"+_purchaseTenderDetailDivId+" #element_id").cxSelect({
        url:'../js/common/productJson.json',
        selects : ['materials1','materials2','materials3','materials4'],
        nodata: 'none'
    });
}

$('#'+('btn_mx_add'+btn_mx_addRnd)).live('click',function(){
    //隐藏当前div clone一个全新的div 清楚新的div 并提取数据到table中
    var row={};
    row.DetailDivId=_purchaseTenderDetailDivId;
    $('#'+_purchaseTenderDetailDivId+' input[type=text],#'+_purchaseTenderDetailDivId+' input[type=hidden], #'+_purchaseTenderDetailDivId+' textarea, #'+_purchaseTenderDetailDivId+' select').each(function(){
        row[$(this).attr('name')]=$(this).val();
    });
    var productTypeId='';
    var productTypeName='';
    $('#'+_purchaseTenderDetailDivId+' #element_id select').each(function(){
        if ($('#'+_purchaseTenderDetailDivId+' #'+$(this).attr('id')+' option:selected').val()!=null&&$('#'+_purchaseTenderDetailDivId+' #'+$(this).attr('id')+' option:selected').val()!=''){
            productTypeId+=$('#'+_purchaseTenderDetailDivId+' #'+$(this).attr('id')+' option:selected').val()+',';
            productTypeName+=$('#'+_purchaseTenderDetailDivId+' #'+$(this).attr('id')+' option:selected').text()+',';
        }
    });
    row.id=$('#'+_purchaseTenderDetailDivId+' #purchaseTenderDetailId').val();
    row.productTypeId=productTypeId.length!=0?productTypeId.substr(0,productTypeId.length-1):'';
    row.productTypeName=productTypeName.length!=0?productTypeName.substr(0,productTypeName.length-1):'';
    if (row.productName==''||row.productName==null||row.productName==undefined){
        msg({
            texts:'产品名称不能为空！'
        });
        return false;
    }
    row.unitName=$('#'+_purchaseTenderDetailDivId+' #unitId option:selected').text();
    var len = $('#table_1').bootstrapTable('getData').length;
    if (typeof row.id=='undefined'||row.id==''){
        row.id=Math.floor(Math.random()*1000+1);
        $('#table_1').bootstrapTable('insertRow',{
            index:len+1,
            row:row
        });
    }else {
        $('#'+_purchaseTenderDetailDivId+' #purchaseTenderDetailId').val('');
        $('#table_1').bootstrapTable('updateByUniqueId',{
            id:row.id,
            row:row
        });
    }
    $('#'+_purchaseTenderDetailDivId).hide();
    //复制新div并清空之前的数据
    var _newDetailDiv=$('#'+_purchaseTenderDetailDivId).clone(true);
    $('#'+_purchaseTenderDetailDivId).parent().append(_newDetailDiv);
    _purchaseTenderDetailDivId='_ProductDiv'+new Date().getTime();
    _EmptyDetailDiv=_purchaseTenderDetailDivId;
    _purchaseTenderDetailDocName='purchaseTenderDetailDoc'+new Date().getTime();
    $(_newDetailDiv).attr('id',_purchaseTenderDetailDivId);
    $('#'+_purchaseTenderDetailDivId+' #purchaseTenderDetailDocName').val(_purchaseTenderDetailDocName);
    $('#'+_purchaseTenderDetailDivId+' input[type=text],#'+_purchaseTenderDetailDivId+' textarea').val('');
    $("#"+_purchaseTenderDetailDivId+" button[name=upload]").remove();
    $("#"+_purchaseTenderDetailDivId+" .statusBar").append('<button type="button" class="btn btn-blue upload-btn" name="upload">上传文件</button>');
    _FileId='fileId'+new Date().getTime();
    $("#"+_purchaseTenderDetailDivId+" button[name=upload]").uploadPreview({
        ListId : "#"+_purchaseTenderDetailDivId+" #uploadList",
        fileId:_FileId,
        fileName : _purchaseTenderDetailDocName
    });
    $('#'+_purchaseTenderDetailDivId+' #unitDiv').children().remove();
    $('#'+_purchaseTenderDetailDivId+' #wzlbDiv').children().remove();
    $('#'+_purchaseTenderDetailDivId+' #unitDiv').append('<select class="unitSelect selelct" id="unitId" name="unitId"></select>');
    $('#'+_purchaseTenderDetailDivId+' #wzlbDiv').append('<div id="element_id">' +
                                                        '<select class="materials1 selelct" id="productTypeId_1" name="productTypeId"></select>' +
                                                        '<select class="materials2 selelct" id="productTypeId_2" name="productTypeId"></select>' +
                                                        '<select class="materials3 selelct" id="productTypeId_3" name="productTypeId"></select>' +
                                                        '<select class="materials4 selelct" id="productTypeId_4" name="productTypeId"></select>' +
                                                        '</div>');
    _DetailInit();
    $('#'+_purchaseTenderDetailDivId+' #uploadList').children().remove();
    $(_newDetailDiv).show();
});

$("#companyPropertyDiv").cxSelect({
    data:_companyProperty,
    selects : ['companyPropertySelelct']
});
$("#operationModelDiv").cxSelect({
    data:_operationModel,
    selects : ['operationModelSelelct']
});
$("#creditGradeDiv").cxSelect({
    data:_creditGrade,
    selects : ['creditGradeSelelct']
});

/**
 * 编辑
 * @param id
 */
function editProduct(id){
    var row = $('#table_1').bootstrapTable('getRowByUniqueId',id);
    $('#'+_purchaseTenderDetailDivId).hide();
    _purchaseTenderDetailDivId=row.DetailDivId;
    $('#'+row.DetailDivId+' #purchaseTenderDetailId').val(row.id);
    $('#'+row.DetailDivId).show();
    var _state = $('#_detail').css('display');
    if (_state=='none'){
        showDetaiAdd();
    }
}

/**
 * 查看
 * @param id
 */
function viewProduct(id){
    var row = $('#table_1').bootstrapTable('getRowByUniqueId',id);
    $('#'+_purchaseTenderDetailDivId).hide();
    _purchaseTenderDetailDivId=row.DetailDivId;
    $('#'+row.DetailDivId+' #purchaseTenderDetailId').val(row.id);
    $('#'+row.DetailDivId).show();
    var _state = $('#_detail').css('display');
    if (_state=='none'){
        showDetaiAdd();
    }
}

/**
 * 删除明细
 * @param id
 */
function delProduct(id){
    var row = $('#table_1').bootstrapTable('getRowByUniqueId',id);
    $('#table_1').bootstrapTable('removeByUniqueId', id);
    $('#'+row.DetailDivId).remove();
    _purchaseTenderDetailDivId=_EmptyDetailDiv;
    $('#'+_EmptyDetailDiv).show();
}

$('#table_2').bootstrapTable({
    url:'../purchaseTender/getPurchaseSupplier',
    pagination: true,
    contentType:'application/x-www-form-urlencoded; charset=UTF-8',
    queryParamsType:'limit',
    sortOrder:'desc',
    queryParams:function(params){
        return {
            pageSize: params.limit,
            order:params.order,
            purchaseTenderOrderId:$('#purchaseTenderOrderId').val(),
            pageNumber: params.pageNumber
        };
    },
    sidePagination: "server",
    pageNumber:1,
    pageSize: 10,
    pageList: [10, 20],
    uniqueId: "companyId",//每一行的唯一标识，一般为主键列
    columns: [{
        field: 'Number',
        title: '序号',
        formatter: function (value, row, index) {
            return index+1;
        }
    },{
        title : '供应商名称',
        field : 'companyName'
    },{
        title : '企业性质',
        field : 'compType'
    },{
        title : '所属行业',
        field : 'mainIndustry'
    },{
        title : '经营模式',
        field : 'businessModel'
    },{
        title : '所在地区',
        field : 'address'
    },{
        title : '来源',
        field : 'infoSource'
    },{
        title : '信息送达',
        field : 'state',
        formatter:function(value,row){
            if (value){
                return '已发送';
            }else {
                return '未发送';
            }
        }
    }, {
        title: '操作',
        visible:_visible,
        field: 'action',
        formatter: function (value,row) {
            return $.formatString('<a class="a_css" href="javascript:void(0)" onclick="removeSupplier(\'{0}\')">删除</a>',row.companyId);
        }
    }]
});

function removeSupplier(id){
    $('#table_2').bootstrapTable('removeByUniqueId',id);
}

$('#btn_fb').click(function(){
    var _supplierArray = $('#table_2').bootstrapTable('getData')||[];
    var supplierArray=[];
    for (var i=0;i<_supplierArray.length;i++){
        _supplierArray[i].state=true;
        supplierArray.push(_supplierArray[i]);
    }
    $('#purchaseTenderOrderSupplierStr').val(supplierArray.length!=0?JSON.stringify(supplierArray):'');
    form_post('../purchaseTender/savePurchaseTenderFb');
});

$('#btn_zc').click(function(){
    var _supplierArray = $('#table_2').bootstrapTable('getData')||[];
    var supplierArray=[];
    for (var i=0;i<_supplierArray.length;i++){
        _supplierArray[i].state=false;
        supplierArray.push(_supplierArray[i]);
    }
    $('#purchaseTenderOrderSupplierStr').val(supplierArray.length!=0?JSON.stringify(supplierArray):'');
    form_post('../purchaseTender/savePurchaseTenderZc');
});

function form_post(url){
    if ($('#tab_jygz #guizename').val()==-1){
        layer.msg('交易规则不能为空！', {icon: 2});
        return ;
    }
    var applyTypeId='';
    var applyTypeName='';
    var ruleSourceId='';
    var ruleSourceName='';
    $('.applyType').each(function(){
        applyTypeId+=($(this).attr('data-id')==undefined?'':$(this).attr('data-id'))+',';
        applyTypeName+=$(this).text()+',';
    });
    applyTypeId=applyTypeId.length!=0?applyTypeId.substr(0,applyTypeId.length-1):applyTypeId;
    applyTypeName=applyTypeName.length!=0?applyTypeName.substr(0,applyTypeName.length-1):applyTypeName;
    $('#cggzDiv .rule-tip').each(function(){
        ruleSourceId+=$(this).attr('data-id')+',';
        ruleSourceName+=$(this).text()+',';
    });
    ruleSourceId=ruleSourceId.length!=0?ruleSourceId.substr(0,ruleSourceId.length-1):ruleSourceId;
    ruleSourceName=ruleSourceName.length!=0?ruleSourceName.substr(0,ruleSourceName.length-1):ruleSourceName;
    $('#ruleSourceId').val(ruleSourceId);
    $('#ruleSourceName').val(ruleSourceName);
    $('#applyTypeId').val(applyTypeId);
    $('#applyTypeName').val(applyTypeName);
    $('#deliverAddressId').val($('#deliverAddress').attr('data-id'));
    var _tenderAreaId='';
    var _tenderAreaName='';
    $('#_areas .area-tip-input .rule-tip').each(function(){
        _tenderAreaId+=$(this).attr('data-id')+',';
        _tenderAreaName+=$(this).attr('value')+',';
    });
    _tenderAreaId=_tenderAreaId.length!=0?_tenderAreaId.substr(0,_tenderAreaId.length-1):'';
    _tenderAreaName=_tenderAreaName.length!=0?_tenderAreaName.substr(0,_tenderAreaName.length-1):'';
    $('#purchaseTenderSourceId').val(_tenderAreaId);
    $('#purchaseTenderSourceName').val(_tenderAreaName);
    var _productArray=$('#table_1').bootstrapTable('getData');
    $('#purchaseTenderDetailArrayStr').val(_productArray.length!=0?JSON.stringify(_productArray):'');
    $('#describle').val(TransferString($('#describle').val()));
    if ($('input:radio[name="cyxz"]:checked').val()=='false'){
        $('#companyProperty').val('');
        $('#operationModel').val('');
        $('#creditGrade').val('');
        $('#purchaseTenderSourceId').val('');
        $('#purchaseTenderSourceName').val('');
    }
    var options={
        url:url,
        type:'post',
        dataType:'json',
        success:function(data){
            closeLoading();
            if (data.success){
                layer.msg(data.msg, {icon: 1});
                changeContent('../caigou/c_zhaobiao.html','right');
            }else {
                layer.msg(data.msg, {icon: 2});
            }
        }
    };
    loading();
    $('#_purchaseTenderForm').ajaxSubmit(options);
}

$('#btn_ch_1').click(function(){
    layer.open({
        title:['未完成物资需求','font-size:18pt;text-align:center'],
        skin: 'layui-layer-cms',
        closeBtn:2,
        offset: 'center', //右下角弹出
        type: 1,
        area: ['65%','550px'],
        content: $('#content').load('../caigou/SelfTransport.html'),
        btn:['确定','取消'],
        yes:function(index,layero){
            var _len = $('#table_1').bootstrapTable('getData');
            var rows = $('#needTable').bootstrapTable('getSelections');
            for (var i=0;i<rows.length;i++){
                var _obj = rows[i];
                _obj.id = Math.floor(Math.random()*1000+1);
                var DetailDivId = '_ProductDiv'+new Date().getTime();
                _obj.DetailDivId=DetailDivId;
                $('#table_1').bootstrapTable('insertRow',{
                    index:_len+i+1,
                    row:_obj
                });
                var _newDetailDiv=$('#'+_purchaseTenderDetailDivId).clone(true);
                _newDetailDiv.hide();
                $('#'+_purchaseTenderDetailDivId).parent().append(_newDetailDiv);
                $(_newDetailDiv).attr('id',_obj.DetailDivId);
                var _purchaseTenderDetailDocName='purchaseTenderDetailDoc'+new Date().getTime();
                $('#'+DetailDivId+' #purchaseTenderDetailDocName').val(_purchaseTenderDetailDocName);
                $('#'+DetailDivId+' input[type=text],#'+DetailDivId+' textarea').val('');
                $("#"+DetailDivId+" button[name=upload]").remove();
                $("#"+DetailDivId+" .statusBar").append('<button type="button" class="btn btn-blue upload-btn" name="upload">上传文件</button>');
                _FileId='fileId'+new Date().getTime();
                $("#"+DetailDivId+" button[name=upload]").uploadPreview({
                    ListId : "#"+DetailDivId+" #uploadList",
                    fileId:_FileId,
                    fileName : _purchaseTenderDetailDocName
                });
                $('#'+DetailDivId+' #unitDiv').children().remove();
                $('#'+DetailDivId+' #wzlbDiv').children().remove();
                $('#'+DetailDivId+' #unitDiv').append('<select class="unitSelect selelct viewReadOnly" id="unitId" name="unitId"></select>');
                $('#'+DetailDivId+' #wzlbDiv').append('<div id="element_id">' +
                '<select class="materials1 selelct viewReadOnly" id="productTypeId_1" name="productTypeId"></select>' +
                '<select class="materials2 selelct viewReadOnly" id="productTypeId_2" name="productTypeId"></select>' +
                '<select class="materials3 selelct viewReadOnly" id="productTypeId_3" name="productTypeId"></select>' +
                '<select class="materials4 selelct viewReadOnly" id="productTypeId_4" name="productTypeId"></select>' +
                '</div>');
                $('#'+DetailDivId+' input[name=productName]').val(_obj.productName);
                $('#'+DetailDivId+' input[name=productModelSize]').val(_obj.productModelSize);
                $('#'+DetailDivId+' input[name=count]').val(_obj.count);
                $.cxSelect.defaults.emptyStyle = 'none';
                $('#'+DetailDivId+' #unitId').attr('data-value',_obj.unitId);
                $('#'+DetailDivId+' #unitDiv').cxSelect({
                    data:_zNodes,
                    selects:['unitSelect']
                });
                var _productTypeIdArray=_obj.productTypeId.split(',');
                for (var j=0;j<_productTypeIdArray.length;j++){
                    $("#"+DetailDivId+" #productTypeId_"+(j+1)).attr('data-value',_productTypeIdArray[j]);
                }
                $("#"+DetailDivId+" #element_id").cxSelect({
                    url:'../js/common/productJson.json',
                    selects : ['materials1','materials2','materials3','materials4'],
                    nodata: 'none'
                });
                var _productDetailDocArray=_obj.needDetailDoc;
                var _detaildocArray = new Array();
                var _detailkeyArray = new Array();
                for (var j=0;j<_productDetailDocArray.length;j++){
                    var _doc=_productDetailDocArray[j];
                    _detaildocArray.push(_doc.fileUrl);
                    _detailkeyArray.push(_doc.id);
                }
                $('#'+DetailDivId+' #uploadList').children().remove();
                if (_detaildocArray.length!=0){
                    $('#'+DetailDivId+' #uploadList').loadPreview({
                        imgArray:_detaildocArray,
                        keyArray:_detailkeyArray,
                        update:true,
                        delObject:$('#'+DetailDivId+' #delFileKeys')
                    });
                }
                $('#'+DetailDivId+' #purchaseTenderDetailId').val(_obj.id);
            }
            layer.close(index);
        },
        no:function(index,layero){
            layer.close(index);
        }
    });
});

$('#btn_ch_2').click(function(){
    layer.open({
        title:['未完成采购的物资明细','font-size:18pt;text-align:center'],
        skin: 'layui-layer-cms',
        closeBtn:2,
        offset: 'center', //右下角弹出
        type: 1,
        area: ['65%','550px'],
        content: $('#content').load('../caigou/SelfTransport2.html')
    });
});

$('#selectVendor').click(function(){
    var btn=['确定','取消'];
    if (purchaseTender!=null){
        btn=['发送','取消'];
    }
    layer.open({
        title:['供应商名录','font-size:18pt;text-align:center'],
        skin: 'layui-layer-cms',
        closeBtn:2,
        offset: 'center', //右下角弹出
        type: 1,
        area: ['65%','550px'],
        content: $('#content').load('../caigou/cg_gysml.html'),
        btn:btn,
        yes:function(index,layero){
            var selections = $('#content #table').bootstrapTable('getSelections');
            var _rows=[];
            for (var i=0;i<selections.length;i++){
                var _obj={};
                _obj.companyId=selections[i].compid;
                _obj.companyName=selections[i].companyName;
                _obj.infoSource='邀请';
                _obj.compType=selections[i].compType;
                _obj.mainIndustry=selections[i].mainIndustry;
                _obj.businessModel=selections[i].businessModel;
                _obj.address=selections[i].address;
                if (purchaseTender!=null&&purchaseTender.state!=null&&purchaseTender.state==202){
                    _obj.state=true;
                }
                if (selections[i].compSuppliers.supplierType==0){
                    _obj.purchaseCompanyId=selections[i].compid;
                    _obj.purchaseCompanyName=selections[i].companyName;
                }else {
                    _obj.tradersId=selections[i].compid;
                    _obj.tradersName=selections[i].companyName;
                }
                _rows.push(_obj);
            }
            if (purchaseTender!=null&&purchaseTender.state!=null&&purchaseTender.state==202){
                var newRows = $('#table_2').bootstrapTable('getUnRowInTableByUniqueId',_rows);
                if (newRows!=0){
                    $.ajaxLoad({
                        url:'../purchaseTender/publishSupplier',
                        data:{
                            id:purchaseTender.id,
                            purchaseTenderOrderSupplierStr:JSON.stringify(newRows)
                        },
                        success:function(data){
                            if (data.success){
                                layer.msg(data.msg, {icon: 1});
                                $('#table_2').bootstrapTable('replaceByUniqueId',_rows);
                                layer.close(index);
                            }else {
                                layer.msg(data.msg, {icon: 2});
                            }
                        }
                    });
                }else {
                    layer.msg('发送成功！', {icon: 1});
                    layer.close(index);
                }
            }else {
                $('#table_2').bootstrapTable('replaceByUniqueId',_rows);
                layer.close(index);
            }
        },
        no:function(index,layero){
            layer.close(index);
        }
    });
});

$('#btn_review').click(function(){
    changeContent('../purchaseTender/reviewPage?id='+$('#purchaseTenderOrderId').val(),'right');
});

$('input[name=cyxz]').change(function(){
    if ($(this).val()=='true'){
        $('.cyxz').show();
    }else {
        $('.cyxz').hide();
    }
});

$('#tab_jygz').load('../guize/cggz.html');

function showDetaiAdd(){
    var state = $('#_detail').css('display');
    if(state == 'none'){
        $('#_detail').show(500);
        $('#expend').empty();
        $('#expend').append('∧收起');
    }else{
        $('#_detail').hide(500);
        $('#expend').empty();
        $('#expend').append('∨展开');
    }
}