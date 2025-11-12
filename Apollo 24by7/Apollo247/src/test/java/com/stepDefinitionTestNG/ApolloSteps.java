package com.stepDefinitionTestNG;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.pages.FindDoctorsPage;
import com.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApolloSteps {

    WebDriver driver;
    LoginPage loginPage;
    FindDoctorsPage findDoctorsPage;
    Properties prop;

    @Given("User opens Apollo Pharmacy homepage")
    public void user_opens_homepage() throws Exception {
        prop = new Properties();
        String path = System.getProperty("user.dir") + "/src/test/resources/Properties/Data.properties";
        FileInputStream fis = new FileInputStream(path);
        prop.load(fis);

        driver = Hooks.driver;
        driver.get(prop.getProperty("ApolloBookingsourceUrl"));

        System.out.println("Apollo homepage launched successfully");
        Thread.sleep(5000); // Debugging pause

        loginPage = new LoginPage(driver);
    }

    @When("User clicks on Find Doctors")
    public void user_clicks_find_doctors() {
        findDoctorsPage = loginPage.clickFindDoctors();
    }

    @Then("Validate the title of the webpage")
    public void validate_title() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Find Doctors"), "Title validation failed! Actual: " + actualTitle);
    }

    @Then("Validate that Browse by Specialty option is displayed")
    public void validate_browse_by_specialty() {
        Assert.assertTrue(findDoctorsPage.isBrowseBySpecialtyVisible(), "Browse by Specialty section not visible!");
    }

    @And("User clicks on Dermatology")
    public void user_clicks_dermatology() {
        Assert.assertTrue(findDoctorsPage.isSpecialtyPresent("Dermatology"), "Dermatology option not found!");
        findDoctorsPage.clickSpecialty("Dermatology");
    }

    @Then("User should navigate to Dermatologists page")
    public void validate_navigation_to_dermatology() {
        Assert.assertTrue(findDoctorsPage.isOnSpecialtyPage("dermatology"), "Navigation to Dermatology page failed!");
    }
}
