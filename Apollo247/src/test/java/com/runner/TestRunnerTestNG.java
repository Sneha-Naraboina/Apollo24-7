package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
// TestNG runner for Cucumber
@CucumberOptions(
    features = "src\\test\\resources\\Features\\Profile.feature", // Path to feature files
    glue = {"com.stepDefinitionTestNG", "com.setup"},
    		
// Step definitions & hooks
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    monochrome = true
    

)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
    // No main() method needed
}
 