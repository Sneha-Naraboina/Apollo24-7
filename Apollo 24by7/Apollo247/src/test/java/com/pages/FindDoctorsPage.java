package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class FindDoctorsPage extends BasePage {

    @FindBy(xpath = "//h2[contains(text(),'Browse by Specialty')]")
    WebElement browseBySpecialtySection;

    @FindBy(xpath = "//div[@class='specialty-list']//a")
    List<WebElement> specialtiesList;

    @FindBy(xpath = "//input[@id='search-bar' or @placeholder='Search doctors, clinics, hospitals']")
    WebElement searchBar;

    public FindDoctorsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
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

    public void clickSpecialty(String specialtyName) {
        for (WebElement specialty : specialtiesList) {
            if (specialty.getText().equalsIgnoreCase(specialtyName)) {
                waitUntilClickable(specialty, 10);
                specialty.click();
                break;
            }
        }
    }

    public boolean isOnSpecialtyPage(String specialtyName) {
        return webdriver.getCurrentUrl().toLowerCase().contains(specialtyName.toLowerCase());
    }
}