//launching code but not navigating properly

package com.stepDefinitionTestNG;

import org.openqa.selenium.WebDriver;

import com.pages.FindDoctorsPage;

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
	
	static WebDriver driver;
	
	//1st scenario============================
	
	@Given("User opens Apollo Pharmacy homepage")
	public void user_opens_apollo_pharmacy_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
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
	public void user_should_navigate_to_dermatologists_page() {}
		
		
		
		
  //3rd scenario=================================================================	   

	@Given("the user is on the Apollo Pharmacy homepage")
	public void the_user_is_on_the_apollo_pharmacy_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("the user applies filters to find doctors")
	public void the_user_applies_filters_to_find_doctors() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("selects a doctor from the filtered list")
	public void selects_a_doctor_from_the_filtered_list() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("clicks on Online Consult")
	public void clicks_on_online_consult() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("chooses a date and time slot")
	public void chooses_a_date_and_time_slot() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("selects a patient or member from the list")
	public void selects_a_patient_or_member_from_the_list() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("clicks on Proceed")
	public void clicks_on_proceed() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("the user should be redirected to the payment page")
	public void the_user_should_be_redirected_to_the_payment_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	









