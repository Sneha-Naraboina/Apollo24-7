package com.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver webdriver;

    public BasePage(WebDriver driver) {
        this.webdriver = driver;
    }

    public void waitUntilVisible(WebElement element, int timeout) {
        new WebDriverWait(webdriver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element, int timeout) {
        new WebDriverWait(webdriver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getPageTitle() {
        return webdriver.getTitle();
    }

    public String getCurrentUrl() {
        return webdriver.getCurrentUrl();
    }
}