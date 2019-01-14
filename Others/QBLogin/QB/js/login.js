 	var playIndex = 0; 	
 	function play(){
 		if(playIndex++%2==0){
	 		document.getElementById("head1-1-1").innerHTML = "申诉电话&nbsp;&nbsp;Complaint call:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;024-31879621";
	 		console.log(111);
 		}else{
 			document.getElementById("head1-1-1").innerHTML = "用户服务热线&nbsp;&nbsp;User service hotline:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;400-1170-178";
 			console.log(222);
 		}
 	}
 	setInterval("play()",1500);
 	console.log(333);
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
