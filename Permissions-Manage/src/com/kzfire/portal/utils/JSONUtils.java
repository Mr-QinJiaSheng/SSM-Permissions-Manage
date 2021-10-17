package com.kzfire.portal.utils;

import java.util.List;


import com.alibaba.fastjson.JSON;
public class JSONUtils {


	public static <T> List<T> parssJsonArray(String  arr,
			Class<T> class1) {
		return JSON.parseArray(arr,class1);  
	}
	
	public static String parseList(List<?> list) {
		
		return JSON.toJSONString(list);
		
	}


}
