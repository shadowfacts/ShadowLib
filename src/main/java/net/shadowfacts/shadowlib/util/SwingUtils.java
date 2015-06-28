package net.shadowfacts.shadowlib.util;

import net.shadowfacts.shadowlib.log.Logger;

import javax.swing.*;

/**
 * @author shadowfacts
 */
public class SwingUtils {

	private static final Logger log = new Logger("ShadowLib|SwingUtils");

	public static final String systemLaf = UIManager.getSystemLookAndFeelClassName();
	public static final String crossPlatformLaf = UIManager.getCrossPlatformLookAndFeelClassName();
	public static final String motifLaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";

	public static void setLookAndFeel(String lafName, JFrame frame) {
		try {
			UIManager.setLookAndFeel(lafName);
			if (frame != null) {
				SwingUtilities.updateComponentTreeUI(frame);
				frame.pack();
			}
		} catch (ClassNotFoundException e) {
			log.error("Could not find Look and Feel class!");
			e.printStackTrace();
		} catch (InstantiationException e) {
			log.error("Could not instantiate Look and Feel class!");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("Could not access Look and Feel class!");
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			log.error("This Look and Feel is not supported!");
			e.printStackTrace();
		}
	}

	public static void setLookAndFeel(LookAndFeel laf, JFrame frame) {
		try {
			UIManager.setLookAndFeel(laf);
			if (frame != null) {
				SwingUtilities.updateComponentTreeUI(frame);
				frame.pack();
			}
		} catch (UnsupportedLookAndFeelException e) {
			log.error("This Look and Feel is not supported!");
			e.printStackTrace();
		}
	}

}
