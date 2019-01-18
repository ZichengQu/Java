<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/includeDemo.jsp" %>
	<!-- HTML注释 -->
	<%--jsp注释 --%>
	<%
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
		System.out.println(sdf.format(date));
		int i = 1;//单行注释
		/*多行注释*/
		//int a = 1/0;//会跳转到errorPage="/error.jsp"
		System.out.println(i);
	%>
	<%!String name="Jack"; %>
	<%!public void add(){
		System.out.println(name);//在声明里写输出语句不起作用。
	}%>
	<%=name %>
	<%=i+1 %>
	<%=1>2 %>
	
</body>
</html>