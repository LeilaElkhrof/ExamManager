package com.fstg.gestion.exams.model.service.util;

import java.security.MessageDigest;


public class HashUtil {

	public static String hash(String pwd) throws Exception {
		 MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(pwd.getBytes());

	        byte byteData[] = md.digest();

	        //convertir le tableau de bits en une format hexadécimal - méthode 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
			return sb.toString();

	}

	
}
