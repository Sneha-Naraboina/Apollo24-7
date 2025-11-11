package com.pages;


	import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class FindDoctorsPage extends BasePage {

	    WebDriver driver;
	    WebDriverWait wait;
	    ConsultPage consultpage;

	    public FindDoctorsPage(WebDriver driver) {
	        super(driver);
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search Doctors, Specialities, Conditions etc.']")
	    WebElement searchBar;


	    @FindBy(how = How.XPATH, using = "/html/body/main/div/div[1]/div[5]/div/div/div[2]/a/p")
	    WebElement derma;
	    
	    @FindBy(how = How.XPATH,using="/html/body/main/header/div/div[1]/div[3]/div/div/div[1]/div/div[3]/h2")
	    WebElement errormsg;
	    
	    @FindBy(how = How.XPATH, using = "/html/body/main/div/div[1]/div[3]/div/div/div[2]/a/p")
	    WebElement noLogderma;

	    public void clickSearchBar() {
	        wait.until(ExpectedConditions.visibilityOf(searchBar));
	        searchBar.click();
	    }

	    public void enterSearchQuery(String doctorName) {
	        wait.until(ExpectedConditions.visibilityOf(searchBar));
	        searchBar.click();
	        searchBar.clear();
	        searchBar.sendKeys(doctorName);
	    }
	    

	public boolean isDoctorSearchVisible() {
	    try {
	       wait.until(ExpectedConditions.visibilityOf(searchBar));
	        return searchBar.isDisplayed();
	      } catch (TimeoutException e) {
	      return false;
	      }
	}


	public boolean isNoResultsMessageDisplayed() {
	     try {
	        wait.until(ExpectedConditions.visibilityOf(errormsg));
	        return errormsg.isDisplayed();
	     } catch (TimeoutException e) {
	       return false;
	       }
	}
	    
	    public void scroll() {
	    	JavascriptExecutor js;
	    	js=(JavascriptExecutor) webdriver;
	        js.executeScript("window.scrollBy(0,250);");
	    }

	    public ConsultPage clickDerma() throws InterruptedException {
	    	Thread.sleep(5000);
	        derma.click();
	        consultpage = new ConsultPage(driver);
	        return consultpage;
	    }
	    
	    public ConsultPage noLogclickDerma() throws InterruptedException {
	    	Thread.sleep(5000);
	        noLogderma.click();
	        consultpage = new ConsultPage(driver);
	        return consultpage;
	    }
	}


