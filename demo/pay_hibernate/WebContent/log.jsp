<%@page import="entity.Admin"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/login.css" />
<title>登录界面</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		//账号格式判断
		var flag1 = false;
		var flag2 = false;
		var reg1 = /^\w{6,10}$/;//	/^[0-9a-zA-Z_]{6,10}$/
		$("#username").blur(function(){
			if($("#username").val()==null||!reg1.test($("#username").val())){
				//$("#code_msg").css("color","red");
				$("#code_msg").attr("class","error");
				flag1 = false;
			}else{
				//$("#code_msg").css("color","green");
				$("#code_msg").attr("class","ok");
				flag1 = true;
			}
		});
		//密码格式判断
		var reg2 = /^[0-9a-zA-Z_]{6,10}$/;
		$("#Password1").blur(function(){
			if($("#Password1").val()==null||!reg2.test($("#Password1").val())){
				//$("#pwd_msg").css("color","red");
				$("#pwd_msg").attr("class","error");
				flag2 = false;
			}else{
				//$("#pwd_msg").css("color","green");
				$("#pwd_msg").attr("class","ok");
				flag2 = true;
			}
		});
		//账号密码格式不正确的时候，阻止表单提交。
		$("form:first").submit(function(){
			if(flag1&&flag2){
				return true;
			}else{
				return false;
			}
		});
		$("#register").click(function(){
			location.href='register.jsp';
		});
	});
</script>
</head>

<body style="background:url(images/bg1.jpg) no-repeat;background-size: cover;">
    
    <div class="wrap1" style="height:450px;">
            <img src="images/logo.png" alt="" />
            <div class="main_content">
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
                    <button style="submit" class="login_btn">登 录</button>
                    <!-- <input id="register" type="button" value="注册" class="btn btn-danger btn btn-default btn-xs"/> -->
                    <span class="required" id="span_msg">${sessionScope.msg }</span>
               </form>
        </div><!--row end-->
    </div><!--container end-->
</body>
</html>
  
    