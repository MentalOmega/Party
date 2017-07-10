package Foehn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBean.Letter;

@WebServlet("/WriteLetter")
public class WriteLetter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteLetter() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String C17=(String) request.getParameter("C17");
		String E18=(String) request.getParameter("E18");
		String R19=(String) request.getParameter("R19");
		String V19=(String) request.getParameter("V19");
		String Z19=(String) request.getParameter("Z19");
		String G21=(String) request.getParameter("G21");
		String U21=(String) request.getParameter("U21");
		String D22=(String) request.getParameter("D22");
		String S22=(String) request.getParameter("S22");
		String R25=(String) request.getParameter("R25");
		String W25=(String) request.getParameter("W25");
		String H27=(String) request.getParameter("H27");
		String V30=(String) request.getParameter("V30");
		String P31=(String) request.getParameter("P31");
		String P32=(String) request.getParameter("P32");
		String H33=(String) request.getParameter("H33");
		String P33=(String) request.getParameter("P33");
		String Z33=(String) request.getParameter("Z33");
		Letter letter = new Letter();
		String info[] = new String[]{C17,E18,R19,V19,Z19,G21,U21,D22,S22,R25,W25,H27,V30,P31,P32,H33,P33,Z33};
		letter.setInfo(info);
		
		/*test*/
		String list[]=letter.getName();
		for(int i=0;i<list.length;i++){
			System.out.println(list[i]+':'+info[i]);
		}
	}

}
