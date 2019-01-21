<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//向服务器发送会话级的数据
	session.setAttribute("session","sessionScopeValue");
	response.sendRedirect("sessionResult.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>requestScope</h2>
	<%=pageContext.getAttribute("page") %> <!-- null -->
</body>
</html>