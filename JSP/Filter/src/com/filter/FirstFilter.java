package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class FirstFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("first init...");
		String encode = filterConfig.getInitParameter("encode");
		System.out.println("encode: "+encode);
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("first doFilter...");
		String username = request.getParameter("username");
		if("admin".equals(username)) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect("index.jsp");
		}
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("first destroy...");
	}

}
