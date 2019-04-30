/*
 *
 */
package com.rrm.selenium.pageobject;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.rrm.utility.selenium.ContinuumWebElement;


/**
 * The Class TestPage.
 */
public class TestPage extends ContinuumWebElement{

	/** The account link. */
	@FindBy(how = How.ID, using = "account")
	public ContinuumWebElement accountLink;


}
