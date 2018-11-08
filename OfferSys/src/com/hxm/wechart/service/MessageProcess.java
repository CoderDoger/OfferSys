package com.hxm.wechart.service;
import java.util.Map;
public interface MessageProcess {

	/**
	 *@author hxm
	 * @param msgMap
	 * 发送文本消息
	 * @param response 
	 */
	public void sendTextMsg(Map<String, String> msgMap);
	/**
	 *@author hxm
	 * @param fromUserName
	 * 发图片本消息
	 */
	public void sendImageMsg(Map<String, String> msgMap);
	/**
	 *@author hxm
	 * @param msgMap
	 * 发送语音消息
	 */
	public void sendVoiceMsg(Map<String, String> msgMap);
	/**
	 *@author hxm
	 * @param fromUserName
	 * 发送视频消息
	 */
	public void sendVideoMsg(Map<String, String> msgMap);
	/**
	 *@author hxm
	 * @param fromUserName
	 * 发送音乐消息
	 */
	public void sendMusicMsg(Map<String, String> msgMap);
	/**
	 *@author hxm
	 * @param fromUserName
	 * 发送图文消息
	 */
	public void sendMultiMsg(Map<String, String> msgMap,String keyWord);
	

}
