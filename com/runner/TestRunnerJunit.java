package com.runner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src\\test\\resources\\Features\\CircleMembership.feature"},		
		glue = "com.stepDefinitionTestNG",
	       plugin = {"pretty","html:target/cucumber-reports/cucumber.html",
	    		         "json:reports/json-report.json",
	    		         "junit:reports/junit_report.xml"}
	       
		)



public class TestRunnerJunit 
{

}
