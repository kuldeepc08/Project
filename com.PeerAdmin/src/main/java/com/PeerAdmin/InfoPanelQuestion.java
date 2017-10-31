package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoPanelQuestion extends Page {

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
				(By.xpath("//app-display-info-panel/div/div"));
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
		driver.switchTo().defaultContent();
	}
	public void informationalContent()
	{
		frames();
		WebElement content = mainPanel().findElement
				(By.xpath("//app-display-info-panel/div/div/p/p/span"));
		System.out.println("Content below info is  - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnLearnMoreLink() throws InterruptedException
	{
		
		moveUp();
		System.out.println("learn more 1");
		Thread.sleep(5000);
		//moveUp()
		//driver.findElement(By.cssSelector("a[class='themeinfoclass'][onclick='showFooterDiv('question_15443',0,'15443')'] > #caret_question_15443")).click();
		mainPanel().findElement(By.xpath("//span[contains(text(),'Learn More')]")).click();
		driver.switchTo().defaultContent();
	}
	public void testReadLearnMoreContent()
	{
		frames();
		try{
			if(driver.findElements(By.xpath("//app-display-info-panel/div/div/div[5]/div/p/p")).size()!= 0)
			{
		WebElement element = mainPanel().findElement(By.xpath("//app-display-info-panel/div/div/div[5]/div/p/p"));
		System.out.println("Learn More Text for Info Panel - \n" +element.getText());
		
		driver.switchTo().defaultContent();
		moveDown();
		Thread.sleep(5000);
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
		WebElement button = mainPanel().findElement(By.cssSelector("a.btn.panel-theme-button"));
		button.click();
		System.out.println("Click on the button?");
		driver.switchTo().defaultContent();
	}
	
	public void infoAllFunctions() throws InterruptedException
	{
		/*imageSize();
		checkimageisPresent();*/
		infoQuestionHeader();
		informationalContent();
		clickOnLearnMoreLink();
		testReadLearnMoreContent();
		clickOnContinueButton();
		
	}
}
