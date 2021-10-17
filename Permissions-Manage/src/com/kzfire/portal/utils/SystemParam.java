package com.kzfire.portal.utils;


/**
 * @author ysf
 *配置参数
 * 2014-8-13 下午3:12:01  
 */

public class SystemParam{
	private  static String imageService;

	public static String getImageService() {
		return imageService;
	}

	public  void setImageService(String imageService) {
		SystemParam.imageService = imageService;
	}
		
}
