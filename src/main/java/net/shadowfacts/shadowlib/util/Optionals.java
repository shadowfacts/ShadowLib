package net.shadowfacts.shadowlib.util;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

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

	public static <T, X> X ifPresent(Optional<T> maybe, Function<T, X> ifPresent, Supplier<X> ifEmpty) {
		if (maybe.isPresent()) {
			return ifPresent.apply(maybe.get());
		}
		return ifEmpty.get();
	}

}
