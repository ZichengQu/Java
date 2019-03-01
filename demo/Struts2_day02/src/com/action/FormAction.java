package com.action;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FormAction extends ActionSupport implements ServletRequestAware, ModelDriven<User>{
	//1. 第一种: 使用ActionContext获取数据
	@Override
	public String execute() throws Exception {
		//1.1获取ActionContext对象
		ActionContext context = ActionContext.getContext();//这个对象不能通过new来创建，只能用这个静态方法获取ActionContext对象。
		//1.2调用方法得到表单数据; key是表单输入项的name属性值,value是输入值;
		Map<String, Object> map = context.getParameters();
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			//1.3根据key得到value
			Object[] objects = (Object[])map.get(key);//因为输入项里面可能有复选框的情况，所以返回的是数组类型
			System.out.println(Arrays.toString(objects));
		}
		return NONE;
	}
	//2.第二种: 使用ServletActionContext类获取
	public String execute2() throws Exception{
		//2.1使用ServletActionContext获取request对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();//获取response对象
		//2.2调用request里面的方法得到结果获取数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		//4.1原始方法: 封装数据到实体类对象里面
		User user = new User();
		user.setUsername(username);
		user.setPassword(Integer.parseInt(password));
		user.setAddress(address);
		System.out.println(user);
		
		//操作三个域对象
		//1.request
		HttpServletRequest request2 = ServletActionContext.getRequest();
		request2.setAttribute("username", username);
		//2.session
		HttpSession session = request2.getSession();
		session.setAttribute("password", password);
		//3.servletContext
		ServletContext servletContext = ServletActionContext.getServletContext();
		servletContext.setAttribute("address", address);	
		
		return SUCCESS;
	}
	//3.第三种:implements ServletRequestAware获取
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public String execute3() throws Exception{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		System.out.println(username+":"+password+":"+address);
		return NONE;
	}
	
	/*
	 * 4.2属性封装(4.1在2里面)
	 * 4.1在action成员位置定义变量：变量的名称和表单输入项的name属性值一样
	 * 4.2生成变量的set方法
	 */
	private String username;
	private String password;
	private String address;
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String execute4() throws Exception{
		User user = new User();
		user.setUsername(username);
		System.out.println(password);//如果同时使用，只能执行模型驱动封装。因为85/86/87行数据为null;
		user.setPassword(Integer.parseInt(password));
		user.setAddress(address);
		System.out.println(user);
		return NONE;
	}
	
	/*
	 * 5.模型驱动封装：
	 * 5.1使用模型驱动封装方式，可以直接把表单数据封装到实体类对象里面。
	 * 5.2前提要求：表单输入项的name属性值和实体类属性名称一致。
	 * 5.3实现步骤：实现ModelDriven接口，implements ModelDriven<User>;new一个实体类;添加未实现方法getModel,把创建的对象返回;
	 */
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	public String execute5() throws Exception {
		System.out.println(user);
		return NONE;
	}

}
