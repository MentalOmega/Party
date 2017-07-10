package Foehn.Servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.jspsmart.upload.SmartUpload;

@WebServlet("/UploadPicture")
public class UploadPicture extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UploadPicture() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// 设置文件上传路径
		//doGet(request, response);
		String username = (String) request.getSession().getAttribute("username");
		String filePath = getServletContext().getRealPath("/") +username+File.separator+"Picture";
		System.out.println(filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		SmartUpload su = new SmartUpload();
		// 初始化对象
		su.initialize(getServletConfig(), request, response);

		su.setMaxFileSize(1024 * 1024 * 3);

		su.setTotalMaxFileSize(1024 * 1024 * 3);

		su.setAllowedFilesList("jpg");
		String result = "上传成功！";
		try {
			//su.setDeniedFilesList("rar");

			su.upload();
			
			int count = su.save(filePath);
			if(count==0) result="请选择文件";
			else{
				for(int i=0;i<su.getFiles().getCount();i++){
					com.jspsmart.upload.File tmpFile = su.getFiles().getFile(i);
					System.out.println("----------------------");
					System.out.println("表单当中name的值："+tmpFile.getFieldName());
					System.out.println("上传文件名："+tmpFile.getFieldName());
					System.out.println("上传文件大小："+tmpFile.getSize());
					System.out.println("上传文件扩展名："+tmpFile.getFileExt());
					System.out.println("上传文件全名："+tmpFile.getFileName());
					System.out.println("----------------------");
				}
			}
			System.out.println("上传成功" + count + "个文件！");
		} catch (Exception e) {
			result = "上传失败";
			if(e.getMessage().indexOf("1015")!=-1){
				result="上传失败，上传文件类型不正确";
			}else if(e.getMessage().indexOf("1010")!=-1){
				result="上传失败，上传文件类型不正确";
			}else if(e.getMessage().indexOf("1105")!=-1){
				result="上传失败，上传文件大小大于允许上传的最大值";
			}else if(e.getMessage().indexOf("1110")!=-1){
				result="上传失败，上传文件总大小大于允许上传的最大值";
			}
			System.out.println(result);
			e.printStackTrace();
		}
		JSONObject json = new JSONObject();
		try {
			json.put("result", result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		//request.getRequestDispatcher("upload.jsp").forward(request, response);
		response.getWriter().write(json.toString());
	}

}
