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
		
		<div class="search">
			<div class="update_container">
			<table cellpadding="10px" cellspacing="2px">
				<tr>
					<td>
						<input type="text" id="course_id" name="course_id" style="border-radius: 20px;text-indent: 20px;height: 25px;">
					</td>
					<td>
						<button  type="button" onclick="javascript:checkSelectionId();">按课程编号查询</button>
					</td>
					<td>
						<input type="text" id="course_name" name="course_name" style="border-radius: 20px;text-indent: 20px;height: 25px;">
					</td>
					<td>
						<button type="button"  onclick="javascript:checkSelectionName(); ">按课程名称查询</button>
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
						课程编号
					</td>
					<td>
						课程名称
					</td>
					<td>
						授课教师
					</td>
					
					<td>
						可容纳学生的数量
					</td>
					<td>
						学分
					</td>
					<td colspan="2">
						操作
					</td>
				</tr>
				<tr>
					<s:iterator value="%{#session.pb.pageData}" var="s" >
				<form action="${pageContext.request.contextPath }/adminSelection_addSelection" method="post" onsubmit="return checkCapacity(${s.course_id});"  >
				<tr>
					<td>
						<s:property value="%{#s.course_id}"/>
						<input type="hidden" name="course_id" value="${s.course_id}">
					</td>
					<td>
						<s:property value="%{#s.course_name}"/>
						<input type="hidden" name="course_name" value="${s.course_name}">
					</td>
					
					<td>
						<s:property value="%{#s.tea.tea_name}"/>
						<input type="hidden" name="tea.tea_id" value="${t.tea_id}">
							
					</td>
					
					<td>
						<input type="text" id="capacity${s. course_id}" name="capacity" style="border-radius: 10px;text-indent: 10px;height: 25px;">
					</td>
					<td>
						<s:property value="%{#s.credit}"/>
						<input type="hidden" name="credit" value="${s.credit}">
						
					</td>
					<td>
					
						<button type="submit" ${s.is_selection==1?'disabled':'' }>添加为选课内容</button>
					</td>
					<td>
						<button type="button"  onclick="deleteSelection(${s.course_id})" ${s.is_selection==0?'disabled':'' }>删除</button>
					</td>
					
				</tr>
				</form>
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
							<button type="button" onclick="javascript:window.location.href='${pageContext.request.contextPath}'+'${pb.path}?num=${pb.currentPage-1} '">上一页</button>
						</td>
						</s:if>
						<s:if test="%{#session.pb.currentPage<#session.pb.totalPage}">
						<td>
							<button type="button" onclick="javascript:window.location.href='${pageContext.request.contextPath}'+'${ pb.path}?num=${ pb.currentPage+1}'">下一页</button>
						</td>
						</s:if>
						</s:if>
					</tr>
				</table>
			</div>
		</div>

	</body>









</html>
