<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//向服务器发送应用程序级的数据
	application.setAttribute("application","applicationScopeValue");
	response.sendRedirect("applicationResult.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>applicationScope</h2>
	<%=application.getAttribute("application") %> <!-- applicationScopeValue  -->
</body>
</html>