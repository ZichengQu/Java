<%@page import="com.bean.Dept"%>
<%@page import="com.service.impl.DeptServiceImpl"%>
<%@page import="com.service.DeptService"%>
<%@page import="com.bean.Emp"%>
<%@page import="java.util.List"%>
<%@page import="com.service.impl.EmpServiceImpl"%>
<%@page import="com.service.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	EmpService empService = new EmpServiceImpl();
	List<Emp> empList = empService.selAllEmp();
	DeptService deptService = new DeptServiceImpl();
	List<Dept> deptList = deptService.selAllDept();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border: 1px solid blue;
	}
</style>
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		$("#deptno").change(function(){
			var deptno_option =$(this).val();
			$.ajax({
				url:"selMgrByDept.do",
				type:"post",
				data:"deptno"+deptno_option,
				dataType:"text",
				success:function(data){
					alert(data);
				}
			});
		});
		$("#form01").submit(function(){
			if(!flag){
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form action="addEmp.do" method="post">
		<table border="1px">
			<tr>
				<td>员工编号</td>
				<td><input name="empno"/></td>
			</tr>
			<tr>
				<td>员工姓名</td>
				<td><input name="ename"/></td>
			</tr>
			<tr>
				<td>员工职位</td>
				<td><input name="job"/></td>
			</tr>
			<tr>
				<td>员工的经理编号</td>
				<td>
					<select id="mgr" name="mgr">
						<option value="">--请选择--</option>
						<%if(!empList.isEmpty()){
							for(Emp emp:empList){
						%>
						<option value="<%=emp.getEmpno()%>"><%=emp.getEname() %></option>
						<%
							}
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td>员工入职时间</td>
				<td><input name="hiredate" id="hiredate"/></td>
			</tr>
			<tr>
				<td>员工工资</td>
				<td><input name="sal"/></td>
			</tr>
			<tr>
				<td>员工奖金</td>
				<td><input name="comm"/></td>
			</tr>
			<tr>
				<td>员工部门编号</td>
				<td>
					<select id="deptno" name="deptno">
						<option value="">--请选择--</option>
						<%if(!deptList.isEmpty()){
							for(Dept dept:deptList){
						%>
						<option value="<%=dept.getDeptno()%>"><%=dept.getDeptno() %></option>
						<%
							}
						}
						%>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="添加"/>
					<input type="button" value="取消" onclick="history.back()"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="js/laydate.js"></script>
	<script type="text/javascript">
		laydate.render({
		  elem: '#hiredate' //指定元素
		});
	</script>
</body>
</html>