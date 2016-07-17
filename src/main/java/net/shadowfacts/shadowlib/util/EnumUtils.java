package net.shadowfacts.shadowlib.util;

/**
 * @author shadowfacts
 */
public class EnumUtils {

	@SuppressWarnings("unchecked")
	public static <E extends Enum> E getNextValue(E current) {
		int currentId = current.ordinal();
		Enum[] values = current.getClass().getEnumConstants();
		int next = currentId + 1 > values.length - 1 ? 0 : currentId + 1;
		return (E)values[next];
	}

	@SuppressWarnings("unchecked")
	public static <E extends Enum> E getPreviousValue(E current) {
		int currentId = current.ordinal();
		Enum[] values = current.getClass().getEnumConstants();
		int prev = currentId - 1 < 0 ? values.length - 1 : currentId - 1;
		return (E)values[prev];
	}

}
