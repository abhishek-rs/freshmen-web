package com.freshmen.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class PasswordUtils {
	public static String HashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] data = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
		return DatatypeConverter.printHexBinary(data);
	}
}
