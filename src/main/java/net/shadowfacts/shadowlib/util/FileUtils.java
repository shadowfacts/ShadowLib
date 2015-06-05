package net.shadowfacts.shadowlib.util;

import java.io.File;
import java.util.function.Consumer;

/**
 * Various utilities related to the file system.
 * @author shadowfacts
 */
public class FileUtils {

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
