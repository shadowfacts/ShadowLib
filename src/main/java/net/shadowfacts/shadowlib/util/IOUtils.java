package net.shadowfacts.shadowlib.util;

import java.io.*;

/**
 * @author shadowfacts
 */
public class IOUtils {

	public static final int EOF = -1;
	private static final int BUFFER_SIZE = 4096;

	/**
	 * Copies the contents of one stream to another
	 * @param in The input stream
	 * @param out The output stream
	 * @throws IOException if there's an i/o problem copying the stream
	 */
	public static void copy(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[BUFFER_SIZE];
		int n;
		while ((n = in.read(buffer)) != EOF) {
			out.write(buffer, 0, n);
		}
	}

	/**
	 * Gets the contents of the input stream as a {@link String}
	 * @param in The input stream
	 * @return The contents of the input stream
	 * @throws IOException if there was an i/o problem copying the stream
	 */
	public static String copyToString(InputStream in) throws IOException {
		return copyToString(new BufferedReader(new InputStreamReader(in)));
	}

	/**
	 * Gets the contents of an input buffered reader as a {@link String}
	 * @param in The input reader
	 * @return The contents of the input reader
	 * @throws IOException if there was an i/o problem copying the stream
	 */
	public static String copyToString(BufferedReader in) throws IOException {
		StringBuffer buffer = new StringBuffer();
		int read;
		char[] chars = new char[1024];
		while ((read = in.read(chars)) != EOF) {
			buffer.append(chars, 0, read);
		}
		return buffer.toString();
	}


}
