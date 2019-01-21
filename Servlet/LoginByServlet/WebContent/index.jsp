<%@page import="com.service.impl.UserServiceImpl"%>
<%@page import="com.service.UserService"%>
<%@page import="com.bean.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	UserService userService = new UserServiceImpl();
	List<User> list = userService.queryAll();
	out.print("<table>");
	out.print("<tr><th>编号</th><th>用户名</th><th>密码</th><tr>");
	for(User user: list) {
		out.print("<tr><td>"+user.getId()+"</td><td>"+user.getUsername()+"</td><td>"+user.getPassword()+"</td><tr>");
	}
	out.print("</table>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
</html>