package com.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
 
	@CucumberOptions (
	features= "src/test/resources/com/features/ApolloBooking.feature",
	glue = "com.stepDefinitionTestNG",
		tags="@TC_06",
		plugin = {"pretty:Reports/pretty-reports.html", "html:Reports/cucumber-reports.html",
				"html:target/cucumber-report.html",
				"html:reports/HTMLReports.html",
				"json:reports/json-report.json",
				"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"}
		)
	 
		
	 
			//plugin = {"pretty", "html:Reports/cucumber-reports.html"}
	//)
 
public class TestRunnerTestNG extends AbstractTestNGCucumberTests
{
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = "src/test/resources/features/ApolloBooking",
//    glue = "com.stepDefinitionTestNG",
//    plugin = {"pretty", "html:target/cucumber-reports"},
//    monochrome = true
//)
//public class TestRunnerTestNG extends AbstractTestNGCucumberTests {}


//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
//
//@CucumberOptions(
//    features = "src/test/resources/com/features/ApolloBooking.feature", // Path to .feature files
//    glue = "com.stepDefinitionTestNG", // Step Definitions package
//    		plugin = {
//    			    "pretty",
//    			    "html:target/cucumber-html-report",
//    			    "json:target/cucumber.json",
//    			    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//
//  		plugin=  {"pretty:target/pretty.txt",
//					 "junit:target/junitGit.txt",
//					 "json:target/jsonGit.json",
//					 "html:target/index.html"
//				,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
//    monochrome = true,
//    dryRun = false
//)
//public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
//
//}
