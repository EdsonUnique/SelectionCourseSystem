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
		
		<div class="search">
			<div class="update_container">
			<table cellpadding="10px" cellspacing="2px">
				<tr>
					<td>
						<input id="course_id" type="text" name="course_id" style="border-radius: 20px;text-indent: 20px;height: 25px;">
					</td>
					<td>
						<button onclick="javascript: checkCourseId();">按课程编号查询</button>
					</td>
					<td>
						<input id="course_name" type="text" name="course_name" style="border-radius: 20px;text-indent: 20px;height: 25px;">
					</td>
					<td>
						<button onclick="javascript: checkCourseName();">按课程名称查询</button>
					</td>
				</tr>
			</table>
			</div>
		</div>
		<div class="display_all">
			<div class="display_table_bottom" style="width: 100%;margin-left: 0;"></div>
			<div class="display_container" style="margin-left: 100px;width:100%;">
			
			<s:if test="%{#session.pb.pageData.size()==0}"><span style="color:red;">数据库暂无该对象数据</span></s:if>
			<s:else>
			<table cellpadding="10px" cellspacing="2px" border="1px solid" style="text-align: center;">
				<tr>
					<td>
						编号
					</td>
					
					<td>
						课程名称
					</td>
					<td>
						授课教师
					</td>
					<td>
						学分
					</td>
					
					<td colspan="2">
						操作
					</td>
				</tr>
				<s:iterator value="%{#session.pb.pageData}" var="course">
				<tr>
					<td>
						<s:property value="%{#course.course_id}"/>
					</td>
					<td>
						<s:property value="%{#course.course_name}"/>
					</td>
					
					<td>
						<s:property value="%{#course.tea.tea_name}"/>
					</td>
					<td>
						<s:property value="%{#course.credit}"/>
					</td>
					<td>
						<button onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminCourse_updateCourseUI?course_id='+'${course.course_id}'">修改</button>
					</td>
					<td>
						<button onclick="javascript:deleteCourse(${course.course_id});">删除</button>
					</td>
				</tr>
				</s:iterator>
			</table>
			</s:else>
			</div>
			
		</div>
		<div class="pagenum">
			<div class="page_container" style="margin-left: 200px;">
				<table cellpadding="10px" cellspacing="20px" style="text-align: center;">
					<tr>
						<td>
							当前页码：<s:property value="%{#session.pb.currentPage}"/>
							总记录：<s:property value="%{#session.pb.totalRecord}"/>条
						</td>
						<s:if test="%{#session.pb.pageData.size()>0}">
						<td>
							<input id="pagenum" type="text" style="text-indent: 20px;height: 25px;width: 50px;border-radius: 5px;">
							&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;&nbsp;<s:property value="%{#session.pb.totalPage}"/>
							
							<button onclick="javascript:gotoPagenum('${pb.path}','${pb.totalPage }');">跳转</button>
						</td>
					
						
						<s:if test="%{#session.pb.currentPage>1}">
						<td>
							<button onclick="javascript:window.location.href='${pageContext.request.contextPath}'+'${pb.path}?num=${pb.currentPage-1} '">上一页</button>
						</td>
						</s:if>
						<s:if test="%{#session.pb.currentPage!=#session.pb.totalPage}">
						<td>
							<button onclick="javascript:window.location.href='${pageContext.request.contextPath}'+'${ pb.path}?num=${ pb.currentPage+1}'">下一页</button>
						</td>
						</s:if>
						</s:if>
					</tr>
				</table>
			</div>
		</div>

	</body>









</html>

