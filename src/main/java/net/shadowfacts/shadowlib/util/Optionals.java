package net.shadowfacts.shadowlib.util;

import java.util.Optional;

/**
 * @author shadowfacts
 */
public class Optionals {

	public static <T> Optional<T> orElse(Optional<T> maybe, Optional<T> fallback) {
		if (maybe.isPresent()) {
			return maybe;
		} else {
			return fallback;
		}
	}

}
