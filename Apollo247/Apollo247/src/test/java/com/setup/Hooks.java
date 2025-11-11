package com.setup;
 
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;

import io.cucumber.java.After;
 
public class Hooks {

    public static WebDriver driver;
 
    @Before

    public void setUp() {

        driver = new ChromeDriver(); // Set path if needed

        driver.manage().window().maximize();

    }
 
    @After

    public void tearDown() {

        driver.quit();

    }

}
 