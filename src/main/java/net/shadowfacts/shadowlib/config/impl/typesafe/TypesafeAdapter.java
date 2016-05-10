package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import net.shadowfacts.shadowlib.config.ConfigManager;

/**
 * @author shadowfacts
 */
public class TypesafeAdapter {

	public static void init() {
		if (classExists("com.typesafe.config.Config")) {
			ConfigManager.registerTypeAdapter(Config.class, Boolean.class, BooleanAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, boolean.class, BooleanAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Boolean[].class, BoxedBooleanArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, boolean[].class, BooleanArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Number.class, NumberAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Number[].class, NumberArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Integer.class, IntegerAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Integer[].class, BoxedIntegerArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, int.class, IntegerAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, int[].class, IntegerArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Long.class, LongAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Long[].class, BoxedLongArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, long.class, LongAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, long[].class, LongArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Double.class, DoubleAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, Double[].class, BoxedDoubleArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, double.class, DoubleAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, double[].class, DoubleArrayAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, String.class, StringAdapter.instance);
			ConfigManager.registerTypeAdapter(Config.class, String[].class, StringArrayAdapter.instance);
		}
	}

	private static boolean classExists(String name) {
		try {
			Class.forName(name);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
