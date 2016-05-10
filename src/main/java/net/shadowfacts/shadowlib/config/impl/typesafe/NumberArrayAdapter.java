package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class NumberArrayAdapter implements ConfigTypeAdapter<Config, Number[]> {

	public static final NumberArrayAdapter instance = new NumberArrayAdapter();

	private NumberArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Number[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Number[] readFromConfig(String category, String name, Config config) {
		List<Number> list = config.getNumberList(category + "." + name);
		return list.toArray(new Number[list.size()]);
	}

}
