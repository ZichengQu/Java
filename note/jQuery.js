1.jQuery:
	jQuery是一个快速、简洁的JavaScript框架，是继Prototype之后又一个优秀的JavaScript代码库(或JavaScript框架);
	jQuery设计的宗旨是“write Less，Do More”，即倡导写更少的代码，做更多的事情;
	它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优化HTML文档操作、事件处理、动画设计和Ajax交互;
	js与jq的区别: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%88%9D%E8%AF%86jq.html
2.使用步骤:
	1.引入jQuery的js文件;
	2.使用选择器找到要操作的节点;
	3.调用jQuery的方法处理节点;
3.选择器:
	(1)基本选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%9F%BA%E6%9C%AC%E9%80%89%E6%8B%A9%E5%99%A8.html
		id选择器:$("#id")		根据给定的ID匹配一个元素;
		元素选择器:$("element") 根据给定的元素名匹配所有元素;
		类选择器:$(".class")	根据给定的类匹配元素;
		通配符选择器:$("*")		匹配所有元素;
		复合选择器:$("selector1,selector2,...,selectorN")		将每一个选择器匹配到的元素合并后一起返回。
	(2)层级选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%B1%82%E7%BA%A7%E9%80%89%E6%8B%A9%E5%99%A8.html
		$("ancestor descendant") 	在给定的祖先元素下匹配所有的后代元素;
		$("parent > child") 		在给定的父元素下匹配所有的子元素;只查找直接子节点，不查找间接子节点。
		$("prev + next")			匹配所有紧接在 prev 元素后的 next 元素(若next不紧跟在prev之后，则不起作用);
		$("prev ~ siblings")		匹配 prev 元素之后的所有 siblings 元素;
	(3)过滤选择器:
		过滤选择器主要是通过特定的过滤规则来筛选出所需要的DOM元素;
		过滤选择器的特点是以":"开头;
		按照不同的过滤规则，过滤选择器可分为基本过滤、内容过滤、可见性过滤、属性过滤、子元素过滤和表单过滤选择器等.
		1)基本过滤选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%9F%BA%E6%9C%AC%E8%BF%87%E6%BB%A4%E9%80%89%E6%8B%A9%E5%99%A8.html
			注意:索引和index都是从0开始的。
			$(":first")	第一个元素;//$("li:first")
			$(":last")	最后一个元素;//$("li:last")
			$(":not(selector")	把selector排除在外;//$("li:not(:first)")	//$("li:not(:eq(3))")
			$(":even")	挑选偶数行;//$("li:even")
			$(":odd")	挑选奇数行;//$("li:odd")
			$(":eq(index)")	挑选下标等于index的元素;//$("li:eq(0)")
			$(":gt(index)")	挑选下标大于index的元素;//$("li:gt(0)")
			$(":lt(index")	挑选下标小于index的元素;//$("li:lt(6)")
		2)内容过滤选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%86%85%E5%AE%B9%E8%BF%87%E6%BB%A4%E9%80%89%E6%8B%A9%E5%99%A8.html
			:contains(text) 匹配包含给定文本的元素//
			:empty 匹配所有不包含子元素或者文本的空元素//
			:has(selector) 匹配含有选择器所匹配的元素的元素//
			:parent 匹配含有子元素或者文本的元素//
			例子:
				<head>
					<meta charset="UTF-8">
					<title></title>
					<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
					<script>
						$(function(){//$(document).ready(function(){});
							$("div:contains('John')").css({ background: "yellow" });//:contains(text) 匹配包含给定文本的元素//第1和3行
							console.log($("div:empty"));//:empty 匹配所有不包含子元素或者文本的空元素
							$("div:has(p)").css({ color: "blue" });//:has(selector) 匹配含有选择器所匹配的元素的元素
							$("div:parent").css({ color: "blue" });//:parent 匹配含有子元素或者文本的元素
						});
					</script>
				</head>
				<body>
					<div>John Resig</div>
					<div><p>George</p> Martin</div>
					<div>Malcom John Sinclair</div>
					<div style="border: 1px solid blue; width: 100px; height: 100px;"></div>
				</body>
		3)可见性选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%8F%AF%E8%A7%81%E6%80%A7%E9%80%89%E6%8B%A9%E5%99%A8.html
			:hidden 匹配所有不可见元素，或者type为hidden的元素 //console.log($("input:hidden").val());
			:visible 匹配所有的可见元素
		4)属性过滤选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%B1%9E%E6%80%A7%E8%BF%87%E6%BB%A4%E9%80%89%E6%8B%A9%E5%99%A8.html
			注意，在jQuery 1.3中，前导的@符号已经被废除！如果想要兼容最新版本，只需要简单去掉@符号即可。
			[attribute] 匹配包含给定属性的元素。//$("div[id]") div中有id属性的
			[attribute=value] 匹配给定的属性是某个特定值的元素 //$("input[name='newsletter']") input中name为newsletter的
			[attribute!=value] 
			[attribute^=value] 匹配给定的属性是以某些值开始的元素 //$("input[name^='news']").attr("checked", true); input中name以news开头的
			[attribute$=value] 
			[attribute*=value] 
			[attrSel1][attrSel2][attrSelN] 
		5)表单属性过滤选择器: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E8%A1%A8%E5%8D%95%E5%B1%9E%E6%80%A7%E8%BF%87%E6%BB%A4%E9%80%89%E6%8B%A9%E5%99%A8.html
			:enabled 匹配所有可用元素 //$("input:enabled")
			:disabled 匹配所有不可用元素 //$("input:disabled")
			获得复选框，单选按钮，下拉列表的选中元素节点:
				:checked 匹配所有选中的被选中元素(复选框、单选框等，不包括select中的option)//$("input[type='checkbox']:checked'").val() //$("input:checked").attr("checked",false);
				:selected 匹配所有选中的option元素 //console.log($("select option:selected").text());
		6)表单选择器:	api
			:input 匹配所有 input, textarea, select 和 button 元素 //$(":input") //$("input")是元素选择器，只能匹配input元素。
			:text 匹配所有的单行文本框 //$(":text")
			:password 匹配所有密码框 //$(":password")
			:radio 匹配所有单选按钮 //$(":radio")
			:checkbox 匹配所有复选框 //$(":checkbox")
			:submit 匹配所有提交按钮 //$(":submit")
			:image 匹配所有图像域 //$(":image")
			:reset 匹配所有重置按钮 //$(":reset")
			:button 匹配所有按钮 //$(":button")
			:file 匹配所有文件域 //$(":file")
			:hidden 匹配所有不可见元素，或者type为hidden的元素 //$(":hidden")//$("input:hidden")
4.jQuery对象和DOM对象:
	(1)区别:
		DOM对象: 使用JS中的方法获取页面中的元素返回的对象就是DOM对象。
		jQuery对象: 使用jQuery的方法获取页面中的元素返回的对象就是jQuery对象。
		var domObj = document.getElementById("id的值");//DOM对象
		var $obj = $("#id的值");//jQuery对象
		jQuery对象就是通过jQuery包装DOM对象后产生的对象，它是jQuery独有的，如果一个对象是jQuery对象，那么就可以使用jQuery里的方法。
		例子: 
			$("#id的值").html();/*获取id为foo的元素内的html代码，html()就是jquery特有的方法。*/ 等同于: document.getElementById("id的值").innerHTML;//两种方法不能替换。
			注意: 在jQuery对象里面无法使用Dom对象的任何方法，同样DOM对象也不能使用jQuery对象的方法。
	(2)jQuery对象 转换成 DOM对象: 其实jquery对象转DOM对象的实质就是取出jQuery对象中封装的DOM对象。
		var $h2 = $("h2");
		第一种方法(推荐使用):$h2[index] //jQuery中获取第几个DOM对象是用下标，获取第几个jQuery对象是用基本过滤选择器，$(":eq(index)") //$("li:eq(0)")
		第二种方法:	$h2.get(index)
	(3)DOM对象 转换成 jQuery:
		var $obj = $(domObj); //$(document).ready(function(){});//就是典型的DOM对象转jQuery对象
	(4)例子: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day02/jQuery%E5%AF%B9%E8%B1%A1%E5%92%8CDOM%E5%AF%B9%E8%B1%A1.html
		<head>
			<meta charset="UTF-8">
			<title></title>
			<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
			<script>
				function f1(){
					document.getElementsByTagName("h2")[0].style.backgroundColor="pink";
					//$("h2").style.backgroundColor="orange";//会报错
					$("h2")[1].style.backgroundColor="orange";//jQuery对象调用DOM对象的成员
				}
				function f2(){
					$("div").css("color","red");
					//document.getElementsByTagName("div")[0].css("color","blue");//DOM对象调用jQuery成员,会报错
					var domObj = document.getElementsByTagName("div")[0];
					$(domObj).css("color","orange");
				}
			</script>
		</head>
		<body>
			<h2 >标题二</h2>
			<h2 >标题二</h2>
			<div>段落一</div>
			<input type="button" value="按钮1" onclick="f1();"/>
			<input type="button" value="按钮2" onclick="f2();"/>
		</body>
5.基本操作: 
	(1)jq操作DOM:
		$(function(){
			......
		});
		页面加载之后调用这个函数，作用等价于window.onload = function(){}
	(2)读写节点:
		读写节点的内容(双标签)
			读: html（） == innerHTML
			写: html("")
			读: text() == innerText
			写: text("")
			例子:
				html([val|fn]) 在一个 HTML 文档中, 我们可以使用 .html() 方法(不止限于html方法)来获取任意一个元素的内容。 如果选择器匹配多于一个的元素，那么只有第一个匹配元素的 HTML 内容会被获取。
				console.log($("p").html())/*返回p元素的内容。<span>哈哈哈哈</span>*/ $("p").html("<b>加粗文本</b>");//设置p元素的内容，识别标签
				text([val|fn]) 取得所有匹配元素的内容。	$("p").text("<b>加粗文本</b>");//设置p元素的内容，不识别标签，会输出标签
		读写节点的值(表单控件)
			读: val() == value
			写: val("")
		读写属性: 
			读: attr("属性名称") == set/getAttribute()
			写: attr("属性名称","属性值")
			对于HTML元素本身就带有的固有属性在处理时使用prop方法;对于HTML元素自定义的DOM属性，在处理时使用attr方法。具有true和false两个属性的属性(如checked、selected或disabled)，使用prop方法
			例子:
				console.log($("img").attr("src"));//img/科比.jpg
				$("img").attr("title","科比");
				$("img").attr({style:"display:none;title:科比"});
				$("img").attr("title", function() { return this.src });//this获取当前元素的html属性
	(3)增删节点: jQuery允许通过HTML代码字符串直接创建元素节点、文本节点及属性节点。
		$("节点标签及内容");	//$("<p>这是在创建节点</p>");
	(4)创建节点:
		父节点.append(子节点) //作为最后一个子节点加进来
		父节点.prepend(子节点) //作为第一个子节点加进来
		同级节点.after(同级节点) //作为下一个节点加进来
		同级节点.before(同级节点) //作为上一个节点加进来
	(5)删除节点:
		节点.remove()  //删除节点
		节点.remove(选择器) //删除满足该选择器的节点
		节点.empty()  //清空节点
	(6)遍历节点: 查找所有与它有关联的节点;有时调用的方法，得到一个节点，不能通过用选择器的方式来操作该节点周围其它的节点，所以只能调用一些遍历节点的方法。
		children()/children(选择器) 直接子节点;	console.log($("#uid").children());//所有对象，$("#uid").children()[index]
		next()/next(选择器) 该节点的下一个节点;	console.log($("#uid5").next());//Number1的对象
		prev()/prev(选择器) 该节点的上一个节点;	console.log($("#uid4").prev());//Number6的对象
		siblings()/siblings(选择器) 同一级别的所有节点(不包含自己); console.log($("#uid5").siblings());//12364
		find(选择器) 查找满足选择器的所欲偶后代; console.log($("#uid").find("h2"));//Number2的对象(因为Number2引用了h2标签)
		parent() 找父节点; console.log($("#uid4").parent());//父元素ul对象
	(7)基本操作例子和jQuery的表单验证: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%9F%BA%E6%9C%AC%E6%93%8D%E4%BD%9C.html
		$("form:first").submit(function(){//验证表达输入项是否为空
			if($("#name").val()==""){
				console.log("请输入用户名");
				return false;
			}
		});
		<form >
			<input id="name" name="username"/>
			<input type="submit" />
		</form>
	(8)jq的DOM操作例子: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day02/jQuery%E6%93%8D%E4%BD%9CDOM.html
		<head>
			<meta charset="UTF-8">
			<title></title>
			<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
			<script>
				$(function(){
					//1.读写节点
						//1.1读写节点的内容
					console.log($("div").html());//读	//<span>哈哈</span>
					console.log($("div").text());//读	//哈哈
					$("div").html("<b>加粗</b>");//写	//识别标签，会加粗文本
					$("div").text("<b>加粗</b>");//写	<b>加粗</b>
						//1.2读写节点的值(表单控件)
					console.log($("#username").val());//读	//admin
					$("#username").val("user");//写
					console.log($("input[type='checkbox']:checked'").val());//游泳 只读取第一个。
					console.log($("#dz").val());//沈阳,val()就是选择的选项。
						//1.3读写属性
					console.log($("#kb").attr("id"));//相当于getAttribute();
					$("#kb").attr("title","科比");
					console.log($("input[type='checkbox']").attr("checked"));//checked,若是不写checked="checked"，则输出undefined
					console.log($("input[type='checkbox']").prop("checked"));//true
					$("input[type='checkbox']").prop("checked",false);
					//2.增删节点
						//2.1创建节点
					var $li1 = $("<li id='uid4'>Number4</li>");//$("节点标签及内容"); //$("<p>这是在创建节点</p>");
					var $li2 = $("<li id='uid5'>Number5</li>");
					var $li3 = $("<li>Number6</li>");
						//2.2插入节点
					$("#uid").append($li1);//父节点.append(子节点) 作为最后一个子节点加进来
					$("#uid").prepend($li2);//父节点.prepend(子节点) 作为第一个子节点加进来
					$("#uid4").after($li3);//同级节点.after(同级节点) 作为下一个节点加进来
					$("#uid4").before($li3);//同级节点.before(同级节点) 作为上一个节点加进来 //类似于节点的剪切，不能将同一个节点插入到不同的位置。
						//2.3删除节点
					//$("#uid").remove(); //节点.remove() 删除节点
					//$("li").remove("#uid5") //节点.remove(选择器) 删除满足该选择器的节点
					//$("#uid").empty(); //节点.empty() 清空节点,节点不删除
					//3.遍历节点
						//3.1
					console.log($("#uid").children());//所有对象，$("#uid").children()[index]
					console.log($("#uid5").next());//Number1的对象
					console.log($("#uid4").prev());//Number6的对象
					console.log($("#uid5").siblings());//12364
					console.log($("#uid").find("h2"));//Number2的对象(因为Number2引用了h2标签)
					console.log($("#uid4").parent());//父元素ul对象
				});
			</script>
		</head>
		<body>
			<div><span>哈哈</span></div>
			用户名:	<input id="username" value="admin"/><br />
			爱好:	<input type="checkbox" name="hobby" value="游泳" checked="checked"/>游泳
					<input type="checkbox" name="hobby" value="篮球" checked="checked"/>篮球
			地址:	<select id="dz">
						<option>大连</option>
						<option selected="selected">沈阳</option>
					</select><br />
			<img id="kb" src="img/科比.jpg"/>
			<ul id="uid">
				<li>Number1</li>
				<li><h2>Number2</h2></li>
				<li>Number3</li>
			</ul>
		</body>
6.样式操作: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day02/%E6%A0%B7%E5%BC%8F%E6%93%8D%E4%BD%9C.html
	attr("class","样式") 获取和设置 	//$("div").attr("class","apple"); //attr对同一个属性进行多次设置修改，后者覆盖前者。
	addClass("样式") 追加样式 	//$("div").addClass("apple"); //addClass给class属性追加属性值，可以叠加，不会覆盖前者。
	removeClass()/removeClass("样式") 移除所有/指定样式 	//$("div").removeClass("apple");
	toggleClass("样式") 切换样式; 可以实现开关效果，有就删除，没有就加入。 //$("div").toggleClass("apple")
	css("") 读取css的值	//console.log($("div").css("color"));
	css("","") 设置多个样式(传对象)	//$("div").css({"color":"red","font-family":"微软雅黑"});
	样式的设置会被设置为行内(内联)样式
	例子:
		<head>
			<meta charset="UTF-8">
			<title></title>
			<style>
				.apple{width: 100px; height: 100px; background-color: pink;}
				.pear{color: blue;}
				.banana{font-size: 30px;}
			</style>
			<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
			<script>
				$(function(){
					console.log($("div").css("color"));
					$("div").css({"color":"red","font-family":"微软雅黑"});
				});
				function f1(){
					//给div设置class属性值.
						//attr对同一个属性进行多次设置修改，后者覆盖前者。
					$("div").attr("class","apple");
					$("div").attr("class","pear");
					$("div").attr("class","banana");
						//addClass给class属性追加属性值，可以叠加，不会覆盖前者。
					$("div").addClass("apple");
					$("div").addClass("pear");
					$("div").addClass("banana");
						//切换样式; 可以实现开关效果，有就删除，没有就加入。
					$("div").toggleClass("apple");
				}
				function f2(){
					//删除class属性值
					$("div").removeClass("apple");//移除class属性中的apple
					$("div").removeClass();//移除所有class属性，class属性为空。
					$("div").removeAttr("class");//删除class属性。
				}
			</script>
		</head>
		<body>
			<h2>样式操作标题2</h2>
			<div class="apple banana pear">此处是div</div>
			<button onclick="f1()">添加样式</button>
			<button onclick="f2()">移除样式</button>
		</body>
7.jQuery事件: 
	1)当元素失去焦点时触发 blur 事件。
		$("input").blur( function () { alert("Hello World!"); } );
	2)当元素获得焦点时，触发 focus 事件。
		 $("#input").focus();//加载页面的时候默认获得焦点
	3)当按钮被松开时，发生 keyup 事件。它发生在当前获得焦点的元素上。
		$("#phone").keyup(function(){
			var v = $(this).val();//$(this).val() -->jQuery对象;this.value --> DOM对象
			var reg = /\D/g;
			if(reg.test(v)){
				$(this).val(v.replace(/\D/g,""));//禁止用户输入非数字字符，将非数字字符替换成空串。
			}
		});
	4)触发每一个匹配元素的 click 事件。
		$("#phone").click(function(){});
	5)当提交表单时，会发生 submit 事件;只适用于表单提交。
		$("#form1").submit(function(){//<input type="submit" />
			if($("#user").val()==""){
				console.log("请输入用户名!");
				return false;//不需要在最后写return true;
			}
		});
		$("#btn").click(function(){//<input id="btn" type="button" value="普通按钮提交"/>,不通过type为submit的方式进行提交
			if($("#user").val()==""){
				console.log("请输入用户名!");
				return false;
			}
			$("#form1").submit();
		});
	(6)jQuery事件的例子: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day02/jQuery%E4%BA%8B%E4%BB%B6.html
		<head>
			<meta charset="UTF-8">
			<title></title>
			<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
			<script>
				$(function(){
					$("#username").focus(function(){
						console.log("获得焦点");
					});
					$("#username").blur(function(){
						console.log("失去焦点");
					});
					$("input").keyup(function(){//当按钮被松开时，发生keyup事件。
					  $("input").css("background-color","#D6D6FF");
					});
					$("#phone").keyup(function(){
						var v = $(this).val();//$(this).val() -->jQuery对象;this.value --> DOM对象
						var reg = /\D/g;
						if(reg.test(v)){
							$(this).val(v.replace(/\D/g,""));////禁止用户输入非数字字符，将非数字字符替换成空串。
						}
					});
					$("p").click( function () { 
						$(this).hide(); 
					});
					$("#form1").submit(function(){
						if($("#user").val()==""){
							console.log("请输入用户名!");
							return false;
						}
					});
					$("#btn").click(function(){//普通按钮提交,不通过type为submit的方式进行提交
						if($("#user").val()==""){
							console.log("请输入用户名!");
							return false;
						}
						$("#form1").submit();
					});
					
				});
			</script>
		</head>
		<body>
			用户名: <input id="username" /><br />
			手机号: <input id="phone" /><br />
			<p>段落</p>
			<form id="form1">
				用户名: <input id="user" name="username"/><br />
				<input type="submit" />
				<input id="btn" type="button" value="普通按钮提交"/>
			</form>
		</body>
	(7)jQuery全选例子: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day02/jQuery%E5%85%A8%E9%80%89.html
		<head>
			<meta charset="UTF-8">
			<title></title>
			<style>
				body{
					font:20px "微软雅黑";
				}
			</style>
			<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
			<script>
				/*
				 * 1、得上面那个复选框
				 * 2、判断这个复选框是否被选中
				 * 3、如果是选中，下面是全选
				 * 4、如果不是选中，下面全部选
				 */
				$(function(){
					$("#selAll").click(function(){
						if($(this).prop("checked")){//判断全选是否被选中
							$("input[name='language']").prop("checked",true);
						}else{
							$("input[name='language']").prop("checked",false);
						}
					});
					$("input[name='language']").click(function(){//第一种
						var L = $("input[name='language']").length;
						var sel = $("input[name='language']:checked").length;
						if(L==sel){
							$("#selAll").prop("checked",true);
						}else{
							$("#selAll").prop("checked",false);
						}
					});
					$("input[name='language']").click(function(){//第二种(较为规范)，对name='language'的元素进行遍历
						var flag = true;
						$("input[name='language']").each(function(){
							if(!this.checked){
								flag = false;
								return;//结束遍历
							}
						});
						if(flag){
							$("#selAll").prop("checked",true);
						}else{
							$("#selAll").prop("checked",false);
						}
					});
				});
			</script>
		</head>
		<body>
			<input type="checkbox" id="selAll"/>全选<br/>
			<input name="language" type="checkbox" id="java" />java<br/>
			<input name="language" type="checkbox" id="python" />python<br/>
			<input name="language" type="checkbox" id="c" />c语言<br/>
			<input name="language" type="checkbox" id="php" />php<br/>
		</body>
	

			


