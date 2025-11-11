package com.pages;

	
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.parameters.ExcelReader;
	 
	public class LoginPage extends BasePage {
		ExcelReader excelReader;
		FindDoctorsPage findDoctorsPage;
		public LoginPage(WebDriver webdriver) {
			super(webdriver);
			excelReader = new ExcelReader();
			
		}
		
		@FindBy(how=How.XPATH , using = "//div[@id='loginPopup']")
		WebElement login;
		public void loginBtn() {
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(login));
			login.click();
		}
		
		@FindBy(how=How.XPATH , using = "//input[@name='mobileNumber']")
		WebElement phnNum;
		public void phoneNumber(String num) throws IOException {
			excelReader.readExcel();
			String number=excelReader.getCellData("Number", 0, 0);
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOf(phnNum));
			phnNum.sendKeys(number);
		}
		
		@FindBy(how=How.XPATH, using = "//button[@class='SignIn_submitBtn__k9oGb']")
		WebElement continuebtn;
		public void continueBtn() {
			continuebtn.click();
		}
		
		
		@FindBy(how=How.CLASS_NAME, using = "SignIn_submitBtn__k9oGb")
		WebElement verify;
		public void verifyBtn() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(verify));
			verify.click();
			Thread.sleep(3000);
		}
		
		
		@FindBy(how=How.LINK_TEXT , using = "Find Doctors")
		WebElement findDoctors;
		public FindDoctorsPage findDoctorsbtn() {
			WebDriverWait wait = new WebDriverWait(webdriver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(findDoctors));
			findDoctors.click();
			findDoctorsPage = new FindDoctorsPage(webdriver);
			return findDoctorsPage;
		}

}
