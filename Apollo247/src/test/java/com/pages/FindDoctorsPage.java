package com.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindDoctorsPage extends BasePage {

	public static WebDriver driver;

	//1st Scenario
	@FindBy(xpath = "//a[contains(text(),'Find Doctors')]")
	WebElement findDoctorsButton;
	//2nd Scenario
	@FindBy(xpath = "//h2[contains(text(),'Browse by Specialty')]")
	WebElement browseBySpecialtySection;
	//2nd Scenario
	@FindBy(xpath = "//div[@class='specialty-list']//a")
	List<WebElement> specialtiesList;
	//1st Scenario
	@FindBy(xpath = "//input[@id='search-bar' or @placeholder='Search doctors, clinics, hospitals']")
	WebElement searchBar;
	//2nd Scenario
	@FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div/div[2]/a")
	WebElement dermatologyOption;
	//3rd scenario
	@FindBy(xpath="//span[text()='0-5']")
	WebElement checkbox1;
	//3rd 
	@FindBy(xpath="//span[text()='Hospital Visit']")
	WebElement checkbox2;
	//3rd
	@FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[1]/div[2]/div[5]/a[1]/div[3]/div/button")
	WebElement onlineConsult;
	//3rd
	@FindBy(xpath="//span[text()='Continue']")
	WebElement clickcontinue;
	//3rd
	@FindBy(xpath="//div[@data-cypress='SignIn']")
	WebElement verifysignin;
	//4th
	@FindBy(xpath="//*[@id=\"fixedConsultSearchCT\"]") 
	WebElement searchdoctors;
	//5th
	//@FindBy(xpath= )

	public FindDoctorsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickDermatology() {

		waitUntilClickable(dermatologyOption, 10);
		dermatologyOption.click();

	}


	public boolean isBrowseBySpecialtyVisible() {
		waitUntilVisible(browseBySpecialtySection, 20);
		return browseBySpecialtySection.isDisplayed();
	}

	public boolean isSearchBarVisible() {
		waitUntilVisible(searchBar, 20);
		return searchBar.isDisplayed();
	}

	public boolean isSpecialtyPresent(String specialtyName) {
		return specialtiesList.stream()
				.anyMatch(s -> s.getText().equalsIgnoreCase(specialtyName));
	}
  
	//2nd Scenario
	public boolean isOnSpecialtyPage(String specialtyName) {
		return webdriver.getCurrentUrl().toLowerCase().contains(specialtyName.toLowerCase());
	}


	//3rd Scenario=============================================================

	public boolean clickCheckBox() {
		waitUntilClickable(checkbox1, 10);
		checkbox1.click();
		return checkbox1.isEnabled(); // or isSelected() if it's an input
	}

	public void clickSecondCheckbox() {
		// TODO Auto-generated method stub

		
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox2);
		waitUntilVisible(checkbox2, 20);
		checkbox2.click();

	}

	public void onlineConsultButton()
	{

		waitUntilVisible(onlineConsult, 20);
		onlineConsult.click();

	}
	public void clickContinue()
	{
		waitUntilClickable(clickcontinue, 20);
		clickcontinue.click();

	}
	public void verifySignin()
	{
		waitUntilVisible(verifysignin, 20);
		verifysignin.isDisplayed();

	}
	//4th Scenario======================================================
	public void searchInvalidDoctor()
	{
		waitUntilClickable(searchdoctors, 20);
		searchdoctors.click();
	}
	
	
	//5th Scenario======================================================
	

}