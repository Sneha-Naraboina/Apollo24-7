package com.stepDefinitionTestNG;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

//import java.io.IOException;
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import com.pages.HomePage;
//import com.parameters.ExcelReader;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile extends BaseSteps {
//	HomePage homePage = new HomePage(driver);
//	
//
//
//	@Given("user has to be on Home page")
//	public void user_has_to_be_on_home_page() {	
//		String expectedTitle = "Apollo 247";
//		String actualTitle = driver.getTitle();
//	    Assert.assertEquals(actualTitle.contains("Apollo 247"), "Home page is NOT loaded!");
//	    System.out.println(" Home Page Loaded Successfully");	
//		 	
//	}
//
//	@When("Navigate to Buy Medicine")
//	public void navigate_to_buy_medicine() {
//	    // Write code here that turns the phrase above into concrete actions
//		driver.findElement(By.xpath("//a[text()=\"Buy Medicines\"]")).click();
//		homePage.clickBuyMedicines();
//		
//		
//	}
//
//	@And("Navigate to Searchbar")
//	public void navigate_to_searchbar() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		driver.findElement(By.xpath("//div[@data-placeholder=\"Search Medicines\"]")).click();
//		homePage.clickSearchBar();
////		
//		
//	}
//
//	@And("Enter valid medicine name")
//	public void enter_valid_medicine_name() throws IOException {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		String filePath = System.getProperty("user.dir") + "/src/test/resources/ExcelData/TestInput.xlsx";
//		 
//	      // Create ExcelReader object with file path
//	      ExcelReader reader = new ExcelReader(filePath);
//	 
//	      // Read value from Excel (Sheet 0, Row 0, Column 0)
//	      String searchValue = reader.getCellData(0, 0, 0);
//	      System.out.println("Searching for: " + searchValue);
//	 
//	      // Locate search bar and enter value
//	      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	      WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(
//	          By.xpath("//*[@id=\"searchProduct\"]")
//	        //input[@type='search' or @placeholder='Search']
//	          
//	      ));
//	 
//	      searchBar.clear();
//	      searchBar.sendKeys(searchValue);
//	      searchBar.sendKeys(Keys.ENTER);
//	      
//		
//	}
//
//	@And("Click search")
//	public void click_search() {
//	   
//		
//
//	}
//
//	@Then("search related products should be displayed")
//	public void search_related_products_should_be_displayed() {
//	    
//		
//		
//		
//		
//		
//			
//
//	}
//	
//}	


//import java.io.IOException;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.pages.HomePage;
import com.pages.HomePage2;
import com.pages.HomePage3;
import com.parameters.ExcelReader;
import com.parameters.ExcelReader1;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

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
    
     

    @Given("user has to be on Home page")
    public void user_has_to_be_on_home_page() {
        homePage.validateHomePageTitle("Apollo 247");
    }

    @When("Navigate to Buy Medicine")
    public void navigate_to_buy_medicine() {
        homePage.clickBuyMedicines();
    }

    @And("Navigate to Searchbar")
    public void navigate_to_searchbar() {
        homePage.clickSearchBar();
    }

    @And("Enter valid medicine name")
    public void enter_valid_medicine_name()  {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/ExcelData/invalid.xlsx";
        ExcelReader reader = new ExcelReader(filePath);
        String searchValue = reader.getCellData(0, 0, 0);
        System.out.println("Searching for: " + searchValue);
        homePage.enterMedicineName(searchValue);
    }

    @And("Click search")
    public void click_search() {
        // No need to implement anything here if search is triggered by ENTER key in enterMedicineName()
        // If you have a separate search button, you can add a method in HomePage like `clickSearchButton()` and call it here.
    }

    @Then("search related products should be displayed")
    public void search_related_products_should_be_displayed() {
        //homePage.validateSearchResultsDisplayed();
    }
    
    
    
    
    
    
    
    //Second Scenario
    @Given("user be on buy medicine page")
    public void user_be_on_buy_medicine_page() {
    	//homePage2.goToBuyMedicinePage();
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

    	    homePage3.enterMedicine(medicineName);  // ✅ Pass actual value
    	    System.out.println("Entered medicine: " + medicineName);
    	}
        
    

    @Then("the system should display results")
    public void the_system_should_display_results() {

////    	String actual = searchInput.getAttribute("value");
////    	String expected = medicineName; // From Excel
//    	Assert.assertEquals(homePage.actual, expected, "Search box value does not match expected medicine!");
	
    	
    	
    	
    	
    	

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
