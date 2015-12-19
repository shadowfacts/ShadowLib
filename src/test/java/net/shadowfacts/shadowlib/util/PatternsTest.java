package net.shadowfacts.shadowlib.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * @author shadowfacts
 */
public class PatternsTest {

	@Test
	public void testFindAllMatchesIn() {
		Pattern p = Pattern.compile("a");
		List<MatchResult> matches = new ArrayList<>();
		Patterns.findAllMatchesIn(p, "aba").forEach(matches::add);

		assertEquals(matches.size(), 2);
		assertEquals(matches.get(0).group(), "a");
		assertEquals(matches.get(0).start(), 0);
		assertEquals(matches.get(1).group(), "a");
		assertEquals(matches.get(1).start(), 2);
	}

}
