//package com.stepDefinitionTestNG;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//
//import com.pages.FindDoctorsPage;
//import com.pages.LoginPage;
//import com.parameters.ExcelReader;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile extends BaseSteps {
//
//    WebDriver driver;
//    LoginPage loginPage;
//    FindDoctorsPage findDoctorsPage;
//    ExcelReader excelReader;
//
//    @Given("User open Apollo Pharmacy website")
//    public void user_open_apollo_pharmacy_website() {
//        driver = getDriver(); // ✅ Get driver from Hooks
//        System.out.println("User loads the url");
//        loginPage = new LoginPage(driver);
//    }
//
//    @Then("User login using mobile number and OTP")
//    public void user_login_using_mobile_number_and_otp(io.cucumber.datatable.DataTable table) throws InterruptedException, IOException {
//        loginPage.loginBtn();
//        Thread.sleep(2000);
//
//        // ✅ Fetch mobile number from Excel
//        excelReader = new ExcelReader();
//        excelReader.readExcel();
//        String mobile = excelReader.getCellData("Sheet1", 0, 0);
//        System.out.println("Mobile Number from Excel: " + mobile);
//
//        loginPage.phoneNumber(mobile);
//        loginPage.continueBtn();
//        Thread.sleep(5000);
//        loginPage.verifyBtn();
//        System.out.println("User login successfully and redirected to homepage");
//    }
//
//    @When("User click on Find Doctors")
//    public void user_click_on_find_doctors() {
//        findDoctorsPage = loginPage.findDoctorsbtn();
//    }
//
//    @Then("Doctors module should be displayed")
//    public void doctors_module_should_be_displayed() {
//        Assert.assertTrue(findDoctorsPage.isDoctorSearchVisible(), "Doctors module is not displayed.");
//    }
//
//    @When("User search on search bar")
//    public void user_search_on_search_bar() {
//        findDoctorsPage.clickSearchBar();
//    }
//
//    @Then("search for invalid Doctor names {int} and {int}")
//    public void search_for_invalid_doctor_names_and(Integer sheetNo, Integer rowNo) throws IOException {
//        excelReader.readExcel();
//        String invalidName = excelReader.getCellData1(sheetNo, rowNo);
//        findDoctorsPage.enterSearchQuery(invalidName);
//    }
//
//    @Then("No results found message should be displayed")
//    public void no_results_found_message_should_be_displayed() {
//        Assert.assertTrue(findDoctorsPage.isNoResultsMessageDisplayed(), "No Results message is NOT displayed");
//    }
//}
