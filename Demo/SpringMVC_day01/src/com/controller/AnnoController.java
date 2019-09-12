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
@SessionAttributes(value = {"msg"})//同时会把存到request域中的msg，再存一份到session域中。
public class AnnoController {
	//5.1	RequestParam使用说明
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(name="name") String newName) {//@RequestParam的第二个参数默认为true，即必须有"name"，newName都不可以，否则报错
		System.out.println("testRequestParam执行了");
		System.out.println("name: "+newName);
		return "success";
	}
	//5.2	RequestBody注解使用说明
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String body) {
		System.out.println("testRequestBody执行了");
		System.out.println("@RequestBody: "+body);//@RequestBody: username=???%E9%8C%A2%E9%8C%A2%E9%8C%A2&age=???
		return "success";
	}
	//5.3	PathVaribale注解使用说明
	@RequestMapping("/testPathVariable/{sid}") 
	public String testPathVariable(@PathVariable("sid") Integer id) {
		System.out.println("testPathVariable执行了");
		System.out.println("@PathVariable: "+id);
		return "success";
	}
	//5.4	RequestHeader注解使用说明
	@RequestMapping("/testRequestHeader") 
	public String testRequestHeader(@RequestHeader(value="Accept",required=false) String header) {
		System.out.println("testRequestHeader执行了");
		System.out.println("@RequestHeader: "+header);
		return "success";
	}
	//5.5	CookieValue注解使用说明
	@RequestMapping("/testCookieValue") 
	public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
		System.out.println("testCookieValue执行了");
		System.out.println("@CookieValue: "+cookieValue);
		return "success";
	}
	//5.6 带有@ModelAttribute的方法会先执行，有无返回值都可以
	//5.6.1	ModelAttribute注解使用说明;有返回值
//	@RequestMapping("/testModelAttribute") 
//	public String testModelAttribute1(User user) {
//		System.out.println("testModelAttribute1执行了");
//		System.out.println("User: "+user);
//		return "success";
//	}
	//5.6.1 有返回值的情况
//	@ModelAttribute
//	public User showUser1(String uname) {
//		System.out.println("showUser1执行了");
//		//通过数据库去查询
//		User user = new User();
//		user.setUname(uname);
//		user.setAge(20);//哪怕这里设置age了，也会以表单输入为主，因为@RequestMapping("/testModelAttribute")对应的方法后运行。
//		user.setDate(new Date());
//		return user;
//	}
	//5.6.2	ModelAttribute注解使用说明;无返回值
	@RequestMapping("/testModelAttribute") 
	public String testModelAttribute2(@ModelAttribute("abc") User user) {
		System.out.println("testModelAttribute2执行了");
		System.out.println("User: "+user);
		return "success";
	}
	//5.6.2 没有返回值的情况
	@ModelAttribute
	public void showUser2(String uname, Map<String, User> map) {
		System.out.println("showUser2执行了");
		//模拟数据库去查询
		User user = new User();
		user.setUname(uname);
		user.setAge(20);//哪怕这里设置age了，也会以表单输入为主，因为@RequestMapping("/testModelAttribute")对应的方法后运行。
		user.setDate(new Date());
		map.put("abc",user);
	}
	/*
	 * 5.7	SessionAttribute注解使用说明
	 * 需要在类名上加此注解，才能存到session域中。
	 */
	//5.7.1 向session域中存值（需要在类名上加此注解，才能存到session域中）
	@RequestMapping("/testSessionAttributes") 
	public String testSessionAttributes(Model model) {
		System.out.println("testSessionAttributes执行了");
		model.addAttribute("msg", "This is SessionAttribute");//会默认存到request域中。
		return "success";
	}
	//5.7.2 从session域中取值
	@RequestMapping("/getSessionAttributes") 
	public String getSessionAttributes(ModelMap modelMap) {
		System.out.println("getSessionAttributes执行了");
		String msg = (String)modelMap.get("msg");
		System.out.println("msg: "+msg);
		return "success";
	}
	//5.7.3从session域中删除值
	@RequestMapping("/delSessionAttributes") 
	public String delSessionAttributes(SessionStatus status) {
		System.out.println("delSessionAttributes执行了");
		status.setComplete();//清空
		return "success";
	}
}
