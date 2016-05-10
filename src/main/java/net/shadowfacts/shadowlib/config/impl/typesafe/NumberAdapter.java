package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

/**
 * @author shadowfacts
 */
public class NumberAdapter implements ConfigTypeAdapter<Config, Number> {

	public static final NumberAdapter instance = new NumberAdapter();

	private NumberAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Number value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Number readFromConfig(String category, String name, Config config) {
		return config.getNumber(category + "." + name);
	}

}
