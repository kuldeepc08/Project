package com.PeerAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleandMultiPulldown{
	
	WebDriver driver;
	public SingleandMultiPulldown(WebDriver driver)
	{
		this.driver=driver;
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
		WebElement panel = driver.findElement(By.xpath("//app-display-single-choice-pulldown/div/div"));
		return panel;
	}
	
	public void singleandMultipleHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector(".heading-top>p"));
		System.out.println("Single and multiple question Header is  - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnPulldown() throws InterruptedException
	{
		frames();
		WebElement element = mainPanel().findElement(By.id("response"));
		Thread.sleep(5000);
		Select select1 = new Select(element);
		select1.selectByVisibleText("one");
		/*List<WebElement> elements = panel.findElements(By.tagName("option"));
		for (WebElement webElement : elements) {
			String value = webElement.getText();
			
			if(value.equalsIgnoreCase(""))
			{
				driver.findElement(By.tagName("option"));
			}
		}*/
		driver.switchTo().defaultContent();
	}
	public void learnMoreSingleAndMultiple()
	{
		frames();
		WebElement learnMore = mainPanel().findElement(By.xpath("//app-display-learnmore/div/a/span"));
		learnMore.click();
		driver.switchTo().defaultContent();
	}
	public void clickOnClearButton() throws InterruptedException
	{
		frames();
		System.out.println("Try to Clear Selected value");
		WebElement element = mainPanel().findElement(By.xpath("//i[contains(text(),'Clear')]"));
		element.click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		clickOnPulldown();
		Thread.sleep(3000);
	}
	public void clickOnContinue()
	{
		frames();
		WebElement button = mainPanel().findElement(By.xpath("//label[contains(text(),'Continue')]"));
		button.click();
		driver.switchTo().defaultContent();
	}

	public void allFunctionsSingleAndMultiple() throws InterruptedException
	{
		singleandMultipleHeader();
		clickOnPulldown();
		learnMoreSingleAndMultiple();
		//clickOnClearButton();
		clickOnContinue();
	}
}
