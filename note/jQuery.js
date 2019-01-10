1.jQuery:
	jQuery是一个快速、简洁的JavaScript框架，是继Prototype之后又一个优秀的JavaScript代码库(或JavaScript框架);
	jQuery设计的宗旨是“write Less，Do More”，即倡导写更少的代码，做更多的事情;
	它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优化HTML文档操作、事件处理、动画设计和Ajax交互;
2.使用步骤:
	1.引入jQuery的js文件;
	2.使用选择器找到要操作的节点;
	3.调用jQuery的方法处理节点;
3.选择器:
	(1)基本选择器:
		id选择器:$("#id")		根据给定的ID匹配一个元素;
		元素选择器:$("element") 根据给定的元素名匹配所有元素;
		类选择器:$(".class")	根据给定的类匹配元素;
		通配符选择器:$("*")		匹配所有元素;
		复合选择器:$("selector1,selector2,...,selectorN")		将每一个选择器匹配到的元素合并后一起返回。
	(2)层级选择器:
		$("ancestor descendant") 	在给定的祖先元素下匹配所有的后代元素;
		$("parent > child") 		在给定的父元素下匹配所有的子元素;只查找直接子节点，不查找间接子节点。
		$("prev + next")			匹配所有紧接在 prev 元素后的 next 元素(若next不紧跟在prev之后，则不起作用);
		$("prev ~ siblings")		匹配 prev 元素之后的所有 siblings 元素;
	(3)过滤选择器:
		过滤选择器主要是通过特定的过滤规则来筛选出所需要的DOM元素;
		过滤选择器的特点是以":"开头;
		按照不同的过滤规则，过滤选择器可分为基本过滤、内容过滤、可见性过滤、属性过滤、子元素过滤和表单过滤选择器等.
		1)基本过滤选择器:
			注意:索引和index都是从0开始的。
			$(":first")	第一个元素;//$("li:first")
			$(":last")	最后一个元素;//$("li:last")
			$(":not(selector")	把selector排除在外;//$("li:not(:first)")	//$("li:not(:eq(3))")
			$(":even")	挑选偶数行;//$("li:even")
			$(":odd")	挑选奇数行;//$("li:odd")
			$(":eq(index)")	挑选下标等于index的元素;//$("li:eq(0)")
			$(":gt(index)")	挑选下标大于index的元素;//$("li:gt(0)")
			$(":lt(index")	挑选下标小于index的元素;//$("li:lt(6)")