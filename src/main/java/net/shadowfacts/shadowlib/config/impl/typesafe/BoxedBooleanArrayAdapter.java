package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class BoxedBooleanArrayAdapter implements ConfigTypeAdapter<Config, Boolean[]> {

	public static final BoxedBooleanArrayAdapter instance = new BoxedBooleanArrayAdapter();

	private BoxedBooleanArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Boolean[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Boolean[] readFromConfig(String category, String name, Config config) {
		List<Boolean> list = config.getBooleanList(category + "." + name);
		return list.toArray(new Boolean[list.size()]);
	}

}
