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
		<span style="color:red;"><s:actionerror/></span>
	</s:if> 
	<s:else>
		<span style="color:red;">请勿错误操作！</span>
	</s:else>
		
		<button onclick="javascript:history.back()">返回</button>
	</body>
	
</html>	