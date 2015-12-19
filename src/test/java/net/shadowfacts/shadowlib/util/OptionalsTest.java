package net.shadowfacts.shadowlib.util;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author shadowfacts
 */
public class OptionalsTest {

	@Test
	public void testOrElse() {
		Optional<String> optional1 = Optional.of("Optional 1");
		Optional<String> optional2 = Optional.of("Optional 2");

		assertTrue(Optionals.orElse(optional1, optional2) == optional1);
		assertTrue(Optionals.orElse(Optional.empty(), optional2) == optional2);
	}

	@Test
	public void testIfPresent() {
		Optional<String> optional1 = Optional.of("Optional 1");
		Function<String, Character> ifPresent = s -> s.charAt(0);
		Supplier<Character> ifEmpty = () -> 'Z';

		assertEquals(Optionals.ifPresent(optional1, ifPresent, ifEmpty), (Character)'O');
		assertEquals(Optionals.ifPresent(Optional.empty(), ifPresent, ifEmpty), (Character)'Z');
	}

}
