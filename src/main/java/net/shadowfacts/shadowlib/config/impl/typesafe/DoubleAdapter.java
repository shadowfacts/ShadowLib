package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

/**
 * @author shadowfacts
 */
public class DoubleAdapter implements ConfigTypeAdapter<Config, Double> {

	public static final DoubleAdapter instance = new DoubleAdapter();

	private DoubleAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Double value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Double readFromConfig(String category, String name, Config config) {
		return config.getDouble(category + "." + name);
	}

}
