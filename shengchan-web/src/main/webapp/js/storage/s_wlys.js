$(function() {
		//日历控件的使用
		laydate({
			elem : '#start',
			event : 'focus'
		});
		laydate({
			elem : '#end',
			event : 'focus'
		});
		//配置行业
		var hangye = [ {
			label : '请选择',
			title : '请选择',
			value : '0'
		}, {
			label : '行业1',
			value : '2'
		}, {
			label : '行业2',
			value : '1'
		} ];
		$('#hangye').multiselect('dataprovider', hangye);
		//配置运输方式
		var trans_type = [ {
			label : '请选择',
			title : '请选择',
			value : '0'
		}, {
			label : '铁路',
			value : '2'
		}, {
			label : '公路',
			value : '1'
		} ];
		$('#trans_type').multiselect('dataprovider', trans_type);
		//配置需求状态
		var require_status = [ {
			label : '请选择',
			title : '请选择',
			value : '0'
		}, {
			label : '需求1',
			value : '2'
		}, {
			label : '需求2',
			value : '1'
		} ];
		$('#require_status').multiselect('dataprovider', require_status);

		layer.config({
			extend : [ 'skin/myskin.css' ]
		//加载新皮肤
		});

		$('#btn_tanchu').click(function() {
			layer.open({
				title : [ '新增物流需求', 'font-size:18pt;text-align:center' ],
				skin : 'layui-layer-cms',
				closeBtn : 2,
				offset : 'center', //右下角弹出
				type : 2,
				area : [ '65%' ],//[width,height]
				content : 'index/header',
				btn : [ '提交' ],
				yes : function(index, layero) {
					layer.close(index);
				}
			});
		});
		var $wltext = "";
		var $wlinput = "";
		var $btn_quere = "";
		//实现可编辑功能
	});
	//使用编辑功能所使用到的方法.
	function btn() {
		var $btn = $btn_quere.find('button');
		$btn.click(function() {
			$btn_quere.hide();
			var text = $(this).html();
			if ('保存' == text) {
				layer.alert('修改成功', {
					icon : 1
				},function(index){
					$wltext.each(function(i, v) {
						$(v).show();
					});
					$wlinput.each(function(i, va) {
						$(va).hide();
					});
					
					layer.close(index);
				});
			} else {
				layer.confirm('确认不进行修改?', {
					icon : 3,
					title : '提示'
				}, function(index) {
					$wltext.each(function(i, v) {
						$(v).show();
					});
					$wlinput.each(function(i, va) {
						$(va).hide();
					});
					layer.close(index);
				});
			}
		});
	}