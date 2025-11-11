//package com.parameters;
// 
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Properties;
// 
//public class PropertyReader {
//	public static Properties readProperty() {
//		Properties prop = null;
//		String fileName = ".\\src\\test\\resources\\PropertiesFile\\Profile.properties";
//		try
//		{
//			FileInputStream fis  = new FileInputStream(fileName);
//			prop = new Properties();
//			prop.load(fis);				
//		}
//		catch(FileNotFoundException e)
//		{
//			System.out.println("File name or file path is not correct");
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//		
//		return prop;
//		
//	}
// 
//}

//==========the below is original code============
package com.parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop;

    static {
        String fileName = ".\\src\\test\\resources\\PropertiesFile\\Profile.properties";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            System.out.println(" Failed to load properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
//========the above is original code==========















