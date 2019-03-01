package com.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bean.Customer;
import com.dao.CustomerDao;
import com.dao.impl.CustomerDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import jdk.nashorn.internal.scripts.JO;
import net.sf.json.JSONObject;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer=new Customer();//ģ���������Customer����
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private List<Customer> list = null;
	public List<Customer> getList() {//��ֵջ�ķ�����list�浽ֵջ��
		return list;
	}
	
	private int customer_cid;//���Է�װ��ȡdeleteCustomerʱ��ajax�ύ��id
	public void setCustomer_cid(int customer_cid) {
		this.customer_cid = customer_cid;
	}

	public String add() throws IOException{
		System.out.println(customer);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");//������Ӧ������json���͵�
		CustomerDao cDao=new CustomerDaoImpl();
		JSONObject jsonObject = new JSONObject();
		boolean flag = cDao.add(customer);
		if (flag) {
			//response.getWriter().print("��ӳɹ�");//���Ƿ���ֵ����Ϊtext��д��
			jsonObject.put("msg", "��ӳɹ�");
		}else {
			jsonObject.put("msg", "���ʧ��");
		}
		//response.getWriter().print(jsonObject);//������������
		jsonObject.write(response.getWriter());//��json�ķ����������ݣ�����һ�ַ�����Ч
		return NONE;
	}

	public String query(){
		HttpServletRequest request = ServletActionContext.getRequest();
		CustomerDao cDao=new CustomerDaoImpl();
		list = cDao.query();
		return SUCCESS;
	}

	public String deleteCustomer() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		//response.setContentType("text/html;charset=UTF-8");//���Ƿ���ֵΪtext���͵�����
		response.setContentType("application/json;charset=UTF-8");//������Ӧ������json���͵�
		System.out.println("customer_cid: "+customer_cid);
		CustomerDao cDao=new CustomerDaoImpl();
		JSONObject jsonObject = new JSONObject();
		boolean flag = cDao.deleteCustomer(customer_cid);
		if (flag) {
			//response.getWriter().print("success");//���Ƿ���ֵ����Ϊtext��д��
			list = cDao.query();
			jsonObject.put("msg", "ɾ���ɹ�");
		}else {
			jsonObject.put("msg", "ɾ��ʧ��");
		}
		//response.getWriter().print(jsonObject);//������������
		jsonObject.write(response.getWriter());//��json�ķ����������ݣ�����һ�ַ�����Ч
		return NONE;
	}
	
}
