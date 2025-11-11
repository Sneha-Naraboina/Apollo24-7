package com.setup;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BasePage {
    public static WebDriver driver;
    public static Properties prop;
    static WebDriverWait wait;
 
    public BasePage() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/com/Properties/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    public void initializeDriver(String browserName) {
        if (browserName == null || browserName.isEmpty()) {
            throw new RuntimeException("Browser name is missing in config.properties!");
        }
 
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + browserName);
        }
 
        driver.manage().window().maximize();
 
        String waitTime = prop.getProperty("implicit.wait");
        int implicitWait = (waitTime != null && !waitTime.isEmpty()) ? Integer.parseInt(waitTime) : 15;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
 
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
}