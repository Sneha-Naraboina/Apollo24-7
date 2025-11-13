package com.stepDefinitionTestNG;
 
import java.io.IOException;

import org.testng.Assert;

import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BasePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
public class LabTestsNavigationSteps extends BasePage {
    HomePage homePage;
 
    @Given("user is on Apollo247 Homepage")
    public void user_is_on_apollo247_homepage() {
        // Initialize HomePage object after driver is launched in Hooks
        homePage = new HomePage(driver);
        // Navigate to Apollo247 homepage using property file
        driver.get(PropertyReader.getProperty("sourceUrl"));
    }
 
    @When("user clicks on Lab Tests Link")
    public void user_clicks_on_lab_tests_link() {
        // Click on Lab Tests link using PageFactory method
        homePage.clickLabTestsLink();
    }
    @And("user clicks on View All Link")
    public void user_clicks_on_view_all_link() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    	homePage.clickViewAll();
    }
    
    @Then("should be display View All page")
    public void should_be_display_view_all_page() {
    	String expectedUrl = PropertyReader.getProperty("targetUrl");
    	String actualUrl = driver.getCurrentUrl();
    	System.out.println("Actual URL: " + actualUrl);

    	Assert.assertEquals(actualUrl, expectedUrl, "View All page URL mismatch!");
    	Assert.assertTrue(homePage.verifyViewAll(), "View All section is not visible!");


    }

    	@When("I click on the Add to Cart button for a test")
    	public void i_click_on_the_add_to_cart_button_for_a_test() {
    		homePage.clickAddToCart();
    	}

    	@Then("a pop-up should appear at the bottom right of the page")
    	public void a_pop_up_should_appear_at_the_bottom_right_of_the_page() {
    		Assert.assertTrue(homePage.verifyPopupDisplayed(), "Pop-up did not appear after adding to cart!");
    	
        
    	}	
    		
    	@When("I click on the Sort By dropdown")
    	public void i_click_on_the_sort_by_dropdown() {
    	    homePage.clickSortBy();
    	}


    	
    	@When("I select SortOption from Excel {int} {int}")
    	public void i_select_sort_option_from_excel(Integer sheet, Integer row) throws IOException {
    		homePage.selectLowToHigh(sheet, row);
    	}
    	
    	

    	@Then("the list of lab tests should be display")
    	public void the_list_of_lab_tests_should_be_display() {
//    		Assert.assertTrue(homePage.verifylowtohigh(), "Low to high tests is displayed !");
    		String expectedUrl = PropertyReader.getProperty("targetUrl");
        	String actualUrl = driver.getCurrentUrl();
        	System.out.println("Actual URL: " + actualUrl);

        	Assert.assertEquals(actualUrl, expectedUrl, "View All page URL mismatch!");
        	Assert.assertTrue(homePage.verifysortby(), "View All section is not visible!");
    	}
    	
    	@When("I select filters from Excel {int} {int}")
    	public void i_select_filters_from_excel(Integer sheet, Integer row) throws IOException {
    		homePage.selectFiltersFromExcel(sheet, row);
    	    
    	}

    	@Then("the filtered list of lab tests should be displayed")
    	public void the_filtered_list_of_lab_tests_should_be_displayed() {
    		Assert.assertTrue(homePage.verifycheck(), "Displays topbooked tests after applying filters");
    	    
    	}
    	
    	
    	
    	
    	
}


//    // Take screenshot for debugging
//         try {
//             File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//             FileUtils.copyFile(screenshot, new File("target/screenshots/ViewAllPage.png"));
//         } catch (Exception e) {
//             System.out.println("Screenshot capture failed: " + e.getMessage());
//         }
//    
//        }
//}



 




