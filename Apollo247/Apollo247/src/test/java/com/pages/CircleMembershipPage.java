package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;
import com.parameters.PropertyReader;

public class CircleMembershipPage {

    WebDriver driver;
    private static WebDriverWait wait;

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
	    
	    
	    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	    //+++++++++++++++++++++++++++++ third scenario ++++++++++++++++++++++++++++++++ 
	    
//	    @FindBy(xpath ="//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div")
//		WebElement loginBtn;
//		@FindBy(xpath ="//*[@id=\"signUp-phoneNumber\"]")
//		WebElement phoneNumber;
//		@FindBy(xpath ="//*[@id=\"signUpSubmit\"]")
//		WebElement continueBtn;
//	    
//	    private static final String LOGIN_TO_CONTINUE_BUTTON = "//span[text() = 'Login to continue']";
//	   // private static final String PHONE_NUMBER_INPUT = "(//input)[1]";
//	    //private static final String PHONE_NUMBER_INPUT = "//input[@name=\"mobileNumber']";
//	    
//	    private static final String PHONE_NUMBER_INPUT = "/html/body/div[4]/div[2]/div/div[2]/div/div/div/form/div[1]/div/div/div[1]/input";
//	    @FindBy(xpath = LOGIN_TO_CONTINUE_BUTTON)
//	    private WebElement loginToContinueBtn;
//	    
//	    @FindBy(xpath = PHONE_NUMBER_INPUT)
//	    private WebElement phoneNumber;
//	    
//	    public void clickLoginToContinue() 
//	    {
//			// TODO Auto-generated method stub
//	 
//	 	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	 	        wait.until(ExpectedConditions.elementToBeClickable(loginToContinueBtn)).click();
//	 	}
//
//     public void clickAndEnterPhoneNumber(int sheetIndex, int rowIndex) throws IOException {
//    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    
//    // Wait for input field to be clickable
//    	 wait.until(ExpectedConditions.elementToBeClickable(phoneNumber)).click();
//    
//    // Read phone number from Excel
//    	//String phone = ExcelReader.getCellData(sheetIndex, rowIndex, 0); // column 0 assumed
//    
//    // Enter phone number
//    //phoneNumber.sendKeys(phone);
//       }
//
//     public void enterPhoneNumber(String phone) throws IOException {
//    	    Properties prop = PropertyReader.readProperty();
//    	    String excelPath = prop.getProperty("number");
//    	    //String phone = ExcelReader.getCellData(excelPath, excelPath, int1, rowIndex);
//    	    wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));
//    	    phoneNumber.sendKeys(phone);
//    	    phoneNumber.sendKeys(Keys.ENTER);
//    	}
//	//------------------------------------------------------
//		public void enterPhoneNumber() throws IOException 
//		{
//			// TODO Auto-generated method stub
//			String phone = ExcelReader.getCellData("login",0,0);
//			wait.until(ExpectedConditions.visibilityOf(phoneNumber)).sendKeys(phone);
//		}
     
//     public void enterPhoneNumber() throws IOException
//     {
//    	 
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    wait.until(ExpectedConditions.visibilityOf(phoneNumber)).sendKeys(phone);
//
//     }

	    
	    //++++++++++++++++++++++++++++ 4th coupon SCENARIO ++++++++++++++++++++++++++
	    

	    //@FindBy(xpath = "/html/body/main/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]")
	    
	 // Locator constants
	    //private static final String APPLY_COUPON_BUTTON = "//button[contains(text(),'Apply Coupon')]";
	    private static final String APPLY_COUPON_BUTTON = "/html/body/main/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]";
	    //private static final String COUPON_INPUT_FIELD = "/html/body/div[4]/div[2]/div/div[1]/h2/div[2]";
	    private static final String COUPON_INPUT_FIELD = "//input[@placeholder='Enter Coupon Code']";
	   // private static final String CANCEL_BUTTON = "//button[contains(text(),'Cancel')]";
	    private static final String CANCEL_BUTTON = "//span[text()='Cancel']";
	   
	 
	    @FindBy(xpath = APPLY_COUPON_BUTTON)
	    private WebElement applyCouponBtn;
	    
	    @FindBy(xpath = COUPON_INPUT_FIELD)
	    private WebElement couponInput;
	    

	    @FindBy(xpath = CANCEL_BUTTON)
	    private WebElement cancelBtn;

	    public void clickApplyCoupon() 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(applyCouponBtn)).click();

	        //wait.until(ExpectedConditions.elementToBeClickable(applyCouponBtn));
	    }
	    
	    public void enterCouponCode(String code) 
	    {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOf(couponInput));
	    	couponInput.clear();
	    	couponInput.sendKeys(code);
        }
	    

     public void clickCancel() 
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
     }

     
     //++++++++++++++++++++++++++++++++++++++  terms scenario ++++++++++++++++++++++++++++++++++++++++++
     
     private static final String LOGIN_TO_CONTINUE_BUTTON = "//span[text() = 'Login to continue']";
     private static final String TERMS_LINK = "//a[contains(text(),'Terms and Conditions')]";
     private static final String VERIFY = "//h1[contains(text(),'terms & conditions')]";
     
     @FindBy(xpath = LOGIN_TO_CONTINUE_BUTTON)
	    private WebElement loginToContinueBtn;
     
     @FindBy(xpath = TERMS_LINK)
     private WebElement termsLink;
     
     @FindBy(xpath = VERIFY)
     private WebElement verify;

     public void clickLoginToContinue() 
	    {
//			// TODO Auto-generated method stub 
	 	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	        wait.until(ExpectedConditions.elementToBeClickable(loginToContinueBtn)).click();
	 	}
     public void clickTerms() 
     {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(termsLink)).click();
     }
     
     public boolean checkverify() //throws TimeoutException
     {
//    	 wait.until(ExpectedConditions.visibilityOf(verify));
//		 return true;

    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    return wait.until(ExpectedConditions.visibilityOf(verify)).isDisplayed();

    	 
     }
     
     //+++++++++++++++++++++++++++++++++++++++++++ buys insurance +++++++++++++++++++++++++++++++++++++++
     //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     
     private static final String CLICK_BUY_INSURANCE = "//a[text()='Buy Insurance']";
     
     @FindBy(xpath = CLICK_BUY_INSURANCE)
     private WebElement buyinsurance ;
     
     public void clickBuyInsurance()
     {
    	buyinsurance.click();
     }
     
    // private static final String PINCODE_INPUT = "//input[@placeholder='Enter 6 digit pincode']";
     
     private static final String PINCODE_INPUT = "//input[@placeholder='Enter 6 digit pincode']";

     @FindBy(xpath = PINCODE_INPUT)
     private WebElement pincodeInput;

     public void enterPincode(String pincode) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(pincodeInput));
         pincodeInput.clear();
         pincodeInput.sendKeys(pincode);
     }
     
}



