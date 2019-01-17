Servlet:
1.Tomcat的目录结构:
	(1)bin: 该目录存放的是二进制的可执行文件。
	(2)conf: 存放Tomcat服务器的各种配置文件。可以通过修改server.xml中的配置信息来修改Tomcat服务器的端口号(大约65行).
	(3)lib: 存放Tomcat服务器和所有web应用程序需要访问的jar包。
	(4)logs: 存放Tomcat的日志文件。
	(5)temp: 存放Tomcat的运行时产生的临时文件
	(6)webapps: 当发布web应用程序时，通常把web应用程序的目录及文件放到这个目录。
	(7)work: Tomcat将jsp生成的Servlet源文件和字节码文件放到这个目录下。
2.Servlet定义及主要功能: 
	(1)定义
		Servlet是用java编写的服务器端应用程序，它运行在Servlet容器(比如Tomcat)中;
		Servlet容器负责Servlet和客户端的通信，以及调用Servlet的方法;
		Servlet和客户端的通信采用"请求/响应"的模式。
	(2)主要功能: 交互式的浏览和修改数据。生成动态Web内容。
3.Servlet容器: 运行Servlet、JSP、Filter等软件环境。
4.Servlet快速入门: https://github.com/ZichengQu/Java/tree/JavaWeb/Servlet/Servlet_day01
	(1)创建一个Servlet接口的实现类，重写方法;或直接创建servlet文件(会自动配置web.html里的内容)。
	(2)在web.xml中配置和映射这个Servlet;
		<!-- 配置Servlet -->
		  <servlet>
			<!-- Servlet注册的名字 -->
			<servlet-name>FirstServlet</servlet-name>
			<!-- Servlet的全类名 -->
			<servlet-class>com.servlet.FirstServlet</servlet-class>
			<!-- 指定Servlet被创建的时机 -->
			<load-on-startup>1</load-on-startup>
		  </servlet>
		<!-- 映射Servlet -->
		  <servlet-mapping>
			<servlet-name>FirstServlet</servlet-name>
			<!-- 映射具体的访问路径: /代表当前web应用的根目录 -->
			<url-pattern>/first</url-pattern>
		  </servlet-mapping>
	(3)访问这个页面: http://localhost:8080/Servlet_day01/first
5.Servlet生命周期的方法: 以下方法都是由Servlet容器负责调用。
	(1)构造器(无参): 只被调用一次，默认第一次请求Servlet时，创建Servlet的实例，调用构造器;这说明Servlet是单实例的。
	(2)init()方法: 只被调用一次，在创建好实例后立即调用，用于初始化当前的Servlet。
	(3)service()方法: 可被多次调用，每次请求都会调用service方法，实际用于响应请求(get提交和post提交)的。
	(4)destory()方法: 只被调用一次，在当前Servlet所在的web应用被卸载前调用，用于释放当前Servlet所占用的资源。
6.Servlet的生命周期:
	(1)创建实例: 调用构造器;
	(2)初始化: 调用init()方法;
	(3)响应客户请求: 调用service()方法;
	(4)销毁: 调用destory()方法;
7.load-on-startup参数: 
	可以指定Servlet被创建的时机;若为负数，则在第一次请求时被创建;若为0或正数，则在当前web应用被Servlet容器加载时创建实例，且数值越小越早被创建。
8.Servlet容器响应客户请求的过程:
	(1)Servlet引擎会检查是否已经装载或创建了该Servlet的实例对象;如果是,则直接执行第四步,否则直接执行第二步.
	(2)装载并创建该Servlet的一个实例对象: 调用Servlet的构造器.
	(3)调用Servlet实例对象的init()方法.
	(4)创建一个用于封装请求的ServletRequest对象和一个代表响应的ServletResponse对象;然后调用Servlet的service方法并将请求和响应对象作为参数传递进去.
	(5)WEB应用程序被停止或重新启动之前，Servlet引擎将卸载Servlet，并在卸载之前调用destory()方法.
9.Servlet映射的细节:
	(1)Servlet可以被映射到多个URL上，即多个<servlet-mapping>元素的<servlet-name>子元素的值可以是同一个servlet的注册名。
		  <servlet-mapping>
			<servlet-name>FirstServlet</servlet-name>
			<!-- 映射具体的访问路径: /代表当前web应用的根目录 -->
			<url-pattern>/first</url-pattern>
		  </servlet-mapping>
		  <servlet-mapping>
			<servlet-name>FirstServlet</servlet-name>
			<url-pattern>/first2</url-pattern>
		  </servlet-mapping>
	(2)在Servlet映射的URL中也可以使用*通配符，但是只能使用两种固定格式: 一种是"*.扩展名";另一种是以正斜杠"/"开头并以"/*"结尾，在中间加一些路径。
		  <servlet-mapping>
			<servlet-name>FirstServlet</servlet-name>
			<url-pattern>*.html</url-pattern>
		  </servlet-mapping>
		  <servlet-mapping>
			<servlet-name>FirstServlet</servlet-name>
			<url-pattern>/a/*</url-pattern>									*/
		  </servlet-mapping>
	(3)缺省Servlet: 可以将url-pattern配置一个/，代表该Servlet是缺省的Servlet。当访问资源地址所有的servlet都不匹配，缺省的servlet负责处理。
		  <servlet-mapping>
			<servlet-name>FirstServlet</servlet-name>
			<url-pattern>/</url-pattern>
		  </servlet-mapping>
	(4)WEB应用中所有的资源响应都是servlet负责，包括静态资源(不和数据库进行交互)和动态页面(和数据库进行交互);在前三种方式均找不到的情况下，会去查找WebContent下的html文件。
10.ServletConfig接口: 封装了Servlet的配置信息
	(1)配置了Servlet的初始化参数。
		<!-- 配置Servlet的初始化参数，且该<init-param>节点必须在<load-on-startup>节点的前面 -->
		<init-param>
			<!-- 参数名 -->
			<param-name>username</param-name>
			<!-- 参数值 -->
			<param-value>admin</param-value>
		</init-param>
	(2)获取初始化参数:
		getInitParameter(String name) 根据初始化参数名返回对应的初始化参数值。
	(3)获得Servlet的名字(Servlet注册的名字,不是类名): getServletName();
	(4)获得ServletContext对象: getServletContext();
	(5)当继承的是HttpServlet的时候，通过this.public ServletConfig getServletConfig()(此方法是HttpServlet实现的GenericServlet接口中的方法)获得ServletConfig对象
11.ServletContext接口: 
	(1)定义: 代表一个WEB应用环境(上下文)对象，即一个WEB环境，也就是说ServletContext内部封装了该web应用的信息。因此一个web应用只有一个ServletContext对象，但一个WEB应用中可以有多个servlet对象。
	(2)生命周期:
		创建: 该web应用被加载
		销毁: web应用被卸载(服务器关闭，移除该web应用)
	(3)在自动创建的servlet.java中，使用this.getServletContext();
	(4)作用: 
		1)获得web应用全局的初始化参数
			<!-- 配置当前web应用的初始化参数 -->
			  <context-param>
				<param-name>driver</param-name>
				<param-value>oracle.jdbc.driver.OracleDriver</param-value>
			  </context-param>
		2)获得当前wen应用的初始化参数: String driver = servletContext.getInitParameter("driver");
		3)获得web应用中任何资源的绝对路径: servletContext.getRealPath("相对于该web应用的相对地址");
		4)ServletContext是一个域对象: 存储数据的区域就是域对象。ServletContext域对象的作为范围: 整个web应用(所有的web资源都可以随意向ServletContext域对象中存取数据，数据可以共享)。
			域对象的通用方法:
				setAttribute(String name, Object obj);//存数据
				getAttribute(String name);//取数据
				removeAttribute(String name);//移除数据
12.ServletRequest接口: 封装了请求信息，可以从中获取任何的请求信息。
	(1)获取请求参数:
		public String getParameter(String name);//根据请求的参数的名字，返回参数值。//若请求参数有多个值(例如checkbox)只能获取第一个提交的值
		public String[] getParameterValues(String name);//根据请求的参数的名字，返回请求参数对应的字符串数组。
	(2)获取请求的URI和URL:
		public String getRequestURI();//Servlet_day01/login
		public String getRequestURL();//http://localhost:8080/Servlet_day01/login
	(3)获取请求方式: public String getMethod();
	(4)若是一个GET请求获取请求参数对应的那个字符串，即网址链接中"?"后的那个字符串(键值对的字符串): public String getQueryString();
	(5)获取请求的Servlet的映射路径: public String getServletPath();//	"/"加上mapping中映射的名字。
13.ServletResponse接口: 封装了响应信息，如果想给用户什么响应，具体可以使用该接口的方法实现。
	(1)设置响应的内容类型。public void setContentType(String type);
		response.setContentType("application/msword");//会自动下载文件。这个参数代表word文档，可以使用microsoft word来打开
		response.setContentType("text/html;charset=utf-8");//设置响应内容类型以及编码格式,使服务器和浏览器编码一致，否则中文出现乱码。
	(2)getWriter();返回PrintWriter对象，调用该对象的print()方法，将print()中的参数直接打印到用户的浏览器上。
		PrintWriter writer = response.getWriter();
		writer.print("<h1>welcome</h1>");
	(3)转码: 
		request.setCharacterEncoding("UTF-8");//解决表单post提交中文时的乱码问题。
		String username_u = request.getParameter("username");
		//username_u = new String(username_u.getBytes("iso-8859-1"),"UTF-8");//表单get/post提交中文时，会乱码，用这种方式转码。
		String password_u = request.getParameter("password");
		System.out.println(username+"\n"+username_u+"\n"+password+"\n"+password_u);
		response.setContentType("text/html;charset=utf-8");//解决响应时中文乱码的问题。
		PrintWriter writer = response.getWriter();
	(4) 响应编码：
		response.setContentType("text/html;charset=utf-8");//解决响应时中文乱码的问题。
		请求编码：
			GET请求
				username=new String(username.getByte("iso-8859-1),"UTF-8");
				在server.xml中配置URIEncoding="UTF-8"
			POST请求
				username=new String(username.getByte("iso-8859-1),"UTF-8");
				在获取参数之前调用request.setCharacterEncoding("UTF-8");//解决表单post提交中文时的乱码问题。
14.JavaEE三层结构:
	(1)dao层: 和数据库进行交互;
	(2)service层: 业务逻辑层;
	(3)web层(servlet/jsp): 数据显示;
100.小tips:
	(1)表单form中的action对应的是servlet中的mapping的url的映射,例如:
		<form id="form1" action="Login" method="get">
		<url-pattern>/Login</url-pattern>
	(2)在获取表单数据getParameter()方法中的参数是name而不是id,例如:
		<input id="username" name="username"/>
		request.getParameter("username");