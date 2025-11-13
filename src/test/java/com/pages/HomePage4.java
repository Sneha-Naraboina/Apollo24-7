//package com.pages;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import java.time.Duration;
//
//public class HomePage {
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    //  Constructor initializes PageFactory
//    public HomePage(WebDriver driver) {
//    	
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//       
//        
//    }
//
//    // PageFactory element locators
//    @FindBy(xpath = "//a[text()='Buy Medicines']")
//    private WebElement buyMedicinesLink;
//
//    @FindBy(xpath = "//div[@data-placeholder='Search Medicines']")
//    private WebElement searchBar;
//
//    @FindBy(xpath = "//*[@id='searchProduct']")
//    private WebElement searchInput;
//    
//    
//    
//
//    
//
//    
//    //  Validate Home Page Title
//    public void validateHomePageTitle(String expectedTitle) {
//        String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.contains(expectedTitle),
//                "Home page title mismatch! Expected to contain: " + expectedTitle);
//        System.out.println("Home Page Loaded Successfully: " + actualTitle);
//    }
//
//    //  Click on "Buy Medicines" link
//    public void clickBuyMedicines() {
//        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
//        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
//        buyMedicinesLink.click();
//        System.out.println("Navigated to Buy Medicines");
//    }
//
//    //  Click on the search bar\\\\
//    public void clickSearchBar() {
//        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
//        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
//        searchBar.click();
//        System.out.println("Search bar clicked");
//    }
//
//    //  Enter medicine name in the search bar
//    public void enterMedicineName(String medicineName) {
//        wait.until(ExpectedConditions.visibilityOf(searchInput));
//        Assert.assertTrue(searchInput.isDisplayed(), "Search input field is not visible!");
//        searchInput.clear();
//        searchInput.sendKeys(medicineName);
//        searchInput.sendKeys(Keys.ENTER);
//        System.out.println("Searching for medicine: " + medicineName);
//    }
//
//    // Optional: Get page title
//    public String getPageTitle() {
//        return driver.getTitle();
//    }
//}
////------------------------------end of HomePage-------------------------------------------
//
////-----------------------HomePage2-----------------------------
//package com.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//public class HomePage2 {
//	private static WebDriverWait wait;
//	private static  WebDriver driver;
//   
//
//    //  Constructor initializes PageFactory
//    public HomePage2(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    // PageFactory element locators
//    @FindBy(xpath = "//a[text()='Buy Medicines']")
//    private static WebElement buyMedicinesLink;
//
//    @FindBy(xpath = "//*[@id='Browse by Health Conditions Web']/div[2]/div[1]/div/a/div[2]/h3")
//    private WebElement diabetesCare;
//
//    @FindBy(xpath = "//h2[text()='Apollo Pharmacy Smart Blood Glucose Monitoring Bluetooth System with Diabetes Management App, APG-01 + 25 Test Strips, 1 kit']")
//    private WebElement healthConditionElement;
//
//    //  Actions
//    public static void clickBuyMedicines() {
//        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
//        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
//        buyMedicinesLink.click();
//        System.out.println("Navigated to Buy Medicines");
//    }
//
//    public void clickDiabetesCare1() {
//        wait.until(ExpectedConditions.elementToBeClickable(diabetesCare));
//        Assert.assertTrue(diabetesCare.isDisplayed(), "Diabetes Care element is not visible!");
//        diabetesCare.click();
//        System.out.println("Clicked Diabetes Care");
//    }
//
//    public void healthconditionselementshouldbedisplayed() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(
//            org.openqa.selenium.By.xpath("//h2[text()='Apollo Pharmacy Smart Blood Glucose Monitoring Bluetooth System with Diabetes Management App, APG-01 + 25 Test Strips, 1 kit']")
//        ));
//        Assert.assertTrue(healthConditionElement.isDisplayed(), "Health condition element is not visible!");
//        healthConditionElement.click();
//    }
//}
//
//
//
//
//
////----------------------end of HomePage2-----------------------------------
//
//
////------------------------------------HomePage3----------------------------
//
//
//public class HomePage3 {
//    private static WebDriverWait wait;
//    private static WebDriver driver;
//
//    public HomePage3(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//a[text()='Buy Medicines']")
//    private WebElement buyMedicinesLink;
//
//    @FindBy(xpath = "//div[@data-placeholder='Search Medicines']")
//    private WebElement searchBar;
//
//    @FindBy(xpath = "//*[@id='searchProduct']")
//    private WebElement searchInput;
//
//    @FindBy(xpath = "//button[@id='searchButton']") // ✅ Adjust locator if needed
//    private WebElement searchButton;
//
//    public void clickBuyMedicines1() {
//        wait.until(ExpectedConditions.elementToBeClickable(buyMedicinesLink));
//        Assert.assertTrue(buyMedicinesLink.isDisplayed(), "Buy Medicines link is not visible!");
//        buyMedicinesLink.click();
//        System.out.println("Navigated to Buy Medicines");
//    }
//
//    public void clickSearchBar1() {
//        wait.until(ExpectedConditions.elementToBeClickable(searchBar));
//        Assert.assertTrue(searchBar.isDisplayed(), "Search bar is not visible!");
//        searchBar.click();
//        System.out.println("Search bar clicked");
//    }
//
//    public void enterMedicine(String medicine) {
//        wait.until(ExpectedConditions.visibilityOf(searchInput));
//        searchInput.clear();
//        searchInput.sendKeys(medicine);
//
//        // Trigger search
//        //wait.until(ExpectedConditions.elementToBeClickable(searchButton));
//       // searchButton.click();
//
//        //  Verify input is present
//        String enteredValue = searchInput.getAttribute("value");
//        Assert.assertEquals(enteredValue, medicine, "Medicine name not entered correctly!");
//        System.out.println("Medicine entered and search triggered: " + medicine);
//    }
////    public boolean verifyProductDetailPage() {
////    try {
////        wait.until(ExpectedConditions.visibilityOf(productTitle));
////        Reports.generateReport(driver, test, Status.PASS, "Product detail page displayed successfully");
////        return true;
////    } catch (TimeoutException te) {
////        Reports.generateReport(driver, test, Status.FAIL, "Product detail page not displayed");
////        return false;
////    }
////}
//}
//
////-------------------------------end of HomePage3-----------------------------------------------
//
//
