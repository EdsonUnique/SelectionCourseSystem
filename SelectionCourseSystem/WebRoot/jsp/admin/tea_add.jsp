<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/admin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/All.js" defer="true"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/laydate/laydate.js"></script> 
		<script>
			//执行一个laydate实例
			laydate.render({
			  elem: '#tea_birth' //指定元素
			
			});
			
		</script>
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
				
				<form action="${pageContext.request.contextPath}${requestScope.tea==null ?'/adminTea_addTeacher':'/adminTea_updateTeacher'}"
					 target="display_frame" method="post" onsubmit="return checkFields();">
					<table cellspacing="2px" cellpadding="10px" style="text-align: center;">
						
						<tr>
							<s:if test="%{#request.tea==null}">
							<td>
								工号：
							</td>
							<td>
								<input id="stu_id" type="text" name="tea_id" value="${requestScope.tea.tea_id }" style="border-radius: 10px;text-indent: 10px;height: 25px;">
								
							</td>
							<td style="text-align: left;"><span id="note1" style="color:red;">*</span></td>
							</s:if>
						</tr>
						
						<s:else>
							<input id="stu_id" type="hidden" name="tea_id" value="${requestScope.tea.tea_id }" style="border-radius: 10px;text-indent: 10px;height: 25px;">
								
						</s:else>
						<tr>
							<td>
								姓名：
							</td>
							<td>
								<input id="stu_name" type="text" name="tea_name" value="${requestScope.tea.tea_name }" style="border-radius: 10px;text-indent: 10px;height: 25px;">
								
							</td>
							<td  style="text-align: left;"><span id="note2" style="color:red;">*</span></td>
						</tr>
						<tr>
							<td>
								性别：
							</td>
							<td>
								<select name="tea_gender" autocomplete="off">
									<option value="1" ${requestScope.tea.tea_gender==1?'selected':''}>男</option>
									<option value="0" ${requestScope.tea.tea_gender==0?'selected':''}>女</option>
								</select>
							</td>
							<td></td>
						</tr>
						<tr>
							<td>
								登录密码：
							</td>
							<td>
								<input type="text" value="${requestScope.tea.tea_pwd }" id="stu_pwd" name="tea_pwd" style="border-radius: 10px;text-indent: 10px;height: 25px;">
								
							</td>
							<td  style="text-align: left;"><span id="note3" style="color:red;">*</span></td>
						</tr>
						<tr>
							<td>
								出生年月：
							</td>
							<td>
								<input type="text" id="tea_birth" name="tea_birth" value="${requestScope.tea.tea_birth }" style="border-radius: 10px;text-indent: 10px;height: 25px;">
							</td>
							<td></td>
						</tr>


						<tr>
							<td>
								<button type="reset">重置</button>
							</td>
							<td>
								<s:if test="%{#request.tea==null }">
									<input type="submit" value="添加" >
								</s:if>
								<s:else>
									<input type="submit" value="修改" >
								</s:else>
							</td>
							<td></td>
						</tr>
					</table>


				</form>

			</div>


		</div>


	</body>





</html>