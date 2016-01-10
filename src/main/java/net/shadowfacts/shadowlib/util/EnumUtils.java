package net.shadowfacts.shadowlib.util;

/**
 * @author shadowfacts
 */
public class EnumUtils {

	public static Enum getNextValue(Enum current) {
		int currentId = current.ordinal();
		Enum[] values = current.getClass().getEnumConstants();
		int next = currentId + 1 > values.length - 1 ? 0 : currentId + 1;
		return values[next];
	}

}
