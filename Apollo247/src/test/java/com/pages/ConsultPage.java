package com.pages;



	import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class ConsultPage extends BasePage {
	    LoginPage loginPage;
	    CheckoutPage checkoutPage;
	    
	    public ConsultPage(WebDriver driver) {
	        super(driver);
	    }

	    // -------------------- UI Elements --------------------

	    @FindBy(xpath = "//button[@aria-label='Button']/span[contains(text(),'Continue')]")
	    WebElement continclick;

	    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[2]/div[1]/div/div/div[5]/div/div") // Replace with actual selector
	    WebElement dateSlot;

	    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/div[4]") // Replace with actual selector
	    WebElement timeSlot;    

	    @FindBy(xpath = "//button[contains(text(),'Hospital Visit')]")
	    WebElement hospitalVisitBtn;

	    
	    @FindBy(xpath = "//div[contains(text(),'Appointment Confirmed')]") // Adjust based on actual confirmation message
	    WebElement appointmentConfirmation;
	    
	    @FindBy(xpath="//input[contains(@value,'ONLINE')]")
	    WebElement onlineconsultCheck;
	    
	    @FindBy(xpath="//input[contains(@value,'PHYSICAL')]")
	    WebElement offlineconsultCheck;
	    
	    
	    @FindBy(xpath = "//span[contains(text(),'Clear All')]")
	    WebElement clearall;
	    
	    @FindBy(xpath = "/html/body/main/div/div[1]/div[2]/div[5]/a[1]/div[2]/div/button")
	    WebElement onlineConsult;
	    
	    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div[5]/div/div")
	    WebElement offlineDateSelect;
	    
	    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/div[7]")
	    WebElement offlineTimeSlot;
	    
	    @FindBy(xpath = "/html/body/main/div/div/div/div/div[2]/div[2]/div[6]/button")
	    WebElement bookAppointmentBtn;
	   
	    
	    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div[3]/button")
	    WebElement offlinecontin;
	    
	    @FindBy(xpath = "/html/body/main/div/div[1]/div[2]/div[5]")
	    WebElement docList;
	    
	    @FindBy(xpath = "/html/body/main/div/div[1]/div[2]/div[4]/div/h1")
	    WebElement dermaHeader;
	    
	    @FindBy(xpath = "/html/body/div[4]/div[2]/div/div[2]/div/div/div/form/div[1]/label")
	    WebElement phoneHeader;


	    // -------------------- Step Definition Methods --------------------
	   
	   
	    
	   
	    
	    public LoginPage continueClick() {
	    	continclick.click();
	        loginPage = new LoginPage(webdriver); 
	        return loginPage;
	        
	    }
	    
	    public CheckoutPage onlineContinueClick() {
	    	continclick.click();
	    	checkoutPage = new CheckoutPage(webdriver);
	    	return checkoutPage;
	    }
	    
	    public CheckoutPage offlineContinueClick() {
	    	offlinecontin.click();
	    	checkoutPage = new CheckoutPage(webdriver);
	    	return checkoutPage;
	    }
	    
	    public void clearAllClick() {
	    	waitUntillWebElementToBeClickable(clearall);
	    	clearall.click();
	    }
	    
	    public void onlineConsultCheck() throws InterruptedException {
	    	Actions scroll = new Actions(webdriver);
	    	scroll.moveToElement(offlineconsultCheck).click().build().perform();
	    }
	    
	    public void offlineConsultCheck() throws InterruptedException {
	    	Actions scroll = new Actions(webdriver);
	    	scroll.moveToElement(onlineconsultCheck).click().build().perform();
	    }
	    
	    public void consultClick() throws InterruptedException {
	    	waitUntillWebElementToBeClickable1(onlineConsult);
	    	onlineConsult.click();
	    }


	    public void chooseDateAndTimeSlot() {
	    	WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
	    	wait.until(ExpectedConditions.elementToBeClickable(dateSlot)).click();
	    	wait.until(ExpectedConditions.elementToBeClickable(timeSlot)).click();
	    	}
	    
	    public void offlinechooseDateAndTimeSlot() throws InterruptedException {
	    	
	    	Actions date = new Actions(webdriver);
	    	date.moveToElement(offlineDateSelect).click().build().perform();
	    	Thread.sleep(1000);
	    	}
	    

		public void clickHospitalVisit() {
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(hospitalVisitBtn)).click();
			}

		public void clickBookAppointment() {
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(bookAppointmentBtn)).click();
		}
		

		public boolean isDermatologistPageDisplayed() {
	        try {
	            waitUntillWebElementToBeVisible(dermaHeader);
		        return dermaHeader.isDisplayed();
	        } catch (TimeoutException e) {
	        	return false;
	        	}
	}


	    public boolean isDoctorsListDisplayed() {
	      try {
	        waitUntillWebElementToBeVisible(docList);
	        return docList.isDisplayed();
	       } catch (TimeoutException e) {
	        return false;
	        }
	    }
	    

		public boolean isLoginPopupVisible() {
		    try {
	            waitUntillWebElementToBeVisible(phoneHeader);
	            return phoneHeader.isDisplayed();
	            } catch (TimeoutException e) {
	            return false;
	            }
	}



		public void verifyAppointmentSuccess() {
		WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(appointmentConfirmation));
		System.out.println("Appointment booked successfully!");
		}

	}

