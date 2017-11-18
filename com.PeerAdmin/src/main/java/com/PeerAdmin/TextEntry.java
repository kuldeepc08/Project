package com.PeerAdmin;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TextEntry{

	WebDriver driver;
	public TextEntry(WebDriver driver)
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
		WebElement panel = driver.findElement(By.xpath("//app-display-text-entry/div[1]/form/div"));
		return panel;
	}
	public void textEntryHeader()
	{
		frames();
		WebElement header = mainPanel().findElement(By.cssSelector("div.heading-top>p"));
		System.out.println("Text Entry question Title - " +header.getText());
		driver.switchTo().defaultContent();
	}
	public void textBelowQuestion()
	{
		frames();
		WebElement content = mainPanel().findElement
				(By.cssSelector(".ng-tns-c14-6>p"));
		System.out.println("Content below question - " +content.getText());
		driver.switchTo().defaultContent();
	}
	public void sendValueTextBox()
	{
		frames();
		WebElement sendValue=  mainPanel().findElement(By.cssSelector("[type='text']"));
		sendValue.sendKeys("test");
	/*	List<WebElement> responses = mainPanel().findElements(By.xpath("//ng2-dropdown-menu/div[1]"));
		responses.get(0).click();*/
		driver.switchTo().defaultContent();
	}
	public void clickOnLearnMore()
	{
		frames();
		WebElement learn = mainPanel().findElement(By.cssSelector(".learn-more.magtop10>a>span"));
		learn.click();
		driver.switchTo().defaultContent();
	}
	public void learnMoreText()
	{
		frames();
		WebElement text = mainPanel().findElement(By.cssSelector("div.well>p"));
		System.out.println("Learn more for Slider question- \n " +text.getText());
		driver.switchTo().defaultContent();
	}
	public void clickOnContinueButton()
	{
		frames();
		WebElement click = mainPanel().findElement(By.xpath("//label[contains(text(),'Continue')]"));
		click.click();
		driver.switchTo().defaultContent();
	}
	public void allFunctionsTextEntry()
	{
		textEntryHeader();
		//textBelowQuestion();
		sendValueTextBox();
		clickOnLearnMore();
		learnMoreText();
		clickOnContinueButton();	
	}
}
