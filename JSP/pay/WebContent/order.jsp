<%@page import="service.impl.OrderServiceImpl"%>
<%@page import="service.OrderService"%>
<%@page import="entity.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	//List<Order> list = (List<Order>)session.getAttribute("list");//用EL表达式可直接从session里获取数据
	String condition = (String)session.getAttribute("condition");
	String value = (String)session.getAttribute("value");
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
			$("[id^='del_']").click(function(){
				//var order_id = $(this).attr("order_id");
				var order_id = this.id.split("_")[1];
				$.ajax({
					url:"deleteOrder.do",
					type:"post",
					data:"order_id="+order_id,
					dataType:"text",
					success:function(data){
						alert();
						console.log(data);
						if(data=="删除成功"){
							alert(111);
							//$("#search_form").submit();
							window.location.reload(true);
						}else{
							alert("删除失败");
						}
					}
				});
			});
			selected();//获取搜索订单里选中内容的状态，否则提交表单后会重新刷新页面。
			function selected(){
				var condition = "<%=condition%>";
				if(condition!= "null"){<%-- 假如condition(java)为null,那么var condition = "<%=condition%>"，则condition(js)则是"null". --%>
					$("[name = 'condition']").val(condition);
				}
			}
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
		<input type="text" class="form-control" name="value" placeholder="搜索内容" value="${sessionScope.value }">
		<button type="button" class="btn btn-primary" id = "search_btn">搜索</button>
		<span>&nbsp;&nbsp;共有 <b>${list==null?0:list.size()}</b> 条订单</span>
	</form>
	<table class="table table-striped table-hover zf-table">
	<thead>
		<tr>
			<th>订单编号</th>
			<th>商品编号</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>删除订单</th>
		</tr>
	</thead>
	<!-- 提交个表单偷点懒  -->
		<tbody>
			<c:forEach var="order" items="${list }">
			<tr>
				<td>${pageScope.order.order_id }</td><!-- 不加域对象名称的话就会从全域里查找 -->
				<td>${product_id }</td>
				<td>${order.product_name }</td>
				<td>${order.product_price }</td>
				<td><input id="del_${order.order_id }" type="button" value="删除" order_id="${pageScope.order.order_id }" class="btn btn-danger btn btn-default btn-xs"/></td>
			</tr>
			</c:forEach>
		</tbody>
		
		<%-- <tbody>
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
		</tbody> --%>
</table>
</div>	
</body>
</html>