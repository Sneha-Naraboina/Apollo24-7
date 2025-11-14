package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/com/features/ApolloBooking.feature", // Path to .feature files
    glue = "com.stepDefinitionjunit", // Step Definitions package
    		plugin = {"pretty:target/pretty.txt",
					"json:target/cucumber.json",
					"junit:target/cucumber.xml",
					"usage:target/usage.json",
					"html:target/index.html"
					,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},
    monochrome = true,
    dryRun = false
    
)


public class TestRunnerJunit {

}
