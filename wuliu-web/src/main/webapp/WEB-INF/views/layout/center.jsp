<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script src="common/plugins/echarts/echarts.js"></script>
<script type="text/javascript">
	$(function() {
		$('#ddList').datagrid({
			//url:'ddWh.do?f=listHelooJson',
			pagination:true,
			pageSize : 50,
	        height: 'auto',   
	        nowrap: false,   
	        striped: true,   
	        border: true,   
	        collapsible:false,//是否可折叠的   
	        fit: true,//自动大小   
	        onClickRow: function() {
					var row = $('#ddList').datagrid('getSelected');
				}
		});
		var p = $('#ddList').datagrid('getPager');
		$(p).pagination({  
	        pageSize: 50,//每页显示的记录条数，默认为50  
	        pageList: [50,100,200],//可以设置每页记录条数的列表  
	        beforePageText: '第',//页数文本框前显示的汉字  
	        afterPageText: '页    共 {pages} 页' 
	    });
		
		$('#ggList').datagrid({
			url:'ggList.json',
			pagination:true,
			pageSize : 50,
	        height: 'auto',   
	        nowrap: false,   
	        striped: true,   
	        border: true,   
	        collapsible:false,//是否可折叠的   
	        fit: true,//自动大小   
<%--	        onClickRow: function() {--%>
<%--					var row = $('#ggList').datagrid('getSelected');--%>
<%--					if(row){--%>
<%--						$('<div/>').dialog({--%>
<%--					width : 600,--%>
<%--					height : 400,--%>
<%--					title : '公告信息',--%>
<%--					modal : true,--%>
<%--					closable: false,//去掉右上角关闭按钮--%>
<%--					cache: false,--%>
<%--					href : "zxd.do?f=ggView",--%>
<%--					buttons : [ {--%>
<%--						text : '关闭',--%>
<%--						handler : function(){dialog_close(this)}--%>
<%--					} ]--%>
<%--				});--%>
<%--					}--%>
<%--				}--%>
		});
		var p = $('#ggList').datagrid('getPager');
		$(p).pagination({  
	        pageSize: 50,//每页显示的记录条数，默认为50  
	        pageList: [50,100,200],//可以设置每页记录条数的列表  
	        beforePageText: '第',//页数文本框前显示的汉字  
	        afterPageText: '页    共 {pages} 页' 
	    });
		$('#layout_center_tabsMenu').menu({
			onClick : function(item) {
				var curTabTitle = $(this).data('tabTitle');//当前点击的菜单对应选项卡名字
				var type = $(item.target).attr('type');
				if (type === 'refresh') {//工具栏刷新
					return;
				}
				if (type === 'close') {//工具栏关闭
					var t = $('#layout_center_tabs').tabs('getTab', curTabTitle);
					if (t.panel('options').closable) {
						$('#layout_center_tabs').tabs('close', curTabTitle);
					}
					return;
				}
				//获取所有选项卡
				var allTabs = $('#layout_center_tabs').tabs('tabs');
				var closeTabsTitle = [];
				$.each(allTabs, function() {
					var opt = $(this).panel('options');
					if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
						closeTabsTitle.push(opt.title);
					} else if (opt.closable && type === 'closeAll') {
						closeTabsTitle.push(opt.title);
					}
				});
				for ( var i = 0; i < closeTabsTitle.length; i++) {
					$('#layout_center_tabs').tabs('close', closeTabsTitle[i]);
				}
			}
		});
<!--		$('#layout_center_tabs').tabs({-->
<!--			fit : true,-->
<!--			border : false,-->
<!--			onContextMenu : function(e, title) {-->
<!--				e.preventDefault();-->
<!--				$('#layout_center_tabsMenu').menu('show', {-->
<!--					left : e.pageX,-->
<!--					top : e.pageY-->
<!--				}).data('tabTitle', title);-->
<!--			}-->
<!--		});-->
	});
	var GLastMenuName='';
	function layout_center_addTabFun(opts) {
		var t = $('#layout_center_tabs');
		if ((GLastMenuName!=null)&& (GLastMenuName!='')) {
			var allTabs = $('#layout_center_tabs').tabs('tabs');
			var closeTabsTitle = [];
			$.each(allTabs, function() {
				var opt = $(this).panel('options');
				if (opt.closable) {
					closeTabsTitle.push(opt.title);
				}
			});
			for ( var i = 0; i < closeTabsTitle.length; i++) {
				$('#layout_center_tabs').tabs('close', closeTabsTitle[i]);
			}
		}
		GLastMenuName=opts.title;
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
	}
</script>
<script type="text/javascript">
require.config({
	  paths: {
	    echarts: 'http://echarts.baidu.com/build/dist'
	  }
	});

	// 使用
	require(
	  [
	    'echarts',
	    'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
	    'echarts/chart/funnel', // 使用柱状图就加载bar模块，按需加载
	  ],
	  function (ec) {
	    // 基于准备好的dom，初始化echarts图表
	    var myChart = ec.init(document.getElementById('mainEcharts')); 
	    //设置数据
	    option = {
    title : {
        text: '数据',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:['李','张','向','韦','熊']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'left',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name:'访问来源',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'李'},
                {value:310, name:'张'},
                {value:234, name:'向'},
                {value:135, name:'韦'},
                {value:1548, name:'熊'}
            ]
        }
    ]
};

	    // 为echarts对象加载数据 
	    myChart.setOption(option); 
	  }
	);
</script>
<div id="layout_center_tabs" style="overflow: hidden;">
		
			<div     style="height:250px; width:36%; float: left;margin-right: 20px; ">
				<div class="easyui-panel" id="mainEcharts" title="快捷功能" style="width:420px;height:250px;padding:10px;">
							
				</div>
			</div>
			<div id="div_gc" style="height: 250px; width: 62%; float: left; ">
				<table id="ggList" width="100%" title="公告栏"
					data-options="fitColumns:true,rownumbers:true,singleSelect:true">
					<thead>
						<tr>
							<th data-options="field:'mc',width:160">名称</th>
							<th data-options="field:'sbr',width:160">发布人</th>
							<th data-options="field:'sj',width:160">发布时间</th>
						</tr>
					</thead>
				</table>
			</div>
			<div id="div_gc" style="height: 300px; width: 100%; float: left; margin-top: 20px;">
				<table id="ddList" width="100%" title="待处理业务"
					data-options="fitColumns:true,rownumbers:true,singleSelect:true">
					<thead>
						<tr>
							<th data-options="field:'ddwhDdh',width:160">订单号</th>
							<th data-options="field:'ddwhVin',width:160">VIN码</th>
							<th data-options="field:'ddwhCfd',width:160">出发地</th>
							<th data-options="field:'ddwhMdd',width:160">目的地</th>
							<th data-options="field:'ddwhDdsj',width:160
							,formatter:
									function(val,rec){
										if (val){
											var date = new Date(val.time);
											var d = date.getFullYear()+'-'+(date.getMonth() + 1)+'-'+date.getDate();
											var t = date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
											return d;
										}else{
											return '';
										}
									}">计划到达时间</th>
						</tr>
					</thead>
				</table>
			</div>
			</div>
</div>
<div id="layout_center_tabsMenu" style="width: 120px;display:none;">
	<div type="refresh">刷新</div>
	<div class="menu-sep"></div>
	<div type="close">关闭</div>
	<div type="closeOther">关闭其他</div>
	<div type="closeAll">关闭所有</div>
</div>