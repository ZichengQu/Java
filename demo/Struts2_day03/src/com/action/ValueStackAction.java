package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		//5.1首先获取ActionContext类的对象
		ActionContext actionContext = ActionContext.getContext();
		//5.2调用方法得到值栈对象
		ValueStack valueStack1 = actionContext.getValueStack();
		//5.3验证每个Action中只有一个值栈对象
		ValueStack valueStack2 = actionContext.getValueStack();
		System.out.println(valueStack1==valueStack2);//true
		return SUCCESS;
	}
	public String execute2() throws Exception {
		//7.1.1首先获取ActionContext类的对象
		ActionContext actionContext = ActionContext.getContext();
		//7.1.2调用方法得到值栈对象
		ValueStack valueStack = actionContext.getValueStack();
		//7.1.3调用set方法,创建map集合
		valueStack.set("username", "admin1");
		//7.2.3调用push方法
		valueStack.push("admin2");
		valueStack.push("admin3");
		return SUCCESS;
	}
	public String execute3() throws Exception {
		//7.2.1首先获取ActionContext类的对象
		ActionContext actionContext = ActionContext.getContext();
		//7.2.2调用方法得到值栈对象
		ValueStack valueStack = actionContext.getValueStack();
		//7.2.3调用push方法
		valueStack.push("admin");
		return SUCCESS;
	}
	//7.3.1定义变量
	private String username;
	//7.3.2生成get方法
	public String getUsername() {
		return username;
	}
	public String execute4() throws Exception {	
		//7.3.3在执行的方法里面给变量赋值
		username = "Jack";
		return SUCCESS;
	}
	
	
}
