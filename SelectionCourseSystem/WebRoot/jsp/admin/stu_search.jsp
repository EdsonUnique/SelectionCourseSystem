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
						<input id="stu_id" type="text" name="stu_id" style="border-radius: 20px;text-indent: 20px;height: 25px;">
					</td>
					<td>
						<button onclick="javascript: checkStuId();">按学号查询</button>
					</td>
					<td>
						<input id="stu_name" type="text" name="stu_name" style="border-radius: 20px;text-indent: 20px;height: 25px;">
					</td>
					<td>
						<button onclick="javascript: checkStuName();">按姓名查询</button>
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
						学号
					</td>
					
					<td>
						姓名
					</td>
					<td>
						性别
					</td>
					<td>
						登录密码
					</td>
					<td>
						出生年月
					</td>
					<td colspan="2">
						操作
					</td>
				</tr>
				<s:iterator value="%{#session.pb.pageData}" var="stu">
				<tr>
					<td>
						<s:property value="%{#stu.stu_id}"/>
					</td>
					<td>
						<s:property value="%{#stu.stu_name}"/>
					</td>
					<td>
						<s:if test="%{#stu.stu_gender==0}">女</s:if>
						<s:else>男</s:else>
					</td>
					<td>
						<s:property value="%{#stu.stu_pwd}"/>
					</td>
					<td>
						<s:property value="%{#stu.stu_birth}"/>
					</td>
					<td>
						<button onclick="javascript:window.location.href='${pageContext.request.contextPath}/admin_updateStudentUI?stu_id='+'${stu.stu_id}'">修改</button>
					</td>
					<td>
						<button onclick="javascript:deleteStu(${stu.stu_id});">删除</button>
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

