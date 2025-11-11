package com.stepDefinitionTestNG;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert; // ✅ For assertions

import com.pages.CheckoutPage;
import com.pages.ConsultPage;
import com.pages.FindDoctorsPage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.parameters.ExcelReader;
import com.setup.BaseSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario; // ✅ For hooks
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Hooks {
WebDriver driver;
LoginPage loginPage;
FindDoctorsPage findDoctorsPage;
ConsultPage consultPage;
CheckoutPage checkoutPage;
PaymentPage paymentPage;
BaseSteps baseSteps;
ExcelReader excelReader;

@Before
public void setup() {
    loginPage = new LoginPage(driver);
    findDoctorsPage = new FindDoctorsPage(driver);
//    consultPage = new ConsultPage(driver);
//    checkoutPage = new CheckoutPage(driver);
//    paymentPage = new PaymentPage(driver);
      baseSteps=new BaseSteps();
}

//-----------------------------------Background--------------------------------------------------------
		

@Given("User open Apollo Pharmacy website")
public void user_open_apollo_pharmacy_website() throws FileNotFoundException, IOException {
	baseSteps = new BaseSteps();
	excelReader= new ExcelReader();
	baseSteps.setup();
	driver = baseSteps.getDriver();
	System.out.println("User loads the url");
}

@Then("User login using mobile number and OTP")
public void user_login_using_mobile_number_and_otp(io.cucumber.datatable.DataTable table) throws InterruptedException, FileNotFoundException, IOException {        
	loginPage=new LoginPage(driver);
	Thread.sleep(2000);
	loginPage.loginBtn();
	List<String> data = table.asList();
	System.out.println(data.size());
	System.out.println(data.get(0));
    loginPage.phoneNumber(data.get(0));
    loginPage.continueBtn();
    Thread.sleep(5000);
    loginPage.verifyBtn();
    System.out.println("User login successfully and redirected to homepage");
}

@When("User click on Find Doctors")
public void user_click_on_find_doctors() {
        	findDoctorsPage = loginPage.findDoctorsbtn();
}

@Then("Doctors module should be displayed")
public void doctors_module_should_be_displayed() {
	Assert.assertTrue(findDoctorsPage.isDoctorSearchVisible(), "Doctors module is not displayed.");
}

//-----------------------------------First scenario--------------------------------------------------------
	

@When("User search on search bar")
public void user_search_on_search_bar() {
	findDoctorsPage.clickSearchBar();
}

@Then("search for invalid Doctor names {int} and {int}")
public void search_for_invalid_doctor_names_and(Integer sheetNo, Integer rowNo) throws IOException {
	excelReader.readExcel();
	String invalidName = excelReader.getCellData1(sheetNo, rowNo);
	findDoctorsPage.enterSearchQuery(invalidName);
	
}

@Then("No results found message should be displayed")
public void no_results_found_message_should_be_displayed() {
	Assert.assertTrue(findDoctorsPage.isNoResultsMessageDisplayed(), "No Results message is NOT displayed");
	
}

@After
   public void tearDown(Scenario scenario) {
       // Example: attach screenshot or log status
       if (scenario.isFailed()) {
           System.out.println("Scenario failed: " + scenario.getName());
       }
   }
}
