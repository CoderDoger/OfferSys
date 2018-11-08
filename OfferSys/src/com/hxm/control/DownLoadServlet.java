package com.hxm.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownLoadServlet extends HttpServlet {
	private File file = null;
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/*****************************************************************************************************/
		//String fileName = new String(request.getParameter("fileName").getBytes("iso8859-1"),"utf-8");
		String fileName = new String(request.getParameter("fileName"));
		
		String fileType = request.getParameter("fileType");
		String category = request.getParameter("category")+"/";
		/****************************************************************************************************/
		System.out.println("文件名："+fileName);
		System.out.println(fileType);
		System.out.println(category);
	
	    
	    if("excel".equals(fileType)){
	    	file = new File(getServletContext().getRealPath("/excel/"+category+fileName));
	    }else if("pdf".equals(fileType)){
	    	file = new File(getServletContext().getRealPath("/pdf/"+category+fileName));	
	    }else if("manual".equals(fileType)){
	    	file = new File(getServletContext().getRealPath("/Manual/"+category+fileName));	
	    }	
	    //判断PDF文件是否存，如果不存在提示用户先创建
		if(!file.exists()){
			System.out.println("文件不存在");
			String msg = "<script>alert('文件不存在，请先生成文件，再下载！');history.back();</script>";
			response.getWriter().write(msg);
			return ;
		}else{
			//System.out.println("文件存在");
			//下载
			response.setHeader("Content-Disposition",  "attachment;fileName="+URLEncoder.encode(fileName,"UTF-8"));
		    response.setHeader("Content-Type", "application/octet-Stream");
			
		    InputStream  is  =  new FileInputStream(file);
		    OutputStream  os  =  response.getOutputStream();
		    int  len  =  -1;
		    byte[]  buf  =  new  byte[1024];
		    while((len=is.read(buf))!=  -1){
		       os.write(buf,  0,  len);
		    }
		    
		    is.close();
		    os.close();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
