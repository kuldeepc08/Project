package com.PeerAdmin.Controller;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page { 
	public static WebDriver driver; 
	protected final String baseUrl ="http://peermvc.peerplatform.org/portal/782#/loginHome"; 
	
	
	protected boolean isElementPresent(By by) {
		
		boolean present = true; 
		try { driver.findElement(by); 
		} 
		catch (NoSuchElementException e) {
			present = false; 
			}
		return present;
		}
}
