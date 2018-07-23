package com.ams.model;

import java.util.Random;

public class GlobalClass {
	public static String getOTP() {
		Random random = new Random();
		int otpNum = random.nextInt(899999);
		return String.valueOf(otpNum+100000);
	}
}
