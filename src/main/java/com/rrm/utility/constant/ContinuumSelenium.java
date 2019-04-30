/*
 *
 */
package com.rrm.utility.constant;

/**
 * The Class CmeSelenium.
 */
public class ContinuumSelenium {

	/**
	 * Instantiates a new CME Selenium.
	 */
	private ContinuumSelenium()
	{
		/**
		 * Restricting user to create object of this class from outside of this class.
		 */
	}

	// --------------------------- DOWNLOAD PATH  --------------------------------
	/** The Constant SYSTEM_USER_HOME. which indicate user directory HOME path*/
	public static final String SYSTEM_USER_HOME = System.getProperty("user.home");

	/** The filepath which contains path of resource document for read, write data. */
	public static String filepath = "/src/test/resources/documents/";

	/** The Constant FILE_PATH_DOWNLOADED hold path of where document will download. */
	public static final String FILE_PATH_DOWNLOADED = SYSTEM_USER_HOME + "\\Downloads\\";
	
	public static final String REPORT_ZIP_FILE_NAME = "ITS-Automation-Report.zip";
}
