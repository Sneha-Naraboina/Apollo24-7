package com.stepDefinitionTestNG;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.CircleMembershipPage;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class Profile extends BaseSteps
{
	WebDriverWait wait;
	CircleMembershipPage circlePage;
	@Given("the user is on Apollo {int} homepage")
	public void the_user_is_on_apollo_homepage(Integer int1) 
	{
			BaseSteps.launchBrowser();
			circlePage = new CircleMembershipPage(driver);
	}

	@When("the user clicks on Circle Membership")
	public void the_user_clicks_on_circle_membership() 
	{
		WebDriver driver = BaseSteps.driver;
		circlePage.clickCircleMembership();
	}

	@When("the circle membership page is visible")
	public void the_circle_membership_page_is_visible() 
	{
		wait.until(ExpectedConditions.visibilityOf(circlePage.getCircleMembershipHeader()));
        Assert.assertTrue(circlePage.isCircleMembershipPageVisible(), "Circle Membership page is not visible");
	}

	@When("the user clicks on Plans for You")
	public void the_user_clicks_on_plans_for_you() 
	{
		//WebDriver driver = BaseSteps.driver;
		circlePage.clickPlansForYou();
	}

	@When("the available plans page is visible")
	public void the_available_plans_page_is_visible() 
	{
		 wait.until(ExpectedConditions.visibilityOf(circlePage.getPlansForYouSection()));
	     Assert.assertTrue(circlePage.isAvailablePlansVisible(), "Available Plans page is not visible");
	}

	@When("the user clicks on Join Circle")
	public void the_user_clicks_on_join_circle() 
	{
		wait.until(ExpectedConditions.elementToBeClickable(circlePage.getJoinCircleHeader()));
        circlePage.clickJoinCircle();
	}

	@Then("the membership joining page is visible")
	public void the_membership_joining_page_is_visible() 
	{ 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(circlePage.getJoinCircleHeader()));
        Assert.assertTrue(circlePage.isJoinCirclePageVisible(), "Join Circle page is not visible");
	}
}






//WebDriverWait wait;
//CircleMembershipPage circlePage;
//@Given("the user is on Apollo {int} homepage")
//public void the_user_is_on_apollo_homepage(Integer int1) {
//	BaseSteps.launchBrowser();
//	 circlePage = new CircleMembershipPage(driver);
//}
//
//@When("the user clicks on Circle Membership")
//public void the_user_clicks_on_circle_membership()
//{
//	WebDriver driver = BaseSteps.driver;
//	 circlePage.clickCircleMembership();
//	// BaseSteps.sleep(5000);
//    
//}
//@Then("the plans for you page is visible")
//public void thOe_plans_for_you_page_is_visible()
//{
////	Assert.assertTrue(circlePage.isPlansSectionVisible(), "Plans for You section is not visible");
////	driver.quit();
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
//    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//	h2[contains(text(),'Plans for You')]")));
//	wait.until(ExpectedConditions.visibilityOf(circlePage.getPlansForYouSection()));
//	Assert.assertTrue(circlePage.isPlansSectionVisible(), "Plans for You section is not visible");
//    //driver.quit();
//
//}

 