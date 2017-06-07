<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--<link rel="stylesheet" href="/common/css/layout.css" type="text/css"></link>--%>
<style type="text/css">
	#breadcrumb ul {background:url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/navigatorBG.png) repeat-x left top; height:24px;}
	#breadcrumb ul {border: 1px solid #bbb;border-bottom:1px solid #999; }
	#breadcrumb ul, li { list-style-type: none; padding: 0; margin: 0; }
	#breadcrumb ul li { float: left; line-height: 25px; padding-left: .75em; color: #000; }
	#breadcrumb ul li a { display: block; padding: 0 15px 0 0px; background: url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/nav.png) no-repeat right bottom; height:25px; }
	#breadcrumb ul li a img {border:0;}
	#breadcrumb ul li a:link, #breadcrumb ul li a:visited { text-decoration: none; color: #000; }
	#breadcrumb ul li a:hover, #breadcrumb ul li a:focus { color: #000; }
	#breadcrumb ul li .NavActiveLeft {background:url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/navigatorActiveLeft.png) no-repeat left top; display:inline-block; padding-left:15px;}
	#breadcrumb ul li .NavActiveRight {background:url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/navigatorActiveRight.png) no-repeat right top; display:inline-block; color:#fff; padding:0 20px 0 10px;}
	#breadcrumb ul li .NoBGImg { background:none;}
</style>
<script type="text/javascript" charset="utf-8">
	function logoutFun() {
		$('<div/>').dialog({
			width : 500,
			height : 180,
			title : '锁定窗口',
			modal : true,
			cache: false,
			closable: false,//去掉右上角关闭按钮
			href : 'login.do?f=dlgLoginLockUser',
			buttons:[{
				text:'确定',
				iconCls:'icon-ok',
				handler:function(){
				var d = $(this).closest('.window-body');
					var loginPwd=$('#loginPwd').val();
					var userPswd=$('#userPswd').val();
					 $.ajax({type:'POST',url:"login.do?f=checkLoginLockUser",data:{loginPwd:loginPwd},
				            success:function(data){
				            console.info(data);
					            if(data==1){
									$(d).dialog('destroy');
					            }else if(data==2){
					            	$.messager.alert("信息","密码错误，请重新输入!!!","info");
							    }else{
					              $.messager.alert("信息","请输入密码!!!","info");
					            }
				            },
				            error:function(request, textStatus){
				              $.messager.alert('信息', textStatus, 'error');
				            }
				      });
				}
			}]
		});
	}
	function userInfoFun() {
			$('<div/>').dialog({
				width : 500,
				height : 270,
				title : '修改密码',
				modal : true,
				cache: false,
				closable: false,//去掉右上角关闭按钮
				href : 'login.do?f=dlgLoginPwd',
				buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function(){
						var d = $(this).closest('.window-body');
						$('#frmLoginPwd').form('submit', {
							url : 'login.do?f=pwdLogin',
							onSubmit : function() {
								return $(this).form('validate');
							},
							success : function(data) {
								if (data=='success') {
									$.messager.alert('信息', "操作成功!", 'info');
									$(d).dialog('destroy');
								} else
									$.messager.alert('信息', "新旧密码不一致", 'error');
							}
						});
					}
				}, {
					text : '关闭',
					handler : function() {
						var d = $(this).closest('.window-body');
						$(d).dialog('destroy');
					}
				}]
			});
	}
	function home(){
		var tabs = $("#layout_center_tabs");
		tabs.tabs('select','主页');
	}
</script>
<div class="ui-layout-north">
	<input value="${loginName}" type="hidden" id="loginName" name="loginName"/>
			<header class="clearfix headerSkin">
				<div class="headerContainer headerContainerSkin">
					<div class="headerLogo floatLeft" style="background:url('${pageContext.request.contextPath}/common/image/bgtop.png');height:65px;">
						<a href="#" onclick="home();">
							<img src="${pageContext.request.contextPath}/common/resources/logo.png" title="" />
						</a>
					</div>
				</div><!--headerContainer-->
						<div id="sessionInfoDiv" style="position: absolute;right: 5px;top:10px;">
							<strong style="color:#fff">${loginName}</strong>&nbsp;&nbsp;<lable style="color:#fff">欢迎你！</lable>
							<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_kzmbMenu',iconCls:'icon-panle'"><lable style="color:#fff">控制面板</label></a> 
							<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'icon-back'"><lable style="color:#fff">注销</label></a>
						</div>
						<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
							<div onclick="userInfoFun();">修改密码</div>
							<div class="menu-sep"></div>
							<div>
								<span>更换主题</span>
								<div style="width: 120px;">
									<div onclick="changeTheme('default');">default</div>
									<div onclick="changeTheme('gray');">gray</div>
									<div onclick="changeTheme('bootstrap');">bootstrap</div>
									<div onclick="changeTheme('black');">black</div>
									<div onclick="changeTheme('metro');">metro</div>
									<div onclick="changeTheme('ui-cupertino');">cupertino</div>
									<div onclick="changeTheme('ui-dark-hive');">dark-hive</div>
									<div onclick="changeTheme('ui-pepper-grinder');">pepper-grinder</div>
									
									<div onclick="changeTheme('metro-blue');">metro-blue</div>
									<div onclick="changeTheme('metro-gray');">metro-gray</div>
									<div onclick="changeTheme('metro-green');">metro-green</div>
									<div onclick="changeTheme('metro-orange');">metro-orange</div>
									<div onclick="changeTheme('metro-red');">metro-red</div>
									<div onclick="changeTheme('ui-sunny');">sunny</div>
								</div>
							</div>
						</div>
						<div id="layout_north_zxMenu" style="width: 100px; display: none;">
							<div onclick="logoutFun();">锁定窗口</div>
							<div><a href="login.do?f=quitLogin" style="text-decoration:none;">重新登录</a></div>
							<div><a href="login.do?f=quitLogin" style="text-decoration:none;">退出系统</a></div>
						</div>
				<div id="breadCrumbContainer">
					<div id="breadcrumb" style="height:24px;background:url(${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/navigatorBG.png) repeat-x left top;">
						<ul>
							<li>
								<img alt="首页" src="${pageContext.request.contextPath}/common/resources/themes/theme_normal/images/icon/iconHome.png" class="marginTop5 marginRight10" style="margin-top:5px;margin-right:10px;">
							</li>
						</ul>
					</div>
				</div>
			</header>
		</div>