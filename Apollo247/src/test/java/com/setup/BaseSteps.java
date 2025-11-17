package com.setup;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.parameters.PropertyReader;
 
public class BaseSteps {
    public static WebDriver driver;
    public static Properties prop; // ✅ Global properties variable
 
    // Launch browser based on config
    public static void launchBrowser() {
        prop = PropertyReader.readProperty(); // ✅ Initialize properties
        String browser = prop.getProperty("browserName");
        String url = prop.getProperty("sourceUrl");
 
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Training\\SeleniumGrid\\chromedriver.exe");


Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.geolocation",2); // 1 = Allow, 2 = Block

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\Training\\SeleniumGrid\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser specified in config.properties");
            return;
        }
        
        
        driver.get(url);
        driver.manage().window().maximize();
        String newurl=prop.getProperty("targetUrl");
        driver.get(newurl);
        driver.manage().window().maximize();
        
    }
 
    // Sleep utility
    public static void sleep(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
 
	
}