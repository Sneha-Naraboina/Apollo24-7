package com.setup;


	
	 
	import org.openqa.selenium.WebDriver;
	 
	import com.aventstack.extentreports.ExtentTest;

	import com.aventstack.extentreports.Status;
	 
	public class Reports {
	 
	    public static void generateReport(WebDriver driver, ExtentTest test, Status status, String message) {

	        test.log(status, message);

	        if (status == Status.FAIL) {

	            // Optionally capture screenshot

	            // String screenshotPath = ScreenshotUtil.capture(driver);

	            // test.addScreenCaptureFromPath(screenshotPath);

	        }

	    }

	}
	 
