package net.shadowfacts.shadowlib.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.function.Consumer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

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
	 * Downloads a file from the specified URL to the destination.
	 * @param url
	 * @param destination
	 * @throws IOException Thrown if the URL is invalidm the input stream cannot be opened, the output file cannot be found, problem transferring the file
	 */
	public static void downloadFile(String url, String destination) throws IOException {
		downloadFile(new URL(url), destination);
	}

	/**
	 * Downloads a file from the specified URL to the destination.
	 * @param url
	 * @param destination
	 * @throws IOException Thrown if the input stream cannot be opened, the output file cannot be found, problem transferring the file
	 */
	public static void downloadFile(URL url, String destination) throws IOException {
		ReadableByteChannel in = Channels.newChannel(url.openStream());

		File parent = new File(destination).getParentFile();
		if (!parent.exists()) parent.mkdirs();

		FileChannel out = new FileOutputStream(destination).getChannel();
		out.transferFrom(in, 0, Long.MAX_VALUE);
	}

	public static void unzipFile(String zip, String outputFolder) throws IOException{
		byte[] buffer = new byte[1024];
		File folder = new File(outputFolder);
		if (!folder.exists()) {
			folder.mkdirs();
		}

		ZipInputStream in = new ZipInputStream(new FileInputStream(zip));

		ZipEntry entry  = in.getNextEntry();
		while (entry != null) {
			if (!entry.isDirectory()) {
				String name = entry.getName();
				File newFile = new File(outputFolder + "/" + name);

				new File(newFile.getParent()).mkdirs();

				FileOutputStream out = new FileOutputStream(newFile);

				int read;
				while ((read = in.read(buffer)) > 0) {
					out.write(buffer, 0, read);
				}

				out.close();
			}

			entry = in.getNextEntry();
		}

		in.closeEntry();
		in.close();
	}

}
