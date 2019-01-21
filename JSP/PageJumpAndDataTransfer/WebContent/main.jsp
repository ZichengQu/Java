<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println(request);//隐式对象request在直接调用此页面的时候(不经过表单提交等操作)，也不会为null。
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	if("admin".equals(username)&&"123456".equals(password)){
		//服务器的隐式请求对象(request)设置属性的方法，参数:(字符串,Object)
		//request.setAttribute("username",username);
		request.getSession().setAttribute("username",username);
		//session.setAttribute("username",username);
		//页面跳转，同时将数据传递到指定页面
		//request.getRequestDispatcher("success.jsp").forward(request,response);//转发
		response.sendRedirect("success.jsp");//重定向
	}else{
		response.sendRedirect("error.jsp");//重定向
	}
	System.out.println(username+"\n"+password);
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