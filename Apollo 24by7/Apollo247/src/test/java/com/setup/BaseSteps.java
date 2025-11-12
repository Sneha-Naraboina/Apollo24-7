package com.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
    private static WebDriver driver;

@Before
public void setUp() {
    if (driver == null) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}


    public void setup() throws IOException {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            Properties prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Properties/Data.properties"));
            String url = prop.getProperty("sourceUrl");
            driver.get(url);

            System.out.println("Apollo homepage launched successfully");

            // ✅ Click Find Doctors
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickFindDoctors();
            System.out.println("Clicked on Find Doctors");
        }
    }

    public WebDriver getDriver() {
        return driver;
    }


@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
        driver = null;
    }

}}