<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
<script>
	$(function(){
		$("#form1").submit(function(){
			if($("#name").val==""){
				alert("请输入姓名!");
				return false;
			}
			if($("[name='hobby']:checked").length==0){
				alert("请选择爱好!");
				return false;
			}
			if($("#school").val==""){
				alert("请输入学校!");
				return false;
			}
			if($("#insertDate").val==""){
				alert("请选择时间!");
				return false;
			}
		});
	});
</script>
</head>
<body>
	<form action="addStudent.do" method="post" id="form1">
		<table border="1" align="center">
			<tr>
				<td>姓名：</td>
				<td><input name="name" id="name"/></td>
			</tr>
			<tr>
				<td>爱好：</td>
				<td>
					<input name="hobby" type="checkbox" value="打游戏">打游戏
					<input name="hobby" type="checkbox" value="游泳">游泳
				    <input name="hobby" type="checkbox" value="看电影">看电影
					<input name="hobby" type="checkbox" value="旅游">旅游
					<input name="hobby" type="checkbox" value="篮球">篮球
			    </td>
			</tr>
			<tr>
				<td>学校：</td>
				<td><input name="school" id="school"/></td>
			</tr>
			<tr>
				<td>添加时间</td>
				<td><input name="insertDate" id="insertDate"/></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="确定"/>&nbsp;
				    <input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript" src="js/laydate.js"></script>
	<script>
			laydate.render({
			  	elem: '#insertDate'
			});
	</script>
</body>
</html>