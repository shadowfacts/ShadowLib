package net.shadowfacts.shadowlib.config.impl.typesafe;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigValueFactory;
import net.shadowfacts.shadowlib.config.ConfigTypeAdapter;

import java.util.List;

/**
 * @author shadowfacts
 */
public class DoubleArrayAdapter implements ConfigTypeAdapter<Config, double[]> {

	public static final DoubleArrayAdapter instance = new DoubleArrayAdapter();

	private DoubleArrayAdapter() {
	}

	@Override
	public Config writeToConfig(String category, String name, String description, Config config, double[] value) {
		return config.withValue(category + "." + name, ConfigValueFactory.fromAnyRef(value, description));
	}

	@Override
	public double[] readFromConfig(String category, String name, Config config) {
		List<Double> list = config.getDoubleList(category + "." + name);
		double[] array = new double[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}
}
