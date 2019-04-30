/*
 *
 */
package com.rrm.utility.cucumber;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.rrm.cucumber.listener.ExtentProperties;
import com.rrm.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This class will load cucumber setting as per given and execute before and after annotation
 * and also load and destroy cucumber objects.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/cucumber/features/"},
		glue = {"com.cucumber.stepdefinitions"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
		)
public class RunCukesTest {

	/**
	 * Initialized ExetentReport object and set it's property such as
	 * Project Name, Report Generation Location, etc.
	 * @author P00251
	 */
	@BeforeClass
	public static void setup() {
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setProjectName("Automation ITS");
		extentProperties.setReportPath("output/report.html");
	}

	/**
	 * It tear down ExetentReport object and load report generation settings from XML.
	 * and set systemInfo such as user, OS, RunnerOutput name.
	 * @author P00251
	 */
	@AfterClass
	public static void teardown() {
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", System.getProperty("os.name").toUpperCase());
		Reporter.setTestRunnerOutput("ITS Automation Reports - CONTINUUM");
	}

}
