package com.setup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class BaseSteps {
	
	WebDriver webdriver;
	LoginPage loginPage;
	
	public void setup() throws FileNotFoundException, IOException {
		WebDriverManager.chromedriver().setup();
		webdriver=new ChromeDriver();
 
		System.out.println("Setup is done");
		Properties prop=new Properties();
		prop.load(new FileInputStream("src/test/resources/Properties/Data.properties"));
		String urlval=prop.getProperty("sourceUrl");
		loginPage=new LoginPage(webdriver);
		loginPage.loadPage(urlval);
 
		
		}
	
	public WebDriver getDriver() {
		return webdriver;
	}	
}
