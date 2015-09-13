package net.shadowfacts.shadowlib.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author shadowfacts
 */
public class ReflectUtils {

	private static HashMap<String, Class> nameClassMap = new HashMap<>();
	private static HashMap<FieldIdentifier, Field> fieldMap = new HashMap<>();

	public static Class getClass(String name) throws ClassNotFoundException {
		if (nameClassMap.containsKey(name)) {
			return nameClassMap.get(name);
		} else {
			return nameClassMap.put(name, Class.forName(name));
		}
	}

	public static Field getField(Class clazz, String name) throws NoSuchFieldException {
		FieldIdentifier id = new FieldIdentifier(clazz, name);
		if (fieldMap.containsKey(id)) {
			return fieldMap.get(id);
		} else {
			return fieldMap.put(id, clazz.getDeclaredField(name));
		}
	}

	public static Field getField(String clazz, String name) throws ClassNotFoundException, NoSuchFieldException {
		return getField(getClass(clazz), name);
	}

	private static class FieldIdentifier {
		public Class clazz;
		public String name;
		public FieldIdentifier(Class clazz, String name) {
			this.clazz = clazz;
			this.name = name;
		}

		@Override
		public boolean equals(Object obj) {
			return obj instanceof FieldIdentifier && obj.hashCode() == hashCode();
		}

		@Override
		public int hashCode() {
			return (clazz.hashCode() * 31) + (name.hashCode() * 31);
		}
	}

}
