package com.hxm.wechart.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.hxm.dao.OfferSysDao;
import com.hxm.dao.OfferSysDaoImpl;
import com.hxm.domain.DvrDetail;
import com.hxm.wechart.util.XmlTmplate;
public class MessageProcessImpl implements MessageProcess {
	private PrintWriter out;
	private OfferSysDao dvrDao = new OfferSysDaoImpl();
	//实例化消息模板
	private XmlTmplate xmlp = new XmlTmplate();
	public MessageProcessImpl(HttpServletResponse response) throws IOException {
		super();
		this.out = response.getWriter();
	}

	@Override
	public void sendTextMsg(Map<String, String> msgMap) {
		//msgMap.put("Content", "www.baidu.com");
		String xml = xmlp.getTextXml(msgMap);
		System.out.println("=========================华丽的分隔线=================================");
		System.out.println(xml);
		out.println(xml);
	}

	@Override
	public void sendImageMsg(Map<String, String> msgMap) {
		String xml = xmlp.getImageXml(msgMap);
		System.out.println("=========================华丽的分隔线=================================");
		System.out.println(xml);
		out.println(xml);
	}

	@Override
	public void sendVoiceMsg(Map<String, String> msgMap) {
		String xml = xmlp.getVoiceXml(msgMap);
		System.out.println("=========================华丽的分隔线=================================");
		System.out.println(xml);
		out.println(xml);
	}

	@Override
	public void sendVideoMsg(Map<String, String> msgMap) {
		String xml = xmlp.getVideoXml(msgMap);
		System.out.println("=========================华丽的分隔线=================================");
		System.out.println(xml);
		out.println(xml);
	}

	@Override
	public void sendMusicMsg(Map<String, String> msgMap) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMultiMsg(Map<String, String> msgMap,String keyWord) {
		//
		System.out.println("keyword=="+keyWord);
		
		DvrDetail dvrDetail = dvrDao.getDvrDetailByModel(keyWord);

		System.out.println(dvrDetail);
		//String desc = "本产品采用高性能芯片，提供高清晰度视频，无缝动态画面。通过欧洲CE、美国FCC的严格认证，支持真正全高清FHD1080P摄像。使用前请仔细阅读本手册并妥善保存，我们希望本产品能满足您的需求并长期服务于您！";
		msgMap.put("MsgType", "news");
		msgMap.put("ArticleCount", "1");//8条以内
		//msgMap.put("Title", "CPR2401说明书");//Title	是	图文消息标题
		//msgMap.put("Description", desc);//Description	是	图文消息描述
		//msgMap.put("PicUrl", "https://mmbiz.qpic.cn/mmbiz_png/pQGcgAfsNjcXCz7DetenKHxLicTSSxxzrXeLgZCAvPyue18X77b96MA8LbANtSH2ADJlCh9A0NdiaDyAPiaoQwl0w/0?wx_fmt=png");//PicUrl	是	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		//msgMap.put("Url", "http://191914ts83.51mypc.cn/Wexin/servlet/FileDownLoad?fileName=2401说明书.pdf");//Url	是	点击图文消息跳转链接
		
		msgMap.put("Title", dvrDetail.getModel()+"参数规格详情：");//Title	是	图文消息标题
		msgMap.put("Description",  "CPU:"+dvrDetail.getCpu()+" LCD:"+dvrDetail.getLcd()+ " " +dvrDetail.getFrontCamera());//Description	是	图文消息描述
		String picUrl = "http://191914ts83.51mypc.cn/OfferSys/uploadFile/"+dvrDetail.getImageId();
		msgMap.put("PicUrl", picUrl );//PicUrl	是	图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
		String url = "http://191914ts83.51mypc.cn/OfferSys/servlet/DvrControllerServlet?ctrl=show&id="+dvrDetail.getId()+"&htmlStatic="+dvrDetail.getHtmlStatic()+"&device=moblie&model="+dvrDetail.getModel();
		msgMap.put("Url", url);//Url	是	点击图文消息跳转链接
		//
		
		String xml = xmlp.getMultiXml(msgMap);
		System.out.println("=========================华丽的分隔线=================================");
		System.out.println(xml);
		out.println(xml);
	}
}