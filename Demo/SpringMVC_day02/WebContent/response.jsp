<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function(){
            $("#btn").click(function(){//页面加载，绑定单击事件
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe","password":"123","age":30}',
                    dataType:"json",
                    type:"post",
                    success:function(data){//data服务器端响应的json的数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });
        });
    </script>

</head>
<body>
	<!-- 6.1	返回字符串 -->
    <a href="user/testString">testString</a>
    <br/>
	<!-- 6.2	返回值是void -->
    <a href="user/testVoid" >testVoid</a>
    <br/>
	<!-- 6.3	返回值是ModelAndView对象 -->
    <a href="user/testModelAndView" >testModelAndView</a>
    <br/>
	<!-- 6.4	使用关键字转发或重定向 -->
    <a href="user/testForwardOrRedirect" >testForwardOrRedirect</a>
    <br/>
	<!-- 6.5	ResponseBody响应json数据 -->
    <button id="btn">发送ajax的请求</button>

</body>
</html>
