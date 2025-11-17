package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
// TestNG runner for Cucumber
@CucumberOptions(
    features = "src\\test\\resources\\Features\\CircleMembership.feature", // Path to feature files
    glue = {"com.stepDefinitionTestNG"}, // Step definitions & hooks
    //tags = "@Join",
    //tags = "@first",
    // tags = "@coupon",
    // tags = "@tandc",
    //tags = "@location",
    plugin = {"pretty","html:target/cucumber-reports/cucumber.html" }, 
    
    monochrome = true
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests 
{
    // No main() method needed
}

