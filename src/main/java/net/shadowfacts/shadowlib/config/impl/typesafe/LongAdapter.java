package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

/**
 * @author shadowfacts
 */
public class LongAdapter implements ConfigTypeAdapter<Config, Long> {

	public static final LongAdapter instance = new LongAdapter();

	private LongAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Long value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Long readFromConfig(String category, String name, Config config) {
		return config.getLong(category + "." + name);
	}

}
