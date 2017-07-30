package net.shadowfacts.shadowlib.util;

import java.util.Arrays;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author shadowfacts
 */
public class NearestColorTest {

	@Test
	public void testFindSame() {
		Color res = NearestColor.find(0xFFFFFF, Color.values(), Color::getColor);
		assertEquals(Color.WHITE, res);
	}

	@Test
	public void testFindClosest() {
		Color res1 = NearestColor.find(0xf1c40f, Color.values(), Color::getColor);
		assertEquals(Color.GOLD, res1);

		Color res2 = NearestColor.find(0x3498db, Color.values(), Color::getColor);
		assertEquals(Color.DARK_AQUA, res2);

		Color res3 = NearestColor.find(0xe91e63, Color.values(), Color::getColor);
		assertEquals(Color.RED, res3);
	}

	private enum Color {
		BLACK(0x000000),
		DARK_BLUE(0x0000AA),
		DARK_GREEN(0x00AA00),
		DARK_AQUA(0x00AAAA),
		DARK_RED(0xAA0000),
		DARK_PURPLE(0xAA00AA),
		GOLD(0xFFAA00),
		GRAY(0xAAAAAA),
		DARK_GRAY(0x555555),
		BLUE(0x5555FF),
		GREEN(0x55FF55),
		AQUA(0x55FFFF),
		RED(0xFF5555),
		LIGHT_PURPLE(0xFF55FF),
		YELLOW(0xFFFF55),
		WHITE(0xFFFFFF);

		private final int color;

		Color(int color) {
			this.color = color;
		}

		public int getColor() {
			return color;
		}
	}

}
