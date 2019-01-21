<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//向服务器发送页面级的数据
	pageContext.setAttribute("page","pageScopeValue");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>pageScope</h2>
	<%=pageContext.getAttribute("page") %>
	<h2><a href="request.jsp">request</a></h2>
	<h2><a href="session.jsp">session</a></h2>
	<h2><a href="application.jsp">application</a></h2>
</body>
</html>