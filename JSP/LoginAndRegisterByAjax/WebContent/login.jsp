<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>登录</title>
</head>
<body onload="change()">
	<form action="login" method="post" id="form01">
		<table>
			<tr>
				<td>用户名：</td><td><input name="username" id="username" placeholder="用户名3-5个字符之间" value="${requestScope.username }"/></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input name="password" id="password" type="password" placeholder="密码6-10个字符之间"/></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="登录"/>
					<input type="button" value="注册" onclick="location.href='register.jsp'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>