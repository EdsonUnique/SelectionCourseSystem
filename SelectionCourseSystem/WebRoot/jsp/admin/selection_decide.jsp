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
			  elem: '#t1' //指定元素
			  ,type: 'datetime'
  			 
              ,format: 'yyyy-MM-dd HH:mm:ss'
			});
			laydate.render({
			  elem: '#t2' //指定元素
			  ,type: 'datetime'
  			 
              ,format: 'yyyy-MM-dd HH:mm:ss'
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
		<div class="select_container" style="margin-left: 0px;" >
			<div class="select_bottom" style="width: 100%;"></div>
			<div class="select_table_container" style="margin-left: 300px;">
			<form action="${pageContext.request.contextPath }/adminSelection_startCheck" method="post" onsubmit="javascript:return checkStartTime();")>
			<table cellpadding="10px" cellspacing="2px"  style="text-align: center;">
				<tr>
					<td>
						选课开始时间:
					</td>
					<td>
						<input id="t1" type="text" name="startTime" ${is_start==1?'disabled':'' } value="${startDate }"  style="border-radius: 10px;text-indent: 10px;height: 25px;">
					</td>
				
					<td>
						选课结束时间:
					</td>
					<td>
						<input id="t2" type="text" name="endTime" ${is_start==1?'disabled':'' } value="${endDate }" style="border-radius: 10px;text-indent: 10px;height: 25px;">
					</td>
				</tr>
				
			</table>
			<br>
			可选课程：
			<s:if test="%{#session.pb.pageData.size()==0}"><span style="color:red;">数据库暂无可选课程，请添加！</span></s:if>
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
					<td>
						可容纳学生的数量
					</td>
				</tr>
				<s:iterator value="%{#session.pb.pageData}" var="m">
				<tr>
					<td>
						<s:property value="%{#m.course_id}"/>
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
						<s:property value="%{#m.capacity}"/>
					</td>
				</tr>
				</s:iterator>
			</table>
			</s:else>
			</div>
		</div>
		<div class="pagenum" style="margin-top: 425px;">
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
							
							<button type="button" onclick="javascript:gotoPagenum('${pb.path}','${pb.totalPage }');">跳转</button>
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
						<td>
							<button type="submit" ${pb.pageData.size()==0?'disabled':'' } ${is_start==1?'disabled':'' }>开始选课</button>
						</td>
						<td>
							<button type="button"  ${is_start!=1?'disabled':'' } onclick="javascript:endSelection();">结束选课</button>
						</td>
						
					</tr>
				</table>
				</form>
			</div>
		</div>


	</body>
</html>