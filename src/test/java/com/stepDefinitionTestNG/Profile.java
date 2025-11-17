package com.stepDefinitionTestNG;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;
import com.pages.HomePage2;
import com.pages.HomePage3;
import com.parameters.ExcelReader;
import com.parameters.ExcelReader1;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;
import com.setup.Reports;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Profile extends BaseSteps {
	
	WebDriver driver=BaseSteps.driver;
	ExtentTest test=Hooks.test;
	
	Properties prop = PropertyReader.readProperty();

    HomePage homePage = new HomePage(driver);
    HomePage2 homePage2 = new HomePage2(driver);
    HomePage3 homePage3 = new HomePage3(driver);
    
     

    //==================================================================================
    
    @Given("user is on buy medicine page")
    public void user_is_on_buy_medicine_page() {
    	 homePage.clickBuyMedicines();
        
    }

    @And("user clicks on the Lab Tests")
    public void user_clicks_on_the_lab_tests() {
    	 homePage.clickLabTest();
        
    }

    @And("user cliks on the serach bar")
    public void user_cliks_on_the_serach_bar() {
    	homePage.clickSearch();
        
    }


    
    @And("user enters valid test name from sheet {int} and row {int}")
    public void user_enters_valid_test_name_from_sheet_and_row(Integer int1, Integer int2) {
    	
    	String excelPathSO = prop.getProperty("ExcelPath1");
	    String testName = ExcelReader.getName(excelPathSO, int1, int2);

	    //Assert.assertNotNull(testName, "testName not found at sheet " + int1 + ", row " + int2);

	    homePage.enterMedicine(testName);  //  Pass actual value
	    System.out.println("Entered medicine: " + testName);
    	
        
    }

    @Then("search related tests should be displayed")
    public void search_related_tests_should_be_displayed() {
    	boolean verify = homePage.verify();
    	Assert.assertTrue(verify);
    	Reports.captureScreenshot(driver, "Scenario_01");
    }
//=============================================================================================
    
    
    
    
    
    
    //Second Scenario
    @Given("user be on buy medicine page")
    public void user_be_on_buy_medicine_page() {
    	homePage2.clickBuyMedicines();
    	//driver.get(config.getProperty("buyMedicineUrl"));
    	//HomePage3.clickBuyMedicines1();
    	
        
    }

    @And("user navigates to Browse by Health Conditions")
    public void user_navigates_to_browse_by_health_conditions() {
    	//homePage2.clickBrowseByHealthConditions();
    	
    }

    @When("click on Diabetes care")
    public void click_on_diabetes_care() {
    	homePage2.clickDiabetesCare1();;
    }
    
    @Then("health conditions element should be displayed")
    public void health_conditions_element_should_be_displayed() {
        homePage2.healthconditionselementshouldbedisplayed();
        Reports.captureScreenshot(driver, "Scenario_02");
    	
    	

    }

    
   //third scenario
    @Given("the user is on the buy medicine page")
    public void the_user_is_on_the_buy_medicine_page() {
    	homePage3 = new HomePage3(driver);
    	homePage3.clickBuyMedicines1();
    	//homePage3.clickSearchBar1();
        
    }


    
    
//    @When("the user enters medicine name from sheet {int} and row {int} in the search box")
//    public void the_user_enters_medicine_name_from_sheet_and_row_in_the_search_box(Integer int1, Integer int2) throws InterruptedException {
//    	String excelPathSO = prop.getProperty("ExcelPath");
//    	String Medicine = ExcelReader1.getName(excelPathSO, int1, int2);
//    	Thread.sleep(2000);
//    	Assert.assertNotNull(Medicine, "Medicine not found at sheet " + int1 + ", row " + int2);
//    	
//    }
//
//        
//    
//
//    @And("clicks on the search button")
//    public void clicks_on_the_search_button() {
//    	//wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
//    	
//        
//    }
//
//    @Then("the system should display results")
//    public void the_system_should_display_results() {
//    	
//    	 homePage3.enterMedicine("Medicine");
//        
//    }
    @When("the user clicks on search box")
    public void the_user_clicks_on_search_box() {
    	homePage3.clickSearchBar1();
    	
        
    }

    @When("the user enters medicine name from sheet {int} and row {int} in the search box")
    public void the_user_enters_medicine_name_from_sheet_and_row_in_the_search_box(Integer int1, Integer int2) {
//    	String excelPathSO = prop.getProperty("ExcelPath");
//    	String Medicine = ExcelReader1.getName(excelPathSO, int1, int2);
//    	
//    	Assert.assertNotNull(Medicine, "Medicine not found at sheet " + int1 + ", row " + int2);
    	//@When("the user enters medicine name from sheet {int} and row {int} in the search box")
    	//public void the_user_enters_medicine_name_from_sheet_and_row_in_the_search_box(Integer sheetIndex, Integer rowIndex) {
    	    String excelPathSO = prop.getProperty("ExcelPath");
    	    String medicineName = ExcelReader1.getName(excelPathSO, int1, int2);

    	    Assert.assertNotNull(medicineName, "Medicine not found at sheet " + int1 + ", row " + int2);

    	    homePage3.enterMedicine(medicineName);  //  Pass actual value
    	    System.out.println("Entered medicine: " + medicineName);
    	}
        
    

//    @Then("the system should display results")
//    public void the_system_should_display_results() {
//    	Assert.assertTrue(homePage3.verifyProductDetailPage());
    	
// }
    
//    @Then("the system should display results")
//    public void the_system_should_display_results() {
//        String expectedMessage = "We’re sorry, the item you searched could not be found. Instead you can continue your search by uploading prescription!";
//        Assert.assertTrue(homePage3.verifyErrorMessage(expectedMessage));
//        
//    }
    
    @Then("the system should display results")
    public void the_system_should_display_results() {
        String expectedMessage = "We’re sorry, the item you searched could not be found. Instead you can continue your search by uploading prescription!";
        Assert.assertTrue(homePage3.verifyErrorMessage(expectedMessage));
        Reports.captureScreenshot(BaseSteps.driver, "MedicineName");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   // --------------------------4th Scenario----------------------------------------------
    
    @When("user clicks on Get {int}% off on medicine")
    public void user_clicks_on_get_off_on_medicine(Integer int1) {
        homePage3.clickGetMeds();
    }
    @When("user navigates to the upload prescriptions page")
    public void user_navigates_to_the_upload_prescriptions_page() {
        
    	boolean verify = homePage3.navigateToGetmeds();
    	Assert.assertTrue(verify);
    }

    @When("click on the view all categories in the product categories")
    public void click_on_the_view_all_categories_in_the_product_categories() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	homePage3.clickViewAllCategory();
    	
    	
    }

//
    @Then("results should be displayed")
    public void results_should_be_displayed() {
    	homePage3.Check();
    	//homePage3.Check();
//    	boolean verify = homePage3.Check();
//    	Assert.assertTrue(verify);
    	//Reports.captureScreenshot(BaseSteps.driver, "view all");
    	Reports.captureScreenshot(driver, "Scenario_04");
//       
    }

    

//@Then("results should be displayed")
//public void results_should_be_displayed() {
//    // Expected breadcrumb text
//    String expectedText = "Home > All categories";
//
//    // Locate the element using XPath
//    WebElement breadcrumb = driver.findElement(By.xpath("//div[text()='Home > All categories']"));
//
//    // Assert that the text matches
//    Assert.assertEquals("Breadcrumb text does not match!", expectedText, breadcrumb.getText());
//}


//-------------------------------------5th scenario-----------------------------------
@When("user click the first product")
public void user_click_the_first_product() {
    // Write code here that turns the phrase above into concrete actions
    //throw new io.cucumber.java.PendingException();
	 homePage3.clickProduct(); 
}

@When("click on cart icon")
public void click_on_cart_icon() {
    
	//Assert.assertTrue(homePage3.clickCart());
	homePage3.clickCart();
	
}

@Then("verify no product to be visible")
public void verify_no_product_to_be_visible() {
    
//	Assert.assertTrue(homePage3.Verify());
	homePage3.Verify();
	Reports.captureScreenshot(driver, "Scenario_05");
}

}
























//	@When("the user enters invalid inputs into the search box")
//	public void the_user_enters_invalid_inputs_into_the_search_box() throws IOException {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		
//		String filePath = System.getProperty("user.dir") + "/src/test/resources/Exceldata/TestInput.xlsx";
//		 
//	      // Create ExcelReader object with file path
//	      ExcelReader reader = new ExcelReader(filePath);
//	 
//	      // Read value from Excel (Sheet 0, Row 0, Column 0)
//	      String searchValue = reader.getCellData(0, 0, 1);
//	      System.out.println("Searching for: " + searchValue);
//	 
//	      // Locate search bar and enter value
//	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	      WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(
//	          By.xpath("//*[@id=\"searchProduct\"]")
//	        //input[@type='search' or @placeholder='Search']
//	          
//	      ));
//	      searchBar.clear();
//	      searchBar.sendKeys(searchValue);
//	      searchBar.sendKeys(Keys.ENTER);
//	      System.out.println("searching for invalid input:"+searchValue);
//		
//		
//	}
//
//	@When("clicks the search button")
//	public void clicks_the_search_button() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the system should display a message {string}")
//	public void the_system_should_display_a_message(String string) {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//
//
//}
