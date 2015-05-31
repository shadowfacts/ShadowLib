package net.shadowfacts.shadowlib.version;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author shadowfacts
 */
public class VersionTest {

	@Test
	public void canConstructVersion() {
		assertNotNull(new Version("1.2.3-alpha"));
	}

	@Test
	public void canCopyVersion() {
		Version v1 = new Version("1.2.3-alpha");
		Version v2 = v1.copy();
		assertEquals(v1, v2);
	}

	@Test
	public void canIncrementMajorWithoutLabelReset() {
		Version v1 = new Version("1.2.3-alpha").incrementMajor();
		Version v2 = new Version("2.0.0-alpha");
		assertEquals(v1, v2);
	}

	@Test
	public void canIncrementMajorWithLabelReset() {
		Version v1 = new Version("1.2.3-alpha").incrementMajor(true);
		Version v2 = new Version("2.0.0");
		assertEquals(v1, v2);
	}

	@Test
	public void canIncrementMinorWithoutLabelReset() {
		Version v1 = new Version("1.2.3-alpha").incrementMinor();
		Version v2 = new Version("1.3.0-alpha");
		assertEquals(v1, v2);
	}

	@Test
	public void canIncrementMinorWithLabelReset() {
		Version v1 = new Version("1.2.3-alpha").incrementMinor(true);
		Version v2 = new Version("1.3.0");
		assertEquals(v1, v2);
	}

	@Test
	public void canIncrementPatchWithoutLabelReset() {
		Version v1 = new Version("1.2.3-alpha").incrementPatch();
		Version v2 = new Version("1.2.4-alpha");
		assertEquals(v1, v2);
	}

	@Test
	public void canIncrementPatchWithLabelReset() {
		Version v1 = new Version("1.2.3-alpha").incrementPatch(true);
		Version v2 = new Version("1.2.4");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetMajorWithoutLabelReset() {
		Version v1 = new Version("1.2.3-alpha").setMajor(3);
		Version v2 = new Version("3.2.3-alpha");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetMajorVersionWithLabelReset() {
		Version v1 = new Version("1.2.3-alpha").setMajor(3, true);
		Version v2 = new Version("3.2.3");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetMinorVersionWithoutLabelReset() {
		Version v1 = new Version("1.2.3-alpha").setMinor(4);
		Version v2 = new Version("1.4.3-alpha");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetMinorVersionWithLabelReset() {
		Version v1 = new Version("1.2.3-alpha").setMinor(4, true);
		Version v2 = new Version("1.4.3");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetPatchVersionWithoutLabelReset() {
		Version v1 = new Version("1.2.3-alpha").setPatch(5);
		Version v2 = new Version("1.2.5-alpha");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetPatchVersionWithLabelReset() {
		Version v1 = new Version("1.2.3-alpha").setPatch(5, true);
		Version v2 = new Version("1.2.5");
		assertEquals(v1, v2);
	}

	@Test
	public void canSetLabel() {
		Version v1 = new Version("1.2.3-alpha").setLabel("beta");
		Version v2 = new Version("1.2.3-beta");
		assertEquals(v1, v2);
	}

	@Test
	public void canRemoveLabel() {
		Version v1 = new Version("1.2.3-alpha").removeLabel();
		Version v2 = new Version("1.2.3");
		assertEquals(v1, v2);
	}

	@Test
	public void canGetMajorVersion() {
		Version v = new Version("1.2.3-alpha");
		assertEquals(1, v.getMajor());
	}

	@Test
	public void canGetMinorVersion() {
		Version v = new Version("1.2.3.-alpha");
		assertEquals(2, v.getMinor());
	}

	@Test
	public void canGetPatchNumber() {
		Version v = new Version("1.2.3-alpha");
		assertEquals(3, v.getPatch());
	}

	@Test
	public void canGetLabel() {
		Version v = new Version("1.2.3-alpha");
		assertEquals("alpha", v.getLabel());
	}

	@Test
	public void canConvertToString() {
		Version v = new Version("1.2.3-alpha");
		assertEquals("1.2.3-alpha", v.toString());
	}

	@Test
	public void canCompareUsingEquals() {
		Version v1 = new Version("1.2.3-alpha");
		Version v2 = new Version("1.2.3-alpha");
		Version v3 = new Version("3.2.1-beta");
		assertTrue(v1.equals(v2));
		assertFalse(v1.equals(v3));
	}

	@Test
	public void canCompareUsingGreaterThan() {
		Version v1 = new Version("1.2.3");
		Version v2 = new Version("2.0.0");
		Version v3 = new Version("1.3.0");
		Version v4 = new Version("1.2.4");
		assertTrue(v2.greaterThan(v1));
		assertTrue(v3.greaterThan(v1));
		assertTrue(v4.greaterThan(v1));
		assertTrue(v1.lessThan(v2));
		assertTrue(v1.lessThan(v3));
		assertTrue(v1.lessThan(v4));
	}

}
