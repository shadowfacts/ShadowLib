package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class BoxedIntegerArrayAdapter implements ConfigTypeAdapter<Config, Integer[]> {

	public static final BoxedIntegerArrayAdapter instance = new BoxedIntegerArrayAdapter();

	private BoxedIntegerArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Integer[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Integer[] readFromConfig(String category, String name, Config config) {
		List<Integer> list = config.getIntList(category + "." + name);
		return list.toArray(new Integer[list.size()]);
	}

}
