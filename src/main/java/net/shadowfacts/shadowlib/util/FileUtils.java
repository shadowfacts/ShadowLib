package net.shadowfacts.shadowlib.util;

import java.io.File;
import java.util.function.Consumer;

/**
 * Various utilities related to the file system.
 * @author shadowfacts
 */
public class FileUtils {

	/**
	 * Iterates over every {@link java.io.File} in a directory and executes the specified action for each one
	 * @param dir The directory to iterate over
	 * @param consumer A lambda to be execute for each {@link java.io.File}
	 *                 Takes one argument, a {@link java.io.File}
	 */
	public static void forEachInDirectory(File dir, Consumer<File> consumer) {
		File[] dirListing = dir.listFiles();
		if (dirListing != null) {
			for (File f : dirListing) {
				consumer.accept(f);
			}
		} else {
			throw new NullPointerException("dirListing was null");
		}
	}

}
