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
						$(function(){
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
				:checked 匹配所有选中的被选中元素(复选框、单选框等，不包括select中的option) //$("input:checked").attr("checked",false);
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
4.基本操作: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%9F%BA%E6%9C%AC%E6%93%8D%E4%BD%9C.html
	(1)html操作:
		html([val|fn]) 在一个 HTML 文档中, 我们可以使用 .html() 方法来获取任意一个元素的内容。 如果选择器匹配多于一个的元素，那么只有第一个匹配元素的 HTML 内容会被获取。
		例子:
			console.log($("p").html())//返回p元素的内容。//<span>哈哈哈哈</span>
			$("p").html("<b>加粗文本</b>");//设置p元素的内容，识别标签
	(2)文本操作:
		text([val|fn]) 取得所有匹配元素的内容。	$("p").text("<b>加粗文本</b>");//设置p元素的内容，不识别标签，会输出标签
	(3)值操作:
		console.log($("img").attr("src"));//img/科比.jpg
	(4)属性操作:
		$("img").attr("title","科比");
		$("img").attr({style:"display:none;title:科比"});
		$("img").attr("title", function() { return this.src });//this获取当前元素的html属性
	(5)jQuery的表单验证: https://github.com/ZichengQu/Java/blob/jQuery/Others/jQuery_day01/%E5%9F%BA%E6%9C%AC%E6%93%8D%E4%BD%9C.html
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

			


