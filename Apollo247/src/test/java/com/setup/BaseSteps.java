//package com.setup;
// 
//import java.util.Properties;
// 
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
// 
//import com.parameters.PropertyReader;
// 
//public class BaseSteps {
//	public static WebDriver driver;
//    public static void launchBrowser()
//    {
//        Properties prop = PropertyReader.readProperty();
//        String browser = prop.getProperty("browserName");   
//        if (browser.equalsIgnoreCase("chrome"))             
//        {
//        	System.setProperty("webdriver.chrome.driver","C:\\Training materials\\JAVA\\Selenium Grid\\chromedriver.exe");
//            driver = new ChromeDriver();
//        }
//        else if (browser.equalsIgnoreCase("firefox"))       
//        {
//            driver = new FirefoxDriver();
//        }
//        else if (browser.equalsIgnoreCase("edge"))           
//        {
//            driver = new EdgeDriver();
//        }
//        else
//        {
//            System.out.println("Invalid browser specified in config.properties");
//            return;
//        }
//        String url = prop.getProperty("sourceUrl");
//        driver.get(url);
//        driver.manage().window().maximize();
//    }
//    public static void sleep(int msec)                     // Handling waits
//    {
//        try
//        {
//            Thread.sleep(msec);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//    }
// 
//}
//=============================================the below code 1st one which is from before copi(original)
package com.setup;

import com.parameters.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {
    public static WebDriver driver;

    public static void launchBrowser() {
        String browser = PropertyReader.getProperty("browserName").trim();
        String url = PropertyReader.getProperty("sourceUrl").trim();

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); // Or use WebDriverManager if configured
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() throws InterruptedException  {
        if (driver != null) {
            driver.quit();
        }
        Thread.sleep(1000);
    }
}
//===============the above code ==================











//package com.setup;
//
//import com.parameters.PropertyReader;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BaseSteps {
//    public static WebDriver driver;
//
//    public static void launchBrowser() {
//        String browser = PropertyReader.getProperty("browserName").trim();
//        String url = PropertyReader.getProperty("sourceUrl").trim();
//        
//        if (browser.equalsIgnoreCase("chrome")) {
//            driver = new ChromeDriver();
//        } else {
//            throw new RuntimeException("Unsupported browser: " + browser);
//        }
//
//        driver.manage().window().maximize();
//        driver.get(url);
//    }
//
//    public static void sleep(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void closeBrowser() throws InterruptedException {
//        if (driver != null) {
//            driver.quit();
//        }
//        Thread.sleep(1000);
//    }
//}












