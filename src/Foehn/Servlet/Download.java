	package Foehn.Servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;


@WebServlet("/Download")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Download() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename=request.getParameter("filename");
		
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(),request,response);
		try {
			System.out.println(File.separator+"xlsx"+File.separator+filename);
			su.downloadFile(File.separator+"xlsx"+File.separator+filename);
		} catch (SmartUploadException e) {
			e.printStackTrace();
		}
	}

}
