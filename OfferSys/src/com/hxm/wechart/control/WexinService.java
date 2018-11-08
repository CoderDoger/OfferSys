package com.hxm.wechart.control;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;

import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.hxm.pageList.Page;
import com.hxm.service.DvrService;
import com.hxm.service.DvrServiceImpl;
import com.hxm.wechart.service.MessageProcess;
import com.hxm.wechart.service.MessageProcessImpl;


public class WexinService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I'm working....");
		//开启免验证
		String echostr = request.getParameter("echostr");;
		response.getWriter().write(echostr);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//得到消息Map
		Map<String,String> msgMap = getMsgMap(request);
		String msgType = msgMap.get("MsgType");
		
		//实例化消息处理类
		MessageProcess msgProcess = new MessageProcessImpl(response);
		//业务逻辑控制
		if("text".equals(msgType)){
			System.out.println("文本消息");
			//文本消息处理
			//msgProcess.sendTextMsg(msgMap);
			String keyWord = msgMap.get("Content");
			
			msgProcess.sendMultiMsg(msgMap,keyWord);
			
			
		}else if("image".equals(msgType)){
			//图片消息处理
			msgProcess.sendImageMsg(msgMap);
			
		}else if("voice".equals(msgType)){
			//语音消息处理
			msgProcess.sendVoiceMsg(msgMap);
			
		}else if("video".equals(msgType)){
			//视频消息处理
			msgProcess.sendVideoMsg(msgMap);
			
		}else if("shortvideo".equals(msgType)){
			//小视频消息处理
			
		}else if("location".equals(msgType)){
			//位置消息处理
			
		}else if("link".equals(msgType)){
			//链接消息处理
			
		}else{
			//默认处理
			response.getWriter().println("success");
		}	
	}
	
	/**
	 *@author hxm
	 * @param request
	 * @return Map
	 * 功能：将消息解板为Map
	 */
	private Map<String,String> getMsgMap(HttpServletRequest request) {
		Map<String,String> map = new HashMap<String,String>();
		InputStream is;
		try {
			is = request.getInputStream();
			SAXReader saxr = new SAXReader();
			Document doc = saxr.read(is);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for(Element e:list){
				System.out.println(e.getName()+"=="+e.getText());
				map.put(e.getName(), e.getText());
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return map;
	}
}
