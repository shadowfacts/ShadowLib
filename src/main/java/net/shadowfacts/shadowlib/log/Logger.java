package net.shadowfacts.shadowlib.log;

/**
 * @author shadowfacts
 */
public class Logger {

	public static boolean ENABLE_VERBOSE = false;

	private String channel;

	private boolean verbose;

	public Logger(String channel) {
		this(channel, false);
	}

	public Logger(String channel, boolean enableVerbose) {
		this.channel = channel;
		this.verbose = enableVerbose;
	}

	public Logger log(LogLevel level, String msg) {
		String chan = "[" + this.channel + "]";
		switch (level) {
			case DEBUG:
				if (verbose) System.out.println(chan + msg);
			case INFO:
				if (verbose) System.out.println(chan + msg);
			case WARN:
				System.err.println(chan + msg);
			case ERROR:
				System.err.println(chan + msg);
		}
		return this;
	}

	public Logger debug(String msg) {
		return log(LogLevel.DEBUG, msg);
	}

	public Logger debug(String msg, Object... params) {
		return debug(String.format(msg, params));
	}

	public Logger info(String msg) {
		return log(LogLevel.INFO, msg);
	}

	public Logger info(String msg, Object... params) {
		return info(String.format(msg, params));
	}

	public Logger warn(String msg) {
		return log(LogLevel.WARN, msg);
	}

	public Logger warn(String msg, Object... params) {
		return warn(String.format(msg, params));
	}

	public Logger error(String msg) {
		return log(LogLevel.ERROR, msg);
	}

	public Logger error(String msg, Object... params) {
		return error(String.format(msg, params));
	}

}
