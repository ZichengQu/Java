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
	private Customer customer=new Customer();//模型驱动获得Customer对象
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private List<Customer> list = null;
	public List<Customer> getList() {//用值栈的方法将list存到值栈里
		return list;
	}
	
	private int customer_cid;//属性封装获取deleteCustomer时在ajax提交的id
	public void setCustomer_cid(int customer_cid) {
		this.customer_cid = customer_cid;
	}

	public String add() throws IOException{
		System.out.println(customer);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");//设置响应内容是json类型的
		CustomerDao cDao=new CustomerDaoImpl();
		JSONObject jsonObject = new JSONObject();
		boolean flag = cDao.add(customer);
		if (flag) {
			//response.getWriter().print("添加成功");//这是返回值类型为text的写法
			jsonObject.put("msg", "添加成功");
		}else {
			jsonObject.put("msg", "添加失败");
		}
		//response.getWriter().print(jsonObject);//用流返回数据
		jsonObject.write(response.getWriter());//用json的方法返回数据，与上一种方法等效
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
		//response.setContentType("text/html;charset=UTF-8");//这是返回值为text类型的设置
		response.setContentType("application/json;charset=UTF-8");//设置响应内容是json类型的
		System.out.println("customer_cid: "+customer_cid);
		CustomerDao cDao=new CustomerDaoImpl();
		JSONObject jsonObject = new JSONObject();
		boolean flag = cDao.deleteCustomer(customer_cid);
		if (flag) {
			//response.getWriter().print("success");//这是返回值类型为text的写法
			list = cDao.query();
			jsonObject.put("msg", "删除成功");
		}else {
			jsonObject.put("msg", "删除失败");
		}
		//response.getWriter().print(jsonObject);//用流返回数据
		jsonObject.write(response.getWriter());//用json的方法返回数据，与上一种方法等效
		return NONE;
	}
	
}
