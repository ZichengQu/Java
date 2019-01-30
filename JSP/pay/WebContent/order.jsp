<%@page import="entity.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	List<Order> list = (List<Order>)session.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/myStyle.css" />
	<script type="text/javascript" src="js/jquery-1.11.3.min.js" ></script>
	<script type="text/javascript" src="js/bootstrap.min.js" ></script>
	<script type="text/javascript" src="js/pay.js" charset="utf-8"></script>
	<title></title>
	<script type="text/javascript">
		$(function(){
			$("#search_btn").click(function(){
				$("#search_form").submit();
			});
		});
	</script>
</head>
<body>
<!--//订单列表-->
<div class="container zf-lists">
	<form action="QueryServlet.do" class="form-inline" id = "search_form">
		搜索订单：
		<select class="form-control" name = "condition">
			<option value="order_id">订单号</option>
			<option value="product_name">商品名称</option>
		</select>	
		<input type="text" class="form-control" name="value" placeholder="搜索内容">
		<button type="button" class="btn btn-primary" id = "search_btn">搜索</button>
		<span>&nbsp;&nbsp;共有 <b>3154</b> 条订单</span>
	</form>
	<table class="table table-striped table-hover zf-table">
	<thead>
		<tr>
			<th>订单编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
		</tr>
	</thead>
	<!-- 提交个表单偷点懒  -->
		<tbody>
			<%
			if(list!=null&&!list.isEmpty()){
				for(Order order:list){
			%>
			<tr>
				<td><%=order.getOrder_id()%></td>
				<td><%=order.getProduct_id()%></td>
				<td><%=order.getProduct_name()%></td>
				<td><%=order.getProduct_price()%></td>
			</tr>
			<%	}
			} %>
		</tbody>
</table>
</div>	
</body>
</html>