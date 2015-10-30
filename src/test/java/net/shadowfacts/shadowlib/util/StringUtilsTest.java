package net.shadowfacts.shadowlib.util;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Tests for {@link net.shadowfacts.shadowlib.util.StringUtils}
 * @author shadowfacts
 */
public class StringUtilsTest {

	@Test
	public void testJoinArray() {
		assertEquals(StringUtils.join(new String[]{"hello", "world"}, " "), "hello world");
	}

	@Test
	public void testJoinList() {
		List<String> list = Arrays.asList("hello", "world");
		assertEquals(StringUtils.join(list, " "), "hello world");
	}

	@Test
	public void testCount() {
		assertEquals(StringUtils.count("hello world", "l"), 3);
	}

}
