JSP: Java Server Pages/Java服务器页面
1.定义: jsp是一种动态网页开发技术，它使用jsp标签在HTML页面中插入java代码。标签通常以<%开头，以%>结束
2.入门: HelloJSP: https://github.com/ZichengQu/Java/tree/JavaWeb/JSP/HelloJSP/WebContent
	(1)创建web项目;
	(2)编辑jsp: 
		位置: 项目/WebContent/
		默认页面字符编码为pageEncoding="iso-8859-1",不识别中文;要识别中文,将其改为"UTF-8";
	(3)部署项目至服务器的webapps/
	(4)启动服务器;
	(5)浏览器运行;
3.jsp执行过程
	(1)客户端发送一个请求;
	(2)WEB容器将jsp翻译成servlet源代码;
	(3)WEB容器将产生的源代码进行编译;
	(4)WEB容器加载编译成字节码文件后，并执行;
	(5)把执行结构响应至客户端;
4.jsp脚本和注释:
	(1)脚本:
		1) <%java代码%> 内部的java代码翻译到service方法的内部;
				<%
					Date date = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
					System.out.println(sdf.format(date));
					int i = 1;
					System.out.println(i);
				%>
		2) <%=java变量或表达式%> 会被翻译成service方法内部的out.print();不能写分号，否则报错;	<%=i+1 %>
		3) <%!java代码%> 声明变量和方法。会被翻译成servlet的成员内容;
				<%!String name="Jack"; %>
				<%!public void add(){
					System.out.println(name);//在声明里写输出语句不起作用。
				}%>
	(2)jsp注释: 不同的注释可见范围是不同的
		1)HTML注释: <!-- 注释内容 -->		可见范围: jsp源码，翻译后的servlet，页面显示html源码
		2)java注释: //单行注释 /*多行注释*/	可见范围: jsp源码，翻译后的servlet
		3)jsp注释: <%--jsp注释 --%>			可见范围: jsp源码
5.jsp的隐式对象:
	request:	HttpServletRequest 接口的实例
	response:	HttpServletResponse 接口的实例
	out:		JspWriter类的实例，用于把结果输出至网页上
	session:	HttpSession类的实例
	application:	ServletContext类的实例，与应用上下文有关
	config:		ServletConfig类的实例
	pageContext:	PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问
	page:		类似于Java类中的this关键字
	Exception:	Exception类的对象，代表发生错误的JSP页面中对应的异常对象
6.jsp指令: jsp指令是指jsp翻译和运行的命令，jsp包括三大指令。
	(1)page指令: 属性最多的指令(实际开发中page指令是默认的)，它会根据不同的属性，指导整个页面特性。
		格式: <%@ page 属性名1="属性值" 属性名2="属性值" ...%>
		常用属性: 
			1)language: jsp脚本可以嵌入的语言种类(jsp只支持java语言，这句话可不写)。
			2)pageEncoding: 当前jsp文件本身的编码;内部包含contentType属性。
			3)contentType: response.setContentType("text/html; charset=UTF-8");//所有的UTF-8的大小写要一致，否则可能报错
			4)import: 导入java的包;
			5)errorPage: 当页面出错后跳转到某一个指定的页面。
			6)isErrorPage: 当前页面是一个处理错误的页面。
				例子: <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
						isErrorPage="true"
			7)
			<!-- 或直接设置web.xml应用的全局的错误页面 -->	
			  <error-page> //网址链接不正确
				<error-code>404</error-code>
				<location>/404.html</location>
			  </error-page>
			 <error-page> //网页出现错误，比如int a = 1/0;
				<error-code>500</error-code>
				<location>/error.jsp</location>
			 </error-page>
			//若404跳转到500的页面，并使用隐式的exception等，会出现空指针异常，因为没有500错误，exception为null。
	(2)include指令: 页面包含(静态包含)指令，可以将一个jsp页面包含到另一个jsp页面中。
		格式: <%@ include file="被包含的文件地址"%>	//<%@include file="/includeDemo.jsp" %>
	(3)tablib指令: 在jsp页面中引入标签库
		格式: <%@ taglib uri="标签库的地址" prefix="标签库的前缀"%>
7.页面跳转与数据传递: 
	(1)超链接: <a href="link"></a>	<a href="main.jsp?id=123&username=管理员">跳转到主页</a> //跳转的时候传递参数，类似于get提交方式,也可以用getParameter获取参数值。
	(2)表单提交: <form action="路径" method="提交方式"></form>
	(3)js跳转: <script>window.location.href="路径";</script>	//window.location.href="login.jsp";//也可以传递参数，但一般不这么用。
	以上是静态页面的跳转，同样适合动态页面(jsp).以下只能在jsp或servlet中使用:
	(4)request.getRequestDispatcher("success.jsp").forward(request,response);//转发
		注意:
			1)在服务器内部跳转，地址栏不发生变化;
			2)这种跳转同时还可以将对象(request/response等)一起传递到另一个jsp;因为服务器地址栏不发生变化;
	(5)response.sendRedirect("error.jsp");//重定向
		注意:
			1)这种跳转发生新的服务器响应，地址栏为新的路径;
			2)当用这种方式跳转时，服务器不能接收request.setAttribute发送的数据;
			3)如果想要接收数据，必须放大权限，将request请求升级为session(jsp隐式对象，可直接使用);
		升级方法:Servlet直接提供的就是request对象，因此只能使用第一种;在jsp中两种都可以用;比session级别更高的或权限更大的范围更广的是application(jsp隐式对象，可跨浏览器公用)。
			1)request.getSession().setAttribute发送数据
			2)session.setAttribute发送数据
	(6)例子: PageJumpAndDataTransfer(页面跳转和数据传递(转发/重定向)): https://github.com/ZichengQu/Java/tree/JavaWeb/JSP/PageJumpAndDataTransfer/WebContent
		默认首页index --> login页面 --> main页面(判断一些验证) --> 跳转到success页面或error页面
		<%
			System.out.println(request);//隐式对象request在直接调用此页面的时候(不经过表单提交等操作)，也不会为null。
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if("admin".equals(username)&&"123456".equals(password)){
				//服务器的隐式请求对象(request)设置属性的方法，参数:(字符串,Object)
				//request..setAttribute("username",username);
				request.getSession().setAttribute("username",username);
				//session.setAttribute("username",username);
				//页面跳转，同时将数据传递到指定页面
				//request.getRequestDispatcher("success.jsp").forward(request,response);//转发
				response.sendRedirect("success.jsp");//重定向
			}else{
				response.sendRedirect("error.jsp");//重定向
			}
			System.out.println(username+"\n"+password);
		%>
		<!--  <h1>欢迎您: <%=request.getAttribute("username") %></h1> -->
		<h1>欢迎您: <%=session.getAttribute("username") %></h1>
8.转发和重定向的区别:
	转发: 一次请求，一次响应; 地址栏的URL不会发生改变，在服务器端执行，所以必须在同一台服务器上; 转发的速度快;
	重定向: 两次请求; 地址栏的URL改变为重定向后的那个URL，在客户端执行，所以可以在不同的服务器上;
9.jsp九大内置对象/隐式对象:
	(1)out: JspWriter对象，调用out.print()可以直接把字符串(可以是html和js等)打印到浏览器上;
	(2)request:	HttpServletRequest接口的实例;向服务器发送请求;
		常用方法: 
			1)服务器的隐式请求对象(request)设置属性的方法: request.setAttribute(String str,Object obj);
			2)获得属性值: request.getAttribute(String str);
			3)跳转: request.getRequestDispatcher("路径").forward(request,response);//转发(url不变): 页面跳转，同时将数据传递到指定页面;
			4)获得来自客户端的Cookie对象: 
				Cookie: 存储到客户端的一个字符串;
				Cookie实例: 保存用户名和密码;
			5)向服务器放大权限(只能放大一级)后发送数据: request.getSession().setAttribute(String str,Object obj);
			6)获取jsp页面的参数，通过参数得到其值: 获取表单提交数据和get方式地址栏参数
				request.getParameter("参数名");
				request.getParameterValues("参数名");
	(3)response: HttpServletResponse接口的实例;响应服务器请求;
		常用方法:
			1)跳转: response.sendRedirect();/*重定向*/ 
				与request跳转不同，request是服务器内部跳转，地址栏内部不发生变化，通过request的属性方法，在另一个jsp页面可以收到来自服务器的数据; response跳转为重新发送请求，地址栏发生变化，通过request的属性方法发送的数据必须放大权限才能在另一个jsp接收到数据。
			2)增加Cookie: response.addCookie();
	(4)session: HttpSession类的实例;会话，浏览器关闭即session关闭，不是关闭其中的某一个页面;
		常用方法: session.setAttribute(String str,Object obj);	session.getAttribute(String str);
	(5)application: ServletContext类的实例，与应用上下文有关;代表当前WEB应用，是ServletContext对象;
		常用方法: application.setAttribute(String str,Object obj);	application.getAttribute(String str);
	(6)pageContext: PageContext类的实例，提供对JSP页面所有对象以及命名空间的访问;
		常用方法: pageContext.setAttribute(String str,Object obj);
	(7)page: 指向当前jsp对应的Servlet对象的引用，但为Object类型，只能调用Object类的方法;类似于Java类中的this关键字;
	(8)config: ServletConfig类的实例;当前ServletConfig对象;
	(9)exception: Exception类的对象，代表发生错误的JSP页面中对应的异常对象,若无错误则exception为null;
10.jsp的四大作用域: https://github.com/ZichengQu/Java/tree/JavaWeb/JSP/FourScopes/WebContent
	(1)pageScope --> pageContext: 当前页面级，解决了当前页面的数据共享问题;获取其它内置对象(已经是内置，可直接获得，不需要用此方法);
	(2)requestScope --> request: 请求级,一次请求的servlet的数据共享;
	(3)sessionScope --> session: 会话级，一个用户的不同请求的数据共享;
	(4)applicationScope --> application: 应用程序级，不同用户的数据共享问题;
		session和application区别的例子: https://github.com/ZichengQu/Java/blob/JavaWeb/JSP/FourScopes/WebContent/countOnline.jsp
			<body>
				<%
					//Integer num = (Integer)session.getAttribute("num");
					Integer num = (Integer)application.getAttribute("num");
					if(num==null||num==0){
						//第一次访问页面
						out.print("欢迎访问乾包网");
						num = 1;
					}else{
						//返回访问值
						out.print("欢迎再次访问");
						num += 1;
					}
					//session.setAttribute("num", num);
					application.setAttribute("num", num);//application是应用级，对于这个应用，数据共享;session是会话级，关闭浏览器或切换浏览器则数据重置;
				%>
				<p>页面访问量为:<%=num %></p>
			</body>
11.EmpManageByServlet(查询/模糊查询/删除/添加，数据库与servlet和jsp的交互): https://github.com/ZichengQu/Java/tree/JavaWeb/JSP/EmpManageByServlet
12.JavaEE的开发模式:
	(1)model1模式:
		技术组成: jsp+javaBean
		弊端: 随着业务复杂性，导致jsp页面比较混乱。
	(2)model2模式:
		技术组成: jsp+servlet+javaBean;
		优点: 开发中使用各个技术擅长的方面;servlet: 擅长处理java业务;jsp: 擅长页面的显示;
		MVC: Model-View-Controller的简称，即模型-视图-控制器;MVC是一种设计模式,它把应用程序分成三个核心模块(M/V/C),它们各自处理自己的任务;
		Model(bean/dao/service): 模型是应用程序的主体部分,模型表示业务数据和业务逻辑;一个模型能为多个视图提供数据;
		View(jsp): 视图是用户看到并与之交互的界面,作用如下:视图向用户显示相关的数据;接受用户的输入;视图不进行任何实际的业务处理;
		Controller(目前是servlet，框架之后会是别的): 控制器接受用户的输入并调用模型和视图去完成用户的需求;控制器接受请求并决定调用哪个模型组件去处理请求，然后决定调用哪个视图来显示模型处理返回的数据;
13.JavaEE三层结构:
	(1)dao层(MyBatis): 和数据库进行交互，JDBC; 
	(2)service层(Spring): 业务逻辑层;
	(3)web层(servlet/jsp)(Structs2): 数据显示;
14.jsp常用7种动作(这里只总结了最常用的5种): https://github.com/ZichengQu/Java/tree/JavaWeb/JSP/JSPAction
	(1)<jsp:userBean>: 相当于实例化一个类;
	(2)<jsp:getProperty>: 相当于获得一个实体类的属性值;
	(3)<jsp:setProperty>: 相当于设置一个实体类的属性值;
	(4)<jsp:include>: 相当于导入一个文件，动态导入;
		静态包含: 同时声明两个相同的对象或变量时，而静态包含((在tomcat的work里产生一个servlet))是先包含后编译，同名对象报异常。
		动态包含: 同时声明两个相同的对象或变量时，动态包含(在tomcat的work里产生两个servlet)成立，它是先编译后包含;
	(5)<jsp:forward>: 相当于请求转发;
	(6)<jsp:param>通过forward传递参数;
	(7)例子:
		<body>//index.jsp
			<jsp:useBean id="stu" class="com.entity.Student"></jsp:useBean>	//相当于Student stu = new Student();
			<%=stu.getName() %>
			<jsp:setProperty property="name" name="stu" value="renameJack"/>	//相当于stu.setName("str");
			<jsp:getProperty property="name" name="stu"/>	//相当于stu.getName();
			<%int num = 1; %> //用来测试静态包含和动态包含的区别
			<%-- <%@include file="foot.jsp" %> --%>	//静态包含
			<jsp:include page="foot.jsp"></jsp:include> //动态包含
			<a href="forward.jsp">直接跳转到指定的页面，通过JSP动作完成</a>
		</body>
		<body>//foot.jsp;页面统一底部
			<%int num = 2; %> //若是静态包含的话，此处不能和index.jsp中的num定义相同的变量名。
			<center>
				<h1>&copy;版权所有2019,联系电话: 123456789</h1>
			</center>
		</body>
		<body>//forward.jsp
			<h1>forward页面</h1>
			<%request.setCharacterEncoding("UTF-8"); %>
			<jsp:forward page="forwardResult.jsp">
				<jsp:param value="用户名的值" name="username"/>
			</jsp:forward>
		</body>
		<body>//forwardResult.jsp
			<h1>forwardResult页面,测试jsp动作forward结果页。</h1>
			<%=request.getParameter("username") %>
		</body>
15.EL表达式: https://github.com/ZichengQu/Java/blob/JavaWeb/JSP/JSPAction/WebContent/el.jsp
	expression language/表达式语言:	$(表达式)
	(1)EL表达式可以嵌入在jsp页面的内部，减少jsp脚本的编写，EL出现的目的是要代替jsp页面中脚本的编写;
	(2)可以从域中取数据: (EL表达式最重要的作用)
		${pageScope.name}
		${requestScope.name}	//${param.paramName}相当于request.getParameter("str");
		${sessionScope.name}
		${applicationScope.name}
		例子:
			<body>
				<%
					request.setAttribute("name", "name_value");//存储字符串
					Student stu1 = new Student();
					stu1.setName("Tom");
					session.setAttribute("stu", stu1);
					
					List<Student> list = new ArrayList<Student>();//存储一个集合
					Student stu2 = new Student("Mary");
					Student stu3 = new Student("Jack");
					list.add(stu1);
					list.add(stu2);
					list.add(stu3);
					application.setAttribute("list", list);
				%>
				request: <%=request.getAttribute("name") %>
				<%Student stu =(Student)session.getAttribute("stu");  %>
				session: <%=stu.getName() %>
				<%list = (List)application.getAttribute("list"); %>
				application: <%=list.get(1).getName() %>
				<br>
				//使用el表达式获得域中的数据
				${ requestScope.name}
				${ sessionScope.stu.name}	//${ sessionScope.stu["name"]}
				${ applicationScope.list[1].name} //name调用的是相应的getName()的方法，不是private的name;若getName0(),则应写list[1].name0
				//全域查找，四个作用域找一遍
				${ name}
				${ stu.name}
				${ list[1].name}
			</body>
	(3)el支持表达式运算
		${1+1 }
		${1>1?true:false }
		<form>
			分数: <input name="score"/> //输入100
			<input type="submit"/>
		</form>
		<!-- el可以进行自动的类型转换 -->
		score: ${param.score +1 }//101	//进行自动非空判断 //<%=request.getParameter("score")==null?"":request.getParameter("score") %>
		score: <%=request.getParameter("score")+1 %>//1001，字符串拼接
	






















