package com.rmm.cucumber.stepdefinitions;

import java.util.List;

import org.hamcrest.core.IsInstanceOf;

import com.rrm.selenium.pageobject.Dashboard;
import com.rrm.selenium.pageobject.LoginPage;
import com.rrm.utility.selenium.BasePageObject;
import com.rrm.utility.selenium.BaseTestScript;
import com.rrm.utility.selenium.ContinuumAssert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * The Class ITSStepDef.
 */
public class ITSStepDef extends BaseTestScript {
	
	
	
	@Given("^Open Browser and lunch application$")
	public void launchBrowser() throws Throwable {
		System.out.println("Browser opened and app is loaded successfully");
	}

	@Given("^Verify login page should be display$")
	public void verifyLoginPage() throws Throwable {
		LoginPage login = (LoginPage)BasePageObject.resultpage.detectPage();
		ContinuumAssert.assertTrue(login.verifyLoginPage(), "After loding base URL, Application is not displaying login page.");
	}

	@When("^Enter valid username and password into login page$")
	public void doLogin() throws Throwable {
		LoginPage login = (LoginPage)BasePageObject.resultpage.detectPage();
		login.doLogin();
		BasePageObject.resultpage=login.clickOnLoginBtn();
	}

	@Then("^Verify required menu options on home page$")
	public void verifyDashboardMenuItems(DataTable menuItems) throws Throwable {
		List<String> allMenuItems = menuItems.asList(String.class);
		Dashboard dashboard = (Dashboard) BasePageObject.resultpage;
		ContinuumAssert.assertTrue(dashboard.verifyMenuItems(allMenuItems), "Menu Item is not visible on page");
	}

	@Given("^Verify default page should be dashboard$")
	public void verifyDashboardPage() throws Throwable {
		Dashboard dashboard = (Dashboard) BasePageObject.resultpage.detectPage();
		ContinuumAssert.assertTrue((dashboard instanceof Dashboard), " Landing page is not dashboard page,");
	}

	@Then("^Verify different widged on dashboard page should display$")
	public void verifyDashboardWidged(DataTable widgedList) throws Throwable {
		
	}
	
}
