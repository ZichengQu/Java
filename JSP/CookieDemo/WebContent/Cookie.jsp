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
		Cookie[] cookies = request.getCookies();//获取Cookie
		if(cookies!=null&&cookies.length>0){
			for(Cookie cookie: cookies){
				out.print(cookie.getName()+": "+cookie.getValue()+"<br>");//获取Cookie的name和value
			}
		}else{
			out.print("没有Cookie,正在创建，并返回给浏览器");
			Cookie cookie = new Cookie("name","Tom");//创建一个Cookie对象
			cookie.setMaxAge(30);//设置Cookie的最大时效，以秒为单位
			response.addCookie(cookie);//调用response的方法把cookie传给客户端
		}
	%>
</body>
</html>