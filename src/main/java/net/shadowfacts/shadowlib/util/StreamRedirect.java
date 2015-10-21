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
		try {
			InputStreamReader streamReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(streamReader);
			String line = null;
			while ((line = reader.readLine()) != null) {
				out.write(reader.readLine().getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
