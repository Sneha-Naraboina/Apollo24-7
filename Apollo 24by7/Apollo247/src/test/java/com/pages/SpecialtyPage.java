package com.pages;



	import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class SpecialtyPage {
	    WebDriver driver;

	    @FindBy(xpath = "//h2[text()='Browse by Specialties']")
	    private WebElement browseBySpecialtyHeader;

	    @FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div/div[2]")
	    private WebElement dermatologyOption;

	    @FindBy(css = "[data-testid='doctor-card']")
	    private List<WebElement> doctorCards;
	    
	    

	    public SpecialtyPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public boolean isBrowseBySpecialtyDisplayed() {
	        return browseBySpecialtyHeader.isDisplayed();
	    }

	    public void clickDermatology() {
	        dermatologyOption.click();
	    }

	    public boolean areDoctorsDisplayed() {
	        return doctorCards.size() > 0;
	    }
	}


