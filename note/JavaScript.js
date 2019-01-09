一、JavaScript简介:
	JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言，
	最早是在HTML(标准通用标记语言下的一个应用)网页上使用，用来给HTML网页增加动态功能。
二、特点:
	1.是一种解释性脚本语言（代码不进行预编译）。
	2.主要用来向HTML（标准通用标记语言下的一个应用）页面添加交互行为。
	3.可以直接嵌入HTML页面，但写成单独的js文件有利于结构和行为的分离。
	4.跨平台特性，在绝大多数浏览器的支持下，可以在多种平台下运行（如Windows、Linux、Mac、Android、iOS等）。
三、Java和JavaScript的区别:
	1.JavaScript是属于网景公司的产品;Java是sun公司的产品;
	2.JavaScript是基于对象的，Java是面向对象的;
	3.JavaScript只需解析就可以执行，而Java需要先编译成字节码文件，再执行。
	4.JavaScript是弱类型语言，Java是强类型语言(Java中声明变量的时候要明确该变量的数据类型，而JavaScript都是使用关键字var去声明即可)。
四、JS的组成:
	1.ECMAScript(JS的核心):欧洲计算机协会，由ECMA组织指定的js基本语法、语句和函数等。
	2.BOM:浏览器对象模型
	3.DOM:文档对象模型
五、JS编写位置:
	1.可以将js代码编写到标签的onclick属性中，当我们点击按钮时，js代码才会执行。
		<button onclick="alert('点了按钮')">按钮</button>
	2.可以将js代码写在超链接的href属性中，这样当点击超链接时会执行js。
		<a href="javascript:alert('点了链接')">超链接</a>
	3.可以将js代码编写到script标签中。
		<script type="text/javascript">
			alert("警告框")//控制浏览器弹出一个警告框
			document.write("<b><i>可以向body中输出一个内容</i></b>");//让计算机在页面中输出一个内容
			console.log("在控制台出现")//向控制台输出一个内容
		</script>
	4.可以将js代码编写到外部js文件中，然后通过script标签引入。
	  script标签一旦用于引入外部文件了，就不能再编写代码了，即使编写了浏览器也会忽略，如果需要则可以再创建一个新的script标签用于编写内部代码。
		<script type="text/javascript" src="js/script.js" >alert("这个js标签的内部代码不会被执行")</script>
六、基本语法:
	1.js严格区分大小写。
	2.js中每一条语句以分号结尾(如果不写分号，浏览器会自动添加，但是会消耗一些系统资源，而且有些时候，浏览器会加错分号，因此在开发中，分号必须写)。
	3.js会忽略多个空格和换行，因此可以利用空格和换行对代码进行格式化。
七、字面量和变量
	1.字面量:都是一些不可改变的值，都是可以直接使用的，但一般不会直接使用字面量，比如1、2、3、4、5。
	2.变量:可以用来保存自变量，而且变量的值是可以任意改变的。
	3.声明变量:在js中使用关键字var来声明一个变量。 var a = 12345;//声明并赋值。
八、标识符:在js中所有的可以由我们自主命名的都可以称为标识符，例如:变量名、函数名等。
		命名规则:
			1.标识符中可以含有数字,字母,_,$
			2.不能以数字开头
			3.不能使用js中的关键字和保留字
			4.标识符一般采用驼峰命名法(首字母小写，每个单词的开头字母大写，其余字母小写)(js底层保存标识符时实际上采用的是Unicode编码，所以理论上，所有的UTF-8中含有的内容都可以作为标识符，包括中文(var 汉字标识符 = "12345";))
九、数据类型:指的是字面量的类型
		1.在js中一共有六种数据类型:其中String,Number,Boolean,Null,Undefined属于原始数据类型，而Object属于引用数据类型。
			String:字符串
			Number:数值
			Boolean:布尔值
			Null:空值
			Undefined:未定义
			Object:对象
		2.String 字符串:在js中字符串需要使用引号(单双引号都可以)引起来。在字符串中我们可以使用\作为转义字符，当我们表示一些特殊符号时可以使用\进行转义。\" --> "	\' --> '	\\ -->\		\n -->换行		\t -->制表位
			var name = "username: 'Mary'"; 或 var name = "username: \"Mary\"";
		3.Number 数值:在js中所有的数值都是Number，包括整数和浮点数(小数)，
			typeof(变量):可以使用一个运算符typeof来检查数据类型。	var a =123;	a="字符串";	console.log(typeof(a));
			NaN是一个特殊的数字，表示not a number，使用typeof检查一个NaN也会返回一个number; var a = "qqq"*2;//typeof:Number, value:NaN.
			在js中整数的运算基本可以保证精确;如果使用js进行浮点运算，可能得到不精确的结果(0.1+0.2=0.30000000000000004),因此不要使用js进行对精确度要求较高的运算;
		4.Boolean 布尔值:true和false，主要做逻辑判断。
		5.Null 空值:只有一个值，就是Null。null专门用来表示一个为空的对象。typeof(null)返回object。
		6.Undefined 未定义:只有一个值，就是undefined。当声明一个变量，但不给变量赋值时，它的值就是undefined。
十、强制类型转换:指将一个数据类型转换为其它的数据类型。主要是指，将其它的数据类型转换为String,Number,Boolean.
	1.将其它的数据类型转换为String:
		(1)调用被转换数据类型的toString();	var a=123;	var b=a.toString();//该方法不会影响原变量，它会将转换的结果返回。//此时b是String，a还是Number类型。
			注意:null和undefined没有toString()方法，如果调用它们，控制台会报错。
		(2)调用String()函数，并将被转换的数据作为参数传递给String()函数，var a=123; var b=String(a);
			注意:String()函数可以将NaN，null，undefined和Boolean等转换成String。对于Number和Boolean，实际上就是调用的toString()方法，但是对于null和undefined，就不会调用toString(),它会将null和undefined直接转换为"null"，"undefined".
		(3)加或减一个空串:	+""; -"";	//这是一种隐式类型转换。
	2.将其它的数据类型转换为Number:
		(1)使用Number()函数:
			字符串 --> 数字:
				1)如果是纯数字字符串，则直接将其转换为数字:	var a ="123";	a = Number(a);//typeof(a) --> number
				2)如果字符串中有非数字的内容，则转换为NaN: var a ="123abc";	a = Number(a);//typeof(a) --> NaN
				3)如果字符串是一个空串，或者是一个全是空格的字符串，则转换为0: var a ="    ";	a = Number(a);//typeof(a) --> number, value:0.
			布尔 --> 数字:	true --> 1;	false --> 0;
			null --> 数字: 0.
			undefined --> 数字: NaN.
		(2)var a=任意类型-0或*1或/1;	var a="123"-0//会转换为Number:123。原理和Number()函数一样。
		   var a=+任意类型; var a=1+ +"2"+ 3;////会转换为Number:6。原理和Number()函数一样。
		(3)这种方式专门用来应对字符串:如果对非String使用parseInt()或parseFloat()，它会先将其转换为String，然后再转为Number。
			1)parseInt():把一个字符串转换为一个整数。 var a="10.03p3x3";	a=parseInt(a);//typeof:Number,value:10;
				注意:可以将一个字符串中的有效的整数内容(从头开始，遇到非数字内容就停止，第一个为非数字内容则typeof为Number,value为NaN)读取出来，然后转换为Number
			2)parseFloat():把一个字符串转换为一个浮点数。 var a="10.03p3x3";	a=parseFloat(a);//typeof:Number,value:10.03;
				注意:和parseInt()类似，不同的是它可以获得有效的小数。
		(4)将其它的数据类型转换为Boolean(使用Boolean()函数):			
			数字 --> Boolean:除了0和NaN，其余都是true: var a=12345; a=Boolean(a);//typeof:Boolean, value:true.
			字符串 --> Boolean: 除了空串，其余都是true: var a="qqq"; a=Boolean(a);//typeof:Boolean, value:true.
			null和undefined都会转换为false。
			Object也会转换为true。
十一、运算符(操作符):通过运算符可以对一个或多个值进行运算，并获取运算结果。
	1.typeof():用来获取一个值的类型,并会将值以string类型返回。 var a=123; var b=typeof(a);//b的typeof:string.
	2.算数运算符:+-*/%,当对Number或能转换成Number类型的值，进行运算时，会将这些值转换为Number，然后再运算任何值和NaN做运算都得NaN。+-可以转换字符串，-*/%可以转换Number。
	3.一元运算符:只需要操作一个数，+(正号),-(负号);对于非Number类型的，它会先转换为Number，然后再运算，可以对一个其它的数据类型使用+，来将其转换为Number，它的原理和Number()函数一样。
	4.自增++,自减--
	5.逻辑运算符:
		!非:如果对非Boolean值进行运算，则会将其转换为Boolean再取反;可以利用该特点将一个其它数据类型转换为布尔值(两次取反)。
		&&与:短路与
		||或:短路或
		&& || 对于非布尔值的情况:对于非布尔值进行与或运算时，会先将其转换为布尔值，然后再运算，并且返回原值。
			与运算:如果第一个值为true，则返回第二个值;如果第一个值为false，则直接返回第一个值。
			或运算:如果第一个值为true，则返回第一个值;如果第一个值为false，则直接返回第二个值。
	6.赋值运算符:=,+=,-=,*=,/=,%=
	7.关系运算符:通过关系运算符可以比较两个值之间的大小关系，如果关系成立，它会返回true，否则返回false:>,<,>=,<=
		非数值的情况:对于非数值进行比较时，会将其转换为数字，然后再比较。任何值和NaN作比较，都是false。"abc">"ab"和"123"<"5" -->比较的是Unicode码，类似于java的compareTo。
					 如果符号两侧的值都是字符串时不会将其转为数字进行比较。比较字符串时，比较的是字符串的Unicode编码。如果比较的是两个字符串型的数字，可能会得到不可预期的结果。
	8.相等运算符
		(1)相等运算符==:当使用==来比较两个值时，如果值的类型不同，则会自动转换为相同的类型，然后再比较。
						1=="1"-->true;	true=="1"-->true;	null==0-->false; null==undefined-->true; NaN==NaN-->false;
		(2)通过isNaN()函数来判断一个值是否是NaN:如果该值是NaN则返回true，否则返回false。
		(3)不相等 !=:用来判断两个值是否不相等，如果不相等返回true，否则返回false。不相等也会对变量自动进行类型转换，如果转换后相等也返回false。
		(4)全等 ===:用来判断两个值是否全等，它和相等类似，不同的是它不会做自动的类型转换。
		(5)不全等 !==:用来判断两个值是否不全等，和不等类似，不同的是它不会做自动的类型转换。如果两个值类型不同，直接返回true。
	9.条件运算符(三元运算符)
		语法:条件表达式?语句1:语句2
		如果条件表达式的结果是一个非布尔值，会将其转换为布尔值然后再运算。
十二、代码块:在js中使用{}来为语句进行分组，同一个{}中的语句称之为一组语句，它们要么都执行，要么都不执行。
		js中的代码块，只具有分组的作用，没有其它的用途。代码块内部的内容，在外部是完全可以调用的。
		例子:
			<script>
				{
					var a = 123;//外部可调用
					alert("警告框")//控制浏览器弹出一个警告框
					document.write("<b><i>可以向body中输出一个内容</i></b>");//让计算机在页面中输出一个内容
					console.log("在控制台出现")//向控制台输出一个内容
				}
				console.log(a);//外部可以调用代码块中的a。
			</script>
十三、流程控制语句:通过流程控制语句可以控制程序执行流程，使程序可以根据一定的条件来选择执行。
		1.语句分类:
			(1)条件判断语句
			(2)条件分支语句
			(3)循环语句
		2.条件判断语句:使用条件判断语句可以在执行某个语句之前进行判断，如果成立瑷珲执行语句，条件不成立则语句不执行。
			if语句:条件表达式可以不适用Boolean类型的值，其它类型会自动转换。
			例子:
				var year = prompt("input a year:")//可以弹出一个提示框，该提示框会带有一个文本框，并带有括号中的提示。
				if(!isNaN(year)&&year!=null){
					if(year%400==0||(year%100!=0&&year%4==0)){
						console.log(year+"是闰年");
					}else{
						console.log(year+"不是闰年")
					}
				}else{
					console.log("不是年份");
				}
		3.条件分支语句(switch语句)
			语法:
				switch(parseInt(prompt("input a score:")/10)){
					case 10: console.log("level 10"); break;
					case 9: console.log("level 9"); break;
					case 8: console.log("level 8"); break;
					case 7: console.log("level 7"); break;
					case 6: console.log("level 6"); break;
					default: console.log("level fail"); break;
				}
			执行流程:在执行时会一次将case后的表达式的值和switch后的条件表达式的值进行全等比较。若比较结果为true，则从当前case处开始执行语句。
		4.循环语句:通过循环语句可以反复的执行一段代码多次。
			(1)while循环
				语法:while(条件表达式){
					statement...;
					}
			(2)do...while 循环:
				语法:do{
						statement...;
					}while(条件表达式);
			(3)for循环
				语法:for(初始化条件;条件表达式;循环增量){
						statement...;
					}
			(4)99乘法表、1~100以内所有质数，例子:
				<style>//99乘法表
					span{
						width: 80px;
						display: inline-block;
					}
				</style>
				<script>
					for(var i=1;i<=9;i++){
						for(var j=1;j<=i;j++){
							document.write("<span>"+j+"*"+i+"="+j*i+"</span>");
						}
						document.write("<br />")
					}
				</script>
				<script>//1~100以内所有质数
					a:for(var i=2; i<100; i++){
						for(var j=2; j<i/2+1; j++){
							if(i%j==0){
								continue a;
							}
						}
						console.log(i);
					}
				</script>
十四、数组
	1.定义方式(三种):
		第一种: var arr=[1,2,3];
		第二种: 使用内置对象Array， var arr = new Array(5);//定义一个数组，数组的长度是5	arr[0]=1;//赋值
		第三种: var arr = new Array(3,4,5);//定义一个数组,数组里的元素是3，4，5
	2.获取数组长度: 数组名.length;
		数组的长度是可变的，数组可以存放不同数据类型的数据。var arr = new Array(5);		arr[10]=100;//下标10可以大于5		console.log(arr.length);
	3.数组的遍历:
		<script>
			var arr=['a','b','c','d','e'];
			for(var i=0;i<arr.length;i++){
				console.log(arr[i]);
			}
			for( var i in arr){//遍历Object对象的时候可能不对。
				console.log(arr[i]);
			}
		</script
十五、函数:在js里定义函数有三种方式。
	1.定义方式:
		(1)使用一个function关键字
			语法:function 方法名(参数列表里直接写参数名称，不需要写var){
					方法体;
					返回值(根据实际需求);
				}
			例子:
				<script>
					function fun(){//1.无参方法
						alert("fun方法");
					}
					fun();//可以直接在js里调用。
					function add(a,b){//2.有参方法
						var c = a+b;
						alert(a+"+"+b+"="+c);
					}
					add(1,2);
					function addReturn(a,b){//3.有参有返回值方法
						var c = a+b;
						return c;
					}
					alert(addReturn(1,2));
				</script>
		(2)匿名函数:
				语法:var fun = function(参数列表){
						方法体;
						返回值(根据实际需求);
					 }
				例子:
					<script>
						var a = function(a,b){
							alert(a+b);
						}
						a(1,2);//函数也是对象，所以直接给函数对象传参。
						console.log(a);//function (a,b){alert(a+b);}"
						console.log(typeof(a));//function
					</script>
		(3)动态函数:使用js里面的一个内置对象 Function
			语法:var add = new Function("参数列表","方法体和返回值");
			例子:
				<script>
					var cs="x,y";
					var fft="var sum=x+y; return sum;";
					var add = new Function(cs,fft);//也可以直接把参数写进去
					alert(add(1,2));
				</script>
	2.js的全局变量和局部变量
		(1)全局变量:在script标签里定义一个变量，这个变量在页面中js部分都可以使用。
			例子:
				<script>
					var str="全局变量";//在方法外部，在方法内部，在另一个sctipt标签使用。
					alert("方法外部: "+str);
					function fun(){
						alert("方法内部: "+str);
					}
					fun();
				</script>
				<script>
					alert("另一个sctipt: "+str);
				</script>
		(2)局部变量:在方法内部定义一个变量，只能在方法内部使用。代码块中的变量在外界中能够访问。
js对象
	1.js的String对象:
		(1)创建String对象: var str="String对象";	var str=new String("String对象");
		(2)属性(参考API文档):
			length 字符串的长度: var str = " abc ";	console.log(str.length);//5,识别空格
		(3)方法(参考API文档):
			1)与html相关的方法:
				bold() 使用粗体显示字符串。 document.write(str.bold());
				fontcolor() 使用指定的颜色来显示字符串。 document.write(str.fontcolor("Red"));
				fontsize() 使用指定的尺寸(大小)来显示字符串。 document.write(str.fontsize(7));//size 参数必须是从 1 至 7 的数字。
				italics() 使用斜体显示字符串。 document.write(str.italics());
				link() 将字符串显示为链接。 document.write(str.link("http://www.w3school.com.cn"))
			2)与java相似的方法:
				charAt() 返回在指定位置的字符。 document.write(str.charAt(0));//字符串中第一个字符的下标是 0。如果参数 index 不在 0 与 string.length 之间，该方法将返回一个空字符串。
				concat() 连接字符串(并未改变str1的值)。 document.write(str1.concat(str2));
				indexOf() 检索字符串。 indexOf() 方法对大小写敏感！如果要检索的字符串值没有出现，则该方法返回 -1。
										var str="Hello world!";
										document.write(str.indexOf("Hello") + "<br />");//0
										document.write(str.indexOf("World") + "<br />");//-1
										document.write(str.indexOf("world"));//6
				split() 把字符串分割为字符串数组。 stringObject.split(separator,howmany)
					separator 必需。字符串或正则表达式，从该参数指定的地方分割 stringObject。 
					howmany 可选。该参数可指定返回的数组的最大长度。如果设置了该参数，返回的子串不会多于这个参数指定的数组。如果没有设置该参数，整个字符串都会被分割，不考虑它的长度.
										var str="How are you doing today?";
										document.write(str.split(" ") + "<br />");//How,are,you,doing,today?
										document.write(str.split("") + "<br />");//H,o,w, ,a,r,e, ,y,o,u, ,d,o,i,n,g, ,t,o,d,a,y,?
										document.write(str.split(" ",3));//How,are,you
				replace() 替换与正则表达式匹配的子串。 stringObject.replace(regexp/substr,replacement)
										var str="Welcome to Microsoft! ";
										str=str + "We are proud to announce that Microsoft has ";
										str=str + "one of the largest Web Developers sites in the world.";
										document.write(str.replace(/Microsoft/ig, "W3School"));//i是忽略大小写，g是全局匹配(否则只匹配第一个)，m是多行匹配。
				substr() 从起始索引号提取字符串中指定数目的字符。 stringObject.substr(start,length)，length可不写，则默认到结尾。
				substring() 提取字符串中两个指定的索引号之间的字符。 stringObject.substring(start,stop);//[start,stop)
				toLowerCase() 把字符串转换为小写。 stringObject.toLowerCase();
				toUpperCase() 把字符串转换为大写。 stringObject.toUpperCase();
				toString() 返回字符串。 var num=10; var str=num.toString(); <==>  var str=num+"";
	2.js的Array对象:
		属性:length 设置或返回数组中元素的数目。 
		方法:
			concat() 连接两个或更多的数组，并返回结果(并未改变a的值)。 var a=[1,2,3]; var b=["qqq","www"];	document.write(a.concat(4,5));/*1,2,3,4,5*/	document.write(a.concat(b));//1,2,3,qqq,www
			join() 把数组的所有元素放入一个字符串。元素通过指定的分隔符进行分隔。 arrayObject.join(separator),separator可选，不写则默认","
				var arr = new Array(3);	arr[0] = "George";	arr[1] = "John";	arr[2] = "Thomas";	document.write(arr.join("."));//George.John.Thomas
			push() 向数组的末尾添加一个或更多元素，并返回新的长度。 
				document.write(arr + "<br />");//George,John,Thomas
				document.write(arr.push("James") + "<br />");//4	//如果push的是另一个数组，那这一整个数组就只占一个元素。
				document.write(arr);//George,John,Thomas,James
			pop() 删除并返回数组的最后一个元素。document.write(arr.pop());
			shift() 删除并返回数组的第一个元素。
			reverse() 颠倒数组中元素的顺序(会改变arr本身，使其变为倒序)。 var arr = new Array["George","John","Thomas"];	document.write(arr.reverse());//Thomas,John,George
			sort() 对数组的元素进行排序。若不写参数则类似于java的compareTo进行排序。
				function sortNumber(a,b)
				{
					return a - b;
				}
				var arr = new Array(6);
				arr[0] = "10";arr[1] = "5";arr[2] = "40";arr[3] = "25";arr[4] = "1000";arr[5] = "1"
				document.write(arr + "<br />");document.write(arr.sort(sortNumber));
			splice() 删除元素，并向数组添加新元素。 arrayObject.splice(index,howmany,item1,.....,itemX);
				index 必需。整数，规定添加/删除项目的位置，使用负数可从数组结尾处规定位置。 
				howmany 必需。要删除的项目数量。如果设置为 0，则不会删除项目。 
				item1, ..., itemX 可选。向数组添加的新项目。 
				var arr = new Array(6);arr[0] = "George";arr[1] = "John";arr[2] = "Thomas";arr[3] = "James";arr[4] = "Adrew";arr[5] = "Martin";
				document.write(arr + "<br />");//George,John,Thomas,James,Adrew,Martin
				arr.splice(2,3,"William","qqq");//George,John,William,Martin,qqq
				document.write(arr);
	3.js的Date对象:
		Date() 返回当日的日期和时间。 var date=new Date()/new Date("July 21, 1983 01:15:00");
		toLocaleString() 根据本地时间格式，把 Date 对象转换为字符串。
		getFullYear() 从 Date 对象以四位数字返回年份。 //getYear()不推荐使用
		getMonth() 从 Date 对象返回月份 (0 ~ 11)。 //和真实月份之间差1
		getDay() 从 Date 对象返回一周中的某一天 (0 ~ 6)。 //星期日是0，其它的对应1~6.
		getDate() 从 Date 对象返回一个月中的某一天 (1 ~ 31)。 
		getHours() 返回 Date 对象的小时 (0 ~ 23)。 
		getMinutes() 返回 Date 对象的分钟 (0 ~ 59)。 
		getSeconds() 返回 Date 对象的秒数 (0 ~ 59)。 
		getMilliseconds() 返回 Date 对象的毫秒(0 ~ 999)。 
		getTime() 返回 1970 年 1 月 1 日至今的毫秒数。
	4.js的Math对象:
		数学的运算:都是静态的方法，可以直接使用Math.方法();
		ceil(x) 对数进行上舍入。 var a=5.5; document.write(Math.ceil(a));/*6*/	document.ceil(a);/*5.5*/
		floor(x) 对数进行下舍入。 
		round(x) 把数四舍五入为最接近的整数。 
		random() 返回 0 ~ 1 之间的随机数。 Math.floor(Math.random()*10) //0~9的随机整数。
	5.js的全局函数:由于不属于任何对象，直接写名称使用。
		eval() 函数可计算某个字符串，并执行其中的的 JavaScript 代码(该方法只接受原始字符串作为参数，如果 string 参数不是原始字符串，那么该方法将不作任何改变地返回。因此请不要为 eval() 函数传递 String 对象来作为参数。)。
			eval("alert('qqq')"); document.write(eval("5+5"));
		isNaN() 检查某个值是否是数字。 document.write(isNaN(123));
		parseFloat() 解析一个字符串并返回一个浮点数。 document.write(parseFloat("34 45 66")) //34
		parseInt() 解析一个字符串并返回一个整数。
	6.js的函数重载:
		java函数重载定义:方法名相同，返回值无关，参数列表不同。
		js的函数重载不存在，但是可以通过其它方式模拟重载。
		把传递到的参数保存到argument数组中。
		例子:
			function add(){
				var sum=0;
				for(var i=0;i<arguments.length;i++){
					sum+=arguments[i];
				}
				return sum;
			}			
			document.write(add(1,2));
			document.write(add(1,2,3));
			document.write(add(1,2,3,4,5,6,7,8,9));
	7.js的BOM对象:浏览器对象模型
		1.navigator:包含有关浏览器的信息。
			appName 返回浏览器的名称。 document.write(navigator.appName);
		2.screen:包含有关客户端显示屏幕的信息。
			height 返回显示屏幕的高度,以像素计。document.write(screen.height); 
			width 返回显示器屏幕的宽度,以像素计。 
		3.location:包含有关当前 URL 的信息。
			href 设置或返回完整的 URL。 document.write(location.href);/*输出当前地址*/	<button onclick="location.href='https://www.baidu.com'">百度</button>	<button onclick="location.href='index.html'">本地文件</button>
		4.history:包含用户（在浏览器窗口中）访问过的 URL。
			length 返回浏览器历史列表中的 URL 数量。 
			back() 加载 history 列表中的前一个 URL。 <input type="button" onclick="history.back()" value="back" /> 
			forward() 加载 history 列表中的下一个 URL。 <input type="button" onclick="history.forward()" value="next" /> 
			go() 加载 history 列表中的某个具体页面。 <input type="button" onclick="history.go(-1)" value="back" />	<input type="button" onclick="history.go(1)" value="next" />
		5.window: 表示浏览器中打开的窗口。顶层对象(所有的bom对象都是在window里面操作的)。
			alert() 显示带有一段消息和一个确认按钮的警告框。 
			prompt() 显示可提示用户输入的对话框。 prompt(text,defaultText);/*两个参数都可以不写*/	var name=prompt("Please enter your name","");
			confirm() 显示带有一段消息以及确认按钮和取消按钮的对话框。 
				confirm(message);/*message 要在 window 上弹出的对话框中显示的纯文本（而非 HTML 文本） */	 
				var r=confirm("Press a button");//value r: true or false.
				例子:
					<head>
						<meta charset="UTF-8">
						<title></title>
						<script>
							function del(){
								if(confirm("确认删除吗？")){
									alert("成功");
								}else{
									alert("失败");
								}			
							}
						</script>
					</head>
					<body>
						<button onclick="del()">删除按钮</button>
						<button onclick=" return del()">删除按钮</button>
					</body>
			blur() 把键盘焦点从顶层窗口移开。 
			open() 打开一个新的浏览器窗口或查找一个已命名的窗口。window.open(URL,name,features,replace);
				function open_win() 
				{
					window.open("http://www.w3school.com.cn","","width=200,height=100");
				}
				<input type=button value="Open Window" onclick="open_win()" />
			close() 关闭浏览器窗口。 <button onclick="window.close()">关闭</button> //最好向open那样写
			setInterval() 按照指定的周期（以毫秒计）来调用函数或计算表达式。
				setInterval(code,millisec[,"lang"]); /*code 必需。要调用的函数或要执行的代码串。 millisec 必须。周期性执行或调用 code 之间的时间间隔，以毫秒计。*/
				setInterval("alert('周期定时器')",1000); 
			setTimeout() 在指定的毫秒数后调用函数或计算表达式，只会执行一次。setTimeout("alert('周期定时器')",1000);
			clearInterval() 取消由 setInterval() 设置的 timeout。
			clearTimeout() 取消由 setTimeout() 方法设置的 timeout。
				例子:
					var id1 = setInterval("alert('周期定时器')",3000); 
					var id2 = setTimeout("alert('周期定时器')",3000);
					<button onclick="clearInterval(id1)">停止周期</button>
					<button onclick="clearTimeout(id2)">停止一次</button>
	8.js的正则表达式: API及https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day04/%E6%AD%A3%E5%88%99%E8%A1%A8%E8%BE%BE%E5%BC%8F.html
		[]-------表示一个位置，如果该位置上只有一种可能，可以忽略不写
		()-------表示一个组合（至少是两位，并且是连续的）
		{}-------用来定义字符串长度的范围
		i 执行对大小写不敏感的匹配。 
		g 执行全局匹配（查找所有匹配而非在找到第一个匹配后停止）。 
		m 执行多行匹配。 
		[abc] 查找方括号之间的任何字符。 
		[^abc] 查找任何不在方括号之间的字符。 
		[0-9] 查找任何从 0 至 9 的数字。 
		[a-z] 查找任何从小写 a 到小写 z 的字符。 
		[A-Z] 查找任何从大写 A 到大写 Z 的字符。 
		[A-z] 查找任何从大写 A 到小写 z 的字符。 
		[adgk] 查找给定集合内的任何字符。 
		[^adgk] 查找给定集合外的任何字符。 
		(red|blue|green) 查找任何指定的选项。 
		. 查找单个字符，除了换行和行结束符。 
		\. 查找 .
		\w 查找单词字符。 匹配字母、数字和下划线
		\W 查找非单词字符。 
		\d 查找数字。 
		\D 查找非数字字符。 
		\s 查找空白字符。 
		\S 查找非空白字符。 
		\b 匹配单词边界。 
		\B 匹配非单词边界。 
		\0 查找 NUL 字符。 
		\n 查找换行符。 
		\f 查找换页符。 
		\r 查找回车符。 
		\t 查找制表符。 
		\v 查找垂直制表符。 
		\xxx 查找以八进制数 xxx 规定的字符。 
		\xdd 查找以十六进制数 dd 规定的字符。 
		\uxxxx 查找以十六进制数 xxxx 规定的 Unicode 字符。 
		n+ 匹配任何包含至少一个 n 的字符串。 
		n* 匹配任何包含零个或多个 n 的字符串。 
		n? 匹配任何包含零个或一个 n 的字符串。 
		n{X} 匹配包含 X 个 n 的序列的字符串。 
		n{X,Y} 匹配包含 X 至 Y 个 n 的序列的字符串。 
		n{X,} 匹配包含至少 X 个 n 的序列的字符串。 
		n$ 匹配任何结尾为 n 的字符串。 
		^n 匹配任何开头为 n 的字符串。 
		?=n 匹配任何其后紧接指定字符串 n 的字符串。 
		?!n 匹配任何其后没有紧接指定字符串 n 的字符串。 
		test: RegExp的对象方法，检索字符串中指定的值。返回 true 或 false。 
		search: String对象的方法，检索与正则表达式相匹配的值。
		match: String对象的方法，找到一个或多个正则表达式的匹配
		replace: String对象的方法，替换与正则表达式匹配的子串。	用空串替换空格。
		split: String对象的方法，把字符串分割为字符串数组。
	9.js的DOM:文档对象模型
		文档:超文本标记(超文本标记文档) html、xml;
		对象:提供了属性和方法;
		模型:使用属性和方法操作超文本标记文档;
		可以使用js的dom里面提供的对象，使用这些对象的属性和方法，对标记型文档进行操作。想要对标记型文档进行操作，首先需要对标记型文档里面的所有内容封装成对象。
			需要把html里面的标签、属性、文本内容都封装成对象进行操作。
		想要对标记型文档进行操作，解析标记型文档
			画图分析，如何使用DOM解析html。
			解析过程:
				根据html的层级结构，在内存中分配一个树形结构，需要把html中每部分封装成对象。
				document对象: 整个文档
				element对象(标签对象，元素对象):要操作element对象。首先需要获取到element，使用document相应的方法获取;然后再用element进行相应的操作。
				属性对象:
				文本:
				Node节点对象: 这个对象是这些对象的父对象。如果在对象里面找不到想要的方法，这个时候到Node里面去找。
		(1)Document对象: 每个载入浏览器的HTML文档都会称为Document对象。
			dom解析html.png: https://github.com/ZichengQu/Java/blob/JavaScript/Others/dom%E8%A7%A3%E6%9E%90html.png
			常用方法：https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day04/Document%E5%AF%B9%E8%B1%A1.html
				write() 向文档写 HTML 表达式 或 JavaScript 代码。
				getElementById() 返回对拥有指定 id 的第一个对象的引用。
						<input id="name" name="username" value="这是id为name的value(改之前)。"/>
						var username = document.getElementById("name");//通过id得到元素。
						alert(username.value);//得到input里面的value的值。username.id/username.name/username.value
						username.value="这是id为name的value(改之后)。";
				getElementsByName() 返回带有指定名称的对象集合(数组)。 
						<input id="input1" type="checkbox" value="吃饭" name="hobby"/><label for="input1">吃饭</label>
						<input id="input2" type="checkbox" value="篮球" name="hobby"/><label for="input2">篮球</label>
						<input id="input3" type="checkbox" value="足球" name="hobby"/><label for="input3">足球</label>
						var inputs1 = document.getElementsByName("hobby");//使用getElementsByName得到input标签
						for(var i=0;i<inputs1.length;i++){//遍历inputs数组,得到标签里面具体的值。
							var hobby=inputs1[i];
							console.log(hobby.value);
						}
				getElementsByTagName() 返回带有指定标签名的对象集合。
						var inputs2 = document.getElementsByTagName("input");
						console.log(inputs2.length);
				注意: 使用getElementsByName()和getElementsByTagName()返回的是一个数组，若此数组的length是1，这个时候不需要遍历，而是可以直接通过数组的下标获取到值。
			1)window弹窗练习:
				https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day04/window%E5%BC%B9%E7%AA%97%E7%BB%83%E4%B9%A0.html
				https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day04/user.html
				实现过程:
					a.创建一个页面，有两个输入项和一个按钮;按钮上面有一个事件，弹出一个新窗口open();
					b.创建弹出表格，每一行有一个按钮、编号和姓名;按钮上有一个事件，把当前的编号和姓名赋值到第一个页面相应的两个输入项中;
						window.opener;//需要跨页面操作，opener 返回对创建此窗口的窗口的引用。 
			2)标题栏滚动演示练习(一个字一个字往外蹦，不是左右滚动):https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day04/window%E5%BC%B9%E7%AA%97%E7%BB%83%E4%B9%A0.html
		(2)js的事件:
			onabort 图像加载被中断
			onblur 元素失去焦点
			onchange 用户改变域的内容
			onclick 鼠标点击某个对象
			ondblclick 鼠标双击某个对象
			onerror 当加载文档或图像时发生某个错误
			onfocus 元素获得焦点
			onkeydown 某个键盘的键被按下
			onkeypress 某个键盘的键被按下或按住
			onkeyup 某个键盘的键被松开
			onload 某个页面或图像被完成加载
			onmousedown 某个鼠标按键被按下
			onmousemove 鼠标被移动
			onmouseout 鼠标从某元素移开
			onmouseover 鼠标被移到某元素之上
			onmouseup 某个鼠标按键被松开
			onreset 重置按钮被点击
			onresize 窗口或框架被调整尺寸
			onselect 文本被选定
			onsubmit 提交按钮被点击 
			onunload 用户退出页面 
			js的隐藏事件例子:https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/index.html
				<head>
					<meta charset="utf-8" />
					<title></title>
					<style>
						.box1{
							width: 100px;
							height: 100px;
							background-color: yellow;
							visibility: hidden;
						}
					</style>
					<script>
						function show(){
							var d = document.getElementById("d");
							d.style.visibility="visible";
						}
						function hide(){
							var d = document.getElementById("d");
							d.style.visibility="hidden";
						}
					</script>
				</head>
				<body>
					<div id="d" class="box1"></div>
					<a onmouseover="show()" onmouseout="hide()">显示隐藏</a>
				</body>
		(3)元素对象(element对象，标签对象):要操作element对象。首先需要获取到element，使用document相应的方法获取;然后再用element进行相应的操作。
			链接:https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/element%E5%AF%B9%E8%B1%A1.html
			方法:
				element.getAttribute("属性名称") 返回元素节点的指定属性值。 
				element.setAttribute("属性名称","属性值") 把指定属性设置或更改为指定值。 
				element.removeAttribute("属性名称") 从元素中移除指定属性。不能删除value，其它都可以删除。 //Chrome能删掉value，IE不会删value
					例子：
						<body>
							<input type="text" value="默认的value" id="text" onblur="fun()" class="in"/>
							<script>
								function fun(){
									var input = document.getElementById("text");
									input.setAttribute("class","ulul")
									console.log(input.getAttribute("value"));//默认的value
									input.removeAttribute("value");//Chrome能删掉value，IE不会删value
									console.log(input.getAttribute("value"));//null
								}			
							</script>
						</body>
				element.childNodes 返回元素子节点的 NodeList。 //不推荐使用,因为这个属性的兼容性很差，会包含空格和换行符结点
				element.getElementsByTagName("标签名称") 返回拥有指定标签名的所有子元素的集合。 
					例子:
						<ul id="uid" name="1234" class="ul">
							<li>Number1</li>
							<li>Number2</li>
							<li>Number3</li>
							<li>Number4</li>
						</ul>
						var ul = document.getElementById("uid");
						var arr = ul.childNodes;			
						console.log(arr.length);//4个标签+5个换行(空格)=9
						arr = ul.getElementsByTagName("li");
						console.log(arr.length);//4
		(4)Node对象属性及方法:使用DOM解析html的时候，需要将html里面的标签属性和文本都封装成对象。
			1)Node对象的属性一:
				nodeName/nodeType/nodeValue
				标签节点对应的值:
					nodeName:大写的标签名
					nodeType:1
					nodeValue:null
				属性节点对应的值:
					nodeName:属性名称
					nodeType:2
					nodeValue:属性的值
				文本节点对应的值:
					nodeName:#text
					nodeType:3
					nodeValue:文本内容
				例子:Node对象属性: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/Node%E5%AF%B9%E8%B1%A1%E5%B1%9E%E6%80%A7.html
					<body>
						<span id="sid" >span文本</span>
						<script>
							var span = document.getElementById("sid");
							//获得标签对象
							console.log(span.nodeName);//SPAN
							console.log(span.nodeType);//1
							console.log(span.nodeValue);//null
							//获得属性对象
							var id = span.getAttributeNode("id");
							console.log(id);//[object Attr]
							console.log(id.nodeName);//id
							console.log(id.nodeType);//2
							console.log(id.nodeValue);//sid
							//获取文本
							var text = span.firstChild;
							console.log(text);//[object Text]
							console.log(text.nodeName);//#text
							console.log(text.nodeType);//3
							console.log(text.nodeValue);//span文本
						</script>
					</body>
			2)Node对象的属性二: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/Node%E5%AF%B9%E8%B1%A1%E7%9A%84%E5%B1%9E%E6%80%A7%E4%BA%8C.html
				父节点:ul是li的父节点; parentNode
				子节点:li是ul的子节点; childNodes,firstChild,lastChild
				同辈节点:li之间的关系是同辈节点。element.previousSibling  element.nextSibling
				例子:
					<body>
						<ul id="uid">
							<li id="n1">Number1</li>
							<li id="n2">Number2</li>
							<li id="n3">Number3</li>
							<li id="n4">Number4</li>
						</ul>
						<script>
							//获取父节点
							var n1 = document.getElementById("n1");//得到id为n1的li
							var ul1 = n1.parentNode;//得到li的父节点ul
							console.log(ul1.id);//uid
							//获取ul的第一个和最后一个子节点
							var ul2 = document.getElementById("uid");
							var firstLi = ul2.firstChild;//会得到空格节点(因为第一个是空格节点)
							var lastLi = ul2.lastChild;//会得到空格节点(因为最后一个还是空格)
							var li = ul2.getElementsByTagName("li");
							console.log(li[0].id);//n1
						</script>
					</body>	
			3)操作DOM树:
				在末尾添加节点，例子: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/%E5%9C%A8%E6%9C%AB%E5%B0%BE%E6%B7%BB%E5%8A%A0%E8%8A%82%E7%82%B9.html
				element.appendChild(newnode) 向元素添加新的子节点，作为最后一个子节点。类似于剪切粘贴的效果。
					例子:appendChild方法: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/appendChild%E6%96%B9%E6%B3%95.html
				element.insertBefore(newItem,existingItem) 在指定的已有的子节点之前插入新节点。
				element.removeChild(oldnode) 从元素中移除子节点。 
				element.replaceChild(newnode,oldnode) 替换元素中的子节点。
					例子: 以上几个节点操作: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/%E8%8A%82%E7%82%B9%E6%93%8D%E4%BD%9C.html
			4)操作DOM总结:
				获取节点的方法:
					getElementById() 通过节点的id属性，查找对应的节点
					getElementsByName() 通过节点的name属性，查找对应的节点，返回节点集合。
					getElementsByTagName() 通过节点的名称，查找对应的节点，返回节点集合。
				插入节点的方法:
					insertBefore() 在某个节点之前插入
					appendChild() 在末尾添加，有剪切粘贴的效果
				删除节点: removeChild() 通过父节点删除
				替换节点: replaceChild() 通过父节点替换
			5)element.innerHTML 设置或返回元素的内容。 (不是dom的组成部分，但是大多数浏览器都支持)
				作用: 获取文本内容;向标签里面设置内容，可以是html代码。
				例子:
					<body>
						<span id="sid"><b>span文本</b></span>
						<script>
							var span = document.getElementById("sid");
							//innerHTML能识别标签，innerText只识别文本。
							console.log(span.innerHTML);//<b>span文本</b>
							console.log(span.innerText);//span文本
							span.innerHTML = "<b>加粗的span文本</b>";//加粗的span文本(加粗的)
							span.innerText = "<b>加粗的span文本</b>";//<b>加粗的span文本</b>
						</script>
					</body>
	10.动态显示时间: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/%E5%8A%A8%E6%80%81%E6%98%BE%E7%A4%BA%E6%97%B6%E9%97%B4.html
		得到当前时间: var date = new Date();	date = date.toLocaleString();
		页面每秒均获取当前时间: setInterval() 定时器
		显示在页面上: 每秒向div里面写一次时间，使用innerHTML/innerText修改值。
	11.全选: https://github.com/ZichengQu/Java/blob/JavaScript/Others/JS_day05/%E5%85%A8%E9%80%89.html
补充:
	区分 点操作符+属性名 和 getAttribute()
	在用DOM操作控制HTML时，很多初学者会把 点操作符+属性名 与getAttribute("属性名") 混淆，误以为这两种方法是等价的。
	实际上，
	通过getAttribute("属性名")和setAttribute("属性名","属性值") 可以获取或修改标签上的属性值
	通过 点操作符+属性名 可以获取或修改元素对应的DOM对象的属性值
	这两种方法并不相同，不可混为一谈
	举个栗子：
	HTML代码：
	<p id="name" align="left" title="名字" test="测试">妙音天女</p>
	JS代码：
		var myname=document.getElementById("name");//myname是HTMLParagraphElement类型的DOM对象

		console.log(myname.title);//名字 //HTMLParagraphElement具有title属性（继承自父类HTMLElement）
		console.log(myname.getAttribute("title"));//名字 //p标签具有title属性（html标签的全局属性）

		console.log(myname.align);//left //HTMLParagraphElement具有align属性
		console.log(myname.getAttribute("align"));//left //p标签具有align属性

		console.log(myname.test);//undefined//HTMLParagraphElement类型的myname对象没有test属性
		console.log(myname.getAttribute("test"));//测试 //此处的p标签具有自定义的test属性

		console.log(myname.innerHTML);//妙音天女 //HTMLParagraphElement具有innerHTML属性（继承自祖父类Element)
		console.log(myname.getAttribute("innerHTML"));//null //p标签没有innerHTML属性

		myname.hi="hello";
		console.log(myname.hi);//hello //myname对象具有hi属性
		console.log(myname.getAttribute("hi"));//null //p标签没有hi属性
	我们可以清晰地看到，
	对于HTML标签和相应的DOM对象都具有的属性（如例子中的title属性和align属性），两种方法取得的值是相同的
	对于HTML标签具有而DOM对象不具有的属性（通常是标签上的自定义属性，如例子中的test属性，或data-* 属性），getAttribute()可以取得相应的属性值，但点操作符返回undefined
	对于DOM对象具有而HTML标签不具有的属性（如例子中的innerHTML和对象上自定义的hi属性），点操作符可以取得相应的属性值，但getAttribute()返回null
	注：p标签对应的DOM类型是HTMLParagraphElement，其父类型是HTMLElement，详见我的另一篇博客：HTMLElement
		