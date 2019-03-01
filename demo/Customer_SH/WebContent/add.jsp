<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript">
	$(function(){
		
		$("#submit").click(function(){
			var custName = $("input[name=custName]").val();
			var custLevel = $("input[name=custLevel]").val();
			var custSource = $("input[name=custSource]").val();
			var custPhone = $("input[name=custPhone]").val();
			var custMobile = $("input[name=custMobile]").val();
			if(confirm('确定添加吗？')){
				$.ajax({
					url:"add.action",
					type:"post",
					data:{//传递多个参数，以对象的形式传递。
						custName:custName,
						custLevel:custLevel,
						custSource:custSource,
						custPhone:custPhone,
						custMobile:custMobile
						},
					dataType:"json",
					success:function(result){
						if(result.msg!=null){//result.msg获取到其对应的value
							alert(result.msg);
						}
						if(result.msg=="添加成功"){
							location.href="query.action";
						}
					}
				});
			}
		});
		
	});
</script>
</head>
<body>
	<div style="width: 50%;margin: 20px auto;">
	<form class="form-horizontal" action="add.action" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label">客户名称</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" name="custName">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">客户级别</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" name="custLevel">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">客户来源</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" name="custSource">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">联系电话</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" name="custPhone">
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">手机</label>
			<div class="col-xs-4">
				<input type="text" class="form-control" name="custMobile">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input id="submit" type="button" class="btn btn-primary">添加</input>
			</div>
		</div>
	</form>
	</div>

</body>
</html>