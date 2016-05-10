package net.shadowfacts.shadowlib.config;

import net.shadowfacts.shadowlib.config.impl.typesafe.TypesafeAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shadowfacts
 */
public class ConfigManager {

	private static Map<Class<?>, Map> configClassToTypeAdapterMap = new HashMap<>();

	static {
		TypesafeAdapter.init();
	}

	// INTERNAL
	private static boolean hasConfigClazz(Class<?> configClazz) {
		return configClassToTypeAdapterMap.containsKey(configClazz);
	}

	@SuppressWarnings("unchecked")
	private static <C, V> Map<Class<V>, ConfigTypeAdapter<C, V>> getAdapterMap(Class<C> configClazz, Class<V> valueClazz) {
		return (Map<Class<V>, ConfigTypeAdapter<C, V>>)configClassToTypeAdapterMap.get(configClazz);
	}

	private static <C, V> ConfigTypeAdapter<C, V> getTypeAdapter(Class<C> configClazz, Class<V> valueClazz) {
		Map<Class<V>, ConfigTypeAdapter<C, V>> adapterMap = getAdapterMap(configClazz, valueClazz);
		if (adapterMap != null) {
			return adapterMap.get(valueClazz);
		}
		return null;
	}

	// PUBLIC
	public static <C> C save(Class<?> clazz, Class<C> configClazz, C config) {
		if (hasConfigClazz(configClazz) && clazz.isAnnotationPresent(Config.class)) {
			Config annotation = clazz.getAnnotation(Config.class);

			for (Field field : clazz.getDeclaredFields()) {
				if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(Config.Prop.class)) {

					Config.Prop prop = field.getAnnotation(Config.Prop.class);

					Class fieldClazz = field.getType();
					@SuppressWarnings("unchecked")
					ConfigTypeAdapter<C, Object> adapter = getTypeAdapter(configClazz, fieldClazz);

					if (adapter != null) {
						String name = prop.name().isEmpty() ? field.getName() : prop.name();

						try {
							field.setAccessible(true);

							config = adapter.writeToConfig(prop.category(), name, prop.description(), config, field.get(null));
						} catch (ReflectiveOperationException e) {
							System.err.println("Problem saving field " + field.getName() + " for config " + annotation.name() + "(" + clazz.getName() + ".class)");
							throw new RuntimeException(e);
						}
					}

				}
			}
		}

		return config;
	}

	public static <C> void load(Class<?> clazz, Class<C> configClazz, C config) {
		if (hasConfigClazz(configClazz) && clazz.isAnnotationPresent(Config.class)) {
			Config annotation = clazz.getAnnotation(Config.class);

			for (Field field : clazz.getDeclaredFields()) {
				if (Modifier.isStatic(field.getModifiers()) && field.isAnnotationPresent(Config.Prop.class)) {

					Config.Prop prop = field.getAnnotation(Config.Prop.class);

					Class fieldClazz = field.getType();
					@SuppressWarnings("unchecked")
					ConfigTypeAdapter<C, Object> adapter = getTypeAdapter(configClazz, fieldClazz);

					if (adapter != null) {
						String name = prop.name().isEmpty() ? field.getName() : prop.name();

						try {
							field.setAccessible(true);

							field.set(null, adapter.readFromConfig(prop.category(), name, config));
						} catch (ReflectiveOperationException e) {
							System.err.println("Problem loading field " + field.getName() + " for config " + annotation.name() + "(" + clazz.getName() + ".class)");
							throw new RuntimeException(e);
						}
					}

				}
			}
		}
	}

	public static <C, V> void registerTypeAdapter(Class<C> configClazz, Class<V> fieldClass, ConfigTypeAdapter<C, V> adapter) {
		if (!hasConfigClazz(configClazz)) {
			configClassToTypeAdapterMap.put(configClazz, new HashMap<>());
		}

		configClassToTypeAdapterMap.get(configClazz).put(fieldClass, adapter);
	}

}
