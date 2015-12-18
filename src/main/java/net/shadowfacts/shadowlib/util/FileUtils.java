package net.shadowfacts.shadowlib.util;

import java.io.*;
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


	/**
	 * Recursively deletes all files and folders inside the specified folder (including the specified folder itself)
	 * @param dir
	 */
	public static void deleteDirRecursive(File dir) {
		File[] files = dir.listFiles();
		if (files != null) {
			for (File f : files) {
				if (f.isDirectory()) {
					deleteDirRecursive(f);
				} else {
					f.delete();
				}
			}
		}
		dir.delete();
	}

	/**
	 * Creates the given directory if not present
	 * @param dir The directory
	 * @return {@code null} if the directory already exists or the result of {@link File#mkdirs()} if it doesn't
	 */
	public static Boolean checkCreateDir(File dir) {
		if (!dir.exists()) return dir.mkdirs();
		return null;
	}

}
