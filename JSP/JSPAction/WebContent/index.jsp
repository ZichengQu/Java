<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="stu" class="com.entity.Student"></jsp:useBean>	<%-- 相当于Student stu = new Student(); --%>
	<%=stu.getName() %>
	<jsp:setProperty property="name" name="stu" value="renameJack"/>	<%-- 相当于stu.setName("str"); --%>
	<jsp:getProperty property="name" name="stu"/>	<%-- 相当于stu.getName(); --%>
	<%int num = 1; %> <!-- 用来测试静态包含和动态包含的区别 -->
	<%-- <%@include file="foot.jsp" %> --%>	<!-- 静态包含 -->
	<jsp:include page="foot.jsp"></jsp:include> <!-- 动态包含 -->
	<a href="forward.jsp">直接跳转到指定的页面，通过JSP动作完成</a>
</body>
</html>