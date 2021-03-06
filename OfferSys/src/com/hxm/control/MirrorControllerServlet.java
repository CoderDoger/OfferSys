package com.hxm.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxm.domain.MirrorDetail;
import com.hxm.domain.UserInfo;
import com.hxm.formbean.MirrorFormBean;
import com.hxm.pageList.Page;
import com.hxm.pagestatic.HtmlStatic;


import com.hxm.service.MirrorService;
import com.hxm.service.MirrorServiceImpl;
import com.hxm.util.FormBeanUtil;

public class MirrorControllerServlet extends HttpServlet {
	private MirrorService mirrorService = new MirrorServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ctrl = request.getParameter("ctrl");
		//创建静态页面
		if("createPage".equals(ctrl)){
			System.out.println("createPage-----");
			showMirrorDetail(request,response);
		}
		
		//登录验证
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		if(null==user){
			System.out.println(user);
			String msg = "<script>alert('非法登录！');window.top.location.href='"+request.getContextPath()+"/login.html'</script>";
			response.getWriter().write(msg);
			return ;
		}

		if("show".equals(ctrl)){
			showMirrorDetail(request,response);
		}else if("showAll".equals(ctrl)){
			showAllMirrorDetail(request,response);
			//response.getWriter().write("showAll");
		}else if("edit".equals(ctrl)){
			editMirrorDetail(request,response);	
		}else if("modify".equals(ctrl)){
			modifyMirrorDetail(request,response);
		}else if("add".equals(ctrl)){
			addMirrorDetail(request,response);
		}else if("del".equals(ctrl)){
			delMirrorDetail(request,response);
		}else if("delAll".equals(ctrl)){
			delAllMirrorDetail(request,response);
		}else if("pageStatic".equals(ctrl)){
			pageStatic(request,response);
		}else if("search".equals(ctrl)){
			search(request,response);
		}
	}
	//搜索
	private void search(HttpServletRequest request, HttpServletResponse response) {
		String keyWord = request.getParameter("keyWord");
		System.out.println(keyWord);
		String currentPageNum = request.getParameter("currentPageNum");
		
		Page page = mirrorService.getPageRecordsByKeyWord(currentPageNum,keyWord);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showMirrorDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//批量删除
	private void delAllMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String[] idArr = request.getParameterValues("idv");
		mirrorService.delAll(idArr);
		try {
			//response.sendRedirect(request.getContextPath());
			String msg = "<script>alert('批量删除成功！');window.location.href='"+request.getContextPath()+"/mirror.jsp'</script>";
			response.getWriter().write(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//页面静态化
	private void pageStatic(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String fileName = request.getParameter("fileName")+".html";
		
		String webappname = request.getContextPath();
		HtmlStatic htmlStatic = new HtmlStatic(webappname);
		
		String ip = request.getLocalAddr();    //取得服务器IP     
        int port = request.getLocalPort();    //取得服务器端口
        //host
        String host = "http://"+ ip + ":" + port;
		String url = host + request.getRequestURI()+"?ctrl=createPage&id="+id;
		String htmlFileName = getServletContext().getRealPath("/staticPage/Mirror/")+"\\"+fileName;
		
		//System.out.println("id="+id+" fileName="+fileName);
		System.out.println("url="+url+" htmlName"+htmlFileName);
		htmlStatic.createHtmlPage(url, htmlFileName);
		
		/*DvrDetail dvrDetail = getDvrDetailBean(request);
		//System.out.println("dvrDe="+dvrDetail);*/
		mirrorService.htmlStatic(id);
		
		//定向到主页
		try {
			String msg = "<script>alert('页面已静态化');window.location.href='"+request.getContextPath()+"/mirror.jsp'</script>";
			response.getWriter().write(msg);
			//response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void modifyMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		MirrorDetail mirrorDetail = getMirrorDetailBean(request);
		System.out.println("mirrorDetail="+mirrorDetail);
		
		mirrorService.modifyMirrorDetail(mirrorDetail, id);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/mirror.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void delMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		mirrorService.del(id);
		try {
			response.sendRedirect(request.getContextPath()+"/mirror.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void editMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		MirrorDetail mirrorDetail = mirrorService.getMirrorDetail(id);
		request.setAttribute("mirrorDetail", mirrorDetail);
		System.out.println(mirrorDetail);
		try {
			request.getRequestDispatcher("/editMirrorDetail.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAllMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		/*List<DvrDetail> list = offerDao.getDvrDetails();
		request.setAttribute("dvrDetails", list);*/
	
		String currentPageNum = request.getParameter("currentPageNum");
		Page page = mirrorService.getPageRecords(currentPageNum);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showMirrorDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		MirrorDetail mirrorDetail = getMirrorDetailBean(request);
		System.out.println(mirrorDetail);
		mirrorService.saveMirrorDetail(mirrorDetail);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/mirror.jsp");
			//request.getRequestDispatcher("/showMirrorDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private MirrorDetail getMirrorDetailBean(HttpServletRequest request) {
		//将数据整 到FormBean中
		//注意如果，jsp提交过来的有数组，将多项的name 写成一样 将自动识别为数组，千万不要用xx[] 来提交数据，否则formbean会报错！
		MirrorFormBean formBean = FormBeanUtil.fillBean(request, MirrorFormBean.class);
		//数据验证不合法，回显不合法信息
		//System.out.println(formBean);
		//数据验证合法，拷贝数据到CustomerBean 中
		MirrorDetail mirrorDetailBean = new MirrorDetail();
		try {
			BeanUtils.copyProperties(mirrorDetailBean, formBean);
			/*
			//单独处理hobby处理为字符串(formBean中的frontCamera，frameRate 是数组,dvrDetailBean中frontCamera，frameRate是字符串，拷贝过程过，只会拷贝数组中的第一个，所以会有数据丢失)
			String[] frontCamera = formBean.getFrontCamera();
			String[] frameRate = formBean.getFrameRate();
			if(frontCamera.length>1)
			{
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<frontCamera.length;i++){
					if(i>0){
						sb.append("&");
						sb.append(frontCamera[i]);
					}
					else
						sb.append(frontCamera[i]);
				}
				String frontCameraStr = sb.toString();
				dvrDetailBean.setFrontCamera(frontCameraStr);
			}
			if(frameRate.length>1)
			{
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<frameRate.length;i++){
					if(i>0){
						sb.append("&");
						sb.append(frameRate[i]);
					}
					else
						sb.append(frameRate[i]);
				}
				String frameRateStr = sb.toString();
				dvrDetailBean.setFrameRate(frameRateStr);
			}
			*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mirrorDetailBean;
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showMirrorDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String htmlStatic = request.getParameter("htmlStatic");
		//System.out.println("htmlStatic=="+htmlStatic);
		try {
			if("1".equals(htmlStatic)){
				String model = request.getParameter("model");
				request.getRequestDispatcher("/staticPage/Mirror/"+model+".html").forward(request, response);
			}else{
				System.out.println("走数据库...");
				String id = request.getParameter("id");
				MirrorDetail mirrorDetail = mirrorService.getMirrorDetail(id);
				//System.out.println(mirrorDetail);
				request.setAttribute("mirrorDetail", mirrorDetail);
				request.getRequestDispatcher("/showMirrorDetail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}

