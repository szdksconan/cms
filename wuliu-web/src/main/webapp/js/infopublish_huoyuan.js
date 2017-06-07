var cheyuanId,huoyuanId,cheyuanState=false,huoyuanState=false;//信息id
var list_title,info_title,huoyuanInfo;
$(function(){

    if (province.length>0){
        var html='<option value="0"></option>';
        for (var i=0;i<province.length;i++){
            html+='<option value="'+province[i].id+'">'+province[i].name+'</option>';
        }
        $('#begin_huoyuan_province').append(html);
        $('#end_huoyuan_province').append(html);
    }

    $("#huoyuanfileInput").uploadPreview({ Img: "ImgPr", Width: 200, Height: 200 });
    /**
     * 初始化货源类型
     */
    $('#packageType').combobox({
        url: 'common/getGoodsDicInfoList?pid=20',
        mode: 'remote',
        valueField:'id',
        textField:'name',
        panelHeight:true,
        editable:false,
        onHidePanel:function(){

        },
        onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            if (val.length!=0&&val[0].id){
                $(this).combobox("select", val[0].id);
                if ($('#packageType2').val()!=null&&$('#packageType2').val()!=''){
                    $(this).combobox("select", $('#packageType2').val());
                }
            }
        }
    });

    /**
     * 新增货源
     */
    $('#huoyuanform').form({
        url : 'infopublish/addHuoyuan',
        onSubmit : function() {
            var huoyuanbeginProvinceName=$('#begin_huoyuan_province').find('option:selected').text();
            $('#beginProvinceName').val(huoyuanbeginProvinceName);
            var huoyuanbeginAreaName=$('#begin_huoyuan_area').find('option:selected').text();
            $('#beginAreaName').val(huoyuanbeginAreaName);
            var huoyuanbeginCityName=$('#begin_huoyuan_city').find('option:selected').text();
            $('#beginCityName').val(huoyuanbeginCityName);
            var huoyuanendProvinceName=$('#end_huoyuan_province').find('option:selected').text();
            $('#endProvinceName').val(huoyuanendProvinceName);
            var huoyuanendAreaName=$('#end_huoyuan_area').find('option:selected').text();
            $('#endAreaName').val(huoyuanendAreaName);
            var huoyuanendCityName=$('#end_huoyuan_city').find('option:selected').text();
            $('#endCityName').val(huoyuanendCityName);
            var startName=huoyuanbeginProvinceName+huoyuanbeginAreaName+huoyuanbeginCityName;
            var endName=huoyuanendProvinceName+huoyuanendAreaName+huoyuanendCityName;
            var obj = $.serializeObject($('#huoyuanform'));
            $('#huoyuaninfo').val(obj.goodsName+';'+$('#packageType').combobox('getText')+';'+obj.numbers+'件;'+obj.weight+'吨;'+obj.volume+'立方;'+obj.offer+'元/吨;'+obj.linkMan+';'+startName+' 至  '+endName+';'+$('#huoyuaninfo').val());
            huoyuanInfo = $('#huoyuaninfo').val();
            return true;
        },
        success : function(result) {
            result = $.parseJSON(result);
            if (result.success) {
                $('#huoyuanform')[0].reset();
                huoyuanId = result.huoyuanId;
                alert(result.msg);
                //if (result.data.rows.length==0){
                //    alert(result.msg);
                //    return;
                //}
                //if (confirm(result.msg)){
                //    huoyuanId=result.huoyuanId;
                //    list_title='推荐车源';
                //    openList_huoyuan('cheyuan',result.data);
                //}else {
                //    huoyuanId=result.huoyuanId;
                //    list_title='推荐车源';
                //    openList_huoyuan('cheyuan',result.data);
                //}
            }else {
                alert(result.msg);
            }
        }
    });
});

var cheyuanCol2 = [{
    field : 'id',
    sortable : true,
    hidden:true
},  {
    width : fixWidth(0.1),
    title : '车牌号码',
    field : 'carNo',
    sortable : true
}/*,  {
    width : fixWidth(0.4),
    title : '路线',
    field : 'way',
    sortable : true
}*/,{
    width : fixWidth(0.1),
    title : '起始地',
    field : 'startWay',
    sortable : true
},{
    width : fixWidth(0.1),
    title : '目的地',
    field : 'endWay',
    sortable : true
},{
        width : fixWidth(0.4),
        title : '信息内容',
        field : 'info',
        formatter:function(value, row, index){
            return '<a href="javascript:void(0)" onclick="a_click_huoyuan(\''+index+'\',\'cheyuan\');" >'+value+'</a>';
        }
    },{
        width : fixWidth(0.1),
        title : '发布时间',
        field : 'createTime',
        sortable : true
    },{
    field : 'action',
    title : '联系方式',
    width : 220,
    align : 'center',
    formatter : function(value, row, index) {
        var str = '';
        // str += '<a href="javascript:void(0)" onclick="CallTel2(\''+row.id+'\',\'huoyuan\',\''+row.info+'\');" ><span style="color:red">拨打电话</span></a>', row.tel,row.tel1,row.tel2);
        var time1 = row.createTime;
        var time2 = new Date().Format("yyyy-MM-dd hh:mm:ss");
        var min = timeDifferent(time1,time2);
        var style="cursor: pointer;";
        if (row.listType==1){
            style+="color:red;";
        }
        if(min >= different)
            str += $.formatString(row.tel+'&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"openTime(\'gridTable_huoyuan\',\''+index+'\')\"   style=\"'+style+'\"><span>发送到手机</span></a>');
        else
            str += $.formatString('信息受保护状态&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"openTime(\'gridTable_huoyuan\',\''+index+'\')\"   style=\"'+style+'\"><span>查看剩余时间</span></a>');
        return str;
    }
}];

function openList_huoyuan(type,data) {
    if (data.rows.length==0){
        //return;
    }
    $('#lab_huoyuan1').html('<span style="color: red">货源信息:'+huoyuanInfo+"</span><br/>"+list_title);
    $('#infoPublish_huoyuan').show();
    $('#infoPublish_huoyuan').css('z-index',99);
    $('#infoPublish_huoyuan').css('background-color',"#dddddd");
    var columns=[cheyuanCol2];
    $('#gridTable_huoyuan').datagrid({
        data : data,
        height: 200,
        striped : true,
        rownumbers : true,
        pagination : false,
        fitColumns:true,
        idField : 'id',
        sortName : 'createTime',
        sortOrder : 'asc',
        columns:columns,
        onDblClickRow:function(rowIndex, rowData){
            info_title='车源信息';
            openInfo_huoyuan(JSON.stringify(rowData),type,rowData.id);
        }
    });
}

function a_click_huoyuan(index,type){
    var data = $('#gridTable_huoyuan').datagrid('getData');
    info_title='车源信息';
    openInfo_huoyuan(JSON.stringify(data.rows[index]),type,data.rows[index].id);
}

function openInfo_huoyuan(json,type,id) {
    cheyuanId = id;
    cheyuanState=false;
    huoyuanState=true;
    $('#lab_huoyuan2').html(info_title);
    $('#viewInfo_huoyuan').show();
    $('#viewInfo_huoyuan').css('z-index',99);
    $('#viewInfo_huoyuan').css('background-color',"#dddddd");
    $('#divInfo_huoyuan').load('infohall/infoHallPage',{"json":json,"type":type,"viewflag":false});
}

function infoconfirm(){
    var obj = {"cheyuanId":cheyuanId,"huoyuanId":huoyuanId,"cheyuanState":cheyuanState,"huoyuanState":huoyuanState};
    $.post('infopublish/infoconfirm',{"json":JSON.stringify(obj)},function(data){
        if (data.success){
            try{
                closeInfo('infoPublish');
                closeInfo('viewInfo');
                closeInfo('infoPublish_huoyuan');
                closeInfo('viewInfo_huoyuan');
                historyList.datagrid('reload');
            }catch(e){}
        }else {
            alert(data.msg);
        }
    });
}

function closeInfo_huoyuan(id){
    document.getElementById(id).style.display = "none";
}

function act_click(tel,id){
    openTelCheyuan(tel,id);
}

function openTelCheyuan(tel,id){
    if(confirm('拨打成功，是否达成交易意向？')){
        cheyuanId = id;
        cheyuanState=false;
        huoyuanState=true;
        infoconfirm();
    }
}