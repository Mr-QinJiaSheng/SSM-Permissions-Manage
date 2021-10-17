package com.kzfire.portal.utils;


/**
 * @author yushifei
 * 统一的返回对象
 * 2014-4-9
 */
public class ResultVo {
	private int result=ResultCodeEnum.PARAM_ERROR.getVal();
	private String msg="param error";
	private Object data=null;
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
