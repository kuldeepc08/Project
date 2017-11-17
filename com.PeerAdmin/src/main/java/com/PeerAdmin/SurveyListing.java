package com.PeerAdmin;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurveyListing extends Page {

	public SurveyListing(WebDriver driver)
	{
		this.driver=driver;
	}
	public void inFrame() throws InterruptedException
	{
	
		//driver.switchTo().defaultContent();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		WebElement frame = driver.findElement(By.id("surveysIframe"));
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
		/*Actions action = new Actions(driver);
		action.contextClick();
		action.contextClick(frame);*/
	
		
	/*	WebDriver wait = new WebDriverWait(driver, 30)
	.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".surveyIFrame>#surveysIframe")));*/
		System.out.println("in the Frame?");
	}
	public void moveDown() throws InterruptedException
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		 
		WebElement element = driver.findElement(By.xpath("//p[contains(text(),'PoojaU')]"));
		// now execute query which actually will scroll until that element is not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		 
	}
	public void surveyListing() throws InterruptedException
	{
	/*	System.out.println("moving down?");
		
		WebElement fr = driver.findElement(By.id("surveysIframe"));
		driver.switchTo().frame(fr);
		Thread.sleep(5000);*/
		System.out.println("moved?");
		inFrame();
		moveDown();
		Thread.sleep(5000);
		
		
		//WebElement ele = driver.findElement(By.xpath("//div/div[2]/div[2]/div"));
		WebElement element1= driver.findElement(By.cssSelector("a.btn.start-btn"));
		element1.click();
			System.out.println("Clicked");
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
		}
		
	}

