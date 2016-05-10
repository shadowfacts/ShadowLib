package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class BoxedLongArrayAdapter implements ConfigTypeAdapter<Config, Long[]> {

	public static final BoxedLongArrayAdapter instance = new BoxedLongArrayAdapter();

	private BoxedLongArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Long[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Long[] readFromConfig(String category, String name, Config config) {
		List<Long> list = config.getLongList(category + "." + name);
		return list.toArray(new Long[list.size()]);
	}

}
