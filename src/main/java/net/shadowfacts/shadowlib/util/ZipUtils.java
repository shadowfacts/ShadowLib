package net.shadowfacts.shadowlib.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Zip related utilities
 *
 * @author shadowfacts
 */
public class ZipUtils {

	/**
	 * Zips a folder into a given file.
	 * Based on the <a href="http://stackoverflow.com/a/29675600">StackOverflow answer</a>
	 * @param folder The input folder
	 * @param zipFile The output file
	 * @throws IOException if there is an i/o problem writing the zip
	 */
	public static void zipDir(File folder, File zipFile) throws IOException {
		zipDir(folder, new FileOutputStream(zipFile));
	}

	/**
	 * Zips a folder into a given OutputStream
	 * Based on the <a href="http://stackoverflow.com/a/29675600>StackOverflow answer</a>
	 * @param folder The input folder
	 * @param outputStream The output stream
	 * @throws IOException if there is an i/o problem writing the zip
	 */
	public static void zipDir(File folder, OutputStream outputStream) throws IOException {
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream)) {
			processZipDir(folder, zipOutputStream, folder.getPath().length() + 1);
		}
	}

	private static void processZipDir(File folder, ZipOutputStream zipOutputStream, int prefixLength) throws IOException {
		for (File f : folder.listFiles()) {
			if (f.isFile()) {
				ZipEntry zipEntry = new ZipEntry(f.getPath().substring(prefixLength));
				zipOutputStream.putNextEntry(zipEntry);
				try (FileInputStream inputStream = new FileInputStream(f)) {
					IOUtils.copy(inputStream, zipOutputStream);
				}
				zipOutputStream.closeEntry();
			} else if (f.isDirectory()) {
				processZipDir(f, zipOutputStream, prefixLength);
			}
		}
	}


	public static void unzipToDir(String zipPath, String outputDirPath) throws IOException {
		FileUtils.checkCreateDir(new File(outputDirPath));

		try (ZipInputStream in = new ZipInputStream(new FileInputStream(zipPath))) {

			ZipEntry entry = in.getNextEntry();
			while (entry != null) {
				if (!entry.isDirectory()) {
					String name = entry.getName();
					File f = new File(outputDirPath + File.separator + name);

					FileUtils.checkCreateDir(f.getParentFile());

					try (FileOutputStream out = new FileOutputStream(f)) {
						IOUtils.copy(in, out);
					}
				}

				entry = in.getNextEntry();
			}

			in.closeEntry();
		}
	}


}
