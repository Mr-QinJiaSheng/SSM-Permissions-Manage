package com.kzfire.portal.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	private final static String PATTEN="sqy222111sasd..sad32";
	public static String encrypt(String str)
	{
		return DigestUtils.md5Hex(str+PATTEN);
	}
	public static void main(String[] a)
	{
		System.out.println(encrypt("123456"));
	}
}
