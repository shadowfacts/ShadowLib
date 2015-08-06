package net.shadowfacts.shadowlib.util.os;

import net.shadowfacts.shadowlib.log.Logger;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author shadowfacts
 */
public class OSUtils {

	private static Logger log = new Logger("OSUtils");

	public static void setOSXDockIcon(Image image) {
		try {
			Class application = Class.forName("com.apple.eawt.Application");
			Method getApplication = application.getMethod("getApplication");
			Method setDockIconImage = application.getMethod("setDockIconImage", Image.class);
			setDockIconImage.invoke(getApplication.invoke(null), image);
		} catch (ClassNotFoundException e) {
			log.error("com.apple.eawt.Application could not be found, ignoring");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			log.error("getApplication or setDockIconImage could not be found");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			log.error("Could not access getApplication");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			log.error("Could not invoke getApplication on null");
			e.printStackTrace();
		}
	}

	public static void setOSXDockIcon(URL url) {
		setOSXDockIcon(Toolkit.getDefaultToolkit().getImage(url));
	}

}
