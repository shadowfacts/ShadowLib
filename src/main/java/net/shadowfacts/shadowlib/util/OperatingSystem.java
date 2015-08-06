package net.shadowfacts.shadowlib.util;


/**
 * @author shadowfacts
 */
public enum OperatingSystem {

	LINUX("linux", "bsd", "unix"),
	WINDOWS("windows", "win"),
	OSX("osx", "mac"),
	UNKNOWN("unknown");

	private String[] names;

	OperatingSystem(String... names) {
		this.names = names;
	}

	public static OperatingSystem getOS() {
		String name = System.getProperty("os.name");

		for (OperatingSystem os : values()) {
			for (String s : os.names) {
				if (name.toLowerCase().contains(s)) {
					return os;
				}
			}
		}

		return UNKNOWN;
	}

}
