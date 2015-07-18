package net.shadowfacts.shadowlib.util;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * @author shadowfacts
 */
public class DesktopUtils {

	public static void openWebpage(URI uri) {
		if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			try {
				Desktop.getDesktop().browse(uri);
			} catch (IOException e) {
				System.err.println("There was a problem opening the URI " + uri);
				e.printStackTrace();
			}
		}
	}

	public static void openWebpage(URL url) throws URISyntaxException {
		openWebpage(url.toURI());
	}

	public static void openWebpage(String str) throws URISyntaxException{
		openWebpage(new URI(str));
	}

}
