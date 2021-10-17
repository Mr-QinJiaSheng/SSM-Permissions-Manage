package com.kzfire.portal.utils;

/**
 * @author ysf
 * 2014-8-25 上午11:01:02  
 */
public class SysEnum {
	/**
	 * @author ysf
	 *流水类型
	 * 2014-12-4 上午9:41:20  
	 */
	public enum NewsType {
		//1banner广告(950*220) 2公司新闻 3行业新闻 4 招聘 
		BANNER(1),
		COMNEWS(2),TRADENEWS(3),JOBNEWS(4);
		int val;
		NewsType(int val)
		{
			this.val = val;
		}
		public int getVal() {
			return val;
		}
	}
}