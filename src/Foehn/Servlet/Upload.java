package Foehn.Servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;

@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Upload() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����ļ��ϴ�·��
		//doGet(request, response);
		
		String filePath = getServletContext().getRealPath("/") + "xlsx";
		System.out.println(filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		SmartUpload su = new SmartUpload();
		// ��ʼ������
		su.initialize(getServletConfig(), request, response);

		su.setMaxFileSize(1024 * 1024 * 10);

		su.setTotalMaxFileSize(1024 * 1024 * 100);

		su.setAllowedFilesList("xlsx");
		String result = "�ϴ��ɹ���";
		try {
			//su.setDeniedFilesList("rar");

			su.upload();
			
			int count = su.save(filePath);
			if(count==0) result="��ѡ���ļ�";
			else{
				for(int i=0;i<su.getFiles().getCount();i++){
					com.jspsmart.upload.File tmpFile = su.getFiles().getFile(i);
					System.out.println("----------------------");
					System.out.println("������name��ֵ��"+tmpFile.getFieldName());
					System.out.println("�ϴ��ļ�����"+tmpFile.getFieldName());
					System.out.println("�ϴ��ļ���С��"+tmpFile.getSize());
					System.out.println("�ϴ��ļ���չ����"+tmpFile.getFileExt());
					System.out.println("�ϴ��ļ�ȫ����"+tmpFile.getFileName());
					System.out.println("----------------------");
				}
			}
			System.out.println("�ϴ��ɹ�" + count + "���ļ���");
		} catch (Exception e) {
			result = "�ϴ�ʧ��";
			if(e.getMessage().indexOf("1015")!=-1){
				result="�ϴ�ʧ�ܣ��ϴ��ļ����Ͳ���ȷ";
			}else if(e.getMessage().indexOf("1010")!=-1){
				result="�ϴ�ʧ�ܣ��ϴ��ļ����Ͳ���ȷ";
			}else if(e.getMessage().indexOf("1105")!=-1){
				result="�ϴ�ʧ�ܣ��ϴ��ļ���С���������ϴ������ֵ";
			}else if(e.getMessage().indexOf("1110")!=-1){
				result="�ϴ�ʧ�ܣ��ϴ��ļ��ܴ�С���������ϴ������ֵ";
			}
			System.out.println(result);
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		request.getRequestDispatcher("upload.jsp").forward(request, response);
	}

}
