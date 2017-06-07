<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="inc.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--[if IE 8]> <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /><![endif]-->
<title>产贸送管理后台</title>
<script type="text/javascript">
	var index_layout;
	var index_tabs;
	var index_tabsMenu;
	var layout_west_tree;
	var layout_west_tree_url = '';
	
	var sessionInfo_userId = '${sessionInfo.userId}';
	if (sessionInfo_userId) {//如果没有登录,直接跳转到登录页面
		layout_west_tree_url = '${ctx}/access/tree';
	}else{
		window.location.href='${ctx}/login/index';
	}
	$(function() {
		index_layout = $('#index_layout').layout({
			fit : true
		});
		index_tabs = $('#index_tabs').tabs({
			fit : true,
			border : false,
			tools : [{
				iconCls : 'icon_home',
				handler : function() {
					index_tabs.tabs('select', 0);
				}
			}, {
				iconCls : 'icon_refresh',
				handler : function() {
					var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
					index_tabs.tabs('getTab', index).panel();
					if(index==0){
						//显示数量
						if($.showUserCount || $.showComCount || $.showPaymentApplyCount || $.showRepairCount){
							$('.light-info').html('<div>欢迎您使用易后台协同工作平台。</div>');
						}
					}
				}
			}, {
				iconCls : 'icon_del',
				handler : function() {
					var index = index_tabs.tabs('getTabIndex', index_tabs.tabs('getSelected'));
					var tab = index_tabs.tabs('getTab', index);
					if (tab.panel('options').closable) {
						index_tabs.tabs('close', index);
					}
				}
			} ]
		});
		
		layout_west_tree = $('#layout_west_tree').tree({
			url : layout_west_tree_url,
			parentField : 'pid',
			lines : false,
			onClick : function(node) {
				$("#layout_west_tree").tree('toggle', node.target);
				if (node.attributes && node.attributes.url) {
					var url = '${ctx}' + node.attributes.url;
					addTab({
						url : url,
						title : node.text,
						iconCls : 'ico_blank',
						nodeid:node.id
					});
				}
			}
		});
		$('#ptTab').tabs({ 
			border:false, 
			onSelect:function(title,index){ 
				if(index==0){
					$("#process1").attr('src','${ctx}/process/processViewShow?dataType=0');
				}else{
					$("#task1").attr('src','${ctx}/tasks/taskViewShow?dataType=0');
				}
			} 
		});
		$('#proceTab').tabs({ 
			border:false, 
			onSelect:function(title,index){ 
				if(index==0){
					$("#process1").attr('src','${ctx}/process/processViewShow?dataType=0');
				}else if(index==1){
					$("#process2").attr('src','${ctx}/process/processViewShow?dataType=1');
				}else{
					$("#process3").attr('src','${ctx}/process/processViewShow?dataType=2');
				}
			} 
		});
		$('#taskTab').tabs({ 
			border:false, 
			onSelect:function(title,index){ 
				if(index==0){
					$("#task1").attr('src','${ctx}/tasks/taskViewShow?dataType=0');
				}else if(index==1){
					$("#task2").attr('src','${ctx}/tasks/taskViewShow?dataType=1');
				}else{
					$("#task3").attr('src','${ctx}/tasks/taskViewShow?dataType=2');
				}
			} 
		});
		getShortcutList();
	});
	
	function getShortcutList(){
		$.get('${ctx}/shortcutmenu/userShortMenuList',{stamp: Math.random() }, function(result){
			var ob;
			var htmlStr = "";
			//result = $.parseJSON(result);
			for(var i=0;i<result.length;i++){
				ob = result[i];
				htmlStr += '<span class="l-btn-function l-btn-text" id="'+ob.id+'"><a href="javascript:void(0);" onclick="createTab(\''+ob.accessMenuUrl+'\',\''+ob.accessMenuName+'\',\''+ob.accessMenuId+'\')">'+ob.accessMenuName+'</a><label onclick="reMove(\''+ob.id+'\');" style="font-size:17px;"> ×</label></span>';
			}
			$("#cutMenu").html(htmlStr);
		});
		
	}
	
	//新增新开页签方法
	function createTabNew(url,text,tid){
		if (url) {
			var url = '${ctx}' +url;
			addTabNew({
				url : url,
				title : text,
				iconCls : 'ico_blank',
				nodeid:tid
			});
		}
	}
	//新增页签
	function addTabNew(params) {
		var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : iframe,
			border : false,
			fit : true,
			nodeid:params.nodeid
		};
		//如果页签已存在，先关闭，再新增
		if (t.tabs('exists', opts.title)) {
			
			t.tabs('close', opts.title);
		} 
		t.tabs('add', opts);
		
	}
	
	function createTab(url,text,tid){
		if (url) {
			var url = '${ctx}' +url;
			addTab({
				url : url,
				title : text,
				iconCls : 'ico_blank',
				nodeid:tid
			});
		}
	}
	function addTab(params) {
		var iframe = '<iframe src="' + params.url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : params.title,
			closable : true,
			iconCls : params.iconCls,
			content : iframe,
			border : false,
			fit : true,
			nodeid:params.nodeid
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
	}
	
	function removeTab(title){
		var t = $('#index_tabs');
		t.tabs('close', title);
	}
	
	function addMainTab(url,title,iconCls) {
		var iframe = '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:98%;"></iframe>';
		var t = $('#index_tabs');
		var opts = {
			title : title,
			closable : true,
			iconCls : iconCls,
			content : iframe,
			border : false,
			fit : true
		};
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
	}
	
	
	function logout(){
		$.messager.confirm('提示','确定要退出?',function(r){
			if (r){
				progressLoad();
				$.post( '${ctx}/login/logout', function(result) {
					if(result.success){
						progressClose();
						$(window).unbind('beforeunload');
						window.location.href='${ctx}/login/index';
					}
				}, 'json');
			}
		});
	}
	

	function editUserPwd() {
		parent.$.modalDialog({
			title : '修改密码',
			width : 300,
			height : 220,
			href : '${ctx}/user/editPwdPage',
			buttons : [ {
				text : '保存',
				handler : function() {
					var f = parent.$.modalDialog.handler.find('#editUserPwdForm');
					f.submit();
				}
			} ]
		});
	}
	function addCount(url,title){
		addTab({
			url : '${ctx}'+url,
			title : title,
			iconCls : 'ico_blank'
		});
	}
	function addMan(){
		var numButt = $('.content-top-funcbutton span').size();
		if(numButt<8){
			parent.$.modalDialog({
				title : '添加',
				width : 300,
				height : 130,
				href : '${ctx}/shortcutmenu/addPage',
				buttons : [ {
					text : '保存',
					handler : function() {
						var f = parent.$.modalDialog.handler.find('#userShortcutMenuAddForm');
						f.submit();
					}
				} ]
			});
		}else{
			$.messager.confirm('提示','添加标签过多，最多只能添加5个','info');
		} 
	}
	
	function reMove(id){
		$.post('${ctx}/shortcutmenu/delete', {
			id : id
		}, function(result) {
			if (result.success) {
				$.messager.alert('提示', result.msg, 'info');
				$("#"+id).remove();
			}else{
				$.messager.alert('提示', result.msg, 'info');
			}
			progressClose();
		}, 'JSON');	
	}
	
</script>
  <link rel="stylesheet" href="${ctx}/style/css/reset.css"/>
    <link rel="stylesheet" href="${ctx}/style/css/index.css"/>
</head>
<style>
	#index_tabs .tabs-title{background:#E8E7E7;display:inline-block;padding:0 25px;border-top:solid 3px #5DBEF4;}
	#index_tabs .tabs li.tabs-selected .tabs-title{background:#F5F5F5;}
	#index_tabs .datagrid-row-selected{background:#EA5415;color:#ffffff;border:solid 1px #ffffff;}
	#content-left div.tabs-header{background-color:#EBECED !important;}
	#ptTab div.tabs-header{background-color:#EBECED !important;}
</style>
<body>
<div class="wrap">
    <div class="header">
        <div class="header-left"></div>
        <div class="header-right">
            <span><!-- <img src="${ctx}/style/img/rc-bg.png">  --></span>
            <div class="out">

                <p>
                	<i></i><a href="javascript:void(0)" onclick="createTab('/loginUser/userCenter','用户中心','1')" class="tuichu">用户中心</a>|
                	<i class="supadm"></i>${sessionInfo.name}
                	<!-- 
                		|<i class="iconRmind"></i><a href="javascript:;" onclick="createTab('/remind/index','提醒列表','2')" class="tuichu">提醒（<label id="counts" style="color:red;">0</label>）</a>
                	 -->
                	|<i class="iconPwd"></i><a href="javascript:;" onclick="editUserPwd()" class="tuichu">修改密码</a>
                	|<i class="goout"></i><a href="javascript:;" onclick="logout()" class="tuichu">退出</a>
                </p>
            </div>
        </div>
    </div>
    <div class="main">
        <div class="main-left">
            <div class="sfq">
            <c:set var="num" value='0'></c:set>
            	<c:forEach items="${menu_tree}" var="menu" >
					<c:if test="${menu.pid==null}">
						<c:set var="num" value='${num+1 }'></c:set>
						  <dl  >  
                    		<dt <c:if test="${num%2!=0}"> class="change" </c:if>><span class="bg1"><img src="${ctx}${menu.iconCls}" width="30px"> </span><a href="javascript:;">${menu.text}</a></dt>
	                		<dd>
		                		<c:forEach items="${menu_tree}" var="menu1">
		                			<c:if test="${menu1.pid==menu.id}">
				                        <ol>
				                            <li onclick="createTab('${menu1.attributes.url}','${menu1.text}','${menu1.id}')"><i><img src="${ctx}/style/img/13.png"></i><a href="javascript:;">${menu1.text}</a></li>
				                        </ol>
		                			</c:if>
		                		</c:forEach>
				        	</dd>
                		</dl> 
					</c:if> 
				</c:forEach>
            </div>
        </div>
        
        <div class="main-right" style="height: 800px;">
			<div id="index_tabs" >
				 <div class="rc-system" title="首页">
                <div class="tab">
                    <div class="tab-content">
                        <div class="system-content-top">
	                        <div class="content-top-funcbutton">
	                            <span class="panel-title content-top-cyfunc">常用功能</span>
	                            <div id="cutMenu" class="content-top-btn">
	                            </div>
	                            <div style="float:right;height:46px;">
	                        		<span class="l-btn-function l-btn-text l-btn-bjcygn" onclick="addMan();">+  添加常用功能</span>
	                        	</div>
	                        </div>
                       	</div>
                        <!-- 左边内容框架 -->
                        <div class="system-content-left">
                        	<!-- <div class="task-header">
                        	<span class="panel-title">流程任务</span>
                        	<span class="task-gd" onclick="createTab('/tasks/taskView','任务处理','1')" >更多任务﹥</span>
                        	<span class="task-gd"></span>
                        	<span class="task-gd" onclick="createTab('/process/processView','业务流程','0')" >更多流程﹥</span>
                        	</div>
                        	<div class="task-content">
                        		<div id="ptTab" class="task-header-one easyui-tabs">
                        			<div title="业务流程" data-options="">
										<div class="easyui-tabs" id="proceTab">
										    <div title="我的流程" class="panel-cont"  style="width:551px;">
												<iframe scrolling="yes" frameborder="0" id="process1" src="${ctx}/process/processViewShow?dataType=0" style="width:551px;height:100%;"></iframe>
										    </div>
										    <div title="我发送的流程" class="panel-cont" data-options="" style="overflow:auto;">
												<iframe scrolling="yes" frameborder="0" id="process2" src="" style="width:551px;height:100%;"></iframe>
										    </div>
										    <div title="我下属的流程" class="panel-cont" data-options="iconCls:'icon-reload'">
												<iframe scrolling="yes" frameborder="0" id="process3" src="" style="width:551px;height:100%;"></iframe>
										    </div>
										</div>
									</div>
                        			<div title="任务" data-options="">
										<div class="easyui-tabs" id="taskTab">
										    <div title="我的任务" class="panel-cont">
												<iframe scrolling="yes" frameborder="0" id="task1" src="" style="width:100%;height:100%;"></iframe>
										    </div>
										    <div title="我发送的任务" class="panel-cont" data-options="" style="overflow:auto;">
												<iframe scrolling="yes" frameborder="0" id="task2" src="" style="width:100%;height:100%;"></iframe>
										    </div>
										    <div title="我下属的任务" class="panel-cont" data-options="iconCls:'icon-reload'" >
												<iframe scrolling="yes" frameborder="0" id="task3" src="" style="width:100%;height:100%;"></iframe>
										    </div>
										</div>
									</div>
									
                        		</div>
                        	</div>
                        	 -->
                        </div>
                        <!-- 右边内容框架 -->
                        <div class="system-content-right">
                        	<!-- <div class="task-header">
                        	<span class="panel-title">提醒</span>
                        	<span class="panel-title" style="cursor:pointer;" onclick="createTab('/event/indexEvent','查看工作日历','2')">查看工作日历</span>
                        	<span class="task-gd" onclick="createTab('/remind/index','提醒列表','1')" >更多提醒﹥﹥</span>
                        	
                        	</div>
                        	<div class="task-content">
                        		<div id="content-left" class="task-header-one easyui-tabs">
                        			<div title="未读提醒" class="tixi-sx">
										<iframe scrolling="yes" frameborder="0" id="remind0"  src="" style="width:530px;height:100%;"></iframe>
										<script>
										$("#remind0").attr('src','${ctx}/remind/indexPage?type=1');
										</script>
									</div>
									
									<div title="全部提醒" class="tixi-sx" ">	
										<iframe scrolling="yes" frameborder="0" id="remind1" src="" style="width:530px;height:100%;"></iframe>
										<script>
										$("#remind1").attr('src','${ctx}/remind/indexPage?type=2');
									</script>
									</div>
									
								</div>
									
                        	</div>
                        	
                        	<div class="task-header-notice">
	                        	<span class="panel-title">公司公告</span>
	                        	<span class="task-gd" onclick="createTab('/notice/index','公告列表','1')" >更多公告﹥﹥</span>
                        	</div>

                        	<div class="task-content">
                        	<div id="content-left" class="task-header-one easyui-tabs">
                        			<div title="置顶公告" class="tixi-sx">
										<iframe scrolling="yes" frameborder="0" id="notice0" src="" style="width:530px;height:100%;"></iframe>
										<script>
										$("#notice0").attr('src','${ctx}/notice/indexNotice?isTop=0');
									</script>
									</div>
									
									<div title="其它公告" class="tixi-sx" ">	
										<iframe scrolling="yes" frameborder="0" id="notice1" src="" style="width:530px;height:100%;"></iframe>
										<script>
											$("#notice1").attr('src','${ctx}/notice/indexNotice?isTop=1');
										</script>
									</div>
									
								</div>

                        </div>
                         -->
                    </div>
                </div>
            </div> 
			</div>
		</div>
 
    </div>
    <div class="clear"></div>
    <div class="footer"style="height:35px;width:1349px;width:1345px \0;background:#5DBEF4;">
    	
    </div>

</div>
<script src="${ctx}/style/js/sfq.js"></script>
</body></html>