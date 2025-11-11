package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Lab Tests']")
    private WebElement labTestsLink;

//    @FindBy(xpath = "//a[contains(text(),'View All')]")
//    private WebElement viewAllLink;

    @FindBy(xpath = "//header[h2[contains(text(),'Top Booked Tests')]]//a[contains(text(),'View All')]")
    private WebElement viewAllLink;
    
//    @FindBy(xpath = "//h2[contains(text(),'Top Booked Tests')]")
//    private WebElement verifyViewAll;
    

    @FindBy(xpath = "//h1[contains(text(),'Top Booked Tests')]")
    private WebElement verifyViewAll;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLabTestsLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(labTestsLink))
            .click();
    }

    public void clickViewAll() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(viewAllLink));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Click normally first
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS click
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }

            // Wait for URL to change
            wait.until(ExpectedConditions.urlContains("top-booked-tests"));

        } catch (Exception e) {
            System.out.println("Failed to click View All: " + e.getMessage());
        }
    }
    
    public boolean verifyViewAll() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.urlContains("top-booked-tests"));
            return verifyViewAll.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    @FindBy(xpath = "(//span[text()='Add'])[1]") // Adjust locator based on actual button text
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Upgrade To']") // Adjust locator for pop-up
    private WebElement cartPopup;

    public void clickAddToCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Try normal click
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        } catch (TimeoutException e) {
            System.out.println("Add to Cart button not found or not clickable: " + e.getMessage());
        }
    }
    	
    public boolean verifyPopupDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(cartPopup));
            return cartPopup.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

	




}