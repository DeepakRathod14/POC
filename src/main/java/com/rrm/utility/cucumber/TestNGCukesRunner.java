/*
 *
 */
package com.rrm.utility.cucumber;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.rrm.cucumber.listener.ExtentProperties;
import com.rrm.cucumber.listener.Reporter;
import com.rrm.utility.constant.ContinuumSelenium;
import com.rrm.utility.file.Downloaded_Verifier;
import com.rrm.utility.file.EmailHelper;
import com.rrm.utility.selenium.BaseTestScript;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * The Class TestNGCukesRunner.
 * This class will load cucumber setting as per given and execute before and after annotation
 * and also load and destroy cucumber objects.
 */
@CucumberOptions(
		features = {"src/test/java/com/rmm/cucumber/features/"},
		tags = {"@Api"},
		glue = {"com.rmm.cucumber.stepdefinitions"},
		plugin = {"com.rrm.cucumber.listener.ExtentCucumberFormatter:","json:output/cucumber.json"}
		)
public class TestNGCukesRunner extends AbstractTestNGCucumberTests {

	/**
	 * Initialized ExetentReport object and set it's property such as
	 * Project Name, Report Generation Location, etc.
	 * @author P00251
	 * @throws IOException
	 */
	@BeforeSuite
	public  static void setup() throws IOException{
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setProjectName("ITS Automation)");
		if(StringUtils.isEmpty(BaseTestScript.REPORTLOCATION)) {
			BaseTestScript.REPORTLOCATION=System.getProperty("user.dir")+"/output";
		}
		extentProperties.setReportPath(BaseTestScript.REPORTLOCATION+"/LastExecution/report.html");
		Downloaded_Verifier download = new Downloaded_Verifier();
		download.deleteAllFilesFromDirectory(BaseTestScript.REPORTLOCATION+"/LastExecution");
	}

	@BeforeTest
	public void beforeTest() throws IOException, InterruptedException
	{
		BaseTestScript script = new BaseTestScript();
		script.beforeTest();
		script.testCaseStartTime();
		script.beforeMethod();
	}

	@AfterTest
	public void afterTest() throws IOException
	{
		BaseTestScript script = new BaseTestScript();
		script.testCaseEndTime();
		script.afterTest();
	}
	/**
	 * It tear down ExetentReport object and load report generation settings from XML.
	 * and set systemInfo such as user, OS, RunnerOutput name.
	 * @author P00251
	 * @throws IOException
	 */
	@AfterSuite
	public static void tearDown() throws IOException
	{
		Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", System.getProperty("os.name").toUpperCase());
		Reporter.setTestRunnerOutput("ITS Automation Reports - CONTINUUM");

		String timestamp = BaseTestScript.dateAndSystemTime().replace(":", "_");
		EmailHelper email = new EmailHelper();
		Downloaded_Verifier download = new Downloaded_Verifier();
		try {
			download.ZipCreation();
			download.moveFileFromSourceToDestination(ContinuumSelenium.REPORT_ZIP_FILE_NAME, BaseTestScript.REPORTLOCATION+"/LastExecution", BaseTestScript.REPORTLOCATION+"/ReportHistory/"+timestamp );
			if(BaseTestScript.MAILSEND.equalsIgnoreCase("yes")) {
				email.sendMailViaGmail(BaseTestScript.REPORTLOCATION+"/ReportHistory/"+timestamp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("verify report generation");
	}
}
