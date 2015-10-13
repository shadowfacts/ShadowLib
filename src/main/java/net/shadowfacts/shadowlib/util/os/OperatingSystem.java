package net.shadowfacts.shadowlib.util.os;


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

	public static OperatingSystem getSystemOS() {
		return getOS(System.getProperty("os.name"));
	}

	public static OperatingSystem getOS(String name) {
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
