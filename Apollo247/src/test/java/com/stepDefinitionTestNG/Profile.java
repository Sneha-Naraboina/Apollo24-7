
//package com.stepDefinitionTestNG;
//
//
//import com.pages.HomePage;
//import com.setup.BaseSteps;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class Profile {
//
//    HomePage homePage;
//
//    @Given("the user is on the Apollo {int} homepage")
//    public void the_user_is_on_the_apollo_homepage(Integer int1) {
//        BaseSteps.launchBrowser();
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
//  @Given("the user is on Health Monitors Page")
//  public void the_user_is_on_health_monitors_page() {
//      BaseSteps.sleep(3000);
//      homePage = new HomePage();
//  }
//
//  @When("the user clicks on Brands")
//  public void the_user_clicks_on_brands() {
//      homePage.clickBrands();
//      BaseSteps.sleep(2000);
//  }
//  
//
//  @When("user selects on ApolloPharmacy option")
//  public void user_selects_on_apollo_pharmacy_option() {
//      
//  }
//
//  @When("user selects on Doctors choice option")
//  public void user_selects_on_doctors_choice_option() {
//      
//  }
//
//
//  @Then("user select multiple option at a time")
//  public void user_select_multiple_option_at_a_time() {
//      
//  }
//      
//  }


//    @Then("close Browser")
//    public void close_browser() {
//        if (BaseSteps.driver != null) {
//           BaseSteps.driver.quit();
//            System.out.println("Browser closed after scenario.");
//        }
//    }
//    

//===========above original code===========

   










//C:\Training materials\JAVA\Apollo 247\Apollo247\src\test\resources\ExcelData\Brands.xlsx
package com.stepDefinitionTestNG;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;

import com.pages.HomePage;
import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

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

    @When("the categories page should be displayed")
    public void the_categories_page_should_be_displayed() {
        homePage.assertHealthMonitorsPageDisplayed();
    }

//second scenario
    @Given("the user is on Health Monitors Page")
    public void the_user_is_on_health_monitors_page() {
        BaseSteps.sleep(3000);
        homePage = new HomePage();
    }

    @When("the user clicks on Apollo products")
    public void the_user_clicks_on_apollo_products() {
        BaseSteps.sleep(2000);
        homePage.clickApolloProducts();
        BaseSteps.sleep(2000);
    }
    


    @When("user clicks on personal care products")
    public void user_clicks_on_personal_care_products() {
        BaseSteps.sleep(2000);
        homePage.clickPersonalCareProducts();
        BaseSteps.sleep(2000);
    }

    @When("user clicks on Baby care prodcuts")
    public void user_clicks_on_baby_care_prodcuts() {
        BaseSteps.sleep(2000);
        homePage.clickBabyCareProducts();
        BaseSteps.sleep(2000);
    }

    @Then("user clicls on OTC products")
    public void user_clicls_on_otc_products() {
        BaseSteps.sleep(2000);
        homePage.clickOTCProducts();
        BaseSteps.sleep(2000);
    }
    

//third scenario
    @Given("the user is on Nutritional Drinks and Supplements page")
    public void the_user_is_on_nutritional_drinks_and_supplements_page() {
        BaseSteps.sleep(3000);
        homePage = new HomePage();
    }

    @When("the user clicks on Nutritional Drinks and Supplements")
    public void the_user_clicks_on_nutritional_drinks_and_supplements() {
        BaseSteps.sleep(2000);
        homePage.clickNutritionalDrinks();
        BaseSteps.sleep(2000);
    }

    @When("the user clicks on Nutritional Drinks")
    public void the_user_clicks_on_nutritional_drinks() {
        BaseSteps.sleep(2000);
        homePage.clickNutritionalDrinks();
        BaseSteps.sleep(2000);
    }

    @When("the user clicks on Sports Nutrition")
    public void the_user_clicks_on_sports_nutrition() {
        BaseSteps.sleep(2000);
        homePage.clickSportsNutrition();
        BaseSteps.sleep(2000);
    }

//    @Then("the user verifies the Sports Nutrition page is displayed")
//    public void the_user_verifies_the_sports_nutrition_page_is_displayed() {
//        homePage.assertSportsNutritionPageDisplayed();
//    }
    @Then("the user verifies the Sports Nutrition page is displayed")
    public void the_user_verifies_the_sports_nutrition_page_is_displayed() {
        homePage.assertSportsNutritionClickedAndNavigated();
    }



// fourth scenario

//  @Given("the user clicks on search bar")
//  public void the_user_clicks_on_search_bar() throws InterruptedException {
//      homePage = new HomePage();
//      homePage.clickSearchBar1();
//      BaseSteps.sleep(2000);
//  }
//  
//  @When("the user enters products from sheet {int} and row {int}")
//  public void the_user_enters_products_from_sheet_and_row(Integer int1, Integer int2) {
//
//  	    PropertyReader prop = null;
//		String excelPathSO = prop.getProperty("excelpath");
//  	    String ProductName = ExcelReader.getName(excelPathSO, int1, int2);
//		//String ProductName = ExcelReader.getRowData( sheet,row);
//
//  	    Assert.assertNotNull(ProductName, "Medicine not found at sheet " + int1 + ", row " + int2);
//
//  	    homePage.enterProduct(ProductName);  // ✅ Pass actual value
//  	    System.out.println("Entered medicine: " + ProductName);
//  	}
//      
//  
//
//  @Then("the system should display results")
//  public void the_system_should_display_results() {
//  	homePage.enterProduct("ProductName");
//  	
//      
//
//  }       
//@When("the user clicks on Health condition")
//public void the_user_clicks_on_health_condition() {
//    homePage.clickHealthCondition();
//    BaseSteps.sleep(2000);
//}
//
//@Then("the user Verifies the Health condition page is displayed")
//public void the_user_verifies_the_health_condition_page_is_displayed() {
//    homePage.assertHealthConditionPageDisplayed();
//}
//}


    //fourth new scenario
    @When("the user clicks on sortBy dropdown")
    public void the_user_clicks_on_sort_by_dropdown() {
        BaseSteps.sleep(2000);
        homePage.clickSortByDropdown();
    }

        @When("user select SortOption from Excel {int} {int}")
        public void user_select_sort_option_from_excel(Integer sheet, Integer row) {
            try {
                homePage.selectSortOptionFromExcel(sheet, row);
            } catch (IOException e) {
                Assert.fail("Failed to read sort option from Excel: " + e.getMessage());
            }

    
}
    }


