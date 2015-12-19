package net.shadowfacts.shadowlib.util;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tests for {@link net.shadowfacts.shadowlib.util.StringUtils}
 * @author shadowfacts
 */
public class StringUtilsTest {

	@Test
	public void testCount() {
		assertEquals(StringUtils.count("hello world", "l"), 3);
		assertEquals(StringUtils.count("hello world", "z"), 0);
		assertEquals(StringUtils.count("hello world", "ll"), 1);
	}

	@Test
	public void testContainsOne() {
		List<String> strings = new ArrayList<>();
		strings.add("a");
		strings.add("b");
		strings.add("c");
		assertTrue(StringUtils.containsOne("abc", strings));
		assertTrue(StringUtils.containsOne("abz", strings));
		assertTrue(StringUtils.containsOne("ayz", strings));
		assertFalse(StringUtils.containsOne("xyz", strings));
	}

}
