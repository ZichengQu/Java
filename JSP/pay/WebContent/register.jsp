<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/login.css" />
<title>注册界面</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background:url(images/bg1.jpg) no-repeat;background-size: cover;">
    
    <div class="wrap1" style="height:450px;">
            <img src="images/logo.png" alt="" />
            <div class="main_content" style="height=1000px">
                <p class="text-center font20">login</p>
                <form action="login.do" method="post">
                    <div class="form-group mg-t20">
                        <i class="yonghu"></i>
                        <input type="text" class="login_input" id="username" name="adminCode"  placeholder="请输入用户名" value="${param.adminCode }" />
                    </div>
                    <span   id="code_msg">6-10位数字字母下划线</span>
                    <div class="form-group mg-t20">
                        <i class="pass"></i>
                        <input type="password" class="login_input"  name="password"  id="Password1" placeholder="请输入密码" value="${param.password }" />
                    </div>
                     <span   id="pwd_msg">6-10位数字字母下划线</span>
                    <div class="form-group mg-t20">
                        <i class="pass"></i>
                        <input type="password" class="login_input"  name="password"  id="Password1" placeholder="请再次输入密码" value="${param.password }" />
                    </div>
                    <span   id="pwd_msg">6-10位数字字母下划线</span>
                    <button style="submit" class="login_btn">确认</button>
                    <span class="required" id="span_msg">${sessionScope.msg }</span>
               </form>
        </div><!--row end-->
    </div><!--container end-->
</body>
</html>