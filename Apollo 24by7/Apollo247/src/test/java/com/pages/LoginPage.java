package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Find Doctors')]")
    WebElement findDoctorsButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FindDoctorsPage clickFindDoctors() {
        waitUntilClickable(findDoctorsButton, 10);
        findDoctorsButton.click();
        return new FindDoctorsPage(webdriver);
    }
}