package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//6.1	返回字符串
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了");
        User user = new User();
        user.setUsername("测试testString");
        user.setPassword("123");
        user.setAge(30);
        //model往request域中存数据
        model.addAttribute("user",user);
        return "success";
    }

    //6.2	返回值是void
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了");
        //转发
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);//使用请求转发不能使用视图解析器，因此路径要写全

        //重定向
        //response.sendRedirect(request.getContextPath()+"/index.jsp");//不能写 /WEB-INF/pages/***.jsp;因为请求不到这个路径，会404

        //设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //直接进行响应
        response.getWriter().print("直接响应");

        return;
    }

    //6.3	返回值是ModelAndView对象
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了");
        User user = new User();
        user.setUsername("一一一");
        user.setPassword("456");
        user.setAge(30);

        //把user对象存到mv对象中，同时ModelAndView也可以直接将键值对存入request域，因为其底层就是实现了Model接口。
        mv.addObject("user",user);

        //跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    //6.4	使用关键字转发或重定向
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了");

        //转发
        //return "forward:/WEB-INF/pages/success.jsp";//使用请求转发不能使用视图解析器，因此路径要写全

        //重定向
        return "redirect:/index.jsp";//不能写 /WEB-INF/pages/***.jsp;因为请求不到这个路径，会404
    }

    /*
     * 6.5	ResponseBody响应json数据
     * @RequestBody String body；通过body能够直接获取json的字符串；
     * @RequestBody User user；需要引入3个jar包；
     * json中的属性必须和实体类的属性保持一致，否则无法封装到实体类对象中。
     */
    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了");
        //客户端发送ajax请求，传的是json字符串，后端把json字符串封装到user对象中。
        System.out.println(user);
        //做响应，模拟从数据库查询数据。
        user.setUsername("haha");
        user.setAge(40);
        //return @ResponseBody User，给ajax返回json对象
        return user;
    }

}














