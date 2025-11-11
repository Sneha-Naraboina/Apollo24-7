
package com.stepDefinitionTestNG;

import com.pages.HomePage;
import com.setup.BaseSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Profile {

    HomePage homePage;

    @Given("the user is on the Apollo {int} homepage")
    public void the_user_is_on_the_apollo_homepage(Integer int1) {
        BaseSteps.launchBrowser();
        BaseSteps.sleep(3000);
        homePage = new HomePage();
    }

    @When("the user clicks on Health Monitors under Shop by Category")
    public void the_user_clicks_on_health_monitors_under_shop_by_category() {
        BaseSteps.sleep(2000);
        homePage.clickHealthMonitors();
        BaseSteps.sleep(3000);
    }

    @Then("the categories page should be displayed")
    public void the_categories_page_should_be_displayed() {
        homePage.assertHealthMonitorsPageDisplayed();
    }


//    @Then("close Browser")
//    public void close_browser() {
//        if (BaseSteps.driver != null) {
//           BaseSteps.driver.quit();
//            System.out.println("Browser closed after scenario.");
//        }
//    }
//    
}
//===========above original code===========






//package com.stepDefinitionTestNG;
//
//import com.pages.HomePage;
//import com.pages.HealthMonitorsPage;
//import com.setup.BaseSteps;
//import io.cucumber.java.en.*;
//
//public class Profile {
//    HomePage homePage;
//    HealthMonitorsPage healthMonitorsPage;
//
//    @Given("the user is on the Apollo {int} homepage")
//    public void the_user_is_on_the_apollo_homepage(Integer int1) {
//        BaseSteps.sleep(3000);
//        homePage = new HomePage();
//    }
//
//    @When("the user clicks on Health Monitors under Shop by Category")
//    public void the_user_clicks_on_health_monitors_under_shop_by_category() {
//        BaseSteps.sleep(2000);
//        homePage.clickHealthMonitors();
//        BaseSteps.sleep(3000);
//    }
//
//    @Then("the categories page should be displayed")
//    public void the_categories_page_should_be_displayed() {
//        homePage.assertHealthMonitorsPageDisplayed();
//    }
//
//    @Given("the user is on Health Monitors Page")
//    public void the_user_is_on_health_monitors_page() {
//        BaseSteps.sleep(3000);
//        healthMonitorsPage = new HealthMonitorsPage();
//    }
//
//    @When("the user clicks on Brands")
//    public void the_user_clicks_on_brands() {
//        healthMonitorsPage.clickBrands();
//        BaseSteps.sleep(2000);
//    }
//
//    @And("verify the Brands has multiple options")
//    public void verify_the_brands_has_multiple_options() {
//        System.out.println("Brands dropdown contains multiple options.");
//    }
//
//    @And("user click on ApolloPharmacy option")
//    public void user_click_on_apollo_pharmacy_option() {
//        healthMonitorsPage.selectApolloPharmacy();
//        BaseSteps.sleep(1000);
//    }
//
//    @And("user click on Doctors choice option")
//    public void user_click_on_doctors_choice_option() {
//        healthMonitorsPage.selectDoctorsChoice();
//        BaseSteps.sleep(1000);
//    }
//
//    @Then("user select multiple option at a time")
//    public void user_select_multiple_option_at_a_time() {
//        healthMonitorsPage.selectMultipleBrands();
//        System.out.println("Multiple brand options selected.");
//    }
//}









