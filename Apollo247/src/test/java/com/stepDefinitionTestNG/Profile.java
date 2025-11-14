//launching code but not navigating properly

package com.stepDefinitionTestNG;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.FindDoctorsPage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;

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
	}

	@Then("Validate the title of the webpage")
	public void validate_the_title_of_the_webpage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

 //2nd scenario=============================================================
	
	@Then("Validate that Browse by Specialty option is displayed")
	public void validate_that_browse_by_specialty_option_is_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@And("User clicks on Dermatology")
	public void user_clicks_on_dermatology() {
		 FindDoctorsPage finddoctorspage = new FindDoctorsPage(Hooks.driver);
		    finddoctorspage.clickDermatology();

	}

	@Then("User should navigate to Dermatologists page")
	public void user_should_navigate_to_dermatologists_page() {
		
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
 
		// Decide action based on rowIndex
		if (rowno == 0) {
			// First brand (Petkit)
			 status=finddoctorspage.clickCheckBox(); // Method for Petkit
		} else if (rowno == 1) {
			// Second brand (Petkit again or another)
			 finddoctorspage.clickSecondCheckbox(); // Method for second brand
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
	}
//4th Scenario============================================================
	@Given("User clicks on Dermatology and navigated to Dermatologist page")
	public void user_clicks_on_dermatology_and_navigated_to_dermatologist_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.clickDermatology();
	}

	@When("User search on search bar")
	public void user_search_on_search_bar() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.searchInvalidDoctor();
	}

	@When("search for invalid Doctor names {int} and {int}")
	public void search_for_invalid_doctor_names(Integer sheetno, Integer rowno) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		ExcelReader excel = new ExcelReader();
		String filePath = excel.filePath;
		List<String> data = excel.getRowData(sheetno,rowno);
		System.out.println("Excel Data: " + data);
		boolean status = false;
		
	}

	@Then("No results found message should be displayed")
	public void no_results_found_message_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
	}


	
	
//5th Scenario============================================================
	@Given("User is on home page and navigated to booking page")
	public void user_is_on_home_page_and_navigated_to_booking_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.clickDermatology();
	}

	@When(" User is not logged in ")
	public void user_is_not_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.onlineConsultButton();
	    
		
		
	}

	@When("User tries to book a consultation")
	public void user_tries_to_book_a_consultation() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	    finddoctorspage.clickContinue();
	}

	@Then("the user should be redirected to the login page")
	public void the_user_should_be_redirected_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		finddoctorspage.verifySignin();
	}


	
	

	
	
	
	
	
	






}


