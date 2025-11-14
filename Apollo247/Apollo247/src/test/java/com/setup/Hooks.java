//package com.setup;
// 
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
// 
//public class Hooks extends BaseSteps
//{
//
//    public static WebDriver driver;
// 
//    @Before
//
//    public void setUp() {
//
//        driver = new ChromeDriver(); // Set path if needed
//
//        driver.manage().window().maximize();
//
//    }
// 
//    @After
//
//    public void tearDown() {
//
//        driver.quit();
//
//    }
//}
	
	package com.setup;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import io.cucumber.java.After;
	import io.cucumber.java.AfterAll;
	import io.cucumber.java.Before;
	import io.cucumber.java.BeforeAll;
	import io.cucumber.java.Scenario;
	public class Hooks extends BaseSteps 
	{
		public static ExtentSparkReporter spark; // classes of extend reports, what should be color of reports
	    public static ExtentReports extReports; //what to track on report(tester name, date etc..,)
	    public static ExtentTest test; // it will track the test cases
	    @BeforeAll // run code before feature file starts
	    public static void beforeAll() {
	        spark = new ExtentSparkReporter(".\\target\\ExtentReport.html"); // for extends report
	        extReports = new ExtentReports();
	        extReports.attachReporter(spark);
	    }
	    @AfterAll
	    public static void afterAll() { // after file rends this will run
	        extReports.flush(); // to generate extentreport like commit method
	    }
	    @Before // before every scenario
	    public void beforeScenario(Scenario scenario) {
	        test = extReports.createTest(scenario.getName()); // on the test, track the name of scenario
	       launchBrowser(); // fresh browser will launch
	    }
	 
	    @After // after every scenario
	    public void afterScenario() {
	        sleep(4000);
	        driver.quit();
	    }
	

 }
 