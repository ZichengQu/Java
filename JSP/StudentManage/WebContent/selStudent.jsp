<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="msg.jsp"></jsp:include>
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
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		var pageIndex = ${pageIndex};
		var totalPages = ${totalPages};
		$("#first,#prev").click( function () { 
			if(pageIndex<=1){
				alert("已经是首页");
				return false;
			}
		});
		$("#next,#last").click( function () { 
			if(pageIndex>=totalPages){
				alert("已经是尾页");
				return false;
			}
		});
	});
</script>
</head>
<body>
	<center>
		<a href="insertStudent.jsp">添加</a>
		<form action="selStuByPage.do">
			<table border="1">
				<tr>
					<th>编号</th>
					<th>姓名</th>
					<th>爱好</th>
					<th>学校</th>
					<th>添加日期</th>
					<th>修改</th>
				</tr>
				<%for(Student stu:list){%>
					<tr>
						<td><%=stu.getId() %></td>
						<td><%=stu.getName() %></td>
						<td><%=stu.getHobby() %></td>
						<td><%=stu.getSchool() %></td>
						<td><%=stu.getInsertDate() %></td>
						<td><input type="button" value="修改" onclick="location.href='updStudent.jsp?id=<%=stu.getId()%>'"/></td>
					</tr>
				<%} %>
			</table>
			<a id="first" href="selStuByPage.do?pageIndex=1">首页</a> 
			<a id="prev" href="selStuByPage.do?pageIndex=${pageIndex-1 }">上一页</a>
			<a id="next" href="selStuByPage.do?pageIndex=${pageIndex+1 }">下一页</a>
			<a id="last" href="selStuByPage.do?pageIndex=${totalPages }">尾页</a>
		</form>
	</center>
</body>
</html>