<%@page import="com.entity.Student"%>
<%@page import="com.service.StudentService"%>
<%@page import="com.service.impl.StudentServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int id =Integer.parseInt(request.getParameter("id"));
	StudentService stuService = new StudentServiceImpl();
	Student stu = stuService.selStuById(id);
	pageContext.setAttribute("stu", stu);//想用el，必须是域对象
	String[] hobbys = stu.getHobby().split(", ");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		<%for(int i=0;i<hobbys.length;i++){%>
			$("[value='<%=hobbys[i]%>']").prop("checked",true);
		<%}%>
	});
</script>
</head>
<body>
	<form action="" method="post" id="form1">
		<table border="1" align="center">
			<input type="hidden" name="id" value="${stu.id }"/>
			<tr>
				<td>姓名：</td>
				<td><input name="name" id="name" value="${stu.name }"/></td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
					<input name="hobby" type="checkbox" value="打游戏">打游戏
					<input name="hobby" type="checkbox" value="游泳">游泳
				    <input name="hobby" type="checkbox" value="看电影">看电影
					<input name="hobby" type="checkbox" value="旅游">旅游
					<input name="hobby" type="checkbox" value="篮球">篮球
				
			    </td>
			</tr>
			<tr>
				<td>学校：</td>
				<td><input name="school" id="school" value="${stu.school }"/></td>
			</tr>
			<tr>
				<td>添加日期：</td>
				<td><input name="insertDate" id="insertDate" value="${stu.insertDate }"/></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="修改"/>&nbsp;
				    <input type="button" value="返回" onclick="history.back();"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>