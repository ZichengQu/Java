<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Student> list = (List)request.getAttribute("list");
	Integer pageIndex=(Integer)request.getAttribute("pageIndex");
	Integer totalPages=(Integer)request.getAttribute("totalPages");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="selStuByPage.do">
			<table border="1">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>爱好</th>
					<th>学校</th>
					<th>添加日期</th>
					<th>操作</th>
				</tr>
				<%for(Student stu:list){%>
					<tr>
						<td><%=stu.getId() %></td>
						<td><%=stu.getName() %></td>
						<td><%=stu.getHobby() %></td>
						<td><%=stu.getSchool() %></td>
						<td><%=stu.getInsertDate() %></td>
					</tr>
				<%} %>
			</table>
			<%if(pageIndex>1){ %>
			<a href="selStuByPage.do?pageIndex=1">首页</a>
			<a href="selStuByPage.do?pageIndex=${pageIndex-1 }">上一页</a>
			<%}%>
			<%if(pageIndex<totalPages){ %>
			<a href="selStuByPage.do?pageIndex=${pageIndex+1 }">下一页</a>
			<a href="selStuByPage.do?pageIndex=${totalPages }">尾页</a>
			<%} %>
		</form>
	</center>
</body>
</html>