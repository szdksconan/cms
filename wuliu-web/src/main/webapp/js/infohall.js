var huoyuanList;
var cheyuanList;
var userId,provinceAreaId;
var cheyuanId,huoyuanId,cheyuanState=false,huoyuanState=false;//信息id
var _info;
var tag;

var huoyuaninfo={
    width : fixWidth(0.4),
    title : '信息内容',
    field : 'info',
    formatter:function(value, row, index){
        var style="";
        if (row.listType==1){
            style="color:red;";
        }
        return '<a style="'+style+'" href="javascript:void(0)" onclick="a_click(\''+index+'\',\'huoyuan\',\''+row.info+'\');" >'+value+'</a>';
    }
};
var cheyuaninfo={
    width : fixWidth(0.4),
    title : '信息内容',
    field : 'info',
    formatter:function(value, row, index){
        var style="";
        if (row.listType==1){
            style="color:red;";
        }
        return '<a style="'+style+'" href="javascript:void(0)" onclick="a_click(\''+index+'\',\'cheyuan\',\''+row.info+'\');" >'+value+'</a>';
    }
};
var huoyuanCol = [{
	field : 'id',
	sortable : true,
	hidden:true
    },{
	width : fixWidth(0.1),
	title : '货主',
	field : 'companyName',
	sortable : true
    },{
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
    width : fixWidth(0.1),
    title : '报价',
    field : 'offer',
    sortable : false,
    formatter:function(value, row, index){
        if (value==0){
            return '面议';
        }else {
            return value+'元/吨';
        }
    }
    },huoyuaninfo,{
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
        if (userId!=row.userId){
           // str += '<a href="javascript:void(0)" onclick="CallTel2(\''+row.id+'\',\'huoyuan\',\''+row.info+'\');" ><span style="color:red">拨打电话</span></a>', row.tel,row.tel1,row.tel2);
        	var time1 = row.createTime;
        	var time2 = new Date().Format("yyyy-MM-dd hh:mm:ss");  
        	var min = timeDifferent(time1,time2);
            var style="cursor: pointer;";
          	var different = $('#different').val();
        	var	title = '获取货源信息';
            if (row.listType==1){
                style+="color:red;";
            }
        	if(min >= different)
        		str += $.formatString(row.tel+'&nbsp;&nbsp;<a href=\"javascript:void(0);\"   onclick=\"openTime(\'huoyuanList\',\''+index+'\',\'anyList\',\''+title+'\')\"  style=\"'+style+'\"><span>发送到手机</span></a>');
        	else
        		str += $.formatString('信息受保护状态&nbsp;&nbsp;<a href=\"javascript:void(0);\"   onclick=\"openTime(\'huoyuanList\',\''+index+'\',\'anyList\',\''+title+'\')\"   style=\"'+style+'\"><span>查看剩余时间</span></a>');
        }
		return str;
	}
}];
var cheyuanCol = [{
	field : 'id',
	sortable : true,
	hidden:true
}, {
    width : fixWidth(0.1),
    title : '货运类型',
    field : 'trafficTypeName',
    sortable : true
},{
	width : fixWidth(0.1),
	title : '车牌号码',
	field : 'carNo',
	sortable : true
},  {
	width : fixWidth(0.1),
	title : '物流企业',
	field : 'companyName',
	sortable : true
},{
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
    width : fixWidth(0.1),
    title : '报价',
    field : 'offer',
    sortable : false,
    formatter:function(value, row, index){
        if (value==0){
            return '面议';
        }else {
            return value+'元/吨';
        }
    }
},cheyuaninfo,{
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
        var str='';
     
        if (userId!=row.userId){
         //   str += $.formatString('<a href="javascript:void(0)" onclick="CallTel2(\''+row.id+'\',\'cheyuan\',\''+row.info+'\');" ><span style="color:red">拨打电话</span></a>', row.tel,row.tel1,row.tel2);
            //str += $.formatString('<a href=\"javascript:void(0);\" onclick=\"openTime(\'cheyuanList\')\"   style=\"cursor: pointer;\"><span>获取联系方式</span></a>');
        	var time1 = row.createTime;
        	var time2 = new Date().Format("yyyy-MM-dd hh:mm:ss");  
        	var min = timeDifferent(time1,time2);
        	var different = $('#different').val();
            var style="cursor: pointer;";
        	var	title = '获取车源信息';
            if (row.listType==1){
                style+="color:red;";
            }
        	if(min >= different)
        		str += $.formatString(row.tel+'&nbsp;&nbsp;<a href=\"javascript:void(0);\"  onclick=\"openTime(\'cheyuanList\',\''+index+'\',\'anyList\',\''+title+'\')\"  style=\"'+style+'\"><span>发送到手机</span></a>');
        	else
        		str += $.formatString('信息受保护状态&nbsp;&nbsp;<a href=\"javascript:void(0);\"  onclick=\"openTime(\'cheyuanList\',\''+index+'\',\'anyList\',\''+title+'\')\"   style=\"'+style+'\"><span>查看剩余时间</span></a>');
        }
		return str;
	}
}];
var more_huoyuan_query=false;
var more_cheyuan_query=false;
$(function(){
	different = $('#different').val();
    $.post('common/getGoodsDicInfoList?pid=20',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
            }
            $('#packageType').append(html);
        }
    },'json');

    $.post('common/getQuoteList',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].quote+'</option>';
            }
            $('#quoteRegion').append(html);
            $('#quoteRegion2').append(html);
        }
    },'json');

    $.post('common/getWeightList',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].weight+'</option>';
            }
            $('#weight').append(html);
            $('#weight2').append(html);
        }
    },'json');

    $.post('common/getCarDic?pid=11',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
            }
            $('#carTrafficType').append(html);
        }
    },'json');

    $.post('common/getCarDic?pid=5',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
            }
            $('#carAxleId').append(html);
        }
    },'json');

    $.post('common/getCarDic?pid=17',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
            }
            $('#carContainerId').append(html);
        }
    },'json');

    $.post('common/getCarDic?pid=1',function(data){
        if (data.length>0){
            var html='<option value="0"></option>';
            for (var i=0;i<data.length;i++){
                html += '<option value="'+data[i].id+'">'+data[i].name+'</option>';
            }
            $('#carTypeId').append(html);
        }
    },'json');

    $.ajax({
        url : "common/getAreaInfo?date="+new Date(),
        dataType:'json',
        type : "Post",
        data : {},
        success : function(data) {
            if (data != null) {
                var province = data.province;
                areacity = data.area;
                var html = '<option value=\'\' ></option>';
                for (var i = 0; i < province.length; i++) {
                    html += '	<option value="' + province[i].id + '">'
                    + province[i].name + '</option>';
                }
                $('#provinceListstart').html(html);
                $('#provinceListend').html(html);
                $('#provinceListstart2').html(html);
                $('#provinceListend2').html(html);
            }

        }
    });

	huoyuanList = $('#huoyuanList').datagrid({
		url : 'infohall/getHuoyuanList',
        queryParams:{firstQuery:true},
		striped : true,
		rownumbers : true,
		pagination : true,
		fitColumns:true,
		singleSelect:true,
		idField : 'id',
		sortName : 'createTime',
		sortOrder : 'desc',
		pageSize : 20,
		pageList:[10,20,30,50,100,200],
		columns : [huoyuanCol],
        rowStyler:function(index,row){
            if (row.listType==1){
                return 'color:red';
            }
        },
		onDblClickRow:function(rowIndex, rowData){
            rowData.state=2;
            viewInfo(JSON.stringify(rowData),'huoyuan',(userId==rowData.userId?true:false),rowData.info);
		},
		toolbar : '#huoyuantoolbar'
	});

    $('input[type=radio][name=rd1]').click(function(){
        var provinceAreaId = $(this).val();
        var json = {provinceAreaId:provinceAreaId};
        if (more_huoyuan_query){
            json.packageType=$('#packageType').val();
            json.quoteRegion=$('#quoteRegion').val();
            json.weight=$('#weight').val();
        }
        huoyuanList.datagrid("load",json);
    });
    $('input[type=radio][name=rd2]').click(function(){
        var provinceAreaId = $(this).val();
        var json = {provinceAreaId:provinceAreaId};
        if (more_cheyuan_query){
            json.carTrafficType=$('#carTrafficType').val();
            json.weight=$('#weight2').val();
            json.quoteRegion=$('#quoteRegion2').val();
            json.carTypeId=$('#carTypeId').val();
            json.carAxleId=$('#carAxleId').val();
            json.carContainerId=$('#carContainerId').val();
            json.trafficType=$('#trafficType').val();
        }
        cheyuanList.datagrid("load",json);
    });
});

function huosearchFun() {
	var start;
	var end;
	var start1 = $('#provinceListstart').val();
	var start2 = $('#areaListstart').val();
	if(!start1 && !start2)
		start = '';
	else if(start1 && !start2)
		start = start1;
	else 
		start = start1+'-'+start2;
	var end1 = $('#provinceListend').val();
	var end2 = $('#areaListend').val();
	if(!end1 && !end2)
		end = '';
	else if(end1 && !end2)
		end = end1;
	else 
		end = end1+'-'+end2;
	var json = {"start":start,"end":end};
    if (!start && !end){
        var rd1 = document.getElementsByName('rd1');
        for (var i=0;i<rd1.length;i++){
            if (rd1[i].checked){
                json.provinceAreaId=rd1[i].value;
                break;
            }
        }
    }
    if (more_huoyuan_query){
        json.packageType=$('#packageType').val();
        json.quoteRegion=$('#quoteRegion').val();
        json.weight=$('#weight').val();
    }
	huoyuanList.datagrid('load', json);
}

function chesearchFun() {
	var start;
	var end;
	var start1 = $('#provinceListstart2').val();
	var start2 = $('#areaListstart2').val();
	if(!start1 && !start2)
		start = '';
	else if(start1 && !start2)
		start = start1;
	else 
		start = start1+'-'+start2;
	var end1 = $('#provinceListend2').val();
	var end2 = $('#areaListend2').val();
	if(!end1 && !end2)
		end = '';
	else if(end1 && !end2)
		end = end1;
	else 
		end = end1+'-'+end2;
	var json = {"start":start,"end":end};
    if (!start && !end){
        var rd2 = document.getElementsByName('rd2');
        for (var i=0;i<rd2.length;i++){
            if (rd2[i].checked){
                json.provinceAreaId=rd2[i].value;
                break;
            }
        }
    }
    if (more_cheyuan_query){
        json.carTrafficType=$('#carTrafficType').val();
        json.quoteRegion=$('#quoteRegion2').val();
        json.weight=$('#weight2').val();
        json.carTypeId=$('#carTypeId').val();
        json.carAxleId=$('#carAxleId').val();
        json.carContainerId=$('#carContainerId').val();
        json.trafficType=$('#trafficType').val();
    }
	cheyuanList.datagrid('load', json);
}

function query(th){
	if (th.id=='tab11'){
		huosearchFun();
		tag = 'huoyuan';
	}
	if (th.id=='tab12'){
		tag = 'cheyuan';
		try{
			chesearchFun();
		}catch(e){
            if (provinceAreaId){
                $('#c_a_'+provinceAreaId).attr("checked",true);
            }
			cheyuanList = $('#cheyuanList').datagrid({
				url : 'infohall/getCheyuanList',
                queryParams:{firstQuery:true},
				striped : true,
				rownumbers : true,
				pagination : true,
				fitColumns:true,
				singleSelect:true,
				idField : 'id',
				sortName : 'createTime',
				sortOrder : 'desc',
				pageSize : 20,
				pageList:[10,20,30,50,100,200],
				columns : [cheyuanCol],
				toolbar : '#cheyuantoolbar',
                rowStyler:function(index,row){
                    if (row.listType==1){
                        return 'color:red';
                    }
                },
				onDblClickRow:function(rowIndex, rowData){
                    rowData.state=2;
                    viewInfo(JSON.stringify(rowData),'cheyuan',(userId==rowData.userId?true:false),rowData.info);
				}
			});
		}
	}
}

function a_click(index,type,info){
    var data;
    if (type=='huoyuan'){
        data = huoyuanList.datagrid('getData');
    }
    if (type=='cheyuan'){
        data = cheyuanList.datagrid('getData');
    }
    data.rows[index].state=2;
    viewInfo(JSON.stringify(data.rows[index]),type,(userId==data.rows[index].userId?true:false),info);
}

function viewInfo(json,type,viewflag,info) {
    _info=info;
    $('#lab_2').html(type=='huoyuan'?'货源信息':'车源信息');
	$('#infoHall2').show();
	$('#infoHall2').css('z-index',99);
	$('#infoHall2').css('background-color',"#dddddd");
	$('#divInfo').load('infohall/infoHallPage',{"json":json,"type":type,"viewflag":viewflag});
}
//隐藏
function closeInfo() {
	clearTimeout(cdst);
	document.getElementById("infoHall").style.display = "none";
}

//function CallTel2(id,type,info){
//    if (confirm('拨打成功，是否进行匹配？')){
//        $.post('infohall/getMarryList',{"id":id,"type":type},function(result){
//            if (type=='huoyuan'){
//                huoyuanId=id;
//            }
//            if (type=='cheyuan'){
//                cheyuanId=id;
//            }
//            openList(type,result.data,info||_info);
//        });
//    }
//}

function openList(type,data,info) {
    if (data.rows.length==0){
    }
    var columns;
    var _formatter2={};
    $.extend(_formatter2,huoyuaninfo);
    _formatter2.formatter=function(value, row, index){
        return value;
    };
    if (type != "huoyuan") {
    } else {
        list_title = '<span style="color: red">货源信息:' + info + '</span><br/>我的车源';
        var cheyuanCol_copy = cheyuanCol.slice();
        var _formatter = {};
        $.extend(_formatter, cheyuanCol[6]);
        _formatter.formatter = function (value, row, index) {
            return '<a href="javascript:void(0)" onclick="infoconfirm(\'' + row.id + '\',\'' + type + '\');" ><span style="color:red">确认交易</span></a>';
        };
        cheyuanCol_copy[4] = _formatter2;
        cheyuanCol_copy[6] = _formatter;
        columns = [cheyuanCol_copy];
    }
    if (type=='cheyuan'){
        list_title='<span style="color: red">车源信息:'+info+'</span><br/>我的货源';
        var huoyuanCol_copy=huoyuanCol.slice();
        var _formatter={};
        $.extend(_formatter,huoyuanCol[5]);
        _formatter.formatter=function(value, row, index){
            return '<a href="javascript:void(0)" onclick="infoconfirm(\''+row.id+'\',\''+type+'\');" ><span style="color:red">确认交易</span></a>';
        };
        huoyuanCol_copy[3]=_formatter2;
        huoyuanCol_copy[5]=_formatter;
        columns=[huoyuanCol_copy];
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
        idField : 'id',
        sortName : 'createTime',
        sortOrder : 'asc',
        columns:columns,
        onDblClickRow:function(rowIndex, rowData){
            openInfo(JSON.stringify(rowData),type,rowData.id,(userId==data.rows[index].userId?true:false));
        }
    });
}

//隐藏
function closeInfo(id) {
    document.getElementById(id).style.display = "none";
}

function CallTel(tel,id,type){
    if (confirm('拨打成功，是否进行匹配？')){
        if (type=='huoyuan'){
            huoyuanId=id;
        }
        if (type=='cheyuan'){
            cheyuanId=id;
        }
        $.post('infohall/getMarryList',{"id":id,"type":type},function(result){
            closeInfo('infoHall2');
            openList(type,result.data,_info);
        });
    }
}

function openTelCheyuan(tel,id,type){
    CallTel(tel,id,type);
}

function infoconfirm(id,type){
    if (type=='huoyuan'){
        cheyuanId=id;
        cheyuanState=true;
        huoyuanState=false;
    }
    if (type=='cheyuan'){
        huoyuanId=id;
        huoyuanState=true;
        cheyuanState=false;
    }
    var obj = {"cheyuanId":cheyuanId,"huoyuanId":huoyuanId,"cheyuanState":cheyuanState,"huoyuanState":huoyuanState};
    $.post('infopublish/infoconfirm',{"json":JSON.stringify(obj)},function(data){
        if (data.success){
            try{
                closeInfo('infoPublish');
                closeInfo('infoHall2');
                huoyuanList.datagrid('reload');
                cheyuanList.datagrid('reload');
            }catch(e){}
        }else {
            alert(data.msg);
        }
    });
}

function searchAreaStart(pid,id,_provinceAreaId) {
	// 1:拿到select对象：
    var myselect = document.getElementById(pid);
    // 2：拿到选中项的索引：
    var index = myselect.selectedIndex; // selectedIndex代表的是你所选中项的index

    // 3:拿到选中项options的value：
    var html = '<option value=\'\' ></option>';
    if (_provinceAreaId){
        $('#'+_provinceAreaId).val(province[index-1].provinceAreaId);
    }
    for (var i = 0; i < areacity.length; i++) {
        if (areacity[i].pid == myselect.options[index].value) {
            var names = areacity[i].names.split(",");
            var ids = areacity[i].ids.split(",");
            for (var j = 0; j < names.length; j++)

                html += '<option value="' + ids[j] + '">' + names[j]
                + '</option>';
        }

	}
	$('#'+id).html(html);
};
//function openTime(list,index){
//	//定义两个变量time1,time2分别保存开始和结束时间
//	//var time1="2009-12-02 12:25";
//	anyList = list;
//	//alert(anyList);
//	$('#'+anyList).datagrid('selectRow',index)
//	
//	var row = $('#'+anyList).datagrid('getSelected');
//	if(row != null){
//	var time1 = row.createTime;
//	var time2 = new Date().Format("yyyy-MM-dd hh:mm:ss");  
//	var min = timeDifferent(time1,time2);
//	if(min >= different){
//		if(anyList == 'huoyuanList')
//			$('#myModalLabel2').html('短信获取货源信息');
//		else
//			$('#myModalLabel2').html('短信获取车源信息');
//		$('#dbutton2').click();
//		
//	}
//	else{
//		min = different - min;
//		$('#dbutton1').click();
//		$('#sendbutton').attr("disabled", true);
//		Countdown.init(Math.floor(min/60),(min%60),1);
//		
//	}
//	//$("#myModal").modal('show');
//}
//
//}
//function closeTime(){
//	
//	Countdown.reset();
//
//}
//function reTime(){
//	$('#sendbutton').attr("disabled", false);
//}
////将要接收短信商家赋值给sendcarno
//function openmsg() {
//	row = $('#'+anyList).datagrid('getSelected');
//	
//	$.ajax({
//		url : "caronline/getMsgSum",
//		datatype : 'json',
//		type : "Post",
//		data : {
//			vaServiceType : '8003'
//		},
//		async : false,// 使用同步的方式,true为异步方式
//		success : function(data) {
//			if (data != null) {
//				$('#totalCount').val(data.msgSum);
//				if (data.msgSum <= 0)
//					// 按钮显示灰色
//					$('#sendbutton2').attr("disabled", true);
//			}
//		}
//	});
//
//}
//// 发送短信
//function sendmsg() {
//	var sendtel = $('#sendOwner').val();
//	$.ajax({
//		url : "caronline/sendMsg",
//		datatype : 'json',
//		type : "Post",
//		data : {
//			sendcarno : '',
//			sendtel : sendtel,
//			msginfo : '信息内容:'+row.info+'联系电话:'+row.tel+','+row.tel1+','+row.tel2,
//			type : '8003'
//		},
//		async : false,// 使用同步的方式,true为异步方式
//		success : function(data) {
//			if (data != null) {
//				$.bootstrapGrowl("发送成功!", {
//					type : 'success', // (null, 'info', 'danger', 'success')
//					align : 'center', // ('left', 'right', or 'center')
//					offset : {
//						from : 'top',
//						amount : 288
//					}, // 'top', or 'bottom'
//					width : 140, // (integer, or 'auto')
//					delay : 300,
//					allow_dismiss : false // If true then will display a cross
//											// to close the popup.
//				});
//			}
//		}
//	});
//}

   

