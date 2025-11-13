package com.runner;

import org.junit.jupiter.api.Tag;
import org.testng.annotations.AfterSuite;

import com.setup.BaseSteps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "src/test/resources/Features/BuyMedicine.feature",
    glue = {"com.stepDefinitionTestNG","com.setup","com.pages","com.parameters"},
   // tags="@verify",
    
  // tags="@sample",
    tags="@first",
    plugin = {"pretty", "html:target/CucumberReport.html","pretty","html:reports/HTMLReports.html",
			"json:reports/json-report.json",
			"junit:reports/junit_report.xml"},
    monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}



