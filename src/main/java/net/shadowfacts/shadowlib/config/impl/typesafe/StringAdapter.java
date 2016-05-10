package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

/**
 * @author shadowfacts
 */
public class StringAdapter implements ConfigTypeAdapter<Config, String> {

	public static final StringAdapter instance = new StringAdapter();

	private StringAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, String value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public String readFromConfig(String category, String name, Config config) {
		return config.getString(category + "." + name);
	}

}
