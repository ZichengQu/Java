<%@page import="com.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("book", "<<java>>");
		User user = new User();
		request.setAttribute("user", user);
		session.setAttribute("book", "book_value");
	%>
	<%-- c:out标签: 用来显示数据的内容，就像<%=表达式%>一样 --%>
	name_1: <c:out value="value_1"></c:out>	<br/>
	<!-- c:out标签: 可以对特殊字符进行转换 -->
	book: ${requestScope.book }	<br/>	 <!-- 	<>	 -->
	book: <c:out value="${requestScope.book }" default="python"></c:out>	<br/>	 <!-- <<java>> -->	<%-- 当${requestScope.book }不存在的时候显示python --%>
	<!-- 这是一行华丽的分割线............................................. -->
	<!-- c:set标签: 用来将变量存储至jsp对象中 -->
	<c:set var="name_2" value="value_2" scope="request"></c:set>
	name_2: ${requestScope.name_2 }	<br/>
	<!-- c:set标签: 用来将变量存储至JavaBean的属性中 -->
	<c:set target="${requestScope.user }" property="name" value="${requestScope.name_2 }"></c:set>
	userName: ${requestScope.user.name }	<br/>
	<!-- 这是一行华丽的分割线............................................. -->
	<!-- c:remove标签: 移除指定域对象中的指定属性值 -->
	book: ${sessionScope.book } <br/>
	<c:remove var="book" scope="session"></c:remove>
	book: ${sessionScope.book } <br/>
	<!-- c:if -->
	<!-- http://localhost:8080/ServletByAnnotation/?age=20 -->
	<c:if test="${param.age>18 }" var="flag" scope="request">成年</c:if>
	request: ${requestScope.flag }
</body>
</html>