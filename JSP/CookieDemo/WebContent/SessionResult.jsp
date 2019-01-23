<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户名: ${username }</h1>
	<%
		Cookie cookie = new Cookie("JSESSIONID",session.getId());//手动创建一个存储JSESSIONID的Cookie
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
	%>
	ID: <%=session.getId() %>
</body>
</html>