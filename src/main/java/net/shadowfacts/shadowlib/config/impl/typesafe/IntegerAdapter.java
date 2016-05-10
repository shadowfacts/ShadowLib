package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

/**
 * @author shadowfacts
 */
public class IntegerAdapter implements ConfigTypeAdapter<Config, Integer> {

	public static final IntegerAdapter instance = new IntegerAdapter();

	private IntegerAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Integer value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Integer readFromConfig(String category, String name, Config config) {
		return config.getInt(category + "." + name);
	}

}
