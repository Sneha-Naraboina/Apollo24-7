//launching code but not navigating properly

package com.stepDefinitionTestNG;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pages.FindDoctorsPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.Reports;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//
//import java.time.Duration;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;

public class Profile  {
	FindDoctorsPage findDoctorsPage ;
	ExtentTest test = Hooks.test;
	FindDoctorsPage finddoctorspage = new FindDoctorsPage(Hooks.driver);
	
	static WebDriver driver;
	Properties prop=PropertyReader.readProperty();
	
	//1st scenario============================
	
	@Given("User opens Apollo Pharmacy homepage")
	public void user_opens_apollo_pharmacy_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		//finddoctorspage.clickDermatology();
	}

	@When("User clicks on Find Doctors")
	public void user_clicks_on_find_doctors() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		//Reports.captureScreenshot(driver, "screenshot_scenario_01");
	}

	@Then("Validate the title of the webpage")
	public void validate_the_title_of_the_webpage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();

String title = Hooks.driver.getTitle();
        Assert.assertTrue(title.contains("Apollo"), "Page title validation failed. Actual title: " + title);
        
        Reports.generateReport(Hooks.driver, test, Status.PASS, "Page title validated successfully: " + title);
        Reports.captureScreenshot(driver, "screenshot_scenario_01");

	}

 //2nd scenario=============================================================
	
	@Then("Validate that Browse by Specialty option is displayed")
	public void validate_that_browse_by_specialty_option_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User clicks on Dermatology")
	public void user_clicks_on_dermatology() {
		 FindDoctorsPage finddoctorspage = new FindDoctorsPage(Hooks.driver);
		    finddoctorspage.clickDermatology();
		  //  Reports.captureScreenshot(driver, "screenshot_scenario_02");

Reports.generateReport(Hooks.driver, test, Status.PASS, "Navigated to Dermatologists page successfully");
    }




	@Then("User should navigate to Dermatologists page")
	public void user_should_navigate_to_dermatologists_page() {
		
		Assert.assertTrue(finddoctorspage.isDermatologyPageLoaded(), "Dermatology page not loaded");
		
	}
		
		
	
		
  //3rd scenario=================================================================	   
	@Given("the user is on the Apollo Pharmacy homepage")
	public void the_user_is_on_the_apollo_pharmacy_homepage() {
		finddoctorspage.clickDermatology();
	}

	@When("the user applies filters {int}{int} to find doctors")
	public void the_user_applies_filters_to_find_doctors(Integer rowno,Integer sheetno) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		//String excelPath = prop.getProperty("path"); // from config.properties
		ExcelReader excel = new ExcelReader();
		String filePath = excel.filePath;
		List<String> data = excel.getRowData(sheetno,rowno);
		System.out.println("Excel Data: " + data);
		boolean status = false;
		System.out.println(rowno + "  " + sheetno);
 
		// Decide action based on rowIndex
		if (rowno == 0) {
			// First brand (Petkit)
			 status=finddoctorspage.clickCheckBox(); // Method for Petkit
		} else if (rowno == 1) {
			// Second brand (Petkit again or another)
			 status=finddoctorspage.clickSecondCheckbox(); // Method for second brand
		}  else {
			throw new IllegalArgumentException("Unsupported row index: " + rowno);
		}
 
		Assert.assertTrue(status);    
	}

	@And("selects a doctor from the filtered list and clicks on Online Consult")
	public void selects_a_doctor_from_the_filtered_list() {
		
		finddoctorspage.onlineConsultButton();
	    
	}

	@And("clicks on Continue")
	public void clicks_on_continue() {
	    finddoctorspage.clickContinue();
	}

	@Then("validate tha login popup")
	public void validate_tha_login_popup() {
	    finddoctorspage.verifySignin();
	    
	    Assert.assertTrue(finddoctorspage.verifysignin.isDisplayed(), "Login popup is not displayed");

	    Reports.generateReport(Hooks.driver, test, Status.PASS, "Login popup validated successfully");
	       

	}
	

	
	
//4th Scenario============================================================
	@Given("User clicks on Dermatology and navigated to Dermatologist page")
	public void user_clicks_on_dermatology_and_navigated_to_dermatologist_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.clickDermatology();
	}

	@When("User clicks on search bar")
	public void user_search_on_search_bar() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.searchValidDoctor();
	}

//	@When("search for Valid Doctor names {int} {int}")
//	public void search_for_valid_doctor_names(Integer rowno,Integer sheetno) throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		ExcelReader excel = new ExcelReader();
//		String filePath = excel.filePath;
//		List<String> data = excel.getRowData(sheetno,rowno);
//		//List<String> data = excel.getRowData(1, rowno);
//		String doctorName = data.get(0); // assuming first column has doctor name
//		finddoctorspage.enterDoctorName(doctorName);
//		
//		System.out.println("Excel Data: " + data);
//		boolean status = false;
// 
//		// Decide action based on rowIndex
//		if (rowno == 0) {
//			// First brand (Petkit)
//			 status=finddoctorspage.searchDoctorResults(); // Method for Petkit
//		} else if (rowno == 1) {
//			// Second brand (Petkit again or another)
//			 finddoctorspage.searchDoctorResults2(); // Method for second brand
//		}  else {
//			throw new IllegalArgumentException("Unsupported row index: " + rowno);
//		}
// 
//		Assert.assertTrue(status); 
	
		
	//}
	
	@And("search for Valid Doctor names {int} {int}")
	public void search_for_valid_doctor_names(Integer sheetNo, Integer rowNo) throws Exception {
	    ExcelReader excel = new ExcelReader();

	    // Correct order: row first, sheet second
	    List<String> data = excel.getRowData(rowNo, sheetNo);

	    if (data.isEmpty()) {
	        throw new RuntimeException("No data found in Excel for sheet: " + sheetNo + ", row: " + rowNo);
	    }

	    String doctorName = data.get(0); // First cell value in that row
	    System.out.println("Excel Data for doctor search: " + doctorName);

	    // Enter doctor name into search bar
	    finddoctorspage.enterDoctorName(doctorName);
	}
//	
	 
//	@When("search for Valid Doctor names {int} {int}")
//	public void search_for_valid_doctor_names(Integer sheetno, Integer rowno) throws Exception {
//	    ExcelReaderOne excel = new ExcelReaderOne();
//
//	    // IMPORTANT: row first, sheet second (matches ExcelReaderOne signature)
//	    List<String> data = excel.getRowData(rowno, sheetno);
//
//	    if (data.isEmpty()) {
//	        throw new RuntimeException("No data found in Excel for sheet: " + sheetno + ", row: " + rowno);
//	    }
//
//	    String doctorName = data.get(0); // First cell value
//	    System.out.println("Excel Data: " + doctorName);
//
//	    // Enter doctor name into search bar
//	    finddoctorspage.enterDoctorName(doctorName);
//	}
	@Then("List of Doctors should be displayed with that name")
	public void list_of_doctors_should_be_displayed_with_that_name() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.searchDoctorResults();
	}

	@Then("The selected doctor profile is displayed")
	public void the_doctor_profile_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.ValidateDoctorProfile();
		
		Assert.assertTrue(finddoctorspage.doctorprofile.isDisplayed(), "Doctor profile is not displayed");

Reports.generateReport(Hooks.driver, test, Status.PASS, "Doctor profile displayed successfully");
    }

	

	
	//5th scenario====================================================================================


	@Given("User is on Apollo Pharmacy home page")
	public void user_is_on_apollo_pharmacy_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	
	}

	@When("when user clicks on Find Doctors")
	public void when_user_clicks_on_find_doctors() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.findDoctorsModule();
	}

	@When("User clicks on ENT speciality")
	public void user_clicks_on_ent_speciality() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.EntSpeciality();
	}

	@Then("should navigate to ENT consultation page")
	public void should_navigate_to_ent_consultation_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("user selects a doctor from the list of dotors")
	public void user_selects_a_doctor_from_the_list_of_dotors() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.EntDoctorSelection();
	}

	@Then("user tries to book consultation without login")
	public void user_tries_to_book_consultation_without_login() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.EntDoctorConsultation();
	}

	@Then("login popup should be displayed")
	public void login_popup_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.EntverifySignin();
		Assert.assertTrue(finddoctorspage.entverifysignin.isDisplayed(), "Login popup for ENT not displayed");
		Reports.generateReport(Hooks.driver, test, Status.PASS, "Login popup for ENT validated successfully");
	}
	
	//6th scenario============================================================
	
	@Given("User is on the Find Doctors page")
	public void user_is_on_the_find_doctors_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.findDoctorsModule();
	}
	@When("User clicks on Dermatology and navigates to Dermatologist page")
	public void User_clicks_on_Dermatology_and_navigates_to_Dermatologist_page() {
		finddoctorspage.clickDermatology();
		finddoctorspage.searchValidDoctor();
	}
	

	@Then("User enters an invalid specialty in the search bar")
	public void user_enters_an_invalid_specialty_in_the_search_bar() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();

		
		finddoctorspage.enterInvalidSpecialtyFromProperties();
		    

	}

	@And("clicks on the Search button")
	public void clicks_on_the_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
	}

	@Then("The system should display No result found message")
	public void the_system_should_display_no_result_found_message() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.isNoResultDisplayed();
		
		Assert.assertTrue(finddoctorspage.isNoResultDisplayed(), "No result message not displayed");
		Reports.generateReport(Hooks.driver, test, Status.PASS, "No result found message displayed successfully");
		
		
	}

	
	
	
	






}


