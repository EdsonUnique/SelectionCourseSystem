<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/admin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/All.js" defer="true"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-3.3.1.min.js"></script>
	</head>
	
	<body>
	<s:if test="hasActionErrors()"> 
		<s:iterator value="actionErrors"> 
		<script language="javascript"> 
			alert("<s:property escapeHtml='false'/>") ;
			
		</script> 
		
		</s:iterator> 
	</s:if> 
		<div class="main_body">
			
			<div class="table_bottom"></div>
			<div class="table_container">
				
				<form action="${pageContext.request.contextPath}/stu_updatePwd" method="post" target="_top" onsubmit="return checkPwdFields();">
					<table cellspacing="2px" cellpadding="10px" style="text-align: center;">
						<tr>
							<td>
								新密码：
							</td>
							<td>
								<input id="pwd1"  type="password" name="pwd1" style="border-radius: 10px;text-indent: 10px;height: 25px;"/>
							</td>
							<td  style="text-align: left;">
								<span id="s1" style="color:red;">*</span>
							</td>
						</tr>
						
						<tr>
							<td>
								再次确认新密码：
							</td>
							<td>
								<input id="pwd2"   type="password" name="pwd2" style="border-radius: 10px;text-indent: 10px;height: 25px;">
							</td>
							<td  style="text-align: left;">
								<span id="s2" style="color:red;">*</span>
							</td>
						</tr>
						<tr>
							<td>
								<button type="reset">重置</button>
							</td>
							<td>
								<button type="submit">修改</button>
							</td>
						</tr>
					</table>


				</form>

			</div>


		</div>


	</body>





</html>
