<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>网页访问量统计</title>
</head>
<body>
	<%
		//Integer num = (Integer)session.getAttribute("num");
		Integer num = (Integer)application.getAttribute("num");
		if(num==null||num==0){//第一次访问页面
			out.print("欢迎访问乾包网");
			num = 1;
		}else{
			out.print("欢迎再次访问");
			num += 1;
		}
		//session.setAttribute("num", num);
		application.setAttribute("num", num);//application是应用级，对于这个应用，数据共享;session是会话级，关闭浏览器或切换浏览器则数据重置;
	%>
	<p>页面访问量为:${applicationScope.num}</p>
</body>
</html>