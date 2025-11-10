package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileread_Manager {

    private static Fileread_Manager instance;
    private static Properties properties;

    public static Fileread_Manager getInstance() {
        if (instance == null) {
            instance = new Fileread_Manager();
        }
        return instance;
    }

    private Fileread_Manager() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("⚠️ Failed to load config.properties file! " + e.getMessage());
        }
    }



    public String getProperty(String getkey) {
        String value = properties.getProperty(getkey);
        if (value == null) {
            throw new RuntimeException("❌ Property not found in config.properties: " + getkey);
        }
        return value;
    }
}
