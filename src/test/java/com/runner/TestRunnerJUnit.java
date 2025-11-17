//package com.runner;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
// 
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/Features",
//        glue = {
//                "com.stepDefinitionJunit",
//                "com.setup",
//                "com.parameters",
//                "com.pages"
//        },
//        plugin = {
//                "pretty",
//                "html:target/JUnit-Cucumber-Report.html"
//        }
//)
//public class TestRunnerJUnit {
// 
//}
package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(

		features = "src/test/resources/Features/BuyMedicine.feature",
	    glue = {"com.stepDefinitionTestNG","com.setup","com.pages","com.parameters"},

        		plugin = {"pretty:reports/prettyReport.html","html:reports/HTMLReports.html",

						"json:reports/json-report.json",

						"junit:reports/junit_report.xml","pretty", "html:target/cucumber-reports.html"},

        				tags="@verify or @sample or @first or @fourth or @fifth",
        			    
        				   //tags="@sample",
        				   // tags="@first",
        				    //tags="@fourth",
        				    //tags="@fifth",      

        				  monochrome = true

)

public class TestRunnerJUnit {



}
 