package com.pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;

public class HomePage {
    static WebDriver driver;
    static WebDriver wait;

    @FindBy(xpath = "//a[text()='Lab Tests']")
    private WebElement labTestsLink;

    @FindBy(xpath = "//header[h2[contains(text(),'Top Booked Tests')]]//a[contains(text(),'View All')]")
    private WebElement viewAllLink;

    @FindBy(xpath = "//h1[contains(text(),'Top Booked Tests')]")
    private WebElement verifyViewAll;
    
    @FindBy(xpath = "(//span[text()='Add'])[1]") // Adjust locator based on actual button text
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[text()='Upgrade To']") // Adjust locator for pop-up
    private WebElement cartPopup;
    
    @FindBy(xpath = "//button[contains(text(),'Sort By')]") 
    private WebElement sortbybutton;
     
    @FindBy (xpath = "//span[text()='Price: Low to High']")
    private WebElement LowToHigh;
    
    @FindBy (xpath = "(//input[@type='checkbox'])[1]")
    private WebElement topDeals;
    
    @FindBy(xpath = "//input[@placeholder='Search for lab tests']")
    private WebElement searchBox;
    
    @FindBy(xpath = "//div[@class='LabTestsSearch_viewAllWrapper__XJO5N' and normalize-space()='View All']")
    private WebElement inputBox;
    
    @FindBy (xpath = "//div[normalize-space(text())='Search Result']")
    private WebElement verifyTest;
    
    @FindBy(xpath = "//div[@class='GoToCartBannerNew_viewDetails__diWp6']/span[normalize-space()='View Details']")
    private WebElement viewDetails;
    
    @FindBy(xpath = "//div[span[normalize-space()='Show Less']]/span")
    private WebElement showDetails;
    
    @FindBy(xpath = "(//img[contains(@alt,'close')])[1]")
    private static WebElement popUp;
    
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
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            try {
                element.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
            }
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


    public void clickAddToCart() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

            try {
                element.click();
            } catch (Exception e) {
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
//    public static void clickclose()
//    {
//    	
//    	try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(popUp));
//            popUp.click();
//
////            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
//
//            try {
//                element.click();
//            } catch (Exception e) {
//                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//            }
//        } catch (TimeoutException e) {
//            System.out.println("Add to Cart button not found or not clickable: " + e.getMessage());
//        }
//    }
    
    public static void clickclose() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(popUp));
            closeBtn.click();
            System.out.println("Popup closed successfully.");

            // Wait until modal background disappears
            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(@class,'CallbackWidget_modalBackground')]")
            ));
            System.out.println("Modal overlay removed.");
        } catch (TimeoutException e) {
            System.out.println("Popup not found or not clickable: " + e.getMessage());
        }
    }

    
    

//	public void clickSortBy() {
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'Aj') and contains(@style,'display')]")));
//
//	    WebElement sortButton = wait.until(ExpectedConditions.elementToBeClickable(sortbybutton));
//
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sortButton);
//
//	    try {
//	        sortButton.click();
//	    } catch (ElementClickInterceptedException e) {
//
//	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sortButton);
//	    }
//	}
	


//	public void selectLowToHigh() {
//		
//		//String[] firstXpath = ExcelReader.getRowData(sheet, row); 
//		new WebDriverWait(driver, Duration.ofSeconds(15))
//        .until(ExpectedConditions.visibilityOf(LowToHigh));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", LowToHigh);
//		
//	}
	
	

	
	private void until(ExpectedCondition<WebElement> visibilityOf) {
		// TODO Auto-generated method stub
		
	}

//	public boolean verifysortby() {
//        try {
//            new WebDriverWait(driver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.urlContains("top-booked-tests"));
//            return verifyViewAll.isDisplayed();
//        } catch (TimeoutException e) {
//            return false;
//        }
//    }
//	public void selectTopDeals(int sheet,int row) throws IOException {
//		String[] topDealsXpath = ExcelReader.getRowData(sheet, row);
//		new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(topDeals));
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", topDeals);
//	}
	
	public void selectFiltersFromExcel(int sheetIndex, int rowIndex) throws IOException {
	    // Read row data from Excel
	    String[] filters = ExcelReader.getRowData(sheetIndex, rowIndex);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    for (String filterName : filters) {
	        if (filterName != null && !filterName.trim().isEmpty()) {
	            String xpath = "//label[normalize-space(text())='" + filterName.trim() + "']";

	            try {
	                WebElement labelElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	                js.executeScript("arguments[0].scrollIntoView(true);", labelElement);
	                js.executeScript("arguments[0].click();", labelElement);
	                System.out.println("Clicked filter: " + filterName);
	            } catch (TimeoutException e) {
	                System.err.println("Filter not found or not clickable: " + filterName);
	            }
	        }
	    }
	}public boolean verifycheck() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(60))
                .until(ExpectedConditions.urlContains("top-booked-tests"));
            return verifyViewAll.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
	
	 
//	 public void clickSearchBox() throws InterruptedException {
//		 Thread.sleep(5000);
//	        new WebDriverWait(driver, Duration.ofSeconds(10))
//	            .until(ExpectedConditions.elementToBeClickable(searchBox))
//	            .click();
//	    }
	
	public void clickSearchBox() {
	    clickclose(); // Close popup first
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(searchBox)).click();
	}
	
	
//	 public void enterTest(String[] TestName) throws IOException   {
//		 
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//			((JavascriptExecutor)driver).executeScript("arguments[0].click();", inputbox);
//			searchBox.sendKeys(TestName);
//			System.out.println("DEBUG: Sent to search box -> " + TestName);
//		}

	 public void enterTest(String[] testData) {
		 // TODO Auto-generated method stub
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 //((JavascriptExecutor)driver).executeScript("arguments[0].click();", searchBox);

		 wait.until(ExpectedConditions.visibilityOf(searchBox));
		 searchBox.click();

		 searchBox.sendKeys(testData[0]);

	 }
	 
	 
	 public void clickEnter() throws InterruptedException {
		 Thread.sleep(2000);
	        new WebDriverWait(driver, Duration.ofSeconds(10))
	            .until(ExpectedConditions.elementToBeClickable(inputBox))
	            .click();
	    }
	 
	 public boolean verifyTests() {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(60))
	                .until(ExpectedConditions.urlContains("top-booked-tests"));
	            return verifyTest.isDisplayed();
	        } catch (TimeoutException e) {
	            return false;
	        }
	
	
	 }
	 
//	 public void clickViewDetails() throws InterruptedException {
//
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//		 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'Aj') and contains(@style,'display')]")));
//
//		 WebElement view = wait.until(ExpectedConditions.elementToBeClickable(viewDetails));
//
//		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", view);
//
//		 try {
//			 view.click();
//			 Thread.sleep(5000);
//		 } catch (ElementClickInterceptedException e) {
//
//			 ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
//		 }
//	 }
	 
	 public void clickViewDetails() throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    // Wait for any blocking banner to disappear
		    try {
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(
		            By.xpath("//div[contains(@class,'GoToCartBannerNew_moveToCart')]")
		        ));
		        System.out.println("Blocking banner removed.");
		    } catch (TimeoutException e) {
		        System.out.println("No blocking banner found or it did not disappear in time.");
		    }

		    // Now click View Details
		    WebElement view = wait.until(ExpectedConditions.elementToBeClickable(viewDetails));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", view);

		    try {
		        view.click();
		        Thread.sleep(5000);
		    } catch (ElementClickInterceptedException e) {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", view);
		    }
		}

	 public boolean verifyViewDetails() {
	        try {
	            new WebDriverWait(driver, Duration.ofSeconds(60))
	                .until(ExpectedConditions.urlContains("top-booked-tests"));
	            return showDetails.isDisplayed();
	        } catch (TimeoutException e) {
	            return false;
	        }
	
	
	 }
	 
	 
	 
}


		
