package com.hxm.wechart.util;

import java.util.Formatter;
import java.util.Map;
public class XmlTmplate {
	private Formatter fm = new Formatter();
	//文本消息
	private String textMsg = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Content><![CDATA[%s]]></Content><Url><![CDATA[www.baidu.com]]></Url></xml>";
	//图片消息
	private String imageMsg = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Image><MediaId><![CDATA[%s]]></MediaId></Image></xml>";
	//语音消息
	private String voiceMsg = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Voice><MediaId><![CDATA[%s]]></MediaId></Voice></xml>";
	//视频消息
	private String vedioMsg = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><Video><MediaId><![CDATA[%s]]></MediaId><Title><![CDATA[%s]]></Title><Description><![CDATA[%s]]></Description></Video> </xml>"; 
	
	private String item = "<item><Title><![CDATA[%s]]></Title><Description><![CDATA[%s]]></Description><PicUrl><![CDATA[%s]]></PicUrl><Url><![CDATA[%s]]></Url></item>";
	private String multiMsg = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[%s]]></MsgType><ArticleCount>%s</ArticleCount><Articles><item><Title><![CDATA[%s]]></Title> <Description><![CDATA[%s]]></Description><PicUrl><![CDATA[%s]]></PicUrl><Url><![CDATA[%s]]></Url></item></Articles></xml>";
	//文本
	public String getTextXml(Map<String, String> msgMap){
		byte[] by = fm.format(
				textMsg,
				msgMap.get("FromUserName"),
				msgMap.get("ToUserName"),
				msgMap.get("CreateTime"),
				msgMap.get("MsgType"),
				msgMap.get("Content")).toString().getBytes();
		fm.close();
		return new String(by);
	}
	//图片
	public String getImageXml(Map<String, String> msgMap){
		byte[] by = fm.format(
				imageMsg,
				msgMap.get("FromUserName"),
				msgMap.get("ToUserName"),
				msgMap.get("CreateTime"),
				msgMap.get("MsgType"),
				msgMap.get("MediaId")).toString().getBytes();
		fm.close();
		return new String(by);
	}
	//语音
	public String getVoiceXml(Map<String, String> msgMap){
		byte[] by = fm.format(
				voiceMsg,
				msgMap.get("FromUserName"),
				msgMap.get("ToUserName"),
				msgMap.get("CreateTime"),
				msgMap.get("MsgType"),
				msgMap.get("MediaId")).toString().getBytes();
		fm.close();
		return new String(by);
	}
	//视频
	public String getVideoXml(Map<String, String> msgMap){
		
		byte[] by = fm.format(
				vedioMsg,
				msgMap.get("FromUserName"),
				msgMap.get("ToUserName"),
				msgMap.get("CreateTime"),
				msgMap.get("MsgType"),
				msgMap.get("MediaId"),
				msgMap.get("ThumbMediaId"),
				msgMap.get("MsgId")).toString().getBytes();
		fm.close();
		return new String(by);
	}
	//视频
	public String getMultiXml(Map<String, String> msgMap){
		
		byte[] by = fm.format(
				multiMsg,
				msgMap.get("FromUserName"),
				msgMap.get("ToUserName"),
				msgMap.get("CreateTime"),
				msgMap.get("MsgType"),
				msgMap.get("ArticleCount"),
				msgMap.get("Title"),
				msgMap.get("Description"),
				msgMap.get("PicUrl"),
				msgMap.get("Url")).toString().getBytes();
		fm.close();
		return new String(by);
	}
}
