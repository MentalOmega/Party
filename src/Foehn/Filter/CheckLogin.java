package Foehn.Filter;

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
import javax.servlet.http.HttpSession;

@WebFilter("/login.html")
public class CheckLogin implements Filter {

    public CheckLogin() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		System.out.println("logincheck");
		if(session.getAttribute("username")==null)
			chain.doFilter(request, response);
		else
			resp.sendRedirect(req.getContextPath()+"/Comment/success.jsp");
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
