package net.shadowfacts.shadowlib.util.enums;

import static org.junit.Assert.*;

import net.shadowfacts.shadowlib.util.EnumUtils;
import org.junit.Test;

/**
 * @author shadowfacts
 */
public class EnumUtilsTest {

	@Test
	public void testGetNextValue() {
		assertEquals(EnumUtils.getNextValue(TestEnum.THING1), TestEnum.THING2);
		assertEquals(EnumUtils.getNextValue(TestEnum.THING2), TestEnum.THING1);
	}

	@Test
	public void testGetPrevValue() {
		assertEquals(EnumUtils.getPreviousValue(TestEnum.THING2), TestEnum.THING1);
		assertEquals(EnumUtils.getPreviousValue(TestEnum.THING1), TestEnum.THING2);
	}

}
