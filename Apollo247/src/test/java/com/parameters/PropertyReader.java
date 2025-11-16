
package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop = new Properties();

    static {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/PropertiesFile/Profile.properties";
        try (FileInputStream fis = new FileInputStream(filePath)) {
            prop.load(fis);
            System.out.println("Loaded properties from: " + filePath);
        } catch (IOException e) {
            System.err.println(" Failed to load properties file: " + filePath);
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        String value = prop.getProperty(key);
        if (value == null) {
            System.out.println(" Property key not found: " + key);
        }
        return value;
    }
}
 
//=====================the above original==================

//============reports code below//======================

    













