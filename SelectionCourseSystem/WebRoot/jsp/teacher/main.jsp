<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>教师管理页面</title>
		<meta charset="utf-8">
		<meta name=”viewport” content=”width=device-width, initial-scale=1″ /><!--自适应屏幕大小-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/tea.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/js/dtree.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/dtree.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/All.js" defer="true"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
		
		
		<div class="header" name="header">
			<div class="character_bg"></div>
			<div class="character">
				欢迎登录选课系统教师界面管理
			</div>
			<div class="login_user">
				用户名：${tea_user.tea_name }&nbsp;&nbsp;&nbsp;&nbsp;<button type="button" onclick="javascript:window.location.href='${pageContext.request.contextPath}/tea_logOut'">退出</button>
				<button type="button" onclick="javascript:self.frames['display_frame'].location.href='${pageContext.request.contextPath}/tea_updatePwdUI'">修改密码</button>
			</div>
		</div>

		<div  class="menu" >
			<div class="menu_bottom">
				
			</div>
			<div  class="menu_container">
				<ul class="alink">
					<li>
						<a href="${pageContext.request.contextPath}/tea_viewMyCourse" target="display_frame" > 我的课程信息</font></a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/tea_viewMySelection" target="display_frame" > 我的开课信息</font></a>
					</li>
				</ul>
			</div>
			
		</div>

		
		<div class="display_iframe">
			<div class="iframe_bottom">
			
			</div>
			<div class="iframe">
				<iframe name="display_frame" width="100%" height="100%"  style="text-align:center;" scrolling="no"></iframe>
			</div>

		</div>


	</body>


</html>
