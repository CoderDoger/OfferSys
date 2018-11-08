package com.hxm.wechart.control;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*****************************************************************************************************/
		//String fileName = new String().getBytes("iso8859-1"),"utf-8");
		String fileName = request.getParameter("fileName");
		/****************************************************************************************************/
		//FileName编码
		String fileNameEnc = fileNameEncode(request, fileName); 
		System.out.println(fileName);
		response.setHeader("Content-Disposition",  "attachment;fileName="+fileNameEnc);
	    response.setHeader("Content-Type",  "application/octet-Stream");
	    InputStream  is  =  getServletContext().getResourceAsStream("/PDF/"+fileName);
	    OutputStream  os  =  response.getOutputStream();
	    int  len  =  -1;
	    byte[]  buf  =  new  byte[1024];
	    while((len=is.read(buf))!=  -1){
	       os.write(buf,  0,  len);
	    }
	    is.close();
	    os.close();
	}

	/**
	 *@author hxm
	 * @param request
	 * @param fileName
	 * @return String FileName
	 * @throws UnsupportedEncodingException
	 * 功能：针对不同浏览器 进行对应文件名编码
	 */
	private String fileNameEncode(HttpServletRequest request, String fileName)
			throws UnsupportedEncodingException {
		String userAgent = request.getHeader("user-agent").toLowerCase();
		System.out.println(userAgent);
		if (userAgent.contains("android")){
			//Android 
			fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
			//System.out.println("android :按iso-8859-1编码");
		}else if(userAgent.contains("msie") || userAgent.contains("like gecko") ) {  
             // iphone win10 ie edge 浏览器 和其他系统的ie  
	         fileName = URLEncoder.encode(fileName, "UTF-8");
	         //System.out.println("按UTF-8编码");
	    } else {  
	             // fireFox safair  (非IE)  
	         fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
	         //fileName.replace("%28","(").replace("%29", ")");
	         //System.out.println("按iso-8859-1编码");
	    }
		//return fileName.replace("+", "%20");
		return fileName;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
