package net.shadowfacts.shadowlib.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author shadowfacts
 */
public class Patterns {

	/**
	 * @see <a href="http://stackoverflow.com/questions/6020384/create-array-of-regex-matches">http://stackoverflow.com/questions/6020384/create-array-of-regex-matches</a>
	 * @param p
	 * @param input
	 * @return
	 */
	public static Iterable<MatchResult> findAllMatchesIn(Pattern p, CharSequence input) {
		return () -> new Iterator<MatchResult>() {

			private Matcher matcher = p.matcher(input);
			private MatchResult pending;

			@Override
			public boolean hasNext() {
				if (pending == null && matcher.find()) {
					pending = matcher.toMatchResult();
				}
				return pending != null;
			}

			@Override
			public MatchResult next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				MatchResult next = pending;
				pending = null;
				return next;
			}
		};
	}

}
