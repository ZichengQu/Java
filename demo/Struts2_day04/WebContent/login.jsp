<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	#code{
		border: 1px solid burlywood;
		background-color: burlywood;
		font:italic bold 20px "微软雅黑";
		display:inline-block;
		width:70px;
		text-align:center;
	}
</style>
<script type="text/javascript">
	function change(){
		document.getElementById('code').style.visibility = "visible";
		var str="";
	    var yzm = ['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','k','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
		for(var i=0;i<4;i++){
			str+=yzm[Math.floor(Math.random()*62)];
		}
	    document.getElementById('code').innerText=str;
	}

</script>
<title>登录</title>
</head>
<body>
	<form action="user_login" method="post" id="form01">
		<table>
			<tr>
				<td>用户名：</td><td><input name="username" id="username" placeholder="用户名3-5个字符之间" value="${requestScope.username }"/></td>
			</tr>
			<tr>
				<td>密&nbsp;码：</td><td><input name="password" id="password" type="password" placeholder="密码6-10个字符之间"/></td>
			</tr>
			<tr>
				<td>验证码：</td><td><input type="text" placeholder="点击获取" onclick="change();"/>&nbsp;
				<span id="code" style="visibility:hidden"></span></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="登录"/>
					<input type="button" value="注册" onclick="location.href='register.jsp'"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>