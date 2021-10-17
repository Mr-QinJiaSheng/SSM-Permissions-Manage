package com.kzfire.portal.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ysf 字符串工具集 2014-9-10 下午2:13:41
 */
public class MStringUtils {
	
	
	public static String TimeTostr(Timestamp time,String s) {
		if(s==null) s="yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(s);
		Date date;
		try {
			date=new Date(time.getTime());
			return format.format(date);
		} catch (Exception e1) {
		}
		return "";
	}
	
	public static Timestamp strToTime(String str,String s) {
		if(s==null) s="yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(s);
		Date date;
		try {
			date = format.parse(str);
			Timestamp ts = new Timestamp(date.getTime());
			return ts;
		} catch (ParseException e1) {
		}
		return null;
	}

	public static Timestamp getTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	public static String getNo() {
		SimpleDateFormat f = new SimpleDateFormat("yyMMddHHmmss");
		Random r = new Random();
		return f.format(new Date()) + (r.nextInt(8999) + 1000);
	}
}
