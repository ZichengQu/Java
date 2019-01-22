<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward页面</h1>
	<%request.setCharacterEncoding("UTF-8"); %> <!-- 要在提交前设置转码，否则会先乱码，再在接收request的页面写转码，所得到的值还是乱码 -->
	<jsp:forward page="forwardResult.jsp">
		<jsp:param value="用户名的值" name="username"/>
	</jsp:forward>
</body>
</html>