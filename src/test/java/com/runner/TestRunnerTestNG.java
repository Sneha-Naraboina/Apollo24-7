package com.runner;

import org.junit.jupiter.api.Tag;
import org.testng.annotations.AfterSuite;

import com.setup.BaseSteps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = "src/test/resources/Features/BuyMedicine.feature",
    glue = {"com.stepDefinitionTestNG","com.setup","com.pages","com.parameters"},
    //tags="@verify",
    plugin = {"pretty", "html:target/CucumberReport.html"},
    monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
	
}



