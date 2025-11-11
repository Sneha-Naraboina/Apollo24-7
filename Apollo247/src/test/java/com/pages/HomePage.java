
//==========the original code below ==============
package com.pages;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class HomePage {

    WebDriver driver;

    public HomePage() {
        this.driver = BaseSteps.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div[1]/div/a/div")
    public WebElement healthMonitorsLink;
    
    

    public void scrollToHealthMonitors() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", healthMonitorsLink);
    }

    public void clickHealthMonitors() {
        try {
            healthMonitorsLink.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", healthMonitorsLink);
        }
    }
    


    public void assertHealthMonitorsPageDisplayed() {
        String expectedUrl = PropertyReader.getProperty("expectedUrl").trim();
        String actualUrl = driver.getCurrentUrl().trim();
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch: Expected vs Actual");
        System.out.println(" Health Monitors page loaded successfully.");
   }   
  
   }
//    ================the original is above code======

// package com.pages;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import com.parameters.PropertyReader;
//import com.setup.BaseSteps;
//
//public class HomePage {
//    WebDriver driver;
//
//    public HomePage() {
//        this.driver = BaseSteps.driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div[1]/div/a/div")
//    public WebElement healthMonitorsLink;
//
//    public void scrollToHealthMonitors() {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", healthMonitorsLink);
//    }
//
//    public void clickHealthMonitors() {
//        try {
//            healthMonitorsLink.click();
//        } catch (ElementClickInterceptedException e) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", healthMonitorsLink);
//        }
//    }
//
//    public void assertHealthMonitorsPageDisplayed() {
//        String expectedUrl = PropertyReader.getProperty("expectedUrl").trim();
//        String actualUrl = driver.getCurrentUrl().trim();
//        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch: Expected vs Actual");
//        System.out.println("Health Monitors page loaded successfully.");
//    }
//}

	














