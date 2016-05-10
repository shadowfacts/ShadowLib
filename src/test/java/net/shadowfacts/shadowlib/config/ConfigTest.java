package net.shadowfacts.shadowlib.config;

import static org.junit.Assert.*;
import org.junit.Test;
import com.typesafe.config.ConfigFactory;

/**
 * @author shadowfacts
 */
public class ConfigTest {

	@Test
	public void testSavePublicConfig() {
		com.typesafe.config.Config config = ConfigManager.save(TestClass.class, com.typesafe.config.Config.class, ConfigFactory.empty());

		assertEquals(TestClass.test, config.getString("general.test"));
		assertEquals(TestClass.i, config.getInt("ints.i"));
	}

	@Test
	public void testLoadPublicConfig() {
		com.typesafe.config.Config config = ConfigManager.save(TestClass.class, com.typesafe.config.Config.class, ConfigFactory.empty());

		TestClass.test = "value2";
		TestClass.i = -1;

		ConfigManager.load(TestClass.class,  com.typesafe.config.Config.class, config);

		assertEquals(TestClass.test, "hello");
		assertEquals(TestClass.i, 3);
	}

	@Test
	public void testSavePrivateConfig() {
		com.typesafe.config.Config config = ConfigManager.save(Test2.class, com.typesafe.config.Config.class, ConfigFactory.empty());

		assertEquals(Test2.test, config.getString("general.test"));
	}

	@Test
	public void testLoadPrivateConfig() {
		com.typesafe.config.Config config = ConfigManager.save(Test2.class, com.typesafe.config.Config.class, ConfigFactory.empty());

		Test2.test = "value2";

		ConfigManager.load(Test2.class, com.typesafe.config.Config.class, config);

		assertEquals(Test2.test, "hello");

	}

	@Config(name = "test")
	public static class TestClass {

		@Config.Prop
		public static String test = "hello";

		@Config.Prop(category = "ints")
		public static int i = 3;

	}

	@Config(name = "test2")
	public static class Test2 {

		@Config.Prop
		private static String test = "hello";

	}

}
