<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>学生信息</title>
		<meta charset="utf-8">
		<meta name=”viewport” content=”width=device-width, initial-scale=1″ /><!--自适应屏幕大小-->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/css/admin.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/All.js" defer="true"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/jquery-3.3.1.min.js"></script>
	</head>
	<body>
		
		
		<div class="display_all">
			<div class="display_table_bottom" style="width: 100%;margin-left: 0;"></div>
			<div class="display_container" style="margin-left: 100px;width:100%;">
			<s:if test="%{#session.pb.pageData.size()==0}"><span style="color:red;">暂无学生选择该课程</span></s:if>
			<s:else>
			<table cellpadding="10px" cellspacing="2px" border="1px solid" style="text-align: center;">
				<tr>
					<td>
						学号
					</td>
					<td>
						姓名
					</td>
					<td>
						性别
					</td>
					<td>
						出生日期
					</td>
				</tr>
				<s:iterator value="%{#session.pb.pageData}" var="m">
				<tr>
					<td>
						<s:property value="%{#m.stu_id}"/>
					</td>
					<td>
						<s:property value="%{#m.stu_name}"/>
					</td>
					<td>
						<s:if test="%{#m.stu_gender==0}">女</s:if>
						<s:else>男</s:else>
					</td>
					<td>
						<s:property value="%{#m.stu_birth}"/>
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
						</td>	
						<td>
							总记录：<s:property value="%{#session.pb.totalRecord}"/>条
						</td>
						<td>
							总页数：<s:property value="%{#session.pb.totalPage}"/>页
						</td>
						<s:if test="%{#session.pb.pageData.size()>0}">
						
					
						
						<s:if test="%{#session.pb.currentPage>1}">
						<td>
							<button onclick="javascript:window.location.href='${pageContext.request.contextPath}'+'${pb.path}&num=${pb.currentPage-1} '">上一页</button>
						</td>
						</s:if>
						<s:if test="%{#session.pb.currentPage!=#session.pb.totalPage}">
						<td>
							<button onclick="javascript:window.location.href='${pageContext.request.contextPath}'+'${ pb.path}&num=${ pb.currentPage+1}'">下一页</button>
						</td>
						</s:if>
						</s:if>
					</tr>
				</table>
			</div>
		</div>

	</body>









</html>
