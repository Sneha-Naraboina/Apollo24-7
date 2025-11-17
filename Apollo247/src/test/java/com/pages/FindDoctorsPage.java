package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class FindDoctorsPage extends BasePage {
	
	private static ExtentTest test;

	public static WebDriver driver;

	//1st Scenario
	@FindBy(xpath = "//a[contains(text(),'Find Doctors')]")
	WebElement findDoctorsButton;
	
	public void findDoctorsModule() {

		waitUntilClickable(findDoctorsButton, 10);
		findDoctorsButton.click();

	}
	
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
	@FindBy(xpath="//*[text()='Hospital Visit']")
	WebElement checkbox2;
	//3rd
	@FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[1]/div[2]/div[5]/a[1]/div[3]/div/button")////*[@id="mainContainerCT"]/div[1]/div[2]/div[5]/a[1]/div[3]/div/button
	WebElement onlineConsult;
	//3rd
	@FindBy(xpath="//span[text()='Continue']")
	WebElement clickcontinue;
	//3rd
	@FindBy(xpath="//div[@data-cypress='SignIn']")
	public
	WebElement verifysignin;
	//4th
	@FindBy(xpath="//*[@id=\"fixedHeaderCT\"]/div/div[1]/div[2]/div/div[1]/input") 
	WebElement searchdoctors;
	//4th
	@FindBy(xpath="(//ul/li/a)[1]")
	WebElement searchresults;
	//4th
	@FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[2]/div[1]")
	public
	WebElement doctorprofile;
	
	
	
	
	//5th
	@FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div/div[5]/a")
	WebElement entoption;
	//5th
	@FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[1]/div[2]/div[5]/a[1]/div[3]/div/button")
	WebElement entdoctor;
	//5th
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2]/div[4]/button/span")
	WebElement entselection;
	//5th
	@FindBy(xpath="/html/body/div[2]/div[2]/div/div[2]/div/div/div/h2")
	public
	WebElement entverifysignin;
	
//	//6th
//	@FindBy(xpath="//input[@placeholder='Search location']")
//	WebElement location;
//	@FindBy(xpath="//span[text()='Submit']")
//	WebElement submitButton;
//	@FindBy(className = "icon-down-arrow")
//	WebElement dropdown;
//	@FindBy(xpath="//*[@id=\"mainContainerCT\"]/div[1]/div[4]/div/div/div[1]/div/div[3]/div/ul/li[1]")
//	WebElement selectFromDropDown;
//	
	
	
	public FindDoctorsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickDermatology() {

		waitUntilClickable(dermatologyOption, 10);
		dermatologyOption.click();

	}
	
	//this method for 2nd scenario assertion
	public boolean isDermatologyPageLoaded() {
	    waitUntilVisible(doctorprofile, 20);
	    return doctorprofile.isDisplayed();
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

	public boolean clickSecondCheckbox() {

		
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", checkbox2);
		waitUntilVisible(checkbox2, 20);
		checkbox2.click();
		return checkbox2.isEnabled();

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
	public void searchValidDoctor()
	{
		waitUntilClickable(searchdoctors, 20);
		searchdoctors.click();
		
	}
	
	public boolean searchDoctorResults()
	{
		waitUntilClickable(searchresults, 40);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		searchresults.click();
		return searchresults.isSelected() ;
	}
	public boolean searchDoctorResults2()
	{
		waitUntilClickable(searchresults, 20);
		searchresults.click();
		return searchresults.isSelected();
	}
	
//	public void enterDoctorName(String doctorName) {
//	    waitUntilVisible(searchdoctors, 20);
//	    searchdoctors.clear();
//	    searchdoctors.sendKeys(doctorName);
//	}
	
	public void enterDoctorName(String doctorName) {
	    waitUntilVisible(searchdoctors, 20); // Wait for input field
	    searchdoctors.clear();
	    typeSequentiallyWithKeyDownUp(BaseSteps.driver,searchdoctors,doctorName,100);
	   // searchdoctors.sendKeys(doctorName);
	  //  searchdoctors.sendKeys(Keys.ENTER); // Optional: trigger search
	}
	
	public void ValidateDoctorProfile()
	{
		waitUntilClickable(doctorprofile, 20);
		doctorprofile.isDisplayed();
	}
	
	
	
	//5th Scenario======================================================
	 
	public void EntSpeciality()
	{
		waitUntilClickable(entoption, 20);
		entoption.click();
	}
	
	public void EntDoctorSelection()
	{
		waitUntilClickable(entdoctor, 20);
		entdoctor.click();
	}
	
	public void EntDoctorConsultation()
	{
		waitUntilClickable(entselection, 20);
		entselection.click();
	}

	public void EntverifySignin()
	{
		waitUntilVisible(entverifysignin, 20);
		entverifysignin.isDisplayed();

	}
//	========================================================
	
//	public void clickDropDown() {
//		waitUntilClickable(dropdown, 20);
//		dropdown.click();
//	}
//	public void selectFromDropDown() {
//		waitUntilClickable(selectFromDropDown, 20);
//		selectFromDropDown.click();
//	}
//	public void EnterLocation() {
//		waitUntilClickable(location, 20);
//		location.click();
//	}
//	public void ClickSubmit() {
//		waitUntilClickable(submitButton, 20);
//		submitButton.click();
//	}
	
	
	
	public static void typeSequentiallyWithKeyDownUp(WebDriver driver, WebElement element, String text, int delayMs) {
        Actions actions = new Actions(driver);
        actions.click(element).perform(); // Focus on element

        for (char ch : text.toCharArray()) {
            actions.keyDown(String.valueOf(ch))
                   .keyUp(String.valueOf(ch))
                   .perform();

            try {
                Thread.sleep(delayMs); // Simulate typing delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
	
	
	//6th scenario======= xpaths and methods
	
	    @FindBy(id = "fixedConsultSearchCT") 
	    WebElement searchBar1;
	   // @FindBy(id = "search-button") WebElement searchButton;
	    @FindBy(xpath = "//h2[text()='No result found']") 
	    WebElement noResultMessage;

	    public void enterSpecialty(String specialty) {
	    	waitUntilVisible(searchBar1, 40);
	    	searchBar1.click();
	        //searchBar1.clear();
	        searchBar1.sendKeys(specialty);
	      
	    }

//	    public void clickSearch() {
//	        searchButton.click();
//	    }

	    public boolean isNoResultDisplayed() {
	    	waitUntilVisible(noResultMessage, 60);
	        return noResultMessage.isDisplayed();
	     
	    }
	  
	    // New method: read invalid specialty from properties and enter it
	    public void enterInvalidSpecialtyFromProperties() {
	        Properties prop = PropertyReader.readProperty();
	        String invalidSpecialty = prop.getProperty("invalidSpecialty");
	        enterSpecialty(invalidSpecialty);
	    }
	}

