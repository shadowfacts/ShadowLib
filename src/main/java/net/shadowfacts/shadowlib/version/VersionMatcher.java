package net.shadowfacts.shadowlib.version;



/**
 * @author shadowfacts
 */
public class VersionMatcher {

	private static final String[] WILDCARD_STRINGS = new String[] {
			"*", "x", "X"
	};

	private String matcherString;

	/**
	 * Constructor used to create a new reusable {@link net.shadowfacts.shadowlib.version.VersionMatcher}
	 * @param matcherString
	 */
	public VersionMatcher(String matcherString) {
		this.matcherString = matcherString;
	}

	/**
	 * Checks if the {@link net.shadowfacts.shadowlib.version.Version} is valid for the matcher {@link java.lang.String} passed to the constructor
	 * @param v
	 * @return
	 */
	public boolean matches(Version v) {
		return matches(matcherString, v);
	}

	/**
	 * Check if the {@link net.shadowfacts.shadowlib.version.Version} is valid for the matcher {@link java.lang.String}
	 * @param matcherString
	 * @param v
	 * @return
	 */
	public static boolean matches(String matcherString, Version v) {
		for (String s : WILDCARD_STRINGS) {
			if (matcherString.equals(s)) {
				return true;
			}
		}

		if (matcherString.charAt(0) == '^') {
			return matchesGreaterThan(matcherString.substring(1), v);
		}

		boolean majorValid = false;
		boolean minorValid = false;
		boolean patchValid = false;
		boolean labelValid = false;

		String major = "";
		String minor = "";
		String patch = "";
		String label = "";

		String[] arr = matcherString.split("\\-");
		String[] arr2 = arr[0].split("\\.");

		if (arr2.length != 3) {
			throw new InvalidVersionException("Cannot create Version with %d version arguments", arr2.length);
		}

		major = arr2[0];
		minor = arr2[1];
		patch = arr2[2];

		if (arr.length == 2) { // There is 1 label

			if (arr[1] == null) {
				throw new InvalidVersionException("Cannot create Version with null label");
			} else if (arr[1].equals("")) {
				throw new InvalidVersionException("Cannot create Version with empty label");
			}

			label = arr[1];

		} else if (arr.length > 2) { //  There are multiple labels

			for (int i = 1; i < arr.length - 1; i++) {

				if (arr[i] == null) {
					throw new InvalidVersionException("Cannot create Version with null label");
				} else if (arr[i].equals("")) {
					throw new InvalidVersionException("Cannot create Version with empty label");
				}

				label += arr[i];

			}

		}

		for (String s : WILDCARD_STRINGS) {
			if (!majorValid) majorValid = major.equals(s);
			if (!minorValid) minorValid = minor.equals(s);
			if (!patchValid) patchValid = patch.equals(s);
		}

		if (!majorValid) majorValid = (Integer.parseInt(major) == v.getMajor());
		if (!minorValid) minorValid = (Integer.parseInt(minor) == v.getMinor());
		if (!patchValid) patchValid = (Integer.parseInt(patch) == v.getPatch());

		if (!labelValid) labelValid = !v.hasLabel() && (label == null || label.equals(""));
		if (!labelValid) labelValid = label.equals(v.getLabel());

		return majorValid && minorValid && patchValid && labelValid;
	}

	private static boolean matchesGreaterThan(String s, Version v) {
		return v.greaterThan(new Version(s));
	}

}
