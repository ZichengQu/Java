<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
$(function(){
	var pageIndex = ${sessionScope.pageBean.pageIndex};
	var totalPages = ${sessionScope.pageBean.totalPages};
	$("#first,#prev").click( function () { //用c标签的if语句了，这里可以不写。
		if(pageIndex<=1){
			alert("已经是首页");
			return false;
		}
	});
	$("#next,#last").click( function () { //用c标签的if语句了，这里可以不写。
		if(pageIndex>=totalPages){
			alert("已经是尾页");
			return false;
		}
	});
	$("#page_select").change(function(){
		var pageIndex =$(this).val();
		window.location.href = "showEmpByPage.do?pageIndex="+pageIndex;
	});
});
</script>
</head>
<body>
	<form action="showEmpByPage.do" align="center">
		<table border="1" align="center">
			<tr>
				<th>员工编号</th>
				<th>员工姓名</th>
				<th>员工职位</th>
				<th>员工的经理编号</th>
				<th>员工入职时间</th>
				<th>员工工资</th>
				<th>员工奖金</th>
				<th>员工部门编号</th>
			</tr>
			<c:forEach var="emp" items="${sessionScope.list }">
				<tr>
					<td>${pageScope.emp.empno }</td>
					<td>${pageScope.emp.ename }</td>
					<td>${pageScope.emp.job }</td>
					<td>${pageScope.emp.mgr }</td>
					<td>${pageScope.emp.hiredate }</td>
					<td>${pageScope.emp.sal }</td>
					<td>${pageScope.emp.comm }</td>
					<td>${pageScope.emp.deptno }</td>
					<%-- <td><input type="button" value="修改" onclick="location.href='updStudent.jsp?id=${pageScope.emp.empno}'"/></td> --%>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${sessionScope.pageBean.pageIndex gt 1 }">
			<a id="first" href="showEmpByPage.do?pageIndex=1">首页</a> 
			<a id="prev" href="showEmpByPage.do?pageIndex=${sessionScope.pageBean.prev }">上一页</a>
		</c:if>
		<select id="page_select">
			<option value="${sessionScope.pageBean.pageIndex }" >当前页为: ${sessionScope.pageBean.pageIndex }</option>
			<c:forEach var="i" begin="1" end="${sessionScope.pageBean.totalPages }" step="1" >
				<option value=${pageScope.i } >跳转到第${pageScope.i }页</option>
			</c:forEach>
		</select>
		<c:if test="${sessionScope.pageBean.pageIndex lt sessionScope.pageBean.totalPages }">
			<a id="next" href="showEmpByPage.do?pageIndex=${sessionScope.pageBean.next }">下一页</a>
			<a id="last" href="showEmpByPage.do?pageIndex=${sessionScope.pageBean.totalPages }">尾页</a>
		</c:if>
	</form>
</body>
</html>