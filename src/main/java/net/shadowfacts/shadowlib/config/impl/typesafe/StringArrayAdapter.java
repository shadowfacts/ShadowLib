package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class StringArrayAdapter implements ConfigTypeAdapter<Config, String[]> {

	public static final StringArrayAdapter instance = new StringArrayAdapter();

	private StringArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, String[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public String[] readFromConfig(String category, String name, Config config) {
		List<String> list = config.getStringList(category + "." + name);
		return list.toArray(new String[list.size()]);
	}

}
