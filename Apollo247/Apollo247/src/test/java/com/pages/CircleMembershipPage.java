package com.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CircleMembershipPage {

    WebDriver driver;

    // Locators moved to constants (no hardcoding in methods)
    private static final String CIRCLE_MEMBERSHIP_LINK = "//a[contains(text(),'Circle Membership')]";
    //private static final String PLANS_FOR_YOU_SECTION = "//h2[contains(text(),'Plans for You')]";
    
    private static final String PLANS_FOR_YOU_SECTION = "/html/body/main/div/div/div[1]/div/ul/li[2]/a";
    @FindBy(xpath = CIRCLE_MEMBERSHIP_LINK)
    private WebElement circleMembershipLink;

    @FindBy(xpath = PLANS_FOR_YOU_SECTION)
	public WebElement plansForYouSection;

    public CircleMembershipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCircleMembership() {
        circleMembershipLink.click();
    }

    public boolean isPlansSectionVisible() {
        return plansForYouSection.isDisplayed();
    }

	public WebElement getPlansForYouSection() {
		// TODO Auto-generated method stub
		return plansForYouSection;
		//return null;
	}
	
	
	
	
	
	//+++++++++++++++++++ second scenario +++++++++++++++++++++++++++++++++++
	    
	
	    // Locators
	    // private static final String CIRCLE_MEMBERSHIP_LINK = "//a[contains(text(),'Circle Membership')]";
	    private static final String JOIN_CIRCLE_BUTTON = "(//span[text()='Join Circle'])[2]";
	    private static final String SIX_MONTHS_PLAN = " //h3[text()='149']"; //"//label[contains(text(),'6 Months')]";
	    private static final String TWELVE_MONTHS_PLAN = "//label[contains(text(),'12 Months')]";
	   private static final String SELECTED_PLAN_HEADER = "//div[contains(@class,'plan-header')]";

	    // WebElements
//	    @FindBy(xpath = CIRCLE_MEMBERSHIP_LINK)
//	    private WebElement circleMembershipLink;

	    @FindBy(xpath = JOIN_CIRCLE_BUTTON)
	    private WebElement joinCircleButton;

	    @FindBy(xpath = SIX_MONTHS_PLAN)
	    private WebElement sixMonthsPlan;

	    @FindBy(xpath = TWELVE_MONTHS_PLAN)
	    private WebElement twelveMonthsPlan;

	    @FindBy(xpath = SELECTED_PLAN_HEADER)
	    private WebElement selectedPlanHeader;

	    // Constructor
//	    public CircleMembershipPage(WebDriver driver) {
//	        this.driver = driver;
//	        PageFactory.initElements(driver, this);
//	    }

	    // Click Circle Membership
//	    public void clickCircleMembership() {
//	        circleMembershipLink.click();
//	    }

	    // ✅ Click Join Circle button
	    public void clickJoinCircle() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(joinCircleButton));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", joinCircleButton);
	        } catch (Exception e) {
	            System.out.println("Failed to click Join Circle button: " + e.getMessage());
	        }
	    }

	    // ✅ Select plan based on properties
	    public void selectPlan(String PlanType) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            if (PlanType.equalsIgnoreCase("6Months")) {
	                wait.until(ExpectedConditions.elementToBeClickable(sixMonthsPlan));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sixMonthsPlan);
	            } else if (PlanType.equalsIgnoreCase("12Months")) {
	                wait.until(ExpectedConditions.elementToBeClickable(twelveMonthsPlan));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", twelveMonthsPlan);
	            } else {
	                System.out.println("Invalid plan type specified in properties file.");
	            }
	        } catch (Exception e) {
	            System.out.println("Failed to select plan: " + e.getMessage());
	        }
	    }
	    
	    public boolean isJoinCirclePageDisplayed() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try {
	            wait.until(ExpectedConditions.visibilityOf(selectedPlanHeader));
	            return selectedPlanHeader.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }

//	    // ✅ Verify selected plan header
//	    public WebElement getSelectedPlanHeader() {
//	        return selectedPlanHeader;
//	    }

//	    public String getSelectedPlanText() {
//	        return selectedPlanHeader.getText();
//	    }
	    
	    
	    //+++++++++++++++++++++++++++++ third scenario ++++++++++++++++++++++++++++++++ 
	    
	    
	    //private static final String LOGIN_TO_CONTINUE_BUTTON = "//button[contains(text(),'Login to Continue')]";
	    private static final String LOGIN_TO_CONTINUE_BUTTON = "//span[text() = 'Login to continue']";
	    //private static final String PHONE_NUMBER_INPUT = "mobileNumber"; // Assuming ID
	    private static final String PHONE_NUMBER_INPUT = "/html/body/div[4]/div[2]/div/div[2]/div/div/div/form/div[1]/div/div/div[1]/input";
	    private static final String CONTINUE_BUTTON = "input[name = 'mobileNumber']";
	    private static final String VERIFY_BUTTON = "//button[contains(text(),'Verify')]";

	    // WebElements
	    @FindBy(xpath = LOGIN_TO_CONTINUE_BUTTON)
	    private WebElement loginToContinueBtn;

	    @FindBy(id = PHONE_NUMBER_INPUT)
	    private WebElement phoneNumberInput;

	    @FindBy(xpath = CONTINUE_BUTTON)
	    private WebElement continueBtn;

	    @FindBy(xpath = VERIFY_BUTTON)
	    private WebElement verifyBtn;

	    // ✅ Click Login to Continue
	    public void clickLoginToContinue() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(loginToContinueBtn)).click();
	    }

	    // ✅ Enter phone number (passed from step definition)
	    public void enterPhoneNumber(String phoneNumber) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput)).sendKeys(phoneNumber);
	    }

	    // ✅ Click Continue
	    public void clickContinue() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
	    }

	    // ✅ Wait for OTP entry (time passed from step definition)
	    public void waitForOtpEntry(int waitTimeInSeconds) {
	        try {
	            System.out.println("Waiting " + waitTimeInSeconds + " seconds for manual OTP entry...");
	            Thread.sleep(waitTimeInSeconds * 1000);
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    // ✅ Click Verify after OTP entered manually
	    public void clickVerify() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(verifyBtn)).click();
	    }

//		public void enterPhoneNumber(String phoneNumber) {
//			// TODO Auto-generated method stub
//			
//		}
//	    
	   
}



