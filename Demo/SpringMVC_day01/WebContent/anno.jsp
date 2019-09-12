<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--常用的注解--%>
    
    <!-- 5.1	RequestParam注解 -->
    <a href="anno/testRequestParam?name=111">RequestParam</a>
    <br>
	<!-- 5.2	RequestBody注解使用说明 -->
    <form action="anno/testRequestBody" method="post">
	        用户姓名：<input type="text" name="username" /><br/>
	        用户年龄：<input type="text" name="age" /><br/>
	    <input type="submit" value="提交" />
    </form>
	<!-- 5.3	PathVaribale注解使用说明 -->
    <a href="anno/testPathVariable/10">testPathVariable</a>
    <br>
	<!-- 5.4	RequestHeader注解使用说明 -->
    <a href="anno/testRequestHeader">RequestHeader</a>
    <br>
	<!-- 5.5	CookieValue注解使用说明 -->
    <a href="anno/testCookieValue">CookieValue</a>
    <br>
	<!-- 5.6	ModelAttribute注解使用说明 -->
    <form action="anno/testModelAttribute" method="post">
	        用户姓名：<input type="text" name="uname" /><br/>
	        用户年龄：<input type="text" name="age" /><br/>
	    <input type="submit" value="提交" />
    </form>
    <br>
	<!-- 5.7	SessionAttribute注解使用说明 -->
    <a href="anno/testSessionAttributes">testSessionAttributes</a>
    <a href="anno/getSessionAttributes">getSessionAttributes</a>
    <a href="anno/delSessionAttributes">delSessionAttributes</a>


</body>
</html>
