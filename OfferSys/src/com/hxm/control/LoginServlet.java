package com.hxm.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hxm.domain.UserInfo;
import com.hxm.service.DvrService;
import com.hxm.service.DvrServiceImpl;

public class LoginServlet extends HttpServlet {
	private DvrService offerService = new DvrServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		System.out.println("servlet="+userName+"===="+passWord);
		UserInfo user = offerService.validation(userName,passWord);
		System.out.println("userName="+userName+" password="+passWord+" user="+user);
		if(null!=user){
			//设置session
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			String msg = "<script>window.location.href='"+request.getContextPath()+"/index.jsp'</script>";
			response.getWriter().write(msg);
		}else{
			String msg = "<script>alert('用户名密码不正确，请重新登录！');window.location.href='"+request.getContextPath()+"/login.html'</script>";
			response.getWriter().write(msg);
			return ;
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
