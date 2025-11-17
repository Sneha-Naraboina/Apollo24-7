package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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

    //  Constructor initializes PageFactory
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//a[text()='Buy Medicines']")
    private WebElement buyMedicinesLink;
    
    @FindBy(xpath="//*[@id=\"Top Grid 2 Web\"]/div/div[5]/div/a/h2")
    private WebElement clicklabtest;
    
    @FindBy(xpath="//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/div/div[1]/input")
    private WebElement clicksearch;
    
    @FindBy(xpath="//*[@id=\"fixedSearchCT\"]/div/div/div[1]/input")
    private WebElement clicksearch1;
    
    ////div[text()='Search Result']
    @FindBy(xpath="//div[@class='SearchResult_headerSection__UnHkD']")
    private WebElement verifypage;
    

    
    public void clickBuyMedicines() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
            Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
            buyMedicinesLink.click();
            System.out.println("Navigated to Buy Medicines");
        } catch (Exception e) {
            System.out.println("Exception in clickBuyMedicines: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickLabTest() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(clicklabtest));
            Assert.assertTrue(clicklabtest.isDisplayed(), "Lab Test button is not visible!");
            clicklabtest.click();
            System.out.println("Lab Test button clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickLabTest: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickSearch() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(clicksearch));
            Assert.assertTrue(clicksearch.isDisplayed(), "Search button is not visible!");
            clicksearch.click();
            System.out.println("Search button clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickSearch: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enterMedicine(String testname) {
        try {
            System.out.println(testname);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(clicksearch1));
            clicksearch1.clear();
            wait.until(ExpectedConditions.elementToBeClickable(clicksearch1));
            clicksearch1.sendKeys(testname);
            clicksearch1.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            System.out.println("Exception in enterMedicine: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean verify() {
        try {
            wait.until(ExpectedConditions.visibilityOf(verifypage)).isDisplayed();
            return true;
        } catch (Exception e) {
            System.out.println("Exception in verify: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    
}











//    //  PageFactory element locators
//    @FindBy(xpath = "//a[text()='Buy Medicines']")
//    private WebElement buyMedicinesLink;
 
//    @FindBy(xpath = "//a[text()='Buy Medicines']")
//  private WebElement buyMedicinesLink;
//   
// // Update locator for search bar to target the input field
////    @FindBy(xpath = "//input[@placeholder='Search Medicines']")
//    @FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[1]/div/div/div")
//    private WebElement searchBar;
//
//   
////    @FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div/div/div/div")
//    @FindBy(xpath="/html/body/div[2]/div/div/div[1]/div[1]/div")
//    private WebElement searchInput;
//
//    //  Validate Home Page Title
//    public void validateHomePageTitle(String expectedTitle) {
//        String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.contains(expectedTitle),
//                "Home page title mismatch! Expected to contain: " + expectedTitle);
//        System.out.println("Home Page Loaded Successfully: " + actualTitle);
//    }
//
//    //  Click on "Buy Medicines" link
//    public void clickBuyMedicines() {
//        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
//        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
//        buyMedicinesLink.click();
//        System.out.println("Navigated to Buy Medicines");
//    }
//
// 
////
////    //  Click on the search bar\\\\
//    public void clickSearchBar() {
//        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
//        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
//        searchBar.click();
//        System.out.println("Search bar clicked");
//    }
//
//    //  Enter medicine name in the search bar
//    public void enterMedicineName(String medicineName) {
//        wait.until(ExpectedConditions.visibilityOf(searchInput));
//        Assert.assertTrue(searchInput.isDisplayed(), "Search input field is not visible!");
////        searchInput.clear();
//        //searchInput.sendKeys(medicineName);
////        searchInput.sendKeys("Paracetamol");
//        //searchInput.sendKeys(Keys.ENTER);
//        System.out.println("Searching for medicine: " + medicineName);
//    }
//
//    // Optional: Get page title
//    public String getPageTitle() {
//        return driver.getTitle();
//    }
//}


