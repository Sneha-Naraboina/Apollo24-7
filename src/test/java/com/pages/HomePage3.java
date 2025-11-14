package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.parameters.PropertyReader;
import com.setup.Reports;


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

    @FindBy(xpath = "//button[@id='searchButton']") 
    private WebElement searchButton;
    
    @FindBy(xpath ="//*[@id=\"Top Grid 2 Web\"]/div/div[2]/div/a/h2")
    private WebElement getmeds;
    
    @FindBy(xpath="//a[text()='View All Categories']")
    private WebElement view;
    
    @FindBy(xpath="//div[text()='Home > All categories'] ")//---------verify-----------------
    private WebElement check;
    
   @FindBy(xpath="//*[@id=\"SKU Widget 6 Web\"]/div[2]/div/div[1]/div/div/a/div/div[2]/div[1]/h2")
   private WebElement firstproduct;
   
   @FindBy(xpath="(//li[@class='Header_nav___g0oE'])[2]")
   private WebElement cart;
   
   @FindBy(xpath="//p[text()=' YOUR CART IS EMPTY']")
   private WebElement verify;

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
    //------------------------4th Scenario-------------------------------

public void clickGetMeds() {
        getmeds.click();
    }

public void clickViewAllCategory() {
	
	 wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
	Properties props = PropertyReader.readProperty();
	
    String viewallLocator = props.getProperty("viewall.link.xpath");
   
	WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(viewallLocator)));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", link);
	wait.until(ExpectedConditions.elementToBeClickable(view));
	view.click();
	}
	
////	public boolean Check()
////	{
////		wait.until(ExpectedConditions.visibilityOf(check));
////		return true;
////	}
//
//
//
//public boolean Check() {
//    wait.until(ExpectedConditions.visibilityOf(check));
//    Assert.assertTrue(check.isDisplayed(), "Check element is not visible!");
//    System.out.println("Check element is visible");
//    return true;
//}

	 
	


//======================================5th scenario===================================


//public void clickProduct() {
//       firstproduct.click();
//   }
//
//public boolean clickCart() {
//	cart.click();
//	return true;
//}
//  
//public boolean Verify()
//{
//	wait.until(ExpectedConditions.visibilityOf(verify));
//	return true;
//}

public void clickProduct() {
    wait.until(ExpectedConditions.elementToBeClickable(firstproduct));
    Assert.assertTrue(firstproduct.isDisplayed(), "First product is not visible!");
    firstproduct.click();
    System.out.println("First product clicked");
}

public boolean clickCart() {
    wait.until(ExpectedConditions.elementToBeClickable(cart));
    Assert.assertTrue(cart.isDisplayed(), "Cart icon is not visible!");

    cart.click();
    System.out.println("Cart clicked");
    return true;
}

public boolean Verify() {
    wait.until(ExpectedConditions.visibilityOf(verify));
    Assert.assertTrue(verify.isDisplayed(), "Verification element is not visible!");
    System.out.println("Verification successful");
    return true;
}


}