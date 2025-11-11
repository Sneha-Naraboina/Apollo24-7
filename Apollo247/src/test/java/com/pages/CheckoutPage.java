package com.pages;


	
	import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class CheckoutPage extends BasePage {

	    WebDriver driver;
	    WebDriverWait wait;
	    PaymentPage paymentPage;

	    public CheckoutPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	       // Elements

	    
	    @FindBy(xpath="/html/body/main/div/div/div[2]/div/div[2]/div[2]/div[1]/div/div/button[2]")
	    WebElement patientSelector;
	    
	    @FindBy(xpath = "/html/body/main/div/div/div/div/div[2]/div[2]/div[1]/div/div/button[2]")
	    WebElement offPatientSelector;
	    
	    @FindBy(xpath = "/html/body/main/div/div/div[2]/div/div[2]/div[2]/div[7]/button/span")
	    WebElement payOnlineButton;
	    
	    @FindBy(xpath = "/html/body/main/div/div/div/div/div[2]/div[2]/div[6]/button/span")
	    WebElement bookAppointment;
	    
	    
	    // Methods
	    
	    public void selectPatient() {
	    	WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
	    	wait.until(ExpectedConditions.elementToBeClickable(patientSelector)).click();
	    	}
	    
	    public void offSelectPatient() {
	    	WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
	    	wait.until(ExpectedConditions.elementToBeClickable(offPatientSelector)).click();
	    	}
	    
	    
	    public void scroll() {
	    	JavascriptExecutor js;
	    	js=(JavascriptExecutor) webdriver;
	        js.executeScript("window.scrollBy(0,850);");
	    }
	    
	    public void offlineScroll() {
	    	JavascriptExecutor js;
	    	js=(JavascriptExecutor) webdriver;
	        js.executeScript("window.scrollBy(0,350);");
	    }

	    public PaymentPage clickProceedToPayment() throws InterruptedException {
	        //wait.until(ExpectedConditions.elementToBeClickable(payOnlineButton)).click();
	    	Thread.sleep(2000);
	    	payOnlineButton.click();
	        paymentPage = new PaymentPage(driver);
	        return paymentPage;
	    }

	    public void clickBookAppointment() {
	        bookAppointment.click();
	    }
	}


