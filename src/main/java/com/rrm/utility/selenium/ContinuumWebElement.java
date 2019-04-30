/*
 *
 */
package com.rrm.utility.selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ContinuumWebElement{

	/** The Seconds. */
	public static int Seconds = 30;
	/** The logger. */
	private static Logger logger;
	/** The selenium. */
	protected static WebDriver selenium;
	/** The action time. */
	protected String actionTime;
	/** The build. */
	private Actions build;
	/** The jse. */
	private JavascriptExecutor scriptExecutor;

	/** The long polling time for fluent wait. */
	private int longPollingTime=20;

	/** The polling frequency time for fluent wait. */
	private int pollingFrequencyTime=500;

	/**
	 * Instantiates a new CME web element.
	 * @author P00251
	 * @param driver the driver
	 */
	{
		selenium = BaseTestScript.selenium;
		PropertyConfigurator.configure("configuration/log4j.properties");
		logger = Logger.getLogger(this.getClass().getName());
		build = new Actions(selenium);
		scriptExecutor = (JavascriptExecutor) selenium;
	}

	/**
	 * Override method of selenium which will click on elemenet. This is more
	 * stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @see org.openqa.selenium.WebElement#click()
	 * @category Click
	 */
	public void click(By by) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			((JavascriptExecutor) selenium).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
			((JavascriptExecutor) selenium).executeScript("arguments[0].click();", element);
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to click Element on windiw : "+by+" On Page : " + e.getMessage());
		}

	}

	/**
	 * Override method of Selenium which will clear TextBox on Element. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @see org.openqa.selenium.WebElement#clear()
	 * @category Keys
	 */
	public void clear(By by) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			element.clear();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to Clear Element on windiw : "+by+" On Page : " + e.getMessage());
		}

	}

	/**
	 * Override method of Selenium which will sendKeys in TextBox on Element.
	 * This is more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @param keysToSend the keys to send
	 * @see org.openqa.selenium.WebElement#sendKeys(CharSequence... keysToSend)
	 * @category Keys
	 */
	public void sendKeys(By by, String keysToSend) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			element.sendKeys(keysToSend);
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to SendKeys Element on windiw : "+by+" On Page : " + e.getMessage());
		}

	}

	/**
	 * Override method of Selenium which will send sequence of Keys slowly in
	 * TextBox on Element. This is more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @param keysToSend the keys to send
	 * @param cleanElement the clean element
	 * @see com.utility.selenium.CMEWebElement.sendKeyswait(boolean
	 *      cleanElement, CharSequence... keysToSend)
	 * @category Keys
	 */
	public void sendKeysWait(By by, String keysToSend, boolean cleanElement) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			if (cleanElement)
			{
				clear(by);
			}
			for (int i = 0; i < keysToSend.length(); i++)
			{
				timeInterval();
				selenium.findElement(by).sendKeys(String.valueOf(keysToSend.charAt(i)));
			}
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to SendKeysWait Element on windiw : "+by+" On Page : " + e.getMessage());
		}

	}

	/**
	 * Override method of Selenium which will getText from TextBox and return
	 * String. This is more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return the text
	 * @see org.openqa.selenium.WebElement#getText()
	 * @category Keys
	 */
	public String getText(By by) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			return element.getText();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to GetText Element on windiw : "+by+" On Page : " + e.getMessage());
		}
		return null;
	}


	/**
	 * Override method of Selenium which will getAttribute from Element and
	 * return its attribute. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @param attribute the attribute
	 * @return the attribute
	 * @see org.openqa.selenium.WebElement#getAttribute()
	 * @category Keys
	 */
	public String getAttribute(By by, String attribute) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			return element.getAttribute(attribute);
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to Get Attribute Element on windiw : "+by+" On Page : " + e.getMessage());
		}
		return null;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isSelected or not and return boolean. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return true, if is selected
	 * @see org.openqa.selenium.WebElement#isSelected()
	 * @category BooleanElements
	 */
	public boolean isSelected(By by) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			return element.isSelected();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to Select Option from Element on windiw : "+by+" On Page : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isEnabled or not and return boolean. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return true, if is enabled
	 * @see org.openqa.selenium.WebElement#isEnabled()
	 * @category BooleanElements
	 */
	public boolean isEnabled(By by) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			return element.isEnabled();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to verify Element is Enalble or not on windiw : "+by+" On Page : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isDisplayed or not and return boolean. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return true, if is displayed
	 * @see org.openqa.selenium.WebElement#isDisplayed()
	 * @category BooleanElements
	 */
	public boolean isDisplayed(By by) {
		try
		{
			WebElement element= getHighlightElement(by);
			build.moveToElement(element).build().perform();
			return element.isDisplayed();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to verify Element is display or not on windiw : "+by+" On Page : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Override method of Selenium which will verify whether element is
	 * isClickable or not and return boolean. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return true, if is clickable
	 * @see org.openqa.selenium.WebElement#isClickable()
	 * @category BooleanElements
	 */
	public boolean isClickable(By by) {
		try
		{
			WebDriverWait wait = new WebDriverWait(selenium, 5);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to verify Element is Clickable or not on windiw : "+by+" On Page : " + e.getMessage());
		}
		return false;
	}

	/**
	 * Gets the number of elements.
	 * @author P00251
	 * @param by the by
	 * @return the number of elements
	 */
	public int getNumberOfElements(By by)
	{
		return selenium.findElements(by).size();
	}
	/**
	 * Override method of Selenium which will Drag and Drop element from one
	 * place to other place. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author P00251
	 * @param source the source
	 * @param target the target
	 * @see com.utility.selenium.CMEWebElement.dragAndDrop();
	 * @category CustomizedWebElement
	 */
	public void dragAndDrop(By source, By target) {
		WebElement sourceElement= getHighlightElement(source);
		WebElement targetElement= getHighlightElement(target);

		try
		{
			build.moveToElement(sourceElement).build().perform();
			build.dragAndDrop(sourceElement, targetElement).build().perform();
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
			ContinuumAssert.assertTrue(false, "Fail to drag and drop from : " + source + " to : " + target + " on page: " + e.getMessage());
		}
	}

	/**
	 * Override method of Selenium which will handle(Accept) the Alert and
	 * getText and return that text as string. This is more stable override
	 * method of CMEWebElement.
	 *
	 * @author P00251
	 * @return the popup msg and accept
	 * @see com.utility.selenium.CMEWebElement.getPopupMsgAndAccept();
	 * @category CustomizedWebElement
	 */
	public String getPopupMsgAndAccept() {
		String msg="";
		try
		{
			msg=selenium.switchTo().alert().getText();
			selenium.switchTo().alert().accept();
		}
		catch (NoSuchElementException e)
		{
			ContinuumAssert.assertTrue(false, "Fail to Handle Alert on windiw : " + e.getMessage());
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
		return msg;
	}

	/**
	 * Override method of Selenium which will vertical scroll to page. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param verticalScroll the vertical scroll
	 * @see com.utility.selenium.CMEWebElement.scroll();
	 * @category CustomizedWebElement
	 */
	public void scroll(int verticalScroll) {
		scriptExecutor.executeScript("window.scrollBy(0," + verticalScroll + ")");
	}

	/**
	 * Override method of Selenium which will scroll to bottom of the page. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @see com.utility.selenium.CMEWebElement.scrollToBottom();
	 * @category CustomizedWebElement
	 */
	public void scrollToBottom()
	{
		timeInterval();
		((JavascriptExecutor) selenium).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		timeInterval();
	}

	/**
	 * Override method of Selenium which will scroll to Top of the page. This is
	 * more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @see com.utility.selenium.CMEWebElement.scrollToTop();
	 * @category CustomizedWebElement
	 */
	public void scrollToTop()
	{
		Boolean vertscrollStatus = (Boolean) scriptExecutor.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		if (vertscrollStatus)
		{
			selenium.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
			timeInterval();
		}
		else
		{
			scriptExecutor.executeScript("scrollBy(0, -1000)");
		}
	}

	/**
	 * Override method of Selenium which will scroll to particular element if
	 * that element hide under scroll. This is more stable override method of
	 * CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @see com.utility.selenium.CMEWebElement.scrollToElement();
	 * @category CustomizedWebElement
	 */
	public void scrollToElement(By by) {
		try
		{
			WebElement element = getHighlightElement(by);
			scriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
			timeInterval();
		}
		catch (NoSuchElementException e)
		{
			ContinuumAssert.assertTrue(false, "Fail to ScrollToElement on windiw : "+by+" On Page : " + e.getMessage());
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
	}

	/**
	 * Override method of Selenium which will highlight webElement by
	 * javaScriptExecutor, so we can get see on screen which element is going to
	 * performed This is more stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return the highlight element
	 * @see com.utility.selenium.CMEWebElement.getHighlightElement();
	 * @category CustomizedWebElement
	 */
	public WebElement getHighlightElement(final By by) {
		WebElement element=null;
		try
		{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(selenium)
					.withTimeout(longPollingTime, TimeUnit.SECONDS)
					.pollingEvery(pollingFrequencyTime, TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);

			element = wait.until(new Function<WebDriver, WebElement>() {
				@Override
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
			// Element is now available for further use.
			((JavascriptExecutor) selenium)
			.executeScript("arguments[0].style.border='2px solid red'", element);
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
		return element;
	}


	/**
	 * Override method of Selenium which will wait 500 Mili Second. This will
	 * give more stability to our execution. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author P00251
	 * @see com.utility.selenium.CMEWebElement.delay();
	 * @category CustomizedWebElement
	 */
	public void timeInterval() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void timeInterval(int time) {
		try {
			Thread.sleep((time*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Override method of Selenium which will wait for element to display until condition is not satisfied. This will
	 * give more stability to our execution. This is more stable override method
	 * of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @param second the second
	 * @see com.utility.selenium.CMEWebElement.waitForParticularElement();
	 * @category CustomizedWebElement
	 */
	public void waitForParticularElement(By by, int second) {
		int count=1;
		while(count<=longPollingTime)
		{
			try {
				selenium.findElement(by).isDisplayed();
				break;
			} catch (Exception e) {
				timeInterval();
				count++;
			}
		}
	}

	/**
	 * Override method of Selenium which will getCssValue of given element and
	 * return it's CSS attribute whatever we wants as string. This is more
	 * stable override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @param propertyName the property name
	 * @return the css value
	 * @see org.openqa.selenium.WebElement#getRect()
	 * @category FindWebElement
	 */
	public String getCssValue(By by, String propertyName) {
		WebElement element = getHighlightElement(by);
		try
		{
			return element.getCssValue(propertyName).trim();
		}
		catch (NoSuchElementException e)
		{
			ContinuumAssert.assertTrue(false, "Fail to get CSS value from : " + by + " on page : " + e.getMessage());
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
		return null;
	}

	/**
	 * Override method of Selenium which will getScreenshotAs different format
	 * it can be use for take picture of current screen. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param screenName the screen name
	 * @return the screenshot as
	 * @throws WebDriverException the web driver exception
	 * @see org.openqa.selenium.WebElement#getScreenshotAs()
	 * @category ScreenShot
	 */
	public static void getScreenshotAs(String screenName) throws WebDriverException {
		File scrFile = ((TakesScreenshot)selenium).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(BaseTestScript.REPORTLOCATION+"/LastExecution/"+screenName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Override method of Selenium which will use for select value from DropDown. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @param option the option
	 * @see org.openqa.selenium.WebElement#selectOptionFromDropDown()
	 * @category DropDownElement
	 */
	public void selectOptionFromDropDown(By by, String option) {
		WebElement element = getHighlightElement(by);
		build.moveToElement(element).build().perform();
		Select select_list = null;
		try
		{
			timeInterval();
			select_list = new Select(element);
			select_list.selectByVisibleText(option);
		}
		catch (NoSuchElementException e)
		{
			ContinuumAssert.assertTrue(false, "Fail to find drop down box to select option : " + by + " on page : " + e.getMessage());
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
	}

	/**
	 * Override method of Selenium which will use for fetch value from DropDown and return as string. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return the value from drop down
	 * @see org.openqa.selenium.WebElement#selectOptionFromDropDown()
	 * @category DropDownElement
	 */
	public String getValueFromDropDown(By by) {
		WebElement element = getHighlightElement(by);
		build.moveToElement(element).build().perform();
		Select select_list = null;
		try
		{
			timeInterval();
			select_list = new Select(element);
			return select_list.getFirstSelectedOption().getText().trim();
		}
		catch (NoSuchElementException e)
		{
			ContinuumAssert.assertTrue(false, "Fail to find drop down box to select option : " + by + " on page : " + e.getMessage());
			logger.info("Fail to find drop down box to select option : " + by + " on page : " + e.getMessage());
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
		return null;
	}

	/**
	 * Override method of Selenium which will use for fetch all options from DropDown and return as List<string>. This is more stable
	 * override method of CMEWebElement.
	 *
	 * @author P00251
	 * @param by the by
	 * @return the values from drop down
	 * @see org.openqa.selenium.WebElement#selectOptionFromDropDown()
	 * @category DropDownElement
	 */
	public List<String> getValuesFromDropDown(By by) {
		WebElement element = getHighlightElement(by);
		build.moveToElement(element).build().perform();
		List<String> options = new ArrayList<>();
		List<WebElement> options_Elmnt = null;
		try
		{
			timeInterval();
			Select select_otions = new Select(element);
			options_Elmnt = select_otions.getOptions();
			for (WebElement ele : options_Elmnt)
			{
				options.add(ele.getText().trim());
			}
		}
		catch (NoSuchElementException e)
		{
			ContinuumAssert.assertTrue(false, "Fail to fetch value from drop down box on page : " + e.getMessage());
		}
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
		return options;
	}
}
