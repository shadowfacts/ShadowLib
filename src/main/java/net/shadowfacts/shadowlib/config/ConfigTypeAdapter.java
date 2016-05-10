package net.shadowfacts.shadowlib.config;

/**
 * @author shadowfacts
 *
 * @param <C> The Configuration type
 * @param <V> The Value type
 */
public interface ConfigTypeAdapter<C, V> {

	C writeToConfig(String category, String name, String description, C config, V value);

	V readFromConfig(String category, String name, C config);

}
