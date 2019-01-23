<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		//如果能够获取到请求参数，然后把登陆信息存储到Cookie中，并设置Cookie的最大时效30s。
		String username_value = request.getParameter("username");
		if(username_value!=null&&!username_value.trim().equals("")){
			Cookie cookie = new Cookie("username",username_value);
			cookie.setMaxAge(30);
			cookie.setPath("/CookieDemo/main.jsp");//设置Cookie的携带路径 //访问CookieDemo应用中的main.jsp页面时，才加载该cookie;
			//cookie.setPath("/CookieDemo");//默认代表访问CookieDemo应用中的任何资源都携带该cookie;
			response.addCookie(cookie);
		}else{
			//第二次请求的时候从Cookie中读取用户信息，如果存在则打印出"欢迎登陆"。
			Cookie[] cookies = request.getCookies();
			if(cookies!=null&&cookies.length>0){
				for(Cookie cookie: cookies){
					if("username".equals(cookie.getName())){
						String value = cookie.getValue();
						username_value = value;
					}
				}
			}
		}
		if(username_value!=null&&!username_value.trim().equals("")){
			out.print("Hello: "+username_value);
		}else{//若没有请求参数也没有Cookie，则重定向到login页面重新登陆。
			response.sendRedirect("login.jsp");
		}
	%>
</body>
</html>