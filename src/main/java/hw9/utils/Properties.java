package hw9.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class Properties {

    private static final Logger logger = LoggerFactory.getLogger(Properties.class);
    private static String fileName = "config.properties";
    private static java.util.Properties prop = new java.util.Properties();

    public static String getPropByKey(String propKey) {
        if (!prop.containsKey(propKey)) {
            prop = readPropertiesFromFile(fileName);
        }
        return prop.getProperty(propKey, null);
    }

    private static java.util.Properties readPropertiesFromFile(String fileName) {

        try (InputStream input = Properties.class.getClassLoader()
                .getResourceAsStream(fileName)) {
            if (input == null) {
                logger.error("Properties file not found");
            }
            prop.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
