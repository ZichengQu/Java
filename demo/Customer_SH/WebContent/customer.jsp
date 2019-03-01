<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript">
	$(function(){
		$("[id^='del_']").click(function(){
			var customer_cid = this.id.split("_")[1];
			if(confirm('确定删除吗？')){
				$.ajax({
					url:"deleteCustomer.action",
					type:"post",
					data:"customer_cid="+customer_cid,
					//data:{customer_cid:customer_cid,demo:demo_value},//传递多个参数，以对象的形式传递。
					dataType:"json",
					success:function(result){
						console.log(result);
						if(result.msg!=null){//result.msg获取到其对应的value
							alert(result.msg);
						}
						if(result.msg=="删除成功"){
							location.reload(true);//true不写的话相当于f5刷新，写true相当于强制刷新(包括缓存的内容)
						}
					}
				});
			}
			
		});
		
	});
</script>
</head>
<body>
	<table class="table table-hover" style="width: 50%;margin: 20px auto;">
	  <tr>
	  	<td>客户ID</td>
	  	<td>客户名称</td>
	  	<td>客户级别</td>
	  	<td>客户来源</td>
	  	<td>联系电话</td>
	  	<td>手机</td>
	  	<td>操作</td>
	  </tr>
	  <%-- <c:forEach var="customer" items="${list }">
	  	<tr>
	  	<td>${customer.cid }</td>
	  	<td>${customer.custName }</td>
	  	<td>${customer.custLevel }</td>
	  	<td>${customer.custSource }</td>
	  	<td>${customer.custPhone }</td>
	  	<td>${customer.custMobile }</td>
	  </tr>
	  </c:forEach> --%>
	  
	   <s:iterator var="customer" value="list">
	  	<tr>
	  	<td><s:property value="#customer.cid"/></td>
	  	<td><s:property value="#customer.custName"/></td>
	  	<td><s:property value="#customer.custLevel"/></td>
	  	<td><s:property value="#customer.custSource"/></td>
	  	<td><s:property value="#customer.custPhone"/></td>
	  	<td><s:property value="#customer.custMobile"/></td>
	  	<td><input id="del_<s:property value="#customer.cid"/>" type="button" value="删除" class="btn btn-danger btn-xs"></td>
	  </tr>
	 </s:iterator>
	  
	</table>
</body>
</html>