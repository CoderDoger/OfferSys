package com.hxm.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.hxm.domain.DvrDetail;
import com.hxm.domain.Manual;
import com.hxm.domain.UserInfo;
import com.hxm.formbean.FormBean;
import com.hxm.pageList.Page;
import com.hxm.pagestatic.HtmlStatic;
import com.hxm.service.DvrService;
import com.hxm.service.DvrServiceImpl;
import com.hxm.service.ManualService;
import com.hxm.service.ManualServiceImpl;
import com.hxm.util.FormBeanUtil;

public class ManualControllerServlet extends HttpServlet {
	private ManualService manualService = new ManualServiceImpl();
	HttpSession session;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String ctrl = request.getParameter("ctrl");
		String device = request.getParameter("device");
		//创建静态页面
		if("createPage".equals(ctrl)){
			//showDvrDetail(request,response);
		}
		//登录验证
		session = request.getSession();
		UserInfo user = (UserInfo)session.getAttribute("user");
		if(null==user&&"".equals(device)){
			System.out.println(user);
			String msg = "<script>alert('非法登录！');window.top.location.href='"+request.getContextPath()+"/login.html'</script>";
			response.getWriter().write(msg);
			return ;
		}	
			
		if("show".equals(ctrl)){
			showManual(request,response);
			
		}else if("showAll".equals(ctrl)){
			showAllManual(request, response);
			//response.getWriter().write("showAll");
		}else if("edit".equals(ctrl)){
			editManual(request,response);
			
		}else if("modify".equals(ctrl)){
			//modifyDvrDetail(request,response);
		}else if("add".equals(ctrl)){
			//addDvrDetail(request,response);
		}else if("del".equals(ctrl)){
			delManual(request,response);
		}else if("delAll".equals(ctrl)){
			delAllManual(request,response);
		}else if("pageStatic".equals(ctrl)){
			//pageStatic(request,response);
		}else if("search".equals(ctrl)){
			search(request,response);
		}else if("logout".equals(ctrl)){
			logout(request,response);
		}
		
	}
	//退出登陆
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		session.invalidate();
		String msg = "<script>alert('已退出系统！');window.top.location.href='"+request.getContextPath()+"/login.html'</script>";
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//搜索
	private void search(HttpServletRequest request, HttpServletResponse response) {
		String keyWord = request.getParameter("keyWord");
		String type = request.getParameter("category");
		System.out.println("keyword===>"+keyWord);
		System.out.println("type===>"+type);
		
		String currentPageNum = request.getParameter("currentPageNum");
	
		
		Page page = manualService.getPageRecordsByKeyWord(currentPageNum,keyWord,type);
		request.setAttribute("page", page);
		try {
			request.getRequestDispatcher("/showManualList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//批量删除
	private void delAllManual(HttpServletRequest request,
			HttpServletResponse response) {
		String[] idArr = request.getParameterValues("idv");
		String category = request.getParameter("category");
		
		manualService.delAll(idArr,category);
		try {
			//response.sendRedirect(request.getContextPath());
			String msg = "<script>alert('批量删除成功！');window.location.href='"+request.getContextPath()+"/"+category.toLowerCase()+"Manual.jsp'</script>";
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
		String htmlFileName = getServletContext().getRealPath("/staticPage/DVR/")+"\\"+fileName;
		
		//System.out.println("id="+id+" fileName="+fileName);
		//System.out.println("url="+url+" htmlName"+htmlFileName);
		htmlStatic.createHtmlPage(url, htmlFileName);
		
		/*DvrDetail dvrDetail = getDvrDetailBean(request);
		//System.out.println("dvrDe="+dvrDetail);*/
		//offerService.htmlStatic(id);
		
		//定向到主页
		try {
			String msg = "<script>alert('页面已静态化');window.location.href='"+request.getContextPath()+"/dvr.jsp'</script>";
			response.getWriter().write(msg);
			//response.sendRedirect(request.getContextPath());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void modifyDvrDetail(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		DvrDetail dvrDetail = getDvrDetailBean(request);
		//System.out.println("dvrDe="+dvrDetail);
		//offerService.modifyDvrDetail(dvrDetail, id);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/dvr.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void delManual(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		String category = request.getParameter("category");
		//System.out.println("id====>"+id+" category====>"+category);
		manualService.del(id,category);
		try {
			response.sendRedirect(request.getContextPath()+"/"+category.toLowerCase()+"Manual.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void editManual(HttpServletRequest request,
			HttpServletResponse response) {
		
		String id = request.getParameter("id");
		//System.out.println("id=====>"+id);
		String category = request.getParameter("category");
		//System.out.println("category===>"+category);
		Manual manual = manualService.getManual(id, category);
		//System.out.println("manual======>"+manual);
		request.setAttribute("manual", manual);
		try {
			request.getRequestDispatcher("/editManual.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void showAllManual(HttpServletRequest request,
			HttpServletResponse response) {
		/*List<DvrDetail> list = offerDao.getDvrDetails();
		request.setAttribute("dvrDetails", list);*/
		//String guest = request.getParameter("guest");
		String type = request.getParameter("objName");
		String currentPageNum = request.getParameter("currentPageNum");
		Page page = manualService.getPageRecords(currentPageNum,type);
		System.out.println(page);
		request.setAttribute("page", page);
		try {	
			request.getRequestDispatcher("/showManualList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void addDvrDetail(HttpServletRequest request,
			HttpServletResponse response) {
		DvrDetail dvrDetail = getDvrDetailBean(request);
		//System.out.println(dvrDetail);
		//offerService.savaDvrDetail(dvrDetail);
		//定向到主页
		try {
			response.sendRedirect(request.getContextPath()+"/dvr.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	private DvrDetail getDvrDetailBean(HttpServletRequest request) {
		//将数据整 到FormBean中
		//注意如果，jsp提交过来的有数组，将多项的name 写成一样 将自动识别为数组，千万不要用xx[] 来提交数据，否则formbean会报错！
		FormBean formBean = FormBeanUtil.fillBean(request, FormBean.class);
		//数据验证不合法，回显不合法信息
		//System.out.println(formBean);
		//数据验证合法，拷贝数据到CustomerBean 中
		DvrDetail dvrDetailBean = new DvrDetail();
		try {
			BeanUtils.copyProperties(dvrDetailBean, formBean);
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
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return dvrDetailBean;
	}
	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void showManual(HttpServletRequest request,
			HttpServletResponse response) {
		//System.out.println("走数据库...");
		String type = request.getParameter("type");
		String id = request.getParameter("id");
		Manual manual = manualService.getManual(id,type);
		//System.out.println(manual);
		request.setAttribute("manual", manual);
		try {
			request.getRequestDispatcher("/showManual.jsp").forward(request, response);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
