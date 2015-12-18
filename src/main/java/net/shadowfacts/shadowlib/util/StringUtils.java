package net.shadowfacts.shadowlib.util;

import java.util.List;

/**
 * @author shadowfacts
 */
public class StringUtils {

	public static int count(String str, String countStr) {
		return (str.length() - str.replace(countStr, "").length()) / countStr.length();
	}

}
