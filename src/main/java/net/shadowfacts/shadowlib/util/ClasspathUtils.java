package net.shadowfacts.shadowlib.util;

import net.shadowfacts.shadowlib.ShadowLib;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * A variety of utilities related to classpath-y things
 * @author shadowfacts
 */
public class ClasspathUtils {

	/**
	 * Add  the specified {@link java.net.URL} to the classpath
	 * @param url The URL
	 */
	public static void addURLToClasspath(URL url) {
		try {
			URLClassLoader urlClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();
			Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
			addURL.setAccessible(true);
			addURL.invoke(urlClassLoader, url);
		} catch (NoSuchMethodException e) {
			ShadowLib.log.error("URLClassLoader#addURL did not exist! This is a problem, report this immediately!");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			ShadowLib.log.error("Could not access URLClassLoader#addURL! This is a problem, report this immediately!");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			ShadowLib.log.error("URLClassLoader#addURL was invoked on the wrong target! This is a problem, report this immediately!");
			e.printStackTrace();
		}
	}

	/**
	 * Adds the specified {@link java.io.File} to the classpath
	 * @param file
	 */
	public static void addFileToClasspath(File file) {
		try {
			addURLToClasspath(file.toURI().toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Reads the specified resource from the classpath and writes it to a temporary file.
	 * @param name The name of the resource in the classpath
	 * @return The temporary file, {@code null} if there was an error
	 */
    public static File readFileFromClasspath(String name) {
        try {
            File tempFile = File.createTempFile("ShadowLibClasspathFile", ".tmp");
            InputStream inputStream = ClasspathUtils.class.getResourceAsStream(name);
			FileOutputStream fileOutputStream = new FileOutputStream(tempFile);

			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, read);
			}

			return tempFile;

        } catch (IOException e) {
			ShadowLib.log.error("Error creating the temp file!");
			e.printStackTrace();
		}
		return null;
    }

}
