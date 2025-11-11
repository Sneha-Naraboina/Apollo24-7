package com.pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CircleMembershipPage 
{	
	WebDriver driver;

	private static final String CIRCLE_MEMBERSHIP_LINK = "//a[contains(text(),'Circle Membership')]";
    // Locators using PageFactory (constants for readability)
    //private static final String CIRCLE_MEMBERSHIP_LINK = "//a[contains(text(),'Circle Membership')]";
    private static final String CIRCLE_MEMBERSHIP_HEADER = "//h1[contains(text(),'Circle Membership')]";
    //private static final String PLANS_FOR_YOU_SECTION = "//h2[contains(text(),'Plans For You')]";
    private static final String PLANS_FOR_YOU_TAB = "//a[contains(normalize-space(.),'Plans For You') or contains(.,'Plans For You')]";
    //private static final String PLANS_FOR_YOU_SECTION = "/html/body/main/div/div/div[1]/div/ul/li[2]/a";
    private static final String JOIN_CIRCLE_BUTTON = "//button[contains(text(),'Join Circle')]";
    private static final String JOIN_CIRCLE_HEADER = "//h1[contains(text(),'Join Circle')]";

    @FindBy(xpath = CIRCLE_MEMBERSHIP_LINK)
    private WebElement circleMembershipLink;

    @FindBy(xpath = CIRCLE_MEMBERSHIP_HEADER)
    private WebElement circleMembershipHeader;

    @FindBy(xpath = PLANS_FOR_YOU_TAB)
    private WebElement plansForYouTab;

    @FindBy(xpath = JOIN_CIRCLE_BUTTON)
    private WebElement joinCircleButton;

    @FindBy(xpath = JOIN_CIRCLE_HEADER)
    private WebElement joinCircleHeader;

    // Constructor
    public CircleMembershipPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
   
    // Actions
    public void clickCircleMembership() {
        circleMembershipLink.click();
    }

    public boolean isCircleMembershipPageVisible() {
        return circleMembershipHeader.isDisplayed();
    }

    public void clickPlansForYou() 
    {
        plansForYouTab.click();
    }

    public boolean isAvailablePlansVisible() {
        return plansForYouTab.isDisplayed();
    }

    public void clickJoinCircle() {
        joinCircleButton.click();
    }

    public boolean isJoinCirclePageVisible() {
        return joinCircleHeader.isDisplayed();
    }

    // Getters for explicit waits
    public WebElement getCircleMembershipHeader() {
        return circleMembershipHeader;
    }

    public WebElement getPlansForYouSection() {
        return plansForYouTab;
    }

    public WebElement getJoinCircleHeader() {
        return joinCircleHeader;
    }
 
   public WebElement getCircleMembershipLink()
   {
    return circleMembershipLink;
   }	
   
}


//   WebDriver driver;
//
//   // Locators moved to constants (no hardcoding in methods)
//   private static final String CIRCLE_MEMBERSHIP_LINK = "//a[contains(text(),'Circle Membership')]";
//   //private static final String PLANS_FOR_YOU_SECTION = "//h2[contains(text(),'Plans for You')]";
//   
//   private static final String PLANS_FOR_YOU_SECTION = "/html/body/main/div/div/div[1]/div/ul/li[2]/a";
//   @FindBy(xpath = CIRCLE_MEMBERSHIP_LINK)
//   private WebElement circleMembershipLink;
//
//   @FindBy(xpath = PLANS_FOR_YOU_SECTION)
//	public WebElement plansForYouSection;
//
//   public CircleMembershipPage(WebDriver driver) {
//       this.driver = driver;
//       PageFactory.initElements(driver, this);
//   }
//
//   public void clickCircleMembership() {
//       circleMembershipLink.click();
//   }
//
//   public boolean isPlansSectionVisible() {
//       return plansForYouSection.isDisplayed();
//   }
//
//	public WebElement getPlansForYouSection() {
//		// TODO Auto-generated method stub
//		return plansForYouSection;
//		//return null;









































//package com.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
// 
//
//public class CircleMembershipPage 
//{
//	WebDriver driver;
//	   By circleMembershipLink = By.xpath("//a[contains(text(),'Circle Membership')]");
//	    By plansForYouSection = By.xpath("//h2[contains(text(),'Plans for You')]");
//
//	    public CircleMembershipPage(WebDriver driver) {
//	        this.driver = driver;
//	    }
//
//	    public void clickCircleMembership() 
//	    {
//	    	
//	        driver.findElement(circleMembershipLink).click();
//	    }
//
//	    public boolean isPlansSectionVisible() {
//	        return driver.findElement(plansForYouSection).isDisplayed();
//	    }
//	}

