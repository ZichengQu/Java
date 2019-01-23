<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post" id="form1">
		<table border="1" align="center" bgcolor="yellow">
			
			<tr>
				<td>姓名：</td>
				<td><input name="name" id="name" value=""/></td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
				
					<input  name="hobby" type="checkbox" value="打游戏">打游戏
					<input name="hobby" type="checkbox" value="游泳">游泳
				    <input name="hobby" type="checkbox" value="看电影">看电影
					<input name="hobby" type="checkbox" value="旅游">旅游
					<input name="hobby" type="checkbox" value="篮球">篮球
				
			    </td>
			</tr>
			<tr>
				<td>学校：</td>
				<td><input name="school" id="school" value=""/></td>
			</tr>
			<tr>
				<td>添加日期：</td>
				<td><input name="insertDate" id="insertDate" readonly="readonly" value=""/></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="修改"/>&nbsp;
				    <input type="button" value="返回" onclick="location.href='selStudent.jsp'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>