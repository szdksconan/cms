$(function() {
		laydate({
			elem : '#bianzhiTime',
			event : 'focus'
		});
		$('#caigoujiaoyi')
				.bootstrapTable(
						{
							url : '../compRule/getBuyRule',
							dataType : 'json',
							method : 'post', // 请求方式（*）
							pagination : true, // 是否显示分页
							editable : true, // 开启编辑模式
							clickToSelect : true,
							locale:"zh-US",//表格汉化 
							striped : true, // 是否显示行间隔色
							cache : false, // 是否使用缓存
							height:'500',
							contentType:'application/x-www-form-urlencoded; charset=UTF-8',
					        queryParams:function(params){
					            return {
					                pageSize: params.limit,
					                sort:'rule_time',
					                order:params.order,
					                pageNumber: params.pageNumber,
					                ruleName:$('#queryname').val(),
					            	applyType:applyGoods('type5','type6','type7','type8')
					            };
					        },
							 queryParamsType :'limit',
							// '', //传递参数
							sortable : false, // 是否启用排序
							 sortOrder :'desc',
							// "asc", //排序方式
							sidePagination : "server", // 分页方式：client客户端分页，server服务端分页
							pageNumber : 1, // 初始化加载第一页，默认第一页
							pageSize :10, // 每页的记录行数
							pageList : [ 10, 20 ], // 可供选择的每页的行数
							width : 'auto',
							uniqueId : "id", // 每一行的唯一标识，一般为主键列
							// left
							columns : [
									{
										title : '规则名称',
										field : 'ruleName',
										sortable : true
									},
									{
										title : '适用物资',
										field : 'applyType',
										sortable : true
									},
//									{
//										title : '付款方式',
//										field : 'payWay',
//										sortable : true
//									},
									{
										title : '结算方式',
										field : 'jiesuanType',
										sortable : true
									},
									{
										title : '编制人',
										field : 'creator',
										sortable : true
									},
									{
										title : '编制时间',
										field : 'ruleTime',
										sortable : true
									},
									{
										title : '操作',
										edit : false,
										field : 'action',
										formatter : function(value, row, index) {
											return '<a href="javascript:void(0)" onclick="updateRule(\''
													+ row.id
													+ '\')">编辑</a>|<a href="javascript:void(0)" onclick="delBuyRule(\''
													+ row.id + '\')">删除</a>';
										}
									} ]
						});
		$("#wzly").click(function(e){
			var tipcon = '<div class="area-tip-input">' +
		            '<span class="rule-tip" value="{0}" data-id="{1}">{2}</span>' +
		            '<span class="del"></span>' +
		            '</div>';
			
		    SelCity(this,e,{
		        'divId':'_areas',
		        'appendHtml':tipcon
		    });
		});
		
		//对物质类别进行初始化
		 $.cxSelect.defaults.emptyStyle = 'none';
		    $("#element_id").cxSelect({
				url:'../js/common/productJson.json',
				selects : ['materials1','materials2','materials3','materials4'],
				nodata: 'none'
			});
		     $("#apply_goods").cxSelect({
				url:'../js/common/productJson.json',
				selects : ['materials1','materials2','materials3','materials4'],
				nodata: 'none'
			});

});
	layer.config({
		extend : [ 'skin/myskin.css' ]
	// 加载新皮肤
	});
	function updateRule(value) {
		var row = $('#caigoujiaoyi').bootstrapTable('getRowByUniqueId',value);
		$('.edit-cg2').show();
		$('.edit-cg3').show();
		getBuyArea(row['id']);
		initguize(row);
		layer.open({
			title : [ '编辑采购规则', 'font-size:18pt;text-align:center' ],
			skin : 'layui-layer-cms',
			closeBtn : 2,
			offset : 'center', // 右下角弹出
			type : 1,
			area : [ '800px', '500px' ],// [width,height]
			content : $('#updateBuyRule'),
			btn : [ '提交', '取消' ],
			yes : function(index, layero) {
				//执行编辑功能
				var status = checkValue();
				if(status==false){
					return status;
				}
				editRule();
				layer.close(index);
			}
		});
	}
	function addproduct(obj) {
		var test = applyGoods('type1','type2','type3','type4')
		if(!test){
			return;
		}
		var content = "<div class='crumb-select-item'><span>" +test
				+ "</span><i onclick='del(this);'></i></div>";
		$(obj).parent().next().append(content);
	}
	function delBuyRule(value){
		//通过ajax向后台
		$.post('../compRule/deleteByRuleId',{"ruleId":value,"compid":companyid},function(data){
			if(data.success){
				msg({texts:"删除成功"});
				$('#caigoujiaoyi').bootstrapTable('refresh');
			}else{
				msg({texts:"删除异常"});
			}
		},"json");
	}
	function addcgzi(){
		reset();
		layer.open({
			title : [ '编辑采购规则', 'font-size:18pt;text-align:center' ],
			skin : 'layui-layer-cms',
			closeBtn : 2,
			offset : 'center', // 右下角弹出
			type : 1,
			area : [ '800px', '500px' ],// [width,height]
			content : $('#updateBuyRule'),
			btn : [ '提交', '取消' ],
			yes : function(index, layero) {
				//执行添加操作
				var status = checkValue();
				if(status==false){
					return status;
				}
				editRule();
				layer.close(index);
			}
		});
	}
	function initguize(row){
		$('#guizename').val(row['ruleName']);
		$('#bianzhiTime').val(row['ruleTime']);
		$('#createor').val(row['creator']);
		$.each($('input[type="checkbox"]'),function(i,v){
			$(v).attr("checked",false);
		});
		var temp = row['jiesuanType'].split(',');
		$.each($('input[type="checkbox"]'),function(i,v){
			if(temp.length==1){
				if($(v).val()==temp[0]){
					$(v).attr('checked','checked');
				}	
			}else if(temp.length==2){
				if($(v).val()==temp[0]){
					$(v).attr('checked','checked');
				}
				if($(v).val()==temp[1]){
					$(v).attr('checked','checked');
				}
			}
			
		});
		$('#payWay').val(row['payWay']);
		$('#describle').val(row['ruleDesc']);
		$('#guizeId').val(row['id']);
		$('#compId').val(row['compid']);
		var applyType = row['applyType'].split('，');
		$('#blank_theme').empty();
		if(applyType[0]!=''){
			$.each(applyType, function(index, value) {
				var content = "<div class='crumb-select-item'><span>" + value
						+ "</span><i onclick='del(this);'></i></div>";
				$('#blank_theme').append(content);
			});
		}
		
	}
	function reset(){
		$('#guizename').val('');
		$('#bianzhiTime').val('');
		$('#createor').val('');
		$('#payWay').val('');
		$('#describle').val('');
		$('#guizeId').val('');
		$('#compId').val('');
		$.each($('input[type="checkbox"]'),function(i,v){
			$(v).attr("checked",false);
		});
		$('.edit-cg2').hide();
		$('.edit-cg3').hide();
		
	}
	function editRule(){
		checkValue();
		var applyType=$("#blank_theme span");
		var temp = '';
		$.each(applyType,function(i,v){
			if(i<applyType.length-1){
				temp+=$(v).html()+","
			}else{
				temp+=$(v).html();
			}
		})
		//对物资来源地进行获取
		var lyd = $("span[class='rule-tip']")
		var wzly = '';
		var wzlyId = '';
		$.each(lyd,function(i,v){
			if(i<lyd.length-1){
				wzly+=$(v).html()+","
			}else{
				wzly+=$(v).html();
			}
		})
		$.each(lyd,function(i,v){
			if(i<lyd.length-1){
				if($(v).attr('data-id')){
					wzlyId+=$(v).attr('data-id')+","
				}
			}else{
				if($(v).attr('data-id')){
					wzlyId+=$(v).attr('data-id');
				}
			}
		})
		var options = {
				url:'../compRule/editBuyRule',
				dataType:'json',
				data:{
					"ruleDesc":$('#describle').val(),
					"applyType":temp,
					"ruleTime":$('#bianzhiTime').val(),
					"creator":$('#createor').val(),
					"wzly":wzly,
					"wzlyId":wzlyId
				},
				success:function(data){
					if(data.success){
						msg({texts:'操作成功！'});
						$('#caigoujiaoyi').bootstrapTable('refresh');
						
					}else{
						msg({texts:'操作异常！'});
					}
				}
		}
		$('#guize').ajaxSubmit(options);
	}
	//将前面的数据进行清空
	function clearcg(){
		$('#queryname').val('');
		var select = $('#type1').val();
		$('#type1').multiselect('deselect',select);
		var select1 = $('#type2').val();
		$('#type2').multiselect('deselect',select1);
		var select2 = $('#type3').val();
		$('#type3').multiselect('deselect',select2);
		var pay_type = $('#pay_type').val();
		$('#pay_type').multiselect('deselect',pay_type);
		$('#recreat').val('');
		$('#applyType').val('');
		
	}
	function queryRule(){
		    var queryParams={};
		    queryParams.ruleName=$('#queryname').val();
		    queryParams.applyType=applyGoods('type5','type6','type7','type8');
		    
		    $.ajaxLoad({
		        url:'../compRule/getBuyRule',
		        type:'POST',
		        dataType:'json',
		        data:queryParams,
		        success:function(data){
		            $('#caigoujiaoyi').bootstrapTable('load',data);
		        }
		    });
	}
	function applyGoods(id1,id2,id3,id4){
		var val1 = $("#"+id1+" option:selected").text()=='请选择' ? '':$("#"+id1+" option:selected").text()+"-";
		var val2 = $("#"+id2+"  option:selected" ).text()=='请选择'|| !$("#"+id2+"  option:selected" ).text() ? '':$("#"+id2+" option:selected" ).text()+"-";
		var val3 = $("#"+id3+"  option:selected").text()=='请选择' || !$("#"+id3+"  option:selected" ).text() ? '':$("#"+id3+" option:selected" ).text()+"-";
		var val4 = $("#"+id4+"  option:selected").text()=='请选择' || !$("#"+id4+"  option:selected" ).text() ?  '':$("#"+id4+" option:selected" ).text()+"-";
		var temp = val1.trim()+val2.trim()+val3.trim()+val4.trim();
		     var test = temp.substring(0,temp.length-1);
		if(temp.length==1 || temp.length==2){
			test='';
		}
		return test;
	}
	function checkValue(){
		if(!$('#guizename').val()){
			$('#guizename').addClass('error');
			return false;
		}
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