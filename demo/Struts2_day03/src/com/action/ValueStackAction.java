package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction extends ActionSupport{
	@Override
	public String execute() throws Exception {
		//5.1���Ȼ�ȡActionContext��Ķ���
		ActionContext actionContext = ActionContext.getContext();
		//5.2���÷����õ�ֵջ����
		ValueStack valueStack1 = actionContext.getValueStack();
		//5.3��֤ÿ��Action��ֻ��һ��ֵջ����
		ValueStack valueStack2 = actionContext.getValueStack();
		System.out.println(valueStack1==valueStack2);//true
		return SUCCESS;
	}
	public String execute2() throws Exception {
		//7.1.1���Ȼ�ȡActionContext��Ķ���
		ActionContext actionContext = ActionContext.getContext();
		//7.1.2���÷����õ�ֵջ����
		ValueStack valueStack = actionContext.getValueStack();
		//7.1.3����set����,����map����
		valueStack.set("username", "admin1");
		//7.2.3����push����
		valueStack.push("admin2");
		valueStack.push("admin3");
		return SUCCESS;
	}
	public String execute3() throws Exception {
		//7.2.1���Ȼ�ȡActionContext��Ķ���
		ActionContext actionContext = ActionContext.getContext();
		//7.2.2���÷����õ�ֵջ����
		ValueStack valueStack = actionContext.getValueStack();
		//7.2.3����push����
		valueStack.push("admin");
		return SUCCESS;
	}
	//7.3.1�������
	private String username;
	//7.3.2����get����
	public String getUsername() {
		return username;
	}
	public String execute4() throws Exception {	
		//7.3.3��ִ�еķ��������������ֵ
		username = "Jack";
		return SUCCESS;
	}
	
	
}
