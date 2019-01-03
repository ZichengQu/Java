CSS:
	定义:层叠样式表，又叫级联样式表，简称样式表;用于HTML文档中元素的样式定义。
	特点:1.实现将内容与表现相分离。2.提高代码的可重用性和可维护性。
一、HTML与CSS的关系：
	HTML用于构建网页的结构;CSS负责构建HTML页面元素的样式;HTML是页面的内容组成，CSS是页面的表现。
二、CSS样式表：
	1.内联方式:将样式定义在单个的HTML元素中;
		color:red; background-color:green; font-size:24px; 文本颜色的样式属性，背景颜色的样式属性，文本大小的样式属性。
		<div style="background-color: red; color: blue; font-size: 100px;">标题1</div>
	2.内部样式表:将样式定义在HTML页的头元素中;
		特点:
			1.应用范围为整个页面而不是某一个别元素,能够提升可重用性和可维护性，同时体现内容与表现相分离;
			2.在style元素中添加样式规则,可以定义多个样式规则,每个样式规则有两个部分：选择器和样式声明
				<head>
					<meta charset="utf-8" />
					<title></title>
					<style> /*内部样式表*/
						h1{
							...
						}
						p{
							color: yellow;
							background-color: black;
							font-size: 24px;
						}		
					</style>
				</head>
				<body text="blue" bgcolor="silver">				
					<h1><marquee>标题1</marquee></h1>
					<div style="background-color: black; color: yellow; font-size: 48px;">div1</div> /*内联方式*/
					<p>段落2</p>
				</body>
	3.外部样式表:将样式定义在一个外部CSS文件中(.css文件)，由HTML页面引用样式表文件。
		(1)创建单独的样式表文件(*.css),在该文件中可以编写若干样式规则
		(2)在需要使用该样式表文件的页面上，引入样式表文件，在页面的head元素中添加一下代码:<link rel="stylesheet" href="样式表文件的url"/>
			<link rel="stylesheet" href="css/style.css" />			
三、CSS语法
	1.CSS语法规范：
		内联规则:由样式声明组成.
		样式表(内部样式表或者外部样式表):由多个样式表规则组成，每个样式规则由两个小部分组成:选择器和声明.
	2.CSS样式表特征:
		(1)继承性:所谓继承性是指书写CSS样式表时，子标签会继承父标签的某些样式，如文本颜色和字号，想要设置一个可继承的属性，只需要将它应用于父元素即可。子元素可以继承父元素的样式(text-,font-,line-开头&&color的属性)
			<div style="color: pink; font-size: 20px;">
				<p>段落</p>
			</div>
		(2)层叠性:CSS处理冲突的能力(样式冲突，遵循就近原则).
			注意:层叠性只有在多个选择器选中"同一个标签"，然后又设置了"相同的属性"，才会发生层叠性。
		(3)优先级:样式定义冲入(重复)时，会按照不同样式的优先级来应用样式。
			低:浏览器缺省设置
			中:外部样式表或内部样式表(就近原则)
			高:内联样式
			!important:调整显示样式属性(不是选择器)的优先级，只要都以!important为主
			注意:继承的样式和自定义样式冲突时，永远都是以类选择器优先。		
		(4)例子：https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day01/index.html
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="utf-8" />
					<title></title>
					<!--<link rel="stylesheet" href="css/style.css" />-->
					<style >			
						.pink{/*自定义*//*类选择器*/
							color: pink;
							font-size: 20px;
							background-color: black;
							font-weight: 1000; /*加粗*/
						}
						.orange{/*!important*/
							color: orange!important;
						}
						div{
							color: aqua;
							font-size: 20px;
						}
						div{/*就近原则*/		
							font-size: 50px;
						}
					</style>
				</head>
				<body >						
					<div >
						<p>段落1</p> <!-- color: aqua; font-size: 50px; -->
					</div>
					<div class="pink">
						<p>段落2</p> <!-- .pink -->
					</div>	
					<div class="pink" style="color: red;">
						<p>段落3</p> <!-- 内联优先级最高，所以是red -->
					</div>
					<div class="orange" style="color: red;">
						<p>段落4</p> <!-- !important优先级最高，所以是orange -->
					</div>
					<div class="orange pink" style="color: red;"> <!-- 多类选择器 -->
						<p>段落5</p> <!-- !important优先级最高，所以是orange -->
					</div>
				</body>
			</html>
四、CSS基础选择器
	1.选择器的作用:规范了页面中哪些元素能够使用定义好的样式，同时也帮助我们去匹配页面上的元素
	2.选择器
		(1)通用选择器(了解)
			1)作用:匹配页面上所有的元素
			2)语法:*{样式声明;}
				<style >
					*{
						...
					}
				</style>
			3)注意:效率低，尽可能通过继承性去代替通用选择器的效果，它常用来设置一些默认样式。
		(2)元素选择器(标签选择器，标记选择器)(重点)
			1)作用:匹配页面上某一指定元素
			2)语法:元素{}				
				div{color:pink;}
				p{font-size:20px;}
		(3)类选择器(重点)
			1)作用:允许元素使用附带的class属性值，对选择器进行引用
			2)语法:以.作为开始，类名以"字母，数字，_"组成,不能以数字开始，     .类名{样式声明;}
			3)多类选择器:
				作用:可以让一个元素同时引用多个类选择器，中间用空格分开即可
		(4)结合元素选择器
			语法:元素选择器.类选择器{样式声明;}
		(5)id选择器(重点)
			作用:只匹配指定id值的元素
			语法:#id{样式声明;}
			例子：	
				#xr{
					background-color: pink;
				}				
		(6)群组选择器
			作用:选择器声明以逗号隔开的选择器列表，其目的是为了声明一组选择器中的公共样式。
			语法:选择器1，选择器2，选择器3...{样式声明;}
		(7)后代选择器
			作用:又称为包含选择器，用于选择作为某元素后代的元素(可选儿子，孙子，重孙子)
			注意:选择器一端包含两个或多个用空格分隔的选择器
			语法:
				选择器1 选择器2{样式声明;} <!-- 如果是自定义的就写. -->
		(8)子代选择器
			作用:选择某个元素的子元素(只选亲儿子)
			语法:选择器1>选择器2(样式声明;)
		(9)例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day01/css2.html
			<!DOCTYPE html>
			<html>
				<head>
					<meta charset="UTF-8">
					<title></title>
					<style >
						.red{
							color: red;
							font-size: 20px;
							font-weight: bold;
						}
						p.red{/*结合元素选择器*/
							font-size: 200px;
						}
						#xr{/*id选择器*/
							background-color: pink;
						}
						#xr,.red,p.red{/*群组选择器*/
							...
						}
						h1 .a{/*后代选择器,h1后面要有空格*/
							color: red;
						}
						.nav1 li{/*后代选择器*/
							color: blue;
						}
						.nav2>li{/*子代选择器*/
							color: green;
						}
					</style>
				</head>
				<body>
					<div class="red">熊大</div> <!-- 类选择器 -->
					<div id="xr"> 熊二</div> <!-- id选择器 -->
					<p>小强</p> <!-- 无属性,不是结合元素选择器 -->
					<p class="red">光头强</p> <!-- 结合元素选择器 -->
					<h1> 
						<p class="a">演示p</p> 
						<span class="a">演示span</span>
					</h1>
					
					<ul class="nav1"> <!-- 后代选择器,所有li均变颜色 -->
						<li>一级菜单</li>
						<ul>
							<li>二级菜单</li>
							<li>二级菜单</li>
							<li>二级菜单</li>
						</ul>
					</ul>
					
					<ul class="nav2">
						<li>一级菜单</li> <!-- 子代选择器,只有这个li变颜色 -->
						<ul>
							<li>二级菜单</li>
							<li>二级菜单</li>
							<li>二级菜单</li>
						</ul>			
					</ul>						
				</body>
			</html>
		(10)伪类选择器:
			作用:用于向某种选择器添加特殊的效果;
			语法:		选择器:伪类选择器{样式声明;}
			分类:
				1.链接伪类:
					link 匹配超链接未被访问时的状态。
					visited 匹配超链接被访问过的状态(只能定义字体颜色)。
				2.动态伪类:
					hover 匹配鼠标悬停在html元素时的状态。
					active 匹配html元素未激活时的状态(点击即被激活)。
					focus 匹配html元素获取焦点时的状态(文本框与密码框)。
				3.书写顺序:link>visited>hover>active
				4.例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day02/index.html
					<head>
						<meta charset="utf-8" />
						<title></title>
						<style>
							a{/*去掉超链接的下划线*/
								text-decoration: none;
							}
							a:link{/*匹配超链接未被访问时的状态*//*Ctrl+Shift+Delete删除浏览器缓存*/
								color: darkgray;
							}
							a:visited{/*匹配超链接被访问过的状态(只能定义字体颜色)*/
								color: dark;
							}
							a:hover{/*匹配鼠标悬停在html元素时的状态*/
								color: red;
								font-size: 20px;
							}
							a:active{/*匹配html元素未激活时的状态*/
								color: yellow;
								font-size: 100px;
							}
							input:focus{/*匹配html元素获取焦点时的状态*/
								color: red;
								background-color: yellow;
							}
						</style>
					</head>
					<body>
						<a href="#">文本</a>
						<br />
						用户名:<input type="text" />
					</body>
		(11)选择器优先级顺序:
			选择器类型  	 权值(不进位，只在本位一直相加)
			元素选择器:		0,0,0,1
			类选择器:		0,0,1,0
			伪类选择器:		0,0,1,0
			ID选择器:		0,1,0,0
			内联样式:		1,0,0,0
			例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day02/index2.html
				<head>
					<meta charset="UTF-8">
					<title></title>
					<style>
						.h{/*0,0,1,0*/
							font-size: 50px;
							color: red;
						}
						p{/*0,0,0,1*/
							font-size: 20px;
							color: yellow;
						}
						div p{/*0,0,0,2*/
							font-size: 50px;
							color: blue;
						}
					</style>
				</head>
				<body>
					<div>
						<p class="h">文本</p><!--显示的是h的属性-->
					</div>		
				</body>
五、尺寸与边框
	1.尺寸属性:
		(1)作用:尺寸属性一般用于设置元素的宽度和高度，单位一般为像素和百分比。
		(2)宽度属性:width,min-width,max-width
		(3)高度属性:height,min-height,max-height
		(4)注意:
			1)不是所有的元素都支持修改尺寸;
			2)支持修改尺寸属性的如下:块级元素;非块级元素中存在width,height属性的html元素(table,img,input).
			例子:
				<style>
					input{
						width: 100px;
						height: 100px;
					}
					span{
						background-color: blueviolet;
						color: bisque;
						width: 200px;/*无变化，因为行内元素不能设置高和宽*/
						height: 200px;				
					}
				</style>
	2.溢出:使用尺寸控制元素大小时，如果内容所需的控件大小大于元素本身的空间，会导致内容溢出。
		处理溢出的属性:
			overflow:当内容溢出元素时如何处理
			overfolw-x:横向溢出处理
			overflow-y:纵向溢出处理
		取值:
			visible:默认值，溢出可见。
			hidden:溢出隐藏。
			scroll:溢出滚动,会为父元素添加滚动条，通过拖动滚动条来查看完整内容，该属性不论内容是否溢出，都会添加水平和垂直双方向的滚动条。
			auto:当溢出的时候，才会出现滚动框，否则不出现。
	3.边框
		(1)简写方式:
			border: width style color
			width:边框粗细，以px为单位
			style:solid(实线),dotted(点虚线),dashed(虚线),double(双实线)
			color:边框颜色
			作用:控制元素的上下左右四个部分的粗细，样式和颜色。
		(2)单边定义:
			border-top/bottom/left/right:width style color
		(3)单属性定义:
			border-width/style/color:值
			作用:控制4条边的对应属性。
		(4)单方向单属性定义:
			border-top/bottom/left/right-width/style/color:值		
		(5)例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day02/index3.html
			<head>
				<meta charset="UTF-8">
				<title></title>
				<style>
					.box1{
						width: 200px;
						min-width: 150px;/*当width<min-width时,以min-width为准*/
						height: 200px;
						background-color: yellow;
						/*overflow: visible;*//*默认值，溢出可见*/
						/*overflow: hidden;*//*溢出隐藏*/
						/*overflow: scroll;*//*溢出滚动*/
						overflow: auto;/*当溢出的时候，才会出现滚动框，否则不出现*/
						/*
						border-width: 5px;
						border-color: #8A2BE2;
						border-style: solid; dotted虚线，dashed虚线,double双实线
						*/
						border: 5px red solid;/*简写方式*/
					}
					.box2{
						width: 100px;
						height: 500px;
						background-color: pink;
						border-bottom: 5px solid blueviolet;/*单边定义*/
						border-width: 5px 10px 15px 20px;
						border-style: solid double;
					}			
				</style>
			</head>
			<body>
				<div class="box1">
					<div class="box2"></div>
				</div>		
			</body>
		(6)注意:
			1)边框颜色可取值为transparent
			2)取消边框显示
				border:0/none;	border-top/bottom/left/right:0/none;
	4.轮廓
		(1)轮廓定义:绘制于元素边框周围的一条线，位于边框边缘的外围，可起到突出元素的作用。
		(2)属性:
			outline:width style color;
			outline-width:宽度
			outline-style:样式
			outline-color:颜色
			常用:outline:0/none;
		(3)例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day02/index4.html
			<head>
				<meta charset="UTF-8">
				<title></title>
				<style>
					input{/*取消显示边框*/
						border: none;
						outline: 0;
					}
					#username{
						/*border: 0;*/
						border-bottom: 5px solid blue;/*显示下边框*/
					}
				</style>
			</head>
			<body>
				用户名:<input type="text" id="username" /> <!-- 只显示下边框  -->
			</body>
	5.京东登陆框demo:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day02/index5.html
	
六、盒子模型:
	1.框模型:
		框:盒子(box),页面元素皆为框。
		框模型:(box-model)定义了元素处理内容，内边距，外边距，边框的一种方式。
		框模型的宽度、高度和面积:
			元素的width和height属性指定了内容区域的宽度和高度;
			增加内边距、边框和外边框不会影响内容区域的大小，但会增加元素框的总尺寸;
			元素的实际宽度=左右外边距+左右边框+左右内边距+width(元素的宽度);
			元素的实际高度=上下外边距+上下边框+上下内边距+height(元素的宽度);
	2.外边距:
		(1)外边距定义:围绕在元素边框周围的空白区域(当前盒子与其它盒子之间的距离)称为外边距;
		(2)作用:控制元素与元素之间的距离;移动元素位置;
		(3)属性:
		margin:四个方向的外边距
		margin-top/bottom/left/right:(上/下/左/右)外边距
		取值:px(像素),%(百分比),auto(自动),负值
		(4)取值-auto
			左右方向设置为auto时，允许元素在其父元素中水平居中对齐，前提必须设置该元素的宽度。
		(5)取值-负值
			移动元素，向着反方向移动; margin-left:-10; 向左移动10px
		(6)外边距的简洁写法:
			margin:value;四个方向外边距
			margin:value1 value2;	上下、左右
			margin:value2 value2 value3; 	上、左右、下
			margin:value1 value2 value3 value4;	上右下左
			margin:0 auto;水平居中
		(7)页面中具备默认外边距的元素:h#,p,ol,ul,div.
			清楚默认外边距:声明margin属性可以覆盖默认样式。 *{margin=0;}
		(8)外边距合并:当两个相邻的垂直外边距相遇时，它们将形成"一个"外边距，合并后的外边距的高度是两个外边距中较大者。
		(9)外边距溢出:在某种特殊场合下，给子元素设置外边距时，效果却作用在父元素的外边距上。
			特殊场合:父元素不设置边框时，为父元素中的第一个子元素设置上外边距时;或为最后一个子元素设置下外边距时.
			解决方案:为父元素添加边框(父元素高度会发生改变);为父元素添加内边距来取代子元素外边距(影响元素的尺寸).
			例子:
				<head>
					<meta charset="utf-8" />
					<title></title>
					<style>
						div.box1{
							width: 200px;
							height: 100px;
							background-color: yellow;
							/*border: 1px solid blue;加border，使子div不影响父外边距*/
							padding-top: 100px;/*内边距*/
						}
						div.box2{
							/*margin-top: 100px;*/
							width: 100px;
							height: 100px;
							background-color: pink;
						}
					</style>
				</head>
				<body>
					<div class="box1">
						<div class="box2"></div> <!-- 当紧挨着的时候，子div外边距溢出，会影响父div的外边距，并不改变它们之间的相对位置。-->
					</div>	
				</body>
	3.内边距
		(1)定义:内容区域与边框之间的空间，会扩大元素边框所占用的区域
		(2)属性:
			1)padding-top/bottom/left/right:px/%;
			2)内边距的简洁写法:
				padding:value;	四个方向外边距
				padding:value1 value2;	上下、左右
				padding:value2 value2 value3; 	上、左右、下
				padding:value1 value2 value3 value4;	上右下左
	4.行内元素盒模型:
		行内元素无法设置高、宽、垂直外边距、垂直内边距和上下两侧的边框，可以设置水平内外边距和左右两侧的边框。
		例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day03/%E8%A1%8C%E5%86%85%E5%85%83%E7%B4%A0%E7%9B%92%E6%A8%A1%E5%9E%8B.html
			<head>
				<meta charset="UTF-8">
				<title></title>
				<style>
					.s1{/*内容区、内边距、边框、外边距*/
						width: 200px;/*行内元素可以设置width和height(不会影响布局)*/
						height: 200px;
						padding-left: 100px;/*设置水平内边距，行内元素可以设置水平方向的内边距(不合并，叠加),可以设置垂直内边距(不会影响布局)*/
						padding-right: 100px;
						border: 1px solid blue;/*内联元素(行内元素)可以设置边框，但是垂直的边框不会影响到页面的布局*/
						margin-left: 100px;/*设置水平外边距，行内元素可以设置水平方向的外边距(不合并，叠加),可以设置垂直外边距(不会影响布局)*/
						margin-right: 100px;
					}
					.box1{
						width: 100px;
						height: 100px;
						background-color: red;
					}
				</style>
			</head>
			<body>
				<span class="s1">我是一个span</span>
				<span class="s1">我是一个span</span>
				<span class="s1">我是一个span</span>
				<span class="s1">我是一个span</span>
				<div class="box1"></div>
			</body>
	5.diaplay和visibility:
		例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day03/display%E5%B1%9E%E6%80%A7.html
			<head>
				<meta charset="UTF-8">
				<title></title>
				<style>
					/*
					 * 将一个内联元素(行内元素)变成块元素，通过display样式可以修改元素的类型;
					 * 为其设置宽和高可以检测是否转换成功。
					 * 可选值:
					 * 	inline:可以将一个元素作为行内元素显示;
					 * 	inline-block:可以将一个元素作为行内块元素显示;既可以设置高度，又不会独占一行(img);
					 * 	block:可以将一个元素设置为块元素显示;
					 * 	none:不显示元素，并且元素不会在页面中继续占有位置。
					 */
					/*
					 * visibility:可以用来设置元素的隐藏和显示状态
					 * 可选值:
					 * 	visible:默认值，元素默认会在页面显示
					 *  hidden:元素隐藏不显示,位置保留
					 */
					a{
						background-color: yellow;
						border: 1px solid blue;				
						display:block;/*将一个元素设置为块元素显示*/
						width: 200px;
						height:200px;
						visibility: hidden;
					}
					.box1{
						width: 100px;
						height: 100px;
						background-color: pink;
						display: none;/* none:不显示元素，并且元素不会在页面中继续占有位置。*/
					}
					.box2{
						width: 100px;
						height: 100px;
						background-color: red;
					}
					.box3{
						width: 100px;
						height: 100px;
						background-color: yellow;
					}
				</style>
			</head>
			<body>
				<a href="#">我是一个超链接</a>	
				<div class="box2"></div>
				<div class="box1"></div>
				<div class="box3"></div>
			</body>
七、背景属性:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day03/index2.html
	1.背景颜色
		属性:background-color
		取值:任意合法的颜色值可取值transparent
		注意:背景颜色会填充到元素的内容区域，内边距区域以及边框区域
	2.背景图像
		属性:background-image
		取值:url(图像的url)		background-image: url(img/SCAR-L.jpg);
	3.背景平铺
		属性:background-repeat
		取值:no-repeat,repeat-x,repeat-y,默认值是repeat
	4.背景图片尺寸
		属性:background-size
		取值:px,%,cover(),contain()		ps:对于px和%，尽量只改一个值，防止缩放失真。
			 value1px value2px	具体数值px，value1表示背景图像的宽度，value2表示背景图像的高度;
			 value1% value2%	以元素尺寸的占比决定背景图的尺寸;
			 cover:把背景图扩展至足够大(等比缩放)，直到背景图像完全覆盖住元素区域的位置(图像可能显示不完整)。
			 contain:包含，将背景图像等比缩放，直到右边或下边碰到元素边缘为止。
		例子:
			.box1{
					width: 500px;
					height: 500px;
					display: inline-block;
					background-color: yellow;
					background-image: url(img/SCAR-L.jpg);/*背景图像*/
					background-repeat: no-repeat;/*背景平铺,no-repeat,repeat-x,repeat-y,默认值是repeat*/
					/*背景图片设置大小background-size*/
					/*background-size: 500px;/*尽量只改一个值，防止缩放失真*/
					/*background-size: 50%;*/
					/*background-size: cover;*/
					background-size: contain;
				}
	5.背景图片固定
		属性:background-attachment
		取值:scroll 滚动，默认值	fixed 固定，将背景图片保持在可视化区域内，不随着滚动条而发生改变。
		例子：
			body{
				background-color: black;
				background-image: url(img/pc_kv2.jpg);		
				background-repeat: no-repeat;	
				background-size: 100%;	
				color: white;
				font-size: 20px;
				background-attachment: fixed;
			}
	6.背景图片位置:
		属性:background-position:方位名词
		取值:left bottom(方位名词没有顺序，谁在前都可以),left(如果方位名词只写一个，另一个默认为center),左中右，上中下
			 x y
			 % %	
		例子:
			background-position: center;/*方位名词没有顺序，谁在前都可以*/
			background-position: left;/*如果方位名词只写一个，另一个默认为center*/
			background-position: 10px 30px;/*精确单位，第一个值是X坐标，第二个值一定是Y坐标，取值可为负*/
			background-position: 10px center;/*水平移10px，垂直居中*/
	7.简写属性:
		background:color url() repeat attachment position;
		background:yellow url(img/SCAR-L.jpg) fixed center;
		注意:属性可以省略，省略的话将采用默认值。
八、文本格式化:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day03/%E6%96%87%E6%9C%AC%E6%A0%BC%E5%BC%8F%E5%8C%96.html
	1.字体属性
		(1)指定字体:font-family:value1,value2,...
			可以同时指定多个value，中间以逗号隔开，表示如果浏览器不支持第一个字体，则尝试下一个，直到找到合适的字体
			注意:中文字体需要加英文状态下的双引号
			例子:font-family: arial,"黑体";
		(2)字体大小:font-size:value; 设置的并不是文字本身的大小,在页面中，每个文字都是处在一个看不见的框中，我们设置的font-size实际上是设置的格的大小，并不是字体的大小。
		(3)字体加粗:<b></b>,<strong></strong>,font-weight:normal/bold/100~900(100的整数倍，400等价于normal，700等价于bold)
		(4)字体样式:font-style:normal/italic(斜体)
		(5)综合设置字体样式:font:style weight size family;
			font: italic 100 20px "黑体";
			使用font属性时，必须按上面语法格式中的混徐书写，不能更换顺序，各个属性以空格隔开。
			其中不需要设置的属性可以忽略(取默认值)，但必须保留size和family属性，否则font属性将不起作用。
	2.文本属性: https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/%E6%96%87%E6%9C%AC%E5%B1%9E%E6%80%A7.html
		(1)文本颜色属性:color;	color: red;
		(2)文本排列
			作用:规定元素中文本的水平对齐方式
			属性:text-align
			取值:left/center/right
			例子:text-align: center;
		(3)文字修饰
			属性:text-decoration
			取值:none/underline/overline(上划线)/line-through(删除线)
			例子:
				a{
					text-decoration: none;
					/*
					 * 超链接会默认添加下划线，也就是说超链接的text-decoration属性默认值是underline;
					 * 如果需要去除超链接的下划线，需要将该样式设置为none;
					 */
				}
		(4)行高
			作用:指定一行文本的高度，如果行高高于文字本身大小，那么文本将在指定的行高范围内垂直居中显示。行间距=行高-字体大小。
			属性:line-height
			取值:数值(px/%/一个具体的数)
			例子:
				.p1{
					font-size: 20px;/*此时行高为30*/
					line-height:1;
					/*
					 * line-height可以接收的值:
					 * 	1.直接接收一个大小px;
					 * 	2.可以指定一个百分比,会相对于字体设置百分比，100%无间距，200%有1倍的间距;
					 * 	3.可以直接传一个数值(无px)，1相当于100%，2相当于200%;
					 */
				}
		(5)首行文本缩进
			属性:text-indent
			取值:px/?em
			例子:
				.p1{
					text-indent: 2em;/*1em是一个汉字字符的大小(跟随text-size)*/
					/*text-indent: 16px;*//*一个汉字字符的默认大小是16px*/
				}
		(6)文本阴影
			属性:text-shadow
			取值:h-shadow(必须，水平阴影的位置) v-shadow(必须，垂直阴影的位置) blur(模糊的距离) color
			例子:
				.box{
					 color: blue;
					 font-size: 50px;
					 width: 50%;
					 height: 200px;
					 background-color: lightpink;
					 text-shadow: 10px 10px 10px red;/*取值*/
				}
		(7)字间距
			属性:letter-spacing
			取值:px
			例子:letter-spacing: 20px;
		(8)文本大小写(只适用于英文)
			属性:text-transform
			取值:none(默认值),capitalize(每个单词首字母大写),uppercase(大写),lowercase(小写);
			例子:
				.p2{
					font-size: 20px;
					text-transform: capitalize;
				}
	3.表格
		(1)表格常用样式属性:
			1)边距属性:padding
			2)尺寸属性:width,height
			3)文本、字体属性:
			4)背景属性:background...
			5)边框属性:border
			6)垂直方向对齐:vertical-align;	取值:top/middle(默认)/bottom
		(2)表格特有的样式属性:
			1)边框合并:	属性:border-collapse	取值:separate(默认，分离边框模式)/collapse(合并)
			2)边框边距:	
				属性:border-spacing
				作用:设置相邻单元格的边框的距离(仅用于"边框分离模式")
				取值:value	水平和垂直间距相同
					 value1 value2	第一个值表示水平间距，第二个值表示垂直间距，两个值之间用空格隔开
			3)标题:<caption></caption>
				标题位置:默认表格上方水平居中
				属性:caption-side	取值:top(默认值),bottom(标题位于表格之下)
			4)显示规则
				作用:如何去布局一个表格，指定了表格显示单元格，行的算法规则，又称为表格的布局。
				属性:table-layout
				取值:
					auto(默认值，自动布局表格数据):列的宽度是根据内容决定的。
					fixed(固定表格布局):列宽度由表格以及单元格所设定好的数据为主。
				auto和fixed的区别:
					自动布局auto:单元格的大小会适应内容;
								 当表格复杂时，加载速度慢(缺点);
								 自动布局会比较灵活(优点);
								 适用于表格不太复杂并且不确定每一列大小时使用。
					固定布局fixed:单元格的尺寸取决于设定的值;
								  任何情况下都会加速显示表格(优点);
								  固定布局不够灵活(缺点);
								  适用于确定每列大小时使用;
				例子:
					table.one{
						table-layout: fixed;/*显示规则,固定表格布局*/
					}
			5)例子:CSS表格:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/table.html
				<head>
					<meta charset="UTF-8">
					<title></title>
					<style>
						table,tr,th,td{
							border: 2px solid blue;/*边框属性*/
							font: normal 400 20px "微软雅黑";/*文本、字体属性*/
						}
						th,td{
							height: 100px;
							width: 100px;
						}
						table{
							margin: 0 auto;/*表格居中*/
							border-collapse: collapse;/*边框合并模式，默认是边框分离模式*/
							border-spacing: 10px 20px;/*边框边距，仅用于"边框分离模式"*/
							caption-side: bottom;/*标题位置:默认表格上方水平居中*/
						}
						th{
							background-color: yellow;/*背景属性*/
						}
						tr:hover{/*伪列，鼠标悬停的时候*/
							background-color: gainsboro;
						}
						td{
							text-align: center;/*文本排列，规定元素中文本的水平对齐方式*/
							vertical-align: middle;/*垂直方向对齐。默认垂直居中*/
						}
						table.one{
							margin-bottom: 100px;
							table-layout: fixed;/*显示规则,固定表格布局*/
						}
					</style>
				</head>
				<body>
					<table class="one" border="1" width="100%">
						<tr>
							<td width="20%">2020202020202020202020202020202020202020202020202020</td>
							<td width="40%">4040404040404040404040404040404040404040404040404040</td>
							<td width="40%">4040404440404040404040</td>				
						</tr>
					</table>
					<table border="1px">
						<caption>员工信息表</caption>
						<tr >
							<th>empno</th>
							<th>ename</th>
							<th>job</th>
							<th>mgr</th>
							<th>hiredate</th>
							<th>sal</th>
							<th>comm</th>				
							<th>deptno</th>				
						</tr>
						<tr >
							<td>100</td>
							<td>Jack</td>
							<td>salesman</td>
							<td>101</td>
							<td>2000-5-30</td>
							<td>5000</td>
							<td>1000</td>
							<td>10</td>
						</tr>
						<tr >
							<td>101</td>
							<td>Mary</td>
							<td>manager</td>
							<td>105</td>
							<td>2000-5-29</td>
							<td>6000</td>
							<td>1500</td>
							<td>20</td>
						</tr>
					</table>
				</body>
	4.浮动
		(1)定位:定义元素框相对于其正常位置应该出现的位置;或者相对于父元素，另一个元素甚至浏览器窗口本身的位置;
		(2)普通流定位(文档流定位):浏览器默认的定位方式称为普通流定位;
		(3)浮动定位:
			1)特征:
				脱离文档流，不占据页面空间，后续元素上前补位;
				会停靠在父元素的左侧或右侧，或者停靠在其它平级已浮动元素边缘上;
				依然包含在父元素内(比如body元素);
				让多个块级元素在一行内显示;
			2)语法:
				属性及取值:float:none/left/right
			3)浮动引发的特殊效果:
				父元素宽度不足以包含所有的已浮动子元素时，最后一个将换行;
				元素浮动起来后，宽度将变成自适应(未设置宽度时，内容决定宽度)(在文档流定位中，不设置宽度，则宽度为父元素宽度);
				行内元素，行内块元素，一旦浮动起来后将变成块级元素;
				文本，行内元素，行内块元素采用环绕的方式进行排列，会巧妙的避开浮动元素而不会被压住;
			4)例子:
				.box2{
					background-color: yellow;
					/*width: 200px;*//*未设置宽度时，内容决定宽度*/
					height: 200px;
					float: left;/*浮动定位*/
				}
			5)例子:
				浮动:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/%E6%B5%AE%E5%8A%A8.html
					<head>
						<meta charset="UTF-8">
						<title></title>
						<style>
							.box1{
								background-color: red;
								width: 200px;
								height: 200px;
								float: left;
							}
							.box2{
								background-color: yellow;
								width: 200px;
								height: 200px;
								float: left;浮动定位
							}
							.box3{
								background-color: blue;
								width: 300px;
								height: 300px;
							}
							.box4{/*文本，行内元素，行内块元素采用环绕的方式进行排列，会巧妙的避开浮动元素而不会被压住;*/
								background-color: yellow;
								width: 100px;
								height: 100px;
								float: left;
							}
							span{
								background-color: yellow;
							}
							.s1{
								width: 100px;
								height: 100px;
								background-color: pink;
								float: left;
								/*display: inline-block;*/
							}
						</style>
					</head>
					<body>
						<!-- div.box$*3 -->
						<div class="box1">
							<div class="box4">
								
							</div>
							浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!浮动引发的特殊效果!
						</div>
						<div class="box2"></div>
						<div class="box3"></div>
						<span class="s1">span标签</span>
						<span class="s2">span标签</span>
						<span class="s3">span标签</span>
					</body>
				简单布局:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/%E7%AE%80%E5%8D%95%E5%B8%83%E5%B1%80.html
					<head>
						<meta charset="UTF-8">
						<title></title>
						<style>
							*{/*清除默认样式*/
								margin: 0;
								padding: 0;
							}
							.header{
								width: 100%;
								height: 150px;
								background-color: yellow;
								margin: 0 auto;
							}
							.content{
								width: 100%;
								height: 400px;
								background-color: orange;
								margin: 0 auto;
								margin: 10px auto;
							}
							.footer{
								width: 100%;
								height: 150px;
								background-color: pink;
								margin: 0 auto;
							}
							/*设置content中小div的样式*/
							.left{
								width: 20%;
								height: 100%;
								background-color: skyblue;
								float: left;
							}
							.center{
								width: 58.68%;
								height: 100%;
								background-color: blanchedalmond;
								float: left;
								margin:0 10px;
							}
							.right{
								width: 20%;
								height: 100%;
								background-color: purple;
								float: left;
							}
						</style>
					</head>
					<body>		
						<div class="header"></div><!-- 头部div -->
						<div class="content"><!-- 主题内容div -->
							<div class="left"></div><!-- 左侧div -->	
							<div class="center"></div><!-- 中间div -->
							<div class="right"></div><!-- 右侧div -->
						</div>
						<div class="footer"></div><!-- 底部信息div -->
					</body>
		(4)清除浮动:
			属性:clear
			取值:none/left/right/both
		(5)浮动元素对父元素带来的影响(对父元素高度带来影响)			
			1)设置父元素的高度(弊端:必须知道父元素的高度)
			2)设置父元素也浮动(弊端:必须后续元素有影响)
			3)为父元素设置overflow，取值为hidden或auto(弊端:如果有内容要溢出，显示也会被一同隐藏)
			4)在父元素中追加空子级块元素，并设置其clear属性为both/left/right; <div style="clear:both"></div>
			5)清除浮动的例子:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/%E6%B8%85%E9%99%A4%E6%B5%AE%E5%8A%A8.html
				<head>
					<meta charset="UTF-8">
					<title></title>
					<style>
						.box1{
							width: 600px;
							/*height: 200px;很多情况下，父级盒子不方便给高度(父盒子的高度会自适应)，因为子元素高度可能会变。*/
							background-color: pink;	
							overflow: hidden;/*和clear效果相同*/
						}
						.box2{
							width: 600px;
							height: 200px;
							background-color: purple;
						}
						.son1{
							/*若son1和son2是文档流，会使父级盒子高度自适应*/
							/*若不是文档流，则不会撑开父级盒子*/
							width: 150px;
							height: 100px;
							background-color: skyblue;
							float: left;
						}
						.son2{
							width: 150px;
							height: 100px;
							background-color: orange;
							float: left;
						}
						.clear{/*如果son1和son2都浮动了，浮动元素不占有位置，父元素就没有高度，此时底下的盒子box2就会跑上来*/
							clear:both;/*清楚浮动带来的影响，both/left/right/none(默认值)*/
						}
					</style>
				</head>
				<body>
					<div class="box1">
						<div class="son1"></div>
						<div class="son2"></div>
						<!--<div class="clear"></div>--> <!-- 在浮动盒子的后面添加一个空盒子 -->
					</div>
					<div class="box2"></div>
					<div class="box3"></div>
				</body>
		(4)相对定位:https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/%E7%9B%B8%E5%AF%B9%E5%AE%9A%E4%BD%8D.html
			例子:
				<head>
					<meta charset="UTF-8">
					<title></title>
					<style>
						.box1{
							width: 200px;
							height: 200px;
							background-color: red;
						}
						.box2{
							width: 200px;
							height: 200px;
							background-color: yellow;
							/*
							 * 定位:将指定元素拜访到页面的任意位置，通过position属性来设置元素的定位;
							 * 	可选值:static:默认值，元素没有开启定位;		relative:开启元素的相对定位;	absolute:开启元素的绝对定位;
							 * 相对定位:相对定位是相对于元素在文档流中原来的位置进行定位(相对定位的元素不会脱离文档流)。
							 * 相对定位会使元素提高一个层级(box2的黄色会盖住其它的box)，还属于文档流.
							 * 相对定位不会改变元素的性质，块还是块，内联还是内联;浮动会将内联也变成块。
							 */
							position: relative;/*当开启了元素的相对定位以后，而不设置偏移量时，元素不会发生任何变化*/
							/*
							 * 当开启了元素的定位时，可通过left/right/top/bottom四个属性来设置元素的偏移量.
							 * left:元素相对于其定位位置的左侧偏移量。left:200px --> 向右平移200px.
							 * 通常偏移量只需要使用两个(一个水平方向的偏移量和一个垂直方向的偏移量)就可以对一个元素进行定位。
							 */
							left: 100px;
							top:100px;
						}
						.box3{
							width: 200px;
							height: 200px;
							background-color: blue;
							/*position: relative;
							bottom: 200px;*/
						}
						.s1{/*相对定位不会改变元素的性质，块还是块，内联还是内联。*/
							width: 200px;
							height: 200px;
							background-color: pink;
							position: relative;
							left: 100px;
						}
					</style>
				</head>
				<body>
					<span class="s1">span标签</span>
					<div class="box1"></div>
					<div class="box2"></div>
					<div class="box3"></div>
				</body>
		(5)绝对定位: https://github.com/ZichengQu/Java/blob/CSS/Others/CSS_day04/%E7%BB%9D%E5%AF%B9%E5%AE%9A%E4%BD%8D.html
				<head>
					<meta charset="UTF-8">
					<title></title>
					<style >
						.box1{
							width:200px;
							height: 200px;
							background-color: red;
						}
						.box2{
							/*width:200px;*/
							height: 200px;
							background-color: yellow;
							/*
							 * 当position属性值设置为absolute时，则开启了元素的绝对定位;
							 * 绝对定位:
							 * 		1.开启绝对定位，会使元素脱离文档流;会使元素提升一个层级;
							 * 		2.开启绝对定位以后，如果不设置偏移量，则元素的位置不会发生变化;
							 * 		3.绝对定位是相对于离它最近的开启了定位的祖先元素进行定位的(一般情况下，开启了子元素的绝对定位都会同时开启父元素的相对定位)，如果所有的祖先元素都没有开启定位(相对和绝对)，则相对于浏览器窗口进行定位;
							 *      4.绝对定位会改变元素的性质，内联元素变成块元素，块元素的宽度和高度(若不指定)默认都被内容撑开;
							 */		
							position: absolute;
							left:100px;
							top: 100px;
						}
						.box3{
							width:200px;
							height: 200px;
							background-color: blue;
						}
						.box4{
							width:300px;
							height: 300px;
							background-color: orange;
							/*position: relative;*/
						}
						.s1{
							width: 100px;
							height: 100px;
							background-color: yellow;
							position: absolute;
						}
					</style>
				</head>
				<body>
					<span class="s1">span标签</span>
					<div class="box1"></div>
					<div class="box4">
						<div class="box2"></div>
					</div>		
					<div class="box3"></div>
				</body>

Demo:
京东登录页:https://github.com/ZichengQu/Java/tree/CSS/%E4%BA%AC%E4%B8%9C%E7%99%BB%E5%BD%95%E9%A1%B5