package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

/**
 * @author shadowfacts
 */
public class BooleanAdapter implements ConfigTypeAdapter<Config, Boolean> {

	public static final BooleanAdapter instance = new BooleanAdapter();

	private BooleanAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Boolean value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Boolean readFromConfig(String category, String name, Config config) {
		return config.getBoolean(category + "." + name);
	}

}
