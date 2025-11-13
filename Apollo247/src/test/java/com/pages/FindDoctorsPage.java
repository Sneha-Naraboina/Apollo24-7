package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindDoctorsPage extends BasePage {
	
	public static WebDriver webdriver;
	
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
//
//    public void clickSpecialty(String specialtyName) {
//        for (WebElement specialty : specialtiesList) {
//            if (specialty.getText().equalsIgnoreCase(specialtyName)) {
//                waitUntilClickable(specialty, 10);
//                specialty.click();
//                break;
//            }
//        }
//    }
    //2nd Scenario
    public boolean isOnSpecialtyPage(String specialtyName) {
        return webdriver.getCurrentUrl().toLowerCase().contains(specialtyName.toLowerCase());
    }
    
    
    //3rd scenario=========================================================================
    
    
    
}