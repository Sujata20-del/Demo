package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//this is your ConfigReader class, which helps you read values from a .properties file
public class ConfigReader {

    private static Properties properties;
//constructor
    public ConfigReader() {
    try {
        FileInputStream fis = new FileInputStream("src/test/resources.properties");
        properties = new Properties();
        properties.load(fis);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
