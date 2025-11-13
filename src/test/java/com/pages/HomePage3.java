package com.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage3 {
    private static WebDriverWait wait;
    private static WebDriver driver;

    public HomePage3(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Buy Medicines']")
    private WebElement buyMedicinesLink;

    @FindBy(xpath = "//div[@data-placeholder='Search Medicines']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='searchProduct']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@id='searchButton']") // ✅ Adjust locator if needed
    private WebElement searchButton;

    public void clickBuyMedicines1() {
        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
        buyMedicinesLink.click();
        System.out.println("Navigated to Buy Medicines");
    }

    public void clickSearchBar1() {
        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
        searchBar.click();
        System.out.println("Search bar clicked");
    }

    public void enterMedicine(String medicine) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();
        searchInput.sendKeys(medicine);

        // Trigger search
        //wait.until(ExpectedConditions.elementToBeClickable(searchButton));
       // searchButton.click();

        //  Verify input is present
        String enteredValue = searchInput.getAttribute("value");
        Assert.assertEquals(enteredValue, medicine, "Medicine name not entered correctly!");
        System.out.println("Medicine entered and search triggered: " + medicine);
    }
//    public boolean verifyProductDetailPage() {
//    try {
//        wait.until(ExpectedConditions.visibilityOf(productTitle));
//        Reports.generateReport(driver, test, Status.PASS, "Product detail page displayed successfully");
//        return true;
//    } catch (TimeoutException te) {
//        Reports.generateReport(driver, test, Status.FAIL, "Product detail page not displayed");
//        return false;
//    }
//}
}