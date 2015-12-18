package net.shadowfacts.shadowlib.util;

import java.io.*;

/**
 * @author shadowfacts
 */
public class StreamRedirect extends Thread {

	private InputStream in;
	private OutputStream out;

	public StreamRedirect(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	@Override
	public void run() {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line;
			while ((line = reader.readLine()) != null) {
				out.write(line.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
