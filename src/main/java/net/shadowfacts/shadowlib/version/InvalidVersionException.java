package net.shadowfacts.shadowlib.version;

/**
 * @author shadowfacts
 */
public class InvalidVersionException extends RuntimeException {
	public InvalidVersionException(String msg) {
		super(msg);
	}

	public InvalidVersionException(String msg, Object... args) {
		this(String.format(msg, args));
	}
}
