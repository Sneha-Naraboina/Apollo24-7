

        
		
	




	


package com.pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage2 {
	private static WebDriverWait wait;
	private static  WebDriver driver;
   

    //  Constructor initializes PageFactory
    public HomePage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // PageFactory element locators
    @FindBy(xpath = "//a[text()='Buy Medicines']")
    private static  WebElement buyMedicinesLink;

    @FindBy(xpath = "//*[@id='Browse by Health Conditions Web']/div[2]/div[1]/div/a/div[2]/h3")
    private WebElement diabetesCare;

    @FindBy(xpath = "//h2[text()='Apollo Pharmacy Smart Blood Glucose Monitoring Bluetooth System with Diabetes Management App, APG-01 + 25 Test Strips, 1 kit']")
    private WebElement healthConditionElement;

    //  Actions
    public static void clickBuyMedicines() {
        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
        buyMedicinesLink.click();
        System.out.println("Navigated to Buy Medicines");
    }

    public void clickDiabetesCare1() {
        wait.until(ExpectedConditions.elementToBeClickable(diabetesCare));
        Assert.assertTrue(diabetesCare.isDisplayed(), "Diabetes Care element is not visible!");
        diabetesCare.click();
        System.out.println("Clicked Diabetes Care");
    }

    public void healthconditionselementshouldbedisplayed() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
            org.openqa.selenium.By.xpath("//h2[text()='Apollo Pharmacy Smart Blood Glucose Monitoring Bluetooth System with Diabetes Management App, APG-01 + 25 Test Strips, 1 kit']")
        ));
        Assert.assertTrue(healthConditionElement.isDisplayed(), "Health condition element is not visible!");
        healthConditionElement.click();
    }
}



















//h2[text()="Apollo Pharmacy Smart Blood Glucose Monitoring Bluetooth System with Diabetes Management App, APG-01 + 25 Test Strips, 1 kit"]