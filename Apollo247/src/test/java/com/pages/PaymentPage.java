package com.pages;



	import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class PaymentPage extends BasePage {
	    WebDriver driver;
	    WebDriverWait wait;

	    public PaymentPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(xpath = "//input[@value='Scan and Pay']")
	    WebElement scanAndPayOption;

	    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div[2]/div/div/div/div[1]/div[2]/div[1]/div/div[1]/div")
	    WebElement showQRCodeButton;

	    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]")
	    WebElement qrImage;

	    public boolean isPaymentPageLoaded() {
	        return wait.until(ExpectedConditions.urlContains("/payment"));
	    }

	    public void selectScanAndPayOption() {
	        wait.until(ExpectedConditions.elementToBeClickable(scanAndPayOption)).click();
	    }

	    public void showQRCode() {
	        wait.until(ExpectedConditions.elementToBeClickable(showQRCodeButton)).click();
	    }
	    
	    
	    public boolean isShowQRCodeDisplayed() {
	        try {
	           waitUntillWebElementToBeVisible(showQRCodeButton);
	           return showQRCodeButton.isDisplayed();
	         } catch (TimeoutException e) {
	       return false;
	       }
	    }
	    
	    

		public boolean isQRCodeDisplayed() {
	         try {
	            waitUntillWebElementToBeVisible(qrImage);
	            return qrImage.isDisplayed();
	          } catch (TimeoutException e) {
	        return false;
	        }
	     }

	}

