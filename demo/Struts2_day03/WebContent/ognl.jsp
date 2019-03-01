<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ognl Struts2环境入门</title>
</head>
<body>
	<h1>访问对象的方法</h1>
	<s:property value="'struts2'.length()"/>
	<h1>访问对象的静态方法</h1>
	<s:property value="@java.lang.Math@random()"/>
</body>
</html>