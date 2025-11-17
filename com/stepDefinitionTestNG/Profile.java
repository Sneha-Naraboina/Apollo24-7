package com.stepDefinitionTestNG;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.CircleMembershipPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
	 
	public class Profile extends BaseSteps
	{
		WebDriverWait wait;
		CircleMembershipPage circlePage;
		
		//++++++++++++++++++++++++++++++++++++++++ first scenario  +++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
			wait.until(ExpectedConditions.visibilityOf(circlePage.getPlansForYouSection()));
			Assert.assertTrue(circlePage.isPlansSectionVisible(), "Plans for You section is not visible");
	        Reports.captureScreenshot(driver, "Scenario_01");
	        driver.quit();

	    }
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++++++++ second scenario +++++++++++++++++++++++++++++++++++++++++++++++
		
		@Given("the user on Apollo247 homepage2")
		public void the_user_on_apollo247_homepage2() 
		{
			 circlePage = new CircleMembershipPage(BaseSteps.driver);
		        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
		}

		@When("the user clicks on the Circle Membership")
		public void the_user_clicks_on_the_circle_membership() 
		{
			circlePage.clickCircleMembership();
		}

		@When("the user clicks on Join Circle")
		public void the_user_clicks_on_join_circle() 
		{
		   
			circlePage.clickJoinCircle();

		}
		
		@When("join circle page is displayed")
		public void join_circle_page_is_displayed() 
		{
//		    WebDriverWait wait = new WebDriverWait(BaseSteps.driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.visibilityOf(circlePage.getSelectedPlanHeader()));
//		    Assert.assertTrue(circlePage.getSelectedPlanHeader().isDisplayed(), "Join Circle page is not displayed");
			//Assert.assertTrue(circlePage.isJoinCirclePageDisplayed(), "Join Circle page is not displayed");
		}

		@Then("any one plan is selected")
		public void any_one_plan_is_selected() 
		{		   
			String planType = PropertyReader.readProperty().getProperty("PlanType.link.xpath"); // e.g., 6Months or 12Months
	        circlePage.selectPlan(planType);
	        Reports.captureScreenshot(driver, "Scenario_02");
	        driver.quit();
			
		}	
	   
		//++++++++++++++++++++++++++++++++++ 4th Scenario ++++++++++++++++++++++++++++++++++++++++++++++
		
		@Given("the user is on the Apollo247 homepage3")
		public void the_user_is_on_the_apollo247_homepage3() 
		{
			//BaseSteps.launchBrowser();
			 circlePage = new CircleMembershipPage(BaseSteps.driver);
	        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
			
		}

		@When("the user clicked on the Circle Membership")
		public void the_user_clicked_on_the_circle_membership() 
		{    
			circlePage.clickCircleMembership();
		}

		@When("the user clicks on the Join Circle")
		public void the_user_clicks_on_the_join_circle() 
		{
			circlePage.clickJoinCircle();
		}

		
		@When("the user clicks on the apply Coupon")
		public void the_user_clicks_on_the_apply_coupon() 
		{
		   
			circlePage.clickApplyCoupon();
		}

		@When("the user enters coupon code from {int}")
		public void the_user_enters_coupon_code_from(Integer int1) 
		{
		   
		try 
		{
        // Read excel path from properties
        String excelPath = PropertyReader.get("excel_Path");

        // Load Excel
        ExcelReader.loadExcel(excelPath);

        // Get coupon code from sheet "Coupons" (assuming first column)
        String couponCode = ExcelReader.getCellData("Sheet1", int1, 0);

        // Enter coupon code using Page Object
        circlePage.enterCouponCode(couponCode);

		}

		catch (Exception e) 
		{
        e.printStackTrace();
        throw new RuntimeException("Failed to enter coupon code from Excel");
		}

		}		
		
		@Then("the user clicks on Cancel")
		public void the_user_clicks_on_cancel() 
		{
			 circlePage.clickCancel();
			 Reports.captureScreenshot(driver, "Scenario_03");
			 driver.quit();
		}
		
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++  TERMS SCENARIO +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		

		@Given("the user is on the Apollo247 homepage4")
		public void the_user_is_on_the_apollo247_homepage4() 
		{
			BaseSteps.launchBrowser();
			 circlePage = new CircleMembershipPage(BaseSteps.driver);
	        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
		}

		@When("the user clicks on Circle Membership4")
		public void the_user_clicks_on_circle_membership4() 
		{
			
			circlePage.clickCircleMembership();
		}

		@When("user clicks on the Join Circle4")
		public void user_clicks_on_the_join_circle4() {
			
			circlePage.clickJoinCircle();
		}

		@When("the user clicks on Login to Continue")
		public void the_user_clicks_on_login_to_continue() {
			
			 circlePage.clickLoginToContinue();
		}

		@When("user clicks on the terms")
		public void user_clicks_on_the_terms() 
		{
			
			circlePage.clickTerms();

			// Switch to the newly opened tab
			    for (String handle : driver.getWindowHandles()) {
			        driver.switchTo().window(handle);
			    }

			
		}

		@Then("terms and Conditions page should be displayed")
		public void terms_and_conditions_page_should_be_displayed() //throws TimeoutException 
		{
			boolean verify = circlePage.checkverify();
			Assert.assertTrue(verify, "Terms and Conditions page is NOT displayed");
			Reports.captureScreenshot(driver, "Scenario_04");
			driver.quit();
	
		}
		
		//+++++++++++++++++++++++++++++++++++++++++ Buy Insurance +++++++++++++++++++++++++++++++++++++++++++++++++
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		
		@Given("the user is on the Apollo24 homepage5")
		public void the_user_is_on_the_apollo24_homepage5() {
		    // Write code here that turns the phrase above into concrete actions
		    // throw new io.cucumber.java.PendingException();
			 BaseSteps.launchBrowser();
			 circlePage = new CircleMembershipPage(BaseSteps.driver);
		     BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
			
		}

		@When("the user clicks on Buy Insurance")
		public void the_user_clicks_on_buy_insurance() {
		  
			 circlePage.clickBuyInsurance();
			
		}

		@When("user navigates to insurance page")
		public void user_navigates_to_insurance_page() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		}
		
		
		@When("the user clicks on Change Location")
		public void the_user_clicks_on_change_location() 
		{
			circlePage.clickChangeLocation();
		}
		
		
		@When("the user enters the pincode from sheet {int} and row {int}")
		public void the_user_enters_the_pincode_from_sheet_and_row(Integer int1, Integer int2) {
		    try {
		        String excelPath = PropertyReader.get("excel_Path");
		        ExcelReader.loadExcel(excelPath);
		        String pincode = ExcelReader.getCellDataBySheetIndex(int1 - 1, int2, 0);

		        circlePage.enterPincode(pincode);
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new RuntimeException("Failed to enter pincode from Excel");
		    }
		}

		@Then("user clicks on submit")
		public void user_clicks_on_submit() 
		{
			circlePage.clickSubmit();
			 Reports.captureScreenshot(driver, "Scenario_05");
			 driver.quit();
		}

	}
