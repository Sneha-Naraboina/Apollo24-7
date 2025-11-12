//package com.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
// 
//public class HomePage {
// 
//    WebDriver driver;
//
//}
//package com.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
//
//public class HomePage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    // Constructor
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//

//package com.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import java.time.Duration;
//
//import org.testng.Assert;
//
//public class HomePage {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    // Constructor
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    // Validate Home Page Title
//    public void validateHomePageTitle(String expectedTitle) {
//       String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.contains(expectedTitle), "Home page title mismatch! Expected to contain: " + expectedTitle);
//        System.out.println("Home Page Loaded Successfully: " + actualTitle);
//    }
//
//    // Click on "Buy Medicines" link
//    public void clickBuyMedicines() {
//        WebElement buyMedicinesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Buy Medicines']")));
//        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
//        buyMedicinesLink.click();
//        System.out.println("Navigated to Buy Medicines");
//    }
//
//    // Click on the search bar
//    public void clickSearchBar() {
//        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-placeholder='Search Medicines']")));
//        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
//        searchBar.click();
//        System.out.println("Search bar clicked");
//    }
//
//    // Enter medicine name in the search bar
//    public void enterMedicineName(String medicineName) {
//        WebElement searchInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='searchProduct']")));
//        Assert.assertTrue(searchInput.isDisplayed(), "Search input field is not visible!");
//        searchInput.clear();
//        searchInput.sendKeys(medicineName);
//        searchInput.sendKeys(Keys.ENTER);
//        System.out.println(" Searching for medicine: " + medicineName);
//    }
//
//    // Check if search results are displayed
////    public void validateSearchResultsDisplayed() {
////        WebElement resultsSection = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'product-list')]")));
////        Assert.assertTrue(resultsSection.isDisplayed(), "Search results are not displayed!");
////        System.out.println("Search results displayed successfully");
////    }
//
//    // Optional: Get page title
//    public String getPageTitle() {
//        return driver.getTitle();
//    }
//}











package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ✅ Constructor initializes PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // ✅ PageFactory element locators
    @FindBy(xpath = "//a[text()='Buy Medicines']")
    private WebElement buyMedicinesLink;

    @FindBy(xpath = "//div[@data-placeholder='Search Medicines']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='searchProduct']")
    private WebElement searchInput;

    // ✅ Validate Home Page Title
    public void validateHomePageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Home page title mismatch! Expected to contain: " + expectedTitle);
        System.out.println("Home Page Loaded Successfully: " + actualTitle);
    }

    // ✅ Click on "Buy Medicines" link
    public void clickBuyMedicines() {
        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
        buyMedicinesLink.click();
        System.out.println("Navigated to Buy Medicines");
    }

    // ✅ Click on the search bar
    public void clickSearchBar() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
        searchBar.click();
        System.out.println("Search bar clicked");
    }

    // ✅ Enter medicine name in the search bar
    public void enterMedicineName(String medicineName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        Assert.assertTrue(searchInput.isDisplayed(), "Search input field is not visible!");
        searchInput.clear();
        searchInput.sendKeys(medicineName);
        searchInput.sendKeys(Keys.ENTER);
        System.out.println("Searching for medicine: " + medicineName);
    }

    // ✅ Optional: Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}