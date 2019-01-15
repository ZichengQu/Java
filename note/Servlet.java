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
	(1)创建一个Servlet接口的实现类，重写方法;
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
	(3)service()方法: 可被多次调用，每次请求都会调用service方法，实际用于响应请求的。
	(4)destory()方法: 只被调用一次，在当前Servlet所在的web应用被卸载前调用，用于释放当前Servlet所占用的资源。
6.Servlet的生命周期:
	(1)创建实例: 调用构造器;
	(2)初始化: 调用init()方法;
	(3)响应客户请求: 调用service()方法;
	(4)销毁: 调用destory()方法;
7.load-on-startup参数: 
	可以指定Servlet被创建的时机;若为负数，则在第一次请求时被创建;若为0或正数，则在当前web应用被Servlet容器加载时创建实例，且数值越小越早被创建。
