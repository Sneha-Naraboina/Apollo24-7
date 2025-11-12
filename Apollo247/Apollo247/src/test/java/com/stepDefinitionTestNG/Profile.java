package com.stepDefinitionTestNG;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.CircleMembershipPage;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
	 
	public class Profile extends BaseSteps
	{
		WebDriverWait wait;
		CircleMembershipPage circlePage;
		@Given("the user is on Apollo247 homepage")
		public void the_user_is_on_apollo247_homepage() {
			BaseSteps.launchBrowser();
			 circlePage = new CircleMembershipPage(driver);
		}
	 
		@When("the user clicks on Circle Membership")
		public void the_user_clicks_on_circle_membership()
		{
			WebDriver driver = BaseSteps.driver;
			 circlePage.clickCircleMembership();
			// BaseSteps.sleep(5000);
		    
		}
	 
		@Then("the plans for you page is visible")
		public void thOe_plans_for_you_page_is_visible()
		{
//			Assert.assertTrue(circlePage.isPlansSectionVisible(), "Plans for You section is not visible");
//			driver.quit();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//	h2[contains(text(),'Plans for You')]")));
			wait.until(ExpectedConditions.visibilityOf(circlePage.getPlansForYouSection()));
			Assert.assertTrue(circlePage.isPlansSectionVisible(), "Plans for You section is not visible");
	        driver.quit();

	    }
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++ second scenario ++++++++++++++++++++++++++++++
		
		@Given("the user on Apollo247 homepage")
		public void the_user_on_apollo247_homepage() 
		{
		    // Write code here that turns the phrase above into concrete actions
		    // throw new io.cucumber.java.PendingException();
			 BaseSteps.launchBrowser();
		        circlePage = new CircleMembershipPage(BaseSteps.driver);
		        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
		}

		@When("the user clicks on the Circle Membership")
		public void the_user_clicks_on_the_circle_membership() {
		    // Write code here that turns the phrase above into concrete actions
		   //  throw new io.cucumber.java.PendingException();
			circlePage.clickCircleMembership();
		}

		@When("the user clicks on Join Circle")
		public void the_user_clicks_on_join_circle() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			circlePage.clickJoinCircle();

		}
		
		@Then("join circle page is displayed")
		public void join_circle_page_is_displayed() {
//		    WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.visibilityOf(circlePage.getSelectedPlanHeader()));
//		    Assert.assertTrue(circlePage.getSelectedPlanHeader().isDisplayed(), "Join Circle page is not displayed");
			//Assert.assertTrue(circlePage.isJoinCirclePageDisplayed(), "Join Circle page is not displayed");
		}

		@Then("any one plan is selected")
		public void any_one_plan_is_selected() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
			String planType = PropertyReader.readProperty().getProperty("PlanType.link.xpath"); // e.g., 6Months or 12Months
	        circlePage.selectPlan(planType);
			
		}

//		@Then("selected plan is visible")
//		public void selected_plan_is_visible() {
//		    // Write code here that turns the phrase above into concrete actions
//		   // throw new io.cucumber.java.PendingException();
//			String expectedPlan = PropertyReader.readProperty().getProperty("PlanType.link.xpath");
//	        wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
//	        wait.until(ExpectedConditions.visibilityOf(circlePage.getSelectedPlanHeader()));
//
//	        String actualPlanText = circlePage.getSelectedPlanText();
//	        Assert.assertTrue(actualPlanText.toLowerCase().contains(expectedPlan.toLowerCase()),
//	                "Expected plan: " + expectedPlan + " but found: " + actualPlanText);
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

 