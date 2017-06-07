$('#table').bootstrapTable({
        url:'../purchase/getPurchaseNeddList',
        dataType:'json',
        toolbar: '#toolbar',
        toolbarWidth:'100%',
        pagination: true,//是否显示分页
        contentType:'application/x-www-form-urlencoded; charset=UTF-8',
        queryParamsType:'limit',
        sortOrder:'desc',
        queryParams:function(params){
            return {
                pageSize: params.limit,
                sort:'createTime',
                order:params.order,
                pageNumber: params.pageNumber
            };
        },
        pagination: true,//是否显示分页
        sidePagination: "server",//分页方式：client客户端分页，server服务端分页
        pageNumber:1,//初始化加载第一页，默认第一页
        pageSize: 10, //每页的记录行数
        pageList: [10, 20],//可供选择的每页的行数
        uniqueId: "id",//每一行的唯一标识，一般为主键列
        columns: [{
            field: 'Number',
            title: '序号',
            formatter: function (value, row, index) {
                return index+1;
            }
        },{
            title : '物资需求单号',
            field : 'purchaseNeedNo'
        },{
            title : '需求名称',
            field : 'purchaseNeedName'
        },{
            title : '需求类型',
            field : 'purchaseNeedType'
        },{
            title : '编制人',
            field : 'createUser'
        },{
            title : '发布状态',
            field : 'purchaseNeedState'
        },{
            title : '发布时间',
            field : 'createTimeByString'
        }, {
            title: '操作',
            field : 'action',
            formatter: function (value, row, index) {
                return '<a class="a_css" onclick="editPurchaseNeed(\''+row.id+'\')" href="javascript:void(0)">编辑</a> | <a class="a_css" onclick="delPurchaseNeed(\''+row.id+'\')" href="javascript:void(0)">删除</a>';
            }
        }]
    });

	//查询方法
	$('#btn_query').click(function () {
	    var queryParams={};
	    queryParams.purchaseNeedNo=$('#purchaseNeedNo').val();
	    queryParams.purchaseNeedState=$('#purchaseNeedState').val();
	    queryParams.purchaseNeedName=$('#purchaseNeedName').val();
	    queryParams.purchaseNeedType=$('#purchaseNeedType').val();
	    $.ajaxLoad({
	        url:'../purchase/getPurchaseNeddList',
	        data:queryParams,
	        success:function(data){
	            $('#table').bootstrapTable('load',data);
	        }
	    });
	});
	
	//删除方法
	function delPurchaseNeed(id){
        layer.confirm('您确定要删除这条数据？',{btn:['是','否']},function(){
            $.ajaxLoad({
                url:'../purchase/delPurchaseNeddById',
                data:{
                    id:id
                },
                success:function(data){
                    if (data.success){
                        layer.msg(data.msg, {icon: 1});
                    	$('#table').bootstrapTable('removeByUniqueId', id);
                    }else {
                        layer.msg(data.msg, {icon: 2});
                    }
                }
            });
        });
	}
	//跳转到修改界面
	function editPurchaseNeed(id){
		 changeContent('../purchase/purchaseNeddAddOrUpdate?id='+id,'right');
	}
	  
	//下拉框加载方法

	                
	 $('#purchaseNeedType').multiselect('url', '../purchase/getPurchaseNeedTypeList?tag=1');
	 
	          	                
	 $('#purchaseNeedState').multiselect('url', '../purchase/getPurchaseNeedStateList?tag=1');