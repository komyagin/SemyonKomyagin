package hw6.utils;

import hw6.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public final class Properties {

    private static final Logger logger = LoggerFactory.getLogger(Properties.class);
    private static java.util.Properties properties;

    static {
        properties = new java.util.Properties();
        try (InputStream inputStream = BaseTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            logger.error("Properties file not found {}", e);
        }
    }

    private Properties() {}

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
