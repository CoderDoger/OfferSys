package com.hxm.control;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;







import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.GpsDetail;
import com.hxm.domain.UserInfo;
import com.hxm.formbean.FormBean;
import com.hxm.formbean.GpsFormBean;
import com.hxm.pageList.Page;
import com.hxm.pagestatic.HtmlStatic;
import com.hxm.service.GpsService;
import com.hxm.service.GpsServiceImpl;
import com.hxm.service.DvrService;
import com.hxm.service.DvrServiceImpl;
import com.hxm.util.FormBeanUtil;

public class GpsControllerServlet extends HttpServlet {
	private GpsService gpsService = new GpsServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ctrl = request.getParameter("ctrl");
		//创建静态页面
		if("createPage".equals(ctrl)){
			showGpsDetail(request,response);
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
			showGpsDetail(request,response);
			
		}else if("showAll".equals(ctrl)){
			showAllGppsDetail(request,response);
			//response.getWriter().write("showAll");
		}else if("edit".equals(ctrl)){
			editDvrDetail(request,response);
			
		}else if("modify".equals(ctrl)){
			modifyGpsDetail(request,response);
		}else if("add".equals(ctrl)){
			addGpsDetail(request,response);
		}else if("del".equals(ctrl)){
			delGpsDetail(request,response);
		}else if("delAll".equals(ctrl)){
			delAllGpsDetail(request,response);
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
		
		Page page = gpsService.getPageRecordsByKeyWord(currentPageNum,keyWord);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showGpsDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//批量删除
	private void delAllGpsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String[] idArr = request.getParameterValues("idv");
		gpsService.delAll(idArr);
		try {
			//response.sendRedirect(request.getContextPath());
			String msg = "<script>alert('批量删除成功！');window.location.href='"+request.getContextPath()+"/gps.jsp'</script>";
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
		String htmlFileName = getServletContext().getRealPath("/staticPage/GPS/")+"\\"+fileName;
		
		//System.out.println("id="+id+" fileName="+fileName);
		//System.out.println("url="+url+" htmlName"+htmlFileName);
		htmlStatic.createHtmlPage(url, htmlFileName);
		
		/*DvrDetail dvrDetail = getDvrDetailBean(request);
		//System.out.println("dvrDe="+dvrDetail);*/
		gpsService.htmlStatic(id);
		
		//定向到主页
		try {
			String msg = "<script>alert('页面已静态化');window.location.href='"+request.getContextPath()+"/gps.jsp'</script>";
			response.getWriter().write(msg);
			//response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void modifyGpsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		GpsDetail gpsDetail = getGpsDetailBean(request);
		//System.out.println("gpsDetail="+gpsDetail);
		gpsService.modifyGpsDetail(gpsDetail, id);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/gps.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void delGpsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		gpsService.del(id);
		try {
			response.sendRedirect(request.getContextPath()+"/gps.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void editDvrDetail(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		GpsDetail gpsDetail = gpsService.getGpsDetail(id);
		request.setAttribute("gpsDetail", gpsDetail);
		try {
			request.getRequestDispatcher("/editGpsDetail.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void showAllGppsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		/*List<DvrDetail> list = offerDao.getDvrDetails();
		request.setAttribute("dvrDetails", list);*/
	
		String currentPageNum = request.getParameter("currentPageNum");
		Page page = gpsService.getPageRecords(currentPageNum);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showGpsDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void addGpsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		GpsDetail gpsDetail = getGpsDetailBean(request);
		//System.out.println(dvrDetail);
		gpsService.saveGpsDetail(gpsDetail);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/gps.jsp");
			//request.getRequestDispatcher("/showGpsDetailList.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private GpsDetail getGpsDetailBean(HttpServletRequest request) {
		//将数据整 到FormBean中
		//注意如果，jsp提交过来的有数组，将多项的name 写成一样 将自动识别为数组，千万不要用xx[] 来提交数据，否则formbean会报错！
		GpsFormBean formBean = FormBeanUtil.fillBean(request, GpsFormBean.class);
		//数据验证不合法，回显不合法信息
		//System.out.println(formBean);
		//数据验证合法，拷贝数据到CustomerBean 中
		GpsDetail gpsDetailBean = new GpsDetail();
		try {
			BeanUtils.copyProperties(gpsDetailBean, formBean);
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
		return gpsDetailBean;
	}


	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showGpsDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String htmlStatic = request.getParameter("htmlStatic");
		//System.out.println("htmlStatic=="+htmlStatic);
		try {
			if("1".equals(htmlStatic)){
				String model = request.getParameter("model");
				request.getRequestDispatcher("/staticPage/GPS/"+model+".html").forward(request, response);
			}else{
				//System.out.println("走数据库...");
				String id = request.getParameter("id");
				GpsDetail gpsDetail = gpsService.getGpsDetail(id);
				//System.out.println(dvrDetail);
				request.setAttribute("gpsDetail", gpsDetail);
				request.getRequestDispatcher("/showGpsDetail.jsp").forward(request, response);
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
