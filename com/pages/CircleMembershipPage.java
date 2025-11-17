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
    private static WebDriverWait wait;
    private static final String CIRCLE_MEMBERSHIP_LINK = "//a[contains(text(),'Circle Membership')]";
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
	
	
	//++++++++++++++++++++++++++++++++++++++++++++ second scenario +++++++++++++++++++++++++++++++++++++++++++++++
	    
	
	    // Locators
	   private static final String JOIN_CIRCLE_BUTTON = "(//span[text()='Join Circle'])[2]";
	   private static final String SIX_MONTHS_PLAN = " //h3[text()='149']"; 
	   private static final String TWELVE_MONTHS_PLAN = "//label[contains(text(),'12 Months')]";
	   private static final String SELECTED_PLAN_HEADER = "//div[contains(@class,'plan-header')]";

	    @FindBy(xpath = JOIN_CIRCLE_BUTTON)
	    private WebElement joinCircleButton;

	    @FindBy(xpath = SIX_MONTHS_PLAN)
	    private WebElement sixMonthsPlan;

	    @FindBy(xpath = TWELVE_MONTHS_PLAN)
	    private WebElement twelveMonthsPlan;

	    @FindBy(xpath = SELECTED_PLAN_HEADER)
	    private WebElement selectedPlanHeader;

	    // Click Join Circle button
	    public void clickJoinCircle() 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try 
	        {
	            wait.until(ExpectedConditions.elementToBeClickable(joinCircleButton));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", joinCircleButton);
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Failed to click Join Circle button: " + e.getMessage());
	        }
	    }

	    // Select plan based on properties
	    public void selectPlan(String PlanType) 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try 
	        {
	            if (PlanType.equalsIgnoreCase("6Months")) 
	            {
	                wait.until(ExpectedConditions.elementToBeClickable(sixMonthsPlan));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sixMonthsPlan);
	            } 
	            else if (PlanType.equalsIgnoreCase("12Months")) 
	            {
	                wait.until(ExpectedConditions.elementToBeClickable(twelveMonthsPlan));
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", twelveMonthsPlan);
	            } 
	            else 
	            {
	                System.out.println("Invalid plan type specified in properties file.");
	            }
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Failed to select plan: " + e.getMessage());
	        }
	    }
	    
	    public boolean isJoinCirclePageDisplayed() 
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        try 
	        {
	            wait.until(ExpectedConditions.visibilityOf(selectedPlanHeader));
	            return selectedPlanHeader.isDisplayed();
	        } 
	        catch (Exception e) 
	        {
	            return false;
	        }
	    }

		
	    
	    
	 //+++++++++++++++++++++++++++++++++++++++++ 3rd Scenario ++++++++++++++++++++++++++++++++++++++++++++++++
	    	    
	 // Locator constants
	
	    private static final String APPLY_COUPON_BUTTON = "/html/body/main/div/div/div/div[2]/div[2]/div[1]/div/div/div[1]/div/div[1]";
	    private static final String COUPON_INPUT_FIELD = "//input[@placeholder='Enter Coupon Code']";
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

     
     //++++++++++++++++++++++++++++++++++++++  4th scenario ++++++++++++++++++++++++++++++++++++++++++
     
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
			// TODO Auto-generated method stub 
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

    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 return wait.until(ExpectedConditions.visibilityOf(verify)).isDisplayed();

    	 
     }
     
     //+++++++++++++++++++++++++++++++++++++++++++ 5th scenario ++++++++++++++++++++++++++++++++++++++++++++++++++++
     //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     
     private static final String CLICK_BUY_INSURANCE = "//a[text()='Buy Insurance']";
     
     private static final String PINCODE_INPUT = "//input[@placeholder='Enter 6 digit pincode']";
     
     private static final String CHANGE_LOCATION_BUTTON = "//span[text()='Change Location']/parent::button";

     private static final String SUBMIT_BUTTON = "//button[@class= 'PincodeModal_primary__WzEmU']"; 

     @FindBy(xpath = CLICK_BUY_INSURANCE)
     private WebElement buyinsurance ;
     
     @FindBy(xpath = PINCODE_INPUT)
     private WebElement pincodeInput;
    
     @FindBy(xpath = CHANGE_LOCATION_BUTTON)
     private WebElement changeLocationBtn;
     
     @FindBy(xpath = SUBMIT_BUTTON)
     private WebElement submitBtn;
     
     public void clickBuyInsurance()
     {
    	buyinsurance.click();
     }
          
     public void clickChangeLocation() 
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(changeLocationBtn)).click();
     }

     public void enterPincode(String pincode) {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.visibilityOf(pincodeInput));
         pincodeInput.clear();
         pincodeInput.sendKeys(pincode);
     }
    
     public void clickSubmit() 
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
     }     
}






