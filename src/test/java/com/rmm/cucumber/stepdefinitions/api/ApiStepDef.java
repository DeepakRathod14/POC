package com.rmm.cucumber.stepdefinitions.api;

import java.util.Collection;
import java.util.List;

import com.rrm.api.beans.Users;
import com.rrm.api.pageobjects.OpenAPIPageObject;
import com.rrm.utility.selenium.BaseTestScript;
import com.rrm.utility.selenium.ContinuumAssert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;

public class ApiStepDef extends BaseTestScript{
	
	private String apiUrl;
	private Collection<Object> userlist;
	
	@Given("^Configure GET \"([^\"]*)\" api call$")
	public void configureAPI(String api) throws Throwable {
		apiUrl=api;
	}

	@Then("^Execute api with expected (\\d+) response code$")
	public void executeAPI(int code) throws Throwable {
		Users userrecord = new Users();
		userlist = OpenAPIPageObject.getApiCall(apiUrl, code, "", null, userrecord);
	}
	
	@Then("^Verify response records should contains details$")
	public void verifyRecords(DataTable verifyRecods) throws Throwable {
		List<DataTableRow> table = verifyRecods.getGherkinRows();
		OpenAPIPageObject apipage = OpenAPIPageObject.getInstance();
		boolean isExpected = apipage.verifyRecords(userlist,table);
		ContinuumAssert.assertTrue(isExpected);
	}
	
}
