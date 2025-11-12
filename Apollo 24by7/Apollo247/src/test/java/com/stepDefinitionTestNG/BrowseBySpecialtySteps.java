//package com.stepDefinitionTestNG;
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.pages.LoginPage;
//import com.pages.SpecialtyPage;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//	public class BrowseBySpecialtySteps {
//		
//		WebDriver driver;
//		LoginPage LoginPage;
//	    SpecialtyPage specialtyPage;
//
//	    @Given("User opens Apollo Pharmacy homepage")
//	    public void openHomePage() {
//	        Hooks.driver.get("https://www.apollo247.com");
//	        LoginPage = new LoginPage(Hooks.driver);
//	        specialtyPage = new SpecialtyPage(Hooks.driver);
//	    }
//
//	    @When("User clicks on Find Doctors")
//	    public void clickFindDoctors() {
//	    	LoginPage.clickFindDoctors();
//	    }
//
//	    @Then("Validate that Browse by Specialty option is displayed")
//	    public void validateBrowseBySpecialty() {
//	        Assert.assertTrue(specialtyPage.isBrowseBySpecialtyDisplayed(), "Browse by Specialty option is not displayed");
//	    }
//
//	    @And("User clicks on Dermatology")
//	    public void clickDermatology() {
//	        specialtyPage.clickDermatology();
//	    }
//
//	    @Then("User should navigate to Dermatologists page")
//	    public void validateDermatologistsPage() {
//	        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//	        boolean urlChanged = wait.until(ExpectedConditions.urlContains("dermatology"));
//	        Assert.assertTrue(urlChanged, "Navigation to Dermatologists page failed");
//	    }
//
//	    @And("Doctors under Dermatology should be displayed")
//	    public void validateDoctorsList() {
//	        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//	        List<WebElement> doctors = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".doctor-card")));
//	        Assert.assertTrue(doctors.size() > 0, "No doctors displayed under Dermatology");
//	    }
//	}


