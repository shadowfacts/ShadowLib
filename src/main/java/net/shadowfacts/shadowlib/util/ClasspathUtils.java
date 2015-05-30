package net.shadowfacts.shadowlib.util;

import net.shadowfacts.shadowlib.ShadowLib;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author shadowfacts
 */
public class ClasspathUtils {

    public static void addFileToClasspath(URL url) {
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

    public static void addFileToClasspath(File f) {
        try {
            addFileToClasspath(f.toURL());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void addFileToClasspath(String s) {
        addFileToClasspath(new File(s));
    }

}
