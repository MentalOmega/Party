package Foehn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().write(getServletContext().getRealPath("/"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		System.out.println(username);
		System.out.println(userpass);
		JSONObject result = new JSONObject();
		if("3115005294".equals(username)&&"admin".equals(userpass)){
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			try {
				result.put("result", "success");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			//response.sendRedirect(request.getContextPath()+"/Comment/success.jsp");
		}
		else{
			
			try {
				result.put("result", "error");
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			//response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		System.out.println(result.toString());
		response.getWriter().write(result.toString());
	}

}
