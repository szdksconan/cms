var historyData={};//历史记录data
var historyHuoyuanList;//历史记录datagrid
var cheyuanId,huoyuanId,cheyuanState=false,huoyuanState=false;//信息id
var list_title,info_title;//详情弹出框title
var cheyuanInfo,huoyuanInfo;
var dom_begin_province,dom_begin_area,dom_begin_city,dom_end_province,dom_end_area,dom_end_city;
var tag ;
$(function(){
    $("#loadHuoyuan").load("infopublish/loadHuoyuan");
    $("#cheyuanfileInput").uploadPreview({ Img: "carImg", Width: 200, Height: 200 });

    /**
     * 初始化身份
     */
    if (province.length>0){
        var html='<option value="0"></option>';
        for (var i=0;i<province.length;i++){
            html+='<option value="'+province[i].id+'">'+province[i].name+'</option>';
        }
        $('#begin_cheyuan_province').append(html);
        $('#end_cheyuan_province').append(html);
    }

    /**
     * 初始化车辆
     */
    $('#carId').combobox({
        url: 'common/getCarList',
        mode: 'remote',
        valueField:'id',
        textField:'car_no',
        panelHeight:true,
        editable:false,
        onHidePanel:function(){

        },
        onSelect:function(data){
        
            $('#zaizong').val(data.car_weigth);
            $('#chelinkMan').val(data.car_owner);
            $('#carImg').attr("src",data.car_pic_url);
            $('#carNo').val(data.car_no);
            $('#carOwner').val(data.car_owner);
            //$('#car_axle_name').val(data.car_axle_name);
            $('#car_container_id').val(data.car_container);
            $('#car_axle_id').val(data.car_axle);
            $('#car_container_name').val(data.car_container_name);
            $('#carTrafficTypeId').val(data.car_traffic_type);
            $('#carTrafficTypeName').val(data.carTrafficTypeName);
            $('#carTypeId').val(data.car_type);
            $('#carTypeName').val(data.carTypeName);
            $('#companyName').val(data.companyName);
            $('#begin_cheyuan_province').find("option:selected").attr("selected",false);
            $('#begin_cheyuan_area').find("option").remove();
            $('#begin_cheyuan_city').find("option").remove();
            $('#end_cheyuan_province').find("option:selected").attr("selected",false);
            $('#end_cheyuan_area').find("option").remove();
            $('#end_cheyuan_city').find("option").remove();
            $('#cheyuanProvinceAreaId').val();
            $.post('infopublish/getMainLine',{"id":data.id},function(data){
                if (data){
                    dom_begin_province=$('#begin_cheyuan_province');
                    dom_begin_area=$('#begin_cheyuan_area');
                    dom_begin_city=$('#begin_cheyuan_city');
                    dom_end_province=$('#end_cheyuan_province');
                    dom_end_area=$('#end_cheyuan_area');
                    dom_end_city=$('#end_cheyuan_city');
                    chooseAdd(data.begin_province_id,data.begin_area_id,data.begin_city_id,data.end_province_id,data.end_area_id,data.end_city_id,data.province_area_id);
                }
            });
        },
        onLoadSuccess: function () { //加载完成后,设置选中第一项
            var val = $(this).combobox("getData");
            if (val.length!=0&&val[0].id){
            	var carId2 =  $("#carId2").val();
            	var no = 0;
            	if(carId2 != ''){
            		for(var j=0;j<val.length;j++){
            			if(carId2 == val[j].id){
            				no = val.indexOf(val[j]);
            				break;
            			}
            		}
            	
            		
            	}
                $(this).combobox("select", val[no].id);
                $('#zaizong').val(val[no].car_weigth);
                $('#chelinkMan').val(val[no].car_owner);
                $('#carImg').attr("src",val[no].car_pic_url);
                $('#carNo').val(val[no].car_no);
                $('#carOwner').val(val[no].car_owner);
                //$('#car_axle_name').val(val[0].car_axle_name);
                $('#car_container_name').val(val[no].car_container_name);
                $('#car_container_id').val(val[no].car_container);
                $('#car_axle_id').val(val[no].car_axle);
                $('#carTrafficTypeId').val(val[no].car_traffic_type);
                $('#carTrafficTypeName').val(val[no].carTrafficTypeName);
                $('#carTypeId').val(val[no].car_type);
                $('#carTypeName').val(val[no].carTypeName);
                $('#companyName').val(val[no].companyName);
                $.post('infopublish/getMainLine',{"id":val[no].id},function(data){
                    if (data){
                        dom_begin_province=$('#begin_cheyuan_province');
                        dom_begin_area=$('#begin_cheyuan_area');
                        dom_begin_city=$('#begin_cheyuan_city');
                        dom_end_province=$('#end_cheyuan_province');
                        dom_end_area=$('#end_cheyuan_area');
                        dom_end_city=$('#end_cheyuan_city');
                        chooseAdd(data.begin_province_id,data.begin_area_id,data.begin_city_id,data.end_province_id,data.end_area_id,data.end_city_id,data.province_area_id);
                    }
                });
            }
            	
        }
    });

    /**
     * 新增车源
     */
    $('#cheyuanform').form({
        url : 'infopublish/addCheyuan',
        onSubmit : function() {
            $('#carImgInp').val($('#carImg').attr('src'));
            var cheyuanbeginProvinceName=$('#begin_cheyuan_province').find('option:selected').text();
            $('#cheyuanbeginProvinceName').val(cheyuanbeginProvinceName);
            var cheyuanbeginAreaName=$('#begin_cheyuan_area').find('option:selected').text();
            $('#cheyuanbeginAreaName').val(cheyuanbeginAreaName);
            var cheyuanbeginCityName=$('#begin_cheyuan_city').find('option:selected').text();
            $('#cheyuanbeginCityName').val(cheyuanbeginCityName);
            var cheyuanendProvinceName=$('#end_cheyuan_province').find('option:selected').text();
            $('#cheyuanendProvinceName').val(cheyuanendProvinceName);
            var cheyuanendAreaName=$('#end_cheyuan_area').find('option:selected').text();
            $('#cheyuanendAreaName').val(cheyuanendAreaName);
            var cheyuanendCityName=$('#end_cheyuan_city').find('option:selected').text();
            $('#cheyuanendCityName').val(cheyuanendCityName);
            var startName=cheyuanbeginProvinceName+cheyuanbeginAreaName+cheyuanbeginCityName;
            var endName=cheyuanendProvinceName+cheyuanendAreaName+cheyuanendCityName;
            var obj = $.serializeObject($('#cheyuanform'));
            $('#cheyuaninfo').val(obj.carNo+';'+obj.car_container_name+";"+obj.weight+'吨;'+obj.offer+'元/吨;'+obj.linkMan+';'+startName+' 至  '+endName+';'+$('#cheyuaninfo').val());
            cheyuanInfo = $('#cheyuaninfo').val();
            return true;
        },
        success : function(result) {
        	var carId = $('#carId2').val();
            result = $.parseJSON(result);
            if (result.success) {
            	//关闭dialog
                cheyuanId = result.cheyuanId;
                $('#cheyuanform')[0].reset();
                alert(result.msg);
                //if (result.data.rows.length==0){
                //    alert(result.msg);
                //  	if(carId != ''){
                //		parent.$.modalDialog.handler.dialog('close');
                //	}
                //    return;
                //}
                //if (confirm(result.msg)){
                //  	if(carId != ''){
                //		parent.$.modalDialog.handler.dialog('close');
                //	}
                //    openList('huoyuan',result.data);
                //}else {
                //  	if(carId != ''){
                //		parent.$.modalDialog.handler.dialog('close');
                //	}
                //    openList('huoyuan',result.data);
                //}
            }else {
                alert(result.msg);
            }
        }
    });

    /**
     * 点击历史记录
     */
    $('#tab13').click(function(){
        historyHuoyuanList = $('#historyHuoyuanList').datagrid({
            url : 'infopublish/getHistoryList?type=huoyuan',
            striped : true,
            height:480,
            rownumbers : false,
            pagination : false,
            fitColumns:true,
            idField : 'id',
            sortName : 'createTime',
            sortOrder : 'asc',
            columns : [[{
                width : fixWidth(1),
                field : 'action',
                formatter : function(value, row, index) {
                    historyData[index]=row;
                    var info_type=(row.type==1?'huoyuan':'cheyuan');
                    var str = '<table style="width:100%;border:0px;">';
                    str+='<tr><td rowspan="3" style="width: 6%;"><img height="100" width="100" alt="图片丢失" onerror="javascript:this.src=\'http://pic17.nipic.com/20111109/8056482_004804322000_2.jpg\';" src="'+row.img+'"></td>';
                    str+='<td>发布时间<label>'+row.createTime+'</label>'+
                    '</td><td>'+(row.type==1?(row.state==1?'<div style="width: 50%;background-color: #bfbfbf;border-style: outset;border-width: 5px;"><span style="color: #11A860">产贸送平台物流报价：xxx元/吨。</span>'+'<a href="#" style="color:red" onclick="platformLogistics(\''+row.id+'\')">   立刻托运</a></div>':''):'')
                    //(row.id2?(row.type==1?(row.o_info==''?'':'<a href="#" style="color:red" onclick="showInfo(\''+row.o_id+'\',\''+info_type+'\')">承载车辆   '+row.o_info+'</a>'):
                    //    (row.o_info==''?'':'<a href="#" style="color:red" onclick="showInfo(\''+row.o_id+'\',\''+info_type+'\')">货物名称   '+
                    //    row.o_info+'</a>')):(row.relcot==0?'':'<a href="#" onclick="showRelationList(\''+row.id+'\',\''+(info_type)+'\')" style="color:red">'+(row.type==1?'有车源待确认':'有货源待确认')+'</a>'))
                    +'</td><td><a href="#" onclick="viewInfo('+index+')">查看 </a>'+(row.id2?'':('<a href="#" onclick="recommond('+index+',\''+(row.type==1?'cheyuan':'huoyuan')+'\')">推荐</a>'))+'</td></tr>';

                    str+='<tr><td>信息类型<label>'+(row.type==1?'货源':'车源 &nbsp;&nbsp;&nbsp;')+'</label>'+(row.type==1?'':'车牌号码<label>'+row.carNo+'</label>')+'</td><td>路线<label>'+row.way+'</label></td><td>'+(row.state=='1'?'已发布':(row.state=='2'?'已过期':'已成交'))+'</td></tr>';

                    str+='<tr><td colspan="2">信息内容<input style="width: 95%;" value="'+row.info+'"/></td><td>'+(row.state=='2'?'<a href="#" onclick="rePublish('+index+')">重新发布</a>':(row.state=='1'?'<a href="#" onclick="del_info(\''+row.id+'\',\''+info_type+'\')">删除</a>':''))+'</td></tr>';
                    str+='</table>';
                    return str;
                }
            }]]
        });
    });

    $('#tab11').click(function (){
        $("#loadHuoyuan").load("infopublish/loadHuoyuan");
    });
    $('#tab12').click(function (){
        $("#loadCheyuan").load("infopublish/loadCheyuan?id=");
    });
});

function changeTable(type){
	anyList2 = type;
    try{
        historyHuoyuanList.datagrid({
            url : 'infopublish/getHistoryList?type='+type,
            columns : [[{
                width : fixWidth(1),
                field : 'action',
                formatter : function(value, row, index) {
                    historyData[index]=row;
                    var info_type=(row.type==1?'huoyuan':'cheyuan');
                    var str = '<table style="width:100%;border:0px;">';
                    str+='<tr><td rowspan="3" style="width: 6%;"><img height="100" width="100" alt="图片丢失" onerror="javascript:this.src=\'http://pic17.nipic.com/20111109/8056482_004804322000_2.jpg\';" src="'+row.img+'"></td>';
                    str+='<td>发布时间<label>'+row.createTime+'</label>'+
                    '</td><td>'+(row.type==1?(row.state==1?'<div style="width: 50%;background-color: #bfbfbf;border-style: outset;border-width: 5px;"><span style="color: #11A860">产贸送平台物流报价：xxx元/吨。</span>'+'<a href="#" style="color:red" onclick="platformLogistics(\''+row.id+'\')">   立刻托运</a></div>':''):'')
                        //(row.id2?(row.type==1?(row.o_info==''?'':'<a href="#" style="color:red" onclick="showInfo(\''+row.o_id+'\',\''+info_type+'\')">承载车辆   '+row.o_info+'</a>'):
                        //(row.o_info==''?'':'<a href="#" style="color:red" onclick="showInfo(\''+row.o_id+'\',\''+info_type+'\')">货物名称   '+
                        //row.o_info+'</a>')):(row.relcot==0?'':'<a href="#" onclick="showRelationList(\''+row.id+'\',\''+(info_type)+'\')" style="color:red">'+(row.type==1?'有车源待确认':'有货源待确认')+'</a>'))
                    +'</td><td><a href="#" onclick="viewInfo('+index+')">查看 </a>'+(row.id2?'':('<a href="#" onclick="recommond('+index+',\''+(row.type==1?'cheyuan':'huoyuan')+'\')">推荐</a>'))+'</td></tr>';

                    str+='<tr><td>信息类型<label>'+(row.type==1?'货源':'车源 &nbsp;&nbsp;&nbsp;')+'</label>'+(row.type==1?'':'车牌号码<label>'+row.carNo+'</label>')+'</td><td>路线<label>'+row.way+'</label></td><td>'+(row.state=='1'?'已发布':(row.state=='2'?'已过期':'已成交'))+'</td></tr>';

                    str+='<tr><td colspan="2">信息内容<input style="width: 95%;" value="'+row.info+'"/></td><td>'+(row.state=='2'?'<a href="#" onclick="rePublish('+index+')">重新发布</a>':(row.state=='1'?'<a href="#" onclick="del_info(\''+row.id+'\',\''+info_type+'\')">删除</a>':''))+'</td></tr>';
                    str+='</table>';
                    return str;
                }
            }]]
        });
    }catch (e){}
}

var actionobj={
    field : 'action',
    title : '联系方式',
    width : 220,
    align : 'center',
    formatter : function(value, row, index) {
        var str = '';
//        str += $.formatString('<a href="javascript:void(0)" onclick="CallTel(\'{0}+{1}+{2}\',\'{3}\');" ><span style="color:red">111111</span></a>', row.tel,row.tel1,row.tel2,row.id);
       	var time1 = row.createTime;
    	var time2 = new Date().Format("yyyy-MM-dd hh:mm:ss");  
    	var min = timeDifferent(time1,time2);
    	var different = $('#different').val();
    	var title = '';
    	if(tag == 'cheyuan')
    		title = '获取车源信息';
    	else
    		title = '获取货源信息';
    	if(min >= different)
    		str += $.formatString(row.tel+'&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"openTime(\'gridTable\',\''+index+'\',\'anyList\',\''+title+'\')\"   style=\"cursor: pointer;\"><span>发送到手机</span></a>');
    	else
    		str += $.formatString('信息受保护状态&nbsp;&nbsp;<a href=\"javascript:void(0);\" onclick=\"openTime(\'gridTable\',\''+index+'\',\'anyList\',\''+title+'\')\"   style=\"cursor: pointer;\"><span>查看剩余时间</span></a>');
  
        return str;
    }
};
var huoyuanCol = [{
    field : 'id',
    sortable : true,
    hidden:true
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
    },
    {
        width : fixWidth(0.4),
        title : '信息内容',
        field : 'info',
        formatter:function(value, row, index){
            return '<a href="javascript:void(0)" onclick="a_click(\''+index+'\',\'huoyuan\');" >'+value+'</a>';
        }
    },{
        width : fixWidth(0.1),
        title : '发布时间',
        field : 'createTime',
        sortable : true
    },actionobj];

var cheyuanCol = [{
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
    },
    {
        width : fixWidth(0.4),
        title : '信息内容',
        field : 'info',
        formatter:function(value, row, index){
            return '<a href="javascript:void(0)" onclick="a_click(\''+index+'\',\'cheyuan\');" >'+value+'</a>';
        }
    },{
        width : fixWidth(0.1),
        title : '发布时间',
        field : 'createTime',
        sortable : true
    },actionobj];

/**
 * 新增车源或货源后立即匹配相对应的货源或车源信息
 * @param type
 * @param data
 */
function openList(type,data,info) {
    if (data.rows.length==0){
        //return;
    }
    var columns;
    tag = type;
    if (type=="huoyuan"){
        list_title='<span style="color: red">车源信息:'+(cheyuanInfo||info)+'</span><br/>推荐货源';
        columns=[huoyuanCol];
    }
    if (type=='cheyuan'){
        list_title='<span style="color: red">货源信息:'+(huoyuanInfo||info)+'</span><br/>推荐车源';
        columns=[cheyuanCol];
    }
    $('#lab_1').html(list_title);
    $('#infoPublish').show();
    $('#infoPublish').css('z-index',99);
    $('#infoPublish').css('background-color',"#dddddd");
    $('#gridTable').datagrid({
        data : data,
        height: 200,
        striped : true,
        rownumbers : true,
        pagination : false,
        fitColumns:true,
        singleSelect:true,
        idField : 'id',
        sortName : 'createTime',
        sortOrder : 'asc',
        columns:columns,
        onDblClickRow:function(rowIndex, rowData){
            openInfo(JSON.stringify(rowData),type,rowData.id);
        }
    });
}
//隐藏
function closeInfo(id) {
    document.getElementById(id).style.display = "none";
}

/**
 * 历史记录查看信息详情
 * @param index
 */
function viewInfo(index){
    historyData[index].carImg=historyData[index].img;
    historyData[index].goodsImg=historyData[index].img;
    historyData[index].length=historyData[index].carLength;
    historyData[index].state=2;
    info_title=(historyData[index].type==1?'货源信息':'车源信息');
    $('#lab_2').html(info_title);
    $('#viewInfo').show();
    $('#viewInfo').css('z-index',99);
    $('#viewInfo').css('background-color',"#dddddd");
    $('#divInfo').load('infohall/infoHallPage',{"json":JSON.stringify(historyData[index]),"type":historyData[index].type==1?'huoyuan':'cheyuan',"viewflag":true});
}

/**
 * 已过期信息重新发布
 * @param index
 */
function rePublish(index){
    if (historyData[index].type==1){
        parent.$.modalDialog.openner_dataGrid = historyHuoyuanList;
        parent.$.modalDialog.json=JSON.stringify(historyData[index]);
        parent.$.modalDialog.id=historyData[index].id;
        parent.$.modalDialog.type=(historyData[index].type==1?'huoyuan':'cheyuan');
        parent.$.modalDialog.info=historyData[index].info;
        $.modalDialog({
            title : ' ',
            width : 500,
            height : 180,
            href : 'infopublish/loadPublish'
        });
    }else {
        $.post('infopublish/rePublish',{"json":JSON.stringify(historyData[index]),"type":(historyData[index].type==1?'huoyuan':'cheyuan')},function(result){
            if (result.success) {
                historyHuoyuanList.datagrid('reload');
                if (result.data.rows.length==0){
                    alert(result.msg);
                    return;
                }
                openList(historyData[index].type==1?'cheyuan':'huoyuan',result.data,historyData[index].info);
            }else {
                alert(result.msg);
            }
        });
    }
}

/**
 * 获取推荐信息
 * @param type
 */
var telstyle;
function recommond(index,type){
    telstyle=type;
    if (type=='cheyuan'){
        huoyuanId = historyData[index].id;
        huoyuanInfo = historyData[index].info;
    }
    if (type=='huoyuan'){
        cheyuanId = historyData[index].id;
        cheyuanInfo = historyData[index].info;
    }
    $.post('infopublish/getMarryList',{"json":JSON.stringify(historyData[index]),"type":type},function(result){
        openList(type,result.data);
    });
}

/**
 * 详情
 * @param index
 * @param type
 */
function a_click(index,type){
    var data;
    data = $('#gridTable').datagrid('getData');
    openInfo(JSON.stringify(data.rows[index]),type,data.rows[index].id);
}

/**
 * 详情
 * @param json
 * @param type
 * @param id
 */
function openInfo(json,type,id) {
    if (type=='cheyuan'){
        info_title='车源信息';
        cheyuanId = id;
        cheyuanState=false;
        huoyuanState=true;
    }
    if (type=='huoyuan'){
        info_title='货源信息';
        huoyuanId = id;
        cheyuanState=true;
        huoyuanState=false;
    }
    $('#lab_2').html(info_title);
    $('#viewInfo').show();
    $('#viewInfo').css('z-index',99);
    $('#viewInfo').css('background-color',"#dddddd");
    $('#divInfo').load('infohall/infoHallPage',{"json":json,"type":type,"viewflag":false});
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
                historyHuoyuanList.datagrid('reload');
            }catch(e){}
        }else {
            alert(data.msg);
        }
    });
}

//var relationHuoyuanCol=[{
//        field : 'id',
//        sortable : true,
//        hidden:true
//    }/*,  {
//        width : fixWidth(0.1),
//        title : '路线',
//        field : 'way',
//        sortable : true
//    }*/,{
//    width : fixWidth(0.1),
//    title : '起始地',
//    field : 'startWay',
//    sortable : true
//    },{
//        width : fixWidth(0.1),
//        title : '目的地',
//        field : 'endWay',
//        sortable : true
//    },
//    {
//        width : fixWidth(0.4),
//        title : '信息内容',
//        field : 'info',
//        formatter:function(value, row, index){
//            return value;
//            //return '<a href="javascript:void(0)" onclick="a_click(\''+index+'\',\'huoyuan\');" >'+value+'</a>';
//        }
//    },{
//        width : fixWidth(0.1),
//        title : '发布时间',
//        field : 'createTime',
//        sortable : true
//    },{
//        field : 'action',
//        title : '操作',
//        width : 220,
//        align : 'center',
//        formatter : function(value, row, index) {
//            var str = '';
//			str += $.formatString('<a href="javascript:void(0)" onclick="updateRelation(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\');" ><span style="color:red">确认</span></a>', row.cheyuanId,row.huoyuanId,row.carId,row.huoyuanState,row.cheyuanState);
//            return str;
//        }
//    }];

//var relationcheyuanCol=[{
//        field : 'id',
//        sortable : true,
//        hidden:true
//    },  {
//        width : fixWidth(0.1),
//        title : '车牌号码',
//        field : 'carNo',
//        sortable : true
//    }/*,  {
//        width : fixWidth(0.1),
//        title : '路线',
//        field : 'way',
//        sortable : true
//    }*/,{
//    width : fixWidth(0.1),
//    title : '起始地',
//    field : 'startWay',
//    sortable : true
//    },{
//    width : fixWidth(0.1),
//    title : '目的地',
//    field : 'endWay',
//    sortable : true
//    },{
//        width : fixWidth(0.4),
//        title : '信息内容',
//        field : 'info',
//        formatter:function(value, row, index){
//            return value;
//            //return '<a href="javascript:void(0)" onclick="a_click(\''+index+'\',\'cheyuan\');" >'+value+'</a>';
//        }
//    },{
//        width : fixWidth(0.1),
//        title : '发布时间',
//        field : 'createTime',
//        sortable : true
//    },{
//        field : 'action',
//        title : '操作',
//        width : 220,
//        align : 'center',
//        formatter : function(value, row, index) {
//            var str = '';
//            str += $.formatString('<a href="javascript:void(0)" onclick="updateRelation(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\');" ><span style="color:red">确认</span></a>', row.cheyuanId,row.huoyuanId,row.carId,row.huoyuanState,row.cheyuanState);
//            return str;
//        }
//    }];

var style;
/**
 * 信息确认
 */
//function showRelationList(id,type){
//    $.post('infopublish/showRelationList',{"id":id,"type":type},function(data) {
//        var columns;
//        style=type;
//        if (type=='huoyuan'){
//            columns=[relationcheyuanCol];
//            list_title='车源确认';
//        }
//        if (type=='cheyuan'){
//            columns=[relationHuoyuanCol];
//            list_title='货源确认';
//        }
//        $('#lab_1').html(list_title);
//        $('#infoPublish').show();
//        $('#infoPublish').css('z-index',99);
//        $('#infoPublish').css('background-color',"#dddddd");
//        $('#gridTable').datagrid({
//            data : data.data,
//            height: 200,
//            striped : true,
//            rownumbers : true,
//            pagination : false,
//            fitColumns:true,
//            idField : 'id',
//            sortName : 'createTime',
//            sortOrder : 'asc',
//            columns:columns
//        });
//    });
//}

function updateRelation(cheyuanId,huoyuanId,carId,huoyuanState,cheyuanState){
    var obj={"cheyuanId":cheyuanId,"huoyuanId":huoyuanId,"carId":carId};
    if (style=='huoyuan'){
        obj.huoyuanState=1;
        obj.cheyuanState=cheyuanState;
    }
    if (style=='cheyuan'){
        obj.cheyuanState=1;
        obj.huoyuanState=huoyuanState;
    }
    $.post('infopublish/updateRelation',obj,function(data){
        if (data.success){
            closeInfo('infoPublish');
            historyHuoyuanList.datagrid("reload");
        }
        alert(data.msg);
    });
}

function del_info(id,type){
    if (id){
        $.post('infopublish/delInfo',{"id":id,"type":type},function(data){
            if (data.success){
                historyHuoyuanList.datagrid('reload');
            }
            alert(data.msg);
        });
    }
}

function CallTel(tel,id){
    if (confirm('拨打成功，是否达成交易意向？')){
        if (telstyle=='cheyuan'){
            cheyuanId=id;
            huoyuanState=true;
            cheyuanState=false;
        }
        if (telstyle=='huoyuan'){
            huoyuanId=id;
            cheyuanState=true;
            huoyuanState=false;
        }
        infoconfirm();
    }
}

function openTelCheyuan(tel,id){
    CallTel(tel,id);
}

function showInfo(id,type){
    type=(type=='huoyuan'?'cheyuan':'huoyuan');
    var obj={"id":id,"type":type};
    $.post('infohall/getInfoById',obj,function(data){
        if (data.success){
            $('#lab_2').html(type=='huoyuan'?'货源信息':'车源信息');
            $('#viewInfo').show();
            $('#viewInfo').css('z-index',99);
            $('#viewInfo').css('background-color',"#dddddd");
            $('#divInfo').load('infohall/infoHallPage',{"json":JSON.stringify(data.data),"type":type,"viewflag":true});
        }else {
            alert(data.msg);
        }
    });
}

/**
 * 保存常用地址
 * @param type
 * @param beginName
 * @param beginId
 * @param endName
 * @param endId
 */
var dom_type;
function saveAddress(type,beginProvinceId,beginAreaId,beginCityId,endProvinceId,endAreaId,endCityId,_provinceAreaId,carId){
    var json = {"type":type};
    if (_provinceAreaId){
        json.provinceAreaId=$('#'+_provinceAreaId).val();
    }
    dom_begin_province=$('#'+beginProvinceId);
    dom_begin_area=$('#'+beginAreaId);
    dom_begin_city=$('#'+beginCityId);
    dom_end_province=$('#'+endProvinceId);
    dom_end_area=$('#'+endAreaId);
    dom_end_city=$('#'+endCityId);
    dom_type = type;
    json.beginProvinceId=$('#'+beginProvinceId).val();
    json.beginProvinceName=$('#'+beginProvinceId).find('option:selected').text();
    json.beginAreaId=$('#'+beginAreaId).val();
    json.beginAreaName=$('#'+beginAreaId).find('option:selected').text();
    json.beginCityId=$('#'+beginCityId).val();
    json.beginCityName=$('#'+beginCityId).find('option:selected').text();
    json.endProvinceId=$('#'+endProvinceId).val();
    json.endProvinceName=$('#'+endProvinceId).find('option:selected').text();
    json.endAreaId=$('#'+endAreaId).val();
    json.endAreaName=$('#'+endAreaId).find('option:selected').text();
    json.endCityId=$('#'+endCityId).val();
    json.endCityName=$('#'+endCityId).find('option:selected').text();
    if (carId){
        var _carId = $('#carId').combobox('getValue');
        if (!_carId){
            alert("请选择车辆！");
            return ;
        }
        json.carId=_carId;
    }
    $.post('infopublish/saveAddress',json,function(data){
        alert(data.msg);
    });
}

/**
 * 获取地址
 * @param type
 */
function getAdd(type,beginProvinceId,beginAreaId,beginCityId,endProvinceId,endAreaId,endCityId,carId){
    dom_type=type;
    dom_begin_province=$('#'+beginProvinceId);
    dom_begin_area=$('#'+beginAreaId);
    dom_begin_city=$('#'+beginCityId);
    dom_end_province=$('#'+endProvinceId);
    dom_end_area=$('#'+endAreaId);
    dom_end_city=$('#'+endCityId);
    var json = {infoType:(type=='huoyuan'?1:2)};
    if (carId){
        var _carId = $('#carId').combobox('getValue');
        if (!_carId){
            alert("请选择车辆！");
            return ;
        }
        json.carId=_carId;
    }
    $('#lab_1').html("常用地址");
    $('#infoPublish').show();
    $('#infoPublish').css('z-index',99);
    $('#infoPublish').css('background-color',"#dddddd");
    $('#gridTable').datagrid({
        url : 'infopublish/getUserAddress',
        queryParams:json,
        height: 200,
        striped : true,
        rownumbers : true,
        pagination : false,
        fitColumns:true,
        idField : 'id',
        sortName : 'createTime',
        sortOrder : 'asc',
        columns:[[
            {
                field : 'id',
                sortable : true,
                hidden:true
            },{
                field : 'provinceAreaId',
                hidden:true
            },{
                field : 'beginProvinceId',
                hidden:true
            },{
                field : 'beginAreaId',
                hidden:true
            },{
                field : 'beginCityId',
                hidden:true
            },{
                field : 'endProvinceId',
                hidden:true
            },{
                field : 'endAreaId',
                hidden:true
            },{
                field : 'endCityId',
                hidden:true
            },{
                width : fixWidth(0.1),
                title : '起始地',
                field : 'startWayName',
                sortable : true
            },{
                width : fixWidth(0.1),
                title : '目的地',
                field : 'endWayName',
                sortable : true
            },{
                field : 'action',
                title : '操作',
                width : 220,
                align : 'center',
                formatter : function(value, row, index) {
                    var str = '';
                    str += $.formatString('<a href="javascript:void(0)" onclick="chooseAdd(\'{0}\',\'{1}\',\'{2}\',\'{3}\',\'{4}\',\'{5}\',\'{6}\');" ><span style="color:red">选择地址</span></a>',
                        row.beginProvinceId,row.beginAreaId,row.beginCityId,row.endProvinceId,row.endAreaId,row.endCityId,row.provinceAreaId);
                    str += '&nbsp;|&nbsp;';
                    str += $.formatString('<a href="javascript:void(0)" onclick="deleteAdd(\'{0}\');" ><span style="color:red">删除</span></a>', row.id);
                    return str;
                }
            }
        ]]
    });
}

/**
 * 选择地址
 * @param startWayId
 * @param endWayId
 * @param startWayName
 * @param endWayName
 */
function chooseAdd(beginProvinceId,beginAreaId,beginCityId,endProvinceId,endAreaId,endCityId,provinceAreaId){
    if (dom_type=='huoyuan'){
            $('#huoyuanProvinceAreaId').val(provinceAreaId);
    }
    if (dom_type=='cheyuan'){
            $('#cheyuanProvinceAreaId').val(provinceAreaId);
    }
    try{
        dom_begin_province.val(beginProvinceId);
        dom_end_province.val(endProvinceId);

        var html='<option value="0"></option>';
        var _area_array_ids=city[beginProvinceId].ids.split(',');
        var _area_array_names=city[beginProvinceId].names.split(',');
        for (var i=0;i<_area_array_ids.length;i++){
            if (beginAreaId==_area_array_ids[i]){
                html+='<option value="'+_area_array_ids[i]+'" selected>'+_area_array_names[i]+'</option>';
            }else {
                html+='<option value="'+_area_array_ids[i]+'">'+_area_array_names[i]+'</option>';
            }
        }
        dom_begin_area.append(html);

        _area_array_ids=city[endProvinceId].ids.split(',');
        _area_array_names=city[endProvinceId].names.split(',');
        html='<option value="0"></option>';
        for (var i=0;i<_area_array_ids.length;i++){
            if (endAreaId==_area_array_ids[i]){
                html+='<option value="'+_area_array_ids[i]+'" selected>'+_area_array_names[i]+'</option>';
            }else {
                html+='<option value="'+_area_array_ids[i]+'">'+_area_array_names[i]+'</option>';
            }
        }
        dom_end_area.append(html);

        _area_array_ids=area[beginAreaId].ids.split(',');
        _area_array_names=area[beginAreaId].names.split(',');
        html='<option value="0"></option>';
        for (var i=0;i<_area_array_ids.length;i++){
            if (beginCityId==_area_array_ids[i]){
                html+='<option value="'+_area_array_ids[i]+'" selected>'+_area_array_names[i]+'</option>';
            }else {
                html+='<option value="'+_area_array_ids[i]+'">'+_area_array_names[i]+'</option>';
            }
        }
        dom_begin_city.append(html);

        _area_array_ids=area[endAreaId].ids.split(',');
        _area_array_names=area[endAreaId].names.split(',');
        html='<option value="0"></option>';
        for (var i=0;i<_area_array_ids.length;i++){
            if (endCityId==_area_array_ids[i]){
                html+='<option value="'+_area_array_ids[i]+'" selected>'+_area_array_names[i]+'</option>';
            }else {
                html+='<option value="'+_area_array_ids[i]+'">'+_area_array_names[i]+'</option>';
            }
        }
        dom_end_city.append(html);
    }catch (e){}
    closeInfo('infoPublish');
}

/**
 * 删除地址
 * @param id
 */
function deleteAdd(id){
    $.post('infopublish/deleteAdd',{"id":id,"type":dom_type},function(data){
        if (data.success){
            $('#gridTable').datagrid({
                data:data.data
            });
        }else {
            alert(data.msg);
        }
    });
}

function searchCityStart(pid,id){
    var myselect = $('#'+pid).val();
    if (myselect!=0){
        var html = '<option value=\'\' ></option>';
        var city_array=area[myselect];
        try{
            var ids=city_array.ids.split(',');
            var names=city_array.names.split(',')
            for (var i=0;i<ids.length;i++){
                html+='<option value="'+ids[i]+'">'+names[i]+'</option>';
            }
        }catch (e){}
        $('#'+id).html(html);
    }
}

function platformLogistics(id){
    if (confirm("是否将货源信息发布到产贸送物流信息平台？")){
        $.post('infopublish/updatePlatformLogistics',{"id":id},function(data){
            if (data.success){
                historyHuoyuanList.datagrid('reload');
            }else {
                alert(data.msg);
            }
        });
    }
}
