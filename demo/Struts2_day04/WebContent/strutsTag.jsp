<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form标签 -->
	<s:form>
		<!-- 1.普通输入项 -->
		<s:textfield label="Username" name="username"></s:textfield>
		<!-- 2.密码输入项 -->
		<s:password label="Password" name="password"></s:password>
		<!-- 3.单选按钮 -->
		<s:radio list="{'Male','Female'}" name="gender" label="Gender"></s:radio>
		<!-- 4.复选框 -->
		<s:checkboxlist list="{'篮球','足球','橄榄球'}" name="hobby" label="Hobby"></s:checkboxlist>
		<!-- 5.下拉列表 -->
		<s:select list="{'C','C++','Java','Python'}" name="language" label="Language"></s:select>
		<!-- 6.隐藏表单域 -->
		<s:hidden name="hidden" label="Hidden"></s:hidden>
		<!-- 7.文件上传 -->
		<s:file name="file" value="upload"></s:file>
		<!-- 8.文本域 -->
		<s:textarea rows="10" cols="50" name="message" label="Message"></s:textarea>
		<!-- 9.提交按钮 -->
		<s:submit value="Submit"></s:submit>
		<!-- 10.重置按钮 -->
		<s:reset value="Reset"></s:reset>
	</s:form>
</body>
</html>