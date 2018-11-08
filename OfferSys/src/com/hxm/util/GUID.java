package com.hxm.util;

import java.math.BigInteger;
import java.util.Random;

public class GUID {
	//GUID就是UUID：唯一
	public static String generateGUID(){
		return new BigInteger(165, new Random()).toString(36).toUpperCase();
	}
}
