package net.shadowfacts.shadowlib.util.os;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @author shadowfacts
 */
public class OSUtils {

	public static void setOSXDockIcon(Image image) {
		try {
			Class application = Class.forName("com.apple.eawt.Application");
			Method getApplication = application.getMethod("getApplication");
			Method setDockIconImage = application.getMethod("setDockIconImage", Image.class);
			setDockIconImage.invoke(getApplication.invoke(null), image);
		} catch (ClassNotFoundException e) {
			System.err.println("com.apple.eawt.Application could not be found, ignoring");
		} catch (NoSuchMethodException e) {
			System.err.println("getApplication or setDockIconImage could not be found");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.err.println("Could not access getApplication");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.err.println("Could not invoke getApplication on null");
			e.printStackTrace();
		}
	}

	public static void setOSXDockIcon(URL url) {
		setOSXDockIcon(Toolkit.getDefaultToolkit().getImage(url));
	}

}
