package com.kzfire.portal.utils;

/**
 * @author yushifei
 * 返回代码
 * 2014-4-9
 */
public enum ResultCodeEnum {
	SUCCESS(1),
	BUSINESS_ERROR(0), 
	AUTH_ERROR(-1), 
	SERVICE_ERROR(-2), 
	PARAM_ERROR(-3);
	int val;
	ResultCodeEnum(int val)
	{
		this.val = val;
	}
	public int getVal() {
		return val;
	}
}
