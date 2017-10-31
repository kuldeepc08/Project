package com.PeerAdmin;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page { 
	public WebDriver driver; 
	protected final String baseUrl = "http://165.227.64.227/portal/772#/loginHome";
	protected boolean isElementPresent(By by) { 
		boolean present = true; 
		try { driver.findElement(by); 
		} 
		catch (NoSuchElementException e) {
			present = false; 
			System.out.println("Why this happining");
			}
		return present;
		}
	public void timeOut()
	{
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.MINUTES);
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
	}
}
