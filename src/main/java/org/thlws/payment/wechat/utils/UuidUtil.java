package org.thlws.payment.wechat.utils;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;


public class UuidUtil {

	/**
	 * Example: "1cf5c5ed02a74f9187931ca7294c01d4" (32 characters)
	 * 
	 * @return uuid without '-' character
	 */
	static public String generateUuid() {
		String uuid = UUID.randomUUID().toString();
		return StringUtils.remove(uuid, "-");
	}
}
