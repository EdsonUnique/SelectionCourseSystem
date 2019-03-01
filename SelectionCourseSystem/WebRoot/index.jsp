<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>欢迎登录选课系统</title>
		<meta charset="UTF-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/style.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/All.js" defer="true"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-3.3.1.min.js"></script>
	</head>
	
	<body class="bg">
	<s:if test="hasActionErrors()"> 
		<s:iterator value="actionErrors"> 
		<script language="javascript"> 
			alert("<s:property escapeHtml='false'/>") ;
			
		</script> 
		
		</s:iterator> 
	</s:if> 
		<div  class="main" align="center" >

			<div class="intro">
				<div class="character_bg">
				</div>
				<div class="character">
						欢迎登录***大学选课系统
				</div>
			</div>

			<div class="login_form">
				<form action="${pageContext.request.contextPath }/admin_login" method="post" onsubmit="return checkLogin();">
					<div class="bottom"></div>
					<div class="login_table">
						<table >
							<tr>
								<td>
									用户名：
								</td>
								<td>
									<input type="text" id="username" name="username"  style="border-radius: 10px;text-indent: 10px;height: 25px;">
									
								</td>
								
							</tr>
							<tr>
								<td>
									密&nbsp;&nbsp;&nbsp;&nbsp;码：
								</td>
								<td>
									<input type="password" id="pwd"  name="pwd" style="border-radius: 10px;text-indent: 10px;height: 25px;">
								</td>
							</tr>
							<tr>
								<td colspan="2">
				
									<input type="radio" name="role" value="0" checked="checked">学生&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="role" value="1" >教师&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="role" value="2"  >管理员
								</td>
								
							</tr>
							<tr>
								<td>
									<button type="reset">重置</button>
								</td>
								<td style="text-align: right;">
									<input type="submit" value="登录">
								</td>
								
							</tr>
							

						</table>
					</div>

				</form>
				

			</div>

			<div class="footer">
				<span style="font-size:20px;float: left;margin-left:580px;margin-top:35px;">
					 Copyright 2019 by Yangxi.<br>
				</span>

			</div>
			
		</div>


	</body>


</html>



