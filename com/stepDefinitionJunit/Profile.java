//package com.stepDefinitionJunit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile extends BaseSteps
//{
//	WebDriverWait wait;
//
//	@Given("the user is on Apollo {int} homepage")
//	public void the_user_is_on_apollo_homepage(Integer int1) {
//		//BaseSteps.launchBrowser();
//		BaseSteps.launchBrowser();
//		//BaseSteps.sleep(3000);
//		//homePage = new HomePage();
//	}
//
//	@When("the user clicks on Circle Membership")
//	public void the_user_clicks_on_circle_membership() 
//	{
//		WebDriver driver = BaseSteps.driver;
//		
//		 BaseSteps.sleep(2000);
//		  //homePage.clickHealthMonitors();          //  Click on Health Monitors
//	     // BaseSteps.sleep(3000);
//	    
//	}
//
//	@Then("the plans for you page is visible")
//	public void thOe_plans_for_you_page_is_visible() 
//	{
////		if (homePage.isHealthMonitorsPageDisplayed()) {
////	            System.out.println("Health monitors page is displayed.");
////	        } else {
////	            throw new AssertionError("Healthmonitors page not displayed.");
////	        }
//		driver.quit();
//	    
//	}
//
//}
