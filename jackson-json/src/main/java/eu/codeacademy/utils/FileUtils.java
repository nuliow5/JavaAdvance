package eu.codeacademy.utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUtils {

    public static File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = FileUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }
}
