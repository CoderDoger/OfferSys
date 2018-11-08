package com.hxm.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxm.domain.PndDetail;
import com.hxm.domain.PndDetail;
import com.hxm.domain.UserInfo;
import com.hxm.formbean.PndFormBean;
import com.hxm.formbean.PndFormBean;
import com.hxm.pageList.Page;
import com.hxm.pagestatic.HtmlStatic;
import com.hxm.service.PndService;
import com.hxm.service.PndServiceImpl;
import com.hxm.service.PndService;

import com.hxm.util.FormBeanUtil;

public class PndControllerServlet extends HttpServlet {
	private PndService pndService = new PndServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ctrl = request.getParameter("ctrl");
		//创建静态页面
		if("createPage".equals(ctrl)){
			showPndDetail(request,response);
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
			showPndDetail(request,response);
			
		}else if("showAll".equals(ctrl)){
			showAllGppsDetail(request,response);
			//response.getWriter().write("showAll");
		}else if("edit".equals(ctrl)){
			editPndDetail(request,response);
			
		}else if("modify".equals(ctrl)){
			modifyPndDetail(request,response);
		}else if("add".equals(ctrl)){
			addPndDetail(request,response);
		}else if("del".equals(ctrl)){
			delPndDetail(request,response);
		}else if("delAll".equals(ctrl)){
			delAllPndDetail(request,response);
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
		
		Page page = pndService.getPageRecordsByKeyWord(currentPageNum,keyWord);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showPndDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//批量删除
	private void delAllPndDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String[] idArr = request.getParameterValues("idv");
		pndService.delAll(idArr);
		try {
			//response.sendRedirect(request.getContextPath());
			String msg = "<script>alert('批量删除成功！');window.location.href='"+request.getContextPath()+"/pnd.jsp'</script>";
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
		String htmlFileName = getServletContext().getRealPath("/staticPage/PND/")+"\\"+fileName;
		
		//System.out.println("id="+id+" fileName="+fileName);
		//System.out.println("url="+url+" htmlName"+htmlFileName);
		htmlStatic.createHtmlPage(url, htmlFileName);
		
		/*DvrDetail dvrDetail = getDvrDetailBean(request);
		//System.out.println("dvrDe="+dvrDetail);*/
		pndService.htmlStatic(id);
		
		//定向到主页
		try {
			String msg = "<script>alert('页面已静态化');window.location.href='"+request.getContextPath()+"/pnd.jsp'</script>";
			response.getWriter().write(msg);
			//response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void modifyPndDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		PndDetail pndDetail = getPndDetailBean(request);
		//System.out.println("pndDetail="+pndDetail);
		pndService.modifyPndDetail(pndDetail, id);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/pnd.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void delPndDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		pndService.del(id);
		try {
			response.sendRedirect(request.getContextPath()+"/pnd.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void editPndDetail(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		PndDetail pndDetail = pndService.getPndDetail(id);
		request.setAttribute("pndDetail", pndDetail);
		System.out.println(pndDetail);
		try {
			request.getRequestDispatcher("/editPndDetail.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAllGppsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		/*List<DvrDetail> list = offerDao.getDvrDetails();
		request.setAttribute("dvrDetails", list);*/
	
		String currentPageNum = request.getParameter("currentPageNum");
		Page page = pndService.getPageRecords(currentPageNum);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showPndDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addPndDetail(HttpServletRequest request,
			HttpServletResponse response) {
		PndDetail pndDetail = getPndDetailBean(request);
		//System.out.println(pndDetail);
		pndService.savePndDetail(pndDetail);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/pnd.jsp");
			//request.getRequestDispatcher("/showPndDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private PndDetail getPndDetailBean(HttpServletRequest request) {
		//将数据整 到FormBean中
		//注意如果，jsp提交过来的有数组，将多项的name 写成一样 将自动识别为数组，千万不要用xx[] 来提交数据，否则formbean会报错！
		PndFormBean formBean = FormBeanUtil.fillBean(request, PndFormBean.class);
		//数据验证不合法，回显不合法信息
		//System.out.println(formBean);
		//数据验证合法，拷贝数据到CustomerBean 中
		PndDetail pndDetailBean = new PndDetail();
		try {
			BeanUtils.copyProperties(pndDetailBean, formBean);
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
		return pndDetailBean;
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showPndDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String htmlStatic = request.getParameter("htmlStatic");
		//System.out.println("htmlStatic=="+htmlStatic);
		try {
			if("1".equals(htmlStatic)){
				String model = request.getParameter("model");
				request.getRequestDispatcher("/staticPage/PND/"+model+".html").forward(request, response);
			}else{
				//System.out.println("走数据库...");
				String id = request.getParameter("id");
				PndDetail pndDetail = pndService.getPndDetail(id);
				//System.out.println(pndDetail);
				request.setAttribute("pndDetail", pndDetail);
				request.getRequestDispatcher("/showPndDetail.jsp").forward(request, response);
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

