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
	//1. ��һ��: ʹ��ActionContext��ȡ����
	@Override
	public String execute() throws Exception {
		//1.1��ȡActionContext����
		ActionContext context = ActionContext.getContext();//���������ͨ��new��������ֻ���������̬������ȡActionContext����
		//1.2���÷����õ�������; key�Ǳ��������name����ֵ,value������ֵ;
		Map<String, Object> map = context.getParameters();
		Set<String> keySet = map.keySet();
		for(String key:keySet) {
			//1.3����key�õ�value
			Object[] objects = (Object[])map.get(key);//��Ϊ��������������и�ѡ�����������Է��ص�����������
			System.out.println(Arrays.toString(objects));
		}
		return NONE;
	}
	//2.�ڶ���: ʹ��ServletActionContext���ȡ
	public String execute2() throws Exception{
		//2.1ʹ��ServletActionContext��ȡrequest����
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();//��ȡresponse����
		//2.2����request����ķ����õ������ȡ����
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		//4.1ԭʼ����: ��װ���ݵ�ʵ�����������
		User user = new User();
		user.setUsername(username);
		user.setPassword(Integer.parseInt(password));
		user.setAddress(address);
		System.out.println(user);
		
		//�������������
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
	//3.������:implements ServletRequestAware��ȡ
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
	 * 4.2���Է�װ(4.1��2����)
	 * 4.1��action��Աλ�ö�����������������ƺͱ��������name����ֵһ��
	 * 4.2���ɱ�����set����
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
		System.out.println(password);//���ͬʱʹ�ã�ֻ��ִ��ģ��������װ����Ϊ85/86/87������Ϊnull;
		user.setPassword(Integer.parseInt(password));
		user.setAddress(address);
		System.out.println(user);
		return NONE;
	}
	
	/*
	 * 5.ģ��������װ��
	 * 5.1ʹ��ģ��������װ��ʽ������ֱ�Ӱѱ����ݷ�װ��ʵ����������档
	 * 5.2ǰ��Ҫ�󣺱��������name����ֵ��ʵ������������һ�¡�
	 * 5.3ʵ�ֲ��裺ʵ��ModelDriven�ӿڣ�implements ModelDriven<User>;newһ��ʵ����;���δʵ�ַ���getModel,�Ѵ����Ķ��󷵻�;
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
