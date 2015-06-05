package net.shadowfacts.shadowlib.util;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for {@link net.shadowfacts.shadowlib.util.FileUtils}
 * @author shadowfacts
 */
public class FileUtilsTest {

    @Test
    public void testForEachInDirectory() {
        ArrayList<String> filenames = new ArrayList<>();
        FileUtils.forEachInDirectory(new File("/"), (File f) -> {
            filenames.add(f.getName());
        });
        System.out.println(filenames);
        assertFalse(filenames.isEmpty());
    }

}
