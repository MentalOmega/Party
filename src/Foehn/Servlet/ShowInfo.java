package Foehn.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.javafx.collections.MappingChange.Map;

import JavaBean.StudentInfo;

@WebServlet("/ShowInfo")
public class ShowInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowInfo() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username=(String) request.getSession().getAttribute("username");
		
		StudentInfo student =new StudentInfo();
		JSONObject json= new JSONObject();
		for(int i=0;i<student.getsz();i++){
			try {
				json.put(student.getkinds(i), student.getstr(i));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		System.out.println(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
