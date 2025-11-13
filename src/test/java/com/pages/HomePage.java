











package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
       
        
    }

    // PageFactory element locators
    @FindBy(xpath = "//a[contains(text(), 'Buy Medicines')]")
    private WebElement buyMedicinesLink;

    @FindBy(xpath = "//div[@class='SearchPlaceholder_sRoot__ZK2aL']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='searchProduct']")
    private WebElement searchInput;
    
    
    

    

    
    //  Validate Home Page Title
    public void validateHomePageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Home page title mismatch! Expected to contain: " + expectedTitle);
        System.out.println("Home Page Loaded Successfully: " + actualTitle);
    }

    
    
    //  Click on "Buy Medicines" link 
//    public void clickBuyMedicines() {
//        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink)).click();
//        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
//        buyMedicinesLink.click();
//        System.out.println("Navigated to Buy Medicines"); 	
//    }

    
    
    public void clickBuyMedicines() {
    	
    	
        wait.until(ExpectedConditions.visibilityOf(buyMedicinesLink));
        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));

        // Scroll into view using Actions
        new Actions(driver).moveToElement(buyMedicinesLink).perform();

        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
        Assert.assertTrue(buyMedicinesLink.isEnabled(), "Buy Medicines link is not enabled!");

        buyMedicinesLink.click();
        System.out.println("Navigated to Buy Medicines");
        
    }
    
    
    
    
    //  Click on the search bar\\\\
    public void clickSearchBar() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
        searchBar.click();
        System.out.println("Search bar clicked");
    }

    //  Enter medicine name in the search bar
    public void enterMedicineName(String medicineName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        Assert.assertTrue(searchInput.isDisplayed(), "Search input field is not visible!");
        searchInput.clear();
        searchInput.sendKeys(medicineName);
        searchInput.sendKeys(Keys.ENTER);
        System.out.println("Searching for medicine: " + medicineName);
    }

    // Optional: Get page title
    public String getPageTitle() {
        return driver.getTitle();
    }
}











