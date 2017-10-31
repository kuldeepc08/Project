package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IntroPanel extends Page {
	
	public IntroPanel(WebDriver driver)
	{
		this.driver = driver;
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
	
	public void imageSize() throws InterruptedException
	{
		//driver.navigate().refresh();
		Thread.sleep(10000);
		frames();
		Thread.sleep(5000);
		checkimageisPresent();
		driver.switchTo().defaultContent();
	}
	public void checkimageisPresent()
	{
		try{
		if(driver.findElements( By.cssSelector(".img-responsive") ).size() != 0)
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
	public void introQuestionHeader()
	{
		frames();
		WebElement panel = driver.findElement(By.cssSelector("div[class='panel-body'][_ngcontent-c10='']"));
		WebElement header = panel.findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Intro Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void introInformationalContent()
	{
		frames();
		WebElement panel = driver.findElement(By.cssSelector("div[class='panel-body'][_ngcontent-c10='']"));
		WebElement content = panel.findElement(By.cssSelector(".ng-tns-c6-3>p"));
		System.out.println("Content below intro is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnLearnMoreLink() throws InterruptedException
	{
		System.out.println("learn more 1");
		Thread.sleep(5000);
		//moveUp();
		WebElement panel = driver.findElement(By.cssSelector(""
				+ "div[class='panel-body'][_ngcontent-c4='']"));
		System.out.println("learn more 2");
		//driver.findElement(By.cssSelector("a[class='themeinfoclass'][onclick='showFooterDiv('question_15443',0,'15443')'] > #caret_question_15443")).click();
		panel.findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		driver.switchTo().defaultContent();
	}
	public void testReadLearnMoreContent()
	{
		frames();
		WebElement panel = driver.findElement(By.cssSelector(""
				+ "div[class='panel-body'][_ngcontent-c4='']"));
		try{
			if(driver.findElements(By.cssSelector(".well>p>p")).size() != 0)
			{
		WebElement element = panel.findElement(By.cssSelector(".well>p>p"));
		System.out.println("Learn More Text for Info Panel - \n" +element.getText());
		driver.switchTo().defaultContent();
			}
		}
		catch(Exception e)
		{
			System.out.println("Learn more link is not present - " +e);
		}
	}
	public void clickOnContinueButton()
	{
		frames();
		/*String style = driver.findElement(By.cssSelector("a[class='btn.panel-theme-button.btn-lg ng-tns-c4-1'] [ng-reflect-ng-style='[object Object]')")).getAttribute("style");
		System.out.println("style elements is - " +style);*/
		WebElement panel = driver.findElement(By.cssSelector(""
				+ "div[class='panel-body'][_ngcontent-c4='']"));
		WebElement button = panel.findElement(By.cssSelector("a.btn.panel-theme-button.btn-lg.ng-tns-c4-1"));
		button.click();
		System.out.println("Click on the button?");
		driver.switchTo().defaultContent();
	}
	
	public void introAllFunctions() throws InterruptedException
	{
		/*imageSize();
		checkimageisPresent();*/
		introQuestionHeader();
		introInformationalContent();
		clickOnLearnMoreLink();
		testReadLearnMoreContent();
		clickOnContinueButton();
		
	}


}
