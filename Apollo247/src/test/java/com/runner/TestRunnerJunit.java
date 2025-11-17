package com.runner;

import org.junit.runner.RunWith;
 
import io.cucumber.junit.Cucumber;
 
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
 
@CucumberOptions(
 
   features = "src/test/resources/com/features/ApolloBooking.feature",
 
   glue = {"com.stepDefinitionTestNG"},
		  tags="@TC_06",
   plugin = {"pretty:Reports/pretty-reports.html", "html:Reports/cucumber-reports.html",
			"json:reports/json-report.json",
			"junit:reports/junit_report.xml"}
)
 
 
public class TestRunnerJunit {
			
 
}
