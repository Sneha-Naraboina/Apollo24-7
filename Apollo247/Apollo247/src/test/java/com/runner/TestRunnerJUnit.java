package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\Features\\LabTestsNavigation.feature",
    glue = "com.stepDefinitionTestNG",
    //tags="@ViewAllPage",
    tags="@CartFunctionality",
    
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    }
)
public class TestRunnerJUnit {
}