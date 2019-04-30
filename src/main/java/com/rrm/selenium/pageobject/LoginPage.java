package com.rrm.selenium.pageobject;

import java.io.IOException;

import org.openqa.selenium.By;
import com.rrm.utility.selenium.BasePageObject;
import com.rrm.utility.selenium.BaseTestScript;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginPage.
 */
public class LoginPage extends BasePageObject{
	
	public LoginPage()
	{
		waitForParticularElement((By.id(id)), Seconds);
	}
	
	/** The id of login box. */
	private final String id="form_1";
	/** The login heading of login box. */
	private final String loginHeading = "Access ITSupport247 Account";
	private final String emailID="idToken1";
	private final String password="idToken2";
	private final String loginbtn="loginButton_0";
	
	/**
	 * Do login with username and password which will be default.
	 */
	public void doLogin()
	{
		doLogin(BaseTestScript.USERNAME, BaseTestScript.PASSWORD);
	}
	
	
	/**
	 * Do login with custom username and password.
	 * @author Deepak.Rathod
	 * @param username the username
	 * @param password the password
	 */
	public void doLogin(String username, String password)
	{
		waitForParticularElement((By.id(id)), Seconds);
		sendKeys(By.id(emailID), username);
		sendKeys(By.id(this.password), password);
	}
	
	/**
	 * Click on login btn.
	 * @throws IOException 
	 */
	public BasePageObject clickOnLoginBtn() throws IOException
	{
		click(By.id(loginbtn));
		timeInterval(8);
		return resultpage.detectPage();
	}
	
	/**
	 * Verify login page which will verify login box along with login box heading.
	 * @author Deepak.Rathod
	 * @return true, if successful
	 */
	public boolean verifyLoginPage()
	{
		waitForParticularElement((By.id(id)), Seconds);
		return isDisplayed(By.id(id)) && isDisplayed(By.xpath("//h1[text()='"+loginHeading+"']"));
	}
}
