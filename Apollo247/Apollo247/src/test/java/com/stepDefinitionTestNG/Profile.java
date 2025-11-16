package com.stepDefinitionTestNG;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.CircleMembershipPage;
import com.parameters.ExcelReader;
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
		
		@Given("the user on Apollo247 homepage2")
		public void the_user_on_apollo247_homepage2() 
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

	
	   //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	   //++++++++++++++++++++++++++++++ 3rd scenario ++++++++++++++++++++++++++++++++++++++++++++++
		
		
//		String num;
//		int rowIndex = 0;
//		@Given("the user is on the Apollo247 homepage")
//		public void the_user_is_on_the_apollo247_homepage() {
//		    // Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
//			BaseSteps.launchBrowser();
//	        circlePage = new CircleMembershipPage(BaseSteps.driver);
//	        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
//			
//		}
//
//		@When("the user clicked on Circle Membership")
//		public void the_user_clicked_on_circle_membership() {
//		    // Write code here that turns the phrase above into concrete actions
//		    // throw new io.cucumber.java.PendingException();
//			circlePage.clickCircleMembership();
//			
//		}
//
//		@When("the user clicked on Join Circle")
//		public void the_user_clicked_on_join_circle() {
//		    // Write code here that turns the phrase above into concrete actions
//		    // throw new io.cucumber.java.PendingException();
//			circlePage.clickJoinCircle();
//			
//		}
//
//		@When("the user clicks on Login to Continue")
//		public void the_user_clicks_on_login_to_continue() 
//		{
//		    circlePage.clickLoginToContinue();
//
//		}
//		
//		@When("the user clicks on search mobile number")
//		public void the_user_clicks_on_search_mobile_number() throws IOException {
//		    // Write code here that turns the phrase above into concrete actions
//		    // throw new io.cucumber.java.PendingException();
//			 circlePage.clickAndEnterPhoneNumber(0, 0);
//		}
		
		//-----------------------------------------------------------------------------------------------------
		
//		@When("the user enters phone number from sheet {int} and row {int}") 
//		public void the_user_enters_phone_number_from_sheet_and_row(Integer int1, Integer int2) throws IOException {
//		    //Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
//			Properties prop = PropertyReader.readProperty();
//			String excelPath = prop.getProperty("number");
//			num=ExcelReader.getCellData(num, 0, rowIndex);
//			circlePage.clickAndEnterPhoneNumber(0, 0);
//			
//		}
		
//		@When("the user enters phone number from sheet {int} and row {int}")
//		public void the_user_enters_phone_number_from_sheet_and_row(Integer sheetIndex, Integer rowIndex) throws IOException {
//		    // Get Excel file path from Profile.properties
//		    Properties prop = PropertyReader.readProperty();
//		    String excelPath = prop.getProperty("number"); // This is your file path
//
//		    // Read phone number from Excel
//		    String phone = ExcelReader.getCellData(excelPath, sheetIndex, rowIndex, 0); // column 0 assumed
//
//		    // Pass phone number to page method
//		    //circlePage.enterPhoneNumber(phone);
//		}
		//----------------------------------------------------------------------------------------------------------
		
//		@When("the user enters phone number from {int}")
//		public void the_user_enters_phone_number_from(Integer int1) throws IOException 
//		{
//		    // Write code here that turns the phrase above into concrete actions
//		   // throw new io.cucumber.java.PendingException();
//			Properties prop = PropertyReader.readProperty();
//		    String excelPath = prop.getProperty("number");
//		    String phone = ExcelReader.getCellData(excelPath, int1, rowIndex);
//		}
//
//		@When("the user clicks on Continue")
//		public void the_user_clicks_on_continue() {
//		    // Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
//		}
//
//		@When("wait for OTP entry")
//		public void wait_for_otp_entry() {
//		    // Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
//		}
//
//		@When("the user waits for OTP and clicks verify")
//		public void the_user_waits_for_otp_and_clicks_verify() {
//		    // Write code here that turns the phrase above into concrete actions
//		    // throw new io.cucumber.java.PendingException();
//		}
//
//		@Then("user should be logged in Succesfully")
//		public void user_should_be_logged_in_succesfully() {
//		    // Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
//		}
		
		//++++++++++++++++++++++++++++++++++ 4th Scenario ++++++++++++++++++++++++++++++++++++++++++++++
		
		@Given("the user is on the Apollo247 homepage3")
		public void the_user_is_on_the_apollo247_homepage3() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			BaseSteps.launchBrowser();
	        circlePage = new CircleMembershipPage(BaseSteps.driver);
	        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
			
		}

		@When("the user clicked on the Circle Membership")
		public void the_user_clicked_on_the_circle_membership() {
		    // Write code here that turns the phrase above into concrete actions
		   // throw new io.cucumber.java.PendingException();
			circlePage.clickCircleMembership();
			
		}

		@When("the user clicks on the Join Circle")
		public void the_user_clicks_on_the_join_circle() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			circlePage.clickJoinCircle();
		}

		
		
		@When("the user clicks on the apply Coupon")
		public void the_user_clicks_on_the_apply_coupon() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			circlePage.clickApplyCoupon();
		}

		@When("the user enters coupon code from {int}")
		public void the_user_enters_coupon_code_from(Integer int1) {
		    // Write code here that turns the phrase above into concrete actions
		    // throw new io.cucumber.java.PendingException();

		try {
        // Read excel path from properties
        String excelPath = PropertyReader.get("excel_Path");

        // Load Excel
        ExcelReader.loadExcel(excelPath);

        // Get coupon code from sheet "Coupons" (assuming first column)
        String couponCode = ExcelReader.getCellData("Sheet1", int1, 0);

        // Enter coupon code using Page Object
        circlePage.enterCouponCode(couponCode);

		}

		catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to enter coupon code from Excel");
		}

		}		
		
		@Then("the user clicks on Cancel")
		public void the_user_clicks_on_cancel() 
		{
		    // Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
			 circlePage.clickCancel();
		}
		
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		//++++++++++++++++++++++++++++++++++++  TERMS SCENARIO +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		

		@Given("the user is on the Apollo247 homepage4")
		public void the_user_is_on_the_apollo247_homepage4() 
		{
			// Write code here that turns the phrase above into concrete actions
			// throw new io.cucumber.java.PendingException();
			BaseSteps.launchBrowser();
	        circlePage = new CircleMembershipPage(BaseSteps.driver);
	        BaseSteps.driver.get(PropertyReader.readProperty().getProperty("sourceUrl"));
		}

		@When("the user clicks on Circle Membership4")
		public void the_user_clicks_on_circle_membership4() 
		{
			// Write code here that turns the phrase above into concrete actions
			// throw new io.cucumber.java.PendingException();
			circlePage.clickCircleMembership();
		}

		@When("user clicks on the Join Circle4")
		public void user_clicks_on_the_join_circle4() {
			// Write code here that turns the phrase above into concrete actions
			// throw new io.cucumber.java.PendingException();
			circlePage.clickJoinCircle();
		}

		@When("the user clicks on Login to Continue")
		public void the_user_clicks_on_login_to_continue() {
			// Write code here that turns the phrase above into concrete actions
			// throw new io.cucumber.java.PendingException();
			 circlePage.clickLoginToContinue();
		}

		@When("user clicks on the terms")
		public void user_clicks_on_the_terms() 
		{
			// Write code here that turns the phrase above into concrete actions
			// throw new io.cucumber.java.PendingException();
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
		    // Write code here that turns the phrase above into concrete actions
		    // throw new io.cucumber.java.PendingException();
			 circlePage.clickBuyInsurance();
			
		}

		@When("user navigates to insurance page")
		public void user_navigates_to_insurance_page() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
		}
		
		
		@When("the user clicks on Change Location")
		public void the_user_clicks_on_change_location() {
		    // Write code here that turns the phrase above into concrete actions
		    // throw new io.cucumber.java.PendingException();
			
			circlePage.clickChangeLocation();
		}
		
		
//		@When("the user enters the pincode from sheet {int} and row {int}")
//		public void the_user_enters_the_pincode_from_sheet_and_row(Integer int1, Integer int2) 
//		{
//		    // Write code here that turns the phrase above into concrete actions
//		    //throw new io.cucumber.java.PendingException();
//			try {
//		        String excelPath = PropertyReader.get("excel_Path");
//		        ExcelReader.loadExcel(excelPath);
//		        String pincode = ExcelReader.getCellDataBySheetIndex(int1 - 1, int2, 0);
//		        Thread.sleep(6000); //wait for 6 secs before interacting
//		        circlePage.enterPincode(pincode);
//		    } catch (Exception e) {
//		        e.printStackTrace();
//		        throw new RuntimeException("Failed to enter pincode from Excel");
//		    }
//
//			
//		}
		
		
		@When("the user enters the pincode from sheet {int} and row {int}")
		public void the_user_enters_the_pincode_from_sheet_and_row(Integer int1, Integer int2) {
		    try {
		        String excelPath = PropertyReader.get("excel_Path");
		        ExcelReader.loadExcel(excelPath);

		        // Adjust sheet index to 0-based
		        String pincode = ExcelReader.getCellDataBySheetIndex(int1 - 1, int2, 0);

		        circlePage.enterPincode(pincode);
		    } catch (Exception e) {
		        e.printStackTrace();
		        throw new RuntimeException("Failed to enter pincode from Excel");
		    }
		}

		@Then("user clicks on submit")
		public void user_clicks_on_submit() {
		    // Write code here that turns the phrase above into concrete actions
		    //throw new io.cucumber.java.PendingException();
			circlePage.clickSubmit();
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

 