package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.Collections;
import java.util.List;

/**
 * @author shadowfacts
 */
public class BooleanArrayAdapter implements ConfigTypeAdapter<Config, boolean[]> {

	public static final BooleanArrayAdapter instance = new BooleanArrayAdapter();

	private BooleanArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, boolean[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public boolean[] readFromConfig(String category, String name, Config config) {
		List<Boolean> list = config.getBooleanList(category + "." + name);
		boolean[] array = new boolean[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

}
