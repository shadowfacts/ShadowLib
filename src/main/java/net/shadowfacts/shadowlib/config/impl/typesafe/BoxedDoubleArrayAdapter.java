package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class BoxedDoubleArrayAdapter implements ConfigTypeAdapter<Config, Double[]> {

	public static final BoxedDoubleArrayAdapter instance = new BoxedDoubleArrayAdapter();

	private BoxedDoubleArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, Double[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public Double[] readFromConfig(String category, String name, Config config) {
		List<Double> list = config.getDoubleList(category + "." + name);
		return list.toArray(new Double[list.size()]);
	}

}
