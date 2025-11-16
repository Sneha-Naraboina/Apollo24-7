
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


//============the above origin code==========

//=============the below is report class============



//package com.setup;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.parameters.PropertyReader;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class BaseSteps {
//
//    public static WebDriver driver;
//    public static ExtentReports extent;
//    public static ExtentTest test;
//
//    public static void launchBrowser() {
//        String browser = PropertyReader.getProperty("browserName").trim();
//        String url = PropertyReader.getProperty("sourceUrl").trim();
//
//        try {
//            if (browser.equalsIgnoreCase("chrome")) {
//                driver = new ChromeDriver(); // Or use WebDriverManager if configured
//            } else {
//                throw new RuntimeException("Unsupported browser: " + browser);
//            }
//
//            driver.manage().window().maximize();
//            driver.get(url);
//
//            // Initialize ExtentTest if not already done
//            if (test != null) {
//                Reports.generateReport(driver, test, Status.PASS, "Browser launched and navigated to: " + url);
//            }
//
//        } catch (Exception e) {
//            if (test != null) {
//                Reports.generateReport(driver, test, Status.FAIL, "Failed to launch browser: " + e.getMessage());
//            }
//            throw new RuntimeException("Browser launch failed", e);
//        }
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
//        try {
//            if (driver != null) {
//                driver.quit();
//                if (test != null) {
//                    Reports.generateReport(driver, test, Status.PASS, "Browser closed successfully.");
//                }
//            }
//        } catch (Exception e) {
//            if (test != null) {
//                Reports.generateReport(driver, test, Status.FAIL, "Error while closing browser: " + e.getMessage());
//            }
//        }
//        Thread.sleep(1000);
//    }
//}


































