package com.hxm.util;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormBeanUtil {
	public static <T>T fillBean(HttpServletRequest request,Class<T> clazz){
		try {
			T bean = clazz.newInstance();
			Map<String,String[]> map = request.getParameterMap();
			/*for( Entry<String, String[]> en:map.entrySet()){
				System.out.println(en.getKey()+"==="+Arrays.toString(en.getValue()));
			}*/
			BeanUtils.populate(bean, map);		
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
