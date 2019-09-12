<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>传统文件上传</h3>
	<form action="fileUpload/fileupload1" method="post" enctype="multipart/form-data">
		选择文件：
			<input type="file" name="upload"/><br/> 
			<input type="submit" value="上传"/>
	</form>

	<h3>Springmvc文件上传</h3>
	<form action="fileUpload/fileupload2" method="post" enctype="multipart/form-data">
		选择文件：
			<input type="file" name="upload"/><br/> 
			<input type="submit" value="上传"/>
	</form>

	<h3>跨服务器文件上传</h3>
	<form action="fileUpload/fileupload3" method="post" enctype="multipart/form-data">
		选择文件：
			<input type="file" name="upload"/><br/> 
			<input type="submit" value="上传"/>
	</form>
</body>
</html>