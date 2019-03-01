package com.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//判断session里面是否有名称是usernmae的值
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object username = session.getAttribute("username");
		if(username!=null) {
			//登陆状态,满足条件 ,做类似于放行的操作,执行action里的方法
			return actionInvocation.invoke();
		}else {
			//不是登陆状态,不执行action里面的方法 ,返回登陆界面,重写登陆
			return "login";//到result标签里面找到name是login的值,然后跳转到相应的配置路径里面
		}
	}

}
