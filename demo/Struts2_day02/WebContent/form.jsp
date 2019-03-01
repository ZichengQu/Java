<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <form action="data.action" method="post">
		<table>
			<tr>
				<td>用户名: </td>
				<td><input name="user.username"></td> 1.3.在表单输入项的name属性值里面写表达式
			</tr>
			<tr>
				<td>密码: </td>
				<td><input type="password" name="user.password"></td>
			</tr>
			<tr>
				<td>地址: </td>
				<td><input name="user.address"></td>
			</tr>
			<tr>
				<td>书名: </td>
				<td><input name="book.book_name"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form> -->
	<!-- 封装数据到list -->
	<!-- <form action="list.action" method="post"> 
		<table>
			<tr>
				<td>用户名: </td>
				<td><input name="list[0].username"></td>
			</tr>
			<tr>
				<td>密码: </td>
				<td><input type="password" name="list[0].password"></td>
			</tr>
			<tr>
				<td>地址: </td>
				<td><input name="list[0].address"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>用户名: </td>
				<td><input name="list[1].username"></td>
			</tr>
			<tr>
				<td>密码: </td>
				<td><input type="password" name="list[1].password"></td>
			</tr>
			<tr>
				<td>地址: </td>
				<td><input name="list[1].address"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form> -->
	<!-- 封装数据到map -->
	<form action="map.action" method="post"> 
		<table>
			<tr>
				<td>用户名: </td>
				<td><input name="map['one'].username"></td>
			</tr>
			<tr>
				<td>密码: </td>
				<td><input type="password" name="map['one'].password"></td>
			</tr>
			<tr>
				<td>地址: </td>
				<td><input name="map['one'].address"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td>用户名: </td>
				<td><input name="map['two'].username"></td>
			</tr>
			<tr>
				<td>密码: </td>
				<td><input type="password" name="map['two'].password"></td>
			</tr>
			<tr>
				<td>地址: </td>
				<td><input name="map['two'].address"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>