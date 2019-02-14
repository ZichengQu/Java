<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
			/* $("#product_1").click(function(){
				$("[name='pname']:first").val($("#pname_1").val());
				$("[name='pcode']:first").val(new Date().getTime());//订单号用当前毫秒值
				$("[name='pprice']").val($("#pprice_1").val());
			});
			$("#product_2").click(function(){
				$("#product").val($("#pname_2").val());
				$("#order2").val($("#order1").val());
				$("#price").val($("#pprice_2").val());
			}); */
			$("[id^='product_']").click(function(){
				var id = this.id.split("_")[1];//获取其id
				var pname = $("[id='pname_"+id+"']").val()//商品名称,属性选择器
				var pcode = new Date().getTime();//订单号用当前毫秒值
				var pprice = $("#pprice_"+id+"").val();//id选择器
				var product = $(this).val();//商品编号，这里和“this.id.split("_")[1];//获取其id”的作用一样。
				
				$("[name='pname']:first").val(pname);
				$("[name='pcode']:first").val(pcode);
				$("[name='pprice']").val(pprice);
				$("[name='product']:first").val(product);
			});
			$("#pay_product_form_btn").click(function(){
				$.ajax({
					url:"existOrder.do",
					type:"post",
					data:"order_id="+$("[name='pcode']:first").val(),
					dataType:"text",
					async:false,//JS等ajax执行完毕后再继续执行后续函数,默认为true
					success:function(data){
						if(data=="true"){
							$("#pay_product_form").submit();
						}else{
							alert("当前订单已存在，请勿重复添加");
							location.href='index.jsp';
						}
					}
				});
			});
			$("#pay_product_form").submit(function(){
				if($("[name='pname']:first").val() == ""){
					alert("请选择商品名称");
					return false;
				}
				if($("[name='pcode']:first").val() == ""){
					alert("请选择订单编号");
					return false;
				}
				if($("[name='pprice']:first").val() == ""){
					alert("请选择价格");
					return false;
				}
			});
		});
	</script>
</head>

<body>
<!--//头部-->
	<div class="zf-header">
		<div class="container">
			<p class="zf-title">个人支付解决方案</p>
		</div>
	</div>
<!--//表单-->	
<div class="container zf-form">
	<form action="addOrder.do" id = "pay_product_form" method="post">
		<!-- 商品名称 -->
		<div class="input-group">
			<div class="input-group-addon">
				<span class="glyphicon glyphicon-barcode"></span>
			</div> 
			<input type="text" class="form-control" name = "pname" id="product" readonly="readonly"> 
			<!-- 商品编号 -->
			<input type = "hidden" name = "product" />
		</div>
		<!-- 订单码 -->
		<div class="input-group">
			<div class="input-group-addon">
				<span class="glyphicon glyphicon-barcode"></span>
			</div> 
			<input type="text" class="form-control" name = "pcode" readonly="readonly"> 
			<!-- token令牌 -->
			<input type = "hidden" name = "token" value = '<%=""+System.currentTimeMillis() %>'/>
			
		</div>
		<!-- 商品价格 -->
		<div class="input-group">
			<div class="input-group-addon">
				<span class="glyphicon glyphicon-yen"></span>
			</div> 
			<input type="text" class="form-control" id="price" name = "pprice" readonly="readonly"> 
		</div>
		<a href="javaScript:void(0);" id = "pay_product_form_btn"><button id="btnSub" type="button" class="btn btn-success">提交订单</button></a>
		<a href = "order.jsp"><button type="button" class="btn btn-success" style = "position: relative;left:300px;">查询订单</button></a>
	</form>
</div>
<!--//订单列表-->
<div class="container zf-lists">
	
	<table class="table table-striped table-hover zf-table">
	<thead>
		<tr>
			<th>选择</th>
			<th>商品名称</th>
			<th>商品价格</th>
		</tr>
	</thead>
	<!-- 提交个表单偷点懒  -->
		<tbody>
			<!-- id后拼接的为商品在数据库中的主键标识 -->
			<tr>
				<td>
					<input type = "radio" id = "product_1" name = "product" value = "1"/>
				</td>
				<td>
					<b>adidas沐浴露</b>
					<input type = "hidden" id = "pname_1" name = "pname" value = "adidas沐浴露"/>
				</td>
				<td>
					<b>￥0.01</b>
					<input type = "hidden" id = "pprice_1" name = "pprice" value = "0.01"/>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type = "radio" id = "product_2" name = "product" value = "2"/>
				</td>
				<td>
					<b>nike洗头膏</b>
					<input type = "hidden" id = "pname_2" name = "pname" value = "nike洗头膏"/>
				</td>
				<td>
					<b>￥0.02</b>
					<input type = "hidden" id = "pprice_2" name = "pprice" value = "0.02"/>
				</td>
			</tr>
		</tbody>
</table>
</div>	
</body>
</html>