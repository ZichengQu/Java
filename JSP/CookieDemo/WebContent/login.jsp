<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = null;
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		if("username".equals(cookie.getName())){
			id = cookie.getValue();
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		var id = <%=id%>;
		<%System.out.println(id);%>
		//$("#username").val(id);//读取cookie并将其赋值到表单中。若是不注释掉此句话，则main.jsp的else分支无法执行其效果。
	});
</script>
</head>
<body>
	<form action="main.jsp" method="post">
		用户名: <input id="username" name="username">
		<input type="submit">
	</form>
</body>
</html>