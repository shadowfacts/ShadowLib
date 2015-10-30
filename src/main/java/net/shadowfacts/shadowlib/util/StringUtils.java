package net.shadowfacts.shadowlib.util;

import java.util.List;

/**
 * @author shadowfacts
 */
public class StringUtils {

	public static String join(List<String> list, String joinString) {
		return join(list.toArray(new String[0]), joinString);
	}

	public static String join(String[] list, String joinString) {
		String ret = null;

		for (int i = 0; i < list.length; i++) {
			if (i == 0) {
				ret = list[i];
			} else {
				ret += joinString;
				ret += list[i];
			}
		}

		return ret;
	}

	public static int count(String str, String countStr) {
		return str.length() - str.replace(countStr, "").length();
	}

}
