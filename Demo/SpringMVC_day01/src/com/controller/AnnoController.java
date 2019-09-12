package com.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bean.User;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})//ͬʱ��Ѵ浽request���е�msg���ٴ�һ�ݵ�session���С�
public class AnnoController {
	//5.1	RequestParamʹ��˵��
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(name="name") String newName) {//@RequestParam�ĵڶ�������Ĭ��Ϊtrue����������"name"��newName�������ԣ����򱨴�
		System.out.println("testRequestParamִ����");
		System.out.println("name: "+newName);
		return "success";
	}
	//5.2	RequestBodyע��ʹ��˵��
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body) {
		System.out.println("testRequestBodyִ����");
		System.out.println("@RequestBody: "+body);//@RequestBody: username=???%E9%8C%A2%E9%8C%A2%E9%8C%A2&age=???
		return "success";
	}
	//5.3	PathVaribaleע��ʹ��˵��
	@RequestMapping("/testPathVariable/{sid}") 
	public String testPathVariable(@PathVariable("sid") Integer id) {
		System.out.println("testPathVariableִ����");
		System.out.println("@PathVariable: "+id);
		return "success";
	}
	//5.4	RequestHeaderע��ʹ��˵��
	@RequestMapping("/testRequestHeader") 
	public String testRequestHeader(@RequestHeader(value="Accept",required=false) String header) {
		System.out.println("testRequestHeaderִ����");
		System.out.println("@RequestHeader: "+header);
		return "success";
	}
	//5.5	CookieValueע��ʹ��˵��
	@RequestMapping("/testCookieValue") 
	public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
		System.out.println("testCookieValueִ����");
		System.out.println("@CookieValue: "+cookieValue);
		return "success";
	}
	//5.6 ����@ModelAttribute�ķ�������ִ�У����޷���ֵ������
	//5.6.1	ModelAttributeע��ʹ��˵��;�з���ֵ
//	@RequestMapping("/testModelAttribute") 
//	public String testModelAttribute1(User user) {
//		System.out.println("testModelAttribute1ִ����");
//		System.out.println("User: "+user);
//		return "success";
//	}
	//5.6.1 �з���ֵ�����
//	@ModelAttribute
//	public User showUser1(String uname) {
//		System.out.println("showUser1ִ����");
//		//ͨ�����ݿ�ȥ��ѯ
//		User user = new User();
//		user.setUname(uname);
//		user.setAge(20);//������������age�ˣ�Ҳ���Ա�����Ϊ������Ϊ@RequestMapping("/testModelAttribute")��Ӧ�ķ��������С�
//		user.setDate(new Date());
//		return user;
//	}
	//5.6.2	ModelAttributeע��ʹ��˵��;�޷���ֵ
	@RequestMapping("/testModelAttribute") 
	public String testModelAttribute2(@ModelAttribute("abc") User user) {
		System.out.println("testModelAttribute2ִ����");
		System.out.println("User: "+user);
		return "success";
	}
	//5.6.2 û�з���ֵ�����
	@ModelAttribute
	public void showUser2(String uname, Map<String, User> map) {
		System.out.println("showUser2ִ����");
		//ģ�����ݿ�ȥ��ѯ
		User user = new User();
		user.setUname(uname);
		user.setAge(20);//������������age�ˣ�Ҳ���Ա�����Ϊ������Ϊ@RequestMapping("/testModelAttribute")��Ӧ�ķ��������С�
		user.setDate(new Date());
		map.put("abc",user);
	}
	/*
	 * 5.7	SessionAttributeע��ʹ��˵��
	 * ��Ҫ�������ϼӴ�ע�⣬���ܴ浽session���С�
	 */
	//5.7.1 ��session���д�ֵ����Ҫ�������ϼӴ�ע�⣬���ܴ浽session���У�
	@RequestMapping("/testSessionAttributes") 
	public String testSessionAttributes(Model model) {
		System.out.println("testSessionAttributesִ����");
		model.addAttribute("msg", "This is SessionAttribute");//��Ĭ�ϴ浽request���С�
		return "success";
	}
	//5.7.2 ��session����ȡֵ
	@RequestMapping("/getSessionAttributes") 
	public String getSessionAttributes(ModelMap modelMap) {
		System.out.println("getSessionAttributesִ����");
		String msg = (String)modelMap.get("msg");
		System.out.println("msg: "+msg);
		return "success";
	}
	//5.7.3��session����ɾ��ֵ
	@RequestMapping("/delSessionAttributes") 
	public String delSessionAttributes(SessionStatus status) {
		System.out.println("delSessionAttributesִ����");
		status.setComplete();//���
		return "success";
	}
}
