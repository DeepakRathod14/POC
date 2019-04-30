/*
 *
 */
package com.rrm.utility.selenium;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.rrm.selenium.pageobject.Dashboard;
import com.rrm.selenium.pageobject.LoginPage;

public class BasePageObject<T> extends ContinuumWebElement
{
	/** The logger. */
	public Logger logger = Logger.getLogger(getClass());

	/** The test url. */
	public String testUrl;

	/** The Seconds. */
	public int Seconds = 15;

	public static BasePageObject resultpage;

	public synchronized static BasePageObject getInstance()
	{
		if(resultpage==null)
		{
			resultpage = new BasePageObject();
		}
		return resultpage;
	}

	/**
	 * Detect page method will help us to identify which HTML page is currently on screen
	 * and based on that java will create object of that page and return it for further use.
	 * @author P00251
	 * @return the base page object BasePageObject<T>
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("unchecked")
	public BasePageObject<T> detectPage() throws IOException
	{
		logger.info(selenium.getCurrentUrl());
		String url = selenium.getCurrentUrl();
		testUrl = BaseTestScript.APPLICATIONURL;
		if (url.startsWith(testUrl+"/openam/XUI/#login/"))
		{
			return PageFactory.initElements(selenium, LoginPage.class);
		}
		else if (url.startsWith(testUrl+"/QADashB"))
		{
			return PageFactory.initElements(selenium, Dashboard.class);
		}
		else
		{
			logger.info("URL : " + url);
			logger.warn("No Page Detected");
			ContinuumAssert.assertTrue(false, "Unexpected Page is display on UI");
			return null;
		}

	}

	/**
	 * If we want to move back from current screen then this method will help us to move back
	 * @author P00251
	 * @return BasePageObject<T>
	 * @throws IOException
	 */
	public BasePageObject<T> gotoBackOnBrowser() throws IOException
	{
		selenium.navigate().back();
		timeInterval();
		return detectPage();
	}

	/**
	 * If we want to move forward from current screen then this method will help us to move forward
	 * @author P00251
	 * @return BasePageObject<T>
	 * @throws IOException
	 */
	public BasePageObject<T> gotoForwardOnBrowser() throws IOException
	{
		selenium.navigate().forward();
		timeInterval();
		return detectPage();
	}
}
