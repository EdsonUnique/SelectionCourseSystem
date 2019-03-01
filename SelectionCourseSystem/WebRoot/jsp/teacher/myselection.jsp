<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>开课信息</title>
		<meta charset="utf-8">
		<meta name=”viewport” content=”width=device-width, initial-scale=1″ /><!--自适应屏幕大小-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/admin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/All.js" defer="true"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
		<div class="display_select">
			<div class="display_select_bottom" style="width: 100%;margin-left: 0;"></div>
			<div class="display_select_container" style="margin-left: 100px;width:100%;">
			<s:if test="%{#session.pb.pageData.size()==0}"><span style="color:red;">暂无课程</span></s:if>
			<s:else>
			<table cellpadding="10px" cellspacing="2px" border="1px solid" style="text-align: center;">
				<tr>
					<td>
						课程编号
					</td>
					<td>
						课程名称
					</td>
					<td>
						授课教师
					</td>
					<td>学分</td>
					<td>
						已选该课的学生数量
					</td>
					<td>
						可容纳学生的数量
					</td>
					<td>
						操作
					</td>
				</tr>
					<s:iterator value="%{#session.pb.pageData}" var="m">
				<tr>
					<td>
						<s:property value="%{#m.course_id}"/>
						<input type="hidden" value="${m.course_id }" name="course_id">
					</td>
					<td>
						<s:property value="%{#m.course_name}"/>
					</td>
					<td>
						<s:property value="%{#m.tea.tea_name}"/>
					</td>
					<td>
						<s:property value="%{#m.credit}"/>
					</td>
					<td>
						<s:property value="%{#m.selection_taken}"/>
					</td>
					<td>
						<s:property value="%{#m.capacity}"/>
					</td>
					<td>
						<a href="${pageContext.request.contextPath }/tea_viewTheStu?course_id=${m.course_id}" >查看选课学生信息</a>
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

