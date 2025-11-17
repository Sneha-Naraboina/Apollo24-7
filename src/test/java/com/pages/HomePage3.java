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
//---------------------------------3rd scenarioL----------------------------------
    @FindBy(xpath = "//a[text()='Buy Medicines']")
    private WebElement buyMedicinesLink;

    @FindBy(xpath = "//div[@data-placeholder='Search Medicines']")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id='searchProduct']")
    private WebElement searchInput;
    
    @FindBy(xpath="(//div[contains(@class,'search')])[2]") //(//h3)[6]
    private WebElement productTitle;
   //---------------------------------4th scenarioL--------------------------------------------------------- 

    @FindBy(xpath = "//button[@id='searchButton']") 
    private WebElement searchButton;
    
    @FindBy(xpath ="//*[@id=\"Top Grid 2 Web\"]/div/div[2]/div/a/h2")
    private WebElement getmeds;
    
    @FindBy(xpath="//h1[text()=\" UPLOAD PRESCRIPTIONS \"]")
    private WebElement navigate;
    
    @FindBy(xpath="//a[text()='View All Categories']")
    private WebElement view;
    
    @FindBy(xpath="//div[contains(@class,'Web_pageTitle')]")//---------verify-----------------
    private WebElement check;
    
    @FindBy(xpath="//p[contains(text(),\"We’re sorry, the item you searched could not be found\")]")
    private WebElement errorMessageLocator;
    
    
//----------------------------------5th scenarioL---------------------------------------------------------------------
    
   @FindBy(xpath="//*[@id=\"SKU Widget 6 Web\"]/div[2]/div/div[1]/div/div/a/div/div[2]/div[1]/h2")
   private WebElement firstproduct;
   
   @FindBy(xpath="(//li[@class='Header_nav___g0oE'])[2]")
   private WebElement cart;
   
   @FindBy(xpath="//p[text()=' YOUR CART IS EMPTY']") //(//h3)[6]
   private WebElement verify;
   
   
   
   
//====================================================================================================================
   
   

//    
   public void clickBuyMedicines1() {
	    try {
	    	
	        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
	        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
	        buyMedicinesLink.click();
	        System.out.println("Navigated to Buy Medicines");
	       
	        
	    } catch (Exception e) {
	        System.out.println("Exception in clickBuyMedicines1: " + e.getMessage());
	        e.printStackTrace();
	        
	    }
	}

	public void clickSearchBar1() {
	    try {
	        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
	        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
	        searchBar.click();
	        System.out.println("Search bar clicked");
	    } catch (Exception e) {
	        System.out.println("Exception in clickSearchBar1: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public void enterMedicine(String medicine) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(searchInput));
	        searchInput.clear();
	        searchInput.sendKeys(medicine);

	        // Verify input is present
	        String enteredValue = searchInput.getAttribute("value");
	        Assert.assertEquals(enteredValue, medicine, "Medicine name not entered correctly!");
	    } catch (Exception e) {
	        System.out.println("Exception in enterMedicine: " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public boolean verifyErrorMessage(String expectedMessage) {
	    try {
	        WebElement errorElement = wait.until(ExpectedConditions.visibilityOf(errorMessageLocator));
	        String actualMessage = errorElement.getText().trim();

	        // Print the actual message
	        System.out.println("Error message displayed: " + actualMessage);

	        return actualMessage.equals(expectedMessage);
	    } catch (Exception e) {
	        System.out.println("Exception in verifyErrorMessage: " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    //------------------------4th Scenario-------------------------------


    

	public void clickGetMeds() {
	    try {
	        Assert.assertTrue(getmeds.isDisplayed(), "Get Meds button is not visible!");
	        getmeds.click();
	        System.out.println("Get Meds button clicked");
	    } catch (Exception e) {
	        System.out.println("Error in clickGetMeds(): " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public boolean navigateToGetmeds() {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(navigate)).isDisplayed();
	        return true;
	    } catch (Exception e) {
	        System.out.println("Error in navigateToGetmeds(): " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}

	public void clickViewAllCategory() throws InterruptedException {
	    try {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Properties props = PropertyReader.readProperty();
	        String viewallLocator = props.getProperty("viewall.link.xpath");

	        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(viewallLocator)));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", link);
	        Thread.sleep(2000);

	        wait.until(ExpectedConditions.elementToBeClickable(view));
	        view.click();
	    } catch (Exception e) {
	        System.out.println("Error in clickViewAllCategory(): " + e.getMessage());
	        e.printStackTrace();
	    }
	}

	public boolean Check() {
	    try {
	        String originalWindow = driver.getWindowHandle();

	        for (String windowHandle : driver.getWindowHandles()) {
	            if (!windowHandle.equals(originalWindow)) {
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }

	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(check));
	        check.isDisplayed();

	        return true;
	    } catch (Exception e) {
	        System.out.println("Error in Check(): " + e.getMessage());
	        e.printStackTrace();
	        return false;
	    }
	}



	 
	


//======================================5th scenario===================================



//public void clickProduct() {
//    wait.until(ExpectedConditions.elementToBeClickable(firstproduct));
//    Assert.assertTrue(firstproduct.isDisplayed(), "First product is not visible!");
//    firstproduct.click();
//    System.out.println("First product clicked");
//}
//
//public boolean clickCart() {
//    wait.until(ExpectedConditions.elementToBeClickable(cart));
//    Assert.assertTrue(cart.isDisplayed(), "Cart icon is not visible!");
//
//    cart.click();
//    System.out.println("Cart clicked");
//    return true;
//}
//
//public boolean Verify() {
//    wait.until(ExpectedConditions.visibilityOf(verify));
//    Assert.assertTrue(verify.isDisplayed(), "Verification element is not visible!");
//    System.out.println("Verification successful");
//    return true;
//}

public void clickProduct() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(firstproduct));
        Assert.assertTrue(firstproduct.isDisplayed(), "First product is not visible!");
        firstproduct.click();
        System.out.println("First product clicked");
    } catch (Exception e) {
        System.out.println("Exception in clickProduct: " + e.getMessage());
        e.printStackTrace();
    }
}

public boolean clickCart() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(cart));
        Assert.assertTrue(cart.isDisplayed(), "Cart icon is not visible!");
        cart.click();
        System.out.println("Cart clicked");
        return true;
    } catch (Exception e) {
        System.out.println("Exception in clickCart: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}

public boolean Verify() {
    try {
        wait.until(ExpectedConditions.visibilityOf(verify));
        Assert.assertTrue(verify.isDisplayed(), "Verification element is not visible!");
        System.out.println("Verification successful");
        return true;
    } catch (Exception e) {
        System.out.println("Exception in Verify: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}


}