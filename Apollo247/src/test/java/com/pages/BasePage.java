package com.pages;


	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	 
	public class BasePage {
	protected static WebDriver webdriver;
	WebDriverWait wait;
	 
	public BasePage(WebDriver webdriver) {
		BasePage.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
	}
	public void loadPage(String url) {
		webdriver.get(url);
		webdriver.manage().window().maximize();
	}
	 
	public void waitUntillWebElementToBeClickable(WebElement cases) {
	    wait = new WebDriverWait(webdriver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(cases));
	}
	 
	public void waitUntillWebElementToBeClickable1(WebElement save) {
	    wait = new WebDriverWait(webdriver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.visibilityOf(save));    
	}
	 
	public void waitUntillWebElementToBeVisible(WebElement casetitle) {
	    wait = new WebDriverWait(webdriver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(casetitle));    
	}
	 
	public void waitUntillWebElementToBeVisibleForCaseSelection(WebElement selectcaseone) {
	    wait = new WebDriverWait(webdriver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(selectcaseone));    
	}
	 
	public void waitCaseSelection() {
	    wait = new WebDriverWait(webdriver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.urlContains("cases"));
	}
	 
	public void waitAndClick(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}
	 
	public void waitForVisibilityOfElement(WebElement element) {
	new WebDriverWait(webdriver, Duration.ofSeconds(10))
	.until(ExpectedConditions.visibilityOf(element));
	}
	 
	public void waitForInVisibilityOfElement(WebElement element) {
	new WebDriverWait(webdriver, Duration.ofSeconds(10))
	.until(ExpectedConditions.invisibilityOf(element));
	}
	 
	public void waitForVisibilityOfElementBy(By obj) {
	new WebDriverWait(webdriver, Duration.ofSeconds(10))
	.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(obj));
	}
	 
	public void waitForInVisibilityOfElementBy(By obj) {
	new WebDriverWait(webdriver, Duration.ofSeconds(10))
	.until(ExpectedConditions.invisibilityOfElementLocated(obj));
	}
	public void waitMethod(int seconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(seconds));
	}
	public void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	}


