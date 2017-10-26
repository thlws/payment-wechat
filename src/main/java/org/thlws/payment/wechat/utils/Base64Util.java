package org.thlws.payment.wechat.utils;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {

	
	
	/**
	 * BASE64加密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(String str) {
		byte[] b = null;
		String s = null;
		try {
			b = str.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (b != null) {
			s = new BASE64Encoder().encode(b);
		}
		return s;
	}

	/**
	 * BASE64解密
	 * 
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String decryptBASE64(String str) {
		byte[] b = null;
		String result = null;
		if (str != null) {
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				b = decoder.decodeBuffer(str);
				result = new String(b, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	public static void main(String[] args) {
		String v = "hanley";
		try {
			String r1 = encryptBASE64(v);
			System.out.println(r1);
			String r2 = decryptBASE64("aGFubGV5");
			System.out.println(r2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
