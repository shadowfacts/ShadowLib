package net.shadowfacts.shadowlib.util;

import net.shadowfacts.shadowlib.log.LogLevel;
import net.shadowfacts.shadowlib.log.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author shadowfacts
 */
public class StreamRedirect extends Thread {

	private InputStream in;

	private Logger log;
	private LogLevel level;

	public StreamRedirect(InputStream in, Logger log, LogLevel level) {
		this.in = in;
		this.log = log;
		this.level = level;
	}

	@Override
	public void run() {
		try {
			InputStreamReader streamReader = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(streamReader);
			String line = null;
			while ((line = reader.readLine()) != null) {
				log.log(level, line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
