package com.runner;
 
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(
    features = ".\\src\\test\\resources\\com\\Features\\LabTestsNavigation.feature",
    glue = "com.stepDefinitionTestNG",
	//tags="@ViewAllPage",
    //tags="@CartFunctionality",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/cucumber.html",
        "json:target/cucumber-reports/cucumber.json"
    },
    //tags="@SortBy"
    //tags="@TopDeals"
    tags="@Search"
    //tags ="@ViewCart"
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}