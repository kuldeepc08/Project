package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoPanelQuestion {
	WebDriver driver;

	public InfoPanelQuestion(WebDriver driver)
	{
		this.driver=driver;
	}
	public void moveUp() throws InterruptedException
	{
		//driver.window.scrollTo(0, 0);
	JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
	     frames();
		WebElement element = driver.findElement(By.cssSelector(".heading-top>p"));
		// now execute query which actually will scroll until that element is not appeared on page.
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		// Thread.sleep(5000);
	}
	
	public void frames()
	{
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		WebElement frame = driver.findElement(By.id("surveysIframe"));
		WebDriverWait wait = new WebDriverWait(driver, 150);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
		System.out.println("in the Frame?");
	}
	
	public WebElement mainPanel()
	{
		WebElement panel = driver.findElement
				(By.xpath("//app-display-info-panel/div[1]/div"));
		return panel;
	}
	
	
	public void imageSize() throws InterruptedException
	{
		//driver.navigate().refresh();
		Thread.sleep(5000);
		moveUp();
		frames();
		checkimageisPresent();
		driver.switchTo().defaultContent();
	}
	public void moveDown()
	{
		frames();
		System.out.println("Moving Down");
		WebElement element = driver.findElement(By.xpath("//div[4]/span/a/span/label"));
		((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
		driver.switchTo().defaultContent();
	}
	public void checkimageisPresent()
	{
		
		try{
		if(mainPanel().findElements( By.cssSelector(".img-responsive") ).size() != 0)
		{
			String width = driver.findElement(By.cssSelector(".img-responsive")).getCssValue("width");
			System.out.println("image width = " +width);
			String height = driver.findElement(By.cssSelector(".img-responsive")).getCssValue("height");
			System.out.println("image width = " +height);
		}
		}
		catch(Exception e){
			
			System.out.println("img is not present" +e);
			//clickOnLearnMoreLink();
		}
		
	}
	public void infoQuestionHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Information Header is  - " +header.getText());
		
		/*WebElement content = mainPanel().findElement
				(By.xpath("//app-display-info-panel/div/div/p/p/span"));
		System.out.println("Content below info is  - " +content.getText());*/
		
		driver.switchTo().defaultContent();
	}
	public void clickOnLearnMoreLink()
	{
		frames();
		try{
		mainPanel().findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.switchTo().defaultContent();
		
	}
	public void clickOnContinueButton()
	{
		frames();
		/*String style = driver.findElement(By.cssSelector("a[class='btn.panel-theme-button.btn-lg ng-tns-c4-1'] [ng-reflect-ng-style='[object Object]')")).getAttribute("style");
		System.out.println("style elements is - " +style);*/
		try{
		mainPanel().findElement
				(By.cssSelector(".btn.panel-theme-button.btn-lg")).click();
		System.out.println("Clicked on Button");
		}
		catch(Exception e)
		{
		System.out.println("Click on the button?");
		}
		driver.switchTo().defaultContent();
	}
	
	public void infoAllFunctions() throws InterruptedException
	{
		/*imageSize();
		checkimageisPresent();*/
		infoQuestionHeader();
		//clickOnLearnMoreLink();
		clickOnContinueButton();
		
	}
}
