 	var playIndex = 0; 	
 	function play(){
 		if(playIndex++%2==0){
	 		document.getElementById("head1-1-1").innerHTML = "申诉电话&nbsp;&nbsp;Complaint call:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;024-31879621";
 		}else{
 			document.getElementById("head1-1-1").innerHTML = "用户服务热线&nbsp;&nbsp;User service hotline:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;400-1170-178";
 		}
 	}
 	setInterval("play()",1500)
 	function f1(){
 		document.getElementById("a1").innerHTML = "Enterprise";
 	}
 	function b1(){
 		document.getElementById("a1").innerHTML = "合作企业";
 	}
 	function f2(){
 		document.getElementById("a2").innerHTML = "About us";
 	}
 	function b2(){
 		document.getElementById("a2").innerHTML = "关于我们";
 	}
 	function f3(){
 		document.getElementById("a3").innerHTML = "Statistics";
 	}
 	function b3(){
 		document.getElementById("a3").innerHTML = "站长统计";
 	}
 	function change1(){
 		var dd1 = document.getElementById("dd1");
 		var dd2 = document.getElementById("dd2");
 		//dd1.style.background-image = "url(../img/gerens.png)";
 		dd1.style.backgroundImage = "url(img/gerens.png)";
 		dd1.style.color = "white";
 		dd1.style.backgroundSize = "120px 35px";
 		dd2.style.backgroundImage = "url(img/qiye.png)";
 		dd2.style.color = "black";
 		dd2.style.backgroundSize = "120px 35px";
 	}
 	function change2(){
 		var dd1 = document.getElementById("dd1");
 		var dd2 = document.getElementById("dd2");
 		dd1.style.backgroundImage = "url(img/gerenss.png)";
 		dd1.style.color = "black";
 		dd1.style.backgroundSize = "120px 35px";
 		dd2.style.backgroundImage = "url(img/qiyes.png)";
 		dd2.style.color = "white";
 		dd2.style.backgroundSize = "120px 35px";
 	}
	function check(){
		var username = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		var qq = document.getElementById("qq").value;
		var phone = document.getElementById("phone").value;
		var verificationM = ""+document.getElementById("verificationM").value;
		var yzm = document.getElementById("sendCode").innerHTML;
		var verificationP = document.getElementById("verificationP").value;
		var checkbox = document.getElementById("checkbox").checked;
		var regUsername = /^[a-zA-Z0-9_-]{1,20}$/;
		var regPhone =  /^1\d{10}$/; 
		if(!regUsername.test(username)){
			alert("请输入正确的用户名")
			return false;
		}else if(password.length<6){
			alert("请输入正确长度的密码")
			return false;
		}else if(qq.length==0){
			alert("请输入您的QQ账号")
			return false;
		}else if(!regPhone.test(phone)){
			alert("请输入正确手机号")
			return false;
		}else if(verificationM==""){
			alert("请输入验证码");
			return false;
		}else if(yzm!=verificationM){
			alert("请输入正确的验证码");
			return false;
		}else if(verificationP.length==0){
			alert("请输入手机验证码");
			return false;
		}else if(checkbox==false){
			alert("请勾选用户协议");
			return false;
		}
		return true;
	}
 	

