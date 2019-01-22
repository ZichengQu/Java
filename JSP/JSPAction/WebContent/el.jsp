<%@page import="java.util.*"%>
<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("name", "name_value");//存储字符串
		
		Student stu1 = new Student("Tom");
		session.setAttribute("stu", stu1);
		
		List<Student> list = new ArrayList<Student>();//存储一个集合
		Student stu2 = new Student("Mary");
		Student stu3 = new Student("Jack");
		list.add(stu1);
		list.add(stu2);
		list.add(stu3);
		application.setAttribute("list", list);
	%>
	request: <%=request.getAttribute("name") %>
	<%Student stu =(Student)session.getAttribute("stu");  %>
	session: <%=stu.getName() %>
	<%list = (List)application.getAttribute("list"); %>
	application: <%=list.get(1).getName() %>
	<br>
	<!-- 使用el表达式获得域中的数据 -->
	${ requestScope.name} <!-- name_value -->
	${ sessionScope.stu.name} <!-- Tom -->	<%-- ${ sessionScope.stu["name"]} --%>  
	${ applicationScope.list[1].name} <!-- Mary --> <!-- name调用的是相应的getName()的方法，不是private的name;若getName0(),则应写list[1].name0 -->
	<br>
	<!-- 全域查找，四个作用域找一遍 -->
	${ name}
	${ stu.name}
	${ list[1].name}
	<br>
	<!-- el支持表达式运算 -->
	${1+1 }
	${1>1?true:false }
	<form>
		分数: <input name="score"/>
		<input type="submit"/>
	</form>
	<!-- el可以进行自动的类型 转换 -->
	score: ${param.score +1 }	<!-- 进行自动非空判断 --><%-- <%=request.getParameter("score")==null?"":request.getParameter("score") %> --%>
	score: <%=request.getParameter("score")+1 %>
</body>
</html>