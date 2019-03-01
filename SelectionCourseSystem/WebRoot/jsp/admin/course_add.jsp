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
				
				<form action="${pageContext.request.contextPath}${requestScope.course==null ?'/adminCourse_addCourse':'/adminCourse_updateCourse'}"
					 target="display_frame" method="post" onsubmit="return checkFields();">
					<table cellspacing="2px" cellpadding="10px" style="text-align: center;">
						
						<tr>
							<s:if test="%{#request.course==null}">
							<td>
								编号：
							</td>
							<td>
								<input id="stu_id"  type="text"   name="course_id" style="border-radius: 10px;text-indent: 10px;height: 25px;">
							</td>
							<td style="text-align: left;"><span id="note1" style="color:red;">*</span></td>
							</s:if>
						</tr>
						
						<s:else>
							<input id="stu_id" type="hidden" name="course_id" value="${requestScope.course.course_id }" style="border-radius: 10px;text-indent: 10px;height: 25px;">
								
						</s:else>
						<tr>
							<td>
								课程名称：
							</td>
							<td>
								<input id="stu_name" value="${requestScope.course.course_name }"  type="text" name="course_name" style="border-radius: 10px;text-indent: 10px;height: 25px;">
							</td>
							<td  style="text-align: left;"><span id="note2" style="color:red;">*</span></td>
						</tr>
						
						<tr>
							<td>
								授课教师
							</td>
							<td>
								<select name="tea.tea_id" autocomplete="off">
									<s:iterator value="%{#session.teas}" var="t">
										<option value="${t.tea_id}" ${requestScope.course.tea.tea_id==t.tea_id?'selected':'' }><s:property value="%{#t.tea_name}"/></option>
									</s:iterator>
								</select>
								
							</td>
								</tr>
						<tr>
							<td>
								学分
							</td>
							<td>
								<input id="stu_pwd" value="${requestScope.course.credit}"  type="text" name="credit" style="border-radius: 10px;text-indent: 10px;height: 25px;">
							</td>
							<td  style="text-align: left;"><span id="note3" style="color:red;">*</span></td>
						</tr>


						<tr>
							<td>
								<button type="reset">重置</button>
							</td>
							<td>
								<s:if test="%{#request.course==null }">
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
