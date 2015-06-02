package net.shadowfacts.shadowlib.version;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author shadowfacts
 */
public class VersionMatcherTest {

	@Test
	public void canConstructVersionMatcher() {
		assertNotNull(new VersionMatcher("1.2.x"));
	}

	@Test
	public void canMatchWithWildcards() {
		VersionMatcher m1 = new VersionMatcher("1.2.x");
		VersionMatcher m2 = new VersionMatcher("1.2.*");
		Version v1 = new Version("1.2.3");
		Version v2 = new Version("1.3.2");
		boolean test = m1.matches(v1);

		assertTrue(m1.matches(v1));
		assertTrue(m2.matches(v1));
		assertFalse(m2.matches(v2));
	}

	@Test
	public void canMatchWithGreaterThan() {
		VersionMatcher matcher = new VersionMatcher("^1.2.3");
		Version v1 = new Version("2.0.0");
		Version v2 = new Version("1.3.0");
		Version v3 = new Version("1.2.4");
		Version v4 = new Version("1.0.0");
		assertTrue(matcher.matches(v1));
		assertTrue(matcher.matches(v2));
		assertTrue(matcher.matches(v3));
	}

	@Test
	public void canMatchWithLessThan() {
		VersionMatcher matcher = new VersionMatcher("<1.2.3");
		Version v1 = new Version("2.0.0");
		Version v2 = new Version("1.3.0");
		Version v3 = new Version("1.2.4");
		Version v4 = new Version("1.0.0");
		assertFalse(matcher.matches(v1));
		assertFalse(matcher.matches(v2));
		assertFalse(matcher.matches(v3));
	}

	@Test
	public void canMatchWithGreaterThanOrEqualTo() {
		VersionMatcher matcher = new VersionMatcher(">=1.2.3");
		Version v1 = new Version("2.0.0");
		Version v2 = new Version("1.3.0");
		Version v3 = new Version("1.2.4");
		Version v4 = new Version("1.2.3");
		assertTrue(matcher.matches(v1));
		assertTrue(matcher.matches(v2));
		assertTrue(matcher.matches(v3));
		assertTrue(matcher.matches(v4));
	}

	@Test
	public void canMatchWithLessThanOrEqualTo() {
		VersionMatcher matcher = new VersionMatcher("<=1.2.3");
		Version v1 = new Version("1.0.0");
		Version v2 = new Version("1.1.0");
		Version v3 = new Version("1.1.1");
		Version v4 = new Version("0.0.1");
		assertTrue(matcher.matches(v1));
		assertTrue(matcher.matches(v2));
		assertTrue(matcher.matches(v3));
		assertTrue(matcher.matches(v4));
	}
}
