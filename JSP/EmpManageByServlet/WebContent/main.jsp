<%@page import="com.bean.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.service.impl.EmpServiceImpl"%>
<%@page import="com.service.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmpService empService = new EmpServiceImpl();
	String msg = (String)session.getAttribute("msg");
	if(msg!=null){
		out.print("<script>alert('"+msg+"');</script>");
		msg = null;//若是不设置为null，刷新页面还会alert。
	}
	List<Emp> list = empService.selAllEmp();
	String condition = request.getParameter("condition");//获取查询类型
	String value = request.getParameter("value");//获取输入的查询内容
	if(value!=null){
		list = empService.selEmpByCondition(condition,value.toUpperCase());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.box{
		width: 50%;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div class="box">
		<form action="" method="post">
			<p> 
				<select name="condition">
					<option value="ename">员工姓名</option>
					<option value="job">职位</option>
				</select>
				<input name="value" type="search" placeholder="请输入查询内容" value="<%=value==null?"":value%>"/>
				<input type="submit" value="查询"/>
				<a href="addEmp.jsp">添加</a>
			</p>
		</form>
		<table border="1px">
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工职位</th>
				<th>员工的经理编号</th>
				<th>员工入职时间</th>
				<th>员工工资</th>
				<th>员工奖金</th>
				<th>员工部门编号</th>
				<th>操作</th>
			</tr>
		<%
			if(!list.isEmpty()){
				for(Emp emp:list){
		%>
			<tr>
				<td><%=emp.getEmpno() %></td>
				<td><%=emp.getEname() %></td>
				<td><%=emp.getJob() %></td>
				<td><%=emp.getMgr() %></td>
				<td><%=emp.getHiredate() %></td>
				<td><%=emp.getSal() %></td>
				<td><%=emp.getComm() %></td>
				<td><%=emp.getDeptno() %></td>
				<td><a href="delEmp.do?empno=<%=emp.getEmpno() %>" onclick="return confirm('是否确认删除');">删除</a></td>
			</tr>
		<%		}
			} %>
		</table>
		</div>
</body>
</html>