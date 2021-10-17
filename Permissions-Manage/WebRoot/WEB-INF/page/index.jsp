<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Gcc办公系统</title>

<link href="jui/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="jui/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="jui/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="jui//uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="jui/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->
<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->
<script src="jui/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="jui/js/jquery.cookie.js" type="text/javascript"></script>
<script src="jui/js/jquery.validate.js" type="text/javascript"></script>
<script src="jui/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="jui/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="jui/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="jui/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="jui/chart/raphael.js"></script>
<script type="text/javascript" src="jui/chart/g.raphael.js"></script>
<script type="text/javascript" src="jui/chart/g.bar.js"></script>
<script type="text/javascript" src="jui/chart/g.line.js"></script>
<script type="text/javascript" src="jui/chart/g.pie.js"></script>
<script type="text/javascript" src="jui/chart/g.dot.js"></script>

<script src="jui/js/dwz.core.js" type="text/javascript"></script>
<script src="jui/js/dwz.util.date.js" type="text/javascript"></script>
<script src="jui/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="jui/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="jui/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="jui/js/dwz.drag.js" type="text/javascript"></script>
<script src="jui/js/dwz.tree.js" type="text/javascript"></script>
<script src="jui/js/dwz.accordion.js" type="text/javascript"></script>
<script src="jui/js/dwz.ui.js" type="text/javascript"></script>
<script src="jui/js/dwz.theme.js" type="text/javascript"></script>
<script src="jui/jui/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="jui/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="jui/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="jui/js/dwz.navTab.js" type="text/javascript"></script>
<script src="jui/js/dwz.tab.js" type="text/javascript"></script>
<script src="jui/js/dwz.resize.js" type="text/javascript"></script>
<script src="jui/js/dwz.dialog.js" type="text/javascript"></script>
<script src="jui/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="jui/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="jui/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="jui/js/dwz.stable.js" type="text/javascript"></script>
<script src="jui/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="jui/js/dwz.ajax.js" type="text/javascript"></script>
<script src="jui/js/dwz.pagination.js" type="text/javascript"></script>
<script src="jui/js/dwz.database.js" type="text/javascript"></script>
<script src="jui/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="jui/js/dwz.effects.js" type="text/javascript"></script>
<script src="jui/js/dwz.panel.js" type="text/javascript"></script>
<script src="jui/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="jui/js/dwz.history.js" type="text/javascript"></script>
<script src="jui/js/dwz.combox.js" type="text/javascript"></script>
<script src="jui/js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("jui/dwz.frag.xml", {
//		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
		loginUrl:"login.jsp",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<img src="common/logo2.png" width="200px">
				<ul class="nav">
					<li><a>${currentLoginUser.realName}</a></li>
					<li><a href="user/user/changePsw.do" rel="changePsw" target="dialog">修改密码</a></li>
					<li><a href="logout.do">退出</a></li>
				</ul>
			</div>
			<!-- navMenu -->
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
				
					<div class="accordionHeader">
						<h2><span>Folder</span>组织架构</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="user/user/list.do" target="navTab" rel="userList">员工管理</a></li>
							<li><a href="user/dept/main.do" target="navTab" rel="deptMian">部门管理</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>系统权限</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="user/per/list.do" target="navTab" rel="perList">权限管理</a></li>
							<li><a href="user/role/list.do" target="navTab" rel="roleList">角色管理</a></li>
						</ul>
					</div>
					
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						欢迎使用Gcc办公系统
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Gcc【】检测有限公司</div>


</body>
</html>

