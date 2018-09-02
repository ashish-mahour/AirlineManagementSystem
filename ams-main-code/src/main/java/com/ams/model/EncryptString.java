package com.ams.model;

import java.math.BigInteger;
import java.security.MessageDigest;

public class EncryptString {
	private static MessageDigest messageDigest;
	private static String encrpyString = null;

	public static String getEncryptString(String input) {
		try {
			messageDigest = MessageDigest.getInstance("SHA");
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte msgInByte[] = messageDigest.digest(input.getBytes());
		encrpyString = new BigInteger(1, msgInByte).toString(16);
		return encrpyString;
	}
	

}
