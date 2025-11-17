//package com.runner;
//
//public class TestRunnerJunit {
//	
//	
//
//}

package com.runner;
 
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)

@CucumberOptions(

    features = "src\\test\\resources\\Features\\Profile.feature",

    glue = {"com.stepDefinitionTestNG"},

    plugin = {

        "pretty",

        "html:target/cucumber-report.html",

        "json:target/cucumber.json",
        "junit:reports/junit_report.xml" 

    },

    monochrome = true,

    dryRun = false

)

public class TestRunnerJunit {
 
}
 