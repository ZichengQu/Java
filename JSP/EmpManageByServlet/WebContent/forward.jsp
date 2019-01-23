<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		var second = document.getElementById("second");
		var time = second.innerText;
		var timer = setInterval(function() {
			time--;
			second.innerHTML = time;
			if(time==0){
				clearInterval(timer);
				location.href = "main.jsp";
			}
		}, 1000);
	}
</script>
</head>
<body>
	<h1 align="center">添加成功,<span style="color:red" id="second">5</span>秒后跳转，若不跳转请点击<a href="main.jsp">这里</a></h1>
</body>
</html>