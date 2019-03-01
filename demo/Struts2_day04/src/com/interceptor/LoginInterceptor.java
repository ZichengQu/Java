package com.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		//�ж�session�����Ƿ���������usernmae��ֵ
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object username = session.getAttribute("username");
		if(username!=null) {
			//��½״̬,�������� ,�������ڷ��еĲ���,ִ��action��ķ���
			return actionInvocation.invoke();
		}else {
			//���ǵ�½״̬,��ִ��action����ķ��� ,���ص�½����,��д��½
			return "login";//��result��ǩ�����ҵ�name��login��ֵ,Ȼ����ת����Ӧ������·������
		}
	}

}
