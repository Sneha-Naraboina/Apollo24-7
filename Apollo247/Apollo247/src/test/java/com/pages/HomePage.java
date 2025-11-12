package com.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Lab Tests']")
    private WebElement labTestsLink;

//    @FindBy(xpath = "//a[contains(text(),'View All')]")
//    private WebElement viewAllLink;

    @FindBy(xpath = "//header[h2[contains(text(),'Top Booked Tests')]]//a[contains(text(),'View All')]")
    private WebElement viewAllLink;
    
//    @FindBy(xpath = "//h2[contains(text(),'Top Booked Tests')]")
//    private WebElement verifyViewAll;
    

    @FindBy(xpath = "//h1[contains(text(),'Top Booked Tests')]")
    private WebElement verifyViewAll;
    

    @FindBy(xpath = "//div[contains(@class,'sort-by-dropdown')]")
    WebElement sortByDropdown;

    @FindBy(xpath = "//ul[contains(@class,'sort-options')]/li")
    List<WebElement> sortOptions;



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLabTestsLink() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(labTestsLink))
            .click();
    }

    public void clickViewAll() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(viewAllLink));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Click normally first
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS click
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }

            // Wait for URL to change
            wait.until(ExpectedConditions.urlContains("top-booked-tests"));

        } catch (Exception e) {
            System.out.println("Failed to click View All: " + e.getMessage());
        }
    }
    
    public boolean verifyViewAll() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.urlContains("top-booked-tests"));
            return verifyViewAll.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


    @FindBy(xpath = "(//span[text()='Add'])[1]") // Adjust locator based on actual button text
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Upgrade To']") // Adjust locator for pop-up
    private WebElement cartPopup;

    public void clickAddToCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

            // Scroll into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            // Try normal click
            try {
                element.click();
            } catch (Exception e) {
                // Fallback to JS click if normal click fails
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
        } catch (TimeoutException e) {
            System.out.println("Add to Cart button not found or not clickable: " + e.getMessage());
        }
    }
    	
    public boolean verifyPopupDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(cartPopup));
            return cartPopup.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

	@FindBy(xpath = "//button[contains(text(),'Sort By')]") 
    private WebElement sortbybutton;
	
	@FindBy(xpath = "//li//span[normalize-space(text())='Price: Low to High']") 
    private WebElement lowtohigh;

	public void clickSortBy() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    // Wait for overlay or loader to disappear
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'Aj') and contains(@style,'display')]")));

	    // Wait for Sort By button to be clickable
	    WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(sortbybutton));

	    // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sortButton);

	    try {
	        sortButton.click();
	    } catch (ElementClickInterceptedException e) {
	        // Fallback to JS click
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortButton);
	    }
	}
	
	
   
//	public void selectSortOption(String optionText) {
//	    WebElement optionElement = new WebDriverWait(driver, Duration.ofSeconds(10))
//	        .until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='" + optionText + "']")));
//	    optionElement.click();
//	}


//	public void selectSortOption(String optionText) {
//	    optionText = optionText.trim(); // Normalize Excel value
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//	    // ✅ Wait for option to be clickable
//	    WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(
//	        By.xpath("//li[contains(text(),'" + optionText + "')]")));
//
//	    // ✅ Scroll and click
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionElement);
//	    optionElement.click();
//	}
//	
	public boolean selectSortOptionFromExcel(int sheetNo, int rowNum) throws IOException {
	    boolean actResult = true;
	    try {
	        // ✅ Read SortOption from Excel (column fixed as 0)
	        String sortOption = ExcelReader.getCellData(sheetNo, rowNum, 0).trim();
	        System.out.println("Sort Option from Excel: " + sortOption);

	        // ✅ Wait for dropdown option to be clickable
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li//span[normalize-space(text())='" + sortOption + "']")));

	        // ✅ Scroll into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", optionElement);

	        // ✅ Try normal click
	        try {
	            optionElement.click();
	        } catch (ElementClickInterceptedException e) {
	            // ✅ Fallback to JS click
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", optionElement);
	        }

	        // ✅ Optional Reporting
	        // Reports.generateReport(driver, test, Status.PASS, "Clicked SortOption: " + sortOption);

	    } catch (TimeoutException | ElementClickInterceptedException e) {
	        actResult = false;
	        System.out.println("Failed to click SortOption: " + e.getMessage());
	        // Reports.generateReport(driver, test, Status.FAIL, "Failed to click SortOption: " + e.getMessage());
	    }
	    return actResult;
	}}
	
//	public boolean verifylowtohigh() {
//        try {
//            new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOf(lowtohigh));
//            return lowtohigh.isDisplayed();
//        } catch (TimeoutException e) {
//            return false;
//        }
//    }
//	
//}