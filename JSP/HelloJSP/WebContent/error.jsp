<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>error page</h1>
	<%=exception.getMessage() %> <%--若404跳转到500的页面，并使用隐式的exception等，会出现空指针异常，因为没有500错误，exception为null。 --%>
</body>
</html>