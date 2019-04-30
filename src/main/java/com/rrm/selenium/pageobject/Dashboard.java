package com.rrm.selenium.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import com.rrm.utility.selenium.BasePageObject;

public class Dashboard extends BasePageObject{

	public Dashboard()
	{
		waitForParticularElement(By.id("logoImg"), Seconds);
	}
	
	public boolean verifyMenuItems(List<String> menuItems)
	{
		waitForParticularElement(By.id("logoImg"), Seconds);
		final boolean[] isVisible = {};
		menuItems.parallelStream().forEach( menu ->
		{
			if(!isDisplayed(By.xpath("//div[@id='divMainTopNav']//a[normalize-space()='"+menu+"']"))) 
				isVisible[0]=false;
				System.out.println("Menu Item --> "+menu+ " is not visible on page");
				return;
		});
		
		if(isVisible.length==0)
			return true;
		else
			return false;
	}
}
