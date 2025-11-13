

package com.pages;

import java.util.List;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.parameters.PropertyReader;
import com.setup.BaseSteps;

public class HomePage {

    WebDriver driver;

    public HomePage() {
        this.driver = BaseSteps.driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"mainContainerCT\"]/div[1]/div[3]/div/div[1]/div/a/div")
    public WebElement healthMonitorsLink;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[4]/div/div[1]/label/span[1]/div")
    public WebElement brandsDropdown;
    
 // Category links under Health Monitors
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/ul/li[1]/a")
    public WebElement apolloProductsLink;

    @FindBy(xpath = "//a[contains(@href,'personal-care')]")
    public WebElement personalCareLink;

    @FindBy(xpath = "//a[contains(@href,'baby-care')]")
    public WebElement babyCareLink;

    @FindBy(xpath = "//a[contains(@href,'otc')]")
    public WebElement otcLink;
    
 // Nutritional Drinks and Supplements section
    @FindBy(xpath = "//a[contains(@href,'nutritional-drinks-and-supplements')]")
    public WebElement nutritionalDrinksSupplementsLink;

    @FindBy(xpath = "//a[contains(@href,'nutritional-drinks')]")
    public WebElement nutritionalDrinksLink;

    @FindBy(xpath = "//a[contains(@href,'sports-nutrition')]")
    public WebElement sportsNutritionLink;





    public void scrollToHealthMonitors() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", healthMonitorsLink);
    }

    public void clickHealthMonitors() {
        try {
            healthMonitorsLink.click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", healthMonitorsLink);
        }
    }

    public void assertHealthMonitorsPageDisplayed() {
        String expectedUrl = PropertyReader.getProperty("expectedUrl").trim();
        String actualUrl = driver.getCurrentUrl().trim();
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch: Expected vs Actual");
        System.out.println("Health Monitors page loaded successfully.");
    }

    public void clickBrands() {
        brandsDropdown.click();
    }
//second scenario
public void clickApolloProducts() {
    try {
        apolloProductsLink.click();
        System.out.println("Clicked on Apollo Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", apolloProductsLink);
    }

}

public void clickPersonalCareProducts() {
    try {
        personalCareLink.click();
        System.out.println("Clicked on Personal Care Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", personalCareLink);
    }
}

public void clickBabyCareProducts() {
    try {
        babyCareLink.click();
        System.out.println("Clicked on Baby Care Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", babyCareLink);
    }
}

public void clickOTCProducts() {
    try {
        otcLink.click();
        System.out.println("Clicked on OTC Products.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", otcLink);
    }
}

//third scenario
public void clickNutritionalDrinksSupplements() {
    try {
        nutritionalDrinksSupplementsLink.click();
        System.out.println("Clicked on Nutritional Drinks and Supplements.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nutritionalDrinksSupplementsLink);
    }
}

public void clickNutritionalDrinks() {
    try {
        nutritionalDrinksLink.click();
        System.out.println("Clicked on Nutritional Drinks.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nutritionalDrinksLink);
    }
}

public void clickSportsNutrition() {
    try {
        sportsNutritionLink.click();
        System.out.println("Clicked on Sports Nutrition.");
    } catch (ElementClickInterceptedException e) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sportsNutritionLink);
    }
}

//public void assertSportsNutritionPageDisplayed() {
//    Assert.assertTrue(sportsNutritionLink.isDisplayed(), "Sports Nutrition link is not displayed or clickable.");
//    System.out.println("Verified Sports Nutrition page is displayed.");
//}
public void assertSportsNutritionClickedAndNavigated() {
    String actualUrl = driver.getCurrentUrl().trim();
    String expectedUrl = PropertyReader.getProperty("sportsNutrition.expectedUrl");

    if (expectedUrl == null) {
        throw new RuntimeException("Missing key: sportsNutrition.expectedUrl in Profile.properties");
    }

    expectedUrl = expectedUrl.trim();
    Assert.assertEquals(actualUrl, expectedUrl, "Click failed: URL mismatch after clicking Sports Nutrition.");
    System.out.println("Navigation to Sports Nutrition page verified.");
}

}














	














