

package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.parameters.ExcelReader;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class HomePage {
	//private static WebDriver wait;

    WebDriver driver;

    public HomePage() {
        this.driver = BaseSteps.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div[1]/div/a/div")
    public WebElement healthMonitorsLink;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div/div[1]/label/span[1]/div")
    public WebElement brandsDropdown;
    
 // Category links under Health Monitors
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/ul/li[1]/a")
    public WebElement apolloProductsLink;

    @FindBy(xpath = "//a[contains(@href,'personal-care')]")
    public WebElement personalCareLink;

    @FindBy(xpath = "//a[contains(@href,'baby-care')]")
    public WebElement babyCareLink;

    @FindBy(xpath = "//a[contains(@href,'otc')]")
    public WebElement otcLink;
    
 // Nutritional Drinks and Supplements section
    @FindBy(xpath = "//a[contains(@href,'nutritional-drinks-and-supplements')]")
    public WebElement nutritionalDrinksSupplementsLink;

    @FindBy(xpath = "//a[contains(@href,'nutritional-drinks')]")
    public WebElement nutritionalDrinksLink;

    @FindBy(xpath = "//a[contains(@href,'sports-nutrition')]")
    public WebElement sportsNutritionLink;
    
//    //search-fourth scenario
//
//    @FindBy(xpath = "/html/body/div[1]/header/div/div/div/div[2]/div")
//    public static WebElement searchBar;
//
//    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div/div/div[1]")
//  //*[@id="searchProduct"]
//    public WebElement searchInput;
//    
//    
//    @FindBy(xpath = "//a[contains(@href,'health-condition')]")
//    public WebElement healthConditionLink;

   
//fourth scenario- new
    @FindBy(xpath = "//*[@id=\"product-container\"]/div[1]/div/div/button/span")
    public WebElement sortbybutton;

    @FindBy(xpath = "//*[@id=\"simple-menu\"]/div[1]")
    public List<WebElement> sortOptions;





    public void scrollToHealthMonitors() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", healthMonitorsLink);
    }

    public void clickHealthMonitors() {
        try {
            healthMonitorsLink.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", healthMonitorsLink);
        }
    }

    public void assertHealthMonitorsPageDisplayed() {
        String expectedUrl = PropertyReader.getProperty("expectedUrl").trim();
        String actualUrl = driver.getCurrentUrl().trim();
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch: Expected vs Actual");
        System.out.println("Health Monitors page loaded successfully.");
    }

    public void clickBrands() {
        brandsDropdown.click();
    }
//second scenario
public void clickApolloProducts() {
    try {
        apolloProductsLink.click();
        System.out.println("Clicked on Apollo Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apolloProductsLink);
    }

}

public void clickPersonalCareProducts() {
    try {
        personalCareLink.click();
        System.out.println("Clicked on Personal Care Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", personalCareLink);
    }
}

public void clickBabyCareProducts() {
    try {
        babyCareLink.click();
        System.out.println("Clicked on Baby Care Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", babyCareLink);
    }
}

public void clickOTCProducts() {
    try {
        otcLink.click();
        System.out.println("Clicked on OTC Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", otcLink);
    }
}

//third scenario
public void clickNutritionalDrinksSupplements() {
    try {
        nutritionalDrinksSupplementsLink.click();
        System.out.println("Clicked on Nutritional Drinks and Supplements.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nutritionalDrinksSupplementsLink);
    }
}

public void clickNutritionalDrinks() {
    try {
        nutritionalDrinksLink.click();
        System.out.println("Clicked on Nutritional Drinks.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nutritionalDrinksLink);
    }
}

public void clickSportsNutrition() {
    try {
        sportsNutritionLink.click();
        System.out.println("Clicked on Sports Nutrition.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsNutritionLink);
    }
}



public void assertSportsNutritionClickedAndNavigated() {
    String actualUrl = driver.getCurrentUrl().trim();
    String expectedUrl = PropertyReader.getProperty("sportsNutrition.expectedUrl");

    if (expectedUrl == null) {
        throw new RuntimeException("Missing key: sportsNutrition.expectedUrl in Profile.properties");
    }

    expectedUrl = expectedUrl.trim();
    Assert.assertEquals(actualUrl, expectedUrl, "Click failed: URL mismatch after clicking Sports Nutrition.");
    System.out.println("Navigation to Sports Nutrition page verified.");
}


//fourth scenario
//public void clickSearchBar() {
//    try {
//        searchBar.click();
//    } catch (Exception e) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchBar);
//    }
//}
//
//public void enterProductInSearchBar(String productName) {
//    try {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	wait.until(ExpectedConditions.visibilityOf(searchInput));
//        searchInput.clear();
//        searchInput.sendKeys(productName);
//        searchInput.sendKeys(Keys.ENTER);
//        System.out.println("Searched for product: " + productName);
//    } catch (Exception e) {
//        throw new RuntimeException("Failed to search for product: " + productName, e);
//    }
//}



//public void clickHealthCondition() {
//    try {
//        healthConditionLink.click();
//    } catch (Exception e) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", healthConditionLink);
//    }
//}
//public void assertHealthConditionPageDisplayed() {
//    String expectedUrl = PropertyReader.getProperty("healthCondition.expectedUrl").trim();
//    String actualUrl = driver.getCurrentUrl().trim();
//
//    if (expectedUrl == null || expectedUrl.isEmpty()) {
//        throw new RuntimeException("Missing or empty key: healthCondition.expectedUrl in Profile.properties");
//    }
//
//    Assert.assertEquals(actualUrl, expectedUrl, "Health Condition page not loaded correctly.");
//    System.out.println("Health Condition page verified.");
//}
//}


//varshitha code

//public void clickSearchBar1() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    wait.until(ExpectedConditions.elementToBeClickable(searchBar));
//    Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
//    searchBar.click();
//    System.out.println("Search bar clicked");
//    Thread.sleep(5000);
//}
//
//public void enterProduct(String ProductName) {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//    wait.until(ExpectedConditions.visibilityOf(searchInput));
//    searchInput.clear();
//    searchInput.sendKeys(ProductName);
//
//    
//
//    //  Verify input is present
//    String enteredValue = searchInput.getAttribute("value");
//    Assert.assertEquals(enteredValue, ProductName, "Medicine name not entered correctly!");
//    System.out.println("Medicine entered and search triggered: " + ProductName);
//}
//public void clickHealthCondition() {
//try {
//  healthConditionLink.click();
//} catch (Exception e) {
//  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", healthConditionLink);
//}
//}
//public void assertHealthConditionPageDisplayed() {
//String expectedUrl = PropertyReader.getProperty("healthCondition.expectedUrl").trim();
//String actualUrl = driver.getCurrentUrl().trim();
//
//if (expectedUrl == null || expectedUrl.isEmpty()) {
//  throw new RuntimeException("Missing or empty key: healthCondition.expectedUrl in Profile.properties");
//}
//
//Assert.assertEquals(actualUrl, expectedUrl, "Health Condition page not loaded correctly.");
//System.out.println("Health Condition page verified.");
//}
//}

//fourth-new-scenario

public void clickSortByDropdown() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.elementToBeClickable(sortbybutton));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sortbybutton);

    try {
        sortbybutton.click();
        System.out.println("Clicked SortBy dropdown.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortbybutton);
    }
}

public void selectSortOptionFromExcel(int sheet, int row) throws IOException {
    String[] sortValues = ExcelReader.getRowData(sheet, row);
    for (String value : sortValues) {
        if (!value.trim().isEmpty()) {
            selectSortOption(value.trim());
        }
    }
}

public void selectSortOption(String optionText) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfAllElements(sortOptions));

    boolean found = false;
    for (WebElement option : sortOptions) {
        String text = option.getText().trim();
        if (text.equalsIgnoreCase(optionText)) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
            System.out.println("Selected sort option: " + text);
            found = true;
            break;
        }
    }
}
}





	














