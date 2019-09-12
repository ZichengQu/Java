<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/29
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--4.1 封装零散属性--%>
    <a href="param/testParam?username=hehe&password=123">封装零散属性</a>
	
	<%--4.2 把数据封装Account类中--%>
    <form action="param/saveAccount" method="post">
        Account实体类姓名：<input type="text" name="username" /><br/>
        Account实体类密码：<input type="password" name="password" /><br/>
        Account实体类金额：<input type="text" name="money" /><br/>
    	User实体类姓名：<input type="text" name="user.uname" /><br/>
    	User实体类用户年龄：<input type="text" name="user.age" /><br/>
        <input type="submit" value="提交:封装到实体类" />
    </form>

    <%--4.4 把数据封装Account类中，类中存在list和map的集合--%>
    <form action="param/saveAccount" method="post">
	        姓名：<input type="text" name="username" /><br/>
	        密码：<input type="text" name="password" /><br/>
	        金额：<input type="text" name="money" /><br/>
	    List用户姓名：<input type="text" name="userList[0].uname" /><br/>
	    List用户年龄：<input type="text" name="userList[0].age" /><br/>
	    Map用户姓名：<input type="text" name="userMap['one'].uname" /><br/>
	    Map用户年龄：<input type="text" name="userMap['one'].age" /><br/>
	    <input type="submit" value="提交:list和map" />
    </form>

    <%--4.5 自定义类型转换器--%>
    <form action="param/saveUser" method="post">
	        用户姓名：<input type="text" name="uname" /><br/>
	        用户年龄：<input type="text" name="age" /><br/>
	        用户生日：<input type="text" name="date" /><br/>
	    <input type="submit" value="提交:自定义类型转换器" />
    </form>
	
	<%--4.6	获取Servlet原生API--%>
    <a href="param/testServlet">Servlet原生的API</a>

</body>
</html>
