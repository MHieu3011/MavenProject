package com.ptit.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HashFunctionUtil {

	public static String MD5(String password) {
		return DigestUtils.md5Hex(password).toUpperCase();
	}

}
