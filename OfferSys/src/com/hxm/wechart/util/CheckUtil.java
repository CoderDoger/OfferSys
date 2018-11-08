package com.hxm.wechart.util;

import java.util.Arrays;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * У��Ĺ�����
 */
public class CheckUtil {

	    private static final String token = "weixin";
	    public static boolean checkSignature(String signature,String timestamp,String nonce){
	         
	        String[] arr = new String[] { token, timestamp, nonce };
	         
	        // ����
	        Arrays.sort(arr);
	        // ����ַ�
	        StringBuilder content = new StringBuilder();
	        for (int i = 0; i < arr.length; i++) {
	            content.append(arr[i]);
	        }
	         
	        // sha1����
	        String temp = getSHA1String(content.toString());
	         
	        return temp.equals(signature); // ��΢�Ŵ��ݹ�����ǩ����бȽ�
	    }
	     
	    private static String getSHA1String(String data){
	        return DigestUtils.shaHex(data);    // ʹ��commons codec���sha1�ַ�
	    }
}
