<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>上传成功！</h1>
	<!-- 在Struts2执行一次请求的过程中，Struts2会把当前的Action对象自动放入值栈 -->
	<img src="${pageContext.request.contextPath }/upload/<s:property value="fileFileName"/>">
</body>
</html>