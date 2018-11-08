package com.hxm.control;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.hxm.dao.OfferSysDao;
import com.hxm.dao.OfferSysDaoImpl;
import com.hxm.util.GUID;

public class FileUplaodServlet extends HttpServlet {
	//private OfferSysDao offerDao = new OfferSysDaoImpl();
	private String fileName;
	private String id;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码格式，解决中文乱码问题
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		//建立DiskFileItemFactory对象
		DiskFileItemFactory fileItem = new DiskFileItemFactory();
		//设置临时存放目录
		//fileItem.setRepository(new File(":/"));
		//判断用户的表单是不是multipart/form-data类型的
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if(!isMultipart)
			throw new RuntimeException("是不是傻!表单类型不是multipart/form-data类型的！");
		//创建ServletFileUpload的实例
		ServletFileUpload sfu = new ServletFileUpload(fileItem);
		//设置上传文件的大小
		sfu.setFileSizeMax(5*1024*1024);
		//设置总文件大小
		sfu.setSizeMax(10*1024*1024);
		//解析请求对象
		try {
			List<FileItem> items = sfu.parseRequest(request);
			//遍历
			for(FileItem item:items){
				if(item.isFormField())
				    //普通字段
					processFormField(item);
				else
					//文件字段
					processUploadField(item);
			}
			//如果没有ID 就不写数据库
			/*if(id!=null&&!"".equals(id)){
				//存数据库
				offerDao.updateImg(fileName,id);
			}*/
			String src = request.getContextPath()+"/uploadFile/"+fileName;
			//System.out.println(src);
			//response.setContentType("application/json");
			response.getWriter().write("{'status':'ok','src':'"+src+"'}");
			//
		}catch(FileUploadBase.FileSizeLimitExceededException e){
			response.getWriter().write("文件超出大小限制");
		}catch(FileUploadBase.SizeLimitExceededException e){
			response.getWriter().write("一次上传文件不能超过10M");
		}catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 处理上传字段
	private void processUploadField(FileItem item) {
		/*限定上传的文件类型*/
		if(!item.getContentType().startsWith("image"))
			throw new RuntimeException("麻蛋，只可以上传图片！");
		/* 生成保存目录*/
		//得到绝对路径
		String realPath = getServletContext().getRealPath("/uploadFile/");
		File dir = new File(realPath);
		if(!dir.exists()){
			dir.mkdirs();
		}
		//取得文件名
		fileName = item.getName();
		/*
		 * 解决问题：
		 * 1.同名文件，怎么防止覆盖
		 * 2.文件多了，怎么分类
		 * 
		if(fileName!=null){
			//生成新的文件名，防止同名覆盖
			fileName = GUID.generateGUID()+"_"+FilenameUtils.getName(fileName);
		}
		/*
		//计算存放子目录:按照日期计算，解决分类
		String childDirectory = makeChildDirectory(realPath);
		
		//计算存放子目录:按用文件名的hash码计算目录
		String childDirectory = makeChildDirectory(realPath,fileName);
		*/
		//保存
		try {
			item.write(new File(realPath+"/", fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//用文件名的hash码计算目录:分2级子目录
	private String makeChildDirectory(String realPath,String filename) {
		int hashCode = filename.hashCode();
		int dir1 = hashCode&0xf;
		/*
		1100 1101 0101 1101 0000 1111 1010 0101  hashCode
		0000 0000 0000 0000 0000 0000 0000 1111  0xf
		-------------------------------------------&
		0000 0000 0000 0000 0000 0000 0000 0101   取hashCode的0~3位   0000~1111  0~15共16个
		 */
		int dir2 = (hashCode&0xf0)>>4;
		/*
		1100 1101 0101 1101 0000 1111 1010 0101  hashCode
		0000 0000 0000 0000 0000 0000 1111 0000   0xf0
		-------------------------------------------&
		0000 0000 0000 0000 0000 0000 1010 0000   取hashCode的4~7位   0000~1111  0~15共16个
		>>4
		0000 0000 0000 0000 0000 0000 0000 1010
		 */
		String childDirectory = dir1+"/"+dir2;
		File file = new File(realPath,childDirectory);
		if(!file.exists()){
			file.mkdirs();
		}
		return childDirectory;
	}
	//按日期生成子目录
	private String makeChildDirectory(String realPath) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(now);
		File file = new File(realPath, date);
		if(!file.exists())
			file.mkdirs();
		return date;
	}
	// 处理普通字段
	private void processFormField(FileItem item) throws UnsupportedEncodingException {
		String FieldName = item.getFieldName();
		if("id".equals(FieldName)){
			this.id = item.getString("UTF-8");
		}
		//解决中文字段乱码
		String FieldValue = item.getString("UTF-8");
		System.out.println(FieldName+":"+FieldValue);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
