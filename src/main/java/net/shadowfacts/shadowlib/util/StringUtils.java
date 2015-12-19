package net.shadowfacts.shadowlib.util;

import java.util.List;

/**
 * @author shadowfacts
 */
public class StringUtils {

	/**
	 * Counts the number of times a string occurs inside another string
	 * @param str
	 * @param countStr
	 * @return
	 */
	public static int count(String str, String countStr) {
		return (str.length() - str.replace(countStr, "").length()) / countStr.length();
	}

	/**
	 * Check if the given string contains 1 of the given group of strings
	 * @param str
	 * @param strings
	 * @return
	 */
	public static boolean containsOne(String str, Iterable<String> strings) {
		for (String s : strings) {
			if (str.contains(s)) {
				return true;
			}
		}
		return false;
	}

}
