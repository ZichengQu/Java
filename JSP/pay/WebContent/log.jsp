<%@page import="entity.Admin"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String msg = (String)session.getAttribute("msg");
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="css/login.css" />
<title>登录界面</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function checkCode(){
		var reg = /^[0-9a-zA-Z_]{6,10}$/;
		if($("#username").val()==null||!reg.test($("#username").val())){
			$("#code_msg").css("color","red");
			return 0;
		}else{
			$("#code_msg").css("color","green");
			return 1;
		}
	}
	function checkPwd(){
		var reg = /^[0-9a-zA-Z_]{6,10}$/;
		if($("#Password1").val()==null||!reg.test($("#Password1").val())){
			$("#pwd_msg").css("color","red");
			return 0;
		}else{
			$("#pwd_msg").css("color","green");
			return 1;
		}
	}
	$(function(){
		var msg = "<%=msg%>";
		//msg = "密码错误";
		$("#span_msg").text("");
		if(msg!="null"){
			$("#span_msg").text(msg);
		}
	});
</script>
</head>

<body style="background:url(images/bg1.jpg) no-repeat;background-size: cover;">
    
    <div class="wrap1" style="height:450px;">
            <img src="images/logo.png" alt="" />
            <div class="main_content">
                <p class="text-center font20">login</p>
                <form action="login.do" method="post" onsubmit="return checkCode()+ checkPwd(==2">
                    <div class="form-group mg-t20">
                        <i class="yonghu"></i>
                        <input type="text" class="login_input" id="username" name="adminCode"  placeholder="请输入用户名"  onblur="checkCode()"/>
                    </div>
                    <span   id="code_msg">6-10位数字字母下划线</span>
                    <div class="form-group mg-t20">
                        <i class="pass"></i>
                        <input type="password" class="login_input"  name="password"  id="Password1" placeholder="请输入密码" value="" onblur="checkPwd()"/>
                    </div>
                    <span   id="pwd_msg">6-10位数字字母下划线</span>
                    <button style="submit" class="login_btn">登 录</button>
                    <span class="required" id="span_msg">
               </form>
        </div><!--row end-->
    </div><!--container end-->
</body>
</html>
  
    