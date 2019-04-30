/*
 * This class is for implementing all API calls
 * related to ReportRequestPage.
 */
package com.rrm.api.pageobjects;

import java.util.Collection;
import java.util.List;

import com.rrm.api.beans.Post;
import com.rrm.api.beans.Users;
import com.rrm.utility.api.BaseApiClass;
import com.rrm.utility.selenium.BaseTestScript;

import gherkin.formatter.model.DataTableRow;


/**
 * The Class ReportRequestApiPage.
 * This class is for implementing all API calls
 * related to ReportRequestPage.
 */
public class OpenAPIPageObject extends BaseApiClass{

	/** The report request api. */
	private static OpenAPIPageObject reportRequestApi = null;
	private static BaseApiClass baseApi = null;
	/**
	 * Instantiates a new report request api page.
	 *
	 * @author P00251
	 * Instantiates a new report request api page.
	 */
	private OpenAPIPageObject()
	{
		// It is for restricting creating object of ReportRequest from outside of class
	}

	/**
	 * Gets the single instance of ReportRequestApiPage.
	 *@author P00251
	 * @return single instance of ReportRequestApiPage
	 */
	public static synchronized OpenAPIPageObject getInstance()
	{
		if (reportRequestApi == null)
		{
			reportRequestApi = new OpenAPIPageObject();
		}
		return reportRequestApi;
	}


	public static Collection<Object> getApiCall(String apiUrl, int responseCode, String authTocken, Object requestObj,Object responseObj) throws Exception
	{
		baseApi = BaseApiClass.getInstance();
		return baseApi.setConnectionParam(BaseTestScript.APPLICATIONURL+"/"+apiUrl, "GET", responseCode,authTocken,requestObj,responseObj,false,BaseTestScript.APICONTENTTYPE,BaseTestScript.APIACCEPTTYPE);
	}

	public static void getPostsAPI() throws Exception
	{
		baseApi = BaseApiClass.getInstance();
		Post post = new Post();
		List<Post> postResponce =  baseApi.setConnectionParam("https://jsonplaceholder.typicode.com/posts", "GET", 200,"",null,post,false,"application/json","application/json");
		for(Post example : postResponce)
		{
			System.out.println(example.getId());
			System.out.println(example.getTitle());
			System.out.println(example.getUserId());
			System.out.println(example.getBody());
		}
	}
	
	public boolean verifyRecords(Collection<Object> objectlist, List<DataTableRow> table)
	{
		int matchingCount=0;
		if(objectlist.size()==0 || table.size()==0)
			return false;
			System.out.println("Expected Records : ");
			for(Object obj : objectlist)
			{
				for(int i=1;i<table.size();i++)
				{
					Users user = (Users)obj;
					if(user.getId()==(Integer.parseInt(table.get(i).getCells().get(0).trim())) && (user.getName().equals(table.get(i).getCells().get(1).trim())) && (user.getEmail().equals(table.get(i).getCells().get(2).trim())) && (user.getPhone().equals(table.get(i).getCells().get(3).trim())))
					{
						System.out.println("===========================================================================================");
						System.out.println("ID : "+table.get(i).getCells().get(0)+" == "+user.getId() +"  --> "+(user.getId()==Integer.parseInt(table.get(i).getCells().get(0))));
						System.out.println("NAME : "+table.get(i).getCells().get(1)+" == "+user.getName()+"  --> "+(user.getName().equals(table.get(i).getCells().get(1).trim())));
						System.out.println("EMAIL : "+table.get(i).getCells().get(2)+" == "+user.getEmail()+"  --> "+(user.getEmail().equals(table.get(i).getCells().get(2).trim())));
						System.out.println("PHONE : "+table.get(i).getCells().get(3)+" == "+user.getPhone()+"  --> "+(user.getPhone().equals(table.get(i).getCells().get(3).trim())));
						matchingCount++;
						if(matchingCount==table.size()-1)
							return true;
						else
							break;
					}
				}
			}
		System.out.println(matchingCount==(table.size()-1));
		return false;
	}
}