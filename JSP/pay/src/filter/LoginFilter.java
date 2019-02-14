package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Admin;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
	private String[] noLoginFilter = {"/login.do","/log.jsp"};
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		Admin admin = (Admin)req.getSession().getAttribute("admin");
		String servletPath = req.getServletPath();
		for(String login: noLoginFilter) {
			if(login.equals(servletPath)) {
				chain.doFilter(request, response);
				return;
			}
		}
		if(admin!=null) {
			chain.doFilter(request, response);
		}else {
			HttpServletResponse res = (HttpServletResponse)response;
			req.getSession().setAttribute("msg", "Äú»¹Ã»ÓÐµÇÂ¼");
			res.sendRedirect("log.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
