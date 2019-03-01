<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用debug标签查看值栈结构 -->
	<s:debug></s:debug>
	<!-- 获取字符串的值 -->
	<s:property value="username"/>
	<!-- 获取对象的值 -->
	<s:property value="user.username"/>
	<s:property value="user.password"/>
	<!-- 获取list集合: 第一种方式 -->
	<s:property value="list[0].username"/>
	<s:property value="list[0].password"/>
	<br>
	<s:property value="list[1].username"/>
	<s:property value="list[1].password"/>
	<br>
	<!-- 获取list集合: 第二种方式 -->
	<s:iterator value="list">
		<!-- 遍历list得到list里面每个user对象 -->
		<s:property value="username"/>
		<s:property value="password"/>
		<br>
	</s:iterator>
	<!-- 获取list集合: 第三种方式 -->
	<s:iterator var="user" value="list">
		<!-- 遍历list得到list里面每个user对象
			机制：把每次遍历出来的user对象不是放到Root，而是放到Context里面了(为了取数据速度较快，因为Context是map类型，通过key得到value速度较快)
			#：写ognl表达式，用来获取Context里面数据
		 -->
		<s:property value="#user.username"/>
		<s:property value="#user.password"/>
		<br>
	</s:iterator>
	<!-- 其他操作: 获取使用set方法向值栈中存储的数据 -->
	<s:property value="username"/>
	<br>
	<!-- 其他操作: 获取使用push方法向值栈中存储的数据 -->
	<s:property value="[0].top"/><br>
	<s:property value="[1].top"/><br>
	<s:property value="[2].top"/><br>
	<!-- 使用forEach标签+el表达式获取值栈中list集合中的数据 -->
	<c:forEach var="user" items="${list }">
		${user.username }
		${user.password }
	</c:forEach>
	<!-- 10.获取Context里面的数据 -->
	<s:property value="#request.name"/>
	<!-- 使用%,在s标签里可以使用OGNL，input等标签里不能使用OGNL，只能使用EL表达式 -->
	<input name="username" value="${requestScope.name}">
	<s:textfield name="username" value="%{#request.name}" ></s:textfield>
	
	
	
	
	
	
	
	
</body>
</html>