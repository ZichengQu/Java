<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script type="text/javascript">
	$(function(){
		var flag = true;
		$("#username").blur(function(){
			var username=$(this).val();
			$.ajax({
				url:"selUserByName.do",
				type:"post",
				data:"username="+username,
				dataType:"text",
				success:function(data){
					if(data=="true"){
						$("#msg1").text("用户名已存在，请更换用户名");
						flag = false;
					}else{
						$("#msg1").text("用户名可用");
						flag = true;
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<form action="register.do" method="post" id="form01">
		<table>
			<tr>
				<td>用户名：</td><td><input name="username" id="username" placeholder="用户名3-5个字符之间"/><span id="msg1" style="color: red;"></span></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td><td><input name="password" id="password" type="password" placeholder="密码6-10个字符之间"/><span id="msg2" style="color: red;"></span></td>
			</tr>
			<tr>
			    <td>确认密码：</td>
				<td><input name="repassword" id="repassword" type="password" placeholder="密码6-10个字符之间"/><span id="msg3" style="color: red;"></span></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="注册"/>
					<input type="reset" value="重置" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>